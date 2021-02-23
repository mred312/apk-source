package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zznz {

    /* renamed from: a */
    private final boolean f16780a;
    public final int viewportHeight;
    public final int viewportWidth;
    public final int zzbhe;
    public final int zzbhf;
    public final int zzbhg;
    public final boolean zzbhh;
    public final boolean zzbhi;
    public final boolean zzbhj;

    public zznz() {
        this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznz.class == obj.getClass()) {
            zznz zznz = (zznz) obj;
            return this.f16780a == zznz.f16780a && this.zzbhe == zznz.zzbhe && this.zzbhf == zznz.zzbhf && this.zzbhh == zznz.zzbhh && this.zzbhi == zznz.zzbhi && this.zzbhj == zznz.zzbhj && this.viewportWidth == zznz.viewportWidth && this.viewportHeight == zznz.viewportHeight && this.zzbhg == zznz.zzbhg && TextUtils.equals((CharSequence) null, (CharSequence) null) && TextUtils.equals((CharSequence) null, (CharSequence) null);
        }
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.f16780a ? 1 : 0)) * 31) + this.zzbhe) * 31) + this.zzbhf) * 31) + this.zzbhg) * 31) + (this.zzbhh ? 1 : 0)) * 31) + (this.zzbhi ? 1 : 0)) * 31) + (this.zzbhj ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }

    private zznz(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.f16780a = true;
        this.zzbhe = Integer.MAX_VALUE;
        this.zzbhf = Integer.MAX_VALUE;
        this.zzbhg = Integer.MAX_VALUE;
        this.zzbhh = true;
        this.zzbhi = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbhj = true;
    }
}
