package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbq implements zzdfi<zzdbr> {

    /* renamed from: a */
    private final zzdzc f15192a;

    /* renamed from: b */
    private final Context f15193b;

    public zzdbq(zzdzc zzdzc, Context context) {
        this.f15192a = zzdzc;
        this.f15193b = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdbr mo17077a() {
        double d;
        Intent registerReceiver = this.f15193b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            double intExtra2 = (double) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            double intExtra3 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzdbr(d, z);
    }

    public final zzdyz<zzdbr> zzasm() {
        return this.f15192a.zze(new C1817ct(this));
    }
}
