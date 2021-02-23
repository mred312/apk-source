package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* renamed from: com.google.android.gms.internal.ads.ds */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1853ds implements zzdyo<ArrayList<Uri>> {

    /* renamed from: a */
    private final /* synthetic */ zzasa f8288a;

    C1853ds(zzcyx zzcyx, zzasa zzasa) {
        this.f8288a = zzasa;
    }

    public final /* synthetic */ void onSuccess(@Nonnull Object obj) {
        try {
            this.f8288a.onSuccess((ArrayList) obj);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzasa zzasa = this.f8288a;
            String valueOf = String.valueOf(th.getMessage());
            zzasa.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
