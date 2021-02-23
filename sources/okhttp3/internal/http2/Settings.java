package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;

public final class Settings {

    /* renamed from: a */
    private int f21262a;

    /* renamed from: b */
    private final int[] f21263b = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25083a() {
        this.f21262a = 0;
        Arrays.fill(this.f21263b, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo25084b(int i) {
        return this.f21263b[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo25085c() {
        if ((this.f21262a & 2) != 0) {
            return this.f21263b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo25086d() {
        return (this.f21262a & 128) != 0 ? this.f21263b[7] : SupportMenu.USER_MASK;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo25087e(int i) {
        return (this.f21262a & 16) != 0 ? this.f21263b[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo25088f(int i) {
        return (this.f21262a & 32) != 0 ? this.f21263b[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo25089g(int i) {
        return ((1 << i) & this.f21262a) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo25090h(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.mo25089g(i)) {
                mo25091i(i, settings.mo25084b(i));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Settings mo25091i(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f21263b;
            if (i < iArr.length) {
                this.f21262a = (1 << i) | this.f21262a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo25092j() {
        return Integer.bitCount(this.f21262a);
    }
}
