package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzae;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzgz {

    /* renamed from: a */
    final Context f18651a;

    /* renamed from: b */
    String f18652b;

    /* renamed from: c */
    String f18653c;

    /* renamed from: d */
    String f18654d;

    /* renamed from: e */
    Boolean f18655e;

    /* renamed from: f */
    long f18656f;

    /* renamed from: g */
    zzae f18657g;

    /* renamed from: h */
    boolean f18658h = true;

    /* renamed from: i */
    Long f18659i;

    @VisibleForTesting
    public zzgz(Context context, zzae zzae, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f18651a = applicationContext;
        this.f18659i = l;
        if (zzae != null) {
            this.f18657g = zzae;
            this.f18652b = zzae.zzf;
            this.f18653c = zzae.zze;
            this.f18654d = zzae.zzd;
            this.f18658h = zzae.zzc;
            this.f18656f = zzae.zzb;
            Bundle bundle = zzae.zzg;
            if (bundle != null) {
                this.f18655e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
