package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzdvq {

    /* renamed from: a */
    private final String f15995a;

    /* renamed from: b */
    private final s10 f15996b;

    /* renamed from: c */
    private s10 f15997c;

    private zzdvq(String str) {
        s10 s10 = new s10();
        this.f15996b = s10;
        this.f15997c = s10;
        this.f15995a = (String) zzdvv.checkNotNull(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f15995a);
        sb.append('{');
        s10 s10 = this.f15996b.f10842b;
        String str = "";
        while (s10 != null) {
            Object obj = s10.f10841a;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            s10 = s10.f10842b;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzdvq zzz(@NullableDecl Object obj) {
        s10 s10 = new s10();
        this.f15997c.f10842b = s10;
        this.f15997c = s10;
        s10.f10841a = obj;
        return this;
    }
}
