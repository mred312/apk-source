package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzasn implements zzasr {

    /* renamed from: f */
    private static final Object f12679f = new Object();
    @VisibleForTesting

    /* renamed from: g */
    private static zzasr f12680g;
    @VisibleForTesting

    /* renamed from: h */
    private static zzasr f12681h;

    /* renamed from: a */
    private final Object f12682a;

    /* renamed from: b */
    private final Context f12683b;

    /* renamed from: c */
    private final WeakHashMap<Thread, Boolean> f12684c;

    /* renamed from: d */
    private final ExecutorService f12685d;

    /* renamed from: e */
    private final zzazh f12686e;

    private zzasn(Context context) {
        this(context, zzazh.zzzi());
    }

    @VisibleForTesting
    /* renamed from: a */
    private final Uri.Builder m7545a(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.packageManager(this.f12683b).isCallerInstantApp();
        } catch (Throwable th) {
            zzaza.zzc("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.f12683b.getPackageName();
        } catch (Throwable unused) {
            zzaza.zzfa("Cannot obtain package name, proceeding.");
            str4 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter(FacebookAdapter.KEY_ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.f12686e.zzbrf).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzabf.zzrl())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "334274230").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzwq.zzqf()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzadg.zzddf.get()));
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcpz)).booleanValue()) {
            appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.f12683b))).appendQueryParameter("lite", this.f12686e.zzego ? "1" : "0");
        }
        return appendQueryParameter2;
    }

    public static zzasr zzc(Context context, zzazh zzazh) {
        synchronized (f12679f) {
            if (f12681h == null) {
                if (zzadg.zzddh.get().booleanValue()) {
                    if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyc)).booleanValue()) {
                        zzasn zzasn = new zzasn(context, zzazh);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzasn.f12682a) {
                                zzasn.f12684c.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new C1977h4(zzasn, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new C2014i4(zzasn, Thread.getDefaultUncaughtExceptionHandler()));
                        f12681h = zzasn;
                    }
                }
                f12681h = new zzasq();
            }
        }
        return f12681h;
    }

    public static zzasr zzq(Context context) {
        synchronized (f12679f) {
            if (f12680g == null) {
                if (zzadg.zzddh.get().booleanValue()) {
                    if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyc)).booleanValue()) {
                        f12680g = new zzasn(context);
                    }
                }
                f12680g = new zzasq();
            }
        }
        return f12680g;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r3 == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L_0x003c
            r1 = r11
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r1 == 0) goto L_0x0037
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = 0
        L_0x000f:
            if (r6 >= r5) goto L_0x0032
            r7 = r4[r6]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzayr.zzeu(r8)
            if (r8 == 0) goto L_0x001e
            r2 = 1
        L_0x001e:
            java.lang.Class<com.google.android.gms.internal.ads.zzasn> r8 = com.google.android.gms.internal.ads.zzasn.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x002f
            r3 = 1
        L_0x002f:
            int r6 = r6 + 1
            goto L_0x000f
        L_0x0032:
            java.lang.Throwable r1 = r1.getCause()
            goto L_0x0007
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r10 = 0
        L_0x003d:
            if (r10 == 0) goto L_0x0046
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasn.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    private zzasn(Context context, zzazh zzazh) {
        this.f12682a = new Object();
        this.f12684c = new WeakHashMap<>();
        this.f12685d = zzduo.zzayg().zzek(zzdut.zzhsl);
        this.f12683b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f12686e = zzazh;
    }

    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    public final void zza(Throwable th, String str, float f) {
        if (zzayr.zzd(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzeid.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            boolean z = Math.random() < ((double) f);
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m7545a(name, stringWriter2, str, i2).toString());
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    this.f12685d.execute(new C1940g4(new zzaze(), (String) obj));
                }
            }
        }
    }
}
