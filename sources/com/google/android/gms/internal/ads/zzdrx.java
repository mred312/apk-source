package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdrx {

    /* renamed from: a */
    private final zzcum f15903a;

    /* renamed from: b */
    private final String f15904b;

    /* renamed from: c */
    private final String f15905c;

    /* renamed from: d */
    private final String f15906d;

    /* renamed from: e */
    private final Context f15907e;

    /* renamed from: f */
    private final zzdni f15908f;

    /* renamed from: g */
    private final Clock f15909g;

    /* renamed from: h */
    private final zzef f15910h;

    public zzdrx(zzcum zzcum, zzazh zzazh, String str, String str2, Context context, @Nullable zzdni zzdni, Clock clock, zzef zzef) {
        this.f15903a = zzcum;
        this.f15904b = zzazh.zzbrf;
        this.f15905c = str;
        this.f15906d = str2;
        this.f15907e = context;
        this.f15908f = zzdni;
        this.f15909g = clock;
        this.f15910h = zzef;
    }

    /* renamed from: a */
    private static String m8477a(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    /* renamed from: b */
    private static String m8478b(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzayu.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    public final List<String> zza(zzdnj zzdnj, zzdmu zzdmu, List<String> list) {
        return zza(zzdnj, zzdmu, false, "", "", list);
    }

    public static List<String> zza(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String a : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(2);
            sb.append(".");
            sb.append(i2);
            arrayList.add(m8477a(a, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    public final List<String> zza(zzdnj zzdnj, @Nullable zzdmu zzdmu, boolean z, String str, @Nullable String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String a : list) {
            String a2 = m8477a(m8477a(m8477a(a, "@gw_adlocid@", zzdnj.zzhij.zzfvl.zzhip), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.f15904b);
            if (zzdmu != null) {
                a2 = zzaxm.zzc(m8477a(m8477a(m8477a(a2, "@gw_qdata@", zzdmu.zzdly), "@gw_adnetid@", zzdmu.f15787id), "@gw_allocid@", zzdmu.zzdkx), this.f15907e, zzdmu.zzdvo);
            }
            String a3 = m8477a(m8477a(m8477a(a2, "@gw_adnetstatus@", this.f15903a.zzarn()), "@gw_seqnum@", this.f15905c), "@gw_sessid@", this.f15906d);
            boolean z2 = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcrp)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.f15910h.zzb(Uri.parse(a3))) {
                    Uri.Builder buildUpon = Uri.parse(a3).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    a3 = buildUpon.build().toString();
                }
            }
            arrayList.add(a3);
        }
        return arrayList;
    }

    public final List<String> zza(zzdmu zzdmu, List<String> list, zzauf zzauf) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.f15909g.currentTimeMillis();
        try {
            String type = zzauf.getType();
            String num = Integer.toString(zzauf.getAmount());
            zzdni zzdni = this.f15908f;
            String str = "";
            String b = zzdni == null ? str : m8478b(zzdni.zzdxy);
            zzdni zzdni2 = this.f15908f;
            if (zzdni2 != null) {
                str = m8478b(zzdni2.zzdxz);
            }
            for (String a : list) {
                arrayList.add(zzaxm.zzc(m8477a(m8477a(m8477a(m8477a(m8477a(m8477a(a, "@gw_rwd_userid@", Uri.encode(b)), "@gw_rwd_custom_data@", Uri.encode(str)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.f15904b), this.f15907e, zzdmu.zzdvo));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzaza.zzc("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }
}
