package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.C0179a;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private final Delegate f344a;

    /* renamed from: b */
    private final DrawerLayout f345b;

    /* renamed from: c */
    private DrawerArrowDrawable f346c;

    /* renamed from: d */
    private boolean f347d;

    /* renamed from: e */
    private Drawable f348e;

    /* renamed from: f */
    boolean f349f;

    /* renamed from: g */
    private boolean f350g;

    /* renamed from: h */
    private final int f351h;

    /* renamed from: i */
    private final int f352i;

    /* renamed from: j */
    View.OnClickListener f353j;

    /* renamed from: k */
    private boolean f354k;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$a */
    class C0135a implements View.OnClickListener {
        C0135a() {
        }

        public void onClick(View view) {
            ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
            if (actionBarDrawerToggle.f349f) {
                actionBarDrawerToggle.mo903e();
                return;
            }
            View.OnClickListener onClickListener = actionBarDrawerToggle.f353j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$b */
    private static class C0136b implements Delegate {

        /* renamed from: a */
        private final Activity f356a;

        /* renamed from: b */
        private C0179a.C0180a f357b;

        C0136b(Activity activity) {
            this.f356a = activity;
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.f356a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f356a;
        }

        public Drawable getThemeUpIndicator() {
            if (Build.VERSION.SDK_INT < 18) {
                return C0179a.m517a(this.f356a);
            }
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f356a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarDescription(int i) {
            if (Build.VERSION.SDK_INT >= 18) {
                ActionBar actionBar = this.f356a.getActionBar();
                if (actionBar != null) {
                    actionBar.setHomeActionContentDescription(i);
                    return;
                }
                return;
            }
            this.f357b = C0179a.m518b(this.f357b, this.f356a, i);
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar actionBar = this.f356a.getActionBar();
            if (actionBar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
                return;
            }
            actionBar.setDisplayShowHomeEnabled(true);
            this.f357b = C0179a.m519c(this.f356a, drawable, i);
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    /* renamed from: androidx.appcompat.app.ActionBarDrawerToggle$c */
    static class C0137c implements Delegate {

        /* renamed from: a */
        final Toolbar f358a;

        /* renamed from: b */
        final Drawable f359b;

        /* renamed from: c */
        final CharSequence f360c;

        C0137c(Toolbar toolbar) {
            this.f358a = toolbar;
            this.f359b = toolbar.getNavigationIcon();
            this.f360c = toolbar.getNavigationContentDescription();
        }

        public Context getActionBarThemedContext() {
            return this.f358a.getContext();
        }

        public Drawable getThemeUpIndicator() {
            return this.f359b;
        }

        public boolean isNavigationVisible() {
            return true;
        }

        public void setActionBarDescription(@StringRes int i) {
            if (i == 0) {
                this.f358a.setNavigationContentDescription(this.f360c);
            } else {
                this.f358a.setNavigationContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
            this.f358a.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i, @StringRes int i2) {
        this(activity, (Toolbar) null, drawerLayout, (DrawerArrowDrawable) null, i, i2);
    }

    /* renamed from: d */
    private void m378d(float f) {
        if (f == 1.0f) {
            this.f346c.setVerticalMirror(true);
        } else if (f == 0.0f) {
            this.f346c.setVerticalMirror(false);
        }
        this.f346c.setProgress(f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo900a() {
        return this.f344a.getThemeUpIndicator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo901b(int i) {
        this.f344a.setActionBarDescription(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo902c(Drawable drawable, int i) {
        if (!this.f354k && !this.f344a.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f354k = true;
        }
        this.f344a.setActionBarUpIndicator(drawable, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo903e() {
        int drawerLockMode = this.f345b.getDrawerLockMode((int) GravityCompat.START);
        if (this.f345b.isDrawerVisible((int) GravityCompat.START) && drawerLockMode != 2) {
            this.f345b.closeDrawer((int) GravityCompat.START);
        } else if (drawerLockMode != 1) {
            this.f345b.openDrawer((int) GravityCompat.START);
        }
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.f346c;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.f353j;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f349f;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.f347d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f350g) {
            this.f348e = mo900a();
        }
        syncState();
    }

    public void onDrawerClosed(View view) {
        m378d(0.0f);
        if (this.f349f) {
            mo901b(this.f351h);
        }
    }

    public void onDrawerOpened(View view) {
        m378d(1.0f);
        if (this.f349f) {
            mo901b(this.f352i);
        }
    }

    public void onDrawerSlide(View view, float f) {
        if (this.f347d) {
            m378d(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            m378d(0.0f);
        }
    }

    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f349f) {
            return false;
        }
        mo903e();
        return true;
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.f346c = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f349f) {
            if (z) {
                mo902c(this.f346c, this.f345b.isDrawerOpen((int) GravityCompat.START) ? this.f352i : this.f351h);
            } else {
                mo902c(this.f348e, 0);
            }
            this.f349f = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.f347d = z;
        if (!z) {
            m378d(0.0f);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f348e = mo900a();
            this.f350g = false;
        } else {
            this.f348e = drawable;
            this.f350g = true;
        }
        if (!this.f349f) {
            mo902c(this.f348e, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.f353j = onClickListener;
    }

    public void syncState() {
        if (this.f345b.isDrawerOpen((int) GravityCompat.START)) {
            m378d(1.0f);
        } else {
            m378d(0.0f);
        }
        if (this.f349f) {
            mo902c(this.f346c, this.f345b.isDrawerOpen((int) GravityCompat.START) ? this.f352i : this.f351h);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i, @StringRes int i2) {
        this(activity, toolbar, drawerLayout, (DrawerArrowDrawable) null, i, i2);
    }

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i, @StringRes int i2) {
        this.f347d = true;
        this.f349f = true;
        this.f354k = false;
        if (toolbar != null) {
            this.f344a = new C0137c(toolbar);
            toolbar.setNavigationOnClickListener(new C0135a());
        } else if (activity instanceof DelegateProvider) {
            this.f344a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f344a = new C0136b(activity);
        }
        this.f345b = drawerLayout;
        this.f351h = i;
        this.f352i = i2;
        if (drawerArrowDrawable == null) {
            this.f346c = new DrawerArrowDrawable(this.f344a.getActionBarThemedContext());
        } else {
            this.f346c = drawerArrowDrawable;
        }
        this.f348e = mo900a();
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? this.f345b.getResources().getDrawable(i) : null);
    }
}
