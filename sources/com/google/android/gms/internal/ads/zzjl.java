package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzjl extends zzji {
    public final zzjh zzany = new zzjh();
    public long zzanz;
    public ByteBuffer zzda;

    public zzjl(int i) {
    }

    /* renamed from: a */
    private final ByteBuffer m8982a(int i) {
        ByteBuffer byteBuffer = this.zzda;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzda;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean isEncrypted() {
        return zzab(1073741824);
    }

    public final void zzac(int i) {
        ByteBuffer byteBuffer = this.zzda;
        if (byteBuffer != null) {
            int capacity = byteBuffer.capacity();
            int position = this.zzda.position() + i;
            if (capacity < position) {
                m8982a(position);
                throw null;
            }
            return;
        }
        m8982a(i);
        throw null;
    }
}
