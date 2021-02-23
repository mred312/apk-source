package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

public class PostMessageService extends Service {

    /* renamed from: a */
    private IPostMessageService.Stub f1837a = new C0383a(this);

    /* renamed from: androidx.browser.customtabs.PostMessageService$a */
    class C0383a extends IPostMessageService.Stub {
        C0383a(PostMessageService postMessageService) {
        }

        public void onMessageChannelReady(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        public void onPostMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f1837a;
    }
}
