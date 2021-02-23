package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.C0401R;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.p002pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;

        /* renamed from: a */
        final Bundle f2020a;
        public PendingIntent actionIntent;
        @Nullable

        /* renamed from: b */
        private IconCompat f2021b;

        /* renamed from: c */
        private final RemoteInput[] f2022c;

        /* renamed from: d */
        private final RemoteInput[] f2023d;

        /* renamed from: e */
        private boolean f2024e;

        /* renamed from: f */
        boolean f2025f;

        /* renamed from: g */
        private final int f2026g;

        /* renamed from: h */
        private final boolean f2027h;
        @Deprecated
        public int icon;
        public CharSequence title;

        public static final class Builder {

            /* renamed from: a */
            private final IconCompat f2028a;

            /* renamed from: b */
            private final CharSequence f2029b;

            /* renamed from: c */
            private final PendingIntent f2030c;

            /* renamed from: d */
            private boolean f2031d;

            /* renamed from: e */
            private final Bundle f2032e;

            /* renamed from: f */
            private ArrayList<RemoteInput> f2033f;

            /* renamed from: g */
            private int f2034g;

            /* renamed from: h */
            private boolean f2035h;

            /* renamed from: i */
            private boolean f2036i;

            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false);
            }

            /* renamed from: a */
            private void m1375a() {
                if (this.f2036i && this.f2030c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            @RequiresApi(19)
            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder fromAndroidAction(@NonNull Notification.Action action) {
                Builder builder;
                RemoteInput[] remoteInputs;
                int i = Build.VERSION.SDK_INT;
                if (i < 23 || action.getIcon() == null) {
                    builder = new Builder(action.icon, action.title, action.actionIntent);
                } else {
                    builder = new Builder(IconCompat.createFromIcon(action.getIcon()), action.title, action.actionIntent);
                }
                if (!(i < 20 || (remoteInputs = action.getRemoteInputs()) == null || remoteInputs.length == 0)) {
                    for (RemoteInput c : remoteInputs) {
                        builder.addRemoteInput(RemoteInput.m1426c(c));
                    }
                }
                if (i >= 24) {
                    builder.f2031d = action.getAllowGeneratedReplies();
                }
                if (i >= 28) {
                    builder.setSemanticAction(action.getSemanticAction());
                }
                if (i >= 29) {
                    builder.setContextual(action.isContextual());
                }
                return builder;
            }

            @NonNull
            public Builder addExtras(@Nullable Bundle bundle) {
                if (bundle != null) {
                    this.f2032e.putAll(bundle);
                }
                return this;
            }

            @NonNull
            public Builder addRemoteInput(@Nullable RemoteInput remoteInput) {
                if (this.f2033f == null) {
                    this.f2033f = new ArrayList<>();
                }
                if (remoteInput != null) {
                    this.f2033f.add(remoteInput);
                }
                return this;
            }

            /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.annotation.NonNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.core.app.NotificationCompat.Action build() {
                /*
                    r15 = this;
                    r15.m1375a()
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList<androidx.core.app.RemoteInput> r2 = r15.f2033f
                    if (r2 == 0) goto L_0x002f
                    java.util.Iterator r2 = r2.iterator()
                L_0x0015:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x002f
                    java.lang.Object r3 = r2.next()
                    androidx.core.app.RemoteInput r3 = (androidx.core.app.RemoteInput) r3
                    boolean r4 = r3.isDataOnly()
                    if (r4 == 0) goto L_0x002b
                    r0.add(r3)
                    goto L_0x0015
                L_0x002b:
                    r1.add(r3)
                    goto L_0x0015
                L_0x002f:
                    boolean r2 = r0.isEmpty()
                    r3 = 0
                    if (r2 == 0) goto L_0x0038
                    r10 = r3
                    goto L_0x0045
                L_0x0038:
                    int r2 = r0.size()
                    androidx.core.app.RemoteInput[] r2 = new androidx.core.app.RemoteInput[r2]
                    java.lang.Object[] r0 = r0.toArray(r2)
                    androidx.core.app.RemoteInput[] r0 = (androidx.core.app.RemoteInput[]) r0
                    r10 = r0
                L_0x0045:
                    boolean r0 = r1.isEmpty()
                    if (r0 == 0) goto L_0x004c
                    goto L_0x0059
                L_0x004c:
                    int r0 = r1.size()
                    androidx.core.app.RemoteInput[] r0 = new androidx.core.app.RemoteInput[r0]
                    java.lang.Object[] r0 = r1.toArray(r0)
                    r3 = r0
                    androidx.core.app.RemoteInput[] r3 = (androidx.core.app.RemoteInput[]) r3
                L_0x0059:
                    r9 = r3
                    androidx.core.app.NotificationCompat$Action r0 = new androidx.core.app.NotificationCompat$Action
                    androidx.core.graphics.drawable.IconCompat r5 = r15.f2028a
                    java.lang.CharSequence r6 = r15.f2029b
                    android.app.PendingIntent r7 = r15.f2030c
                    android.os.Bundle r8 = r15.f2032e
                    boolean r11 = r15.f2031d
                    int r12 = r15.f2034g
                    boolean r13 = r15.f2035h
                    boolean r14 = r15.f2036i
                    r4 = r0
                    r4.<init>((androidx.core.graphics.drawable.IconCompat) r5, (java.lang.CharSequence) r6, (android.app.PendingIntent) r7, (android.os.Bundle) r8, (androidx.core.app.RemoteInput[]) r9, (androidx.core.app.RemoteInput[]) r10, (boolean) r11, (int) r12, (boolean) r13, (boolean) r14)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Action.Builder.build():androidx.core.app.NotificationCompat$Action");
            }

            @NonNull
            public Builder extend(@NonNull Extender extender) {
                extender.extend(this);
                return this;
            }

            @NonNull
            public Bundle getExtras() {
                return this.f2032e;
            }

            @NonNull
            public Builder setAllowGeneratedReplies(boolean z) {
                this.f2031d = z;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean z) {
                this.f2036i = z;
                return this;
            }

            @NonNull
            public Builder setSemanticAction(int i) {
                this.f2034g = i;
                return this;
            }

            @NonNull
            public Builder setShowsUserInterface(boolean z) {
                this.f2035h = z;
                return this;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Builder(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.createWithResource((Resources) null, "", i) : null, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false);
            }

            public Builder(@NonNull Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.f2020a), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.f2025f, action.isContextual());
            }

            private Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable RemoteInput[] remoteInputArr, boolean z, int i, boolean z2, boolean z3) {
                ArrayList<RemoteInput> arrayList;
                this.f2031d = true;
                this.f2035h = true;
                this.f2028a = iconCompat;
                this.f2029b = Builder.limitCharSequenceLength(charSequence);
                this.f2030c = pendingIntent;
                this.f2032e = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(remoteInputArr));
                }
                this.f2033f = arrayList;
                this.f2031d = z;
                this.f2034g = i;
                this.f2035h = z2;
                this.f2036i = z3;
            }
        }

        public interface Extender {
            @NonNull
            Builder extend(@NonNull Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {

            /* renamed from: a */
            private int f2037a = 1;

            /* renamed from: b */
            private CharSequence f2038b;

            /* renamed from: c */
            private CharSequence f2039c;

            /* renamed from: d */
            private CharSequence f2040d;

            public WearableExtender() {
            }

            /* renamed from: a */
            private void m1376a(int i, boolean z) {
                if (z) {
                    this.f2037a = i | this.f2037a;
                    return;
                }
                this.f2037a = (i ^ -1) & this.f2037a;
            }

            @NonNull
            public Builder extend(@NonNull Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.f2037a;
                if (i != 1) {
                    bundle.putInt("flags", i);
                }
                CharSequence charSequence = this.f2038b;
                if (charSequence != null) {
                    bundle.putCharSequence("inProgressLabel", charSequence);
                }
                CharSequence charSequence2 = this.f2039c;
                if (charSequence2 != null) {
                    bundle.putCharSequence("confirmLabel", charSequence2);
                }
                CharSequence charSequence3 = this.f2040d;
                if (charSequence3 != null) {
                    bundle.putCharSequence("cancelLabel", charSequence3);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            @Deprecated
            @Nullable
            public CharSequence getCancelLabel() {
                return this.f2040d;
            }

            @Deprecated
            @Nullable
            public CharSequence getConfirmLabel() {
                return this.f2039c;
            }

            public boolean getHintDisplayActionInline() {
                return (this.f2037a & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.f2037a & 2) != 0;
            }

            @Deprecated
            @Nullable
            public CharSequence getInProgressLabel() {
                return this.f2038b;
            }

            public boolean isAvailableOffline() {
                return (this.f2037a & 1) != 0;
            }

            @NonNull
            public WearableExtender setAvailableOffline(boolean z) {
                m1376a(1, z);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setCancelLabel(@Nullable CharSequence charSequence) {
                this.f2040d = charSequence;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setConfirmLabel(@Nullable CharSequence charSequence) {
                this.f2039c = charSequence;
                return this;
            }

            @NonNull
            public WearableExtender setHintDisplayActionInline(boolean z) {
                m1376a(4, z);
                return this;
            }

            @NonNull
            public WearableExtender setHintLaunchesActivity(boolean z) {
                m1376a(2, z);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setInProgressLabel(@Nullable CharSequence charSequence) {
                this.f2038b = charSequence;
                return this;
            }

            @NonNull
            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f2037a = this.f2037a;
                wearableExtender.f2038b = this.f2038b;
                wearableExtender.f2039c = this.f2039c;
                wearableExtender.f2040d = this.f2040d;
                return wearableExtender;
            }

            public WearableExtender(@NonNull Action action) {
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f2037a = bundle.getInt("flags", 1);
                    this.f2038b = bundle.getCharSequence("inProgressLabel");
                    this.f2039c = bundle.getCharSequence("confirmLabel");
                    this.f2040d = bundle.getCharSequence("cancelLabel");
                }
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.createWithResource((Resources) null, "", i) : null, charSequence, pendingIntent);
        }

        @Nullable
        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.f2024e;
        }

        @Nullable
        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.f2023d;
        }

        @NonNull
        public Bundle getExtras() {
            return this.f2020a;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            int i;
            if (this.f2021b == null && (i = this.icon) != 0) {
                this.f2021b = IconCompat.createWithResource((Resources) null, "", i);
            }
            return this.f2021b;
        }

        @Nullable
        public RemoteInput[] getRemoteInputs() {
            return this.f2022c;
        }

        public int getSemanticAction() {
            return this.f2026g;
        }

        public boolean getShowsUserInterface() {
            return this.f2025f;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isContextual() {
            return this.f2027h;
        }

        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        Action(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable RemoteInput[] remoteInputArr, @Nullable RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3) {
            this(i != 0 ? IconCompat.createWithResource((Resources) null, "", i) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i2, z2, z3);
        }

        Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable RemoteInput[] remoteInputArr, @Nullable RemoteInput[] remoteInputArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f2025f = true;
            this.f2021b = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.f2020a = bundle == null ? new Bundle() : bundle;
            this.f2022c = remoteInputArr;
            this.f2023d = remoteInputArr2;
            this.f2024e = z;
            this.f2026g = i;
            this.f2025f = z2;
            this.f2027h = z3;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {

        /* renamed from: d */
        private Bitmap f2041d;

        /* renamed from: e */
        private Bitmap f2042e;

        /* renamed from: f */
        private boolean f2043f;

        public BigPictureStyle() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            if (this.f2043f) {
                bundle.putParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG, this.f2042e);
            }
            bundle.putParcelable(NotificationCompat.EXTRA_PICTURE, this.f2041d);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f2129a).bigPicture(this.f2041d);
                if (this.f2043f) {
                    bigPicture.bigLargeIcon(this.f2042e);
                }
                if (this.f2131c) {
                    bigPicture.setSummaryText(this.f2130b);
                }
            }
        }

        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Bitmap bitmap) {
            this.f2042e = bitmap;
            this.f2043f = true;
            return this;
        }

        @NonNull
        public BigPictureStyle bigPicture(@Nullable Bitmap bitmap) {
            this.f2041d = bitmap;
            return this;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            bundle.remove(NotificationCompat.EXTRA_PICTURE);
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            if (bundle.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
                this.f2042e = (Bitmap) bundle.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG);
                this.f2043f = true;
            }
            this.f2041d = (Bitmap) bundle.getParcelable(NotificationCompat.EXTRA_PICTURE);
        }

        @NonNull
        public BigPictureStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.f2129a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public BigPictureStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.f2130b = Builder.limitCharSequenceLength(charSequence);
            this.f2131c = true;
            return this;
        }

        public BigPictureStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    public static class BigTextStyle extends Style {

        /* renamed from: d */
        private CharSequence f2044d;

        public BigTextStyle() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_BIG_TEXT, this.f2044d);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f2129a).bigText(this.f2044d);
                if (this.f2131c) {
                    bigText.setSummaryText(this.f2130b);
                }
            }
        }

        @NonNull
        public BigTextStyle bigText(@Nullable CharSequence charSequence) {
            this.f2044d = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.f2044d = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @NonNull
        public BigTextStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.f2129a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public BigTextStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.f2130b = Builder.limitCharSequenceLength(charSequence);
            this.f2131c = true;
            return this;
        }

        public BigTextStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    public static final class BubbleMetadata {

        /* renamed from: a */
        private PendingIntent f2045a;

        /* renamed from: b */
        private PendingIntent f2046b;

        /* renamed from: c */
        private IconCompat f2047c;

        /* renamed from: d */
        private int f2048d;
        @DimenRes

        /* renamed from: e */
        private int f2049e;

        /* renamed from: f */
        private int f2050f;

        public static final class Builder {

            /* renamed from: a */
            private PendingIntent f2051a;

            /* renamed from: b */
            private IconCompat f2052b;

            /* renamed from: c */
            private int f2053c;
            @DimenRes

            /* renamed from: d */
            private int f2054d;

            /* renamed from: e */
            private int f2055e;

            /* renamed from: f */
            private PendingIntent f2056f;

            @NonNull
            /* renamed from: a */
            private Builder m1377a(int i, boolean z) {
                if (z) {
                    this.f2055e = i | this.f2055e;
                } else {
                    this.f2055e = (i ^ -1) & this.f2055e;
                }
                return this;
            }

            @SuppressLint({"SyntheticAccessor"})
            @NonNull
            public BubbleMetadata build() {
                PendingIntent pendingIntent = this.f2051a;
                if (pendingIntent != null) {
                    IconCompat iconCompat = this.f2052b;
                    if (iconCompat != null) {
                        return new BubbleMetadata(pendingIntent, this.f2056f, iconCompat, this.f2053c, this.f2054d, this.f2055e);
                    }
                    throw new IllegalStateException("Must supply an icon for the bubble");
                }
                throw new IllegalStateException("Must supply pending intent to bubble");
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean z) {
                m1377a(1, z);
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
                this.f2056f = pendingIntent;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int i) {
                this.f2053c = Math.max(i, 0);
                this.f2054d = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int i) {
                this.f2054d = i;
                this.f2053c = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat iconCompat) {
                if (iconCompat == null) {
                    throw new IllegalArgumentException("Bubbles require non-null icon");
                } else if (iconCompat.getType() != 1) {
                    this.f2052b = iconCompat;
                    return this;
                } else {
                    throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
                }
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent pendingIntent) {
                if (pendingIntent != null) {
                    this.f2051a = pendingIntent;
                    return this;
                }
                throw new IllegalArgumentException("Bubble requires non-null pending intent");
            }

            @NonNull
            public Builder setSuppressNotification(boolean z) {
                m1377a(2, z);
                return this;
            }
        }

        @RequiresApi(29)
        @Nullable
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            Builder suppressNotification = new Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(bubbleMetadata.getIcon())).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
            if (bubbleMetadata.getDesiredHeight() != 0) {
                suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
            }
            if (bubbleMetadata.getDesiredHeightResId() != 0) {
                suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
            }
            return suppressNotification.build();
        }

        @RequiresApi(29)
        @Nullable
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
            if (bubbleMetadata.getDesiredHeight() != 0) {
                suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
            }
            if (bubbleMetadata.getDesiredHeightResId() != 0) {
                suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
            }
            return suppressNotification.build();
        }

        public boolean getAutoExpandBubble() {
            return (this.f2050f & 1) != 0;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.f2046b;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.f2048d;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.f2049e;
        }

        @NonNull
        public IconCompat getIcon() {
            return this.f2047c;
        }

        @NonNull
        public PendingIntent getIntent() {
            return this.f2045a;
        }

        public boolean isNotificationSuppressed() {
            return (this.f2050f & 2) != 0;
        }

        private BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i, @DimenRes int i2, int i3) {
            this.f2045a = pendingIntent;
            this.f2047c = iconCompat;
            this.f2048d = i;
            this.f2049e = i2;
            this.f2046b = pendingIntent2;
            this.f2050f = i3;
        }
    }

    public static class Builder {

        /* renamed from: A */
        String f2057A;

        /* renamed from: B */
        Bundle f2058B;

        /* renamed from: C */
        int f2059C;

        /* renamed from: D */
        int f2060D;

        /* renamed from: E */
        Notification f2061E;

        /* renamed from: F */
        RemoteViews f2062F;

        /* renamed from: G */
        RemoteViews f2063G;

        /* renamed from: H */
        RemoteViews f2064H;

        /* renamed from: I */
        String f2065I;

        /* renamed from: J */
        int f2066J;

        /* renamed from: K */
        String f2067K;

        /* renamed from: L */
        LocusIdCompat f2068L;

        /* renamed from: M */
        long f2069M;

        /* renamed from: N */
        int f2070N;

        /* renamed from: O */
        boolean f2071O;

        /* renamed from: P */
        BubbleMetadata f2072P;

        /* renamed from: Q */
        Notification f2073Q;

        /* renamed from: R */
        boolean f2074R;

        /* renamed from: S */
        Icon f2075S;

        /* renamed from: a */
        ArrayList<Action> f2076a;

        /* renamed from: b */
        CharSequence f2077b;

        /* renamed from: c */
        CharSequence f2078c;

        /* renamed from: d */
        PendingIntent f2079d;

        /* renamed from: e */
        PendingIntent f2080e;

        /* renamed from: f */
        RemoteViews f2081f;

        /* renamed from: g */
        Bitmap f2082g;

        /* renamed from: h */
        CharSequence f2083h;

        /* renamed from: i */
        int f2084i;

        /* renamed from: j */
        int f2085j;

        /* renamed from: k */
        boolean f2086k;

        /* renamed from: l */
        boolean f2087l;

        /* renamed from: m */
        boolean f2088m;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;
        @Deprecated
        public ArrayList<String> mPeople;
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Person> mPersonList;

        /* renamed from: n */
        Style f2089n;

        /* renamed from: o */
        CharSequence f2090o;

        /* renamed from: p */
        CharSequence f2091p;

        /* renamed from: q */
        CharSequence[] f2092q;

        /* renamed from: r */
        int f2093r;

        /* renamed from: s */
        int f2094s;

        /* renamed from: t */
        boolean f2095t;

        /* renamed from: u */
        String f2096u;

        /* renamed from: v */
        boolean f2097v;

        /* renamed from: w */
        String f2098w;

        /* renamed from: x */
        boolean f2099x;

        /* renamed from: y */
        boolean f2100y;

        /* renamed from: z */
        boolean f2101z;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public Builder(@NonNull Context context, @NonNull Notification notification) {
            this(context, NotificationCompat.getChannelId(notification));
            ArrayList parcelableArrayList;
            int i = Build.VERSION.SDK_INT;
            Bundle bundle = notification.extras;
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(extractStyleFromNotification).setContentIntent(notification.contentIntent).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, NotificationCompat.m1373b(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(bundle.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), bundle.getInt(NotificationCompat.EXTRA_PROGRESS), bundle.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(m1378a(notification, extractStyleFromNotification));
            if (i >= 23) {
                this.f2075S = notification.getSmallIcon();
            }
            Notification.Action[] actionArr = notification.actions;
            if (!(actionArr == null || actionArr.length == 0)) {
                for (Notification.Action fromAndroidAction : actionArr) {
                    addAction(Action.Builder.fromAndroidAction(fromAndroidAction).build());
                }
            }
            if (i >= 21) {
                List<Action> invisibleActions = NotificationCompat.getInvisibleActions(notification);
                if (!invisibleActions.isEmpty()) {
                    for (Action addInvisibleAction : invisibleActions) {
                        addInvisibleAction(addInvisibleAction);
                    }
                }
            }
            String[] stringArray = notification.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (!(stringArray == null || stringArray.length == 0)) {
                for (String addPerson : stringArray) {
                    addPerson(addPerson);
                }
            }
            if (i >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    addPerson(Person.fromAndroidPerson((Person) it.next()));
                }
            }
            if (i >= 24 && bundle.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                setChronometerCountDown(bundle.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (i >= 26 && bundle.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
                setColorized(bundle.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            }
        }

        @RequiresApi(19)
        @Nullable
        /* renamed from: a */
        private static Bundle m1378a(@NonNull Notification notification, @Nullable Style style) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove(NotificationCompat.EXTRA_TITLE);
            bundle.remove(NotificationCompat.EXTRA_TEXT);
            bundle.remove(NotificationCompat.EXTRA_INFO_TEXT);
            bundle.remove(NotificationCompat.EXTRA_SUB_TEXT);
            bundle.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            bundle.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            bundle.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            bundle.remove(NotificationCompat.EXTRA_PROGRESS);
            bundle.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            bundle.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            bundle.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            bundle.remove(NotificationCompat.EXTRA_COLORIZED);
            bundle.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            bundle.remove(NotificationCompat.EXTRA_PEOPLE);
            bundle.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            bundle.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            bundle.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            bundle.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            bundle.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (style != null) {
                style.clearCompatExtraKeys(bundle);
            }
            return bundle;
        }

        @Nullable
        /* renamed from: b */
        private Bitmap m1379b(@Nullable Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0401R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C0401R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d = (double) dimensionPixelSize;
            double max = (double) Math.max(1, bitmap.getWidth());
            Double.isNaN(d);
            Double.isNaN(max);
            double d2 = d / max;
            double d3 = (double) dimensionPixelSize2;
            double max2 = (double) Math.max(1, bitmap.getHeight());
            Double.isNaN(d3);
            Double.isNaN(max2);
            double min = Math.min(d2, d3 / max2);
            double width = (double) bitmap.getWidth();
            Double.isNaN(width);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        /* renamed from: c */
        private void m1380c(int i, boolean z) {
            if (z) {
                Notification notification = this.f2073Q;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.f2073Q;
            notification2.flags = (i ^ -1) & notification2.flags;
        }

        /* renamed from: d */
        private boolean m1381d() {
            Style style = this.f2089n;
            return style == null || !style.displayCustomViewInline();
        }

        @Nullable
        protected static CharSequence limitCharSequenceLength(@Nullable CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        @NonNull
        public Builder addAction(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.f2058B;
                if (bundle2 == null) {
                    this.f2058B = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        @RequiresApi(21)
        @NonNull
        public Builder addInvisibleAction(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.f2076a.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addPerson(@Nullable String str) {
            if (str != null && !str.isEmpty()) {
                this.mPeople.add(str);
            }
            return this;
        }

        @NonNull
        public Notification build() {
            return new C0435b(this).mo4067b();
        }

        @NonNull
        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        public Builder clearInvisibleActions() {
            this.f2076a.clear();
            Bundle bundle = this.f2058B.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.f2058B.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        @NonNull
        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews createBigContentView() {
            RemoteViews makeBigContentView;
            int i = Build.VERSION.SDK_INT;
            if (i < 16) {
                return null;
            }
            if (this.f2063G != null && m1381d()) {
                return this.f2063G;
            }
            C0435b bVar = new C0435b(this);
            Style style = this.f2089n;
            if (style != null && (makeBigContentView = style.makeBigContentView(bVar)) != null) {
                return makeBigContentView;
            }
            Notification b = bVar.mo4067b();
            if (i >= 24) {
                return Notification.Builder.recoverBuilder(this.mContext, b).createBigContentView();
            }
            return b.bigContentView;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews createContentView() {
            RemoteViews makeContentView;
            if (this.f2062F != null && m1381d()) {
                return this.f2062F;
            }
            C0435b bVar = new C0435b(this);
            Style style = this.f2089n;
            if (style != null && (makeContentView = style.makeContentView(bVar)) != null) {
                return makeContentView;
            }
            Notification b = bVar.mo4067b();
            if (Build.VERSION.SDK_INT >= 24) {
                return Notification.Builder.recoverBuilder(this.mContext, b).createContentView();
            }
            return b.contentView;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews createHeadsUpContentView() {
            RemoteViews makeHeadsUpContentView;
            int i = Build.VERSION.SDK_INT;
            if (i < 21) {
                return null;
            }
            if (this.f2064H != null && m1381d()) {
                return this.f2064H;
            }
            C0435b bVar = new C0435b(this);
            Style style = this.f2089n;
            if (style != null && (makeHeadsUpContentView = style.makeHeadsUpContentView(bVar)) != null) {
                return makeHeadsUpContentView;
            }
            Notification b = bVar.mo4067b();
            if (i >= 24) {
                return Notification.Builder.recoverBuilder(this.mContext, b).createHeadsUpContentView();
            }
            return b.headsUpContentView;
        }

        @NonNull
        public Builder extend(@NonNull Extender extender) {
            extender.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.f2063G;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.f2072P;
        }

        @ColorInt
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.f2059C;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.f2062F;
        }

        @NonNull
        public Bundle getExtras() {
            if (this.f2058B == null) {
                this.f2058B = new Bundle();
            }
            return this.f2058B;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.f2064H;
        }

        @NonNull
        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.f2085j;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.f2086k) {
                return this.f2073Q.when;
            }
            return 0;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean z) {
            this.f2071O = z;
            return this;
        }

        @NonNull
        public Builder setAutoCancel(boolean z) {
            m1380c(16, z);
            return this;
        }

        @NonNull
        public Builder setBadgeIconType(int i) {
            this.f2066J = i;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata bubbleMetadata) {
            this.f2072P = bubbleMetadata;
            return this;
        }

        @NonNull
        public Builder setCategory(@Nullable String str) {
            this.f2057A = str;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull String str) {
            this.f2065I = str;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setChronometerCountDown(boolean z) {
            this.f2088m = z;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z);
            return this;
        }

        @NonNull
        public Builder setColor(@ColorInt int i) {
            this.f2059C = i;
            return this;
        }

        @NonNull
        public Builder setColorized(boolean z) {
            this.f2100y = z;
            this.f2101z = true;
            return this;
        }

        @NonNull
        public Builder setContent(@Nullable RemoteViews remoteViews) {
            this.f2073Q.contentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder setContentInfo(@Nullable CharSequence charSequence) {
            this.f2083h = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setContentIntent(@Nullable PendingIntent pendingIntent) {
            this.f2079d = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setContentText(@Nullable CharSequence charSequence) {
            this.f2078c = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setContentTitle(@Nullable CharSequence charSequence) {
            this.f2077b = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setCustomBigContentView(@Nullable RemoteViews remoteViews) {
            this.f2063G = remoteViews;
            return this;
        }

        @NonNull
        public Builder setCustomContentView(@Nullable RemoteViews remoteViews) {
            this.f2062F = remoteViews;
            return this;
        }

        @NonNull
        public Builder setCustomHeadsUpContentView(@Nullable RemoteViews remoteViews) {
            this.f2064H = remoteViews;
            return this;
        }

        @NonNull
        public Builder setDefaults(int i) {
            Notification notification = this.f2073Q;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
            this.f2073Q.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.f2058B = bundle;
            return this;
        }

        @NonNull
        public Builder setFullScreenIntent(@Nullable PendingIntent pendingIntent, boolean z) {
            this.f2080e = pendingIntent;
            m1380c(128, z);
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.f2096u = str;
            return this;
        }

        @NonNull
        public Builder setGroupAlertBehavior(int i) {
            this.f2070N = i;
            return this;
        }

        @NonNull
        public Builder setGroupSummary(boolean z) {
            this.f2097v = z;
            return this;
        }

        @NonNull
        public Builder setLargeIcon(@Nullable Bitmap bitmap) {
            this.f2082g = m1379b(bitmap);
            return this;
        }

        @NonNull
        public Builder setLights(@ColorInt int i, int i2, int i3) {
            Notification notification = this.f2073Q;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            notification.flags = ((i2 == 0 || i3 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        @NonNull
        public Builder setLocalOnly(boolean z) {
            this.f2099x = z;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.f2068L = locusIdCompat;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNotificationSilent() {
            this.f2074R = true;
            return this;
        }

        @NonNull
        public Builder setNumber(int i) {
            this.f2084i = i;
            return this;
        }

        @NonNull
        public Builder setOngoing(boolean z) {
            m1380c(2, z);
            return this;
        }

        @NonNull
        public Builder setOnlyAlertOnce(boolean z) {
            m1380c(8, z);
            return this;
        }

        @NonNull
        public Builder setPriority(int i) {
            this.f2085j = i;
            return this;
        }

        @NonNull
        public Builder setProgress(int i, int i2, boolean z) {
            this.f2093r = i;
            this.f2094s = i2;
            this.f2095t = z;
            return this;
        }

        @NonNull
        public Builder setPublicVersion(@Nullable Notification notification) {
            this.f2061E = notification;
            return this;
        }

        @NonNull
        public Builder setRemoteInputHistory(@Nullable CharSequence[] charSequenceArr) {
            this.f2092q = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setSettingsText(@Nullable CharSequence charSequence) {
            this.f2091p = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setShortcutId(@Nullable String str) {
            this.f2067K = str;
            return this;
        }

        @NonNull
        public Builder setShortcutInfo(@Nullable ShortcutInfoCompat shortcutInfoCompat) {
            if (shortcutInfoCompat == null) {
                return this;
            }
            this.f2067K = shortcutInfoCompat.getId();
            if (this.f2068L == null) {
                if (shortcutInfoCompat.getLocusId() != null) {
                    this.f2068L = shortcutInfoCompat.getLocusId();
                } else if (shortcutInfoCompat.getId() != null) {
                    this.f2068L = new LocusIdCompat(shortcutInfoCompat.getId());
                }
            }
            if (this.f2077b == null) {
                setContentTitle(shortcutInfoCompat.getShortLabel());
            }
            return this;
        }

        @NonNull
        public Builder setShowWhen(boolean z) {
            this.f2086k = z;
            return this;
        }

        @NonNull
        public Builder setSilent(boolean z) {
            this.f2074R = z;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setSmallIcon(@NonNull IconCompat iconCompat) {
            this.f2075S = iconCompat.toIcon(this.mContext);
            return this;
        }

        @NonNull
        public Builder setSortKey(@Nullable String str) {
            this.f2098w = str;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri) {
            Notification notification = this.f2073Q;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        @NonNull
        public Builder setStyle(@Nullable Style style) {
            if (this.f2089n != style) {
                this.f2089n = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        @NonNull
        public Builder setSubText(@Nullable CharSequence charSequence) {
            this.f2090o = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setTicker(@Nullable CharSequence charSequence) {
            this.f2073Q.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setTimeoutAfter(long j) {
            this.f2069M = j;
            return this;
        }

        @NonNull
        public Builder setUsesChronometer(boolean z) {
            this.f2087l = z;
            return this;
        }

        @NonNull
        public Builder setVibrate(@Nullable long[] jArr) {
            this.f2073Q.vibrate = jArr;
            return this;
        }

        @NonNull
        public Builder setVisibility(int i) {
            this.f2060D = i;
            return this;
        }

        @NonNull
        public Builder setWhen(long j) {
            this.f2073Q.when = j;
            return this;
        }

        @NonNull
        public Builder addAction(@Nullable Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        @RequiresApi(21)
        @NonNull
        public Builder addInvisibleAction(@Nullable Action action) {
            if (action != null) {
                this.f2076a.add(action);
            }
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int i) {
            this.f2073Q.icon = i;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTicker(@Nullable CharSequence charSequence, @Nullable RemoteViews remoteViews) {
            this.f2073Q.tickerText = limitCharSequenceLength(charSequence);
            this.f2081f = remoteViews;
            return this;
        }

        @NonNull
        public Builder addPerson(@Nullable Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int i, int i2) {
            Notification notification = this.f2073Q;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, int i) {
            Notification notification = this.f2073Q;
            notification.sound = uri;
            notification.audioStreamType = i;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i).build();
            }
            return this;
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            this.mActions = new ArrayList<>();
            this.mPersonList = new ArrayList<>();
            this.f2076a = new ArrayList<>();
            this.f2086k = true;
            this.f2099x = false;
            this.f2059C = 0;
            this.f2060D = 0;
            this.f2066J = 0;
            this.f2070N = 0;
            Notification notification = new Notification();
            this.f2073Q = notification;
            this.mContext = context;
            this.f2065I = str;
            notification.when = System.currentTimeMillis();
            this.f2073Q.audioStreamType = -1;
            this.f2085j = 0;
            this.mPeople = new ArrayList<>();
            this.f2071O = true;
        }

        @Deprecated
        public Builder(@NonNull Context context) {
            this(context, (String) null);
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        /* renamed from: k */
        private RemoteViews m1384k(RemoteViews remoteViews, boolean z) {
            int min;
            boolean z2 = true;
            int i = 0;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, C0401R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(C0401R.C0403id.actions);
            List<Action> m = m1386m(this.mBuilder.mActions);
            if (!z || m == null || (min = Math.min(m.size(), 3)) <= 0) {
                z2 = false;
            } else {
                for (int i2 = 0; i2 < min; i2++) {
                    applyStandardTemplate.addView(C0401R.C0403id.actions, m1385l(m.get(i2)));
                }
            }
            if (!z2) {
                i = 8;
            }
            applyStandardTemplate.setViewVisibility(C0401R.C0403id.actions, i);
            applyStandardTemplate.setViewVisibility(C0401R.C0403id.action_divider, i);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        /* renamed from: l */
        private RemoteViews m1385l(Action action) {
            int i;
            boolean z = action.actionIntent == null;
            String packageName = this.mBuilder.mContext.getPackageName();
            if (z) {
                i = C0401R.layout.notification_action_tombstone;
            } else {
                i = C0401R.layout.notification_action;
            }
            RemoteViews remoteViews = new RemoteViews(packageName, i);
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                remoteViews.setImageViewBitmap(C0401R.C0403id.action_image, mo3872e(iconCompat, this.mBuilder.mContext.getResources().getColor(C0401R.color.notification_action_color_filter)));
            }
            remoteViews.setTextViewText(C0401R.C0403id.action_text, action.title);
            if (!z) {
                remoteViews.setOnClickPendingIntent(C0401R.C0403id.action_container, action.actionIntent);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(C0401R.C0403id.action_container, action.title);
            }
            return remoteViews;
        }

        /* renamed from: m */
        private static List<Action> m1386m(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action next : list) {
                if (!next.isContextual()) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return m1384k(bigContentView, true);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return m1384k(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            if (headsUpContentView != null) {
                remoteViews = headsUpContentView;
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (headsUpContentView == null) {
                return null;
            }
            return m1384k(remoteViews, true);
        }
    }

    public interface Extender {
        @NonNull
        Builder extend(@NonNull Builder builder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static abstract class Style {

        /* renamed from: a */
        CharSequence f2129a;

        /* renamed from: b */
        CharSequence f2130b;

        /* renamed from: c */
        boolean f2131c = false;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected Builder mBuilder;

        /* renamed from: a */
        private int m1396a() {
            Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0401R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C0401R.dimen.notification_top_pad_large_text);
            float b = (m1397b(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - b) * ((float) dimensionPixelSize)) + (b * ((float) dimensionPixelSize2)));
        }

        /* renamed from: b */
        private static float m1397b(float f, float f2, float f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }

        @Nullable
        /* renamed from: c */
        private static Style m1398c(@NonNull Bundle bundle) {
            String string = bundle.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
            if (string == null) {
                string = m1403i(bundle.getString(NotificationCompat.EXTRA_TEMPLATE));
            }
            if (string == null) {
                if (bundle.containsKey(NotificationCompat.EXTRA_PICTURE)) {
                    string = BigPictureStyle.class.getName();
                } else if (bundle.containsKey(NotificationCompat.EXTRA_BIG_TEXT)) {
                    string = BigTextStyle.class.getName();
                } else if (bundle.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                    string = MessagingStyle.class.getName();
                } else if (!bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                    return null;
                } else {
                    string = InboxStyle.class.getName();
                }
            }
            Class<? extends Style> h = m1402h(string);
            if (h == null) {
                return null;
            }
            try {
                Constructor<? extends Style> declaredConstructor = h.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                Style style = (Style) declaredConstructor.newInstance(new Object[0]);
                style.restoreFromCompatExtras(bundle);
                return style;
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: d */
        private Bitmap m1399d(int i, int i2, int i3) {
            return m1400f(IconCompat.createWithResource(this.mBuilder.mContext, i), i2, i3);
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Style extractStyleFromNotification(@NonNull Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            return m1398c(extras);
        }

        /* renamed from: f */
        private Bitmap m1400f(@NonNull IconCompat iconCompat, int i, int i2) {
            Drawable loadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
            int intrinsicWidth = i2 == 0 ? loadDrawable.getIntrinsicWidth() : i2;
            if (i2 == 0) {
                i2 = loadDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i2, Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, intrinsicWidth, i2);
            if (i != 0) {
                loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        /* renamed from: g */
        private Bitmap m1401g(int i, int i2, int i3, int i4) {
            int i5 = C0401R.C0402drawable.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap d = m1399d(i5, i4, i2);
            Canvas canvas = new Canvas(d);
            Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            int i6 = (i2 - i3) / 2;
            int i7 = i3 + i6;
            mutate.setBounds(i6, i6, i7, i7);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return d;
        }

        @Nullable
        /* renamed from: h */
        private static Class<? extends Style> m1402h(@NonNull String str) {
            Class[] clsArr = {BigTextStyle.class, BigPictureStyle.class, InboxStyle.class, DecoratedCustomViewStyle.class, MessagingStyle.class};
            for (int i = 0; i < 5; i++) {
                Class cls = clsArr[i];
                if (str.equals(cls.getName())) {
                    return cls;
                }
            }
            return null;
        }

        @Nullable
        /* renamed from: i */
        private static String m1403i(@Nullable String str) {
            int i;
            if (str != null && (i = Build.VERSION.SDK_INT) >= 16) {
                if (str.equals(Notification.BigPictureStyle.class.getName())) {
                    return BigPictureStyle.class.getName();
                }
                if (str.equals(Notification.BigTextStyle.class.getName())) {
                    return BigTextStyle.class.getName();
                }
                if (str.equals(Notification.InboxStyle.class.getName())) {
                    return InboxStyle.class.getName();
                }
                if (i >= 24) {
                    if (str.equals(Notification.MessagingStyle.class.getName())) {
                        return MessagingStyle.class.getName();
                    }
                    if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                        return DecoratedCustomViewStyle.class.getName();
                    }
                }
            }
            return null;
        }

        /* renamed from: j */
        private void m1404j(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(C0401R.C0403id.title, 8);
            remoteViews.setViewVisibility(C0401R.C0403id.text2, 8);
            remoteViews.setViewVisibility(C0401R.C0403id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
            if (this.f2131c) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.f2130b);
            }
            CharSequence charSequence = this.f2129a;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, getClass().getName());
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x0177  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0181  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x01af  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01f5  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01fa  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01fc  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0206  */
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews applyStandardTemplate(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                androidx.core.app.NotificationCompat$Builder r1 = r0.mBuilder
                android.content.Context r1 = r1.mContext
                android.content.res.Resources r1 = r1.getResources()
                android.widget.RemoteViews r8 = new android.widget.RemoteViews
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                android.content.Context r2 = r2.mContext
                java.lang.String r2 = r2.getPackageName()
                r3 = r18
                r8.<init>(r2, r3)
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                int r2 = r2.getPriority()
                r3 = -1
                r9 = 1
                r10 = 0
                if (r2 >= r3) goto L_0x0026
                r2 = 1
                goto L_0x0027
            L_0x0026:
                r2 = 0
            L_0x0027:
                int r11 = android.os.Build.VERSION.SDK_INT
                r4 = 21
                r12 = 16
                if (r11 < r12) goto L_0x0052
                if (r11 >= r4) goto L_0x0052
                java.lang.String r5 = "setBackgroundResource"
                if (r2 == 0) goto L_0x0044
                int r2 = androidx.core.C0401R.C0403id.notification_background
                int r6 = androidx.core.C0401R.C0402drawable.notification_bg_low
                r8.setInt(r2, r5, r6)
                int r2 = androidx.core.C0401R.C0403id.icon
                int r6 = androidx.core.C0401R.C0402drawable.notification_template_icon_low_bg
                r8.setInt(r2, r5, r6)
                goto L_0x0052
            L_0x0044:
                int r2 = androidx.core.C0401R.C0403id.notification_background
                int r6 = androidx.core.C0401R.C0402drawable.notification_bg
                r8.setInt(r2, r5, r6)
                int r2 = androidx.core.C0401R.C0403id.icon
                int r6 = androidx.core.C0401R.C0402drawable.notification_template_icon_bg
                r8.setInt(r2, r5, r6)
            L_0x0052:
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                android.graphics.Bitmap r5 = r2.f2082g
                r13 = 8
                if (r5 == 0) goto L_0x00b3
                if (r11 < r12) goto L_0x0069
                int r2 = androidx.core.C0401R.C0403id.icon
                r8.setViewVisibility(r2, r10)
                androidx.core.app.NotificationCompat$Builder r5 = r0.mBuilder
                android.graphics.Bitmap r5 = r5.f2082g
                r8.setImageViewBitmap(r2, r5)
                goto L_0x006e
            L_0x0069:
                int r2 = androidx.core.C0401R.C0403id.icon
                r8.setViewVisibility(r2, r13)
            L_0x006e:
                if (r17 == 0) goto L_0x00f4
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                android.app.Notification r2 = r2.f2073Q
                int r2 = r2.icon
                if (r2 == 0) goto L_0x00f4
                int r2 = androidx.core.C0401R.dimen.notification_right_icon_size
                int r2 = r1.getDimensionPixelSize(r2)
                int r5 = androidx.core.C0401R.dimen.notification_small_icon_background_padding
                int r5 = r1.getDimensionPixelSize(r5)
                int r5 = r5 * 2
                int r5 = r2 - r5
                if (r11 < r4) goto L_0x009e
                androidx.core.app.NotificationCompat$Builder r3 = r0.mBuilder
                android.app.Notification r6 = r3.f2073Q
                int r6 = r6.icon
                int r3 = r3.getColor()
                android.graphics.Bitmap r2 = r0.m1401g(r6, r2, r5, r3)
                int r3 = androidx.core.C0401R.C0403id.right_icon
                r8.setImageViewBitmap(r3, r2)
                goto L_0x00ad
            L_0x009e:
                int r2 = androidx.core.C0401R.C0403id.right_icon
                androidx.core.app.NotificationCompat$Builder r5 = r0.mBuilder
                android.app.Notification r5 = r5.f2073Q
                int r5 = r5.icon
                android.graphics.Bitmap r3 = r0.createColoredBitmap(r5, r3)
                r8.setImageViewBitmap(r2, r3)
            L_0x00ad:
                int r2 = androidx.core.C0401R.C0403id.right_icon
                r8.setViewVisibility(r2, r10)
                goto L_0x00f4
            L_0x00b3:
                if (r17 == 0) goto L_0x00f4
                android.app.Notification r2 = r2.f2073Q
                int r2 = r2.icon
                if (r2 == 0) goto L_0x00f4
                int r2 = androidx.core.C0401R.C0403id.icon
                r8.setViewVisibility(r2, r10)
                if (r11 < r4) goto L_0x00e7
                int r3 = androidx.core.C0401R.dimen.notification_large_icon_width
                int r3 = r1.getDimensionPixelSize(r3)
                int r5 = androidx.core.C0401R.dimen.notification_big_circle_margin
                int r5 = r1.getDimensionPixelSize(r5)
                int r3 = r3 - r5
                int r5 = androidx.core.C0401R.dimen.notification_small_icon_size_as_large
                int r5 = r1.getDimensionPixelSize(r5)
                androidx.core.app.NotificationCompat$Builder r6 = r0.mBuilder
                android.app.Notification r7 = r6.f2073Q
                int r7 = r7.icon
                int r6 = r6.getColor()
                android.graphics.Bitmap r3 = r0.m1401g(r7, r3, r5, r6)
                r8.setImageViewBitmap(r2, r3)
                goto L_0x00f4
            L_0x00e7:
                androidx.core.app.NotificationCompat$Builder r5 = r0.mBuilder
                android.app.Notification r5 = r5.f2073Q
                int r5 = r5.icon
                android.graphics.Bitmap r3 = r0.createColoredBitmap(r5, r3)
                r8.setImageViewBitmap(r2, r3)
            L_0x00f4:
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                java.lang.CharSequence r2 = r2.f2077b
                if (r2 == 0) goto L_0x00ff
                int r3 = androidx.core.C0401R.C0403id.title
                r8.setTextViewText(r3, r2)
            L_0x00ff:
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                java.lang.CharSequence r2 = r2.f2078c
                if (r2 == 0) goto L_0x010c
                int r3 = androidx.core.C0401R.C0403id.text
                r8.setTextViewText(r3, r2)
                r2 = 1
                goto L_0x010d
            L_0x010c:
                r2 = 0
            L_0x010d:
                if (r11 >= r4) goto L_0x0117
                androidx.core.app.NotificationCompat$Builder r3 = r0.mBuilder
                android.graphics.Bitmap r3 = r3.f2082g
                if (r3 == 0) goto L_0x0117
                r3 = 1
                goto L_0x0118
            L_0x0117:
                r3 = 0
            L_0x0118:
                androidx.core.app.NotificationCompat$Builder r4 = r0.mBuilder
                java.lang.CharSequence r5 = r4.f2083h
                if (r5 == 0) goto L_0x0129
                int r2 = androidx.core.C0401R.C0403id.info
                r8.setTextViewText(r2, r5)
                r8.setViewVisibility(r2, r10)
            L_0x0126:
                r14 = 1
                r15 = 1
                goto L_0x0164
            L_0x0129:
                int r4 = r4.f2084i
                if (r4 <= 0) goto L_0x015d
                int r2 = androidx.core.C0401R.integer.status_bar_notification_info_maxnum
                int r2 = r1.getInteger(r2)
                androidx.core.app.NotificationCompat$Builder r3 = r0.mBuilder
                int r3 = r3.f2084i
                if (r3 <= r2) goto L_0x0145
                int r2 = androidx.core.C0401R.C0403id.info
                int r3 = androidx.core.C0401R.string.status_bar_notification_info_overflow
                java.lang.String r3 = r1.getString(r3)
                r8.setTextViewText(r2, r3)
                goto L_0x0157
            L_0x0145:
                java.text.NumberFormat r2 = java.text.NumberFormat.getIntegerInstance()
                int r3 = androidx.core.C0401R.C0403id.info
                androidx.core.app.NotificationCompat$Builder r4 = r0.mBuilder
                int r4 = r4.f2084i
                long r4 = (long) r4
                java.lang.String r2 = r2.format(r4)
                r8.setTextViewText(r3, r2)
            L_0x0157:
                int r2 = androidx.core.C0401R.C0403id.info
                r8.setViewVisibility(r2, r10)
                goto L_0x0126
            L_0x015d:
                int r4 = androidx.core.C0401R.C0403id.info
                r8.setViewVisibility(r4, r13)
                r14 = r2
                r15 = r3
            L_0x0164:
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                java.lang.CharSequence r2 = r2.f2090o
                if (r2 == 0) goto L_0x0186
                if (r11 < r12) goto L_0x0186
                int r3 = androidx.core.C0401R.C0403id.text
                r8.setTextViewText(r3, r2)
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                java.lang.CharSequence r2 = r2.f2078c
                if (r2 == 0) goto L_0x0181
                int r3 = androidx.core.C0401R.C0403id.text2
                r8.setTextViewText(r3, r2)
                r8.setViewVisibility(r3, r10)
                r2 = 1
                goto L_0x0187
            L_0x0181:
                int r2 = androidx.core.C0401R.C0403id.text2
                r8.setViewVisibility(r2, r13)
            L_0x0186:
                r2 = 0
            L_0x0187:
                if (r2 == 0) goto L_0x01a3
                if (r11 < r12) goto L_0x01a3
                if (r19 == 0) goto L_0x0199
                int r2 = androidx.core.C0401R.dimen.notification_subtext_size
                int r1 = r1.getDimensionPixelSize(r2)
                float r1 = (float) r1
                int r2 = androidx.core.C0401R.C0403id.text
                r8.setTextViewTextSize(r2, r10, r1)
            L_0x0199:
                int r3 = androidx.core.C0401R.C0403id.line1
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r2 = r8
                r2.setViewPadding(r3, r4, r5, r6, r7)
            L_0x01a3:
                androidx.core.app.NotificationCompat$Builder r1 = r0.mBuilder
                long r1 = r1.getWhenIfShowing()
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x01f5
                androidx.core.app.NotificationCompat$Builder r1 = r0.mBuilder
                boolean r1 = r1.f2087l
                if (r1 == 0) goto L_0x01e4
                if (r11 < r12) goto L_0x01e4
                int r1 = androidx.core.C0401R.C0403id.chronometer
                r8.setViewVisibility(r1, r10)
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                long r2 = r2.getWhenIfShowing()
                long r4 = android.os.SystemClock.elapsedRealtime()
                long r6 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r6
                long r2 = r2 + r4
                java.lang.String r4 = "setBase"
                r8.setLong(r1, r4, r2)
                java.lang.String r2 = "setStarted"
                r8.setBoolean(r1, r2, r9)
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                boolean r2 = r2.f2088m
                if (r2 == 0) goto L_0x01f6
                r3 = 24
                if (r11 < r3) goto L_0x01f6
                r8.setChronometerCountDown(r1, r2)
                goto L_0x01f6
            L_0x01e4:
                int r1 = androidx.core.C0401R.C0403id.time
                r8.setViewVisibility(r1, r10)
                androidx.core.app.NotificationCompat$Builder r2 = r0.mBuilder
                long r2 = r2.getWhenIfShowing()
                java.lang.String r4 = "setTime"
                r8.setLong(r1, r4, r2)
                goto L_0x01f6
            L_0x01f5:
                r9 = r15
            L_0x01f6:
                int r1 = androidx.core.C0401R.C0403id.right_side
                if (r9 == 0) goto L_0x01fc
                r2 = 0
                goto L_0x01fe
            L_0x01fc:
                r2 = 8
            L_0x01fe:
                r8.setViewVisibility(r1, r2)
                int r1 = androidx.core.C0401R.C0403id.line3
                if (r14 == 0) goto L_0x0206
                goto L_0x0208
            L_0x0206:
                r10 = 8
            L_0x0208:
                r8.setViewVisibility(r1, r10)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        @Nullable
        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            m1404j(remoteViews);
            int i = C0401R.C0403id.notification_main_column;
            remoteViews.removeAllViews(i);
            remoteViews.addView(i, remoteViews2.clone());
            remoteViews.setViewVisibility(i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(C0401R.C0403id.notification_main_column_container, 0, m1396a(), 0, 0);
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            bundle.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            bundle.remove(NotificationCompat.EXTRA_TITLE_BIG);
            bundle.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int i, int i2) {
            return m1399d(i, i2, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Bitmap mo3872e(@NonNull IconCompat iconCompat, int i) {
            return m1400f(iconCompat, i, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            if (bundle.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT)) {
                this.f2130b = bundle.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
                this.f2131c = true;
            }
            this.f2129a = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@Nullable Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    public static final class WearableExtender implements Extender {
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;

        /* renamed from: a */
        private ArrayList<Action> f2132a = new ArrayList<>();

        /* renamed from: b */
        private int f2133b = 1;

        /* renamed from: c */
        private PendingIntent f2134c;

        /* renamed from: d */
        private ArrayList<Notification> f2135d = new ArrayList<>();

        /* renamed from: e */
        private Bitmap f2136e;

        /* renamed from: f */
        private int f2137f;

        /* renamed from: g */
        private int f2138g = GravityCompat.END;

        /* renamed from: h */
        private int f2139h = -1;

        /* renamed from: i */
        private int f2140i = 0;

        /* renamed from: j */
        private int f2141j;

        /* renamed from: k */
        private int f2142k = 80;

        /* renamed from: l */
        private int f2143l;

        /* renamed from: m */
        private String f2144m;

        /* renamed from: n */
        private String f2145n;

        public WearableExtender() {
        }

        @RequiresApi(20)
        /* renamed from: a */
        private static Notification.Action m1406a(Action action) {
            Notification.Action.Builder builder;
            Bundle bundle;
            Icon icon;
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                IconCompat iconCompat = action.getIconCompat();
                if (iconCompat == null) {
                    icon = null;
                } else {
                    icon = iconCompat.toIcon();
                }
                builder = new Notification.Action.Builder(icon, action.getTitle(), action.getActionIntent());
            } else {
                IconCompat iconCompat2 = action.getIconCompat();
                builder = new Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), action.getTitle(), action.getActionIntent());
            }
            if (action.getExtras() != null) {
                bundle = new Bundle(action.getExtras());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (i >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (RemoteInput addRemoteInput : RemoteInput.m1425b(remoteInputs)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            return builder.build();
        }

        /* renamed from: b */
        private void m1407b(int i, boolean z) {
            if (z) {
                this.f2133b = i | this.f2133b;
                return;
            }
            this.f2133b = (i ^ -1) & this.f2133b;
        }

        @NonNull
        public WearableExtender addAction(@NonNull Action action) {
            this.f2132a.add(action);
            return this;
        }

        @NonNull
        public WearableExtender addActions(@NonNull List<Action> list) {
            this.f2132a.addAll(list);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPage(@NonNull Notification notification) {
            this.f2135d.add(notification);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPages(@NonNull List<Notification> list) {
            this.f2135d.addAll(list);
            return this;
        }

        @NonNull
        public WearableExtender clearActions() {
            this.f2132a.clear();
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender clearPages() {
            this.f2135d.clear();
            return this;
        }

        @NonNull
        public Builder extend(@NonNull Builder builder) {
            int i = Build.VERSION.SDK_INT;
            Bundle bundle = new Bundle();
            if (!this.f2132a.isEmpty()) {
                if (i >= 16) {
                    ArrayList arrayList = new ArrayList(this.f2132a.size());
                    Iterator<Action> it = this.f2132a.iterator();
                    while (it.hasNext()) {
                        Action next = it.next();
                        if (i >= 20) {
                            arrayList.add(m1406a(next));
                        } else if (i >= 16) {
                            arrayList.add(C0436c.m1462j(next));
                        }
                    }
                    bundle.putParcelableArrayList("actions", arrayList);
                } else {
                    bundle.putParcelableArrayList("actions", (ArrayList) null);
                }
            }
            int i2 = this.f2133b;
            if (i2 != 1) {
                bundle.putInt("flags", i2);
            }
            PendingIntent pendingIntent = this.f2134c;
            if (pendingIntent != null) {
                bundle.putParcelable("displayIntent", pendingIntent);
            }
            if (!this.f2135d.isEmpty()) {
                ArrayList<Notification> arrayList2 = this.f2135d;
                bundle.putParcelableArray("pages", (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
            }
            Bitmap bitmap = this.f2136e;
            if (bitmap != null) {
                bundle.putParcelable("background", bitmap);
            }
            int i3 = this.f2137f;
            if (i3 != 0) {
                bundle.putInt("contentIcon", i3);
            }
            int i4 = this.f2138g;
            if (i4 != 8388613) {
                bundle.putInt("contentIconGravity", i4);
            }
            int i5 = this.f2139h;
            if (i5 != -1) {
                bundle.putInt("contentActionIndex", i5);
            }
            int i6 = this.f2140i;
            if (i6 != 0) {
                bundle.putInt("customSizePreset", i6);
            }
            int i7 = this.f2141j;
            if (i7 != 0) {
                bundle.putInt("customContentHeight", i7);
            }
            int i8 = this.f2142k;
            if (i8 != 80) {
                bundle.putInt("gravity", i8);
            }
            int i9 = this.f2143l;
            if (i9 != 0) {
                bundle.putInt("hintScreenTimeout", i9);
            }
            String str = this.f2144m;
            if (str != null) {
                bundle.putString("dismissalId", str);
            }
            String str2 = this.f2145n;
            if (str2 != null) {
                bundle.putString("bridgeTag", str2);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        @NonNull
        public List<Action> getActions() {
            return this.f2132a;
        }

        @Deprecated
        @Nullable
        public Bitmap getBackground() {
            return this.f2136e;
        }

        @Nullable
        public String getBridgeTag() {
            return this.f2145n;
        }

        public int getContentAction() {
            return this.f2139h;
        }

        @Deprecated
        public int getContentIcon() {
            return this.f2137f;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.f2138g;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.f2133b & 1) != 0;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.f2141j;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.f2140i;
        }

        @Nullable
        public String getDismissalId() {
            return this.f2144m;
        }

        @Deprecated
        @Nullable
        public PendingIntent getDisplayIntent() {
            return this.f2134c;
        }

        @Deprecated
        public int getGravity() {
            return this.f2142k;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            return (this.f2133b & 32) != 0;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.f2133b & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.f2133b & 64) != 0;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            return (this.f2133b & 2) != 0;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.f2143l;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.f2133b & 4) != 0;
        }

        @NonNull
        @Deprecated
        public List<Notification> getPages() {
            return this.f2135d;
        }

        public boolean getStartScrollBottom() {
            return (this.f2133b & 8) != 0;
        }

        @NonNull
        @Deprecated
        public WearableExtender setBackground(@Nullable Bitmap bitmap) {
            this.f2136e = bitmap;
            return this;
        }

        @NonNull
        public WearableExtender setBridgeTag(@Nullable String str) {
            this.f2145n = str;
            return this;
        }

        @NonNull
        public WearableExtender setContentAction(int i) {
            this.f2139h = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIcon(int i) {
            this.f2137f = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIconGravity(int i) {
            this.f2138g = i;
            return this;
        }

        @NonNull
        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            m1407b(1, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomContentHeight(int i) {
            this.f2141j = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomSizePreset(int i) {
            this.f2140i = i;
            return this;
        }

        @NonNull
        public WearableExtender setDismissalId(@Nullable String str) {
            this.f2144m = str;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setDisplayIntent(@Nullable PendingIntent pendingIntent) {
            this.f2134c = pendingIntent;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setGravity(int i) {
            this.f2142k = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z) {
            m1407b(32, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            m1407b(16, z);
            return this;
        }

        @NonNull
        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            m1407b(64, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            m1407b(2, z);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintScreenTimeout(int i) {
            this.f2143l = i;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            m1407b(4, z);
            return this;
        }

        @NonNull
        public WearableExtender setStartScrollBottom(boolean z) {
            m1407b(8, z);
            return this;
        }

        @NonNull
        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f2132a = new ArrayList<>(this.f2132a);
            wearableExtender.f2133b = this.f2133b;
            wearableExtender.f2134c = this.f2134c;
            wearableExtender.f2135d = new ArrayList<>(this.f2135d);
            wearableExtender.f2136e = this.f2136e;
            wearableExtender.f2137f = this.f2137f;
            wearableExtender.f2138g = this.f2138g;
            wearableExtender.f2139h = this.f2139h;
            wearableExtender.f2140i = this.f2140i;
            wearableExtender.f2141j = this.f2141j;
            wearableExtender.f2142k = this.f2142k;
            wearableExtender.f2143l = this.f2143l;
            wearableExtender.f2144m = this.f2144m;
            wearableExtender.f2145n = this.f2145n;
            return wearableExtender;
        }

        public WearableExtender(@NonNull Notification notification) {
            int i = Build.VERSION.SDK_INT;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (i >= 16 && parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i >= 20) {
                            actionArr[i2] = NotificationCompat.m1372a((Notification.Action) parcelableArrayList.get(i2));
                        } else if (i >= 16) {
                            actionArr[i2] = C0436c.m1459g((Bundle) parcelableArrayList.get(i2));
                        }
                    }
                    Collections.addAll(this.f2132a, actionArr);
                }
                this.f2133b = bundle.getInt("flags", 1);
                this.f2134c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] c = NotificationCompat.m1374c(bundle, "pages");
                if (c != null) {
                    Collections.addAll(this.f2135d, c);
                }
                this.f2136e = (Bitmap) bundle.getParcelable("background");
                this.f2137f = bundle.getInt("contentIcon");
                this.f2138g = bundle.getInt("contentIconGravity", GravityCompat.END);
                this.f2139h = bundle.getInt("contentActionIndex", -1);
                this.f2140i = bundle.getInt("customSizePreset", 0);
                this.f2141j = bundle.getInt("customContentHeight");
                this.f2142k = bundle.getInt("gravity", 80);
                this.f2143l = bundle.getInt("hintScreenTimeout");
                this.f2144m = bundle.getString("dismissalId");
                this.f2145n = bundle.getString("bridgeTag");
            }
        }
    }

    @RequiresApi(20)
    @NonNull
    /* renamed from: a */
    static Action m1372a(@NonNull Notification.Action action) {
        RemoteInput[] remoteInputArr;
        boolean z;
        int i;
        int i2;
        Notification.Action action2 = action;
        int i3 = Build.VERSION.SDK_INT;
        RemoteInput[] remoteInputs = action.getRemoteInputs();
        IconCompat iconCompat = null;
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i4 = 0; i4 < remoteInputs.length; i4++) {
                RemoteInput remoteInput = remoteInputs[i4];
                remoteInputArr2[i4] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), i3 >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), (Set<String>) null);
            }
            remoteInputArr = remoteInputArr2;
        }
        if (i3 >= 24) {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies();
        } else {
            z = action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        }
        boolean z2 = z;
        boolean z3 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        if (i3 >= 28) {
            i = action.getSemanticAction();
        } else {
            i = action.getExtras().getInt("android.support.action.semanticAction", 0);
        }
        int i5 = i;
        boolean isContextual = i3 >= 29 ? action.isContextual() : false;
        if (i3 < 23) {
            return new Action(action2.icon, action2.title, action2.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z2, i5, z3, isContextual);
        }
        if (action.getIcon() == null && (i2 = action2.icon) != 0) {
            return new Action(i2, action2.title, action2.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z2, i5, z3, isContextual);
        }
        if (action.getIcon() != null) {
            iconCompat = IconCompat.createFromIconOrNullIfZeroResId(action.getIcon());
        }
        return new Action(iconCompat, action2.title, action2.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z2, i5, z3, isContextual);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: b */
    static boolean m1373b(@NonNull Notification notification) {
        return (notification.flags & 128) != 0;
    }

    @NonNull
    /* renamed from: c */
    static Notification[] m1374c(@NonNull Bundle bundle, @NonNull String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            notificationArr[i] = (Notification) parcelableArray[i];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.os.Bundle} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.app.NotificationCompat.Action getAction(@androidx.annotation.NonNull android.app.Notification r3, int r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 20
            if (r0 < r1) goto L_0x000f
            android.app.Notification$Action[] r3 = r3.actions
            r3 = r3[r4]
            androidx.core.app.NotificationCompat$Action r3 = m1372a(r3)
            return r3
        L_0x000f:
            r1 = 19
            r2 = 0
            if (r0 < r1) goto L_0x0034
            android.app.Notification$Action[] r0 = r3.actions
            r0 = r0[r4]
            android.os.Bundle r3 = r3.extras
            java.lang.String r1 = "android.support.actionExtras"
            android.util.SparseArray r3 = r3.getSparseParcelableArray(r1)
            if (r3 == 0) goto L_0x0029
            java.lang.Object r3 = r3.get(r4)
            r2 = r3
            android.os.Bundle r2 = (android.os.Bundle) r2
        L_0x0029:
            int r3 = r0.icon
            java.lang.CharSequence r4 = r0.title
            android.app.PendingIntent r0 = r0.actionIntent
            androidx.core.app.NotificationCompat$Action r3 = androidx.core.app.C0436c.m1464l(r3, r4, r0, r2)
            return r3
        L_0x0034:
            r1 = 16
            if (r0 < r1) goto L_0x003d
            androidx.core.app.NotificationCompat$Action r3 = androidx.core.app.C0436c.m1457e(r3, r4)
            return r3
        L_0x003d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.getAction(android.app.Notification, int):androidx.core.app.NotificationCompat$Action");
    }

    public static int getActionCount(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            Notification.Action[] actionArr = notification.actions;
            if (actionArr != null) {
                return actionArr.length;
            }
            return 0;
        } else if (i >= 16) {
            return C0436c.m1458f(notification);
        } else {
            return 0;
        }
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return notification.getAllowSystemGeneratedContextualActions();
        }
        return false;
    }

    public static boolean getAutoCancel(@NonNull Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int getBadgeIconType(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(notification.getBubbleMetadata());
        }
        return null;
    }

    @Nullable
    public static String getCategory(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static int getColor(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.color;
        }
        return 0;
    }

    @RequiresApi(19)
    @Nullable
    public static CharSequence getContentInfo(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @RequiresApi(19)
    @Nullable
    public static CharSequence getContentText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    @RequiresApi(19)
    @Nullable
    public static CharSequence getContentTitle(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return C0436c.m1463k(notification);
        }
        return null;
    }

    @Nullable
    public static String getGroup(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return notification.getGroup();
        }
        if (i >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        if (i >= 16) {
            return C0436c.m1463k(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        return null;
    }

    public static int getGroupAlertBehavior(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    @RequiresApi(21)
    @NonNull
    public static List<Action> getInvisibleActions(@NonNull Notification notification) {
        Bundle bundle;
        Bundle bundle2;
        ArrayList arrayList = new ArrayList();
        if (!(Build.VERSION.SDK_INT < 19 || (bundle = notification.extras.getBundle("android.car.EXTENSIONS")) == null || (bundle2 = bundle.getBundle("invisible_actions")) == null)) {
            for (int i = 0; i < bundle2.size(); i++) {
                arrayList.add(C0436c.m1459g(bundle2.getBundle(Integer.toString(i))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            if ((notification.flags & 256) != 0) {
                return true;
            }
            return false;
        } else if (i >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        } else {
            if (i >= 16) {
                return C0436c.m1463k(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            }
            return false;
        }
    }

    @Nullable
    public static LocusIdCompat getLocusId(@NonNull Notification notification) {
        LocusId locusId;
        if (Build.VERSION.SDK_INT < 29 || (locusId = notification.getLocusId()) == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(locusId);
    }

    public static boolean getOngoing(@NonNull Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification notification) {
        return (notification.flags & 8) != 0;
    }

    @NonNull
    public static List<Person> getPeople(@NonNull Notification notification) {
        String[] stringArray;
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Person.fromAndroidPerson((Person) it.next()));
                }
            }
        } else if (!(i < 19 || (stringArray = notification.extras.getStringArray(EXTRA_PEOPLE)) == null || stringArray.length == 0)) {
            for (String uri : stringArray) {
                arrayList.add(new Person.Builder().setUri(uri).build());
            }
        }
        return arrayList;
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.publicVersion;
        }
        return null;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getSettingsText();
        }
        return null;
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    @RequiresApi(19)
    public static boolean getShowWhen(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return notification.getSortKey();
        }
        if (i >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        if (i >= 16) {
            return C0436c.m1463k(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        return null;
    }

    @RequiresApi(19)
    @Nullable
    public static CharSequence getSubText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0;
    }

    @RequiresApi(19)
    public static boolean getUsesChronometer(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.visibility;
        }
        return 0;
    }

    public static boolean isGroupSummary(@NonNull Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            if ((notification.flags & 512) != 0) {
                return true;
            }
            return false;
        } else if (i >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        } else {
            if (i >= 16) {
                return C0436c.m1463k(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            }
            return false;
        }
    }

    public static final class CarExtender implements Extender {

        /* renamed from: a */
        private Bitmap f2102a;

        /* renamed from: b */
        private UnreadConversation f2103b;

        /* renamed from: c */
        private int f2104c = 0;

        @Deprecated
        public static class UnreadConversation {

            /* renamed from: a */
            private final String[] f2105a;

            /* renamed from: b */
            private final RemoteInput f2106b;

            /* renamed from: c */
            private final PendingIntent f2107c;

            /* renamed from: d */
            private final PendingIntent f2108d;

            /* renamed from: e */
            private final String[] f2109e;

            /* renamed from: f */
            private final long f2110f;

            public static class Builder {

                /* renamed from: a */
                private final List<String> f2111a = new ArrayList();

                /* renamed from: b */
                private final String f2112b;

                /* renamed from: c */
                private RemoteInput f2113c;

                /* renamed from: d */
                private PendingIntent f2114d;

                /* renamed from: e */
                private PendingIntent f2115e;

                /* renamed from: f */
                private long f2116f;

                public Builder(@NonNull String str) {
                    this.f2112b = str;
                }

                @NonNull
                public Builder addMessage(@Nullable String str) {
                    if (str != null) {
                        this.f2111a.add(str);
                    }
                    return this;
                }

                @NonNull
                public UnreadConversation build() {
                    List<String> list = this.f2111a;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.f2113c, this.f2115e, this.f2114d, new String[]{this.f2112b}, this.f2116f);
                }

                @NonNull
                public Builder setLatestTimestamp(long j) {
                    this.f2116f = j;
                    return this;
                }

                @NonNull
                public Builder setReadPendingIntent(@Nullable PendingIntent pendingIntent) {
                    this.f2114d = pendingIntent;
                    return this;
                }

                @NonNull
                public Builder setReplyAction(@Nullable PendingIntent pendingIntent, @Nullable RemoteInput remoteInput) {
                    this.f2113c = remoteInput;
                    this.f2115e = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(@Nullable String[] strArr, @Nullable RemoteInput remoteInput, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable String[] strArr2, long j) {
                this.f2105a = strArr;
                this.f2106b = remoteInput;
                this.f2108d = pendingIntent2;
                this.f2107c = pendingIntent;
                this.f2109e = strArr2;
                this.f2110f = j;
            }

            public long getLatestTimestamp() {
                return this.f2110f;
            }

            @Nullable
            public String[] getMessages() {
                return this.f2105a;
            }

            @Nullable
            public String getParticipant() {
                String[] strArr = this.f2109e;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @Nullable
            public String[] getParticipants() {
                return this.f2109e;
            }

            @Nullable
            public PendingIntent getReadPendingIntent() {
                return this.f2108d;
            }

            @Nullable
            public RemoteInput getRemoteInput() {
                return this.f2106b;
            }

            @Nullable
            public PendingIntent getReplyPendingIntent() {
                return this.f2107c;
            }
        }

        public CarExtender() {
        }

        @RequiresApi(21)
        /* renamed from: a */
        private static Bundle m1382a(@NonNull UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            int length = unreadConversation.getMessages().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i = 0; i < length; i++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i]);
                bundle2.putString("author", str);
                parcelableArr[i] = bundle2;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable("remote_input", new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
            bundle.putParcelable("on_read", unreadConversation.getReadPendingIntent());
            bundle.putStringArray("participants", unreadConversation.getParticipants());
            bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
            return bundle;
        }

        @RequiresApi(21)
        /* renamed from: b */
        private static UnreadConversation m1383b(@Nullable Bundle bundle) {
            String[] strArr;
            boolean z;
            Bundle bundle2 = bundle;
            RemoteInput remoteInput = null;
            if (bundle2 == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle2.getParcelableArray("messages");
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                String[] strArr2 = new String[length];
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (!(parcelableArray[i] instanceof Bundle)) {
                        break;
                    } else {
                        strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                        if (strArr2[i] == null) {
                            break;
                        }
                        i++;
                    }
                }
                z = false;
                if (!z) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable("on_read");
            PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable("on_reply");
            RemoteInput remoteInput2 = (RemoteInput) bundle2.getParcelable("remote_input");
            String[] stringArray = bundle2.getStringArray("participants");
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            if (remoteInput2 != null) {
                remoteInput = new RemoteInput(remoteInput2.getResultKey(), remoteInput2.getLabel(), remoteInput2.getChoices(), remoteInput2.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput2.getEditChoicesBeforeSending() : 0, remoteInput2.getExtras(), (Set<String>) null);
            }
            return new UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle2.getLong("timestamp"));
        }

        @NonNull
        public Builder extend(@NonNull Builder builder) {
            if (Build.VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.f2102a;
            if (bitmap != null) {
                bundle.putParcelable("large_icon", bitmap);
            }
            int i = this.f2104c;
            if (i != 0) {
                bundle.putInt("app_color", i);
            }
            UnreadConversation unreadConversation = this.f2103b;
            if (unreadConversation != null) {
                bundle.putBundle("car_conversation", m1382a(unreadConversation));
            }
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            return builder;
        }

        @ColorInt
        public int getColor() {
            return this.f2104c;
        }

        @Nullable
        public Bitmap getLargeIcon() {
            return this.f2102a;
        }

        @Deprecated
        @Nullable
        public UnreadConversation getUnreadConversation() {
            return this.f2103b;
        }

        @NonNull
        public CarExtender setColor(@ColorInt int i) {
            this.f2104c = i;
            return this;
        }

        @NonNull
        public CarExtender setLargeIcon(@Nullable Bitmap bitmap) {
            this.f2102a = bitmap;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender setUnreadConversation(@Nullable UnreadConversation unreadConversation) {
            this.f2103b = unreadConversation;
            return this;
        }

        public CarExtender(@NonNull Notification notification) {
            Bundle bundle;
            if (Build.VERSION.SDK_INT >= 21) {
                if (NotificationCompat.getExtras(notification) == null) {
                    bundle = null;
                } else {
                    bundle = NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
                }
                if (bundle != null) {
                    this.f2102a = (Bitmap) bundle.getParcelable("large_icon");
                    this.f2104c = bundle.getInt("app_color", 0);
                    this.f2103b = m1383b(bundle.getBundle("car_conversation"));
                }
            }
        }
    }

    public static class InboxStyle extends Style {

        /* renamed from: d */
        private ArrayList<CharSequence> f2117d = new ArrayList<>();

        public InboxStyle() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES, (CharSequence[]) this.f2117d.toArray(new CharSequence[this.f2117d.size()]));
        }

        @NonNull
        public InboxStyle addLine(@Nullable CharSequence charSequence) {
            if (charSequence != null) {
                this.f2117d.add(Builder.limitCharSequenceLength(charSequence));
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.f2129a);
                if (this.f2131c) {
                    bigContentTitle.setSummaryText(this.f2130b);
                }
                Iterator<CharSequence> it = this.f2117d.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.f2117d.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                Collections.addAll(this.f2117d, bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            }
        }

        @NonNull
        public InboxStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.f2129a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public InboxStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.f2130b = Builder.limitCharSequenceLength(charSequence);
            this.f2131c = true;
            return this;
        }

        public InboxStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;

        /* renamed from: d */
        private final List<Message> f2118d = new ArrayList();

        /* renamed from: e */
        private final List<Message> f2119e = new ArrayList();

        /* renamed from: f */
        private Person f2120f;
        @Nullable

        /* renamed from: g */
        private CharSequence f2121g;
        @Nullable

        /* renamed from: h */
        private Boolean f2122h;

        private MessagingStyle() {
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(@NonNull Notification notification) {
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            if (extractStyleFromNotification instanceof MessagingStyle) {
                return (MessagingStyle) extractStyleFromNotification;
            }
            return null;
        }

        @Nullable
        /* renamed from: k */
        private Message m1387k() {
            for (int size = this.f2118d.size() - 1; size >= 0; size--) {
                Message message = this.f2118d.get(size);
                if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
            }
            if (this.f2118d.isEmpty()) {
                return null;
            }
            List<Message> list = this.f2118d;
            return list.get(list.size() - 1);
        }

        /* renamed from: l */
        private boolean m1388l() {
            for (int size = this.f2118d.size() - 1; size >= 0; size--) {
                Message message = this.f2118d.get(size);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        /* renamed from: m */
        private TextAppearanceSpan m1389m(int i) {
            return new TextAppearanceSpan((String) null, 0, 0, ColorStateList.valueOf(i), (ColorStateList) null);
        }

        /* renamed from: n */
        private CharSequence m1390n(@NonNull Message message) {
            BidiFormatter instance = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = Build.VERSION.SDK_INT >= 21;
            int i = z ? ViewCompat.MEASURED_STATE_MASK : -1;
            CharSequence charSequence = "";
            CharSequence name = message.getPerson() == null ? charSequence : message.getPerson().getName();
            if (TextUtils.isEmpty(name)) {
                name = this.f2120f.getName();
                if (z && this.mBuilder.getColor() != 0) {
                    i = this.mBuilder.getColor();
                }
            }
            CharSequence unicodeWrap = instance.unicodeWrap(name);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(m1389m(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            if (message.getText() != null) {
                charSequence = message.getText();
            }
            spannableStringBuilder.append("  ").append(instance.unicodeWrap(charSequence));
            return spannableStringBuilder;
        }

        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.f2120f.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.f2120f.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.f2121g);
            if (this.f2121g != null && this.f2122h.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.f2121g);
            }
            if (!this.f2118d.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.m1391a(this.f2118d));
            }
            if (!this.f2119e.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.m1391a(this.f2119e));
            }
            Boolean bool = this.f2122h;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @NonNull
        public MessagingStyle addHistoricMessage(@Nullable Message message) {
            if (message != null) {
                this.f2119e.add(message);
                if (this.f2119e.size() > 25) {
                    this.f2119e.remove(0);
                }
            }
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle addMessage(@Nullable CharSequence charSequence, long j, @Nullable CharSequence charSequence2) {
            this.f2118d.add(new Message(charSequence, j, new Person.Builder().setName(charSequence2).build()));
            if (this.f2118d.size() > 25) {
                this.f2118d.remove(0);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence charSequence;
            Notification.MessagingStyle messagingStyle;
            int i = Build.VERSION.SDK_INT;
            setGroupConversation(isGroupConversation());
            if (i >= 24) {
                if (i >= 28) {
                    messagingStyle = new Notification.MessagingStyle(this.f2120f.toAndroidPerson());
                } else {
                    messagingStyle = new Notification.MessagingStyle(this.f2120f.getName());
                }
                for (Message d : this.f2118d) {
                    messagingStyle.addMessage(d.mo3859d());
                }
                if (i >= 26) {
                    for (Message d2 : this.f2119e) {
                        messagingStyle.addHistoricMessage(d2.mo3859d());
                    }
                }
                if (this.f2122h.booleanValue() || i >= 28) {
                    messagingStyle.setConversationTitle(this.f2121g);
                }
                if (i >= 28) {
                    messagingStyle.setGroupConversation(this.f2122h.booleanValue());
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            Message k = m1387k();
            if (this.f2121g != null && this.f2122h.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.f2121g);
            } else if (k != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                if (k.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(k.getPerson().getName());
                }
            }
            if (k != null) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                if (this.f2121g != null) {
                    charSequence = m1390n(k);
                } else {
                    charSequence = k.getText();
                }
                builder.setContentText(charSequence);
            }
            if (i >= 16) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z = this.f2121g != null || m1388l();
                for (int size = this.f2118d.size() - 1; size >= 0; size--) {
                    Message message = this.f2118d.get(size);
                    CharSequence n = z ? m1390n(message) : message.getText();
                    if (size != this.f2118d.size() - 1) {
                        spannableStringBuilder.insert(0, "\n");
                    }
                    spannableStringBuilder.insert(0, n);
                }
                new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle((CharSequence) null).bigText(spannableStringBuilder);
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            bundle.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            bundle.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.f2121g;
        }

        @NonNull
        public List<Message> getHistoricMessages() {
            return this.f2119e;
        }

        @NonNull
        public List<Message> getMessages() {
            return this.f2118d;
        }

        @NonNull
        public Person getUser() {
            return this.f2120f;
        }

        @Deprecated
        @Nullable
        public CharSequence getUserDisplayName() {
            return this.f2120f.getName();
        }

        public boolean isGroupConversation() {
            Builder builder = this.mBuilder;
            if (builder == null || builder.mContext.getApplicationInfo().targetSdkVersion >= 28 || this.f2122h != null) {
                Boolean bool = this.f2122h;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } else if (this.f2121g != null) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.f2118d.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.f2120f = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.f2120f = new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.f2121g = charSequence;
            if (charSequence == null) {
                this.f2121g = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.f2118d.addAll(Message.m1393c(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (parcelableArray2 != null) {
                this.f2119e.addAll(Message.m1393c(parcelableArray2));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.f2122h = Boolean.valueOf(bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        @NonNull
        public MessagingStyle setConversationTitle(@Nullable CharSequence charSequence) {
            this.f2121g = charSequence;
            return this;
        }

        @NonNull
        public MessagingStyle setGroupConversation(boolean z) {
            this.f2122h = Boolean.valueOf(z);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.f2120f = new Person.Builder().setName(charSequence).build();
        }

        public static final class Message {

            /* renamed from: a */
            private final CharSequence f2123a;

            /* renamed from: b */
            private final long f2124b;
            @Nullable

            /* renamed from: c */
            private final Person f2125c;

            /* renamed from: d */
            private Bundle f2126d;
            @Nullable

            /* renamed from: e */
            private String f2127e;
            @Nullable

            /* renamed from: f */
            private Uri f2128f;

            public Message(@Nullable CharSequence charSequence, long j, @Nullable Person person) {
                this.f2126d = new Bundle();
                this.f2123a = charSequence;
                this.f2124b = j;
                this.f2125c = person;
            }

            @NonNull
            /* renamed from: a */
            static Bundle[] m1391a(@NonNull List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = list.get(i).m1394e();
                }
                return bundleArr;
            }

            @Nullable
            /* renamed from: b */
            static Message m1392b(@NonNull Bundle bundle) {
                Person person;
                try {
                    if (bundle.containsKey("text")) {
                        if (bundle.containsKey("time")) {
                            if (bundle.containsKey("person")) {
                                person = Person.fromBundle(bundle.getBundle("person"));
                            } else if (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) {
                                person = bundle.containsKey("sender") ? new Person.Builder().setName(bundle.getCharSequence("sender")).build() : null;
                            } else {
                                person = Person.fromAndroidPerson((android.app.Person) bundle.getParcelable("sender_person"));
                            }
                            Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), person);
                            if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                                message.setData(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                            }
                            if (bundle.containsKey("extras")) {
                                message.getExtras().putAll(bundle.getBundle("extras"));
                            }
                            return message;
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @NonNull
            /* renamed from: c */
            static List<Message> m1393c(@NonNull Parcelable[] parcelableArr) {
                Message b;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (int i = 0; i < parcelableArr.length; i++) {
                    if ((parcelableArr[i] instanceof Bundle) && (b = m1392b(parcelableArr[i])) != null) {
                        arrayList.add(b);
                    }
                }
                return arrayList;
            }

            @NonNull
            /* renamed from: e */
            private Bundle m1394e() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f2123a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f2124b);
                Person person = this.f2125c;
                if (person != null) {
                    bundle.putCharSequence("sender", person.getName());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", this.f2125c.toAndroidPerson());
                    } else {
                        bundle.putBundle("person", this.f2125c.toBundle());
                    }
                }
                String str = this.f2127e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f2128f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f2126d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.app.Person} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.CharSequence] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* access modifiers changed from: package-private */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.annotation.RequiresApi(24)
            @androidx.annotation.NonNull
            @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.app.Notification.MessagingStyle.Message mo3859d() {
                /*
                    r6 = this;
                    androidx.core.app.Person r0 = r6.getPerson()
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 0
                    r3 = 28
                    if (r1 < r3) goto L_0x0020
                    android.app.Notification$MessagingStyle$Message r1 = new android.app.Notification$MessagingStyle$Message
                    java.lang.CharSequence r3 = r6.getText()
                    long r4 = r6.getTimestamp()
                    if (r0 != 0) goto L_0x0018
                    goto L_0x001c
                L_0x0018:
                    android.app.Person r2 = r0.toAndroidPerson()
                L_0x001c:
                    r1.<init>(r3, r4, r2)
                    goto L_0x0034
                L_0x0020:
                    android.app.Notification$MessagingStyle$Message r1 = new android.app.Notification$MessagingStyle$Message
                    java.lang.CharSequence r3 = r6.getText()
                    long r4 = r6.getTimestamp()
                    if (r0 != 0) goto L_0x002d
                    goto L_0x0031
                L_0x002d:
                    java.lang.CharSequence r2 = r0.getName()
                L_0x0031:
                    r1.<init>(r3, r4, r2)
                L_0x0034:
                    java.lang.String r0 = r6.getDataMimeType()
                    if (r0 == 0) goto L_0x0045
                    java.lang.String r0 = r6.getDataMimeType()
                    android.net.Uri r2 = r6.getDataUri()
                    r1.setData(r0, r2)
                L_0x0045:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.Message.mo3859d():android.app.Notification$MessagingStyle$Message");
            }

            @Nullable
            public String getDataMimeType() {
                return this.f2127e;
            }

            @Nullable
            public Uri getDataUri() {
                return this.f2128f;
            }

            @NonNull
            public Bundle getExtras() {
                return this.f2126d;
            }

            @Nullable
            public Person getPerson() {
                return this.f2125c;
            }

            @Deprecated
            @Nullable
            public CharSequence getSender() {
                Person person = this.f2125c;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            @NonNull
            public CharSequence getText() {
                return this.f2123a;
            }

            public long getTimestamp() {
                return this.f2124b;
            }

            @NonNull
            public Message setData(@Nullable String str, @Nullable Uri uri) {
                this.f2127e = str;
                this.f2128f = uri;
                return this;
            }

            @Deprecated
            public Message(@Nullable CharSequence charSequence, long j, @Nullable CharSequence charSequence2) {
                this(charSequence, j, new Person.Builder().setName(charSequence2).build());
            }
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable CharSequence charSequence, long j, @Nullable Person person) {
            addMessage(new Message(charSequence, j, person));
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable Message message) {
            if (message != null) {
                this.f2118d.add(message);
                if (this.f2118d.size() > 25) {
                    this.f2118d.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.getName())) {
                this.f2120f = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }
}
