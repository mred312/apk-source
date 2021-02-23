package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzeac<PrimitiveT, KeyProtoT extends zzels> implements zzdzz<PrimitiveT> {

    /* renamed from: a */
    private final zzeae<KeyProtoT> f16089a;

    /* renamed from: b */
    private final Class<PrimitiveT> f16090b;

    public zzeac(zzeae<KeyProtoT> zzeae, Class<PrimitiveT> cls) {
        if (zzeae.zzazw().contains(cls) || Void.class.equals(cls)) {
            this.f16089a = zzeae;
            this.f16090b = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzeae.toString(), cls.getName()}));
    }

    /* renamed from: a */
    private final i40<?, KeyProtoT> m8611a() {
        return new i40<>(this.f16089a.zzazy());
    }

    /* renamed from: b */
    private final PrimitiveT m8612b(KeyProtoT keyprotot) {
        if (!Void.class.equals(this.f16090b)) {
            this.f16089a.zze(keyprotot);
            return this.f16089a.zza(keyprotot, this.f16090b);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final String getKeyType() {
        return this.f16089a.getKeyType();
    }

    public final PrimitiveT zza(zzels zzels) {
        String valueOf = String.valueOf(this.f16089a.zzazu().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.f16089a.zzazu().isInstance(zzels)) {
            return m8612b(zzels);
        }
        throw new GeneralSecurityException(concat);
    }

    public final Class<PrimitiveT> zzazr() {
        return this.f16090b;
    }

    public final PrimitiveT zzm(zzeiu zzeiu) {
        try {
            return m8612b(this.f16089a.zzr(zzeiu));
        } catch (zzeks e) {
            String valueOf = String.valueOf(this.f16089a.zzazu().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzels zzn(zzeiu zzeiu) {
        try {
            return m8611a().mo14247a(zzeiu);
        } catch (zzeks e) {
            String valueOf = String.valueOf(this.f16089a.zzazy().zzazt().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzefh zzo(zzeiu zzeiu) {
        try {
            return (zzefh) ((zzekh) zzefh.zzbdi().zzho(this.f16089a.getKeyType()).zzag(m8611a().mo14247a(zzeiu).zzbfg()).zzb(this.f16089a.zzazv()).zzbhv());
        } catch (zzeks e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
