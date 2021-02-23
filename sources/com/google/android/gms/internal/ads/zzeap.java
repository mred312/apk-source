package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefr;
import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeap {

    /* renamed from: a */
    private static final Logger f16106a = Logger.getLogger(zzeap.class.getName());

    /* renamed from: b */
    private static final ConcurrentMap<String, C2697a> f16107b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final ConcurrentMap<String, C2698b> f16108c = new ConcurrentHashMap();

    /* renamed from: d */
    private static final ConcurrentMap<String, Boolean> f16109d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final ConcurrentMap<String, zzdzw<?>> f16110e = new ConcurrentHashMap();

    /* renamed from: f */
    private static final ConcurrentMap<Class<?>, zzeao<?>> f16111f = new ConcurrentHashMap();

    /* renamed from: com.google.android.gms.internal.ads.zzeap$a */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    interface C2697a {
        /* renamed from: b */
        <P> zzdzz<P> mo14292b(Class<P> cls);

        /* renamed from: c */
        Class<?> mo14293c();

        /* renamed from: d */
        zzdzz<?> mo14294d();

        /* renamed from: e */
        Class<?> mo14295e();

        /* renamed from: f */
        Set<Class<?>> mo14296f();
    }

    /* renamed from: com.google.android.gms.internal.ads.zzeap$b */
    /* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
    interface C2698b {
    }

    private zzeap() {
    }

    /* renamed from: a */
    private static <T> T m8617a(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: b */
    private static <P> zzdzz<P> m8618b(String str, Class<P> cls) {
        C2697a g = m8623g(str);
        if (cls == null) {
            return g.mo14294d();
        }
        if (g.mo14296f().contains(cls)) {
            return g.mo14292b(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(g.mo14293c());
        Set<Class<?>> f = g.mo14296f();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : f) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    /* renamed from: c */
    private static <KeyProtoT extends zzels> C2697a m8619c(zzeae<KeyProtoT> zzeae) {
        return new j40(zzeae);
    }

    /* renamed from: d */
    private static <P> P m8620d(String str, zzeiu zzeiu, Class<P> cls) {
        return m8618b(str, cls).zzm(zzeiu);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        return;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m8621e(java.lang.String r8, java.lang.Class<?> r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzeap> r0 = com.google.android.gms.internal.ads.zzeap.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.android.gms.internal.ads.zzeap$a> r1 = f16107b     // Catch:{ all -> 0x0091 }
            boolean r2 = r1.containsKey(r8)     // Catch:{ all -> 0x0091 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0091 }
            com.google.android.gms.internal.ads.zzeap$a r1 = (com.google.android.gms.internal.ads.zzeap.C2697a) r1     // Catch:{ all -> 0x0091 }
            java.lang.Class r2 = r1.mo14293c()     // Catch:{ all -> 0x0091 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0091 }
            if (r2 != 0) goto L_0x0063
            java.util.logging.Logger r10 = f16106a     // Catch:{ all -> 0x0091 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "com.google.crypto.tink.Registry"
            java.lang.String r4 = "ensureKeyManagerInsertable"
            java.lang.String r5 = "Attempted overwrite of a registered key manager for key type "
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0091 }
            int r7 = r6.length()     // Catch:{ all -> 0x0091 }
            if (r7 == 0) goto L_0x0036
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x0091 }
            goto L_0x003c
        L_0x0036:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0091 }
            r6.<init>(r5)     // Catch:{ all -> 0x0091 }
            r5 = r6
        L_0x003c:
            r10.logp(r2, r3, r4, r5)     // Catch:{ all -> 0x0091 }
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0091 }
            r4 = 0
            r3[r4] = r8     // Catch:{ all -> 0x0091 }
            r8 = 1
            java.lang.Class r1 = r1.mo14293c()     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0091 }
            r3[r8] = r1     // Catch:{ all -> 0x0091 }
            r8 = 2
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0091 }
            r3[r8] = r9     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0091 }
            r10.<init>(r8)     // Catch:{ all -> 0x0091 }
            throw r10     // Catch:{ all -> 0x0091 }
        L_0x0063:
            if (r10 == 0) goto L_0x008f
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r9 = f16109d     // Catch:{ all -> 0x0091 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x0091 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0091 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0091 }
            if (r9 != 0) goto L_0x008f
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0091 }
            java.lang.String r10 = "New keys are already disallowed for key type "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0091 }
            int r1 = r8.length()     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0086
            java.lang.String r8 = r10.concat(r8)     // Catch:{ all -> 0x0091 }
            goto L_0x008b
        L_0x0086:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0091 }
            r8.<init>(r10)     // Catch:{ all -> 0x0091 }
        L_0x008b:
            r9.<init>(r8)     // Catch:{ all -> 0x0091 }
            throw r9     // Catch:{ all -> 0x0091 }
        L_0x008f:
            monitor-exit(r0)
            return
        L_0x0091:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeap.m8621e(java.lang.String, java.lang.Class, boolean):void");
    }

    /* renamed from: f */
    private static <KeyProtoT extends zzels> C2698b m8622f(zzeae<KeyProtoT> zzeae) {
        return new l40(zzeae);
    }

    /* renamed from: g */
    private static synchronized C2697a m8623g(String str) {
        C2697a aVar;
        synchronized (zzeap.class) {
            ConcurrentMap<String, C2697a> concurrentMap = f16107b;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            aVar = (C2697a) concurrentMap.get(str);
        }
        return aVar;
    }

    /* renamed from: h */
    private static zzdzz<?> m8624h(String str) {
        return m8623g(str).mo14294d();
    }

    public static synchronized <P> void zza(zzdzz<P> zzdzz, boolean z) {
        synchronized (zzeap.class) {
            if (zzdzz != null) {
                String keyType = zzdzz.getKeyType();
                m8621e(keyType, zzdzz.getClass(), z);
                f16107b.putIfAbsent(keyType, new k40(zzdzz));
                f16109d.put(keyType, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized zzels zzb(zzefn zzefn) {
        zzels zzn;
        synchronized (zzeap.class) {
            zzdzz<?> h = m8624h(zzefn.zzbdf());
            if (((Boolean) f16109d.get(zzefn.zzbdf())).booleanValue()) {
                zzn = h.zzn(zzefn.zzbdg());
            } else {
                String valueOf = String.valueOf(zzefn.zzbdf());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    @Deprecated
    public static zzdzw<?> zzhl(String str) {
        if (str != null) {
            ConcurrentMap<String, zzdzw<?>> concurrentMap = f16110e;
            Locale locale = Locale.US;
            zzdzw<?> zzdzw = (zzdzw) concurrentMap.get(str.toLowerCase(locale));
            if (zzdzw != null) {
                return zzdzw;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(locale).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkpublickeysign") || str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static synchronized <KeyProtoT extends zzels> void zza(zzeae<KeyProtoT> zzeae, boolean z) {
        synchronized (zzeap.class) {
            String keyType = zzeae.getKeyType();
            m8621e(keyType, zzeae.getClass(), true);
            ConcurrentMap<String, C2697a> concurrentMap = f16107b;
            if (!concurrentMap.containsKey(keyType)) {
                concurrentMap.put(keyType, m8619c(zzeae));
                f16108c.put(keyType, m8622f(zzeae));
            }
            f16109d.put(keyType, Boolean.TRUE);
        }
    }

    public static synchronized <KeyProtoT extends zzels, PublicKeyProtoT extends zzels> void zza(zzeaq<KeyProtoT, PublicKeyProtoT> zzeaq, zzeae<PublicKeyProtoT> zzeae, boolean z) {
        Class<?> e;
        synchronized (zzeap.class) {
            String keyType = zzeaq.getKeyType();
            String keyType2 = zzeae.getKeyType();
            m8621e(keyType, zzeaq.getClass(), true);
            m8621e(keyType2, zzeae.getClass(), false);
            if (!keyType.equals(keyType2)) {
                ConcurrentMap<String, C2697a> concurrentMap = f16107b;
                if (concurrentMap.containsKey(keyType) && (e = ((C2697a) concurrentMap.get(keyType)).mo14295e()) != null) {
                    if (!e.equals(zzeae.getClass())) {
                        Logger logger = f16106a;
                        Level level = Level.WARNING;
                        StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                        sb.append("Attempted overwrite of a registered key manager for key type ");
                        sb.append(keyType);
                        sb.append(" with inconsistent public key type ");
                        sb.append(keyType2);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzeaq.getClass().getName(), e.getName(), zzeae.getClass().getName()}));
                    }
                }
                if (!concurrentMap.containsKey(keyType) || ((C2697a) concurrentMap.get(keyType)).mo14295e() == null) {
                    concurrentMap.put(keyType, new m40(zzeaq, zzeae));
                    f16108c.put(keyType, m8622f(zzeaq));
                }
                ConcurrentMap<String, Boolean> concurrentMap2 = f16109d;
                concurrentMap2.put(keyType, Boolean.TRUE);
                if (!concurrentMap.containsKey(keyType2)) {
                    concurrentMap.put(keyType2, m8619c(zzeae));
                }
                concurrentMap2.put(keyType2, Boolean.FALSE);
            } else {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
        }
    }

    public static synchronized <P> void zza(zzeao<P> zzeao) {
        synchronized (zzeap.class) {
            if (zzeao != null) {
                Class<P> zzazr = zzeao.zzazr();
                ConcurrentMap<Class<?>, zzeao<?>> concurrentMap = f16111f;
                if (concurrentMap.containsKey(zzazr)) {
                    zzeao zzeao2 = (zzeao) concurrentMap.get(zzazr);
                    if (!zzeao.getClass().equals(zzeao2.getClass())) {
                        Logger logger = f16106a;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzazr);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
                        sb.append("Attempted overwrite of a registered SetWrapper for type ");
                        sb.append(valueOf);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzazr.getName(), zzeao2.getClass().getName(), zzeao.getClass().getName()}));
                    }
                }
                concurrentMap.put(zzazr, zzeao);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static synchronized zzefh zza(zzefn zzefn) {
        zzefh zzo;
        synchronized (zzeap.class) {
            zzdzz<?> h = m8624h(zzefn.zzbdf());
            if (((Boolean) f16109d.get(zzefn.zzbdf())).booleanValue()) {
                zzo = h.zzo(zzefn.zzbdg());
            } else {
                String valueOf = String.valueOf(zzefn.zzbdf());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static <P> P zza(String str, zzels zzels, Class<P> cls) {
        m8617a(cls);
        return m8618b(str, cls).zza(zzels);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) {
        zzeiu zzt = zzeiu.zzt(bArr);
        m8617a(cls);
        return m8620d(str, zzt, cls);
    }

    public static <P> zzeam<P> zza(zzeaf zzeaf, zzdzz<P> zzdzz, Class<P> cls) {
        m8617a(cls);
        Class cls2 = cls;
        n40.m6519b(zzeaf.mo17427b());
        zzeam<P> zza = zzeam.zza(cls2);
        for (zzefr.zza next : zzeaf.mo17427b().zzbdt()) {
            if (next.zzbab() == zzefl.ENABLED) {
                zzeal<P> zza2 = zza.zza(m8620d(next.zzbdx().zzbdf(), next.zzbdx().zzbdg(), cls2), next);
                if (next.zzbdy() == zzeaf.mo17427b().zzbds()) {
                    zza.zza(zza2);
                }
            }
        }
        return zza;
    }

    public static <P> P zza(zzeam<P> zzeam) {
        zzeao zzeao = (zzeao) f16111f.get(zzeam.zzazr());
        if (zzeao != null) {
            return zzeao.zza(zzeam);
        }
        String valueOf = String.valueOf(zzeam.zzazr().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
    }
}
