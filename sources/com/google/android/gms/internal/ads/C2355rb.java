package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.rb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2355rb implements zzdyo<String> {

    /* renamed from: a */
    private final /* synthetic */ zzbjv f10781a;

    C2355rb(zzbjv zzbjv) {
        this.f10781a = zzbjv;
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        int i;
        zzdnv e = this.f10781a.f13368g;
        List<String> zza = this.f10781a.f13367f.zza(this.f10781a.f13365d, this.f10781a.f13366e, false, "", (String) obj, this.f10781a.f13366e.zzdls);
        zzp.zzkq();
        if (zzm.zzbc(this.f10781a.f13362a)) {
            i = zzcql.zzgqc;
        } else {
            i = zzcql.zzgqb;
        }
        e.zza(zza, i);
    }

    public final void zzb(Throwable th) {
        int i;
        zzdnv e = this.f10781a.f13368g;
        List<String> zza = this.f10781a.f13367f.zza(this.f10781a.f13365d, this.f10781a.f13366e, false, "", "failure_click_attok", this.f10781a.f13366e.zzdls);
        zzp.zzkq();
        if (zzm.zzbc(this.f10781a.f13362a)) {
            i = zzcql.zzgqc;
        } else {
            i = zzcql.zzgqb;
        }
        e.zza(zza, i);
    }
}
