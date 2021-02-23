package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzx extends zzy {
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public final ViewGroup.LayoutParams zzyk() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
