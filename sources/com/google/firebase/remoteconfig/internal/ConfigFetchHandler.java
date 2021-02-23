package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class ConfigFetchHandler {
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    @VisibleForTesting

    /* renamed from: j */
    static final int[] f20236j = {2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: a */
    private final FirebaseInstallationsApi f20237a;
    @Nullable

    /* renamed from: b */
    private final AnalyticsConnector f20238b;

    /* renamed from: c */
    private final Executor f20239c;

    /* renamed from: d */
    private final Clock f20240d;

    /* renamed from: e */
    private final Random f20241e;

    /* renamed from: f */
    private final ConfigCacheClient f20242f;

    /* renamed from: g */
    private final ConfigFetchHttpClient f20243g;

    /* renamed from: h */
    private final ConfigMetadataClient f20244h;

    /* renamed from: i */
    private final Map<String, String> f20245i;

    public static class FetchResponse {

        /* renamed from: a */
        private final int f20246a;

        /* renamed from: b */
        private final ConfigContainer f20247b;
        @Nullable

        /* renamed from: c */
        private final String f20248c;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
            public static final int BACKEND_HAS_NO_UPDATES = 1;
            public static final int BACKEND_UPDATES_FETCHED = 0;
            public static final int LOCAL_STORAGE_USED = 2;
        }

        private FetchResponse(Date date, int i, ConfigContainer configContainer, @Nullable String str) {
            this.f20246a = i;
            this.f20247b = configContainer;
            this.f20248c = str;
        }

        public static FetchResponse forBackendHasNoUpdates(Date date) {
            return new FetchResponse(date, 1, (ConfigContainer) null, (String) null);
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, (ConfigContainer) null, (String) null);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public String mo22624a() {
            return this.f20248c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo22625b() {
            return this.f20246a;
        }

        public ConfigContainer getFetchedConfigs() {
            return this.f20247b;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, @Nullable AnalyticsConnector analyticsConnector, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.f20237a = firebaseInstallationsApi;
        this.f20238b = analyticsConnector;
        this.f20239c = executor;
        this.f20240d = clock;
        this.f20241e = random;
        this.f20242f = configCacheClient;
        this.f20243g = configFetchHttpClient;
        this.f20244h = configMetadataClient;
        this.f20245i = map;
    }

    /* renamed from: a */
    private boolean m12104a(long j, Date date) {
        Date c = this.f20244h.mo22641c();
        if (c.equals(ConfigMetadataClient.f20261d)) {
            return false;
        }
        return date.before(new Date(c.getTime() + TimeUnit.SECONDS.toMillis(j)));
    }

    /* renamed from: b */
    private FirebaseRemoteConfigServerException m12105b(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else if (httpStatusCode == 429) {
            throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
        } else if (httpStatusCode != 500) {
            switch (httpStatusCode) {
                case 502:
                case 503:
                case 504:
                    str = "The server is unavailable. Please try again later.";
                    break;
                default:
                    str = "The server returned an unexpected error.";
                    break;
            }
        } else {
            str = "There was an internal server error.";
        }
        int httpStatusCode2 = firebaseRemoteConfigServerException.getHttpStatusCode();
        return new FirebaseRemoteConfigServerException(httpStatusCode2, "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    /* renamed from: c */
    private String m12106c(long j) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", new Object[]{DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j))});
    }

    @WorkerThread
    /* renamed from: d */
    private FetchResponse m12107d(String str, String str2, Date date) {
        try {
            FetchResponse fetch = this.f20243g.fetch(this.f20243g.mo22627c(), str, str2, m12112i(), this.f20244h.mo22640b(), this.f20245i, date);
            if (fetch.mo22624a() != null) {
                this.f20244h.mo22645f(fetch.mo22624a());
            }
            this.f20244h.mo22643d();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e) {
            ConfigMetadataClient.C3583a p = m12119p(e.getHttpStatusCode(), date);
            if (m12118o(p, e.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(p.mo22655a().getTime());
            }
            throw m12105b(e);
        }
    }

    /* renamed from: e */
    private Task<FetchResponse> m12108e(String str, String str2, Date date) {
        try {
            FetchResponse d = m12107d(str, str2, date);
            if (d.mo22625b() != 0) {
                return Tasks.forResult(d);
            }
            return this.f20242f.put(d.getFetchedConfigs()).onSuccessTask(this.f20239c, C3594h.m12188a(d));
        } catch (FirebaseRemoteConfigException e) {
            return Tasks.forException(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public Task<FetchResponse> m12109f(Task<ConfigContainer> task, long j) {
        Task<TContinuationResult> task2;
        Date date = new Date(this.f20240d.currentTimeMillis());
        if (task.isSuccessful() && m12104a(j, date)) {
            return Tasks.forResult(FetchResponse.forLocalStorageUsed(date));
        }
        Date g = m12110g(date);
        if (g != null) {
            task2 = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(m12106c(g.getTime() - date.getTime()), g.getTime()));
        } else {
            Task<String> id = this.f20237a.getId();
            Task<InstallationTokenResult> token = this.f20237a.getToken(false);
            task2 = Tasks.whenAllComplete((Task<?>[]) new Task[]{id, token}).continueWithTask(this.f20239c, C3592f.m12186a(this, id, token, date));
        }
        return task2.continueWithTask(this.f20239c, C3593g.m12187a(this, date));
    }

    @Nullable
    /* renamed from: g */
    private Date m12110g(Date date) {
        Date a = this.f20244h.mo22639a().mo22655a();
        if (date.before(a)) {
            return a;
        }
        return null;
    }

    /* renamed from: h */
    private long m12111h(int i) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f20236j;
        long millis = timeUnit.toMillis((long) iArr[Math.min(i, iArr.length) - 1]);
        return (millis / 2) + ((long) this.f20241e.nextInt((int) millis));
    }

    @WorkerThread
    /* renamed from: i */
    private Map<String, String> m12112i() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.f20238b;
        if (analyticsConnector == null) {
            return hashMap;
        }
        for (Map.Entry next : analyticsConnector.getUserProperties(false).entrySet()) {
            hashMap.put((String) next.getKey(), next.getValue().toString());
        }
        return hashMap;
    }

    /* renamed from: j */
    private boolean m12113j(int i) {
        return i == 429 || i == 502 || i == 503 || i == 504;
    }

    /* renamed from: m */
    static /* synthetic */ Task m12116m(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date, Task task3) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException()));
        }
        return configFetchHandler.m12108e((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).getToken(), date);
    }

    /* renamed from: o */
    private boolean m12118o(ConfigMetadataClient.C3583a aVar, int i) {
        return aVar.mo22656b() > 1 || i == 429;
    }

    /* renamed from: p */
    private ConfigMetadataClient.C3583a m12119p(int i, Date date) {
        if (m12113j(i)) {
            m12120q(date);
        }
        return this.f20244h.mo22639a();
    }

    /* renamed from: q */
    private void m12120q(Date date) {
        int b = this.f20244h.mo22639a().mo22656b() + 1;
        this.f20244h.mo22644e(b, new Date(date.getTime() + m12111h(b)));
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m12121r(Task<FetchResponse> task, Date date) {
        if (task.isSuccessful()) {
            this.f20244h.mo22650h(date);
            return;
        }
        Exception exception = task.getException();
        if (exception != null) {
            if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
                this.f20244h.mo22651i();
            } else {
                this.f20244h.mo22646g();
            }
        }
    }

    public Task<FetchResponse> fetch() {
        return fetch(this.f20244h.getMinimumFetchIntervalInSeconds());
    }

    @VisibleForTesting
    @Nullable
    public AnalyticsConnector getAnalyticsConnector() {
        return this.f20238b;
    }

    public Task<FetchResponse> fetch(long j) {
        if (this.f20244h.isDeveloperModeEnabled()) {
            j = 0;
        }
        return this.f20242f.get().continueWithTask(this.f20239c, C3591e.m12185a(this, j));
    }
}
