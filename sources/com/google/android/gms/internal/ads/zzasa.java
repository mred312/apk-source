package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public interface zzasa extends IInterface {
    void onError(String str);

    void onSuccess(List<Uri> list);
}
