package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzwq {

    /* renamed from: j */
    private static zzwq f17096j = new zzwq();

    /* renamed from: a */
    private final zzayr f17097a;

    /* renamed from: b */
    private final zzvx f17098b;

    /* renamed from: c */
    private final String f17099c;

    /* renamed from: d */
    private final zzaaw f17100d;

    /* renamed from: e */
    private final zzaay f17101e;

    /* renamed from: f */
    private final zzabb f17102f;

    /* renamed from: g */
    private final zzazh f17103g;

    /* renamed from: h */
    private final Random f17104h;

    /* renamed from: i */
    private final WeakHashMap<QueryInfo, String> f17105i;

    protected zzwq() {
        this(new zzayr(), new zzvx(new zzvi(), new zzvf(), new zzzp(), new zzagn(), new zzaut(), new zzavx(), new zzarh(), new zzagm()), new zzaaw(), new zzaay(), new zzabb(), zzayr.zzzf(), new zzazh(0, 203404000, true), new Random(), new WeakHashMap());
    }

    public static zzayr zzqa() {
        return f17096j.f17097a;
    }

    public static zzvx zzqb() {
        return f17096j.f17098b;
    }

    public static zzaay zzqc() {
        return f17096j.f17101e;
    }

    public static zzaaw zzqd() {
        return f17096j.f17100d;
    }

    public static zzabb zzqe() {
        return f17096j.f17102f;
    }

    public static String zzqf() {
        return f17096j.f17099c;
    }

    public static zzazh zzqg() {
        return f17096j.f17103g;
    }

    public static Random zzqh() {
        return f17096j.f17104h;
    }

    public static WeakHashMap<QueryInfo, String> zzqi() {
        return f17096j.f17105i;
    }

    private zzwq(zzayr zzayr, zzvx zzvx, zzaaw zzaaw, zzaay zzaay, zzabb zzabb, String str, zzazh zzazh, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.f17097a = zzayr;
        this.f17098b = zzvx;
        this.f17100d = zzaaw;
        this.f17101e = zzaay;
        this.f17102f = zzabb;
        this.f17099c = str;
        this.f17103g = zzazh;
        this.f17104h = random;
        this.f17105i = weakHashMap;
    }
}
