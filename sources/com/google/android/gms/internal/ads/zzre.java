package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzre {

    /* renamed from: a */
    private final int f16916a;

    /* renamed from: b */
    private final int f16917b;

    /* renamed from: c */
    private final int f16918c;

    /* renamed from: d */
    private final boolean f16919d;

    /* renamed from: e */
    private final zzrt f16920e;

    /* renamed from: f */
    private final zzsa f16921f;

    /* renamed from: g */
    private final Object f16922g = new Object();

    /* renamed from: h */
    private ArrayList<String> f16923h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<String> f16924i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<zzrr> f16925j = new ArrayList<>();

    /* renamed from: k */
    private int f16926k = 0;

    /* renamed from: l */
    private int f16927l = 0;

    /* renamed from: m */
    private int f16928m = 0;

    /* renamed from: n */
    private int f16929n;

    /* renamed from: o */
    private String f16930o = "";

    /* renamed from: p */
    private String f16931p = "";

    /* renamed from: q */
    private String f16932q = "";

    public zzre(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.f16916a = i;
        this.f16917b = i2;
        this.f16918c = i3;
        this.f16919d = z;
        this.f16920e = new zzrt(i4);
        this.f16921f = new zzsa(i5, i6, i7);
    }

    /* renamed from: a */
    private static String m9078a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    /* renamed from: b */
    private final void m9079b(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.f16918c) {
            synchronized (this.f16922g) {
                this.f16923h.add(str);
                this.f16926k += str.length();
                if (z) {
                    this.f16924i.add(str);
                    this.f16925j.add(new zzrr(f, f2, f3, f4, this.f16924i.size() - 1));
                }
            }
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private final int m9080c(int i, int i2) {
        if (this.f16919d) {
            return this.f16917b;
        }
        return (i * this.f16916a) + (i2 * this.f16917b);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: d */
    public final int mo18167d() {
        return this.f16926k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzre)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzre) obj).f16930o;
        return str != null && str.equals(this.f16930o);
    }

    public final int getScore() {
        return this.f16929n;
    }

    public final int hashCode() {
        return this.f16930o.hashCode();
    }

    public final String toString() {
        int i = this.f16927l;
        int i2 = this.f16929n;
        int i3 = this.f16926k;
        String a = m9078a(this.f16923h, 100);
        String a2 = m9078a(this.f16924i, 100);
        String str = this.f16930o;
        String str2 = this.f16931p;
        String str3 = this.f16932q;
        StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 165 + String.valueOf(a2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(a);
        sb.append("\n viewableText");
        sb.append(a2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        m9079b(str, z, f, f2, f3, f4);
        synchronized (this.f16922g) {
            if (this.f16928m < 0) {
                zzaza.zzeb("ActivityContent: negative number of WebViews.");
            }
            zzmf();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        m9079b(str, z, f, f2, f3, f4);
    }

    public final void zzbt(int i) {
        this.f16927l = i;
    }

    public final boolean zzlx() {
        boolean z;
        synchronized (this.f16922g) {
            z = this.f16928m == 0;
        }
        return z;
    }

    public final String zzly() {
        return this.f16930o;
    }

    public final String zzlz() {
        return this.f16931p;
    }

    public final String zzma() {
        return this.f16932q;
    }

    public final void zzmb() {
        synchronized (this.f16922g) {
            this.f16929n -= 100;
        }
    }

    public final void zzmc() {
        synchronized (this.f16922g) {
            this.f16928m--;
        }
    }

    public final void zzmd() {
        synchronized (this.f16922g) {
            this.f16928m++;
        }
    }

    public final void zzme() {
        synchronized (this.f16922g) {
            int c = m9080c(this.f16926k, this.f16927l);
            if (c > this.f16929n) {
                this.f16929n = c;
            }
        }
    }

    public final void zzmf() {
        synchronized (this.f16922g) {
            int c = m9080c(this.f16926k, this.f16927l);
            if (c > this.f16929n) {
                this.f16929n = c;
                if (!zzp.zzku().zzwz().zzxp()) {
                    this.f16930o = this.f16920e.zza(this.f16923h);
                    this.f16931p = this.f16920e.zza(this.f16924i);
                }
                if (!zzp.zzku().zzwz().zzxr()) {
                    this.f16932q = this.f16921f.zza(this.f16924i, this.f16925j);
                }
            }
        }
    }
}
