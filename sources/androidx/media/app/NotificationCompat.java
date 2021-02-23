package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.C0835R;

public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        /* renamed from: q */
        private void m2765q(RemoteViews remoteViews) {
            int i;
            if (this.mBuilder.getColor() != 0) {
                i = this.mBuilder.getColor();
            } else {
                i = this.mBuilder.mContext.getResources().getColor(C0835R.color.notification_material_background_media_default_color);
            }
            remoteViews.setInt(C0835R.C0837id.status_bar_latest_event_content, "setBackgroundColor", i);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                Notification.DecoratedMediaCustomViewStyle decoratedMediaCustomViewStyle = new Notification.DecoratedMediaCustomViewStyle();
                mo6561k(decoratedMediaCustomViewStyle);
                builder.setStyle(decoratedMediaCustomViewStyle);
                return;
            }
            super.apply(notificationBuilderWithBuilderAccessor);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return null;
            }
            if (this.mBuilder.getBigContentView() != null) {
                remoteViews = this.mBuilder.getBigContentView();
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (remoteViews == null) {
                return null;
            }
            RemoteViews l = mo6562l();
            buildIntoRemoteViews(l, remoteViews);
            if (i >= 21) {
                m2765q(l);
            }
            return l;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return null;
            }
            boolean z = true;
            boolean z2 = this.mBuilder.getContentView() != null;
            if (i >= 21) {
                if (!z2 && this.mBuilder.getBigContentView() == null) {
                    z = false;
                }
                if (z) {
                    RemoteViews m = mo6563m();
                    if (z2) {
                        buildIntoRemoteViews(m, this.mBuilder.getContentView());
                    }
                    m2765q(m);
                    return m;
                }
            } else {
                RemoteViews m2 = mo6563m();
                if (z2) {
                    buildIntoRemoteViews(m2, this.mBuilder.getContentView());
                    return m2;
                }
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return null;
            }
            if (this.mBuilder.getHeadsUpContentView() != null) {
                remoteViews = this.mBuilder.getHeadsUpContentView();
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (remoteViews == null) {
                return null;
            }
            RemoteViews l = mo6562l();
            buildIntoRemoteViews(l, remoteViews);
            if (i >= 21) {
                m2765q(l);
            }
            return l;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public int mo6559o(int i) {
            return i <= 3 ? C0835R.layout.notification_template_big_media_narrow_custom : C0835R.layout.notification_template_big_media_custom;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public int mo6560p() {
            if (this.mBuilder.getContentView() != null) {
                return C0835R.layout.notification_template_media_custom;
            }
            return super.mo6560p();
        }
    }

    private NotificationCompat() {
    }

    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: d */
        int[] f3764d = null;

        /* renamed from: e */
        MediaSessionCompat.Token f3765e;

        /* renamed from: f */
        boolean f3766f;

        /* renamed from: g */
        PendingIntent f3767g;

        public MediaStyle() {
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return MediaSessionCompat.Token.fromToken(parcelable);
                }
                return null;
            }
            IBinder binder = BundleCompat.getBinder(extras, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (binder == null) {
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.writeStrongBinder(binder);
            obtain.setDataPosition(0);
            MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        }

        /* renamed from: n */
        private RemoteViews m2768n(NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), C0835R.layout.notification_media_action);
            int i = C0835R.C0837id.action0;
            remoteViews.setImageViewResource(i, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(i, action.getActionIntent());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(i, action.getTitle());
            }
            return remoteViews;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
                mo6561k(mediaStyle);
                builder.setStyle(mediaStyle);
            } else if (this.f3766f) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        /* access modifiers changed from: package-private */
        @RequiresApi(21)
        /* renamed from: k */
        public Notification.MediaStyle mo6561k(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.f3764d;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.f3765e;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public RemoteViews mo6562l() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, mo6559o(min), false);
            applyStandardTemplate.removeAllViews(C0835R.C0837id.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(C0835R.C0837id.media_actions, m2768n(this.mBuilder.mActions.get(i)));
                }
            }
            if (this.f3766f) {
                int i2 = C0835R.C0837id.cancel_action;
                applyStandardTemplate.setViewVisibility(i2, 0);
                applyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(C0835R.integer.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(i2, this.f3767g);
            } else {
                applyStandardTemplate.setViewVisibility(C0835R.C0837id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public RemoteViews mo6563m() {
            int i;
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, mo6560p(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.f3764d;
            if (iArr == null) {
                i = 0;
            } else {
                i = Math.min(iArr.length, 3);
            }
            applyStandardTemplate.removeAllViews(C0835R.C0837id.media_actions);
            if (i > 0) {
                int i2 = 0;
                while (i2 < i) {
                    if (i2 < size) {
                        applyStandardTemplate.addView(C0835R.C0837id.media_actions, m2768n(this.mBuilder.mActions.get(this.f3764d[i2])));
                        i2++;
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                    }
                }
            }
            if (this.f3766f) {
                applyStandardTemplate.setViewVisibility(C0835R.C0837id.end_padder, 8);
                int i3 = C0835R.C0837id.cancel_action;
                applyStandardTemplate.setViewVisibility(i3, 0);
                applyStandardTemplate.setOnClickPendingIntent(i3, this.f3767g);
                applyStandardTemplate.setInt(i3, "setAlpha", this.mBuilder.mContext.getResources().getInteger(C0835R.integer.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(C0835R.C0837id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(C0835R.C0837id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return mo6562l();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return mo6563m();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public int mo6559o(int i) {
            return i <= 3 ? C0835R.layout.notification_template_big_media_narrow : C0835R.layout.notification_template_big_media;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public int mo6560p() {
            return C0835R.layout.notification_template_media;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.f3767g = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f3765e = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f3764d = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (Build.VERSION.SDK_INT < 21) {
                this.f3766f = z;
            }
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }
    }
}
