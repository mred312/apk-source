package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class rg0 extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

    /* renamed from: a */
    private final int[] f10795a = new int[1];

    /* renamed from: b */
    private Handler f10796b;

    /* renamed from: c */
    private SurfaceTexture f10797c;

    /* renamed from: d */
    private Error f10798d;

    /* renamed from: e */
    private RuntimeException f10799e;

    /* renamed from: f */
    private zzpw f10800f;

    public rg0() {
        super("dummySurface");
    }

    /* renamed from: a */
    public final void mo14746a() {
        this.f10796b.sendEmptyMessage(3);
    }

    /* renamed from: b */
    public final zzpw mo14747b(boolean z) {
        boolean z2;
        start();
        this.f10796b = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.f10796b.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.f10800f == null && this.f10799e == null && this.f10798d == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.f10799e;
        if (runtimeException == null) {
            Error error = this.f10798d;
            if (error == null) {
                return this.f10800f;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final boolean handleMessage(Message message) {
        Message message2 = message;
        int i = message2.what;
        if (i == 1) {
            try {
                boolean z = message2.arg1 != 0;
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                zzpc.checkState(eglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr = new int[2];
                zzpc.checkState(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                EGLConfig[] eGLConfigArr2 = eGLConfigArr;
                zzpc.checkState(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr2[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr2[0];
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                zzpc.checkState(eglCreateContext != null, "eglCreateContext failed");
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                zzpc.checkState(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                zzpc.checkState(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.f10795a, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f10795a[0]);
                this.f10797c = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.f10800f = new zzpw(this, this.f10797c, z);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e);
                this.f10799e = e;
                synchronized (this) {
                    notify();
                }
            } catch (Error e2) {
                try {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f10798d = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
            return true;
        } else if (i == 2) {
            this.f10797c.updateTexImage();
            return true;
        } else if (i != 3) {
            return true;
        } else {
            try {
                this.f10797c.release();
                this.f10800f = null;
                this.f10797c = null;
                GLES20.glDeleteTextures(1, this.f10795a, 0);
                quit();
            } catch (Throwable th2) {
                try {
                    Log.e("DummySurface", "Failed to release dummy surface", th2);
                } finally {
                    quit();
                }
            }
            return true;
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f10796b.sendEmptyMessage(2);
    }
}
