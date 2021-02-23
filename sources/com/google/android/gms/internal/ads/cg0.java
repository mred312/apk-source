package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class cg0 {

    /* renamed from: a */
    private final zzjw[] f8006a;

    /* renamed from: b */
    private final zzjy f8007b;

    /* renamed from: c */
    private zzjw f8008c;

    public cg0(zzjw[] zzjwArr, zzjy zzjy) {
        this.f8006a = zzjwArr;
        this.f8007b = zzjy;
    }

    /* renamed from: a */
    public final void mo13779a() {
        zzjw zzjw = this.f8008c;
        if (zzjw != null) {
            zzjw.release();
            this.f8008c = null;
        }
    }

    /* renamed from: b */
    public final zzjw mo13780b(zzjz zzjz, Uri uri) {
        zzjw zzjw = this.f8008c;
        if (zzjw != null) {
            return zzjw;
        }
        zzjw[] zzjwArr = this.f8006a;
        int length = zzjwArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjw zzjw2 = zzjwArr[i];
            try {
                if (zzjw2.zza(zzjz)) {
                    this.f8008c = zzjw2;
                    zzjz.zzgq();
                    break;
                }
                i++;
            } catch (EOFException unused) {
            } finally {
                zzjz.zzgq();
            }
        }
        zzjw zzjw3 = this.f8008c;
        if (zzjw3 != null) {
            zzjw3.zza(this.f8007b);
            return this.f8008c;
        }
        String zza = zzpt.zza((Object[]) this.f8006a);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zznt(sb.toString(), uri);
    }
}
