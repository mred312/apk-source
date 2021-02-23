package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqq {

    /* renamed from: a */
    private final boolean f12637a;

    /* renamed from: b */
    private final boolean f12638b;

    /* renamed from: c */
    private final boolean f12639c;

    /* renamed from: d */
    private final boolean f12640d;

    /* renamed from: e */
    private final boolean f12641e;

    private zzaqq(zzaqs zzaqs) {
        this.f12637a = zzaqs.f12642a;
        this.f12638b = zzaqs.f12643b;
        this.f12639c = zzaqs.f12644c;
        this.f12640d = zzaqs.f12645d;
        this.f12641e = zzaqs.f12646e;
    }

    public final JSONObject zzdr() {
        try {
            return new JSONObject().put("sms", this.f12637a).put("tel", this.f12638b).put("calendar", this.f12639c).put("storePicture", this.f12640d).put("inlineVideo", this.f12641e);
        } catch (JSONException e) {
            zzaza.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
