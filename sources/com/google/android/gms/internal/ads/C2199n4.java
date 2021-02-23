package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.ads.n4 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final /* synthetic */ class C2199n4 implements zzazc {

    /* renamed from: a */
    static final zzazc f10035a = new C2199n4();

    private C2199n4() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzavn) {
            return (zzavn) queryLocalInterface;
        }
        return new zzavm(iBinder);
    }
}
