package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.common.b */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
abstract class C1663b extends zzn {

    /* renamed from: a */
    private int f7496a;

    protected C1663b(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.f7496a = Arrays.hashCode(bArr);
    }

    /* renamed from: b */
    protected static byte[] m5258b(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract byte[] mo12860a();

    public boolean equals(@Nullable Object obj) {
        IObjectWrapper zzb;
        if (obj != null && (obj instanceof zzl)) {
            try {
                zzl zzl = (zzl) obj;
                if (zzl.zzc() != hashCode() || (zzb = zzl.zzb()) == null) {
                    return false;
                }
                return Arrays.equals(mo12860a(), (byte[]) ObjectWrapper.unwrap(zzb));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f7496a;
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(mo12860a());
    }

    public final int zzc() {
        return hashCode();
    }
}
