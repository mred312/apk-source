package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.app.d */
/* compiled from: ToolbarActionBar */
class C0183d extends ActionBar {

    /* renamed from: a */
    DecorToolbar f612a;

    /* renamed from: b */
    boolean f613b;

    /* renamed from: c */
    Window.Callback f614c;

    /* renamed from: d */
    private boolean f615d;

    /* renamed from: e */
    private boolean f616e;

    /* renamed from: f */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f617f = new ArrayList<>();

    /* renamed from: g */
    private final Runnable f618g = new C0184a();

    /* renamed from: h */
    private final Toolbar.OnMenuItemClickListener f619h;

    /* renamed from: androidx.appcompat.app.d$a */
    /* compiled from: ToolbarActionBar */
    class C0184a implements Runnable {
        C0184a() {
        }

        public void run() {
            C0183d.this.mo1232d();
        }
    }

    /* renamed from: androidx.appcompat.app.d$b */
    /* compiled from: ToolbarActionBar */
    class C0185b implements Toolbar.OnMenuItemClickListener {
        C0185b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return C0183d.this.f614c.onMenuItemSelected(0, menuItem);
        }
    }

    /* renamed from: androidx.appcompat.app.d$c */
    /* compiled from: ToolbarActionBar */
    private final class C0186c implements MenuPresenter.Callback {

        /* renamed from: a */
        private boolean f622a;

        C0186c() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            if (!this.f622a) {
                this.f622a = true;
                C0183d.this.f612a.dismissPopupMenus();
                Window.Callback callback = C0183d.this.f614c;
                if (callback != null) {
                    callback.onPanelClosed(108, menuBuilder);
                }
                this.f622a = false;
            }
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            Window.Callback callback = C0183d.this.f614c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.d$d */
    /* compiled from: ToolbarActionBar */
    private final class C0187d implements MenuBuilder.Callback {
        C0187d() {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            C0183d dVar = C0183d.this;
            if (dVar.f614c == null) {
                return;
            }
            if (dVar.f612a.isOverflowMenuShowing()) {
                C0183d.this.f614c.onPanelClosed(108, menuBuilder);
            } else if (C0183d.this.f614c.onPreparePanel(0, (View) null, menuBuilder)) {
                C0183d.this.f614c.onMenuOpened(108, menuBuilder);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.d$e */
    /* compiled from: ToolbarActionBar */
    private class C0188e extends WindowCallbackWrapper {
        public C0188e(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(C0183d.this.f612a.getContext());
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                C0183d dVar = C0183d.this;
                if (!dVar.f613b) {
                    dVar.f612a.setMenuPrepared();
                    C0183d.this.f613b = true;
                }
            }
            return onPreparePanel;
        }
    }

    C0183d(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        C0185b bVar = new C0185b();
        this.f619h = bVar;
        this.f612a = new ToolbarWidgetWrapper(toolbar, false);
        C0188e eVar = new C0188e(callback);
        this.f614c = eVar;
        this.f612a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f612a.setWindowTitle(charSequence);
    }

    /* renamed from: b */
    private Menu m525b() {
        if (!this.f615d) {
            this.f612a.setMenuCallbacks(new C0186c(), new C0187d());
            this.f615d = true;
        }
        return this.f612a.getMenu();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo803a() {
        this.f612a.getViewGroup().removeCallbacks(this.f618g);
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f617f.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    /* renamed from: c */
    public Window.Callback mo1231c() {
        return this.f614c;
    }

    public boolean closeOptionsMenu() {
        return this.f612a.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        if (!this.f612a.hasExpandedActionView()) {
            return false;
        }
        this.f612a.collapseActionView();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo1232d() {
        Menu b = m525b();
        MenuBuilder menuBuilder = b instanceof MenuBuilder ? (MenuBuilder) b : null;
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        try {
            b.clear();
            if (!this.f614c.onCreatePanelMenu(0, b) || !this.f614c.onPreparePanel(0, (View) null, b)) {
                b.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.startDispatchingItemsChanged();
            }
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.f616e) {
            this.f616e = z;
            int size = this.f617f.size();
            for (int i = 0; i < size; i++) {
                this.f617f.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public View getCustomView() {
        return this.f612a.getCustomView();
    }

    public int getDisplayOptions() {
        return this.f612a.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.f612a.getViewGroup());
    }

    public int getHeight() {
        return this.f612a.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.f612a.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.f612a.getContext();
    }

    public CharSequence getTitle() {
        return this.f612a.getTitle();
    }

    public void hide() {
        this.f612a.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.f612a.getViewGroup().removeCallbacks(this.f618g);
        ViewCompat.postOnAnimation(this.f612a.getViewGroup(), this.f618g);
        return true;
    }

    public boolean isShowing() {
        return this.f612a.getVisibility() == 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu b = m525b();
        if (b == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        b.setQwertyMode(z);
        return b.performShortcut(i, keyEvent, 0);
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean openOptionsMenu() {
        return this.f612a.showOverflowMenu();
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f617f.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void selectTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.f612a.setBackgroundDrawable(drawable);
    }

    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
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
        ViewCompat.setElevation(this.f612a.getViewGroup(), f);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.f612a.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f612a.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        this.f612a.setIcon(i);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f612a.setDropdownParams(spinnerAdapter, new C0181b(onNavigationListener));
    }

    public void setLogo(int i) {
        this.f612a.setLogo(i);
    }

    public void setNavigationMode(int i) {
        if (i != 2) {
            this.f612a.setNavigationMode(i);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public void setSelectedNavigationItem(int i) {
        if (this.f612a.getNavigationMode() == 1) {
            this.f612a.setDropdownSelectedPosition(i);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f612a.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f612a.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.f612a.setWindowTitle(charSequence);
    }

    public void show() {
        this.f612a.setVisibility(0);
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f612a.setCustomView(view);
    }

    public void setDisplayOptions(int i, int i2) {
        this.f612a.setDisplayOptions((i & i2) | ((i2 ^ -1) & this.f612a.getDisplayOptions()));
    }

    public void setHomeActionContentDescription(int i) {
        this.f612a.setNavigationContentDescription(i);
    }

    public void setHomeAsUpIndicator(int i) {
        this.f612a.setNavigationIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f612a.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.f612a.setLogo(drawable);
    }

    public void setSubtitle(int i) {
        DecorToolbar decorToolbar = this.f612a;
        decorToolbar.setSubtitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    public void setTitle(int i) {
        DecorToolbar decorToolbar = this.f612a;
        decorToolbar.setTitle(i != 0 ? decorToolbar.getContext().getText(i) : null);
    }

    public void addTab(ActionBar.Tab tab, int i) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.f612a.getContext()).inflate(i, this.f612a.getViewGroup(), false));
    }
}
