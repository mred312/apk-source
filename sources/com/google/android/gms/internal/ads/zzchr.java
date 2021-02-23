package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzchr {

    /* renamed from: a */
    private final zzbrt f14390a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzbsu f14391b;

    /* renamed from: c */
    private final zzbti f14392c;

    /* renamed from: d */
    private final zzbtr f14393d;

    /* renamed from: e */
    private final zzbvy f14394e;

    /* renamed from: f */
    private final Executor f14395f;

    /* renamed from: g */
    private final zzbxx f14396g;

    /* renamed from: h */
    private final zzbki f14397h;

    /* renamed from: i */
    private final zza f14398i;

    /* renamed from: j */
    private final zzbso f14399j;

    /* renamed from: k */
    private final zzawq f14400k;

    /* renamed from: l */
    private final zzef f14401l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final zzbvr f14402m;

    /* renamed from: n */
    private final zzcqo f14403n;

    /* renamed from: o */
    private final zzdrz f14404o;

    /* renamed from: p */
    private final zzckq f14405p;

    public zzchr(zzbrt zzbrt, zzbsu zzbsu, zzbti zzbti, zzbtr zzbtr, zzbvy zzbvy, Executor executor, zzbxx zzbxx, zzbki zzbki, zza zza, zzbso zzbso, @Nullable zzawq zzawq, zzef zzef, zzbvr zzbvr, zzcqo zzcqo, zzdrz zzdrz, zzckq zzckq) {
        this.f14390a = zzbrt;
        this.f14391b = zzbsu;
        this.f14392c = zzbti;
        this.f14393d = zzbtr;
        this.f14394e = zzbvy;
        this.f14395f = executor;
        this.f14396g = zzbxx;
        this.f14397h = zzbki;
        this.f14398i = zza;
        this.f14399j = zzbso;
        this.f14400k = zzawq;
        this.f14401l = zzef;
        this.f14402m = zzbvr;
        this.f14403n = zzcqo;
        this.f14404o = zzdrz;
        this.f14405p = zzckq;
    }

    public static zzdyz<?> zza(zzbdv zzbdv, String str, String str2) {
        zzazq zzazq = new zzazq();
        zzbdv.zzacs().zza((zzbfj) new C1882ek(zzazq));
        zzbdv.zzb(str, str2, (String) null);
        return zzazq;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16862b(zzbdv zzbdv, zzbdv zzbdv2, Map map) {
        this.f14397h.zzf(zzbdv);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ boolean mo16863c(View view, MotionEvent motionEvent) {
        this.f14398i.recordClick();
        zzawq zzawq = this.f14400k;
        if (zzawq == null) {
            return false;
        }
        zzawq.zzwe();
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16864d(View view) {
        this.f14398i.recordClick();
        zzawq zzawq = this.f14400k;
        if (zzawq != null) {
            zzawq.zzwe();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo16865e() {
        this.f14391b.onAdLeftApplication();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo16866f() {
        this.f14390a.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ void mo16867h(String str, String str2) {
        this.f14394e.onAppEvent(str, str2);
    }

    public final void zzb(zzbdv zzbdv, boolean z) {
        zzdv zzca;
        zzbdv zzbdv2 = zzbdv;
        zzbdv.zzacs().zza(new C2515vj(this), this.f14392c, this.f14393d, new C2478uj(this), new C2590xj(this), z, (zzahu) null, this.f14398i, new C1845dk(this), this.f14400k, this.f14403n, this.f14404o, this.f14405p);
        zzbdv2.setOnTouchListener(new C2552wj(this));
        zzbdv2.setOnClickListener(new C2665zj(this));
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcra)).booleanValue() && (zzca = this.f14401l.zzca()) != null) {
            zzca.zzb(zzbdv.getView());
        }
        this.f14396g.zza(zzbdv2, this.f14395f);
        this.f14396g.zza(new C2628yj(zzbdv2), this.f14395f);
        this.f14396g.zzv(zzbdv.getView());
        zzbdv2.zza("/trackActiveViewUnit", (zzahv<? super zzbdv>) new C1808ck(this, zzbdv2));
        this.f14397h.zzo(zzbdv2);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcoh)).booleanValue()) {
            zzbso zzbso = this.f14399j;
            zzbdv.getClass();
            zzbso.zza(C1734ak.m5822a(zzbdv), this.f14395f);
        }
    }
}
