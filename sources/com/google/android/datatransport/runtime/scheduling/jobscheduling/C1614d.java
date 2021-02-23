package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.d */
/* compiled from: JobInfoSchedulerService */
final /* synthetic */ class C1614d implements Runnable {

    /* renamed from: a */
    private final JobInfoSchedulerService f7319a;

    /* renamed from: b */
    private final JobParameters f7320b;

    private C1614d(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f7319a = jobInfoSchedulerService;
        this.f7320b = jobParameters;
    }

    /* renamed from: a */
    public static Runnable m5112a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new C1614d(jobInfoSchedulerService, jobParameters);
    }

    public void run() {
        this.f7319a.jobFinished(this.f7320b, false);
    }
}
