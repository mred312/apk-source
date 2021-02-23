package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbrg {

    /* renamed from: a */
    private final Context f13722a;

    /* renamed from: b */
    private final zzdnn f13723b;

    /* renamed from: c */
    private Bundle f13724c;
    @Nullable

    /* renamed from: d */
    private final String f13725d;
    @Nullable

    /* renamed from: e */
    private final zzdni f13726e;

    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Context f13727a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public zzdnn f13728b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Bundle f13729c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d */
        public String f13730d;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: e */
        public zzdni f13731e;

        public final zza zza(zzdnn zzdnn) {
            this.f13728b = zzdnn;
            return this;
        }

        public final zzbrg zzakx() {
            return new zzbrg(this);
        }

        public final zza zzcg(Context context) {
            this.f13727a = context;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.f13729c = bundle;
            return this;
        }

        public final zza zzfu(String str) {
            this.f13730d = str;
            return this;
        }

        public final zza zza(zzdni zzdni) {
            this.f13731e = zzdni;
            return this;
        }
    }

    private zzbrg(zza zza2) {
        this.f13722a = zza2.f13727a;
        this.f13723b = zza2.f13728b;
        this.f13724c = zza2.f13729c;
        this.f13725d = zza2.f13730d;
        this.f13726e = zza2.f13731e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final zza mo16418a() {
        return new zza().zzcg(this.f13722a).zza(this.f13723b).zzfu(this.f13725d).zze(this.f13724c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final zzdnn mo16419b() {
        return this.f13723b;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public final zzdni mo16420c() {
        return this.f13726e;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: d */
    public final Bundle mo16421d() {
        return this.f13724c;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: e */
    public final String mo16422e() {
        return this.f13725d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final Context mo16423f(Context context) {
        if (this.f13725d != null) {
            return context;
        }
        return this.f13722a;
    }
}
