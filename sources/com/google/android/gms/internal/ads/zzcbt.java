package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcbt extends zzboc {

    /* renamed from: f */
    private final Executor f14002f;

    /* renamed from: g */
    private final zzcce f14003g;

    /* renamed from: h */
    private final zzccm f14004h;

    /* renamed from: i */
    private final zzcda f14005i;

    /* renamed from: j */
    private final zzcci f14006j;

    /* renamed from: k */
    private final zzccl f14007k;

    /* renamed from: l */
    private final zzeoz<zzcfz> f14008l;

    /* renamed from: m */
    private final zzeoz<zzcfx> f14009m;

    /* renamed from: n */
    private final zzeoz<zzcgg> f14010n;

    /* renamed from: o */
    private final zzeoz<zzcft> f14011o;

    /* renamed from: p */
    private final zzeoz<zzcgb> f14012p;

    /* renamed from: q */
    private zzcdy f14013q;

    /* renamed from: r */
    private boolean f14014r;

    /* renamed from: s */
    private boolean f14015s = false;

    /* renamed from: t */
    private final zzawu f14016t;

    /* renamed from: u */
    private final zzef f14017u;

    /* renamed from: v */
    private final zzazh f14018v;

    /* renamed from: w */
    private final Context f14019w;

    /* renamed from: x */
    private final zzcbz f14020x;

    /* renamed from: y */
    private final zzcyb f14021y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcbt(zzbob zzbob, Executor executor, zzcce zzcce, zzccm zzccm, zzcda zzcda, zzcci zzcci, zzccl zzccl, zzeoz<zzcfz> zzeoz, zzeoz<zzcfx> zzeoz2, zzeoz<zzcgg> zzeoz3, zzeoz<zzcft> zzeoz4, zzeoz<zzcgb> zzeoz5, zzawu zzawu, zzef zzef, zzazh zzazh, Context context, zzcbz zzcbz, zzcyb zzcyb) {
        super(zzbob);
        this.f14002f = executor;
        this.f14003g = zzcce;
        this.f14004h = zzccm;
        this.f14005i = zzcda;
        this.f14006j = zzcci;
        this.f14007k = zzccl;
        this.f14008l = zzeoz;
        this.f14009m = zzeoz2;
        this.f14010n = zzeoz3;
        this.f14011o = zzeoz4;
        this.f14012p = zzeoz5;
        this.f14016t = zzawu;
        this.f14017u = zzef;
        this.f14018v = zzazh;
        this.f14019w = context;
        this.f14020x = zzcbz;
        this.f14021y = zzcyb;
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16575a() {
        this.f14004h.destroy();
        this.f14003g.destroy();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16576b() {
        try {
            int zzanc = this.f14003g.zzanc();
            if (zzanc != 1) {
                if (zzanc != 2) {
                    if (zzanc != 3) {
                        if (zzanc != 6) {
                            if (zzanc != 7) {
                                zzaza.zzey("Wrong native template id!");
                            } else if (this.f14007k.zzanv() != null) {
                                this.f14007k.zzanv().zza(this.f14011o.get());
                            }
                        } else if (this.f14007k.zzant() != null) {
                            zzi("Google", true);
                            this.f14007k.zzant().zza(this.f14010n.get());
                        }
                    } else if (this.f14007k.zzga(this.f14003g.getCustomTemplateId()) != null) {
                        if (this.f14003g.zzanh() != null) {
                            zzi("Google", true);
                        }
                        this.f14007k.zzga(this.f14003g.getCustomTemplateId()).zza(this.f14012p.get());
                    }
                } else if (this.f14007k.zzans() != null) {
                    zzi("Google", true);
                    this.f14007k.zzans().zza(this.f14009m.get());
                }
            } else if (this.f14007k.zzanr() != null) {
                zzi("Google", true);
                this.f14007k.zzanr().zza(this.f14008l.get());
            }
        } catch (RemoteException e) {
            zzaza.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo16577c(boolean z) {
        this.f14004h.zza(this.f14013q.zzaiz(), this.f14013q.zzaoe(), this.f14013q.zzaof(), z);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.f14004h.cancelUnconfirmedClick();
    }

    public final synchronized void destroy() {
        this.f14002f.execute(new C2027ih(this));
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.f14004h.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        zzcdy zzcdy = this.f14013q;
        if (zzcdy == null) {
            zzaza.zzeb("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.f14002f.execute(new C1990hh(this, zzcdy instanceof zzccv));
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.f14004h.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzcdy zzcdy) {
        zzdv zzca;
        this.f14013q = zzcdy;
        this.f14005i.zza(zzcdy);
        this.f14004h.zza(zzcdy.zzaiz(), zzcdy.zzaof(), zzcdy.zzaog(), (View.OnTouchListener) zzcdy, (View.OnClickListener) zzcdy);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcra)).booleanValue() && (zzca = this.f14017u.zzca()) != null) {
            zzca.zzb(zzcdy.zzaiz());
        }
        if (zzcdy.zzaod() != null) {
            zzcdy.zzaod().zza(this.f14016t);
        }
    }

    public final void zzaa(View view) {
        IObjectWrapper zzanj = this.f14003g.zzanj();
        boolean z = this.f14003g.zzani() != null;
        if (this.f14006j.zzamy() && zzanj != null && z && view != null) {
            zzp.zzlf().zza(zzanj, view);
        }
    }

    public final void zzab(View view) {
        IObjectWrapper zzanj = this.f14003g.zzanj();
        if (this.f14006j.zzamy() && zzanj != null && view != null) {
            zzp.zzlf().zzb(zzanj, view);
        }
    }

    @AnyThread
    public final void zzajj() {
        this.f14002f.execute(new C1953gh(this));
        if (this.f14003g.zzanc() != 7) {
            Executor executor = this.f14002f;
            zzccm zzccm = this.f14004h;
            zzccm.getClass();
            executor.execute(C1916fh.m6068a(zzccm));
        }
        super.zzajj();
    }

    public final synchronized void zzamr() {
        if (!this.f14014r) {
            this.f14004h.zzamr();
        }
    }

    public final boolean zzamx() {
        return this.f14006j.zzanp();
    }

    public final boolean zzamy() {
        return this.f14006j.zzamy();
    }

    public final zzcbz zzamz() {
        return this.f14020x;
    }

    public final synchronized void zzb(zzcdy zzcdy) {
        this.f14004h.zza(zzcdy.zzaiz(), zzcdy.zzaoe());
        if (zzcdy.zzaoc() != null) {
            zzcdy.zzaoc().setClickable(false);
            zzcdy.zzaoc().removeAllViews();
        }
        if (zzcdy.zzaod() != null) {
            zzcdy.zzaod().zzb(this.f14016t);
        }
        this.f14013q = null;
    }

    public final synchronized void zzf(Bundle bundle) {
        this.f14004h.zzf(bundle);
    }

    public final synchronized void zzfw(String str) {
        this.f14004h.zzfw(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.f14004h.zzg(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.f14014r) {
            return true;
        }
        boolean zzh = this.f14004h.zzh(bundle);
        this.f14014r = zzh;
        return zzh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(java.lang.String r16, boolean r17) {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.ads.zzcci r1 = r0.f14006j
            boolean r1 = r1.zzamy()
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            com.google.android.gms.internal.ads.zzcce r1 = r0.f14003g
            com.google.android.gms.internal.ads.zzbdv r1 = r1.zzani()
            com.google.android.gms.internal.ads.zzcce r2 = r0.f14003g
            com.google.android.gms.internal.ads.zzbdv r2 = r2.zzanh()
            if (r1 != 0) goto L_0x001b
            if (r2 != 0) goto L_0x001b
            return
        L_0x001b:
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0021
            r5 = 1
            goto L_0x0022
        L_0x0021:
            r5 = 0
        L_0x0022:
            if (r2 == 0) goto L_0x0025
            r3 = 1
        L_0x0025:
            r6 = 0
            if (r5 == 0) goto L_0x002a
        L_0x0028:
            r10 = r6
            goto L_0x0032
        L_0x002a:
            if (r3 == 0) goto L_0x0030
            java.lang.String r6 = "javascript"
            r1 = r2
            goto L_0x0028
        L_0x0030:
            r1 = r6
            r10 = r1
        L_0x0032:
            android.webkit.WebView r5 = r1.getWebView()
            if (r5 != 0) goto L_0x003e
            java.lang.String r1 = "Webview is null in InternalNativeAd"
            com.google.android.gms.internal.ads.zzaza.zzfa(r1)
            return
        L_0x003e:
            com.google.android.gms.internal.ads.zzard r5 = com.google.android.gms.ads.internal.zzp.zzlf()
            android.content.Context r6 = r0.f14019w
            boolean r5 = r5.zzm(r6)
            if (r5 != 0) goto L_0x0050
            java.lang.String r1 = "Failed to initialize omid in InternalNativeAd"
            com.google.android.gms.internal.ads.zzaza.zzfa(r1)
            return
        L_0x0050:
            com.google.android.gms.internal.ads.zzazh r5 = r0.f14018v
            int r6 = r5.zzegl
            int r5 = r5.zzegm
            r7 = 23
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r6)
            java.lang.String r6 = "."
            r8.append(r6)
            r8.append(r5)
            java.lang.String r6 = r8.toString()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabf.zzcum
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r5 = r7.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00af
            if (r3 == 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzare r5 = com.google.android.gms.internal.ads.zzare.VIDEO
            com.google.android.gms.internal.ads.zzarg r7 = com.google.android.gms.internal.ads.zzarg.DEFINED_BY_JAVASCRIPT
        L_0x0084:
            r13 = r5
            r12 = r7
            goto L_0x0098
        L_0x0087:
            com.google.android.gms.internal.ads.zzare r5 = com.google.android.gms.internal.ads.zzare.NATIVE_DISPLAY
            com.google.android.gms.internal.ads.zzcce r7 = r0.f14003g
            int r7 = r7.zzanc()
            r8 = 3
            if (r7 != r8) goto L_0x0095
            com.google.android.gms.internal.ads.zzarg r7 = com.google.android.gms.internal.ads.zzarg.UNSPECIFIED
            goto L_0x0084
        L_0x0095:
            com.google.android.gms.internal.ads.zzarg r7 = com.google.android.gms.internal.ads.zzarg.ONE_PIXEL
            goto L_0x0084
        L_0x0098:
            com.google.android.gms.internal.ads.zzard r5 = com.google.android.gms.ads.internal.zzp.zzlf()
            android.webkit.WebView r7 = r1.getWebView()
            com.google.android.gms.internal.ads.zzdmu r8 = r0.zzeri
            java.lang.String r14 = r8.zzche
            java.lang.String r8 = ""
            java.lang.String r9 = "javascript"
            r11 = r16
            com.google.android.gms.dynamic.IObjectWrapper r5 = r5.zzb(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00c1
        L_0x00af:
            com.google.android.gms.internal.ads.zzard r5 = com.google.android.gms.ads.internal.zzp.zzlf()
            android.webkit.WebView r7 = r1.getWebView()
            java.lang.String r8 = ""
            java.lang.String r9 = "javascript"
            r11 = r16
            com.google.android.gms.dynamic.IObjectWrapper r5 = r5.zza(r6, r7, r8, r9, r10, r11)
        L_0x00c1:
            if (r5 != 0) goto L_0x00c9
            java.lang.String r1 = "Failed to create omid session in InternalNativeAd"
            com.google.android.gms.internal.ads.zzaza.zzfa(r1)
            return
        L_0x00c9:
            com.google.android.gms.internal.ads.zzcce r6 = r0.f14003g
            r6.zzat(r5)
            r1.zzaq(r5)
            if (r3 == 0) goto L_0x00e2
            android.view.View r2 = r2.getView()
            if (r2 == 0) goto L_0x00e0
            com.google.android.gms.internal.ads.zzard r3 = com.google.android.gms.ads.internal.zzp.zzlf()
            r3.zza(r5, r2)
        L_0x00e0:
            r0.f14015s = r4
        L_0x00e2:
            if (r17 == 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzard r2 = com.google.android.gms.ads.internal.zzp.zzlf()
            r2.zzab(r5)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcuo
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0107
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.lang.String r3 = "onSdkLoaded"
            r1.zza(r3, r2)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zzi(java.lang.String, boolean):void");
    }

    public final synchronized void zztg() {
        this.f14004h.zztg();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f14014r     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcda r6 = r2.f14005i     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzcdy r1 = r2.f14013q     // Catch:{ all -> 0x006a }
            r6.zzd(r1)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzccm r6 = r2.f14004h     // Catch:{ all -> 0x006a }
            r6.zzb(r3, r4, r5)     // Catch:{ all -> 0x006a }
            r2.f14014r = r0     // Catch:{ all -> 0x006a }
            monitor-exit(r2)
            return
        L_0x001a:
            if (r6 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzabf.zzcsi     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x006a }
            java.lang.Object r6 = r1.zzd(r6)     // Catch:{ all -> 0x006a }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x006a }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x0068
            if (r4 == 0) goto L_0x0068
            java.util.Set r6 = r4.entrySet()     // Catch:{ all -> 0x006a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x006a }
        L_0x0038:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x006a }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x006a }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x006a }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0038
            boolean r1 = zzz(r1)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzcda r6 = r2.f14005i     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzcdy r1 = r2.f14013q     // Catch:{ all -> 0x006a }
            r6.zzd(r1)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzccm r6 = r2.f14004h     // Catch:{ all -> 0x006a }
            r6.zzb(r3, r4, r5)     // Catch:{ all -> 0x006a }
            r2.f14014r = r0     // Catch:{ all -> 0x006a }
            monitor-exit(r2)
            return
        L_0x0068:
            monitor-exit(r2)
            return
        L_0x006a:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x006e
        L_0x006d:
            throw r3
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(android.view.View r9, android.view.View r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzcda r0 = r8.f14005i     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcdy r1 = r8.f14013q     // Catch:{ all -> 0x0045 }
            r0.zzc(r1)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzccm r2 = r8.f14004h     // Catch:{ all -> 0x0045 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zza((android.view.View) r3, (android.view.View) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r6, (boolean) r7)     // Catch:{ all -> 0x0045 }
            boolean r9 = r8.f14015s     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzabf.zzcsb     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzabb r10 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r10.zzd(r9)     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0045 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzcce r9 = r8.f14003g     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbdv r9 = r9.zzanh()     // Catch:{ all -> 0x0045 }
            if (r9 != 0) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            com.google.android.gms.internal.ads.zzcce r9 = r8.f14003g     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbdv r9 = r9.zzanh()     // Catch:{ all -> 0x0045 }
            java.lang.String r10 = "onSdkAdUserInteractionClick"
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0045 }
            r11.<init>()     // Catch:{ all -> 0x0045 }
            r9.zza(r10, r11)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)
            return
        L_0x0043:
            monitor-exit(r8)
            return
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zza(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.f14004h.zza(view, motionEvent, view2);
    }

    public final synchronized JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.f14004h.zza(view, map, map2);
    }

    public final synchronized void zza(zzage zzage) {
        this.f14004h.zza(zzage);
    }

    public final synchronized void zza(@Nullable zzyd zzyd) {
        this.f14004h.zza(zzyd);
    }

    public final synchronized void zza(zzxz zzxz) {
        this.f14004h.zza(zzxz);
    }

    public final synchronized void zza(zzym zzym) {
        this.f14021y.zzc(zzym);
    }
}
