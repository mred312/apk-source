package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;

    /* renamed from: a */
    private final String f2186a;

    /* renamed from: b */
    private final CharSequence f2187b;

    /* renamed from: c */
    private final CharSequence[] f2188c;

    /* renamed from: d */
    private final boolean f2189d;

    /* renamed from: e */
    private final int f2190e;

    /* renamed from: f */
    private final Bundle f2191f;

    /* renamed from: g */
    private final Set<String> f2192g;

    public static final class Builder {

        /* renamed from: a */
        private final String f2193a;

        /* renamed from: b */
        private final Set<String> f2194b = new HashSet();

        /* renamed from: c */
        private final Bundle f2195c = new Bundle();

        /* renamed from: d */
        private CharSequence f2196d;

        /* renamed from: e */
        private CharSequence[] f2197e;

        /* renamed from: f */
        private boolean f2198f = true;

        /* renamed from: g */
        private int f2199g = 0;

        public Builder(@NonNull String str) {
            if (str != null) {
                this.f2193a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle bundle) {
            if (bundle != null) {
                this.f2195c.putAll(bundle);
            }
            return this;
        }

        @NonNull
        public RemoteInput build() {
            return new RemoteInput(this.f2193a, this.f2196d, this.f2197e, this.f2198f, this.f2199g, this.f2195c, this.f2194b);
        }

        @NonNull
        public Bundle getExtras() {
            return this.f2195c;
        }

        @NonNull
        public Builder setAllowDataType(@NonNull String str, boolean z) {
            if (z) {
                this.f2194b.add(str);
            } else {
                this.f2194b.remove(str);
            }
            return this;
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean z) {
            this.f2198f = z;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] charSequenceArr) {
            this.f2197e = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int i) {
            this.f2199g = i;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence charSequence) {
            this.f2196d = charSequence;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set<String> set) {
        this.f2186a = str;
        this.f2187b = charSequence;
        this.f2188c = charSequenceArr;
        this.f2189d = z;
        this.f2190e = i;
        this.f2191f = bundle;
        this.f2192g = set;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    @RequiresApi(20)
    /* renamed from: a */
    static android.app.RemoteInput m1424a(RemoteInput remoteInput) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            android.app.RemoteInput.addDataResultToIntent(m1424a(remoteInput), intent, map);
        } else if (i >= 16) {
            Intent d = m1427d(intent);
            if (d == null) {
                d = new Intent();
            }
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Uri uri = (Uri) next.getValue();
                if (str != null) {
                    Bundle bundleExtra = d.getBundleExtra(m1428e(str));
                    if (bundleExtra == null) {
                        bundleExtra = new Bundle();
                    }
                    bundleExtra.putString(remoteInput.getResultKey(), uri.toString());
                    d.putExtra(m1428e(str), bundleExtra);
                }
            }
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, d));
        }
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            android.app.RemoteInput.addResultsToIntent(m1425b(remoteInputArr), intent, bundle);
            return;
        }
        if (i >= 20) {
            Bundle resultsFromIntent = getResultsFromIntent(intent);
            int resultsSource = getResultsSource(intent);
            if (resultsFromIntent != null) {
                resultsFromIntent.putAll(bundle);
                bundle = resultsFromIntent;
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
                android.app.RemoteInput.addResultsToIntent(m1425b(new RemoteInput[]{remoteInput}), intent, bundle);
                if (dataResultsFromIntent != null) {
                    addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
                }
            }
            setResultsSource(intent, resultsSource);
        } else if (i >= 16) {
            Intent d = m1427d(intent);
            if (d == null) {
                d = new Intent();
            }
            Bundle bundleExtra = d.getBundleExtra(EXTRA_RESULTS_DATA);
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            for (RemoteInput remoteInput2 : remoteInputArr) {
                Object obj = bundle.get(remoteInput2.getResultKey());
                if (obj instanceof CharSequence) {
                    bundleExtra.putCharSequence(remoteInput2.getResultKey(), (CharSequence) obj);
                }
            }
            d.putExtra(EXTRA_RESULTS_DATA, bundleExtra);
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, d));
        }
    }

    @RequiresApi(20)
    /* renamed from: b */
    static android.app.RemoteInput[] m1425b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = m1424a(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    @RequiresApi(20)
    /* renamed from: c */
    static RemoteInput m1426c(android.app.RemoteInput remoteInput) {
        Builder addExtras = new Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    @RequiresApi(16)
    /* renamed from: d */
    private static Intent m1427d(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    /* renamed from: e */
    private static String m1428e(String str) {
        return "android.remoteinput.dataTypeResultsData" + str;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        Intent d;
        String string;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }
        if (i < 16 || (d = m1427d(intent)) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : d.getExtras().keySet()) {
            if (str2.startsWith("android.remoteinput.dataTypeResultsData")) {
                String substring = str2.substring(39);
                if (!substring.isEmpty() && (string = d.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    hashMap.put(substring, Uri.parse(string));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        Intent d;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
        if (i < 16 || (d = m1427d(intent)) == null) {
            return null;
        }
        return (Bundle) d.getExtras().getParcelable(EXTRA_RESULTS_DATA);
    }

    public static int getResultsSource(@NonNull Intent intent) {
        Intent d;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return android.app.RemoteInput.getResultsSource(intent);
        }
        if (i < 16 || (d = m1427d(intent)) == null) {
            return 0;
        }
        return d.getExtras().getInt("android.remoteinput.resultsSource", 0);
    }

    public static void setResultsSource(@NonNull Intent intent, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            android.app.RemoteInput.setResultsSource(intent, i);
        } else if (i2 >= 16) {
            Intent d = m1427d(intent);
            if (d == null) {
                d = new Intent();
            }
            d.putExtra("android.remoteinput.resultsSource", i);
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, d));
        }
    }

    public boolean getAllowFreeFormInput() {
        return this.f2189d;
    }

    public Set<String> getAllowedDataTypes() {
        return this.f2192g;
    }

    public CharSequence[] getChoices() {
        return this.f2188c;
    }

    public int getEditChoicesBeforeSending() {
        return this.f2190e;
    }

    public Bundle getExtras() {
        return this.f2191f;
    }

    public CharSequence getLabel() {
        return this.f2187b;
    }

    public String getResultKey() {
        return this.f2186a;
    }

    public boolean isDataOnly() {
        return !getAllowFreeFormInput() && (getChoices() == null || getChoices().length == 0) && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty();
    }
}
