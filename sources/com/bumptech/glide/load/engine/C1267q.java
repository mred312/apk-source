package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.bumptech.glide.load.engine.q */
/* compiled from: ResourceRecycler */
class C1267q {

    /* renamed from: a */
    private boolean f5992a;

    /* renamed from: b */
    private final Handler f5993b = new Handler(Looper.getMainLooper(), new C1268a());

    /* renamed from: com.bumptech.glide.load.engine.q$a */
    /* compiled from: ResourceRecycler */
    private static final class C1268a implements Handler.Callback {
        C1268a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    C1267q() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9713a(Resource<?> resource) {
        if (this.f5992a) {
            this.f5993b.obtainMessage(1, resource).sendToTarget();
        } else {
            this.f5992a = true;
            resource.recycle();
            this.f5992a = false;
        }
    }
}
