package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzajh implements AdapterStatus {

    /* renamed from: a */
    private final AdapterStatus.State f12485a;

    /* renamed from: b */
    private final String f12486b;

    /* renamed from: c */
    private final int f12487c;

    public zzajh(AdapterStatus.State state, String str, int i) {
        this.f12485a = state;
        this.f12486b = str;
        this.f12487c = i;
    }

    public final String getDescription() {
        return this.f12486b;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.f12485a;
    }

    public final int getLatency() {
        return this.f12487c;
    }
}
