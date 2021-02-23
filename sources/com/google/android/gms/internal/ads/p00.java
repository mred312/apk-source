package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class p00 implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    @VisibleForTesting

    /* renamed from: a */
    private zzdts f10412a;

    /* renamed from: b */
    private final String f10413b;

    /* renamed from: c */
    private final String f10414c;

    /* renamed from: d */
    private final LinkedBlockingQueue<zzcf.zza> f10415d = new LinkedBlockingQueue<>();

    /* renamed from: e */
    private final HandlerThread f10416e;

    public p00(Context context, String str, String str2) {
        this.f10413b = str;
        this.f10414c = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.f10416e = handlerThread;
        handlerThread.start();
        this.f10412a = new zzdts(context, handlerThread.getLooper(), this, this, 9200000);
        this.f10412a.checkAvailabilityAndConnect();
    }

    /* renamed from: a */
    private final void m6599a() {
        zzdts zzdts = this.f10412a;
        if (zzdts == null) {
            return;
        }
        if (zzdts.isConnected() || this.f10412a.isConnecting()) {
            this.f10412a.disconnect();
        }
    }

    /* renamed from: b */
    private final zzdtv m6600b() {
        try {
            return this.f10412a.zzaxq();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private static zzcf.zza m6601c() {
        return (zzcf.zza) ((zzekh) zzcf.zza.zzaq().zzn(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbhv());
    }

    /* renamed from: d */
    public final zzcf.zza mo14559d(int i) {
        zzcf.zza zza;
        try {
            zza = this.f10415d.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? m6601c() : zza;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|11|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        m6599a();
        r3.f10416e.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.f10415d.put(m6601c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        m6599a();
        r3.f10416e.quit();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdtv r4 = r3.m6600b()
            if (r4 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzdtr r0 = new com.google.android.gms.internal.ads.zzdtr     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = r3.f10413b     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r3.f10414c     // Catch:{ all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdtt r4 = r4.zza((com.google.android.gms.internal.ads.zzdtr) r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcf$zza r4 = r4.zzaxr()     // Catch:{ all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r0 = r3.f10415d     // Catch:{ all -> 0x0025 }
            r0.put(r4)     // Catch:{ all -> 0x0025 }
            r3.m6599a()
            android.os.HandlerThread r4 = r3.f10416e
            r4.quit()
            return
        L_0x0025:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r4 = r3.f10415d     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            com.google.android.gms.internal.ads.zzcf$zza r0 = m6601c()     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            goto L_0x0039
        L_0x002f:
            r4 = move-exception
            r3.m6599a()
            android.os.HandlerThread r0 = r3.f10416e
            r0.quit()
            throw r4
        L_0x0039:
            r3.m6599a()
            android.os.HandlerThread r4 = r3.f10416e
            r4.quit()
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.p00.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.f10415d.put(m6601c());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.f10415d.put(m6601c());
        } catch (InterruptedException unused) {
        }
    }
}
