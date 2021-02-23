package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzmu;
import com.google.android.gms.internal.measurement.zzny;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public class zzfv implements C3050m4 {

    /* renamed from: H */
    private static volatile zzfv f18601H;

    /* renamed from: A */
    private volatile Boolean f18602A;
    @VisibleForTesting

    /* renamed from: B */
    private Boolean f18603B;
    @VisibleForTesting

    /* renamed from: C */
    private Boolean f18604C;

    /* renamed from: D */
    private volatile boolean f18605D;

    /* renamed from: E */
    private int f18606E;

    /* renamed from: F */
    private AtomicInteger f18607F = new AtomicInteger(0);
    @VisibleForTesting

    /* renamed from: G */
    final long f18608G;

    /* renamed from: a */
    private final Context f18609a;

    /* renamed from: b */
    private final String f18610b;

    /* renamed from: c */
    private final String f18611c;

    /* renamed from: d */
    private final String f18612d;

    /* renamed from: e */
    private final boolean f18613e;

    /* renamed from: f */
    private final zzx f18614f;

    /* renamed from: g */
    private final zzy f18615g;

    /* renamed from: h */
    private final C3049m3 f18616h;

    /* renamed from: i */
    private final zzer f18617i;

    /* renamed from: j */
    private final zzfo f18618j;

    /* renamed from: k */
    private final zzju f18619k;

    /* renamed from: l */
    private final zzkw f18620l;

    /* renamed from: m */
    private final zzep f18621m;

    /* renamed from: n */
    private final Clock f18622n;

    /* renamed from: o */
    private final zzij f18623o;

    /* renamed from: p */
    private final zzgy f18624p;

    /* renamed from: q */
    private final zza f18625q;

    /* renamed from: r */
    private final zzia f18626r;

    /* renamed from: s */
    private zzen f18627s;

    /* renamed from: t */
    private zzio f18628t;

    /* renamed from: u */
    private zzal f18629u;

    /* renamed from: v */
    private zzek f18630v;

    /* renamed from: w */
    private zzfi f18631w;

    /* renamed from: x */
    private boolean f18632x = false;

    /* renamed from: y */
    private Boolean f18633y;

    /* renamed from: z */
    private long f18634z;

    private zzfv(zzgz zzgz) {
        long j;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzgz);
        Context context = zzgz.f18651a;
        zzx zzx = new zzx(context);
        this.f18614f = zzx;
        C2934a3.f17934a = zzx;
        this.f18609a = context;
        this.f18610b = zzgz.f18652b;
        this.f18611c = zzgz.f18653c;
        this.f18612d = zzgz.f18654d;
        this.f18613e = zzgz.f18658h;
        this.f18602A = zzgz.f18655e;
        this.f18605D = true;
        zzae zzae = zzgz.f18657g;
        if (!(zzae == null || (bundle = zzae.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.f18603B = (Boolean) obj;
            }
            Object obj2 = zzae.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.f18604C = (Boolean) obj2;
            }
        }
        zzdh.zza(context);
        Clock instance = DefaultClock.getInstance();
        this.f18622n = instance;
        Long l = zzgz.f18659i;
        if (l != null) {
            j = l.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.f18608G = j;
        this.f18615g = new zzy(this);
        C3049m3 m3Var = new C3049m3(this);
        m3Var.zzab();
        this.f18616h = m3Var;
        zzer zzer = new zzer(this);
        zzer.zzab();
        this.f18617i = zzer;
        zzkw zzkw = new zzkw(this);
        zzkw.zzab();
        this.f18620l = zzkw;
        zzep zzep = new zzep(this);
        zzep.zzab();
        this.f18621m = zzep;
        this.f18625q = new zza(this);
        zzij zzij = new zzij(this);
        zzij.zzw();
        this.f18623o = zzij;
        zzgy zzgy = new zzgy(this);
        zzgy.zzw();
        this.f18624p = zzgy;
        zzju zzju = new zzju(this);
        zzju.zzw();
        this.f18619k = zzju;
        zzia zzia = new zzia(this);
        zzia.zzab();
        this.f18626r = zzia;
        zzfo zzfo = new zzfo(this);
        zzfo.zzab();
        this.f18618j = zzfo;
        zzae zzae2 = zzgz.f18657g;
        if (!(zzae2 == null || zzae2.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            zzgy zzg = zzg();
            if (zzg.zzm().getApplicationContext() instanceof Application) {
                Application application = (Application) zzg.zzm().getApplicationContext();
                if (zzg.zza == null) {
                    zzg.zza = new C3069o5(zzg, (C3104s4) null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzg.zza);
                    application.registerActivityLifecycleCallbacks(zzg.zza);
                    zzg.zzq().zzw().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzq().zzh().zza("Application context is not an Application");
        }
        zzfo.zza((Runnable) new C3103s3(this, zzgz));
    }

    /* renamed from: c */
    private static void m10810c(C3032k4 k4Var) {
        if (k4Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: e */
    public final void m10811e(zzgz zzgz) {
        zzet zzet;
        String str;
        zzp().zzc();
        zzal zzal = new zzal(this);
        zzal.zzab();
        this.f18629u = zzal;
        zzek zzek = new zzek(this, zzgz.f18656f);
        zzek.zzw();
        this.f18630v = zzek;
        zzen zzen = new zzen(this);
        zzen.zzw();
        this.f18627s = zzen;
        zzio zzio = new zzio(this);
        zzio.zzw();
        this.f18628t = zzio;
        this.f18620l.zzac();
        this.f18616h.zzac();
        this.f18631w = new zzfi(this);
        this.f18630v.zzx();
        zzq().zzu().zza("App measurement initialized, version", 32053L);
        zzq().zzu().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String c = zzek.mo20275c();
        if (TextUtils.isEmpty(this.f18610b)) {
            if (zzh().mo20563T(c)) {
                zzet = zzq().zzu();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzet zzu = zzq().zzu();
                String valueOf = String.valueOf(c);
                zzet zzet2 = zzu;
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzet = zzet2;
            }
            zzet.zza(str);
        }
        zzq().zzv().zza("Debug-level message logging enabled");
        if (this.f18606E != this.f18607F.get()) {
            zzq().zze().zza("Not all components initialized", Integer.valueOf(this.f18606E), Integer.valueOf(this.f18607F.get()));
        }
        this.f18632x = true;
    }

    /* renamed from: j */
    private final zzia m10812j() {
        m10814l(this.f18626r);
        return this.f18626r;
    }

    /* renamed from: k */
    private static void m10813k(C3130v3 v3Var) {
        if (v3Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!v3Var.mo20123a()) {
            String valueOf = String.valueOf(v3Var.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: l */
    private static void m10814l(C3059n4 n4Var) {
        if (n4Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!n4Var.mo20065a()) {
            String valueOf = String.valueOf(n4Var.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo20349b(C3130v3 v3Var) {
        this.f18606E++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo20350d(C3059n4 n4Var) {
        this.f18606E++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo20351f(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzq().zzh().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzb().f18247w.zza(true);
        if (bArr.length == 0) {
            zzq().zzv().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (TextUtils.isEmpty(optString)) {
                zzq().zzv().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkw zzh = zzh();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzh.zzm().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzq().zzh().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.f18624p.zza("auto", "_cmp", bundle);
            zzkw zzh2 = zzh();
            if (!TextUtils.isEmpty(optString) && zzh2.mo20576x(optString, optDouble)) {
                zzh2.zzm().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzq().zze().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: g */
    public final void mo20352g(boolean z) {
        this.f18602A = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo20353h() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo20354i() {
        this.f18607F.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final zzfo mo20355m() {
        return this.f18618j;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzae zzae) {
        zzp().zzc();
        if (zzmj.zzb() && this.f18615g.zza(zzat.zzcg)) {
            zzad o = zzb().mo20050o();
            if (!(zzae == null || zzae.zzg == null || !zzb().zza(40))) {
                zzad zzb = zzad.zzb(zzae.zzg);
                if (!zzb.equals(zzad.zza)) {
                    zzg().zza(zzb, 40, this.f18608G);
                    o = zzb;
                }
            }
            zzg().mo20386c(o);
        }
        if (zzb().f18228d.zza() == 0) {
            zzb().f18228d.zza(this.f18622n.currentTimeMillis());
        }
        if (Long.valueOf(zzb().f18233i.zza()).longValue() == 0) {
            zzq().zzw().zza("Persisting first open", Long.valueOf(this.f18608G));
            zzb().f18233i.zza(this.f18608G);
        }
        if (this.f18615g.zza(zzat.zzcc)) {
            zzg().f18648l.mo20598c();
        }
        if (zzaf()) {
            if (!TextUtils.isEmpty(zzx().mo20276d()) || !TextUtils.isEmpty(zzx().zzac())) {
                zzh();
                if (zzkw.m10986C(zzx().mo20276d(), zzb().mo20044i(), zzx().zzac(), zzb().mo20045j())) {
                    zzq().zzu().zza("Rechecking which service to use due to a GMP App Id change");
                    zzb().mo20047l();
                    zzj().zzaa();
                    this.f18628t.zzag();
                    this.f18628t.mo20458g();
                    zzb().f18233i.zza(this.f18608G);
                    zzb().f18235k.zza((String) null);
                }
                zzb().mo20040f(zzx().mo20276d());
                zzb().zzc(zzx().zzac());
            }
            if (zzmj.zzb() && this.f18615g.zza(zzat.zzcg) && !zzb().mo20050o().zze()) {
                zzb().f18235k.zza((String) null);
            }
            zzg().mo20387j(zzb().f18235k.zza());
            if (zzmu.zzb() && this.f18615g.zza(zzat.zzbo) && !zzh().zzj() && !TextUtils.isEmpty(zzb().f18249y.zza())) {
                zzq().zzh().zza("Remote config removed with active feature rollouts");
                zzb().f18249y.zza((String) null);
            }
            if (!TextUtils.isEmpty(zzx().mo20276d()) || !TextUtils.isEmpty(zzx().zzac())) {
                boolean zzaa = zzaa();
                if (!zzb().zzy() && !this.f18615g.zzf()) {
                    zzb().mo20041g(!zzaa);
                }
                if (zzaa) {
                    zzg().zzah();
                }
                zzd().zza.mo20010a();
                zzv().zza((AtomicReference<String>) new AtomicReference());
                if (zzny.zzb() && this.f18615g.zza(zzat.zzby)) {
                    zzv().zza(zzb().f18225B.zza());
                }
            }
        } else if (zzaa()) {
            if (!zzh().mo20562Q("android.permission.INTERNET")) {
                zzq().zze().zza("App is missing INTERNET permission");
            }
            if (!zzh().mo20562Q("android.permission.ACCESS_NETWORK_STATE")) {
                zzq().zze().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.f18609a).isCallerInstantApp() && !this.f18615g.mo20608j()) {
                if (!zzfn.zza(this.f18609a)) {
                    zzq().zze().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkw.m11005r(this.f18609a, false)) {
                    zzq().zze().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzq().zze().zza("Uploading is not possible. App measurement disabled");
        }
        zzb().f18243s.zza(this.f18615g.zza(zzat.zzax));
    }

    @WorkerThread
    public final boolean zzaa() {
        return zzab() == 0;
    }

    @WorkerThread
    public final int zzab() {
        zzp().zzc();
        if (this.f18615g.zzf()) {
            return 1;
        }
        Boolean bool = this.f18604C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (zzmj.zzb() && this.f18615g.zza(zzat.zzcg) && !zzac()) {
            return 8;
        }
        Boolean m = zzb().mo20048m();
        if (m == null) {
            Boolean f = this.f18615g.mo20604f("firebase_analytics_collection_enabled");
            if (f == null) {
                Boolean bool2 = this.f18603B;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.f18615g.zza(zzat.zzar) || this.f18602A == null || this.f18602A.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (f.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (m.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @WorkerThread
    public final boolean zzac() {
        zzp().zzc();
        return this.f18605D;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzaf() {
        if (this.f18632x) {
            zzp().zzc();
            Boolean bool = this.f18633y;
            if (bool == null || this.f18634z == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f18622n.elapsedRealtime() - this.f18634z) > 1000)) {
                this.f18634z = this.f18622n.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzh().mo20562Q("android.permission.INTERNET") && zzh().mo20562Q("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.f18609a).isCallerInstantApp() || this.f18615g.mo20608j() || (zzfn.zza(this.f18609a) && zzkw.m11005r(this.f18609a, false))));
                this.f18633y = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzh().mo20555B(zzx().mo20276d(), zzx().zzac(), zzx().mo20277e()) && TextUtils.isEmpty(zzx().zzac())) {
                        z = false;
                    }
                    this.f18633y = Boolean.valueOf(z);
                }
            }
            return this.f18633y.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @WorkerThread
    public final void zzag() {
        zzp().zzc();
        m10814l(m10812j());
        String c = zzx().mo20275c();
        Pair<String, Boolean> b = zzb().mo20036b(c);
        if (!this.f18615g.zzg().booleanValue() || ((Boolean) b.second).booleanValue() || TextUtils.isEmpty((CharSequence) b.first)) {
            zzq().zzv().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!m10812j().zzf()) {
            zzq().zzh().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzkw zzh = zzh();
            zzx();
            URL zza = zzh.zza(32053, c, (String) b.first, zzb().f18248x.zza() - 1);
            zzia j = m10812j();
            C3094r3 r3Var = new C3094r3(this);
            j.zzc();
            j.zzaa();
            Preconditions.checkNotNull(zza);
            Preconditions.checkNotNull(r3Var);
            j.zzp().zzc(new C3087q5(j, c, zza, (byte[]) null, (Map<String, String>) null, r3Var));
        }
    }

    public final C3049m3 zzb() {
        m10810c(this.f18616h);
        return this.f18616h;
    }

    public final zzer zzc() {
        zzer zzer = this.f18617i;
        if (zzer == null || !zzer.mo20065a()) {
            return null;
        }
        return this.f18617i;
    }

    public final zzju zzd() {
        m10813k(this.f18619k);
        return this.f18619k;
    }

    public final zzfi zze() {
        return this.f18631w;
    }

    public final zzgy zzg() {
        m10813k(this.f18624p);
        return this.f18624p;
    }

    public final zzkw zzh() {
        m10810c(this.f18620l);
        return this.f18620l;
    }

    public final zzep zzi() {
        m10810c(this.f18621m);
        return this.f18621m;
    }

    public final zzen zzj() {
        m10813k(this.f18627s);
        return this.f18627s;
    }

    public final boolean zzk() {
        return TextUtils.isEmpty(this.f18610b);
    }

    public final Clock zzl() {
        return this.f18622n;
    }

    public final Context zzm() {
        return this.f18609a;
    }

    public final String zzn() {
        return this.f18610b;
    }

    public final String zzo() {
        return this.f18611c;
    }

    public final zzfo zzp() {
        m10814l(this.f18618j);
        return this.f18618j;
    }

    public final zzer zzq() {
        m10814l(this.f18617i);
        return this.f18617i;
    }

    public final String zzr() {
        return this.f18612d;
    }

    public final boolean zzs() {
        return this.f18613e;
    }

    public final zzx zzt() {
        return this.f18614f;
    }

    public final zzij zzu() {
        m10813k(this.f18623o);
        return this.f18623o;
    }

    public final zzio zzv() {
        m10813k(this.f18628t);
        return this.f18628t;
    }

    public final zzal zzw() {
        m10814l(this.f18629u);
        return this.f18629u;
    }

    public final zzek zzx() {
        m10813k(this.f18630v);
        return this.f18630v;
    }

    public final zza zzy() {
        zza zza = this.f18625q;
        if (zza != null) {
            return zza;
        }
        throw new IllegalStateException("Component not created");
    }

    @WorkerThread
    public final boolean zzz() {
        return this.f18602A != null && this.f18602A.booleanValue();
    }

    @WorkerThread
    public final void zzb(boolean z) {
        zzp().zzc();
        this.f18605D = z;
    }

    public final zzy zza() {
        return this.f18615g;
    }

    public static zzfv zza(Context context, zzae zzae, Long l) {
        Bundle bundle;
        if (zzae != null && (zzae.zze == null || zzae.zzf == null)) {
            zzae = new zzae(zzae.zza, zzae.zzb, zzae.zzc, zzae.zzd, (String) null, (String) null, zzae.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f18601H == null) {
            synchronized (zzfv.class) {
                if (f18601H == null) {
                    f18601H = new zzfv(new zzgz(context, zzae, l));
                }
            }
        } else if (!(zzae == null || (bundle = zzae.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            f18601H.mo20352g(zzae.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return f18601H;
    }
}
