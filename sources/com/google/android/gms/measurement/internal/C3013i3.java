package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.i3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3013i3 {

    /* renamed from: A */
    private long f18130A;

    /* renamed from: B */
    private long f18131B;

    /* renamed from: C */
    private long f18132C;

    /* renamed from: D */
    private String f18133D;

    /* renamed from: E */
    private boolean f18134E;

    /* renamed from: F */
    private long f18135F;

    /* renamed from: G */
    private long f18136G;

    /* renamed from: a */
    private final zzfv f18137a;

    /* renamed from: b */
    private final String f18138b;

    /* renamed from: c */
    private String f18139c;

    /* renamed from: d */
    private String f18140d;

    /* renamed from: e */
    private String f18141e;

    /* renamed from: f */
    private String f18142f;

    /* renamed from: g */
    private long f18143g;

    /* renamed from: h */
    private long f18144h;

    /* renamed from: i */
    private long f18145i;

    /* renamed from: j */
    private String f18146j;

    /* renamed from: k */
    private long f18147k;

    /* renamed from: l */
    private String f18148l;

    /* renamed from: m */
    private long f18149m;

    /* renamed from: n */
    private long f18150n;

    /* renamed from: o */
    private boolean f18151o;

    /* renamed from: p */
    private long f18152p;

    /* renamed from: q */
    private boolean f18153q;

    /* renamed from: r */
    private boolean f18154r;

    /* renamed from: s */
    private String f18155s;

    /* renamed from: t */
    private Boolean f18156t;

    /* renamed from: u */
    private long f18157u;

    /* renamed from: v */
    private List<String> f18158v;

    /* renamed from: w */
    private String f18159w;

    /* renamed from: x */
    private long f18160x;

    /* renamed from: y */
    private long f18161y;

    /* renamed from: z */
    private long f18162z;

    @WorkerThread
    C3013i3(zzfv zzfv, String str) {
        Preconditions.checkNotNull(zzfv);
        Preconditions.checkNotEmpty(str);
        this.f18137a = zzfv;
        this.f18138b = str;
        zzfv.zzp().zzc();
    }

    @WorkerThread
    /* renamed from: A */
    public final String mo19937A() {
        this.f18137a.zzp().zzc();
        return this.f18140d;
    }

    @WorkerThread
    /* renamed from: B */
    public final void mo19938B(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18150n != j;
        this.f18150n = j;
    }

    @WorkerThread
    /* renamed from: C */
    public final void mo19939C(String str) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m10994R(this.f18141e, str);
        this.f18141e = str;
    }

    @WorkerThread
    /* renamed from: D */
    public final String mo19940D() {
        this.f18137a.zzp().zzc();
        return this.f18155s;
    }

    @WorkerThread
    /* renamed from: E */
    public final void mo19941E(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18157u != j;
        this.f18157u = j;
    }

    @WorkerThread
    /* renamed from: F */
    public final void mo19942F(String str) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m10994R(this.f18142f, str);
        this.f18142f = str;
    }

    @WorkerThread
    /* renamed from: G */
    public final String mo19943G() {
        this.f18137a.zzp().zzc();
        return this.f18159w;
    }

    @WorkerThread
    /* renamed from: H */
    public final void mo19944H(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.f18137a.zzp().zzc();
        boolean z2 = this.f18134E;
        if (this.f18143g == j) {
            z = false;
        }
        this.f18134E = z | z2;
        this.f18143g = j;
    }

    @WorkerThread
    /* renamed from: I */
    public final void mo19945I(String str) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m10994R(this.f18146j, str);
        this.f18146j = str;
    }

    @WorkerThread
    /* renamed from: J */
    public final String mo19946J() {
        this.f18137a.zzp().zzc();
        return this.f18141e;
    }

    @WorkerThread
    /* renamed from: K */
    public final void mo19947K(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18135F != j;
        this.f18135F = j;
    }

    @WorkerThread
    /* renamed from: L */
    public final void mo19948L(String str) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m10994R(this.f18148l, str);
        this.f18148l = str;
    }

    @WorkerThread
    /* renamed from: M */
    public final String mo19949M() {
        this.f18137a.zzp().zzc();
        return this.f18142f;
    }

    @WorkerThread
    /* renamed from: N */
    public final void mo19950N(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18136G != j;
        this.f18136G = j;
    }

    @WorkerThread
    /* renamed from: O */
    public final void mo19951O(String str) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m10994R(this.f18133D, str);
        this.f18133D = str;
    }

    @WorkerThread
    /* renamed from: P */
    public final long mo19952P() {
        this.f18137a.zzp().zzc();
        return this.f18144h;
    }

    @WorkerThread
    /* renamed from: Q */
    public final void mo19953Q(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18160x != j;
        this.f18160x = j;
    }

    @WorkerThread
    /* renamed from: R */
    public final long mo19954R() {
        this.f18137a.zzp().zzc();
        return this.f18145i;
    }

    @WorkerThread
    /* renamed from: S */
    public final void mo19955S(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18161y != j;
        this.f18161y = j;
    }

    @WorkerThread
    /* renamed from: T */
    public final String mo19956T() {
        this.f18137a.zzp().zzc();
        return this.f18146j;
    }

    @WorkerThread
    /* renamed from: U */
    public final void mo19957U(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18162z != j;
        this.f18162z = j;
    }

    @WorkerThread
    /* renamed from: V */
    public final long mo19958V() {
        this.f18137a.zzp().zzc();
        return this.f18147k;
    }

    @WorkerThread
    /* renamed from: W */
    public final void mo19959W(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18130A != j;
        this.f18130A = j;
    }

    @WorkerThread
    /* renamed from: X */
    public final String mo19960X() {
        this.f18137a.zzp().zzc();
        return this.f18148l;
    }

    @WorkerThread
    /* renamed from: Y */
    public final void mo19961Y(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18132C != j;
        this.f18132C = j;
    }

    @WorkerThread
    /* renamed from: Z */
    public final long mo19962Z() {
        this.f18137a.zzp().zzc();
        return this.f18149m;
    }

    @WorkerThread
    /* renamed from: a */
    public final void mo19963a(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18144h != j;
        this.f18144h = j;
    }

    @WorkerThread
    /* renamed from: a0 */
    public final void mo19964a0(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18131B != j;
        this.f18131B = j;
    }

    @WorkerThread
    /* renamed from: b */
    public final void mo19965b(Boolean bool) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m11008u(this.f18156t, bool);
        this.f18156t = bool;
    }

    @WorkerThread
    /* renamed from: b0 */
    public final long mo19966b0() {
        this.f18137a.zzp().zzc();
        return this.f18150n;
    }

    @WorkerThread
    /* renamed from: c */
    public final void mo19967c(String str) {
        this.f18137a.zzp().zzc();
        this.f18134E |= !zzkw.m10994R(this.f18139c, str);
        this.f18139c = str;
    }

    @WorkerThread
    /* renamed from: c0 */
    public final void mo19968c0(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18152p != j;
        this.f18152p = j;
    }

    @WorkerThread
    /* renamed from: d */
    public final void mo19969d(@Nullable List<String> list) {
        this.f18137a.zzp().zzc();
        if (!zzkw.m10988G(this.f18158v, list)) {
            this.f18134E = true;
            this.f18158v = list != null ? new ArrayList(list) : null;
        }
    }

    @WorkerThread
    /* renamed from: d0 */
    public final long mo19970d0() {
        this.f18137a.zzp().zzc();
        return this.f18157u;
    }

    @WorkerThread
    /* renamed from: e */
    public final void mo19971e(boolean z) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18151o != z;
        this.f18151o = z;
    }

    @WorkerThread
    /* renamed from: e0 */
    public final boolean mo19972e0() {
        this.f18137a.zzp().zzc();
        return this.f18151o;
    }

    @WorkerThread
    /* renamed from: f */
    public final boolean mo19973f() {
        this.f18137a.zzp().zzc();
        return this.f18134E;
    }

    @WorkerThread
    /* renamed from: f0 */
    public final long mo19974f0() {
        this.f18137a.zzp().zzc();
        return this.f18143g;
    }

    @WorkerThread
    /* renamed from: g */
    public final long mo19975g() {
        this.f18137a.zzp().zzc();
        return this.f18132C;
    }

    @WorkerThread
    /* renamed from: g0 */
    public final long mo19976g0() {
        this.f18137a.zzp().zzc();
        return this.f18135F;
    }

    @WorkerThread
    /* renamed from: h */
    public final long mo19977h() {
        this.f18137a.zzp().zzc();
        return this.f18131B;
    }

    @WorkerThread
    /* renamed from: h0 */
    public final long mo19978h0() {
        this.f18137a.zzp().zzc();
        return this.f18136G;
    }

    @WorkerThread
    /* renamed from: i */
    public final String mo19979i() {
        this.f18137a.zzp().zzc();
        return this.f18133D;
    }

    @WorkerThread
    /* renamed from: i0 */
    public final void mo19980i0() {
        this.f18137a.zzp().zzc();
        long j = this.f18143g + 1;
        if (j > 2147483647L) {
            this.f18137a.zzq().zzh().zza("Bundle index overflow. appId", zzer.zza(this.f18138b));
            j = 0;
        }
        this.f18134E = true;
        this.f18143g = j;
    }

    @WorkerThread
    /* renamed from: j */
    public final String mo19981j() {
        this.f18137a.zzp().zzc();
        String str = this.f18133D;
        mo19951O((String) null);
        return str;
    }

    @WorkerThread
    /* renamed from: j0 */
    public final long mo19982j0() {
        this.f18137a.zzp().zzc();
        return this.f18160x;
    }

    @WorkerThread
    /* renamed from: k */
    public final long mo19983k() {
        this.f18137a.zzp().zzc();
        return this.f18152p;
    }

    @WorkerThread
    /* renamed from: k0 */
    public final long mo19984k0() {
        this.f18137a.zzp().zzc();
        return this.f18161y;
    }

    @WorkerThread
    /* renamed from: l */
    public final boolean mo19985l() {
        this.f18137a.zzp().zzc();
        return this.f18153q;
    }

    @WorkerThread
    /* renamed from: l0 */
    public final long mo19986l0() {
        this.f18137a.zzp().zzc();
        return this.f18162z;
    }

    @WorkerThread
    /* renamed from: m */
    public final boolean mo19987m() {
        this.f18137a.zzp().zzc();
        return this.f18154r;
    }

    @WorkerThread
    /* renamed from: m0 */
    public final long mo19988m0() {
        this.f18137a.zzp().zzc();
        return this.f18130A;
    }

    @WorkerThread
    /* renamed from: n */
    public final Boolean mo19989n() {
        this.f18137a.zzp().zzc();
        return this.f18156t;
    }

    @WorkerThread
    @Nullable
    /* renamed from: o */
    public final List<String> mo19990o() {
        this.f18137a.zzp().zzc();
        return this.f18158v;
    }

    @WorkerThread
    /* renamed from: p */
    public final void mo19991p() {
        this.f18137a.zzp().zzc();
        this.f18134E = false;
    }

    @WorkerThread
    /* renamed from: q */
    public final void mo19992q(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18145i != j;
        this.f18145i = j;
    }

    @WorkerThread
    /* renamed from: r */
    public final void mo19993r(String str) {
        this.f18137a.zzp().zzc();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f18134E |= !zzkw.m10994R(this.f18140d, str);
        this.f18140d = str;
    }

    @WorkerThread
    /* renamed from: s */
    public final void mo19994s(boolean z) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18153q != z;
        this.f18153q = z;
    }

    @WorkerThread
    /* renamed from: t */
    public final String mo19995t() {
        this.f18137a.zzp().zzc();
        return this.f18138b;
    }

    @WorkerThread
    /* renamed from: u */
    public final void mo19996u(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18147k != j;
        this.f18147k = j;
    }

    @WorkerThread
    /* renamed from: v */
    public final void mo19997v(String str) {
        this.f18137a.zzp().zzc();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f18134E |= !zzkw.m10994R(this.f18155s, str);
        this.f18155s = str;
    }

    @WorkerThread
    /* renamed from: w */
    public final void mo19998w(boolean z) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18154r != z;
        this.f18154r = z;
    }

    @WorkerThread
    /* renamed from: x */
    public final String mo19999x() {
        this.f18137a.zzp().zzc();
        return this.f18139c;
    }

    @WorkerThread
    /* renamed from: y */
    public final void mo20000y(long j) {
        this.f18137a.zzp().zzc();
        this.f18134E |= this.f18149m != j;
        this.f18149m = j;
    }

    @WorkerThread
    /* renamed from: z */
    public final void mo20001z(String str) {
        this.f18137a.zzp().zzc();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f18134E |= !zzkw.m10994R(this.f18159w, str);
        this.f18159w = str;
    }
}
