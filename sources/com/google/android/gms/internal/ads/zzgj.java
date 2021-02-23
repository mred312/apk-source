package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzgj {

    /* renamed from: a */
    private final zzfa f16425a;

    /* renamed from: b */
    private final String f16426b;

    /* renamed from: c */
    private final String f16427c;

    /* renamed from: d */
    private volatile Method f16428d = null;

    /* renamed from: e */
    private final Class<?>[] f16429e;

    /* renamed from: f */
    private CountDownLatch f16430f = new CountDownLatch(1);

    public zzgj(zzfa zzfa, String str, String str2, Class<?>... clsArr) {
        this.f16425a = zzfa;
        this.f16426b = str;
        this.f16427c = str2;
        this.f16429e = clsArr;
        zzfa.zzcg().submit(new hd0(this));
    }

    /* renamed from: b */
    private final String m8946b(byte[] bArr, String str) {
        return new String(this.f16425a.zzci().zza(bArr, str), Key.STRING_CHARSET_NAME);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m8947c() {
        try {
            Class loadClass = this.f16425a.zzch().loadClass(m8946b(this.f16425a.zzcj(), this.f16426b));
            if (loadClass != null) {
                this.f16428d = loadClass.getMethod(m8946b(this.f16425a.zzcj(), this.f16427c), this.f16429e);
                if (this.f16428d == null) {
                    this.f16430f.countDown();
                } else {
                    this.f16430f.countDown();
                }
            }
        } catch (zzek unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.f16430f.countDown();
        }
    }

    public final Method zzdb() {
        if (this.f16428d != null) {
            return this.f16428d;
        }
        try {
            if (!this.f16430f.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.f16428d;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
