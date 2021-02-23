package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzyz {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashSet<String> f17110a = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Bundle f17111b = new Bundle();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f17112c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HashSet<String> f17113d = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Bundle f17114e = new Bundle();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final HashSet<String> f17115f = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Date f17116g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f17117h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final List<String> f17118i = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f17119j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Location f17120k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f17121l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f17122m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f17123n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f17124o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f17125p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public AdInfo f17126q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f17127r = -1;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f17128s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f17129t = 60000;

    public final void setManualImpressionsEnabled(boolean z) {
        this.f17121l = z;
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.f17112c.put(networkExtras.getClass(), networkExtras);
        }
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.f17125p = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.f17111b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.f17111b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.f17111b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzc(List<String> list) {
        this.f17118i.clear();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                zzaza.zzfa("neighboring content URL should not be null or empty");
            } else {
                this.f17118i.add(next);
            }
        }
    }

    public final void zzcf(String str) {
        this.f17110a.add(str);
    }

    public final void zzcg(String str) {
        this.f17113d.add(str);
    }

    public final void zzch(String str) {
        this.f17113d.remove(str);
    }

    public final void zzci(String str) {
        this.f17117h = str;
    }

    public final void zzcj(String str) {
        this.f17122m = str;
    }

    public final void zzck(String str) {
        this.f17123n = str;
    }

    public final void zzcl(String str) {
        this.f17115f.add(str);
    }

    @Deprecated
    public final void zzcm(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.f17128s = str;
        }
    }

    @Deprecated
    public final void zzcw(int i) {
        this.f17119j = i;
    }

    @Deprecated
    public final void zzcx(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.f17127r = i;
        }
    }

    public final void zzcy(int i) {
        this.f17129t = i;
    }

    public final void zze(String str, String str2) {
        this.f17114e.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.f17124o = z ? 1 : 0;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.f17111b.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.f17116g = date;
    }

    public final void zza(Location location) {
        this.f17120k = location;
    }

    public final void zza(AdInfo adInfo) {
        this.f17126q = adInfo;
    }
}
