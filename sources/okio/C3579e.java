package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* renamed from: okio.e */
/* compiled from: SegmentPool */
final class C3579e {
    @Nullable

    /* renamed from: a */
    static C3578d f20220a;

    /* renamed from: b */
    static long f20221b;

    private C3579e() {
    }

    /* renamed from: a */
    static void m12094a(C3578d dVar) {
        if (dVar.f20218f != null || dVar.f20219g != null) {
            throw new IllegalArgumentException();
        } else if (!dVar.f20216d) {
            synchronized (C3579e.class) {
                long j = f20221b;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f20221b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    dVar.f20218f = f20220a;
                    dVar.f20215c = 0;
                    dVar.f20214b = 0;
                    f20220a = dVar;
                }
            }
        }
    }

    /* renamed from: b */
    static C3578d m12095b() {
        synchronized (C3579e.class) {
            C3578d dVar = f20220a;
            if (dVar == null) {
                return new C3578d();
            }
            f20220a = dVar.f20218f;
            dVar.f20218f = null;
            f20221b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return dVar;
        }
    }
}
