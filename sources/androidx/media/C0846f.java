package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* renamed from: androidx.media.f */
/* compiled from: MediaSessionManagerImplBase */
class C0846f implements MediaSessionManager.C0833a {

    /* renamed from: c */
    private static final boolean f3777c = MediaSessionManager.f3752b;

    /* renamed from: a */
    Context f3778a;

    /* renamed from: b */
    ContentResolver f3779b;

    /* renamed from: androidx.media.f$a */
    /* compiled from: MediaSessionManagerImplBase */
    static class C0847a implements MediaSessionManager.C0834b {

        /* renamed from: a */
        private String f3780a;

        /* renamed from: b */
        private int f3781b;

        /* renamed from: c */
        private int f3782c;

        C0847a(String str, int i, int i2) {
            this.f3780a = str;
            this.f3781b = i;
            this.f3782c = i2;
        }

        /* renamed from: a */
        public int mo6536a() {
            return this.f3782c;
        }

        /* renamed from: b */
        public int mo6537b() {
            return this.f3781b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0847a)) {
                return false;
            }
            C0847a aVar = (C0847a) obj;
            if (TextUtils.equals(this.f3780a, aVar.f3780a) && this.f3781b == aVar.f3781b && this.f3782c == aVar.f3782c) {
                return true;
            }
            return false;
        }

        public String getPackageName() {
            return this.f3780a;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f3780a, Integer.valueOf(this.f3781b), Integer.valueOf(this.f3782c));
        }
    }

    C0846f(Context context) {
        this.f3778a = context;
        this.f3779b = context.getContentResolver();
    }

    /* renamed from: d */
    private boolean m2786d(MediaSessionManager.C0834b bVar, String str) {
        if (bVar.mo6537b() < 0) {
            if (this.f3778a.getPackageManager().checkPermission(str, bVar.getPackageName()) == 0) {
                return true;
            }
            return false;
        } else if (this.f3778a.checkPermission(str, bVar.mo6537b(), bVar.mo6536a()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo6535a(@NonNull MediaSessionManager.C0834b bVar) {
        try {
            if (this.f3778a.getPackageManager().getApplicationInfo(bVar.getPackageName(), 0).uid != bVar.mo6536a()) {
                if (f3777c) {
                    Log.d("MediaSessionManager", "Package name " + bVar.getPackageName() + " doesn't match with the uid " + bVar.mo6536a());
                }
                return false;
            } else if (m2786d(bVar, "android.permission.STATUS_BAR_SERVICE") || m2786d(bVar, "android.permission.MEDIA_CONTENT_CONTROL") || bVar.mo6536a() == 1000 || mo6577c(bVar)) {
                return true;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (f3777c) {
                Log.d("MediaSessionManager", "Package " + bVar.getPackageName() + " doesn't exist");
            }
            return false;
        }
    }

    /* renamed from: b */
    public Context mo6576b() {
        return this.f3778a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6577c(@NonNull MediaSessionManager.C0834b bVar) {
        String string = Settings.Secure.getString(this.f3779b, "enabled_notification_listeners");
        if (string != null) {
            String[] split = string.split(":");
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null && unflattenFromString2.getPackageName().equals(bVar.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
