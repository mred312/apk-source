package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zztl {
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable

    /* renamed from: a */
    public zztc f17002a;
    /* access modifiers changed from: private */
    @GuardedBy("lock")

    /* renamed from: b */
    public boolean f17003b;

    /* renamed from: c */
    private final Context f17004c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f17005d = new Object();

    zztl(Context context) {
        this.f17004c = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m9107a() {
        synchronized (this.f17005d) {
            zztc zztc = this.f17002a;
            if (zztc != null) {
                zztc.disconnect();
                this.f17002a = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final Future<zztt> mo18245g(zztf zztf) {
        ai0 ai0 = new ai0(this);
        ci0 ci0 = new ci0(this, zztf, ai0);
        fi0 fi0 = new fi0(this, ai0);
        synchronized (this.f17005d) {
            zztc zztc = new zztc(this.f17004c, zzp.zzle().zzyw(), ci0, fi0);
            this.f17002a = zztc;
            zztc.checkAvailabilityAndConnect();
        }
        return ai0;
    }
}
