package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class e10 implements zzdsl {

    /* renamed from: a */
    private final Object f8304a;

    /* renamed from: b */
    private final zzdua f8305b;

    /* renamed from: c */
    private final zzdum f8306c;

    /* renamed from: d */
    private final zzdsi f8307d;

    e10(@NonNull Object obj, @NonNull zzdua zzdua, @NonNull zzdum zzdum, @NonNull zzdsi zzdsi) {
        this.f8304a = obj;
        this.f8305b = zzdua;
        this.f8306c = zzdum;
        this.f8307d = zzdsi;
    }

    @Nullable
    /* renamed from: e */
    private final synchronized byte[] m5995e(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.f8307d.zza(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.f8304a.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.f8304a, new Object[]{null, map2});
    }

    @Nullable
    /* renamed from: f */
    private static String m5996f(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) ((zzekh) zzcf.zzf.zzbl().zzb(zzcm.DG).zzj(zzeiu.zzt(bArr)).zzbhv())).toByteArray(), 11);
    }

    /* renamed from: a */
    public final synchronized void mo13857a() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f8304a.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.f8304a, new Object[0]);
            this.f8307d.zzh(AdError.MEDIATION_ERROR_CODE, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzduk((int) AdError.INTERNAL_ERROR_2003, (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final zzdua mo13858b() {
        return this.f8305b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized boolean mo13859c() {
        try {
        } catch (Exception e) {
            throw new zzduk((int) AdError.INTERNAL_ERROR_CODE, (Throwable) e);
        }
        return ((Boolean) this.f8304a.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.f8304a, new Object[0])).booleanValue();
    }

    /* renamed from: d */
    public final synchronized int mo13860d() {
        try {
        } catch (Exception e) {
            throw new zzduk((int) AdError.INTERNAL_ERROR_2006, (Throwable) e);
        }
        return ((Integer) this.f8304a.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.f8304a, new Object[0])).intValue();
    }

    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzce;
        zzce = this.f8306c.zzce();
        zzce.put("f", "c");
        zzce.put("ctx", context);
        zzce.put("cs", str2);
        zzce.put("aid", (Object) null);
        zzce.put("view", view);
        zzce.put("act", activity);
        return m5996f(m5995e((Map<String, String>) null, zzce));
    }

    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzcd;
        zzcd = this.f8306c.zzcd();
        zzcd.put("f", "v");
        zzcd.put("ctx", context);
        zzcd.put("aid", (Object) null);
        zzcd.put("view", view);
        zzcd.put("act", activity);
        return m5996f(m5995e((Map<String, String>) null, zzcd));
    }

    @Nullable
    public final synchronized String zzt(Context context, String str) {
        Map<String, Object> zzcc;
        zzcc = this.f8306c.zzcc();
        zzcc.put("f", "q");
        zzcc.put("ctx", context);
        zzcc.put("aid", (Object) null);
        return m5996f(m5995e((Map<String, String>) null, zzcc));
    }

    public final synchronized void zza(String str, MotionEvent motionEvent) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.f8304a.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.f8304a, new Object[]{hashMap});
            this.f8307d.zzh(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzduk(2005, (Throwable) e);
        }
    }
}
