package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* renamed from: androidx.appcompat.widget.a */
/* compiled from: ActionBarBackgroundDrawable */
class C0316a extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f1612a;

    public C0316a(ActionBarContainer actionBarContainer) {
        this.f1612a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1612a;
        if (actionBarContainer.f1040h) {
            Drawable drawable = actionBarContainer.f1039g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1037e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1612a;
        Drawable drawable3 = actionBarContainer2.f1038f;
        if (drawable3 != null && actionBarContainer2.f1041i) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        ActionBarContainer actionBarContainer = this.f1612a;
        if (actionBarContainer.f1040h) {
            Drawable drawable = actionBarContainer.f1039g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1037e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
