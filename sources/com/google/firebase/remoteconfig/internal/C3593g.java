package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* renamed from: com.google.firebase.remoteconfig.internal.g */
/* compiled from: ConfigFetchHandler */
final /* synthetic */ class C3593g implements Continuation {

    /* renamed from: a */
    private final ConfigFetchHandler f20297a;

    /* renamed from: b */
    private final Date f20298b;

    private C3593g(ConfigFetchHandler configFetchHandler, Date date) {
        this.f20297a = configFetchHandler;
        this.f20298b = date;
    }

    /* renamed from: a */
    public static Continuation m12187a(ConfigFetchHandler configFetchHandler, Date date) {
        return new C3593g(configFetchHandler, date);
    }

    public Object then(Task task) {
        Task unused = this.f20297a.m12121r(task, this.f20298b);
        return task;
    }
}
