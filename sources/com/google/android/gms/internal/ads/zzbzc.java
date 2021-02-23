package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbzc {

    /* renamed from: a */
    private final zzcaf f13867a;
    @Nullable

    /* renamed from: b */
    private final zzbdv f13868b;

    public zzbzc(zzcaf zzcaf) {
        this(zzcaf, (zzbdv) null);
    }

    @Nullable
    public final zzbdv zzaim() {
        return this.f13868b;
    }

    public final zzcaf zzamb() {
        return this.f13867a;
    }

    @Nullable
    public final View zzamc() {
        zzbdv zzbdv = this.f13868b;
        if (zzbdv != null) {
            return zzbdv.getWebView();
        }
        return null;
    }

    @Nullable
    public final View zzamd() {
        zzbdv zzbdv = this.f13868b;
        if (zzbdv == null) {
            return null;
        }
        return zzbdv.getWebView();
    }

    public Set<zzbxy<zzbru>> zzb(zzbqu zzbqu) {
        return Collections.singleton(zzbxy.zzb(zzbqu, zzazj.zzegu));
    }

    public Set<zzbxy<zzbxn>> zzc(zzbqu zzbqu) {
        return Collections.singleton(zzbxy.zzb(zzbqu, zzazj.zzegu));
    }

    public zzbzc(zzcaf zzcaf, @Nullable zzbdv zzbdv) {
        this.f13867a = zzcaf;
        this.f13868b = zzbdv;
    }

    public final zzbxy<zzbvs> zzb(Executor executor) {
        return new zzbxy<>(new C2438tg(this.f13868b), executor);
    }
}
