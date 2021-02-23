package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {

    /* renamed from: a */
    private final Context f1528a;

    /* renamed from: b */
    private final TypedArray f1529b;

    /* renamed from: c */
    private TypedValue f1530c;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f1528a = context;
        this.f1529b = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i, boolean z) {
        return this.f1529b.getBoolean(i, z);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return this.f1529b.getChangingConfigurations();
    }

    public int getColor(int i, int i2) {
        return this.f1529b.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        if (!this.f1529b.hasValue(i) || (resourceId = this.f1529b.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.f1528a, resourceId)) == null) {
            return this.f1529b.getColorStateList(i);
        }
        return colorStateList;
    }

    public float getDimension(int i, float f) {
        return this.f1529b.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.f1529b.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.f1529b.getDimensionPixelSize(i, i2);
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        if (!this.f1529b.hasValue(i) || (resourceId = this.f1529b.getResourceId(i, 0)) == 0) {
            return this.f1529b.getDrawable(i);
        }
        return AppCompatResources.getDrawable(this.f1528a, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.f1529b.hasValue(i) || (resourceId = this.f1529b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().mo2203b(this.f1528a, resourceId, true);
    }

    public float getFloat(int i, float f) {
        return this.f1529b.getFloat(i, f);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i, int i2, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f1529b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1530c == null) {
            this.f1530c = new TypedValue();
        }
        return ResourcesCompat.getFont(this.f1528a, resourceId, this.f1530c, i2, fontCallback);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.f1529b.getFraction(i, i2, i3, f);
    }

    public int getIndex(int i) {
        return this.f1529b.getIndex(i);
    }

    public int getIndexCount() {
        return this.f1529b.getIndexCount();
    }

    public int getInt(int i, int i2) {
        return this.f1529b.getInt(i, i2);
    }

    public int getInteger(int i, int i2) {
        return this.f1529b.getInteger(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.f1529b.getLayoutDimension(i, str);
    }

    public String getNonResourceString(int i) {
        return this.f1529b.getNonResourceString(i);
    }

    public String getPositionDescription() {
        return this.f1529b.getPositionDescription();
    }

    public int getResourceId(int i, int i2) {
        return this.f1529b.getResourceId(i, i2);
    }

    public Resources getResources() {
        return this.f1529b.getResources();
    }

    public String getString(int i) {
        return this.f1529b.getString(i);
    }

    public CharSequence getText(int i) {
        return this.f1529b.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f1529b.getTextArray(i);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1529b.getType(i);
        }
        if (this.f1530c == null) {
            this.f1530c = new TypedValue();
        }
        this.f1529b.getValue(i, this.f1530c);
        return this.f1530c.type;
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.f1529b.getValue(i, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.f1529b;
    }

    public boolean hasValue(int i) {
        return this.f1529b.hasValue(i);
    }

    public int length() {
        return this.f1529b.length();
    }

    public TypedValue peekValue(int i) {
        return this.f1529b.peekValue(i);
    }

    public void recycle() {
        this.f1529b.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int getLayoutDimension(int i, int i2) {
        return this.f1529b.getLayoutDimension(i, i2);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }
}
