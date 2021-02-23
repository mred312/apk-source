package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;

/* renamed from: com.google.android.gms.measurement.internal.d8 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2969d8 extends C2999g8 {

    /* renamed from: g */
    private zzbv.zzb f18026g;

    /* renamed from: h */
    private final /* synthetic */ C2939a8 f18027h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2969d8(C2939a8 a8Var, String str, int i, zzbv.zzb zzb) {
        super(str, i);
        this.f18027h = a8Var;
        this.f18026g = zzb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo19891a() {
        return this.f18026g.zzb();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final boolean mo19892i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final boolean mo19893j() {
        return this.f18026g.zzf();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010b, code lost:
        if (r6.booleanValue() == false) goto L_0x039f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03b7  */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo19894k(java.lang.Long r18, java.lang.Long r19, com.google.android.gms.internal.measurement.zzcd.zzc r20, long r21, com.google.android.gms.measurement.internal.C3000h r23, boolean r24) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r3 = com.google.android.gms.internal.measurement.zzmv.zzb()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.measurement.internal.a8 r3 = r0.f18027h
            com.google.android.gms.measurement.internal.zzy r3 = r3.zzs()
            java.lang.String r6 = r0.f18087a
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzbb
            boolean r3 = r3.zzd(r6, r7)
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            com.google.android.gms.internal.measurement.zzbv$zzb r6 = r0.f18026g
            boolean r6 = r6.zzk()
            if (r6 == 0) goto L_0x002e
            r6 = r23
            long r6 = r6.f18097e
            goto L_0x0030
        L_0x002e:
            r6 = r21
        L_0x0030:
            com.google.android.gms.measurement.internal.a8 r8 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()
            r9 = 2
            boolean r8 = r8.zza((int) r9)
            r9 = 0
            if (r8 == 0) goto L_0x0092
            com.google.android.gms.measurement.internal.a8 r8 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzw()
            int r10 = r0.f18088b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.google.android.gms.internal.measurement.zzbv$zzb r11 = r0.f18026g
            boolean r11 = r11.zza()
            if (r11 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzbv$zzb r11 = r0.f18026g
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x0062
        L_0x0061:
            r11 = r9
        L_0x0062:
            com.google.android.gms.measurement.internal.a8 r12 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r12 = r12.zzn()
            com.google.android.gms.internal.measurement.zzbv$zzb r13 = r0.f18026g
            java.lang.String r13 = r13.zzc()
            java.lang.String r12 = r12.zza((java.lang.String) r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, event"
            r8.zza(r13, r10, r11, r12)
            com.google.android.gms.measurement.internal.a8 r8 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzw()
            com.google.android.gms.measurement.internal.a8 r10 = r0.f18027h
            com.google.android.gms.measurement.internal.zzks r10 = r10.mo20059f_()
            com.google.android.gms.internal.measurement.zzbv$zzb r11 = r0.f18026g
            java.lang.String r10 = r10.mo20545h(r11)
            java.lang.String r11 = "Filter definition"
            r8.zza(r11, r10)
        L_0x0092:
            com.google.android.gms.internal.measurement.zzbv$zzb r8 = r0.f18026g
            boolean r8 = r8.zza()
            if (r8 == 0) goto L_0x03f8
            com.google.android.gms.internal.measurement.zzbv$zzb r8 = r0.f18026g
            int r8 = r8.zzb()
            r10 = 256(0x100, float:3.59E-43)
            if (r8 <= r10) goto L_0x00a6
            goto L_0x03f8
        L_0x00a6:
            com.google.android.gms.internal.measurement.zzbv$zzb r8 = r0.f18026g
            boolean r8 = r8.zzh()
            com.google.android.gms.internal.measurement.zzbv$zzb r10 = r0.f18026g
            boolean r10 = r10.zzi()
            com.google.android.gms.internal.measurement.zzbv$zzb r11 = r0.f18026g
            boolean r11 = r11.zzk()
            if (r8 != 0) goto L_0x00c1
            if (r10 != 0) goto L_0x00c1
            if (r11 == 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r8 = 0
            goto L_0x00c2
        L_0x00c1:
            r8 = 1
        L_0x00c2:
            if (r24 == 0) goto L_0x00ee
            if (r8 != 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.a8 r1 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzw()
            int r2 = r0.f18088b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzbv$zzb r3 = r0.f18026g
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x00e8
            com.google.android.gms.internal.measurement.zzbv$zzb r3 = r0.f18026g
            int r3 = r3.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
        L_0x00e8:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zza(r3, r2, r9)
            return r5
        L_0x00ee:
            com.google.android.gms.internal.measurement.zzbv$zzb r10 = r0.f18026g
            java.lang.String r11 = r20.zzc()
            boolean r12 = r10.zzf()
            if (r12 == 0) goto L_0x010f
            com.google.android.gms.internal.measurement.zzbv$zzd r12 = r10.zzg()
            java.lang.Boolean r6 = com.google.android.gms.measurement.internal.C2999g8.m10510c(r6, r12)
            if (r6 != 0) goto L_0x0107
        L_0x0104:
            r2 = r9
            goto L_0x039f
        L_0x0107:
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x010f
            goto L_0x039f
        L_0x010f:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            java.util.List r7 = r10.zzd()
            java.util.Iterator r7 = r7.iterator()
        L_0x011c:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x0154
            java.lang.Object r12 = r7.next()
            com.google.android.gms.internal.measurement.zzbv$zzc r12 = (com.google.android.gms.internal.measurement.zzbv.zzc) r12
            java.lang.String r13 = r12.zzh()
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x014c
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            java.lang.String r7 = "null or empty param name in filter. event"
            r2.zza(r7, r6)
            goto L_0x0104
        L_0x014c:
            java.lang.String r12 = r12.zzh()
            r6.add(r12)
            goto L_0x011c
        L_0x0154:
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            java.util.List r12 = r20.zza()
            java.util.Iterator r12 = r12.iterator()
        L_0x0161:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01ee
            java.lang.Object r13 = r12.next()
            com.google.android.gms.internal.measurement.zzcd$zze r13 = (com.google.android.gms.internal.measurement.zzcd.zze) r13
            java.lang.String r14 = r13.zzb()
            boolean r14 = r6.contains(r14)
            if (r14 == 0) goto L_0x0161
            boolean r14 = r13.zze()
            if (r14 == 0) goto L_0x0195
            java.lang.String r14 = r13.zzb()
            boolean r15 = r13.zze()
            if (r15 == 0) goto L_0x0190
            long r15 = r13.zzf()
            java.lang.Long r13 = java.lang.Long.valueOf(r15)
            goto L_0x0191
        L_0x0190:
            r13 = r9
        L_0x0191:
            r7.put(r14, r13)
            goto L_0x0161
        L_0x0195:
            boolean r14 = r13.zzi()
            if (r14 == 0) goto L_0x01b3
            java.lang.String r14 = r13.zzb()
            boolean r15 = r13.zzi()
            if (r15 == 0) goto L_0x01ae
            double r15 = r13.zzj()
            java.lang.Double r13 = java.lang.Double.valueOf(r15)
            goto L_0x01af
        L_0x01ae:
            r13 = r9
        L_0x01af:
            r7.put(r14, r13)
            goto L_0x0161
        L_0x01b3:
            boolean r14 = r13.zzc()
            if (r14 == 0) goto L_0x01c5
            java.lang.String r14 = r13.zzb()
            java.lang.String r13 = r13.zzd()
            r7.put(r14, r13)
            goto L_0x0161
        L_0x01c5:
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r10 = r13.zzb()
            java.lang.String r7 = r7.zzb(r10)
            java.lang.String r10 = "Unknown value for param. event, param"
            r2.zza(r10, r6, r7)
            goto L_0x0104
        L_0x01ee:
            java.util.List r6 = r10.zzd()
            java.util.Iterator r6 = r6.iterator()
        L_0x01f6:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x039e
            java.lang.Object r10 = r6.next()
            com.google.android.gms.internal.measurement.zzbv$zzc r10 = (com.google.android.gms.internal.measurement.zzbv.zzc) r10
            boolean r12 = r10.zze()
            if (r12 == 0) goto L_0x0210
            boolean r12 = r10.zzf()
            if (r12 == 0) goto L_0x0210
            r12 = 1
            goto L_0x0211
        L_0x0210:
            r12 = 0
        L_0x0211:
            java.lang.String r13 = r10.zzh()
            boolean r14 = r13.isEmpty()
            if (r14 == 0) goto L_0x0236
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            java.lang.String r7 = "Event has empty param name. event"
            r2.zza(r7, r6)
            goto L_0x0104
        L_0x0236:
            java.lang.Object r14 = r7.get(r13)
            boolean r15 = r14 instanceof java.lang.Long
            if (r15 == 0) goto L_0x0283
            boolean r15 = r10.zzc()
            if (r15 != 0) goto L_0x0269
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No number filter for long param. event, param"
            r2.zza(r10, r6, r7)
            goto L_0x0104
        L_0x0269:
            java.lang.Long r14 = (java.lang.Long) r14
            long r13 = r14.longValue()
            com.google.android.gms.internal.measurement.zzbv$zzd r10 = r10.zzd()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.C2999g8.m10510c(r13, r10)
            if (r10 != 0) goto L_0x027b
            goto L_0x0104
        L_0x027b:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01f6
            goto L_0x039f
        L_0x0283:
            boolean r15 = r14 instanceof java.lang.Double
            if (r15 == 0) goto L_0x02cc
            boolean r15 = r10.zzc()
            if (r15 != 0) goto L_0x02b2
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No number filter for double param. event, param"
            r2.zza(r10, r6, r7)
            goto L_0x0104
        L_0x02b2:
            java.lang.Double r14 = (java.lang.Double) r14
            double r13 = r14.doubleValue()
            com.google.android.gms.internal.measurement.zzbv$zzd r10 = r10.zzd()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.C2999g8.m10509b(r13, r10)
            if (r10 != 0) goto L_0x02c4
            goto L_0x0104
        L_0x02c4:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01f6
            goto L_0x039f
        L_0x02cc:
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x0353
            boolean r15 = r10.zza()
            if (r15 == 0) goto L_0x02e7
            java.lang.String r14 = (java.lang.String) r14
            com.google.android.gms.internal.measurement.zzbv$zzf r10 = r10.zzb()
            com.google.android.gms.measurement.internal.a8 r13 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzq()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.C2999g8.m10514g(r14, r10, r13)
            goto L_0x02fd
        L_0x02e7:
            boolean r15 = r10.zzc()
            if (r15 == 0) goto L_0x032e
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = com.google.android.gms.measurement.internal.zzks.m10971z(r14)
            if (r15 == 0) goto L_0x0309
            com.google.android.gms.internal.measurement.zzbv$zzd r10 = r10.zzd()
            java.lang.Boolean r10 = com.google.android.gms.measurement.internal.C2999g8.m10512e(r14, r10)
        L_0x02fd:
            if (r10 != 0) goto L_0x0301
            goto L_0x0104
        L_0x0301:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01f6
            goto L_0x039f
        L_0x0309:
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "Invalid param value for number filter. event, param"
            r2.zza(r10, r6, r7)
            goto L_0x0104
        L_0x032e:
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No filter for String param. event, param"
            r2.zza(r10, r6, r7)
            goto L_0x0104
        L_0x0353:
            if (r14 != 0) goto L_0x0379
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r9 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r9 = r9.zzn()
            java.lang.String r9 = r9.zzb(r13)
            java.lang.String r10 = "Missing param for filter. event, param"
            r6.zza(r10, r7, r9)
            goto L_0x039f
        L_0x0379:
            com.google.android.gms.measurement.internal.a8 r2 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzh()
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r6 = r6.zzn()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.a8 r7 = r0.f18027h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "Unknown param type. event, param"
            r2.zza(r10, r6, r7)
            goto L_0x0104
        L_0x039e:
            r2 = r1
        L_0x039f:
            com.google.android.gms.measurement.internal.a8 r6 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()
            if (r2 != 0) goto L_0x03ae
            java.lang.String r7 = "null"
            goto L_0x03af
        L_0x03ae:
            r7 = r2
        L_0x03af:
            java.lang.String r9 = "Event filter result"
            r6.zza(r9, r7)
            if (r2 != 0) goto L_0x03b7
            return r4
        L_0x03b7:
            r0.f18089c = r1
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x03c0
            return r5
        L_0x03c0:
            r0.f18090d = r1
            if (r8 == 0) goto L_0x03f7
            boolean r1 = r20.zzd()
            if (r1 == 0) goto L_0x03f7
            long r1 = r20.zze()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            com.google.android.gms.internal.measurement.zzbv$zzb r2 = r0.f18026g
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x03e9
            if (r3 == 0) goto L_0x03e6
            com.google.android.gms.internal.measurement.zzbv$zzb r2 = r0.f18026g
            boolean r2 = r2.zzf()
            if (r2 == 0) goto L_0x03e6
            r1 = r18
        L_0x03e6:
            r0.f18092f = r1
            goto L_0x03f7
        L_0x03e9:
            if (r3 == 0) goto L_0x03f5
            com.google.android.gms.internal.measurement.zzbv$zzb r2 = r0.f18026g
            boolean r2 = r2.zzf()
            if (r2 == 0) goto L_0x03f5
            r1 = r19
        L_0x03f5:
            r0.f18091e = r1
        L_0x03f7:
            return r5
        L_0x03f8:
            com.google.android.gms.measurement.internal.a8 r1 = r0.f18027h
            com.google.android.gms.measurement.internal.zzer r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzh()
            java.lang.String r2 = r0.f18087a
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzer.zza((java.lang.String) r2)
            com.google.android.gms.internal.measurement.zzbv$zzb r3 = r0.f18026g
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x041a
            com.google.android.gms.internal.measurement.zzbv$zzb r3 = r0.f18026g
            int r3 = r3.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
        L_0x041a:
            java.lang.String r3 = java.lang.String.valueOf(r9)
            java.lang.String r5 = "Invalid event filter ID. appId, id"
            r1.zza(r5, r2, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2969d8.mo19894k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzcd$zzc, long, com.google.android.gms.measurement.internal.h, boolean):boolean");
    }
}
