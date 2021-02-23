package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzcky {

    /* renamed from: a */
    private final String f14524a = zzacu.zzdbq.get();

    /* renamed from: b */
    private final Executor f14525b;

    /* renamed from: c */
    private final boolean f14526c;
    protected final zzaze zzeff;
    protected final Map<String, String> zzgki = new HashMap();

    protected zzcky(Executor executor, zzaze zzaze) {
        boolean z;
        this.f14525b = executor;
        this.zzeff = zzaze;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue()) {
            z = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqo)).booleanValue();
        } else {
            z = ((double) zzwq.zzqh().nextFloat()) <= zzacu.zzdbp.get().doubleValue();
        }
        this.f14526c = z;
    }

    /* access modifiers changed from: protected */
    public abstract void zzaqi();

    public final void zzo(Map<String, String> map) {
        String zzp = zzp(map);
        if (this.f14526c) {
            this.f14525b.execute(new C2629yk(this, zzp));
        }
        zzd.zzee(zzp);
    }

    /* access modifiers changed from: protected */
    public final String zzp(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.f14524a).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
