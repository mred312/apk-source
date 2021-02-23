package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0131R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: a0 */
    private static final SimpleArrayMap<String, Integer> f442a0 = new SimpleArrayMap<>();

    /* renamed from: b0 */
    private static final boolean f443b0;

    /* renamed from: c0 */
    private static final int[] f444c0 = {16842836};

    /* renamed from: d0 */
    private static final boolean f445d0 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: e0 */
    private static final boolean f446e0;

    /* renamed from: f0 */
    private static boolean f447f0 = true;

    /* renamed from: A */
    boolean f448A;

    /* renamed from: B */
    boolean f449B;

    /* renamed from: C */
    boolean f450C;

    /* renamed from: D */
    boolean f451D;

    /* renamed from: E */
    boolean f452E;

    /* renamed from: F */
    private boolean f453F;

    /* renamed from: G */
    private PanelFeatureState[] f454G;

    /* renamed from: H */
    private PanelFeatureState f455H;

    /* renamed from: I */
    private boolean f456I;

    /* renamed from: J */
    private boolean f457J;

    /* renamed from: K */
    private boolean f458K;

    /* renamed from: L */
    private boolean f459L;

    /* renamed from: M */
    boolean f460M;

    /* renamed from: N */
    private int f461N;

    /* renamed from: O */
    private int f462O;

    /* renamed from: P */
    private boolean f463P;

    /* renamed from: Q */
    private boolean f464Q;

    /* renamed from: R */
    private C0165m f465R;

    /* renamed from: S */
    private C0165m f466S;

    /* renamed from: T */
    boolean f467T;

    /* renamed from: U */
    int f468U;

    /* renamed from: V */
    private final Runnable f469V;

    /* renamed from: W */
    private boolean f470W;

    /* renamed from: X */
    private Rect f471X;

    /* renamed from: Y */
    private Rect f472Y;

    /* renamed from: Z */
    private AppCompatViewInflater f473Z;

    /* renamed from: d */
    final Object f474d;

    /* renamed from: e */
    final Context f475e;

    /* renamed from: f */
    Window f476f;

    /* renamed from: g */
    private C0163k f477g;

    /* renamed from: h */
    final AppCompatCallback f478h;

    /* renamed from: i */
    ActionBar f479i;

    /* renamed from: j */
    MenuInflater f480j;

    /* renamed from: k */
    private CharSequence f481k;

    /* renamed from: l */
    private DecorContentParent f482l;

    /* renamed from: m */
    private C0160i f483m;

    /* renamed from: n */
    private C0173t f484n;

    /* renamed from: o */
    ActionMode f485o;

    /* renamed from: p */
    ActionBarContextView f486p;

    /* renamed from: q */
    PopupWindow f487q;

    /* renamed from: r */
    Runnable f488r;

    /* renamed from: s */
    ViewPropertyAnimatorCompat f489s;

    /* renamed from: t */
    private boolean f490t;

    /* renamed from: u */
    private boolean f491u;

    /* renamed from: v */
    ViewGroup f492v;

    /* renamed from: w */
    private TextView f493w;

    /* renamed from: x */
    private View f494x;

    /* renamed from: y */
    private boolean f495y;

    /* renamed from: z */
    private boolean f496z;

    protected static final class PanelFeatureState {

        /* renamed from: a */
        int f497a;

        /* renamed from: b */
        int f498b;

        /* renamed from: c */
        int f499c;

        /* renamed from: d */
        int f500d;

        /* renamed from: e */
        int f501e;

        /* renamed from: f */
        int f502f;

        /* renamed from: g */
        ViewGroup f503g;

        /* renamed from: h */
        View f504h;

        /* renamed from: i */
        View f505i;

        /* renamed from: j */
        MenuBuilder f506j;

        /* renamed from: k */
        ListMenuPresenter f507k;

        /* renamed from: l */
        Context f508l;

        /* renamed from: m */
        boolean f509m;

        /* renamed from: n */
        boolean f510n;

        /* renamed from: o */
        boolean f511o;

        /* renamed from: p */
        boolean f512p = false;

        /* renamed from: q */
        boolean f513q;
        public boolean qwertyMode;

        /* renamed from: r */
        Bundle f514r;

        PanelFeatureState(int i) {
            this.f497a = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public MenuView mo1121a(MenuPresenter.Callback callback) {
            if (this.f506j == null) {
                return null;
            }
            if (this.f507k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f508l, C0131R.layout.abc_list_menu_item_layout);
                this.f507k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.f506j.addMenuPresenter(this.f507k);
            }
            return this.f507k.getMenuView(this.f503g);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1122b(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f506j;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.f507k);
                }
                this.f506j = menuBuilder;
                if (menuBuilder != null && (listMenuPresenter = this.f507k) != null) {
                    menuBuilder.addMenuPresenter(listMenuPresenter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo1123c(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0131R.attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(C0131R.attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(C0131R.style.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f508l = contextThemeWrapper;
            TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(C0131R.styleable.AppCompatTheme);
            this.f498b = obtainStyledAttributes.getResourceId(C0131R.styleable.AppCompatTheme_panelBackground, 0);
            this.f502f = obtainStyledAttributes.getResourceId(C0131R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public void clearMenuPresenters() {
            MenuBuilder menuBuilder = this.f506j;
            if (menuBuilder != null) {
                menuBuilder.removeMenuPresenter(this.f507k);
            }
            this.f507k = null;
        }

        public boolean hasPanelItems() {
            if (this.f504h == null) {
                return false;
            }
            if (this.f505i == null && this.f507k.getAdapter().getCount() <= 0) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$a */
    class C0151a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        final /* synthetic */ Thread.UncaughtExceptionHandler f515a;

        C0151a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f515a = uncaughtExceptionHandler;
        }

        /* renamed from: a */
        private boolean m478a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            if (message.contains("drawable") || message.contains("Drawable")) {
                return true;
            }
            return false;
        }

        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            if (m478a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f515a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f515a.uncaughtException(thread, th);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$b */
    class C0152b implements Runnable {
        C0152b() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f468U & 1) != 0) {
                appCompatDelegateImpl.mo1117r(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f468U & 4096) != 0) {
                appCompatDelegateImpl2.mo1117r(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f467T = false;
            appCompatDelegateImpl3.f468U = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$c */
    class C0153c implements OnApplyWindowInsetsListener {
        C0153c() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int g0 = AppCompatDelegateImpl.this.mo1106g0(windowInsetsCompat, (Rect) null);
            if (systemWindowInsetTop != g0) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), g0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$d */
    class C0154d implements FitWindowsViewGroup.OnFitSystemWindowsListener {
        C0154d() {
        }

        public void onFitSystemWindows(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.mo1106g0((WindowInsetsCompat) null, rect);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$e */
    class C0155e implements ContentFrameLayout.OnAttachListener {
        C0155e() {
        }

        public void onAttachedFromWindow() {
        }

        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.mo1115p();
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$f */
    class C0156f implements Runnable {

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$f$a */
        class C0157a extends ViewPropertyAnimatorListenerAdapter {
            C0157a() {
            }

            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.f486p.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f489s.setListener((ViewPropertyAnimatorListener) null);
                AppCompatDelegateImpl.this.f489s = null;
            }

            public void onAnimationStart(View view) {
                AppCompatDelegateImpl.this.f486p.setVisibility(0);
            }
        }

        C0156f() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f487q.showAtLocation(appCompatDelegateImpl.f486p, 55, 0, 0);
            AppCompatDelegateImpl.this.mo1118s();
            if (AppCompatDelegateImpl.this.mo1104Z()) {
                AppCompatDelegateImpl.this.f486p.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f489s = ViewCompat.animate(appCompatDelegateImpl2.f486p).alpha(1.0f);
                AppCompatDelegateImpl.this.f489s.setListener(new C0157a());
                return;
            }
            AppCompatDelegateImpl.this.f486p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f486p.setVisibility(0);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$g */
    class C0158g extends ViewPropertyAnimatorListenerAdapter {
        C0158g() {
        }

        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.f486p.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f489s.setListener((ViewPropertyAnimatorListener) null);
            AppCompatDelegateImpl.this.f489s = null;
        }

        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.f486p.setVisibility(0);
            AppCompatDelegateImpl.this.f486p.sendAccessibilityEvent(32);
            if (AppCompatDelegateImpl.this.f486p.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f486p.getParent());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$h */
    private class C0159h implements ActionBarDrawerToggle.Delegate {
        C0159h() {
        }

        public Context getActionBarThemedContext() {
            return AppCompatDelegateImpl.this.mo1120x();
        }

        public Drawable getThemeUpIndicator() {
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), (AttributeSet) null, new int[]{C0131R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            return (supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarDescription(int i) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar supportActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeAsUpIndicator(drawable);
                supportActionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$i */
    private final class C0160i implements MenuPresenter.Callback {
        C0160i() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.mo1108j(menuBuilder);
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            Window.Callback C = AppCompatDelegateImpl.this.mo1094C();
            if (C == null) {
                return true;
            }
            C.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$j */
    class C0161j implements ActionMode.Callback {

        /* renamed from: a */
        private ActionMode.Callback f525a;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$j$a */
        class C0162a extends ViewPropertyAnimatorListenerAdapter {
            C0162a() {
            }

            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.f486p.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f487q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f486p.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f486p.getParent());
                }
                AppCompatDelegateImpl.this.f486p.removeAllViews();
                AppCompatDelegateImpl.this.f489s.setListener((ViewPropertyAnimatorListener) null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f489s = null;
                ViewCompat.requestApplyInsets(appCompatDelegateImpl2.f492v);
            }
        }

        public C0161j(ActionMode.Callback callback) {
            this.f525a = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f525a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f525a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f525a.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f487q != null) {
                appCompatDelegateImpl.f476f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f488r);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f486p != null) {
                appCompatDelegateImpl2.mo1118s();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f489s = ViewCompat.animate(appCompatDelegateImpl3.f486p).alpha(0.0f);
                AppCompatDelegateImpl.this.f489s.setListener(new C0162a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.f478h;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.f485o);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f485o = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.f492v);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.f492v);
            return this.f525a.onPrepareActionMode(actionMode, menu);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$l */
    private class C0164l extends C0165m {

        /* renamed from: c */
        private final PowerManager f529c;

        C0164l(@NonNull Context context) {
            super();
            this.f529c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public IntentFilter mo1152b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        /* renamed from: c */
        public int mo1153c() {
            if (Build.VERSION.SDK_INT < 21 || !this.f529c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        /* renamed from: d */
        public void mo1154d() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$m */
    abstract class C0165m {

        /* renamed from: a */
        private BroadcastReceiver f531a;

        /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$m$a */
        class C0166a extends BroadcastReceiver {
            C0166a() {
            }

            public void onReceive(Context context, Intent intent) {
                C0165m.this.mo1154d();
            }
        }

        C0165m() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1155a() {
            BroadcastReceiver broadcastReceiver = this.f531a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f475e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f531a = null;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: b */
        public abstract IntentFilter mo1152b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract int mo1153c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract void mo1154d();

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo1156e() {
            mo1155a();
            IntentFilter b = mo1152b();
            if (b != null && b.countActions() != 0) {
                if (this.f531a == null) {
                    this.f531a = new C0166a();
                }
                AppCompatDelegateImpl.this.f475e.registerReceiver(this.f531a, b);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$n */
    private class C0167n extends C0165m {

        /* renamed from: c */
        private final C0190f f534c;

        C0167n(@NonNull C0190f fVar) {
            super();
            this.f534c = fVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public IntentFilter mo1152b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* renamed from: c */
        public int mo1153c() {
            return this.f534c.mo1237d() ? 2 : 1;
        }

        /* renamed from: d */
        public void mo1154d() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    @RequiresApi(17)
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$o */
    static class C0168o {
        /* renamed from: a */
        static void m491a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i = configuration.densityDpi;
            int i2 = configuration2.densityDpi;
            if (i != i2) {
                configuration3.densityDpi = i2;
            }
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$p */
    static class C0169p {
        /* renamed from: a */
        static void m492a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    @RequiresApi(26)
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$q */
    static class C0170q {
        /* renamed from: a */
        static void m493a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i = configuration.colorMode & 3;
            int i2 = configuration2.colorMode;
            if (i != (i2 & 3)) {
                configuration3.colorMode |= i2 & 3;
            }
            int i3 = configuration.colorMode & 12;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 12)) {
                configuration3.colorMode |= i4 & 12;
            }
        }
    }

    @RequiresApi(17)
    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$r */
    private static class C0171r {
        /* renamed from: a */
        static void m494a(android.view.ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$s */
    private class C0172s extends ContentFrameLayout {
        public C0172s(Context context) {
            super(context);
        }

        /* renamed from: a */
        private boolean m495a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.mo1116q(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m495a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.mo1109l(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$t */
    private final class C0173t implements MenuPresenter.Callback {
        C0173t() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState v = appCompatDelegateImpl.mo1119v(menuBuilder);
            if (v == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.mo1107i(v.f497a, v, rootMenu);
                AppCompatDelegateImpl.this.mo1110m(v, true);
                return;
            }
            AppCompatDelegateImpl.this.mo1110m(v, z);
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            Window.Callback C;
            if (menuBuilder != menuBuilder.getRootMenu()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.f448A || (C = appCompatDelegateImpl.mo1094C()) == null || AppCompatDelegateImpl.this.f460M) {
                return true;
            }
            C.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean z2 = i < 21;
        f443b0 = z2;
        if (i >= 17) {
            z = true;
        }
        f446e0 = z;
        if (z2 && !f447f0) {
            Thread.setDefaultUncaughtExceptionHandler(new C0151a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this(activity, (Window) null, appCompatCallback, activity);
    }

    /* renamed from: D */
    private void m419D() {
        m445t();
        if (this.f448A && this.f479i == null) {
            Object obj = this.f474d;
            if (obj instanceof Activity) {
                this.f479i = new WindowDecorActionBar((Activity) this.f474d, this.f449B);
            } else if (obj instanceof Dialog) {
                this.f479i = new WindowDecorActionBar((Dialog) this.f474d);
            }
            ActionBar actionBar = this.f479i;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.f470W);
            }
        }
    }

    /* renamed from: E */
    private boolean m420E(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f505i;
        if (view != null) {
            panelFeatureState.f504h = view;
            return true;
        } else if (panelFeatureState.f506j == null) {
            return false;
        } else {
            if (this.f484n == null) {
                this.f484n = new C0173t();
            }
            View view2 = (View) panelFeatureState.mo1121a(this.f484n);
            panelFeatureState.f504h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: F */
    private boolean m421F(PanelFeatureState panelFeatureState) {
        panelFeatureState.mo1123c(mo1120x());
        panelFeatureState.f503g = new C0172s(panelFeatureState.f508l);
        panelFeatureState.f499c = 81;
        return true;
    }

    /* renamed from: G */
    private boolean m422G(PanelFeatureState panelFeatureState) {
        Context context = this.f475e;
        int i = panelFeatureState.f497a;
        if ((i == 0 || i == 108) && this.f482l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(C0131R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0131R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0131R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme2);
                context = contextThemeWrapper;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.mo1122b(menuBuilder);
        return true;
    }

    /* renamed from: H */
    private void m423H(int i) {
        this.f468U = (1 << i) | this.f468U;
        if (!this.f467T) {
            ViewCompat.postOnAnimation(this.f476f.getDecorView(), this.f469V);
            this.f467T = true;
        }
    }

    /* renamed from: I */
    private boolean m424I() {
        if (!this.f464Q && (this.f474d instanceof Activity)) {
            PackageManager packageManager = this.f475e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f475e, this.f474d.getClass()), i >= 29 ? 269221888 : i >= 24 ? 786432 : 0);
                this.f463P = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.f463P = false;
            }
        }
        this.f464Q = true;
        return this.f463P;
    }

    /* renamed from: M */
    private boolean m425M(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState A = mo1092A(i, true);
        if (!A.f511o) {
            return m429W(A, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* renamed from: P */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m426P(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.ActionMode r0 = r4.f485o
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.mo1092A(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.f482l
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.canShowOverflowMenu()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.f475e
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.DecorContentParent r5 = r4.f482l
            boolean r5 = r5.isOverflowMenuShowing()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.f460M
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.m429W(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.DecorContentParent r5 = r4.f482l
            boolean r0 = r5.showOverflowMenu()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.DecorContentParent r5 = r4.f482l
            boolean r0 = r5.hideOverflowMenu()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.f511o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.f510n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.f509m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.f513q
            if (r5 == 0) goto L_0x005b
            r2.f509m = r1
            boolean r5 = r4.m429W(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = 1
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.m427T(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = 0
            goto L_0x0068
        L_0x0064:
            r4.mo1110m(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0085
            android.content.Context r5 = r4.f475e
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007e
            r5.playSoundEffect(r1)
            goto L_0x0085
        L_0x007e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m426P(int, android.view.KeyEvent):boolean");
    }

    /* renamed from: T */
    private void m427T(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.f511o && !this.f460M) {
            if (panelFeatureState.f497a == 0) {
                if ((this.f475e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback C = mo1094C();
            if (C == null || C.onMenuOpened(panelFeatureState.f497a, panelFeatureState.f506j)) {
                WindowManager windowManager = (WindowManager) this.f475e.getSystemService("window");
                if (windowManager != null && m429W(panelFeatureState, keyEvent)) {
                    ViewGroup viewGroup = panelFeatureState.f503g;
                    if (viewGroup == null || panelFeatureState.f512p) {
                        if (viewGroup == null) {
                            if (!m421F(panelFeatureState) || panelFeatureState.f503g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f512p && viewGroup.getChildCount() > 0) {
                            panelFeatureState.f503g.removeAllViews();
                        }
                        if (!m420E(panelFeatureState) || !panelFeatureState.hasPanelItems()) {
                            panelFeatureState.f512p = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f504h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        panelFeatureState.f503g.setBackgroundResource(panelFeatureState.f498b);
                        ViewParent parent = panelFeatureState.f504h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(panelFeatureState.f504h);
                        }
                        panelFeatureState.f503g.addView(panelFeatureState.f504h, layoutParams2);
                        if (!panelFeatureState.f504h.hasFocus()) {
                            panelFeatureState.f504h.requestFocus();
                        }
                    } else {
                        View view = panelFeatureState.f505i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i = -1;
                            panelFeatureState.f510n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f500d, panelFeatureState.f501e, 1002, 8519680, -3);
                            layoutParams3.gravity = panelFeatureState.f499c;
                            layoutParams3.windowAnimations = panelFeatureState.f502f;
                            windowManager.addView(panelFeatureState.f503g, layoutParams3);
                            panelFeatureState.f511o = true;
                            return;
                        }
                    }
                    i = -2;
                    panelFeatureState.f510n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, panelFeatureState.f500d, panelFeatureState.f501e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f499c;
                    layoutParams32.windowAnimations = panelFeatureState.f502f;
                    windowManager.addView(panelFeatureState.f503g, layoutParams32);
                    panelFeatureState.f511o = true;
                    return;
                }
                return;
            }
            mo1110m(panelFeatureState, true);
        }
    }

    /* renamed from: V */
    private boolean m428V(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        MenuBuilder menuBuilder;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f509m || m429W(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f506j) != null) {
            z = menuBuilder.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f482l == null) {
            mo1110m(panelFeatureState, true);
        }
        return z;
    }

    /* renamed from: W */
    private boolean m429W(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        DecorContentParent decorContentParent4;
        if (this.f460M) {
            return false;
        }
        if (panelFeatureState.f509m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f455H;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            mo1110m(panelFeatureState2, false);
        }
        Window.Callback C = mo1094C();
        if (C != null) {
            panelFeatureState.f505i = C.onCreatePanelView(panelFeatureState.f497a);
        }
        int i = panelFeatureState.f497a;
        boolean z = i == 0 || i == 108;
        if (z && (decorContentParent4 = this.f482l) != null) {
            decorContentParent4.setMenuPrepared();
        }
        if (panelFeatureState.f505i == null && (!z || !(mo1103U() instanceof C0183d))) {
            MenuBuilder menuBuilder = panelFeatureState.f506j;
            if (menuBuilder == null || panelFeatureState.f513q) {
                if (menuBuilder == null && (!m422G(panelFeatureState) || panelFeatureState.f506j == null)) {
                    return false;
                }
                if (z && (decorContentParent3 = this.f482l) != null) {
                    if (this.f483m == null) {
                        this.f483m = new C0160i();
                    }
                    decorContentParent3.setMenu(panelFeatureState.f506j, this.f483m);
                }
                panelFeatureState.f506j.stopDispatchingItemsChanged();
                if (!C.onCreatePanelMenu(panelFeatureState.f497a, panelFeatureState.f506j)) {
                    panelFeatureState.mo1122b((MenuBuilder) null);
                    if (z && (decorContentParent2 = this.f482l) != null) {
                        decorContentParent2.setMenu((Menu) null, this.f483m);
                    }
                    return false;
                }
                panelFeatureState.f513q = false;
            }
            panelFeatureState.f506j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.f514r;
            if (bundle != null) {
                panelFeatureState.f506j.restoreActionViewStates(bundle);
                panelFeatureState.f514r = null;
            }
            if (!C.onPreparePanel(0, panelFeatureState.f505i, panelFeatureState.f506j)) {
                if (z && (decorContentParent = this.f482l) != null) {
                    decorContentParent.setMenu((Menu) null, this.f483m);
                }
                panelFeatureState.f506j.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = z2;
            panelFeatureState.f506j.setQwertyMode(z2);
            panelFeatureState.f506j.startDispatchingItemsChanged();
        }
        panelFeatureState.f509m = true;
        panelFeatureState.f510n = false;
        this.f455H = panelFeatureState;
        return true;
    }

    /* renamed from: X */
    private void m430X(boolean z) {
        DecorContentParent decorContentParent = this.f482l;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.f475e).hasPermanentMenuKey() && !this.f482l.isOverflowMenuShowPending())) {
            PanelFeatureState A = mo1092A(0, true);
            A.f512p = true;
            mo1110m(A, false);
            m427T(A, (KeyEvent) null);
            return;
        }
        Window.Callback C = mo1094C();
        if (this.f482l.isOverflowMenuShowing() && z) {
            this.f482l.hideOverflowMenu();
            if (!this.f460M) {
                C.onPanelClosed(108, mo1092A(0, true).f506j);
            }
        } else if (C != null && !this.f460M) {
            if (this.f467T && (this.f468U & 1) != 0) {
                this.f476f.getDecorView().removeCallbacks(this.f469V);
                this.f469V.run();
            }
            PanelFeatureState A2 = mo1092A(0, true);
            MenuBuilder menuBuilder = A2.f506j;
            if (menuBuilder != null && !A2.f513q && C.onPreparePanel(0, A2.f505i, menuBuilder)) {
                C.onMenuOpened(108, A2.f506j);
                this.f482l.showOverflowMenu();
            }
        }
    }

    /* renamed from: Y */
    private int m431Y(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* renamed from: a0 */
    private boolean m432a0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f476f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* renamed from: c0 */
    private void m433c0() {
        if (this.f491u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Nullable
    /* renamed from: d0 */
    private AppCompatActivity m434d0() {
        Context context = this.f475e;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    /* renamed from: e */
    private boolean m435e(boolean z) {
        if (this.f460M) {
            return false;
        }
        int h = m440h();
        boolean e0 = m436e0(mo1095J(this.f475e, h), z);
        if (h == 0) {
            m449z(this.f475e).mo1156e();
        } else {
            C0165m mVar = this.f465R;
            if (mVar != null) {
                mVar.mo1155a();
            }
        }
        if (h == 3) {
            m448y(this.f475e).mo1156e();
        } else {
            C0165m mVar2 = this.f466S;
            if (mVar2 != null) {
                mVar2.mo1155a();
            }
        }
        return e0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* renamed from: e0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m436e0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f475e
            r1 = 0
            android.content.res.Configuration r0 = r6.m443n(r0, r7, r1)
            boolean r2 = r6.m424I()
            android.content.Context r3 = r6.f475e
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L_0x0047
            if (r8 == 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            boolean r8 = r6.f457J
            if (r8 == 0) goto L_0x0047
            boolean r8 = f445d0
            if (r8 != 0) goto L_0x0030
            boolean r8 = r6.f458K
            if (r8 == 0) goto L_0x0047
        L_0x0030:
            java.lang.Object r8 = r6.f474d
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L_0x0047
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L_0x0047
            java.lang.Object r8 = r6.f474d
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.ActivityCompat.recreate(r8)
            r8 = 1
            goto L_0x0048
        L_0x0047:
            r8 = 0
        L_0x0048:
            if (r8 != 0) goto L_0x0050
            if (r3 == r0) goto L_0x0050
            r6.m438f0(r0, r2, r1)
            goto L_0x0051
        L_0x0050:
            r4 = r8
        L_0x0051:
            if (r4 == 0) goto L_0x005e
            java.lang.Object r8 = r6.f474d
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L_0x005e
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r8.onNightModeChanged(r7)
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.m436e0(int, boolean):boolean");
    }

    /* renamed from: f */
    private void m437f() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f492v.findViewById(16908290);
        View decorView = this.f476f.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f475e.obtainStyledAttributes(C0131R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(C0131R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0131R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i = C0131R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i)) {
            obtainStyledAttributes.getValue(i, contentFrameLayout.getFixedWidthMajor());
        }
        int i2 = C0131R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMinor());
        }
        int i3 = C0131R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedHeightMajor());
        }
        int i4 = C0131R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: f0 */
    private void m438f0(int i, boolean z, @Nullable Configuration configuration) {
        Resources resources = this.f475e.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            C0182c.m520a(resources);
        }
        int i3 = this.f462O;
        if (i3 != 0) {
            this.f475e.setTheme(i3);
            if (i2 >= 23) {
                this.f475e.getTheme().applyStyle(this.f462O, true);
            }
        }
        if (z) {
            Object obj = this.f474d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof LifecycleOwner) {
                    if (((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.f459L) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    /* renamed from: g */
    private void m439g(@NonNull Window window) {
        if (this.f476f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof C0163k)) {
                C0163k kVar = new C0163k(callback);
                this.f477g = kVar;
                window.setCallback(kVar);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f475e, (AttributeSet) null, f444c0);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.f476f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: h */
    private int m440h() {
        int i = this.f461N;
        return i != -100 ? i : AppCompatDelegate.getDefaultNightMode();
    }

    /* renamed from: h0 */
    private void m441h0(View view) {
        int i;
        if ((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0) {
            i = ContextCompat.getColor(this.f475e, C0131R.color.abc_decor_view_status_guard_light);
        } else {
            i = ContextCompat.getColor(this.f475e, C0131R.color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(i);
    }

    /* renamed from: k */
    private void m442k() {
        C0165m mVar = this.f465R;
        if (mVar != null) {
            mVar.mo1155a();
        }
        C0165m mVar2 = this.f466S;
        if (mVar2 != null) {
            mVar2.mo1155a();
        }
    }

    @NonNull
    /* renamed from: n */
    private Configuration m443n(@NonNull Context context, int i, @Nullable Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* renamed from: o */
    private ViewGroup m444o() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f475e.obtainStyledAttributes(C0131R.styleable.AppCompatTheme);
        int i = C0131R.styleable.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i)) {
            if (obtainStyledAttributes.getBoolean(C0131R.styleable.AppCompatTheme_windowNoTitle, false)) {
                requestWindowFeature(1);
            } else if (obtainStyledAttributes.getBoolean(i, false)) {
                requestWindowFeature(108);
            }
            if (obtainStyledAttributes.getBoolean(C0131R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                requestWindowFeature(109);
            }
            if (obtainStyledAttributes.getBoolean(C0131R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                requestWindowFeature(10);
            }
            this.f451D = obtainStyledAttributes.getBoolean(C0131R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            m446u();
            this.f476f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f475e);
            if (this.f452E) {
                viewGroup = this.f450C ? (ViewGroup) from.inflate(C0131R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(C0131R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.f451D) {
                viewGroup = (ViewGroup) from.inflate(C0131R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f449B = false;
                this.f448A = false;
            } else if (this.f448A) {
                TypedValue typedValue = new TypedValue();
                this.f475e.getTheme().resolveAttribute(C0131R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new ContextThemeWrapper(this.f475e, typedValue.resourceId);
                } else {
                    context = this.f475e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C0131R.layout.abc_screen_toolbar, (ViewGroup) null);
                DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(C0131R.C0133id.decor_content_parent);
                this.f482l = decorContentParent;
                decorContentParent.setWindowCallback(mo1094C());
                if (this.f449B) {
                    this.f482l.initFeature(109);
                }
                if (this.f495y) {
                    this.f482l.initFeature(2);
                }
                if (this.f496z) {
                    this.f482l.initFeature(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new C0153c());
                } else if (viewGroup instanceof FitWindowsViewGroup) {
                    ((FitWindowsViewGroup) viewGroup).setOnFitSystemWindowsListener(new C0154d());
                }
                if (this.f482l == null) {
                    this.f493w = (TextView) viewGroup.findViewById(C0131R.C0133id.title);
                }
                ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0131R.C0133id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f476f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f476f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new C0155e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f448A + ", windowActionBarOverlay: " + this.f449B + ", android:windowIsFloating: " + this.f451D + ", windowActionModeOverlay: " + this.f450C + ", windowNoTitle: " + this.f452E + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: t */
    private void m445t() {
        if (!this.f491u) {
            this.f492v = m444o();
            CharSequence B = mo1093B();
            if (!TextUtils.isEmpty(B)) {
                DecorContentParent decorContentParent = this.f482l;
                if (decorContentParent != null) {
                    decorContentParent.setWindowTitle(B);
                } else if (mo1103U() != null) {
                    mo1103U().setWindowTitle(B);
                } else {
                    TextView textView = this.f493w;
                    if (textView != null) {
                        textView.setText(B);
                    }
                }
            }
            m437f();
            mo1102S(this.f492v);
            this.f491u = true;
            PanelFeatureState A = mo1092A(0, false);
            if (this.f460M) {
                return;
            }
            if (A == null || A.f506j == null) {
                m423H(108);
            }
        }
    }

    /* renamed from: u */
    private void m446u() {
        if (this.f476f == null) {
            Object obj = this.f474d;
            if (obj instanceof Activity) {
                m439g(((Activity) obj).getWindow());
            }
        }
        if (this.f476f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @NonNull
    /* renamed from: w */
    private static Configuration m447w(@NonNull Configuration configuration, @Nullable Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i = configuration.mcc;
            int i2 = configuration2.mcc;
            if (i != i2) {
                configuration3.mcc = i2;
            }
            int i3 = configuration.mnc;
            int i4 = configuration2.mnc;
            if (i3 != i4) {
                configuration3.mnc = i4;
            }
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 24) {
                C0169p.m492a(configuration, configuration2, configuration3);
            } else if (!ObjectsCompat.equals(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & 192;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 192)) {
                configuration3.screenLayout |= i21 & 192;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            if (i5 >= 26) {
                C0170q.m493a(configuration, configuration2, configuration3);
            }
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            if (i5 >= 17) {
                C0168o.m491a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    /* renamed from: y */
    private C0165m m448y(@NonNull Context context) {
        if (this.f466S == null) {
            this.f466S = new C0164l(context);
        }
        return this.f466S;
    }

    /* renamed from: z */
    private C0165m m449z(@NonNull Context context) {
        if (this.f465R == null) {
            this.f465R = new C0167n(C0190f.m531a(context));
        }
        return this.f465R;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public PanelFeatureState mo1092A(int i, boolean z) {
        PanelFeatureState[] panelFeatureStateArr = this.f454G;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f454G = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public final CharSequence mo1093B() {
        Object obj = this.f474d;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f481k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public final Window.Callback mo1094C() {
        return this.f476f.getCallback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public int mo1095J(@NonNull Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (!(i == 1 || i == 2)) {
                    if (i == 3) {
                        return m448y(context).mo1153c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                return m449z(context).mo1153c();
            } else {
                return -1;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public boolean mo1096K() {
        ActionMode actionMode = this.f485o;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.collapseActionView()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public boolean mo1097L(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z = false;
            }
            this.f456I = z;
        } else if (i == 82) {
            m425M(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public boolean mo1098N(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f455H;
        if (panelFeatureState == null || !m428V(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f455H == null) {
                PanelFeatureState A = mo1092A(0, true);
                m429W(A, keyEvent);
                boolean V = m428V(A, keyEvent.getKeyCode(), keyEvent, 1);
                A.f509m = false;
                if (V) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.f455H;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f510n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public boolean mo1099O(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f456I;
            this.f456I = false;
            PanelFeatureState A = mo1092A(0, false);
            if (A != null && A.f511o) {
                if (!z) {
                    mo1110m(A, true);
                }
                return true;
            } else if (mo1096K()) {
                return true;
            }
        } else if (i == 82) {
            m426P(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Q */
    public void mo1100Q(int i) {
        ActionBar supportActionBar;
        if (i == 108 && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.dispatchMenuVisibilityChanged(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: R */
    public void mo1101R(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (i == 0) {
            PanelFeatureState A = mo1092A(i, true);
            if (A.f511o) {
                mo1110m(A, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: S */
    public void mo1102S(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: U */
    public final ActionBar mo1103U() {
        return this.f479i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f492v;
     */
    /* renamed from: Z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo1104Z() {
        /*
            r1 = this;
            boolean r0 = r1.f491u
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f492v
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.ViewCompat.isLaidOut(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.mo1104Z():boolean");
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m445t();
        ((ViewGroup) this.f492v.findViewById(16908290)).addView(view, layoutParams);
        this.f477g.getWrapped().onContentChanged();
    }

    public boolean applyDayNight() {
        return m435e(true);
    }

    @CallSuper
    @NonNull
    public Context attachBaseContext2(@NonNull Context context) {
        boolean z = true;
        this.f457J = true;
        int J = mo1095J(context, m440h());
        Configuration configuration = null;
        if (f446e0 && (context instanceof android.view.ContextThemeWrapper)) {
            try {
                C0171r.m494a((android.view.ContextThemeWrapper) context, m443n(context, J, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(m443n(context, J, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f445d0) {
            return super.attachBaseContext2(context);
        }
        try {
            Configuration configuration2 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            if (!configuration2.equals(configuration3)) {
                configuration = m447w(configuration2, configuration3);
            }
            Configuration n = m443n(context, J, configuration);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, C0131R.style.Theme_AppCompat_Empty);
            contextThemeWrapper.applyOverrideConfiguration(n);
            boolean z2 = false;
            try {
                if (context.getTheme() == null) {
                    z = false;
                }
                z2 = z;
            } catch (NullPointerException unused3) {
            }
            if (z2) {
                ResourcesCompat.ThemeCompat.rebase(contextThemeWrapper.getTheme());
            }
            return super.attachBaseContext2(contextThemeWrapper);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Application failed to obtain resources from itself", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* renamed from: b0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode mo1105b0(@androidx.annotation.NonNull androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            r7.mo1118s()
            androidx.appcompat.view.ActionMode r0 = r7.f485o
            if (r0 == 0) goto L_0x000a
            r0.finish()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.C0161j
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$j r0 = new androidx.appcompat.app.AppCompatDelegateImpl$j
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.AppCompatCallback r0 = r7.f478h
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.f460M
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.ActionMode r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f485o = r0
            goto L_0x0162
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f486p
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.f451D
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f475e
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.C0131R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f475e
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.f475e
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f475e
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f486p = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.C0131R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f487q = r5
            r6 = 2
            androidx.core.widget.PopupWindowCompat.setWindowLayoutType(r5, r6)
            android.widget.PopupWindow r5 = r7.f487q
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f486p
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f487q
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.C0131R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f486p
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f487q
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$f r0 = new androidx.appcompat.app.AppCompatDelegateImpl$f
            r0.<init>()
            r7.f488r = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.f492v
            int r4 = androidx.appcompat.C0131R.C0133id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.mo1120x()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.inflate()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f486p = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f486p
            if (r0 == 0) goto L_0x0162
            r7.mo1118s()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f486p
            r0.killMode()
            androidx.appcompat.view.StandaloneActionMode r0 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f486p
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f486p
            android.widget.PopupWindow r6 = r7.f487q
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = 0
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.getMenu()
            boolean r8 = r8.onCreateActionMode(r0, r3)
            if (r8 == 0) goto L_0x0160
            r0.invalidate()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            r8.initForMode(r0)
            r7.f485o = r0
            boolean r8 = r7.mo1104Z()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.animate(r8)
            androidx.core.view.ViewPropertyAnimatorCompat r8 = r8.alpha(r0)
            r7.f489s = r8
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = new androidx.appcompat.app.AppCompatDelegateImpl$g
            r0.<init>()
            r8.setListener(r0)
            goto L_0x0150
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0150
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f486p
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.ViewCompat.requestApplyInsets(r8)
        L_0x0150:
            android.widget.PopupWindow r8 = r7.f487q
            if (r8 == 0) goto L_0x0162
            android.view.Window r8 = r7.f476f
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f488r
            r8.post(r0)
            goto L_0x0162
        L_0x0160:
            r7.f485o = r1
        L_0x0162:
            androidx.appcompat.view.ActionMode r8 = r7.f485o
            if (r8 == 0) goto L_0x016d
            androidx.appcompat.app.AppCompatCallback r0 = r7.f478h
            if (r0 == 0) goto L_0x016d
            r0.onSupportActionModeStarted(r8)
        L_0x016d:
            androidx.appcompat.view.ActionMode r8 = r7.f485o
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.mo1105b0(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.f473Z == null) {
            String string = this.f475e.obtainStyledAttributes(C0131R.styleable.AppCompatTheme).getString(C0131R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f473Z = new AppCompatViewInflater();
            } else {
                try {
                    this.f473Z = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f473Z = new AppCompatViewInflater();
                }
            }
        }
        boolean z3 = f443b0;
        if (z3) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = m432a0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.f473Z.mo1178b(view, str, context, attributeSet, z, z3, true, VectorEnabledTintResources.shouldBeUsed());
    }

    @Nullable
    public <T extends View> T findViewById(@IdRes int i) {
        m445t();
        return this.f476f.findViewById(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g0 */
    public final int mo1106g0(@Nullable WindowInsetsCompat windowInsetsCompat, @Nullable Rect rect) {
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i4;
        int i5 = 0;
        if (windowInsetsCompat != null) {
            i = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.f486p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f486p.getLayoutParams();
            boolean z3 = true;
            if (this.f486p.isShown()) {
                if (this.f471X == null) {
                    this.f471X = new Rect();
                    this.f472Y = new Rect();
                }
                Rect rect2 = this.f471X;
                Rect rect3 = this.f472Y;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows(this.f492v, rect2, rect3);
                int i6 = rect2.top;
                int i7 = rect2.left;
                int i8 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.f492v);
                if (rootWindowInsets == null) {
                    i2 = 0;
                } else {
                    i2 = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    i3 = 0;
                } else {
                    i3 = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams2.topMargin == i6 && marginLayoutParams2.leftMargin == i7 && marginLayoutParams2.rightMargin == i8) {
                    z2 = false;
                } else {
                    marginLayoutParams2.topMargin = i6;
                    marginLayoutParams2.leftMargin = i7;
                    marginLayoutParams2.rightMargin = i8;
                    z2 = true;
                }
                if (i6 <= 0 || this.f494x != null) {
                    View view = this.f494x;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i4 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3))) {
                        marginLayoutParams.height = i4;
                        marginLayoutParams.leftMargin = i2;
                        marginLayoutParams.rightMargin = i3;
                        this.f494x.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f475e);
                    this.f494x = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    this.f492v.addView(this.f494x, -1, layoutParams);
                }
                View view3 = this.f494x;
                if (view3 == null) {
                    z3 = false;
                }
                if (z3 && view3.getVisibility() != 0) {
                    m441h0(this.f494x);
                }
                if (!this.f450C && z3) {
                    i = 0;
                }
                z = z3;
                z3 = z2;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.f486p.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.f494x;
        if (view4 != null) {
            if (!z) {
                i5 = 8;
            }
            view4.setVisibility(i5);
        }
        return i;
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new C0159h();
    }

    public int getLocalNightMode() {
        return this.f461N;
    }

    public MenuInflater getMenuInflater() {
        if (this.f480j == null) {
            m419D();
            ActionBar actionBar = this.f479i;
            this.f480j = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : this.f475e);
        }
        return this.f480j;
    }

    public ActionBar getSupportActionBar() {
        m419D();
        return this.f479i;
    }

    public boolean hasWindowFeature(int i) {
        boolean z;
        int Y = m431Y(i);
        if (Y == 1) {
            z = this.f452E;
        } else if (Y == 2) {
            z = this.f495y;
        } else if (Y == 5) {
            z = this.f496z;
        } else if (Y == 10) {
            z = this.f450C;
        } else if (Y == 108) {
            z = this.f448A;
        } else if (Y != 109) {
            z = false;
        } else {
            z = this.f449B;
        }
        if (z || this.f476f.hasFeature(i)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo1107i(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f454G;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f506j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f511o) && !this.f460M) {
            this.f477g.getWrapped().onPanelClosed(i, menu);
        }
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.f475e);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.invalidateOptionsMenu()) {
            m423H(0);
        }
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.f490t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo1108j(@NonNull MenuBuilder menuBuilder) {
        if (!this.f453F) {
            this.f453F = true;
            this.f482l.dismissPopups();
            Window.Callback C = mo1094C();
            if (C != null && !this.f460M) {
                C.onPanelClosed(108, menuBuilder);
            }
            this.f453F = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo1109l(int i) {
        mo1110m(mo1092A(i, true), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo1110m(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (!z || panelFeatureState.f497a != 0 || (decorContentParent = this.f482l) == null || !decorContentParent.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.f475e.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f511o || (viewGroup = panelFeatureState.f503g) == null)) {
                windowManager.removeView(viewGroup);
                if (z) {
                    mo1107i(panelFeatureState.f497a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f509m = false;
            panelFeatureState.f510n = false;
            panelFeatureState.f511o = false;
            panelFeatureState.f504h = null;
            panelFeatureState.f512p = true;
            if (this.f455H == panelFeatureState) {
                this.f455H = null;
                return;
            }
            return;
        }
        mo1108j(panelFeatureState.f506j);
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar supportActionBar;
        if (this.f448A && this.f491u && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.f475e);
        m435e(false);
    }

    public void onCreate(Bundle bundle) {
        this.f457J = true;
        m435e(false);
        m446u();
        Object obj = this.f474d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar U = mo1103U();
                if (U == null) {
                    this.f470W = true;
                } else {
                    U.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegate.m415a(this);
        }
        this.f458K = true;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return createView(view, str, context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f474d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.AppCompatDelegate.m417c(r3)
        L_0x0009:
            boolean r0 = r3.f467T
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f476f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f469V
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 0
            r3.f459L = r0
            r0 = 1
            r3.f460M = r0
            int r0 = r3.f461N
            r1 = -100
            if (r0 == r1) goto L_0x0048
            java.lang.Object r0 = r3.f474d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0048
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0048
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = f442a0
            java.lang.Object r1 = r3.f474d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f461N
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0057
        L_0x0048:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = f442a0
            java.lang.Object r1 = r3.f474d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0057:
            androidx.appcompat.app.ActionBar r0 = r3.f479i
            if (r0 == 0) goto L_0x005e
            r0.mo803a()
        L_0x005e:
            r3.m442k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        PanelFeatureState v;
        Window.Callback C = mo1094C();
        if (C == null || this.f460M || (v = mo1119v(menuBuilder.getRootMenu())) == null) {
            return false;
        }
        return C.onMenuItemSelected(v.f497a, menuItem);
    }

    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        m430X(true);
    }

    public void onPostCreate(Bundle bundle) {
        m445t();
    }

    public void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.f459L = true;
        applyDayNight();
    }

    public void onStop() {
        this.f459L = false;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo1115p() {
        MenuBuilder menuBuilder;
        DecorContentParent decorContentParent = this.f482l;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.f487q != null) {
            this.f476f.getDecorView().removeCallbacks(this.f488r);
            if (this.f487q.isShowing()) {
                try {
                    this.f487q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f487q = null;
        }
        mo1118s();
        PanelFeatureState A = mo1092A(0, false);
        if (A != null && (menuBuilder = A.f506j) != null) {
            menuBuilder.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo1116q(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f474d;
        boolean z = true;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof AppCompatDialog)) && (decorView = this.f476f.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f477g.getWrapped().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo1097L(keyCode, keyEvent) : mo1099O(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo1117r(int i) {
        PanelFeatureState A;
        PanelFeatureState A2 = mo1092A(i, true);
        if (A2.f506j != null) {
            Bundle bundle = new Bundle();
            A2.f506j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                A2.f514r = bundle;
            }
            A2.f506j.stopDispatchingItemsChanged();
            A2.f506j.clear();
        }
        A2.f513q = true;
        A2.f512p = true;
        if ((i == 108 || i == 0) && this.f482l != null && (A = mo1092A(0, false)) != null) {
            A.f509m = false;
            m429W(A, (KeyEvent) null);
        }
    }

    public boolean requestWindowFeature(int i) {
        int Y = m431Y(i);
        if (this.f452E && Y == 108) {
            return false;
        }
        if (this.f448A && Y == 1) {
            this.f448A = false;
        }
        if (Y == 1) {
            m433c0();
            this.f452E = true;
            return true;
        } else if (Y == 2) {
            m433c0();
            this.f495y = true;
            return true;
        } else if (Y == 5) {
            m433c0();
            this.f496z = true;
            return true;
        } else if (Y == 10) {
            m433c0();
            this.f450C = true;
            return true;
        } else if (Y == 108) {
            m433c0();
            this.f448A = true;
            return true;
        } else if (Y != 109) {
            return this.f476f.requestFeature(Y);
        } else {
            m433c0();
            this.f449B = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo1118s() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f489s;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public void setContentView(View view) {
        m445t();
        ViewGroup viewGroup = (ViewGroup) this.f492v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f477g.getWrapped().onContentChanged();
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.f490t = z;
    }

    @RequiresApi(17)
    public void setLocalNightMode(int i) {
        if (this.f461N != i) {
            this.f461N = i;
            if (this.f457J) {
                applyDayNight();
            }
        }
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.f474d instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (!(supportActionBar instanceof WindowDecorActionBar)) {
                this.f480j = null;
                if (supportActionBar != null) {
                    supportActionBar.mo803a();
                }
                if (toolbar != null) {
                    C0183d dVar = new C0183d(toolbar, mo1093B(), this.f477g);
                    this.f479i = dVar;
                    this.f476f.setCallback(dVar.mo1231c());
                } else {
                    this.f479i = null;
                    this.f476f.setCallback(this.f477g);
                }
                invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public void setTheme(@StyleRes int i) {
        this.f462O = i;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f481k = charSequence;
        DecorContentParent decorContentParent = this.f482l;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (mo1103U() != null) {
            mo1103U().setWindowTitle(charSequence);
        } else {
            TextView textView = this.f493w;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
        AppCompatCallback appCompatCallback;
        if (callback != null) {
            ActionMode actionMode = this.f485o;
            if (actionMode != null) {
                actionMode.finish();
            }
            C0161j jVar = new C0161j(callback);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                ActionMode startActionMode = supportActionBar.startActionMode(jVar);
                this.f485o = startActionMode;
                if (!(startActionMode == null || (appCompatCallback = this.f478h) == null)) {
                    appCompatCallback.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.f485o == null) {
                this.f485o = mo1105b0(jVar);
            }
            return this.f485o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public PanelFeatureState mo1119v(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f454G;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f506j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public final Context mo1120x() {
        ActionBar supportActionBar = getSupportActionBar();
        Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
        return themedContext == null ? this.f475e : themedContext;
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$k */
    class C0163k extends WindowCallbackWrapper {
        C0163k(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final android.view.ActionMode mo1141a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.f475e, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.mo1116q(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.mo1098N(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.mo1100Q(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.mo1101R(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @RequiresApi(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder;
            PanelFeatureState A = AppCompatDelegateImpl.this.mo1092A(0, true);
            if (A == null || (menuBuilder = A.f506j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) {
                return mo1141a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @RequiresApi(23)
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return mo1141a(callback);
        }
    }

    AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, (Window) null, appCompatCallback, activity);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0032, code lost:
        r3 = f442a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.AppCompatCallback r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f489s = r0
            r0 = 1
            r2.f490t = r0
            r0 = -100
            r2.f461N = r0
            androidx.appcompat.app.AppCompatDelegateImpl$b r1 = new androidx.appcompat.app.AppCompatDelegateImpl$b
            r1.<init>()
            r2.f469V = r1
            r2.f475e = r3
            r2.f478h = r5
            r2.f474d = r6
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x002e
            androidx.appcompat.app.AppCompatActivity r3 = r2.m434d0()
            if (r3 == 0) goto L_0x002e
            androidx.appcompat.app.AppCompatDelegate r3 = r3.getDelegate()
            int r3 = r3.getLocalNightMode()
            r2.f461N = r3
        L_0x002e:
            int r3 = r2.f461N
            if (r3 != r0) goto L_0x0055
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r3 = f442a0
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0055
            int r5 = r5.intValue()
            r2.f461N = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0055:
            if (r4 == 0) goto L_0x005a
            r2.m439g(r4)
        L_0x005a:
            androidx.appcompat.widget.AppCompatDrawableManager.preload()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.AppCompatCallback, java.lang.Object):void");
    }

    public void setContentView(int i) {
        m445t();
        ViewGroup viewGroup = (ViewGroup) this.f492v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f475e).inflate(i, viewGroup);
        this.f477g.getWrapped().onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m445t();
        ViewGroup viewGroup = (ViewGroup) this.f492v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f477g.getWrapped().onContentChanged();
    }
}
