package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzamb implements zzakj, zzaly {

    /* renamed from: a */
    private final zzalz f12518a;

    /* renamed from: b */
    private final HashSet<AbstractMap.SimpleEntry<String, zzahv<? super zzalz>>> f12519b = new HashSet<>();

    public zzamb(zzalz zzalz) {
        this.f12518a = zzalz;
    }

    public final void zza(String str, zzahv<? super zzalz> zzahv) {
        this.f12518a.zza(str, zzahv);
        this.f12519b.add(new AbstractMap.SimpleEntry(str, zzahv));
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zzb(String str, zzahv<? super zzalz> zzahv) {
        this.f12518a.zzb(str, zzahv);
        this.f12519b.remove(new AbstractMap.SimpleEntry(str, zzahv));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final void zzcy(String str) {
        this.f12518a.zzcy(str);
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final void zztz() {
        Iterator<AbstractMap.SimpleEntry<String, zzahv<? super zzalz>>> it = this.f12519b.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzahv) next.getValue()).toString());
            zzd.zzee(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.f12518a.zzb((String) next.getKey(), (zzahv) next.getValue());
        }
        this.f12519b.clear();
    }
}
