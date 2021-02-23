package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.y3 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2611y3 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ String f11975a;

    /* renamed from: b */
    private final /* synthetic */ String f11976b;

    /* renamed from: c */
    private final /* synthetic */ zzaqp f11977c;

    C2611y3(zzaqp zzaqp, String str, String str2) {
        this.f11977c = zzaqp;
        this.f11975a = str;
        this.f11976b = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.f11977c.f12636d.getSystemService("download");
        try {
            String str = this.f11975a;
            String str2 = this.f11976b;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzp.zzks();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.f11977c.zzdt("Could not store picture.");
        }
    }
}
