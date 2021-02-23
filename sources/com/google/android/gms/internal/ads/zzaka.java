package com.google.android.gms.internal.ads;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaka extends zzakn<zzalz> implements zzakj, zzako {

    /* renamed from: c */
    private final zzbgb f12498c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzakr f12499d;

    public zzaka(Context context, zzazh zzazh) {
        try {
            zzbgb zzbgb = new zzbgb(context, new C1900f1(this));
            this.f12498c = zzbgb;
            zzbgb.setWillNotDraw(true);
            zzbgb.addJavascriptInterface(new C1937g1(this), "GoogleJsInterface");
            zzp.zzkq().zza(context, zzazh.zzbrf, zzbgb.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbeh("Init failed.", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo15392d(String str) {
        this.f12498c.zzcy(str);
    }

    public final void destroy() {
        this.f12498c.destroy();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo15394e(String str) {
        this.f12498c.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo15395f(String str) {
        this.f12498c.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
    }

    public final boolean isDestroyed() {
        return this.f12498c.isDestroyed();
    }

    public final void zza(zzakr zzakr) {
        this.f12499d = zzakr;
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final void zzcv(String str) {
        zzcw(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    public final void zzcw(String str) {
        zzazj.zzegt.execute(new C1789c1(this, str));
    }

    public final void zzcx(String str) {
        zzazj.zzegt.execute(new C1752b1(this, str));
    }

    public final void zzcy(String str) {
        zzazj.zzegt.execute(new C1863e1(this, str));
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final zzaly zzts() {
        return new zzamb(this);
    }
}
