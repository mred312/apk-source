package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.ia */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2020ia extends zzdga {

    /* renamed from: a */
    private final zzdhn f9280a;

    /* renamed from: b */
    private zzeps<zzdfw> f9281b;

    /* renamed from: c */
    private zzeps<String> f9282c;

    /* renamed from: d */
    private zzeps<zzdgg> f9283d;

    /* renamed from: e */
    private zzeps<Integer> f9284e;

    /* renamed from: f */
    private zzeps<zzdgk> f9285f;

    /* renamed from: g */
    private zzeps<zzdgq> f9286g;

    /* renamed from: h */
    private zzeps<zzdgz> f9287h;

    /* renamed from: i */
    private zzeps<Boolean> f9288i;

    /* renamed from: j */
    private zzeps<ApplicationInfo> f9289j;

    /* renamed from: k */
    private zzeps<zzdhe> f9290k;

    /* renamed from: l */
    private zzeps<zzdhi> f9291l;

    /* renamed from: m */
    private zzeps<zzdhw> f9292m;

    /* renamed from: n */
    private zzeps<String> f9293n;

    /* renamed from: o */
    private zzeps<zzckc> f9294o;

    /* renamed from: p */
    private zzeps<zzckc> f9295p;

    /* renamed from: q */
    private zzeps<zzckc> f9296q;

    /* renamed from: r */
    private zzeps<zzckc> f9297r;

    /* renamed from: s */
    private zzeps<Map<zzdrl, zzckc>> f9298s;

    /* renamed from: t */
    private zzeps<Set<zzbxy<zzdru>>> f9299t;

    /* renamed from: u */
    private zzeps<Set<zzbxy<zzdru>>> f9300u;

    /* renamed from: v */
    private zzeps f9301v;

    /* renamed from: w */
    private zzeps<zzdro> f9302w;

    /* renamed from: x */
    private final /* synthetic */ zzbhg f9303x;

    private C2020ia(zzbhg zzbhg, zzdhn zzdhn) {
        this.f9303x = zzbhg;
        this.f9280a = zzdhn;
        this.f9281b = new zzdgb(C2281pb.f10618a, zzbhg.f13307k, zzbhg.f13301f, zzdqo.zzawk());
        this.f9282c = new zzdhm(zzdhn);
        this.f9283d = new zzdgi(C1761ba.f7887a, zzbhg.f13307k, this.f9282c, zzdqo.zzawk());
        this.f9284e = new zzdhr(zzdhn);
        this.f9285f = new zzdgo(C2281pb.f10618a, this.f9284e, zzbhg.f13307k, zzbhg.f13274I, zzbhg.f13301f, zzdqo.zzawk());
        this.f9286g = new zzdgs(C2169mb.f9933a, zzdqo.zzawk(), zzbhg.f13307k);
        this.f9287h = new zzdhb(C2206nb.f10147a, zzdqo.zzawk(), this.f9282c);
        this.f9288i = new zzdho(zzdhn);
        this.f9289j = new zzdhp(zzdhn);
        this.f9290k = new zzdhg(zzbhg.f13276K, zzbhg.f13301f, this.f9288i, this.f9289j);
        this.f9291l = new zzdhk(C2244ob.f10354a, zzbhg.f13301f, zzbhg.f13307k);
        this.f9292m = new zzdhy(zzdqo.zzawk());
        this.f9293n = new zzdhq(zzdhn);
        this.f9294o = zzepg.zzas(zzcjr.zzaps());
        this.f9295p = zzepg.zzas(zzcjp.zzapr());
        this.f9296q = zzepg.zzas(zzcjt.zzapu());
        this.f9297r = zzepg.zzas(zzcjv.zzapw());
        this.f9298s = ((zzepj) ((zzepj) ((zzepj) ((zzepj) zzeph.zzig(4).zza(zzdrl.GMS_SIGNALS, this.f9294o)).zza(zzdrl.BUILD_URL, this.f9295p)).zza(zzdrl.HTTP, this.f9296q)).zza(zzdrl.PRE_PROCESS, this.f9297r)).zzblu();
        this.f9299t = zzepg.zzas(new zzcjx(this.f9293n, zzbhg.f13307k, zzdqo.zzawk(), this.f9298s));
        zzepo<Set<zzbxy<zzdru>>> zzblv = zzepo.zzas(0, 1).zzav(this.f9299t).zzblv();
        this.f9300u = zzblv;
        this.f9301v = zzdrw.zzar(zzblv);
        this.f9302w = zzepg.zzas(zzdrt.zzx(zzdqo.zzawk(), zzbhg.f13301f, this.f9301v));
    }

    /* renamed from: a */
    private final zzdhd m6319a() {
        return new zzdhd((zzaao) zzepl.zza(new zzaao(), "Cannot return null from a non-@Nullable @Provides method"), zzdqo.zzawl(), (List) zzepl.zza(this.f9280a.zzatn(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    /* renamed from: b */
    private final zzdgc m6320b() {
        return new zzdgc(zzbjk.zzaie(), zzdqo.zzawl(), (String) zzepl.zza(this.f9280a.zzatk(), "Cannot return null from a non-@Nullable @Provides method"), this.f9280a.zzatl());
    }

    public final zzdfl<JSONObject> zzagl() {
        zzdzc zzawl = zzdqo.zzawl();
        long longValue = ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue();
        long longValue2 = ((Long) zzwq.zzqe().zzd(zzabf.zzcsv)).longValue();
        return zzdfm.zza(zzawl, zzdwt.zza((zzdfi) zzepl.zza(new zzddx(new zzdgz(zzbjg.zzaia(), zzdqo.zzawl(), zzdhm.zzb(this.f9280a)), 0, (ScheduledExecutorService) this.f9303x.f13301f.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdhe(zzbip.zzb(this.f9303x.f13293b), (ScheduledExecutorService) this.f9303x.f13301f.get(), this.f9280a.zzatm(), zzdhp.zzc(this.f9280a)), longValue, (ScheduledExecutorService) this.f9303x.f13301f.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdhi(zzbji.zzaic(), (ScheduledExecutorService) this.f9303x.f13301f.get(), zzbgo.zza(this.f9303x.f13295c)), longValue2, (ScheduledExecutorService) this.f9303x.f13301f.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdfw(zzbjk.zzaie(), zzbgo.zza(this.f9303x.f13295c), (ScheduledExecutorService) this.f9303x.f13301f.get(), zzdqo.zzawl()), 0, (ScheduledExecutorService) this.f9303x.f13301f.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(new zzddx(new zzdhw(zzdqo.zzawl()), 0, (ScheduledExecutorService) this.f9303x.f13301f.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdfi) zzepl.zza(zzdht.zzatr(), "Cannot return null from a non-@Nullable @Provides method"), new zzdgg((zzato) null, zzbgo.zza(this.f9303x.f13295c), zzdhm.zzb(this.f9280a), zzdqo.zzawl()), new zzdgq(zzbje.zzahy(), zzdqo.zzawl(), zzbgo.zza(this.f9303x.f13295c)), m6319a(), m6320b(), new zzdgk(zzbjk.zzaie(), this.f9280a.zzatq(), zzbgo.zza(this.f9303x.f13295c), (zzayg) this.f9303x.f13274I.get(), (ScheduledExecutorService) this.f9303x.f13301f.get(), zzdqo.zzawl()), (zzdfi) this.f9303x.f13275J.get()));
    }

    public final zzdfl<JSONObject> zzagm() {
        return zzdhu.zza(zzbjg.zzaia(), this.f9303x.f13275J.get(), m6320b(), m6319a(), zzepg.zzat(this.f9281b), zzepg.zzat(this.f9283d), zzepg.zzat(this.f9285f), zzepg.zzat(this.f9286g), zzepg.zzat(this.f9287h), zzepg.zzat(this.f9290k), zzepg.zzat(this.f9291l), zzepg.zzat(this.f9292m), zzdqo.zzawl(), (ScheduledExecutorService) this.f9303x.f13301f.get());
    }

    public final zzdro zzagn() {
        return this.f9302w.get();
    }
}
