package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class b40<V> implements Runnable {
    @NullableDecl

    /* renamed from: a */
    private z30<V> f7872a;

    b40(z30<V> z30) {
        this.f7872a = z30;
    }

    public final void run() {
        zzdyz t;
        String str;
        z30<V> z30 = this.f7872a;
        if (z30 != null && (t = z30.f12254h) != null) {
            this.f7872a = null;
            if (t.isDone()) {
                z30.setFuture(t);
                return;
            }
            try {
                ScheduledFuture w = z30.f12255i;
                ScheduledFuture unused = z30.f12255i = null;
                str = "Timed out";
                if (w != null) {
                    long abs = Math.abs(w.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        StringBuilder sb = new StringBuilder(str.length() + 66);
                        sb.append(str);
                        sb.append(" (timeout delayed by ");
                        sb.append(abs);
                        sb.append(" ms after scheduled time)");
                        str = sb.toString();
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(t);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                z30.setException(new a40(sb2.toString()));
                t.cancel(true);
            } catch (Throwable th) {
                t.cancel(true);
                throw th;
            }
        }
    }
}
