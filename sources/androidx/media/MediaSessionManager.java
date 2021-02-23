package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.C0844e;
import androidx.media.C0846f;

public final class MediaSessionManager {

    /* renamed from: b */
    static final boolean f3752b = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: c */
    private static final Object f3753c = new Object();

    /* renamed from: d */
    private static volatile MediaSessionManager f3754d;

    /* renamed from: a */
    C0833a f3755a;

    /* renamed from: androidx.media.MediaSessionManager$a */
    interface C0833a {
        /* renamed from: a */
        boolean mo6535a(C0834b bVar);
    }

    /* renamed from: androidx.media.MediaSessionManager$b */
    interface C0834b {
        /* renamed from: a */
        int mo6536a();

        /* renamed from: b */
        int mo6537b();

        String getPackageName();
    }

    private MediaSessionManager(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f3755a = new C0844e(context);
        } else if (i >= 21) {
            this.f3755a = new C0843d(context);
        } else {
            this.f3755a = new C0846f(context);
        }
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = f3754d;
        if (mediaSessionManager == null) {
            synchronized (f3753c) {
                mediaSessionManager = f3754d;
                if (mediaSessionManager == null) {
                    f3754d = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = f3754d;
                }
            }
        }
        return mediaSessionManager;
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.f3755a.mo6535a(remoteUserInfo.f3756a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";

        /* renamed from: a */
        C0834b f3756a;

        public RemoteUserInfo(@NonNull String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f3756a = new C0844e.C0845a(str, i, i2);
            } else {
                this.f3756a = new C0846f.C0847a(str, i, i2);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.f3756a.equals(((RemoteUserInfo) obj).f3756a);
        }

        @NonNull
        public String getPackageName() {
            return this.f3756a.getPackageName();
        }

        public int getPid() {
            return this.f3756a.mo6537b();
        }

        public int getUid() {
            return this.f3756a.mo6536a();
        }

        public int hashCode() {
            return this.f3756a.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3756a = new C0844e.C0845a(remoteUserInfo);
        }
    }
}
