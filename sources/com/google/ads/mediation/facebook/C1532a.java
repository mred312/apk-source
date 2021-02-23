package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.ads.mediation.facebook.a */
/* compiled from: FacebookInitializer */
class C1532a implements AudienceNetworkAds.InitListener {

    /* renamed from: d */
    private static C1532a f7031d;

    /* renamed from: a */
    private boolean f7032a = false;

    /* renamed from: b */
    private boolean f7033b = false;

    /* renamed from: c */
    private ArrayList<C1533a> f7034c = new ArrayList<>();

    /* renamed from: com.google.ads.mediation.facebook.a$a */
    /* compiled from: FacebookInitializer */
    interface C1533a {
        /* renamed from: a */
        void mo11196a(String str);

        /* renamed from: b */
        void mo11197b();
    }

    private C1532a() {
    }

    /* renamed from: a */
    static C1532a m4999a() {
        if (f7031d == null) {
            f7031d = new C1532a();
        }
        return f7031d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo11224b(Context context, String str, C1533a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        m4999a().mo11225c(context, arrayList, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo11225c(Context context, ArrayList<String> arrayList, C1533a aVar) {
        if (this.f7032a) {
            this.f7034c.add(aVar);
        } else if (this.f7033b) {
            aVar.mo11197b();
        } else {
            this.f7032a = true;
            m4999a().f7034c.add(aVar);
            AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:6.0.0.0").withPlacementIds(arrayList).withInitListener(this).initialize();
        }
    }

    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        this.f7032a = false;
        this.f7033b = initResult.isSuccess();
        Iterator<C1533a> it = this.f7034c.iterator();
        while (it.hasNext()) {
            C1533a next = it.next();
            if (initResult.isSuccess()) {
                next.mo11197b();
            } else {
                next.mo11196a(initResult.getMessage());
            }
        }
        this.f7034c.clear();
    }
}
