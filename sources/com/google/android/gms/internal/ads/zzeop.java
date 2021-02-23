package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzeop implements zzbs, Closeable, Iterator<zzbp> {

    /* renamed from: e */
    private static final zzbp f16330e = new nc0("eof ");

    /* renamed from: a */
    private zzbp f16331a = null;

    /* renamed from: b */
    long f16332b = 0;

    /* renamed from: c */
    long f16333c = 0;

    /* renamed from: d */
    private List<zzbp> f16334d = new ArrayList();
    protected zzeor zziyc;
    protected zzbo zziyf;

    static {
        zzeox.zzn(zzeop.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final zzbp next() {
        zzbp zza;
        zzbp zzbp = this.f16331a;
        if (zzbp == null || zzbp == f16330e) {
            zzeor zzeor = this.zziyc;
            if (zzeor == null || this.f16332b >= this.f16333c) {
                this.f16331a = f16330e;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzeor) {
                    this.zziyc.zzfc(this.f16332b);
                    zza = this.zziyf.zza(this.zziyc, this);
                    this.f16332b = this.zziyc.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.f16331a = null;
            return zzbp;
        }
    }

    public void close() {
        this.zziyc.close();
    }

    public boolean hasNext() {
        zzbp zzbp = this.f16331a;
        if (zzbp == f16330e) {
            return false;
        }
        if (zzbp != null) {
            return true;
        }
        try {
            this.f16331a = (zzbp) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.f16331a = f16330e;
            return false;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.f16334d.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.f16334d.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzeor zzeor, long j, zzbo zzbo) {
        this.zziyc = zzeor;
        this.f16332b = zzeor.position();
        zzeor.zzfc(zzeor.position() + j);
        this.f16333c = zzeor.position();
        this.zziyf = zzbo;
    }

    public final List<zzbp> zzblr() {
        if (this.zziyc == null || this.f16331a == f16330e) {
            return this.f16334d;
        }
        return new zzeov(this.f16334d, this);
    }
}
