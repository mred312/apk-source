package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbfk extends MutableContextWrapper {

    /* renamed from: a */
    private Activity f13216a;

    /* renamed from: b */
    private Context f13217b;

    /* renamed from: c */
    private Context f13218c;

    public zzbfk(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Object getSystemService(String str) {
        return this.f13218c.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f13217b = applicationContext;
        this.f13216a = context instanceof Activity ? (Activity) context : null;
        this.f13218c = context;
        super.setBaseContext(applicationContext);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.f13216a;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.f13217b.startActivity(intent);
    }

    public final Activity zzaaj() {
        return this.f13216a;
    }

    public final Context zzacn() {
        return this.f13218c;
    }
}
