package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.analytics.FirebaseAnalytics;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public abstract class GmsClientSupervisor {

    /* renamed from: a */
    private static int f7540a = 129;

    /* renamed from: b */
    private static final Object f7541b = new Object();

    /* renamed from: c */
    private static GmsClientSupervisor f7542c;

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    protected static final class zza {

        /* renamed from: f */
        private static final Uri f7543f = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();
        @Nullable

        /* renamed from: a */
        private final String f7544a;
        @Nullable

        /* renamed from: b */
        private final String f7545b;
        @Nullable

        /* renamed from: c */
        private final ComponentName f7546c;

        /* renamed from: d */
        private final int f7547d;

        /* renamed from: e */
        private final boolean f7548e;

        public zza(String str, int i) {
            this(str, "com.google.android.gms", i);
        }

        /* JADX WARNING: type inference failed for: r6v6, types: [android.os.Parcelable] */
        /* JADX WARNING: Multi-variable type inference failed */
        @androidx.annotation.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.content.Intent m5280a(android.content.Context r6) {
            /*
                r5 = this;
                java.lang.String r0 = "ConnectionStatusConfig"
                android.os.Bundle r1 = new android.os.Bundle
                r1.<init>()
                java.lang.String r2 = r5.f7544a
                java.lang.String r3 = "serviceActionBundleKey"
                r1.putString(r3, r2)
                r2 = 0
                android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x001c }
                android.net.Uri r3 = f7543f     // Catch:{ IllegalArgumentException -> 0x001c }
                java.lang.String r4 = "serviceIntentCall"
                android.os.Bundle r6 = r6.call(r3, r4, r2, r1)     // Catch:{ IllegalArgumentException -> 0x001c }
                goto L_0x0040
            L_0x001c:
                r6 = move-exception
                java.lang.String r6 = java.lang.String.valueOf(r6)
                java.lang.String r1 = java.lang.String.valueOf(r6)
                int r1 = r1.length()
                int r1 = r1 + 34
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r1)
                java.lang.String r1 = "Dynamic intent resolution failed: "
                r3.append(r1)
                r3.append(r6)
                java.lang.String r6 = r3.toString()
                android.util.Log.w(r0, r6)
                r6 = r2
            L_0x0040:
                if (r6 != 0) goto L_0x0043
                goto L_0x004c
            L_0x0043:
                java.lang.String r1 = "serviceResponseIntentKey"
                android.os.Parcelable r6 = r6.getParcelable(r1)
                r2 = r6
                android.content.Intent r2 = (android.content.Intent) r2
            L_0x004c:
                if (r2 != 0) goto L_0x006a
                java.lang.String r6 = "Dynamic lookup for intent failed for action: "
                java.lang.String r1 = r5.f7544a
                java.lang.String r1 = java.lang.String.valueOf(r1)
                int r3 = r1.length()
                if (r3 == 0) goto L_0x0061
                java.lang.String r6 = r6.concat(r1)
                goto L_0x0067
            L_0x0061:
                java.lang.String r1 = new java.lang.String
                r1.<init>(r6)
                r6 = r1
            L_0x0067:
                android.util.Log.w(r0, r6)
            L_0x006a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClientSupervisor.zza.m5280a(android.content.Context):android.content.Intent");
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return Objects.equal(this.f7544a, zza.f7544a) && Objects.equal(this.f7545b, zza.f7545b) && Objects.equal(this.f7546c, zza.f7546c) && this.f7547d == zza.f7547d && this.f7548e == zza.f7548e;
        }

        public final int hashCode() {
            return Objects.hashCode(this.f7544a, this.f7545b, this.f7546c, Integer.valueOf(this.f7547d), Boolean.valueOf(this.f7548e));
        }

        public final String toString() {
            String str = this.f7544a;
            if (str != null) {
                return str;
            }
            Preconditions.checkNotNull(this.f7546c);
            return this.f7546c.flattenToString();
        }

        @Nullable
        public final String zza() {
            return this.f7545b;
        }

        @Nullable
        public final ComponentName zzb() {
            return this.f7546c;
        }

        public final int zzc() {
            return this.f7547d;
        }

        private zza(String str, String str2, int i) {
            this(str, str2, i, false);
        }

        public final Intent zza(Context context) {
            if (this.f7544a == null) {
                return new Intent().setComponent(this.f7546c);
            }
            Intent a = this.f7548e ? m5280a(context) : null;
            if (a == null) {
                return new Intent(this.f7544a).setPackage(this.f7545b);
            }
            return a;
        }

        public zza(String str, String str2, int i, boolean z) {
            this.f7544a = Preconditions.checkNotEmpty(str);
            this.f7545b = Preconditions.checkNotEmpty(str2);
            this.f7546c = null;
            this.f7547d = i;
            this.f7548e = z;
        }

        public zza(ComponentName componentName, int i) {
            this.f7544a = null;
            this.f7545b = null;
            this.f7546c = (ComponentName) Preconditions.checkNotNull(componentName);
            this.f7547d = i;
            this.f7548e = false;
        }
    }

    @KeepForSdk
    public static int getDefaultBindFlags() {
        return f7540a;
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (f7541b) {
            if (f7542c == null) {
                f7542c = new C1682c(context.getApplicationContext());
            }
        }
        return f7542c;
    }

    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zzb(new zza(str, str2, i, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zza zza2, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void zzb(zza zza2, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }
}
