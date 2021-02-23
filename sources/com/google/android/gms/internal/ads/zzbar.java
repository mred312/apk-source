package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbar extends FrameLayout implements zzbam {

    /* renamed from: a */
    private final zzbbe f13000a;

    /* renamed from: b */
    private final FrameLayout f13001b;

    /* renamed from: c */
    private final zzabs f13002c;

    /* renamed from: d */
    private final C1869e7 f13003d;

    /* renamed from: e */
    private final long f13004e;
    @Nullable

    /* renamed from: f */
    private zzbap f13005f;

    /* renamed from: g */
    private boolean f13006g;

    /* renamed from: h */
    private boolean f13007h;

    /* renamed from: i */
    private boolean f13008i;

    /* renamed from: j */
    private boolean f13009j;

    /* renamed from: k */
    private long f13010k;

    /* renamed from: l */
    private long f13011l;

    /* renamed from: m */
    private String f13012m;

    /* renamed from: n */
    private String[] f13013n;

    /* renamed from: o */
    private Bitmap f13014o;

    /* renamed from: p */
    private ImageView f13015p;

    /* renamed from: q */
    private boolean f13016q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbar(Context context, zzbbe zzbbe, int i, boolean z, zzabs zzabs, zzbbf zzbbf) {
        super(context);
        Context context2 = context;
        zzabs zzabs2 = zzabs;
        this.f13000a = zzbbe;
        this.f13002c = zzabs2;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f13001b = frameLayout;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcmw)).booleanValue()) {
            frameLayout.setBackgroundResource(17170444);
        }
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbbe.zzaak());
        zzbap zza = zzbbe.zzaak().zzboi.zza(context, zzbbe, i, z, zzabs, zzbbf);
        this.f13005f = zza;
        if (zza != null) {
            frameLayout.addView(zza, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcmn)).booleanValue()) {
                zzzy();
            }
        }
        this.f13015p = new ImageView(context);
        this.f13004e = ((Long) zzwq.zzqe().zzd(zzabf.zzcmr)).longValue();
        boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcmp)).booleanValue();
        this.f13009j = booleanValue;
        if (zzabs2 != null) {
            zzabs2.zzh("spinner_used", booleanValue ? "1" : "0");
        }
        this.f13003d = new C1869e7(this);
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.zza(this);
        }
        if (this.f13005f == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    /* renamed from: b */
    private final boolean m7652b() {
        return this.f13015p.getParent() != null;
    }

    /* renamed from: c */
    private final void m7653c() {
        if (this.f13000a.zzaaj() != null && this.f13007h && !this.f13008i) {
            this.f13000a.zzaaj().getWindow().clearFlags(128);
            this.f13007h = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m7654e(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.f13000a.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbbe zzbbe, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbbe.zza("onVideoEvent", hashMap);
    }

    public static void zzb(zzbbe zzbbe) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzbbe.zza("onVideoEvent", hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo15974d(boolean z) {
        m7654e("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void destroy() {
        this.f13003d.mo13869a();
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.stop();
        }
        m7653c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo15976f() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            long currentPosition = (long) zzbap.getCurrentPosition();
            if (this.f13010k != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue()) {
                    m7654e("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.f13005f.getTotalBytes()), "qoeCachedBytes", String.valueOf(this.f13005f.zzna()), "qoeLoadedBytes", String.valueOf(this.f13005f.zzzo()), "droppedFrames", String.valueOf(this.f13005f.zzzp()), "reportTime", String.valueOf(zzp.zzkx().currentTimeMillis()));
                } else {
                    m7654e("timeupdate", "time", String.valueOf(f));
                }
                this.f13010k = currentPosition;
            }
        }
    }

    public final void finalize() {
        try {
            this.f13003d.mo13869a();
            zzbap zzbap = this.f13005f;
            if (zzbap != null) {
                zzdzc zzdzc = zzazj.zzegt;
                zzbap.getClass();
                zzdzc.execute(C2502v6.m7053a(zzbap));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onPaused() {
        m7654e("pause", new String[0]);
        m7653c();
        this.f13006g = false;
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f13003d.mo13870b();
        } else {
            this.f13003d.mo13869a();
            this.f13011l = this.f13010k;
        }
        zzm.zzedd.post(new C2577x6(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.f13003d.mo13870b();
            z = true;
        } else {
            this.f13003d.mo13869a();
            this.f13011l = this.f13010k;
            z = false;
        }
        zzm.zzedd.post(new C2615y6(this, z));
    }

    public final void pause() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.pause();
        }
    }

    public final void play() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.play();
        }
    }

    public final void seekTo(int i) {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.seekTo(i);
        }
    }

    public final void setVolume(float f) {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.zzeii.setVolume(f);
            zzbap.zzzq();
        }
    }

    public final void zzc(String str, String[] strArr) {
        this.f13012m = str;
        this.f13013n = strArr;
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.f13001b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzdl(int i) {
        this.f13005f.zzdl(i);
    }

    public final void zzdm(int i) {
        this.f13005f.zzdm(i);
    }

    public final void zzdn(int i) {
        this.f13005f.zzdn(i);
    }

    public final void zzdo(int i) {
        this.f13005f.zzdo(i);
    }

    public final void zzdp(int i) {
        this.f13005f.zzdp(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzfb() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null && this.f13011l == 0) {
            m7654e("canplaythrough", "duration", String.valueOf(((float) zzbap.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.f13005f.getVideoWidth()), "videoHeight", String.valueOf(this.f13005f.getVideoHeight()));
        }
    }

    public final void zzhy() {
        if (this.f13005f != null) {
            if (!TextUtils.isEmpty(this.f13012m)) {
                this.f13005f.zzb(this.f13012m, this.f13013n);
            } else {
                m7654e("no_src", new String[0]);
            }
        }
    }

    public final void zzk(int i, int i2) {
        if (this.f13009j) {
            zzaaq zzaaq = zzabf.zzcmq;
            int max = Math.max(i / ((Integer) zzwq.zzqe().zzd(zzaaq)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzwq.zzqe().zzd(zzaaq)).intValue(), 1);
            Bitmap bitmap = this.f13014o;
            if (bitmap == null || bitmap.getWidth() != max || this.f13014o.getHeight() != max2) {
                this.f13014o = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.f13016q = false;
            }
        }
    }

    public final void zzm(String str, @Nullable String str2) {
        m7654e("error", "what", str, "extra", str2);
    }

    public final void zzzr() {
        this.f13003d.mo13870b();
        zzm.zzedd.post(new C2539w6(this));
    }

    public final void zzzs() {
        if (this.f13000a.zzaaj() != null && !this.f13007h) {
            boolean z = (this.f13000a.zzaaj().getWindow().getAttributes().flags & 128) != 0;
            this.f13008i = z;
            if (!z) {
                this.f13000a.zzaaj().getWindow().addFlags(128);
                this.f13007h = true;
            }
        }
        this.f13006g = true;
    }

    public final void zzzt() {
        m7654e("ended", new String[0]);
        m7653c();
    }

    public final void zzzu() {
        if (this.f13016q && this.f13014o != null && !m7652b()) {
            this.f13015p.setImageBitmap(this.f13014o);
            this.f13015p.invalidate();
            this.f13001b.addView(this.f13015p, new FrameLayout.LayoutParams(-1, -1));
            this.f13001b.bringChildToFront(this.f13015p);
        }
        this.f13003d.mo13869a();
        this.f13011l = this.f13010k;
        zzm.zzedd.post(new C2652z6(this));
    }

    public final void zzzv() {
        if (this.f13006g && m7652b()) {
            this.f13001b.removeView(this.f13015p);
        }
        if (this.f13014o != null) {
            long elapsedRealtime = zzp.zzkx().elapsedRealtime();
            if (this.f13005f.getBitmap(this.f13014o) != null) {
                this.f13016q = true;
            }
            long elapsedRealtime2 = zzp.zzkx().elapsedRealtime() - elapsedRealtime;
            if (zzd.zzxn()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzd.zzee(sb.toString());
            }
            if (elapsedRealtime2 > this.f13004e) {
                zzaza.zzfa("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.f13009j = false;
                this.f13014o = null;
                zzabs zzabs = this.f13002c;
                if (zzabs != null) {
                    zzabs.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzzw() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.zzeii.setMuted(true);
            zzbap.zzzq();
        }
    }

    public final void zzzx() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.zzeii.setMuted(false);
            zzbap.zzzq();
        }
    }

    @TargetApi(14)
    public final void zzzy() {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            TextView textView = new TextView(zzbap.getContext());
            String valueOf = String.valueOf(this.f13005f.zzzk());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.f13001b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.f13001b.bringChildToFront(textView);
        }
    }

    public static void zza(zzbbe zzbbe, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzbbe.zza("onVideoEvent", hashMap);
    }

    public final void zza(float f, float f2) {
        zzbap zzbap = this.f13005f;
        if (zzbap != null) {
            zzbap.zza(f, f2);
        }
    }
}
