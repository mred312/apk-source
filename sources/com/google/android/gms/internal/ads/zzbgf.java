package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public interface zzbgf extends IInterface {
    void beginAdUnitExposure(String str);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void endAdUnitExposure(String str);

    long generateEventId();

    String getAppIdOrigin();

    String getAppInstanceId();

    List getConditionalUserProperties(String str, String str2);

    String getCurrentScreenClass();

    String getCurrentScreenName();

    String getGmpAppId();

    int getMaxUserProperties(String str);

    Map getUserProperties(String str, String str2, boolean z);

    void logEvent(String str, String str2, Bundle bundle);

    void performAction(Bundle bundle);

    Bundle performActionWithResponse(Bundle bundle);

    void setConditionalUserProperty(Bundle bundle);

    void zza(String str, String str2, IObjectWrapper iObjectWrapper);

    void zzb(IObjectWrapper iObjectWrapper, String str, String str2);
}
