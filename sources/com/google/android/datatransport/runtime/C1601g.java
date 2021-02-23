package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* renamed from: com.google.android.datatransport.runtime.g */
/* compiled from: TransportFactoryImpl */
final class C1601g implements TransportFactory {

    /* renamed from: a */
    private final Set<Encoding> f7245a;

    /* renamed from: b */
    private final TransportContext f7246b;

    /* renamed from: c */
    private final C1604j f7247c;

    C1601g(Set<Encoding> set, TransportContext transportContext, C1604j jVar) {
        this.f7245a = set;
        this.f7246b = transportContext;
        this.f7247c = jVar;
    }

    public <T> Transport<T> getTransport(String str, Class<T> cls, Transformer<T, byte[]> transformer) {
        return getTransport(str, cls, Encoding.m5015of("proto"), transformer);
    }

    public <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
        if (this.f7245a.contains(encoding)) {
            return new C1603i(this.f7246b, str, encoding, transformer, this.f7247c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{encoding, this.f7245a}));
    }
}
