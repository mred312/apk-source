package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzait implements zzx {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile zzaii f12482a;

    /* renamed from: b */
    private final Context f12483b;

    public zzait(Context context) {
        this.f12483b = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m7467a() {
        if (this.f12482a != null) {
            this.f12482a.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzy zzc(zzaa<?> zzaa) {
        zzail zzh = zzail.zzh(zzaa);
        long elapsedRealtime = zzp.zzkx().elapsedRealtime();
        try {
            zzazq zzazq = new zzazq();
            this.f12482a = new zzaii(this.f12483b, zzp.zzle().zzyw(), new C1712a1(this, zzazq), new C2646z0(this, zzazq));
            this.f12482a.checkAvailabilityAndConnect();
            C2533w0 w0Var = new C2533w0(this, zzh);
            zzdzc zzdzc = zzazj.zzegp;
            zzdyz zza = zzdyr.zza(zzdyr.zzb(zzazq, w0Var, (Executor) zzdzc), (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzctm)).intValue(), TimeUnit.MILLISECONDS, zzazj.zzegs);
            zza.addListener(new C2570x0(this), zzdzc);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzp.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzd.zzee(sb.toString());
            zzain zzain = (zzain) new zzatg(parcelFileDescriptor).zza(zzain.CREATOR);
            if (zzain == null) {
                return null;
            }
            if (zzain.zzdhj) {
                throw new zzao(zzain.zzcgs);
            } else if (zzain.zzdhh.length != zzain.zzdhi.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    String[] strArr = zzain.zzdhh;
                    if (i >= strArr.length) {
                        return new zzy(zzain.statusCode, zzain.data, (Map<String, String>) hashMap, zzain.zzam, zzain.zzan);
                    }
                    hashMap.put(strArr[i], zzain.zzdhi[i]);
                    i++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(zzp.zzkx().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzd.zzee(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = zzp.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            zzd.zzee(sb3.toString());
            throw th;
        }
    }
}
