package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeah {

    /* renamed from: a */
    private static final CopyOnWriteArrayList<zzeai> f16097a = new CopyOnWriteArrayList<>();

    public static zzeai zzhh(String str) {
        Iterator<zzeai> it = f16097a.iterator();
        while (it.hasNext()) {
            zzeai next = it.next();
            if (next.zzhi(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
