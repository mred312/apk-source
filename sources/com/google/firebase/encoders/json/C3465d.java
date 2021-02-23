package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* renamed from: com.google.firebase.encoders.json.d */
/* compiled from: JsonValueObjectEncoderContext */
final class C3465d implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a */
    private C3465d f19559a = null;

    /* renamed from: b */
    private boolean f19560b = true;

    /* renamed from: c */
    private final JsonWriter f19561c;

    /* renamed from: d */
    private final Map<Class<?>, ObjectEncoder<?>> f19562d;

    /* renamed from: e */
    private final Map<Class<?>, ValueEncoder<?>> f19563e;

    /* renamed from: f */
    private final ObjectEncoder<Object> f19564f;

    /* renamed from: g */
    private final boolean f19565g;

    C3465d(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z) {
        this.f19561c = new JsonWriter(writer);
        this.f19562d = map;
        this.f19563e = map2;
        this.f19564f = objectEncoder;
        this.f19565g = z;
    }

    /* renamed from: m */
    private boolean m11743m(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    /* renamed from: p */
    private C3465d m11744p(@NonNull String str, @Nullable Object obj) {
        m11746r();
        this.f19561c.name(str);
        if (obj == null) {
            this.f19561c.nullValue();
            return this;
        }
        mo21557d(obj, false);
        return this;
    }

    /* renamed from: q */
    private C3465d m11745q(@NonNull String str, @Nullable Object obj) {
        if (obj == null) {
            return this;
        }
        m11746r();
        this.f19561c.name(str);
        mo21557d(obj, false);
        return this;
    }

    /* renamed from: r */
    private void m11746r() {
        if (this.f19560b) {
            C3465d dVar = this.f19559a;
            if (dVar != null) {
                dVar.m11746r();
                this.f19559a.f19560b = false;
                this.f19559a = null;
                this.f19561c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @NonNull
    /* renamed from: a */
    public C3465d mo21554a(double d) {
        m11746r();
        this.f19561c.value(d);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ObjectEncoderContext add(@NonNull String str, double d) {
        mo21559f(str, d);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public C3465d mo21555b(int i) {
        m11746r();
        this.f19561c.value((long) i);
        return this;
    }

    @NonNull
    /* renamed from: c */
    public C3465d mo21556c(long j) {
        m11746r();
        this.f19561c.value(j);
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: d */
    public C3465d mo21557d(@Nullable Object obj, boolean z) {
        Class<?> cls;
        int i = 0;
        if (z && m11743m(obj)) {
            Object[] objArr = new Object[1];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            objArr[0] = cls;
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        } else if (obj == null) {
            this.f19561c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f19561c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                mo21565l((byte[]) obj);
                return this;
            }
            this.f19561c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i < length) {
                    this.f19561c.value((long) iArr[i]);
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i < length2) {
                    mo21556c(jArr[i]);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i < length3) {
                    this.f19561c.value(dArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i < length4) {
                    this.f19561c.value(zArr[i]);
                    i++;
                }
            } else if (obj instanceof Number[]) {
                for (Number d : (Number[]) obj) {
                    mo21557d(d, false);
                }
            } else {
                for (Object d2 : (Object[]) obj) {
                    mo21557d(d2, false);
                }
            }
            this.f19561c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f19561c.beginArray();
            for (Object d3 : (Collection) obj) {
                mo21557d(d3, false);
            }
            this.f19561c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f19561c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    mo21562i((String) key, entry.getValue());
                } catch (ClassCastException e) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e);
                }
            }
            this.f19561c.endObject();
            return this;
        } else {
            ObjectEncoder objectEncoder = this.f19562d.get(obj.getClass());
            if (objectEncoder != null) {
                mo21567o(objectEncoder, obj, z);
                return this;
            }
            ValueEncoder valueEncoder = this.f19563e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                mo21558e(((Enum) obj).name());
                return this;
            } else {
                mo21567o(this.f19564f, obj, z);
                return this;
            }
        }
    }

    @NonNull
    /* renamed from: e */
    public C3465d mo21558e(@Nullable String str) {
        m11746r();
        this.f19561c.value(str);
        return this;
    }

    @NonNull
    /* renamed from: f */
    public C3465d mo21559f(@NonNull String str, double d) {
        m11746r();
        this.f19561c.name(str);
        mo21554a(d);
        return this;
    }

    @NonNull
    /* renamed from: g */
    public C3465d mo21560g(@NonNull String str, int i) {
        m11746r();
        this.f19561c.name(str);
        mo21555b(i);
        return this;
    }

    @NonNull
    /* renamed from: h */
    public C3465d mo21561h(@NonNull String str, long j) {
        m11746r();
        this.f19561c.name(str);
        mo21556c(j);
        return this;
    }

    @NonNull
    /* renamed from: i */
    public C3465d mo21562i(@NonNull String str, @Nullable Object obj) {
        if (this.f19565g) {
            m11745q(str, obj);
            return this;
        }
        m11744p(str, obj);
        return this;
    }

    @NonNull
    public ObjectEncoderContext inline(@Nullable Object obj) {
        mo21557d(obj, true);
        return this;
    }

    @NonNull
    /* renamed from: j */
    public C3465d mo21563j(@NonNull String str, boolean z) {
        m11746r();
        this.f19561c.name(str);
        mo21564k(z);
        return this;
    }

    @NonNull
    /* renamed from: k */
    public C3465d mo21564k(boolean z) {
        m11746r();
        this.f19561c.value(z);
        return this;
    }

    @NonNull
    /* renamed from: l */
    public C3465d mo21565l(@Nullable byte[] bArr) {
        m11746r();
        if (bArr == null) {
            this.f19561c.nullValue();
        } else {
            this.f19561c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo21566n() {
        m11746r();
        this.f19561c.flush();
    }

    @NonNull
    public ObjectEncoderContext nested(@NonNull String str) {
        m11746r();
        this.f19559a = new C3465d(this);
        this.f19561c.name(str);
        this.f19561c.beginObject();
        return this.f19559a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public C3465d mo21567o(ObjectEncoder<Object> objectEncoder, Object obj, boolean z) {
        if (!z) {
            this.f19561c.beginObject();
        }
        objectEncoder.encode(obj, this);
        if (!z) {
            this.f19561c.endObject();
        }
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ObjectEncoderContext add(@NonNull String str, int i) {
        mo21560g(str, i);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ObjectEncoderContext add(@NonNull String str, long j) {
        mo21561h(str, j);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) {
        mo21562i(str, obj);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ObjectEncoderContext add(@NonNull String str, boolean z) {
        mo21563j(str, z);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(double d) {
        mo21554a(d);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(int i) {
        mo21555b(i);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(long j) {
        mo21556c(j);
        return this;
    }

    private C3465d(C3465d dVar) {
        this.f19561c = dVar.f19561c;
        this.f19562d = dVar.f19562d;
        this.f19563e = dVar.f19563e;
        this.f19564f = dVar.f19564f;
        this.f19565g = dVar.f19565g;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(@Nullable String str) {
        mo21558e(str);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(boolean z) {
        mo21564k(z);
        return this;
    }

    @NonNull
    public /* bridge */ /* synthetic */ ValueEncoderContext add(@Nullable byte[] bArr) {
        mo21565l(bArr);
        return this;
    }
}
