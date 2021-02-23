package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.d */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1824d implements Callable<Boolean> {
    C1824d() {
    }

    public final /* synthetic */ Object call() {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
