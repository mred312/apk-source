package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzef {

    /* renamed from: d */
    private static final String[] f16126d = {"/aclk", "/pcs/click", "/dbm/clk"};

    /* renamed from: a */
    private String f16127a = "ad.doubleclick.net";

    /* renamed from: b */
    private String[] f16128b = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: c */
    private zzdv f16129c;

    public zzef(zzdv zzdv) {
        this.f16129c = zzdv;
    }

    /* renamed from: a */
    private final Uri m8713a(Uri uri, String str) {
        try {
            boolean b = m8714b(uri);
            if (b) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzei("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzei("Query parameter already exists: ms");
            }
            if (b) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms" + "=" + str + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + "dc_ms" + "=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            int i2 = indexOf3 + 1;
            return Uri.parse(uri3.substring(0, i2) + "ms" + "=" + str + "&" + uri3.substring(i2));
        } catch (UnsupportedOperationException unused) {
            throw new zzei("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: b */
    private final boolean m8714b(Uri uri) {
        uri.getClass();
        try {
            return uri.getHost().equals(this.f16127a);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final Uri zza(Uri uri, Context context) {
        return m8713a(uri, this.f16129c.zzb(context));
    }

    public final boolean zzb(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            for (String endsWith : this.f16128b) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String endsWith : f16126d) {
                if (uri.getPath().endsWith(endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final zzdv zzca() {
        return this.f16129c;
    }

    public final void zza(MotionEvent motionEvent) {
        this.f16129c.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) {
        try {
            return m8713a(uri, this.f16129c.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzei("Provided Uri is not in a valid state");
        }
    }
}
