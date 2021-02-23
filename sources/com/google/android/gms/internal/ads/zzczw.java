package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczw implements zzdfj<Bundle> {

    /* renamed from: a */
    private final Context f15108a;

    /* renamed from: b */
    private final zzvn f15109b;

    /* renamed from: c */
    private final List<Parcelable> f15110c;

    public zzczw(Context context, zzvn zzvn, List<Parcelable> list) {
        this.f15108a = context;
        this.f15109b = zzvn;
        this.f15110c = list;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (zzadd.zzdcy.get().booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzp.zzkq();
            bundle2.putString("activity", zzm.zzar(this.f15108a));
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.f15109b.width);
            bundle3.putInt("height", this.f15109b.height);
            bundle2.putBundle("size", bundle3);
            if (this.f15110c.size() > 0) {
                List<Parcelable> list = this.f15110c;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
