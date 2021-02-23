package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.C1656R;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbeg extends FrameLayout implements zzbdv {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbdv f13195a;

    /* renamed from: b */
    private final zzbax f13196b;

    /* renamed from: c */
    private final AtomicBoolean f13197c = new AtomicBoolean();

    public zzbeg(zzbdv zzbdv) {
        super(zzbdv.getContext());
        this.f13195a = zzbdv;
        this.f13196b = new zzbax(zzbdv.zzacn(), this, this);
        if (!zzadj()) {
            addView(zzbdv.getView());
        }
    }

    public final void destroy() {
        IObjectWrapper zzacw = zzacw();
        if (zzacw != null) {
            zzduw zzduw = zzm.zzedd;
            zzduw.post(new C1908f9(zzacw));
            zzduw.postDelayed(new C1871e9(this), (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcuj)).intValue());
            return;
        }
        this.f13195a.destroy();
    }

    public final String getRequestId() {
        return this.f13195a.getRequestId();
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this.f13195a.getWebView();
    }

    public final boolean isDestroyed() {
        return this.f13195a.isDestroyed();
    }

    public final void loadData(String str, String str2, String str3) {
        this.f13195a.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f13195a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.f13195a.loadUrl(str);
    }

    public final void onAdClicked() {
        zzbdv zzbdv = this.f13195a;
        if (zzbdv != null) {
            zzbdv.onAdClicked();
        }
    }

    public final void onPause() {
        this.f13196b.onPause();
        this.f13195a.onPause();
    }

    public final void onResume() {
        this.f13195a.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f13195a.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f13195a.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.f13195a.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f13195a.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f13195a.setWebViewClient(webViewClient);
    }

    public final void zza(String str, Map<String, ?> map) {
        this.f13195a.zza(str, map);
    }

    public final zzbax zzaag() {
        return this.f13196b;
    }

    public final zzbep zzaah() {
        return this.f13195a.zzaah();
    }

    public final zzabq zzaai() {
        return this.f13195a.zzaai();
    }

    public final Activity zzaaj() {
        return this.f13195a.zzaaj();
    }

    public final zzb zzaak() {
        return this.f13195a.zzaak();
    }

    public final String zzaal() {
        return this.f13195a.zzaal();
    }

    public final int zzaam() {
        return this.f13195a.zzaam();
    }

    public final zzabt zzaan() {
        return this.f13195a.zzaan();
    }

    public final zzazh zzaao() {
        return this.f13195a.zzaao();
    }

    public final int zzaap() {
        return getMeasuredHeight();
    }

    public final int zzaaq() {
        return getMeasuredWidth();
    }

    public final void zzaar() {
        this.f13195a.zzaar();
    }

    public final zzdmu zzabw() {
        return this.f13195a.zzabw();
    }

    public final void zzacl() {
        this.f13195a.zzacl();
    }

    public final void zzacm() {
        this.f13195a.zzacm();
    }

    public final Context zzacn() {
        return this.f13195a.zzacn();
    }

    public final zze zzaco() {
        return this.f13195a.zzaco();
    }

    public final zze zzacp() {
        return this.f13195a.zzacp();
    }

    public final zzbfn zzacq() {
        return this.f13195a.zzacq();
    }

    public final String zzacr() {
        return this.f13195a.zzacr();
    }

    public final zzbfg zzacs() {
        return this.f13195a.zzacs();
    }

    public final WebViewClient zzact() {
        return this.f13195a.zzact();
    }

    public final boolean zzacu() {
        return this.f13195a.zzacu();
    }

    public final zzef zzacv() {
        return this.f13195a.zzacv();
    }

    public final IObjectWrapper zzacw() {
        return this.f13195a.zzacw();
    }

    public final boolean zzacx() {
        return this.f13195a.zzacx();
    }

    public final void zzacy() {
        this.f13196b.onDestroy();
        this.f13195a.zzacy();
    }

    public final boolean zzacz() {
        return this.f13195a.zzacz();
    }

    public final boolean zzada() {
        return this.f13195a.zzada();
    }

    public final void zzadb() {
        this.f13195a.zzadb();
    }

    public final void zzadc() {
        this.f13195a.zzadc();
    }

    @Nullable
    public final zzadx zzadd() {
        return this.f13195a.zzadd();
    }

    public final void zzade() {
        setBackgroundColor(0);
        this.f13195a.setBackgroundColor(0);
    }

    public final void zzadf() {
        TextView textView = new TextView(getContext());
        Resources resources = zzp.zzku().getResources();
        textView.setText(resources != null ? resources.getString(C1656R.string.f7418s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final zzsc zzadg() {
        return this.f13195a.zzadg();
    }

    public final boolean zzadh() {
        return this.f13197c.get();
    }

    public final zzsu zzadi() {
        return this.f13195a.zzadi();
    }

    public final boolean zzadj() {
        return this.f13195a.zzadj();
    }

    public final zzdmz zzadk() {
        return this.f13195a.zzadk();
    }

    public final void zzal(boolean z) {
        this.f13195a.zzal(z);
    }

    public final void zzaq(IObjectWrapper iObjectWrapper) {
        this.f13195a.zzaq(iObjectWrapper);
    }

    public final void zzau(boolean z) {
        this.f13195a.zzau(z);
    }

    public final void zzaw(boolean z) {
        this.f13195a.zzaw(z);
    }

    public final void zzaz(boolean z) {
        this.f13195a.zzaz(z);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.f13195a.zzb(str, jSONObject);
    }

    public final void zzba(boolean z) {
        this.f13195a.zzba(z);
    }

    public final void zzbb(boolean z) {
        this.f13195a.zzbb(z);
    }

    public final void zzbx(Context context) {
        this.f13195a.zzbx(context);
    }

    public final boolean zzc(boolean z, int i) {
        if (!this.f13197c.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoe)).booleanValue()) {
            return false;
        }
        if (this.f13195a.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f13195a.getParent()).removeView(this.f13195a.getView());
        }
        return this.f13195a.zzc(z, i);
    }

    public final void zzcy(String str) {
        this.f13195a.zzcy(str);
    }

    public final void zzdq(int i) {
        this.f13195a.zzdq(i);
    }

    public final void zzdv(int i) {
        this.f13195a.zzdv(i);
    }

    public final zzbcx zzff(String str) {
        return this.f13195a.zzff(str);
    }

    public final void zzkm() {
        this.f13195a.zzkm();
    }

    public final void zzkn() {
        this.f13195a.zzkn();
    }

    public final void zzvj() {
        this.f13195a.zzvj();
    }

    public final void zzvk() {
        this.f13195a.zzvk();
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        this.f13195a.zza(str, zzahv);
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        this.f13195a.zzb(str, zzahv);
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        this.f13195a.zza(str, predicate);
    }

    public final void zzb(zze zze) {
        this.f13195a.zzb(zze);
    }

    public final void zza(boolean z, long j) {
        this.f13195a.zza(z, j);
    }

    public final void zzb(String str, String str2, @Nullable String str3) {
        this.f13195a.zzb(str, str2, str3);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.f13195a.zza(str, jSONObject);
    }

    public final void zzb(boolean z, int i) {
        this.f13195a.zzb(z, i);
    }

    public final void zza(zze zze) {
        this.f13195a.zza(zze);
    }

    public final void zza(zzbfn zzbfn) {
        this.f13195a.zza(zzbfn);
    }

    public final void zza(String str, zzbcx zzbcx) {
        this.f13195a.zza(str, zzbcx);
    }

    public final void zza(zzads zzads) {
        this.f13195a.zza(zzads);
    }

    public final void zza(zzsc zzsc) {
        this.f13195a.zza(zzsc);
    }

    public final void zza(zzqv zzqv) {
        this.f13195a.zza(zzqv);
    }

    public final void zza(@Nullable zzadx zzadx) {
        this.f13195a.zza(zzadx);
    }

    public final void zza(zzbep zzbep) {
        this.f13195a.zza(zzbep);
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzb) {
        this.f13195a.zza(zzb);
    }

    public final void zza(boolean z, int i, String str) {
        this.f13195a.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.f13195a.zza(z, i, str, str2);
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.f13195a.zza(this, activity, str, str2);
    }

    public final void zza(zzdmu zzdmu, zzdmz zzdmz) {
        this.f13195a.zza(zzdmu, zzdmz);
    }
}
