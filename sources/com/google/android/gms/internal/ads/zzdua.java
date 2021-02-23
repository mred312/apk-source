package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdua {

    /* renamed from: a */
    private final zzgt f15967a;

    /* renamed from: b */
    private final File f15968b;

    /* renamed from: c */
    private final File f15969c;

    /* renamed from: d */
    private final File f15970d;

    /* renamed from: e */
    private byte[] f15971e;

    public zzdua(@NonNull zzgt zzgt, @NonNull File file, @NonNull File file2, @NonNull File file3) {
        this.f15967a = zzgt;
        this.f15968b = file;
        this.f15969c = file3;
        this.f15970d = file2;
    }

    public final boolean zza() {
        return System.currentTimeMillis() / 1000 > this.f15967a.zzdi();
    }

    public final zzgt zzaxz() {
        return this.f15967a;
    }

    public final File zzaya() {
        return this.f15968b;
    }

    public final File zzayb() {
        return this.f15969c;
    }

    public final byte[] zzayc() {
        if (this.f15971e == null) {
            this.f15971e = zzduc.zzf(this.f15970d);
        }
        byte[] bArr = this.f15971e;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean zzff(long j) {
        return this.f15967a.zzdi() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
