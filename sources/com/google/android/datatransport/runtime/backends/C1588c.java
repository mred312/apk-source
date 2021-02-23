package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;

/* renamed from: com.google.android.datatransport.runtime.backends.c */
/* compiled from: AutoValue_CreationContext */
final class C1588c extends CreationContext {

    /* renamed from: a */
    private final Context f7212a;

    /* renamed from: b */
    private final Clock f7213b;

    /* renamed from: c */
    private final Clock f7214c;

    /* renamed from: d */
    private final String f7215d;

    C1588c(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.f7212a = context;
            if (clock != null) {
                this.f7213b = clock;
                if (clock2 != null) {
                    this.f7214c = clock2;
                    if (str != null) {
                        this.f7215d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (!this.f7212a.equals(creationContext.getApplicationContext()) || !this.f7213b.equals(creationContext.getWallClock()) || !this.f7214c.equals(creationContext.getMonotonicClock()) || !this.f7215d.equals(creationContext.getBackendName())) {
            return false;
        }
        return true;
    }

    public Context getApplicationContext() {
        return this.f7212a;
    }

    @NonNull
    public String getBackendName() {
        return this.f7215d;
    }

    public Clock getMonotonicClock() {
        return this.f7214c;
    }

    public Clock getWallClock() {
        return this.f7213b;
    }

    public int hashCode() {
        return ((((((this.f7212a.hashCode() ^ 1000003) * 1000003) ^ this.f7213b.hashCode()) * 1000003) ^ this.f7214c.hashCode()) * 1000003) ^ this.f7215d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f7212a + ", wallClock=" + this.f7213b + ", monotonicClock=" + this.f7214c + ", backendName=" + this.f7215d + "}";
    }
}
