package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.m8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2166m8 {

    /* renamed from: a */
    private final ArrayList<zzoq> f9919a = new ArrayList<>();

    /* renamed from: b */
    private long f9920b;

    C2166m8() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo14416a(zzoq zzoq) {
        this.f9919a.add(zzoq);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo14417b() {
        Iterator<zzoq> it = this.f9919a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry next : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.f9920b = Math.max(this.f9920b, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.f9920b;
    }
}
