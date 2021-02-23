package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class NestedScrollingParentHelper {

    /* renamed from: a */
    private int f2639a;

    /* renamed from: b */
    private int f2640b;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        return this.f2639a | this.f2640b;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2) {
        if (i2 == 1) {
            this.f2640b = i;
        } else {
            this.f2639a = i;
        }
    }

    public void onStopNestedScroll(@NonNull View view, int i) {
        if (i == 1) {
            this.f2640b = 0;
        } else {
            this.f2639a = 0;
        }
    }
}
