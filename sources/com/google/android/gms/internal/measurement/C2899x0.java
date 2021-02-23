package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.measurement.x0 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2899x0 extends C2797k1 {

    /* renamed from: a */
    private final Context f17502a;

    /* renamed from: b */
    private final zzec<zzdy<zzdd>> f17503b;

    C2899x0(Context context, @Nullable zzec<zzdy<zzdd>> zzec) {
        if (context != null) {
            this.f17502a = context;
            this.f17503b = zzec;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo18688a() {
        return this.f17502a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public final zzec<zzdy<zzdd>> mo18689b() {
        return this.f17503b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f17503b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.measurement.C2797k1
            r2 = 0
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.k1 r5 = (com.google.android.gms.internal.measurement.C2797k1) r5
            android.content.Context r1 = r4.f17502a
            android.content.Context r3 = r5.mo18688a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzec<com.google.android.gms.internal.measurement.zzdy<com.google.android.gms.internal.measurement.zzdd>> r1 = r4.f17503b
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.internal.measurement.zzec r5 = r5.mo18689b()
            if (r5 != 0) goto L_0x002d
            goto L_0x002c
        L_0x0022:
            com.google.android.gms.internal.measurement.zzec r5 = r5.mo18689b()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2899x0.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.f17502a.hashCode() ^ 1000003) * 1000003;
        zzec<zzdy<zzdd>> zzec = this.f17503b;
        return hashCode ^ (zzec == null ? 0 : zzec.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17502a);
        String valueOf2 = String.valueOf(this.f17503b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }
}
