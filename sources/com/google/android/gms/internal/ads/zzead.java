package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzead<KeyFormatProtoT extends zzels, KeyT> {

    /* renamed from: a */
    private final Class<KeyFormatProtoT> f16091a;

    public zzead(Class<KeyFormatProtoT> cls) {
        this.f16091a = cls;
    }

    public final Class<KeyFormatProtoT> zzazt() {
        return this.f16091a;
    }

    public abstract void zzc(KeyFormatProtoT keyformatprotot);

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot);

    public abstract KeyFormatProtoT zzq(zzeiu zzeiu);
}
