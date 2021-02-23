package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzza {

    /* renamed from: a */
    private final Date f17130a;

    /* renamed from: b */
    private final String f17131b;

    /* renamed from: c */
    private final List<String> f17132c;

    /* renamed from: d */
    private final int f17133d;

    /* renamed from: e */
    private final Set<String> f17134e;

    /* renamed from: f */
    private final Location f17135f;

    /* renamed from: g */
    private final boolean f17136g;

    /* renamed from: h */
    private final Bundle f17137h;

    /* renamed from: i */
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f17138i;

    /* renamed from: j */
    private final String f17139j;

    /* renamed from: k */
    private final String f17140k;

    /* renamed from: l */
    private final SearchAdRequest f17141l;

    /* renamed from: m */
    private final int f17142m;

    /* renamed from: n */
    private final Set<String> f17143n;

    /* renamed from: o */
    private final Bundle f17144o;

    /* renamed from: p */
    private final Set<String> f17145p;

    /* renamed from: q */
    private final boolean f17146q;

    /* renamed from: r */
    private final AdInfo f17147r;

    /* renamed from: s */
    private final int f17148s;

    /* renamed from: t */
    private final String f17149t;

    /* renamed from: u */
    private final int f17150u;

    public zzza(zzyz zzyz) {
        this(zzyz, (SearchAdRequest) null);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f17130a;
    }

    public final String getContentUrl() {
        return this.f17131b;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.f17137h.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.f17144o;
    }

    @Deprecated
    public final int getGender() {
        return this.f17133d;
    }

    public final Set<String> getKeywords() {
        return this.f17134e;
    }

    public final Location getLocation() {
        return this.f17135f;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.f17136g;
    }

    @Nullable
    public final String getMaxAdContentRating() {
        return this.f17149t;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.f17138i.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.f17137h.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.f17139j;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f17146q;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzzd.zzrb().getRequestConfiguration();
        zzwq.zzqa();
        String zzbn = zzayr.zzbn(context);
        return this.f17143n.contains(zzbn) || requestConfiguration.getTestDeviceIds().contains(zzbn);
    }

    public final List<String> zzqr() {
        return new ArrayList(this.f17132c);
    }

    public final String zzqs() {
        return this.f17140k;
    }

    public final SearchAdRequest zzqt() {
        return this.f17141l;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqu() {
        return this.f17138i;
    }

    public final Bundle zzqv() {
        return this.f17137h;
    }

    public final int zzqw() {
        return this.f17142m;
    }

    public final Set<String> zzqx() {
        return this.f17145p;
    }

    @Nullable
    public final AdInfo zzqy() {
        return this.f17147r;
    }

    public final int zzqz() {
        return this.f17148s;
    }

    public final int zzra() {
        return this.f17150u;
    }

    public zzza(zzyz zzyz, SearchAdRequest searchAdRequest) {
        this.f17130a = zzyz.f17116g;
        this.f17131b = zzyz.f17117h;
        this.f17132c = zzyz.f17118i;
        this.f17133d = zzyz.f17119j;
        this.f17134e = Collections.unmodifiableSet(zzyz.f17110a);
        this.f17135f = zzyz.f17120k;
        this.f17136g = zzyz.f17121l;
        this.f17137h = zzyz.f17111b;
        this.f17138i = Collections.unmodifiableMap(zzyz.f17112c);
        this.f17139j = zzyz.f17122m;
        this.f17140k = zzyz.f17123n;
        this.f17141l = searchAdRequest;
        this.f17142m = zzyz.f17124o;
        this.f17143n = Collections.unmodifiableSet(zzyz.f17113d);
        this.f17144o = zzyz.f17114e;
        this.f17145p = Collections.unmodifiableSet(zzyz.f17115f);
        this.f17146q = zzyz.f17125p;
        this.f17147r = zzyz.f17126q;
        this.f17148s = zzyz.f17127r;
        this.f17149t = zzyz.f17128s;
        this.f17150u = zzyz.f17129t;
    }
}
