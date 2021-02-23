package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContentUriTriggers {

    /* renamed from: a */
    private final Set<Trigger> f5041a = new HashSet();

    public static final class Trigger {
        @NonNull

        /* renamed from: a */
        private final Uri f5042a;

        /* renamed from: b */
        private final boolean f5043b;

        Trigger(@NonNull Uri uri, boolean z) {
            this.f5042a = uri;
            this.f5043b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Trigger.class != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            if (this.f5043b != trigger.f5043b || !this.f5042a.equals(trigger.f5042a)) {
                return false;
            }
            return true;
        }

        @NonNull
        public Uri getUri() {
            return this.f5042a;
        }

        public int hashCode() {
            return (this.f5042a.hashCode() * 31) + (this.f5043b ? 1 : 0);
        }

        public boolean shouldTriggerForDescendants() {
            return this.f5043b;
        }
    }

    public void add(@NonNull Uri uri, boolean z) {
        this.f5041a.add(new Trigger(uri, z));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentUriTriggers.class != obj.getClass()) {
            return false;
        }
        return this.f5041a.equals(((ContentUriTriggers) obj).f5041a);
    }

    @NonNull
    public Set<Trigger> getTriggers() {
        return this.f5041a;
    }

    public int hashCode() {
        return this.f5041a.hashCode();
    }

    public int size() {
        return this.f5041a.size();
    }
}
