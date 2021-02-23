package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

public abstract class PostMessageServiceConnection implements ServiceConnection {

    /* renamed from: a */
    private final Object f1838a = new Object();

    /* renamed from: b */
    private final ICustomTabsCallback f1839b;

    /* renamed from: c */
    private IPostMessageService f1840c;

    public PostMessageServiceConnection(CustomTabsSessionToken customTabsSessionToken) {
        this.f1839b = ICustomTabsCallback.Stub.asInterface(customTabsSessionToken.mo3220a());
    }

    public boolean bindSessionToPostMessageService(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(str, PostMessageService.class.getName());
        return context.bindService(intent, this, 1);
    }

    public final boolean notifyMessageChannelReady(Bundle bundle) {
        if (this.f1840c == null) {
            return false;
        }
        synchronized (this.f1838a) {
            try {
                this.f1840c.onMessageChannelReady(this.f1839b, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void onPostMessageServiceConnected() {
    }

    public void onPostMessageServiceDisconnected() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f1840c = IPostMessageService.Stub.asInterface(iBinder);
        onPostMessageServiceConnected();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f1840c = null;
        onPostMessageServiceDisconnected();
    }

    public final boolean postMessage(String str, Bundle bundle) {
        if (this.f1840c == null) {
            return false;
        }
        synchronized (this.f1838a) {
            try {
                this.f1840c.onPostMessage(this.f1839b, str, bundle);
            } catch (RemoteException unused) {
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void unbindFromContext(Context context) {
        context.unbindService(this);
    }
}
