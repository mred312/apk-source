package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

public class Person {
    @Nullable

    /* renamed from: a */
    CharSequence f2174a;
    @Nullable

    /* renamed from: b */
    IconCompat f2175b;
    @Nullable

    /* renamed from: c */
    String f2176c;
    @Nullable

    /* renamed from: d */
    String f2177d;

    /* renamed from: e */
    boolean f2178e;

    /* renamed from: f */
    boolean f2179f;

    public static class Builder {
        @Nullable

        /* renamed from: a */
        CharSequence f2180a;
        @Nullable

        /* renamed from: b */
        IconCompat f2181b;
        @Nullable

        /* renamed from: c */
        String f2182c;
        @Nullable

        /* renamed from: d */
        String f2183d;

        /* renamed from: e */
        boolean f2184e;

        /* renamed from: f */
        boolean f2185f;

        public Builder() {
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }

        @NonNull
        public Builder setBot(boolean z) {
            this.f2184e = z;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat iconCompat) {
            this.f2181b = iconCompat;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean z) {
            this.f2185f = z;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String str) {
            this.f2183d = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f2180a = charSequence;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String str) {
            this.f2182c = str;
            return this;
        }

        Builder(Person person) {
            this.f2180a = person.f2174a;
            this.f2181b = person.f2175b;
            this.f2182c = person.f2176c;
            this.f2183d = person.f2177d;
            this.f2184e = person.f2178e;
            this.f2185f = person.f2179f;
        }
    }

    Person(Builder builder) {
        this.f2174a = builder.f2180a;
        this.f2175b = builder.f2181b;
        this.f2176c = builder.f2182c;
        this.f2177d = builder.f2183d;
        this.f2178e = builder.f2184e;
        this.f2179f = builder.f2185f;
    }

    @RequiresApi(28)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        return new Builder().setName(person.getName()).setIcon(person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new Builder().setName(bundle.getCharSequence("name")).setIcon(bundle2 != null ? IconCompat.createFromBundle(bundle2) : null).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean("isBot")).setImportant(bundle.getBoolean("isImportant")).build();
    }

    @RequiresApi(22)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle persistableBundle) {
        return new Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString("key")).setBot(persistableBundle.getBoolean("isBot")).setImportant(persistableBundle.getBoolean("isImportant")).build();
    }

    @Nullable
    public IconCompat getIcon() {
        return this.f2175b;
    }

    @Nullable
    public String getKey() {
        return this.f2177d;
    }

    @Nullable
    public CharSequence getName() {
        return this.f2174a;
    }

    @Nullable
    public String getUri() {
        return this.f2176c;
    }

    public boolean isBot() {
        return this.f2178e;
    }

    public boolean isImportant() {
        return this.f2179f;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String str = this.f2176c;
        if (str != null) {
            return str;
        }
        if (this.f2174a == null) {
            return "";
        }
        return "name:" + this.f2174a;
    }

    @RequiresApi(28)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return new Person.Builder().setName(getName()).setIcon(getIcon() != null ? getIcon().toIcon() : null).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f2174a);
        IconCompat iconCompat = this.f2175b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.toBundle() : null);
        bundle.putString("uri", this.f2176c);
        bundle.putString("key", this.f2177d);
        bundle.putBoolean("isBot", this.f2178e);
        bundle.putBoolean("isImportant", this.f2179f);
        return bundle;
    }

    @RequiresApi(22)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = this.f2174a;
        persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
        persistableBundle.putString("uri", this.f2176c);
        persistableBundle.putString("key", this.f2177d);
        persistableBundle.putBoolean("isBot", this.f2178e);
        persistableBundle.putBoolean("isImportant", this.f2179f);
        return persistableBundle;
    }
}
