package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzbcx implements Releasable {
    protected Context mContext;
    protected String zzefk;
    protected WeakReference<zzbbe> zzeog;

    public zzbcx(zzbbe zzbbe) {
        this.mContext = zzbbe.getContext();
        this.zzefk = zzp.zzkq().zzq(this.mContext, zzbbe.zzaao().zzbrf);
        this.zzeog = new WeakReference<>(zzbbe);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m7713c(String str, Map<String, String> map) {
        zzbbe zzbbe = (zzbbe) this.zzeog.get();
        if (zzbbe != null) {
            zzbbe.zza(str, map);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static String m7714d(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 0;
                    break;
                }
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 1;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 3;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 4;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 6;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = 7;
                    break;
                }
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = 8;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 9;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 10;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 1:
            case 3:
                return "network";
            case 6:
            case 7:
                return "policy";
            case 10:
            case 11:
                return "io";
            default:
                return "internal";
        }
    }

    public abstract void abort();

    public void release() {
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        Handler handler = zzayr.zzzz;
        C2018i8 i8Var = r0;
        C2018i8 i8Var2 = new C2018i8(this, str, str2, j, j2, j3, j4, j5, z, i, i2);
        handler.post(i8Var);
    }

    @VisibleForTesting
    public final void zzc(String str, String str2, long j) {
        zzayr.zzzz.post(new C2055j8(this, str, str2, j));
    }

    /* access modifiers changed from: protected */
    public void zzdl(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzdm(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzdn(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzdo(int i) {
    }

    public boolean zze(String str, String[] strArr) {
        return zzfj(str);
    }

    public abstract boolean zzfj(String str);

    /* access modifiers changed from: protected */
    public String zzfk(String str) {
        return zzayr.zzet(str);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzayr.zzzz.post(new C1981h8(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzayr.zzzz.post(new C2092k8(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzayr.zzzz.post(new C2129l8(this, str, str2, str3, str4));
    }
}
