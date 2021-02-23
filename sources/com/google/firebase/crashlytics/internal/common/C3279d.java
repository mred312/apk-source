package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.google.firebase.crashlytics.internal.common.d */
/* compiled from: BytesBackedNativeSessionFile */
class C3279d implements C3331o {
    @Nullable

    /* renamed from: a */
    private final byte[] f19076a;
    @NonNull

    /* renamed from: b */
    private final String f19077b;
    @NonNull

    /* renamed from: c */
    private final String f19078c;

    C3279d(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.f19077b = str;
        this.f19078c = str2;
        this.f19076a = bArr;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x002e */
    @androidx.annotation.Nullable
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m11293d() {
        /*
            r4 = this;
            boolean r0 = r4.m11294e()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x002f }
            r0.<init>()     // Catch:{ IOException -> 0x002f }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x002a }
            r2.<init>(r0)     // Catch:{ all -> 0x002a }
            byte[] r3 = r4.f19076a     // Catch:{ all -> 0x0025 }
            r2.write(r3)     // Catch:{ all -> 0x0025 }
            r2.finish()     // Catch:{ all -> 0x0025 }
            byte[] r3 = r0.toByteArray()     // Catch:{ all -> 0x0025 }
            r2.close()     // Catch:{ all -> 0x002a }
            r0.close()     // Catch:{ IOException -> 0x002f }
            return r3
        L_0x0025:
            r3 = move-exception
            r2.close()     // Catch:{ all -> 0x0029 }
        L_0x0029:
            throw r3     // Catch:{ all -> 0x002a }
        L_0x002a:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x002e }
        L_0x002e:
            throw r2     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.C3279d.m11293d():byte[]");
    }

    /* renamed from: e */
    private boolean m11294e() {
        byte[] bArr = this.f19076a;
        return bArr == null || bArr.length == 0;
    }

    @NonNull
    /* renamed from: a */
    public String mo20950a() {
        return this.f19078c;
    }

    @Nullable
    /* renamed from: b */
    public InputStream mo20951b() {
        if (m11294e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f19076a);
    }

    @Nullable
    /* renamed from: c */
    public CrashlyticsReport.FilesPayload.File mo20952c() {
        byte[] d = m11293d();
        if (d == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.builder().setContents(d).setFilename(this.f19077b).build();
    }
}
