package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RequiresApi(16)
/* renamed from: androidx.core.app.c */
/* compiled from: NotificationCompatJellybean */
class C0436c {

    /* renamed from: a */
    private static final Object f2241a = new Object();

    /* renamed from: b */
    private static Field f2242b;

    /* renamed from: c */
    private static boolean f2243c;

    /* renamed from: d */
    private static final Object f2244d = new Object();

    /* renamed from: e */
    private static Field f2245e;

    /* renamed from: f */
    private static Field f2246f;

    /* renamed from: g */
    private static Field f2247g;

    /* renamed from: h */
    private static Field f2248h;

    /* renamed from: i */
    private static boolean f2249i;

    /* renamed from: a */
    public static SparseArray<Bundle> m1453a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: b */
    private static boolean m1454b() {
        if (f2249i) {
            return false;
        }
        try {
            if (f2245e == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                f2246f = cls.getDeclaredField("icon");
                f2247g = cls.getDeclaredField("title");
                f2248h = cls.getDeclaredField("actionIntent");
                Field declaredField = Notification.class.getDeclaredField("actions");
                f2245e = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e("NotificationCompat", "Unable to access notification actions", e);
            f2249i = true;
        } catch (NoSuchFieldException e2) {
            Log.e("NotificationCompat", "Unable to access notification actions", e2);
            f2249i = true;
        }
        return !f2249i;
    }

    /* renamed from: c */
    private static RemoteInput m1455c(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    /* renamed from: d */
    private static RemoteInput[] m1456d(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i = 0; i < bundleArr.length; i++) {
            remoteInputArr[i] = m1455c(bundleArr[i]);
        }
        return remoteInputArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r5 = r5.getSparseParcelableArray(androidx.core.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.app.NotificationCompat.Action m1457e(android.app.Notification r5, int r6) {
        /*
            java.lang.Object r0 = f2244d
            monitor-enter(r0)
            r1 = 0
            java.lang.Object[] r2 = m1460h(r5)     // Catch:{ IllegalAccessException -> 0x0040 }
            if (r2 == 0) goto L_0x004b
            r2 = r2[r6]     // Catch:{ IllegalAccessException -> 0x0040 }
            android.os.Bundle r5 = m1463k(r5)     // Catch:{ IllegalAccessException -> 0x0040 }
            if (r5 == 0) goto L_0x0021
            java.lang.String r3 = "android.support.actionExtras"
            android.util.SparseArray r5 = r5.getSparseParcelableArray(r3)     // Catch:{ IllegalAccessException -> 0x0040 }
            if (r5 == 0) goto L_0x0021
            java.lang.Object r5 = r5.get(r6)     // Catch:{ IllegalAccessException -> 0x0040 }
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch:{ IllegalAccessException -> 0x0040 }
            goto L_0x0022
        L_0x0021:
            r5 = r1
        L_0x0022:
            java.lang.reflect.Field r6 = f2246f     // Catch:{ IllegalAccessException -> 0x0040 }
            int r6 = r6.getInt(r2)     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.reflect.Field r3 = f2247g     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.reflect.Field r4 = f2248h     // Catch:{ IllegalAccessException -> 0x0040 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ IllegalAccessException -> 0x0040 }
            android.app.PendingIntent r2 = (android.app.PendingIntent) r2     // Catch:{ IllegalAccessException -> 0x0040 }
            androidx.core.app.NotificationCompat$Action r5 = m1464l(r6, r3, r2, r5)     // Catch:{ IllegalAccessException -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r5
        L_0x003e:
            r5 = move-exception
            goto L_0x004d
        L_0x0040:
            r5 = move-exception
            java.lang.String r6 = "NotificationCompat"
            java.lang.String r2 = "Unable to access notification actions"
            android.util.Log.e(r6, r2, r5)     // Catch:{ all -> 0x003e }
            r5 = 1
            f2249i = r5     // Catch:{ all -> 0x003e }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r1
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.C0436c.m1457e(android.app.Notification, int):androidx.core.app.NotificationCompat$Action");
    }

    /* renamed from: f */
    public static int m1458f(Notification notification) {
        int length;
        synchronized (f2244d) {
            Object[] h = m1460h(notification);
            length = h != null ? h.length : 0;
        }
        return length;
    }

    /* renamed from: g */
    static NotificationCompat.Action m1459g(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), m1456d(m1461i(bundle, "remoteInputs")), m1456d(m1461i(bundle, "dataOnlyRemoteInputs")), bundle2 != null ? bundle2.getBoolean("android.support.allowGeneratedReplies", false) : false, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false);
    }

    /* renamed from: h */
    private static Object[] m1460h(Notification notification) {
        synchronized (f2244d) {
            if (!m1454b()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) f2245e.get(notification);
                return objArr;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                f2249i = true;
                return null;
            }
        }
    }

    /* renamed from: i */
    private static Bundle[] m1461i(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    /* renamed from: j */
    static Bundle m1462j(NotificationCompat.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        bundle2.putInt("icon", iconCompat != null ? iconCompat.getResId() : 0);
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable("actionIntent", action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", m1466n(action.getRemoteInputs()));
        bundle2.putBoolean("showsUserInterface", action.getShowsUserInterface());
        bundle2.putInt("semanticAction", action.getSemanticAction());
        return bundle2;
    }

    /* renamed from: k */
    public static Bundle m1463k(Notification notification) {
        synchronized (f2241a) {
            if (f2243c) {
                return null;
            }
            try {
                if (f2242b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2243c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2242b = declaredField;
                }
                Bundle bundle = (Bundle) f2242b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2242b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f2243c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f2243c = true;
                return null;
            }
        }
    }

    /* renamed from: l */
    public static NotificationCompat.Action m1464l(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        boolean z;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        if (bundle != null) {
            remoteInputArr2 = m1456d(m1461i(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
            remoteInputArr = m1456d(m1461i(bundle, "android.support.dataRemoteInputs"));
            z = bundle.getBoolean("android.support.allowGeneratedReplies");
        } else {
            remoteInputArr2 = null;
            remoteInputArr = null;
            z = false;
        }
        return new NotificationCompat.Action(i, charSequence, pendingIntent, bundle, remoteInputArr2, remoteInputArr, z, 0, true, false);
    }

    /* renamed from: m */
    private static Bundle m1465m(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList arrayList = new ArrayList(allowedDataTypes.size());
            for (String add : allowedDataTypes) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: n */
    private static Bundle[] m1466n(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = m1465m(remoteInputArr[i]);
        }
        return bundleArr;
    }

    /* renamed from: o */
    public static Bundle m1467o(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat iconCompat = action.getIconCompat();
        builder.addAction(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, m1466n(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m1466n(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        return bundle;
    }
}
