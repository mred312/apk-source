package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzawq;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zza {
    private final Context context;
    private boolean zzboe;
    private zzawq zzbof;
    private zzasw zzbog = null;

    public zza(Context context2, zzawq zzawq, zzasw zzasw) {
        this.context = context2;
        this.zzbof = zzawq;
        if (0 == 0) {
            this.zzbog = new zzasw();
        }
    }

    private final boolean zzjx() {
        zzawq zzawq = this.zzbof;
        return (zzawq != null && zzawq.zzwc().zzdzg) || this.zzbog.zzdvq;
    }

    public final void recordClick() {
        this.zzboe = true;
    }

    public final void zzbk(@Nullable String str) {
        List<String> list;
        if (zzjx()) {
            if (str == null) {
                str = "";
            }
            zzawq zzawq = this.zzbof;
            if (zzawq != null) {
                zzawq.zza(str, (Map<String, String>) null, 3);
                return;
            }
            zzasw zzasw = this.zzbog;
            if (zzasw.zzdvq && (list = zzasw.zzdvr) != null) {
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzp.zzkq();
                        zzm.zzb(this.context, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzjy() {
        return !zzjx() || this.zzboe;
    }
}
