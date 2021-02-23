package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.firebase.crashlytics.internal.common.e */
/* compiled from: CLSUUID */
class C3280e {

    /* renamed from: a */
    private static final AtomicLong f19079a = new AtomicLong(0);

    /* renamed from: b */
    private static String f19080b;

    C3280e(IdManager idManager) {
        byte[] bArr = new byte[10];
        m11302e(bArr);
        m11301d(bArr);
        m11300c(bArr);
        String sha1 = CommonUtils.sha1(idManager.getCrashlyticsInstallId());
        String hexify = CommonUtils.hexify(bArr);
        Locale locale = Locale.US;
        f19080b = String.format(locale, "%s-%s-%s-%s", new Object[]{hexify.substring(0, 12), hexify.substring(12, 16), hexify.subSequence(16, 20), sha1.substring(0, 12)}).toUpperCase(locale);
    }

    /* renamed from: a */
    private static byte[] m11298a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: b */
    private static byte[] m11299b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: c */
    private void m11300c(byte[] bArr) {
        byte[] b = m11299b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    /* renamed from: d */
    private void m11301d(byte[] bArr) {
        byte[] b = m11299b(f19079a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    /* renamed from: e */
    private void m11302e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a = m11298a(time / 1000);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = m11299b(time % 1000);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    public String toString() {
        return f19080b;
    }
}
