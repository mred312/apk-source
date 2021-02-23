package com.unity3d.services.p008ar.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.util.SparseArray;
import com.google.ar.core.Anchor;
import com.google.ar.core.Camera;
import com.google.ar.core.Frame;
import com.google.ar.core.Plane;
import com.google.ar.core.Pose;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.core.exceptions.NotYetAvailableException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.p008ar.AREvent;
import com.unity3d.services.p008ar.ARUtils;
import com.unity3d.services.p008ar.view.GLSurfaceView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(19)
/* renamed from: com.unity3d.services.ar.view.ARView */
public class ARView extends GLSurfaceView implements GLSurfaceView.Renderer {
    private static final long FRAME_UPDATE_TIMEOUT = 500;
    private Map<String, Anchor> _anchors = new HashMap();
    private float _arFar = 10000.0f;
    private float _arNear = 0.01f;
    private BackgroundRenderer _backgroundRenderer = new BackgroundRenderer();
    private SparseArray<Plane> _detectedPlanes = new SparseArray<>();
    private DisplayRotationHelper _displayRotationHelper;
    private boolean _drawNextCameraFrame;
    JSONObject _frameInfo = new JSONObject();
    JSONObject _lightEstimate = new JSONObject();
    JSONArray _orientation = new JSONArray();
    float[] _orientationArray = new float[4];
    float[] _planeMatrix = new float[16];
    float[] _planeVertices = new float[12];
    JSONArray _position = new JSONArray();
    JSONArray _projectionMatrix = new JSONArray();
    float[] _projectionMatrixArray = new float[16];
    private Session _session = null;
    private boolean _sessionRunning;
    private boolean _sessionWasRunning;
    private boolean _shouldSendResize = false;
    private boolean _showCameraFrame;
    private long _timeOfLastDrawnCameraFrame;
    JSONArray _viewMatrix = new JSONArray();
    float[] _viewMatrixArray = new float[16];

    public ARView(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT > 11) {
            setPreserveEGLContextOnPause(true);
        }
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
        this._displayRotationHelper = new DisplayRotationHelper(context);
    }

    private static void getPlaneVertices(Plane plane, float[] fArr) {
        fArr[0] = plane.getExtentX() / 2.0f;
        fArr[1] = 0.0f;
        fArr[2] = plane.getExtentZ() / 2.0f;
        fArr[3] = (-plane.getExtentX()) / 2.0f;
        fArr[4] = 0.0f;
        fArr[5] = plane.getExtentZ() / 2.0f;
        fArr[6] = (-plane.getExtentX()) / 2.0f;
        fArr[7] = 0.0f;
        fArr[8] = (-plane.getExtentZ()) / 2.0f;
        fArr[9] = plane.getExtentX() / 2.0f;
        fArr[10] = 0.0f;
        fArr[11] = (-plane.getExtentZ()) / 2.0f;
    }

    private static void matrix4x4ToQuaternion(float[] fArr, float[] fArr2) {
        float f;
        if (fArr[10] < 0.0f) {
            if (fArr[0] > fArr[5]) {
                f = ((fArr[0] + 1.0f) - fArr[5]) - fArr[10];
                fArr2[0] = f;
                fArr2[1] = fArr[1] + fArr[4];
                fArr2[2] = fArr[8] + fArr[2];
                fArr2[3] = fArr[6] - fArr[9];
            } else {
                f = ((1.0f - fArr[0]) + fArr[5]) - fArr[10];
                fArr2[0] = fArr[1] + fArr[4];
                fArr2[1] = f;
                fArr2[2] = fArr[6] + fArr[9];
                fArr2[3] = fArr[8] - fArr[2];
            }
        } else if (fArr[0] < (-fArr[5])) {
            f = ((1.0f - fArr[0]) - fArr[5]) + fArr[10];
            fArr2[0] = fArr[8] + fArr[2];
            fArr2[1] = fArr[6] + fArr[9];
            fArr2[2] = f;
            fArr2[3] = fArr[1] - fArr[4];
        } else {
            f = fArr[0] + 1.0f + fArr[5] + fArr[10];
            fArr2[0] = fArr[6] - fArr[9];
            fArr2[1] = fArr[8] - fArr[2];
            fArr2[2] = fArr[1] - fArr[4];
            fArr2[3] = f;
        }
        double d = (double) fArr2[0];
        double d2 = (double) f;
        Double.isNaN(d);
        fArr2[0] = (float) (d * (0.5d / Math.sqrt(d2)));
        double d3 = (double) fArr2[1];
        Double.isNaN(d3);
        fArr2[1] = (float) (d3 * (0.5d / Math.sqrt(d2)));
        double d4 = (double) fArr2[2];
        Double.isNaN(d4);
        fArr2[2] = (float) (d4 * (0.5d / Math.sqrt(d2)));
        double d5 = (double) fArr2[3];
        Double.isNaN(d5);
        fArr2[3] = (float) (d5 * (0.5d / Math.sqrt(d2)));
    }

    private static void matrix4x4ToTranslation(float[] fArr, float[] fArr2) {
        fArr2[0] = fArr[3];
        fArr2[1] = fArr[7];
        fArr2[2] = fArr[11];
    }

    private void sendToWebView(AREvent aREvent, Object... objArr) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null && currentApp.isWebAppLoaded()) {
            currentApp.sendEvent(WebViewEventCategory.AR, aREvent, objArr);
        }
    }

    private void updatePlanes(Collection<Plane> collection) {
        if (!collection.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (Plane next : collection) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    next.getCenterPose().toMatrix(this._planeMatrix, 0);
                    jSONObject.put("modelMatrix", new JSONArray(this._planeMatrix));
                    jSONObject.put("identifier", Integer.toHexString(next.hashCode()));
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put((double) next.getExtentX());
                    jSONArray4.put((double) next.getExtentZ());
                    jSONObject.put("extent", jSONArray4);
                    getPlaneVertices(next, this._planeVertices);
                    jSONObject.put("vertices", new JSONArray(this._planeVertices));
                    jSONObject.put("alignment", next.getType().ordinal());
                    if (next.getSubsumedBy() == null && this._detectedPlanes.get(next.hashCode()) == null) {
                        this._detectedPlanes.append(next.hashCode(), next);
                        jSONArray.put(jSONObject);
                    } else if (next.getSubsumedBy() != null) {
                        this._detectedPlanes.delete(next.hashCode());
                        jSONArray3.put(next);
                    } else {
                        jSONArray2.put(jSONObject);
                    }
                } catch (JSONException e) {
                    DeviceLog.error("Error updating AR planes: " + e.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                sendToWebView(AREvent.AR_PLANES_ADDED, jSONArray.toString());
            }
            if (jSONArray2.length() > 0) {
                sendToWebView(AREvent.AR_PLANES_UPDATED, jSONArray2.toString());
            }
            if (jSONArray3.length() > 0) {
                sendToWebView(AREvent.AR_PLANES_REMOVED, jSONArray3.toString());
            }
        }
    }

    public void addAnchor(String str, String str2) {
        if (this._session == null) {
            DeviceLog.warning("Session is null. Not adding anchor.");
            return;
        }
        String[] split = str2.split(",");
        if (split.length != 16) {
            DeviceLog.warning("Matrix doesn't have 16 elements. Not adding anchor.");
            return;
        }
        float[] fArr = new float[16];
        int i = 0;
        while (i < 16) {
            try {
                fArr[i] = Float.parseFloat(split[i]);
                i++;
            } catch (NumberFormatException unused) {
                DeviceLog.warning("Cannot parse matrix. Not adding anchor.");
                return;
            }
        }
        float[] fArr2 = new float[4];
        matrix4x4ToQuaternion(fArr, fArr2);
        float[] fArr3 = new float[3];
        matrix4x4ToTranslation(fArr, fArr3);
        this._anchors.put(str, this._session.createAnchor(new Pose(fArr3, fArr2)));
    }

    public float getArFar() {
        return this._arFar;
    }

    public float getArNear() {
        return this._arNear;
    }

    public boolean getShowCameraFrame() {
        return this._showCameraFrame;
    }

    public void onDrawFrame(GL10 gl10) {
        if (this._shouldSendResize) {
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                float width = (float) currentApp.getWebView().getWidth();
                float height = (float) currentApp.getWebView().getHeight();
                if (width > 0.0f && height > 0.0f) {
                    sendToWebView(AREvent.AR_WINDOW_RESIZED, Float.valueOf(width), Float.valueOf(height));
                }
            }
            this._shouldSendResize = false;
        }
        if (this._sessionRunning) {
            this._session.setCameraTextureName(this._backgroundRenderer.getTextureId());
            this._displayRotationHelper.updateSessionIfNeeded(this._session);
            try {
                Frame update = this._session.update();
                Camera camera = update.getCamera();
                long currentTimeMillis = System.currentTimeMillis();
                if (this._timeOfLastDrawnCameraFrame == 0) {
                    this._timeOfLastDrawnCameraFrame = currentTimeMillis;
                }
                this._timeOfLastDrawnCameraFrame = currentTimeMillis;
                camera.getProjectionMatrix(this._projectionMatrixArray, 0, this._arNear, this._arFar);
                camera.getViewMatrix(this._viewMatrixArray, 0);
                float pixelIntensity = update.getLightEstimate().getPixelIntensity();
                Pose displayOrientedPose = camera.getDisplayOrientedPose();
                displayOrientedPose.getRotationQuaternion(this._orientationArray, 0);
                try {
                    this._position.put(0, (double) displayOrientedPose.tx());
                    this._position.put(1, (double) displayOrientedPose.ty());
                    this._position.put(2, (double) displayOrientedPose.tz());
                    this._frameInfo.put("position", this._position);
                    for (int i = 0; i < 4; i++) {
                        this._orientation.put(i, (double) this._orientationArray[i]);
                    }
                    this._frameInfo.put(AdUnitActivity.EXTRA_ORIENTATION, this._orientation);
                    for (int i2 = 0; i2 < 16; i2++) {
                        this._viewMatrix.put(i2, (double) this._viewMatrixArray[i2]);
                    }
                    this._frameInfo.put("viewMatrix", this._viewMatrix);
                    for (int i3 = 0; i3 < 16; i3++) {
                        this._projectionMatrix.put(i3, (double) this._projectionMatrixArray[i3]);
                    }
                    this._frameInfo.put("projectionMatrix", this._projectionMatrix);
                    this._lightEstimate.put("ambientIntensity", (double) pixelIntensity);
                    this._lightEstimate.put(RemoteConfigConstants.ResponseFieldKey.STATE, update.getLightEstimate().getState().toString());
                    this._frameInfo.put("lightEstimate", this._lightEstimate);
                } catch (JSONException unused) {
                }
                sendToWebView(AREvent.AR_FRAME_UPDATED, this._frameInfo.toString());
                updatePlanes(update.getUpdatedTrackables(Plane.class));
                DeviceLog.debug(update.toString());
                if (this._showCameraFrame) {
                    GLES20.glClear(16384);
                    this._backgroundRenderer.draw(update);
                }
            } catch (CameraNotAvailableException e) {
                sendToWebView(AREvent.AR_ERROR, e.getMessage());
            } catch (NotYetAvailableException e2) {
                sendToWebView(AREvent.AR_ERROR, e2.getMessage());
            }
        }
    }

    public void onPause() {
        super.onPause();
        Session session = this._session;
        if (session != null && this._sessionRunning) {
            try {
                this._sessionWasRunning = true;
                this._sessionRunning = false;
                session.pause();
            } catch (Exception e) {
                DeviceLog.error("Error pausing AR session: " + e.getMessage());
            }
        }
        this._displayRotationHelper.onPause();
    }

    public void onResume() {
        super.onResume();
        Session session = this._session;
        if (session != null && this._sessionWasRunning) {
            try {
                session.resume();
                this._sessionRunning = true;
            } catch (Exception e) {
                DeviceLog.error("Error resuming AR session: " + e.getMessage());
            }
        }
        this._displayRotationHelper.onResume();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this._displayRotationHelper.onSurfaceChanged(i, i2);
        sendToWebView(AREvent.AR_WINDOW_RESIZED, Float.valueOf((float) i), Float.valueOf((float) i2));
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        this._backgroundRenderer.createOnGlThread();
        GLES20.glClear(16384);
    }

    public void pauseSession() {
        if (this._sessionRunning) {
            this._session.pause();
        }
    }

    public void removeAnchor(String str) {
        if (this._anchors.containsKey(str)) {
            this._anchors.get(str).detach();
            this._anchors.remove(str);
            return;
        }
        DeviceLog.warning("Anchor with identifier: " + str + " doesn't exist.");
    }

    public void restartSession(JSONObject jSONObject) {
        if (this._session == null) {
            try {
                this._session = new Session(getContext());
                this._shouldSendResize = true;
            } catch (Exception unused) {
                DeviceLog.debug("Error creating ARCore session");
                return;
            }
        }
        this._session.configure(ARUtils.createConfiguration(jSONObject.getJSONObject("configuration"), this._session));
        this._session.resume();
        this._sessionRunning = true;
        this._displayRotationHelper.onResume();
        postDelayed(new Runnable() {
            public void run() {
                ARView.this.requestRender();
            }
        }, 200);
    }

    public void setArFar(float f) {
        this._arFar = f;
    }

    public void setArNear(float f) {
        this._arNear = f;
    }

    public void setDrawNextCameraFrame() {
        requestRender();
    }

    public void setShowCameraFrame(boolean z) {
        this._showCameraFrame = z;
    }
}
