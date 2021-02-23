package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {

    /* renamed from: a */
    private final String f2443a;

    /* renamed from: b */
    private final String f2444b;

    /* renamed from: c */
    private final String f2445c;

    /* renamed from: d */
    private final List<List<byte[]>> f2446d;

    /* renamed from: e */
    private final int f2447e;

    /* renamed from: f */
    private final String f2448f;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.f2443a = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.f2444b = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.f2445c = str6;
        this.f2446d = (List) Preconditions.checkNotNull(list);
        this.f2447e = 0;
        this.f2448f = str4 + "-" + str5 + "-" + str6;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.f2446d;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.f2447e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String getIdentifier() {
        return this.f2448f;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.f2443a;
    }

    @NonNull
    public String getProviderPackage() {
        return this.f2444b;
    }

    @NonNull
    public String getQuery() {
        return this.f2445c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2443a + ", mProviderPackage: " + this.f2444b + ", mQuery: " + this.f2445c + ", mCertificates:");
        for (int i = 0; i < this.f2446d.size(); i++) {
            sb.append(" [");
            List list = this.f2446d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2447e);
        return sb.toString();
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @ArrayRes int i) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.f2443a = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.f2444b = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.f2445c = str6;
        this.f2446d = null;
        Preconditions.checkArgument(i != 0);
        this.f2447e = i;
        this.f2448f = str4 + "-" + str5 + "-" + str6;
    }
}
