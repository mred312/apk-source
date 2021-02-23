package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbbw implements zzon {
    @Nullable

    /* renamed from: a */
    private final zzpd<zzon> f13099a;

    /* renamed from: b */
    private final Context f13100b;

    /* renamed from: c */
    private final zzon f13101c;

    /* renamed from: d */
    private final zzbby f13102d;

    /* renamed from: e */
    private final String f13103e;

    /* renamed from: f */
    private final int f13104f;

    /* renamed from: g */
    private final boolean f13105g = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue();

    /* renamed from: h */
    private InputStream f13106h;

    /* renamed from: i */
    private boolean f13107i;

    /* renamed from: j */
    private Uri f13108j;

    /* renamed from: k */
    private volatile zztf f13109k;

    /* renamed from: l */
    private boolean f13110l = false;

    /* renamed from: m */
    private boolean f13111m = false;

    /* renamed from: n */
    private boolean f13112n = false;

    /* renamed from: o */
    private boolean f13113o = false;

    /* renamed from: p */
    private long f13114p = 0;

    /* renamed from: q */
    private zzdyz<Long> f13115q = null;

    /* renamed from: r */
    private final AtomicLong f13116r = new AtomicLong(-1);

    public zzbbw(Context context, zzon zzon, String str, int i, zzpd<zzon> zzpd, zzbby zzbby) {
        this.f13100b = context;
        this.f13101c = zzon;
        this.f13099a = zzpd;
        this.f13102d = zzbby;
        this.f13103e = str;
        this.f13104f = i;
    }

    /* renamed from: a */
    private final boolean m7690a() {
        if (!this.f13105g) {
            return false;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcti)).booleanValue() && !this.f13112n) {
            return true;
        }
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzctj)).booleanValue() || this.f13113o) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private final void m7691c(zzoo zzoo) {
        zzpd<zzon> zzpd = this.f13099a;
        if (zzpd != null) {
            zzpd.zza(this, zzoo);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Long mo16048b() {
        return Long.valueOf(zzp.zzkw().zzb(this.f13109k));
    }

    public final void close() {
        zzpd<zzon> zzpd;
        if (this.f13107i) {
            boolean z = false;
            this.f13107i = false;
            this.f13108j = null;
            if (!this.f13105g || this.f13106h != null) {
                z = true;
            }
            InputStream inputStream = this.f13106h;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.f13106h = null;
            } else {
                this.f13101c.close();
            }
            if (z && (zzpd = this.f13099a) != null) {
                zzpd.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final long getContentLength() {
        if (this.f13109k == null) {
            return -1;
        }
        if (this.f13116r.get() != -1) {
            return this.f13116r.get();
        }
        synchronized (this) {
            if (this.f13115q == null) {
                this.f13115q = zzazj.zzegp.zze(new C2388s7(this));
            }
        }
        if (!this.f13115q.isDone()) {
            return -1;
        }
        try {
            this.f13116r.compareAndSet(-1, this.f13115q.get().longValue());
            return this.f13116r.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }

    public final Uri getUri() {
        return this.f13108j;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        zzpd<zzon> zzpd;
        if (this.f13107i) {
            InputStream inputStream = this.f13106h;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.f13101c.read(bArr, i, i2);
            }
            if ((!this.f13105g || this.f13106h != null) && (zzpd = this.f13099a) != null) {
                zzpd.zzc(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0141=Splitter:B:39:0x0141, B:34:0x010f=Splitter:B:34:0x010f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzoo r15) {
        /*
            r14 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Cache connection took "
            boolean r2 = r14.f13107i
            if (r2 != 0) goto L_0x0216
            r2 = 1
            r14.f13107i = r2
            android.net.Uri r3 = r15.uri
            r14.f13108j = r3
            boolean r3 = r14.f13105g
            if (r3 != 0) goto L_0x0016
            r14.m7691c(r15)
        L_0x0016:
            android.net.Uri r3 = r15.uri
            com.google.android.gms.internal.ads.zztf r3 = com.google.android.gms.internal.ads.zztf.zzd(r3)
            r14.f13109k = r3
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzctf
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            r6 = 0
            if (r3 == 0) goto L_0x0193
            com.google.android.gms.internal.ads.zztf r3 = r14.f13109k
            if (r3 == 0) goto L_0x01ee
            com.google.android.gms.internal.ads.zztf r3 = r14.f13109k
            long r7 = r15.position
            r3.zzbve = r7
            com.google.android.gms.internal.ads.zztf r3 = r14.f13109k
            java.lang.String r7 = r14.f13103e
            java.lang.String r7 = com.google.android.gms.internal.ads.zzdwc.zzhg(r7)
            r3.zzbvf = r7
            com.google.android.gms.internal.ads.zztf r3 = r14.f13109k
            int r7 = r14.f13104f
            r3.zzbvg = r7
            com.google.android.gms.internal.ads.zztf r3 = r14.f13109k
            boolean r3 = r3.zzbvd
            if (r3 == 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzabf.zzcth
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r7.zzd(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            goto L_0x006c
        L_0x0060:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzabf.zzctg
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r7.zzd(r3)
            java.lang.Long r3 = (java.lang.Long) r3
        L_0x006c:
            long r7 = r3.longValue()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r9 = r3.elapsedRealtime()
            com.google.android.gms.ads.internal.zzp.zzlk()
            android.content.Context r3 = r14.f13100b
            com.google.android.gms.internal.ads.zztf r11 = r14.f13109k
            java.util.concurrent.Future r3 = com.google.android.gms.internal.ads.zztq.zza(r3, r11)
            r11 = 44
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x0140, InterruptedException -> 0x010e, all -> 0x010b }
            java.lang.Object r7 = r3.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x0140, InterruptedException -> 0x010e, all -> 0x010b }
            com.google.android.gms.internal.ads.zztt r7 = (com.google.android.gms.internal.ads.zztt) r7     // Catch:{ ExecutionException | TimeoutException -> 0x0140, InterruptedException -> 0x010e, all -> 0x010b }
            boolean r8 = r7.zzmy()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.f13110l = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zznb()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.f13112n = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r7.zzmz()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.f13113o = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            long r12 = r7.zzna()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.f13114p = r12     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r8 = r14.m7690a()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r8 != 0) goto L_0x00de
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            r14.f13106h = r7     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            boolean r7 = r14.f13105g     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
            if (r7 == 0) goto L_0x00b8
            r14.m7691c(r15)     // Catch:{ ExecutionException | TimeoutException -> 0x0109, InterruptedException -> 0x0107, all -> 0x0105 }
        L_0x00b8:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r6 = r15.elapsedRealtime()
            long r6 = r6 - r9
            com.google.android.gms.internal.ads.zzbby r15 = r14.f13102d
            r15.zzb(r2, r6)
            r14.f13111m = r2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            r15.append(r1)
            r15.append(r6)
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r15)
            return r4
        L_0x00de:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzbby r5 = r14.f13102d
            r5.zzb(r2, r3)
            r14.f13111m = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            goto L_0x01ee
        L_0x0105:
            r15 = move-exception
            goto L_0x016d
        L_0x0107:
            r4 = 1
            goto L_0x010f
        L_0x0109:
            r4 = 1
            goto L_0x0141
        L_0x010b:
            r15 = move-exception
            r2 = 0
            goto L_0x016d
        L_0x010e:
            r4 = 0
        L_0x010f:
            r3.cancel(r2)     // Catch:{ all -> 0x016b }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x016b }
            r2.interrupt()     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzbby r5 = r14.f13102d
            r5.zzb(r4, r2)
            r14.f13111m = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            goto L_0x01ee
        L_0x0140:
            r4 = 0
        L_0x0141:
            r3.cancel(r2)     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzbby r5 = r14.f13102d
            r5.zzb(r4, r2)
            r14.f13111m = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            goto L_0x01ee
        L_0x016b:
            r15 = move-exception
            r2 = r4
        L_0x016d:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzbby r5 = r14.f13102d
            r5.zzb(r2, r3)
            r14.f13111m = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            throw r15
        L_0x0193:
            r0 = 0
            com.google.android.gms.internal.ads.zztf r1 = r14.f13109k
            if (r1 == 0) goto L_0x01b8
            com.google.android.gms.internal.ads.zztf r0 = r14.f13109k
            long r7 = r15.position
            r0.zzbve = r7
            com.google.android.gms.internal.ads.zztf r0 = r14.f13109k
            java.lang.String r1 = r14.f13103e
            java.lang.String r1 = com.google.android.gms.internal.ads.zzdwc.zzhg(r1)
            r0.zzbvf = r1
            com.google.android.gms.internal.ads.zztf r0 = r14.f13109k
            int r1 = r14.f13104f
            r0.zzbvg = r1
            com.google.android.gms.internal.ads.zzsx r0 = com.google.android.gms.ads.internal.zzp.zzkw()
            com.google.android.gms.internal.ads.zztf r1 = r14.f13109k
            com.google.android.gms.internal.ads.zzta r0 = r0.zza(r1)
        L_0x01b8:
            if (r0 == 0) goto L_0x01ee
            boolean r1 = r0.zzmv()
            if (r1 == 0) goto L_0x01ee
            boolean r1 = r0.zzmy()
            r14.f13110l = r1
            boolean r1 = r0.zznb()
            r14.f13112n = r1
            boolean r1 = r0.zzmz()
            r14.f13113o = r1
            long r7 = r0.zzna()
            r14.f13114p = r7
            r14.f13111m = r2
            boolean r1 = r14.m7690a()
            if (r1 != 0) goto L_0x01ee
            java.io.InputStream r0 = r0.zzmw()
            r14.f13106h = r0
            boolean r0 = r14.f13105g
            if (r0 == 0) goto L_0x01ed
            r14.m7691c(r15)
        L_0x01ed:
            return r4
        L_0x01ee:
            r14.f13111m = r6
            com.google.android.gms.internal.ads.zztf r0 = r14.f13109k
            if (r0 == 0) goto L_0x020f
            com.google.android.gms.internal.ads.zzoo r0 = new com.google.android.gms.internal.ads.zzoo
            com.google.android.gms.internal.ads.zztf r1 = r14.f13109k
            java.lang.String r1 = r1.url
            android.net.Uri r2 = android.net.Uri.parse(r1)
            byte[] r3 = r15.zzbia
            long r4 = r15.zzbib
            long r6 = r15.position
            long r8 = r15.zzcm
            java.lang.String r10 = r15.zzck
            int r11 = r15.flags
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r15 = r0
        L_0x020f:
            com.google.android.gms.internal.ads.zzon r0 = r14.f13101c
            long r0 = r0.zza(r15)
            return r0
        L_0x0216:
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbw.zza(com.google.android.gms.internal.ads.zzoo):long");
    }

    public final boolean zzabl() {
        return this.f13111m;
    }

    public final boolean zzabm() {
        return this.f13113o;
    }

    public final boolean zzmy() {
        return this.f13110l;
    }

    public final long zzna() {
        return this.f13114p;
    }

    public final boolean zznb() {
        return this.f13112n;
    }
}
