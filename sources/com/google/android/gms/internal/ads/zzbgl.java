package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbgl {

    /* renamed from: a */
    private final zzazh f13248a;

    /* renamed from: b */
    private final Context f13249b;

    /* renamed from: c */
    private final WeakReference<Context> f13250c;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public zzazh f13251a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Context f13252b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public WeakReference<Context> f13253c;

        public final zza zza(zzazh zzazh) {
            this.f13251a = zzazh;
            return this;
        }

        public final zza zzby(Context context) {
            this.f13253c = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f13252b = context;
            return this;
        }
    }

    private zzbgl(zza zza2) {
        this.f13248a = zza2.f13251a;
        this.f13249b = zza2.f13252b;
        this.f13250c = zza2.f13253c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo16253a() {
        return this.f13249b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final WeakReference<Context> mo16254b() {
        return this.f13250c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final zzazh mo16255c() {
        return this.f13248a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final String mo16256d() {
        return zzp.zzkq().zzq(this.f13249b, this.f13248a.zzbrf);
    }

    public final zzef zzaej() {
        return new zzef(new zzf(this.f13249b, this.f13248a));
    }
}
