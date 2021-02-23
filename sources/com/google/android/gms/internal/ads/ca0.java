package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ca0 implements aa0 {
    ca0() {
    }

    /* renamed from: a */
    public final Map<?, ?> mo13584a(Object obj) {
        return (zzelm) obj;
    }

    /* renamed from: b */
    public final boolean mo13585b(Object obj) {
        return !((zzelm) obj).isMutable();
    }

    /* renamed from: c */
    public final Object mo13586c(Object obj) {
        ((zzelm) obj).zzbfl();
        return obj;
    }

    /* renamed from: d */
    public final Object mo13587d(Object obj) {
        return zzelm.zzbja().zzbjb();
    }

    /* renamed from: e */
    public final Object mo13588e(Object obj, Object obj2) {
        zzelm zzelm = (zzelm) obj;
        zzelm zzelm2 = (zzelm) obj2;
        if (!zzelm2.isEmpty()) {
            if (!zzelm.isMutable()) {
                zzelm = zzelm.zzbjb();
            }
            zzelm.zza(zzelm2);
        }
        return zzelm;
    }

    /* renamed from: f */
    public final z90<?, ?> mo13589f(Object obj) {
        zzelk zzelk = (zzelk) obj;
        throw new NoSuchMethodError();
    }

    /* renamed from: g */
    public final int mo13590g(int i, Object obj, Object obj2) {
        zzelm zzelm = (zzelm) obj;
        zzelk zzelk = (zzelk) obj2;
        if (zzelm.isEmpty()) {
            return 0;
        }
        Iterator it = zzelm.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    /* renamed from: h */
    public final Map<?, ?> mo13591h(Object obj) {
        return (zzelm) obj;
    }
}
