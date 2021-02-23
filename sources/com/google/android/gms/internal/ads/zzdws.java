package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdws<E> extends d20<E> {
    @NullableDecl

    /* renamed from: d */
    private Object[] f16036d;

    /* renamed from: e */
    private int f16037e;

    public zzdws() {
        super(4);
    }

    public final /* synthetic */ zzdwn zza(Iterator it) {
        zzdvv.checkNotNull(it);
        while (it.hasNext()) {
            zzac(it.next());
        }
        return this;
    }

    public final /* synthetic */ d20 zzab(Object obj) {
        return (zzdws) zzac(obj);
    }

    public final /* synthetic */ zzdwn zzac(Object obj) {
        zzdvv.checkNotNull(obj);
        if (this.f16036d != null) {
            int j = zzdwt.m8551j(this.f8046b);
            Object[] objArr = this.f16036d;
            if (j <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int a = c20.m5878a(hashCode);
                while (true) {
                    int i = a & length;
                    Object[] objArr2 = this.f16036d;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        a = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.f16037e += hashCode;
                        super.zzab(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.f16036d = null;
        super.zzab(obj);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ads.m20} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.internal.ads.zzdwt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.internal.ads.m20} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.ads.m20} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdwt<E> zzayz() {
        /*
            r8 = this;
            int r0 = r8.f8046b
            if (r0 == 0) goto L_0x0059
            r1 = 1
            if (r0 == r1) goto L_0x004f
            java.lang.Object[] r2 = r8.f16036d
            if (r2 == 0) goto L_0x003b
            int r0 = com.google.android.gms.internal.ads.zzdwt.m8551j(r0)
            java.lang.Object[] r2 = r8.f16036d
            int r2 = r2.length
            if (r0 != r2) goto L_0x003b
            int r0 = r8.f8046b
            java.lang.Object[] r2 = r8.f8045a
            int r2 = r2.length
            boolean r0 = com.google.android.gms.internal.ads.zzdwt.m8552k(r0, r2)
            if (r0 == 0) goto L_0x0028
            java.lang.Object[] r0 = r8.f8045a
            int r2 = r8.f8046b
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            goto L_0x002a
        L_0x0028:
            java.lang.Object[] r0 = r8.f8045a
        L_0x002a:
            r3 = r0
            com.google.android.gms.internal.ads.m20 r0 = new com.google.android.gms.internal.ads.m20
            int r4 = r8.f16037e
            java.lang.Object[] r5 = r8.f16036d
            int r2 = r5.length
            int r6 = r2 + -1
            int r7 = r8.f8046b
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0049
        L_0x003b:
            int r0 = r8.f8046b
            java.lang.Object[] r2 = r8.f8045a
            com.google.android.gms.internal.ads.zzdwt r0 = com.google.android.gms.internal.ads.zzdwt.m8549f(r0, r2)
            int r2 = r0.size()
            r8.f8046b = r2
        L_0x0049:
            r8.f8047c = r1
            r1 = 0
            r8.f16036d = r1
            return r0
        L_0x004f:
            java.lang.Object[] r0 = r8.f8045a
            r1 = 0
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzdwt r0 = com.google.android.gms.internal.ads.zzdwt.zzae(r0)
            return r0
        L_0x0059:
            com.google.android.gms.internal.ads.m20<java.lang.Object> r0 = com.google.android.gms.internal.ads.m20.f9902h
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdws.zzayz():com.google.android.gms.internal.ads.zzdwt");
    }

    public final /* synthetic */ zzdwn zzg(Iterable iterable) {
        zzdvv.checkNotNull(iterable);
        if (this.f16036d != null) {
            for (Object zzac : iterable) {
                zzac(zzac);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    zzdws(int i) {
        super(i);
        this.f16036d = new Object[zzdwt.m8551j(i)];
    }
}
