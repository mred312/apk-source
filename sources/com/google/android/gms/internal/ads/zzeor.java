package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public interface zzeor extends Closeable {
    void close();

    long position();

    int read(ByteBuffer byteBuffer);

    long size();

    void zzfc(long j);

    ByteBuffer zzh(long j, long j2);
}
