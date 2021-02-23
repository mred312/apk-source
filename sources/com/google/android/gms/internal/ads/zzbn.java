package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbn extends zzeop implements Closeable {
    static {
        zzeox.zzn(zzbn.class);
    }

    public zzbn(zzeor zzeor, zzbo zzbo) {
        zza(zzeor, zzeor.size(), zzbo);
    }

    public void close() {
        this.zziyc.close();
    }

    public String toString() {
        String obj = this.zziyc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
