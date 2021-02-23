package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class dg0 implements zzpb {

    /* renamed from: a */
    private final Uri f8256a;

    /* renamed from: b */
    private final zzon f8257b;

    /* renamed from: c */
    private final cg0 f8258c;

    /* renamed from: d */
    private final zzpe f8259d;

    /* renamed from: e */
    private final zzkc f8260e = new zzkc();

    /* renamed from: f */
    private volatile boolean f8261f;

    /* renamed from: g */
    private boolean f8262g = true;

    /* renamed from: h */
    private long f8263h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f8264i = -1;

    /* renamed from: j */
    private final /* synthetic */ xf0 f8265j;

    public dg0(xf0 xf0, Uri uri, zzon zzon, cg0 cg0, zzpe zzpe) {
        this.f8265j = xf0;
        this.f8256a = (Uri) zzpc.checkNotNull(uri);
        this.f8257b = (zzon) zzpc.checkNotNull(zzon);
        this.f8258c = (cg0) zzpc.checkNotNull(cg0);
        this.f8259d = zzpe;
    }

    /* renamed from: b */
    public final void mo13828b(long j, long j2) {
        this.f8260e.position = j;
        this.f8263h = j2;
        this.f8262g = true;
    }

    public final void cancelLoad() {
        this.f8261f = true;
    }

    public final boolean zzhx() {
        return this.f8261f;
    }

    public final void zzhy() {
        int i = 0;
        while (i == 0 && !this.f8261f) {
            zzjx zzjx = null;
            try {
                long j = this.f8260e.position;
                long zza = this.f8257b.zza(new zzoo(this.f8256a, j, -1, this.f8265j.f11915h));
                this.f8264i = zza;
                if (zza != -1) {
                    this.f8264i = zza + j;
                }
                zzjx zzjx2 = new zzjx(this.f8257b, j, this.f8264i);
                try {
                    zzjw b = this.f8258c.mo13780b(zzjx2, this.f8257b.getUri());
                    if (this.f8262g) {
                        b.zzc(j, this.f8263h);
                        this.f8262g = false;
                    }
                    while (i == 0 && !this.f8261f) {
                        this.f8259d.block();
                        i = b.zza(zzjx2, this.f8260e);
                        if (zzjx2.getPosition() > this.f8265j.f11916i + j) {
                            j = zzjx2.getPosition();
                            this.f8259d.zziu();
                            this.f8265j.f11922o.post(this.f8265j.f11921n);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.f8260e.position = zzjx2.getPosition();
                    }
                    zzpt.zza(this.f8257b);
                } catch (Throwable th) {
                    th = th;
                    zzjx = zzjx2;
                    this.f8260e.position = zzjx.getPosition();
                    zzpt.zza(this.f8257b);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (!(i == 1 || zzjx == null)) {
                    this.f8260e.position = zzjx.getPosition();
                }
                zzpt.zza(this.f8257b);
                throw th;
            }
        }
    }
}
