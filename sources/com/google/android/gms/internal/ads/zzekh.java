package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import com.google.android.gms.internal.ads.zzekh.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzekh<MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeik<MessageType, BuilderType> {
    private static Map<Object, zzekh<?, ?>> zzinq = new ConcurrentHashMap();
    protected zzeni zzino = zzeni.zzbkg();
    private int zzinp = -1;

    /* renamed from: com.google.android.gms.internal.ads.zzekh$a */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    static final class C2704a implements zzejz<C2704a> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final zzelr zza(zzelr zzelr, zzels zzels) {
            throw new NoSuchMethodError();
        }

        public final zzenw zzbhl() {
            throw new NoSuchMethodError();
        }

        public final zzenz zzbhm() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbhn() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbho() {
            throw new NoSuchMethodError();
        }

        public final int zzv() {
            throw new NoSuchMethodError();
        }

        public final zzelx zza(zzelx zzelx, zzelx zzelx2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzekh<MessageType, BuilderType> implements zzelu {
        protected e90<C2704a> zzinr = e90.m6022p();

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public final e90<C2704a> mo17674i() {
            if (this.zzinr.mo13877b()) {
                this.zzinr = (e90) this.zzinr.clone();
            }
            return this.zzinr;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static class zzc<T extends zzekh<T, ?>> extends zzeip<T> {
        public zzc(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static class zzd<ContainingType extends zzels, Type> extends zzejs<ContainingType, Type> {
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static final class zzf {

        /* renamed from: a */
        private static final /* synthetic */ int[] f16268a = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzinu = 1;
        public static final int zzinv = 2;
        public static final int zzinw = 3;
        public static final int zzinx = 4;
        public static final int zziny = 5;
        public static final int zzinz = 6;
        public static final int zzioa = 7;

        public static int[] zzbih() {
            return (int[]) f16268a.clone();
        }
    }

    /* renamed from: c */
    private static <T extends zzekh<T, ?>> T m8811c(T t, zzejj zzejj, zzeju zzeju) {
        T t2 = (zzekh) t.zza(zzf.zzinx, (Object) null, (Object) null);
        try {
            wa0 a = pa0.m6655b().mo14584a(t2);
            a.mo14194g(t2, x80.m7161N(zzejj), zzeju);
            a.mo14196i(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzeks) {
                throw ((zzeks) e.getCause());
            }
            throw new zzeks(e.getMessage()).zzl(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzeks) {
                throw ((zzeks) e2.getCause());
            }
            throw e2;
        }
    }

    /* renamed from: d */
    private static <T extends zzekh<T, ?>> T m8812d(T t, byte[] bArr, int i, int i2, zzeju zzeju) {
        T t2 = (zzekh) t.zza(zzf.zzinx, (Object) null, (Object) null);
        try {
            wa0 a = pa0.m6655b().mo14584a(t2);
            a.mo14193f(t2, bArr, 0, i2, new k80(zzeju));
            a.mo14196i(t2);
            if (t2.zziij == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzeks) {
                throw ((zzeks) e.getCause());
            }
            throw new zzeks(e.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzeks.m8828a().zzl(t2);
        }
    }

    /* renamed from: e */
    static Object m8813e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    /* renamed from: f */
    private static <T extends zzekh<T, ?>> T m8814f(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzeks(new zzeng(t).getMessage()).zzl(t);
    }

    /* renamed from: g */
    private static <T extends zzekh<T, ?>> T m8815g(T t, zzeiu zzeiu, zzeju zzeju) {
        T c;
        try {
            zzejj zzbfs = zzeiu.zzbfs();
            c = m8811c(t, zzbfs, zzeju);
            zzbfs.zzgc(0);
            return c;
        } catch (zzeks e) {
            throw e.zzl(c);
        } catch (zzeks e2) {
            throw e2;
        }
    }

    /* renamed from: h */
    static <T extends zzekh<?, ?>> T m8816h(Class<T> cls) {
        T t = (zzekh) zzinq.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzekh) zzinq.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzekh) ((zzekh) sb0.m6929x(cls)).zza(zzf.zzinz, (Object) null, (Object) null);
            if (t != null) {
                zzinq.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzekh<?, ?>> void zza(Class<T> cls, T t) {
        zzinq.put(cls, t);
    }

    protected static zzeko zzbia() {
        return m90.m6487a();
    }

    protected static zzekq zzbib() {
        return w90.m7116a();
    }

    protected static <E> zzekp<E> zzbic() {
        return oa0.m6577a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo17586a() {
        return this.zzinp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo17587b(int i) {
        this.zzinp = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return pa0.m6655b().mo14584a(this).mo14189b(this, (zzekh) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zziij;
        if (i != 0) {
            return i;
        }
        int d = pa0.m6655b().mo14584a(this).mo14191d(this);
        this.zziij = d;
        return d;
    }

    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return fa0.m6058a(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zzb(zzejo zzejo) {
        pa0.m6655b().mo14584a(this).mo14198k(this, a90.m5763g(zzejo));
    }

    public final /* synthetic */ zzels zzbhw() {
        return (zzekh) zza(zzf.zzinz, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbhx() {
        return (zza) zza(zzf.zziny, (Object) null, (Object) null);
    }

    public final BuilderType zzbhy() {
        BuilderType buildertype = (zza) zza(zzf.zziny, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzbhz() {
        if (this.zzinp == -1) {
            this.zzinp = pa0.m6655b().mo14584a(this).mo14197j(this);
        }
        return this.zzinp;
    }

    public final /* synthetic */ zzelr zzbid() {
        zza zza2 = (zza) zza(zzf.zziny, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzelr zzbie() {
        return (zza) zza(zzf.zziny, (Object) null, (Object) null);
    }

    protected static Object zza(zzels zzels, String str, Object[] objArr) {
        return new ra0(zzels, str, objArr);
    }

    protected static final <T extends zzekh<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzinu, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean e = pa0.m6655b().mo14584a(t).mo14192e(t);
        if (z) {
            t.zza(zzf.zzinv, (Object) e ? t : null, (Object) null);
        }
        return e;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
    public static abstract class zza<MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzein<MessageType, BuilderType> {

        /* renamed from: a */
        private final MessageType f16267a;
        protected MessageType zzinm;
        protected boolean zzinn = false;

        protected zza(MessageType messagetype) {
            this.f16267a = messagetype;
            this.zzinm = (zzekh) messagetype.zza(zzf.zzinx, (Object) null, (Object) null);
        }

        /* renamed from: a */
        private static void m8819a(MessageType messagetype, MessageType messagetype2) {
            pa0.m6655b().mo14584a(messagetype).mo14195h(messagetype, messagetype2);
        }

        /* renamed from: b */
        private final BuilderType m8820b(zzejj zzejj, zzeju zzeju) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            try {
                pa0.m6655b().mo14584a(this.zzinm).mo14194g(this.zzinm, x80.m7161N(zzejj), zzeju);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        /* renamed from: c */
        private final BuilderType m8821c(byte[] bArr, int i, int i2, zzeju zzeju) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            try {
                pa0.m6655b().mo14584a(this.zzinm).mo14193f(this.zzinm, bArr, 0, i2, new k80(zzeju));
                return this;
            } catch (zzeks e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzeks.m8828a();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public /* synthetic */ Object clone() {
            zza zza = (zza) this.f16267a.zza(zzf.zziny, (Object) null, (Object) null);
            zza.zza((zzekh) zzbhu());
            return zza;
        }

        public final boolean isInitialized() {
            return zzekh.zza(this.zzinm, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            m8819a(this.zzinm, messagetype);
            return this;
        }

        public final /* synthetic */ zzein zzbfj() {
            return (zza) clone();
        }

        /* access modifiers changed from: protected */
        public void zzbhr() {
            MessageType messagetype = (zzekh) this.zzinm.zza(zzf.zzinx, (Object) null, (Object) null);
            m8819a(messagetype, this.zzinm);
            this.zzinm = messagetype;
        }

        /* renamed from: zzbhs */
        public MessageType zzbhu() {
            if (this.zzinn) {
                return this.zzinm;
            }
            MessageType messagetype = this.zzinm;
            pa0.m6655b().mo14584a(messagetype).mo14196i(messagetype);
            this.zzinn = true;
            return this.zzinm;
        }

        /* renamed from: zzbht */
        public final MessageType zzbhv() {
            MessageType messagetype = (zzekh) zzbhu();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzeng(messagetype);
        }

        public final /* synthetic */ zzels zzbhw() {
            return this.f16267a;
        }

        public final /* synthetic */ zzein zza(byte[] bArr, int i, int i2, zzeju zzeju) {
            m8821c(bArr, 0, i2, zzeju);
            return this;
        }

        public final /* synthetic */ zzein zza(zzejj zzejj, zzeju zzeju) {
            m8820b(zzejj, zzeju);
            return this;
        }
    }

    protected static zzeko zza(zzeko zzeko) {
        int size = zzeko.size();
        return zzeko.zzhf(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzekp<E> zza(zzekp<E> zzekp) {
        int size = zzekp.size();
        return zzekp.zzfx(size == 0 ? 10 : size << 1);
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, zzeiu zzeiu) {
        T g = m8815g(t, zzeiu, zzeju.zzbhe());
        m8814f(g);
        m8814f(g);
        return g;
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, zzeiu zzeiu, zzeju zzeju) {
        T g = m8815g(t, zzeiu, zzeju);
        m8814f(g);
        return g;
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, byte[] bArr) {
        T d = m8812d(t, bArr, 0, bArr.length, zzeju.zzbhe());
        m8814f(d);
        return d;
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, byte[] bArr, zzeju zzeju) {
        T d = m8812d(t, bArr, 0, bArr.length, zzeju);
        m8814f(d);
        return d;
    }
}
