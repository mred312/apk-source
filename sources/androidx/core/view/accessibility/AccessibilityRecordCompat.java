package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import java.util.List;

public class AccessibilityRecordCompat {

    /* renamed from: a */
    private final AccessibilityRecord f2723a;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.f2723a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.f2723a));
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f2723a;
        if (accessibilityRecord == null) {
            if (accessibilityRecordCompat.f2723a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(accessibilityRecordCompat.f2723a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int getAddedCount() {
        return this.f2723a.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.f2723a.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.f2723a.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.f2723a.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.f2723a.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.f2723a.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.f2723a;
    }

    @Deprecated
    public int getItemCount() {
        return this.f2723a.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.f2723a);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.f2723a);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.f2723a.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.f2723a.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.f2723a.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.f2723a.getScrollY();
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.m1899l(this.f2723a.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.f2723a.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.f2723a.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.f2723a.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f2723a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.f2723a.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.f2723a.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.f2723a.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.f2723a.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.f2723a.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.f2723a.recycle();
    }

    @Deprecated
    public void setAddedCount(int i) {
        this.f2723a.setAddedCount(i);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.f2723a.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z) {
        this.f2723a.setChecked(z);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.f2723a.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.f2723a.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i) {
        this.f2723a.setCurrentItemIndex(i);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.f2723a.setEnabled(z);
    }

    @Deprecated
    public void setFromIndex(int i) {
        this.f2723a.setFromIndex(i);
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        this.f2723a.setFullScreen(z);
    }

    @Deprecated
    public void setItemCount(int i) {
        this.f2723a.setItemCount(i);
    }

    @Deprecated
    public void setMaxScrollX(int i) {
        setMaxScrollX(this.f2723a, i);
    }

    @Deprecated
    public void setMaxScrollY(int i) {
        setMaxScrollY(this.f2723a, i);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.f2723a.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z) {
        this.f2723a.setPassword(z);
    }

    @Deprecated
    public void setRemovedCount(int i) {
        this.f2723a.setRemovedCount(i);
    }

    @Deprecated
    public void setScrollX(int i) {
        this.f2723a.setScrollX(i);
    }

    @Deprecated
    public void setScrollY(int i) {
        this.f2723a.setScrollY(i);
    }

    @Deprecated
    public void setScrollable(boolean z) {
        this.f2723a.setScrollable(z);
    }

    @Deprecated
    public void setSource(View view) {
        this.f2723a.setSource(view);
    }

    @Deprecated
    public void setToIndex(int i) {
        this.f2723a.setToIndex(i);
    }

    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollX();
        }
        return 0;
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollY();
        }
        return 0;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public void setSource(View view, int i) {
        setSource(this.f2723a, view, i);
    }

    public static void setSource(@NonNull AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }
}
