package androidx.core.content.p002pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: androidx.core.content.pm.ShortcutInfoCompat */
public class ShortcutInfoCompat {

    /* renamed from: a */
    Context f2264a;

    /* renamed from: b */
    String f2265b;

    /* renamed from: c */
    String f2266c;

    /* renamed from: d */
    Intent[] f2267d;

    /* renamed from: e */
    ComponentName f2268e;

    /* renamed from: f */
    CharSequence f2269f;

    /* renamed from: g */
    CharSequence f2270g;

    /* renamed from: h */
    CharSequence f2271h;

    /* renamed from: i */
    IconCompat f2272i;

    /* renamed from: j */
    boolean f2273j;

    /* renamed from: k */
    Person[] f2274k;

    /* renamed from: l */
    Set<String> f2275l;
    @Nullable

    /* renamed from: m */
    LocusIdCompat f2276m;

    /* renamed from: n */
    boolean f2277n;

    /* renamed from: o */
    int f2278o;

    /* renamed from: p */
    PersistableBundle f2279p;

    /* renamed from: q */
    long f2280q;

    /* renamed from: r */
    UserHandle f2281r;

    /* renamed from: s */
    boolean f2282s;

    /* renamed from: t */
    boolean f2283t;

    /* renamed from: u */
    boolean f2284u;

    /* renamed from: v */
    boolean f2285v;

    /* renamed from: w */
    boolean f2286w;

    /* renamed from: x */
    boolean f2287x = true;

    /* renamed from: y */
    boolean f2288y;

    /* renamed from: z */
    int f2289z;

    /* renamed from: androidx.core.content.pm.ShortcutInfoCompat$Builder */
    public static class Builder {

        /* renamed from: a */
        private final ShortcutInfoCompat f2290a;

        /* renamed from: b */
        private boolean f2291b;

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f2290a = shortcutInfoCompat;
            shortcutInfoCompat.f2264a = context;
            shortcutInfoCompat.f2265b = str;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (!TextUtils.isEmpty(this.f2290a.f2269f)) {
                ShortcutInfoCompat shortcutInfoCompat = this.f2290a;
                Intent[] intentArr = shortcutInfoCompat.f2267d;
                if (intentArr == null || intentArr.length == 0) {
                    throw new IllegalArgumentException("Shortcut must have an intent");
                }
                if (this.f2291b) {
                    if (shortcutInfoCompat.f2276m == null) {
                        shortcutInfoCompat.f2276m = new LocusIdCompat(shortcutInfoCompat.f2265b);
                    }
                    this.f2290a.f2277n = true;
                }
                return this.f2290a;
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.f2290a.f2268e = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.f2290a.f2273j = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            this.f2290a.f2275l = set;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.f2290a.f2271h = charSequence;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle persistableBundle) {
            this.f2290a.f2279p = persistableBundle;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.f2290a.f2272i = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.f2290a.f2267d = intentArr;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.f2291b = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.f2290a.f2276m = locusIdCompat;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.f2290a.f2270g = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.f2290a.f2277n = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.f2290a.f2274k = personArr;
            return this;
        }

        @NonNull
        public Builder setRank(int i) {
            this.f2290a.f2278o = i;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.f2290a.f2269f = charSequence;
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean z) {
            this.f2290a.f2277n = z;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.f2290a = shortcutInfoCompat2;
            shortcutInfoCompat2.f2264a = shortcutInfoCompat.f2264a;
            shortcutInfoCompat2.f2265b = shortcutInfoCompat.f2265b;
            shortcutInfoCompat2.f2266c = shortcutInfoCompat.f2266c;
            Intent[] intentArr = shortcutInfoCompat.f2267d;
            shortcutInfoCompat2.f2267d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.f2268e = shortcutInfoCompat.f2268e;
            shortcutInfoCompat2.f2269f = shortcutInfoCompat.f2269f;
            shortcutInfoCompat2.f2270g = shortcutInfoCompat.f2270g;
            shortcutInfoCompat2.f2271h = shortcutInfoCompat.f2271h;
            shortcutInfoCompat2.f2289z = shortcutInfoCompat.f2289z;
            shortcutInfoCompat2.f2272i = shortcutInfoCompat.f2272i;
            shortcutInfoCompat2.f2273j = shortcutInfoCompat.f2273j;
            shortcutInfoCompat2.f2281r = shortcutInfoCompat.f2281r;
            shortcutInfoCompat2.f2280q = shortcutInfoCompat.f2280q;
            shortcutInfoCompat2.f2282s = shortcutInfoCompat.f2282s;
            shortcutInfoCompat2.f2283t = shortcutInfoCompat.f2283t;
            shortcutInfoCompat2.f2284u = shortcutInfoCompat.f2284u;
            shortcutInfoCompat2.f2285v = shortcutInfoCompat.f2285v;
            shortcutInfoCompat2.f2286w = shortcutInfoCompat.f2286w;
            shortcutInfoCompat2.f2287x = shortcutInfoCompat.f2287x;
            shortcutInfoCompat2.f2276m = shortcutInfoCompat.f2276m;
            shortcutInfoCompat2.f2277n = shortcutInfoCompat.f2277n;
            shortcutInfoCompat2.f2288y = shortcutInfoCompat.f2288y;
            shortcutInfoCompat2.f2278o = shortcutInfoCompat.f2278o;
            Person[] personArr = shortcutInfoCompat.f2274k;
            if (personArr != null) {
                shortcutInfoCompat2.f2274k = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.f2275l != null) {
                shortcutInfoCompat2.f2275l = new HashSet(shortcutInfoCompat.f2275l);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.f2279p;
            if (persistableBundle != null) {
                shortcutInfoCompat2.f2279p = persistableBundle;
            }
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f2290a = shortcutInfoCompat;
            shortcutInfoCompat.f2264a = context;
            shortcutInfoCompat.f2265b = shortcutInfo.getId();
            shortcutInfoCompat.f2266c = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            shortcutInfoCompat.f2267d = (Intent[]) Arrays.copyOf(intents, intents.length);
            shortcutInfoCompat.f2268e = shortcutInfo.getActivity();
            shortcutInfoCompat.f2269f = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f2270g = shortcutInfo.getLongLabel();
            shortcutInfoCompat.f2271h = shortcutInfo.getDisabledMessage();
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                shortcutInfoCompat.f2289z = shortcutInfo.getDisabledReason();
            } else {
                shortcutInfoCompat.f2289z = shortcutInfo.isEnabled() ? 0 : 3;
            }
            shortcutInfoCompat.f2275l = shortcutInfo.getCategories();
            shortcutInfoCompat.f2274k = ShortcutInfoCompat.m1489f(shortcutInfo.getExtras());
            shortcutInfoCompat.f2281r = shortcutInfo.getUserHandle();
            shortcutInfoCompat.f2280q = shortcutInfo.getLastChangedTimestamp();
            if (i >= 30) {
                shortcutInfoCompat.f2282s = shortcutInfo.isCached();
            }
            shortcutInfoCompat.f2283t = shortcutInfo.isDynamic();
            shortcutInfoCompat.f2284u = shortcutInfo.isPinned();
            shortcutInfoCompat.f2285v = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.f2286w = shortcutInfo.isImmutable();
            shortcutInfoCompat.f2287x = shortcutInfo.isEnabled();
            shortcutInfoCompat.f2288y = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.f2276m = ShortcutInfoCompat.m1487d(shortcutInfo);
            shortcutInfoCompat.f2278o = shortcutInfo.getRank();
            shortcutInfoCompat.f2279p = shortcutInfo.getExtras();
        }
    }

    ShortcutInfoCompat() {
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: b */
    private PersistableBundle m1485b() {
        if (this.f2279p == null) {
            this.f2279p = new PersistableBundle();
        }
        Person[] personArr = this.f2274k;
        if (personArr != null && personArr.length > 0) {
            this.f2279p.putInt("extraPersonCount", personArr.length);
            int i = 0;
            while (i < this.f2274k.length) {
                PersistableBundle persistableBundle = this.f2279p;
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i2 = i + 1;
                sb.append(i2);
                persistableBundle.putPersistableBundle(sb.toString(), this.f2274k[i].toPersistableBundle());
                i = i2;
            }
        }
        LocusIdCompat locusIdCompat = this.f2276m;
        if (locusIdCompat != null) {
            this.f2279p.putString("extraLocusId", locusIdCompat.getId());
        }
        this.f2279p.putBoolean("extraLongLived", this.f2277n);
        return this.f2279p;
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: c */
    static List<ShortcutInfoCompat> m1486c(@NonNull Context context, @NonNull List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ShortcutInfo builder : list) {
            arrayList.add(new Builder(context, builder).build());
        }
        return arrayList;
    }

    @RequiresApi(25)
    @Nullable
    /* renamed from: d */
    static LocusIdCompat m1487d(@NonNull ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return m1488e(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
    }

    @RequiresApi(25)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* renamed from: e */
    private static LocusIdCompat m1488e(@Nullable PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString("extraLocusId")) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    @RequiresApi(25)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    /* renamed from: f */
    static Person[] m1489f(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey("extraPersonCount")) {
            return null;
        }
        int i = persistableBundle.getInt("extraPersonCount");
        Person[] personArr = new Person[i];
        int i2 = 0;
        while (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("extraPerson_");
            int i3 = i2 + 1;
            sb.append(i3);
            personArr[i2] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
            i2 = i3;
        }
        return personArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Intent mo4088a(Intent intent) {
        Intent[] intentArr = this.f2267d;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f2269f.toString());
        if (this.f2272i != null) {
            Drawable drawable = null;
            if (this.f2273j) {
                PackageManager packageManager = this.f2264a.getPackageManager();
                ComponentName componentName = this.f2268e;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f2264a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f2272i.addToShortcutIntent(intent, drawable, this.f2264a);
        }
        return intent;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.f2268e;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.f2275l;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.f2271h;
    }

    public int getDisabledReason() {
        return this.f2289z;
    }

    @Nullable
    public PersistableBundle getExtras() {
        return this.f2279p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.f2272i;
    }

    @NonNull
    public String getId() {
        return this.f2265b;
    }

    @NonNull
    public Intent getIntent() {
        Intent[] intentArr = this.f2267d;
        return intentArr[intentArr.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.f2267d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.f2280q;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        return this.f2276m;
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.f2270g;
    }

    @NonNull
    public String getPackage() {
        return this.f2266c;
    }

    public int getRank() {
        return this.f2278o;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.f2269f;
    }

    @Nullable
    public UserHandle getUserHandle() {
        return this.f2281r;
    }

    public boolean hasKeyFieldsOnly() {
        return this.f2288y;
    }

    public boolean isCached() {
        return this.f2282s;
    }

    public boolean isDeclaredInManifest() {
        return this.f2285v;
    }

    public boolean isDynamic() {
        return this.f2283t;
    }

    public boolean isEnabled() {
        return this.f2287x;
    }

    public boolean isImmutable() {
        return this.f2286w;
    }

    public boolean isPinned() {
        return this.f2284u;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f2264a, this.f2265b).setShortLabel(this.f2269f).setIntents(this.f2267d);
        IconCompat iconCompat = this.f2272i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.f2264a));
        }
        if (!TextUtils.isEmpty(this.f2270g)) {
            intents.setLongLabel(this.f2270g);
        }
        if (!TextUtils.isEmpty(this.f2271h)) {
            intents.setDisabledMessage(this.f2271h);
        }
        ComponentName componentName = this.f2268e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.f2275l;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f2278o);
        PersistableBundle persistableBundle = this.f2279p;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.f2274k;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i = 0; i < length; i++) {
                    personArr2[i] = this.f2274k[i].toAndroidPerson();
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.f2276m;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.toLocusId());
            }
            intents.setLongLived(this.f2277n);
        } else {
            intents.setExtras(m1485b());
        }
        return intents.build();
    }
}
