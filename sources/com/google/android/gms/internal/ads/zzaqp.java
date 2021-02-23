package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C1656R;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqp extends zzaqu {

    /* renamed from: c */
    private final Map<String, String> f12635c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f12636d;

    public zzaqp(zzbdv zzbdv, Map<String, String> map) {
        super(zzbdv, "storePicture");
        this.f12635c = map;
        this.f12636d = zzbdv.zzaaj();
    }

    public final void execute() {
        if (this.f12636d == null) {
            zzdt("Activity context is not available");
            return;
        }
        zzp.zzkq();
        if (!zzm.zzaq(this.f12636d).zzri()) {
            zzdt("Feature is not supported by the device.");
            return;
        }
        String str = this.f12635c.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdt("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdt(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzp.zzkq();
            if (!zzm.zzek(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdt(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzp.zzku().getResources();
            zzp.zzkq();
            AlertDialog.Builder zzap = zzm.zzap(this.f12636d);
            zzap.setTitle(resources != null ? resources.getString(C1656R.string.f7412s1) : "Save image");
            zzap.setMessage(resources != null ? resources.getString(C1656R.string.f7413s2) : "Allow Ad to store image in Picture gallery?");
            zzap.setPositiveButton(resources != null ? resources.getString(C1656R.string.f7414s3) : AbstractSpiCall.HEADER_ACCEPT, new C2611y3(this, str, lastPathSegment));
            zzap.setNegativeButton(resources != null ? resources.getString(C1656R.string.f7415s4) : "Decline", new C2649z3(this));
            zzap.create().show();
        }
    }
}
