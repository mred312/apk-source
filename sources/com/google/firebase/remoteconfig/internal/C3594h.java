package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* renamed from: com.google.firebase.remoteconfig.internal.h */
/* compiled from: ConfigFetchHandler */
final /* synthetic */ class C3594h implements SuccessContinuation {

    /* renamed from: a */
    private final ConfigFetchHandler.FetchResponse f20299a;

    private C3594h(ConfigFetchHandler.FetchResponse fetchResponse) {
        this.f20299a = fetchResponse;
    }

    /* renamed from: a */
    public static SuccessContinuation m12188a(ConfigFetchHandler.FetchResponse fetchResponse) {
        return new C3594h(fetchResponse);
    }

    public Task then(Object obj) {
        return Tasks.forResult(this.f20299a);
    }
}
