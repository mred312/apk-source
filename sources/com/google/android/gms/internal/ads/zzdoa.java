package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdoa {

    /* renamed from: a */
    private final Pattern f15816a;

    @VisibleForTesting
    public zzdoa() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzwq.zzqe().zzd(zzabf.zzcxy));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.f15816a = pattern;
    }

    @Nullable
    public final String zzgr(@Nullable String str) {
        Pattern pattern = this.f15816a;
        if (!(pattern == null || str == null)) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
