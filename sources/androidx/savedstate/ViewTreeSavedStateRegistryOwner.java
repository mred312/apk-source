package androidx.savedstate;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ViewTreeSavedStateRegistryOwner {
    private ViewTreeSavedStateRegistryOwner() {
    }

    @Nullable
    public static SavedStateRegistryOwner get(@NonNull View view) {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) view.getTag(C0990R.C0991id.view_tree_saved_state_registry_owner);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        ViewParent parent = view.getParent();
        while (savedStateRegistryOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            savedStateRegistryOwner = (SavedStateRegistryOwner) view2.getTag(C0990R.C0991id.view_tree_saved_state_registry_owner);
            parent = view2.getParent();
        }
        return savedStateRegistryOwner;
    }

    public static void set(@NonNull View view, @Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        view.setTag(C0990R.C0991id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
