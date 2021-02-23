package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzaza;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzag {
    private final Context context;
    private Handler handler;
    private int state;
    private String zzbrf;
    private String zzbum;
    private String zzdrs;
    @Nullable
    private String zzdvh;
    private int zzedo;
    private PointF zzedp;
    private PointF zzedq;
    private Runnable zzedr;

    public zzag(Context context2) {
        this.state = 0;
        this.zzedr = new zzaf(this);
        this.context = context2;
        this.zzedo = ViewConfiguration.get(context2).getScaledTouchSlop();
        zzp.zzle().zzyw();
        this.handler = zzp.zzle().getHandler();
    }

    private final boolean zza(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzedp.x - f) < ((float) this.zzedo) && Math.abs(this.zzedp.y - f2) < ((float) this.zzedo) && Math.abs(this.zzedq.x - f3) < ((float) this.zzedo) && Math.abs(this.zzedq.y - f4) < ((float) this.zzedo);
    }

    public final void setAdUnitId(String str) {
        this.zzbum = str;
    }

    public final void showDialog() {
        try {
            if (!(this.context instanceof Activity)) {
                zzaza.zzez("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(zzp.zzla().zzys()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzp.zzla().zzyt() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            int zza = zza((List<String>) arrayList, "Ad Information", true);
            int zza2 = zza((List<String>) arrayList, str, true);
            int zza3 = zza((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context, zzp.zzks().zzym());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzai(this, zza, zza2, zza3));
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            zzd.zza("", e);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzdrs);
        sb.append(",DebugSignal: ");
        sb.append(this.zzdvh);
        sb.append(",AFMA Version: ");
        sb.append(this.zzbrf);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzbum);
        sb.append("}");
        return sb.toString();
    }

    public final void zzad(String str) {
        this.zzbrf = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.view.MotionEvent r11) {
        /*
            r10 = this;
            int r0 = r11.getActionMasked()
            int r1 = r11.getHistorySize()
            int r2 = r11.getPointerCount()
            r3 = 0
            if (r0 != 0) goto L_0x0021
            r10.state = r3
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r11.getX(r3)
            float r11 = r11.getY(r3)
            r0.<init>(r1, r11)
            r10.zzedp = r0
            return
        L_0x0021:
            int r4 = r10.state
            r5 = -1
            if (r4 != r5) goto L_0x0027
            return
        L_0x0027:
            r6 = 5
            r7 = 1
            if (r4 != 0) goto L_0x0056
            if (r0 != r6) goto L_0x0056
            r10.state = r6
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r11.getX(r7)
            float r11 = r11.getY(r7)
            r0.<init>(r1, r11)
            r10.zzedq = r0
            android.os.Handler r11 = r10.handler
            java.lang.Runnable r0 = r10.zzedr
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzctr
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r11.postDelayed(r0, r1)
            return
        L_0x0056:
            if (r4 != r6) goto L_0x00a0
            r4 = 2
            if (r2 == r4) goto L_0x005d
        L_0x005b:
            r3 = 1
            goto L_0x0095
        L_0x005d:
            if (r0 != r4) goto L_0x0095
            r0 = 0
            r2 = 0
        L_0x0061:
            if (r0 >= r1) goto L_0x007d
            float r4 = r11.getHistoricalX(r3, r0)
            float r6 = r11.getHistoricalY(r3, r0)
            float r8 = r11.getHistoricalX(r7, r0)
            float r9 = r11.getHistoricalY(r7, r0)
            boolean r4 = r10.zza(r4, r6, r8, r9)
            if (r4 != 0) goto L_0x007a
            r2 = 1
        L_0x007a:
            int r0 = r0 + 1
            goto L_0x0061
        L_0x007d:
            float r0 = r11.getX()
            float r1 = r11.getY()
            float r3 = r11.getX(r7)
            float r11 = r11.getY(r7)
            boolean r11 = r10.zza(r0, r1, r3, r11)
            if (r11 != 0) goto L_0x0094
            goto L_0x005b
        L_0x0094:
            r3 = r2
        L_0x0095:
            if (r3 == 0) goto L_0x00a0
            r10.state = r5
            android.os.Handler r11 = r10.handler
            java.lang.Runnable r0 = r10.zzedr
            r11.removeCallbacks(r0)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzag.zzd(android.view.MotionEvent):void");
    }

    public final void zzep(String str) {
        this.zzdrs = str;
    }

    public final void zzeq(String str) {
        this.zzdvh = str;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzyp() {
        zzp.zzla().zza(this.context, this.zzbum, this.zzbrf, this.zzdvh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzyq() {
        zzp.zzla().zze(this.context, this.zzbum, this.zzbrf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzyr() {
        this.state = 4;
        showDialog();
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, DialogInterface dialogInterface, int i) {
        zzp.zzkq();
        zzm.zza(this.context, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public zzag(Context context2, String str) {
        this(context2);
        this.zzdrs = str;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L_0x009b
            android.content.Context r1 = r0.context
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto L_0x000e
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzaza.zzez(r1)
            return
        L_0x000e:
            java.lang.String r1 = r0.zzdrs
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0071
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzp.zzkq()
            java.util.Map r1 = com.google.android.gms.ads.internal.util.zzm.zzj((android.net.Uri) r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x003f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0062
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L_0x003f
        L_0x0062:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            java.lang.String r1 = "No debug information"
        L_0x0073:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.context
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            com.google.android.gms.ads.internal.util.zzah r3 = new com.google.android.gms.ads.internal.util.zzah
            r3.<init>(r0, r1)
            java.lang.String r1 = "Share"
            r2.setPositiveButton(r1, r3)
            android.content.DialogInterface$OnClickListener r1 = com.google.android.gms.ads.internal.util.zzak.zzedv
            java.lang.String r3 = "Close"
            r2.setNegativeButton(r3, r1)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L_0x009b:
            if (r5 != r2) goto L_0x00ad
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzaza.zzeb(r1)
            com.google.android.gms.internal.ads.zzdzc r1 = com.google.android.gms.internal.ads.zzazj.zzegp
            com.google.android.gms.ads.internal.util.zzaj r2 = new com.google.android.gms.ads.internal.util.zzaj
            r2.<init>(r0)
            r1.execute(r2)
            return
        L_0x00ad:
            if (r5 != r3) goto L_0x00be
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzaza.zzeb(r1)
            com.google.android.gms.internal.ads.zzdzc r1 = com.google.android.gms.internal.ads.zzazj.zzegp
            com.google.android.gms.ads.internal.util.zzam r2 = new com.google.android.gms.ads.internal.util.zzam
            r2.<init>(r0)
            r1.execute(r2)
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzag.zza(int, int, int, android.content.DialogInterface, int):void");
    }
}
