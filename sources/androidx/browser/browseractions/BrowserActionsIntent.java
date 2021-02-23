package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowserActionsIntent {
    public static final String ACTION_BROWSER_ACTIONS_OPEN = "androidx.browser.browseractions.browser_action_open";
    public static final String EXTRA_APP_ID = "androidx.browser.browseractions.APP_ID";
    public static final String EXTRA_MENU_ITEMS = "androidx.browser.browseractions.extra.MENU_ITEMS";
    public static final String EXTRA_SELECTED_ACTION_PENDING_INTENT = "androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT";
    public static final String EXTRA_TYPE = "androidx.browser.browseractions.extra.TYPE";
    public static final int ITEM_COPY = 3;
    public static final int ITEM_DOWNLOAD = 2;
    public static final int ITEM_INVALID_ITEM = -1;
    public static final int ITEM_OPEN_IN_INCOGNITO = 1;
    public static final int ITEM_OPEN_IN_NEW_TAB = 0;
    public static final int ITEM_SHARE = 4;
    public static final String KEY_ACTION = "androidx.browser.browseractions.ACTION";
    public static final String KEY_ICON_ID = "androidx.browser.browseractions.ICON_ID";
    public static final String KEY_TITLE = "androidx.browser.browseractions.TITLE";
    public static final int MAX_CUSTOM_ITEMS = 5;
    public static final int URL_TYPE_AUDIO = 3;
    public static final int URL_TYPE_FILE = 4;
    public static final int URL_TYPE_IMAGE = 1;
    public static final int URL_TYPE_NONE = 0;
    public static final int URL_TYPE_PLUGIN = 5;
    public static final int URL_TYPE_VIDEO = 2;

    /* renamed from: b */
    private static C0362a f1776b;
    @NonNull

    /* renamed from: a */
    private final Intent f1777a;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BrowserActionsItemId {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BrowserActionsUrlType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    /* renamed from: androidx.browser.browseractions.BrowserActionsIntent$a */
    interface C0362a {
        /* renamed from: a */
        void mo3154a();
    }

    BrowserActionsIntent(@NonNull Intent intent) {
        this.f1777a = intent;
    }

    /* renamed from: a */
    private static List<ResolveInfo> m1193a(Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent(ACTION_BROWSER_ACTIONS_OPEN, Uri.parse("https://www.example.com")), 131072);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: b */
    static void m1194b(Context context, Intent intent, List<ResolveInfo> list) {
        if (list == null || list.size() == 0) {
            m1195c(context, intent);
            return;
        }
        int i = 0;
        if (list.size() == 1) {
            intent.setPackage(list.get(0).activityInfo.packageName);
        } else {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 65536);
            if (resolveActivity != null) {
                String str = resolveActivity.activityInfo.packageName;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    } else if (str.equals(list.get(i).activityInfo.packageName)) {
                        intent.setPackage(str);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        ContextCompat.startActivity(context, intent, (Bundle) null);
    }

    /* renamed from: c */
    private static void m1195c(Context context, Intent intent) {
        Uri data = intent.getData();
        int intExtra = intent.getIntExtra(EXTRA_TYPE, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(EXTRA_MENU_ITEMS);
        m1196d(context, data, intExtra, parcelableArrayListExtra != null ? parseBrowserActionItems(parcelableArrayListExtra) : null);
    }

    /* renamed from: d */
    private static void m1196d(Context context, Uri uri, int i, List<BrowserActionItem> list) {
        new C0367c(context, uri, list).mo3163a();
        C0362a aVar = f1776b;
        if (aVar != null) {
            aVar.mo3154a();
        }
    }

    public static String getCreatorPackageName(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(EXTRA_APP_ID);
        if (pendingIntent == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return pendingIntent.getCreatorPackage();
        }
        return pendingIntent.getTargetPackage();
    }

    public static void launchIntent(Context context, Intent intent) {
        m1194b(context, intent, m1193a(context));
    }

    public static void openBrowserAction(Context context, Uri uri) {
        launchIntent(context, new Builder(context, uri).build().getIntent());
    }

    public static List<BrowserActionItem> parseBrowserActionItems(ArrayList<Bundle> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = arrayList.get(i);
            String string = bundle.getString(KEY_TITLE);
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(KEY_ACTION);
            int i2 = bundle.getInt(KEY_ICON_ID);
            if (TextUtils.isEmpty(string) || pendingIntent == null) {
                throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            }
            arrayList2.add(new BrowserActionItem(string, pendingIntent, i2));
        }
        return arrayList2;
    }

    @NonNull
    public Intent getIntent() {
        return this.f1777a;
    }

    public static void openBrowserAction(Context context, Uri uri, int i, ArrayList<BrowserActionItem> arrayList, PendingIntent pendingIntent) {
        launchIntent(context, new Builder(context, uri).setUrlType(i).setCustomItems(arrayList).setOnItemSelectedAction(pendingIntent).build().getIntent());
    }

    public static final class Builder {

        /* renamed from: a */
        private final Intent f1778a = new Intent(BrowserActionsIntent.ACTION_BROWSER_ACTIONS_OPEN);

        /* renamed from: b */
        private Context f1779b;

        /* renamed from: c */
        private Uri f1780c;

        /* renamed from: d */
        private int f1781d;

        /* renamed from: e */
        private ArrayList<Bundle> f1782e = null;

        /* renamed from: f */
        private PendingIntent f1783f = null;

        public Builder(Context context, Uri uri) {
            this.f1779b = context;
            this.f1780c = uri;
            this.f1781d = 0;
            this.f1782e = new ArrayList<>();
        }

        /* renamed from: a */
        private Bundle m1197a(BrowserActionItem browserActionItem) {
            Bundle bundle = new Bundle();
            bundle.putString(BrowserActionsIntent.KEY_TITLE, browserActionItem.getTitle());
            bundle.putParcelable(BrowserActionsIntent.KEY_ACTION, browserActionItem.getAction());
            if (browserActionItem.getIconId() != 0) {
                bundle.putInt(BrowserActionsIntent.KEY_ICON_ID, browserActionItem.getIconId());
            }
            return bundle;
        }

        public BrowserActionsIntent build() {
            this.f1778a.setData(this.f1780c);
            this.f1778a.putExtra(BrowserActionsIntent.EXTRA_TYPE, this.f1781d);
            this.f1778a.putParcelableArrayListExtra(BrowserActionsIntent.EXTRA_MENU_ITEMS, this.f1782e);
            this.f1778a.putExtra(BrowserActionsIntent.EXTRA_APP_ID, PendingIntent.getActivity(this.f1779b, 0, new Intent(), 0));
            PendingIntent pendingIntent = this.f1783f;
            if (pendingIntent != null) {
                this.f1778a.putExtra(BrowserActionsIntent.EXTRA_SELECTED_ACTION_PENDING_INTENT, pendingIntent);
            }
            return new BrowserActionsIntent(this.f1778a);
        }

        public Builder setCustomItems(ArrayList<BrowserActionItem> arrayList) {
            if (arrayList.size() <= 5) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (TextUtils.isEmpty(arrayList.get(i).getTitle()) || arrayList.get(i).getAction() == null) {
                        throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
                    }
                    this.f1782e.add(m1197a(arrayList.get(i)));
                }
                return this;
            }
            throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        }

        public Builder setOnItemSelectedAction(PendingIntent pendingIntent) {
            this.f1783f = pendingIntent;
            return this;
        }

        public Builder setUrlType(int i) {
            this.f1781d = i;
            return this;
        }

        public Builder setCustomItems(BrowserActionItem... browserActionItemArr) {
            return setCustomItems((ArrayList<BrowserActionItem>) new ArrayList(Arrays.asList(browserActionItemArr)));
        }
    }
}
