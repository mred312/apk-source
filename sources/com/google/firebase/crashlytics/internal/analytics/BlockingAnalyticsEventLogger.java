package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* renamed from: a */
    private final CrashlyticsOriginAnalyticsEventLogger f18980a;

    /* renamed from: b */
    private final int f18981b;

    /* renamed from: c */
    private final TimeUnit f18982c;

    /* renamed from: d */
    private final Object f18983d = new Object();

    /* renamed from: e */
    private CountDownLatch f18984e;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit) {
        this.f18980a = crashlyticsOriginAnalyticsEventLogger;
        this.f18981b = i;
        this.f18982c = timeUnit;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.google.firebase.crashlytics.internal.Logger.getLogger().mo20859d("Interrupted while awaiting app exception callback from FA listener.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0043 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logEvent(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.Nullable android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f18983d
            monitor-enter(r0)
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Logging Crashlytics event to Firebase"
            r1.mo20859d(r2)     // Catch:{ all -> 0x0051 }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0051 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0051 }
            r3.f18984e = r1     // Catch:{ all -> 0x0051 }
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r1 = r3.f18980a     // Catch:{ all -> 0x0051 }
            r1.logEvent(r4, r5)     // Catch:{ all -> 0x0051 }
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "Awaiting app exception callback from FA..."
            r4.mo20859d(r5)     // Catch:{ all -> 0x0051 }
            java.util.concurrent.CountDownLatch r4 = r3.f18984e     // Catch:{ InterruptedException -> 0x0043 }
            int r5 = r3.f18981b     // Catch:{ InterruptedException -> 0x0043 }
            long r1 = (long) r5     // Catch:{ InterruptedException -> 0x0043 }
            java.util.concurrent.TimeUnit r5 = r3.f18982c     // Catch:{ InterruptedException -> 0x0043 }
            boolean r4 = r4.await(r1, r5)     // Catch:{ InterruptedException -> 0x0043 }
            if (r4 == 0) goto L_0x0039
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x0043 }
            java.lang.String r5 = "App exception callback received from FA listener."
            r4.mo20859d(r5)     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x004c
        L_0x0039:
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x0043 }
            java.lang.String r5 = "Timeout exceeded while awaiting app exception callback from FA listener."
            r4.mo20859d(r5)     // Catch:{ InterruptedException -> 0x0043 }
            goto L_0x004c
        L_0x0043:
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "Interrupted while awaiting app exception callback from FA listener."
            r4.mo20859d(r5)     // Catch:{ all -> 0x0051 }
        L_0x004c:
            r4 = 0
            r3.f18984e = r4     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger.logEvent(java.lang.String, android.os.Bundle):void");
    }

    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f18984e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
