package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* renamed from: androidx.appcompat.view.menu.d */
/* compiled from: StandardMenuPopup */
final class C0229d extends C0228c implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {

    /* renamed from: v */
    private static final int f1003v = C0131R.layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    private final Context f1004b;

    /* renamed from: c */
    private final MenuBuilder f1005c;

    /* renamed from: d */
    private final MenuAdapter f1006d;

    /* renamed from: e */
    private final boolean f1007e;

    /* renamed from: f */
    private final int f1008f;

    /* renamed from: g */
    private final int f1009g;

    /* renamed from: h */
    private final int f1010h;

    /* renamed from: i */
    final MenuPopupWindow f1011i;

    /* renamed from: j */
    final ViewTreeObserver.OnGlobalLayoutListener f1012j = new C0230a();

    /* renamed from: k */
    private final View.OnAttachStateChangeListener f1013k = new C0231b();

    /* renamed from: l */
    private PopupWindow.OnDismissListener f1014l;

    /* renamed from: m */
    private View f1015m;

    /* renamed from: n */
    View f1016n;

    /* renamed from: o */
    private MenuPresenter.Callback f1017o;

    /* renamed from: p */
    ViewTreeObserver f1018p;

    /* renamed from: q */
    private boolean f1019q;

    /* renamed from: r */
    private boolean f1020r;

    /* renamed from: s */
    private int f1021s;

    /* renamed from: t */
    private int f1022t = 0;

    /* renamed from: u */
    private boolean f1023u;

    /* renamed from: androidx.appcompat.view.menu.d$a */
    /* compiled from: StandardMenuPopup */
    class C0230a implements ViewTreeObserver.OnGlobalLayoutListener {
        C0230a() {
        }

        public void onGlobalLayout() {
            if (C0229d.this.isShowing() && !C0229d.this.f1011i.isModal()) {
                View view = C0229d.this.f1016n;
                if (view == null || !view.isShown()) {
                    C0229d.this.dismiss();
                } else {
                    C0229d.this.f1011i.show();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$b */
    /* compiled from: StandardMenuPopup */
    class C0231b implements View.OnAttachStateChangeListener {
        C0231b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = C0229d.this.f1018p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    C0229d.this.f1018p = view.getViewTreeObserver();
                }
                C0229d dVar = C0229d.this;
                dVar.f1018p.removeGlobalOnLayoutListener(dVar.f1012j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public C0229d(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f1004b = context;
        this.f1005c = menuBuilder;
        this.f1007e = z;
        this.f1006d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, f1003v);
        this.f1009g = i;
        this.f1010h = i2;
        Resources resources = context.getResources();
        this.f1008f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0131R.dimen.abc_config_prefDialogWidth));
        this.f1015m = view;
        this.f1011i = new MenuPopupWindow(context, (AttributeSet) null, i, i2);
        menuBuilder.addMenuPresenter(this, context);
    }

    /* renamed from: o */
    private boolean m719o() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.f1019q || (view = this.f1015m) == null) {
            return false;
        }
        this.f1016n = view;
        this.f1011i.setOnDismissListener(this);
        this.f1011i.setOnItemClickListener(this);
        this.f1011i.setModal(true);
        View view2 = this.f1016n;
        boolean z = this.f1018p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1018p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1012j);
        }
        view2.addOnAttachStateChangeListener(this.f1013k);
        this.f1011i.setAnchorView(view2);
        this.f1011i.setDropDownGravity(this.f1022t);
        if (!this.f1020r) {
            this.f1021s = C0228c.m705d(this.f1006d, (ViewGroup) null, this.f1004b, this.f1008f);
            this.f1020r = true;
        }
        this.f1011i.setContentWidth(this.f1021s);
        this.f1011i.setInputMethodMode(2);
        this.f1011i.setEpicenterBounds(mo1899c());
        this.f1011i.show();
        ListView listView = this.f1011i.getListView();
        listView.setOnKeyListener(this);
        if (this.f1023u && this.f1005c.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1004b).inflate(C0131R.layout.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1005c.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f1011i.setAdapter(this.f1006d);
        this.f1011i.show();
        return true;
    }

    /* renamed from: a */
    public void mo1577a(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.f1011i.dismiss();
        }
    }

    /* renamed from: e */
    public void mo1580e(View view) {
        this.f1015m = view;
    }

    public boolean flagActionItems() {
        return false;
    }

    /* renamed from: g */
    public void mo1581g(boolean z) {
        this.f1006d.setForceShowIcon(z);
    }

    public ListView getListView() {
        return this.f1011i.getListView();
    }

    /* renamed from: h */
    public void mo1583h(int i) {
        this.f1022t = i;
    }

    /* renamed from: i */
    public void mo1584i(int i) {
        this.f1011i.setHorizontalOffset(i);
    }

    public boolean isShowing() {
        return !this.f1019q && this.f1011i.isShowing();
    }

    /* renamed from: j */
    public void mo1586j(PopupWindow.OnDismissListener onDismissListener) {
        this.f1014l = onDismissListener;
    }

    /* renamed from: k */
    public void mo1587k(boolean z) {
        this.f1023u = z;
    }

    /* renamed from: l */
    public void mo1588l(int i) {
        this.f1011i.setVerticalOffset(i);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f1005c) {
            dismiss();
            MenuPresenter.Callback callback = this.f1017o;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.f1019q = true;
        this.f1005c.close();
        ViewTreeObserver viewTreeObserver = this.f1018p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1018p = this.f1016n.getViewTreeObserver();
            }
            this.f1018p.removeGlobalOnLayoutListener(this.f1012j);
            this.f1018p = null;
        }
        this.f1016n.removeOnAttachStateChangeListener(this.f1013k);
        PopupWindow.OnDismissListener onDismissListener = this.f1014l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f1004b, subMenuBuilder, this.f1016n, this.f1007e, this.f1009g, this.f1010h);
            menuPopupHelper.setPresenterCallback(this.f1017o);
            menuPopupHelper.setForceShowIcon(C0228c.m706m(subMenuBuilder));
            menuPopupHelper.setOnDismissListener(this.f1014l);
            this.f1014l = null;
            this.f1005c.close(false);
            int horizontalOffset = this.f1011i.getHorizontalOffset();
            int verticalOffset = this.f1011i.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.f1022t, ViewCompat.getLayoutDirection(this.f1015m)) & 7) == 5) {
                horizontalOffset += this.f1015m.getWidth();
            }
            if (menuPopupHelper.tryShow(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.f1017o;
                if (callback == null) {
                    return true;
                }
                callback.onOpenSubMenu(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f1017o = callback;
    }

    public void show() {
        if (!m719o()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z) {
        this.f1020r = false;
        MenuAdapter menuAdapter = this.f1006d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
