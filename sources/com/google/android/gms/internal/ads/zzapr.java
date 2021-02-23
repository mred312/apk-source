package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzapr extends zzgw implements zzapo {
    public zzapr() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzapo zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzapo) {
            return (zzapo) queryLocalInterface;
        }
        return new zzapq(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [com.google.android.gms.internal.ads.zzapc] */
    /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.internal.ads.zzapj] */
    /* JADX WARNING: type inference failed for: r2v13, types: [com.google.android.gms.internal.ads.zzaph] */
    /* JADX WARNING: type inference failed for: r5v8, types: [com.google.android.gms.internal.ads.zzaph] */
    /* JADX WARNING: type inference failed for: r2v17, types: [com.google.android.gms.internal.ads.zzapp] */
    /* JADX WARNING: type inference failed for: r2v18, types: [com.google.android.gms.internal.ads.zzapn] */
    /* JADX WARNING: type inference failed for: r5v10, types: [com.google.android.gms.internal.ads.zzapn] */
    /* JADX WARNING: type inference failed for: r2v23, types: [com.google.android.gms.internal.ads.zzapk] */
    /* JADX WARNING: type inference failed for: r2v24, types: [com.google.android.gms.internal.ads.zzapi] */
    /* JADX WARNING: type inference failed for: r5v13, types: [com.google.android.gms.internal.ads.zzapi] */
    /* JADX WARNING: type inference failed for: r2v28, types: [com.google.android.gms.internal.ads.zzapp] */
    /* JADX WARNING: type inference failed for: r2v29, types: [com.google.android.gms.internal.ads.zzapn] */
    /* JADX WARNING: type inference failed for: r5v15, types: [com.google.android.gms.internal.ads.zzapn] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r14, android.os.Parcel r15, android.os.Parcel r16, int r17) {
        /*
            r13 = this;
            r8 = r13
            r0 = r14
            r1 = r15
            r9 = r16
            r10 = 1
            r2 = 0
            if (r0 == r10) goto L_0x0218
            r3 = 2
            if (r0 == r3) goto L_0x020d
            r3 = 3
            if (r0 == r3) goto L_0x0202
            r3 = 5
            if (r0 == r3) goto L_0x01f6
            r3 = 10
            if (r0 == r3) goto L_0x01e6
            r3 = 11
            if (r0 == r3) goto L_0x01d2
            java.lang.String r3 = "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback"
            switch(r0) {
                case 13: goto L_0x017d;
                case 14: goto L_0x0132;
                case 15: goto L_0x011e;
                case 16: goto L_0x00d5;
                case 17: goto L_0x00c1;
                case 18: goto L_0x0076;
                case 19: goto L_0x006a;
                case 20: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            java.lang.String r4 = r15.readString()
            java.lang.String r5 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzvk r6 = (com.google.android.gms.internal.ads.zzvk) r6
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x0042
        L_0x0040:
            r11 = r2
            goto L_0x0053
        L_0x0042:
            android.os.IInterface r2 = r0.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzapn
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzapn r2 = (com.google.android.gms.internal.ads.zzapn) r2
            goto L_0x0040
        L_0x004d:
            com.google.android.gms.internal.ads.zzapp r2 = new com.google.android.gms.internal.ads.zzapp
            r2.<init>(r0)
            goto L_0x0040
        L_0x0053:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r12 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r13
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r11
            r6 = r12
            r0.zzb(r1, r2, r3, r4, r5, r6)
            r16.writeNoException()
            goto L_0x0264
        L_0x006a:
            java.lang.String r0 = r15.readString()
            r13.zzdn(r0)
            r16.writeNoException()
            goto L_0x0264
        L_0x0076:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zzvk r5 = (com.google.android.gms.internal.ads.zzvk) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x0097
        L_0x0095:
            r7 = r2
            goto L_0x00aa
        L_0x0097:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzapi
            if (r7 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzapi r2 = (com.google.android.gms.internal.ads.zzapi) r2
            goto L_0x0095
        L_0x00a4:
            com.google.android.gms.internal.ads.zzapk r2 = new com.google.android.gms.internal.ads.zzapk
            r2.<init>(r0)
            goto L_0x0095
        L_0x00aa:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r11 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzvk) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzapi) r5, (com.google.android.gms.internal.ads.zzano) r6)
            r16.writeNoException()
            goto L_0x0264
        L_0x00c1:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r13.zzaa(r0)
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzgv.writeBoolean(r9, r0)
            goto L_0x0264
        L_0x00d5:
            java.lang.String r4 = r15.readString()
            java.lang.String r5 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzvk r6 = (com.google.android.gms.internal.ads.zzvk) r6
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x00f6
        L_0x00f4:
            r11 = r2
            goto L_0x0107
        L_0x00f6:
            android.os.IInterface r2 = r0.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzapn
            if (r3 == 0) goto L_0x0101
            com.google.android.gms.internal.ads.zzapn r2 = (com.google.android.gms.internal.ads.zzapn) r2
            goto L_0x00f4
        L_0x0101:
            com.google.android.gms.internal.ads.zzapp r2 = new com.google.android.gms.internal.ads.zzapp
            r2.<init>(r0)
            goto L_0x00f4
        L_0x0107:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r12 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r13
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r11
            r6 = r12
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzvk) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzapn) r5, (com.google.android.gms.internal.ads.zzano) r6)
            r16.writeNoException()
            goto L_0x0264
        L_0x011e:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r13.zzz(r0)
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzgv.writeBoolean(r9, r0)
            goto L_0x0264
        L_0x0132:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zzvk r5 = (com.google.android.gms.internal.ads.zzvk) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x0153
        L_0x0151:
            r7 = r2
            goto L_0x0166
        L_0x0153:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzaph
            if (r7 == 0) goto L_0x0160
            com.google.android.gms.internal.ads.zzaph r2 = (com.google.android.gms.internal.ads.zzaph) r2
            goto L_0x0151
        L_0x0160:
            com.google.android.gms.internal.ads.zzapj r2 = new com.google.android.gms.internal.ads.zzapj
            r2.<init>(r0)
            goto L_0x0151
        L_0x0166:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r11 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.internal.ads.zzvk) r3, (com.google.android.gms.dynamic.IObjectWrapper) r4, (com.google.android.gms.internal.ads.zzaph) r5, (com.google.android.gms.internal.ads.zzano) r6)
            r16.writeNoException()
            goto L_0x0264
        L_0x017d:
            java.lang.String r3 = r15.readString()
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvk> r0 = com.google.android.gms.internal.ads.zzvk.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zzvk r5 = (com.google.android.gms.internal.ads.zzvk) r5
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x019e
        L_0x019c:
            r7 = r2
            goto L_0x01b1
        L_0x019e:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzapc
            if (r7 == 0) goto L_0x01ab
            com.google.android.gms.internal.ads.zzapc r2 = (com.google.android.gms.internal.ads.zzapc) r2
            goto L_0x019c
        L_0x01ab:
            com.google.android.gms.internal.ads.zzape r2 = new com.google.android.gms.internal.ads.zzape
            r2.<init>(r0)
            goto L_0x019c
        L_0x01b1:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.internal.ads.zzano r11 = com.google.android.gms.internal.ads.zzanr.zzad(r0)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r0 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r12 = r0
            com.google.android.gms.internal.ads.zzvn r12 = (com.google.android.gms.internal.ads.zzvn) r12
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r7 = r12
            r0.zza(r1, r2, r3, r4, r5, r6, r7)
            r16.writeNoException()
            goto L_0x0264
        L_0x01d2:
            java.lang.String[] r0 = r15.createStringArray()
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            java.lang.Object[] r1 = r15.createTypedArray(r2)
            android.os.Bundle[] r1 = (android.os.Bundle[]) r1
            r13.zza(r0, r1)
            r16.writeNoException()
            goto L_0x0264
        L_0x01e6:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r13.zzy(r0)
            r16.writeNoException()
            goto L_0x0264
        L_0x01f6:
            com.google.android.gms.internal.ads.zzys r0 = r13.getVideoController()
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r9, (android.os.IInterface) r0)
            goto L_0x0264
        L_0x0202:
            com.google.android.gms.internal.ads.zzaqc r0 = r13.zzum()
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r9, r0)
            goto L_0x0264
        L_0x020d:
            com.google.android.gms.internal.ads.zzaqc r0 = r13.zzul()
            r16.writeNoException()
            com.google.android.gms.internal.ads.zzgv.zzb(r9, r0)
            goto L_0x0264
        L_0x0218:
            android.os.IBinder r0 = r15.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            java.lang.String r4 = r15.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r6 = r0
            android.os.Bundle r6 = (android.os.Bundle) r6
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvn> r0 = com.google.android.gms.internal.ads.zzvn.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzgv.zza((android.os.Parcel) r15, r0)
            r7 = r0
            com.google.android.gms.internal.ads.zzvn r7 = (com.google.android.gms.internal.ads.zzvn) r7
            android.os.IBinder r0 = r15.readStrongBinder()
            if (r0 != 0) goto L_0x0244
            r11 = r2
            goto L_0x0257
        L_0x0244:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzapt
            if (r2 == 0) goto L_0x0251
            com.google.android.gms.internal.ads.zzapt r1 = (com.google.android.gms.internal.ads.zzapt) r1
            goto L_0x0256
        L_0x0251:
            com.google.android.gms.internal.ads.zzapv r1 = new com.google.android.gms.internal.ads.zzapv
            r1.<init>(r0)
        L_0x0256:
            r11 = r1
        L_0x0257:
            r0 = r13
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1, (java.lang.String) r2, (android.os.Bundle) r3, (android.os.Bundle) r4, (com.google.android.gms.internal.ads.zzvn) r5, (com.google.android.gms.internal.ads.zzapt) r6)
            r16.writeNoException()
        L_0x0264:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapr.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
