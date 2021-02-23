package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaud extends zzaue {

    /* renamed from: a */
    private final String f12853a;

    /* renamed from: b */
    private final int f12854b;

    public zzaud(String str, int i) {
        this.f12853a = str;
        this.f12854b = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaud)) {
            zzaud zzaud = (zzaud) obj;
            if (!Objects.equal(this.f12853a, zzaud.f12853a) || !Objects.equal(Integer.valueOf(this.f12854b), Integer.valueOf(zzaud.f12854b))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int getAmount() {
        return this.f12854b;
    }

    public final String getType() {
        return this.f12853a;
    }
}
