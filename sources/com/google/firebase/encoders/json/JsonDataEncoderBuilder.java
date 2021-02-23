package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* renamed from: e */
    private static final ObjectEncoder<Object> f19546e = C3462a.m11740a();

    /* renamed from: f */
    private static final ValueEncoder<String> f19547f = C3463b.m11741a();

    /* renamed from: g */
    private static final ValueEncoder<Boolean> f19548g = C3464c.m11742a();

    /* renamed from: h */
    private static final C3461b f19549h = new C3461b((C3460a) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<Class<?>, ObjectEncoder<?>> f19550a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<Class<?>, ValueEncoder<?>> f19551b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ObjectEncoder<Object> f19552c = f19546e;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f19553d = false;

    /* renamed from: com.google.firebase.encoders.json.JsonDataEncoderBuilder$b */
    private static final class C3461b implements ValueEncoder<Date> {

        /* renamed from: a */
        private static final DateFormat f19555a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f19555a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private C3461b() {
        }

        /* renamed from: a */
        public void encode(@NonNull Date date, @NonNull ValueEncoderContext valueEncoderContext) {
            valueEncoderContext.add(f19555a.format(date));
        }

        /* synthetic */ C3461b(C3460a aVar) {
            this();
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) f19547f);
        registerEncoder(Boolean.class, (ValueEncoder) f19548g);
        registerEncoder(Date.class, (ValueEncoder) f19549h);
    }

    /* renamed from: e */
    static /* synthetic */ void m11736e(Object obj, ObjectEncoderContext objectEncoderContext) {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    @NonNull
    public DataEncoder build() {
        return new C3460a();
    }

    @NonNull
    public JsonDataEncoderBuilder configureWith(@NonNull Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder ignoreNullValues(boolean z) {
        this.f19553d = z;
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder registerFallbackEncoder(@NonNull ObjectEncoder<Object> objectEncoder) {
        this.f19552c = objectEncoder;
        return this;
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.f19550a.put(cls, objectEncoder);
        this.f19551b.remove(cls);
        return this;
    }

    /* renamed from: com.google.firebase.encoders.json.JsonDataEncoderBuilder$a */
    class C3460a implements DataEncoder {
        C3460a() {
        }

        public void encode(@NonNull Object obj, @NonNull Writer writer) {
            C3465d dVar = new C3465d(writer, JsonDataEncoderBuilder.this.f19550a, JsonDataEncoderBuilder.this.f19551b, JsonDataEncoderBuilder.this.f19552c, JsonDataEncoderBuilder.this.f19553d);
            dVar.mo21557d(obj, false);
            dVar.mo21566n();
        }

        public String encode(@NonNull Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                encode(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    @NonNull
    public <T> JsonDataEncoderBuilder registerEncoder(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.f19551b.put(cls, valueEncoder);
        this.f19550a.remove(cls);
        return this;
    }
}
