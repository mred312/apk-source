package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class xe0 extends ue0 {

    /* renamed from: P0 */
    public final long f11896P0;

    /* renamed from: Q0 */
    public final List<we0> f11897Q0 = new ArrayList();

    /* renamed from: R0 */
    public final List<xe0> f11898R0 = new ArrayList();

    public xe0(int i, long j) {
        super(i);
        this.f11896P0 = j;
    }

    /* renamed from: d */
    public final void mo15026d(we0 we0) {
        this.f11897Q0.add(we0);
    }

    /* renamed from: e */
    public final void mo15027e(xe0 xe0) {
        this.f11898R0.add(xe0);
    }

    /* renamed from: f */
    public final we0 mo15028f(int i) {
        int size = this.f11897Q0.size();
        for (int i2 = 0; i2 < size; i2++) {
            we0 we0 = this.f11897Q0.get(i2);
            if (we0.f11418a == i) {
                return we0;
            }
        }
        return null;
    }

    /* renamed from: g */
    public final xe0 mo15029g(int i) {
        int size = this.f11898R0.size();
        for (int i2 = 0; i2 < size; i2++) {
            xe0 xe0 = this.f11898R0.get(i2);
            if (xe0.f11418a == i) {
                return xe0;
            }
        }
        return null;
    }

    public final String toString() {
        String c = ue0.m7043c(this.f11418a);
        String arrays = Arrays.toString(this.f11897Q0.toArray());
        String arrays2 = Arrays.toString(this.f11898R0.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(c);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
