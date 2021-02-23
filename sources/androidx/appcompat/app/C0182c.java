package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: androidx.appcompat.app.c */
/* compiled from: ResourcesFlusher */
class C0182c {

    /* renamed from: a */
    private static Field f604a;

    /* renamed from: b */
    private static boolean f605b;

    /* renamed from: c */
    private static Class<?> f606c;

    /* renamed from: d */
    private static boolean f607d;

    /* renamed from: e */
    private static Field f608e;

    /* renamed from: f */
    private static boolean f609f;

    /* renamed from: g */
    private static Field f610g;

    /* renamed from: h */
    private static boolean f611h;

    /* renamed from: a */
    static void m520a(@NonNull Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            if (i >= 24) {
                m523d(resources);
            } else if (i >= 23) {
                m522c(resources);
            } else if (i >= 21) {
                m521b(resources);
            }
        }
    }

    @RequiresApi(21)
    /* renamed from: b */
    private static void m521b(@NonNull Resources resources) {
        if (!f605b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f604a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f605b = true;
        }
        Field field = f604a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    @RequiresApi(23)
    /* renamed from: c */
    private static void m522c(@NonNull Resources resources) {
        if (!f605b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f604a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f605b = true;
        }
        Object obj = null;
        Field field = f604a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj != null) {
            m524e(obj);
        }
    }

    @RequiresApi(24)
    /* renamed from: d */
    private static void m523d(@NonNull Resources resources) {
        Object obj;
        if (!f611h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f610g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f611h = true;
        }
        Field field = f610g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                obj = null;
            }
            if (obj != null) {
                if (!f605b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f604a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e3) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                    }
                    f605b = true;
                }
                Field field2 = f604a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                    }
                }
                if (obj2 != null) {
                    m524e(obj2);
                }
            }
        }
    }

    @RequiresApi(16)
    /* renamed from: e */
    private static void m524e(@NonNull Object obj) {
        if (!f607d) {
            try {
                f606c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f607d = true;
        }
        Class<?> cls = f606c;
        if (cls != null) {
            if (!f609f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f608e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                f609f = true;
            }
            Field field = f608e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
