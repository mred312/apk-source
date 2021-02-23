package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.C0955h;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a */
/* compiled from: AdapterHelper */
class C0931a implements C0955h.C0956a {

    /* renamed from: a */
    private Pools.Pool<C0933b> f4371a;

    /* renamed from: b */
    final ArrayList<C0933b> f4372b;

    /* renamed from: c */
    final ArrayList<C0933b> f4373c;

    /* renamed from: d */
    final C0932a f4374d;

    /* renamed from: e */
    Runnable f4375e;

    /* renamed from: f */
    final boolean f4376f;

    /* renamed from: g */
    final C0955h f4377g;

    /* renamed from: h */
    private int f4378h;

    /* renamed from: androidx.recyclerview.widget.a$a */
    /* compiled from: AdapterHelper */
    interface C0932a {
        /* renamed from: a */
        void mo7438a(int i, int i2);

        /* renamed from: b */
        void mo7439b(C0933b bVar);

        /* renamed from: c */
        void mo7440c(int i, int i2, Object obj);

        /* renamed from: d */
        void mo7441d(C0933b bVar);

        /* renamed from: e */
        RecyclerView.ViewHolder mo7442e(int i);

        /* renamed from: f */
        void mo7443f(int i, int i2);

        /* renamed from: g */
        void mo7444g(int i, int i2);

        /* renamed from: h */
        void mo7445h(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    /* compiled from: AdapterHelper */
    static class C0933b {

        /* renamed from: a */
        int f4379a;

        /* renamed from: b */
        int f4380b;

        /* renamed from: c */
        Object f4381c;

        /* renamed from: d */
        int f4382d;

        C0933b(int i, int i2, int i3, Object obj) {
            this.f4379a = i;
            this.f4380b = i2;
            this.f4382d = i3;
            this.f4381c = obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo7638a() {
            int i = this.f4379a;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return "rm";
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0933b.class != obj.getClass()) {
                return false;
            }
            C0933b bVar = (C0933b) obj;
            int i = this.f4379a;
            if (i != bVar.f4379a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f4382d - this.f4380b) == 1 && this.f4382d == bVar.f4380b && this.f4380b == bVar.f4382d) {
                return true;
            }
            if (this.f4382d != bVar.f4382d || this.f4380b != bVar.f4380b) {
                return false;
            }
            Object obj2 = this.f4381c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f4381c)) {
                    return false;
                }
            } else if (bVar.f4381c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4379a * 31) + this.f4380b) * 31) + this.f4382d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + mo7638a() + ",s:" + this.f4380b + "c:" + this.f4382d + ",p:" + this.f4381c + "]";
        }
    }

    C0931a(C0932a aVar) {
        this(aVar, false);
    }

    /* renamed from: c */
    private void m3416c(C0933b bVar) {
        m3422v(bVar);
    }

    /* renamed from: d */
    private void m3417d(C0933b bVar) {
        m3422v(bVar);
    }

    /* renamed from: f */
    private void m3418f(C0933b bVar) {
        char c;
        boolean z;
        boolean z2;
        int i = bVar.f4380b;
        int i2 = bVar.f4382d + i;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f4374d.mo7442e(i3) != null || m3420h(i3)) {
                if (c2 == 0) {
                    m3421k(mo7621b(2, i, i4, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m3422v(mo7621b(2, i, i4, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.f4382d) {
            mo7620a(bVar);
            bVar = mo7621b(2, i, i4, (Object) null);
        }
        if (c2 == 0) {
            m3421k(bVar);
        } else {
            m3422v(bVar);
        }
    }

    /* renamed from: g */
    private void m3419g(C0933b bVar) {
        int i = bVar.f4380b;
        int i2 = bVar.f4382d + i;
        int i3 = i;
        char c = 65535;
        int i4 = 0;
        while (i < i2) {
            if (this.f4374d.mo7442e(i) != null || m3420h(i)) {
                if (c == 0) {
                    m3421k(mo7621b(4, i3, i4, bVar.f4381c));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m3422v(mo7621b(4, i3, i4, bVar.f4381c));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.f4382d) {
            Object obj = bVar.f4381c;
            mo7620a(bVar);
            bVar = mo7621b(4, i3, i4, obj);
        }
        if (c == 0) {
            m3421k(bVar);
        } else {
            m3422v(bVar);
        }
    }

    /* renamed from: h */
    private boolean m3420h(int i) {
        int size = this.f4373c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0933b bVar = this.f4373c.get(i2);
            int i3 = bVar.f4379a;
            if (i3 == 8) {
                if (mo7627n(bVar.f4382d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f4380b;
                int i5 = bVar.f4382d + i4;
                while (i4 < i5) {
                    if (mo7627n(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: k */
    private void m3421k(C0933b bVar) {
        int i;
        int i2 = bVar.f4379a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z = m3423z(bVar.f4380b, i2);
        int i3 = bVar.f4380b;
        int i4 = bVar.f4379a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.f4382d; i6++) {
            int z2 = m3423z(bVar.f4380b + (i * i6), bVar.f4379a);
            int i7 = bVar.f4379a;
            if (i7 == 2 ? z2 == z : i7 == 4 && z2 == z + 1) {
                i5++;
            } else {
                C0933b b = mo7621b(i7, z, i5, bVar.f4381c);
                mo7625l(b, i3);
                mo7620a(b);
                if (bVar.f4379a == 4) {
                    i3 += i5;
                }
                z = z2;
                i5 = 1;
            }
        }
        Object obj = bVar.f4381c;
        mo7620a(bVar);
        if (i5 > 0) {
            C0933b b2 = mo7621b(bVar.f4379a, z, i5, obj);
            mo7625l(b2, i3);
            mo7620a(b2);
        }
    }

    /* renamed from: v */
    private void m3422v(C0933b bVar) {
        this.f4373c.add(bVar);
        int i = bVar.f4379a;
        if (i == 1) {
            this.f4374d.mo7444g(bVar.f4380b, bVar.f4382d);
        } else if (i == 2) {
            this.f4374d.mo7443f(bVar.f4380b, bVar.f4382d);
        } else if (i == 4) {
            this.f4374d.mo7440c(bVar.f4380b, bVar.f4382d, bVar.f4381c);
        } else if (i == 8) {
            this.f4374d.mo7438a(bVar.f4380b, bVar.f4382d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* renamed from: z */
    private int m3423z(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f4373c.size() - 1; size >= 0; size--) {
            C0933b bVar = this.f4373c.get(size);
            int i5 = bVar.f4379a;
            if (i5 == 8) {
                int i6 = bVar.f4380b;
                int i7 = bVar.f4382d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            bVar.f4380b = i6 + 1;
                            bVar.f4382d = i7 + 1;
                        } else if (i2 == 2) {
                            bVar.f4380b = i6 - 1;
                            bVar.f4382d = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        bVar.f4382d = i7 + 1;
                    } else if (i2 == 2) {
                        bVar.f4382d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.f4380b = i6 + 1;
                    } else if (i2 == 2) {
                        bVar.f4380b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = bVar.f4380b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= bVar.f4382d;
                    } else if (i5 == 2) {
                        i += bVar.f4382d;
                    }
                } else if (i2 == 1) {
                    bVar.f4380b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.f4380b = i8 - 1;
                }
            }
        }
        for (int size2 = this.f4373c.size() - 1; size2 >= 0; size2--) {
            C0933b bVar2 = this.f4373c.get(size2);
            if (bVar2.f4379a == 8) {
                int i9 = bVar2.f4382d;
                if (i9 == bVar2.f4380b || i9 < 0) {
                    this.f4373c.remove(size2);
                    mo7620a(bVar2);
                }
            } else if (bVar2.f4382d <= 0) {
                this.f4373c.remove(size2);
                mo7620a(bVar2);
            }
        }
        return i;
    }

    /* renamed from: a */
    public void mo7620a(C0933b bVar) {
        if (!this.f4376f) {
            bVar.f4381c = null;
            this.f4371a.release(bVar);
        }
    }

    /* renamed from: b */
    public C0933b mo7621b(int i, int i2, int i3, Object obj) {
        C0933b acquire = this.f4371a.acquire();
        if (acquire == null) {
            return new C0933b(i, i2, i3, obj);
        }
        acquire.f4379a = i;
        acquire.f4380b = i2;
        acquire.f4382d = i3;
        acquire.f4381c = obj;
        return acquire;
    }

    /* renamed from: e */
    public int mo7622e(int i) {
        int size = this.f4372b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0933b bVar = this.f4372b.get(i2);
            int i3 = bVar.f4379a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f4380b;
                    if (i4 <= i) {
                        int i5 = bVar.f4382d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f4380b;
                    if (i6 == i) {
                        i = bVar.f4382d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.f4382d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f4380b <= i) {
                i += bVar.f4382d;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo7623i() {
        int size = this.f4373c.size();
        for (int i = 0; i < size; i++) {
            this.f4374d.mo7441d(this.f4373c.get(i));
        }
        mo7636x(this.f4373c);
        this.f4378h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo7624j() {
        mo7623i();
        int size = this.f4372b.size();
        for (int i = 0; i < size; i++) {
            C0933b bVar = this.f4372b.get(i);
            int i2 = bVar.f4379a;
            if (i2 == 1) {
                this.f4374d.mo7441d(bVar);
                this.f4374d.mo7444g(bVar.f4380b, bVar.f4382d);
            } else if (i2 == 2) {
                this.f4374d.mo7441d(bVar);
                this.f4374d.mo7445h(bVar.f4380b, bVar.f4382d);
            } else if (i2 == 4) {
                this.f4374d.mo7441d(bVar);
                this.f4374d.mo7440c(bVar.f4380b, bVar.f4382d, bVar.f4381c);
            } else if (i2 == 8) {
                this.f4374d.mo7441d(bVar);
                this.f4374d.mo7438a(bVar.f4380b, bVar.f4382d);
            }
            Runnable runnable = this.f4375e;
            if (runnable != null) {
                runnable.run();
            }
        }
        mo7636x(this.f4372b);
        this.f4378h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo7625l(C0933b bVar, int i) {
        this.f4374d.mo7439b(bVar);
        int i2 = bVar.f4379a;
        if (i2 == 2) {
            this.f4374d.mo7445h(i, bVar.f4382d);
        } else if (i2 == 4) {
            this.f4374d.mo7440c(i, bVar.f4382d, bVar.f4381c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo7626m(int i) {
        return mo7627n(i, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public int mo7627n(int i, int i2) {
        int size = this.f4373c.size();
        while (i2 < size) {
            C0933b bVar = this.f4373c.get(i2);
            int i3 = bVar.f4379a;
            if (i3 == 8) {
                int i4 = bVar.f4380b;
                if (i4 == i) {
                    i = bVar.f4382d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.f4382d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f4380b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.f4382d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.f4382d;
                }
            }
            i2++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo7628o(int i) {
        return (i & this.f4378h) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo7629p() {
        return this.f4372b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public boolean mo7630q() {
        return !this.f4373c.isEmpty() && !this.f4372b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean mo7631r(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f4372b.add(mo7621b(4, i, i2, obj));
        this.f4378h |= 4;
        if (this.f4372b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo7632s(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f4372b.add(mo7621b(1, i, i2, (Object) null));
        this.f4378h |= 1;
        if (this.f4372b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo7633t(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f4372b.add(mo7621b(8, i, i2, (Object) null));
            this.f4378h |= 8;
            if (this.f4372b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo7634u(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f4372b.add(mo7621b(2, i, i2, (Object) null));
        this.f4378h |= 2;
        if (this.f4372b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo7635w() {
        this.f4377g.mo7702b(this.f4372b);
        int size = this.f4372b.size();
        for (int i = 0; i < size; i++) {
            C0933b bVar = this.f4372b.get(i);
            int i2 = bVar.f4379a;
            if (i2 == 1) {
                m3416c(bVar);
            } else if (i2 == 2) {
                m3418f(bVar);
            } else if (i2 == 4) {
                m3419g(bVar);
            } else if (i2 == 8) {
                m3417d(bVar);
            }
            Runnable runnable = this.f4375e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f4372b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo7636x(List<C0933b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo7620a(list.get(i));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo7637y() {
        mo7636x(this.f4372b);
        mo7636x(this.f4373c);
        this.f4378h = 0;
    }

    C0931a(C0932a aVar, boolean z) {
        this.f4371a = new Pools.SimplePool(30);
        this.f4372b = new ArrayList<>();
        this.f4373c = new ArrayList<>();
        this.f4378h = 0;
        this.f4374d = aVar;
        this.f4376f = z;
        this.f4377g = new C0955h(this);
    }
}
