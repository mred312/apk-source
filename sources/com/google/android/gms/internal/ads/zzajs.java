package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzajs extends zzgw implements zzajt {
    public zzajs() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public static zzajt zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
        if (queryLocalInterface instanceof zzajt) {
            return (zzajt) queryLocalInterface;
        }
        return new zzajv(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            r5 = 1
            if (r2 == r5) goto L_0x001f
            r0 = 2
            if (r2 == r0) goto L_0x0017
            r0 = 3
            if (r2 == r0) goto L_0x000b
            r2 = 0
            return r2
        L_0x000b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzve> r2 = com.google.android.gms.internal.ads.zzve.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzve r2 = (com.google.android.gms.internal.ads.zzve) r2
            r1.zzd(r2)
            goto L_0x003e
        L_0x0017:
            int r2 = r3.readInt()
            r1.onInstreamAdFailedToLoad(r2)
            goto L_0x003e
        L_0x001f:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0027
            r2 = 0
            goto L_0x003b
        L_0x0027:
            java.lang.String r3 = "com.google.android.gms.ads.internal.instream.client.IInstreamAd"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zzajn
            if (r0 == 0) goto L_0x0035
            r2 = r3
            com.google.android.gms.internal.ads.zzajn r2 = (com.google.android.gms.internal.ads.zzajn) r2
            goto L_0x003b
        L_0x0035:
            com.google.android.gms.internal.ads.zzajp r3 = new com.google.android.gms.internal.ads.zzajp
            r3.<init>(r2)
            r2 = r3
        L_0x003b:
            r1.zza(r2)
        L_0x003e:
            r4.writeNoException()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajs.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
