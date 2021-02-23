package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcdd implements View.OnClickListener {

    /* renamed from: a */
    private final zzcgh f14124a;

    /* renamed from: b */
    private final Clock f14125b;
    @Nullable

    /* renamed from: c */
    private zzage f14126c;
    @Nullable

    /* renamed from: d */
    private zzahv<Object> f14127d;
    @VisibleForTesting
    @Nullable

    /* renamed from: e */
    String f14128e;
    @VisibleForTesting
    @Nullable

    /* renamed from: f */
    Long f14129f;
    @VisibleForTesting
    @Nullable

    /* renamed from: g */
    WeakReference<View> f14130g;

    public zzcdd(zzcgh zzcgh, Clock clock) {
        this.f14124a = zzcgh;
        this.f14125b = clock;
    }

    /* renamed from: a */
    private final void m7927a() {
        View view;
        this.f14128e = null;
        this.f14129f = null;
        WeakReference<View> weakReference = this.f14130g;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.f14130g = null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.f14126c != null && this.f14129f != null) {
            m7927a();
            try {
                this.f14126c.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        WeakReference<View> weakReference = this.f14130g;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.f14128e == null || this.f14129f == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put(FacebookAdapter.KEY_ID, this.f14128e);
                hashMap.put("time_interval", String.valueOf(this.f14125b.currentTimeMillis() - this.f14129f.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.f14124a.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            m7927a();
        }
    }

    public final void zza(zzage zzage) {
        this.f14126c = zzage;
        zzahv<Object> zzahv = this.f14127d;
        if (zzahv != null) {
            this.f14124a.zzb("/unconfirmedClick", zzahv);
        }
        C2324qh qhVar = new C2324qh(this, zzage);
        this.f14127d = qhVar;
        this.f14124a.zza("/unconfirmedClick", (zzahv<Object>) qhVar);
    }

    @Nullable
    public final zzage zzaol() {
        return this.f14126c;
    }
}
