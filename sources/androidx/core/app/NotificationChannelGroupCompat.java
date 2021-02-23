package androidx.core.app;

import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;

public class NotificationChannelGroupCompat {

    /* renamed from: a */
    final String f2016a;

    /* renamed from: b */
    CharSequence f2017b;

    /* renamed from: c */
    String f2018c;

    public static class Builder {

        /* renamed from: a */
        private final NotificationChannelGroupCompat f2019a;

        public Builder(@NonNull String str) {
            this.f2019a = new NotificationChannelGroupCompat(str);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.f2019a;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.f2019a.f2018c = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f2019a.f2017b = charSequence;
            return this;
        }
    }

    NotificationChannelGroupCompat(@NonNull String str) {
        this.f2016a = (String) Preconditions.checkNotNull(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public NotificationChannelGroup mo3674a() {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(this.f2016a, this.f2017b);
        if (i >= 28) {
            notificationChannelGroup.setDescription(this.f2018c);
        }
        return notificationChannelGroup;
    }

    @Nullable
    public String getDescription() {
        return this.f2018c;
    }

    @NonNull
    public String getId() {
        return this.f2016a;
    }

    @Nullable
    public CharSequence getName() {
        return this.f2017b;
    }
}
