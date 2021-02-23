package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.b */
/* compiled from: ChildHelper */
class C0934b {

    /* renamed from: a */
    final C0936b f4383a;

    /* renamed from: b */
    final C0935a f4384b = new C0935a();

    /* renamed from: c */
    final List<View> f4385c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.b$a */
    /* compiled from: ChildHelper */
    static class C0935a {

        /* renamed from: a */
        long f4386a = 0;

        /* renamed from: b */
        C0935a f4387b;

        C0935a() {
        }

        /* renamed from: c */
        private void m3471c() {
            if (this.f4387b == null) {
                this.f4387b = new C0935a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7660a(int i) {
            if (i >= 64) {
                C0935a aVar = this.f4387b;
                if (aVar != null) {
                    aVar.mo7660a(i - 64);
                    return;
                }
                return;
            }
            this.f4386a &= (1 << i) ^ -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo7661b(int i) {
            C0935a aVar = this.f4387b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f4386a);
                }
                return Long.bitCount(this.f4386a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f4386a & ((1 << i) - 1));
            } else {
                return aVar.mo7661b(i - 64) + Long.bitCount(this.f4386a);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo7662d(int i) {
            if (i < 64) {
                return (this.f4386a & (1 << i)) != 0;
            }
            m3471c();
            return this.f4387b.mo7662d(i - 64);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo7663e(int i, boolean z) {
            if (i >= 64) {
                m3471c();
                this.f4387b.mo7663e(i - 64, z);
                return;
            }
            long j = this.f4386a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.f4386a = ((j & (j2 ^ -1)) << 1) | (j & j2);
            if (z) {
                mo7666h(i);
            } else {
                mo7660a(i);
            }
            if (z2 || this.f4387b != null) {
                m3471c();
                this.f4387b.mo7663e(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public boolean mo7664f(int i) {
            if (i >= 64) {
                m3471c();
                return this.f4387b.mo7664f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.f4386a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (j ^ -1);
            this.f4386a = j3;
            long j4 = j - 1;
            this.f4386a = (j3 & j4) | Long.rotateRight((j4 ^ -1) & j3, 1);
            C0935a aVar = this.f4387b;
            if (aVar != null) {
                if (aVar.mo7662d(0)) {
                    mo7666h(63);
                }
                this.f4387b.mo7664f(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo7665g() {
            this.f4386a = 0;
            C0935a aVar = this.f4387b;
            if (aVar != null) {
                aVar.mo7665g();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo7666h(int i) {
            if (i >= 64) {
                m3471c();
                this.f4387b.mo7666h(i - 64);
                return;
            }
            this.f4386a |= 1 << i;
        }

        public String toString() {
            if (this.f4387b == null) {
                return Long.toBinaryString(this.f4386a);
            }
            return this.f4387b.toString() + "xx" + Long.toBinaryString(this.f4386a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b */
    /* compiled from: ChildHelper */
    interface C0936b {
        /* renamed from: a */
        View mo7427a(int i);

        void addView(View view, int i);

        /* renamed from: b */
        void mo7429b(View view);

        /* renamed from: c */
        int mo7430c();

        /* renamed from: d */
        void mo7431d();

        /* renamed from: e */
        int mo7432e(View view);

        /* renamed from: f */
        RecyclerView.ViewHolder mo7433f(View view);

        /* renamed from: g */
        void mo7434g(int i);

        /* renamed from: h */
        void mo7435h(View view);

        /* renamed from: i */
        void mo7436i(int i);

        /* renamed from: j */
        void mo7437j(View view, int i, ViewGroup.LayoutParams layoutParams);
    }

    C0934b(C0936b bVar) {
        this.f4383a = bVar;
    }

    /* renamed from: h */
    private int m3451h(int i) {
        if (i < 0) {
            return -1;
        }
        int c = this.f4383a.mo7430c();
        int i2 = i;
        while (i2 < c) {
            int b = i - (i2 - this.f4384b.mo7661b(i2));
            if (b == 0) {
                while (this.f4384b.mo7662d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b;
        }
        return -1;
    }

    /* renamed from: l */
    private void m3452l(View view) {
        this.f4385c.add(view);
        this.f4383a.mo7429b(view);
    }

    /* renamed from: t */
    private boolean m3453t(View view) {
        if (!this.f4385c.remove(view)) {
            return false;
        }
        this.f4383a.mo7435h(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7642a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f4383a.mo7430c();
        } else {
            i2 = m3451h(i);
        }
        this.f4384b.mo7663e(i2, z);
        if (z) {
            m3452l(view);
        }
        this.f4383a.addView(view, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7643b(View view, boolean z) {
        mo7642a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7644c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f4383a.mo7430c();
        } else {
            i2 = m3451h(i);
        }
        this.f4384b.mo7663e(i2, z);
        if (z) {
            m3452l(view);
        }
        this.f4383a.mo7437j(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo7645d(int i) {
        int h = m3451h(i);
        this.f4384b.mo7664f(h);
        this.f4383a.mo7434g(h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public View mo7646e(int i) {
        int size = this.f4385c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f4385c.get(i2);
            RecyclerView.ViewHolder f = this.f4383a.mo7433f(view);
            if (f.getLayoutPosition() == i && !f.mo7405n() && !f.mo7406o()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public View mo7647f(int i) {
        return this.f4383a.mo7427a(m3451h(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo7648g() {
        return this.f4383a.mo7430c() - this.f4385c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public View mo7649i(int i) {
        return this.f4383a.mo7427a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo7650j() {
        return this.f4383a.mo7430c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo7651k(View view) {
        int e = this.f4383a.mo7432e(view);
        if (e >= 0) {
            this.f4384b.mo7666h(e);
            m3452l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo7652m(View view) {
        int e = this.f4383a.mo7432e(view);
        if (e != -1 && !this.f4384b.mo7662d(e)) {
            return e - this.f4384b.mo7661b(e);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo7653n(View view) {
        return this.f4385c.contains(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo7654o() {
        this.f4384b.mo7665g();
        for (int size = this.f4385c.size() - 1; size >= 0; size--) {
            this.f4383a.mo7435h(this.f4385c.get(size));
            this.f4385c.remove(size);
        }
        this.f4383a.mo7431d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo7655p(View view) {
        int e = this.f4383a.mo7432e(view);
        if (e >= 0) {
            if (this.f4384b.mo7664f(e)) {
                m3453t(view);
            }
            this.f4383a.mo7436i(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo7656q(int i) {
        int h = m3451h(i);
        View a = this.f4383a.mo7427a(h);
        if (a != null) {
            if (this.f4384b.mo7664f(h)) {
                m3453t(a);
            }
            this.f4383a.mo7436i(h);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean mo7657r(View view) {
        int e = this.f4383a.mo7432e(view);
        if (e == -1) {
            m3453t(view);
            return true;
        } else if (!this.f4384b.mo7662d(e)) {
            return false;
        } else {
            this.f4384b.mo7664f(e);
            m3453t(view);
            this.f4383a.mo7436i(e);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo7658s(View view) {
        int e = this.f4383a.mo7432e(view);
        if (e < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f4384b.mo7662d(e)) {
            this.f4384b.mo7660a(e);
            m3453t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f4384b.toString() + ", hidden list:" + this.f4385c.size();
    }
}
