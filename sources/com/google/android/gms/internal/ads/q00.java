package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class q00 implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    @VisibleForTesting

    /* renamed from: a */
    private zzdts f10659a;

    /* renamed from: b */
    private final String f10660b;

    /* renamed from: c */
    private final String f10661c;

    /* renamed from: d */
    private final zzgn f10662d;

    /* renamed from: e */
    private final int f10663e = 1;

    /* renamed from: f */
    private final LinkedBlockingQueue<zzdud> f10664f;

    /* renamed from: g */
    private final HandlerThread f10665g;

    /* renamed from: h */
    private final zzdsi f10666h;

    /* renamed from: i */
    private final long f10667i;

    public q00(Context context, int i, zzgn zzgn, String str, String str2, String str3, zzdsi zzdsi) {
        this.f10660b = str;
        this.f10662d = zzgn;
        this.f10661c = str2;
        this.f10666h = zzdsi;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.f10665g = handlerThread;
        handlerThread.start();
        this.f10667i = System.currentTimeMillis();
        this.f10659a = new zzdts(context, handlerThread.getLooper(), this, this, 19621000);
        this.f10664f = new LinkedBlockingQueue<>();
        this.f10659a.checkAvailabilityAndConnect();
    }

    /* renamed from: a */
    private final void m6694a() {
        zzdts zzdts = this.f10659a;
        if (zzdts == null) {
            return;
        }
        if (zzdts.isConnected() || this.f10659a.isConnecting()) {
            this.f10659a.disconnect();
        }
    }

    /* renamed from: b */
    private final zzdtv m6695b() {
        try {
            return this.f10659a.zzaxq();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private static zzdud m6696c() {
        return new zzdud((byte[]) null, 1);
    }

    /* renamed from: d */
    private final void m6697d(int i, long j, Exception exc) {
        zzdsi zzdsi = this.f10666h;
        if (zzdsi != null) {
            zzdsi.zza(i, System.currentTimeMillis() - j, exc);
        }
    }

    /* renamed from: e */
    public final zzdud mo14626e(int i) {
        zzdud zzdud;
        try {
            zzdud = this.f10664f.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            m6697d(AdError.INTERSTITIAL_AD_TIMEOUT, this.f10667i, e);
            zzdud = null;
        }
        m6697d(3004, this.f10667i, (Exception) null);
        if (zzdud != null) {
            if (zzdud.status == 7) {
                zzdsi.m8483c(zzbw.zza.zzc.DISABLED);
            } else {
                zzdsi.m8483c(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzdud == null ? m6696c() : zzdud;
    }

    public final void onConnected(Bundle bundle) {
        zzdtv b = m6695b();
        if (b != null) {
            try {
                zzdud zza = b.zza(new zzdub(this.f10663e, this.f10662d, this.f10660b, this.f10661c));
                m6697d(5011, this.f10667i, (Exception) null);
                this.f10664f.put(zza);
            } catch (Throwable th) {
                m6697d(2010, this.f10667i, new Exception(th));
            } finally {
                m6694a();
                this.f10665g.quit();
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            m6697d(4012, this.f10667i, (Exception) null);
            this.f10664f.put(m6696c());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            m6697d(4011, this.f10667i, (Exception) null);
            this.f10664f.put(m6696c());
        } catch (InterruptedException unused) {
        }
    }
}
