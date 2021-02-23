package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcwx {

    /* renamed from: a */
    private final ConcurrentHashMap<String, zzapo> f15003a = new ConcurrentHashMap<>();

    /* renamed from: b */
    private final zzciq f15004b;

    public zzcwx(zzciq zzciq) {
        this.f15004b = zzciq;
    }

    public final void zzgl(String str) {
        try {
            this.f15003a.put(str, this.f15004b.zzdg(str));
        } catch (RemoteException e) {
            zzaza.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzapo zzgm(String str) {
        if (this.f15003a.containsKey(str)) {
            return this.f15003a.get(str);
        }
        return null;
    }
}
