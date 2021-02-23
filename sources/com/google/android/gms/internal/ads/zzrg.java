package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzrg {

    /* renamed from: a */
    private final Object f16933a = new Object();
    @GuardedBy("activityTrackerLock")

    /* renamed from: b */
    private oh0 f16934b = null;
    @GuardedBy("activityTrackerLock")

    /* renamed from: c */
    private boolean f16935c = false;

    @Nullable
    public final Activity getActivity() {
        synchronized (this.f16933a) {
            oh0 oh0 = this.f16934b;
            if (oh0 == null) {
                return null;
            }
            Activity a = oh0.mo14539a();
            return a;
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.f16933a) {
            oh0 oh0 = this.f16934b;
            if (oh0 == null) {
                return null;
            }
            Context b = oh0.mo14540b();
            return b;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f16933a
            monitor-enter(r0)
            boolean r1 = r4.f16935c     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0032
            r1 = 0
            android.content.Context r2 = r5.getApplicationContext()     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x000f
            r2 = r5
        L_0x000f:
            boolean r3 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0016
            r1 = r2
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x0034 }
        L_0x0016:
            if (r1 != 0) goto L_0x001f
            java.lang.String r5 = "Can not cast Context to Application"
            com.google.android.gms.internal.ads.zzaza.zzfa(r5)     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x001f:
            com.google.android.gms.internal.ads.oh0 r2 = r4.f16934b     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.ads.oh0 r2 = new com.google.android.gms.internal.ads.oh0     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            r4.f16934b = r2     // Catch:{ all -> 0x0034 }
        L_0x002a:
            com.google.android.gms.internal.ads.oh0 r2 = r4.f16934b     // Catch:{ all -> 0x0034 }
            r2.mo14541e(r1, r5)     // Catch:{ all -> 0x0034 }
            r5 = 1
            r4.f16935c = r5     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrg.initialize(android.content.Context):void");
    }

    public final void zza(zzrl zzrl) {
        synchronized (this.f16933a) {
            if (this.f16934b == null) {
                this.f16934b = new oh0();
            }
            this.f16934b.mo14542f(zzrl);
        }
    }

    public final void zzb(zzrl zzrl) {
        synchronized (this.f16933a) {
            oh0 oh0 = this.f16934b;
            if (oh0 != null) {
                oh0.mo14543h(zzrl);
            }
        }
    }
}
