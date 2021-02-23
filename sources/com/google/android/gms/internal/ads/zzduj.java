package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.facebook.ads.AdError;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzduj {

    /* renamed from: g */
    private static final HashMap<String, Class<?>> f15983g = new HashMap<>();

    /* renamed from: a */
    private final Context f15984a;

    /* renamed from: b */
    private final zzdum f15985b;

    /* renamed from: c */
    private final zzdsi f15986c;

    /* renamed from: d */
    private final zzdsg f15987d;
    @Nullable

    /* renamed from: e */
    private e10 f15988e;

    /* renamed from: f */
    private final Object f15989f = new Object();

    public zzduj(@NonNull Context context, @NonNull zzdum zzdum, @NonNull zzdsi zzdsi, @NonNull zzdsg zzdsg) {
        this.f15984a = context;
        this.f15985b = zzdum;
        this.f15986c = zzdsi;
        this.f15987d = zzdsg;
    }

    /* renamed from: a */
    private final synchronized Class<?> m8521a(@NonNull zzdua zzdua) {
        if (zzdua.zzaxz() != null) {
            String zzdg = zzdua.zzaxz().zzdg();
            HashMap<String, Class<?>> hashMap = f15983g;
            Class<?> cls = hashMap.get(zzdg);
            if (cls != null) {
                return cls;
            }
            try {
                if (this.f15987d.zzb(zzdua.zzaya())) {
                    File zzayb = zzdua.zzayb();
                    if (!zzayb.exists()) {
                        zzayb.mkdirs();
                    }
                    Class<?> loadClass = new DexClassLoader(zzdua.zzaya().getAbsolutePath(), zzayb.getAbsolutePath(), (String) null, this.f15984a.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    hashMap.put(zzdg, loadClass);
                    return loadClass;
                }
                throw new zzduk(2026, "VM did not pass signature verification");
            } catch (GeneralSecurityException e) {
                throw new zzduk(2026, (Throwable) e);
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
                throw new zzduk((int) AdError.REMOTE_ADS_SERVICE_ERROR, e2);
            }
        } else {
            throw new zzduk(4010, "mc");
        }
    }

    /* renamed from: b */
    private final Object m8522b(@NonNull Class<?> cls, @NonNull zzdua zzdua) {
        try {
            return cls.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.f15984a, "msa-r", zzdua.zzayc(), null, new Bundle(), 2});
        } catch (Exception e) {
            throw new zzduk((int) AdError.INTERNAL_ERROR_2004, (Throwable) e);
        }
    }

    @Nullable
    public final zzdsl zzayd() {
        e10 e10;
        synchronized (this.f15989f) {
            e10 = this.f15988e;
        }
        return e10;
    }

    @Nullable
    public final zzdua zzaye() {
        synchronized (this.f15989f) {
            e10 e10 = this.f15988e;
            if (e10 == null) {
                return null;
            }
            zzdua b = e10.mo13858b();
            return b;
        }
    }

    public final void zzb(@NonNull zzdua zzdua) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            e10 e10 = new e10(m8522b(m8521a(zzdua), zzdua), zzdua, this.f15985b, this.f15986c);
            if (e10.mo13859c()) {
                int d = e10.mo13860d();
                if (d == 0) {
                    synchronized (this.f15989f) {
                        e10 e102 = this.f15988e;
                        if (e102 != null) {
                            try {
                                e102.mo13857a();
                            } catch (zzduk e) {
                                this.f15986c.zza(e.zzayf(), -1, e);
                            }
                        }
                        this.f15988e = e10;
                    }
                    this.f15986c.zzh(PathInterpolatorCompat.MAX_NUM_POINTS, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(d);
                throw new zzduk(4001, sb.toString());
            }
            throw new zzduk(4000, "init failed");
        } catch (zzduk e2) {
            this.f15986c.zza(e2.zzayf(), System.currentTimeMillis() - currentTimeMillis, e2);
        } catch (Exception e3) {
            this.f15986c.zza(4010, System.currentTimeMillis() - currentTimeMillis, e3);
        }
    }
}
