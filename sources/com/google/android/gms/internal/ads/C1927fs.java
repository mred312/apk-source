package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.Collections;
import javax.annotation.Nonnull;

/* renamed from: com.google.android.gms.internal.ads.fs */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1927fs implements zzdyo<Uri> {

    /* renamed from: a */
    private final /* synthetic */ zzasa f8490a;

    C1927fs(zzcyx zzcyx, zzasa zzasa) {
        this.f8490a = zzasa;
    }

    public final /* synthetic */ void onSuccess(@Nonnull Object obj) {
        try {
            this.f8490a.onSuccess(Collections.singletonList((Uri) obj));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzasa zzasa = this.f8490a;
            String valueOf = String.valueOf(th.getMessage());
            zzasa.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
