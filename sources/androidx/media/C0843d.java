package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.media.MediaSessionManager;

@RequiresApi(21)
/* renamed from: androidx.media.d */
/* compiled from: MediaSessionManagerImplApi21 */
class C0843d extends C0846f {
    C0843d(Context context) {
        super(context);
        this.f3778a = context;
    }

    /* renamed from: e */
    private boolean m2781e(@NonNull MediaSessionManager.C0834b bVar) {
        return mo6576b().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", bVar.mo6537b(), bVar.mo6536a()) == 0;
    }

    /* renamed from: a */
    public boolean mo6535a(@NonNull MediaSessionManager.C0834b bVar) {
        return m2781e(bVar) || super.mo6535a(bVar);
    }
}
