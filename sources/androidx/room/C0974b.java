package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.room.b */
/* compiled from: MultiInstanceInvalidationClient */
class C0974b {
    @Nullable

    /* renamed from: a */
    Context f4559a;

    /* renamed from: b */
    final String f4560b;

    /* renamed from: c */
    int f4561c;

    /* renamed from: d */
    final InvalidationTracker f4562d;

    /* renamed from: e */
    final InvalidationTracker.Observer f4563e;
    @Nullable

    /* renamed from: f */
    IMultiInstanceInvalidationService f4564f;

    /* renamed from: g */
    final Executor f4565g;

    /* renamed from: h */
    final IMultiInstanceInvalidationCallback f4566h = new C0975a();

    /* renamed from: i */
    final AtomicBoolean f4567i = new AtomicBoolean(false);

    /* renamed from: j */
    final ServiceConnection f4568j;

    /* renamed from: k */
    final Runnable f4569k;

    /* renamed from: l */
    final Runnable f4570l;

    /* renamed from: m */
    private final Runnable f4571m;

    /* renamed from: androidx.room.b$a */
    /* compiled from: MultiInstanceInvalidationClient */
    class C0975a extends IMultiInstanceInvalidationCallback.Stub {

        /* renamed from: androidx.room.b$a$a */
        /* compiled from: MultiInstanceInvalidationClient */
        class C0976a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String[] f4573a;

            C0976a(String[] strArr) {
                this.f4573a = strArr;
            }

            public void run() {
                C0974b.this.f4562d.notifyObserversByTableNames(this.f4573a);
            }
        }

        C0975a() {
        }

        public void onInvalidation(String[] strArr) {
            C0974b.this.f4565g.execute(new C0976a(strArr));
        }
    }

    /* renamed from: androidx.room.b$b */
    /* compiled from: MultiInstanceInvalidationClient */
    class C0977b implements ServiceConnection {
        C0977b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0974b.this.f4564f = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            C0974b bVar = C0974b.this;
            bVar.f4565g.execute(bVar.f4569k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0974b bVar = C0974b.this;
            bVar.f4565g.execute(bVar.f4570l);
            C0974b bVar2 = C0974b.this;
            bVar2.f4564f = null;
            bVar2.f4559a = null;
        }
    }

    /* renamed from: androidx.room.b$c */
    /* compiled from: MultiInstanceInvalidationClient */
    class C0978c implements Runnable {
        C0978c() {
        }

        public void run() {
            try {
                C0974b bVar = C0974b.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar.f4564f;
                if (iMultiInstanceInvalidationService != null) {
                    bVar.f4561c = iMultiInstanceInvalidationService.registerCallback(bVar.f4566h, bVar.f4560b);
                    C0974b bVar2 = C0974b.this;
                    bVar2.f4562d.addObserver(bVar2.f4563e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
            }
        }
    }

    /* renamed from: androidx.room.b$d */
    /* compiled from: MultiInstanceInvalidationClient */
    class C0979d implements Runnable {
        C0979d() {
        }

        public void run() {
            C0974b bVar = C0974b.this;
            bVar.f4562d.removeObserver(bVar.f4563e);
        }
    }

    /* renamed from: androidx.room.b$e */
    /* compiled from: MultiInstanceInvalidationClient */
    class C0980e implements Runnable {
        C0980e() {
        }

        public void run() {
            C0974b bVar = C0974b.this;
            bVar.f4562d.removeObserver(bVar.f4563e);
            try {
                C0974b bVar2 = C0974b.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar2.f4564f;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(bVar2.f4566h, bVar2.f4561c);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            C0974b bVar3 = C0974b.this;
            Context context = bVar3.f4559a;
            if (context != null) {
                context.unbindService(bVar3.f4568j);
                C0974b.this.f4559a = null;
            }
        }
    }

    /* renamed from: androidx.room.b$f */
    /* compiled from: MultiInstanceInvalidationClient */
    class C0981f extends InvalidationTracker.Observer {
        C0981f(String[] strArr) {
            super(strArr);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo7800a() {
            return true;
        }

        public void onInvalidated(@NonNull Set<String> set) {
            if (!C0974b.this.f4567i.get()) {
                try {
                    C0974b bVar = C0974b.this;
                    bVar.f4564f.broadcastInvalidation(bVar.f4561c, (String[]) set.toArray(new String[0]));
                } catch (RemoteException e) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e);
                }
            }
        }
    }

    C0974b(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        C0977b bVar = new C0977b();
        this.f4568j = bVar;
        this.f4569k = new C0978c();
        this.f4570l = new C0979d();
        this.f4571m = new C0980e();
        this.f4559a = context.getApplicationContext();
        this.f4560b = str;
        this.f4562d = invalidationTracker;
        this.f4565g = executor;
        this.f4563e = new C0981f(invalidationTracker.f4485b);
        this.f4559a.bindService(new Intent(this.f4559a, MultiInstanceInvalidationService.class), bVar, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7893a() {
        if (this.f4567i.compareAndSet(false, true)) {
            this.f4565g.execute(this.f4571m);
        }
    }
}
