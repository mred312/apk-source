package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcce {

    /* renamed from: a */
    private int f14046a;

    /* renamed from: b */
    private zzys f14047b;

    /* renamed from: c */
    private zzaeb f14048c;

    /* renamed from: d */
    private View f14049d;

    /* renamed from: e */
    private List<?> f14050e;

    /* renamed from: f */
    private List<zzzk> f14051f = Collections.emptyList();

    /* renamed from: g */
    private zzzk f14052g;

    /* renamed from: h */
    private Bundle f14053h;

    /* renamed from: i */
    private zzbdv f14054i;
    @Nullable

    /* renamed from: j */
    private zzbdv f14055j;
    @Nullable

    /* renamed from: k */
    private IObjectWrapper f14056k;

    /* renamed from: l */
    private View f14057l;

    /* renamed from: m */
    private IObjectWrapper f14058m;

    /* renamed from: n */
    private double f14059n;

    /* renamed from: o */
    private zzaej f14060o;

    /* renamed from: p */
    private zzaej f14061p;

    /* renamed from: q */
    private String f14062q;

    /* renamed from: r */
    private SimpleArrayMap<String, zzadv> f14063r = new SimpleArrayMap<>();

    /* renamed from: s */
    private SimpleArrayMap<String, String> f14064s = new SimpleArrayMap<>();

    /* renamed from: t */
    private float f14065t;
    @Nullable

    /* renamed from: u */
    private String f14066u;

    /* renamed from: a */
    private final synchronized void m7915a(float f) {
        this.f14065t = f;
    }

    /* renamed from: b */
    private static zzccb m7916b(zzys zzys, @Nullable zzaob zzaob) {
        if (zzys == null) {
            return null;
        }
        return new zzccb(zzys, zzaob);
    }

    /* renamed from: c */
    private static zzcce m7917c(zzys zzys, zzaeb zzaeb, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaej zzaej, String str6, float f) {
        zzcce zzcce = new zzcce();
        zzcce.f14046a = 6;
        zzcce.f14047b = zzys;
        zzcce.f14048c = zzaeb;
        zzcce.f14049d = view;
        String str7 = str;
        zzcce.zzn("headline", str);
        zzcce.f14050e = list;
        String str8 = str2;
        zzcce.zzn("body", str2);
        zzcce.f14053h = bundle;
        String str9 = str3;
        zzcce.zzn("call_to_action", str3);
        zzcce.f14057l = view2;
        zzcce.f14058m = iObjectWrapper;
        String str10 = str4;
        zzcce.zzn(TransactionErrorDetailsUtilities.STORE, str4);
        String str11 = str5;
        zzcce.zzn("price", str5);
        zzcce.f14059n = d;
        zzcce.f14060o = zzaej;
        zzcce.zzn("advertiser", str6);
        zzcce.m7915a(f);
        return zzcce;
    }

    /* renamed from: d */
    private static <T> T m7918d(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    /* renamed from: e */
    private final synchronized String m7919e(String str) {
        return this.f14064s.get(str);
    }

    public final synchronized void destroy() {
        zzbdv zzbdv = this.f14054i;
        if (zzbdv != null) {
            zzbdv.destroy();
            this.f14054i = null;
        }
        zzbdv zzbdv2 = this.f14055j;
        if (zzbdv2 != null) {
            zzbdv2.destroy();
            this.f14055j = null;
        }
        this.f14056k = null;
        this.f14063r.clear();
        this.f14064s.clear();
        this.f14047b = null;
        this.f14048c = null;
        this.f14049d = null;
        this.f14050e = null;
        this.f14053h = null;
        this.f14057l = null;
        this.f14058m = null;
        this.f14060o = null;
        this.f14061p = null;
        this.f14062q = null;
    }

    public final synchronized String getAdvertiser() {
        return m7919e("advertiser");
    }

    public final synchronized String getBody() {
        return m7919e("body");
    }

    public final synchronized String getCallToAction() {
        return m7919e("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.f14062q;
    }

    public final synchronized Bundle getExtras() {
        if (this.f14053h == null) {
            this.f14053h = new Bundle();
        }
        return this.f14053h;
    }

    public final synchronized String getHeadline() {
        return m7919e("headline");
    }

    public final synchronized List<?> getImages() {
        return this.f14050e;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.f14065t;
    }

    public final synchronized List<zzzk> getMuteThisAdReasons() {
        return this.f14051f;
    }

    public final synchronized String getPrice() {
        return m7919e("price");
    }

    public final synchronized double getStarRating() {
        return this.f14059n;
    }

    public final synchronized String getStore() {
        return m7919e(TransactionErrorDetailsUtilities.STORE);
    }

    public final synchronized zzys getVideoController() {
        return this.f14047b;
    }

    public final synchronized void setImages(List<zzadv> list) {
        this.f14050e = list;
    }

    public final synchronized void setStarRating(double d) {
        this.f14059n = d;
    }

    public final synchronized void zza(zzaeb zzaeb) {
        this.f14048c = zzaeb;
    }

    public final synchronized void zzac(View view) {
        this.f14057l = view;
    }

    public final synchronized int zzanc() {
        return this.f14046a;
    }

    public final synchronized View zzand() {
        return this.f14049d;
    }

    @Nullable
    public final zzaej zzane() {
        List<?> list = this.f14050e;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.f14050e.get(0);
            if (obj instanceof IBinder) {
                return zzaei.zzo((IBinder) obj);
            }
        }
        return null;
    }

    @Nullable
    public final synchronized zzzk zzanf() {
        return this.f14052g;
    }

    public final synchronized View zzang() {
        return this.f14057l;
    }

    public final synchronized zzbdv zzanh() {
        return this.f14054i;
    }

    @Nullable
    public final synchronized zzbdv zzani() {
        return this.f14055j;
    }

    @Nullable
    public final synchronized IObjectWrapper zzanj() {
        return this.f14056k;
    }

    public final synchronized SimpleArrayMap<String, zzadv> zzank() {
        return this.f14063r;
    }

    @Nullable
    public final synchronized String zzanl() {
        return this.f14066u;
    }

    public final synchronized SimpleArrayMap<String, String> zzanm() {
        return this.f14064s;
    }

    public final synchronized void zzat(IObjectWrapper iObjectWrapper) {
        this.f14056k = iObjectWrapper;
    }

    public final synchronized void zzb(zzys zzys) {
        this.f14047b = zzys;
    }

    public final synchronized void zzdz(int i) {
        this.f14046a = i;
    }

    public final synchronized void zzfx(String str) {
        this.f14062q = str;
    }

    public final synchronized void zzfy(@Nullable String str) {
        this.f14066u = str;
    }

    public final synchronized void zzh(List<zzzk> list) {
        this.f14051f = list;
    }

    public final synchronized void zzi(zzbdv zzbdv) {
        this.f14054i = zzbdv;
    }

    public final synchronized void zzj(zzbdv zzbdv) {
        this.f14055j = zzbdv;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.f14064s.remove(str);
        } else {
            this.f14064s.put(str, str2);
        }
    }

    public final synchronized zzaej zzsw() {
        return this.f14060o;
    }

    public final synchronized zzaeb zzsx() {
        return this.f14048c;
    }

    public final synchronized IObjectWrapper zzsy() {
        return this.f14058m;
    }

    public final synchronized zzaej zzsz() {
        return this.f14061p;
    }

    public final synchronized void zza(@Nullable zzzk zzzk) {
        this.f14052g = zzzk;
    }

    public final synchronized void zzb(zzaej zzaej) {
        this.f14061p = zzaej;
    }

    public static zzcce zzb(zzaob zzaob) {
        try {
            return m7917c(m7916b(zzaob.getVideoController(), zzaob), zzaob.zzsx(), (View) m7918d(zzaob.zzup()), zzaob.getHeadline(), zzaob.getImages(), zzaob.getBody(), zzaob.getExtras(), zzaob.getCallToAction(), (View) m7918d(zzaob.zzuq()), zzaob.zzsy(), zzaob.getStore(), zzaob.getPrice(), zzaob.getStarRating(), zzaob.zzsw(), zzaob.getAdvertiser(), zzaob.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzaza.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized void zza(zzaej zzaej) {
        this.f14060o = zzaej;
    }

    public final synchronized void zza(String str, zzadv zzadv) {
        if (zzadv == null) {
            this.f14063r.remove(str);
        } else {
            this.f14063r.put(str, zzadv);
        }
    }

    public static zzcce zza(zzanw zzanw) {
        try {
            zzccb b = m7916b(zzanw.getVideoController(), (zzaob) null);
            zzaeb zzsx = zzanw.zzsx();
            String headline = zzanw.getHeadline();
            List<?> images = zzanw.getImages();
            String body = zzanw.getBody();
            Bundle extras = zzanw.getExtras();
            String callToAction = zzanw.getCallToAction();
            IObjectWrapper zzsy = zzanw.zzsy();
            String advertiser = zzanw.getAdvertiser();
            zzaej zzsz = zzanw.zzsz();
            zzcce zzcce = new zzcce();
            zzcce.f14046a = 1;
            zzcce.f14047b = b;
            zzcce.f14048c = zzsx;
            zzcce.f14049d = (View) m7918d(zzanw.zzup());
            zzcce.zzn("headline", headline);
            zzcce.f14050e = images;
            zzcce.zzn("body", body);
            zzcce.f14053h = extras;
            zzcce.zzn("call_to_action", callToAction);
            zzcce.f14057l = (View) m7918d(zzanw.zzuq());
            zzcce.f14058m = zzsy;
            zzcce.zzn("advertiser", advertiser);
            zzcce.f14061p = zzsz;
            return zzcce;
        } catch (RemoteException e) {
            zzaza.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzcce zzb(zzanv zzanv) {
        try {
            return m7917c(m7916b(zzanv.getVideoController(), (zzaob) null), zzanv.zzsx(), (View) m7918d(zzanv.zzup()), zzanv.getHeadline(), zzanv.getImages(), zzanv.getBody(), zzanv.getExtras(), zzanv.getCallToAction(), (View) m7918d(zzanv.zzuq()), zzanv.zzsy(), zzanv.getStore(), zzanv.getPrice(), zzanv.getStarRating(), zzanv.zzsw(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzaza.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzcce zza(zzanv zzanv) {
        try {
            zzccb b = m7916b(zzanv.getVideoController(), (zzaob) null);
            zzaeb zzsx = zzanv.zzsx();
            String headline = zzanv.getHeadline();
            List<?> images = zzanv.getImages();
            String body = zzanv.getBody();
            Bundle extras = zzanv.getExtras();
            String callToAction = zzanv.getCallToAction();
            IObjectWrapper zzsy = zzanv.zzsy();
            String store = zzanv.getStore();
            String price = zzanv.getPrice();
            double starRating = zzanv.getStarRating();
            zzaej zzsw = zzanv.zzsw();
            zzcce zzcce = new zzcce();
            zzcce.f14046a = 2;
            zzcce.f14047b = b;
            zzcce.f14048c = zzsx;
            zzcce.f14049d = (View) m7918d(zzanv.zzup());
            zzcce.zzn("headline", headline);
            zzcce.f14050e = images;
            zzcce.zzn("body", body);
            zzcce.f14053h = extras;
            zzcce.zzn("call_to_action", callToAction);
            zzcce.f14057l = (View) m7918d(zzanv.zzuq());
            zzcce.f14058m = zzsy;
            zzcce.zzn(TransactionErrorDetailsUtilities.STORE, store);
            zzcce.zzn("price", price);
            zzcce.f14059n = starRating;
            zzcce.f14060o = zzsw;
            return zzcce;
        } catch (RemoteException e) {
            zzaza.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzcce zzb(zzanw zzanw) {
        try {
            return m7917c(m7916b(zzanw.getVideoController(), (zzaob) null), zzanw.zzsx(), (View) m7918d(zzanw.zzup()), zzanw.getHeadline(), zzanw.getImages(), zzanw.getBody(), zzanw.getExtras(), zzanw.getCallToAction(), (View) m7918d(zzanw.zzuq()), zzanw.zzsy(), (String) null, (String) null, -1.0d, zzanw.zzsz(), zzanw.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzaza.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }
}
