package com.google.firebase.remoteconfig.internal;

import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@AnyThread
public class ConfigCacheClient {
    @GuardedBy("ConfigCacheClient.class")

    /* renamed from: d */
    private static final Map<String, ConfigCacheClient> f20222d = new HashMap();

    /* renamed from: e */
    private static final Executor f20223e = C3590d.m12184a();

    /* renamed from: a */
    private final ExecutorService f20224a;

    /* renamed from: b */
    private final ConfigStorageClient f20225b;
    @GuardedBy("this")
    @Nullable

    /* renamed from: c */
    private Task<ConfigContainer> f20226c = null;

    /* renamed from: com.google.firebase.remoteconfig.internal.ConfigCacheClient$b */
    private static class C3581b<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {

        /* renamed from: a */
        private final CountDownLatch f20227a;

        private C3581b() {
            this.f20227a = new CountDownLatch(1);
        }

        /* renamed from: a */
        public boolean mo22609a(long j, TimeUnit timeUnit) {
            return this.f20227a.await(j, timeUnit);
        }

        public void onCanceled() {
            this.f20227a.countDown();
        }

        public void onFailure(@NonNull Exception exc) {
            this.f20227a.countDown();
        }

        public void onSuccess(TResult tresult) {
            this.f20227a.countDown();
        }
    }

    private ConfigCacheClient(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        this.f20224a = executorService;
        this.f20225b = configStorageClient;
    }

    /* renamed from: a */
    private static <TResult> TResult m12096a(Task<TResult> task, long j, TimeUnit timeUnit) {
        C3581b bVar = new C3581b();
        Executor executor = f20223e;
        task.addOnSuccessListener(executor, (OnSuccessListener<? super TResult>) bVar);
        task.addOnFailureListener(executor, (OnFailureListener) bVar);
        task.addOnCanceledListener(executor, (OnCanceledListener) bVar);
        if (!bVar.mo22609a(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        } else if (task.isSuccessful()) {
            return task.getResult();
        } else {
            throw new ExecutionException(task.getException());
        }
    }

    @VisibleForTesting
    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            f20222d.clear();
        }
    }

    /* renamed from: d */
    static /* synthetic */ Task m12098d(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer, Void voidR) {
        if (z) {
            configCacheClient.m12099e(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    /* renamed from: e */
    private synchronized void m12099e(ConfigContainer configContainer) {
        this.f20226c = Tasks.forResult(configContainer);
    }

    public static synchronized ConfigCacheClient getInstance(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String a = configStorageClient.mo21737a();
            Map<String, ConfigCacheClient> map = f20222d;
            if (!map.containsKey(a)) {
                map.put(a, new ConfigCacheClient(executorService, configStorageClient));
            }
            configCacheClient = map.get(a);
        }
        return configCacheClient;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return (com.google.firebase.remoteconfig.internal.ConfigContainer) m12096a(get(), r3, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        android.util.Log.d(com.google.firebase.remoteconfig.FirebaseRemoteConfig.TAG, "Reading from storage file failed.", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        return null;
     */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.Nullable
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.remoteconfig.internal.ConfigContainer mo22602b(long r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r0 = r2.f20226c     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.isSuccessful()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r3 = r2.f20226c     // Catch:{ all -> 0x0031 }
            java.lang.Object r3 = r3.getResult()     // Catch:{ all -> 0x0031 }
            com.google.firebase.remoteconfig.internal.ConfigContainer r3 = (com.google.firebase.remoteconfig.internal.ConfigContainer) r3     // Catch:{ all -> 0x0031 }
            monitor-exit(r2)     // Catch:{ all -> 0x0031 }
            return r3
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0031 }
            com.google.android.gms.tasks.Task r0 = r2.get()     // Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x0025, TimeoutException -> 0x0023 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x0025, TimeoutException -> 0x0023 }
            java.lang.Object r3 = m12096a(r0, r3, r1)     // Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x0025, TimeoutException -> 0x0023 }
            com.google.firebase.remoteconfig.internal.ConfigContainer r3 = (com.google.firebase.remoteconfig.internal.ConfigContainer) r3     // Catch:{ InterruptedException -> 0x0027, ExecutionException -> 0x0025, TimeoutException -> 0x0023 }
            return r3
        L_0x0023:
            r3 = move-exception
            goto L_0x0028
        L_0x0025:
            r3 = move-exception
            goto L_0x0028
        L_0x0027:
            r3 = move-exception
        L_0x0028:
            java.lang.String r4 = "FirebaseRemoteConfig"
            java.lang.String r0 = "Reading from storage file failed."
            android.util.Log.d(r4, r0, r3)
            r3 = 0
            return r3
        L_0x0031:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0031 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigCacheClient.mo22602b(long):com.google.firebase.remoteconfig.internal.ConfigContainer");
    }

    public void clear() {
        synchronized (this) {
            this.f20226c = Tasks.forResult(null);
        }
        this.f20225b.clear();
    }

    public synchronized Task<ConfigContainer> get() {
        Task<ConfigContainer> task = this.f20226c;
        if (task == null || (task.isComplete() && !this.f20226c.isSuccessful())) {
            ExecutorService executorService = this.f20224a;
            ConfigStorageClient configStorageClient = this.f20225b;
            configStorageClient.getClass();
            this.f20226c = Tasks.call(executorService, C3589c.m12183a(configStorageClient));
        }
        return this.f20226c;
    }

    @Nullable
    public ConfigContainer getBlocking() {
        return mo22602b(5);
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    public Task<ConfigContainer> putWithoutWaitingForDiskWrite(ConfigContainer configContainer) {
        m12099e(configContainer);
        return put(configContainer, false);
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer, boolean z) {
        return Tasks.call(this.f20224a, C3587a.m12181a(this, configContainer)).onSuccessTask(this.f20224a, C3588b.m12182a(this, z, configContainer));
    }
}
