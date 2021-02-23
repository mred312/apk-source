package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczz implements zzdfi<zzczw> {

    /* renamed from: a */
    private final zzdzc f15111a;

    /* renamed from: b */
    private final Context f15112b;

    /* renamed from: c */
    private final zzdnn f15113c;

    /* renamed from: d */
    private final View f15114d;

    public zzczz(zzdzc zzdzc, Context context, zzdnn zzdnn, @Nullable ViewGroup viewGroup) {
        this.f15111a = zzdzc;
        this.f15112b = context;
        this.f15113c = zzdnn;
        this.f15114d = viewGroup;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzczw mo17071a() {
        Context context = this.f15112b;
        zzvn zzvn = this.f15113c.zzbpe;
        ArrayList arrayList = new ArrayList();
        View view = this.f15114d;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzczw(context, zzvn, arrayList);
    }

    public final zzdyz<zzczw> zzasm() {
        return this.f15111a.zze(new C2038is(this));
    }
}
