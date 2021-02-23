package com.medio.timer;

import android.content.Context;
import android.os.Handler;

public abstract class MyTimer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f20942a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f20943b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f20944c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f20945d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f20946e;

    /* renamed from: f */
    private Runnable f20947f = new C3791a();

    /* renamed from: com.medio.timer.MyTimer$a */
    class C3791a implements Runnable {
        C3791a() {
        }

        public void run() {
            if (MyTimer.m14055c(MyTimer.this) >= MyTimer.this.f20943b / MyTimer.this.f20944c) {
                int unused = MyTimer.this.f20942a = 0;
                if (MyTimer.this.f20946e) {
                    MyTimer.this.onFinish();
                }
            } else if (MyTimer.this.f20946e) {
                MyTimer myTimer = MyTimer.this;
                myTimer.onTick(myTimer.f20942a * MyTimer.this.f20944c);
            }
            if (MyTimer.this.f20946e) {
                MyTimer.this.f20945d.postDelayed(this, (long) MyTimer.this.f20944c);
            }
        }
    }

    public MyTimer(Context context, int i, int i2) {
        this.f20943b = i;
        this.f20944c = i2;
        this.f20942a = 0;
        this.f20946e = false;
        this.f20945d = new Handler();
    }

    /* renamed from: c */
    static /* synthetic */ int m14055c(MyTimer myTimer) {
        int i = myTimer.f20942a + 1;
        myTimer.f20942a = i;
        return i;
    }

    public void onFinish() {
    }

    public void onTick(int i) {
    }

    public void resetCounter() {
        this.f20942a = 0;
    }

    public void start() {
        this.f20942a = 0;
        this.f20946e = true;
        this.f20945d.postDelayed(this.f20947f, (long) this.f20944c);
    }

    public void stop() {
        this.f20946e = false;
        this.f20945d.removeCallbacks(this.f20947f);
    }
}
