package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.net.HttpURLConnection;

/* renamed from: com.google.android.gms.internal.ads.x9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2580x9 extends FilterInputStream {

    /* renamed from: a */
    private final HttpURLConnection f11771a;

    C2580x9(HttpURLConnection httpURLConnection) {
        super(zzbd.m7715a(httpURLConnection));
        this.f11771a = httpURLConnection;
    }

    public final void close() {
        super.close();
        this.f11771a.disconnect();
    }
}
