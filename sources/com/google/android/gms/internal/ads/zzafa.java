package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzafa extends zzgw implements zzafb {
    public zzafa() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                IObjectWrapper zzsv = zzsv();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzsv);
                return true;
            case 3:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 5:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 6:
                zzaej zzsz = zzsz();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzsz);
                return true;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 8:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                return true;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzgv.zzb(parcel2, extras);
                return true;
            case 10:
                destroy();
                parcel2.writeNoException();
                return true;
            case 11:
                zzys videoController = getVideoController();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) videoController);
                return true;
            case 12:
                performClick((Bundle) zzgv.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean recordImpression = recordImpression((Bundle) zzgv.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, recordImpression);
                return true;
            case 14:
                reportTouchEvent((Bundle) zzgv.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzaeb zzsx = zzsx();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzsx);
                return true;
            case 16:
                IObjectWrapper zzsy = zzsy();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzsy);
                return true;
            case 17:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
