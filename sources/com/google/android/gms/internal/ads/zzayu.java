package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzayu {

    /* renamed from: b */
    private static Object f12972b = new Object();
    @GuardedBy("lock")

    /* renamed from: c */
    private static boolean f12973c = false;
    @GuardedBy("lock")

    /* renamed from: d */
    private static boolean f12974d = false;

    /* renamed from: e */
    private static Clock f12975e = DefaultClock.getInstance();

    /* renamed from: f */
    private static final Set<String> f12976f = new HashSet(Arrays.asList(new String[0]));

    /* renamed from: a */
    private final List<String> f12977a;

    public zzayu() {
        this((String) null);
    }

    /* renamed from: a */
    static final /* synthetic */ void m7616a(int i, Map map, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        m7617b(jsonWriter, map);
        jsonWriter.endObject();
    }

    /* renamed from: b */
    private static void m7617b(JsonWriter jsonWriter, @Nullable Map<String, ?> map) {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (!f12976f.contains(str)) {
                    if (!(next.getValue() instanceof List)) {
                        if (!(next.getValue() instanceof String)) {
                            zzaza.zzey("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value((String) next.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String value : (List) next.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name("value").value(value);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: c */
    static final /* synthetic */ void m7618c(String str, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    /* renamed from: d */
    private final void m7619d(String str, C2651z5 z5Var) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(f12975e.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.f12977a) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            z5Var.mo14895a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzaza.zzc("unable to log", e);
        }
        m7625j(stringWriter.toString());
    }

    /* renamed from: e */
    static final /* synthetic */ void m7620e(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        m7617b(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    /* renamed from: f */
    static final /* synthetic */ void m7621f(byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zzet = zzayr.zzet(encode);
            if (zzet != null) {
                jsonWriter.name("bodydigest").value(zzet);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    /* renamed from: g */
    private final void m7622g(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        m7619d("onNetworkRequest", new C2538w5(str, str2, map, bArr));
    }

    /* renamed from: h */
    private final void m7623h(@Nullable Map<String, ?> map, int i) {
        m7619d("onNetworkResponse", new C2501v5(i, map));
    }

    /* renamed from: i */
    private final void m7624i(@Nullable String str) {
        m7619d("onNetworkRequestError", new C2576x5(str));
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (f12972b) {
            z = f12973c && f12974d;
        }
        return z;
    }

    /* renamed from: j */
    private static synchronized void m7625j(String str) {
        synchronized (zzayu.class) {
            zzaza.zzez("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzaza.zzez(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzaza.zzez("GMA Debug FINISH");
        }
    }

    public static void zzaq(boolean z) {
        synchronized (f12972b) {
            f12973c = true;
            f12974d = z;
        }
    }

    public static boolean zzbu(Context context) {
        if (Build.VERSION.SDK_INT < 17 || !zzacw.zzdby.get().booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzaza.zzd("Fail to determine debug setting.", e);
            return false;
        }
    }

    public static void zzzg() {
        synchronized (f12972b) {
            f12973c = false;
            f12974d = false;
            zzaza.zzfa("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzzh() {
        boolean z;
        synchronized (f12972b) {
            z = f12973c;
        }
        return z;
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        HashMap hashMap;
        if (isEnabled()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            m7622g(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzev(@Nullable String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(byte[] bArr) {
        m7619d("onNetworkResponseBody", new C2613y5(bArr));
    }

    public zzayu(@Nullable String str) {
        List<String> list;
        if (!isEnabled()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            list = Arrays.asList(strArr);
        }
        this.f12977a = list;
    }

    public final void zza(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (isEnabled()) {
            m7622g(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            m7623h(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzaza.zzfa(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                m7624i(str);
            }
        }
    }

    public final void zza(@Nullable Map<String, ?> map, int i) {
        if (isEnabled()) {
            m7623h(map, i);
            if (i < 200 || i >= 300) {
                m7624i((String) null);
            }
        }
    }
}
