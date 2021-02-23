package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.p006a.zza;
import com.google.android.datatransport.cct.p006a.zzb;
import com.google.android.datatransport.cct.p006a.zzo;
import com.google.android.datatransport.cct.p006a.zzp;
import com.google.android.datatransport.cct.p006a.zzq;
import com.google.android.datatransport.cct.p006a.zzr;
import com.google.android.datatransport.cct.p006a.zzt;
import com.google.android.datatransport.cct.p006a.zzu;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.google.android.datatransport.cct.c */
final class C1574c implements TransportBackend {

    /* renamed from: a */
    private final DataEncoder f7152a = new JsonDataEncoderBuilder().configureWith(zzb.zza).ignoreNullValues(true).build();

    /* renamed from: b */
    private final ConnectivityManager f7153b;

    /* renamed from: c */
    final URL f7154c;

    /* renamed from: d */
    private final Clock f7155d;

    /* renamed from: e */
    private final Clock f7156e;

    /* renamed from: f */
    private final int f7157f;

    /* renamed from: com.google.android.datatransport.cct.c$a */
    static final class C1575a {

        /* renamed from: a */
        final URL f7158a;

        /* renamed from: b */
        final zzo f7159b;
        @Nullable

        /* renamed from: c */
        final String f7160c;

        C1575a(URL url, zzo zzo, @Nullable String str) {
            this.f7158a = url;
            this.f7159b = zzo;
            this.f7160c = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1575a mo11361a(URL url) {
            return new C1575a(url, this.f7159b, this.f7160c);
        }
    }

    /* renamed from: com.google.android.datatransport.cct.c$b */
    static final class C1576b {

        /* renamed from: a */
        final int f7161a;
        @Nullable

        /* renamed from: b */
        final URL f7162b;

        /* renamed from: c */
        final long f7163c;

        C1576b(int i, @Nullable URL url, long j) {
            this.f7161a = i;
            this.f7162b = url;
            this.f7163c = j;
        }
    }

    C1574c(Context context, Clock clock, Clock clock2) {
        this.f7153b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f7154c = m5029d(CCTDestination.f7079c);
        this.f7155d = clock2;
        this.f7156e = clock;
        this.f7157f = 40000;
    }

    /* renamed from: a */
    static /* synthetic */ C1575a m5026a(C1575a aVar, C1576b bVar) {
        URL url = bVar.f7162b;
        if (url == null) {
            return null;
        }
        Logging.m5072d("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return aVar.mo11361a(bVar.f7162b);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0116 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0133 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x013a */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.datatransport.cct.C1574c.C1576b m5027b(com.google.android.datatransport.cct.C1574c.C1575a r14) {
        /*
            r13 = this;
            java.net.URL r0 = r14.f7158a
            java.lang.String r1 = "CctTransportBackend"
            java.lang.String r2 = "Making request to: %s"
            com.google.android.datatransport.runtime.logging.Logging.m5072d((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object) r0)
            java.net.URL r0 = r14.f7158a
            java.net.URLConnection r0 = r0.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r2 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r2)
            int r2 = r13.f7157f
            r0.setReadTimeout(r2)
            r2 = 1
            r0.setDoOutput(r2)
            r3 = 0
            r0.setInstanceFollowRedirects(r3)
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "2.3.1"
            r2[r3] = r4
            java.lang.String r3 = "datatransport/%s android/"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "User-Agent"
            r0.setRequestProperty(r3, r2)
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r0.setRequestProperty(r2, r3)
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r0.setRequestProperty(r4, r5)
            java.lang.String r5 = "Accept-Encoding"
            r0.setRequestProperty(r5, r3)
            java.lang.String r5 = r14.f7160c
            if (r5 == 0) goto L_0x0055
            java.lang.String r6 = "X-Goog-Api-Key"
            r0.setRequestProperty(r6, r5)
        L_0x0055:
            r5 = 0
            r7 = 0
            java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ ConnectException -> 0x014d, UnknownHostException -> 0x014b, EncodingException -> 0x013d, IOException -> 0x013b }
            java.util.zip.GZIPOutputStream r9 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0134 }
            r9.<init>(r8)     // Catch:{ all -> 0x0134 }
            com.google.firebase.encoders.DataEncoder r10 = r13.f7152a     // Catch:{ all -> 0x012f }
            com.google.android.datatransport.cct.a.zzo r14 = r14.f7159b     // Catch:{ all -> 0x012f }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ all -> 0x012f }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x012f }
            r12.<init>(r9)     // Catch:{ all -> 0x012f }
            r11.<init>(r12)     // Catch:{ all -> 0x012f }
            r10.encode(r14, r11)     // Catch:{ all -> 0x012f }
            r9.close()     // Catch:{ all -> 0x0134 }
            if (r8 == 0) goto L_0x007a
            r8.close()     // Catch:{ ConnectException -> 0x014d, UnknownHostException -> 0x014b, EncodingException -> 0x013d, IOException -> 0x013b }
        L_0x007a:
            int r14 = r0.getResponseCode()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Status Code: "
            r8.append(r9)
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            com.google.android.datatransport.runtime.logging.Logging.m5076i(r1, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Content-Type: "
            r8.append(r9)
            java.lang.String r4 = r0.getHeaderField(r4)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            com.google.android.datatransport.runtime.logging.Logging.m5076i(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "Content-Encoding: "
            r4.append(r8)
            java.lang.String r8 = r0.getHeaderField(r2)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.google.android.datatransport.runtime.logging.Logging.m5076i(r1, r4)
            r1 = 302(0x12e, float:4.23E-43)
            if (r14 == r1) goto L_0x011e
            r1 = 301(0x12d, float:4.22E-43)
            if (r14 == r1) goto L_0x011e
            r1 = 307(0x133, float:4.3E-43)
            if (r14 != r1) goto L_0x00cf
            goto L_0x011e
        L_0x00cf:
            r1 = 200(0xc8, float:2.8E-43)
            if (r14 == r1) goto L_0x00d9
            com.google.android.datatransport.cct.c$b r0 = new com.google.android.datatransport.cct.c$b
            r0.<init>(r14, r7, r5)
            return r0
        L_0x00d9:
            java.io.InputStream r1 = r0.getInputStream()
            java.lang.String r0 = r0.getHeaderField(r2)     // Catch:{ all -> 0x0117 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x00ed
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0117 }
            r0.<init>(r1)     // Catch:{ all -> 0x0117 }
            goto L_0x00ee
        L_0x00ed:
            r0 = r1
        L_0x00ee:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0110 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0110 }
            r3.<init>(r0)     // Catch:{ all -> 0x0110 }
            r2.<init>(r3)     // Catch:{ all -> 0x0110 }
            com.google.android.datatransport.cct.a.zzs r2 = com.google.android.datatransport.cct.p006a.zzs.zza(r2)     // Catch:{ all -> 0x0110 }
            long r2 = r2.zza()     // Catch:{ all -> 0x0110 }
            com.google.android.datatransport.cct.c$b r4 = new com.google.android.datatransport.cct.c$b     // Catch:{ all -> 0x0110 }
            r4.<init>(r14, r7, r2)     // Catch:{ all -> 0x0110 }
            if (r0 == 0) goto L_0x010a
            r0.close()     // Catch:{ all -> 0x0117 }
        L_0x010a:
            if (r1 == 0) goto L_0x010f
            r1.close()
        L_0x010f:
            return r4
        L_0x0110:
            r14 = move-exception
            if (r0 == 0) goto L_0x0116
            r0.close()     // Catch:{ all -> 0x0116 }
        L_0x0116:
            throw r14     // Catch:{ all -> 0x0117 }
        L_0x0117:
            r14 = move-exception
            if (r1 == 0) goto L_0x011d
            r1.close()     // Catch:{ all -> 0x011d }
        L_0x011d:
            throw r14
        L_0x011e:
            java.lang.String r1 = "Location"
            java.lang.String r0 = r0.getHeaderField(r1)
            com.google.android.datatransport.cct.c$b r1 = new com.google.android.datatransport.cct.c$b
            java.net.URL r2 = new java.net.URL
            r2.<init>(r0)
            r1.<init>(r14, r2, r5)
            return r1
        L_0x012f:
            r14 = move-exception
            r9.close()     // Catch:{ all -> 0x0133 }
        L_0x0133:
            throw r14     // Catch:{ all -> 0x0134 }
        L_0x0134:
            r14 = move-exception
            if (r8 == 0) goto L_0x013a
            r8.close()     // Catch:{ all -> 0x013a }
        L_0x013a:
            throw r14     // Catch:{ ConnectException -> 0x014d, UnknownHostException -> 0x014b, EncodingException -> 0x013d, IOException -> 0x013b }
        L_0x013b:
            r14 = move-exception
            goto L_0x013e
        L_0x013d:
            r14 = move-exception
        L_0x013e:
            java.lang.String r0 = "Couldn't encode request, returning with 400"
            com.google.android.datatransport.runtime.logging.Logging.m5075e(r1, r0, r14)
            com.google.android.datatransport.cct.c$b r14 = new com.google.android.datatransport.cct.c$b
            r0 = 400(0x190, float:5.6E-43)
            r14.<init>(r0, r7, r5)
            return r14
        L_0x014b:
            r14 = move-exception
            goto L_0x014e
        L_0x014d:
            r14 = move-exception
        L_0x014e:
            java.lang.String r0 = "Couldn't open connection, returning with 500"
            com.google.android.datatransport.runtime.logging.Logging.m5075e(r1, r0, r14)
            com.google.android.datatransport.cct.c$b r14 = new com.google.android.datatransport.cct.c$b
            r0 = 500(0x1f4, float:7.0E-43)
            r14.<init>(r0, r7, r5)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.C1574c.m5027b(com.google.android.datatransport.cct.c$a):com.google.android.datatransport.cct.c$b");
    }

    /* renamed from: d */
    private static URL m5029d(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.f7153b.getActiveNetworkInfo();
        EventInternal.Builder addMetadata = eventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        EventInternal.Builder addMetadata2 = addMetadata.addMetadata("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        if (activeNetworkInfo == null) {
            i = zzt.zzc.NONE.zza();
        } else {
            i = activeNetworkInfo.getType();
        }
        EventInternal.Builder addMetadata3 = addMetadata2.addMetadata("net-type", i);
        if (activeNetworkInfo == null) {
            i2 = zzt.zzb.UNKNOWN_MOBILE_SUBTYPE.zza();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = zzt.zzb.COMBINED.zza();
            } else if (zzt.zzb.zza(i2) == null) {
                i2 = 0;
            }
        }
        return addMetadata3.addMetadata("mobile-subtype", i2).build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        zzq.zza zza;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            zzr.zza zza2 = zzr.zza().zza(zzu.DEFAULT).zza(this.f7156e.getTime()).zzb(this.f7155d.getTime()).zza(zzp.zza().zza(zzp.zzb.ANDROID_FIREBASE).zza(zza.zza().zza(Integer.valueOf(eventInternal.getInteger("sdk-version"))).zze(eventInternal.get("model")).zzc(eventInternal.get("hardware")).zza(eventInternal.get("device")).zzg(eventInternal.get("product")).zzf(eventInternal.get("os-uild")).zzd(eventInternal.get("manufacturer")).zzb(eventInternal.get("fingerprint")).zza()).zza());
            try {
                zza2.zza(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                zza2.zzb((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.m5015of("proto"))) {
                    zza = zzq.zza(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.m5015of("json"))) {
                    zza = zzq.zza(new String(encodedPayload.getBytes(), Charset.forName(Key.STRING_CHARSET_NAME)));
                } else {
                    Logging.m5077w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                zza.zza(eventInternal2.getEventMillis()).zzb(eventInternal2.getUptimeMillis()).zzc(eventInternal2.getLong("tz-offset")).zza(zzt.zza().zza(zzt.zzc.zza(eventInternal2.getInteger("net-type"))).zza(zzt.zzb.zza(eventInternal2.getInteger("mobile-subtype"))).zza());
                if (eventInternal2.getCode() != null) {
                    zza.zza(eventInternal2.getCode());
                }
                arrayList3.add(zza.zza());
            }
            zza2.zza((List<zzq>) arrayList3);
            arrayList2.add(zza2.zza());
        }
        zzo zza3 = zzo.zza(arrayList2);
        String str = null;
        URL url = this.f7154c;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = m5029d(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.fatalError();
            }
        }
        try {
            C1576b bVar = (C1576b) Retries.retry(5, new C1575a(url, zza3, str), C1549a.m5016a(this), C1573b.m5025a());
            int i = bVar.f7161a;
            if (i == 200) {
                return BackendResponse.m5052ok(bVar.f7163c);
            }
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e) {
            Logging.m5075e("CctTransportBackend", "Could not make request to the backend", e);
            return BackendResponse.transientError();
        }
    }
}
