package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzjo implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzjo> CREATOR = new je0();

    /* renamed from: a */
    private final zza[] f16549a;

    /* renamed from: b */
    private int f16550b;
    public final int zzaoj;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new ke0();

        /* renamed from: a */
        private int f16551a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final UUID f16552b;

        /* renamed from: c */
        private final String f16553c;

        /* renamed from: d */
        private final byte[] f16554d;
        public final boolean zzaok;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            return this.f16553c.equals(zza.f16553c) && zzpt.zza(this.f16552b, zza.f16552b) && Arrays.equals(this.f16554d, zza.f16554d);
        }

        public final int hashCode() {
            if (this.f16551a == 0) {
                this.f16551a = (((this.f16552b.hashCode() * 31) + this.f16553c.hashCode()) * 31) + Arrays.hashCode(this.f16554d);
            }
            return this.f16551a;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f16552b.getMostSignificantBits());
            parcel.writeLong(this.f16552b.getLeastSignificantBits());
            parcel.writeString(this.f16553c);
            parcel.writeByteArray(this.f16554d);
            parcel.writeByte(this.zzaok ? (byte) 1 : 0);
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f16552b = (UUID) zzpc.checkNotNull(uuid);
            this.f16553c = (String) zzpc.checkNotNull(str);
            this.f16554d = (byte[]) zzpc.checkNotNull(bArr);
            this.zzaok = false;
        }

        zza(Parcel parcel) {
            this.f16552b = new UUID(parcel.readLong(), parcel.readLong());
            this.f16553c = parcel.readString();
            this.f16554d = parcel.createByteArray();
            this.zzaok = parcel.readByte() != 0;
        }
    }

    public zzjo(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zza zza2 = (zza) obj;
        zza zza3 = (zza) obj2;
        UUID uuid = zzhb.UUID_NIL;
        if (uuid.equals(zza2.f16552b)) {
            return uuid.equals(zza3.f16552b) ? 0 : 1;
        }
        return zza2.f16552b.compareTo(zza3.f16552b);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzjo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f16549a, ((zzjo) obj).f16549a);
    }

    public final int hashCode() {
        if (this.f16550b == 0) {
            this.f16550b = Arrays.hashCode(this.f16549a);
        }
        return this.f16550b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f16549a, 0);
    }

    public final zza zzae(int i) {
        return this.f16549a[i];
    }

    public zzjo(zza... zzaArr) {
        this(true, zzaArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.google.android.gms.internal.ads.zzjo$zza[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzjo(boolean r3, com.google.android.gms.internal.ads.zzjo.zza... r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L_0x000c
            java.lang.Object r3 = r4.clone()
            r4 = r3
            com.google.android.gms.internal.ads.zzjo$zza[] r4 = (com.google.android.gms.internal.ads.zzjo.zza[]) r4
        L_0x000c:
            java.util.Arrays.sort(r4, r2)
            r3 = 1
        L_0x0010:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x0055
            int r0 = r3 + -1
            r0 = r4[r0]
            java.util.UUID r0 = r0.f16552b
            r1 = r4[r3]
            java.util.UUID r1 = r1.f16552b
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r3 = r3 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = r4[r3]
            java.util.UUID r3 = r3.f16552b
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 25
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r4 = "Duplicate data for uuid: "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0055:
            r2.f16549a = r4
            int r3 = r4.length
            r2.zzaoj = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjo.<init>(boolean, com.google.android.gms.internal.ads.zzjo$zza[]):void");
    }

    zzjo(Parcel parcel) {
        zza[] zzaArr = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.f16549a = zzaArr;
        this.zzaoj = zzaArr.length;
    }
}
