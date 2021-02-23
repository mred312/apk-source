package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmd;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzka {

    /* renamed from: a */
    private static final Pattern f16566a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzahn = -1;
    public int zzaho = -1;

    /* renamed from: a */
    private final boolean m8990a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f16566a.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzahn = parseInt;
                    this.zzaho = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzb(zzmd zzmd) {
        for (int i = 0; i < zzmd.length(); i++) {
            zzmd.zza zzay = zzmd.zzay(i);
            if (zzay instanceof zzmj) {
                zzmj zzmj = (zzmj) zzay;
                if (m8990a(zzmj.description, zzmj.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgs() {
        return (this.zzahn == -1 || this.zzaho == -1) ? false : true;
    }
}
