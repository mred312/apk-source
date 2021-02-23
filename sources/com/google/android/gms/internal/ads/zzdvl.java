package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzdvl {

    /* renamed from: a */
    private final String f15994a;

    private zzdvl(String str) {
        this.f15994a = (String) zzdvv.checkNotNull(str);
    }

    /* renamed from: a */
    private static CharSequence m8528a(Object obj) {
        zzdvv.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public static zzdvl zzhe(String str) {
        return new zzdvl(str);
    }

    public final StringBuilder zza(StringBuilder sb, Iterator<?> it) {
        try {
            zzdvv.checkNotNull(sb);
            if (it.hasNext()) {
                sb.append(m8528a(it.next()));
                while (it.hasNext()) {
                    sb.append(this.f15994a);
                    sb.append(m8528a(it.next()));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
