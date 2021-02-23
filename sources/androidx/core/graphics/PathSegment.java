package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

public final class PathSegment {

    /* renamed from: a */
    private final PointF f2321a;

    /* renamed from: b */
    private final float f2322b;

    /* renamed from: c */
    private final PointF f2323c;

    /* renamed from: d */
    private final float f2324d;

    public PathSegment(@NonNull PointF pointF, float f, @NonNull PointF pointF2, float f2) {
        this.f2321a = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.f2322b = f;
        this.f2323c = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.f2324d = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        if (Float.compare(this.f2322b, pathSegment.f2322b) != 0 || Float.compare(this.f2324d, pathSegment.f2324d) != 0 || !this.f2321a.equals(pathSegment.f2321a) || !this.f2323c.equals(pathSegment.f2323c)) {
            return false;
        }
        return true;
    }

    @NonNull
    public PointF getEnd() {
        return this.f2323c;
    }

    public float getEndFraction() {
        return this.f2324d;
    }

    @NonNull
    public PointF getStart() {
        return this.f2321a;
    }

    public float getStartFraction() {
        return this.f2322b;
    }

    public int hashCode() {
        int hashCode = this.f2321a.hashCode() * 31;
        float f = this.f2322b;
        int i = 0;
        int floatToIntBits = (((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.f2323c.hashCode()) * 31;
        float f2 = this.f2324d;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i;
    }

    public String toString() {
        return "PathSegment{start=" + this.f2321a + ", startFraction=" + this.f2322b + ", end=" + this.f2323c + ", endFraction=" + this.f2324d + '}';
    }
}
