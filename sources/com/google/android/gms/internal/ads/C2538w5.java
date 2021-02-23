package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.w5 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class C2538w5 implements C2651z5 {

    /* renamed from: a */
    private final String f11664a;

    /* renamed from: b */
    private final String f11665b;

    /* renamed from: c */
    private final Map f11666c;

    /* renamed from: d */
    private final byte[] f11667d;

    C2538w5(String str, String str2, Map map, byte[] bArr) {
        this.f11664a = str;
        this.f11665b = str2;
        this.f11666c = map;
        this.f11667d = bArr;
    }

    /* renamed from: a */
    public final void mo14895a(JsonWriter jsonWriter) {
        zzayu.m7620e(this.f11664a, this.f11665b, this.f11666c, this.f11667d, jsonWriter);
    }
}
