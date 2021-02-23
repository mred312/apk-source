package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbca implements zzhg, zzih, zzmz, zzpd<zzon>, zzqg {
    @VisibleForTesting

    /* renamed from: t */
    private static int f13117t;
    @VisibleForTesting

    /* renamed from: u */
    private static int f13118u;

    /* renamed from: a */
    private final Context f13119a;

    /* renamed from: b */
    private final zzbcb f13120b;

    /* renamed from: c */
    private final zzhy f13121c;

    /* renamed from: d */
    private final zzhy f13122d;

    /* renamed from: e */
    private final zzob f13123e;

    /* renamed from: f */
    private final zzbbf f13124f;

    /* renamed from: g */
    private zzhd f13125g;

    /* renamed from: h */
    private ByteBuffer f13126h;

    /* renamed from: i */
    private boolean f13127i;

    /* renamed from: j */
    private final WeakReference<zzbbe> f13128j;

    /* renamed from: k */
    private zzbck f13129k;

    /* renamed from: l */
    private int f13130l;

    /* renamed from: m */
    private int f13131m;

    /* renamed from: n */
    private long f13132n;

    /* renamed from: o */
    private final String f13133o;

    /* renamed from: p */
    private final int f13134p;

    /* renamed from: q */
    private final ArrayList<zzot> f13135q;

    /* renamed from: r */
    private volatile zzbbw f13136r;

    /* renamed from: s */
    private Set<WeakReference<C2277p7>> f13137s = new HashSet();

    public zzbca(Context context, zzbbf zzbbf, zzbbe zzbbe) {
        this.f13119a = context;
        this.f13124f = zzbbf;
        this.f13128j = new WeakReference<>(zzbbe);
        zzbcb zzbcb = new zzbcb();
        this.f13120b = zzbcb;
        zzlx zzlx = zzlx.zzbcu;
        zzduw zzduw = zzm.zzedd;
        zzqa zzqa = new zzqa(context, zzlx, 0, zzduw, this, -1);
        this.f13121c = zzqa;
        zzjc zzjc = new zzjc(zzlx, zzduw, this);
        this.f13122d = zzjc;
        zznw zznw = new zznw();
        this.f13123e = zznw;
        if (zzd.zzxn()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzd.zzee(sb.toString());
        }
        f13117t++;
        int i = 0;
        zzhd zza = zzhh.zza(new zzhy[]{zzjc, zzqa}, zznw, zzbcb);
        this.f13125g = zza;
        zza.zza((zzhg) this);
        this.f13130l = 0;
        this.f13132n = 0;
        this.f13131m = 0;
        this.f13135q = new ArrayList<>();
        this.f13136r = null;
        this.f13133o = (zzbbe == null || zzbbe.zzaal() == null) ? "" : zzbbe.zzaal();
        this.f13134p = zzbbe != null ? zzbbe.zzaam() : i;
    }

    /* renamed from: c */
    private final boolean m7696c() {
        return this.f13136r != null && this.f13136r.zzabl();
    }

    @VisibleForTesting
    /* renamed from: e */
    private final zzna m7697e(Uri uri, String str) {
        C2429t7 t7Var;
        zzkb zzkb;
        C2616y7 y7Var;
        if (!this.f13127i || this.f13126h.limit() <= 0) {
            zzbbf zzbbf = this.f13124f;
            if (zzbbf.zzekz > 0) {
                y7Var = new C2540w7(this, str);
            } else {
                y7Var = new C2503v7(this, str);
            }
            if (zzbbf.zzela) {
                y7Var = new C2616y7(this, y7Var);
            }
            if (this.f13126h.limit() > 0) {
                byte[] bArr = new byte[this.f13126h.limit()];
                this.f13126h.get(bArr);
                y7Var = new C2578x7(y7Var, bArr);
            }
            t7Var = y7Var;
        } else {
            byte[] bArr2 = new byte[this.f13126h.limit()];
            this.f13126h.get(bArr2);
            t7Var = new C2429t7(bArr2);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcme)).booleanValue()) {
            zzkb = C1722a8.f7794a;
        } else {
            zzkb = C2653z7.f12259a;
        }
        zzkb zzkb2 = zzkb;
        zzbbf zzbbf2 = this.f13124f;
        return new zzmw(uri, t7Var, zzkb2, zzbbf2.zzelb, zzm.zzedd, this, (String) null, zzbbf2.zzekx);
    }

    /* renamed from: j */
    private static long m7698j(Map<String, List<String>> map) {
        if (map == null) {
            return 0;
        }
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                try {
                    if (!(next.getKey() == null || !zzdve.zza("content-length", (CharSequence) next.getKey()) || next.getValue() == null || ((List) next.getValue()).get(0) == null)) {
                        return Long.parseLong((String) ((List) next.getValue()).get(0));
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
        }
        return 0;
    }

    public static int zzabq() {
        return f13117t;
    }

    public static int zzabr() {
        return f13118u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzon mo16055a(zzom zzom) {
        return new zzbbw(this.f13119a, zzom.zzip(), this.f13133o, this.f13134p, this, new C1759b8(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo16056b(Surface surface, boolean z) {
        if (this.f13125g != null) {
            zzhi zzhi = new zzhi(this.f13121c, 1, surface);
            if (z) {
                this.f13125g.zzb(zzhi);
                return;
            }
            this.f13125g.zza(zzhi);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo16057d(boolean z) {
        if (this.f13125g != null) {
            for (int i = 0; i < this.f13125g.zzel(); i++) {
                this.f13123e.zzf(i, !z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo16058f(float f, boolean z) {
        if (this.f13125g != null) {
            zzhi zzhi = new zzhi(this.f13122d, 2, Float.valueOf(f));
            if (z) {
                this.f13125g.zzb(zzhi);
                return;
            }
            this.f13125g.zza(zzhi);
        }
    }

    public final void finalize() {
        f13117t--;
        if (zzd.zzxn()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzd.zzee(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final /* synthetic */ void mo16060g(boolean z, long j) {
        zzbck zzbck = this.f13129k;
        if (zzbck != null) {
            zzbck.zzb(z, j);
        }
    }

    public final long getBytesTransferred() {
        return (long) this.f13130l;
    }

    public final long getTotalBytes() {
        if (m7696c()) {
            return this.f13136r.getContentLength();
        }
        while (!this.f13135q.isEmpty()) {
            this.f13132n += m7698j(this.f13135q.remove(0).getResponseHeaders());
        }
        return this.f13132n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ zzon mo16063h(String str) {
        zzbbf zzbbf = this.f13124f;
        return new zzoq(str, (zzpp<String>) null, zzbbf.zzela ? null : this, zzbbf.zzeku, zzbbf.zzekw, true, (zzox) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final /* synthetic */ zzon mo16064i(String str) {
        zzbbf zzbbf = this.f13124f;
        C2277p7 p7Var = new C2277p7(str, zzbbf.zzela ? null : this, zzbbf.zzeku, zzbbf.zzekw, zzbbf.zzekz);
        this.f13137s.add(new WeakReference(p7Var));
        return p7Var;
    }

    public final void release() {
        zzhd zzhd = this.f13125g;
        if (zzhd != null) {
            zzhd.zzb((zzhg) this);
            this.f13125g.release();
            this.f13125g = null;
            f13118u--;
        }
    }

    public final void zza(int i, long j, long j2) {
    }

    public final void zza(Surface surface) {
    }

    public final void zza(zzbck zzbck) {
        this.f13129k = zzbck;
    }

    public final void zza(zzhv zzhv) {
    }

    public final void zza(zzhz zzhz, Object obj) {
    }

    public final void zza(zzjm zzjm) {
    }

    public final void zza(zznq zznq, zzoe zzoe) {
    }

    public final void zza(String str, long j, long j2) {
    }

    public final zzhd zzabp() {
        return this.f13125g;
    }

    public final zzbcb zzabs() {
        return this.f13120b;
    }

    public final void zzb(zzjm zzjm) {
    }

    public final void zzb(IOException iOException) {
        zzbck zzbck = this.f13129k;
        if (zzbck != null) {
            zzbck.zza("onLoadError", iOException);
        }
    }

    public final /* synthetic */ void zzc(Object obj, int i) {
        this.f13130l += i;
    }

    public final void zzd(String str, long j, long j2) {
    }

    public final void zzdp(int i) {
        for (WeakReference<C2277p7> weakReference : this.f13137s) {
            C2277p7 p7Var = (C2277p7) weakReference.get();
            if (p7Var != null) {
                p7Var.mo14570a(i);
            }
        }
    }

    public final void zze(zzjm zzjm) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final void zzen() {
    }

    public final void zzf(int i, long j) {
        this.f13131m += i;
    }

    public final void zzf(zzjm zzjm) {
    }

    public final void zzg(boolean z) {
    }

    public final void zzk(zzhp zzhp) {
        zzbbe zzbbe = (zzbbe) this.f13128j.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && zzbbe != null && zzhp != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzhp.zzahe));
            hashMap.put("bitRate", String.valueOf(zzhp.zzagw));
            int i = zzhp.width;
            int i2 = zzhp.height;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            hashMap.put("resolution", sb.toString());
            hashMap.put("videoMime", zzhp.zzagz);
            hashMap.put("videoCodec", zzhp.zzagx);
            zzbbe.zza("onMetadataEvent", hashMap);
        }
    }

    public final long zzna() {
        if (m7696c() && this.f13136r.zznb()) {
            return Math.min((long) this.f13130l, this.f13136r.zzna());
        }
        return 0;
    }

    public final void zzw(int i) {
    }

    public final long zzzo() {
        if (!m7696c()) {
            return (long) this.f13130l;
        }
        return 0;
    }

    public final int zzzp() {
        return this.f13131m;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzna zzna;
        if (this.f13125g != null) {
            this.f13126h = byteBuffer;
            this.f13127i = z;
            if (uriArr.length == 1) {
                zzna = m7697e(uriArr[0], str);
            } else {
                zzna[] zznaArr = new zzna[uriArr.length];
                for (int i = 0; i < uriArr.length; i++) {
                    zznaArr[i] = m7697e(uriArr[i], str);
                }
                zzna = new zznf(zznaArr);
            }
            this.f13125g.zza(zzna);
            f13118u++;
        }
    }

    public final void zzb(zzhp zzhp) {
        zzbbe zzbbe = (zzbbe) this.f13128j.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && zzbbe != null && zzhp != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzhp.zzagz);
            hashMap.put("audioCodec", zzhp.zzagx);
            zzbbe.zza("onMetadataEvent", hashMap);
        }
    }

    public final void zza(int i, int i2, int i3, float f) {
        zzbck zzbck = this.f13129k;
        if (zzbck != null) {
            zzbck.zzn(i, i2);
        }
    }

    public final void zza(boolean z, int i) {
        zzbck zzbck = this.f13129k;
        if (zzbck != null) {
            zzbck.zzdr(i);
        }
    }

    public final void zza(zzhe zzhe) {
        zzbck zzbck = this.f13129k;
        if (zzbck != null) {
            zzbck.zza("onPlayerError", zzhe);
        }
    }

    public final /* synthetic */ void zza(Object obj, zzoo zzoo) {
        zzon zzon = (zzon) obj;
        if (zzon instanceof zzot) {
            this.f13135q.add((zzot) zzon);
        } else if (zzon instanceof zzbbw) {
            this.f13136r = (zzbbw) zzon;
            zzbbe zzbbe = (zzbbe) this.f13128j.get();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && zzbbe != null && this.f13136r.zzmy()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.f13136r.zznb()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.f13136r.zzabm()));
                zzm.zzedd.post(new C2466u7(zzbbe, hashMap));
            }
        }
    }
}
