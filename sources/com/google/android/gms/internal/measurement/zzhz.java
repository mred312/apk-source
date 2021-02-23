package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzhz.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public abstract class zzhz<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgh<MessageType, BuilderType> {
    private static Map<Object, zzhz<?, ?>> zzd = new ConcurrentHashMap();
    protected zzku zzb = zzku.zza();
    private int zzc = -1;

    /* renamed from: com.google.android.gms.internal.measurement.zzhz$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    static final class C2926a implements zzhr<C2926a> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzli zzb() {
            throw new NoSuchMethodError();
        }

        public final zzll zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzjk zza(zzjk zzjk, zzjh zzjh) {
            throw new NoSuchMethodError();
        }

        public final zzjq zza(zzjq zzjq, zzjq zzjq2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzhz<MessageType, BuilderType> implements zzjj {
        protected C2909y3<C2926a> zzc = C2909y3.m9939c();

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final C2909y3<C2926a> mo19532e() {
            if (this.zzc.mo18987o()) {
                this.zzc = (C2909y3) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    protected static class zzc<T extends zzhz<T, ?>> extends zzgi<T> {
        public zzc(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    public static class zzd<ContainingType extends zzjh, Type> extends zzhk<ContainingType, Type> {
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    public static final class zzf {

        /* renamed from: a */
        private static final /* synthetic */ int[] f17729a = {1, 2, 3, 4, 5, 6, 7};
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;

        public static int[] zza() {
            return (int[]) f17729a.clone();
        }
    }

    /* renamed from: c */
    static <T extends zzhz<?, ?>> T m10372c(Class<T> cls) {
        T t = (zzhz) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzhz) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzhz) ((zzhz) C2758f6.m9425c(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    /* renamed from: d */
    static Object m10373d(Method method, Object obj, Object... objArr) {
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

    protected static zzig zzbp() {
        return C2768g4.m9488b();
    }

    protected static zzif zzbq() {
        return C2824n4.m9670b();
    }

    protected static <E> zzii<E> zzbr() {
        return C2785i5.m9515c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo19457a() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo19458b(int i) {
        this.zzc = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return C2769g5.m9493a().mo18662c(this).mo18544d(this, (zzhz) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int a = C2769g5.m9493a().mo18662c(this).mo18541a(this);
        this.zza = a;
        return a;
    }

    /* renamed from: i_ */
    public final boolean mo19516i_() {
        return zza(this, true);
    }

    public String toString() {
        return C2917z4.m10012a(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zza(zzhg zzhg) {
        C2769g5.m9493a().mo18662c(this).mo18546f(this, C2879u3.m9799I(zzhg));
    }

    public final /* synthetic */ zzjh zzaa() {
        return (zzhz) zza(zzf.zzf, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbm() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzbn() {
        BuilderType buildertype = (zza) zza(zzf.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzbo() {
        if (this.zzc == -1) {
            this.zzc = C2769g5.m9493a().mo18662c(this).zzb(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ zzjk zzbs() {
        zza zza2 = (zza) zza(zzf.zze, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzjk zzbt() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    protected static <T extends zzhz<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjh zzjh, String str, Object[] objArr) {
        return new C2777h5(zzjh, str, objArr);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
    public static abstract class zza<MessageType extends zzhz<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzgg<MessageType, BuilderType> {

        /* renamed from: a */
        private final MessageType f17728a;
        protected MessageType zza;
        protected boolean zzb = false;

        protected zza(MessageType messagetype) {
            this.f17728a = messagetype;
            this.zza = (zzhz) messagetype.zza(zzf.zzd, (Object) null, (Object) null);
        }

        /* renamed from: b */
        private static void m10377b(MessageType messagetype, MessageType messagetype2) {
            C2769g5.m9493a().mo18662c(messagetype).mo18548h(messagetype, messagetype2);
        }

        /* renamed from: c */
        private final BuilderType m10378c(zzhd zzhd, zzhm zzhm) {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                C2769g5.m9493a().mo18662c(this.zza).mo18547g(this.zza, C2847q3.m9731u(zzhd), zzhm);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        /* renamed from: d */
        private final BuilderType m10379d(byte[] bArr, int i, int i2, zzhm zzhm) {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                C2769g5.m9493a().mo18662c(this.zza).mo18545e(this.zza, bArr, 0, i2, new C2739d3(zzhm));
                return this;
            } catch (zzih e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzih.m10387a();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public /* synthetic */ Object clone() {
            zza zza2 = (zza) this.f17728a.zza(zzf.zze, (Object) null, (Object) null);
            zza2.zza((zzhz) zzy());
            return zza2;
        }

        /* renamed from: i_ */
        public final boolean mo19516i_() {
            return zzhz.zza(this.zza, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            m10377b(this.zza, messagetype);
            return this;
        }

        public final /* synthetic */ zzjh zzaa() {
            return this.f17728a;
        }

        public final /* synthetic */ zzgg zzt() {
            return (zza) clone();
        }

        /* access modifiers changed from: protected */
        public void zzu() {
            MessageType messagetype = (zzhz) this.zza.zza(zzf.zzd, (Object) null, (Object) null);
            m10377b(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zzw */
        public MessageType zzy() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            C2769g5.m9493a().mo18662c(messagetype).mo18543c(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzx */
        public final MessageType zzz() {
            MessageType messagetype = (zzhz) zzy();
            if (messagetype.mo19516i_()) {
                return messagetype;
            }
            throw new zzks(messagetype);
        }

        public final /* synthetic */ zzgg zza(byte[] bArr, int i, int i2, zzhm zzhm) {
            m10379d(bArr, 0, i2, zzhm);
            return this;
        }

        public final /* synthetic */ zzgg zza(byte[] bArr, int i, int i2) {
            m10379d(bArr, 0, i2, zzhm.zza());
            return this;
        }

        public final /* synthetic */ zzgg zza(zzhd zzhd, zzhm zzhm) {
            m10378c(zzhd, zzhm);
            return this;
        }
    }

    protected static final <T extends zzhz<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b = C2769g5.m9493a().mo18662c(t).mo18542b(t);
        if (z) {
            t.zza(zzf.zzb, (Object) b ? t : null, (Object) null);
        }
        return b;
    }

    protected static zzif zza(zzif zzif) {
        int size = zzif.size();
        return zzif.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzii<E> zza(zzii<E> zzii) {
        int size = zzii.size();
        return zzii.zza(size == 0 ? 10 : size << 1);
    }
}
