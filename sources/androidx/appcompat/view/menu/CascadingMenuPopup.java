package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

final class CascadingMenuPopup extends C0228c implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B */
    private static final int f835B = C0131R.layout.abc_cascading_menu_item_layout;

    /* renamed from: A */
    boolean f836A;

    /* renamed from: b */
    private final Context f837b;

    /* renamed from: c */
    private final int f838c;

    /* renamed from: d */
    private final int f839d;

    /* renamed from: e */
    private final int f840e;

    /* renamed from: f */
    private final boolean f841f;

    /* renamed from: g */
    final Handler f842g;

    /* renamed from: h */
    private final List<MenuBuilder> f843h = new ArrayList();

    /* renamed from: i */
    final List<C0217d> f844i = new ArrayList();

    /* renamed from: j */
    final ViewTreeObserver.OnGlobalLayoutListener f845j = new C0213a();

    /* renamed from: k */
    private final View.OnAttachStateChangeListener f846k = new C0214b();

    /* renamed from: l */
    private final MenuItemHoverListener f847l = new C0215c();

    /* renamed from: m */
    private int f848m = 0;

    /* renamed from: n */
    private int f849n = 0;

    /* renamed from: o */
    private View f850o;

    /* renamed from: p */
    View f851p;

    /* renamed from: q */
    private int f852q;

    /* renamed from: r */
    private boolean f853r;

    /* renamed from: s */
    private boolean f854s;

    /* renamed from: t */
    private int f855t;

    /* renamed from: u */
    private int f856u;

    /* renamed from: v */
    private boolean f857v;

    /* renamed from: w */
    private boolean f858w;

    /* renamed from: x */
    private MenuPresenter.Callback f859x;

    /* renamed from: y */
    ViewTreeObserver f860y;

    /* renamed from: z */
    private PopupWindow.OnDismissListener f861z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$a */
    class C0213a implements ViewTreeObserver.OnGlobalLayoutListener {
        C0213a() {
        }

        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.f844i.size() > 0 && !CascadingMenuPopup.this.f844i.get(0).f869a.isModal()) {
                View view = CascadingMenuPopup.this.f851p;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (C0217d dVar : CascadingMenuPopup.this.f844i) {
                    dVar.f869a.show();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$b */
    class C0214b implements View.OnAttachStateChangeListener {
        C0214b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.f860y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.f860y = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.f860y.removeGlobalOnLayoutListener(cascadingMenuPopup.f845j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$c */
    class C0215c implements MenuItemHoverListener {

        /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$c$a */
        class C0216a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0217d f865a;

            /* renamed from: b */
            final /* synthetic */ MenuItem f866b;

            /* renamed from: c */
            final /* synthetic */ MenuBuilder f867c;

            C0216a(C0217d dVar, MenuItem menuItem, MenuBuilder menuBuilder) {
                this.f865a = dVar;
                this.f866b = menuItem;
                this.f867c = menuBuilder;
            }

            public void run() {
                C0217d dVar = this.f865a;
                if (dVar != null) {
                    CascadingMenuPopup.this.f836A = true;
                    dVar.f870b.close(false);
                    CascadingMenuPopup.this.f836A = false;
                }
                if (this.f866b.isEnabled() && this.f866b.hasSubMenu()) {
                    this.f867c.performItemAction(this.f866b, 4);
                }
            }
        }

        C0215c() {
        }

        public void onItemHoverEnter(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            C0217d dVar = null;
            CascadingMenuPopup.this.f842g.removeCallbacksAndMessages((Object) null);
            int size = CascadingMenuPopup.this.f844i.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.f844i.get(i).f870b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < CascadingMenuPopup.this.f844i.size()) {
                    dVar = CascadingMenuPopup.this.f844i.get(i2);
                }
                CascadingMenuPopup.this.f842g.postAtTime(new C0216a(dVar, menuItem, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.f842g.removeCallbacksAndMessages(menuBuilder);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$d */
    private static class C0217d {

        /* renamed from: a */
        public final MenuPopupWindow f869a;

        /* renamed from: b */
        public final MenuBuilder f870b;

        /* renamed from: c */
        public final int f871c;

        public C0217d(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i) {
            this.f869a = menuPopupWindow;
            this.f870b = menuBuilder;
            this.f871c = i;
        }

        /* renamed from: a */
        public ListView mo1600a() {
            return this.f869a.getListView();
        }
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, @AttrRes int i, @StyleRes int i2, boolean z) {
        this.f837b = context;
        this.f850o = view;
        this.f839d = i;
        this.f840e = i2;
        this.f841f = z;
        this.f857v = false;
        this.f852q = m646s();
        Resources resources = context.getResources();
        this.f838c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0131R.dimen.abc_config_prefDialogWidth));
        this.f842g = new Handler();
    }

    /* renamed from: o */
    private MenuPopupWindow m642o() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f837b, (AttributeSet) null, this.f839d, this.f840e);
        menuPopupWindow.setHoverListener(this.f847l);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.f850o);
        menuPopupWindow.setDropDownGravity(this.f849n);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    /* renamed from: p */
    private int m643p(@NonNull MenuBuilder menuBuilder) {
        int size = this.f844i.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.f844i.get(i).f870b) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: q */
    private MenuItem m644q(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: r */
    private View m645r(@NonNull C0217d dVar, @NonNull MenuBuilder menuBuilder) {
        int i;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        MenuItem q = m644q(dVar.f870b, menuBuilder);
        if (q == null) {
            return null;
        }
        ListView a = dVar.mo1600a();
        ListAdapter adapter = a.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (q == menuAdapter.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a.getChildCount()) {
            return a.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* renamed from: s */
    private int m646s() {
        return ViewCompat.getLayoutDirection(this.f850o) == 1 ? 0 : 1;
    }

    /* renamed from: t */
    private int m647t(int i) {
        List<C0217d> list = this.f844i;
        ListView a = list.get(list.size() - 1).mo1600a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f851p.getWindowVisibleDisplayFrame(rect);
        if (this.f852q == 1) {
            if (iArr[0] + a.getWidth() + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: u */
    private void m648u(@NonNull MenuBuilder menuBuilder) {
        View view;
        C0217d dVar;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f837b);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f841f, f835B);
        if (!isShowing() && this.f857v) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(C0228c.m706m(menuBuilder));
        }
        int d = C0228c.m705d(menuAdapter, (ViewGroup) null, this.f837b, this.f838c);
        MenuPopupWindow o = m642o();
        o.setAdapter(menuAdapter);
        o.setContentWidth(d);
        o.setDropDownGravity(this.f849n);
        if (this.f844i.size() > 0) {
            List<C0217d> list = this.f844i;
            dVar = list.get(list.size() - 1);
            view = m645r(dVar, menuBuilder);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            o.setTouchModal(false);
            o.setEnterTransition((Object) null);
            int t = m647t(d);
            boolean z = t == 1;
            this.f852q = t;
            if (Build.VERSION.SDK_INT >= 26) {
                o.setAnchorView(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f850o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f849n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f850o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f849n & 5) != 5) {
                if (z) {
                    d = view.getWidth();
                }
                i3 = i - d;
                o.setHorizontalOffset(i3);
                o.setOverlapAnchor(true);
                o.setVerticalOffset(i2);
            } else if (!z) {
                d = view.getWidth();
                i3 = i - d;
                o.setHorizontalOffset(i3);
                o.setOverlapAnchor(true);
                o.setVerticalOffset(i2);
            }
            i3 = i + d;
            o.setHorizontalOffset(i3);
            o.setOverlapAnchor(true);
            o.setVerticalOffset(i2);
        } else {
            if (this.f853r) {
                o.setHorizontalOffset(this.f855t);
            }
            if (this.f854s) {
                o.setVerticalOffset(this.f856u);
            }
            o.setEpicenterBounds(mo1899c());
        }
        this.f844i.add(new C0217d(o, menuBuilder, this.f852q));
        o.show();
        ListView listView = o.getListView();
        listView.setOnKeyListener(this);
        if (dVar == null && this.f858w && menuBuilder.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0131R.layout.abc_popup_menu_header_item_layout, listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, (Object) null, false);
            o.show();
        }
    }

    /* renamed from: a */
    public void mo1577a(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.f837b);
        if (isShowing()) {
            m648u(menuBuilder);
        } else {
            this.f843h.add(menuBuilder);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo1578b() {
        return false;
    }

    public void dismiss() {
        int size = this.f844i.size();
        if (size > 0) {
            C0217d[] dVarArr = (C0217d[]) this.f844i.toArray(new C0217d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0217d dVar = dVarArr[i];
                if (dVar.f869a.isShowing()) {
                    dVar.f869a.dismiss();
                }
            }
        }
    }

    /* renamed from: e */
    public void mo1580e(@NonNull View view) {
        if (this.f850o != view) {
            this.f850o = view;
            this.f849n = GravityCompat.getAbsoluteGravity(this.f848m, ViewCompat.getLayoutDirection(view));
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    /* renamed from: g */
    public void mo1581g(boolean z) {
        this.f857v = z;
    }

    public ListView getListView() {
        if (this.f844i.isEmpty()) {
            return null;
        }
        List<C0217d> list = this.f844i;
        return list.get(list.size() - 1).mo1600a();
    }

    /* renamed from: h */
    public void mo1583h(int i) {
        if (this.f848m != i) {
            this.f848m = i;
            this.f849n = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.f850o));
        }
    }

    /* renamed from: i */
    public void mo1584i(int i) {
        this.f853r = true;
        this.f855t = i;
    }

    public boolean isShowing() {
        return this.f844i.size() > 0 && this.f844i.get(0).f869a.isShowing();
    }

    /* renamed from: j */
    public void mo1586j(PopupWindow.OnDismissListener onDismissListener) {
        this.f861z = onDismissListener;
    }

    /* renamed from: k */
    public void mo1587k(boolean z) {
        this.f858w = z;
    }

    /* renamed from: l */
    public void mo1588l(int i) {
        this.f854s = true;
        this.f856u = i;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int p = m643p(menuBuilder);
        if (p >= 0) {
            int i = p + 1;
            if (i < this.f844i.size()) {
                this.f844i.get(i).f870b.close(false);
            }
            C0217d remove = this.f844i.remove(p);
            remove.f870b.removeMenuPresenter(this);
            if (this.f836A) {
                remove.f869a.setExitTransition((Object) null);
                remove.f869a.setAnimationStyle(0);
            }
            remove.f869a.dismiss();
            int size = this.f844i.size();
            if (size > 0) {
                this.f852q = this.f844i.get(size - 1).f871c;
            } else {
                this.f852q = m646s();
            }
            if (size == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.f859x;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.f860y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f860y.removeGlobalOnLayoutListener(this.f845j);
                    }
                    this.f860y = null;
                }
                this.f851p.removeOnAttachStateChangeListener(this.f846k);
                this.f861z.onDismiss();
            } else if (z) {
                this.f844i.get(0).f870b.close(false);
            }
        }
    }

    public void onDismiss() {
        C0217d dVar;
        int size = this.f844i.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = this.f844i.get(i);
            if (!dVar.f869a.isShowing()) {
                break;
            }
            i++;
        }
        if (dVar != null) {
            dVar.f870b.close(false);
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
        for (C0217d next : this.f844i) {
            if (subMenuBuilder == next.f870b) {
                next.mo1600a().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        mo1577a(subMenuBuilder);
        MenuPresenter.Callback callback = this.f859x;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f859x = callback;
    }

    public void show() {
        if (!isShowing()) {
            for (MenuBuilder u : this.f843h) {
                m648u(u);
            }
            this.f843h.clear();
            View view = this.f850o;
            this.f851p = view;
            if (view != null) {
                boolean z = this.f860y == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f860y = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f845j);
                }
                this.f851p.addOnAttachStateChangeListener(this.f846k);
            }
        }
    }

    public void updateMenuView(boolean z) {
        for (C0217d a : this.f844i) {
            C0228c.m707n(a.mo1600a().getAdapter()).notifyDataSetChanged();
        }
    }
}
