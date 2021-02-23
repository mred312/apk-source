package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqk extends zzaqu {

    /* renamed from: c */
    private String f12614c = "top-right";

    /* renamed from: d */
    private boolean f12615d = true;

    /* renamed from: e */
    private int f12616e = 0;

    /* renamed from: f */
    private int f12617f = 0;

    /* renamed from: g */
    private int f12618g = -1;

    /* renamed from: h */
    private int f12619h = 0;

    /* renamed from: i */
    private int f12620i = 0;

    /* renamed from: j */
    private int f12621j = -1;

    /* renamed from: k */
    private final Object f12622k = new Object();

    /* renamed from: l */
    private final zzbdv f12623l;

    /* renamed from: m */
    private final Activity f12624m;

    /* renamed from: n */
    private zzbfn f12625n;

    /* renamed from: o */
    private ImageView f12626o;

    /* renamed from: p */
    private LinearLayout f12627p;

    /* renamed from: q */
    private zzaqx f12628q;

    /* renamed from: r */
    private PopupWindow f12629r;

    /* renamed from: s */
    private RelativeLayout f12630s;

    /* renamed from: t */
    private ViewGroup f12631t;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzaqk(zzbdv zzbdv, zzaqx zzaqx) {
        super(zzbdv, "resize");
        this.f12623l = zzbdv;
        this.f12624m = zzbdv.zzaaj();
        this.f12628q = zzaqx;
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.f12622k) {
            this.f12616e = i;
            this.f12617f = i2;
            PopupWindow popupWindow = this.f12629r;
        }
    }

    public final void zzac(boolean z) {
        synchronized (this.f12622k) {
            PopupWindow popupWindow = this.f12629r;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f12630s.removeView(this.f12623l.getView());
                ViewGroup viewGroup = this.f12631t;
                if (viewGroup != null) {
                    viewGroup.removeView(this.f12626o);
                    this.f12631t.addView(this.f12623l.getView());
                    this.f12623l.zza(this.f12625n);
                }
                if (z) {
                    zzdv("default");
                    zzaqx zzaqx = this.f12628q;
                    if (zzaqx != null) {
                        zzaqx.zzva();
                    }
                }
                this.f12629r = null;
                this.f12630s = null;
                this.f12631t = null;
                this.f12627p = null;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d2, code lost:
        r5 = r1.f12616e + r1.f12619h;
        r8 = r1.f12617f + r1.f12620i;
        r15 = r1.f12618g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01de, code lost:
        r8 = (r8 + r15) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e1, code lost:
        r5 = ((r1.f12616e + r1.f12619h) + (r1.f12621j / 2)) - 25;
        r8 = ((r1.f12617f + r1.f12620i) + (r1.f12618g / 2)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f8, code lost:
        r5 = ((r1.f12616e + r1.f12619h) + (r1.f12621j / 2)) - 25;
        r8 = r1.f12617f;
        r15 = r1.f12620i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0208, code lost:
        r5 = r1.f12616e + r1.f12619h;
        r8 = r1.f12617f;
        r15 = r1.f12620i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0211, code lost:
        r8 = r8 + r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0212, code lost:
        if (r5 < 0) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0215, code lost:
        if ((r5 + 50) > r7) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0219, code lost:
        if (r8 < r6[0]) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x021e, code lost:
        if ((r8 + 50) <= r6[1]) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0193, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0194, code lost:
        if (r5 == 0) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0196, code lost:
        if (r5 == 1) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0198, code lost:
        if (r5 == 2) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x019a, code lost:
        if (r5 == 3) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019c, code lost:
        if (r5 == 4) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x019e, code lost:
        if (r5 == 5) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a0, code lost:
        r5 = ((r1.f12616e + r1.f12619h) + r1.f12621j) - 50;
        r8 = r1.f12617f;
        r15 = r1.f12620i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ae, code lost:
        r5 = ((r1.f12616e + r1.f12619h) + r1.f12621j) - 50;
        r8 = r1.f12617f + r1.f12620i;
        r15 = r1.f12618g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01bf, code lost:
        r5 = ((r1.f12616e + r1.f12619h) + (r1.f12621j / 2)) - 25;
        r8 = r1.f12617f + r1.f12620i;
        r15 = r1.f12618g;
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0231 A[Catch:{ RuntimeException -> 0x0452 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0233 A[Catch:{ RuntimeException -> 0x0452 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x028d A[Catch:{ RuntimeException -> 0x0452 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0294 A[Catch:{ RuntimeException -> 0x0452 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.f12622k
            monitor-enter(r2)
            android.app.Activity r3 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbdv r3 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbfn r3 = r3.zzacq()     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbdv r3 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbfn r3 = r3.zzacq()     // Catch:{ all -> 0x04a6 }
            boolean r3 = r3.zzady()     // Catch:{ all -> 0x04a6 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbdv r3 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            boolean r3 = r3.zzacx()     // Catch:{ all -> 0x04a6 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a6 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x04a6 }
            r1.f12621j = r3     // Catch:{ all -> 0x04a6 }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a6 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x04a6 }
            r1.f12618g = r3     // Catch:{ all -> 0x04a6 }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a6 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x04a6 }
            r1.f12619h = r3     // Catch:{ all -> 0x04a6 }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a6 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x04a6 }
            r1.f12620i = r3     // Catch:{ all -> 0x04a6 }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04a6 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04a6 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04a6 }
            r1.f12615d = r3     // Catch:{ all -> 0x04a6 }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04a6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04a6 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04a6 }
            if (r3 != 0) goto L_0x00eb
            r1.f12614c = r0     // Catch:{ all -> 0x04a6 }
        L_0x00eb:
            int r0 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0101:
            android.app.Activity r0 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04a6 }
            if (r0 == 0) goto L_0x049f
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04a6 }
            if (r5 != 0) goto L_0x0111
            goto L_0x049f
        L_0x0111:
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r5 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzm.zzg(r5)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r6 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int[] r6 = com.google.android.gms.ads.internal.util.zzm.zzh(r6)     // Catch:{ all -> 0x04a6 }
            r7 = r5[r4]     // Catch:{ all -> 0x04a6 }
            r5 = r5[r3]     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0229
            if (r8 <= r7) goto L_0x0136
            goto L_0x0229
        L_0x0136:
            int r15 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            if (r15 < r14) goto L_0x0223
            if (r15 <= r5) goto L_0x013e
            goto L_0x0223
        L_0x013e:
            if (r15 != r5) goto L_0x0149
            if (r8 != r7) goto L_0x0149
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.ads.zzaza.zzfa(r5)     // Catch:{ all -> 0x04a6 }
            goto L_0x022e
        L_0x0149:
            boolean r5 = r1.f12615d     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0221
            java.lang.String r5 = r1.f12614c     // Catch:{ all -> 0x04a6 }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04a6 }
            switch(r8) {
                case -1364013995: goto L_0x0189;
                case -1012429441: goto L_0x017f;
                case -655373719: goto L_0x0175;
                case 1163912186: goto L_0x016b;
                case 1288627767: goto L_0x0161;
                case 1755462605: goto L_0x0157;
                default: goto L_0x0156;
            }     // Catch:{ all -> 0x04a6 }
        L_0x0156:
            goto L_0x0193
        L_0x0157:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0193
            r5 = 1
            goto L_0x0194
        L_0x0161:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0193
            r5 = 4
            goto L_0x0194
        L_0x016b:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0193
            r5 = 5
            goto L_0x0194
        L_0x0175:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0193
            r5 = 3
            goto L_0x0194
        L_0x017f:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0193
            r5 = 0
            goto L_0x0194
        L_0x0189:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0193
            r5 = 2
            goto L_0x0194
        L_0x0193:
            r5 = -1
        L_0x0194:
            if (r5 == 0) goto L_0x0208
            if (r5 == r3) goto L_0x01f8
            if (r5 == r13) goto L_0x01e1
            if (r5 == r11) goto L_0x01d2
            if (r5 == r10) goto L_0x01bf
            if (r5 == r9) goto L_0x01ae
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            goto L_0x0211
        L_0x01ae:
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            int r8 = r8 + r15
            int r15 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            goto L_0x01de
        L_0x01bf:
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            int r8 = r8 + r15
            int r15 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            goto L_0x01de
        L_0x01d2:
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            int r8 = r8 + r15
            int r15 = r1.f12618g     // Catch:{ all -> 0x04a6 }
        L_0x01de:
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0212
        L_0x01e1:
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            int r8 = r8 + r15
            int r15 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x0212
        L_0x01f8:
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            goto L_0x0211
        L_0x0208:
            int r5 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r5 = r5 + r8
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
        L_0x0211:
            int r8 = r8 + r15
        L_0x0212:
            if (r5 < 0) goto L_0x022e
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x022e
            r5 = r6[r4]     // Catch:{ all -> 0x04a6 }
            if (r8 < r5) goto L_0x022e
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04a6 }
            if (r8 <= r5) goto L_0x0221
            goto L_0x022e
        L_0x0221:
            r5 = 1
            goto L_0x022f
        L_0x0223:
            java.lang.String r5 = "Height is too small or too large."
            com.google.android.gms.internal.ads.zzaza.zzfa(r5)     // Catch:{ all -> 0x04a6 }
            goto L_0x022e
        L_0x0229:
            java.lang.String r5 = "Width is too small or too large."
            com.google.android.gms.internal.ads.zzaza.zzfa(r5)     // Catch:{ all -> 0x04a6 }
        L_0x022e:
            r5 = 0
        L_0x022f:
            if (r5 != 0) goto L_0x0233
            r5 = 0
            goto L_0x028b
        L_0x0233:
            boolean r5 = r1.f12615d     // Catch:{ all -> 0x04a6 }
            if (r5 == 0) goto L_0x0248
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04a6 }
            int r6 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r7 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04a6 }
            int r6 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r7 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04a6 }
            goto L_0x028b
        L_0x0248:
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r5 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzm.zzg(r5)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r6 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int[] r6 = com.google.android.gms.ads.internal.util.zzm.zzh(r6)     // Catch:{ all -> 0x04a6 }
            r5 = r5[r4]     // Catch:{ all -> 0x04a6 }
            int r7 = r1.f12616e     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12619h     // Catch:{ all -> 0x04a6 }
            int r7 = r7 + r8
            int r8 = r1.f12617f     // Catch:{ all -> 0x04a6 }
            int r15 = r1.f12620i     // Catch:{ all -> 0x04a6 }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x026a
            r7 = 0
            goto L_0x0272
        L_0x026a:
            int r15 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r9 = r7 + r15
            if (r9 <= r5) goto L_0x0272
            int r7 = r5 - r15
        L_0x0272:
            r5 = r6[r4]     // Catch:{ all -> 0x04a6 }
            if (r8 >= r5) goto L_0x0279
            r8 = r6[r4]     // Catch:{ all -> 0x04a6 }
            goto L_0x0285
        L_0x0279:
            int r5 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            int r9 = r8 + r5
            r15 = r6[r3]     // Catch:{ all -> 0x04a6 }
            if (r9 <= r15) goto L_0x0285
            r6 = r6[r3]     // Catch:{ all -> 0x04a6 }
            int r8 = r6 - r5
        L_0x0285:
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04a6 }
            r5[r4] = r7     // Catch:{ all -> 0x04a6 }
            r5[r3] = r8     // Catch:{ all -> 0x04a6 }
        L_0x028b:
            if (r5 != 0) goto L_0x0294
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0294:
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r6 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int r7 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r6 = com.google.android.gms.internal.ads.zzayr.zzc(r6, r7)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r7 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int r8 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            int r7 = com.google.android.gms.internal.ads.zzayr.zzc(r7, r8)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r8 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04a6 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04a6 }
            if (r8 == 0) goto L_0x0498
            boolean r9 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x0498
            r9 = r8
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r15 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            android.view.View r15 = r15.getView()     // Catch:{ all -> 0x04a6 }
            r9.removeView(r15)     // Catch:{ all -> 0x04a6 }
            android.widget.PopupWindow r9 = r1.f12629r     // Catch:{ all -> 0x04a6 }
            if (r9 != 0) goto L_0x02f7
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04a6 }
            r1.f12631t = r8     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r8 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04a6 }
            android.graphics.Bitmap r8 = com.google.android.gms.ads.internal.util.zzm.zzm(r8)     // Catch:{ all -> 0x04a6 }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04a6 }
            android.app.Activity r15 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            r9.<init>(r15)     // Catch:{ all -> 0x04a6 }
            r1.f12626o = r9     // Catch:{ all -> 0x04a6 }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r8 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbfn r8 = r8.zzacq()     // Catch:{ all -> 0x04a6 }
            r1.f12625n = r8     // Catch:{ all -> 0x04a6 }
            android.view.ViewGroup r8 = r1.f12631t     // Catch:{ all -> 0x04a6 }
            android.widget.ImageView r9 = r1.f12626o     // Catch:{ all -> 0x04a6 }
            r8.addView(r9)     // Catch:{ all -> 0x04a6 }
            goto L_0x02fa
        L_0x02f7:
            r9.dismiss()     // Catch:{ all -> 0x04a6 }
        L_0x02fa:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04a6 }
            android.app.Activity r9 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            r8.<init>(r9)     // Catch:{ all -> 0x04a6 }
            r1.f12630s = r8     // Catch:{ all -> 0x04a6 }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04a6 }
            android.widget.RelativeLayout r8 = r1.f12630s     // Catch:{ all -> 0x04a6 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04a6 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04a6 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            android.widget.RelativeLayout r8 = r1.f12630s     // Catch:{ all -> 0x04a6 }
            android.widget.PopupWindow r8 = com.google.android.gms.ads.internal.util.zzm.zza((android.view.View) r8, (int) r6, (int) r7, (boolean) r4)     // Catch:{ all -> 0x04a6 }
            r1.f12629r = r8     // Catch:{ all -> 0x04a6 }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04a6 }
            android.widget.PopupWindow r8 = r1.f12629r     // Catch:{ all -> 0x04a6 }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04a6 }
            android.widget.PopupWindow r8 = r1.f12629r     // Catch:{ all -> 0x04a6 }
            boolean r9 = r1.f12615d     // Catch:{ all -> 0x04a6 }
            if (r9 != 0) goto L_0x032b
            r9 = 1
            goto L_0x032c
        L_0x032b:
            r9 = 0
        L_0x032c:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04a6 }
            android.widget.RelativeLayout r8 = r1.f12630s     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r9 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04a6 }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04a6 }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04a6 }
            android.app.Activity r9 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            r8.<init>(r9)     // Catch:{ all -> 0x04a6 }
            r1.f12627p = r8     // Catch:{ all -> 0x04a6 }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r9 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int r9 = com.google.android.gms.internal.ads.zzayr.zzc(r9, r14)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r15 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int r14 = com.google.android.gms.internal.ads.zzayr.zzc(r15, r14)     // Catch:{ all -> 0x04a6 }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04a6 }
            java.lang.String r9 = r1.f12614c     // Catch:{ all -> 0x04a6 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04a6 }
            switch(r14) {
                case -1364013995: goto L_0x0396;
                case -1012429441: goto L_0x038c;
                case -655373719: goto L_0x0382;
                case 1163912186: goto L_0x0378;
                case 1288627767: goto L_0x036e;
                case 1755462605: goto L_0x0364;
                default: goto L_0x0363;
            }     // Catch:{ all -> 0x04a6 }
        L_0x0363:
            goto L_0x039f
        L_0x0364:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x039f
            r12 = 1
            goto L_0x039f
        L_0x036e:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x039f
            r12 = 4
            goto L_0x039f
        L_0x0378:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x039f
            r12 = 5
            goto L_0x039f
        L_0x0382:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x039f
            r12 = 3
            goto L_0x039f
        L_0x038c:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x039f
            r12 = 0
            goto L_0x039f
        L_0x0396:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x039f
            r12 = 2
        L_0x039f:
            r9 = 9
            r14 = 10
            if (r12 == 0) goto L_0x03df
            r15 = 14
            if (r12 == r3) goto L_0x03d8
            if (r12 == r13) goto L_0x03d2
            r13 = 12
            if (r12 == r11) goto L_0x03cb
            if (r12 == r10) goto L_0x03c4
            r9 = 11
            r10 = 5
            if (r12 == r10) goto L_0x03bd
            r8.addRule(r14)     // Catch:{ all -> 0x04a6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04a6 }
            goto L_0x03e5
        L_0x03bd:
            r8.addRule(r13)     // Catch:{ all -> 0x04a6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04a6 }
            goto L_0x03e5
        L_0x03c4:
            r8.addRule(r13)     // Catch:{ all -> 0x04a6 }
            r8.addRule(r15)     // Catch:{ all -> 0x04a6 }
            goto L_0x03e5
        L_0x03cb:
            r8.addRule(r13)     // Catch:{ all -> 0x04a6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04a6 }
            goto L_0x03e5
        L_0x03d2:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04a6 }
            goto L_0x03e5
        L_0x03d8:
            r8.addRule(r14)     // Catch:{ all -> 0x04a6 }
            r8.addRule(r15)     // Catch:{ all -> 0x04a6 }
            goto L_0x03e5
        L_0x03df:
            r8.addRule(r14)     // Catch:{ all -> 0x04a6 }
            r8.addRule(r9)     // Catch:{ all -> 0x04a6 }
        L_0x03e5:
            android.widget.LinearLayout r9 = r1.f12627p     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.x3 r10 = new com.google.android.gms.internal.ads.x3     // Catch:{ all -> 0x04a6 }
            r10.<init>(r1)     // Catch:{ all -> 0x04a6 }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04a6 }
            android.widget.LinearLayout r9 = r1.f12627p     // Catch:{ all -> 0x04a6 }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04a6 }
            android.widget.RelativeLayout r9 = r1.f12630s     // Catch:{ all -> 0x04a6 }
            android.widget.LinearLayout r10 = r1.f12627p     // Catch:{ all -> 0x04a6 }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04a6 }
            android.widget.PopupWindow r8 = r1.f12629r     // Catch:{ RuntimeException -> 0x0452 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0452 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ RuntimeException -> 0x0452 }
            android.app.Activity r9 = r1.f12624m     // Catch:{ RuntimeException -> 0x0452 }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x0452 }
            int r9 = com.google.android.gms.internal.ads.zzayr.zzc(r9, r10)     // Catch:{ RuntimeException -> 0x0452 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ RuntimeException -> 0x0452 }
            android.app.Activity r10 = r1.f12624m     // Catch:{ RuntimeException -> 0x0452 }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x0452 }
            int r10 = com.google.android.gms.internal.ads.zzayr.zzc(r10, r11)     // Catch:{ RuntimeException -> 0x0452 }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x0452 }
            r0 = r5[r4]     // Catch:{ all -> 0x04a6 }
            r8 = r5[r3]     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzaqx r9 = r1.f12628q     // Catch:{ all -> 0x04a6 }
            if (r9 == 0) goto L_0x042b
            int r10 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r11 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            r9.zzc(r0, r8, r10, r11)     // Catch:{ all -> 0x04a6 }
        L_0x042b:
            com.google.android.gms.internal.ads.zzbdv r0 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbfn r6 = com.google.android.gms.internal.ads.zzbfn.zzq(r6, r7)     // Catch:{ all -> 0x04a6 }
            r0.zza((com.google.android.gms.internal.ads.zzbfn) r6)     // Catch:{ all -> 0x04a6 }
            r0 = r5[r4]     // Catch:{ all -> 0x04a6 }
            r3 = r5[r3]     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x04a6 }
            android.app.Activity r5 = r1.f12624m     // Catch:{ all -> 0x04a6 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzm.zzh(r5)     // Catch:{ all -> 0x04a6 }
            r4 = r5[r4]     // Catch:{ all -> 0x04a6 }
            int r3 = r3 - r4
            int r4 = r1.f12621j     // Catch:{ all -> 0x04a6 }
            int r5 = r1.f12618g     // Catch:{ all -> 0x04a6 }
            r1.zza(r0, r3, r4, r5)     // Catch:{ all -> 0x04a6 }
            java.lang.String r0 = "resized"
            r1.zzdv(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0452:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x04a6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04a6 }
            int r4 = r0.length()     // Catch:{ all -> 0x04a6 }
            if (r4 == 0) goto L_0x0468
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x04a6 }
            goto L_0x046d
        L_0x0468:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x04a6 }
            r0.<init>(r3)     // Catch:{ all -> 0x04a6 }
        L_0x046d:
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            android.widget.RelativeLayout r0 = r1.f12630s     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r3 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04a6 }
            r0.removeView(r3)     // Catch:{ all -> 0x04a6 }
            android.view.ViewGroup r0 = r1.f12631t     // Catch:{ all -> 0x04a6 }
            if (r0 == 0) goto L_0x0496
            android.widget.ImageView r3 = r1.f12626o     // Catch:{ all -> 0x04a6 }
            r0.removeView(r3)     // Catch:{ all -> 0x04a6 }
            android.view.ViewGroup r0 = r1.f12631t     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r3 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04a6 }
            r0.addView(r3)     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbdv r0 = r1.f12623l     // Catch:{ all -> 0x04a6 }
            com.google.android.gms.internal.ads.zzbfn r3 = r1.f12625n     // Catch:{ all -> 0x04a6 }
            r0.zza((com.google.android.gms.internal.ads.zzbfn) r3)     // Catch:{ all -> 0x04a6 }
        L_0x0496:
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x0498:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x049f:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdt(r0)     // Catch:{ all -> 0x04a6 }
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            return
        L_0x04a6:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04a6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqk.zzg(java.util.Map):void");
    }

    public final void zzi(int i, int i2) {
        this.f12616e = i;
        this.f12617f = i2;
    }

    public final boolean zzuy() {
        boolean z;
        synchronized (this.f12622k) {
            z = this.f12629r != null;
        }
        return z;
    }
}
