package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzkw extends C3059n4 {

    /* renamed from: f */
    private static final String[] f18724f = {"firebase_", "google_", "ga_"};

    /* renamed from: g */
    private static final String[] f18725g = {"_err"};

    /* renamed from: b */
    private SecureRandom f18726b;

    /* renamed from: c */
    private final AtomicLong f18727c = new AtomicLong(0);

    /* renamed from: d */
    private int f18728d;

    /* renamed from: e */
    private Integer f18729e = null;

    zzkw(zzfv zzfv) {
        super(zzfv);
    }

    /* renamed from: C */
    static boolean m10986C(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    /* renamed from: D */
    private static boolean m10987D(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String R : strArr) {
            if (m10994R(str, R)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: G */
    static boolean m10988G(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* renamed from: H */
    static byte[] m10989H(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: K */
    private static boolean m10990K(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: L */
    private static boolean m10991L(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    /* renamed from: N */
    static Bundle[] m10992N(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    @VisibleForTesting
    /* renamed from: P */
    private final boolean m10993P(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            zzq().zze().zza("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            zzq().zze().zza("Package name not found", e2);
            return true;
        }
    }

    /* renamed from: R */
    static boolean m10994R(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* renamed from: S */
    static boolean m10995S(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* renamed from: U */
    private final int m10996U(String str) {
        if (!mo20578z("event param", str)) {
            return 3;
        }
        if (!mo20556E("event param", (String[]) null, str)) {
            return 14;
        }
        if (!mo20577y("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* renamed from: W */
    private final int m10997W(String str) {
        if (!mo20560M("event param", str)) {
            return 3;
        }
        if (!mo20556E("event param", (String[]) null, str)) {
            return 14;
        }
        if (!mo20577y("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* renamed from: X */
    static MessageDigest m10998X() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    /* renamed from: Y */
    private final int m10999Y(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (!zzs().zza(zzat.zzbg) || !"_lgclid".equals(str)) ? 36 : 100;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m11000b(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Object r20, android.os.Bundle r21, @androidx.annotation.Nullable java.util.List<java.lang.String> r22, boolean r23, boolean r24) {
        /*
            r16 = this;
            r7 = r16
            r8 = r19
            r0 = r20
            r1 = r21
            r16.zzc()
            boolean r2 = m11009v(r20)
            java.lang.String r3 = "param"
            r9 = 0
            r10 = 1
            if (r2 == 0) goto L_0x0092
            if (r24 == 0) goto L_0x008f
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzgv.zzc
            boolean r2 = m10987D(r8, r2)
            if (r2 != 0) goto L_0x0022
            r0 = 20
            return r0
        L_0x0022:
            com.google.android.gms.measurement.internal.zzfv r2 = r7.zzy
            com.google.android.gms.measurement.internal.zzio r2 = r2.zzv()
            boolean r2 = r2.mo20460i()
            if (r2 != 0) goto L_0x0031
            r0 = 25
            return r0
        L_0x0031:
            boolean r2 = r0 instanceof android.os.Parcelable[]
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == 0) goto L_0x003c
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r5 = r5.length
            goto L_0x0047
        L_0x003c:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x005c
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
        L_0x0047:
            if (r5 <= r4) goto L_0x005c
            com.google.android.gms.measurement.internal.zzer r6 = r16.zzq()
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzj()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r6.zza(r11, r3, r8, r5)
            r5 = 0
            goto L_0x005d
        L_0x005c:
            r5 = 1
        L_0x005d:
            if (r5 != 0) goto L_0x0092
            r5 = 17
            if (r2 == 0) goto L_0x0073
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r6 = r2.length
            if (r6 <= r4) goto L_0x008c
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x008c
        L_0x0073:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x008c
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r6 = r2.size()
            if (r6 <= r4) goto L_0x008c
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r9, r4)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x008c:
            r11 = 17
            goto L_0x0093
        L_0x008f:
            r0 = 21
            return r0
        L_0x0092:
            r11 = 0
        L_0x0093:
            com.google.android.gms.measurement.internal.zzy r1 = r16.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzaq
            r12 = r17
            boolean r1 = r1.zze(r12, r2)
            if (r1 == 0) goto L_0x00a7
            boolean r1 = m10995S(r18)
            if (r1 != 0) goto L_0x00ad
        L_0x00a7:
            boolean r1 = m10995S(r19)
            if (r1 == 0) goto L_0x00b0
        L_0x00ad:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x00b2
        L_0x00b0:
            r1 = 100
        L_0x00b2:
            boolean r1 = r7.mo20554A(r3, r8, r1, r0)
            if (r1 == 0) goto L_0x00b9
            return r11
        L_0x00b9:
            if (r24 == 0) goto L_0x014d
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00d4
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r6 = r23
            r0.m11004q(r1, r2, r3, r4, r5, r6)
        L_0x00d1:
            r9 = 1
            goto L_0x014a
        L_0x00d4:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x010c
            r13 = r0
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13
            int r14 = r13.length
            r15 = 0
        L_0x00dd:
            if (r15 >= r14) goto L_0x00d1
            r0 = r13[r15]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzer r1 = r16.zzq()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzj()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zza(r2, r0, r8)
            goto L_0x014a
        L_0x00f7:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r6 = r23
            r0.m11004q(r1, r2, r3, r4, r5, r6)
            int r15 = r15 + 1
            goto L_0x00dd
        L_0x010c:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x014a
            r13 = r0
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            int r14 = r13.size()
            r0 = 0
        L_0x0118:
            if (r0 >= r14) goto L_0x00d1
            java.lang.Object r1 = r13.get(r0)
            int r15 = r0 + 1
            boolean r0 = r1 instanceof android.os.Bundle
            if (r0 != 0) goto L_0x0136
            com.google.android.gms.measurement.internal.zzer r0 = r16.zzq()
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzj()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r0.zza(r2, r1, r8)
            goto L_0x014a
        L_0x0136:
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r22
            r6 = r23
            r0.m11004q(r1, r2, r3, r4, r5, r6)
            r0 = r15
            goto L_0x0118
        L_0x014a:
            if (r9 == 0) goto L_0x014d
            return r11
        L_0x014d:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkw.m11000b(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    @VisibleForTesting
    /* renamed from: e */
    static long m11001e(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    /* renamed from: j */
    private final Object m11002j(int i, Object obj, boolean z, boolean z2) {
        Bundle g;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (g = mo20568g((Bundle) parcelable)) != null && !g.isEmpty()) {
                    arrayList.add(g);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* renamed from: l */
    private static void m11003l(Bundle bundle, int i, String str, String str2, Object obj) {
        if (m10991L(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj == null) {
                    return;
                }
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    /* renamed from: q */
    private final void m11004q(String str, String str2, String str3, Bundle bundle, @Nullable List<String> list, boolean z) {
        int i;
        String str4;
        int i2;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            int i3 = 0;
            for (String str6 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str6)) {
                    i = z ? m10996U(str6) : 0;
                    if (i == 0) {
                        i = m10997W(str6);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    m11003l(bundle2, i, str6, str6, i == 3 ? str6 : null);
                    bundle2.remove(str6);
                } else {
                    if (m11009v(bundle2.get(str6))) {
                        zzq().zzj().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i2 = 22;
                        str4 = str6;
                    } else {
                        String str7 = str3;
                        str4 = str6;
                        i2 = m11000b(str, str2, str6, bundle2.get(str6), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        m11003l(bundle2, i2, str4, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (m11010w(str4) && !m10987D(str4, zzgv.zzd) && (i3 = i3 + 1) > 0) {
                        zzq().zzg().zza("Item cannot contain custom parameters", zzn().zza(str5), zzn().zza(bundle2));
                        m10991L(bundle2, 23);
                        bundle2.remove(str4);
                    }
                }
            }
        }
    }

    /* renamed from: r */
    static boolean m11005r(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return m10990K(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return m10990K(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* renamed from: s */
    static boolean m11006s(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* renamed from: t */
    static boolean m11007t(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    /* renamed from: u */
    static boolean m11008u(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    /* renamed from: v */
    static boolean m11009v(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* renamed from: w */
    static boolean m11010w(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static Bundle zzb(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    @VisibleForTesting
    private static boolean zzi(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public final boolean mo20554A(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzq().zzj().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public final boolean mo20555B(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (zzi(str)) {
                return true;
            }
            if (this.zzy.zzk()) {
                zzq().zzg().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzer.zza(str));
            }
            return false;
        } else if (zznt.zzb() && zzs().zza(zzat.zzbi) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (TextUtils.isEmpty(str2)) {
                if (this.zzy.zzk()) {
                    zzq().zzg().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            } else if (zzi(str2)) {
                return true;
            } else {
                zzq().zzg().zza("Invalid admob_app_id. Analytics disabled.", zzer.zza(str2));
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public final boolean mo20556E(String str, String[] strArr, String str2) {
        return mo20557F(str, strArr, (String[]) null, str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public final boolean mo20557F(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z;
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = f18724f;
        int length = strArr3.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr3[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzq().zzg().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !m10987D(str2, strArr) || (strArr2 != null && m10987D(str2, strArr2))) {
            return true;
        } else {
            zzq().zzg().zza("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public final int mo20558I(String str) {
        if (!mo20560M("user property", str)) {
            return 6;
        }
        if (!mo20556E("user property", zzgu.zza, str)) {
            return 15;
        }
        if (!mo20577y("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public final int mo20559J(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = mo20554A("user property referrer", str, m10999Y(str), obj);
        } else {
            z = mo20554A("user property", str, m10999Y(str), obj);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public final boolean mo20560M(String str, String str2) {
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzq().zzg().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzq().zzg().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzq().zzg().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public final Object mo20561O(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return m11002j(m10999Y(str), obj, true, false);
        }
        return m11002j(m10999Y(str), obj, false, false);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: Q */
    public final boolean mo20562Q(String str) {
        zzc();
        if (Wrappers.packageManager(zzm()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzq().zzv().zza("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: T */
    public final boolean mo20563T(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zzs().zzu().equals(str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: V */
    public final SecureRandom mo20564V() {
        zzc();
        if (this.f18726b == null) {
            this.f18726b = new SecureRandom();
        }
        return this.f18726b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo20565c(String str, boolean z) {
        if (!mo20560M(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (z) {
            if (!mo20557F(NotificationCompat.CATEGORY_EVENT, zzgs.zza, zzgs.zzb, str)) {
                return 13;
            }
        } else if (!mo20556E(NotificationCompat.CATEGORY_EVENT, zzgs.zza, str)) {
            return 13;
        }
        if (!mo20577y(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: d */
    public final long mo20566d(Context context, String str) {
        zzc();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest X = m10998X();
        if (X == null) {
            zzq().zze().zza("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!m10993P(context, str)) {
                    Signature[] signatureArr = Wrappers.packageManager(context).getPackageInfo(zzm().getPackageName(), 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        return m11001e(X.digest(signatureArr[0].toByteArray()));
                    }
                    zzq().zzh().zza("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzq().zze().zza("Package name not found", e);
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final Bundle mo20567f(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE, str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzq().zzh().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final Bundle mo20568g(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object k = mo20571k(str, bundle.get(str));
                if (k == null) {
                    zzq().zzj().zza("Param value can't be null", zzn().zzb(str));
                } else {
                    mo20573n(bundle2, str, k);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    /* renamed from: g_ */
    public final void mo20042g_() {
        zzc();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzq().zzh().zza("Utils falling back to Random for random id");
            }
        }
        this.f18727c.set(nextLong);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle mo20569h(java.lang.String r20, java.lang.String r21, android.os.Bundle r22, @androidx.annotation.Nullable java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r9 = r19
            r10 = r21
            r11 = r22
            r12 = r23
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzgs.zzd
            boolean r13 = m10987D(r10, r0)
            if (r11 == 0) goto L_0x0107
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.zzy r0 = r19.zzs()
            int r8 = r0.zzd()
            com.google.android.gms.measurement.internal.zzy r0 = r19.zzs()
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzay
            r7 = r20
            boolean r0 = r0.zze(r7, r1)
            if (r0 == 0) goto L_0x0035
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r22.keySet()
            r0.<init>(r1)
            goto L_0x0039
        L_0x0035:
            java.util.Set r0 = r22.keySet()
        L_0x0039:
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = 0
        L_0x0041:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x0105
            java.lang.Object r0 = r16.next()
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            if (r12 == 0) goto L_0x0059
            boolean r0 = r12.contains(r6)
            if (r0 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r0 = 0
            goto L_0x0067
        L_0x0059:
            if (r24 == 0) goto L_0x0060
            int r0 = r9.m10996U(r6)
            goto L_0x0061
        L_0x0060:
            r0 = 0
        L_0x0061:
            if (r0 != 0) goto L_0x0067
            int r0 = r9.m10997W(r6)
        L_0x0067:
            if (r0 == 0) goto L_0x0077
            r1 = 3
            if (r0 != r1) goto L_0x006e
            r1 = r6
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            m11003l(r15, r0, r6, r6, r1)
            r15.remove(r6)
            r9 = r8
            goto L_0x00b3
        L_0x0077:
            java.lang.Object r4 = r11.get(r6)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r6
            r5 = r15
            r14 = r6
            r6 = r23
            r7 = r24
            r9 = r8
            r8 = r13
            int r0 = r0.m11000b(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 17
            if (r0 != r1) goto L_0x0098
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            m11003l(r15, r0, r14, r14, r1)
            goto L_0x00b9
        L_0x0098:
            if (r0 == 0) goto L_0x00b9
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00b9
            r1 = 21
            if (r0 != r1) goto L_0x00a8
            r6 = r10
            goto L_0x00a9
        L_0x00a8:
            r6 = r14
        L_0x00a9:
            java.lang.Object r1 = r11.get(r14)
            m11003l(r15, r0, r6, r14, r1)
            r15.remove(r14)
        L_0x00b3:
            r7 = r20
        L_0x00b5:
            r8 = r9
            r9 = r19
            goto L_0x0041
        L_0x00b9:
            boolean r0 = m11010w(r14)
            if (r0 == 0) goto L_0x00b3
            int r0 = r18 + 1
            if (r0 <= r9) goto L_0x0102
            r1 = 48
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Event can't contain more than "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r1 = " params"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.measurement.internal.zzer r2 = r19.zzq()
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzg()
            com.google.android.gms.measurement.internal.zzep r3 = r19.zzn()
            java.lang.String r3 = r3.zza((java.lang.String) r10)
            com.google.android.gms.measurement.internal.zzep r4 = r19.zzn()
            java.lang.String r4 = r4.zza((android.os.Bundle) r11)
            r2.zza(r1, r3, r4)
            r1 = 5
            m10991L(r15, r1)
            r15.remove(r14)
            r7 = r20
            r18 = r0
            goto L_0x00b5
        L_0x0102:
            r18 = r0
            goto L_0x00b3
        L_0x0105:
            r14 = r15
            goto L_0x0108
        L_0x0107:
            r14 = 0
        L_0x0108:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkw.mo20569h(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final zzar mo20570i(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2, boolean z3) {
        String str4 = str2;
        Bundle bundle2 = bundle;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (mo20565c(str2, z3) == 0) {
            Bundle bundle3 = bundle2 != null ? new Bundle(bundle) : new Bundle();
            String str5 = str3;
            bundle3.putString("_o", str3);
            Bundle h = mo20569h(str, str2, bundle3, CollectionUtils.listOf("_o"), false, false);
            if (z) {
                h = mo20568g(h);
            }
            return new zzar(str2, new zzam(h), str3, j);
        }
        zzq().zze().zza("Invalid conditional property event name", zzn().zzc(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final Object mo20571k(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return m11002j(256, obj, true, true);
        }
        if (!m10995S(str)) {
            i = 100;
        }
        return m11002j(i, obj, false, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final void mo20572m(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    zzo().mo20573n(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final void mo20573n(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                zzq().zzj().zza("Not putting event parameter. Invalid value type. name, type", zzn().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final void mo20574o(zzev zzev, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzev.zzb.keySet())) {
            if (m11010w(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                zzq().zzg().zza(sb.toString(), zzn().zza(zzev.zza), zzn().zza(zzev.zzb));
                m10991L(zzev.zzb, 5);
                zzev.zzb.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final void mo20575p(C3143w7 w7Var, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m10991L(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        if (!zzlx.zzb() || !zzs().zza(zzat.zzcn)) {
            this.zzy.zzg().zza("auto", "_err", bundle);
        } else {
            w7Var.zza(str, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ApplySharedPref"})
    /* renamed from: x */
    public final boolean mo20576x(String str, double d) {
        try {
            SharedPreferences.Editor edit = zzm().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return edit.commit();
        } catch (Exception e) {
            zzq().zze().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public final boolean mo20577y(String str, int i, String str2) {
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzq().zzg().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public final boolean mo20578z(String str, String str2) {
        if (str2 == null) {
            zzq().zzg().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzq().zzg().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzq().zzg().zza("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzq().zzg().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return true;
    }

    public final long zzf() {
        long andIncrement;
        long j;
        if (this.f18727c.get() == 0) {
            synchronized (this.f18727c) {
                long nextLong = new Random(System.nanoTime() ^ zzl().currentTimeMillis()).nextLong();
                int i = this.f18728d + 1;
                this.f18728d = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.f18727c) {
            this.f18727c.compareAndSet(-1, 1);
            andIncrement = this.f18727c.getAndIncrement();
        }
        return andIncrement;
    }

    public final boolean zzj() {
        try {
            zzm().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final void zza(C3143w7 w7Var, int i, String str, String str2, int i2) {
        mo20575p(w7Var, (String) null, i, str, str2, i2);
    }

    public final int zzi() {
        if (this.f18729e == null) {
            this.f18729e = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zzm()) / 1000);
        }
        return this.f18729e.intValue();
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzm(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzq().zzh().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public static boolean zzf(String str) {
        for (String equals : f18725g) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public final void zza(zzw zzw, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning string value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning int value to wrapper", e);
        }
    }

    public static ArrayList<Bundle> zzb(List<zzw> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzw next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.zza);
            bundle.putString("origin", next.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, next.zzd);
            bundle.putString("name", next.zzc.zza);
            zzgt.zza(bundle, next.zzc.zza());
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, next.zze);
            String str = next.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzar zzar = next.zzg;
            if (zzar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzar.zza);
                zzam zzam = next.zzg.zzb;
                if (zzam != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzam.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, next.zzh);
            zzar zzar2 = next.zzi;
            if (zzar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzar2.zza);
                zzam zzam2 = next.zzi.zzb;
                if (zzam2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzam2.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, next.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, next.zzj);
            zzar zzar3 = next.zzk;
            if (zzar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzar3.zza);
                zzam zzam3 = next.zzk.zzb;
                if (zzam3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzam3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final void zza(zzw zzw, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzw zzw, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(zzw zzw, Bundle bundle) {
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning bundle value to wrapper", e);
        }
    }

    public static Bundle zza(List<zzkr> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkr next : list) {
            String str = next.zzd;
            if (str != null) {
                bundle.putString(next.zza, str);
            } else {
                Long l = next.zzc;
                if (l != null) {
                    bundle.putLong(next.zza, l.longValue());
                } else {
                    Double d = next.zzf;
                    if (d != null) {
                        bundle.putDouble(next.zza, d.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public final void zza(zzw zzw, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zzy.zzq().zzh().zza("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zza(long j, @NonNull String str, @NonNull String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j), Integer.valueOf(zzi())}), str2, str, Long.valueOf(j2)});
            if (str.equals(zzs().zzv())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzq().zze().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public static long zza(zzam zzam) {
        long j = 0;
        if (zzam == null) {
            return 0;
        }
        Iterator<String> it = zzam.iterator();
        while (it.hasNext()) {
            Object b = zzam.mo20239b(it.next());
            if (b instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) b).length;
            }
        }
        return j;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
