package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzcnu implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final Object mLock = new Object();
    protected final zzazq<InputStream> zzdkm = new zzazq<>();
    protected boolean zzgnf = false;
    protected boolean zzgng = false;
    protected zzatl zzgnh;
    @VisibleForTesting(otherwise = 3)
    @GuardedBy("mLock")
    protected zzast zzgni;

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaza.zzeb("Disconnected from remote ad request service.");
        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    public void onConnectionSuspended(int i) {
        zzaza.zzeb("Cannot connect to remote service, fallback to local instance.");
    }

    /* access modifiers changed from: protected */
    public final void zzara() {
        synchronized (this.mLock) {
            this.zzgng = true;
            if (this.zzgni.isConnected() || this.zzgni.isConnecting()) {
                this.zzgni.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
