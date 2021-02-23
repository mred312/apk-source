package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzbm implements zzbo {

    /* renamed from: b */
    private static Logger f13481b = Logger.getLogger(zzbm.class.getName());

    /* renamed from: a */
    private ThreadLocal<ByteBuffer> f13482a = new C2620yb(this);

    public final zzbp zza(zzeor zzeor, zzbs zzbs) {
        int read;
        long j;
        zzeor zzeor2 = zzeor;
        zzbs zzbs2 = zzbs;
        long position = zzeor.position();
        this.f13482a.get().rewind().limit(8);
        do {
            read = zzeor2.read(this.f13482a.get());
            if (read == 8) {
                this.f13482a.get().rewind();
                long zzf = zzbq.zzf(this.f13482a.get());
                byte[] bArr = null;
                if (zzf >= 8 || zzf <= 1) {
                    String zzk = zzbq.zzk(this.f13482a.get());
                    if (zzf == 1) {
                        this.f13482a.get().limit(16);
                        zzeor2.read(this.f13482a.get());
                        this.f13482a.get().position(8);
                        j = zzbq.zzh(this.f13482a.get()) - 16;
                    } else {
                        j = zzf == 0 ? zzeor.size() - zzeor.position() : zzf - 8;
                    }
                    if ("uuid".equals(zzk)) {
                        this.f13482a.get().limit(this.f13482a.get().limit() + 16);
                        zzeor2.read(this.f13482a.get());
                        bArr = new byte[16];
                        for (int position2 = this.f13482a.get().position() - 16; position2 < this.f13482a.get().position(); position2++) {
                            bArr[position2 - (this.f13482a.get().position() - 16)] = this.f13482a.get().get(position2);
                        }
                        j -= 16;
                    }
                    long j2 = j;
                    zzbp zza = zza(zzk, bArr, zzbs2 instanceof zzbp ? ((zzbp) zzbs2).getType() : "");
                    zza.zza(zzbs2);
                    this.f13482a.get().rewind();
                    zza.zza(zzeor, this.f13482a.get(), j2, this);
                    return zza;
                }
                Logger logger = f13481b;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zzf);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzeor2.zzfc(position);
        throw new EOFException();
    }

    public abstract zzbp zza(String str, byte[] bArr, String str2);
}
