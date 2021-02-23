package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaam {

    /* renamed from: a */
    private final Context f12334a;

    public zzaam(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.f12334a = context;
    }

    /* renamed from: a */
    private final boolean m7419a(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        if (!this.f12334a.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean zzrg() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m7419a(intent);
    }

    public final boolean zzrh() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m7419a(intent);
    }

    public final boolean zzri() {
        return ((Boolean) zzbu.zza(this.f12334a, new C1824d())).booleanValue() && Wrappers.packageManager(this.f12334a).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean zzrj() {
        return m7419a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
