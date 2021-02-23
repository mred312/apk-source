package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

@RequiresApi(28)
/* renamed from: androidx.media.e */
/* compiled from: MediaSessionManagerImplApi28 */
class C0844e extends C0843d {

    /* renamed from: d */
    MediaSessionManager f3775d;

    C0844e(Context context) {
        super(context);
        this.f3775d = (MediaSessionManager) context.getSystemService("media_session");
    }

    /* renamed from: a */
    public boolean mo6535a(MediaSessionManager.C0834b bVar) {
        if (bVar instanceof C0845a) {
            return this.f3775d.isTrustedForMediaControl(((C0845a) bVar).f3776a);
        }
        return false;
    }

    /* renamed from: androidx.media.e$a */
    /* compiled from: MediaSessionManagerImplApi28 */
    static final class C0845a implements MediaSessionManager.C0834b {

        /* renamed from: a */
        final MediaSessionManager.RemoteUserInfo f3776a;

        C0845a(String str, int i, int i2) {
            this.f3776a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        /* renamed from: a */
        public int mo6536a() {
            return this.f3776a.getUid();
        }

        /* renamed from: b */
        public int mo6537b() {
            return this.f3776a.getPid();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0845a)) {
                return false;
            }
            return this.f3776a.equals(((C0845a) obj).f3776a);
        }

        public String getPackageName() {
            return this.f3776a.getPackageName();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f3776a);
        }

        C0845a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3776a = remoteUserInfo;
        }
    }
}
