package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmj;
import com.google.android.gms.internal.measurement.zzny;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzfw extends zzei {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzki f18635a;

    /* renamed from: b */
    private Boolean f18636b;
    @Nullable

    /* renamed from: c */
    private String f18637c;

    public zzfw(zzki zzki) {
        this(zzki, (String) null);
    }

    @VisibleForTesting
    /* renamed from: c */
    private final void m10823c(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.f18635a.zzp().zzf()) {
            runnable.run();
        } else {
            this.f18635a.zzp().zza(runnable);
        }
    }

    @BinderThread
    /* renamed from: d */
    private final void m10824d(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f18636b == null) {
                        if (!"com.google.android.gms".equals(this.f18637c) && !UidVerifier.isGooglePlayServicesUid(this.f18635a.zzm(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.f18635a.zzm()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.f18636b = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.f18636b = Boolean.valueOf(z2);
                    }
                    if (this.f18636b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.f18635a.zzq().zze().zza("Measurement Service called with invalid calling package. appId", zzer.zza(str));
                    throw e;
                }
            }
            if (this.f18637c == null && GooglePlayServicesUtilLight.uidHasPackageName(this.f18635a.zzm(), Binder.getCallingUid(), str)) {
                this.f18637c = str;
            }
            if (!str.equals(this.f18637c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f18635a.zzq().zze().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @BinderThread
    /* renamed from: f */
    private final void m10825f(zzn zzn, boolean z) {
        Preconditions.checkNotNull(zzn);
        m10824d(zzn.zza, false);
        this.f18635a.zzk().mo20555B(zzn.zzb, zzn.zzr, zzn.zzv);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo20383b(zzn zzn, Bundle bundle) {
        this.f18635a.zze().mo19832D(zzn.zza, bundle);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: e */
    public final zzar mo20384e(zzar zzar, zzn zzn) {
        zzam zzam;
        boolean z = false;
        if (!(!"_cmp".equals(zzar.zza) || (zzam = zzar.zzb) == null || zzam.zza() == 0)) {
            String e = zzar.zzb.mo20242e("_cis");
            if ("referrer broadcast".equals(e) || "referrer API".equals(e)) {
                z = true;
            }
        }
        if (!z) {
            return zzar;
        }
        this.f18635a.zzq().zzu().zza("Event has been filtered ", zzar.toString());
        return new zzar("_cmpx", zzar.zzb, zzar.zzc, zzar.zzd);
    }

    @BinderThread
    public final void zza(zzar zzar, zzn zzn) {
        Preconditions.checkNotNull(zzar);
        m10825f(zzn, false);
        m10823c(new C2985f4(this, zzar, zzn));
    }

    @BinderThread
    public final void zzb(zzn zzn) {
        m10825f(zzn, false);
        m10823c(new C3112t3(this, zzn));
    }

    @BinderThread
    public final String zzc(zzn zzn) {
        m10825f(zzn, false);
        return this.f18635a.mo20507P(zzn);
    }

    @BinderThread
    public final void zzd(zzn zzn) {
        m10824d(zzn.zza, false);
        m10823c(new C2965d4(this, zzn));
    }

    @BinderThread
    public final void zze(zzn zzn) {
        if (zzmj.zzb() && this.f18635a.zzb().zza(zzat.zzci)) {
            Preconditions.checkNotEmpty(zzn.zza);
            Preconditions.checkNotNull(zzn.zzw);
            C2955c4 c4Var = new C2955c4(this, zzn);
            Preconditions.checkNotNull(c4Var);
            if (this.f18635a.zzp().zzf()) {
                c4Var.run();
            } else {
                this.f18635a.zzp().zzb((Runnable) c4Var);
            }
        }
    }

    private zzfw(zzki zzki, @Nullable String str) {
        Preconditions.checkNotNull(zzki);
        this.f18635a = zzki;
        this.f18637c = null;
    }

    @BinderThread
    public final void zza(zzar zzar, String str, String str2) {
        Preconditions.checkNotNull(zzar);
        Preconditions.checkNotEmpty(str);
        m10824d(str, true);
        m10823c(new C2975e4(this, zzar, str));
    }

    @BinderThread
    public final byte[] zza(zzar zzar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzar);
        m10824d(str, true);
        this.f18635a.zzq().zzv().zza("Log and bundle. event", this.f18635a.zzj().zza(zzar.zza));
        long nanoTime = this.f18635a.zzl().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f18635a.zzp().zzb(new C3005h4(this, zzar, str)).get();
            if (bArr == null) {
                this.f18635a.zzq().zze().zza("Log and bundle returned null. appId", zzer.zza(str));
                bArr = new byte[0];
            }
            this.f18635a.zzq().zzv().zza("Log and bundle processed. event, size, time_ms", this.f18635a.zzj().zza(zzar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.f18635a.zzl().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f18635a.zzq().zze().zza("Failed to log and bundle. appId, event, error", zzer.zza(str), this.f18635a.zzj().zza(zzar.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzkr zzkr, zzn zzn) {
        Preconditions.checkNotNull(zzkr);
        m10825f(zzn, false);
        m10823c(new C2995g4(this, zzkr, zzn));
    }

    @BinderThread
    public final List<zzkr> zza(zzn zzn, boolean z) {
        m10825f(zzn, false);
        try {
            List<C3134v7> list = (List) this.f18635a.zzp().zza(new C3023j4(this, zzn)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C3134v7 v7Var : list) {
                if (z || !zzkw.m10995S(v7Var.f18417c)) {
                    arrayList.add(new zzkr(v7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f18635a.zzq().zze().zza("Failed to get user properties. appId", zzer.zza(zzn.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzn zzn) {
        m10825f(zzn, false);
        m10823c(new C3014i4(this, zzn));
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        m10823c(new C3041l4(this, str2, str3, str, j));
    }

    @BinderThread
    public final void zza(Bundle bundle, zzn zzn) {
        if (zzny.zzb() && this.f18635a.zzb().zza(zzat.zzbz)) {
            m10825f(zzn, false);
            m10823c(new C3121u3(this, zzn, bundle));
        }
    }

    @BinderThread
    public final void zza(zzw zzw, zzn zzn) {
        Preconditions.checkNotNull(zzw);
        Preconditions.checkNotNull(zzw.zzc);
        m10825f(zzn, false);
        zzw zzw2 = new zzw(zzw);
        zzw2.zza = zzn.zza;
        m10823c(new C3148x3(this, zzw2, zzn));
    }

    @BinderThread
    public final void zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        Preconditions.checkNotNull(zzw.zzc);
        m10824d(zzw.zza, true);
        m10823c(new C3139w3(this, new zzw(zzw)));
    }

    @BinderThread
    public final List<zzkr> zza(String str, String str2, boolean z, zzn zzn) {
        m10825f(zzn, false);
        try {
            List<C3134v7> list = (List) this.f18635a.zzp().zza(new C3166z3(this, zzn, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C3134v7 v7Var : list) {
                if (z || !zzkw.m10995S(v7Var.f18417c)) {
                    arrayList.add(new zzkr(v7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f18635a.zzq().zze().zza("Failed to query user properties. appId", zzer.zza(zzn.zza), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzkr> zza(String str, String str2, String str3, boolean z) {
        m10824d(str, true);
        try {
            List<C3134v7> list = (List) this.f18635a.zzp().zza(new C3157y3(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C3134v7 v7Var : list) {
                if (z || !zzkw.m10995S(v7Var.f18417c)) {
                    arrayList.add(new zzkr(v7Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f18635a.zzq().zze().zza("Failed to get user properties as. appId", zzer.zza(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzw> zza(String str, String str2, zzn zzn) {
        m10825f(zzn, false);
        try {
            return (List) this.f18635a.zzp().zza(new C2945b4(this, zzn, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f18635a.zzq().zze().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzw> zza(String str, String str2, String str3) {
        m10824d(str, true);
        try {
            return (List) this.f18635a.zzp().zza(new C2935a4(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f18635a.zzq().zze().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }
}
