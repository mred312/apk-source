package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.C0131R;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

/* renamed from: androidx.appcompat.widget.k */
/* compiled from: DropDownListView */
class C0330k extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* renamed from: a */
    private final Rect f1669a = new Rect();

    /* renamed from: b */
    private int f1670b = 0;

    /* renamed from: c */
    private int f1671c = 0;

    /* renamed from: d */
    private int f1672d = 0;

    /* renamed from: e */
    private int f1673e = 0;

    /* renamed from: f */
    private int f1674f;

    /* renamed from: g */
    private Field f1675g;

    /* renamed from: h */
    private C0331a f1676h;

    /* renamed from: i */
    private boolean f1677i;

    /* renamed from: j */
    private boolean f1678j;

    /* renamed from: k */
    private boolean f1679k;

    /* renamed from: l */
    private ViewPropertyAnimatorCompat f1680l;

    /* renamed from: m */
    private ListViewAutoScrollHelper f1681m;

    /* renamed from: n */
    C0332b f1682n;

    /* renamed from: androidx.appcompat.widget.k$a */
    /* compiled from: DropDownListView */
    private static class C0331a extends DrawableWrapper {

        /* renamed from: b */
        private boolean f1683b = true;

        C0331a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3015a(boolean z) {
            this.f1683b = z;
        }

        public void draw(Canvas canvas) {
            if (this.f1683b) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f1683b) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1683b) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1683b) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1683b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.k$b */
    /* compiled from: DropDownListView */
    private class C0332b implements Runnable {
        C0332b() {
        }

        /* renamed from: a */
        public void mo3016a() {
            C0330k kVar = C0330k.this;
            kVar.f1682n = null;
            kVar.removeCallbacks(this);
        }

        /* renamed from: b */
        public void mo3017b() {
            C0330k.this.post(this);
        }

        public void run() {
            C0330k kVar = C0330k.this;
            kVar.f1682n = null;
            kVar.drawableStateChanged();
        }
    }

    C0330k(@NonNull Context context, boolean z) {
        super(context, (AttributeSet) null, C0131R.attr.dropDownListViewStyle);
        this.f1678j = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1675g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1125a() {
        this.f1679k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1674f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1680l;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.f1680l = null;
        }
    }

    /* renamed from: b */
    private void m1126b(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* renamed from: c */
    private void m1127c(Canvas canvas) {
        Drawable selector;
        if (!this.f1669a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1669a);
            selector.draw(canvas);
        }
    }

    /* renamed from: d */
    private void m1128d(int i, View view) {
        Rect rect = this.f1669a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1670b;
        rect.top -= this.f1671c;
        rect.right += this.f1672d;
        rect.bottom += this.f1673e;
        try {
            boolean z = this.f1675g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1675g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m1129e(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m1128d(i, view);
        if (z2) {
            Rect rect = this.f1669a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    /* renamed from: f */
    private void m1130f(int i, View view, float f, float f2) {
        m1129e(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.setHotspot(selector, f, f2);
        }
    }

    /* renamed from: g */
    private void m1131g(View view, int i, float f, float f2) {
        View childAt;
        this.f1679k = true;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f1674f;
        if (!(i3 == -1 || (childAt = getChildAt(i3 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1674f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (i2 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m1130f(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: h */
    private boolean m1132h() {
        return this.f1679k;
    }

    /* renamed from: i */
    private void m1133i() {
        Drawable selector = getSelector();
        if (selector != null && m1132h() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z) {
        C0331a aVar = this.f1676h;
        if (aVar != null) {
            aVar.mo3015a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m1127c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1682n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m1133i();
        }
    }

    public boolean hasFocus() {
        return this.f1678j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1678j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1678j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1678j && this.f1677i) || super.isInTouchMode();
    }

    public int lookForSelectablePosition(int i, boolean z) {
        int i2;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z) {
                    i2 = Math.max(0, i);
                    while (i2 < count && !adapter.isEnabled(i2)) {
                        i2++;
                    }
                } else {
                    int min = Math.min(i, count - 1);
                    while (i2 >= 0 && !adapter.isEnabled(i2)) {
                        min = i2 - 1;
                    }
                }
                if (i2 < 0 || i2 >= count) {
                    return -1;
                }
                return i2;
            } else if (i < 0 || i >= count) {
                return -1;
            } else {
                return i;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i7 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            if (i11 > 0) {
                i6 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i6);
            view.forceLayout();
            if (i8 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i4) {
                return (i5 < 0 || i8 <= i5 || i10 <= 0 || i7 == i4) ? i4 : i10;
            }
            if (i5 >= 0 && i8 >= i5) {
                i10 = i7;
            }
            i8++;
        }
        return i7;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1682n = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onForwardedEvent(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = 0
            r3 = 1
            goto L_0x0046
        L_0x0011:
            r9 = 0
            r3 = 0
            goto L_0x0046
        L_0x0014:
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = 1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m1131g(r3, r5, r4, r9)
            if (r0 != r2) goto L_0x000e
            r7.m1126b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.m1125a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1681m
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.f1681m = r9
        L_0x005a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1681m
            r9.setEnabled(r2)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1681m
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.f1681m
            if (r8 == 0) goto L_0x006c
            r8.setEnabled(r1)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0330k.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1682n == null) {
            C0332b bVar = new C0332b();
            this.f1682n = bVar;
            bVar.mo3017b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m1133i();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1674f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        C0332b bVar = this.f1682n;
        if (bVar != null) {
            bVar.mo3016a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.f1677i = z;
    }

    public void setSelector(Drawable drawable) {
        C0331a aVar = drawable != null ? new C0331a(drawable) : null;
        this.f1676h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1670b = rect.left;
        this.f1671c = rect.top;
        this.f1672d = rect.right;
        this.f1673e = rect.bottom;
    }
}
