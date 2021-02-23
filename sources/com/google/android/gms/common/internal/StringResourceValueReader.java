package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.C1659R;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.Nullable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class StringResourceValueReader {

    /* renamed from: a */
    private final Resources f7557a;

    /* renamed from: b */
    private final String f7558b;

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.f7557a = resources;
        this.f7558b = resources.getResourcePackageName(C1659R.string.common_google_play_services_unknown_issue);
    }

    @KeepForSdk
    @Nullable
    public String getString(String str) {
        int identifier = this.f7557a.getIdentifier(str, "string", this.f7558b);
        if (identifier == 0) {
            return null;
        }
        return this.f7557a.getString(identifier);
    }
}
