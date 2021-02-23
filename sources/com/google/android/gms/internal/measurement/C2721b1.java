package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.measurement.b1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2721b1 implements C2713a1 {
    @GuardedBy("GservicesLoader.class")

    /* renamed from: c */
    private static C2721b1 f17228c;
    @Nullable

    /* renamed from: a */
    private final Context f17229a;
    @Nullable

    /* renamed from: b */
    private final ContentObserver f17230b;

    private C2721b1(Context context) {
        this.f17229a = context;
        C2729c1 c1Var = new C2729c1(this, (Handler) null);
        this.f17230b = c1Var;
        context.getContentResolver().registerContentObserver(zzcp.zza, true, c1Var);
    }

    /* renamed from: a */
    static C2721b1 m9316a(Context context) {
        C2721b1 b1Var;
        synchronized (C2721b1.class) {
            if (f17228c == null) {
                f17228c = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C2721b1(context) : new C2721b1();
            }
            b1Var = f17228c;
        }
        return b1Var;
    }

    /* renamed from: b */
    static synchronized void m9317b() {
        Context context;
        synchronized (C2721b1.class) {
            C2721b1 b1Var = f17228c;
            if (!(b1Var == null || (context = b1Var.f17229a) == null || b1Var.f17230b == null)) {
                context.getContentResolver().unregisterContentObserver(f17228c.f17230b);
            }
            f17228c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final String zza(String str) {
        if (this.f17229a == null) {
            return null;
        }
        try {
            return (String) zzcw.zza(new C2737d1(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ String mo18553c(String str) {
        return zzcp.zza(this.f17229a.getContentResolver(), str, (String) null);
    }

    private C2721b1() {
        this.f17229a = null;
        this.f17230b = null;
    }
}
