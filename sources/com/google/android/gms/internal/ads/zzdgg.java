package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgg implements zzdfi<zzdgh> {

    /* renamed from: a */
    private final zzato f15578a;

    /* renamed from: b */
    private final Context f15579b;

    /* renamed from: c */
    private final String f15580c;

    /* renamed from: d */
    private final zzdzc f15581d;

    public zzdgg(@Nullable zzato zzato, Context context, String str, zzdzc zzdzc) {
        this.f15578a = zzato;
        this.f15579b = context;
        this.f15580c = str;
        this.f15581d = zzdzc;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdgh mo17097a() {
        JSONObject jSONObject = new JSONObject();
        zzato zzato = this.f15578a;
        if (zzato != null) {
            zzato.zza(this.f15579b, this.f15580c, jSONObject);
        }
        return new zzdgh(jSONObject);
    }

    public final zzdyz<zzdgh> zzasm() {
        return this.f15581d.zze(new C2601xu(this));
    }
}
