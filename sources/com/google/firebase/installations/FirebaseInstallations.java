package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* renamed from: l */
    private static final Object f19574l = new Object();

    /* renamed from: m */
    private static final ThreadFactory f19575m = new C3470a();

    /* renamed from: a */
    private final FirebaseApp f19576a;

    /* renamed from: b */
    private final FirebaseInstallationServiceClient f19577b;

    /* renamed from: c */
    private final PersistedInstallation f19578c;

    /* renamed from: d */
    private final C3490k f19579d;

    /* renamed from: e */
    private final IidStore f19580e;

    /* renamed from: f */
    private final RandomFidGenerator f19581f;

    /* renamed from: g */
    private final Object f19582g;

    /* renamed from: h */
    private final ExecutorService f19583h;

    /* renamed from: i */
    private final ExecutorService f19584i;
    @GuardedBy("this")

    /* renamed from: j */
    private String f19585j;
    @GuardedBy("lock")

    /* renamed from: k */
    private final List<C3489j> f19586k;

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$a */
    class C3470a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f19587a = new AtomicInteger(1);

        C3470a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f19587a.getAndIncrement())}));
        }
    }

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$b */
    static /* synthetic */ class C3471b {

        /* renamed from: a */
        static final /* synthetic */ int[] f19588a;

        /* renamed from: b */
        static final /* synthetic */ int[] f19589b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                com.google.firebase.installations.remote.TokenResult$ResponseCode[] r0 = com.google.firebase.installations.remote.TokenResult.ResponseCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19589b = r0
                r1 = 1
                com.google.firebase.installations.remote.TokenResult$ResponseCode r2 = com.google.firebase.installations.remote.TokenResult.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19589b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r3 = com.google.firebase.installations.remote.TokenResult.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f19589b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r3 = com.google.firebase.installations.remote.TokenResult.ResponseCode.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode[] r2 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f19588a = r2
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r3 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f19588a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r2 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.C3471b.<clinit>():void");
        }
    }

    FirebaseInstallations(FirebaseApp firebaseApp, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        this(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), f19575m), firebaseApp, new FirebaseInstallationServiceClient(firebaseApp.getApplicationContext(), userAgentPublisher, heartBeatInfo), new PersistedInstallation(firebaseApp), new C3490k(), new IidStore(firebaseApp), new RandomFidGenerator());
    }

    /* renamed from: b */
    private Task<InstallationTokenResult> m11767b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m11769d(new C3484h(this.f19579d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* renamed from: c */
    private Task<String> m11768c() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m11769d(new C3485i(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* renamed from: d */
    private void m11769d(C3489j jVar) {
        synchronized (this.f19582g) {
            this.f19586k.add(jVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Void m11770e() {
        m11786x((String) null);
        PersistedInstallationEntry l = m11775l();
        if (l.isRegistered()) {
            this.f19577b.deleteFirebaseInstallation(mo21578i(), l.getFirebaseInstallationId(), mo21580n(), l.getRefreshToken());
        }
        m11777o(l.withNoGeneratedFid());
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11771f(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.m11775l()
            boolean r1 = r0.isErrored()     // Catch:{ FirebaseInstallationsException -> 0x005c }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r0.isUnregistered()     // Catch:{ FirebaseInstallationsException -> 0x005c }
            if (r1 == 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            if (r3 != 0) goto L_0x001d
            com.google.firebase.installations.k r3 = r2.f19579d     // Catch:{ FirebaseInstallationsException -> 0x005c }
            boolean r3 = r3.mo21603b(r0)     // Catch:{ FirebaseInstallationsException -> 0x005c }
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.m11773h(r0)     // Catch:{ FirebaseInstallationsException -> 0x005c }
            goto L_0x0026
        L_0x0022:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.m11783u(r0)     // Catch:{ FirebaseInstallationsException -> 0x005c }
        L_0x0026:
            r2.m11777o(r3)
            boolean r0 = r3.isRegistered()
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = r3.getFirebaseInstallationId()
            r2.m11786x(r0)
        L_0x0036:
            boolean r0 = r3.isErrored()
            if (r0 == 0) goto L_0x0047
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r1 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r0.<init>(r1)
            r2.m11784v(r3, r0)
            goto L_0x005b
        L_0x0047:
            boolean r0 = r3.isNotGenerated()
            if (r0 == 0) goto L_0x0058
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r0.<init>(r1)
            r2.m11784v(r3, r0)
            goto L_0x005b
        L_0x0058:
            r2.m11785w(r3)
        L_0x005b:
            return
        L_0x005c:
            r3 = move-exception
            r2.m11784v(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.m11771f(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m11772g(boolean z) {
        PersistedInstallationEntry m = m11776m();
        if (z) {
            m = m.withClearedAuthToken();
        }
        m11785w(m);
        this.f19584i.execute(C3482f.m11797a(this, z));
    }

    @NonNull
    public static FirebaseInstallations getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* renamed from: h */
    private PersistedInstallationEntry m11773h(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        TokenResult generateAuthToken = this.f19577b.generateAuthToken(mo21578i(), persistedInstallationEntry.getFirebaseInstallationId(), mo21580n(), persistedInstallationEntry.getRefreshToken());
        int i = C3471b.f19589b[generateAuthToken.getResponseCode().ordinal()];
        if (i == 1) {
            return persistedInstallationEntry.withAuthToken(generateAuthToken.getToken(), generateAuthToken.getTokenExpirationTimestamp(), this.f19579d.mo21602a());
        } else if (i == 2) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        } else {
            if (i == 3) {
                m11786x((String) null);
                return persistedInstallationEntry.withNoGeneratedFid();
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* renamed from: k */
    private synchronized String m11774k() {
        return this.f19585j;
    }

    /* renamed from: l */
    private PersistedInstallationEntry m11775l() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (f19574l) {
            C3478b a = C3478b.m11792a(this.f19576a.getApplicationContext(), "generatefid.lock");
            try {
                readPersistedInstallationEntryValue = this.f19578c.readPersistedInstallationEntryValue();
                if (a != null) {
                    a.mo21595b();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.mo21595b();
                }
                throw th;
            }
        }
        return readPersistedInstallationEntryValue;
    }

    /* renamed from: m */
    private PersistedInstallationEntry m11776m() {
        PersistedInstallationEntry readPersistedInstallationEntryValue;
        synchronized (f19574l) {
            C3478b a = C3478b.m11792a(this.f19576a.getApplicationContext(), "generatefid.lock");
            try {
                readPersistedInstallationEntryValue = this.f19578c.readPersistedInstallationEntryValue();
                if (readPersistedInstallationEntryValue.isNotGenerated()) {
                    readPersistedInstallationEntryValue = this.f19578c.insertOrUpdatePersistedInstallationEntry(readPersistedInstallationEntryValue.withUnregisteredFid(m11782t(readPersistedInstallationEntryValue)));
                }
                if (a != null) {
                    a.mo21595b();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.mo21595b();
                }
                throw th;
            }
        }
        return readPersistedInstallationEntryValue;
    }

    /* renamed from: o */
    private void m11777o(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (f19574l) {
            C3478b a = C3478b.m11792a(this.f19576a.getApplicationContext(), "generatefid.lock");
            try {
                this.f19578c.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntry);
                if (a != null) {
                    a.mo21595b();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.mo21595b();
                }
                throw th;
            }
        }
    }

    /* renamed from: s */
    private void m11781s() {
        Preconditions.checkNotEmpty(mo21579j(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(mo21580n(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(mo21578i(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(C3490k.m11806d(mo21579j()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(C3490k.m11805c(mo21578i()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* renamed from: t */
    private String m11782t(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.f19576a.getName().equals("CHIME_ANDROID_SDK") && !this.f19576a.isDefaultApp()) || !persistedInstallationEntry.shouldAttemptMigration()) {
            return this.f19581f.createRandomFid();
        }
        String readIid = this.f19580e.readIid();
        return TextUtils.isEmpty(readIid) ? this.f19581f.createRandomFid() : readIid;
    }

    /* renamed from: u */
    private PersistedInstallationEntry m11783u(PersistedInstallationEntry persistedInstallationEntry) {
        InstallationResponse createFirebaseInstallation = this.f19577b.createFirebaseInstallation(mo21578i(), persistedInstallationEntry.getFirebaseInstallationId(), mo21580n(), mo21579j(), (persistedInstallationEntry.getFirebaseInstallationId() == null || persistedInstallationEntry.getFirebaseInstallationId().length() != 11) ? null : this.f19580e.readToken());
        int i = C3471b.f19588a[createFirebaseInstallation.getResponseCode().ordinal()];
        if (i == 1) {
            return persistedInstallationEntry.withRegisteredFid(createFirebaseInstallation.getFid(), createFirebaseInstallation.getRefreshToken(), this.f19579d.mo21602a(), createFirebaseInstallation.getAuthToken().getToken(), createFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
        } else if (i == 2) {
            return persistedInstallationEntry.withFisError("BAD CONFIG");
        } else {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* renamed from: v */
    private void m11784v(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        synchronized (this.f19582g) {
            Iterator<C3489j> it = this.f19586k.iterator();
            while (it.hasNext()) {
                if (it.next().mo21600a(persistedInstallationEntry, exc)) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: w */
    private void m11785w(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f19582g) {
            Iterator<C3489j> it = this.f19586k.iterator();
            while (it.hasNext()) {
                if (it.next().mo21601b(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: x */
    private synchronized void m11786x(String str) {
        this.f19585j = str;
    }

    @NonNull
    public Task<Void> delete() {
        return Tasks.call(this.f19583h, C3481e.m11796a(this));
    }

    @NonNull
    public Task<String> getId() {
        m11781s();
        String k = m11774k();
        if (k != null) {
            return Tasks.forResult(k);
        }
        Task<String> c = m11768c();
        this.f19583h.execute(C3479c.m11794a(this));
        return c;
    }

    @NonNull
    public Task<InstallationTokenResult> getToken(boolean z) {
        m11781s();
        Task<InstallationTokenResult> b = m11767b();
        this.f19583h.execute(C3480d.m11795a(this, z));
        return b;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: i */
    public String mo21578i() {
        return this.f19576a.getOptions().getApiKey();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: j */
    public String mo21579j() {
        return this.f19576a.getOptions().getApplicationId();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: n */
    public String mo21580n() {
        return this.f19576a.getOptions().getProjectId();
    }

    @NonNull
    public static FirebaseInstallations getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.get(FirebaseInstallationsApi.class);
    }

    FirebaseInstallations(ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation, C3490k kVar, IidStore iidStore, RandomFidGenerator randomFidGenerator) {
        this.f19582g = new Object();
        this.f19586k = new ArrayList();
        this.f19576a = firebaseApp;
        this.f19577b = firebaseInstallationServiceClient;
        this.f19578c = persistedInstallation;
        this.f19579d = kVar;
        this.f19580e = iidStore;
        this.f19581f = randomFidGenerator;
        this.f19583h = executorService;
        this.f19584i = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), f19575m);
    }
}
