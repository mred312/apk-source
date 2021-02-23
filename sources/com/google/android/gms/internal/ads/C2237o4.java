package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.ads.o4 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2237o4 implements Comparator<byte[]> {
    C2237o4() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((byte[]) obj).length - ((byte[]) obj2).length;
    }
}
