package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzts {

    /* renamed from: a */
    private final zztx f17006a;
    @GuardedBy("this")

    /* renamed from: b */
    private final zzue.zzi.zza f17007b;

    /* renamed from: c */
    private final boolean f17008c;

    public zzts(zztx zztx) {
        this.f17007b = zzue.zzi.zzoe();
        this.f17006a = zztx;
        this.f17008c = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue();
    }

    /* renamed from: a */
    private final synchronized void m9114a(zztu.zza.C3991zza zza) {
        this.f17007b.zzoh().zzb((Iterable<? extends Long>) m9117d());
        this.f17006a.zzf(((zzue.zzi) ((zzekh) this.f17007b.zzbhv())).toByteArray()).zzbv(zza.zzv()).log();
        String valueOf = String.valueOf(Integer.toString(zza.zzv(), 10));
        zzd.zzee(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    /* renamed from: b */
    private final synchronized void m9115b(zztu.zza.C3991zza zza) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(m9116c(zza).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzd.zzee("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzd.zzee("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzd.zzee("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zzd.zzee("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zzd.zzee("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    /* renamed from: c */
    private final synchronized String m9116c(zztu.zza.C3991zza zza) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.f17007b.zzoa(), Long.valueOf(zzp.zzkx().elapsedRealtime()), Integer.valueOf(zza.zzv()), Base64.encodeToString(((zzue.zzi) ((zzekh) this.f17007b.zzbhv())).toByteArray(), 3)});
    }

    /* renamed from: d */
    private static List<Long> m9117d() {
        List<String> zzrm = zzabf.zzrm();
        ArrayList arrayList = new ArrayList();
        for (String split : zzrm) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zzd.zzee("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public static zzts zzne() {
        return new zzts();
    }

    public final synchronized void zza(zztu.zza.C3991zza zza) {
        if (this.f17008c) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcud)).booleanValue()) {
                m9115b(zza);
            } else {
                m9114a(zza);
            }
        }
    }

    private zzts() {
        this.f17007b = zzue.zzi.zzoe();
        this.f17008c = false;
        this.f17006a = new zztx();
    }

    public final synchronized void zza(zztv zztv) {
        if (this.f17008c) {
            try {
                zztv.zza(this.f17007b);
            } catch (NullPointerException e) {
                zzp.zzku().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }
}
