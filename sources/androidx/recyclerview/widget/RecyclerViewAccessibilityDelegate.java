package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: d */
    final RecyclerView f4282d;

    /* renamed from: e */
    final AccessibilityDelegateCompat f4283e = new ItemDelegate(this);

    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d */
        final RecyclerViewAccessibilityDelegate f4284d;

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f4284d = recyclerViewAccessibilityDelegate;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!this.f4284d.mo7464e() && this.f4284d.f4282d.getLayoutManager() != null) {
                this.f4284d.f4282d.getLayoutManager().mo7212j(view, accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.f4284d.mo7464e() || this.f4284d.f4282d.getLayoutManager() == null) {
                return false;
            }
            return this.f4284d.f4282d.getLayoutManager().mo7217m(view, i, bundle);
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
        this.f4282d = recyclerView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo7464e() {
        return this.f4282d.hasPendingAdapterUpdates();
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.f4283e;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !mo7464e()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (!mo7464e() && this.f4282d.getLayoutManager() != null) {
            this.f4282d.getLayoutManager().mo7203i(accessibilityNodeInfoCompat);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (mo7464e() || this.f4282d.getLayoutManager() == null) {
            return false;
        }
        return this.f4282d.getLayoutManager().mo7214l(i, bundle);
    }
}
