package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzji implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile boolean f18679a;

    /* renamed from: b */
    private volatile zzeo f18680b;

    /* renamed from: c */
    final /* synthetic */ zzio f18681c;

    protected zzji(zzio zzio) {
        this.f18681c = zzio;
    }

    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f18681c.zzp().zza((Runnable) new C3151x6(this, (zzej) this.f18680b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f18680b = null;
                this.f18679a = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzer zzc = this.f18681c.zzy.zzc();
        if (zzc != null) {
            zzc.zzh().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f18679a = false;
            this.f18680b = null;
        }
        this.f18681c.zzp().zza((Runnable) new C3160y6(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.f18681c.zzq().zzv().zza("Service connection suspended");
        this.f18681c.zzp().zza((Runnable) new C3142w6(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.f18681c.zzq().zze().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0062 */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.f18679a = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzio r4 = r3.f18681c     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzer r4 = r4.zzq()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zze()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0099
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0062 }
            if (r2 == 0) goto L_0x0052
            if (r5 != 0) goto L_0x002f
            goto L_0x0042
        L_0x002f:
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0062 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzej     // Catch:{ RemoteException -> 0x0062 }
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzej r1 = (com.google.android.gms.measurement.internal.zzej) r1     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0041
        L_0x003c:
            com.google.android.gms.measurement.internal.zzel r1 = new com.google.android.gms.measurement.internal.zzel     // Catch:{ RemoteException -> 0x0062 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0062 }
        L_0x0041:
            r0 = r1
        L_0x0042:
            com.google.android.gms.measurement.internal.zzio r5 = r3.f18681c     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzq()     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzw()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0071
        L_0x0052:
            com.google.android.gms.measurement.internal.zzio r5 = r3.f18681c     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzq()     // Catch:{ RemoteException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zze()     // Catch:{ RemoteException -> 0x0062 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zza(r2, r1)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0071
        L_0x0062:
            com.google.android.gms.measurement.internal.zzio r5 = r3.f18681c     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzq()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zze()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x001c }
        L_0x0071:
            if (r0 != 0) goto L_0x0089
            r3.f18679a = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzio r5 = r3.f18681c     // Catch:{ IllegalArgumentException -> 0x0097 }
            android.content.Context r5 = r5.zzm()     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzio r0 = r3.f18681c     // Catch:{ IllegalArgumentException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzji r0 = r0.f18672b     // Catch:{ IllegalArgumentException -> 0x0097 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0097 }
            goto L_0x0097
        L_0x0089:
            com.google.android.gms.measurement.internal.zzio r4 = r3.f18681c     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfo r4 = r4.zzp()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.v6 r5 = new com.google.android.gms.measurement.internal.v6     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zza((java.lang.Runnable) r5)     // Catch:{ all -> 0x001c }
        L_0x0097:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0099:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzji.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.f18681c.zzq().zzv().zza("Service disconnected");
        this.f18681c.zzp().zza((Runnable) new C3124u6(this, componentName));
    }

    @WorkerThread
    public final void zza(Intent intent) {
        this.f18681c.zzc();
        Context zzm = this.f18681c.zzm();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.f18679a) {
                this.f18681c.zzq().zzw().zza("Connection attempt already in progress");
                return;
            }
            this.f18681c.zzq().zzw().zza("Using local app measurement service");
            this.f18679a = true;
            instance.bindService(zzm, intent, this.f18681c.f18672b, 129);
        }
    }

    @WorkerThread
    public final void zzb() {
        this.f18681c.zzc();
        Context zzm = this.f18681c.zzm();
        synchronized (this) {
            if (this.f18679a) {
                this.f18681c.zzq().zzw().zza("Connection attempt already in progress");
            } else if (this.f18680b == null || (!this.f18680b.isConnecting() && !this.f18680b.isConnected())) {
                this.f18680b = new zzeo(zzm, Looper.getMainLooper(), this, this);
                this.f18681c.zzq().zzw().zza("Connecting to remote service");
                this.f18679a = true;
                this.f18680b.checkAvailabilityAndConnect();
            } else {
                this.f18681c.zzq().zzw().zza("Already awaiting connection attempt");
            }
        }
    }

    @WorkerThread
    public final void zza() {
        if (this.f18680b != null && (this.f18680b.isConnected() || this.f18680b.isConnecting())) {
            this.f18680b.disconnect();
        }
        this.f18680b = null;
    }
}
