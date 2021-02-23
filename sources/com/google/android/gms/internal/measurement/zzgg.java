package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public abstract class zzgg<MessageType extends zzgh<MessageType, BuilderType>, BuilderType extends zzgg<MessageType, BuilderType>> implements zzjk {
    /* renamed from: a */
    private final String m10346a(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzhd zzhd, zzhm zzhm);

    public BuilderType zza(byte[] bArr, int i, int i2) {
        try {
            zzhd a = zzhd.m10358a(bArr, 0, i2, false);
            zza(a, zzhm.zza());
            a.zza(0);
            return this;
        } catch (zzih e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(m10346a("byte array"), e2);
        }
    }

    /* renamed from: zzt */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzhm zzhm) {
        try {
            zzhd a = zzhd.m10358a(bArr, 0, i2, false);
            zza(a, zzhm);
            a.zza(0);
            return this;
        } catch (zzih e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(m10346a("byte array"), e2);
        }
    }

    public final /* synthetic */ zzjk zza(zzjh zzjh) {
        if (zzaa().getClass().isInstance(zzjh)) {
            return zza((zzgh) zzjh);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzjk zza(byte[] bArr, zzhm zzhm) {
        return zza(bArr, 0, bArr.length, zzhm);
    }

    public final /* synthetic */ zzjk zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }
}
