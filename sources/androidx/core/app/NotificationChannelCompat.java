package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    @NonNull

    /* renamed from: a */
    final String f2001a;

    /* renamed from: b */
    CharSequence f2002b;

    /* renamed from: c */
    int f2003c;

    /* renamed from: d */
    String f2004d;

    /* renamed from: e */
    String f2005e;

    /* renamed from: f */
    boolean f2006f = true;

    /* renamed from: g */
    Uri f2007g = Settings.System.DEFAULT_NOTIFICATION_URI;

    /* renamed from: h */
    AudioAttributes f2008h;

    /* renamed from: i */
    boolean f2009i;

    /* renamed from: j */
    int f2010j = 0;

    /* renamed from: k */
    boolean f2011k;

    /* renamed from: l */
    long[] f2012l;

    /* renamed from: m */
    String f2013m;

    /* renamed from: n */
    String f2014n;

    public static class Builder {

        /* renamed from: a */
        private final NotificationChannelCompat f2015a;

        public Builder(@NonNull String str, int i) {
            this.f2015a = new NotificationChannelCompat(str, i);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.f2015a;
        }

        @NonNull
        public Builder setConversationId(@NonNull String str, @NonNull String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                NotificationChannelCompat notificationChannelCompat = this.f2015a;
                notificationChannelCompat.f2013m = str;
                notificationChannelCompat.f2014n = str2;
            }
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.f2015a.f2004d = str;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.f2015a.f2005e = str;
            return this;
        }

        @NonNull
        public Builder setImportance(int i) {
            this.f2015a.f2003c = i;
            return this;
        }

        @NonNull
        public Builder setLightColor(int i) {
            this.f2015a.f2010j = i;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean z) {
            this.f2015a.f2009i = z;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f2015a.f2002b = charSequence;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean z) {
            this.f2015a.f2006f = z;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.f2015a;
            notificationChannelCompat.f2007g = uri;
            notificationChannelCompat.f2008h = audioAttributes;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean z) {
            this.f2015a.f2011k = z;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] jArr) {
            NotificationChannelCompat notificationChannelCompat = this.f2015a;
            notificationChannelCompat.f2011k = jArr != null && jArr.length > 0;
            notificationChannelCompat.f2012l = jArr;
            return this;
        }
    }

    NotificationChannelCompat(@NonNull String str, int i) {
        this.f2001a = (String) Preconditions.checkNotNull(str);
        this.f2003c = i;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2008h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public NotificationChannel mo3647a() {
        String str;
        String str2;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(this.f2001a, this.f2002b, this.f2003c);
        notificationChannel.setDescription(this.f2004d);
        notificationChannel.setGroup(this.f2005e);
        notificationChannel.setShowBadge(this.f2006f);
        notificationChannel.setSound(this.f2007g, this.f2008h);
        notificationChannel.enableLights(this.f2009i);
        notificationChannel.setLightColor(this.f2010j);
        notificationChannel.setVibrationPattern(this.f2012l);
        notificationChannel.enableVibration(this.f2011k);
        if (!(i < 30 || (str = this.f2013m) == null || (str2 = this.f2014n) == null)) {
            notificationChannel.setConversationId(str, str2);
        }
        return notificationChannel;
    }

    public boolean canShowBadge() {
        return this.f2006f;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.f2008h;
    }

    @Nullable
    public String getConversationId() {
        return this.f2014n;
    }

    @Nullable
    public String getDescription() {
        return this.f2004d;
    }

    @Nullable
    public String getGroup() {
        return this.f2005e;
    }

    @NonNull
    public String getId() {
        return this.f2001a;
    }

    public int getImportance() {
        return this.f2003c;
    }

    public int getLightColor() {
        return this.f2010j;
    }

    @Nullable
    public CharSequence getName() {
        return this.f2002b;
    }

    @Nullable
    public String getParentChannelId() {
        return this.f2013m;
    }

    @Nullable
    public Uri getSound() {
        return this.f2007g;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.f2012l;
    }

    public boolean shouldShowLights() {
        return this.f2009i;
    }

    public boolean shouldVibrate() {
        return this.f2011k;
    }
}
