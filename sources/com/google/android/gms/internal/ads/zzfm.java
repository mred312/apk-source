package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfm extends zzgl {

    /* renamed from: e */
    private final Activity f16402e;

    /* renamed from: f */
    private final View f16403f;

    public zzfm(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2, View view, Activity activity) {
        super(zzfa, str, str2, zza, i, 62);
        this.f16403f = view;
        this.f16402e = activity;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.f16403f != null) {
            boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqz)).booleanValue();
            Object[] objArr = (Object[]) this.zzabi.invoke((Object) null, new Object[]{this.f16403f, this.f16402e, Boolean.valueOf(booleanValue)});
            synchronized (this.zzaay) {
                this.zzaay.zzai(((Long) objArr[0]).longValue());
                this.zzaay.zzaj(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzaay.zzaa((String) objArr[2]);
                }
            }
        }
    }
}
