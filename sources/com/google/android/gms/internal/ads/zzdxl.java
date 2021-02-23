package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdxl implements FilenameFilter {

    /* renamed from: a */
    private final Pattern f16049a;

    public zzdxl(Pattern pattern) {
        this.f16049a = (Pattern) zzdvv.checkNotNull(pattern);
    }

    public final boolean accept(@NullableDecl File file, String str) {
        return this.f16049a.matcher(str).matches();
    }
}
