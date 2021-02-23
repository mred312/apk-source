package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public abstract class RemoteCreator<T> {

    /* renamed from: a */
    private final String f7758a;

    /* renamed from: b */
    private T f7759b;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    protected RemoteCreator(String str) {
        this.f7758a = str;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract T getRemoteCreator(IBinder iBinder);

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final T getRemoteCreatorInstance(Context context) {
        if (this.f7759b == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    this.f7759b = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.f7758a).newInstance());
                } catch (ClassNotFoundException e) {
                    throw new RemoteCreatorException("Could not load creator class.", e);
                } catch (InstantiationException e2) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e2);
                } catch (IllegalAccessException e3) {
                    throw new RemoteCreatorException("Could not access creator.", e3);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.f7759b;
    }
}
