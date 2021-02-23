package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

public final class EdgeEffectCompat {

    /* renamed from: a */
    private EdgeEffect f2776a;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f2776a = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.f2776a.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.f2776a.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.f2776a.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.f2776a.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.f2776a.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.f2776a.onRelease();
        return this.f2776a.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.f2776a.setSize(i, i2);
    }

    @Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.f2776a, f, f2);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }
}
