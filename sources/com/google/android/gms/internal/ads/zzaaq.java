package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzaaq<T> {

    /* renamed from: a */
    private final int f12335a;

    /* renamed from: b */
    private final String f12336b;

    /* renamed from: c */
    private final T f12337c;

    private zzaaq(int i, String str, T t) {
        this.f12335a = i;
        this.f12336b = str;
        this.f12337c = t;
        zzwq.zzqd().zza(this);
    }

    public static zzaaq<Boolean> zza(int i, String str, Boolean bool) {
        return new C1898f(i, str, bool);
    }

    public static zzaaq<Long> zzb(int i, String str, long j) {
        return new C1972h(1, str, Long.valueOf(j));
    }

    public final String getKey() {
        return this.f12336b;
    }

    public final int getSource() {
        return this.f12335a;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* access modifiers changed from: protected */
    public abstract T zzb(JSONObject jSONObject);

    public final T zzrk() {
        return this.f12337c;
    }

    public static zzaaq<Integer> zza(int i, String str, int i2) {
        return new C1861e(1, str, Integer.valueOf(i2));
    }

    public static zzaaq<String> zzb(int i, String str) {
        zzaaq<String> zza = zza(1, str, (String) null);
        zzwq.zzqd().zzc(zza);
        return zza;
    }

    public static zzaaq<Float> zza(int i, String str, float f) {
        return new C1935g(1, str, Float.valueOf(0.0f));
    }

    public static zzaaq<String> zza(int i, String str, String str2) {
        return new C2009i(1, str, str2);
    }

    /* synthetic */ zzaaq(int i, String str, Object obj, C1898f fVar) {
        this(i, str, obj);
    }
}
