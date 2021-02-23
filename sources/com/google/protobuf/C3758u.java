package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.Map;

/* renamed from: com.google.protobuf.u */
/* compiled from: MapFieldSchemaLite */
class C3758u implements C3751t {
    C3758u() {
    }

    /* renamed from: i */
    private static <K, V> int m13824i(int i, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        int i2 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            i2 += mapEntryLite.computeMessageSize(i, entry.getKey(), entry.getValue());
        }
        return i2;
    }

    /* renamed from: j */
    private static <K, V> MapFieldLite<K, V> m13825j(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable()) {
                mapFieldLite = mapFieldLite.mutableCopy();
            }
            mapFieldLite.mergeFrom(mapFieldLite2);
        }
        return mapFieldLite;
    }

    /* renamed from: a */
    public Object mo24031a(Object obj, Object obj2) {
        return m13825j(obj, obj2);
    }

    /* renamed from: b */
    public Object mo24032b(Object obj) {
        ((MapFieldLite) obj).makeImmutable();
        return obj;
    }

    /* renamed from: c */
    public MapEntryLite.C3657b<?, ?> mo24033c(Object obj) {
        return ((MapEntryLite) obj).mo23508b();
    }

    /* renamed from: d */
    public Map<?, ?> mo24034d(Object obj) {
        return (MapFieldLite) obj;
    }

    /* renamed from: e */
    public Object mo24035e(Object obj) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    /* renamed from: f */
    public int mo24036f(int i, Object obj, Object obj2) {
        return m13824i(i, obj, obj2);
    }

    /* renamed from: g */
    public boolean mo24037g(Object obj) {
        return !((MapFieldLite) obj).isMutable();
    }

    /* renamed from: h */
    public Map<?, ?> mo24038h(Object obj) {
        return (MapFieldLite) obj;
    }
}
