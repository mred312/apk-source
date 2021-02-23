package com.google.android.gms.internal.ads;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class yc0 implements C2475ug {

    /* renamed from: a */
    private final FileChannel f12178a;

    /* renamed from: b */
    private final long f12179b;

    /* renamed from: c */
    private final long f12180c;

    public yc0(FileChannel fileChannel, long j, long j2) {
        this.f12178a = fileChannel;
        this.f12179b = j;
        this.f12180c = j2;
    }

    /* renamed from: a */
    public final void mo14316a(MessageDigest[] messageDigestArr, long j, int i) {
        MappedByteBuffer map = this.f12178a.map(FileChannel.MapMode.READ_ONLY, this.f12179b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }

    public final long size() {
        return this.f12180c;
    }
}
