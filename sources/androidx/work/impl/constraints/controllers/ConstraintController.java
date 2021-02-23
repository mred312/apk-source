package androidx.work.impl.constraints.controllers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class ConstraintController<T> implements ConstraintListener<T> {

    /* renamed from: a */
    private final List<String> f5244a = new ArrayList();

    /* renamed from: b */
    private T f5245b;

    /* renamed from: c */
    private ConstraintTracker<T> f5246c;

    /* renamed from: d */
    private OnConstraintUpdatedCallback f5247d;

    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(@NonNull List<String> list);

        void onConstraintNotMet(@NonNull List<String> list);
    }

    ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.f5246c = constraintTracker;
    }

    /* renamed from: c */
    private void m3974c() {
        if (!this.f5244a.isEmpty() && this.f5247d != null) {
            T t = this.f5245b;
            if (t == null || mo8945b(t)) {
                this.f5247d.onConstraintNotMet(this.f5244a);
            } else {
                this.f5247d.onConstraintMet(this.f5244a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo8944a(@NonNull WorkSpec workSpec);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo8945b(@NonNull T t);

    public boolean isWorkSpecConstrained(@NonNull String str) {
        T t = this.f5245b;
        return t != null && mo8945b(t) && this.f5244a.contains(str);
    }

    public void onConstraintChanged(@Nullable T t) {
        this.f5245b = t;
        m3974c();
    }

    public void replace(@NonNull List<WorkSpec> list) {
        this.f5244a.clear();
        for (WorkSpec next : list) {
            if (mo8944a(next)) {
                this.f5244a.add(next.f5281id);
            }
        }
        if (this.f5244a.isEmpty()) {
            this.f5246c.removeListener(this);
        } else {
            this.f5246c.addListener(this);
        }
        m3974c();
    }

    public void reset() {
        if (!this.f5244a.isEmpty()) {
            this.f5244a.clear();
            this.f5246c.removeListener(this);
        }
    }

    public void setCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.f5247d != onConstraintUpdatedCallback) {
            this.f5247d = onConstraintUpdatedCallback;
            m3974c();
        }
    }
}
