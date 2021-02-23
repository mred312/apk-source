package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.C1656R;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbeq;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzva;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzahz<T extends zzva & zzbdk & zzbeq & zzbex & zzbew & zzbfa & zzbff & zzbfh> implements zzahv<T> {
    @Nullable

    /* renamed from: a */
    private final zza f12468a;
    @Nullable

    /* renamed from: b */
    private final zzckq f12469b;

    /* renamed from: c */
    private final zzaze f12470c = new zzaze();
    @Nullable

    /* renamed from: d */
    private final zzaqk f12471d;
    @Nullable

    /* renamed from: e */
    private final zzcqo f12472e;

    public zzahz(zza zza, zzaqk zzaqk, zzcqo zzcqo, zzckq zzckq) {
        this.f12468a = zza;
        this.f12471d = zzaqk;
        this.f12472e = zzcqo;
        this.f12469b = zzckq;
    }

    @VisibleForTesting
    /* renamed from: a */
    static Uri m7453a(Context context, zzef zzef, Uri uri, View view, @Nullable Activity activity) {
        if (zzef == null) {
            return uri;
        }
        try {
            if (zzef.zzc(uri)) {
                return zzef.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzei unused) {
            return uri;
        } catch (Exception e) {
            zzp.zzku().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    /* renamed from: e */
    private final boolean m7454e(T t, Context context, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        Context context2 = context;
        String str7 = str2;
        zzp.zzkq();
        boolean zzbc = zzm.zzbc(context);
        zzp.zzkq();
        zzbf zzbf = zzm.zzbf(context);
        zzckq zzckq = this.f12469b;
        if (zzckq != null) {
            zzcqy.zza(context2, zzckq, this.f12472e, str7, "offline_open");
        }
        if (zzbc) {
            this.f12472e.zzb(this.f12470c, str7);
            return false;
        }
        zzp.zzkq();
        if (zzm.zzbe(context) && zzbf != null) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcze)).booleanValue()) {
                zzp.zzkq();
                AlertDialog.Builder zzap = zzm.zzap(context);
                Resources resources = zzp.zzku().getResources();
                if (resources == null) {
                    str3 = "Open ad when you're back online.";
                } else {
                    str3 = resources.getString(C1656R.string.offline_opt_in_title);
                }
                AlertDialog.Builder title = zzap.setTitle(str3);
                if (resources == null) {
                    str4 = "We'll send you a notification with a link to the advertiser site.";
                } else {
                    str4 = resources.getString(C1656R.string.offline_opt_in_message);
                }
                AlertDialog.Builder message = title.setMessage(str4);
                if (resources == null) {
                    str5 = "OK";
                } else {
                    str5 = resources.getString(C1656R.string.offline_opt_in_confirm);
                }
                AlertDialog.Builder positiveButton = message.setPositiveButton(str5, new C2344r0(this, context, str2, zzbf, str, resources));
                if (resources == null) {
                    str6 = "No thanks";
                } else {
                    str6 = resources.getString(C1656R.string.offline_opt_in_decline);
                }
                positiveButton.setNegativeButton(str6, new C2422t0(this, str7, context2)).setOnCancelListener(new C2381s0(this, str7, context2));
                zzap.create().show();
                zzckq zzckq2 = this.f12469b;
                if (zzckq2 != null) {
                    zzcqy.zza(context2, zzckq2, this.f12472e, str7, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.f12472e.zzgk(str7);
        if (this.f12469b != null) {
            HashMap hashMap = new HashMap();
            zzp.zzkq();
            if (!zzm.zzbe(context)) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzbf == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
            }
            zzcqy.zza(context, this.f12469b, this.f12472e, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    /* renamed from: f */
    private final void m7455f(boolean z) {
        zzaqk zzaqk = this.f12471d;
        if (zzaqk != null) {
            zzaqk.zzac(z);
        }
    }

    /* renamed from: g */
    private static boolean m7456g(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: h */
    private static int m7457h(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzp.zzks();
            return 7;
        } else if ("l".equalsIgnoreCase(str)) {
            zzp.zzks();
            return 6;
        } else if ("c".equalsIgnoreCase(str)) {
            return zzp.zzks().zzyj();
        } else {
            return -1;
        }
    }

    /* renamed from: i */
    private final void m7458i(int i) {
        zzckq zzckq = this.f12469b;
        if (zzckq != null) {
            zzckq.zzaqg().zzr("action", "cct_action").zzr("cct_open_status", zzach.zzdau[i - 1]).zzaqd();
        }
    }

    @VisibleForTesting
    /* renamed from: j */
    static Uri m7459j(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzaza.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo15346b(Context context, String str, zzbf zzbf, String str2, Resources resources, DialogInterface dialogInterface, int i) {
        String str3;
        if (this.f12469b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "confirm");
            zzcqy.zza(context, this.f12469b, this.f12472e, str, "dialog_click", hashMap);
        }
        boolean z = false;
        try {
            z = zzbf.zzd(ObjectWrapper.wrap(context), str2, str);
        } catch (RemoteException e) {
            zzaza.zzc("Failed to schedule offline notification poster.", e);
        }
        if (!z) {
            this.f12472e.zzgk(str);
            zzckq zzckq = this.f12469b;
            if (zzckq != null) {
                zzcqy.zza(context, zzckq, this.f12472e, str, "offline_notification_worker_not_scheduled");
            }
        }
        zzp.zzkq();
        AlertDialog.Builder zzap = zzm.zzap(context);
        if (resources == null) {
            str3 = "You'll get a notification with the link when you're back online";
        } else {
            str3 = resources.getString(C1656R.string.offline_opt_in_confirmation);
        }
        zzap.setMessage(str3);
        AlertDialog create = zzap.create();
        create.show();
        Timer timer = new Timer();
        timer.schedule(new C2459u0(this, create, timer), 3000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo15347c(String str, Context context, DialogInterface dialogInterface) {
        this.f12472e.zzgk(str);
        if (this.f12469b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcqy.zza(context, this.f12469b, this.f12472e, str, "dialog_click", hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo15348d(String str, Context context, DialogInterface dialogInterface, int i) {
        this.f12472e.zzgk(str);
        if (this.f12469b != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcqy.zza(context, this.f12469b, this.f12472e, str, "dialog_click", hashMap);
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        String str;
        boolean z;
        Map map2 = map;
        zzva zzva = (zzva) obj;
        zzbex zzbex = (zzbex) zzva;
        String zzc = zzaxm.zzc((String) map2.get("u"), zzbex.getContext(), true);
        String str2 = (String) map2.get("a");
        if (str2 == null) {
            zzaza.zzfa("Action missing from an open GMSG.");
            return;
        }
        zza zza = this.f12468a;
        if (zza == null || zza.zzjy()) {
            zzdmu zzabw = ((zzbdk) zzva).zzabw();
            zzdmz zzadk = ((zzbeq) zzva).zzadk();
            if (zzabw == null || zzadk == null) {
                str = "";
                z = false;
            } else {
                z = zzabw.zzhhq;
                str = zzadk.zzbvf;
            }
            if ("expand".equalsIgnoreCase(str2)) {
                if (((zzbew) zzva).zzacx()) {
                    zzaza.zzfa("Cannot expand WebView that is already expanded.");
                    return;
                }
                m7455f(false);
                ((zzbfa) zzva).zzb(m7456g(map), m7457h(map));
            } else if ("webapp".equalsIgnoreCase(str2)) {
                m7455f(false);
                if (zzc != null) {
                    ((zzbfa) zzva).zza(m7456g(map), m7457h(map), zzc);
                } else {
                    ((zzbfa) zzva).zza(m7456g(map), m7457h(map), (String) map2.get("html"), (String) map2.get("baseurl"));
                }
            } else {
                if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
                    if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctp)).booleanValue()) {
                        m7455f(true);
                        if (TextUtils.isEmpty(zzc)) {
                            zzaza.zzfa("Cannot open browser with null or empty url");
                            m7458i(zzach.zzdar);
                            return;
                        }
                        Uri j = m7459j(m7453a(zzbex.getContext(), ((zzbff) zzva).zzacv(), Uri.parse(zzc), ((zzbfh) zzva).getView(), zzbex.zzaaj()));
                        if (!z || this.f12472e == null || !m7454e(zzva, zzbex.getContext(), j.toString(), str)) {
                            try {
                                m7458i(zzp.zzkq().zza((Context) ((zzbex) zzva).zzaaj(), j));
                                return;
                            } catch (ActivityNotFoundException e) {
                                zzaza.zzfa(e.getMessage());
                                m7458i(5);
                                return;
                            } catch (Throwable th) {
                                m7458i(7);
                                throw th;
                            }
                        } else {
                            return;
                        }
                    }
                }
                if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
                    m7455f(true);
                    Intent zze = new zzaic(zzbex.getContext(), ((zzbff) zzva).zzacv(), ((zzbfh) zzva).getView()).zze(map2);
                    if (!z || this.f12472e == null || zze == null || !m7454e(zzva, zzbex.getContext(), zze.getData().toString(), str)) {
                        try {
                            ((zzbfa) zzva).zza(new zzb(zze));
                        } catch (ActivityNotFoundException e2) {
                            zzaza.zzfa(e2.getMessage());
                        }
                    }
                } else if ("open_app".equalsIgnoreCase(str2)) {
                    if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyw)).booleanValue()) {
                        m7455f(true);
                        String str3 = (String) map2.get("p");
                        if (str3 == null) {
                            zzaza.zzfa("Package name missing from open app action.");
                        } else if (!z || this.f12472e == null || !m7454e(zzva, zzbex.getContext(), str3, str)) {
                            PackageManager packageManager = zzbex.getContext().getPackageManager();
                            if (packageManager == null) {
                                zzaza.zzfa("Cannot get package manager from open app action.");
                                return;
                            }
                            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                            if (launchIntentForPackage != null) {
                                ((zzbfa) zzva).zza(new zzb(launchIntentForPackage));
                            }
                        }
                    }
                } else {
                    m7455f(true);
                    String str4 = (String) map2.get("intent_url");
                    Intent intent = null;
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            intent = Intent.parseUri(str4, 0);
                        } catch (URISyntaxException e3) {
                            URISyntaxException uRISyntaxException = e3;
                            String valueOf = String.valueOf(str4);
                            zzaza.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                        }
                    }
                    if (!(intent == null || intent.getData() == null)) {
                        Uri data = intent.getData();
                        if (!Uri.EMPTY.equals(data)) {
                            Uri j2 = m7459j(m7453a(zzbex.getContext(), ((zzbff) zzva).zzacv(), data, ((zzbfh) zzva).getView(), zzbex.zzaaj()));
                            if (!TextUtils.isEmpty(intent.getType())) {
                                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyx)).booleanValue()) {
                                    intent.setDataAndType(j2, intent.getType());
                                }
                            }
                            intent.setData(j2);
                        }
                    }
                    if (intent == null) {
                        if (!TextUtils.isEmpty(zzc)) {
                            zzc = m7459j(m7453a(zzbex.getContext(), ((zzbff) zzva).zzacv(), Uri.parse(zzc), ((zzbfh) zzva).getView(), zzbex.zzaaj())).toString();
                        }
                        String str5 = zzc;
                        if (!z || this.f12472e == null || !m7454e(zzva, zzbex.getContext(), str5, str)) {
                            ((zzbfa) zzva).zza(new zzb((String) map2.get("i"), str5, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e")));
                        }
                    } else if (!z || this.f12472e == null || !m7454e(zzva, zzbex.getContext(), intent.getData().toString(), str)) {
                        ((zzbfa) zzva).zza(new zzb(intent));
                    }
                }
            }
        } else {
            this.f12468a.zzbk(zzc);
        }
    }
}
