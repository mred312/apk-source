package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzamg {

    /* renamed from: a */
    private static final Charset f12524a = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final zzamh<JSONObject> zzdjy = new C2086k2();
    public static final zzamf<InputStream> zzdjz = C2123l2.f9796a;

    /* renamed from: a */
    static final /* synthetic */ InputStream m7495a(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(f12524a));
    }
}
