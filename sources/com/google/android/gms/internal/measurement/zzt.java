package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzt extends zzz {

    /* renamed from: a */
    private final AtomicReference<Bundle> f17915a = new AtomicReference<>();

    /* renamed from: b */
    private boolean f17916b;

    public final void zza(Bundle bundle) {
        synchronized (this.f17915a) {
            try {
                this.f17915a.set(bundle);
                this.f17916b = true;
                this.f17915a.notify();
            } catch (Throwable th) {
                this.f17915a.notify();
                throw th;
            }
        }
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        synchronized (this.f17915a) {
            if (!this.f17916b) {
                try {
                    this.f17915a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f17915a.get();
        }
        return bundle;
    }

    public final String zza(long j) {
        return (String) zza(zzb(j), String.class);
    }

    public static <T> T zza(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e);
            throw e;
        }
    }
}
