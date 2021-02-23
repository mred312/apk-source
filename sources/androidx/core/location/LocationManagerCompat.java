package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.p003os.HandlerExecutor;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class LocationManagerCompat {
    @GuardedBy("sGnssStatusListeners")

    /* renamed from: a */
    private static final SimpleArrayMap<Object, Object> f2378a = new SimpleArrayMap<>();

    /* renamed from: androidx.core.location.LocationManagerCompat$a */
    class C0467a implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ LocationManager f2379a;

        /* renamed from: b */
        final /* synthetic */ C0469c f2380b;

        C0467a(LocationManager locationManager, C0469c cVar) {
            this.f2379a = locationManager;
            this.f2380b = cVar;
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(this.f2379a.addGpsStatusListener(this.f2380b));
        }
    }

    @RequiresApi(30)
    /* renamed from: androidx.core.location.LocationManagerCompat$b */
    private static class C0468b extends GnssStatus.Callback {

        /* renamed from: a */
        final GnssStatusCompat.Callback f2381a;

        C0468b(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.f2381a = callback;
        }

        public void onFirstFix(int i) {
            this.f2381a.onFirstFix(i);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f2381a.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.f2381a.onStarted();
        }

        public void onStopped() {
            this.f2381a.onStopped();
        }
    }

    /* renamed from: androidx.core.location.LocationManagerCompat$c */
    private static class C0469c implements GpsStatus.Listener {

        /* renamed from: a */
        private final LocationManager f2382a;

        /* renamed from: b */
        final GnssStatusCompat.Callback f2383b;
        @Nullable

        /* renamed from: c */
        volatile Executor f2384c;

        /* renamed from: androidx.core.location.LocationManagerCompat$c$a */
        class C0470a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2385a;

            C0470a(Executor executor) {
                this.f2385a = executor;
            }

            public void run() {
                if (C0469c.this.f2384c == this.f2385a) {
                    C0469c.this.f2383b.onStarted();
                }
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$c$b */
        class C0471b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2387a;

            C0471b(Executor executor) {
                this.f2387a = executor;
            }

            public void run() {
                if (C0469c.this.f2384c == this.f2387a) {
                    C0469c.this.f2383b.onStopped();
                }
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$c$c */
        class C0472c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2389a;

            /* renamed from: b */
            final /* synthetic */ int f2390b;

            C0472c(Executor executor, int i) {
                this.f2389a = executor;
                this.f2390b = i;
            }

            public void run() {
                if (C0469c.this.f2384c == this.f2389a) {
                    C0469c.this.f2383b.onFirstFix(this.f2390b);
                }
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$c$d */
        class C0473d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2392a;

            /* renamed from: b */
            final /* synthetic */ GnssStatusCompat f2393b;

            C0473d(Executor executor, GnssStatusCompat gnssStatusCompat) {
                this.f2392a = executor;
                this.f2393b = gnssStatusCompat;
            }

            public void run() {
                if (C0469c.this.f2384c == this.f2392a) {
                    C0469c.this.f2383b.onSatelliteStatusChanged(this.f2393b);
                }
            }
        }

        C0469c(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.f2382a = locationManager;
            this.f2383b = callback;
        }

        /* renamed from: a */
        public void mo4317a(Executor executor) {
            Preconditions.checkState(this.f2384c == null);
            this.f2384c = executor;
        }

        /* renamed from: b */
        public void mo4318b() {
            this.f2384c = null;
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            Executor executor = this.f2384c;
            if (executor != null) {
                if (i == 1) {
                    executor.execute(new C0470a(executor));
                } else if (i == 2) {
                    executor.execute(new C0471b(executor));
                } else if (i == 3) {
                    GpsStatus gpsStatus2 = this.f2382a.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        executor.execute(new C0472c(executor, gpsStatus2.getTimeToFirstFix()));
                    }
                } else if (i == 4 && (gpsStatus = this.f2382a.getGpsStatus((GpsStatus) null)) != null) {
                    executor.execute(new C0473d(executor, GnssStatusCompat.wrap(gpsStatus)));
                }
            }
        }
    }

    /* renamed from: androidx.core.location.LocationManagerCompat$d */
    private static class C0474d implements Executor {

        /* renamed from: a */
        private final Handler f2395a;

        C0474d(@NonNull Handler handler) {
            this.f2395a = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.f2395a.getLooper()) {
                runnable.run();
            } else if (!this.f2395a.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.f2395a + " is shutting down");
            }
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.core.location.LocationManagerCompat$e */
    private static class C0475e extends GnssStatus.Callback {

        /* renamed from: a */
        final GnssStatusCompat.Callback f2396a;
        @Nullable

        /* renamed from: b */
        volatile Executor f2397b;

        /* renamed from: androidx.core.location.LocationManagerCompat$e$a */
        class C0476a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2398a;

            C0476a(Executor executor) {
                this.f2398a = executor;
            }

            public void run() {
                if (C0475e.this.f2397b == this.f2398a) {
                    C0475e.this.f2396a.onStarted();
                }
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$e$b */
        class C0477b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2400a;

            C0477b(Executor executor) {
                this.f2400a = executor;
            }

            public void run() {
                if (C0475e.this.f2397b == this.f2400a) {
                    C0475e.this.f2396a.onStopped();
                }
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$e$c */
        class C0478c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2402a;

            /* renamed from: b */
            final /* synthetic */ int f2403b;

            C0478c(Executor executor, int i) {
                this.f2402a = executor;
                this.f2403b = i;
            }

            public void run() {
                if (C0475e.this.f2397b == this.f2402a) {
                    C0475e.this.f2396a.onFirstFix(this.f2403b);
                }
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$e$d */
        class C0479d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Executor f2405a;

            /* renamed from: b */
            final /* synthetic */ GnssStatus f2406b;

            C0479d(Executor executor, GnssStatus gnssStatus) {
                this.f2405a = executor;
                this.f2406b = gnssStatus;
            }

            public void run() {
                if (C0475e.this.f2397b == this.f2405a) {
                    C0475e.this.f2396a.onSatelliteStatusChanged(GnssStatusCompat.wrap(this.f2406b));
                }
            }
        }

        C0475e(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.f2396a = callback;
        }

        /* renamed from: a */
        public void mo4325a(Executor executor) {
            boolean z = true;
            Preconditions.checkArgument(executor != null, "invalid null executor");
            if (this.f2397b != null) {
                z = false;
            }
            Preconditions.checkState(z);
            this.f2397b = executor;
        }

        /* renamed from: b */
        public void mo4326b() {
            this.f2397b = null;
        }

        public void onFirstFix(int i) {
            Executor executor = this.f2397b;
            if (executor != null) {
                executor.execute(new C0478c(executor, i));
            }
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.f2397b;
            if (executor != null) {
                executor.execute(new C0479d(executor, gnssStatus));
            }
        }

        public void onStarted() {
            Executor executor = this.f2397b;
            if (executor != null) {
                executor.execute(new C0476a(executor));
            }
        }

        public void onStopped() {
            Executor executor = this.f2397b;
            if (executor != null) {
                executor.execute(new C0477b(executor));
            }
        }
    }

    private LocationManagerCompat() {
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* renamed from: a */
    private static boolean m1599a(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = f2378a;
            synchronized (simpleArrayMap) {
                C0468b bVar = (C0468b) simpleArrayMap.get(callback);
                if (bVar == null) {
                    bVar = new C0468b(callback);
                }
                if (!locationManager.registerGnssStatusCallback(executor, bVar)) {
                    return false;
                }
                simpleArrayMap.put(callback, bVar);
                return true;
            }
        } else if (i >= 24) {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap2 = f2378a;
            synchronized (simpleArrayMap2) {
                C0475e eVar = (C0475e) simpleArrayMap2.get(callback);
                if (eVar == null) {
                    eVar = new C0475e(callback);
                } else {
                    eVar.mo4326b();
                }
                eVar.mo4325a(executor);
                if (locationManager.registerGnssStatusCallback(eVar, handler)) {
                    simpleArrayMap2.put(callback, eVar);
                    return true;
                }
                eVar.mo4326b();
                return false;
            }
        } else {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap3 = f2378a;
            synchronized (simpleArrayMap3) {
                C0469c cVar = (C0469c) simpleArrayMap3.get(callback);
                if (cVar == null) {
                    cVar = new C0469c(locationManager, callback);
                } else {
                    cVar.mo4318b();
                }
                cVar.mo4317a(executor);
                FutureTask futureTask = new FutureTask(new C0467a(locationManager, cVar));
                if (Looper.myLooper() == handler.getLooper()) {
                    futureTask.run();
                } else if (!handler.post(futureTask)) {
                    throw new IllegalStateException(handler + " is shutting down");
                }
                try {
                    if (((Boolean) futureTask.get(4, TimeUnit.SECONDS)).booleanValue()) {
                        simpleArrayMap3.put(callback, cVar);
                        return true;
                    }
                    cVar.mo4318b();
                    return false;
                } catch (ExecutionException e) {
                    e = e;
                    throw new IllegalStateException(e);
                } catch (InterruptedException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (TimeoutException e3) {
                    throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e3);
                }
            }
        }
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return locationManager.isLocationEnabled();
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, (Executor) new HandlerExecutor(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, (Executor) new C0474d(handler), callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = f2378a;
            synchronized (simpleArrayMap) {
                C0468b bVar = (C0468b) simpleArrayMap.remove(callback);
                if (bVar != null) {
                    locationManager.unregisterGnssStatusCallback(bVar);
                }
            }
        } else if (i >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = f2378a;
            synchronized (simpleArrayMap2) {
                C0475e eVar = (C0475e) simpleArrayMap2.remove(callback);
                if (eVar != null) {
                    eVar.mo4326b();
                    locationManager.unregisterGnssStatusCallback(eVar);
                }
            }
        } else {
            SimpleArrayMap<Object, Object> simpleArrayMap3 = f2378a;
            synchronized (simpleArrayMap3) {
                C0469c cVar = (C0469c) simpleArrayMap3.remove(callback);
                if (cVar != null) {
                    cVar.mo4318b();
                    locationManager.removeGpsStatusListener(cVar);
                }
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return m1599a(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return m1599a(locationManager, new Handler(myLooper), executor, callback);
    }
}
