package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;

/* renamed from: com.google.android.gms.measurement.internal.f8 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2989f8 extends C2999g8 {

    /* renamed from: g */
    private zzbv.zze f18064g;

    /* renamed from: h */
    private final /* synthetic */ C2939a8 f18065h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2989f8(C2939a8 a8Var, String str, int i, zzbv.zze zze) {
        super(str, i);
        this.f18065h = a8Var;
        this.f18064g = zze;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo19891a() {
        return this.f18064g.zzb();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final boolean mo19892i() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final boolean mo19893j() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v17, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo19912k(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzcd.zzk r13, boolean r14) {
        /*
            r10 = this;
            boolean r0 = com.google.android.gms.internal.measurement.zzmv.zzb()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.a8 r0 = r10.f18065h
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()
            java.lang.String r3 = r10.f18087a
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzaz
            boolean r0 = r0.zzd(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            com.google.android.gms.internal.measurement.zzbv$zze r3 = r10.f18064g
            boolean r3 = r3.zze()
            com.google.android.gms.internal.measurement.zzbv$zze r4 = r10.f18064g
            boolean r4 = r4.zzf()
            com.google.android.gms.internal.measurement.zzbv$zze r5 = r10.f18064g
            boolean r5 = r5.zzh()
            if (r3 != 0) goto L_0x0036
            if (r4 != 0) goto L_0x0036
            if (r5 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = 1
        L_0x0037:
            r4 = 0
            if (r14 == 0) goto L_0x0064
            if (r3 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.a8 r11 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r11 = r11.zzq()
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzw()
            int r12 = r10.f18088b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzbv$zze r13 = r10.f18064g
            boolean r13 = r13.zza()
            if (r13 == 0) goto L_0x005e
            com.google.android.gms.internal.measurement.zzbv$zze r13 = r10.f18064g
            int r13 = r13.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
        L_0x005e:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.zza(r13, r12, r4)
            return r2
        L_0x0064:
            com.google.android.gms.internal.measurement.zzbv$zze r6 = r10.f18064g
            com.google.android.gms.internal.measurement.zzbv$zzc r6 = r6.zzd()
            boolean r7 = r6.zzf()
            boolean r8 = r13.zzf()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.a8 r6 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzh()
            com.google.android.gms.measurement.internal.a8 r7 = r10.f18065h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x0099:
            long r8 = r13.zzg()
            com.google.android.gms.internal.measurement.zzbv$zzd r4 = r6.zzd()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10510c(r8, r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10511d(r4, r7)
            goto L_0x0189
        L_0x00ab:
            boolean r8 = r13.zzh()
            if (r8 == 0) goto L_0x00e8
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.a8 r6 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzh()
            com.google.android.gms.measurement.internal.a8 r7 = r10.f18065h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x00d6:
            double r8 = r13.zzi()
            com.google.android.gms.internal.measurement.zzbv$zzd r4 = r6.zzd()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10509b(r8, r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10511d(r4, r7)
            goto L_0x0189
        L_0x00e8:
            boolean r8 = r13.zzd()
            if (r8 == 0) goto L_0x016c
            boolean r8 = r6.zza()
            if (r8 != 0) goto L_0x0155
            boolean r8 = r6.zzc()
            if (r8 != 0) goto L_0x0118
            com.google.android.gms.measurement.internal.a8 r6 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzh()
            com.google.android.gms.measurement.internal.a8 r7 = r10.f18065h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x0118:
            java.lang.String r8 = r13.zze()
            boolean r8 = com.google.android.gms.measurement.internal.zzks.m10971z(r8)
            if (r8 == 0) goto L_0x0133
            java.lang.String r4 = r13.zze()
            com.google.android.gms.internal.measurement.zzbv$zzd r6 = r6.zzd()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10512e(r4, r6)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10511d(r4, r7)
            goto L_0x0189
        L_0x0133:
            com.google.android.gms.measurement.internal.a8 r6 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzh()
            com.google.android.gms.measurement.internal.a8 r7 = r10.f18065h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = r13.zze()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.zza(r9, r7, r8)
            goto L_0x0189
        L_0x0155:
            java.lang.String r4 = r13.zze()
            com.google.android.gms.internal.measurement.zzbv$zzf r6 = r6.zzb()
            com.google.android.gms.measurement.internal.a8 r8 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzq()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10514g(r4, r6, r8)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C2999g8.m10511d(r4, r7)
            goto L_0x0189
        L_0x016c:
            com.google.android.gms.measurement.internal.a8 r6 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzh()
            com.google.android.gms.measurement.internal.a8 r7 = r10.f18065h
            com.google.android.gms.measurement.internal.zzep r7 = r7.zzn()
            java.lang.String r8 = r13.zzc()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.zza(r8, r7)
        L_0x0189:
            com.google.android.gms.measurement.internal.a8 r6 = r10.f18065h
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzw()
            if (r4 != 0) goto L_0x0198
            java.lang.String r7 = "null"
            goto L_0x0199
        L_0x0198:
            r7 = r4
        L_0x0199:
            java.lang.String r8 = "Property filter result"
            r6.zza(r8, r7)
            if (r4 != 0) goto L_0x01a1
            return r1
        L_0x01a1:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r10.f18089c = r1
            if (r5 == 0) goto L_0x01ae
            boolean r1 = r4.booleanValue()
            if (r1 != 0) goto L_0x01ae
            return r2
        L_0x01ae:
            if (r14 == 0) goto L_0x01b8
            com.google.android.gms.internal.measurement.zzbv$zze r14 = r10.f18064g
            boolean r14 = r14.zze()
            if (r14 == 0) goto L_0x01ba
        L_0x01b8:
            r10.f18090d = r4
        L_0x01ba:
            boolean r14 = r4.booleanValue()
            if (r14 == 0) goto L_0x01ff
            if (r3 == 0) goto L_0x01ff
            boolean r14 = r13.zza()
            if (r14 == 0) goto L_0x01ff
            long r13 = r13.zzb()
            if (r11 == 0) goto L_0x01d2
            long r13 = r11.longValue()
        L_0x01d2:
            if (r0 == 0) goto L_0x01ea
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.f18064g
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x01ea
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.f18064g
            boolean r11 = r11.zzf()
            if (r11 != 0) goto L_0x01ea
            if (r12 == 0) goto L_0x01ea
            long r13 = r12.longValue()
        L_0x01ea:
            com.google.android.gms.internal.measurement.zzbv$zze r11 = r10.f18064g
            boolean r11 = r11.zzf()
            if (r11 == 0) goto L_0x01f9
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f18092f = r11
            goto L_0x01ff
        L_0x01f9:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f18091e = r11
        L_0x01ff:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2989f8.mo19912k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzcd$zzk, boolean):boolean");
    }
}
