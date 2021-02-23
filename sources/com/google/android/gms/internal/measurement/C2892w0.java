package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.measurement.w0 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2892w0 extends ContentObserver {
    C2892w0(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzcp.f17602b.set(true);
    }
}
