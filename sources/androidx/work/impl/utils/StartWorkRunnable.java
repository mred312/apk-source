package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StartWorkRunnable implements Runnable {

    /* renamed from: a */
    private WorkManagerImpl f5345a;

    /* renamed from: b */
    private String f5346b;

    /* renamed from: c */
    private WorkerParameters.RuntimeExtras f5347c;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f5345a = workManagerImpl;
        this.f5346b = str;
        this.f5347c = runtimeExtras;
    }

    public void run() {
        this.f5345a.getProcessor().startWork(this.f5346b, this.f5347c);
    }
}
