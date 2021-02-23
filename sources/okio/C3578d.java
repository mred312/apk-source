package okio;

import javax.annotation.Nullable;

/* renamed from: okio.d */
/* compiled from: Segment */
final class C3578d {

    /* renamed from: a */
    final byte[] f20213a;

    /* renamed from: b */
    int f20214b;

    /* renamed from: c */
    int f20215c;

    /* renamed from: d */
    boolean f20216d;

    /* renamed from: e */
    boolean f20217e;

    /* renamed from: f */
    C3578d f20218f;

    /* renamed from: g */
    C3578d f20219g;

    C3578d() {
        this.f20213a = new byte[8192];
        this.f20217e = true;
        this.f20216d = false;
    }

    /* renamed from: a */
    public final void mo22595a() {
        C3578d dVar = this.f20219g;
        if (dVar == this) {
            throw new IllegalStateException();
        } else if (dVar.f20217e) {
            int i = this.f20215c - this.f20214b;
            if (i <= (8192 - dVar.f20215c) + (dVar.f20216d ? 0 : dVar.f20214b)) {
                mo22601g(dVar, i);
                mo22596b();
                C3579e.m12094a(this);
            }
        }
    }

    @Nullable
    /* renamed from: b */
    public final C3578d mo22596b() {
        C3578d dVar = this.f20218f;
        C3578d dVar2 = dVar != this ? dVar : null;
        C3578d dVar3 = this.f20219g;
        dVar3.f20218f = dVar;
        this.f20218f.f20219g = dVar3;
        this.f20218f = null;
        this.f20219g = null;
        return dVar2;
    }

    /* renamed from: c */
    public final C3578d mo22597c(C3578d dVar) {
        dVar.f20219g = this;
        dVar.f20218f = this.f20218f;
        this.f20218f.f20219g = dVar;
        this.f20218f = dVar;
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final C3578d mo22598d() {
        this.f20216d = true;
        return new C3578d(this.f20213a, this.f20214b, this.f20215c, true, false);
    }

    /* renamed from: e */
    public final C3578d mo22599e(int i) {
        C3578d dVar;
        if (i <= 0 || i > this.f20215c - this.f20214b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            dVar = mo22598d();
        } else {
            dVar = C3579e.m12095b();
            System.arraycopy(this.f20213a, this.f20214b, dVar.f20213a, 0, i);
        }
        dVar.f20215c = dVar.f20214b + i;
        this.f20214b += i;
        this.f20219g.mo22597c(dVar);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final C3578d mo22600f() {
        return new C3578d((byte[]) this.f20213a.clone(), this.f20214b, this.f20215c, false, true);
    }

    /* renamed from: g */
    public final void mo22601g(C3578d dVar, int i) {
        if (dVar.f20217e) {
            int i2 = dVar.f20215c;
            if (i2 + i > 8192) {
                if (!dVar.f20216d) {
                    int i3 = dVar.f20214b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = dVar.f20213a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        dVar.f20215c -= dVar.f20214b;
                        dVar.f20214b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f20213a, this.f20214b, dVar.f20213a, dVar.f20215c, i);
            dVar.f20215c += i;
            this.f20214b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    C3578d(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f20213a = bArr;
        this.f20214b = i;
        this.f20215c = i2;
        this.f20216d = z;
        this.f20217e = z2;
    }
}
