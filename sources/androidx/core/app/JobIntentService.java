package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {

    /* renamed from: h */
    static final Object f1973h = new Object();

    /* renamed from: i */
    static final HashMap<ComponentName, C0421h> f1974i = new HashMap<>();

    /* renamed from: a */
    C0414b f1975a;

    /* renamed from: b */
    C0421h f1976b;

    /* renamed from: c */
    C0413a f1977c;

    /* renamed from: d */
    boolean f1978d = false;

    /* renamed from: e */
    boolean f1979e = false;

    /* renamed from: f */
    boolean f1980f = false;

    /* renamed from: g */
    final ArrayList<C0416d> f1981g;

    /* renamed from: androidx.core.app.JobIntentService$a */
    final class C0413a extends AsyncTask<Void, Void, Void> {
        C0413a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                C0417e a = JobIntentService.this.mo3617a();
                if (a == null) {
                    return null;
                }
                JobIntentService.this.onHandleWork(a.getIntent());
                a.mo3641a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            JobIntentService.this.mo3620e();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.mo3620e();
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$b */
    interface C0414b {
        /* renamed from: a */
        IBinder mo3635a();

        /* renamed from: b */
        C0417e mo3636b();
    }

    /* renamed from: androidx.core.app.JobIntentService$c */
    static final class C0415c extends C0421h {

        /* renamed from: d */
        private final Context f1983d;

        /* renamed from: e */
        private final PowerManager.WakeLock f1984e;

        /* renamed from: f */
        private final PowerManager.WakeLock f1985f;

        /* renamed from: g */
        boolean f1986g;

        /* renamed from: h */
        boolean f1987h;

        C0415c(Context context, ComponentName componentName) {
            super(componentName);
            this.f1983d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f1984e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f1985f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3637a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f1998a);
            if (this.f1983d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f1986g) {
                        this.f1986g = true;
                        if (!this.f1987h) {
                            this.f1984e.acquire(60000);
                        }
                    }
                }
            }
        }

        /* renamed from: c */
        public void mo3638c() {
            synchronized (this) {
                if (this.f1987h) {
                    if (this.f1986g) {
                        this.f1984e.acquire(60000);
                    }
                    this.f1987h = false;
                    this.f1985f.release();
                }
            }
        }

        /* renamed from: d */
        public void mo3639d() {
            synchronized (this) {
                if (!this.f1987h) {
                    this.f1987h = true;
                    this.f1985f.acquire(600000);
                    this.f1984e.release();
                }
            }
        }

        /* renamed from: e */
        public void mo3640e() {
            synchronized (this) {
                this.f1986g = false;
            }
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$d */
    final class C0416d implements C0417e {

        /* renamed from: a */
        final Intent f1988a;

        /* renamed from: b */
        final int f1989b;

        C0416d(Intent intent, int i) {
            this.f1988a = intent;
            this.f1989b = i;
        }

        /* renamed from: a */
        public void mo3641a() {
            JobIntentService.this.stopSelf(this.f1989b);
        }

        public Intent getIntent() {
            return this.f1988a;
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$e */
    interface C0417e {
        /* renamed from: a */
        void mo3641a();

        Intent getIntent();
    }

    @RequiresApi(26)
    /* renamed from: androidx.core.app.JobIntentService$f */
    static final class C0418f extends JobServiceEngine implements C0414b {

        /* renamed from: a */
        final JobIntentService f1991a;

        /* renamed from: b */
        final Object f1992b = new Object();

        /* renamed from: c */
        JobParameters f1993c;

        /* renamed from: androidx.core.app.JobIntentService$f$a */
        final class C0419a implements C0417e {

            /* renamed from: a */
            final JobWorkItem f1994a;

            C0419a(JobWorkItem jobWorkItem) {
                this.f1994a = jobWorkItem;
            }

            /* renamed from: a */
            public void mo3641a() {
                synchronized (C0418f.this.f1992b) {
                    JobParameters jobParameters = C0418f.this.f1993c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f1994a);
                    }
                }
            }

            public Intent getIntent() {
                return this.f1994a.getIntent();
            }
        }

        C0418f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f1991a = jobIntentService;
        }

        /* renamed from: a */
        public IBinder mo3635a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f1991a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            return new androidx.core.app.JobIntentService.C0418f.C0419a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.C0417e mo3636b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f1992b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f1993c     // Catch:{ all -> 0x0025 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x000a:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0025 }
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                if (r1 == 0) goto L_0x0024
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f1991a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$f$a r0 = new androidx.core.app.JobIntentService$f$a
                r0.<init>(r1)
                return r0
            L_0x0024:
                return r2
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.C0418f.mo3636b():androidx.core.app.JobIntentService$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f1993c = jobParameters;
            this.f1991a.mo3619c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b = this.f1991a.mo3618b();
            synchronized (this.f1992b) {
                this.f1993c = null;
            }
            return b;
        }
    }

    @RequiresApi(26)
    /* renamed from: androidx.core.app.JobIntentService$g */
    static final class C0420g extends C0421h {

        /* renamed from: d */
        private final JobInfo f1996d;

        /* renamed from: e */
        private final JobScheduler f1997e;

        C0420g(Context context, ComponentName componentName, int i) {
            super(componentName);
            mo3645b(i);
            this.f1996d = new JobInfo.Builder(i, this.f1998a).setOverrideDeadline(0).build();
            this.f1997e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3637a(Intent intent) {
            this.f1997e.enqueue(this.f1996d, new JobWorkItem(intent));
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$h */
    static abstract class C0421h {

        /* renamed from: a */
        final ComponentName f1998a;

        /* renamed from: b */
        boolean f1999b;

        /* renamed from: c */
        int f2000c;

        C0421h(ComponentName componentName) {
            this.f1998a = componentName;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo3637a(Intent intent);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3645b(int i) {
            if (!this.f1999b) {
                this.f1999b = true;
                this.f2000c = i;
            } else if (this.f2000c != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f2000c);
            }
        }

        /* renamed from: c */
        public void mo3638c() {
        }

        /* renamed from: d */
        public void mo3639d() {
        }

        /* renamed from: e */
        public void mo3640e() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1981g = null;
        } else {
            this.f1981g = new ArrayList<>();
        }
    }

    /* renamed from: d */
    static C0421h m1345d(Context context, ComponentName componentName, boolean z, int i) {
        C0421h hVar;
        HashMap<ComponentName, C0421h> hashMap = f1974i;
        C0421h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new C0415c(context, componentName);
        } else if (z) {
            hVar = new C0420g(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        C0421h hVar3 = hVar;
        hashMap.put(componentName, hVar3);
        return hVar3;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i, intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0417e mo3617a() {
        C0414b bVar = this.f1975a;
        if (bVar != null) {
            return bVar.mo3636b();
        }
        synchronized (this.f1981g) {
            if (this.f1981g.size() <= 0) {
                return null;
            }
            C0417e remove = this.f1981g.remove(0);
            return remove;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3618b() {
        C0413a aVar = this.f1977c;
        if (aVar != null) {
            aVar.cancel(this.f1978d);
        }
        this.f1979e = true;
        return onStopCurrentWork();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3619c(boolean z) {
        if (this.f1977c == null) {
            this.f1977c = new C0413a();
            C0421h hVar = this.f1976b;
            if (hVar != null && z) {
                hVar.mo3639d();
            }
            this.f1977c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo3620e() {
        ArrayList<C0416d> arrayList = this.f1981g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1977c = null;
                ArrayList<C0416d> arrayList2 = this.f1981g;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    mo3619c(false);
                } else if (!this.f1980f) {
                    this.f1976b.mo3638c();
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f1979e;
    }

    public IBinder onBind(@NonNull Intent intent) {
        C0414b bVar = this.f1975a;
        if (bVar != null) {
            return bVar.mo3635a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1975a = new C0418f(this);
            this.f1976b = null;
            return;
        }
        this.f1975a = null;
        this.f1976b = m1345d(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<C0416d> arrayList = this.f1981g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1980f = true;
                this.f1976b.mo3638c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onHandleWork(@NonNull Intent intent);

    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        if (this.f1981g == null) {
            return 2;
        }
        this.f1976b.mo3640e();
        synchronized (this.f1981g) {
            ArrayList<C0416d> arrayList = this.f1981g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C0416d(intent, i2));
            mo3619c(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.f1978d = z;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (f1973h) {
                C0421h d = m1345d(context, componentName, true, i);
                d.mo3645b(i);
                d.mo3637a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }
}
