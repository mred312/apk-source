package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbbl extends zzbap implements TextureView.SurfaceTextureListener, zzbck {

    /* renamed from: a */
    private final zzbbe f13079a;

    /* renamed from: b */
    private final zzbbh f13080b;

    /* renamed from: c */
    private final boolean f13081c;

    /* renamed from: d */
    private final zzbbf f13082d;

    /* renamed from: e */
    private zzbam f13083e;

    /* renamed from: f */
    private Surface f13084f;

    /* renamed from: g */
    private zzbca f13085g;

    /* renamed from: h */
    private String f13086h;

    /* renamed from: i */
    private String[] f13087i;

    /* renamed from: j */
    private boolean f13088j;

    /* renamed from: k */
    private int f13089k = 1;

    /* renamed from: l */
    private zzbbc f13090l;

    /* renamed from: m */
    private final boolean f13091m;

    /* renamed from: n */
    private boolean f13092n;

    /* renamed from: o */
    private boolean f13093o;

    /* renamed from: p */
    private int f13094p;

    /* renamed from: q */
    private int f13095q;

    /* renamed from: r */
    private int f13096r;

    /* renamed from: s */
    private int f13097s;

    /* renamed from: t */
    private float f13098t;

    public zzbbl(Context context, zzbbh zzbbh, zzbbe zzbbe, boolean z, boolean z2, zzbbf zzbbf) {
        super(context);
        this.f13081c = z2;
        this.f13079a = zzbbe;
        this.f13080b = zzbbh;
        this.f13091m = z;
        this.f13082d = zzbbf;
        setSurfaceTextureListener(this);
        zzbbh.zzb(this);
    }

    /* renamed from: a */
    private final void m7668a(float f, boolean z) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.mo16058f(f, z);
        } else {
            zzaza.zzfa("Trying to set volume before player is initalized.");
        }
    }

    /* renamed from: b */
    private final void m7669b(Surface surface, boolean z) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.mo16056b(surface, z);
        } else {
            zzaza.zzfa("Trying to set surface before player is initalized.");
        }
    }

    /* renamed from: c */
    private final zzbca m7670c() {
        return new zzbca(this.f13079a.getContext(), this.f13082d, this.f13079a);
    }

    /* renamed from: d */
    private final String m7671d() {
        return zzp.zzkq().zzq(this.f13079a.getContext(), this.f13079a.zzaao().zzbrf);
    }

    /* renamed from: e */
    private final boolean m7672e() {
        zzbca zzbca = this.f13085g;
        return (zzbca == null || zzbca.zzabp() == null || this.f13088j) ? false : true;
    }

    /* renamed from: f */
    private final boolean m7673f() {
        return m7672e() && this.f13089k != 1;
    }

    /* renamed from: g */
    private final void m7674g() {
        String str;
        if (this.f13085g == null && (str = this.f13086h) != null && this.f13084f != null) {
            if (str.startsWith("cache:")) {
                zzbcx zzff = this.f13079a.zzff(this.f13086h);
                if (zzff instanceof zzbdi) {
                    zzbca zzabu = ((zzbdi) zzff).zzabu();
                    this.f13085g = zzabu;
                    if (zzabu.zzabp() == null) {
                        zzaza.zzfa("Precached video player has been released.");
                        return;
                    }
                } else if (zzff instanceof zzbdj) {
                    zzbdj zzbdj = (zzbdj) zzff;
                    String d = m7671d();
                    ByteBuffer byteBuffer = zzbdj.getByteBuffer();
                    boolean zzabv = zzbdj.zzabv();
                    String url = zzbdj.getUrl();
                    if (url == null) {
                        zzaza.zzfa("Stream cache URL is null.");
                        return;
                    }
                    zzbca c = m7670c();
                    this.f13085g = c;
                    c.zza(new Uri[]{Uri.parse(url)}, d, byteBuffer, zzabv);
                } else {
                    String valueOf = String.valueOf(this.f13086h);
                    zzaza.zzfa(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.f13085g = m7670c();
                String d2 = m7671d();
                Uri[] uriArr = new Uri[this.f13087i.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.f13087i;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.f13085g.zza(uriArr, d2);
            }
            this.f13085g.zza((zzbck) this);
            m7669b(this.f13084f, false);
            if (this.f13085g.zzabp() != null) {
                int playbackState = this.f13085g.zzabp().getPlaybackState();
                this.f13089k = playbackState;
                if (playbackState == 3) {
                    m7675h();
                }
            }
        }
    }

    /* renamed from: h */
    private final void m7675h() {
        if (!this.f13092n) {
            this.f13092n = true;
            zzm.zzedd.post(new C1943g7(this));
            zzzq();
            this.f13080b.zzfb();
            if (this.f13093o) {
                play();
            }
        }
    }

    /* renamed from: i */
    private final void m7676i() {
        m7679u(this.f13094p, this.f13095q);
    }

    /* renamed from: j */
    private final void m7677j() {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.mo16057d(true);
        }
    }

    /* renamed from: k */
    private final void m7678k() {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.mo16057d(false);
        }
    }

    /* renamed from: u */
    private final void m7679u(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.f13098t != f) {
            this.f13098t = f;
            requestLayout();
        }
    }

    public final int getCurrentPosition() {
        if (m7673f()) {
            return (int) this.f13085g.zzabp().zzem();
        }
        return 0;
    }

    public final int getDuration() {
        if (m7673f()) {
            return (int) this.f13085g.zzabp().getDuration();
        }
        return 0;
    }

    public final long getTotalBytes() {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            return zzbca.getTotalBytes();
        }
        return -1;
    }

    public final int getVideoHeight() {
        return this.f13095q;
    }

    public final int getVideoWidth() {
        return this.f13094p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void mo16028l() {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzzu();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void mo16029m() {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzzr();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void mo16030n() {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void mo16031o() {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzzs();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[LOOP:0: B:30:0x0078->B:35:0x0093, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.f13098t
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzbbc r2 = r10.f13090l
            if (r2 != 0) goto L_0x0028
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0028
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x0028:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbbc r0 = r10.f13090l
            if (r0 == 0) goto L_0x0032
            r0.zzm(r11, r12)
        L_0x0032:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a0
            int r0 = r10.f13096r
            if (r0 <= 0) goto L_0x003e
            if (r0 != r11) goto L_0x0044
        L_0x003e:
            int r0 = r10.f13097s
            if (r0 <= 0) goto L_0x009c
            if (r0 == r12) goto L_0x009c
        L_0x0044:
            boolean r0 = r10.f13081c
            if (r0 == 0) goto L_0x009c
            boolean r0 = r10.m7672e()
            if (r0 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzbca r0 = r10.f13085g
            com.google.android.gms.internal.ads.zzhd r0 = r0.zzabp()
            long r2 = r0.zzem()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009c
            boolean r2 = r0.zzek()
            if (r2 == 0) goto L_0x0065
            goto L_0x009c
        L_0x0065:
            r2 = 1
            r10.m7668a(r1, r2)
            r0.zzf(r2)
            long r1 = r0.zzem()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r3 = r3.currentTimeMillis()
        L_0x0078:
            boolean r5 = r10.m7672e()
            if (r5 == 0) goto L_0x0095
            long r5 = r0.zzem()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0095
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0078
        L_0x0095:
            r1 = 0
            r0.zzf(r1)
            r10.zzzq()
        L_0x009c:
            r10.f13096r = r11
            r10.f13097s = r12
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbl.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f13091m) {
            zzbbc zzbbc = new zzbbc(getContext());
            this.f13090l = zzbbc;
            zzbbc.zza(surfaceTexture, i, i2);
            this.f13090l.start();
            SurfaceTexture zzaae = this.f13090l.zzaae();
            if (zzaae != null) {
                surfaceTexture = zzaae;
            } else {
                this.f13090l.zzaad();
                this.f13090l = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.f13084f = surface;
        if (this.f13085g == null) {
            m7674g();
        } else {
            m7669b(surface, true);
            if (!this.f13082d.zzekr) {
                m7677j();
            }
        }
        if (this.f13094p == 0 || this.f13095q == 0) {
            m7679u(i, i2);
        } else {
            m7676i();
        }
        zzm.zzedd.post(new C2165m7(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbbc zzbbc = this.f13090l;
        if (zzbbc != null) {
            zzbbc.zzaad();
            this.f13090l = null;
        }
        if (this.f13085g != null) {
            m7678k();
            Surface surface = this.f13084f;
            if (surface != null) {
                surface.release();
            }
            this.f13084f = null;
            m7669b((Surface) null, true);
        }
        zzm.zzedd.post(new C2240o7(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbbc zzbbc = this.f13090l;
        if (zzbbc != null) {
            zzbbc.zzm(i, i2);
        }
        zzm.zzedd.post(new C2128l7(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f13080b.zzc(this);
        this.zzeih.zza(surfaceTexture, this.f13083e);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzd.zzee(sb.toString());
        zzm.zzedd.post(new C2202n7(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final /* synthetic */ void mo16038p() {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzzt();
        }
    }

    public final void pause() {
        if (m7673f()) {
            if (this.f13082d.zzekr) {
                m7678k();
            }
            this.f13085g.zzabp().zzf(false);
            this.f13080b.zzaau();
            this.zzeii.zzaau();
            zzm.zzedd.post(new C2054j7(this));
        }
    }

    public final void play() {
        if (m7673f()) {
            if (this.f13082d.zzekr) {
                m7677j();
            }
            this.f13085g.zzabp().zzf(true);
            this.f13080b.zzaat();
            this.zzeii.zzaat();
            this.zzeih.zzzs();
            zzm.zzedd.post(new C2091k7(this));
            return;
        }
        this.f13093o = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final /* synthetic */ void mo16039q() {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzfb();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final /* synthetic */ void mo16040r(boolean z, long j) {
        this.f13079a.zza(z, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public final /* synthetic */ void mo16041s(int i) {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.onWindowVisibilityChanged(i);
        }
    }

    public final void seekTo(int i) {
        if (m7673f()) {
            this.f13085g.zzabp().seekTo((long) i);
        }
    }

    public final void setVideoPath(String str) {
        if (str != null) {
            this.f13086h = str;
            this.f13087i = new String[]{str};
            m7674g();
        }
    }

    public final void stop() {
        if (m7672e()) {
            this.f13085g.zzabp().stop();
            if (this.f13085g != null) {
                m7669b((Surface) null, true);
                zzbca zzbca = this.f13085g;
                if (zzbca != null) {
                    zzbca.zza((zzbck) null);
                    this.f13085g.release();
                    this.f13085g = null;
                }
                this.f13089k = 1;
                this.f13088j = false;
                this.f13092n = false;
                this.f13093o = false;
            }
        }
        this.f13080b.zzaau();
        this.zzeii.zzaau();
        this.f13080b.onStop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final /* synthetic */ void mo16042t(String str) {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzm("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final /* synthetic */ void mo16043v(int i, int i2) {
        zzbam zzbam = this.f13083e;
        if (zzbam != null) {
            zzbam.zzk(i, i2);
        }
    }

    public final void zza(zzbam zzbam) {
        this.f13083e = zzbam;
    }

    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.f13086h = str;
            this.f13087i = (String[]) Arrays.copyOf(strArr, strArr.length);
            m7674g();
        }
    }

    public final void zzdl(int i) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.zzabs().zzdt(i);
        }
    }

    public final void zzdm(int i) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.zzabs().zzdu(i);
        }
    }

    public final void zzdn(int i) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.zzabs().zzdn(i);
        }
    }

    public final void zzdo(int i) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.zzabs().zzdo(i);
        }
    }

    public final void zzdp(int i) {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            zzbca.zzdp(i);
        }
    }

    public final void zzdr(int i) {
        if (this.f13089k != i) {
            this.f13089k = i;
            if (i == 3) {
                m7675h();
            } else if (i == 4) {
                if (this.f13082d.zzekr) {
                    m7678k();
                }
                this.f13080b.zzaau();
                this.zzeii.zzaau();
                zzm.zzedd.post(new C2017i7(this));
            }
        }
    }

    public final void zzn(int i, int i2) {
        this.f13094p = i;
        this.f13095q = i2;
        m7676i();
    }

    public final long zzna() {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            return zzbca.zzna();
        }
        return -1;
    }

    public final String zzzk() {
        String str = this.f13091m ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final long zzzo() {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            return zzbca.zzzo();
        }
        return -1;
    }

    public final int zzzp() {
        zzbca zzbca = this.f13085g;
        if (zzbca != null) {
            return zzbca.zzzp();
        }
        return -1;
    }

    public final void zzzq() {
        m7668a(this.zzeii.getVolume(), false);
    }

    public final void zza(float f, float f2) {
        zzbbc zzbbc = this.f13090l;
        if (zzbbc != null) {
            zzbbc.zzb(f, f2);
        }
    }

    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzaza.zzfa(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.f13088j = true;
        if (this.f13082d.zzekr) {
            m7678k();
        }
        zzm.zzedd.post(new C1980h7(this, sb2));
    }

    public final void zzb(boolean z, long j) {
        if (this.f13079a != null) {
            zzazj.zzegt.execute(new C2314q7(this, z, j));
        }
    }
}
