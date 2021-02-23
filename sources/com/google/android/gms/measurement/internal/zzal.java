package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzal extends C3059n4 {

    /* renamed from: b */
    private long f18504b;

    /* renamed from: c */
    private String f18505c;

    /* renamed from: d */
    private Boolean f18506d;

    /* renamed from: e */
    private AccountManager f18507e;

    /* renamed from: f */
    private Boolean f18508f;

    /* renamed from: g */
    private long f18509g;

    zzal(zzfv zzfv) {
        super(zzfv);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final long mo20233b() {
        zzc();
        return this.f18509g;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: c */
    public final void mo20234c() {
        zzc();
        this.f18508f = null;
        this.f18509g = 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: d */
    public final boolean mo20235d() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        zzc();
        long currentTimeMillis = zzl().currentTimeMillis();
        if (currentTimeMillis - this.f18509g > 86400000) {
            this.f18508f = null;
        }
        Boolean bool3 = this.f18508f;
        if (bool3 != null) {
            return bool3.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(zzm(), "android.permission.GET_ACCOUNTS") != 0) {
            zzq().zzi().zza("Permission error checking for dasher/unicorn accounts");
            this.f18509g = currentTimeMillis;
            this.f18508f = bool2;
            return false;
        }
        if (this.f18507e == null) {
            this.f18507e = AccountManager.get(zzm());
        }
        try {
            Account[] result = this.f18507e.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.f18507e.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.f18508f = bool;
                    this.f18509g = currentTimeMillis;
                    return true;
                }
                this.f18509g = currentTimeMillis;
                this.f18508f = bool2;
                return false;
            }
            this.f18508f = bool;
            this.f18509g = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            zzq().zzf().zza("Exception checking account types", e);
        }
    }

    public final boolean zza(Context context) {
        if (this.f18506d == null) {
            this.f18506d = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f18506d = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f18506d.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        Calendar instance = Calendar.getInstance();
        this.f18504b = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f18505c = sb.toString();
        return false;
    }

    public final long zze() {
        zzaa();
        return this.f18504b;
    }

    public final String zzf() {
        zzaa();
        return this.f18505c;
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
