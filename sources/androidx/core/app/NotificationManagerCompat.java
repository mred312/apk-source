package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.p000v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    /* renamed from: c */
    private static final Object f2147c = new Object();
    @GuardedBy("sEnabledNotificationListenersLock")

    /* renamed from: d */
    private static String f2148d;
    @GuardedBy("sEnabledNotificationListenersLock")

    /* renamed from: e */
    private static Set<String> f2149e = new HashSet();

    /* renamed from: f */
    private static final Object f2150f = new Object();
    @GuardedBy("sLock")

    /* renamed from: g */
    private static C0427d f2151g;

    /* renamed from: a */
    private final Context f2152a;

    /* renamed from: b */
    private final NotificationManager f2153b;

    /* renamed from: androidx.core.app.NotificationManagerCompat$b */
    private static class C0425b implements C0429e {

        /* renamed from: a */
        final String f2158a;

        /* renamed from: b */
        final int f2159b;

        /* renamed from: c */
        final String f2160c;

        /* renamed from: d */
        final Notification f2161d;

        C0425b(String str, int i, String str2, Notification notification) {
            this.f2158a = str;
            this.f2159b = i;
            this.f2160c = str2;
            this.f2161d = notification;
        }

        /* renamed from: a */
        public void mo3947a(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.notify(this.f2158a, this.f2159b, this.f2160c, this.f2161d);
        }

        @NonNull
        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f2158a + ", id:" + this.f2159b + ", tag:" + this.f2160c + "]";
        }
    }

    /* renamed from: androidx.core.app.NotificationManagerCompat$c */
    private static class C0426c {

        /* renamed from: a */
        final ComponentName f2162a;

        /* renamed from: b */
        final IBinder f2163b;

        C0426c(ComponentName componentName, IBinder iBinder) {
            this.f2162a = componentName;
            this.f2163b = iBinder;
        }
    }

    /* renamed from: androidx.core.app.NotificationManagerCompat$d */
    private static class C0427d implements Handler.Callback, ServiceConnection {

        /* renamed from: a */
        private final Context f2164a;

        /* renamed from: b */
        private final HandlerThread f2165b;

        /* renamed from: c */
        private final Handler f2166c;

        /* renamed from: d */
        private final Map<ComponentName, C0428a> f2167d = new HashMap();

        /* renamed from: e */
        private Set<String> f2168e = new HashSet();

        /* renamed from: androidx.core.app.NotificationManagerCompat$d$a */
        private static class C0428a {

            /* renamed from: a */
            final ComponentName f2169a;

            /* renamed from: b */
            boolean f2170b = false;

            /* renamed from: c */
            INotificationSideChannel f2171c;

            /* renamed from: d */
            ArrayDeque<C0429e> f2172d = new ArrayDeque<>();

            /* renamed from: e */
            int f2173e = 0;

            C0428a(ComponentName componentName) {
                this.f2169a = componentName;
            }
        }

        C0427d(Context context) {
            this.f2164a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f2165b = handlerThread;
            handlerThread.start();
            this.f2166c = new Handler(handlerThread.getLooper(), this);
        }

        /* renamed from: a */
        private boolean m1413a(C0428a aVar) {
            if (aVar.f2170b) {
                return true;
            }
            boolean bindService = this.f2164a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(aVar.f2169a), this, 33);
            aVar.f2170b = bindService;
            if (bindService) {
                aVar.f2173e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f2169a);
                this.f2164a.unbindService(this);
            }
            return aVar.f2170b;
        }

        /* renamed from: b */
        private void m1414b(C0428a aVar) {
            if (aVar.f2170b) {
                this.f2164a.unbindService(this);
                aVar.f2170b = false;
            }
            aVar.f2171c = null;
        }

        /* renamed from: c */
        private void m1415c(C0429e eVar) {
            m1421j();
            for (C0428a next : this.f2167d.values()) {
                next.f2172d.add(eVar);
                m1419g(next);
            }
        }

        /* renamed from: d */
        private void m1416d(ComponentName componentName) {
            C0428a aVar = this.f2167d.get(componentName);
            if (aVar != null) {
                m1419g(aVar);
            }
        }

        /* renamed from: e */
        private void m1417e(ComponentName componentName, IBinder iBinder) {
            C0428a aVar = this.f2167d.get(componentName);
            if (aVar != null) {
                aVar.f2171c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f2173e = 0;
                m1419g(aVar);
            }
        }

        /* renamed from: f */
        private void m1418f(ComponentName componentName) {
            C0428a aVar = this.f2167d.get(componentName);
            if (aVar != null) {
                m1414b(aVar);
            }
        }

        /* renamed from: g */
        private void m1419g(C0428a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f2169a + ", " + aVar.f2172d.size() + " queued tasks");
            }
            if (!aVar.f2172d.isEmpty()) {
                if (!m1413a(aVar) || aVar.f2171c == null) {
                    m1420i(aVar);
                    return;
                }
                while (true) {
                    C0429e peek = aVar.f2172d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.mo3947a(aVar.f2171c);
                        aVar.f2172d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f2169a);
                        }
                    } catch (RemoteException e) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f2169a, e);
                    }
                }
                if (!aVar.f2172d.isEmpty()) {
                    m1420i(aVar);
                }
            }
        }

        /* renamed from: i */
        private void m1420i(C0428a aVar) {
            if (!this.f2166c.hasMessages(3, aVar.f2169a)) {
                int i = aVar.f2173e + 1;
                aVar.f2173e = i;
                if (i > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f2172d.size() + " tasks to " + aVar.f2169a + " after " + aVar.f2173e + " retries");
                    aVar.f2172d.clear();
                    return;
                }
                int i2 = (1 << (i - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i2 + " ms");
                }
                this.f2166c.sendMessageDelayed(this.f2166c.obtainMessage(3, aVar.f2169a), (long) i2);
            }
        }

        /* renamed from: j */
        private void m1421j() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f2164a);
            if (!enabledListenerPackages.equals(this.f2168e)) {
                this.f2168e = enabledListenerPackages;
                List<ResolveInfo> queryIntentServices = this.f2164a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (enabledListenerPackages.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f2167d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f2167d.put(componentName2, new C0428a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, C0428a>> it = this.f2167d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next2 = it.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        m1414b((C0428a) next2.getValue());
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: h */
        public void mo3950h(C0429e eVar) {
            this.f2166c.obtainMessage(0, eVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                m1415c((C0429e) message.obj);
                return true;
            } else if (i == 1) {
                C0426c cVar = (C0426c) message.obj;
                m1417e(cVar.f2162a, cVar.f2163b);
                return true;
            } else if (i == 2) {
                m1418f((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                m1416d((ComponentName) message.obj);
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2166c.obtainMessage(1, new C0426c(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2166c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* renamed from: androidx.core.app.NotificationManagerCompat$e */
    private interface C0429e {
        /* renamed from: a */
        void mo3947a(INotificationSideChannel iNotificationSideChannel);
    }

    private NotificationManagerCompat(Context context) {
        this.f2152a = context;
        this.f2153b = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    private void m1409a(C0429e eVar) {
        synchronized (f2150f) {
            if (f2151g == null) {
                f2151g = new C0427d(this.f2152a.getApplicationContext());
            }
            f2151g.mo3950h(eVar);
        }
    }

    /* renamed from: b */
    private static boolean m1410b(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f2147c) {
            if (string != null) {
                if (!string.equals(f2148d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f2149e = hashSet;
                    f2148d = string;
                }
            }
            set = f2149e;
        }
        return set;
    }

    public boolean areNotificationsEnabled() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return this.f2153b.areNotificationsEnabled();
        }
        if (i < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2152a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2152a.getApplicationInfo();
        String packageName = this.f2152a.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void cancel(int i) {
        cancel((String) null, i);
    }

    public void cancelAll() {
        this.f2153b.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            m1409a(new C0424a(this.f2152a.getPackageName()));
        }
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2153b.createNotificationChannel(notificationChannel);
        }
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2153b.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2153b.createNotificationChannelGroups(list);
        }
    }

    public void createNotificationChannelGroupsCompat(@NonNull List<NotificationChannelGroupCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelGroupCompat a : list) {
                arrayList.add(a.mo3674a());
            }
            this.f2153b.createNotificationChannelGroups(arrayList);
        }
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2153b.createNotificationChannels(list);
        }
    }

    public void createNotificationChannelsCompat(@NonNull List<NotificationChannelCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelCompat a : list) {
                arrayList.add(a.mo3647a());
            }
            this.f2153b.createNotificationChannels(arrayList);
        }
    }

    public void deleteNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2153b.deleteNotificationChannel(str);
        }
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2153b.deleteNotificationChannelGroup(str);
        }
    }

    public void deleteUnlistedNotificationChannels(@NonNull Collection<String> collection) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            for (NotificationChannel next : this.f2153b.getNotificationChannels()) {
                if (!collection.contains(next.getId()) && (i < 30 || !collection.contains(next.getParentChannelId()))) {
                    this.f2153b.deleteNotificationChannel(next.getId());
                }
            }
        }
    }

    public int getImportance() {
        return Build.VERSION.SDK_INT >= 24 ? this.f2153b.getImportance() : IMPORTANCE_UNSPECIFIED;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2153b.getNotificationChannel(str);
        }
        return null;
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return this.f2153b.getNotificationChannelGroup(str);
        }
        if (i >= 26) {
            for (NotificationChannelGroup next : getNotificationChannelGroups()) {
                if (next.getId().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2153b.getNotificationChannelGroups();
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2153b.getNotificationChannels();
        }
        return Collections.emptyList();
    }

    public void notify(int i, @NonNull Notification notification) {
        notify((String) null, i, notification);
    }

    public void cancel(@Nullable String str, int i) {
        this.f2153b.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            m1409a(new C0424a(this.f2152a.getPackageName(), i, str));
        }
    }

    public void notify(@Nullable String str, int i, @NonNull Notification notification) {
        if (m1410b(notification)) {
            m1409a(new C0425b(this.f2152a.getPackageName(), i, str, notification));
            this.f2153b.cancel(str, i);
            return;
        }
        this.f2153b.notify(str, i, notification);
    }

    public void createNotificationChannel(@NonNull NotificationChannelCompat notificationChannelCompat) {
        createNotificationChannel(notificationChannelCompat.mo3647a());
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroupCompat notificationChannelGroupCompat) {
        createNotificationChannelGroup(notificationChannelGroupCompat.mo3674a());
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return this.f2153b.getNotificationChannel(str, str2);
        }
        return getNotificationChannel(str);
    }

    /* renamed from: androidx.core.app.NotificationManagerCompat$a */
    private static class C0424a implements C0429e {

        /* renamed from: a */
        final String f2154a;

        /* renamed from: b */
        final int f2155b;

        /* renamed from: c */
        final String f2156c;

        /* renamed from: d */
        final boolean f2157d;

        C0424a(String str) {
            this.f2154a = str;
            this.f2155b = 0;
            this.f2156c = null;
            this.f2157d = true;
        }

        /* renamed from: a */
        public void mo3947a(INotificationSideChannel iNotificationSideChannel) {
            if (this.f2157d) {
                iNotificationSideChannel.cancelAll(this.f2154a);
            } else {
                iNotificationSideChannel.cancel(this.f2154a, this.f2155b, this.f2156c);
            }
        }

        @NonNull
        public String toString() {
            return "CancelTask[" + "packageName:" + this.f2154a + ", id:" + this.f2155b + ", tag:" + this.f2156c + ", all:" + this.f2157d + "]";
        }

        C0424a(String str, int i, String str2) {
            this.f2154a = str;
            this.f2155b = i;
            this.f2156c = str2;
            this.f2157d = false;
        }
    }
}
