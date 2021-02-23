package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.annotation.XmlRes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;

    /* renamed from: a */
    private final Context f19670a;
    @Nullable

    /* renamed from: b */
    private final FirebaseABTesting f19671b;

    /* renamed from: c */
    private final Executor f19672c;

    /* renamed from: d */
    private final ConfigCacheClient f19673d;

    /* renamed from: e */
    private final ConfigCacheClient f19674e;

    /* renamed from: f */
    private final ConfigCacheClient f19675f;

    /* renamed from: g */
    private final ConfigFetchHandler f19676g;

    /* renamed from: h */
    private final ConfigGetParameterHandler f19677h;

    /* renamed from: i */
    private final ConfigMetadataClient f19678i;

    /* renamed from: j */
    private final FirebaseInstallationsApi f19679j;

    FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.f19670a = context;
        this.f19679j = firebaseInstallationsApi;
        this.f19671b = firebaseABTesting;
        this.f19672c = executor;
        this.f19673d = configCacheClient;
        this.f19674e = configCacheClient2;
        this.f19675f = configCacheClient3;
        this.f19676g = configFetchHandler;
        this.f19677h = configGetParameterHandler;
        this.f19678i = configMetadataClient;
    }

    /* renamed from: b */
    private static boolean m11848b(ConfigContainer configContainer, @Nullable ConfigContainer configContainer2) {
        return configContainer2 == null || !configContainer.getFetchTime().equals(configContainer2.getFetchTime());
    }

    /* renamed from: c */
    static /* synthetic */ Task m11849c(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2, Task task3) {
        Boolean bool = Boolean.FALSE;
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(bool);
        }
        ConfigContainer configContainer = (ConfigContainer) task.getResult();
        if (!task2.isSuccessful() || m11848b(configContainer, (ConfigContainer) task2.getResult())) {
            return firebaseRemoteConfig.f19674e.put(configContainer).continueWith(firebaseRemoteConfig.f19672c, C3510b.m11877a(firebaseRemoteConfig));
        }
        return Tasks.forResult(bool);
    }

    /* renamed from: d */
    static /* synthetic */ void m11850d(FirebaseRemoteConfig firebaseRemoteConfig, ConfigContainer configContainer) {
        firebaseRemoteConfig.f19673d.clear();
        firebaseRemoteConfig.mo21701q(configContainer.getAbtExperiments());
    }

    /* renamed from: e */
    static /* synthetic */ FirebaseRemoteConfigInfo m11851e(Task task, Task task2) {
        return (FirebaseRemoteConfigInfo) task.getResult();
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* renamed from: i */
    static /* synthetic */ Void m11855i(FirebaseRemoteConfig firebaseRemoteConfig) {
        firebaseRemoteConfig.f19674e.clear();
        firebaseRemoteConfig.f19673d.clear();
        firebaseRemoteConfig.f19675f.clear();
        firebaseRemoteConfig.f19678i.clear();
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public boolean m11858l(Task<ConfigContainer> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        this.f19673d.clear();
        if (task.getResult() != null) {
            mo21701q(task.getResult().getAbtExperiments());
            return true;
        }
        Log.e(TAG, "Activated configs written to disk are null.");
        return true;
    }

    /* renamed from: m */
    private void m11859m(Map<String, String> map) {
        try {
            this.f19675f.putWithoutWaitingForDiskWrite(ConfigContainer.newBuilder().replaceConfigsWith(map).build());
        } catch (JSONException e) {
            Log.e(TAG, "The provided defaults map could not be processed.", e);
        }
    }

    /* renamed from: n */
    private Task<Void> m11860n(Map<String, String> map) {
        try {
            return this.f19675f.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build()).onSuccessTask(C3509a.m11876a());
        } catch (JSONException e) {
            Log.e(TAG, "The provided defaults map could not be processed.", e);
            return Tasks.forResult(null);
        }
    }

    @VisibleForTesting
    /* renamed from: p */
    static List<Map<String, String>> m11861p(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @NonNull
    public Task<Boolean> activate() {
        Task<ConfigContainer> task = this.f19673d.get();
        Task<ConfigContainer> task2 = this.f19674e.get();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{task, task2}).continueWithTask(this.f19672c, C3515g.m11882a(this, task, task2));
    }

    @WorkerThread
    @Deprecated
    public boolean activateFetched() {
        ConfigContainer blocking = this.f19673d.getBlocking();
        if (blocking == null || !m11848b(blocking, this.f19674e.getBlocking())) {
            return false;
        }
        this.f19674e.putWithoutWaitingForDiskWrite(blocking).addOnSuccessListener(this.f19672c, C3514f.m11881a(this));
        return true;
    }

    @NonNull
    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task<ConfigContainer> task = this.f19674e.get();
        Task<ConfigContainer> task2 = this.f19675f.get();
        Task<ConfigContainer> task3 = this.f19673d.get();
        Task call = Tasks.call(this.f19672c, C3511c.m11878a(this));
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{task, task2, task3, call, this.f19679j.getId(), this.f19679j.getToken(false)}).continueWith(this.f19672c, C3512d.m11879a(call));
    }

    @NonNull
    public Task<Void> fetch() {
        return this.f19676g.fetch().onSuccessTask(C3516h.m11883a());
    }

    @NonNull
    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.f19672c, C3513e.m11880a(this));
    }

    @NonNull
    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.f19677h.getAll();
    }

    public boolean getBoolean(@NonNull String str) {
        return this.f19677h.getBoolean(str);
    }

    @NonNull
    @Deprecated
    public byte[] getByteArray(@NonNull String str) {
        return this.f19677h.getByteArray(str);
    }

    public double getDouble(@NonNull String str) {
        return this.f19677h.getDouble(str);
    }

    @NonNull
    public FirebaseRemoteConfigInfo getInfo() {
        return this.f19678i.getInfo();
    }

    @NonNull
    public Set<String> getKeysByPrefix(@NonNull String str) {
        return this.f19677h.getKeysByPrefix(str);
    }

    public long getLong(@NonNull String str) {
        return this.f19677h.getLong(str);
    }

    @NonNull
    public String getString(@NonNull String str) {
        return this.f19677h.getString(str);
    }

    @NonNull
    public FirebaseRemoteConfigValue getValue(@NonNull String str) {
        return this.f19677h.getValue(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo21700o() {
        this.f19674e.get();
        this.f19675f.get();
        this.f19673d.get();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: q */
    public void mo21701q(@NonNull JSONArray jSONArray) {
        if (this.f19671b != null) {
            try {
                this.f19671b.replaceAllExperiments(m11861p(jSONArray));
            } catch (JSONException e) {
                Log.e(TAG, "Could not parse ABT experiments from the JSON response.", e);
            } catch (AbtException e2) {
                Log.w(TAG, "Could not update ABT experiments.", e2);
            }
        }
    }

    @NonNull
    public Task<Void> reset() {
        return Tasks.call(this.f19672c, C3519k.m11887a(this));
    }

    @Deprecated
    public void setConfigSettings(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f19678i.setConfigSettingsWithoutWaitingOnDiskWrite(firebaseRemoteConfigSettings);
    }

    @NonNull
    public Task<Void> setConfigSettingsAsync(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.f19672c, C3518j.m11886a(this, firebaseRemoteConfigSettings));
    }

    @Deprecated
    public void setDefaults(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof byte[]) {
                hashMap.put((String) next.getKey(), new String((byte[]) value));
            } else {
                hashMap.put((String) next.getKey(), value.toString());
            }
        }
        m11859m(hashMap);
    }

    @NonNull
    public Task<Void> setDefaultsAsync(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof byte[]) {
                hashMap.put((String) next.getKey(), new String((byte[]) value));
            } else {
                hashMap.put((String) next.getKey(), value.toString());
            }
        }
        return m11860n(hashMap);
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance(@NonNull FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).mo21731c();
    }

    @NonNull
    public Task<Void> fetch(long j) {
        return this.f19676g.fetch(j).onSuccessTask(C3517i.m11884a());
    }

    @Deprecated
    public void setDefaults(@XmlRes int i) {
        m11859m(DefaultsXmlParser.getDefaultsFromXml(this.f19670a, i));
    }

    @NonNull
    public Task<Void> setDefaultsAsync(@XmlRes int i) {
        return m11860n(DefaultsXmlParser.getDefaultsFromXml(this.f19670a, i));
    }
}
