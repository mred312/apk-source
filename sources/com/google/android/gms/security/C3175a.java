package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* renamed from: com.google.android.gms.security.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C3175a extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a */
    private final /* synthetic */ Context f18738a;

    /* renamed from: b */
    private final /* synthetic */ ProviderInstaller.ProviderInstallListener f18739b;

    C3175a(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f18738a = context;
        this.f18739b = providerInstallListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Integer doInBackground(Void... voidArr) {
        try {
            ProviderInstaller.installIfNeeded(this.f18738a);
            return 0;
        } catch (GooglePlayServicesRepairableException e) {
            return Integer.valueOf(e.getConnectionStatusCode());
        } catch (GooglePlayServicesNotAvailableException e2) {
            return Integer.valueOf(e2.errorCode);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.f18739b.onProviderInstalled();
            return;
        }
        this.f18739b.onProviderInstallFailed(num.intValue(), ProviderInstaller.f18735a.getErrorResolutionIntent(this.f18738a, num.intValue(), "pi"));
    }
}
