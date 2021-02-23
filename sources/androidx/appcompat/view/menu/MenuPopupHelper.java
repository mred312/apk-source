package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupHelper {

    /* renamed from: a */
    private final Context f979a;

    /* renamed from: b */
    private final MenuBuilder f980b;

    /* renamed from: c */
    private final boolean f981c;

    /* renamed from: d */
    private final int f982d;

    /* renamed from: e */
    private final int f983e;

    /* renamed from: f */
    private View f984f;

    /* renamed from: g */
    private int f985g;

    /* renamed from: h */
    private boolean f986h;

    /* renamed from: i */
    private MenuPresenter.Callback f987i;

    /* renamed from: j */
    private C0228c f988j;

    /* renamed from: k */
    private PopupWindow.OnDismissListener f989k;

    /* renamed from: l */
    private final PopupWindow.OnDismissListener f990l;

    /* renamed from: androidx.appcompat.view.menu.MenuPopupHelper$a */
    class C0225a implements PopupWindow.OnDismissListener {
        C0225a() {
        }

        public void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, (View) null, false, C0131R.attr.popupMenuStyle, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.MenuPresenter, androidx.appcompat.view.menu.c] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.CascadingMenuPopup] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.C0228c m695a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f979a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            r0.getRealSize(r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f979a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.C0131R.dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.CascadingMenuPopup r0 = new androidx.appcompat.view.menu.CascadingMenuPopup
            android.content.Context r2 = r14.f979a
            android.view.View r3 = r14.f984f
            int r4 = r14.f982d
            int r5 = r14.f983e
            boolean r6 = r14.f981c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r8 = r14.f979a
            androidx.appcompat.view.menu.MenuBuilder r9 = r14.f980b
            android.view.View r10 = r14.f984f
            int r11 = r14.f982d
            int r12 = r14.f983e
            boolean r13 = r14.f981c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.MenuBuilder r1 = r14.f980b
            r0.mo1577a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f990l
            r0.mo1586j(r1)
            android.view.View r1 = r14.f984f
            r0.mo1580e(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r14.f987i
            r0.setCallback(r1)
            boolean r1 = r14.f986h
            r0.mo1581g(r1)
            int r1 = r14.f985g
            r0.mo1583h(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuPopupHelper.m695a():androidx.appcompat.view.menu.c");
    }

    /* renamed from: b */
    private void m696b(int i, int i2, boolean z, boolean z2) {
        C0228c popup = getPopup();
        popup.mo1587k(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.f985g, ViewCompat.getLayoutDirection(this.f984f)) & 7) == 5) {
                i -= this.f984f.getWidth();
            }
            popup.mo1584i(i);
            popup.mo1588l(i2);
            int i3 = (int) ((this.f979a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.mo1900f(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.f988j.dismiss();
        }
    }

    public int getGravity() {
        return this.f985g;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    public C0228c getPopup() {
        if (this.f988j == null) {
            this.f988j = m695a();
        }
        return this.f988j;
    }

    public boolean isShowing() {
        C0228c cVar = this.f988j;
        return cVar != null && cVar.isShowing();
    }

    /* access modifiers changed from: protected */
    public void onDismiss() {
        this.f988j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f989k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(@NonNull View view) {
        this.f984f = view;
    }

    public void setForceShowIcon(boolean z) {
        this.f986h = z;
        C0228c cVar = this.f988j;
        if (cVar != null) {
            cVar.mo1581g(z);
        }
    }

    public void setGravity(int i) {
        this.f985g = i;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f989k = onDismissListener;
    }

    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        this.f987i = callback;
        C0228c cVar = this.f988j;
        if (cVar != null) {
            cVar.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f984f == null) {
            return false;
        }
        m696b(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, C0131R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i, @StyleRes int i2) {
        this.f985g = GravityCompat.START;
        this.f990l = new C0225a();
        this.f979a = context;
        this.f980b = menuBuilder;
        this.f984f = view;
        this.f981c = z;
        this.f982d = i;
        this.f983e = i2;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.f984f == null) {
            return false;
        }
        m696b(i, i2, true, true);
        return true;
    }
}
