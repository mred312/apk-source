package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehk;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehh<T_WRAPPER extends zzehk<T_ENGINE>, T_ENGINE> {

    /* renamed from: d */
    private static final Logger f16169d = Logger.getLogger(zzehh.class.getName());

    /* renamed from: e */
    private static final List<Provider> f16170e;
    public static final zzehh<zzehj, Cipher> zzihd = new zzehh<>(new zzehj());
    public static final zzehh<zzehn, Mac> zzihe = new zzehh<>(new zzehn());
    public static final zzehh<zzehm, KeyAgreement> zzihh = new zzehh<>(new zzehm());
    public static final zzehh<zzeho, KeyPairGenerator> zzihi = new zzehh<>(new zzeho());
    public static final zzehh<zzehl, KeyFactory> zzihj = new zzehh<>(new zzehl());

    /* renamed from: a */
    private T_WRAPPER f16171a;

    /* renamed from: b */
    private List<Provider> f16172b = f16170e;

    /* renamed from: c */
    private boolean f16173c = true;

    static {
        if (zzehz.zzbfe()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f16169d.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            f16170e = arrayList;
        } else {
            f16170e = new ArrayList();
        }
        new zzehp();
        new zzehq();
    }

    private zzehh(T_WRAPPER t_wrapper) {
        this.f16171a = t_wrapper;
    }

    public final T_ENGINE zzhq(String str) {
        Exception exc = null;
        for (Provider zza : this.f16172b) {
            try {
                return this.f16171a.zza(str, zza);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.f16173c) {
            return this.f16171a.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
