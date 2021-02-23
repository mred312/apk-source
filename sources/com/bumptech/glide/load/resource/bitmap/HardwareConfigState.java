package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

public final class HardwareConfigState {
    public static final int DEFAULT_MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    public static final int DEFAULT_MIN_HARDWARE_DIMENSION = 128;

    /* renamed from: d */
    private static final File f6144d = new File("/proc/self/fd");

    /* renamed from: e */
    private static volatile int f6145e = DEFAULT_MAXIMUM_FDS_FOR_HARDWARE_CONFIGS;

    /* renamed from: f */
    private static volatile int f6146f = 128;

    /* renamed from: g */
    private static volatile HardwareConfigState f6147g;

    /* renamed from: a */
    private final boolean f6148a = m4545b();
    @GuardedBy("this")

    /* renamed from: b */
    private int f6149b;
    @GuardedBy("this")

    /* renamed from: c */
    private boolean f6150c = true;

    @VisibleForTesting
    HardwareConfigState() {
    }

    /* renamed from: a */
    private synchronized boolean m4544a() {
        boolean z = true;
        int i = this.f6149b + 1;
        this.f6149b = i;
        if (i >= 50) {
            this.f6149b = 0;
            int length = f6144d.list().length;
            if (length >= f6145e) {
                z = false;
            }
            this.f6150c = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + f6145e);
            }
        }
        return this.f6150c;
    }

    /* renamed from: b */
    private static boolean m4545b() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (Build.VERSION.SDK_INT != 26) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    public static HardwareConfigState getInstance() {
        if (f6147g == null) {
            synchronized (HardwareConfigState.class) {
                if (f6147g == null) {
                    f6147g = new HardwareConfigState();
                }
            }
        }
        return f6147g;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    /* renamed from: c */
    public boolean mo9852c(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (isHardwareConfigAllowed) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        if (!z || !this.f6148a || Build.VERSION.SDK_INT < 26 || z2 || i < f6146f || i2 < f6146f || !m4544a()) {
            return false;
        }
        return true;
    }
}
