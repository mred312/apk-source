package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.internal.ads.c7 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1795c7 implements SensorEventListener {

    /* renamed from: a */
    private final SensorManager f7970a;

    /* renamed from: b */
    private final Object f7971b = new Object();

    /* renamed from: c */
    private final Display f7972c;

    /* renamed from: d */
    private final float[] f7973d = new float[9];

    /* renamed from: e */
    private final float[] f7974e = new float[9];
    @GuardedBy("sensorThreadLock")

    /* renamed from: f */
    private float[] f7975f;

    /* renamed from: g */
    private Handler f7976g;

    /* renamed from: h */
    private C1832d7 f7977h;

    C1795c7(Context context) {
        this.f7970a = (SensorManager) context.getSystemService("sensor");
        this.f7972c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    /* renamed from: e */
    private final void m5884e(int i, int i2) {
        float[] fArr = this.f7974e;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo13738a() {
        if (this.f7976g == null) {
            Sensor defaultSensor = this.f7970a.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzaza.zzey("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            zzduw zzduw = new zzduw(handlerThread.getLooper());
            this.f7976g = zzduw;
            if (!this.f7970a.registerListener(this, defaultSensor, 0, zzduw)) {
                zzaza.zzey("SensorManager.registerListener failed.");
                mo13739b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo13739b() {
        if (this.f7976g != null) {
            this.f7970a.unregisterListener(this);
            this.f7976g.post(new C1758b7(this));
            this.f7976g = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo13740c(C1832d7 d7Var) {
        this.f7977h = d7Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo13741d(float[] fArr) {
        synchronized (this.f7971b) {
            float[] fArr2 = this.f7975f;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            return true;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f7971b) {
                if (this.f7975f == null) {
                    this.f7975f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f7973d, fArr);
            int rotation = this.f7972c.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.f7973d, 2, 129, this.f7974e);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.f7973d, 129, 130, this.f7974e);
            } else if (rotation != 3) {
                System.arraycopy(this.f7973d, 0, this.f7974e, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.f7973d, 130, 1, this.f7974e);
            }
            m5884e(1, 3);
            m5884e(2, 6);
            m5884e(5, 7);
            synchronized (this.f7971b) {
                System.arraycopy(this.f7974e, 0, this.f7975f, 0, 9);
            }
            C1832d7 d7Var = this.f7977h;
            if (d7Var != null) {
                d7Var.zzvi();
            }
        }
    }
}
