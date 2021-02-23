package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C1656R;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqj extends zzaqu {

    /* renamed from: c */
    private final Map<String, String> f12607c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f12608d;

    /* renamed from: e */
    private String f12609e = m7532c("description");

    /* renamed from: f */
    private long f12610f = m7533d("start_ticks");

    /* renamed from: g */
    private long f12611g = m7533d("end_ticks");

    /* renamed from: h */
    private String f12612h = m7532c("summary");

    /* renamed from: i */
    private String f12613i = m7532c(FirebaseAnalytics.Param.LOCATION);

    public zzaqj(zzbdv zzbdv, Map<String, String> map) {
        super(zzbdv, "createCalendarEvent");
        this.f12607c = map;
        this.f12608d = zzbdv.zzaaj();
    }

    /* renamed from: c */
    private final String m7532c(String str) {
        return TextUtils.isEmpty(this.f12607c.get(str)) ? "" : this.f12607c.get(str);
    }

    /* renamed from: d */
    private final long m7533d(String str) {
        String str2 = this.f12607c.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    /* renamed from: a */
    public final Intent mo15624a() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.f12609e);
        data.putExtra("eventLocation", this.f12613i);
        data.putExtra("description", this.f12612h);
        long j = this.f12610f;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.f12611g;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.f12608d == null) {
            zzdt("Activity context is not available.");
            return;
        }
        zzp.zzkq();
        if (!zzm.zzaq(this.f12608d).zzrj()) {
            zzdt("This feature is not available on the device.");
            return;
        }
        zzp.zzkq();
        AlertDialog.Builder zzap = zzm.zzap(this.f12608d);
        Resources resources = zzp.zzku().getResources();
        zzap.setTitle(resources != null ? resources.getString(C1656R.string.f7416s5) : "Create calendar event");
        zzap.setMessage(resources != null ? resources.getString(C1656R.string.f7417s6) : "Allow Ad to create a calendar event?");
        zzap.setPositiveButton(resources != null ? resources.getString(C1656R.string.f7414s3) : AbstractSpiCall.HEADER_ACCEPT, new C2499v3(this));
        zzap.setNegativeButton(resources != null ? resources.getString(C1656R.string.f7415s4) : "Decline", new C2536w3(this));
        zzap.create().show();
    }
}
