package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {

    /* renamed from: a */
    private final ICustomTabsService f1799a;

    /* renamed from: b */
    private final ComponentName f1800b;

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$a */
    static class C0371a extends CustomTabsServiceConnection {

        /* renamed from: a */
        final /* synthetic */ Context f1801a;

        C0371a(Context context) {
            this.f1801a = context;
        }

        public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            customTabsClient.warmup(0);
            this.f1801a.unbindService(this);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: androidx.browser.customtabs.CustomTabsClient$b */
    class C0372b extends ICustomTabsCallback.Stub {

        /* renamed from: a */
        private Handler f1802a = new Handler(Looper.getMainLooper());

        /* renamed from: b */
        final /* synthetic */ CustomTabsCallback f1803b;

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$b$a */
        class C0373a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1804a;

            /* renamed from: b */
            final /* synthetic */ Bundle f1805b;

            C0373a(int i, Bundle bundle) {
                this.f1804a = i;
                this.f1805b = bundle;
            }

            public void run() {
                C0372b.this.f1803b.onNavigationEvent(this.f1804a, this.f1805b);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$b$b */
        class C0374b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f1807a;

            /* renamed from: b */
            final /* synthetic */ Bundle f1808b;

            C0374b(String str, Bundle bundle) {
                this.f1807a = str;
                this.f1808b = bundle;
            }

            public void run() {
                C0372b.this.f1803b.extraCallback(this.f1807a, this.f1808b);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$b$c */
        class C0375c implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bundle f1810a;

            C0375c(Bundle bundle) {
                this.f1810a = bundle;
            }

            public void run() {
                C0372b.this.f1803b.onMessageChannelReady(this.f1810a);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$b$d */
        class C0376d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f1812a;

            /* renamed from: b */
            final /* synthetic */ Bundle f1813b;

            C0376d(String str, Bundle bundle) {
                this.f1812a = str;
                this.f1813b = bundle;
            }

            public void run() {
                C0372b.this.f1803b.onPostMessage(this.f1812a, this.f1813b);
            }
        }

        /* renamed from: androidx.browser.customtabs.CustomTabsClient$b$e */
        class C0377e implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1815a;

            /* renamed from: b */
            final /* synthetic */ Uri f1816b;

            /* renamed from: c */
            final /* synthetic */ boolean f1817c;

            /* renamed from: d */
            final /* synthetic */ Bundle f1818d;

            C0377e(int i, Uri uri, boolean z, Bundle bundle) {
                this.f1815a = i;
                this.f1816b = uri;
                this.f1817c = z;
                this.f1818d = bundle;
            }

            public void run() {
                C0372b.this.f1803b.onRelationshipValidationResult(this.f1815a, this.f1816b, this.f1817c, this.f1818d);
            }
        }

        C0372b(CustomTabsClient customTabsClient, CustomTabsCallback customTabsCallback) {
            this.f1803b = customTabsCallback;
        }

        public void extraCallback(String str, Bundle bundle) {
            if (this.f1803b != null) {
                this.f1802a.post(new C0374b(str, bundle));
            }
        }

        public void onMessageChannelReady(Bundle bundle) {
            if (this.f1803b != null) {
                this.f1802a.post(new C0375c(bundle));
            }
        }

        public void onNavigationEvent(int i, Bundle bundle) {
            if (this.f1803b != null) {
                this.f1802a.post(new C0373a(i, bundle));
            }
        }

        public void onPostMessage(String str, Bundle bundle) {
            if (this.f1803b != null) {
                this.f1802a.post(new C0376d(str, bundle));
            }
        }

        public void onRelationshipValidationResult(int i, Uri uri, boolean z, @Nullable Bundle bundle) {
            if (this.f1803b != null) {
                this.f1802a.post(new C0377e(i, uri, z, bundle));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.f1799a = iCustomTabsService;
        this.f1800b = componentName;
    }

    public static boolean bindCustomTabsService(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    public static boolean connectAndInitialize(Context context, String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new C0371a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static String getPackageName(Context context, @Nullable List<String> list) {
        return getPackageName(context, list, false);
    }

    public Bundle extraCommand(String str, Bundle bundle) {
        try {
            return this.f1799a.extraCommand(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        C0372b bVar = new C0372b(this, customTabsCallback);
        try {
            if (!this.f1799a.newSession(bVar)) {
                return null;
            }
            return new CustomTabsSession(this.f1799a, bVar, this.f1800b);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean warmup(long j) {
        try {
            return this.f1799a.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public static String getPackageName(Context context, @Nullable List<String> list, boolean z) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = list == null ? new ArrayList() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        for (String next : arrayList) {
            intent2.setPackage(next);
            if (packageManager.resolveService(intent2, 0) != null) {
                return next;
            }
        }
        return null;
    }
}
