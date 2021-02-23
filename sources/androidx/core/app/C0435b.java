package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.core.app.b */
/* compiled from: NotificationCompatBuilder */
class C0435b implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a */
    private final Notification.Builder f2233a;

    /* renamed from: b */
    private final NotificationCompat.Builder f2234b;

    /* renamed from: c */
    private RemoteViews f2235c;

    /* renamed from: d */
    private RemoteViews f2236d;

    /* renamed from: e */
    private final List<Bundle> f2237e = new ArrayList();

    /* renamed from: f */
    private final Bundle f2238f = new Bundle();

    /* renamed from: g */
    private int f2239g;

    /* renamed from: h */
    private RemoteViews f2240h;

    C0435b(NotificationCompat.Builder builder) {
        Icon icon;
        List<String> list;
        List<String> d;
        int i = Build.VERSION.SDK_INT;
        this.f2234b = builder;
        if (i >= 26) {
            this.f2233a = new Notification.Builder(builder.mContext, builder.f2065I);
        } else {
            this.f2233a = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.f2073Q;
        this.f2233a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f2081f).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f2077b).setContentText(builder.f2078c).setContentInfo(builder.f2083h).setContentIntent(builder.f2079d).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.f2080e, (notification.flags & 128) != 0).setLargeIcon(builder.f2082g).setNumber(builder.f2084i).setProgress(builder.f2093r, builder.f2094s, builder.f2095t);
        if (i < 21) {
            this.f2233a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i >= 16) {
            this.f2233a.setSubText(builder.f2090o).setUsesChronometer(builder.f2087l).setPriority(builder.f2085j);
            Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                m1447a(it.next());
            }
            Bundle bundle = builder.f2058B;
            if (bundle != null) {
                this.f2238f.putAll(bundle);
            }
            if (i < 20) {
                if (builder.f2099x) {
                    this.f2238f.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                String str = builder.f2096u;
                if (str != null) {
                    this.f2238f.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                    if (builder.f2097v) {
                        this.f2238f.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.f2238f.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                String str2 = builder.f2098w;
                if (str2 != null) {
                    this.f2238f.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
                }
            }
            this.f2235c = builder.f2062F;
            this.f2236d = builder.f2063G;
        }
        if (i >= 17) {
            this.f2233a.setShowWhen(builder.f2086k);
        }
        if (i >= 19 && i < 21 && (d = m1448d(m1449e(builder.mPersonList), builder.mPeople)) != null && !d.isEmpty()) {
            this.f2238f.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) d.toArray(new String[d.size()]));
        }
        if (i >= 20) {
            this.f2233a.setLocalOnly(builder.f2099x).setGroup(builder.f2096u).setGroupSummary(builder.f2097v).setSortKey(builder.f2098w);
            this.f2239g = builder.f2070N;
        }
        if (i >= 21) {
            this.f2233a.setCategory(builder.f2057A).setColor(builder.f2059C).setVisibility(builder.f2060D).setPublicVersion(builder.f2061E).setSound(notification.sound, notification.audioAttributes);
            if (i < 28) {
                list = m1448d(m1449e(builder.mPersonList), builder.mPeople);
            } else {
                list = builder.mPeople;
            }
            if (list != null && !list.isEmpty()) {
                for (String addPerson : list) {
                    this.f2233a.addPerson(addPerson);
                }
            }
            this.f2240h = builder.f2064H;
            if (builder.f2076a.size() > 0) {
                Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i2 = 0; i2 < builder.f2076a.size(); i2++) {
                    bundle4.putBundle(Integer.toString(i2), C0436c.m1462j(builder.f2076a.get(i2)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
                this.f2238f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (i >= 23 && (icon = builder.f2075S) != null) {
            this.f2233a.setSmallIcon(icon);
        }
        if (i >= 24) {
            this.f2233a.setExtras(builder.f2058B).setRemoteInputHistory(builder.f2092q);
            RemoteViews remoteViews = builder.f2062F;
            if (remoteViews != null) {
                this.f2233a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = builder.f2063G;
            if (remoteViews2 != null) {
                this.f2233a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = builder.f2064H;
            if (remoteViews3 != null) {
                this.f2233a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i >= 26) {
            this.f2233a.setBadgeIconType(builder.f2066J).setSettingsText(builder.f2091p).setShortcutId(builder.f2067K).setTimeoutAfter(builder.f2069M).setGroupAlertBehavior(builder.f2070N);
            if (builder.f2101z) {
                this.f2233a.setColorized(builder.f2100y);
            }
            if (!TextUtils.isEmpty(builder.f2065I)) {
                this.f2233a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i >= 28) {
            Iterator<Person> it2 = builder.mPersonList.iterator();
            while (it2.hasNext()) {
                this.f2233a.addPerson(it2.next().toAndroidPerson());
            }
        }
        if (i >= 29) {
            this.f2233a.setAllowSystemGeneratedContextualActions(builder.f2071O);
            this.f2233a.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(builder.f2072P));
            LocusIdCompat locusIdCompat = builder.f2068L;
            if (locusIdCompat != null) {
                this.f2233a.setLocusId(locusIdCompat.toLocusId());
            }
        }
        if (builder.f2074R) {
            if (this.f2234b.f2097v) {
                this.f2239g = 2;
            } else {
                this.f2239g = 1;
            }
            this.f2233a.setVibrate((long[]) null);
            this.f2233a.setSound((Uri) null);
            int i3 = notification.defaults & -2;
            notification.defaults = i3;
            int i4 = i3 & -3;
            notification.defaults = i4;
            this.f2233a.setDefaults(i4);
            if (i >= 26) {
                if (TextUtils.isEmpty(this.f2234b.f2096u)) {
                    this.f2233a.setGroup(NotificationCompat.GROUP_KEY_SILENT);
                }
                this.f2233a.setGroupAlertBehavior(this.f2239g);
            }
        }
    }

    /* renamed from: a */
    private void m1447a(NotificationCompat.Action action) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            IconCompat iconCompat = action.getIconCompat();
            if (i >= 23) {
                builder = new Notification.Action.Builder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent());
            } else {
                builder = new Notification.Action.Builder(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
            }
            if (action.getRemoteInputs() != null) {
                for (RemoteInput addRemoteInput : RemoteInput.m1425b(action.getRemoteInputs())) {
                    builder.addRemoteInput(addRemoteInput);
                }
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
            bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
            if (i >= 28) {
                builder.setSemanticAction(action.getSemanticAction());
            }
            if (i >= 29) {
                builder.setContextual(action.isContextual());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
            builder.addExtras(bundle);
            this.f2233a.addAction(builder.build());
        } else if (i >= 16) {
            this.f2237e.add(C0436c.m1467o(this.f2233a, action));
        }
    }

    @Nullable
    /* renamed from: d */
    private static List<String> m1448d(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    /* renamed from: e */
    private static List<String> m1449e(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person resolveToLegacyUri : list) {
            arrayList.add(resolveToLegacyUri.resolveToLegacyUri());
        }
        return arrayList;
    }

    /* renamed from: f */
    private void m1450f(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & -2;
        notification.defaults = i;
        notification.defaults = i & -3;
    }

    /* renamed from: b */
    public Notification mo4067b() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.f2234b.f2089n;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification c = mo4068c();
        if (makeContentView != null) {
            c.contentView = makeContentView;
        } else {
            RemoteViews remoteViews = this.f2234b.f2062F;
            if (remoteViews != null) {
                c.contentView = remoteViews;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (!(i < 16 || style == null || (makeBigContentView = style.makeBigContentView(this)) == null)) {
            c.bigContentView = makeBigContentView;
        }
        if (!(i < 21 || style == null || (makeHeadsUpContentView = this.f2234b.f2089n.makeHeadsUpContentView(this)) == null)) {
            c.headsUpContentView = makeHeadsUpContentView;
        }
        if (!(i < 16 || style == null || (extras = NotificationCompat.getExtras(c)) == null)) {
            style.addCompatExtras(extras);
        }
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Notification mo4068c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f2233a.build();
        }
        if (i >= 24) {
            Notification build = this.f2233a.build();
            if (this.f2239g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f2239g != 2)) {
                    m1450f(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2239g == 1) {
                    m1450f(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f2233a.setExtras(this.f2238f);
            Notification build2 = this.f2233a.build();
            RemoteViews remoteViews = this.f2235c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2236d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2240h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f2239g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f2239g != 2)) {
                    m1450f(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2239g == 1) {
                    m1450f(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f2233a.setExtras(this.f2238f);
            Notification build3 = this.f2233a.build();
            RemoteViews remoteViews4 = this.f2235c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2236d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f2239g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f2239g != 2)) {
                    m1450f(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2239g == 1) {
                    m1450f(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> a = C0436c.m1453a(this.f2237e);
            if (a != null) {
                this.f2238f.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a);
            }
            this.f2233a.setExtras(this.f2238f);
            Notification build4 = this.f2233a.build();
            RemoteViews remoteViews6 = this.f2235c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2236d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i < 16) {
            return this.f2233a.getNotification();
        } else {
            Notification build5 = this.f2233a.build();
            Bundle extras = NotificationCompat.getExtras(build5);
            Bundle bundle = new Bundle(this.f2238f);
            for (String str : this.f2238f.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            SparseArray<Bundle> a2 = C0436c.m1453a(this.f2237e);
            if (a2 != null) {
                NotificationCompat.getExtras(build5).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a2);
            }
            RemoteViews remoteViews8 = this.f2235c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f2236d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    public Notification.Builder getBuilder() {
        return this.f2233a;
    }
}
