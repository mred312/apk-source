package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    public static class IntentBuilder {
        @NonNull

        /* renamed from: a */
        private final Context f2200a;
        @NonNull

        /* renamed from: b */
        private final Intent f2201b;
        @Nullable

        /* renamed from: c */
        private CharSequence f2202c;
        @Nullable

        /* renamed from: d */
        private ArrayList<String> f2203d;
        @Nullable

        /* renamed from: e */
        private ArrayList<String> f2204e;
        @Nullable

        /* renamed from: f */
        private ArrayList<String> f2205f;
        @Nullable

        /* renamed from: g */
        private ArrayList<Uri> f2206g;

        private IntentBuilder(@NonNull Context context, @Nullable ComponentName componentName) {
            this.f2200a = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f2201b = action;
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
            action.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            action.addFlags(524288);
        }

        /* renamed from: a */
        private void m1431a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f2201b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f2201b.putExtra(str, strArr);
        }

        /* renamed from: b */
        private void m1432b(@Nullable String str, @NonNull String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[(strArr.length + length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }

        @NonNull
        /* renamed from: c */
        private static IntentBuilder m1433c(@NonNull Context context, @Nullable ComponentName componentName) {
            return new IntentBuilder(context, componentName);
        }

        @NonNull
        public static IntentBuilder from(@NonNull Activity activity) {
            return m1433c((Context) Preconditions.checkNotNull(activity), activity.getComponentName());
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String str) {
            if (this.f2205f == null) {
                this.f2205f = new ArrayList<>();
            }
            this.f2205f.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String str) {
            if (this.f2204e == null) {
                this.f2204e = new ArrayList<>();
            }
            this.f2204e.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String str) {
            if (this.f2203d == null) {
                this.f2203d = new ArrayList<>();
            }
            this.f2203d.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri uri) {
            Uri uri2 = (Uri) this.f2201b.getParcelableExtra("android.intent.extra.STREAM");
            ArrayList<Uri> arrayList = this.f2206g;
            if (arrayList == null && uri2 == null) {
                return setStream(uri);
            }
            if (arrayList == null) {
                this.f2206g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.f2201b.removeExtra("android.intent.extra.STREAM");
                this.f2206g.add(uri2);
            }
            this.f2206g.add(uri);
            return this;
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f2202c);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: d */
        public Context mo4005d() {
            return this.f2200a;
        }

        @NonNull
        public Intent getIntent() {
            ArrayList<String> arrayList = this.f2203d;
            if (arrayList != null) {
                m1431a("android.intent.extra.EMAIL", arrayList);
                this.f2203d = null;
            }
            ArrayList<String> arrayList2 = this.f2204e;
            if (arrayList2 != null) {
                m1431a("android.intent.extra.CC", arrayList2);
                this.f2204e = null;
            }
            ArrayList<String> arrayList3 = this.f2205f;
            if (arrayList3 != null) {
                m1431a("android.intent.extra.BCC", arrayList3);
                this.f2205f = null;
            }
            ArrayList<Uri> arrayList4 = this.f2206g;
            boolean z = true;
            if (arrayList4 == null || arrayList4.size() <= 1) {
                z = false;
            }
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.f2201b.getAction());
            if (!z && equals) {
                this.f2201b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.f2206g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.f2201b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f2201b.putExtra("android.intent.extra.STREAM", this.f2206g.get(0));
                }
                this.f2206g = null;
            }
            if (z && !equals) {
                this.f2201b.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList6 = this.f2206g;
                if (arrayList6 == null || arrayList6.isEmpty()) {
                    this.f2201b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f2201b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f2206g);
                }
            }
            return this.f2201b;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
            this.f2202c = charSequence;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] strArr) {
            this.f2201b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] strArr) {
            this.f2201b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] strArr) {
            if (this.f2203d != null) {
                this.f2203d = null;
            }
            this.f2201b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String str) {
            this.f2201b.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.f2201b.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri uri) {
            if (!"android.intent.action.SEND".equals(this.f2201b.getAction())) {
                this.f2201b.setAction("android.intent.action.SEND");
            }
            this.f2206g = null;
            this.f2201b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String str) {
            this.f2201b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence charSequence) {
            this.f2201b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String str) {
            this.f2201b.setType(str);
            return this;
        }

        public void startChooser() {
            this.f2200a.startActivity(createChooserIntent());
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int i) {
            return setChooserTitle(this.f2200a.getText(i));
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] strArr) {
            m1432b("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] strArr) {
            m1432b("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] strArr) {
            m1432b("android.intent.extra.EMAIL", strArr);
            return this;
        }
    }

    public static class IntentReader {
        @NonNull

        /* renamed from: a */
        private final Context f2207a;
        @NonNull

        /* renamed from: b */
        private final Intent f2208b;
        @Nullable

        /* renamed from: c */
        private final String f2209c;
        @Nullable

        /* renamed from: d */
        private final ComponentName f2210d;
        @Nullable

        /* renamed from: e */
        private ArrayList<Uri> f2211e;

        private IntentReader(@NonNull Context context, @NonNull Intent intent) {
            this.f2207a = (Context) Preconditions.checkNotNull(context);
            this.f2208b = (Intent) Preconditions.checkNotNull(intent);
            this.f2209c = ShareCompat.m1430b(intent);
            this.f2210d = ShareCompat.m1429a(intent);
        }

        @NonNull
        /* renamed from: a */
        private static IntentReader m1435a(@NonNull Context context, @NonNull Intent intent) {
            return new IntentReader(context, intent);
        }

        /* renamed from: b */
        private static void m1436b(StringBuilder sb, CharSequence charSequence, int i, int i2) {
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#");
                    sb.append(charAt);
                    sb.append(";");
                } else if (charAt == ' ') {
                    while (true) {
                        int i3 = i + 1;
                        if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                            sb.append(' ');
                        } else {
                            sb.append("&nbsp;");
                            i = i3;
                        }
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i++;
            }
        }

        @NonNull
        public static IntentReader from(@NonNull Activity activity) {
            return m1435a((Context) Preconditions.checkNotNull(activity), activity.getIntent());
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.f2210d;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            if (this.f2210d == null) {
                return null;
            }
            try {
                return this.f2207a.getPackageManager().getActivityIcon(this.f2210d);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            if (this.f2209c == null) {
                return null;
            }
            try {
                return this.f2207a.getPackageManager().getApplicationIcon(this.f2209c);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            if (this.f2209c == null) {
                return null;
            }
            PackageManager packageManager = this.f2207a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f2209c, 0));
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("IntentReader", "Could not retrieve label for calling application", e);
                return null;
            }
        }

        @Nullable
        public String getCallingPackage() {
            return this.f2209c;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.f2208b.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.f2208b.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.f2208b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String stringExtra = this.f2208b.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence text = getText();
            if (text instanceof Spanned) {
                return Html.toHtml((Spanned) text);
            }
            if (text == null) {
                return stringExtra;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return Html.escapeHtml(text);
            }
            StringBuilder sb = new StringBuilder();
            m1436b(sb, text, 0, text.length());
            return sb.toString();
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.f2208b.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.f2211e == null && isMultipleShare()) {
                this.f2211e = this.f2208b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f2211e;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.f2208b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @Nullable
        public String getSubject() {
            return this.f2208b.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.f2208b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.f2208b.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f2208b.getAction());
        }

        public boolean isShareIntent() {
            String action = this.f2208b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.f2208b.getAction());
        }

        @Nullable
        public Uri getStream(int i) {
            if (this.f2211e == null && isMultipleShare()) {
                this.f2211e = this.f2208b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f2211e;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            if (i == 0) {
                return (Uri) this.f2208b.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }
    }

    private ShareCompat() {
    }

    @Nullable
    /* renamed from: a */
    static ComponentName m1429a(@NonNull Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        return componentName == null ? (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP) : componentName;
    }

    @Nullable
    /* renamed from: b */
    static String m1430b(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        return stringExtra == null ? intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP) : stringExtra;
    }

    public static void configureMenuItem(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ShareActionProvider shareActionProvider;
        ActionProvider actionProvider = menuItem.getActionProvider();
        if (!(actionProvider instanceof ShareActionProvider)) {
            shareActionProvider = new ShareActionProvider(intentBuilder.mo4005d());
        } else {
            shareActionProvider = (ShareActionProvider) actionProvider;
        }
        shareActionProvider.setShareHistoryFileName(".sharecompat_" + intentBuilder.mo4005d().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
        if (Build.VERSION.SDK_INT < 16 && !menuItem.hasSubMenu()) {
            menuItem.setIntent(intentBuilder.createChooserIntent());
        }
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? m1429a(intent) : callingActivity;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : m1430b(intent);
    }

    public static void configureMenuItem(@NonNull Menu menu, @IdRes int i, @NonNull IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
    }
}
