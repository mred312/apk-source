package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbep extends zzyr {

    /* renamed from: a */
    private final zzbbe f13198a;

    /* renamed from: b */
    private final Object f13199b = new Object();

    /* renamed from: c */
    private final boolean f13200c;

    /* renamed from: d */
    private final boolean f13201d;
    @GuardedBy("lock")

    /* renamed from: e */
    private int f13202e;
    @GuardedBy("lock")

    /* renamed from: f */
    private zzyt f13203f;
    @GuardedBy("lock")

    /* renamed from: g */
    private boolean f13204g;
    @GuardedBy("lock")

    /* renamed from: h */
    private boolean f13205h = true;
    @GuardedBy("lock")

    /* renamed from: i */
    private float f13206i;
    @GuardedBy("lock")

    /* renamed from: j */
    private float f13207j;
    @GuardedBy("lock")

    /* renamed from: k */
    private float f13208k;
    @GuardedBy("lock")

    /* renamed from: l */
    private boolean f13209l;
    @GuardedBy("lock")

    /* renamed from: m */
    private boolean f13210m;
    @GuardedBy("lock")

    /* renamed from: n */
    private zzafv f13211n;

    public zzbep(zzbbe zzbbe, float f, boolean z, boolean z2) {
        this.f13198a = zzbbe;
        this.f13206i = f;
        this.f13200c = z;
        this.f13201d = z2;
    }

    /* renamed from: a */
    private final void m7737a(int i, int i2, boolean z, boolean z2) {
        zzazj.zzegt.execute(new C2130l9(this, i, i2, z, z2));
    }

    /* renamed from: c */
    private final void m7738c(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzazj.zzegt.execute(new C2093k9(this, hashMap));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16192b(int i, int i2, boolean z, boolean z2) {
        zzyt zzyt;
        zzyt zzyt2;
        zzyt zzyt3;
        synchronized (this.f13199b) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = this.f13204g;
            boolean z6 = !z5 && i2 == 1;
            boolean z7 = z4 && i2 == 1;
            boolean z8 = z4 && i2 == 2;
            boolean z9 = z4 && i2 == 3;
            boolean z10 = z != z2;
            if (z5 || z6) {
                z3 = true;
            }
            this.f13204g = z3;
            if (z6) {
                try {
                    zzyt zzyt4 = this.f13203f;
                    if (zzyt4 != null) {
                        zzyt4.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
            if (z7 && (zzyt3 = this.f13203f) != null) {
                zzyt3.onVideoPlay();
            }
            if (z8 && (zzyt2 = this.f13203f) != null) {
                zzyt2.onVideoPause();
            }
            if (z9) {
                zzyt zzyt5 = this.f13203f;
                if (zzyt5 != null) {
                    zzyt5.onVideoEnd();
                }
                this.f13198a.zzaar();
            }
            if (z10 && (zzyt = this.f13203f) != null) {
                zzyt.onVideoMute(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16193d(Map map) {
        this.f13198a.zza("pubVideoCmd", map);
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.f13199b) {
            f = this.f13208k;
        }
        return f;
    }

    public final float getCurrentTime() {
        float f;
        synchronized (this.f13199b) {
            f = this.f13207j;
        }
        return f;
    }

    public final float getDuration() {
        float f;
        synchronized (this.f13199b) {
            f = this.f13206i;
        }
        return f;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.f13199b) {
            i = this.f13202e;
        }
        return i;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.f13199b) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.f13210m && this.f13201d) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.f13199b) {
            z = this.f13200c && this.f13209l;
        }
        return z;
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.f13199b) {
            z = this.f13205h;
        }
        return z;
    }

    public final void mute(boolean z) {
        m7738c(z ? "mute" : "unmute", (Map<String, String>) null);
    }

    public final void pause() {
        m7738c("pause", (Map<String, String>) null);
    }

    public final void play() {
        m7738c("play", (Map<String, String>) null);
    }

    public final void stop() {
        m7738c("stop", (Map<String, String>) null);
    }

    public final void zza(zzyt zzyt) {
        synchronized (this.f13199b) {
            this.f13203f = zzyt;
        }
    }

    public final void zzadt() {
        boolean z;
        int i;
        synchronized (this.f13199b) {
            z = this.f13205h;
            i = this.f13202e;
            this.f13202e = 3;
        }
        m7737a(i, 3, z, z);
    }

    public final void zzb(zzaak zzaak) {
        boolean z = zzaak.zzadu;
        boolean z2 = zzaak.zzadv;
        boolean z3 = zzaak.zzadw;
        synchronized (this.f13199b) {
            this.f13209l = z2;
            this.f13210m = z3;
        }
        m7738c("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void zze(float f) {
        synchronized (this.f13199b) {
            this.f13207j = f;
        }
    }

    public final zzyt zzqq() {
        zzyt zzyt;
        synchronized (this.f13199b) {
            zzyt = this.f13203f;
        }
        return zzyt;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f13199b
            monitor-enter(r0)
            float r1 = r3.f13206i     // Catch:{ all -> 0x004d }
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            float r1 = r3.f13208k     // Catch:{ all -> 0x004d }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            r3.f13206i = r5     // Catch:{ all -> 0x004d }
            r3.f13207j = r4     // Catch:{ all -> 0x004d }
            boolean r4 = r3.f13205h     // Catch:{ all -> 0x004d }
            r3.f13205h = r7     // Catch:{ all -> 0x004d }
            int r5 = r3.f13202e     // Catch:{ all -> 0x004d }
            r3.f13202e = r6     // Catch:{ all -> 0x004d }
            float r2 = r3.f13208k     // Catch:{ all -> 0x004d }
            r3.f13208k = r8     // Catch:{ all -> 0x004d }
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x004d }
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbbe r8 = r3.f13198a     // Catch:{ all -> 0x004d }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x004d }
            r8.invalidate()     // Catch:{ all -> 0x004d }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzafv r8 = r3.f13211n     // Catch:{ RemoteException -> 0x0043 }
            if (r8 == 0) goto L_0x0049
            r8.zztf()     // Catch:{ RemoteException -> 0x0043 }
            goto L_0x0049
        L_0x0043:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzaza.zze(r0, r8)
        L_0x0049:
            r3.m7737a(r5, r6, r4, r7)
            return
        L_0x004d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbep.zza(float, float, int, boolean, float):void");
    }

    public final void zza(zzafv zzafv) {
        synchronized (this.f13199b) {
            this.f13211n = zzafv;
        }
    }
}
