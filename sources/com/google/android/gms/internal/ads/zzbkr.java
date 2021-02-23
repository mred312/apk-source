package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkr implements zzqu {

    /* renamed from: a */
    private zzbdv f13433a;

    /* renamed from: b */
    private final Executor f13434b;

    /* renamed from: c */
    private final zzbkg f13435c;

    /* renamed from: d */
    private final Clock f13436d;

    /* renamed from: e */
    private boolean f13437e = false;

    /* renamed from: f */
    private boolean f13438f = false;

    /* renamed from: g */
    private zzbkk f13439g = new zzbkk();

    public zzbkr(Executor executor, zzbkg zzbkg, Clock clock) {
        this.f13434b = executor;
        this.f13435c = zzbkg;
        this.f13436d = clock;
    }

    /* renamed from: a */
    private final void m7819a() {
        try {
            JSONObject zza = this.f13435c.zzj(this.f13439g);
            if (this.f13433a != null) {
                this.f13434b.execute(new C2582xb(this, zza));
            }
        } catch (JSONException e) {
            zzd.zza("Failed to call video active view js", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16334b(JSONObject jSONObject) {
        this.f13433a.zza("AFMA_updateActiveView", jSONObject);
    }

    public final void disable() {
        this.f13437e = false;
    }

    public final void enable() {
        this.f13437e = true;
        m7819a();
    }

    public final void zza(zzqv zzqv) {
        zzbkk zzbkk = this.f13439g;
        zzbkk.zzbqz = this.f13438f ? false : zzqv.zzbqz;
        zzbkk.timestamp = this.f13436d.elapsedRealtime();
        this.f13439g.zzfrj = zzqv;
        if (this.f13437e) {
            m7819a();
        }
    }

    public final void zzbe(boolean z) {
        this.f13438f = z;
    }

    public final void zzg(zzbdv zzbdv) {
        this.f13433a = zzbdv;
    }
}
