package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* renamed from: com.google.android.gms.common.i */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
class C1676i {

    /* renamed from: d */
    private static final C1676i f7506d = new C1676i(true, (String) null, (Throwable) null);

    /* renamed from: a */
    final boolean f7507a;
    @Nullable

    /* renamed from: b */
    private final String f7508b;
    @Nullable

    /* renamed from: c */
    private final Throwable f7509c;

    C1676i(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.f7507a = z;
        this.f7508b = str;
        this.f7509c = th;
    }

    /* renamed from: a */
    static C1676i m5270a() {
        return f7506d;
    }

    /* renamed from: b */
    static C1676i m5271b(@NonNull String str) {
        return new C1676i(false, str, (Throwable) null);
    }

    /* renamed from: c */
    static C1676i m5272c(@NonNull String str, @NonNull Throwable th) {
        return new C1676i(false, str, th);
    }

    /* renamed from: d */
    static C1676i m5273d(Callable<String> callable) {
        return new C1686j(callable);
    }

    /* renamed from: e */
    static String m5274e(String str, C1663b bVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2 ? "debug cert rejected" : "not whitelisted", str, Hex.bytesToStringLowercase(AndroidUtilsLight.zza("SHA-1").digest(bVar.mo12860a())), Boolean.valueOf(z), "12451009.false"});
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: f */
    public String mo12877f() {
        return this.f7508b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo12878g() {
        if (!this.f7507a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f7509c != null) {
                Log.d("GoogleCertificatesRslt", mo12877f(), this.f7509c);
            } else {
                Log.d("GoogleCertificatesRslt", mo12877f());
            }
        }
    }
}
