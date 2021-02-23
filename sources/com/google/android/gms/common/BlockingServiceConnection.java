package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a */
    private boolean f7438a = false;

    /* renamed from: b */
    private final BlockingQueue<IBinder> f7439b = new LinkedBlockingQueue();

    @KeepForSdk
    public IBinder getService() {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (!this.f7438a) {
            this.f7438a = true;
            return this.f7439b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @KeepForSdk
    public IBinder getServiceWithTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f7438a) {
            this.f7438a = true;
            IBinder poll = this.f7439b.poll(j, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7439b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
