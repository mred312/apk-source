package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzdy implements zzdv {
    protected static volatile zzfa zzwb;

    /* renamed from: a */
    private double f16083a;

    /* renamed from: b */
    private double f16084b;

    /* renamed from: c */
    private boolean f16085c = false;
    protected MotionEvent zzwt;
    protected LinkedList<MotionEvent> zzwu = new LinkedList<>();
    protected long zzwv = 0;
    protected long zzww = 0;
    protected long zzwx = 0;
    protected long zzwy = 0;
    protected long zzwz = 0;
    protected long zzxa = 0;
    protected long zzxb = 0;
    protected double zzxc;
    protected float zzxf;
    protected float zzxg;
    protected float zzxh;
    protected float zzxi;
    protected boolean zzxk = false;
    protected DisplayMetrics zzxl;

    protected zzdy(Context context) {
        try {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrg)).booleanValue()) {
                C2370rq.m6824f();
            } else {
                bd0.m5860a(zzwb);
            }
            this.zzxl = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private final String m8608a(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        String str2;
        zzdt zzdt;
        int i2;
        int i3;
        int i4;
        int i5;
        Context context2 = context;
        int i6 = i;
        View view2 = view;
        Activity activity2 = activity;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqw)).booleanValue();
        zzcf.zza.C3977zza zza = null;
        if (booleanValue) {
            zzdt = zzwb != null ? zzwb.zzcl() : null;
            str2 = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcrg)).booleanValue() ? "be" : "te";
        } else {
            zzdt = null;
            str2 = null;
        }
        try {
            if (i6 == zzcw.zznm) {
                zza = zzc(context2, view2, activity2);
                this.f16085c = true;
                i5 = 1002;
            } else if (i6 == zzcw.zznl) {
                zza = zzb(context2, view2, activity2);
                i5 = PointerIconCompat.TYPE_TEXT;
            } else {
                zza = zza(context2, (zzby.zza) null);
                i5 = 1000;
            }
            if (booleanValue && zzdt != null) {
                zzdt.zza(i5, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            Exception exc = e;
            if (booleanValue && zzdt != null) {
                if (i6 == zzcw.zznm) {
                    i4 = PointerIconCompat.TYPE_HELP;
                } else if (i6 == zzcw.zznl) {
                    i4 = PointerIconCompat.TYPE_VERTICAL_TEXT;
                } else {
                    i4 = i6 == zzcw.zznk ? 1001 : -1;
                }
                zzdt.zza(i4, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zza != null) {
            try {
                if (((zzcf.zza) ((zzekh) zza.zzbhv())).zzbhz() != 0) {
                    String h = C2370rq.m6826h((zzcf.zza) ((zzekh) zza.zzbhv()), str);
                    if (!booleanValue || zzdt == null) {
                        return h;
                    }
                    if (i6 == zzcw.zznm) {
                        i3 = PointerIconCompat.TYPE_CELL;
                    } else if (i6 == zzcw.zznl) {
                        i3 = PointerIconCompat.TYPE_ALIAS;
                    } else {
                        i3 = i6 == zzcw.zznk ? PointerIconCompat.TYPE_WAIT : -1;
                    }
                    zzdt.zza(i3, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return h;
                }
            } catch (Exception e2) {
                Exception exc2 = e2;
                String num = Integer.toString(7);
                if (!booleanValue || zzdt == null) {
                    return num;
                }
                if (i6 == zzcw.zznm) {
                    i2 = PointerIconCompat.TYPE_CROSSHAIR;
                } else if (i6 == zzcw.zznl) {
                    i2 = PointerIconCompat.TYPE_COPY;
                } else {
                    i2 = i6 == zzcw.zznk ? 1005 : -1;
                }
                zzdt.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis2, str2, exc2);
                return num;
            }
        }
        return Integer.toString(5);
    }

    /* renamed from: b */
    private final void m8609b() {
        this.zzwz = 0;
        this.zzwv = 0;
        this.zzww = 0;
        this.zzwx = 0;
        this.zzwy = 0;
        this.zzxa = 0;
        this.zzxb = 0;
        if (this.zzwu.size() > 0) {
            Iterator it = this.zzwu.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzwu.clear();
        } else {
            MotionEvent motionEvent = this.zzwt;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwt = null;
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr);

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C3977zza zza(Context context, zzby.zza zza);

    public String zza(Context context, View view, Activity activity) {
        return m8608a(context, (String) null, zzcw.zznl, view, activity, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C3977zza zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzfg zzb(MotionEvent motionEvent);

    public String zzb(Context context) {
        if (!zzff.isMainThread()) {
            return m8608a(context, (String) null, zzcw.zznk, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public void zzb(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.C3977zza zzc(Context context, View view, Activity activity);

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public String zza(Context context, String str, View view, Activity activity) {
        return m8608a(context, str, zzcw.zznm, view, activity, (byte[]) null);
    }

    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f16085c) {
            m8609b();
            this.f16085c = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzxc = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.f16083a = (double) motionEvent.getRawX();
            this.f16084b = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = this.f16083a;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.f16084b;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.zzxc += Math.sqrt((d2 * d2) + (d4 * d4));
            this.f16083a = rawX;
            this.f16084b = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzxf = motionEvent.getX();
            this.zzxg = motionEvent.getY();
            this.zzxh = motionEvent.getRawX();
            this.zzxi = motionEvent.getRawY();
            this.zzwv++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzwt = obtain;
            this.zzwu.add(obtain);
            if (this.zzwu.size() > 6) {
                this.zzwu.remove().recycle();
            }
            this.zzwx++;
            this.zzwz = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zzww += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzfg zzb = zzb(motionEvent);
                if ((zzb == null || zzb.zzzr == null || zzb.zzzu == null) ? false : true) {
                    this.zzxa += zzb.zzzr.longValue() + zzb.zzzu.longValue();
                }
                if (!(this.zzxl == null || zzb == null || zzb.zzzs == null || zzb.zzzv == null)) {
                    z = true;
                }
                if (z) {
                    this.zzxb += zzb.zzzs.longValue() + zzb.zzzv.longValue();
                }
            } catch (zzet unused) {
            }
        } else if (action2 == 3) {
            this.zzwy++;
        }
        this.zzxk = true;
    }

    public void zza(int i, int i2, int i3) {
        if (this.zzwt != null) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqu)).booleanValue()) {
                m8609b();
            } else {
                this.zzwt.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxl;
        if (displayMetrics != null) {
            float f = displayMetrics.density;
            this.zzwt = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * f, ((float) i2) * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzwt = null;
        }
        this.zzxk = false;
    }
}
