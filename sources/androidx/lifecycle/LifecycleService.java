package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

public class LifecycleService extends Service implements LifecycleOwner {

    /* renamed from: a */
    private final ServiceLifecycleDispatcher f3486a = new ServiceLifecycleDispatcher(this);

    public Lifecycle getLifecycle() {
        return this.f3486a.getLifecycle();
    }

    @CallSuper
    @Nullable
    public IBinder onBind(Intent intent) {
        this.f3486a.onServicePreSuperOnBind();
        return null;
    }

    @CallSuper
    public void onCreate() {
        this.f3486a.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @CallSuper
    public void onDestroy() {
        this.f3486a.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @CallSuper
    public void onStart(Intent intent, int i) {
        this.f3486a.onServicePreSuperOnStart();
        super.onStart(intent, i);
    }

    @CallSuper
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
