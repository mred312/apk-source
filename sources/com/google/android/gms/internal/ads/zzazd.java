package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzazd {
    /* renamed from: a */
    private static DynamiteModule m7626a(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzazf(e);
        }
    }

    public static <T> T zza(Context context, String str, zzazc<IBinder, T> zzazc) {
        try {
            return zzazc.apply(m7626a(context).instantiate(str));
        } catch (Exception e) {
            throw new zzazf(e);
        }
    }

    public static Context zzbv(Context context) {
        return m7626a(context).getModuleContext();
    }
}
