package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpb;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ng0<T extends zzpb> extends Handler implements Runnable {

    /* renamed from: a */
    private final T f10192a;

    /* renamed from: b */
    private final zzoz<T> f10193b;

    /* renamed from: c */
    public final int f10194c;

    /* renamed from: d */
    private final long f10195d;

    /* renamed from: e */
    private IOException f10196e;

    /* renamed from: f */
    private int f10197f;

    /* renamed from: g */
    private volatile Thread f10198g;

    /* renamed from: h */
    private volatile boolean f10199h;

    /* renamed from: i */
    private final /* synthetic */ zzow f10200i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ng0(zzow zzow, Looper looper, T t, zzoz<T> zzoz, int i, long j) {
        super(looper);
        this.f10200i = zzow;
        this.f10192a = t;
        this.f10193b = zzoz;
        this.f10194c = i;
        this.f10195d = j;
    }

    /* renamed from: a */
    private final void m6560a() {
        this.f10196e = null;
        this.f10200i.f16813a.execute(this.f10200i.f16814b);
    }

    /* renamed from: b */
    private final void m6561b() {
        ng0 unused = this.f10200i.f16814b = null;
    }

    /* renamed from: c */
    public final void mo14491c(int i) {
        IOException iOException = this.f10196e;
        if (iOException != null && this.f10197f > i) {
            throw iOException;
        }
    }

    /* renamed from: d */
    public final void mo14492d(long j) {
        zzpc.checkState(this.f10200i.f16814b == null);
        ng0 unused = this.f10200i.f16814b = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            m6560a();
        }
    }

    /* renamed from: e */
    public final void mo14493e(boolean z) {
        this.f10199h = z;
        this.f10196e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f10192a.cancelLoad();
            if (this.f10198g != null) {
                this.f10198g.interrupt();
            }
        }
        if (z) {
            m6561b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f10193b.zza(this.f10192a, elapsedRealtime, elapsedRealtime - this.f10195d, true);
        }
    }

    public final void handleMessage(Message message) {
        int i;
        if (!this.f10199h) {
            int i2 = message.what;
            if (i2 == 0) {
                m6560a();
            } else if (i2 != 4) {
                m6561b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.f10195d;
                if (this.f10192a.zzhx()) {
                    this.f10193b.zza(this.f10192a, elapsedRealtime, j, false);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f10193b.zza(this.f10192a, elapsedRealtime, j, false);
                } else if (i3 == 2) {
                    this.f10193b.zza(this.f10192a, elapsedRealtime, j);
                } else if (i3 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.f10196e = iOException;
                    int zza = this.f10193b.zza(this.f10192a, elapsedRealtime, j, iOException);
                    if (zza == 3) {
                        IOException unused = this.f10200i.f16815c = this.f10196e;
                    } else if (zza != 2) {
                        if (zza == 1) {
                            i = 1;
                        } else {
                            i = this.f10197f + 1;
                        }
                        this.f10197f = i;
                        mo14492d((long) Math.min((i - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        try {
            this.f10198g = Thread.currentThread();
            if (!this.f10192a.zzhx()) {
                String valueOf = String.valueOf(this.f10192a.getClass().getSimpleName());
                zzpq.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                this.f10192a.zzhy();
                zzpq.endSection();
            }
            if (!this.f10199h) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.f10199h) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzpc.checkState(this.f10192a.zzhx());
            if (!this.f10199h) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.f10199h) {
                obtainMessage(3, new zzpa(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.f10199h) {
                obtainMessage(3, new zzpa(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.f10199h) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzpq.endSection();
            throw th;
        }
    }
}
