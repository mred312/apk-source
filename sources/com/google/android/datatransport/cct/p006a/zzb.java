package com.google.android.datatransport.cct.p006a;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* renamed from: com.google.android.datatransport.cct.a.zzb */
public final class zzb implements Configurator {
    public static final Configurator zza = new zzb();

    /* renamed from: com.google.android.datatransport.cct.a.zzb$a */
    private static final class C1567a implements ObjectEncoder<zza> {

        /* renamed from: a */
        static final C1567a f7140a = new C1567a();

        private C1567a() {
        }

        public void encode(Object obj, Object obj2) {
            zza zza = (zza) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, (Object) zza.zzi());
            objectEncoderContext.add("model", (Object) zza.zzf());
            objectEncoderContext.add("hardware", (Object) zza.zzd());
            objectEncoderContext.add("device", (Object) zza.zzb());
            objectEncoderContext.add("product", (Object) zza.zzh());
            objectEncoderContext.add("osBuild", (Object) zza.zzg());
            objectEncoderContext.add("manufacturer", (Object) zza.zze());
            objectEncoderContext.add("fingerprint", (Object) zza.zzc());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzb$b */
    private static final class C1568b implements ObjectEncoder<zzo> {

        /* renamed from: a */
        static final C1568b f7141a = new C1568b();

        private C1568b() {
        }

        public void encode(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).add("logRequest", (Object) ((zzo) obj).zza());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzb$c */
    private static final class C1569c implements ObjectEncoder<zzp> {

        /* renamed from: a */
        static final C1569c f7142a = new C1569c();

        private C1569c() {
        }

        public void encode(Object obj, Object obj2) {
            zzp zzp = (zzp) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("clientType", (Object) zzp.zzc());
            objectEncoderContext.add("androidClientInfo", (Object) zzp.zzb());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzb$d */
    private static final class C1570d implements ObjectEncoder<zzq> {

        /* renamed from: a */
        static final C1570d f7143a = new C1570d();

        private C1570d() {
        }

        public void encode(Object obj, Object obj2) {
            zzq zzq = (zzq) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("eventTimeMs", zzq.zzb());
            objectEncoderContext.add("eventCode", (Object) zzq.zza());
            objectEncoderContext.add("eventUptimeMs", zzq.zzc());
            objectEncoderContext.add("sourceExtension", (Object) zzq.zze());
            objectEncoderContext.add("sourceExtensionJsonProto3", (Object) zzq.zzf());
            objectEncoderContext.add("timezoneOffsetSeconds", zzq.zzg());
            objectEncoderContext.add("networkConnectionInfo", (Object) zzq.zzd());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzb$e */
    private static final class C1571e implements ObjectEncoder<zzr> {

        /* renamed from: a */
        static final C1571e f7144a = new C1571e();

        private C1571e() {
        }

        public void encode(Object obj, Object obj2) {
            zzr zzr = (zzr) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("requestTimeMs", zzr.zzg());
            objectEncoderContext.add("requestUptimeMs", zzr.zzh());
            objectEncoderContext.add("clientInfo", (Object) zzr.zzb());
            objectEncoderContext.add("logSource", (Object) zzr.zzd());
            objectEncoderContext.add("logSourceName", (Object) zzr.zze());
            objectEncoderContext.add("logEvent", (Object) zzr.zzc());
            objectEncoderContext.add("qosTier", (Object) zzr.zzf());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.a.zzb$f */
    private static final class C1572f implements ObjectEncoder<zzt> {

        /* renamed from: a */
        static final C1572f f7145a = new C1572f();

        private C1572f() {
        }

        public void encode(Object obj, Object obj2) {
            zzt zzt = (zzt) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("networkType", (Object) zzt.zzc());
            objectEncoderContext.add("mobileSubtype", (Object) zzt.zzb());
        }
    }

    private zzb() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        C1568b bVar = C1568b.f7141a;
        encoderConfig.registerEncoder((Class<U>) zzo.class, (ObjectEncoder<? super U>) bVar);
        encoderConfig.registerEncoder((Class<U>) C1553b.class, (ObjectEncoder<? super U>) bVar);
        C1571e eVar = C1571e.f7144a;
        encoderConfig.registerEncoder((Class<U>) zzr.class, (ObjectEncoder<? super U>) eVar);
        encoderConfig.registerEncoder((Class<U>) C1560e.class, (ObjectEncoder<? super U>) eVar);
        C1569c cVar = C1569c.f7142a;
        encoderConfig.registerEncoder((Class<U>) zzp.class, (ObjectEncoder<? super U>) cVar);
        encoderConfig.registerEncoder((Class<U>) C1554c.class, (ObjectEncoder<? super U>) cVar);
        C1567a aVar = C1567a.f7140a;
        encoderConfig.registerEncoder((Class<U>) zza.class, (ObjectEncoder<? super U>) aVar);
        encoderConfig.registerEncoder((Class<U>) C1550a.class, (ObjectEncoder<? super U>) aVar);
        C1570d dVar = C1570d.f7143a;
        encoderConfig.registerEncoder((Class<U>) zzq.class, (ObjectEncoder<? super U>) dVar);
        encoderConfig.registerEncoder((Class<U>) C1557d.class, (ObjectEncoder<? super U>) dVar);
        C1572f fVar = C1572f.f7145a;
        encoderConfig.registerEncoder((Class<U>) zzt.class, (ObjectEncoder<? super U>) fVar);
        encoderConfig.registerEncoder((Class<U>) C1564g.class, (ObjectEncoder<? super U>) fVar);
    }
}
