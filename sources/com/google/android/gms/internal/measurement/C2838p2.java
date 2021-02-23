package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.measurement.p2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2838p2<K, V> extends zzfc<K, V> {

    /* renamed from: g */
    static final zzfc<Object, Object> f17405g = new C2838p2((Object) null, new Object[0], 0);

    /* renamed from: d */
    private final transient Object f17406d;

    /* renamed from: e */
    private final transient Object[] f17407e;

    /* renamed from: f */
    private final transient int f17408f;

    private C2838p2(Object obj, Object[] objArr, int i) {
        this.f17406d = obj;
        this.f17407e = objArr;
        this.f17408f = i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v3 ?, r2v5 ?, r2v4 ?, r2v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    /* renamed from: d */
    static <K, V> com.google.android.gms.internal.measurement.C2838p2<K, V> m9696d(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.measurement.zzfc<java.lang.Object, java.lang.Object> r10 = f17405g
            com.google.android.gms.internal.measurement.p2 r10 = (com.google.android.gms.internal.measurement.C2838p2) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.gms.internal.measurement.C2907y1.m9935a(r10, r1)
            com.google.android.gms.internal.measurement.p2 r10 = new com.google.android.gms.internal.measurement.p2
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.gms.internal.measurement.zzeb.zzb((int) r10, (int) r3)
            int r3 = com.google.android.gms.internal.measurement.zzfg.m10338f(r10)
            if (r10 != r2) goto L_0x002d
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.gms.internal.measurement.C2907y1.m9935a(r1, r2)
            goto L_0x00e1
        L_0x002d:
            int r0 = r3 + -1
            r2 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r3 > r2) goto L_0x006f
            byte[] r2 = new byte[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x0039:
            if (r1 >= r10) goto L_0x006c
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.measurement.C2907y1.m9935a(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.measurement.C2790j2.m9519a(r6)
        L_0x004e:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x005c
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0039
        L_0x005c:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0067
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0067:
            java.lang.IllegalArgumentException r10 = m9697e(r4, r5, r11, r7)
            throw r10
        L_0x006c:
            r0 = r2
            goto L_0x00e1
        L_0x006f:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r3 > r2) goto L_0x00ad
            short[] r2 = new short[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x0079:
            if (r1 >= r10) goto L_0x006c
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.measurement.C2907y1.m9935a(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.measurement.C2790j2.m9519a(r6)
        L_0x008e:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x009d
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0079
        L_0x009d:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00a8
            int r6 = r6 + 1
            goto L_0x008e
        L_0x00a8:
            java.lang.IllegalArgumentException r10 = m9697e(r4, r5, r11, r7)
            throw r10
        L_0x00ad:
            int[] r2 = new int[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x00b2:
            if (r1 >= r10) goto L_0x006c
            int r3 = r1 * 2
            r5 = r11[r3]
            r6 = r3 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.measurement.C2907y1.m9935a(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.measurement.C2790j2.m9519a(r7)
        L_0x00c7:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r4) goto L_0x00d1
            r2[r7] = r3
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00d1:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00dc
            int r7 = r7 + 1
            goto L_0x00c7
        L_0x00dc:
            java.lang.IllegalArgumentException r10 = m9697e(r5, r6, r11, r8)
            throw r10
        L_0x00e1:
            com.google.android.gms.internal.measurement.p2 r1 = new com.google.android.gms.internal.measurement.p2
            r1.<init>(r0, r11, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2838p2.m9696d(int, java.lang.Object[]):com.google.android.gms.internal.measurement.p2");
    }

    /* renamed from: e */
    private static IllegalArgumentException m9697e(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final zzfg<Map.Entry<K, V>> mo18790a() {
        return new C2830o2(this, this.f17407e, 0, this.f17408f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final zzfg<K> mo18791b() {
        return new C2846q2(this, new C2870t2(this.f17407e, 0, this.f17408f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final zzey<V> mo18792c() {
        return new C2870t2(this.f17407e, 1, this.f17408f);
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.f17406d;
        V[] vArr = this.f17407e;
        int i = this.f17408f;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int a = C2790j2.m9519a(obj.hashCode());
                while (true) {
                    int i2 = a & length;
                    byte b = bArr[i2] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    a = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int a2 = C2790j2.m9519a(obj.hashCode());
                while (true) {
                    int i3 = a2 & length2;
                    short s = sArr[i3] & 65535;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    a2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int a3 = C2790j2.m9519a(obj.hashCode());
                while (true) {
                    int i4 = a3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    a3 = i4 + 1;
                }
            }
        }
    }

    public final int size() {
        return this.f17408f;
    }
}
