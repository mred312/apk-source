package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzana extends zzbge {

    /* renamed from: a */
    private final AppMeasurementSdk f12538a;

    zzana(AppMeasurementSdk appMeasurementSdk) {
        this.f12538a = appMeasurementSdk;
    }

    public final void beginAdUnitExposure(String str) {
        this.f12538a.beginAdUnitExposure(str);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f12538a.clearConditionalUserProperty(str, str2, bundle);
    }

    public final void endAdUnitExposure(String str) {
        this.f12538a.endAdUnitExposure(str);
    }

    public final long generateEventId() {
        return this.f12538a.generateEventId();
    }

    public final String getAppIdOrigin() {
        return this.f12538a.getAppIdOrigin();
    }

    public final String getAppInstanceId() {
        return this.f12538a.getAppInstanceId();
    }

    public final List getConditionalUserProperties(String str, String str2) {
        return this.f12538a.getConditionalUserProperties(str, str2);
    }

    public final String getCurrentScreenClass() {
        return this.f12538a.getCurrentScreenClass();
    }

    public final String getCurrentScreenName() {
        return this.f12538a.getCurrentScreenName();
    }

    public final String getGmpAppId() {
        return this.f12538a.getGmpAppId();
    }

    public final int getMaxUserProperties(String str) {
        return this.f12538a.getMaxUserProperties(str);
    }

    public final Map getUserProperties(String str, String str2, boolean z) {
        return this.f12538a.getUserProperties(str, str2, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        this.f12538a.logEvent(str, str2, bundle);
    }

    public final void performAction(Bundle bundle) {
        this.f12538a.performAction(bundle);
    }

    public final Bundle performActionWithResponse(Bundle bundle) {
        return this.f12538a.performActionWithResponse(bundle);
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        this.f12538a.setConditionalUserProperty(bundle);
    }

    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) {
        this.f12538a.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) {
        this.f12538a.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }
}
