package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* renamed from: com.google.android.gms.internal.measurement.b */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.6.0 */
final class C2719b extends zzag.C2920b {

    /* renamed from: e */
    private final /* synthetic */ String f17221e;

    /* renamed from: f */
    private final /* synthetic */ String f17222f;

    /* renamed from: g */
    private final /* synthetic */ Context f17223g;

    /* renamed from: h */
    private final /* synthetic */ Bundle f17224h;

    /* renamed from: i */
    private final /* synthetic */ zzag f17225i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2719b(zzag zzag, String str, String str2, Context context, Bundle bundle) {
        super(zzag);
        this.f17225i = zzag;
        this.f17221e = str;
        this.f17222f = str2;
        this.f17223g = context;
        this.f17224h = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052 A[Catch:{ Exception -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e A[Catch:{ Exception -> 0x009e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18537a() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzag r2 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x009e }
            r3.<init>()     // Catch:{ Exception -> 0x009e }
            java.util.List unused = r2.f17562d = r3     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzag r2 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            java.lang.String r3 = r14.f17221e     // Catch:{ Exception -> 0x009e }
            java.lang.String r4 = r14.f17222f     // Catch:{ Exception -> 0x009e }
            boolean r2 = com.google.android.gms.internal.measurement.zzag.m10032p(r3, r4)     // Catch:{ Exception -> 0x009e }
            r3 = 0
            if (r2 == 0) goto L_0x0027
            java.lang.String r3 = r14.f17222f     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = r14.f17221e     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzag r4 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            java.lang.String r4 = r4.f17559a     // Catch:{ Exception -> 0x009e }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x002a
        L_0x0027:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x002a:
            android.content.Context r2 = r14.f17223g     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzag.m10038v(r2)     // Catch:{ Exception -> 0x009e }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzag.f17557j     // Catch:{ Exception -> 0x009e }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x009e }
            if (r2 != 0) goto L_0x003e
            if (r10 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            com.google.android.gms.internal.measurement.zzag r3 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            android.content.Context r4 = r14.f17223g     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzv r4 = r3.zza((android.content.Context) r4, (boolean) r2)     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzv unused = r3.f17566h = r4     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzag r3 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzv r3 = r3.f17566h     // Catch:{ Exception -> 0x009e }
            if (r3 != 0) goto L_0x005e
            com.google.android.gms.internal.measurement.zzag r2 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = r2.f17559a     // Catch:{ Exception -> 0x009e }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch:{ Exception -> 0x009e }
            return
        L_0x005e:
            android.content.Context r3 = r14.f17223g     // Catch:{ Exception -> 0x009e }
            int r3 = com.google.android.gms.internal.measurement.zzag.m10037u(r3)     // Catch:{ Exception -> 0x009e }
            android.content.Context r4 = r14.f17223g     // Catch:{ Exception -> 0x009e }
            int r4 = com.google.android.gms.internal.measurement.zzag.m10036t(r4)     // Catch:{ Exception -> 0x009e }
            if (r2 == 0) goto L_0x0077
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x009e }
            if (r4 >= r3) goto L_0x0074
            r3 = 1
            goto L_0x0075
        L_0x0074:
            r3 = 0
        L_0x0075:
            r8 = r3
            goto L_0x0081
        L_0x0077:
            if (r3 <= 0) goto L_0x007a
            r4 = r3
        L_0x007a:
            if (r3 <= 0) goto L_0x007e
            r2 = 1
            goto L_0x007f
        L_0x007e:
            r2 = 0
        L_0x007f:
            r8 = r2
            r2 = r4
        L_0x0081:
            com.google.android.gms.internal.measurement.zzae r13 = new com.google.android.gms.internal.measurement.zzae     // Catch:{ Exception -> 0x009e }
            r4 = 32053(0x7d35, double:1.58363E-319)
            long r6 = (long) r2     // Catch:{ Exception -> 0x009e }
            android.os.Bundle r12 = r14.f17224h     // Catch:{ Exception -> 0x009e }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzag r2 = r14.f17225i     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.internal.measurement.zzv r2 = r2.f17566h     // Catch:{ Exception -> 0x009e }
            android.content.Context r3 = r14.f17223g     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ Exception -> 0x009e }
            long r4 = r14.f17568a     // Catch:{ Exception -> 0x009e }
            r2.initialize(r3, r13, r4)     // Catch:{ Exception -> 0x009e }
            return
        L_0x009e:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzag r3 = r14.f17225i
            r3.m10022f(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2719b.mo18537a():void");
    }
}
