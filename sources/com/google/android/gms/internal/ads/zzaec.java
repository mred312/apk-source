package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaec extends NativeAd.AdChoicesInfo {

    /* renamed from: a */
    private final zzaeb f12419a;

    /* renamed from: b */
    private final List<NativeAd.Image> f12420b = new ArrayList();

    /* renamed from: c */
    private String f12421c;

    public zzaec(zzaeb zzaeb) {
        zzaej zzaej;
        IBinder iBinder;
        this.f12419a = zzaeb;
        try {
            this.f12421c = zzaeb.getText();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            this.f12421c = "";
        }
        try {
            for (zzaej next : zzaeb.zzsm()) {
                if (!(next instanceof IBinder) || (iBinder = (IBinder) next) == null) {
                    zzaej = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaej = queryLocalInterface instanceof zzaej ? (zzaej) queryLocalInterface : new zzael(iBinder);
                }
                if (zzaej != null) {
                    this.f12420b.add(new zzaek(zzaej));
                }
            }
        } catch (RemoteException e2) {
            zzaza.zzc("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.f12420b;
    }

    public final CharSequence getText() {
        return this.f12421c;
    }
}
