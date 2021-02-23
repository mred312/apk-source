package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {

    /* renamed from: a */
    private final Set<OnContextAvailableListener> f303a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private volatile Context f304b;

    public void addOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        if (this.f304b != null) {
            onContextAvailableListener.onContextAvailable(this.f304b);
        }
        this.f303a.add(onContextAvailableListener);
    }

    public void clearAvailableContext() {
        this.f304b = null;
    }

    public void dispatchOnContextAvailable(@NonNull Context context) {
        this.f304b = context;
        for (OnContextAvailableListener onContextAvailable : this.f303a) {
            onContextAvailable.onContextAvailable(context);
        }
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.f304b;
    }

    public void removeOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.f303a.remove(onContextAvailableListener);
    }
}
