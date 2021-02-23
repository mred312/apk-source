package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.work.WorkRequest;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class xf0 implements zzjy, zzmy, zznk, zzoz<dg0> {

    /* renamed from: A */
    private boolean[] f11900A;

    /* renamed from: B */
    private boolean f11901B;

    /* renamed from: C */
    private long f11902C;

    /* renamed from: D */
    private long f11903D;

    /* renamed from: E */
    private long f11904E;

    /* renamed from: F */
    private int f11905F;

    /* renamed from: G */
    private boolean f11906G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f11907H;

    /* renamed from: a */
    private final Uri f11908a;

    /* renamed from: b */
    private final zzon f11909b;

    /* renamed from: c */
    private final int f11910c;

    /* renamed from: d */
    private final Handler f11911d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzmz f11912e;

    /* renamed from: f */
    private final zznd f11913f;

    /* renamed from: g */
    private final zzol f11914g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final String f11915h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f11916i;

    /* renamed from: j */
    private final zzow f11917j;

    /* renamed from: k */
    private final cg0 f11918k;

    /* renamed from: l */
    private final zzpe f11919l;

    /* renamed from: m */
    private final Runnable f11920m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Runnable f11921n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Handler f11922o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final SparseArray<zzni> f11923p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public zznb f11924q;

    /* renamed from: r */
    private zzkf f11925r;

    /* renamed from: s */
    private boolean f11926s;

    /* renamed from: t */
    private boolean f11927t;

    /* renamed from: u */
    private boolean f11928u;

    /* renamed from: v */
    private boolean f11929v;

    /* renamed from: w */
    private int f11930w;

    /* renamed from: x */
    private zznq f11931x;

    /* renamed from: y */
    private long f11932y;

    /* renamed from: z */
    private boolean[] f11933z;

    public xf0(Uri uri, zzon zzon, zzjw[] zzjwArr, int i, Handler handler, zzmz zzmz, zznd zznd, zzol zzol, String str, int i2) {
        this.f11908a = uri;
        this.f11909b = zzon;
        this.f11910c = i;
        this.f11911d = handler;
        this.f11912e = zzmz;
        this.f11913f = zznd;
        this.f11914g = zzol;
        this.f11916i = (long) i2;
        this.f11917j = new zzow("Loader:ExtractorMediaPeriod");
        this.f11918k = new cg0(zzjwArr, this);
        this.f11919l = new zzpe();
        this.f11920m = new zf0(this);
        this.f11921n = new yf0(this);
        this.f11922o = new Handler();
        this.f11904E = -9223372036854775807L;
        this.f11923p = new SparseArray<>();
        this.f11902C = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        r0 = r9.f11925r;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7241b() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.dg0 r6 = new com.google.android.gms.internal.ads.dg0
            android.net.Uri r2 = r9.f11908a
            com.google.android.gms.internal.ads.zzon r3 = r9.f11909b
            com.google.android.gms.internal.ads.cg0 r4 = r9.f11918k
            com.google.android.gms.internal.ads.zzpe r5 = r9.f11919l
            r0 = r6
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            boolean r0 = r9.f11927t
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0040
            boolean r0 = r9.m7254s()
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            long r3 = r9.f11932y
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            long r7 = r9.f11904E
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0031
            r0 = 1
            r9.f11906G = r0
            r9.f11904E = r1
            return
        L_0x0031:
            com.google.android.gms.internal.ads.zzkf r0 = r9.f11925r
            long r3 = r9.f11904E
            long r3 = r0.zzdz(r3)
            long r7 = r9.f11904E
            r6.mo13828b(r3, r7)
            r9.f11904E = r1
        L_0x0040:
            int r0 = r9.m7252q()
            r9.f11905F = r0
            int r0 = r9.f11910c
            r3 = -1
            if (r0 != r3) goto L_0x0067
            boolean r0 = r9.f11927t
            if (r0 == 0) goto L_0x0066
            long r3 = r9.f11902C
            r7 = -1
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzkf r0 = r9.f11925r
            if (r0 == 0) goto L_0x0064
            long r3 = r0.getDurationUs()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r0 = 6
            goto L_0x0067
        L_0x0066:
            r0 = 3
        L_0x0067:
            com.google.android.gms.internal.ads.zzow r1 = r9.f11917j
            r1.zza(r6, r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xf0.m7241b():void");
    }

    /* renamed from: e */
    private final void m7243e(dg0 dg0) {
        if (this.f11902C == -1) {
            this.f11902C = dg0.f8264i;
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    /* renamed from: p */
    public final void m7251p() {
        /*
            r8 = this;
            boolean r0 = r8.f11907H
            if (r0 != 0) goto L_0x009d
            boolean r0 = r8.f11927t
            if (r0 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzkf r0 = r8.f11925r
            if (r0 == 0) goto L_0x009d
            boolean r0 = r8.f11926s
            if (r0 != 0) goto L_0x0012
            goto L_0x009d
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzni> r0 = r8.f11923p
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.internal.ads.zzni> r3 = r8.f11923p
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzni r3 = (com.google.android.gms.internal.ads.zzni) r3
            com.google.android.gms.internal.ads.zzhp r3 = r3.zzif()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.gms.internal.ads.zzpe r2 = r8.f11919l
            r2.zziu()
            com.google.android.gms.internal.ads.zznr[] r2 = new com.google.android.gms.internal.ads.zznr[r0]
            boolean[] r3 = new boolean[r0]
            r8.f11900A = r3
            boolean[] r3 = new boolean[r0]
            r8.f11933z = r3
            com.google.android.gms.internal.ads.zzkf r3 = r8.f11925r
            long r3 = r3.getDurationUs()
            r8.f11932y = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.gms.internal.ads.zzni> r5 = r8.f11923p
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzni r5 = (com.google.android.gms.internal.ads.zzni) r5
            com.google.android.gms.internal.ads.zzhp r5 = r5.zzif()
            com.google.android.gms.internal.ads.zznr r6 = new com.google.android.gms.internal.ads.zznr
            com.google.android.gms.internal.ads.zzhp[] r7 = new com.google.android.gms.internal.ads.zzhp[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzaha
            boolean r6 = com.google.android.gms.internal.ads.zzpj.zzbd(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.gms.internal.ads.zzpj.zzbc(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.f11900A
            r5[r3] = r4
            boolean r5 = r8.f11901B
            r4 = r4 | r5
            r8.f11901B = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.gms.internal.ads.zznq r0 = new com.google.android.gms.internal.ads.zznq
            r0.<init>(r2)
            r8.f11931x = r0
            r8.f11927t = r4
            com.google.android.gms.internal.ads.zznd r0 = r8.f11913f
            com.google.android.gms.internal.ads.zzno r1 = new com.google.android.gms.internal.ads.zzno
            long r2 = r8.f11932y
            com.google.android.gms.internal.ads.zzkf r4 = r8.f11925r
            boolean r4 = r4.isSeekable()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zznb r0 = r8.f11924q
            r0.zza(r8)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xf0.m7251p():void");
    }

    /* renamed from: q */
    private final int m7252q() {
        int size = this.f11923p.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.f11923p.valueAt(i2).zzid();
        }
        return i;
    }

    /* renamed from: r */
    private final long m7253r() {
        int size = this.f11923p.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.f11923p.valueAt(i).zzhv());
        }
        return j;
    }

    /* renamed from: s */
    private final boolean m7254s() {
        return this.f11904E != -9223372036854775807L;
    }

    /* renamed from: a */
    public final void mo15030a() {
        this.f11917j.zza(new bg0(this, this.f11918k));
        this.f11922o.removeCallbacksAndMessages((Object) null);
        this.f11907H = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo15031c(int i, zzhr zzhr, zzjl zzjl, boolean z) {
        if (this.f11929v || m7254s()) {
            return -3;
        }
        return this.f11923p.valueAt(i).zza(zzhr, zzjl, z, this.f11906G, this.f11903D);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo15032f(int i) {
        if (!this.f11906G) {
            return !m7254s() && this.f11923p.valueAt(i).zzie();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final void mo15033k(int i, long j) {
        zzni valueAt = this.f11923p.valueAt(i);
        if (!this.f11906G || j <= valueAt.zzhv()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzih();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final void mo15034o() {
        this.f11917j.zzbg(Integer.MIN_VALUE);
    }

    public final void zza(zznb zznb, long j) {
        this.f11924q = zznb;
        this.f11919l.open();
        m7241b();
    }

    public final zzkh zzc(int i, int i2) {
        zzni zzni = this.f11923p.get(i);
        if (zzni != null) {
            return zzni;
        }
        zzni zzni2 = new zzni(this.f11914g);
        zzni2.zza(this);
        this.f11923p.put(i, zzni2);
        return zzni2;
    }

    public final void zzee(long j) {
    }

    public final boolean zzef(long j) {
        if (this.f11906G) {
            return false;
        }
        if (this.f11927t && this.f11930w == 0) {
            return false;
        }
        boolean open = this.f11919l.open();
        if (this.f11917j.isLoading()) {
            return open;
        }
        m7241b();
        return true;
    }

    public final long zzeg(long j) {
        if (!this.f11925r.isSeekable()) {
            j = 0;
        }
        this.f11903D = j;
        int size = this.f11923p.size();
        boolean z = !m7254s();
        int i = 0;
        while (z && i < size) {
            if (this.f11933z[i]) {
                z = this.f11923p.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.f11904E = j;
            this.f11906G = false;
            if (this.f11917j.isLoading()) {
                this.f11917j.zzis();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.f11923p.valueAt(i2).zzk(this.f11933z[i2]);
                }
            }
        }
        this.f11929v = false;
        return j;
    }

    public final void zzf(zzhp zzhp) {
        this.f11922o.post(this.f11920m);
    }

    public final void zzgr() {
        this.f11926s = true;
        this.f11922o.post(this.f11920m);
    }

    public final void zzhn() {
        this.f11917j.zzbg(Integer.MIN_VALUE);
    }

    public final zznq zzho() {
        return this.f11931x;
    }

    public final long zzhp() {
        if (this.f11930w == 0) {
            return Long.MIN_VALUE;
        }
        return zzhr();
    }

    public final long zzhq() {
        if (!this.f11929v) {
            return -9223372036854775807L;
        }
        this.f11929v = false;
        return this.f11903D;
    }

    public final long zzhr() {
        long j;
        if (this.f11906G) {
            return Long.MIN_VALUE;
        }
        if (m7254s()) {
            return this.f11904E;
        }
        if (this.f11901B) {
            j = Long.MAX_VALUE;
            int size = this.f11923p.size();
            for (int i = 0; i < size; i++) {
                if (this.f11900A[i]) {
                    j = Math.min(j, this.f11923p.valueAt(i).zzhv());
                }
            }
        } else {
            j = m7253r();
        }
        return j == Long.MIN_VALUE ? this.f11903D : j;
    }

    public final long zza(zzoc[] zzocArr, boolean[] zArr, zznn[] zznnArr, boolean[] zArr2, long j) {
        zzpc.checkState(this.f11927t);
        for (int i = 0; i < zzocArr.length; i++) {
            if (zznnArr[i] != null && (zzocArr[i] == null || !zArr[i])) {
                int a = zznnArr[i].f8360a;
                zzpc.checkState(this.f11933z[a]);
                this.f11930w--;
                this.f11933z[a] = false;
                this.f11923p.valueAt(a).disable();
                zznnArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzocArr.length; i2++) {
            if (zznnArr[i2] == null && zzocArr[i2] != null) {
                zzoc zzoc = zzocArr[i2];
                zzpc.checkState(zzoc.length() == 1);
                zzpc.checkState(zzoc.zzbd(0) == 0);
                int zza = this.f11931x.zza(zzoc.zzil());
                zzpc.checkState(!this.f11933z[zza]);
                this.f11930w++;
                this.f11933z[zza] = true;
                zznnArr[i2] = new eg0(this, zza);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.f11928u) {
            int size = this.f11923p.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.f11933z[i3]) {
                    this.f11923p.valueAt(i3).disable();
                }
            }
        }
        if (this.f11930w == 0) {
            this.f11929v = false;
            if (this.f11917j.isLoading()) {
                this.f11917j.zzis();
            }
        } else if (!this.f11928u ? j != 0 : z) {
            j = zzeg(j);
            for (int i4 = 0; i4 < zznnArr.length; i4++) {
                if (zznnArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.f11928u = true;
        return j;
    }

    public final void zza(zzkf zzkf) {
        this.f11925r = zzkf;
        this.f11922o.post(this.f11920m);
    }

    public final /* synthetic */ int zza(zzpb zzpb, long j, long j2, IOException iOException) {
        zzkf zzkf;
        dg0 dg0 = (dg0) zzpb;
        m7243e(dg0);
        Handler handler = this.f11911d;
        if (!(handler == null || this.f11912e == null)) {
            handler.post(new ag0(this, iOException));
        }
        if (iOException instanceof zznt) {
            return 3;
        }
        boolean z = m7252q() > this.f11905F;
        if (this.f11902C == -1 && ((zzkf = this.f11925r) == null || zzkf.getDurationUs() == -9223372036854775807L)) {
            this.f11903D = 0;
            this.f11929v = this.f11927t;
            int size = this.f11923p.size();
            for (int i = 0; i < size; i++) {
                this.f11923p.valueAt(i).zzk(!this.f11927t || this.f11933z[i]);
            }
            dg0.mo13828b(0, 0);
        }
        this.f11905F = m7252q();
        return z ? 1 : 0;
    }

    public final /* synthetic */ void zza(zzpb zzpb, long j, long j2, boolean z) {
        m7243e((dg0) zzpb);
        if (!z && this.f11930w > 0) {
            int size = this.f11923p.size();
            for (int i = 0; i < size; i++) {
                this.f11923p.valueAt(i).zzk(this.f11933z[i]);
            }
            this.f11924q.zza(this);
        }
    }

    public final /* synthetic */ void zza(zzpb zzpb, long j, long j2) {
        m7243e((dg0) zzpb);
        this.f11906G = true;
        if (this.f11932y == -9223372036854775807L) {
            long r = m7253r();
            this.f11932y = r == Long.MIN_VALUE ? 0 : r + WorkRequest.MIN_BACKOFF_MILLIS;
            this.f11913f.zzb(new zzno(this.f11932y, this.f11925r.isSeekable()), (Object) null);
        }
        this.f11924q.zza(this);
    }
}
