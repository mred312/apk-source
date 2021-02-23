package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeou extends zzeox {

    /* renamed from: a */
    private String f16336a;

    public zzeou(String str) {
        this.f16336a = str;
    }

    public final void zzii(String str) {
        String str2 = this.f16336a;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
