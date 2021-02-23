package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class wc0 implements zzdum {

    /* renamed from: a */
    private final zzdsj f11697a;

    /* renamed from: b */
    private final zzdsv f11698b;

    /* renamed from: c */
    private final zzfh f11699c;

    /* renamed from: d */
    private final zzey f11700d;

    wc0(@NonNull zzdsj zzdsj, @NonNull zzdsv zzdsv, @NonNull zzfh zzfh, @NonNull zzey zzey) {
        this.f11697a = zzdsj;
        this.f11698b = zzdsv;
        this.f11699c = zzfh;
        this.f11700d = zzey;
    }

    /* renamed from: b */
    private final Map<String, Object> m7134b() {
        HashMap hashMap = new HashMap();
        zzcf.zza zzco = this.f11698b.zzco();
        hashMap.put("v", this.f11697a.zzawx());
        hashMap.put("gms", Boolean.valueOf(this.f11697a.zzcm()));
        hashMap.put("int", zzco.zzaf());
        hashMap.put("up", Boolean.valueOf(this.f11700d.mo17775a()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo14974a(View view) {
        this.f11699c.mo17796f(view);
    }

    public final Map<String, Object> zzcc() {
        Map<String, Object> b = m7134b();
        zzcf.zza zzaxe = this.f11698b.zzaxe();
        b.put("gai", Boolean.valueOf(this.f11697a.zzawy()));
        b.put("did", zzaxe.zzal());
        b.put("dst", Integer.valueOf(zzaxe.zzam().zzv()));
        b.put("doo", Boolean.valueOf(zzaxe.zzan()));
        return b;
    }

    public final Map<String, Object> zzcd() {
        return m7134b();
    }

    public final Map<String, Object> zzce() {
        Map<String, Object> b = m7134b();
        b.put("lts", Long.valueOf(this.f11699c.zzcu()));
        return b;
    }
}
