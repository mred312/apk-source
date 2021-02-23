package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbc {
    /* renamed from: a */
    static String m7693a(long j) {
        return m7695c("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    /* renamed from: b */
    private static long m7694b(String str) {
        try {
            return m7695c("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaq.m7526v("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzaq.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    /* renamed from: c */
    private static SimpleDateFormat m7695c(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    @Nullable
    public static zzn zzb(zzy zzy) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        zzy zzy2 = zzy;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzy2.zzal;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long b = str != null ? m7694b(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i2 = 0;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get("Expires");
        long b2 = str3 != null ? m7694b(str3) : 0;
        String str4 = map.get("Last-Modified");
        long b3 = str4 != null ? m7694b(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (b <= 0 || b2 < b) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (b2 - b);
                j3 = j4;
            }
        }
        zzn zzn = new zzn();
        zzn.data = zzy2.data;
        zzn.zzr = str5;
        zzn.zzv = j4;
        zzn.zzu = j3;
        zzn.zzs = b;
        zzn.zzt = b3;
        zzn.zzw = map;
        zzn.zzx = zzy2.allHeaders;
        return zzn;
    }
}
