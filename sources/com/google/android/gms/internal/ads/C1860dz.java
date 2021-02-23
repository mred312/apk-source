package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.internal.ads.dz */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1860dz implements zzdpd {
    @GuardedBy("this")

    /* renamed from: a */
    private final ConcurrentHashMap<zzdpq, C1786bz> f8297a;

    /* renamed from: b */
    private zzdpk f8298b;

    /* renamed from: c */
    private C1897ez f8299c = new C1897ez();

    public C1860dz(zzdpk zzdpk) {
        this.f8297a = new ConcurrentHashMap<>(zzdpk.zzhlo);
        this.f8298b = zzdpk;
    }

    /* renamed from: a */
    private final void m5993a() {
        if (zzdpk.zzavr()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8298b.zzhlm);
            sb.append(" PoolCollection");
            sb.append(this.f8299c.mo13928g());
            int i = 0;
            for (Map.Entry next : this.f8297a.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(next.getValue());
                sb.append("#");
                sb.append(((zzdpq) next.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((C1786bz) next.getValue()).mo13720b(); i2++) {
                    sb.append("[O]");
                }
                for (int b = ((C1786bz) next.getValue()).mo13720b(); b < this.f8298b.zzhlo; b++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((C1786bz) next.getValue()).mo13724f());
                sb.append("\n");
            }
            while (i < this.f8298b.zzhln) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzaza.zzeb(sb.toString());
        }
    }

    /* renamed from: b */
    private final void m5994b(zzdpn<?> zzdpn, zzdqg zzdqg) {
        if (zzdpn != null) {
            zzdpn.zzhmb.zzakk().zzc((zzue.zzb) ((zzekh) zzue.zzb.zznk().zza(zzue.zzb.zza.zznm().zza(zzue.zzb.C3994zzb.IN_MEMORY).zza(zzue.zzb.zzd.zzno().zzq(zzdqg.zzhnd).zzby(zzdqg.zzhmy))).zzbhv()));
        }
        m5993a();
    }

    @Nullable
    public final synchronized zzdpn<?> zza(zzdpq zzdpq) {
        zzdpn<?> zzdpn;
        C1786bz bzVar = this.f8297a.get(zzdpq);
        zzdpn = null;
        if (bzVar != null) {
            zzdpn = bzVar.mo13721c();
            if (zzdpn == null) {
                this.f8299c.mo13923b();
            }
            m5994b(zzdpn, bzVar.mo13725g());
        } else {
            this.f8299c.mo13922a();
            m5994b((zzdpn<?>) null, (zzdqg) null);
        }
        return zzdpn;
    }

    public final zzdpk zzavc() {
        return this.f8298b;
    }

    public final synchronized boolean zzb(zzdpq zzdpq) {
        C1786bz bzVar = this.f8297a.get(zzdpq);
        if (bzVar == null) {
            return true;
        }
        if (bzVar.mo13720b() < this.f8298b.zzhlo) {
            return true;
        }
        return false;
    }

    public final synchronized boolean zza(zzdpq zzdpq, zzdpn<?> zzdpn) {
        boolean i;
        C1786bz bzVar = this.f8297a.get(zzdpq);
        zzdpn.zzhmd = zzp.zzkx().currentTimeMillis();
        if (bzVar == null) {
            zzdpk zzdpk = this.f8298b;
            bzVar = new C1786bz(zzdpk.zzhlo, zzdpk.zzhlp * 1000);
            int size = this.f8297a.size();
            zzdpk zzdpk2 = this.f8298b;
            if (size == zzdpk2.zzhln) {
                int i2 = C1823cz.f8041a[zzdpk2.zzhls - 1];
                long j = Long.MAX_VALUE;
                zzdpq zzdpq2 = null;
                if (i2 == 1) {
                    for (Map.Entry next : this.f8297a.entrySet()) {
                        if (((C1786bz) next.getValue()).mo13719a() < j) {
                            j = ((C1786bz) next.getValue()).mo13719a();
                            zzdpq2 = (zzdpq) next.getKey();
                        }
                    }
                    if (zzdpq2 != null) {
                        this.f8297a.remove(zzdpq2);
                    }
                } else if (i2 == 2) {
                    for (Map.Entry next2 : this.f8297a.entrySet()) {
                        if (((C1786bz) next2.getValue()).mo13722d() < j) {
                            j = ((C1786bz) next2.getValue()).mo13722d();
                            zzdpq2 = (zzdpq) next2.getKey();
                        }
                    }
                    if (zzdpq2 != null) {
                        this.f8297a.remove(zzdpq2);
                    }
                } else if (i2 == 3) {
                    int i3 = Integer.MAX_VALUE;
                    for (Map.Entry next3 : this.f8297a.entrySet()) {
                        if (((C1786bz) next3.getValue()).mo13723e() < i3) {
                            i3 = ((C1786bz) next3.getValue()).mo13723e();
                            zzdpq2 = (zzdpq) next3.getKey();
                        }
                    }
                    if (zzdpq2 != null) {
                        this.f8297a.remove(zzdpq2);
                    }
                }
                this.f8299c.mo13925d();
            }
            this.f8297a.put(zzdpq, bzVar);
            this.f8299c.mo13924c();
        }
        i = bzVar.mo13726i(zzdpn);
        this.f8299c.mo13926e();
        zzdph f = this.f8299c.mo13927f();
        zzdqg g = bzVar.mo13725g();
        if (zzdpn != null) {
            zzdpn.zzhmb.zzakk().zzd((zzue.zzb) ((zzekh) zzue.zzb.zznk().zza(zzue.zzb.zza.zznm().zza(zzue.zzb.C3994zzb.IN_MEMORY).zza(zzue.zzb.zze.zznq().zzs(f.zzhkw).zzt(f.zzhkx).zzca(g.zzhmy))).zzbhv()));
        }
        m5993a();
        return i;
    }

    @Deprecated
    public final zzdpq zza(zzvk zzvk, String str, zzvw zzvw) {
        return new zzdpp(zzvk, str, new zzatt(this.f8298b.context).zzvz().zzdwr, this.f8298b.zzhlq, zzvw);
    }
}
