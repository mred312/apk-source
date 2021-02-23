package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzeoo implements zzbp {

    /* renamed from: i */
    private static zzeox f16321i = zzeox.zzn(zzeoo.class);

    /* renamed from: a */
    private String f16322a;

    /* renamed from: b */
    private zzbs f16323b;

    /* renamed from: c */
    boolean f16324c;

    /* renamed from: d */
    private boolean f16325d;

    /* renamed from: e */
    private ByteBuffer f16326e;

    /* renamed from: f */
    private long f16327f;

    /* renamed from: g */
    private long f16328g = -1;

    /* renamed from: h */
    private zzeor f16329h;

    protected zzeoo(String str) {
        this.f16322a = str;
        this.f16325d = true;
        this.f16324c = true;
    }

    /* renamed from: a */
    private final synchronized void m8914a() {
        if (!this.f16325d) {
            try {
                zzeox zzeox = f16321i;
                String valueOf = String.valueOf(this.f16322a);
                zzeox.zzii(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.f16326e = this.f16329h.zzh(this.f16327f, this.f16328g);
                this.f16325d = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String getType() {
        return this.f16322a;
    }

    public final void zza(zzeor zzeor, ByteBuffer byteBuffer, long j, zzbo zzbo) {
        this.f16327f = zzeor.position();
        byteBuffer.remaining();
        this.f16328g = j;
        this.f16329h = zzeor;
        zzeor.zzfc(zzeor.position() + j);
        this.f16325d = false;
        this.f16324c = false;
        zzblq();
    }

    public final synchronized void zzblq() {
        m8914a();
        zzeox zzeox = f16321i;
        String valueOf = String.valueOf(this.f16322a);
        zzeox.zzii(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.f16326e;
        if (byteBuffer != null) {
            this.f16324c = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                byteBuffer.slice();
            }
            this.f16326e = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzl(ByteBuffer byteBuffer);

    public final void zza(zzbs zzbs) {
        this.f16323b = zzbs;
    }
}
