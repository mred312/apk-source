package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzasi {
    /* access modifiers changed from: private */
    @Nonnull

    /* renamed from: a */
    public View f12677a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, WeakReference<View>> f12678b = new HashMap();

    public final zzasi zzh(Map<String, View> map) {
        this.f12678b.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.f12678b.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }

    public final zzasi zzk(View view) {
        this.f12677a = view;
        return this;
    }
}
