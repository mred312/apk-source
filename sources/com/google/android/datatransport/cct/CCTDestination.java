package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class CCTDestination implements EncodedDestination {
    public static final CCTDestination INSTANCE;
    public static final CCTDestination LEGACY_INSTANCE;

    /* renamed from: c */
    static final String f7079c;

    /* renamed from: d */
    static final String f7080d;

    /* renamed from: e */
    private static final String f7081e;

    /* renamed from: f */
    private static final Set<Encoding> f7082f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding[]{Encoding.m5015of("proto"), Encoding.m5015of("json")})));
    @NonNull

    /* renamed from: a */
    private final String f7083a;
    @Nullable

    /* renamed from: b */
    private final String f7084b;

    static {
        String a = zzd.m5031a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f7079c = a;
        String a2 = zzd.m5031a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f7080d = a2;
        String a3 = zzd.m5031a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f7081e = a3;
        INSTANCE = new CCTDestination(a, (String) null);
        LEGACY_INSTANCE = new CCTDestination(a2, a3);
    }

    public CCTDestination(@NonNull String str, @Nullable String str2) {
        this.f7083a = str;
        this.f7084b = str2;
    }

    @NonNull
    public static CCTDestination fromByteArray(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName(Key.STRING_CHARSET_NAME));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new CCTDestination(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Nullable
    public byte[] asByteArray() {
        String str = this.f7084b;
        if (str == null && this.f7083a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f7083a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
    }

    @Nullable
    public String getAPIKey() {
        return this.f7084b;
    }

    @NonNull
    public String getEndPoint() {
        return this.f7083a;
    }

    @Nullable
    public byte[] getExtras() {
        return asByteArray();
    }

    @NonNull
    public String getName() {
        return "cct";
    }

    public Set<Encoding> getSupportedEncodings() {
        return f7082f;
    }
}
