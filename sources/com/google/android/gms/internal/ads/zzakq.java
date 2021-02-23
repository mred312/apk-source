package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzakq implements zzakj, zzako {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbdv f12502a;

    public zzakq(Context context, zzazh zzazh, @Nullable zzef zzef, zzb zzb) {
        zzp.zzkr();
        zzbdv zza = zzbed.zza(context, zzbfn.zzadv(), "", false, false, zzef, (zzacg) null, zzazh, (zzabs) null, (zzk) null, (zzb) null, zzts.zzne(), (zzsu) null, false, (zzdmu) null, (zzdmz) null);
        this.f12502a = zza;
        zza.getView().setWillNotDraw(true);
    }

    /* renamed from: a */
    private static void m7479a(Runnable runnable) {
        zzwq.zzqa();
        if (zzayr.zzze()) {
            runnable.run();
        } else {
            zzm.zzedd.post(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo15411c(String str) {
        this.f12502a.zzcy(str);
    }

    public final void destroy() {
        this.f12502a.destroy();
    }

    public final boolean isDestroyed() {
        return this.f12502a.isDestroyed();
    }

    public final void zza(String str, zzahv<? super zzalz> zzahv) {
        this.f12502a.zza(str, (zzahv<? super zzbdv>) new C2271p1(this, zzahv));
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zzb(String str, zzahv<? super zzalz> zzahv) {
        this.f12502a.zza(str, (Predicate<zzahv<? super zzbdv>>) new C2048j1(zzahv));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final void zzcv(String str) {
        m7479a(new C2122l1(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzcw(String str) {
        m7479a(new C2233o1(this, str));
    }

    public final void zzcx(String str) {
        m7479a(new C2196n1(this, str));
    }

    public final void zzcy(String str) {
        m7479a(new C2085k1(this, str));
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final zzaly zzts() {
        return new zzamb(this);
    }

    public final void zza(zzakr zzakr) {
        zzbfg zzacs = this.f12502a.zzacs();
        zzakr.getClass();
        zzacs.zza(C2159m1.m6471a(zzakr));
    }
}
