package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzduy {

    /* renamed from: a */
    private static final ClipData f15993a = ClipData.newIntent("", new Intent());

    /* renamed from: a */
    private static boolean m8524a(int i, int i2) {
        return (i & i2) == i2;
    }

    @Nullable
    public static PendingIntent getService(Context context, int i, Intent intent, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        boolean z = true;
        zzdvv.checkArgument((i2 & 95) == 0, "Cannot set any dangerous parts of intent to be mutable.");
        zzdvv.checkArgument(intent.getComponent() != null, "Must set component on Intent.");
        if (m8524a(0, 1)) {
            zzdvv.checkArgument(!m8524a(i2, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            if (i3 >= 23 && !m8524a(i2, 67108864)) {
                z = false;
            }
            zzdvv.checkArgument(z, "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (i3 < 23 || !m8524a(i2, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!m8524a(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!m8524a(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!m8524a(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!m8524a(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(f15993a);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i2);
    }
}
