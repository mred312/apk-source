package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.fc */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1911fc extends zzbme {

    /* renamed from: f */
    private final Context f8440f;

    /* renamed from: g */
    private final View f8441g;
    @Nullable

    /* renamed from: h */
    private final zzbdv f8442h;

    /* renamed from: i */
    private final zzdmx f8443i;

    /* renamed from: j */
    private final zzbnz f8444j;

    /* renamed from: k */
    private final zzccl f8445k;

    /* renamed from: l */
    private final zzbyc f8446l;

    /* renamed from: m */
    private final zzeoz<zzcxi> f8447m;

    /* renamed from: n */
    private final Executor f8448n;

    /* renamed from: o */
    private zzvn f8449o;

    C1911fc(zzbob zzbob, Context context, zzdmx zzdmx, View view, @Nullable zzbdv zzbdv, zzbnz zzbnz, zzccl zzccl, zzbyc zzbyc, zzeoz<zzcxi> zzeoz, Executor executor) {
        super(zzbob);
        this.f8440f = context;
        this.f8441g = view;
        this.f8442h = zzbdv;
        this.f8443i = zzdmx;
        this.f8444j = zzbnz;
        this.f8445k = zzccl;
        this.f8446l = zzbyc;
        this.f8447m = zzeoz;
        this.f8448n = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo13951a() {
        if (this.f8445k.zzanu() != null) {
            try {
                this.f8445k.zzanu().zza(this.f8447m.get(), ObjectWrapper.wrap(this.f8440f));
            } catch (RemoteException e) {
                zzaza.zzc("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final zzys getVideoController() {
        try {
            return this.f8444j.getVideoController();
        } catch (zzdnr unused) {
            return null;
        }
    }

    public final void zza(ViewGroup viewGroup, zzvn zzvn) {
        zzbdv zzbdv;
        if (viewGroup != null && (zzbdv = this.f8442h) != null) {
            zzbdv.zza(zzbfn.zzb(zzvn));
            viewGroup.setMinimumHeight(zzvn.heightPixels);
            viewGroup.setMinimumWidth(zzvn.widthPixels);
            this.f8449o = zzvn;
        }
    }

    public final zzdmx zzaiy() {
        boolean z;
        zzvn zzvn = this.f8449o;
        if (zzvn != null) {
            return zzdns.zzg(zzvn);
        }
        zzdmu zzdmu = this.zzeri;
        if (zzdmu.zzhhk) {
            Iterator<String> it = zzdmu.zzhgo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdmx(this.f8441g.getWidth(), this.f8441g.getHeight(), false);
            }
        }
        return zzdns.zza(this.zzeri.zzhgw, this.f8443i);
    }

    public final View zzaiz() {
        return this.f8441g;
    }

    public final zzdmx zzajh() {
        return this.f8443i;
    }

    public final int zzaji() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcye)).booleanValue() && this.zzeri.zzhho) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyf)).booleanValue()) {
                return 0;
            }
        }
        return this.zzfpr.zzhik.zzerj.zzhhx;
    }

    public final void zzajj() {
        this.f8448n.execute(new C1874ec(this));
        super.zzajj();
    }

    public final void zzke() {
        this.f8446l.zzalx();
    }
}
