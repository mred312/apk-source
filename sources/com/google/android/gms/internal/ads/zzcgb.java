package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgb extends zzafe {

    /* renamed from: a */
    private final Context f14293a;

    /* renamed from: b */
    private final zzcce f14294b;

    /* renamed from: c */
    private zzcda f14295c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzcbt f14296d;

    public zzcgb(Context context, zzcce zzcce, zzcda zzcda, zzcbt zzcbt) {
        this.f14293a = context;
        this.f14294b = zzcce;
        this.f14295c = zzcda;
        this.f14296d = zzcbt;
    }

    public final void destroy() {
        zzcbt zzcbt = this.f14296d;
        if (zzcbt != null) {
            zzcbt.destroy();
        }
        this.f14296d = null;
        this.f14295c = null;
    }

    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzadv> zzank = this.f14294b.zzank();
        SimpleArrayMap<String, String> zzanm = this.f14294b.zzanm();
        String[] strArr = new String[(zzank.size() + zzanm.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzank.size()) {
            strArr[i3] = zzank.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzanm.size()) {
            strArr[i3] = zzanm.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.f14294b.getCustomTemplateId();
    }

    public final zzys getVideoController() {
        return this.f14294b.getVideoController();
    }

    public final void performClick(String str) {
        zzcbt zzcbt = this.f14296d;
        if (zzcbt != null) {
            zzcbt.zzfw(str);
        }
    }

    public final void recordImpression() {
        zzcbt zzcbt = this.f14296d;
        if (zzcbt != null) {
            zzcbt.zzamr();
        }
    }

    public final String zzct(String str) {
        return this.f14294b.zzanm().get(str);
    }

    public final zzaej zzcu(String str) {
        return this.f14294b.zzank().get(str);
    }

    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup)) {
            return false;
        }
        zzcda zzcda = this.f14295c;
        if (!(zzcda != null && zzcda.zza((ViewGroup) unwrap))) {
            return false;
        }
        this.f14294b.zzanh().zza((zzadx) new C1844dj(this));
        return true;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzcbt zzcbt;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.f14294b.zzanj() != null && (zzcbt = this.f14296d) != null) {
            zzcbt.zzaa((View) unwrap);
        }
    }

    public final IObjectWrapper zzsv() {
        return null;
    }

    public final IObjectWrapper zzta() {
        return ObjectWrapper.wrap(this.f14293a);
    }

    public final boolean zztb() {
        zzcbt zzcbt = this.f14296d;
        if ((zzcbt == null || zzcbt.zzamy()) && this.f14294b.zzani() != null && this.f14294b.zzanh() == null) {
            return true;
        }
        return false;
    }

    public final boolean zztc() {
        IObjectWrapper zzanj = this.f14294b.zzanj();
        if (zzanj != null) {
            zzp.zzlf().zzab(zzanj);
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcuo)).booleanValue() || this.f14294b.zzani() == null) {
                return true;
            }
            this.f14294b.zzani().zza("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzaza.zzfa("Trying to start OMID session before creation.");
        return false;
    }

    public final void zztd() {
        String zzanl = this.f14294b.zzanl();
        if ("Google".equals(zzanl)) {
            zzaza.zzfa("Illegal argument specified for omid partner name.");
            return;
        }
        zzcbt zzcbt = this.f14296d;
        if (zzcbt != null) {
            zzcbt.zzi(zzanl, false);
        }
    }
}
