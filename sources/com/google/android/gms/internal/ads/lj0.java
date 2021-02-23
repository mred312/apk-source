package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
abstract class lj0<T> {
    @Nullable

    /* renamed from: a */
    private static final zzxp f9873a = m6462e();

    lj0() {
    }

    /* renamed from: e */
    private static zzxp m6462e() {
        try {
            Object newInstance = zzvx.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzaza.zzfa("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzxp) {
                return (zzxp) queryLocalInterface;
            }
            return new zzxr(iBinder);
        } catch (Exception unused) {
            zzaza.zzfa("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    /* renamed from: f */
    private final T m6463f() {
        zzxp zzxp = f9873a;
        if (zzxp == null) {
            zzaza.zzfa("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return mo13605a(zzxp);
        } catch (RemoteException e) {
            zzaza.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    /* renamed from: g */
    private final T m6464g() {
        try {
            return mo13607d();
        } catch (RemoteException e) {
            zzaza.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: a */
    public abstract T mo13605a(zzxp zzxp);

    /* renamed from: b */
    public final T mo14405b(Context context, boolean z) {
        T t;
        boolean z2 = false;
        boolean z3 = z;
        if (!z3) {
            zzwq.zzqa();
            if (!zzayr.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzaza.zzeb("Google Play Services is not available.");
                z3 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = true;
        }
        zzabf.initialize(context);
        if (zzacx.zzdca.get().booleanValue()) {
            z3 = false;
        }
        if (z3) {
            t = m6463f();
            if (t == null) {
                t = m6464g();
            }
        } else {
            T g = m6464g();
            int i = g == null ? 1 : 0;
            if (i != 0) {
                if (zzwq.zzqh().nextInt(zzadg.zzddd.get().intValue()) == 0) {
                    z2 = true;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzwq.zzqa().zza(context, zzwq.zzqg().zzbrf, "gmob-apps", bundle, true);
                }
            }
            t = g == null ? m6463f() : g;
        }
        return t == null ? mo13606c() : t;
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: c */
    public abstract T mo13606c();

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: d */
    public abstract T mo13607d();
}
