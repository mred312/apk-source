package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Date;

/* renamed from: com.google.firebase.remoteconfig.internal.f */
/* compiled from: ConfigFetchHandler */
final /* synthetic */ class C3592f implements Continuation {

    /* renamed from: a */
    private final ConfigFetchHandler f20293a;

    /* renamed from: b */
    private final Task f20294b;

    /* renamed from: c */
    private final Task f20295c;

    /* renamed from: d */
    private final Date f20296d;

    private C3592f(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        this.f20293a = configFetchHandler;
        this.f20294b = task;
        this.f20295c = task2;
        this.f20296d = date;
    }

    /* renamed from: a */
    public static Continuation m12186a(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date) {
        return new C3592f(configFetchHandler, task, task2, date);
    }

    public Object then(Task task) {
        return ConfigFetchHandler.m12116m(this.f20293a, this.f20294b, this.f20295c, this.f20296d, task);
    }
}
