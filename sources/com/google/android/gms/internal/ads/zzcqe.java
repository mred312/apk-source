package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqe {

    /* renamed from: g */
    private static final SparseArray<zzue.zzo.zzc> f14704g;

    /* renamed from: a */
    private final Context f14705a;

    /* renamed from: b */
    private final zzbqz f14706b;

    /* renamed from: c */
    private final TelephonyManager f14707c;

    /* renamed from: d */
    private final zzcpx f14708d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzcpr f14709e;

    /* renamed from: f */
    private zzuo f14710f;

    static {
        SparseArray<zzue.zzo.zzc> sparseArray = new SparseArray<>();
        f14704g = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzue.zzo.zzc.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzue.zzo.zzc zzc = zzue.zzo.zzc.CONNECTING;
        sparseArray.put(ordinal, zzc);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzc);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzc);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzue.zzo.zzc.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzue.zzo.zzc zzc2 = zzue.zzo.zzc.DISCONNECTED;
        sparseArray.put(ordinal2, zzc2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzc2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzc2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzc2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzc2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzue.zzo.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzc);
        }
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzc);
    }

    zzcqe(Context context, zzbqz zzbqz, zzcpx zzcpx, zzcpr zzcpr) {
        this.f14705a = context;
        this.f14706b = zzbqz;
        this.f14708d = zzcpx;
        this.f14709e = zzcpr;
        this.f14707c = (TelephonyManager) context.getSystemService("phone");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final byte[] m8234d(boolean z, ArrayList<zzue.zzc.zza> arrayList, zzue.zzm zzm, zzue.zzo.zzc zzc) {
        boolean z2 = true;
        zzue.zzo.zza.C3995zza zzeu = zzue.zzo.zza.zzoq().zzf((Iterable<? extends zzue.zzc.zza>) arrayList).zzh(m8236f(zzp.zzks().zzb(this.f14705a.getContentResolver()) != 0)).zzi(zzp.zzks().zza(this.f14705a, this.f14707c)).zzev(this.f14708d.zzard()).zzew(this.f14708d.zzarf()).zzcl(this.f14708d.getResponseCode()).zzb(zzc).zzb(zzm).zzj(this.f14710f).zzf(m8236f(z)).zzeu(zzp.zzkx().currentTimeMillis());
        if (zzp.zzks().zza(this.f14705a.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zzue.zzo.zza) ((zzekh) zzeu.zzg(m8236f(z2)).zzbhv())).toByteArray();
    }

    /* renamed from: f */
    private static zzuo m8236f(boolean z) {
        return z ? zzuo.ENUM_TRUE : zzuo.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final zzue.zzm m8238h(Bundle bundle) {
        zzue.zzm.zza zza;
        zzue.zzm.zzb zzok = zzue.zzm.zzok();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.f14710f = zzuo.ENUM_TRUE;
        } else {
            this.f14710f = zzuo.ENUM_FALSE;
            if (i == 0) {
                zzok.zzb(zzue.zzm.zzc.CELL);
            } else if (i != 1) {
                zzok.zzb(zzue.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzok.zzb(zzue.zzm.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zza = zzue.zzm.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zza = zzue.zzm.zza.THREE_G;
                    break;
                case 13:
                    zza = zzue.zzm.zza.LTE;
                    break;
                default:
                    zza = zzue.zzm.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzok.zzb(zza);
        }
        return (zzue.zzm) ((zzekh) zzok.zzbhv());
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static zzue.zzo.zzc m8239i(Bundle bundle) {
        return f14704g.get(zzdnx.zza(zzdnx.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzue.zzo.zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzue.zzc.zza> m8240j(android.os.Bundle r4) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r4 = r4.get(r0)
            boolean r0 = r4 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r4 = (java.util.List) r4
            goto L_0x0017
        L_0x000d:
            boolean r0 = r4 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r4 = (java.lang.String[]) r4
            java.util.List r4 = java.util.Arrays.asList(r4)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Iterator r4 = r4.iterator()
        L_0x0024:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r4.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r4 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r4 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x004a:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x00a2
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case -1396342996: goto L_0x0083;
                case -1052618729: goto L_0x0078;
                case -239580146: goto L_0x006d;
                case 604727084: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x008d
        L_0x0062:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x006b
            goto L_0x008d
        L_0x006b:
            r2 = 3
            goto L_0x008d
        L_0x006d:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0076
            goto L_0x008d
        L_0x0076:
            r2 = 2
            goto L_0x008d
        L_0x0078:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0081
            goto L_0x008d
        L_0x0081:
            r2 = 1
            goto L_0x008d
        L_0x0083:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            switch(r2) {
                case 0: goto L_0x009c;
                case 1: goto L_0x0099;
                case 2: goto L_0x0096;
                case 3: goto L_0x0093;
                default: goto L_0x0090;
            }
        L_0x0090:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x009e
        L_0x0093:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.INTERSTITIAL
            goto L_0x009e
        L_0x0096:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L_0x009e
        L_0x0099:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.NATIVE_APP_INSTALL
            goto L_0x009e
        L_0x009c:
            com.google.android.gms.internal.ads.zzue$zzc$zza r1 = com.google.android.gms.internal.ads.zzue.zzc.zza.BANNER
        L_0x009e:
            r0.add(r1)
            goto L_0x004a
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqe.m8240j(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbj(boolean z) {
        zzdyr.zza(this.f14706b.zzakq(), new C2181mn(this, z), zzazj.zzegu);
    }
}
