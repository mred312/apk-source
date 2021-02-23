package android.support.p000v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* renamed from: android.support.v4.media.e */
/* compiled from: MediaDescriptionCompatApi23 */
class C0052e {

    /* renamed from: android.support.v4.media.e$a */
    /* compiled from: MediaDescriptionCompatApi23 */
    static class C0053a {
        /* renamed from: a */
        public static void m135a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    /* renamed from: a */
    public static Uri m134a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
