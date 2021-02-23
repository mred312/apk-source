package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

public abstract class CustomTabsServiceConnection implements ServiceConnection {

    /* renamed from: androidx.browser.customtabs.CustomTabsServiceConnection$a */
    class C0380a extends CustomTabsClient {
        C0380a(CustomTabsServiceConnection customTabsServiceConnection, ICustomTabsService iCustomTabsService, ComponentName componentName) {
            super(iCustomTabsService, componentName);
        }
    }

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onCustomTabsServiceConnected(componentName, new C0380a(this, ICustomTabsService.Stub.asInterface(iBinder), componentName));
    }
}
