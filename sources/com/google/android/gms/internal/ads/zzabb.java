package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzabb implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a */
    private final Object f12341a = new Object();

    /* renamed from: b */
    private final ConditionVariable f12342b = new ConditionVariable();

    /* renamed from: c */
    private volatile boolean f12343c = false;
    @VisibleForTesting

    /* renamed from: d */
    private volatile boolean f12344d = false;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e */
    public SharedPreferences f12345e = null;

    /* renamed from: f */
    private Bundle f12346f = new Bundle();

    /* renamed from: g */
    private Context f12347g;

    /* renamed from: h */
    private JSONObject f12348h = new JSONObject();

    /* renamed from: c */
    private final void m7421c() {
        if (this.f12345e != null) {
            try {
                this.f12348h = new JSONObject((String) zzbu.zza(new C2157m(this)));
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Object mo15160b(zzaaq zzaaq) {
        return zzaaq.zza(this.f12345e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ String mo15161d() {
        return this.f12345e.getString("flag_configuration", "{}");
    }

    public final void initialize(Context context) {
        if (!this.f12343c) {
            synchronized (this.f12341a) {
                if (!this.f12343c) {
                    if (!this.f12344d) {
                        this.f12344d = true;
                    }
                    Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
                    this.f12347g = applicationContext;
                    try {
                        this.f12346f = Wrappers.packageManager(applicationContext).getApplicationInfo(this.f12347g.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (remoteContext == null && context != null) {
                            Context applicationContext2 = context.getApplicationContext();
                            if (applicationContext2 != null) {
                                context = applicationContext2;
                            }
                            remoteContext = context;
                        }
                        if (remoteContext != null) {
                            zzwq.zzqc();
                            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                            this.f12345e = sharedPreferences;
                            if (sharedPreferences != null) {
                                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzado.zza(new C2120l(this));
                            m7421c();
                            this.f12343c = true;
                            this.f12344d = false;
                            this.f12342b.open();
                        }
                    } finally {
                        this.f12344d = false;
                        this.f12342b.open();
                    }
                }
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            m7421c();
        }
    }

    public final <T> T zzd(zzaaq<T> zzaaq) {
        if (!this.f12342b.block(5000)) {
            synchronized (this.f12341a) {
                if (!this.f12344d) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.f12343c || this.f12345e == null) {
            synchronized (this.f12341a) {
                if (this.f12343c) {
                    if (this.f12345e == null) {
                    }
                }
                T zzrk = zzaaq.zzrk();
                return zzrk;
            }
        }
        if (zzaaq.getSource() == 2) {
            Bundle bundle = this.f12346f;
            if (bundle == null) {
                return zzaaq.zzrk();
            }
            return zzaaq.zza(bundle);
        } else if (zzaaq.getSource() != 1 || !this.f12348h.has(zzaaq.getKey())) {
            return zzbu.zza(new C2083k(this, zzaaq));
        } else {
            return zzaaq.zzb(this.f12348h);
        }
    }
}
