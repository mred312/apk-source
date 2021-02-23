package com.google.ads.mediation.facebook;

import android.os.Bundle;

public class FacebookExtras {
    public static String NATIVE_BANNER = "native_banner";

    /* renamed from: a */
    private static boolean f7012a;

    public Bundle build() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(NATIVE_BANNER, f7012a);
        return bundle;
    }

    public FacebookExtras setNativeBanner(boolean z) {
        f7012a = z;
        return this;
    }
}
