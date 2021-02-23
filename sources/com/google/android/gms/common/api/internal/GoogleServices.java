package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.C1659R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class GoogleServices {

    /* renamed from: e */
    private static final Object f7475e = new Object();
    @GuardedBy("sLock")

    /* renamed from: f */
    private static GoogleServices f7476f;

    /* renamed from: a */
    private final String f7477a;

    /* renamed from: b */
    private final Status f7478b;

    /* renamed from: c */
    private final boolean f7479c;

    /* renamed from: d */
    private final boolean f7480d;

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C1659R.string.common_google_play_services_unknown_issue));
        boolean z = false;
        boolean z2 = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) != 0 ? true : z;
            this.f7480d = !z;
            z2 = z;
        } else {
            this.f7480d = false;
        }
        this.f7479c = z2;
        String zza = zzs.zza(context);
        zza = zza == null ? new StringResourceValueReader(context).getString("google_app_id") : zza;
        if (TextUtils.isEmpty(zza)) {
            this.f7478b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f7477a = null;
            return;
        }
        this.f7477a = zza;
        this.f7478b = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    /* renamed from: b */
    private static GoogleServices m5252b(String str) {
        GoogleServices googleServices;
        synchronized (f7475e) {
            googleServices = f7476f;
            if (googleServices == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }

    @KeepForSdk
    public static String getGoogleAppId() {
        return m5252b("getGoogleAppId").f7477a;
    }

    @KeepForSdk
    public static Status initialize(Context context, String str, boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (f7475e) {
            GoogleServices googleServices = f7476f;
            if (googleServices != null) {
                Status a = googleServices.mo12823a(str);
                return a;
            }
            GoogleServices googleServices2 = new GoogleServices(str, z);
            f7476f = googleServices2;
            Status status = googleServices2.f7478b;
            return status;
        }
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices b = m5252b("isMeasurementEnabled");
        return b.f7478b.isSuccess() && b.f7479c;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return m5252b("isMeasurementExplicitlyDisabled").f7480d;
    }

    /* access modifiers changed from: package-private */
    @KeepForSdk
    @VisibleForTesting
    /* renamed from: a */
    public final Status mo12823a(String str) {
        String str2 = this.f7477a;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.f7477a;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
        sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        sb.append(str3);
        sb.append("'.");
        return new Status(10, sb.toString());
    }

    @KeepForSdk
    public static Status initialize(Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (f7475e) {
            if (f7476f == null) {
                f7476f = new GoogleServices(context);
            }
            status = f7476f.f7478b;
        }
        return status;
    }

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(String str, boolean z) {
        this.f7477a = str;
        this.f7478b = Status.RESULT_SUCCESS;
        this.f7479c = z;
        this.f7480d = !z;
    }
}
