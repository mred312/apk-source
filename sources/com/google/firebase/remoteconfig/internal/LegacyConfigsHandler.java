package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.bumptech.glide.load.Key;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.proto.ConfigPersistence;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import developers.mobile.abt.FirebaseAbt;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyConfigsHandler {
    @VisibleForTesting
    public static final String EXPERIMENT_ID_KEY = "experimentId";
    @VisibleForTesting
    public static final String EXPERIMENT_START_TIME_KEY = "experimentStartTime";
    @VisibleForTesting
    public static final String EXPERIMENT_TIME_TO_LIVE_KEY = "timeToLiveMillis";
    @VisibleForTesting
    public static final String EXPERIMENT_TRIGGER_EVENT_KEY = "triggerEvent";
    @VisibleForTesting
    public static final String EXPERIMENT_TRIGGER_TIMEOUT_KEY = "triggerTimeoutMillis";
    @VisibleForTesting
    public static final String EXPERIMENT_VARIANT_ID_KEY = "variantId";

    /* renamed from: d */
    private static final Charset f20276d = Charset.forName(Key.STRING_CHARSET_NAME);
    @VisibleForTesting

    /* renamed from: e */
    static final ThreadLocal<DateFormat> f20277e = new C3585a();

    /* renamed from: a */
    private final Context f20278a;

    /* renamed from: b */
    private final String f20279b;

    /* renamed from: c */
    private final SharedPreferences f20280c;

    /* renamed from: com.google.firebase.remoteconfig.internal.LegacyConfigsHandler$a */
    class C3585a extends ThreadLocal<DateFormat> {
        C3585a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        }
    }

    /* renamed from: com.google.firebase.remoteconfig.internal.LegacyConfigsHandler$b */
    private static class C3586b {

        /* renamed from: a */
        private ConfigContainer f20281a;

        /* renamed from: b */
        private ConfigContainer f20282b;

        /* renamed from: c */
        private ConfigContainer f20283c;

        /* synthetic */ C3586b(C3585a aVar) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public ConfigContainer m12175g() {
            return this.f20282b;
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public ConfigContainer m12176h() {
            return this.f20283c;
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public ConfigContainer m12177i() {
            return this.f20281a;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public void m12178j(ConfigContainer configContainer) {
            this.f20282b = configContainer;
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public void m12179k(ConfigContainer configContainer) {
            this.f20283c = configContainer;
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public void m12180l(ConfigContainer configContainer) {
            this.f20281a = configContainer;
        }

        private C3586b() {
        }
    }

    public LegacyConfigsHandler(Context context, String str) {
        this.f20278a = context;
        this.f20279b = str;
        this.f20280c = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    /* renamed from: a */
    private Map<String, ConfigContainer> m12159a(ConfigPersistence.ConfigHolder configHolder) {
        HashMap hashMap = new HashMap();
        Date date = new Date(configHolder.getTimestamp());
        JSONArray d = m12162d(configHolder.getExperimentPayloadList());
        for (ConfigPersistence.NamespaceKeyValue next : configHolder.getNamespaceKeyValueList()) {
            String namespace = next.getNamespace();
            if (namespace.startsWith("configns:")) {
                namespace = namespace.substring(9);
            }
            ConfigContainer.Builder withFetchTime = ConfigContainer.newBuilder().replaceConfigsWith(m12160b(next.getKeyValueList())).withFetchTime(date);
            if (namespace.equals(RemoteConfigComponent.DEFAULT_NAMESPACE)) {
                withFetchTime.withAbtExperiments(d);
            }
            try {
                hashMap.put(namespace, withFetchTime.build());
            } catch (JSONException unused) {
                Log.d(FirebaseRemoteConfig.TAG, "A set of legacy configs could not be converted.");
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private Map<String, String> m12160b(List<ConfigPersistence.KeyValue> list) {
        HashMap hashMap = new HashMap();
        for (ConfigPersistence.KeyValue next : list) {
            hashMap.put(next.getKey(), next.getValue().toString(f20276d));
        }
        return hashMap;
    }

    /* renamed from: c */
    private JSONObject m12161c(FirebaseAbt.ExperimentPayload experimentPayload) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("experimentId", experimentPayload.getExperimentId());
        jSONObject.put("variantId", experimentPayload.getVariantId());
        jSONObject.put(EXPERIMENT_START_TIME_KEY, f20277e.get().format(new Date(experimentPayload.getExperimentStartTimeMillis())));
        jSONObject.put(EXPERIMENT_TRIGGER_EVENT_KEY, experimentPayload.getTriggerEvent());
        jSONObject.put(EXPERIMENT_TRIGGER_TIMEOUT_KEY, experimentPayload.getTriggerTimeoutMillis());
        jSONObject.put(EXPERIMENT_TIME_TO_LIVE_KEY, experimentPayload.getTimeToLiveMillis());
        return jSONObject;
    }

    /* renamed from: d */
    private JSONArray m12162d(List<ByteString> list) {
        JSONArray jSONArray = new JSONArray();
        for (ByteString e : list) {
            FirebaseAbt.ExperimentPayload e2 = m12163e(e);
            if (e2 != null) {
                try {
                    jSONArray.put(m12161c(e2));
                } catch (JSONException e3) {
                    Log.d(FirebaseRemoteConfig.TAG, "A legacy ABT experiment could not be parsed.", e3);
                }
            }
        }
        return jSONArray;
    }

    @Nullable
    /* renamed from: e */
    private FirebaseAbt.ExperimentPayload m12163e(ByteString byteString) {
        try {
            ByteString.ByteIterator it = byteString.iterator();
            int size = byteString.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = ((Byte) it.next()).byteValue();
            }
            return FirebaseAbt.ExperimentPayload.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            Log.d(FirebaseRemoteConfig.TAG, "Payload was not defined or could not be deserialized.", e);
            return null;
        }
    }

    @WorkerThread
    /* renamed from: g */
    private Map<String, C3586b> m12164g() {
        ConfigPersistence.PersistedConfig h = m12165h();
        HashMap hashMap = new HashMap();
        if (h == null) {
            return hashMap;
        }
        Map<String, ConfigContainer> a = m12159a(h.getActiveConfigHolder());
        Map<String, ConfigContainer> a2 = m12159a(h.getFetchedConfigHolder());
        Map<String, ConfigContainer> a3 = m12159a(h.getDefaultsConfigHolder());
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(a.keySet());
        hashSet.addAll(a2.keySet());
        hashSet.addAll(a3.keySet());
        for (String str : hashSet) {
            C3586b bVar = new C3586b((C3585a) null);
            if (a.containsKey(str)) {
                bVar.m12178j(a.get(str));
            }
            if (a2.containsKey(str)) {
                bVar.m12180l(a2.get(str));
            }
            if (a3.containsKey(str)) {
                bVar.m12179k(a3.get(str));
            }
            hashMap.put(str, bVar);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031 A[SYNTHETIC, Splitter:B:24:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0043 A[SYNTHETIC, Splitter:B:35:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x004f A[SYNTHETIC, Splitter:B:42:0x004f] */
    @androidx.annotation.WorkerThread
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.firebase.remoteconfig.proto.ConfigPersistence.PersistedConfig m12165h() {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to close persisted config file."
            java.lang.String r1 = "FirebaseRemoteConfig"
            android.content.Context r2 = r7.f20278a
            r3 = 0
            if (r2 != 0) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r4 = "persisted_config"
            java.io.FileInputStream r2 = r2.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0028, all -> 0x0023 }
            com.google.firebase.remoteconfig.proto.ConfigPersistence$PersistedConfig r3 = com.google.firebase.remoteconfig.proto.ConfigPersistence.PersistedConfig.parseFrom((java.io.InputStream) r2)     // Catch:{ FileNotFoundException -> 0x0021, IOException -> 0x001f }
            if (r2 == 0) goto L_0x001e
            r2.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r2 = move-exception
            android.util.Log.d(r1, r0, r2)
        L_0x001e:
            return r3
        L_0x001f:
            r4 = move-exception
            goto L_0x002a
        L_0x0021:
            r4 = move-exception
            goto L_0x003c
        L_0x0023:
            r2 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x004d
        L_0x0028:
            r4 = move-exception
            r2 = r3
        L_0x002a:
            java.lang.String r5 = "Cannot initialize from persisted config."
            android.util.Log.d(r1, r5, r4)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            android.util.Log.d(r1, r0, r2)
        L_0x0039:
            return r3
        L_0x003a:
            r4 = move-exception
            r2 = r3
        L_0x003c:
            java.lang.String r5 = "Persisted config file was not found."
            android.util.Log.d(r1, r5, r4)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r2 = move-exception
            android.util.Log.d(r1, r0, r2)
        L_0x004b:
            return r3
        L_0x004c:
            r3 = move-exception
        L_0x004d:
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r2 = move-exception
            android.util.Log.d(r1, r0, r2)
        L_0x0057:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.LegacyConfigsHandler.m12165h():com.google.firebase.remoteconfig.proto.ConfigPersistence$PersistedConfig");
    }

    @WorkerThread
    /* renamed from: i */
    private void m12166i(Map<String, C3586b> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            C3586b bVar = (C3586b) next.getValue();
            ConfigCacheClient f = mo22661f(str, RemoteConfigComponent.FETCH_FILE_NAME);
            ConfigCacheClient f2 = mo22661f(str, RemoteConfigComponent.ACTIVATE_FILE_NAME);
            ConfigCacheClient f3 = mo22661f(str, RemoteConfigComponent.DEFAULTS_FILE_NAME);
            if (bVar.m12177i() != null) {
                f.put(bVar.m12177i());
            }
            if (bVar.m12175g() != null) {
                f2.put(bVar.m12175g());
            }
            if (bVar.m12176h() != null) {
                f3.put(bVar.m12176h());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public ConfigCacheClient mo22661f(String str, String str2) {
        return RemoteConfigComponent.getCacheClient(this.f20278a, this.f20279b, str, str2);
    }

    @WorkerThread
    public boolean saveLegacyConfigsIfNecessary() {
        if (!this.f20280c.getBoolean("save_legacy_configs", true)) {
            return false;
        }
        m12166i(m12164g());
        this.f20280c.edit().putBoolean("save_legacy_configs", false).commit();
        return true;
    }
}
