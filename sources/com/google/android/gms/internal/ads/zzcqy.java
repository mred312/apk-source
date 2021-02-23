package com.google.android.gms.internal.ads;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.C1656R;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqy extends zzaqz {

    /* renamed from: a */
    private final Context f14723a;

    /* renamed from: b */
    private final zzckq f14724b;

    /* renamed from: c */
    private final zzaze f14725c;

    /* renamed from: d */
    private final zzcqo f14726d;

    public zzcqy(Context context, zzcqo zzcqo, zzaze zzaze, zzckq zzckq) {
        this.f14723a = context;
        this.f14724b = zzckq;
        this.f14725c = zzaze;
        this.f14726d = zzcqo;
    }

    /* renamed from: a */
    private final void m8251a(String str, String str2, Map<String, String> map) {
        zza(this.f14723a, this.f14724b, this.f14726d, str, str2, map);
    }

    public static void zza(Context context, zzckq zzckq, zzcqo zzcqo, String str, String str2) {
        zza(context, zzckq, zzcqo, str, str2, new HashMap());
    }

    public final void zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            zzp.zzkq();
            boolean zzbc = zzm.zzbc(this.f14723a);
            int i = C2632yn.f12222b;
            HashMap hashMap = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (zzbc) {
                    i = C2632yn.f12221a;
                }
                Context context = this.f14723a;
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                    launchIntentForPackage.setData(Uri.parse(stringExtra3));
                }
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            m8251a(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.f14726d.getWritableDatabase();
                if (i == C2632yn.f12221a) {
                    this.f14726d.mo16967e(writableDatabase, this.f14725c, stringExtra2);
                } else {
                    zzcqo.m8245f(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzaza.zzey(sb.toString());
            }
        }
    }

    public final void zzuz() {
        this.f14726d.zza(this.f14725c);
    }

    public static void zza(Context context, zzckq zzckq, zzcqo zzcqo, String str, String str2, Map<String, String> map) {
        zzckp zzaqg = zzckq.zzaqg();
        zzaqg.zzr("gqi", str);
        zzaqg.zzr("action", str2);
        zzp.zzkq();
        zzaqg.zzr("device_connectivity", zzm.zzbc(context) ? "online" : "offline");
        zzaqg.zzr("event_timestamp", String.valueOf(zzp.zzkx().currentTimeMillis()));
        for (Map.Entry next : map.entrySet()) {
            zzaqg.zzr((String) next.getKey(), (String) next.getValue());
        }
        zzcqo.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), str, zzaqg.zzaqe(), zzcql.zzgqc));
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        String str4;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        int i = PlatformVersion.isAtLeastM() ? 1140850688 : 1073741824;
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent service = zzduy.getService(context, 0, intent, i);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent service2 = zzduy.getService(context, 0, intent2, i);
        Resources resources = zzp.zzku().getResources();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (resources == null) {
            str3 = "View the ad you saved when you were offline";
        } else {
            str3 = resources.getString(C1656R.string.offline_notification_title);
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(str3);
        if (resources == null) {
            str4 = "Tap to open ad";
        } else {
            str4 = resources.getString(C1656R.string.offline_notification_text);
        }
        ((NotificationManager) context.getSystemService("notification")).notify(str2, 54321, contentTitle.setContentText(str4).setAutoCancel(true).setDeleteIntent(service2).setContentIntent(service).setSmallIcon(context.getApplicationInfo().icon).build());
        m8251a(str2, "offline_notification_impression", new HashMap());
    }
}
