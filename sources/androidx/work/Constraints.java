package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class Constraints {
    public static final Constraints NONE = new Builder().build();
    @ColumnInfo(name = "required_network_type")

    /* renamed from: a */
    private NetworkType f5025a = NetworkType.NOT_REQUIRED;
    @ColumnInfo(name = "requires_charging")

    /* renamed from: b */
    private boolean f5026b;
    @ColumnInfo(name = "requires_device_idle")

    /* renamed from: c */
    private boolean f5027c;
    @ColumnInfo(name = "requires_battery_not_low")

    /* renamed from: d */
    private boolean f5028d;
    @ColumnInfo(name = "requires_storage_not_low")

    /* renamed from: e */
    private boolean f5029e;
    @ColumnInfo(name = "trigger_content_update_delay")

    /* renamed from: f */
    private long f5030f = -1;
    @ColumnInfo(name = "trigger_max_content_delay")

    /* renamed from: g */
    private long f5031g = -1;
    @ColumnInfo(name = "content_uri_triggers")

    /* renamed from: h */
    private ContentUriTriggers f5032h = new ContentUriTriggers();

    public static final class Builder {

        /* renamed from: a */
        boolean f5033a = false;

        /* renamed from: b */
        boolean f5034b = false;

        /* renamed from: c */
        NetworkType f5035c = NetworkType.NOT_REQUIRED;

        /* renamed from: d */
        boolean f5036d = false;

        /* renamed from: e */
        boolean f5037e = false;

        /* renamed from: f */
        long f5038f = -1;

        /* renamed from: g */
        long f5039g = -1;

        /* renamed from: h */
        ContentUriTriggers f5040h = new ContentUriTriggers();

        @RequiresApi(24)
        @NonNull
        public Builder addContentUriTrigger(@NonNull Uri uri, boolean z) {
            this.f5040h.add(uri, z);
            return this;
        }

        @NonNull
        public Constraints build() {
            return new Constraints(this);
        }

        @NonNull
        public Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
            this.f5035c = networkType;
            return this;
        }

        @NonNull
        public Builder setRequiresBatteryNotLow(boolean z) {
            this.f5036d = z;
            return this;
        }

        @NonNull
        public Builder setRequiresCharging(boolean z) {
            this.f5033a = z;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setRequiresDeviceIdle(boolean z) {
            this.f5034b = z;
            return this;
        }

        @NonNull
        public Builder setRequiresStorageNotLow(boolean z) {
            this.f5037e = z;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentMaxDelay(long j, @NonNull TimeUnit timeUnit) {
            this.f5039g = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentUpdateDelay(long j, @NonNull TimeUnit timeUnit) {
            this.f5038f = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentMaxDelay(Duration duration) {
            this.f5039g = duration.toMillis();
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentUpdateDelay(Duration duration) {
            this.f5038f = duration.toMillis();
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Constraints() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.f5026b == constraints.f5026b && this.f5027c == constraints.f5027c && this.f5028d == constraints.f5028d && this.f5029e == constraints.f5029e && this.f5030f == constraints.f5030f && this.f5031g == constraints.f5031g && this.f5025a == constraints.f5025a) {
            return this.f5032h.equals(constraints.f5032h);
        }
        return false;
    }

    @RequiresApi(24)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ContentUriTriggers getContentUriTriggers() {
        return this.f5032h;
    }

    @NonNull
    public NetworkType getRequiredNetworkType() {
        return this.f5025a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerContentUpdateDelay() {
        return this.f5030f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerMaxContentDelay() {
        return this.f5031g;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasContentUriTriggers() {
        return this.f5032h.size() > 0;
    }

    public int hashCode() {
        long j = this.f5030f;
        long j2 = this.f5031g;
        return (((((((((((((this.f5025a.hashCode() * 31) + (this.f5026b ? 1 : 0)) * 31) + (this.f5027c ? 1 : 0)) * 31) + (this.f5028d ? 1 : 0)) * 31) + (this.f5029e ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f5032h.hashCode();
    }

    public boolean requiresBatteryNotLow() {
        return this.f5028d;
    }

    public boolean requiresCharging() {
        return this.f5026b;
    }

    @RequiresApi(23)
    public boolean requiresDeviceIdle() {
        return this.f5027c;
    }

    public boolean requiresStorageNotLow() {
        return this.f5029e;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setContentUriTriggers(@Nullable ContentUriTriggers contentUriTriggers) {
        this.f5032h = contentUriTriggers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiredNetworkType(@NonNull NetworkType networkType) {
        this.f5025a = networkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresBatteryNotLow(boolean z) {
        this.f5028d = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresCharging(boolean z) {
        this.f5026b = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresDeviceIdle(boolean z) {
        this.f5027c = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresStorageNotLow(boolean z) {
        this.f5029e = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerContentUpdateDelay(long j) {
        this.f5030f = j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerMaxContentDelay(long j) {
        this.f5031g = j;
    }

    Constraints(Builder builder) {
        this.f5026b = builder.f5033a;
        int i = Build.VERSION.SDK_INT;
        this.f5027c = i >= 23 && builder.f5034b;
        this.f5025a = builder.f5035c;
        this.f5028d = builder.f5036d;
        this.f5029e = builder.f5037e;
        if (i >= 24) {
            this.f5032h = builder.f5040h;
            this.f5030f = builder.f5038f;
            this.f5031g = builder.f5039g;
        }
    }

    public Constraints(@NonNull Constraints constraints) {
        this.f5026b = constraints.f5026b;
        this.f5027c = constraints.f5027c;
        this.f5025a = constraints.f5025a;
        this.f5028d = constraints.f5028d;
        this.f5029e = constraints.f5029e;
        this.f5032h = constraints.f5032h;
    }
}
