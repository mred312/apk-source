package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.y4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2612y4 {

    /* renamed from: a */
    long f11978a;

    /* renamed from: b */
    final String f11979b;

    /* renamed from: c */
    final String f11980c;

    /* renamed from: d */
    final long f11981d;

    /* renamed from: e */
    final long f11982e;

    /* renamed from: f */
    final long f11983f;

    /* renamed from: g */
    final long f11984g;

    /* renamed from: h */
    final List<zzu> f11985h;

    private C2612y4(String str, String str2, long j, long j2, long j3, long j4, List<zzu> list) {
        this.f11979b = str;
        this.f11980c = "".equals(str2) ? null : str2;
        this.f11981d = j;
        this.f11982e = j2;
        this.f11983f = j3;
        this.f11984g = j4;
        this.f11985h = list;
    }

    /* renamed from: b */
    static C2612y4 m7271b(C2016i6 i6Var) {
        if (zzav.m7573k(i6Var) == 538247942) {
            return new C2612y4(zzav.m7567e(i6Var), zzav.m7567e(i6Var), zzav.m7575m(i6Var), zzav.m7575m(i6Var), zzav.m7575m(i6Var), zzav.m7575m(i6Var), zzav.m7574l(i6Var));
        }
        throw new IOException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo15053a(OutputStream outputStream) {
        try {
            zzav.m7568f(outputStream, 538247942);
            zzav.m7570h(outputStream, this.f11979b);
            String str = this.f11980c;
            if (str == null) {
                str = "";
            }
            zzav.m7570h(outputStream, str);
            zzav.m7569g(outputStream, this.f11981d);
            zzav.m7569g(outputStream, this.f11982e);
            zzav.m7569g(outputStream, this.f11983f);
            zzav.m7569g(outputStream, this.f11984g);
            List<zzu> list = this.f11985h;
            if (list != null) {
                zzav.m7568f(outputStream, list.size());
                for (zzu next : list) {
                    zzav.m7570h(outputStream, next.getName());
                    zzav.m7570h(outputStream, next.getValue());
                }
            } else {
                zzav.m7568f(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzaq.m7524d("%s", e.toString());
            return false;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C2612y4(java.lang.String r14, com.google.android.gms.internal.ads.zzn r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzr
            long r3 = r15.zzs
            long r5 = r15.zzt
            long r7 = r15.zzu
            long r9 = r15.zzv
            java.util.List<com.google.android.gms.internal.ads.zzu> r0 = r15.zzx
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r11 = r0
            goto L_0x0044
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzw
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0023:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzu r11 = new com.google.android.gms.internal.ads.zzu
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0023
        L_0x0044:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C2612y4.<init>(java.lang.String, com.google.android.gms.internal.ads.zzn):void");
    }
}
