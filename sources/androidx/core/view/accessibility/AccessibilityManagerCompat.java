package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean z);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* renamed from: androidx.core.view.accessibility.AccessibilityManagerCompat$a */
    private static class C0561a implements AccessibilityManager.AccessibilityStateChangeListener {

        /* renamed from: a */
        AccessibilityStateChangeListener f2709a;

        C0561a(@NonNull AccessibilityStateChangeListener accessibilityStateChangeListener) {
            this.f2709a = accessibilityStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0561a)) {
                return false;
            }
            return this.f2709a.equals(((C0561a) obj).f2709a);
        }

        public int hashCode() {
            return this.f2709a.hashCode();
        }

        public void onAccessibilityStateChanged(boolean z) {
            this.f2709a.onAccessibilityStateChanged(z);
        }
    }

    @RequiresApi(19)
    /* renamed from: androidx.core.view.accessibility.AccessibilityManagerCompat$b */
    private static final class C0562b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a */
        final TouchExplorationStateChangeListener f2710a;

        C0562b(@NonNull TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            this.f2710a = touchExplorationStateChangeListener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0562b)) {
                return false;
            }
            return this.f2710a.equals(((C0562b) obj).f2710a);
        }

        public int hashCode() {
            return this.f2710a.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean z) {
            this.f2710a.onTouchExplorationStateChanged(z);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.addAccessibilityStateChangeListener(new C0561a(accessibilityStateChangeListener));
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        if (Build.VERSION.SDK_INT < 19 || touchExplorationStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new C0562b(touchExplorationStateChangeListener));
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.removeAccessibilityStateChangeListener(new C0561a(accessibilityStateChangeListener));
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        if (Build.VERSION.SDK_INT < 19 || touchExplorationStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new C0562b(touchExplorationStateChangeListener));
    }
}
