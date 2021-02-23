package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.m */
/* compiled from: RtlSpacingHelper */
class C0334m {

    /* renamed from: a */
    private int f1686a = 0;

    /* renamed from: b */
    private int f1687b = 0;

    /* renamed from: c */
    private int f1688c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f1689d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f1690e = 0;

    /* renamed from: f */
    private int f1691f = 0;

    /* renamed from: g */
    private boolean f1692g = false;

    /* renamed from: h */
    private boolean f1693h = false;

    C0334m() {
    }

    /* renamed from: a */
    public int mo3063a() {
        return this.f1692g ? this.f1686a : this.f1687b;
    }

    /* renamed from: b */
    public int mo3064b() {
        return this.f1686a;
    }

    /* renamed from: c */
    public int mo3065c() {
        return this.f1687b;
    }

    /* renamed from: d */
    public int mo3066d() {
        return this.f1692g ? this.f1687b : this.f1686a;
    }

    /* renamed from: e */
    public void mo3067e(int i, int i2) {
        this.f1693h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1690e = i;
            this.f1686a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1691f = i2;
            this.f1687b = i2;
        }
    }

    /* renamed from: f */
    public void mo3068f(boolean z) {
        if (z != this.f1692g) {
            this.f1692g = z;
            if (!this.f1693h) {
                this.f1686a = this.f1690e;
                this.f1687b = this.f1691f;
            } else if (z) {
                int i = this.f1689d;
                if (i == Integer.MIN_VALUE) {
                    i = this.f1690e;
                }
                this.f1686a = i;
                int i2 = this.f1688c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f1691f;
                }
                this.f1687b = i2;
            } else {
                int i3 = this.f1688c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f1690e;
                }
                this.f1686a = i3;
                int i4 = this.f1689d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f1691f;
                }
                this.f1687b = i4;
            }
        }
    }

    /* renamed from: g */
    public void mo3069g(int i, int i2) {
        this.f1688c = i;
        this.f1689d = i2;
        this.f1693h = true;
        if (this.f1692g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1686a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1687b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1686a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1687b = i2;
        }
    }
}
