package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {

    /* renamed from: a */
    final C0930b f4364a;

    /* renamed from: b */
    C0929a f4365b = new C0929a();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    /* renamed from: androidx.recyclerview.widget.ViewBoundsCheck$a */
    static class C0929a {

        /* renamed from: a */
        int f4366a = 0;

        /* renamed from: b */
        int f4367b;

        /* renamed from: c */
        int f4368c;

        /* renamed from: d */
        int f4369d;

        /* renamed from: e */
        int f4370e;

        C0929a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7615a(int i) {
            this.f4366a = i | this.f4366a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo7616b() {
            int i = this.f4366a;
            if ((i & 7) != 0 && (i & (mo7617c(this.f4369d, this.f4367b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f4366a;
            if ((i2 & 112) != 0 && (i2 & (mo7617c(this.f4369d, this.f4368c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f4366a;
            if ((i3 & 1792) != 0 && (i3 & (mo7617c(this.f4370e, this.f4367b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f4366a;
            if ((i4 & 28672) == 0 || (i4 & (mo7617c(this.f4370e, this.f4368c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo7617c(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7618d() {
            this.f4366a = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo7619e(int i, int i2, int i3, int i4) {
            this.f4367b = i;
            this.f4368c = i2;
            this.f4369d = i3;
            this.f4370e = i4;
        }
    }

    /* renamed from: androidx.recyclerview.widget.ViewBoundsCheck$b */
    interface C0930b {
        /* renamed from: a */
        View mo7265a(int i);

        /* renamed from: b */
        int mo7266b(View view);

        /* renamed from: c */
        int mo7267c();

        /* renamed from: d */
        int mo7268d();

        /* renamed from: e */
        int mo7269e(View view);
    }

    ViewBoundsCheck(C0930b bVar) {
        this.f4364a = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo7613a(int i, int i2, int i3, int i4) {
        int c = this.f4364a.mo7267c();
        int d = this.f4364a.mo7268d();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a = this.f4364a.mo7265a(i);
            this.f4365b.mo7619e(c, d, this.f4364a.mo7266b(a), this.f4364a.mo7269e(a));
            if (i3 != 0) {
                this.f4365b.mo7618d();
                this.f4365b.mo7615a(i3);
                if (this.f4365b.mo7616b()) {
                    return a;
                }
            }
            if (i4 != 0) {
                this.f4365b.mo7618d();
                this.f4365b.mo7615a(i4);
                if (this.f4365b.mo7616b()) {
                    view = a;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo7614b(View view, int i) {
        this.f4365b.mo7619e(this.f4364a.mo7267c(), this.f4364a.mo7268d(), this.f4364a.mo7266b(view), this.f4364a.mo7269e(view));
        if (i == 0) {
            return false;
        }
        this.f4365b.mo7618d();
        this.f4365b.mo7615a(i);
        return this.f4365b.mo7616b();
    }
}
