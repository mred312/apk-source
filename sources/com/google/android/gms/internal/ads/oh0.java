package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class oh0 implements Application.ActivityLifecycleCallbacks {
    @Nullable

    /* renamed from: a */
    private Activity f10373a;

    /* renamed from: b */
    private Context f10374b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f10375c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f10376d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f10377e = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")

    /* renamed from: f */
    public final List<zzrl> f10378f = new ArrayList();
    @GuardedBy("lock")

    /* renamed from: g */
    private final List<zzrw> f10379g = new ArrayList();

    /* renamed from: h */
    private Runnable f10380h;

    /* renamed from: i */
    private boolean f10381i = false;

    /* renamed from: j */
    private long f10382j;

    oh0() {
    }

    /* renamed from: c */
    private final void m6584c(Activity activity) {
        synchronized (this.f10375c) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.f10373a = activity;
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public final Activity mo14539a() {
        return this.f10373a;
    }

    @Nullable
    /* renamed from: b */
    public final Context mo14540b() {
        return this.f10374b;
    }

    /* renamed from: e */
    public final void mo14541e(Application application, Context context) {
        if (!this.f10381i) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                m6584c((Activity) context);
            }
            this.f10374b = application;
            this.f10382j = ((Long) zzwq.zzqe().zzd(zzabf.zzcoo)).longValue();
            this.f10381i = true;
        }
    }

    /* renamed from: f */
    public final void mo14542f(zzrl zzrl) {
        synchronized (this.f10375c) {
            this.f10378f.add(zzrl);
        }
    }

    /* renamed from: h */
    public final void mo14543h(zzrl zzrl) {
        synchronized (this.f10375c) {
            this.f10378f.remove(zzrl);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f10375c) {
            Activity activity2 = this.f10373a;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.f10373a = null;
                }
                Iterator<zzrw> it = this.f10379g.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzp.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzaza.zzc("", e);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        m6584c(activity);
        synchronized (this.f10375c) {
            for (zzrw onActivityPaused : this.f10379g) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzp.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzaza.zzc("", e);
                }
            }
        }
        this.f10377e = true;
        Runnable runnable = this.f10380h;
        if (runnable != null) {
            zzm.zzedd.removeCallbacks(runnable);
        }
        zzduw zzduw = zzm.zzedd;
        nh0 nh0 = new nh0(this);
        this.f10380h = nh0;
        zzduw.postDelayed(nh0, this.f10382j);
    }

    public final void onActivityResumed(Activity activity) {
        m6584c(activity);
        this.f10377e = false;
        boolean z = !this.f10376d;
        this.f10376d = true;
        Runnable runnable = this.f10380h;
        if (runnable != null) {
            zzm.zzedd.removeCallbacks(runnable);
        }
        synchronized (this.f10375c) {
            for (zzrw onActivityResumed : this.f10379g) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzp.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzaza.zzc("", e);
                }
            }
            if (z) {
                for (zzrl zzp : this.f10378f) {
                    try {
                        zzp.zzp(true);
                    } catch (Exception e2) {
                        zzaza.zzc("", e2);
                    }
                }
            } else {
                zzaza.zzeb("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        m6584c(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }
}
