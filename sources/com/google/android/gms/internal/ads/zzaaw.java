package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaaw {

    /* renamed from: a */
    private final Collection<zzaaq<?>> f12338a = new ArrayList();

    /* renamed from: b */
    private final Collection<zzaaq<String>> f12339b = new ArrayList();

    /* renamed from: c */
    private final Collection<zzaaq<String>> f12340c = new ArrayList();

    public final void zza(zzaaq zzaaq) {
        this.f12338a.add(zzaaq);
    }

    public final void zzb(zzaaq<String> zzaaq) {
        this.f12339b.add(zzaaq);
    }

    public final void zzc(zzaaq<String> zzaaq) {
        this.f12340c.add(zzaaq);
    }

    public final List<String> zzrl() {
        ArrayList arrayList = new ArrayList();
        for (zzaaq<String> zzd : this.f12339b) {
            String str = (String) zzwq.zzqe().zzd(zzd);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzabg.m7426b());
        return arrayList;
    }

    public final List<String> zzrm() {
        List<String> zzrl = zzrl();
        for (zzaaq<String> zzd : this.f12340c) {
            String str = (String) zzwq.zzqe().zzd(zzd);
            if (!TextUtils.isEmpty(str)) {
                zzrl.add(str);
            }
        }
        zzrl.addAll(zzabg.m7427c());
        return zzrl;
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzaaq next : this.f12338a) {
            if (next.getSource() == 1) {
                next.zza(editor, next.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzaza.zzey("Flag Json is null.");
        }
    }
}
