package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends CustomTarget<Z> {

    /* renamed from: e */
    private static final Handler f6442e = new Handler(Looper.getMainLooper(), new C1346a());

    /* renamed from: d */
    private final RequestManager f6443d;

    /* renamed from: com.bumptech.glide.request.target.PreloadTarget$a */
    class C1346a implements Handler.Callback {
        C1346a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).mo10202a();
            return true;
        }
    }

    private PreloadTarget(RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.f6443d = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i, int i2) {
        return new PreloadTarget<>(requestManager, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10202a() {
        this.f6443d.clear((Target<?>) this);
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        f6442e.obtainMessage(1, this).sendToTarget();
    }
}
