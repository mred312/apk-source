package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbr;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.y1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2609y1 implements zzahv<zzalz> {

    /* renamed from: a */
    private final /* synthetic */ zzef f11968a;

    /* renamed from: b */
    private final /* synthetic */ zzako f11969b;

    /* renamed from: c */
    private final /* synthetic */ zzbr f11970c;

    /* renamed from: d */
    private final /* synthetic */ zzalb f11971d;

    C2609y1(zzalb zzalb, zzef zzef, zzako zzako, zzbr zzbr) {
        this.f11971d = zzalb;
        this.f11968a = zzef;
        this.f11969b = zzako;
        this.f11970c = zzbr;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzalz zzalz = (zzalz) obj;
        synchronized (this.f11971d.f12503a) {
            zzaza.zzez("JS Engine is requesting an update");
            if (this.f11971d.f12510h == 0) {
                zzaza.zzez("Starting reload.");
                int unused = this.f11971d.f12510h = 2;
                this.f11971d.zza(this.f11968a);
            }
            this.f11969b.zzb("/requestReload", (zzahv) this.f11970c.get());
        }
    }
}
