package com.google.android.gms.ads.internal.util;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzas extends Exception {
    private final int errorCode;

    public zzas(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
