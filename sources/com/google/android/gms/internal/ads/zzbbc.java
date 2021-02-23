package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbbc extends Thread implements SurfaceTexture.OnFrameAvailableListener, C1832d7 {

    /* renamed from: B */
    private static final float[] f13028B = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: A */
    private volatile boolean f13029A;

    /* renamed from: a */
    private final C1795c7 f13030a;

    /* renamed from: b */
    private final float[] f13031b = new float[9];

    /* renamed from: c */
    private final float[] f13032c = new float[9];

    /* renamed from: d */
    private final float[] f13033d = new float[9];

    /* renamed from: e */
    private final float[] f13034e = new float[9];

    /* renamed from: f */
    private final float[] f13035f = new float[9];

    /* renamed from: g */
    private final float[] f13036g = new float[9];

    /* renamed from: h */
    private final float[] f13037h = new float[9];

    /* renamed from: i */
    private float f13038i = Float.NaN;

    /* renamed from: j */
    private float f13039j;

    /* renamed from: k */
    private float f13040k;

    /* renamed from: l */
    private int f13041l;

    /* renamed from: m */
    private int f13042m;

    /* renamed from: n */
    private SurfaceTexture f13043n;

    /* renamed from: o */
    private SurfaceTexture f13044o;

    /* renamed from: p */
    private int f13045p;

    /* renamed from: q */
    private int f13046q;

    /* renamed from: r */
    private int f13047r;

    /* renamed from: s */
    private FloatBuffer f13048s;

    /* renamed from: t */
    private final CountDownLatch f13049t;

    /* renamed from: u */
    private final Object f13050u;

    /* renamed from: v */
    private EGL10 f13051v;

    /* renamed from: w */
    private EGLDisplay f13052w;

    /* renamed from: x */
    private EGLContext f13053x;

    /* renamed from: y */
    private EGLSurface f13054y;

    /* renamed from: z */
    private volatile boolean f13055z;

    public zzbbc(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = f13028B;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f13048s = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        C1795c7 c7Var = new C1795c7(context);
        this.f13030a = c7Var;
        c7Var.mo13740c(this);
        this.f13049t = new CountDownLatch(1);
        this.f13050u = new Object();
    }

    /* renamed from: a */
    private static void m7657a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    /* renamed from: b */
    private static void m7658b(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    @VisibleForTesting
    /* renamed from: c */
    private final boolean m7659c() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.f13054y;
        boolean z = false;
        if (!(eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE))) {
            z = this.f13051v.eglDestroySurface(this.f13052w, this.f13054y) | this.f13051v.eglMakeCurrent(this.f13052w, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.f13054y = null;
        }
        EGLContext eGLContext = this.f13053x;
        if (eGLContext != null) {
            z |= this.f13051v.eglDestroyContext(this.f13052w, eGLContext);
            this.f13053x = null;
        }
        EGLDisplay eGLDisplay = this.f13052w;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.f13051v.eglTerminate(eGLDisplay);
        this.f13052w = null;
        return eglTerminate;
    }

    /* renamed from: d */
    private static void m7660d(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    /* renamed from: e */
    private static int m7661e(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m7662f("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        m7662f("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        m7662f("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        m7662f("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        m7662f("deleteShader");
        return 0;
    }

    /* renamed from: f */
    private static void m7662f(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f13047r++;
        synchronized (this.f13050u) {
            this.f13050u.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01cf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            android.graphics.SurfaceTexture r0 = r14.f13044o
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.internal.ads.zzaza.zzey(r0)
            java.util.concurrent.CountDownLatch r0 = r14.f13049t
            r0.countDown()
            return
        L_0x000f:
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r14.f13051v = r0
            java.lang.Object r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r1)
            r14.f13052w = r0
            javax.microedition.khronos.egl.EGLDisplay r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r0 != r1) goto L_0x002b
        L_0x0028:
            r0 = 0
            goto L_0x0092
        L_0x002b:
            int[] r1 = new int[r3]
            javax.microedition.khronos.egl.EGL10 r7 = r14.f13051v
            boolean r0 = r7.eglInitialize(r0, r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0028
        L_0x0036:
            int[] r0 = new int[r5]
            javax.microedition.khronos.egl.EGLConfig[] r1 = new javax.microedition.khronos.egl.EGLConfig[r5]
            r7 = 11
            int[] r9 = new int[r7]
            r9 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.f13051v
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.f13052w
            r11 = 1
            r10 = r1
            r12 = r0
            boolean r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x0055
            r0 = r0[r6]
            if (r0 <= 0) goto L_0x0055
            r0 = r1[r6]
            goto L_0x0056
        L_0x0055:
            r0 = r4
        L_0x0056:
            if (r0 != 0) goto L_0x0059
            goto L_0x0028
        L_0x0059:
            int[] r1 = new int[r2]
            r1 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.f13051v
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.f13052w
            javax.microedition.khronos.egl.EGLContext r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r7.eglCreateContext(r8, r0, r9, r1)
            r14.f13053x = r1
            if (r1 == 0) goto L_0x0028
            javax.microedition.khronos.egl.EGLContext r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r1 != r7) goto L_0x0071
            goto L_0x0028
        L_0x0071:
            javax.microedition.khronos.egl.EGL10 r1 = r14.f13051v
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.f13052w
            android.graphics.SurfaceTexture r8 = r14.f13044o
            javax.microedition.khronos.egl.EGLSurface r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4)
            r14.f13054y = r0
            if (r0 == 0) goto L_0x0028
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x0084
            goto L_0x0028
        L_0x0084:
            javax.microedition.khronos.egl.EGL10 r1 = r14.f13051v
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.f13052w
            javax.microedition.khronos.egl.EGLContext r8 = r14.f13053x
            boolean r0 = r1.eglMakeCurrent(r7, r0, r0, r8)
            if (r0 != 0) goto L_0x0091
            goto L_0x0028
        L_0x0091:
            r0 = 1
        L_0x0092:
            r1 = 35633(0x8b31, float:4.9932E-41)
            com.google.android.gms.internal.ads.zzaaq<java.lang.String> r7 = com.google.android.gms.internal.ads.zzabf.zzcpr
            com.google.android.gms.internal.ads.zzabb r8 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r8 = r8.zzd(r7)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r7.zzrk()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzabb r8 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r7 = r8.zzd(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r7 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00b8:
            int r1 = m7661e(r1, r7)
            if (r1 != 0) goto L_0x00c1
        L_0x00be:
            r8 = 0
            goto L_0x0143
        L_0x00c1:
            r7 = 35632(0x8b30, float:4.9931E-41)
            com.google.android.gms.internal.ads.zzaaq<java.lang.String> r8 = com.google.android.gms.internal.ads.zzabf.zzcps
            com.google.android.gms.internal.ads.zzabb r9 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r9 = r9.zzd(r8)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.zzrk()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzabb r9 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r8 = r9.zzd(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00e7
        L_0x00e5:
            java.lang.String r8 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00e7:
            int r7 = m7661e(r7, r8)
            if (r7 != 0) goto L_0x00ee
            goto L_0x00be
        L_0x00ee:
            int r8 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r9 = "createProgram"
            m7662f(r9)
            if (r8 == 0) goto L_0x0143
            android.opengl.GLES20.glAttachShader(r8, r1)
            java.lang.String r1 = "attachShader"
            m7662f(r1)
            android.opengl.GLES20.glAttachShader(r8, r7)
            java.lang.String r1 = "attachShader"
            m7662f(r1)
            android.opengl.GLES20.glLinkProgram(r8)
            java.lang.String r1 = "linkProgram"
            m7662f(r1)
            int[] r1 = new int[r5]
            r7 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r8, r7, r1, r6)
            java.lang.String r7 = "getProgramiv"
            m7662f(r7)
            r1 = r1[r6]
            if (r1 == r5) goto L_0x013b
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = "Could not link program: "
            android.util.Log.e(r1, r7)
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = android.opengl.GLES20.glGetProgramInfoLog(r8)
            android.util.Log.e(r1, r7)
            android.opengl.GLES20.glDeleteProgram(r8)
            java.lang.String r1 = "deleteProgram"
            m7662f(r1)
            goto L_0x00be
        L_0x013b:
            android.opengl.GLES20.glValidateProgram(r8)
            java.lang.String r1 = "validateProgram"
            m7662f(r1)
        L_0x0143:
            r14.f13045p = r8
            android.opengl.GLES20.glUseProgram(r8)
            java.lang.String r1 = "useProgram"
            m7662f(r1)
            int r1 = r14.f13045p
            java.lang.String r7 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7)
            r9 = 3
            r10 = 5126(0x1406, float:7.183E-42)
            r11 = 0
            r12 = 12
            java.nio.FloatBuffer r13 = r14.f13048s
            r8 = r1
            android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13)
            java.lang.String r7 = "vertexAttribPointer"
            m7662f(r7)
            android.opengl.GLES20.glEnableVertexAttribArray(r1)
            java.lang.String r1 = "enableVertexAttribArray"
            m7662f(r1)
            int[] r1 = new int[r5]
            android.opengl.GLES20.glGenTextures(r5, r1, r6)
            java.lang.String r7 = "genTextures"
            m7662f(r7)
            r1 = r1[r6]
            r7 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r7, r1)
            java.lang.String r8 = "bindTextures"
            m7662f(r8)
            r8 = 10240(0x2800, float:1.4349E-41)
            r9 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            m7662f(r8)
            r8 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            m7662f(r8)
            r8 = 10242(0x2802, float:1.4352E-41)
            r9 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            m7662f(r8)
            r8 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r7 = "texParameteri"
            m7662f(r7)
            int r7 = r14.f13045p
            java.lang.String r8 = "uVMat"
            int r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8)
            r14.f13046q = r7
            r8 = 9
            float[] r8 = new float[r8]
            r8 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r7, r5, r6, r8, r6)
            int r7 = r14.f13045p
            if (r7 == 0) goto L_0x01cc
            r7 = 1
            goto L_0x01cd
        L_0x01cc:
            r7 = 0
        L_0x01cd:
            if (r0 == 0) goto L_0x0388
            if (r7 != 0) goto L_0x01d3
            goto L_0x0388
        L_0x01d3:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r1)
            r14.f13043n = r0
            r0.setOnFrameAvailableListener(r14)
            java.util.concurrent.CountDownLatch r0 = r14.f13049t
            r0.countDown()
            com.google.android.gms.internal.ads.c7 r0 = r14.f13030a
            r0.mo13738a()
            r14.f13055z = r5     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
        L_0x01e9:
            boolean r0 = r14.f13029A     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            if (r0 != 0) goto L_0x0333
        L_0x01ed:
            int r0 = r14.f13047r     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            if (r0 <= 0) goto L_0x01fc
            android.graphics.SurfaceTexture r0 = r14.f13043n     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r0 = r14.f13047r     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r0 = r0 - r5
            r14.f13047r = r0     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            goto L_0x01ed
        L_0x01fc:
            com.google.android.gms.internal.ads.c7 r0 = r14.f13030a     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r1 = r14.f13031b     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            boolean r0 = r0.mo13741d(r1)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r1 = 5
            r7 = 4
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            if (r0 == 0) goto L_0x0282
            float r0 = r14.f13038i     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            if (r0 == 0) goto L_0x0277
            float[] r0 = r14.f13031b     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r9 = new float[r2]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r10 = 0
            r9[r6] = r10     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r11 = 1065353216(0x3f800000, float:1.0)
            r9[r5] = r11     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r9[r3] = r10     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r10 = new float[r2]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r11 = r0[r6]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r11 = r11 * r12
            r12 = r0[r5]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = r0[r3]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r10[r6] = r11     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r11 = r0[r2]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r11 = r11 * r12
            r12 = r0[r7]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = r0[r1]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r10[r5] = r11     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r11 = 6
            r11 = r0[r11]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r11 = r11 * r12
            r12 = 7
            r12 = r0[r12]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = 8
            r0 = r0[r12]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r9 = r9[r3]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r0 = r0 * r9
            float r11 = r11 + r0
            r10[r3] = r11     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r0 = r10[r5]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            double r11 = (double) r0     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r0 = r10[r6]     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            double r9 = (double) r0     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            double r9 = java.lang.Math.atan2(r11, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r0 = (float) r9     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r0 = r0 - r8
            float r0 = -r0
            r14.f13038i = r0     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
        L_0x0277:
            float[] r0 = r14.f13036g     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r9 = r14.f13038i     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r10 = r14.f13039j     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r9 = r9 + r10
            m7660d(r0, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            goto L_0x0291
        L_0x0282:
            float[] r0 = r14.f13031b     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r9 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            m7657a(r0, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r0 = r14.f13036g     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r9 = r14.f13039j     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            m7660d(r0, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
        L_0x0291:
            float[] r0 = r14.f13032c     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            m7657a(r0, r8)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r0 = r14.f13033d     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r8 = r14.f13036g     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r9 = r14.f13032c     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            m7658b(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r0 = r14.f13034e     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r8 = r14.f13031b     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r9 = r14.f13033d     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            m7658b(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r0 = r14.f13035f     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r8 = r14.f13040k     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            m7657a(r0, r8)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r0 = r14.f13037h     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r8 = r14.f13035f     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r9 = r14.f13034e     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            m7658b(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r0 = r14.f13046q     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float[] r8 = r14.f13037h     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            android.opengl.GLES20.glDrawArrays(r1, r6, r7)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            java.lang.String r0 = "drawArrays"
            m7662f(r0)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            javax.microedition.khronos.egl.EGL10 r0 = r14.f13051v     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.f13052w     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            javax.microedition.khronos.egl.EGLSurface r7 = r14.f13054y     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r0.eglSwapBuffers(r1, r7)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            boolean r0 = r14.f13055z     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            if (r0 == 0) goto L_0x0319
            int r0 = r14.f13042m     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r1 = r14.f13041l     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            android.opengl.GLES20.glViewport(r6, r6, r0, r1)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            java.lang.String r0 = "viewport"
            m7662f(r0)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r0 = r14.f13045p     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            java.lang.String r1 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r1 = r14.f13045p     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            java.lang.String r7 = "uFOVy"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r7 = r14.f13042m     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r8 = r14.f13041l     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            r9 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r7 <= r8) goto L_0x030c
            android.opengl.GLES20.glUniform1f(r0, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            int r0 = r14.f13041l     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r0 = r0 * r9
            int r7 = r14.f13042m     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r0 = r0 / r7
            android.opengl.GLES20.glUniform1f(r1, r0)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            goto L_0x0317
        L_0x030c:
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r7 = r7 * r9
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            float r7 = r7 / r8
            android.opengl.GLES20.glUniform1f(r0, r7)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
            android.opengl.GLES20.glUniform1f(r1, r9)     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
        L_0x0317:
            r14.f13055z = r6     // Catch:{ IllegalStateException -> 0x0362, all -> 0x0343 }
        L_0x0319:
            java.lang.Object r0 = r14.f13050u     // Catch:{ InterruptedException -> 0x01e9 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x01e9 }
            boolean r1 = r14.f13029A     // Catch:{ all -> 0x0330 }
            if (r1 != 0) goto L_0x032d
            boolean r1 = r14.f13055z     // Catch:{ all -> 0x0330 }
            if (r1 != 0) goto L_0x032d
            int r1 = r14.f13047r     // Catch:{ all -> 0x0330 }
            if (r1 != 0) goto L_0x032d
            java.lang.Object r1 = r14.f13050u     // Catch:{ all -> 0x0330 }
            r1.wait()     // Catch:{ all -> 0x0330 }
        L_0x032d:
            monitor-exit(r0)     // Catch:{ all -> 0x0330 }
            goto L_0x01e9
        L_0x0330:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0330 }
            throw r1     // Catch:{ InterruptedException -> 0x01e9 }
        L_0x0333:
            com.google.android.gms.internal.ads.c7 r0 = r14.f13030a
            r0.mo13739b()
            android.graphics.SurfaceTexture r0 = r14.f13043n
            r0.setOnFrameAvailableListener(r4)
            r14.f13043n = r4
            r14.m7659c()
            return
        L_0x0343:
            r0 = move-exception
            java.lang.String r1 = "SphericalVideoProcessor died."
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)     // Catch:{ all -> 0x0377 }
            com.google.android.gms.internal.ads.zzayg r1 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ all -> 0x0377 }
            java.lang.String r2 = "SphericalVideoProcessor.run.2"
            r1.zza(r0, r2)     // Catch:{ all -> 0x0377 }
            com.google.android.gms.internal.ads.c7 r0 = r14.f13030a
            r0.mo13739b()
            android.graphics.SurfaceTexture r0 = r14.f13043n
            r0.setOnFrameAvailableListener(r4)
            r14.f13043n = r4
            r14.m7659c()
            return
        L_0x0362:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)     // Catch:{ all -> 0x0377 }
            com.google.android.gms.internal.ads.c7 r0 = r14.f13030a
            r0.mo13739b()
            android.graphics.SurfaceTexture r0 = r14.f13043n
            r0.setOnFrameAvailableListener(r4)
            r14.f13043n = r4
            r14.m7659c()
            return
        L_0x0377:
            r0 = move-exception
            com.google.android.gms.internal.ads.c7 r1 = r14.f13030a
            r1.mo13739b()
            android.graphics.SurfaceTexture r1 = r14.f13043n
            r1.setOnFrameAvailableListener(r4)
            r14.f13043n = r4
            r14.m7659c()
            throw r0
        L_0x0388:
            javax.microedition.khronos.egl.EGL10 r0 = r14.f13051v
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r1 = "EGL initialization failed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x03a3
            java.lang.String r0 = r1.concat(r0)
            goto L_0x03a8
        L_0x03a3:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x03a8:
            com.google.android.gms.internal.ads.zzaza.zzey(r0)
            com.google.android.gms.internal.ads.zzayg r1 = com.google.android.gms.ads.internal.zzp.zzku()
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r1.zza(r2, r0)
            r14.m7659c()
            java.util.concurrent.CountDownLatch r0 = r14.f13049t
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbc.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f13042m = i;
        this.f13041l = i2;
        this.f13044o = surfaceTexture;
    }

    public final void zzaad() {
        synchronized (this.f13050u) {
            this.f13029A = true;
            this.f13044o = null;
            this.f13050u.notifyAll();
        }
    }

    public final SurfaceTexture zzaae() {
        if (this.f13044o == null) {
            return null;
        }
        try {
            this.f13049t.await();
        } catch (InterruptedException unused) {
        }
        return this.f13043n;
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.f13042m;
        int i2 = this.f13041l;
        if (i > i2) {
            f4 = (f * 1.7453293f) / ((float) i);
            f3 = f2 * 1.7453293f;
            f5 = (float) i;
        } else {
            f4 = (f * 1.7453293f) / ((float) i2);
            f3 = f2 * 1.7453293f;
            f5 = (float) i2;
        }
        this.f13039j -= f4;
        float f6 = this.f13040k - (f3 / f5);
        this.f13040k = f6;
        if (f6 < -1.5707964f) {
            this.f13040k = -1.5707964f;
        }
        if (this.f13040k > 1.5707964f) {
            this.f13040k = 1.5707964f;
        }
    }

    public final void zzm(int i, int i2) {
        synchronized (this.f13050u) {
            this.f13042m = i;
            this.f13041l = i2;
            this.f13055z = true;
            this.f13050u.notifyAll();
        }
    }

    public final void zzvi() {
        synchronized (this.f13050u) {
            this.f13050u.notifyAll();
        }
    }
}
