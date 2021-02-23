package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: m */
    private static final int[] f3433m = {16843531};

    /* renamed from: a */
    final Activity f3434a;

    /* renamed from: b */
    private final Delegate f3435b;

    /* renamed from: c */
    private final DrawerLayout f3436c;

    /* renamed from: d */
    private boolean f3437d;

    /* renamed from: e */
    private boolean f3438e;

    /* renamed from: f */
    private Drawable f3439f;

    /* renamed from: g */
    private Drawable f3440g;

    /* renamed from: h */
    private C0729b f3441h;

    /* renamed from: i */
    private final int f3442i;

    /* renamed from: j */
    private final int f3443j;

    /* renamed from: k */
    private final int f3444k;

    /* renamed from: l */
    private C0728a f3445l;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: androidx.legacy.app.ActionBarDrawerToggle$a */
    private static class C0728a {

        /* renamed from: a */
        Method f3446a;

        /* renamed from: b */
        Method f3447b;

        /* renamed from: c */
        ImageView f3448c;

        C0728a(Activity activity) {
            try {
                this.f3446a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f3447b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                        if (childAt instanceof ImageView) {
                            this.f3448c = (ImageView) childAt;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: androidx.legacy.app.ActionBarDrawerToggle$b */
    private class C0729b extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a */
        private final boolean f3449a;

        /* renamed from: b */
        private final Rect f3450b;

        /* renamed from: c */
        private float f3451c;

        /* renamed from: d */
        private float f3452d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0729b(Drawable drawable) {
            super(drawable, 0);
            boolean z = false;
            this.f3449a = Build.VERSION.SDK_INT > 18 ? true : z;
            this.f3450b = new Rect();
        }

        /* renamed from: a */
        public float mo6174a() {
            return this.f3451c;
        }

        /* renamed from: b */
        public void mo6175b(float f) {
            this.f3452d = f;
            invalidateSelf();
        }

        /* renamed from: c */
        public void mo6176c(float f) {
            this.f3451c = f;
            invalidateSelf();
        }

        public void draw(@NonNull Canvas canvas) {
            copyBounds(this.f3450b);
            canvas.save();
            int i = 1;
            boolean z = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.f3434a.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            float width = (float) this.f3450b.width();
            canvas.translate((-this.f3452d) * width * this.f3451c * ((float) i), 0.0f);
            if (z && !this.f3449a) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        this(activity, drawerLayout, !m2534a(activity), i, i2, i3);
    }

    /* renamed from: a */
    private static boolean m2534a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: b */
    private Drawable m2535b() {
        Context context;
        Delegate delegate = this.f3435b;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f3434a.getActionBar();
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = this.f3434a;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f3433m, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        TypedArray obtainStyledAttributes2 = this.f3434a.obtainStyledAttributes(f3433m);
        Drawable drawable2 = obtainStyledAttributes2.getDrawable(0);
        obtainStyledAttributes2.recycle();
        return drawable2;
    }

    /* renamed from: c */
    private void m2536c(int i) {
        Delegate delegate = this.f3435b;
        if (delegate != null) {
            delegate.setActionBarDescription(i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f3434a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        } else {
            if (this.f3445l == null) {
                this.f3445l = new C0728a(this.f3434a);
            }
            if (this.f3445l.f3446a != null) {
                try {
                    ActionBar actionBar2 = this.f3434a.getActionBar();
                    this.f3445l.f3447b.invoke(actionBar2, new Object[]{Integer.valueOf(i)});
                    actionBar2.setSubtitle(actionBar2.getSubtitle());
                } catch (Exception e) {
                    Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", e);
                }
            }
        }
    }

    /* renamed from: d */
    private void m2537d(Drawable drawable, int i) {
        Delegate delegate = this.f3435b;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f3434a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        } else {
            if (this.f3445l == null) {
                this.f3445l = new C0728a(this.f3434a);
            }
            C0728a aVar = this.f3445l;
            if (aVar.f3446a != null) {
                try {
                    ActionBar actionBar2 = this.f3434a.getActionBar();
                    this.f3445l.f3446a.invoke(actionBar2, new Object[]{drawable});
                    this.f3445l.f3447b.invoke(actionBar2, new Object[]{Integer.valueOf(i)});
                } catch (Exception e) {
                    Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", e);
                }
            } else {
                ImageView imageView = aVar.f3448c;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                } else {
                    Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
                }
            }
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f3437d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f3438e) {
            this.f3439f = m2535b();
        }
        this.f3440g = ContextCompat.getDrawable(this.f3434a, this.f3442i);
        syncState();
    }

    public void onDrawerClosed(View view) {
        this.f3441h.mo6176c(0.0f);
        if (this.f3437d) {
            m2536c(this.f3443j);
        }
    }

    public void onDrawerOpened(View view) {
        this.f3441h.mo6176c(1.0f);
        if (this.f3437d) {
            m2536c(this.f3444k);
        }
    }

    public void onDrawerSlide(View view, float f) {
        float f2;
        float a = this.f3441h.mo6174a();
        if (f > 0.5f) {
            f2 = Math.max(a, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            f2 = Math.min(a, f * 2.0f);
        }
        this.f3441h.mo6176c(f2);
    }

    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f3437d) {
            return false;
        }
        if (this.f3436c.isDrawerVisible((int) GravityCompat.START)) {
            this.f3436c.closeDrawer((int) GravityCompat.START);
            return true;
        }
        this.f3436c.openDrawer((int) GravityCompat.START);
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f3437d) {
            if (z) {
                m2537d(this.f3441h, this.f3436c.isDrawerOpen((int) GravityCompat.START) ? this.f3444k : this.f3443j);
            } else {
                m2537d(this.f3439f, 0);
            }
            this.f3437d = z;
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f3439f = m2535b();
            this.f3438e = false;
        } else {
            this.f3439f = drawable;
            this.f3438e = true;
        }
        if (!this.f3437d) {
            m2537d(this.f3439f, 0);
        }
    }

    public void syncState() {
        if (this.f3436c.isDrawerOpen((int) GravityCompat.START)) {
            this.f3441h.mo6176c(1.0f);
        } else {
            this.f3441h.mo6176c(0.0f);
        }
        if (this.f3437d) {
            m2537d(this.f3441h, this.f3436c.isDrawerOpen((int) GravityCompat.START) ? this.f3444k : this.f3443j);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        this.f3437d = true;
        this.f3434a = activity;
        if (activity instanceof DelegateProvider) {
            this.f3435b = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f3435b = null;
        }
        this.f3436c = drawerLayout;
        this.f3442i = i;
        this.f3443j = i2;
        this.f3444k = i3;
        this.f3439f = m2535b();
        this.f3440g = ContextCompat.getDrawable(activity, i);
        C0729b bVar = new C0729b(this.f3440g);
        this.f3441h = bVar;
        bVar.mo6175b(z ? 0.33333334f : 0.0f);
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? ContextCompat.getDrawable(this.f3434a, i) : null);
    }
}
