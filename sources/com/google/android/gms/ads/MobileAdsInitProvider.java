package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.internal.ads.zzzj;

@KeepForSdkWithMembers
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzzj zzadk = new zzzj();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzadk.attachInfo(context, providerInfo);
    }

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return this.zzadk.delete(uri, str, strArr);
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return this.zzadk.getType(uri);
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return this.zzadk.insert(uri, contentValues);
    }

    public boolean onCreate() {
        return this.zzadk.onCreate();
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzadk.query(uri, strArr, str, strArr2, str2);
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzadk.update(uri, contentValues, str, strArr);
    }
}
