package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.prefill.b */
/* compiled from: PreFillQueue */
final class C1266b {

    /* renamed from: a */
    private final Map<PreFillType, Integer> f5988a;

    /* renamed from: b */
    private final List<PreFillType> f5989b;

    /* renamed from: c */
    private int f5990c;

    /* renamed from: d */
    private int f5991d;

    public C1266b(Map<PreFillType, Integer> map) {
        this.f5988a = map;
        this.f5989b = new ArrayList(map.keySet());
        for (Integer intValue : map.values()) {
            this.f5990c += intValue.intValue();
        }
    }

    /* renamed from: a */
    public boolean mo9711a() {
        return this.f5990c == 0;
    }

    /* renamed from: b */
    public PreFillType mo9712b() {
        PreFillType preFillType = this.f5989b.get(this.f5991d);
        Integer num = this.f5988a.get(preFillType);
        if (num.intValue() == 1) {
            this.f5988a.remove(preFillType);
            this.f5989b.remove(this.f5991d);
        } else {
            this.f5988a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.f5990c--;
        this.f5991d = this.f5989b.isEmpty() ? 0 : (this.f5991d + 1) % this.f5989b.size();
        return preFillType;
    }
}
