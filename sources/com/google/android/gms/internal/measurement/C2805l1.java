package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.measurement.l1 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final /* synthetic */ class C2805l1 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    private final zzdo f17366a;

    C2805l1(zzdo zzdo) {
        this.f17366a = zzdo;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.f17366a.mo19409c(sharedPreferences, str);
    }
}
