package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Calendar;

/* renamed from: androidx.appcompat.app.f */
/* compiled from: TwilightManager */
class C0190f {

    /* renamed from: d */
    private static C0190f f630d;

    /* renamed from: a */
    private final Context f631a;

    /* renamed from: b */
    private final LocationManager f632b;

    /* renamed from: c */
    private final C0191a f633c = new C0191a();

    /* renamed from: androidx.appcompat.app.f$a */
    /* compiled from: TwilightManager */
    private static class C0191a {

        /* renamed from: a */
        boolean f634a;

        /* renamed from: b */
        long f635b;

        /* renamed from: c */
        long f636c;

        /* renamed from: d */
        long f637d;

        /* renamed from: e */
        long f638e;

        /* renamed from: f */
        long f639f;

        C0191a() {
        }
    }

    @VisibleForTesting
    C0190f(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f631a = context;
        this.f632b = locationManager;
    }

    /* renamed from: a */
    static C0190f m531a(@NonNull Context context) {
        if (f630d == null) {
            Context applicationContext = context.getApplicationContext();
            f630d = new C0190f(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
        }
        return f630d;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m532b() {
        Location location = null;
        Location c = PermissionChecker.checkSelfPermission(this.f631a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m533c("network") : null;
        if (PermissionChecker.checkSelfPermission(this.f631a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m533c("gps");
        }
        return (location == null || c == null) ? location != null ? location : c : location.getTime() > c.getTime() ? location : c;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    /* renamed from: c */
    private Location m533c(String str) {
        try {
            if (this.f632b.isProviderEnabled(str)) {
                return this.f632b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* renamed from: e */
    private boolean m534e() {
        return this.f633c.f639f > System.currentTimeMillis();
    }

    /* renamed from: f */
    private void m535f(@NonNull Location location) {
        long j;
        C0191a aVar = this.f633c;
        long currentTimeMillis = System.currentTimeMillis();
        C0189e b = C0189e.m529b();
        C0189e eVar = b;
        eVar.mo1236a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = b.f627a;
        eVar.mo1236a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b.f629c == 1;
        long j3 = b.f628b;
        long j4 = j2;
        long j5 = b.f627a;
        long j6 = j3;
        boolean z2 = z;
        b.mo1236a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = b.f628b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f634a = z2;
        aVar.f635b = j4;
        aVar.f636c = j6;
        aVar.f637d = j5;
        aVar.f638e = j7;
        aVar.f639f = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo1237d() {
        C0191a aVar = this.f633c;
        if (m534e()) {
            return aVar.f634a;
        }
        Location b = m532b();
        if (b != null) {
            m535f(b);
            return aVar.f634a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
