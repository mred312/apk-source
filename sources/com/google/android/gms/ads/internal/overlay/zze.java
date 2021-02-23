package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzacg;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzawq;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbed;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzckq;
import com.google.android.gms.internal.ads.zzcqo;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzdmz;
import com.google.android.gms.internal.ads.zzdrz;
import com.google.android.gms.internal.ads.zzduw;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzsu;
import com.google.android.gms.internal.ads.zzts;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzwq;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zze extends zzari implements zzz {
    @VisibleForTesting
    private static final int zzdqh = Color.argb(0, 0, 0, 0);
    protected final Activity zzaap;
    @VisibleForTesting
    private boolean zzbou = false;
    @VisibleForTesting
    zzbdv zzdii;
    @VisibleForTesting
    AdOverlayInfoParcel zzdqi;
    @VisibleForTesting
    private zzk zzdqj;
    @VisibleForTesting
    private zzr zzdqk;
    @VisibleForTesting
    private boolean zzdql = false;
    @VisibleForTesting
    private FrameLayout zzdqm;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdqn;
    @VisibleForTesting
    private boolean zzdqo = false;
    @VisibleForTesting
    private zzh zzdqp;
    @VisibleForTesting
    private boolean zzdqq = false;
    @VisibleForTesting
    zzl zzdqr = zzl.BACK_BUTTON;
    private final Object zzdqs = new Object();
    private Runnable zzdqt;
    private boolean zzdqu;
    private boolean zzdqv;
    private boolean zzdqw = false;
    private boolean zzdqx = false;
    private boolean zzdqy = true;

    public zze(Activity activity) {
        this.zzaap = activity;
    }

    private final void zzaj(boolean z) {
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcub)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = z ? intValue : 0;
        zzq.paddingRight = z ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        this.zzdqk = new zzr(this.zzaap, zzq, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdqi.zzdro);
        this.zzdqp.addView(this.zzdqk, layoutParams);
    }

    private final void zzak(boolean z) {
        if (!this.zzdqv) {
            this.zzaap.requestWindowFeature(1);
        }
        Window window = this.zzaap.getWindow();
        if (window != null) {
            zzbdv zzbdv = this.zzdqi.zzdii;
            zzbfg zzacs = zzbdv != null ? zzbdv.zzacs() : null;
            boolean z2 = false;
            boolean z3 = zzacs != null && zzacs.zzaby();
            this.zzdqq = false;
            if (z3) {
                int i = this.zzdqi.orientation;
                zzp.zzks();
                if (i == 6) {
                    if (this.zzaap.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdqq = z2;
                } else {
                    int i2 = this.zzdqi.orientation;
                    zzp.zzks();
                    if (i2 == 7) {
                        if (this.zzaap.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.zzdqq = z2;
                    }
                }
            }
            boolean z4 = this.zzdqq;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzaza.zzeb(sb.toString());
            setRequestedOrientation(this.zzdqi.orientation);
            zzp.zzks();
            window.setFlags(16777216, 16777216);
            zzaza.zzeb("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzbou) {
                this.zzdqp.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.zzdqp.setBackgroundColor(zzdqh);
            }
            this.zzaap.setContentView(this.zzdqp);
            this.zzdqv = true;
            if (z) {
                try {
                    zzp.zzkr();
                    Activity activity = this.zzaap;
                    zzbdv zzbdv2 = this.zzdqi.zzdii;
                    zzbfn zzacq = zzbdv2 != null ? zzbdv2.zzacq() : null;
                    zzbdv zzbdv3 = this.zzdqi.zzdii;
                    String zzacr = zzbdv3 != null ? zzbdv3.zzacr() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqi;
                    zzazh zzazh = adOverlayInfoParcel.zzbpd;
                    zzbdv zzbdv4 = adOverlayInfoParcel.zzdii;
                    zzbdv zza = zzbed.zza(activity, zzacq, zzacr, true, z3, (zzef) null, (zzacg) null, zzazh, (zzabs) null, (zzk) null, zzbdv4 != null ? zzbdv4.zzaak() : null, zzts.zzne(), (zzsu) null, false, (zzdmu) null, (zzdmz) null);
                    this.zzdii = zza;
                    zzbfg zzacs2 = zza.zzacs();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdqi;
                    zzagy zzagy = adOverlayInfoParcel2.zzdfr;
                    zzaha zzaha = adOverlayInfoParcel2.zzdfs;
                    zzu zzu = adOverlayInfoParcel2.zzdrq;
                    zzbdv zzbdv5 = adOverlayInfoParcel2.zzdii;
                    zzacs2.zza((zzva) null, zzagy, (zzp) null, zzaha, zzu, true, (zzahu) null, zzbdv5 != null ? zzbdv5.zzacs().zzabx() : null, (zzaqx) null, (zzawq) null, (zzcqo) null, (zzdrz) null, (zzckq) null);
                    this.zzdii.zzacs().zza((zzbfj) new zzd(this));
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzdqi;
                    String str = adOverlayInfoParcel3.url;
                    if (str != null) {
                        this.zzdii.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel3.zzdrp;
                        if (str2 != null) {
                            this.zzdii.loadDataWithBaseURL(adOverlayInfoParcel3.zzdrn, str2, "text/html", Key.STRING_CHARSET_NAME, (String) null);
                        } else {
                            throw new zzi("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzbdv zzbdv6 = this.zzdqi.zzdii;
                    if (zzbdv6 != null) {
                        zzbdv6.zzb(this);
                    }
                } catch (Exception e) {
                    zzaza.zzc("Error obtaining webview.", e);
                    throw new zzi("Could not obtain webview for the overlay.");
                }
            } else {
                zzbdv zzbdv7 = this.zzdqi.zzdii;
                this.zzdii = zzbdv7;
                zzbdv7.zzbx(this.zzaap);
            }
            this.zzdii.zza(this);
            zzbdv zzbdv8 = this.zzdqi.zzdii;
            if (zzbdv8 != null) {
                zzc(zzbdv8.zzacw(), this.zzdqp);
            }
            ViewParent parent = this.zzdii.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzdii.getView());
            }
            if (this.zzbou) {
                this.zzdii.zzade();
            }
            zzbdv zzbdv9 = this.zzdii;
            Activity activity2 = this.zzaap;
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzdqi;
            zzbdv9.zza((ViewGroup) null, activity2, adOverlayInfoParcel4.zzdrn, adOverlayInfoParcel4.zzdrp);
            this.zzdqp.addView(this.zzdii.getView(), -1, -1);
            if (!z && !this.zzdqq) {
                zzvj();
            }
            zzaj(z3);
            if (this.zzdii.zzacu()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new zzi("Invalid activity, no window available.");
    }

    private static void zzc(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzp.zzlf().zza(iObjectWrapper, view);
        }
    }

    private final void zzvg() {
        if (this.zzaap.isFinishing() && !this.zzdqw) {
            this.zzdqw = true;
            if (this.zzdii != null) {
                this.zzdii.zzdv(this.zzdqr.zzvn());
                synchronized (this.zzdqs) {
                    if (!this.zzdqu && this.zzdii.zzada()) {
                        zzg zzg = new zzg(this);
                        this.zzdqt = zzg;
                        zzm.zzedd.postDelayed(zzg, ((Long) zzwq.zzqe().zzd(zzabf.zzcot)).longValue());
                        return;
                    }
                }
            }
            zzvh();
        }
    }

    private final void zzvj() {
        this.zzdii.zzvj();
    }

    public final void close() {
        this.zzdqr = zzl.CUSTOM_CLOSE;
        this.zzaap.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.zzdqr = zzl.BACK_BUTTON;
    }

    public void onCreate(Bundle bundle) {
        zzva zzva;
        this.zzaap.requestWindowFeature(1);
        this.zzdqo = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(this.zzaap.getIntent());
            this.zzdqi = zzd;
            if (zzd != null) {
                if (zzd.zzbpd.zzegm > 7500000) {
                    this.zzdqr = zzl.OTHER;
                }
                if (this.zzaap.getIntent() != null) {
                    this.zzdqy = this.zzaap.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                zzi zzi = this.zzdqi.zzdrt;
                if (zzi != null) {
                    this.zzbou = zzi.zzbou;
                } else {
                    this.zzbou = false;
                }
                if (this.zzbou && zzi.zzboz != -1) {
                    new zzj(this).zzxl();
                }
                if (bundle == null) {
                    zzp zzp = this.zzdqi.zzdrm;
                    if (zzp != null && this.zzdqy) {
                        zzp.zzux();
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqi;
                    if (!(adOverlayInfoParcel.zzdrr == 1 || (zzva = adOverlayInfoParcel.zzcgp) == null)) {
                        zzva.onAdClicked();
                    }
                }
                Activity activity = this.zzaap;
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdqi;
                zzh zzh = new zzh(activity, adOverlayInfoParcel2.zzdrs, adOverlayInfoParcel2.zzbpd.zzbrf);
                this.zzdqp = zzh;
                zzh.setId(1000);
                zzp.zzks().zzi(this.zzaap);
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzdqi;
                int i = adOverlayInfoParcel3.zzdrr;
                if (i == 1) {
                    zzak(false);
                } else if (i == 2) {
                    this.zzdqj = new zzk(adOverlayInfoParcel3.zzdii);
                    zzak(false);
                } else if (i == 3) {
                    zzak(true);
                } else {
                    throw new zzi("Could not determine ad overlay type.");
                }
            } else {
                throw new zzi("Could not get info for ad overlay.");
            }
        } catch (zzi e) {
            zzaza.zzfa(e.getMessage());
            this.zzdqr = zzl.OTHER;
            this.zzaap.finish();
        }
    }

    public final void onDestroy() {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            try {
                this.zzdqp.removeView(zzbdv.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzvg();
    }

    public final void onPause() {
        zzvc();
        zzp zzp = this.zzdqi.zzdrm;
        if (zzp != null) {
            zzp.onPause();
        }
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue() && this.zzdii != null && (!this.zzaap.isFinishing() || this.zzdqj == null)) {
            zzp.zzks();
            zzu.zza(this.zzdii);
        }
        zzvg();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        zzp zzp = this.zzdqi.zzdrm;
        if (zzp != null) {
            zzp.onResume();
        }
        zza(this.zzaap.getResources().getConfiguration());
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue()) {
            zzbdv zzbdv = this.zzdii;
            if (zzbdv == null || zzbdv.isDestroyed()) {
                zzaza.zzfa("The webview does not exist. Ignoring action.");
                return;
            }
            zzp.zzks();
            zzu.zzb(this.zzdii);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdqo);
    }

    public final void onStart() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue()) {
            zzbdv zzbdv = this.zzdii;
            if (zzbdv == null || zzbdv.isDestroyed()) {
                zzaza.zzfa("The webview does not exist. Ignoring action.");
                return;
            }
            zzp.zzks();
            zzu.zzb(this.zzdii);
        }
    }

    public final void onStop() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue() && this.zzdii != null && (!this.zzaap.isFinishing() || this.zzdqj == null)) {
            zzp.zzks();
            zzu.zza(this.zzdii);
        }
        zzvg();
    }

    public final void onUserLeaveHint() {
        zzp zzp = this.zzdqi.zzdrm;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaap.getApplicationInfo().targetSdkVersion >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwi)).intValue()) {
            if (this.zzaap.getApplicationInfo().targetSdkVersion <= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwj)).intValue()) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwk)).intValue()) {
                    if (i2 <= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwl)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaap.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzp.zzku().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzdqi).zzdrt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcou
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdqi
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzi r0 = r0.zzdrt
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzbpb
            if (r0 == 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcov
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdqi
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzi r3 = r3.zzdrt
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzbpc
            if (r3 == 0) goto L_0x0043
            r3 = 1
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzaqu r7 = new com.google.android.gms.internal.ads.zzaqu
            com.google.android.gms.internal.ads.zzbdv r4 = r6.zzdii
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzdt(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzr r7 = r6.zzdqk
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r7.zzal(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zze.zza(boolean, boolean):void");
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzdp() {
        this.zzdqv = true;
    }

    public final void zzvc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqi;
        if (adOverlayInfoParcel != null && this.zzdql) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdqm != null) {
            this.zzaap.setContentView(this.zzdqp);
            this.zzdqv = true;
            this.zzdqm.removeAllViews();
            this.zzdqm = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdqn;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdqn = null;
        }
        this.zzdql = false;
    }

    public final void zzvd() {
        this.zzdqr = zzl.CLOSE_BUTTON;
        this.zzaap.finish();
    }

    public final boolean zzve() {
        this.zzdqr = zzl.BACK_BUTTON;
        zzbdv zzbdv = this.zzdii;
        if (zzbdv == null) {
            return true;
        }
        boolean zzacz = zzbdv.zzacz();
        if (!zzacz) {
            this.zzdii.zza("onbackblocked", Collections.emptyMap());
        }
        return zzacz;
    }

    public final void zzvf() {
        this.zzdqp.removeView(this.zzdqk);
        zzaj(true);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzvh() {
        zzbdv zzbdv;
        zzp zzp;
        if (!this.zzdqx) {
            this.zzdqx = true;
            zzbdv zzbdv2 = this.zzdii;
            if (zzbdv2 != null) {
                this.zzdqp.removeView(zzbdv2.getView());
                zzk zzk = this.zzdqj;
                if (zzk != null) {
                    this.zzdii.zzbx(zzk.context);
                    this.zzdii.zzaz(false);
                    ViewGroup viewGroup = this.zzdqj.parent;
                    View view = this.zzdii.getView();
                    zzk zzk2 = this.zzdqj;
                    viewGroup.addView(view, zzk2.index, zzk2.zzdrc);
                    this.zzdqj = null;
                } else if (this.zzaap.getApplicationContext() != null) {
                    this.zzdii.zzbx(this.zzaap.getApplicationContext());
                }
                this.zzdii = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqi;
            if (!(adOverlayInfoParcel == null || (zzp = adOverlayInfoParcel.zzdrm) == null)) {
                zzp.zza(this.zzdqr);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdqi;
            if (adOverlayInfoParcel2 != null && (zzbdv = adOverlayInfoParcel2.zzdii) != null) {
                zzc(zzbdv.zzacw(), this.zzdqi.zzdii.getView());
            }
        }
    }

    public final void zzvi() {
        if (this.zzdqq) {
            this.zzdqq = false;
            zzvj();
        }
    }

    public final void zzvk() {
        this.zzdqp.zzdra = true;
    }

    public final void zzvl() {
        synchronized (this.zzdqs) {
            this.zzdqu = true;
            Runnable runnable = this.zzdqt;
            if (runnable != null) {
                zzduw zzduw = zzm.zzedd;
                zzduw.removeCallbacks(runnable);
                zzduw.post(this.zzdqt);
            }
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaap);
        this.zzdqm = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdqm.addView(view, -1, -1);
        this.zzaap.setContentView(this.zzdqm);
        this.zzdqv = true;
        this.zzdqn = customViewCallback;
        this.zzdql = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r1.zzdrt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.res.Configuration r7) {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r1 = r6.zzdqi
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.android.gms.ads.internal.zzi r1 = r1.zzdrt
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.zzbov
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            com.google.android.gms.ads.internal.util.zzu r4 = com.google.android.gms.ads.internal.zzp.zzks()
            android.app.Activity r5 = r6.zzaap
            boolean r7 = r4.zza((android.app.Activity) r5, (android.content.res.Configuration) r7)
            boolean r4 = r6.zzbou
            r5 = 19
            if (r4 == 0) goto L_0x0025
            if (r1 == 0) goto L_0x0037
        L_0x0025:
            if (r7 != 0) goto L_0x0037
            if (r0 < r5) goto L_0x0038
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r7 = r6.zzdqi
            if (r7 == 0) goto L_0x0038
            com.google.android.gms.ads.internal.zzi r7 = r7.zzdrt
            if (r7 == 0) goto L_0x0038
            boolean r7 = r7.zzbpa
            if (r7 == 0) goto L_0x0038
            r3 = 1
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            android.app.Activity r7 = r6.zzaap
            android.view.Window r7 = r7.getWindow()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzcow
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r4.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0064
            if (r0 < r5) goto L_0x0064
            android.view.View r7 = r7.getDecorView()
            r0 = 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0060
            r0 = 5380(0x1504, float:7.539E-42)
            if (r3 == 0) goto L_0x0060
            r0 = 5894(0x1706, float:8.259E-42)
        L_0x0060:
            r7.setSystemUiVisibility(r0)
            return
        L_0x0064:
            r1 = 1024(0x400, float:1.435E-42)
            r4 = 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x007e
            r7.addFlags(r1)
            r7.clearFlags(r4)
            if (r0 < r5) goto L_0x0084
            if (r3 == 0) goto L_0x0084
            android.view.View r7 = r7.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r7.setSystemUiVisibility(r0)
            return
        L_0x007e:
            r7.addFlags(r4)
            r7.clearFlags(r1)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zze.zza(android.content.res.Configuration):void");
    }
}
