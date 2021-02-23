package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {

    /* renamed from: a */
    private static Field f2630a;

    /* renamed from: b */
    private static boolean f2631b;

    /* renamed from: androidx.core.view.LayoutInflaterCompat$a */
    static class C0530a implements LayoutInflater.Factory2 {

        /* renamed from: a */
        final LayoutInflaterFactory f2632a;

        C0530a(LayoutInflaterFactory layoutInflaterFactory) {
            this.f2632a = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f2632a.onCreateView((View) null, str, context, attributeSet);
        }

        @NonNull
        public String toString() {
            return C0530a.class.getName() + "{" + this.f2632a + "}";
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f2632a.onCreateView(view, str, context, attributeSet);
        }
    }

    private LayoutInflaterCompat() {
    }

    /* renamed from: a */
    private static void m1730a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2631b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f2630a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f2631b = true;
        }
        Field field = f2630a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof C0530a) {
            return ((C0530a) factory).f2632a;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        C0530a aVar = null;
        if (Build.VERSION.SDK_INT >= 21) {
            if (layoutInflaterFactory != null) {
                aVar = new C0530a(layoutInflaterFactory);
            }
            layoutInflater.setFactory2(aVar);
            return;
        }
        if (layoutInflaterFactory != null) {
            aVar = new C0530a(layoutInflaterFactory);
        }
        layoutInflater.setFactory2(aVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            m1730a(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            m1730a(layoutInflater, aVar);
        }
    }

    public static void setFactory2(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                m1730a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                m1730a(layoutInflater, factory2);
            }
        }
    }
}
