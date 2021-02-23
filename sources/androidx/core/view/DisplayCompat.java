package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class DisplayCompat {
    private DisplayCompat() {
    }

    /* renamed from: a */
    private static Point m1702a(@NonNull Context context, @NonNull Display display) {
        Point point;
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            point = m1707f("sys.display-size", display);
        } else {
            point = m1707f("vendor.display-size", display);
        }
        if (point != null) {
            return point;
        }
        if (m1704c(context)) {
            return new Point(3840, 2160);
        }
        Point point2 = new Point();
        if (i >= 23) {
            Display.Mode mode = display.getMode();
            point2.x = mode.getPhysicalWidth();
            point2.y = mode.getPhysicalHeight();
        } else if (i >= 17) {
            display.getRealSize(point2);
        } else {
            display.getSize(point2);
        }
        return point2;
    }

    @Nullable
    /* renamed from: b */
    private static String m1703b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static boolean m1704c(@NonNull Context context) {
        return m1705d(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    /* renamed from: d */
    private static boolean m1705d(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    /* renamed from: e */
    private static Point m1706e(@NonNull String str) {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    /* renamed from: f */
    private static Point m1707f(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String b = m1703b(str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            return m1706e(b);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @RequiresApi(23)
    /* renamed from: g */
    private static boolean m1708g(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
    }

    @SuppressLint({"ArrayReturn"})
    @NonNull
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Point a = m1702a(context, display);
        if (Build.VERSION.SDK_INT >= 23) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            ArrayList arrayList = new ArrayList(supportedModes.length);
            boolean z = false;
            for (int i = 0; i < supportedModes.length; i++) {
                if (m1708g(supportedModes[i], a)) {
                    arrayList.add(i, new ModeCompat(supportedModes[i], true));
                    z = true;
                } else {
                    arrayList.add(i, new ModeCompat(supportedModes[i], false));
                }
            }
            if (!z) {
                arrayList.add(new ModeCompat(a));
            }
            return (ModeCompat[]) arrayList.toArray(new ModeCompat[0]);
        }
        return new ModeCompat[]{new ModeCompat(a)};
    }

    public static final class ModeCompat {

        /* renamed from: a */
        private final Display.Mode f2585a;

        /* renamed from: b */
        private final Point f2586b;

        /* renamed from: c */
        private final boolean f2587c;

        ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalDisplaySize == null");
            this.f2587c = true;
            this.f2586b = point;
            this.f2585a = null;
        }

        public int getPhysicalHeight() {
            return this.f2586b.y;
        }

        public int getPhysicalWidth() {
            return this.f2586b.x;
        }

        public boolean isNative() {
            return this.f2587c;
        }

        @RequiresApi(23)
        @Nullable
        public Display.Mode toMode() {
            return this.f2585a;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "Display.Mode == null, can't wrap a null reference");
            this.f2587c = z;
            this.f2586b = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.f2585a = mode;
        }
    }
}
