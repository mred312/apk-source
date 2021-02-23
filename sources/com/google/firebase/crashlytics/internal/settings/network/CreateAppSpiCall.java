package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;

public class CreateAppSpiCall extends C3457a {
    public CreateAppSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, HttpMethod.POST, str3);
    }

    public /* bridge */ /* synthetic */ boolean invoke(AppRequestData appRequestData, boolean z) {
        return super.invoke(appRequestData, z);
    }
}
