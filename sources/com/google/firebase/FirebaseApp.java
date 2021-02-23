package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.p003os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseApp {
    @NonNull
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Object f18821j = new Object();

    /* renamed from: k */
    private static final Executor f18822k = new C3211c();
    @GuardedBy("LOCK")

    /* renamed from: l */
    static final Map<String, FirebaseApp> f18823l = new ArrayMap();

    /* renamed from: a */
    private final Context f18824a;

    /* renamed from: b */
    private final String f18825b;

    /* renamed from: c */
    private final FirebaseOptions f18826c;

    /* renamed from: d */
    private final ComponentRuntime f18827d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f18828e = new AtomicBoolean(false);

    /* renamed from: f */
    private final AtomicBoolean f18829f = new AtomicBoolean();

    /* renamed from: g */
    private final Lazy<DataCollectionConfigStorage> f18830g;

    /* renamed from: h */
    private final List<BackgroundStateChangeListener> f18831h = new CopyOnWriteArrayList();

    /* renamed from: i */
    private final List<FirebaseAppLifecycleListener> f18832i = new CopyOnWriteArrayList();

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    /* renamed from: com.google.firebase.FirebaseApp$b */
    private static class C3210b implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a */
        private static AtomicReference<C3210b> f18833a = new AtomicReference<>();

        private C3210b() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m11116b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f18833a.get() == null) {
                    C3210b bVar = new C3210b();
                    if (f18833a.compareAndSet((Object) null, bVar)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(bVar);
                    }
                }
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.f18821j) {
                Iterator it = new ArrayList(FirebaseApp.f18823l.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.f18828e.get()) {
                        firebaseApp.m11113j(z);
                    }
                }
            }
        }
    }

    /* renamed from: com.google.firebase.FirebaseApp$c */
    private static class C3211c implements Executor {

        /* renamed from: a */
        private static final Handler f18834a = new Handler(Looper.getMainLooper());

        private C3211c() {
        }

        public void execute(@NonNull Runnable runnable) {
            f18834a.post(runnable);
        }
    }

    @TargetApi(24)
    /* renamed from: com.google.firebase.FirebaseApp$d */
    private static class C3212d extends BroadcastReceiver {

        /* renamed from: b */
        private static AtomicReference<C3212d> f18835b = new AtomicReference<>();

        /* renamed from: a */
        private final Context f18836a;

        public C3212d(Context context) {
            this.f18836a = context;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m11118b(Context context) {
            if (f18835b.get() == null) {
                C3212d dVar = new C3212d(context);
                if (f18835b.compareAndSet((Object) null, dVar)) {
                    context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        /* renamed from: c */
        public void mo20719c() {
            this.f18836a.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f18821j) {
                for (FirebaseApp b : FirebaseApp.f18823l.values()) {
                    b.m11110g();
                }
            }
            mo20719c();
        }
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.f18824a = (Context) Preconditions.checkNotNull(context);
        this.f18825b = Preconditions.checkNotEmpty(str);
        this.f18826c = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        List<ComponentRegistrar> discover = ComponentDiscovery.forContext(context, ComponentDiscoveryService.class).discover();
        String detectVersion = KotlinDetector.detectVersion();
        Executor executor = f18822k;
        Component[] componentArr = new Component[8];
        componentArr[0] = Component.m11159of(context, Context.class, new Class[0]);
        componentArr[1] = Component.m11159of(this, FirebaseApp.class, new Class[0]);
        componentArr[2] = Component.m11159of(firebaseOptions, FirebaseOptions.class, new Class[0]);
        componentArr[3] = LibraryVersionComponent.create("fire-android", "");
        componentArr[4] = LibraryVersionComponent.create("fire-core", BuildConfig.VERSION_NAME);
        componentArr[5] = detectVersion != null ? LibraryVersionComponent.create("kotlin", detectVersion) : null;
        componentArr[6] = DefaultUserAgentPublisher.component();
        componentArr[7] = DefaultHeartBeatInfo.component();
        this.f18827d = new ComponentRuntime(executor, discover, componentArr);
        this.f18830g = new Lazy<>(C3217a.m11127a(this, context));
    }

    @VisibleForTesting
    public static void clearInstancesForTest() {
        synchronized (f18821j) {
            f18823l.clear();
        }
    }

    /* renamed from: e */
    private void m11108e() {
        Preconditions.checkState(!this.f18829f.get(), "FirebaseApp was deleted");
    }

    /* renamed from: f */
    private static List<String> m11109f() {
        ArrayList arrayList = new ArrayList();
        synchronized (f18821j) {
            for (FirebaseApp name : f18823l.values()) {
                arrayList.add(name.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11110g() {
        if (!UserManagerCompat.isUserUnlocked(this.f18824a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + getName());
            C3212d.m11118b(this.f18824a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + getName());
        this.f18827d.initializeEagerComponents(isDefaultApp());
    }

    @NonNull
    public static List<FirebaseApp> getApps(@NonNull Context context) {
        ArrayList arrayList;
        synchronized (f18821j) {
            arrayList = new ArrayList(f18823l.values());
        }
        return arrayList;
    }

    @NonNull
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (f18821j) {
            firebaseApp = f18823l.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    /* renamed from: h */
    static /* synthetic */ DataCollectionConfigStorage m11111h(FirebaseApp firebaseApp, Context context) {
        return new DataCollectionConfigStorage(context, firebaseApp.getPersistenceKey(), (Publisher) firebaseApp.f18827d.get(Publisher.class));
    }

    /* renamed from: i */
    private static String m11112i(@NonNull String str) {
        return str.trim();
    }

    @Nullable
    public static FirebaseApp initializeApp(@NonNull Context context) {
        synchronized (f18821j) {
            if (f18823l.containsKey(DEFAULT_APP_NAME)) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            FirebaseApp initializeApp = initializeApp(context, fromResource);
            return initializeApp;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m11113j(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (BackgroundStateChangeListener onBackgroundStateChanged : this.f18831h) {
            onBackgroundStateChanged.onBackgroundStateChanged(z);
        }
    }

    /* renamed from: k */
    private void m11114k() {
        for (FirebaseAppLifecycleListener onDeleted : this.f18832i) {
            onDeleted.onDeleted(this.f18825b, this.f18826c);
        }
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        m11108e();
        if (this.f18828e.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.f18831h.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void addLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        m11108e();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.f18832i.add(firebaseAppLifecycleListener);
    }

    public void delete() {
        if (this.f18829f.compareAndSet(false, true)) {
            synchronized (f18821j) {
                f18823l.remove(this.f18825b);
            }
            m11114k();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f18825b.equals(((FirebaseApp) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        m11108e();
        return this.f18827d.get(cls);
    }

    @NonNull
    public Context getApplicationContext() {
        m11108e();
        return this.f18824a;
    }

    @NonNull
    public String getName() {
        m11108e();
        return this.f18825b;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        m11108e();
        return this.f18826c;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.f18825b.hashCode();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        m11108e();
        return this.f18830g.get().isEnabled();
    }

    @VisibleForTesting
    @KeepForSdk
    public boolean isDefaultApp() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        m11108e();
        this.f18831h.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void removeLifecycleEventListener(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        m11108e();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.f18832i.remove(firebaseAppLifecycleListener);
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        m11108e();
        if (this.f18828e.compareAndSet(!z, z)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && isInBackground) {
                m11113j(true);
            } else if (!z && isInBackground) {
                m11113j(false);
            }
        }
    }

    @KeepForSdk
    public void setDataCollectionDefaultEnabled(Boolean bool) {
        m11108e();
        this.f18830g.get().setEnabled(bool);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f18825b).add("options", this.f18826c).toString();
    }

    @KeepForSdk
    @Deprecated
    public void setDataCollectionDefaultEnabled(boolean z) {
        setDataCollectionDefaultEnabled(Boolean.valueOf(z));
    }

    @KeepForSdk
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    @NonNull
    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (f18821j) {
            firebaseApp = f18823l.get(m11112i(str));
            if (firebaseApp == null) {
                List<String> f = m11109f();
                if (f.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", f);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    @NonNull
    public static FirebaseApp initializeApp(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        FirebaseApp firebaseApp;
        C3210b.m11116b(context);
        String i = m11112i(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f18821j) {
            Map<String, FirebaseApp> map = f18823l;
            boolean z = !map.containsKey(i);
            Preconditions.checkState(z, "FirebaseApp name " + i + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, i, firebaseOptions);
            map.put(i, firebaseApp);
        }
        firebaseApp.m11110g();
        return firebaseApp;
    }
}
