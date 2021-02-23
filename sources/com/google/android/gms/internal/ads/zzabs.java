package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabs {
    @VisibleForTesting

    /* renamed from: a */
    final boolean f12365a;

    /* renamed from: b */
    private final List<zzabq> f12366b = new LinkedList();

    /* renamed from: c */
    private final Map<String, String> f12367c;

    /* renamed from: d */
    private final Object f12368d;
    @Nullable

    /* renamed from: e */
    private zzabs f12369e;

    public zzabs(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f12367c = linkedHashMap;
        this.f12368d = new Object();
        this.f12365a = true;
        linkedHashMap.put("action", str);
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public final boolean zza(zzabq zzabq, long j, String... strArr) {
        synchronized (this.f12368d) {
            for (String zzabq2 : strArr) {
                this.f12366b.add(new zzabq(j, zzabq2, zzabq));
            }
        }
        return true;
    }

    public final void zzc(@Nullable zzabs zzabs) {
        synchronized (this.f12368d) {
            this.f12369e = zzabs;
        }
    }

    @Nullable
    public final zzabq zzex(long j) {
        if (!this.f12365a) {
            return null;
        }
        return new zzabq(j, (String) null, (zzabq) null);
    }

    public final void zzh(String str, String str2) {
        zzabi zzwt;
        if (this.f12365a && !TextUtils.isEmpty(str2) && (zzwt = zzp.zzku().zzwt()) != null) {
            synchronized (this.f12368d) {
                zzabm zzcq = zzwt.zzcq(str);
                Map<String, String> map = this.f12367c;
                map.put(str, zzcq.zzg(map.get(str), str2));
            }
        }
    }

    public final zzabv zzrw() {
        zzabv zzabv;
        boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.f12368d) {
            for (zzabq next : this.f12366b) {
                long time = next.getTime();
                String zzru = next.zzru();
                zzabq zzrv = next.zzrv();
                if (zzrv != null && time > 0) {
                    sb.append(zzru);
                    sb.append('.');
                    sb.append(time - zzrv.getTime());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzrv.getTime()))) {
                            hashMap.put(Long.valueOf(zzrv.getTime()), new StringBuilder(zzru));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzrv.getTime()));
                            sb2.append('+');
                            sb2.append(zzru);
                        }
                    }
                }
            }
            this.f12366b.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzp.zzkx().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzp.zzkx().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzabv = new zzabv(sb.toString(), str);
        }
        return zzabv;
    }

    @VisibleForTesting
    public final Map<String, String> zzrx() {
        synchronized (this.f12368d) {
            zzabi zzwt = zzp.zzku().zzwt();
            if (zzwt != null) {
                zzabs zzabs = this.f12369e;
                if (zzabs != null) {
                    Map<String, String> a = zzwt.mo15165a(this.f12367c, zzabs.zzrx());
                    return a;
                }
            }
            Map<String, String> map = this.f12367c;
            return map;
        }
    }
}
