package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import java.util.Map;

@DynamiteApi
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
public class AppMeasurementDynamiteService extends zzu {
    @VisibleForTesting

    /* renamed from: a */
    zzfv f17925a = null;

    /* renamed from: b */
    private Map<Integer, zzgw> f17926b = new ArrayMap();

    /* renamed from: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$a */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
    class C2928a implements zzgw {

        /* renamed from: a */
        private zzab f17927a;

        C2928a(zzab zzab) {
            this.f17927a = zzab;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.f17927a.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f17925a.zzq().zzh().zza("Event listener threw exception", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$b */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.6.0 */
    class C2929b implements zzgx {

        /* renamed from: a */
        private zzab f17929a;

        C2929b(zzab zzab) {
            this.f17929a = zzab;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.f17929a.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f17925a.zzq().zzh().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* renamed from: a */
    private final void m10415a() {
        if (this.f17925a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    /* renamed from: b */
    private final void m10416b(zzw zzw, String str) {
        this.f17925a.zzh().zza(zzw, str);
    }

    public void beginAdUnitExposure(String str, long j) {
        m10415a();
        this.f17925a.zzy().zza(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        m10415a();
        this.f17925a.zzg().zzc(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) {
        m10415a();
        this.f17925a.zzg().zza((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) {
        m10415a();
        this.f17925a.zzy().zzb(str, j);
    }

    public void generateEventId(zzw zzw) {
        m10415a();
        this.f17925a.zzh().zza(zzw, this.f17925a.zzh().zzf());
    }

    public void getAppInstanceId(zzw zzw) {
        m10415a();
        this.f17925a.zzp().zza((Runnable) new C3068o4(this, zzw));
    }

    public void getCachedAppInstanceId(zzw zzw) {
        m10415a();
        m10416b(zzw, this.f17925a.zzg().zzag());
    }

    public void getConditionalUserProperties(String str, String str2, zzw zzw) {
        m10415a();
        this.f17925a.zzp().zza((Runnable) new C3170z7(this, zzw, str, str2));
    }

    public void getCurrentScreenClass(zzw zzw) {
        m10415a();
        m10416b(zzw, this.f17925a.zzg().zzaj());
    }

    public void getCurrentScreenName(zzw zzw) {
        m10415a();
        m10416b(zzw, this.f17925a.zzg().zzai());
    }

    public void getGmpAppId(zzw zzw) {
        m10415a();
        m10416b(zzw, this.f17925a.zzg().zzak());
    }

    public void getMaxUserProperties(String str, zzw zzw) {
        m10415a();
        this.f17925a.zzg();
        Preconditions.checkNotEmpty(str);
        this.f17925a.zzh().zza(zzw, 25);
    }

    public void getTestFlag(zzw zzw, int i) {
        m10415a();
        if (i == 0) {
            this.f17925a.zzh().zza(zzw, this.f17925a.zzg().zzac());
        } else if (i == 1) {
            this.f17925a.zzh().zza(zzw, this.f17925a.zzg().zzad().longValue());
        } else if (i == 2) {
            zzkw zzh = this.f17925a.zzh();
            double doubleValue = this.f17925a.zzg().zzaf().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzw.zza(bundle);
            } catch (RemoteException e) {
                zzh.zzy.zzq().zzh().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.f17925a.zzh().zza(zzw, this.f17925a.zzg().zzae().intValue());
        } else if (i == 4) {
            this.f17925a.zzh().zza(zzw, this.f17925a.zzg().zzab().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzw zzw) {
        m10415a();
        this.f17925a.zzp().zza((Runnable) new C3078p5(this, zzw, str, str2, z));
    }

    public void initForTests(Map map) {
        m10415a();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzae zzae, long j) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfv zzfv = this.f17925a;
        if (zzfv == null) {
            this.f17925a = zzfv.zza(context, zzae, Long.valueOf(j));
        } else {
            zzfv.zzq().zzh().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzw zzw) {
        m10415a();
        this.f17925a.zzp().zza((Runnable) new C2998g7(this, zzw));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        m10415a();
        this.f17925a.zzg().zza(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzw, long j) {
        Bundle bundle2;
        m10415a();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f17925a.zzp().zza((Runnable) new C3034k6(this, zzw, new zzar(str2, new zzam(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Object obj;
        Object obj2;
        m10415a();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.f17925a.zzq().zza(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzw, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        Bundle bundle = new Bundle();
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.f17925a.zzq().zzh().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        m10415a();
        C3069o5 o5Var = this.f17925a.zzg().zza;
        if (o5Var != null) {
            this.f17925a.zzg().zzaa();
            o5Var.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void performAction(Bundle bundle, zzw zzw, long j) {
        m10415a();
        zzw.zza((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzab zzab) {
        m10415a();
        zzgw zzgw = this.f17926b.get(Integer.valueOf(zzab.zza()));
        if (zzgw == null) {
            zzgw = new C2928a(zzab);
            this.f17926b.put(Integer.valueOf(zzab.zza()), zzgw);
        }
        this.f17925a.zzg().zza(zzgw);
    }

    public void resetAnalyticsData(long j) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        zzg.mo20387j((String) null);
        zzg.zzp().zza((Runnable) new C3149x4(zzg, j));
    }

    public void setConditionalUserProperty(Bundle bundle, long j) {
        m10415a();
        if (bundle == null) {
            this.f17925a.zzq().zze().zza("Conditional user property must not be null");
        } else {
            this.f17925a.zzg().zza(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        if (zzmj.zzb() && zzg.zzs().zzd((String) null, zzat.zzcg)) {
            zzg.zza(bundle, 30, j);
        }
    }

    public void setConsentThirdParty(Bundle bundle, long j) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        if (zzmj.zzb() && zzg.zzs().zzd((String) null, zzat.zzch)) {
            zzg.zza(bundle, 10, j);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) {
        m10415a();
        this.f17925a.zzu().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        zzg.zzv();
        zzg.zzp().zza((Runnable) new C3042l5(zzg, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzg.zzp().zza((Runnable) new C3086q4(zzg, bundle2));
    }

    public void setEventInterceptor(zzab zzab) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        C2929b bVar = new C2929b(zzab);
        zzg.zzv();
        zzg.zzp().zza((Runnable) new C2936a5(zzg, bVar));
    }

    public void setInstanceIdProvider(zzac zzac) {
        m10415a();
    }

    public void setMeasurementEnabled(boolean z, long j) {
        m10415a();
        this.f17925a.zzg().zza(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        zzg.zzp().zza((Runnable) new C3122u4(zzg, j));
    }

    public void setSessionTimeoutDuration(long j) {
        m10415a();
        zzgy zzg = this.f17925a.zzg();
        zzg.zzp().zza((Runnable) new C3113t4(zzg, j));
    }

    public void setUserId(String str, long j) {
        m10415a();
        this.f17925a.zzg().zza((String) null, "_id", str, true, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        m10415a();
        this.f17925a.zzg().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzab zzab) {
        m10415a();
        zzgw remove = this.f17926b.remove(Integer.valueOf(zzab.zza()));
        if (remove == null) {
            remove = new C2928a(zzab);
        }
        this.f17925a.zzg().zzb(remove);
    }
}
