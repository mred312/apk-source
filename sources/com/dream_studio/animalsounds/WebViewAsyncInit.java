package com.dream_studio.animalsounds;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import com.google.android.gms.ads.MobileAds;
import java.lang.ref.WeakReference;

@TargetApi(17)
public class WebViewAsyncInit extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private WeakReference<MainActivity> f6860a;

    public WebViewAsyncInit(MainActivity mainActivity) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f6860a = new WeakReference<>(mainActivity);
            execute(new Void[0]);
            return;
        }
        mainActivity.createAdsIfInitialized(true, false);
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... voidArr) {
        MainActivity mainActivity = (MainActivity) this.f6860a.get();
        if (mainActivity == null) {
            return null;
        }
        try {
            MobileAds.initialize(mainActivity);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void voidR) {
        super.onPostExecute(voidR);
        MainActivity mainActivity = (MainActivity) this.f6860a.get();
        if (mainActivity != null) {
            mainActivity.createAdsIfInitialized(true, false);
        }
    }
}
