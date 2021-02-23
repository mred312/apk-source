package androidx.work.impl.constraints;

import androidx.annotation.NonNull;

public class NetworkState {

    /* renamed from: a */
    private boolean f5236a;

    /* renamed from: b */
    private boolean f5237b;

    /* renamed from: c */
    private boolean f5238c;

    /* renamed from: d */
    private boolean f5239d;

    public NetworkState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5236a = z;
        this.f5237b = z2;
        this.f5238c = z3;
        this.f5239d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        if (this.f5236a == networkState.f5236a && this.f5237b == networkState.f5237b && this.f5238c == networkState.f5238c && this.f5239d == networkState.f5239d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f5236a ? 1 : 0;
        if (this.f5237b) {
            i += 16;
        }
        if (this.f5238c) {
            i += 256;
        }
        return this.f5239d ? i + 4096 : i;
    }

    public boolean isConnected() {
        return this.f5236a;
    }

    public boolean isMetered() {
        return this.f5238c;
    }

    public boolean isNotRoaming() {
        return this.f5239d;
    }

    public boolean isValidated() {
        return this.f5237b;
    }

    @NonNull
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.f5236a), Boolean.valueOf(this.f5237b), Boolean.valueOf(this.f5238c), Boolean.valueOf(this.f5239d)});
    }
}
