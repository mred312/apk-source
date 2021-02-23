package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.ads.tr */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2449tr implements Runnable {
    private C2449tr() {
    }

    public final void run() {
        try {
            MessageDigest unused = C2370rq.f10818b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            C2370rq.f10821e.countDown();
        }
    }
}
