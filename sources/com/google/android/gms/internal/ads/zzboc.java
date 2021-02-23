package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzboc {

    /* renamed from: a */
    private final zzbso f13579a;

    /* renamed from: b */
    private final zzbte f13580b;
    @Nullable

    /* renamed from: c */
    private final zzdki f13581c;

    /* renamed from: d */
    private final zzbrp f13582d;

    /* renamed from: e */
    private final zzbul f13583e;
    protected final zzdmu zzeri;
    protected final zzdnj zzfpr;

    protected zzboc(zzbob zzbob) {
        this.zzfpr = zzbob.f13572a;
        this.zzeri = zzbob.f13573b;
        this.f13579a = zzbob.f13574c;
        this.f13580b = zzbob.f13575d;
        this.f13581c = zzbob.f13576e;
        this.f13582d = zzbob.f13577f;
        this.f13583e = zzbob.f13578g;
    }

    public void destroy() {
        this.f13579a.zzce((Context) null);
    }

    public void zzajj() {
        this.f13580b.onAdLoaded();
    }

    public final zzbso zzajy() {
        return this.f13579a;
    }

    public final zzbrp zzajz() {
        return this.f13582d;
    }

    @Nullable
    public final zzdki zzaka() {
        return this.f13581c;
    }

    public final zzbvn zzakb() {
        return this.f13583e.zzakb();
    }
}
