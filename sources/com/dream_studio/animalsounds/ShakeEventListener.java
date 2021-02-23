package com.dream_studio.animalsounds;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class ShakeEventListener implements SensorEventListener {

    /* renamed from: a */
    private long f6816a = 0;

    /* renamed from: b */
    private long f6817b;

    /* renamed from: c */
    private int f6818c = 0;

    /* renamed from: d */
    private float f6819d = 0.0f;

    /* renamed from: e */
    private float f6820e = 0.0f;

    /* renamed from: f */
    private float f6821f = 0.0f;

    /* renamed from: g */
    private OnShakeListener f6822g;

    public interface OnShakeListener {
        void onShake();
    }

    /* renamed from: a */
    private void m4914a() {
        this.f6816a = 0;
        this.f6818c = 0;
        this.f6817b = 0;
        this.f6819d = 0.0f;
        this.f6820e = 0.0f;
        this.f6821f = 0.0f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (Math.abs(((((f + f2) + f3) - this.f6819d) - this.f6820e) - this.f6821f) > 10.0f) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f6816a == 0) {
                this.f6816a = currentTimeMillis;
                this.f6817b = currentTimeMillis;
            }
            if (currentTimeMillis - this.f6817b < 200) {
                this.f6817b = currentTimeMillis;
                int i = this.f6818c + 1;
                this.f6818c = i;
                this.f6819d = f;
                this.f6820e = f2;
                this.f6821f = f3;
                if (i >= 3 && currentTimeMillis - this.f6816a < 400) {
                    this.f6822g.onShake();
                    m4914a();
                    return;
                }
                return;
            }
            m4914a();
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.f6822g = onShakeListener;
    }
}
