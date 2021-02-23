package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: F */
    private static final Interpolator f550F = new AccelerateInterpolator();

    /* renamed from: G */
    private static final Interpolator f551G = new DecelerateInterpolator();

    /* renamed from: A */
    private boolean f552A;

    /* renamed from: B */
    boolean f553B;

    /* renamed from: C */
    final ViewPropertyAnimatorListener f554C = new C0176a();

    /* renamed from: D */
    final ViewPropertyAnimatorListener f555D = new C0177b();

    /* renamed from: E */
    final ViewPropertyAnimatorUpdateListener f556E = new C0178c();

    /* renamed from: a */
    Context f557a;

    /* renamed from: b */
    private Context f558b;

    /* renamed from: c */
    private Activity f559c;

    /* renamed from: d */
    ActionBarOverlayLayout f560d;

    /* renamed from: e */
    ActionBarContainer f561e;

    /* renamed from: f */
    DecorToolbar f562f;

    /* renamed from: g */
    ActionBarContextView f563g;

    /* renamed from: h */
    View f564h;

    /* renamed from: i */
    ScrollingTabContainerView f565i;

    /* renamed from: j */
    private ArrayList<TabImpl> f566j = new ArrayList<>();

    /* renamed from: k */
    private TabImpl f567k;

    /* renamed from: l */
    private int f568l = -1;

    /* renamed from: m */
    private boolean f569m;

    /* renamed from: n */
    ActionModeImpl f570n;

    /* renamed from: o */
    ActionMode f571o;

    /* renamed from: p */
    ActionMode.Callback f572p;

    /* renamed from: q */
    private boolean f573q;

    /* renamed from: r */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f574r = new ArrayList<>();

    /* renamed from: s */
    private boolean f575s;

    /* renamed from: t */
    private int f576t = 0;

    /* renamed from: u */
    boolean f577u = true;

    /* renamed from: v */
    boolean f578v;

    /* renamed from: w */
    boolean f579w;

    /* renamed from: x */
    private boolean f580x;

    /* renamed from: y */
    private boolean f581y = true;

    /* renamed from: z */
    ViewPropertyAnimatorCompatSet f582z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: c */
        private final Context f583c;

        /* renamed from: d */
        private final MenuBuilder f584d;

        /* renamed from: e */
        private ActionMode.Callback f585e;

        /* renamed from: f */
        private WeakReference<View> f586f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f583c = context;
            this.f585e = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f584d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.f584d.stopDispatchingItemsChanged();
            try {
                return this.f585e.onCreateActionMode(this, this.f584d);
            } finally {
                this.f584d.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f570n == this) {
                if (!WindowDecorActionBar.m505b(windowDecorActionBar.f578v, windowDecorActionBar.f579w, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.f571o = this;
                    windowDecorActionBar2.f572p = this.f585e;
                } else {
                    this.f585e.onDestroyActionMode(this);
                }
                this.f585e = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.f563g.closeMode();
                WindowDecorActionBar.this.f562f.getViewGroup().sendAccessibilityEvent(32);
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.f560d.setHideOnContentScrollEnabled(windowDecorActionBar3.f553B);
                WindowDecorActionBar.this.f570n = null;
            }
        }

        public View getCustomView() {
            WeakReference<View> weakReference = this.f586f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.f584d;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.f583c);
        }

        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.f563g.getSubtitle();
        }

        public CharSequence getTitle() {
            return WindowDecorActionBar.this.f563g.getTitle();
        }

        public void invalidate() {
            if (WindowDecorActionBar.this.f570n == this) {
                this.f584d.stopDispatchingItemsChanged();
                try {
                    this.f585e.onPrepareActionMode(this, this.f584d);
                } finally {
                    this.f584d.startDispatchingItemsChanged();
                }
            }
        }

        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.f563g.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.f585e;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            if (this.f585e != null) {
                invalidate();
                WindowDecorActionBar.this.f563g.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.f585e == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void setCustomView(View view) {
            WindowDecorActionBar.this.f563g.setCustomView(view);
            this.f586f = new WeakReference<>(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f563g.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.f563g.setTitle(charSequence);
        }

        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            WindowDecorActionBar.this.f563g.setTitleOptional(z);
        }

        public void setSubtitle(int i) {
            setSubtitle((CharSequence) WindowDecorActionBar.this.f557a.getResources().getString(i));
        }

        public void setTitle(int i) {
            setTitle((CharSequence) WindowDecorActionBar.this.f557a.getResources().getString(i));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: a */
        private ActionBar.TabListener f588a;

        /* renamed from: b */
        private Object f589b;

        /* renamed from: c */
        private Drawable f590c;

        /* renamed from: d */
        private CharSequence f591d;

        /* renamed from: e */
        private CharSequence f592e;

        /* renamed from: f */
        private int f593f = -1;

        /* renamed from: g */
        private View f594g;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.f588a;
        }

        public CharSequence getContentDescription() {
            return this.f592e;
        }

        public View getCustomView() {
            return this.f594g;
        }

        public Drawable getIcon() {
            return this.f590c;
        }

        public int getPosition() {
            return this.f593f;
        }

        public Object getTag() {
            return this.f589b;
        }

        public CharSequence getText() {
            return this.f591d;
        }

        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(WindowDecorActionBar.this.f557a.getResources().getText(i));
        }

        public ActionBar.Tab setCustomView(View view) {
            this.f594g = view;
            int i = this.f593f;
            if (i >= 0) {
                WindowDecorActionBar.this.f565i.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.f590c = drawable;
            int i = this.f593f;
            if (i >= 0) {
                WindowDecorActionBar.this.f565i.updateTab(i);
            }
            return this;
        }

        public void setPosition(int i) {
            this.f593f = i;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.f588a = tabListener;
            return this;
        }

        public ActionBar.Tab setTag(Object obj) {
            this.f589b = obj;
            return this;
        }

        public ActionBar.Tab setText(CharSequence charSequence) {
            this.f591d = charSequence;
            int i = this.f593f;
            if (i >= 0) {
                WindowDecorActionBar.this.f565i.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.f592e = charSequence;
            int i = this.f593f;
            if (i >= 0) {
                WindowDecorActionBar.this.f565i.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.f557a, i));
        }

        public ActionBar.Tab setText(int i) {
            return setText(WindowDecorActionBar.this.f557a.getResources().getText(i));
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$a */
    class C0176a extends ViewPropertyAnimatorListenerAdapter {
        C0176a() {
        }

        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f577u && (view2 = windowDecorActionBar.f564h) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f561e.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f561e.setVisibility(8);
            WindowDecorActionBar.this.f561e.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.f582z = null;
            windowDecorActionBar2.mo1196d();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f560d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$b */
    class C0177b extends ViewPropertyAnimatorListenerAdapter {
        C0177b() {
        }

        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.f582z = null;
            windowDecorActionBar.f561e.requestLayout();
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$c */
    class C0178c implements ViewPropertyAnimatorUpdateListener {
        C0178c() {
        }

        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.f561e.getParent()).invalidate();
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f559c = activity;
        View decorView = activity.getWindow().getDecorView();
        m511i(decorView);
        if (!z) {
            this.f564h = decorView.findViewById(16908290);
        }
    }

    /* renamed from: b */
    static boolean m505b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: c */
    private void m506c() {
        if (this.f567k != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.f566j.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.f565i;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.f568l = -1;
    }

    /* renamed from: e */
    private void m507e(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i);
            this.f566j.add(i, tabImpl);
            int size = this.f566j.size();
            while (true) {
                i++;
                if (i < size) {
                    this.f566j.get(i).setPosition(i);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    /* renamed from: f */
    private void m508f() {
        if (this.f565i == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f557a);
            if (this.f575s) {
                scrollingTabContainerView.setVisibility(0);
                this.f562f.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.f560d;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f561e.setTabContainer(scrollingTabContainerView);
            }
            this.f565i = scrollingTabContainerView;
        }
    }

    /* renamed from: g */
    private DecorToolbar m509g(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: h */
    private void m510h() {
        if (this.f580x) {
            this.f580x = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f560d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m515m(false);
        }
    }

    /* renamed from: i */
    private void m511i(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(C0131R.C0133id.decor_content_parent);
        this.f560d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f562f = m509g(view.findViewById(C0131R.C0133id.action_bar));
        this.f563g = (ActionBarContextView) view.findViewById(C0131R.C0133id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(C0131R.C0133id.action_bar_container);
        this.f561e = actionBarContainer;
        DecorToolbar decorToolbar = this.f562f;
        if (decorToolbar == null || this.f563g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f557a = decorToolbar.getContext();
        boolean z = (this.f562f.getDisplayOptions() & 4) != 0;
        if (z) {
            this.f569m = true;
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.f557a);
        setHomeButtonEnabled(actionBarPolicy.enableHomeButtonByDefault() || z);
        m512j(actionBarPolicy.hasEmbeddedTabs());
        TypedArray obtainStyledAttributes = this.f557a.obtainStyledAttributes((AttributeSet) null, C0131R.styleable.ActionBar, C0131R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0131R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: j */
    private void m512j(boolean z) {
        this.f575s = z;
        if (!z) {
            this.f562f.setEmbeddedTabView((ScrollingTabContainerView) null);
            this.f561e.setTabContainer(this.f565i);
        } else {
            this.f561e.setTabContainer((ScrollingTabContainerView) null);
            this.f562f.setEmbeddedTabView(this.f565i);
        }
        boolean z2 = true;
        boolean z3 = getNavigationMode() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f565i;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f560d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f562f.setCollapsible(!this.f575s && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f560d;
        if (this.f575s || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    /* renamed from: k */
    private boolean m513k() {
        return ViewCompat.isLaidOut(this.f561e);
    }

    /* renamed from: l */
    private void m514l() {
        if (!this.f580x) {
            this.f580x = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f560d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            m515m(false);
        }
    }

    /* renamed from: m */
    private void m515m(boolean z) {
        if (m505b(this.f578v, this.f579w, this.f580x)) {
            if (!this.f581y) {
                this.f581y = true;
                doShow(z);
            }
        } else if (this.f581y) {
            this.f581y = false;
            doHide(z);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f574r.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.f566j.isEmpty());
    }

    public void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z) {
            m514l();
        } else {
            m510h();
        }
        if (m513k()) {
            if (z) {
                viewPropertyAnimatorCompat = this.f562f.setupAnimatorToVisibility(4, 100);
                viewPropertyAnimatorCompat2 = this.f563g.setupAnimatorToVisibility(0, 200);
            } else {
                viewPropertyAnimatorCompat2 = this.f562f.setupAnimatorToVisibility(0, 200);
                viewPropertyAnimatorCompat = this.f563g.setupAnimatorToVisibility(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            this.f562f.setVisibility(4);
            this.f563g.setVisibility(0);
        } else {
            this.f562f.setVisibility(0);
            this.f563g.setVisibility(8);
        }
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.f562f;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.f562f.collapseActionView();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1196d() {
        ActionMode.Callback callback = this.f572p;
        if (callback != null) {
            callback.onDestroyActionMode(this.f571o);
            this.f571o = null;
            this.f572p = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f573q) {
            this.f573q = z;
            int size = this.f574r.size();
            for (int i = 0; i < size; i++) {
                this.f574r.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public void doHide(boolean z) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f582z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.f576t != 0 || (!this.f552A && !z)) {
            this.f554C.onAnimationEnd((View) null);
            return;
        }
        this.f561e.setAlpha(1.0f);
        this.f561e.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f = (float) (-this.f561e.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f561e.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f561e).translationY(f);
        translationY.setUpdateListener(this.f556E);
        viewPropertyAnimatorCompatSet2.play(translationY);
        if (this.f577u && (view = this.f564h) != null) {
            viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f));
        }
        viewPropertyAnimatorCompatSet2.setInterpolator(f550F);
        viewPropertyAnimatorCompatSet2.setDuration(250);
        viewPropertyAnimatorCompatSet2.setListener(this.f554C);
        this.f582z = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.start();
    }

    public void doShow(boolean z) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f582z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.f561e.setVisibility(0);
        if (this.f576t != 0 || (!this.f552A && !z)) {
            this.f561e.setAlpha(1.0f);
            this.f561e.setTranslationY(0.0f);
            if (this.f577u && (view = this.f564h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f555D.onAnimationEnd((View) null);
        } else {
            this.f561e.setTranslationY(0.0f);
            float f = (float) (-this.f561e.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f561e.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.f561e.setTranslationY(f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f561e).translationY(0.0f);
            translationY.setUpdateListener(this.f556E);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.f577u && (view2 = this.f564h) != null) {
                view2.setTranslationY(f);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.f564h).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(f551G);
            viewPropertyAnimatorCompatSet2.setDuration(250);
            viewPropertyAnimatorCompatSet2.setListener(this.f555D);
            this.f582z = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f560d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public void enableContentAnimations(boolean z) {
        this.f577u = z;
    }

    public View getCustomView() {
        return this.f562f.getCustomView();
    }

    public int getDisplayOptions() {
        return this.f562f.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f561e);
    }

    public int getHeight() {
        return this.f561e.getHeight();
    }

    public int getHideOffset() {
        return this.f560d.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int navigationMode = this.f562f.getNavigationMode();
        if (navigationMode == 1) {
            return this.f562f.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.f566j.size();
    }

    public int getNavigationMode() {
        return this.f562f.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.f562f.getNavigationMode();
        if (navigationMode == 1) {
            return this.f562f.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.f567k) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        return this.f567k;
    }

    public CharSequence getSubtitle() {
        return this.f562f.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i) {
        return this.f566j.get(i);
    }

    public int getTabCount() {
        return this.f566j.size();
    }

    public Context getThemedContext() {
        if (this.f558b == null) {
            TypedValue typedValue = new TypedValue();
            this.f557a.getTheme().resolveAttribute(C0131R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f558b = new ContextThemeWrapper(this.f557a, i);
            } else {
                this.f558b = this.f557a;
            }
        }
        return this.f558b;
    }

    public CharSequence getTitle() {
        return this.f562f.getTitle();
    }

    public boolean hasIcon() {
        return this.f562f.hasIcon();
    }

    public boolean hasLogo() {
        return this.f562f.hasLogo();
    }

    public void hide() {
        if (!this.f578v) {
            this.f578v = true;
            m515m(false);
        }
    }

    public void hideForSystem() {
        if (!this.f579w) {
            this.f579w = true;
            m515m(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.f560d.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.f581y && (height == 0 || getHideOffset() < height);
    }

    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.f562f;
        return decorToolbar != null && decorToolbar.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        m512j(ActionBarPolicy.get(this.f557a).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f582z;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.f582z = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu;
        ActionModeImpl actionModeImpl = this.f570n;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int i) {
        this.f576t = i;
    }

    public void removeAllTabs() {
        m506c();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f574r.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.f565i != null) {
            TabImpl tabImpl = this.f567k;
            int position = tabImpl != null ? tabImpl.getPosition() : this.f568l;
            this.f565i.removeTabAt(i);
            TabImpl remove = this.f566j.remove(i);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.f566j.size();
            for (int i2 = i; i2 < size; i2++) {
                this.f566j.get(i2).setPosition(i2);
            }
            if (position == i) {
                selectTab(this.f566j.isEmpty() ? null : this.f566j.get(Math.max(0, i - 1)));
            }
        }
    }

    public boolean requestFocus() {
        ViewGroup viewGroup = this.f562f.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.f568l = i;
            return;
        }
        FragmentTransaction disallowAddToBackStack = (!(this.f559c instanceof FragmentActivity) || this.f562f.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.f559c).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        TabImpl tabImpl = this.f567k;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f565i;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            TabImpl tabImpl2 = this.f567k;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.f567k, disallowAddToBackStack);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.f567k = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.f567k, disallowAddToBackStack);
            }
        } else if (tabImpl != null) {
            tabImpl.getCallback().onTabReselected(this.f567k, disallowAddToBackStack);
            this.f565i.animateToTab(tab.getPosition());
        }
        if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
            disallowAddToBackStack.commit();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f561e.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f562f.getViewGroup(), false));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.f569m) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f569m = true;
        }
        this.f562f.setDisplayOptions(i);
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    public void setElevation(float f) {
        ViewCompat.setElevation(this.f561e, f);
    }

    public void setHideOffset(int i) {
        if (i == 0 || this.f560d.isInOverlayMode()) {
            this.f560d.setActionBarHideOffset(i);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (!z || this.f560d.isInOverlayMode()) {
            this.f553B = z;
            this.f560d.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f562f.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f562f.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.f562f.setHomeButtonEnabled(z);
    }

    public void setIcon(int i) {
        this.f562f.setIcon(i);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f562f.setDropdownParams(spinnerAdapter, new C0181b(onNavigationListener));
    }

    public void setLogo(int i) {
        this.f562f.setLogo(i);
    }

    public void setNavigationMode(int i) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.f562f.getNavigationMode();
        if (navigationMode == 2) {
            this.f568l = getSelectedNavigationIndex();
            selectTab((ActionBar.Tab) null);
            this.f565i.setVisibility(8);
        }
        if (!(navigationMode == i || this.f575s || (actionBarOverlayLayout = this.f560d) == null)) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.f562f.setNavigationMode(i);
        boolean z = false;
        if (i == 2) {
            m508f();
            this.f565i.setVisibility(0);
            int i2 = this.f568l;
            if (i2 != -1) {
                setSelectedNavigationItem(i2);
                this.f568l = -1;
            }
        }
        this.f562f.setCollapsible(i == 2 && !this.f575s);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f560d;
        if (i == 2 && !this.f575s) {
            z = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z);
    }

    public void setSelectedNavigationItem(int i) {
        int navigationMode = this.f562f.getNavigationMode();
        if (navigationMode == 1) {
            this.f562f.setDropdownSelectedPosition(i);
        } else if (navigationMode == 2) {
            selectTab(this.f566j.get(i));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f552A = z;
        if (!z && (viewPropertyAnimatorCompatSet = this.f582z) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.f561e.setStackedBackground(drawable);
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.f557a.getString(i));
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f557a.getString(i));
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f562f.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.f578v) {
            this.f578v = false;
            m515m(false);
        }
    }

    public void showForSystem() {
        if (this.f579w) {
            this.f579w = false;
            m515m(true);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f570n;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.f560d.setHideOnContentScrollEnabled(false);
        this.f563g.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f563g.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        this.f570n = actionModeImpl2;
        actionModeImpl2.invalidate();
        this.f563g.initForMode(actionModeImpl2);
        animateToMode(true);
        this.f563g.sendAccessibilityEvent(32);
        return actionModeImpl2;
    }

    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.f566j.isEmpty());
    }

    public void setHomeActionContentDescription(int i) {
        this.f562f.setNavigationContentDescription(i);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f562f.setNavigationIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f562f.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.f562f.setLogo(drawable);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f562f.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f562f.setTitle(charSequence);
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        m508f();
        this.f565i.addTab(tab, z);
        m507e(tab, this.f566j.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.f562f.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f569m = true;
        }
        this.f562f.setDisplayOptions((i & i2) | ((i2 ^ -1) & displayOptions));
    }

    public void setCustomView(View view) {
        this.f562f.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f562f.setCustomView(view);
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        m508f();
        this.f565i.addTab(tab, i, z);
        m507e(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        m511i(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        m511i(view);
    }
}
