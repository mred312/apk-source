package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.o5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2833o5 extends C2841p5<FieldDescriptorType, Object> {
    C2833o5(int i) {
        super(i, (C2833o5) null);
    }

    /* renamed from: e */
    public final void mo18786e() {
        if (!mo18803i()) {
            for (int i = 0; i < mo18804j(); i++) {
                Map.Entry h = mo18801h(i);
                if (((zzhr) h.getKey()).zzd()) {
                    h.setValue(Collections.unmodifiableList((List) h.getValue()));
                }
            }
            for (Map.Entry entry : mo18805m()) {
                if (((zzhr) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo18786e();
    }
}
