package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.app.a */
/* compiled from: ActionBarDrawerToggleHoneycomb */
class C0179a {

    /* renamed from: a */
    private static final int[] f599a = {16843531};

    /* renamed from: androidx.appcompat.app.a$a */
    /* compiled from: ActionBarDrawerToggleHoneycomb */
    static class C0180a {

        /* renamed from: a */
        public Method f600a;

        /* renamed from: b */
        public Method f601b;

        /* renamed from: c */
        public ImageView f602c;

        C0180a(Activity activity) {
            try {
                this.f600a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f601b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                        if (childAt instanceof ImageView) {
                            this.f602c = (ImageView) childAt;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static Drawable m517a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f599a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    /* renamed from: b */
    public static C0180a m518b(C0180a aVar, Activity activity, int i) {
        if (aVar == null) {
            aVar = new C0180a(activity);
        }
        if (aVar.f600a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f601b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (Build.VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHC", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return aVar;
    }

    /* renamed from: c */
    public static C0180a m519c(Activity activity, Drawable drawable, int i) {
        C0180a aVar = new C0180a(activity);
        if (aVar.f600a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                aVar.f600a.invoke(actionBar, new Object[]{drawable});
                aVar.f601b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else {
            ImageView imageView = aVar.f602c;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            } else {
                Log.w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator");
            }
        }
        return aVar;
    }
}
