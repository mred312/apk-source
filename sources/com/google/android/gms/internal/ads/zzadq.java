package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzadq extends zzaea {

    /* renamed from: i */
    private static final int f12390i;

    /* renamed from: j */
    private static final int f12391j = Color.rgb(204, 204, 204);

    /* renamed from: k */
    private static final int f12392k;

    /* renamed from: a */
    private final String f12393a;

    /* renamed from: b */
    private final List<zzadv> f12394b = new ArrayList();

    /* renamed from: c */
    private final List<zzaej> f12395c = new ArrayList();

    /* renamed from: d */
    private final int f12396d;

    /* renamed from: e */
    private final int f12397e;

    /* renamed from: f */
    private final int f12398f;

    /* renamed from: g */
    private final int f12399g;

    /* renamed from: h */
    private final int f12400h;

    static {
        int rgb = Color.rgb(12, 174, 206);
        f12390i = rgb;
        f12392k = rgb;
    }

    public zzadq(String str, List<zzadv> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.f12393a = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadv zzadv = list.get(i3);
                this.f12394b.add(zzadv);
                this.f12395c.add(zzadv);
            }
        }
        this.f12396d = num != null ? num.intValue() : f12391j;
        this.f12397e = num2 != null ? num2.intValue() : f12392k;
        this.f12398f = num3 != null ? num3.intValue() : 12;
        this.f12399g = i;
        this.f12400h = i2;
    }

    public final int getBackgroundColor() {
        return this.f12396d;
    }

    public final String getText() {
        return this.f12393a;
    }

    public final int getTextColor() {
        return this.f12397e;
    }

    public final int getTextSize() {
        return this.f12398f;
    }

    public final List<zzaej> zzsm() {
        return this.f12395c;
    }

    public final List<zzadv> zzsn() {
        return this.f12394b;
    }

    public final int zzso() {
        return this.f12399g;
    }

    public final int zzsp() {
        return this.f12400h;
    }
}
