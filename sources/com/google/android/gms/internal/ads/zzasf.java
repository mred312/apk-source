package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzasf {
    @GuardedBy("InternalQueryInfoGenerator.class")

    /* renamed from: d */
    private static zzaxq f12670d;

    /* renamed from: a */
    private final Context f12671a;

    /* renamed from: b */
    private final AdFormat f12672b;
    @Nullable

    /* renamed from: c */
    private final zzza f12673c;

    public zzasf(Context context, AdFormat adFormat, @Nullable zzza zzza) {
        this.f12671a = context;
        this.f12672b = adFormat;
        this.f12673c = zzza;
    }

    @Nullable
    public static zzaxq zzp(Context context) {
        zzaxq zzaxq;
        synchronized (zzasf.class) {
            if (f12670d == null) {
                f12670d = zzwq.zzqb().zza(context, new zzanj());
            }
            zzaxq = f12670d;
        }
        return zzaxq;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzvk zzvk;
        zzaxq zzp = zzp(this.f12671a);
        if (zzp == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.f12671a);
        zzza zzza = this.f12673c;
        if (zzza == null) {
            zzvk = new zzvj().zzpn();
        } else {
            zzvk = zzvl.zza(this.f12671a, zzza);
        }
        try {
            zzp.zza(wrap, new zzaxw((String) null, this.f12672b.name(), (zzvn) null, zzvk), (zzaxp) new C1829d4(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
