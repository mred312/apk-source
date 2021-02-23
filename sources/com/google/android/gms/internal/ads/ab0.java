package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ab0 extends bb0<FieldDescriptorType, Object> {
    ab0(int i) {
        super(i, (ab0) null);
    }

    /* renamed from: g */
    public final void mo13596g() {
        if (!mo13656a()) {
            for (int i = 0; i < mo13663h(); i++) {
                Map.Entry p = mo13667p(i);
                if (((zzejz) p.getKey()).zzbhn()) {
                    p.setValue(Collections.unmodifiableList((List) p.getValue()));
                }
            }
            for (Map.Entry entry : mo13665i()) {
                if (((zzejz) entry.getKey()).zzbhn()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo13596g();
    }
}
