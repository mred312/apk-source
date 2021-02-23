package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzash {
    @Nonnull

    /* renamed from: a */
    private final View f12674a;
    @Nullable

    /* renamed from: b */
    private final Map<String, WeakReference<View>> f12675b;
    @Nullable

    /* renamed from: c */
    private final zzaxq f12676c;

    public zzash(zzasi zzasi) {
        View a = zzasi.f12677a;
        this.f12674a = a;
        Map<String, WeakReference<View>> b = zzasi.f12678b;
        this.f12675b = b;
        zzaxq zzp = zzasf.zzp(zzasi.f12677a.getContext());
        this.f12676c = zzp;
        if (zzp != null && b != null && !b.isEmpty()) {
            try {
                zzp.zza(new zzasl(ObjectWrapper.wrap(a).asBinder(), ObjectWrapper.wrap(b).asBinder()));
            } catch (RemoteException unused) {
                zzaza.zzey("Failed to call remote method.");
            }
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzaxq zzaxq = this.f12676c;
        if (zzaxq == null) {
            zzaza.zzeb("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzaxq.zzan(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzaza.zzey("Failed to call remote method.");
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.f12676c == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.f12676c.zzb(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.f12674a), new C1903f4(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.f12676c == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.f12676c.zza(list, ObjectWrapper.wrap(this.f12674a), (zzasa) new C1866e4(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }
}
