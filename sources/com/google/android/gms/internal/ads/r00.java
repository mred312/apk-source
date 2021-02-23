package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class r00 implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final zzdts f10751a;

    /* renamed from: b */
    private final zzdti f10752b;

    /* renamed from: c */
    private final Object f10753c = new Object();

    /* renamed from: d */
    private boolean f10754d = false;

    /* renamed from: e */
    private boolean f10755e = false;

    r00(@NonNull Context context, @NonNull Looper looper, @NonNull zzdti zzdti) {
        this.f10752b = zzdti;
        this.f10751a = new zzdts(context, looper, this, this, 12800000);
    }

    /* renamed from: a */
    private final void m6788a() {
        synchronized (this.f10753c) {
            if (this.f10751a.isConnected() || this.f10751a.isConnecting()) {
                this.f10751a.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo14706b() {
        synchronized (this.f10753c) {
            if (!this.f10754d) {
                this.f10754d = true;
                this.f10751a.checkAvailabilityAndConnect();
            }
        }
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.f10753c) {
            if (!this.f10755e) {
                this.f10755e = true;
                try {
                    this.f10751a.zzaxq().zza(new zzdtq(this.f10752b.toByteArray()));
                    m6788a();
                } catch (Exception unused) {
                    m6788a();
                } catch (Throwable th) {
                    m6788a();
                    throw th;
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i) {
    }
}
