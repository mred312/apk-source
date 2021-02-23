package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;

public class DefaultHeartBeatInfo implements HeartBeatInfo {

    /* renamed from: a */
    private C3469b f19568a;

    private DefaultHeartBeatInfo(Context context) {
        this.f19568a = C3469b.m11763a(context);
    }

    /* renamed from: a */
    static /* synthetic */ HeartBeatInfo m11761a(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) componentContainer.get(Context.class));
    }

    @NonNull
    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).factory(C3468a.m11762a()).build();
    }

    @NonNull
    public HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean c = this.f19568a.mo21574c(str, currentTimeMillis);
        boolean b = this.f19568a.mo21573b(currentTimeMillis);
        if (c && b) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (b) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (c) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }
}
