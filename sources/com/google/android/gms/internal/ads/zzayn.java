package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzayn {
    @VisibleForTesting

    /* renamed from: a */
    private long f12946a = -1;
    @VisibleForTesting

    /* renamed from: b */
    private long f12947b = -1;
    @GuardedBy("lock")
    @VisibleForTesting

    /* renamed from: c */
    private int f12948c = -1;
    @VisibleForTesting

    /* renamed from: d */
    int f12949d = -1;
    @VisibleForTesting

    /* renamed from: e */
    private long f12950e = 0;

    /* renamed from: f */
    private final Object f12951f = new Object();
    @VisibleForTesting

    /* renamed from: g */
    private final String f12952g;

    /* renamed from: h */
    private final zzf f12953h;
    @GuardedBy("lock")
    @VisibleForTesting

    /* renamed from: i */
    private int f12954i = 0;
    @GuardedBy("lock")
    @VisibleForTesting

    /* renamed from: j */
    private int f12955j = 0;

    public zzayn(String str, zzf zzf) {
        this.f12952g = str;
        this.f12953h = zzf;
    }

    /* renamed from: a */
    private static boolean m7614a(Context context) {
        Context zzy = zzauc.zzy(context);
        int identifier = zzy.getResources().getIdentifier("Theme.Translucent", "style", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier == 0) {
            zzaza.zzez("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzy.getPackageManager().getActivityInfo(new ComponentName(zzy.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzaza.zzez("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzaza.zzfa("Fail to fetch AdActivity theme");
            zzaza.zzez("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzvk r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f12951f
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzf r1 = r10.f12953h     // Catch:{ all -> 0x0075 }
            long r1 = r1.zzxw()     // Catch:{ all -> 0x0075 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ all -> 0x0075 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0075 }
            long r5 = r10.f12947b     // Catch:{ all -> 0x0075 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzabf.zzcop     // Catch:{ all -> 0x0075 }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0075 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x0075 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0075 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0075 }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.f12949d = r1     // Catch:{ all -> 0x0075 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzf r1 = r10.f12953h     // Catch:{ all -> 0x0075 }
            int r1 = r1.zzxx()     // Catch:{ all -> 0x0075 }
            r10.f12949d = r1     // Catch:{ all -> 0x0075 }
        L_0x003b:
            r10.f12947b = r12     // Catch:{ all -> 0x0075 }
            r10.f12946a = r12     // Catch:{ all -> 0x0075 }
            goto L_0x0042
        L_0x0040:
            r10.f12946a = r12     // Catch:{ all -> 0x0075 }
        L_0x0042:
            r12 = 1
            if (r11 == 0) goto L_0x0054
            android.os.Bundle r11 = r11.extras     // Catch:{ all -> 0x0075 }
            if (r11 == 0) goto L_0x0054
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x0075 }
            if (r11 != r12) goto L_0x0054
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            return
        L_0x0054:
            int r11 = r10.f12948c     // Catch:{ all -> 0x0075 }
            int r11 = r11 + r12
            r10.f12948c = r11     // Catch:{ all -> 0x0075 }
            int r11 = r10.f12949d     // Catch:{ all -> 0x0075 }
            int r11 = r11 + r12
            r10.f12949d = r11     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x006a
            r11 = 0
            r10.f12950e = r11     // Catch:{ all -> 0x0075 }
            com.google.android.gms.ads.internal.util.zzf r11 = r10.f12953h     // Catch:{ all -> 0x0075 }
            r11.zzfa(r3)     // Catch:{ all -> 0x0075 }
            goto L_0x0073
        L_0x006a:
            com.google.android.gms.ads.internal.util.zzf r11 = r10.f12953h     // Catch:{ all -> 0x0075 }
            long r11 = r11.zzxy()     // Catch:{ all -> 0x0075 }
            long r3 = r3 - r11
            r10.f12950e = r3     // Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            return
        L_0x0075:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0075 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayn.zza(com.google.android.gms.internal.ads.zzvk, long):void");
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.f12951f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f12952g);
            bundle.putLong("basets", this.f12947b);
            bundle.putLong("currts", this.f12946a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f12948c);
            bundle.putInt("preqs_in_session", this.f12949d);
            bundle.putLong("time_in_session", this.f12950e);
            bundle.putInt("pclick", this.f12954i);
            bundle.putInt("pimp", this.f12955j);
            bundle.putBoolean("support_transparent_background", m7614a(context));
        }
        return bundle;
    }

    public final void zzwp() {
        synchronized (this.f12951f) {
            this.f12955j++;
        }
    }

    public final void zzwq() {
        synchronized (this.f12951f) {
            this.f12954i++;
        }
    }
}
