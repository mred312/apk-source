package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* renamed from: androidx.core.graphics.drawable.a */
/* compiled from: RoundedBitmapDrawable21 */
class C0462a extends RoundedBitmapDrawable {
    protected C0462a(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4207b(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    public void getOutline(@NonNull Outline outline) {
        mo4209e();
        outline.setRoundRect(this.f2352h, getCornerRadius());
    }

    public boolean hasMipMap() {
        Bitmap bitmap = this.f2345a;
        return bitmap != null && bitmap.hasMipMap();
    }

    public void setMipMap(boolean z) {
        Bitmap bitmap = this.f2345a;
        if (bitmap != null) {
            bitmap.setHasMipMap(z);
            invalidateSelf();
        }
    }
}
