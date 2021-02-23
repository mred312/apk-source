package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), (UserAgentPublisher) componentContainer.get(UserAgentPublisher.class), (HeartBeatInfo) componentContainer.get(HeartBeatInfo.class));
    }

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseInstallationsApi.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(HeartBeatInfo.class)).add(Dependency.required(UserAgentPublisher.class)).factory(C3483g.m11798a()).build(), LibraryVersionComponent.create("fire-installations", BuildConfig.VERSION_NAME)});
    }
}
