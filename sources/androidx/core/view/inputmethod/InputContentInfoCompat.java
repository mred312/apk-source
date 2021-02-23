package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class InputContentInfoCompat {

    /* renamed from: a */
    private final C0571c f2731a;

    /* renamed from: androidx.core.view.inputmethod.InputContentInfoCompat$b */
    private static final class C0570b implements C0571c {
        @NonNull

        /* renamed from: a */
        private final Uri f2733a;
        @NonNull

        /* renamed from: b */
        private final ClipDescription f2734b;
        @Nullable

        /* renamed from: c */
        private final Uri f2735c;

        C0570b(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f2733a = uri;
            this.f2734b = clipDescription;
            this.f2735c = uri2;
        }

        @NonNull
        /* renamed from: a */
        public Uri mo5035a() {
            return this.f2733a;
        }

        /* renamed from: b */
        public void mo5036b() {
        }

        @Nullable
        /* renamed from: c */
        public Uri mo5037c() {
            return this.f2735c;
        }

        @Nullable
        /* renamed from: d */
        public Object mo5038d() {
            return null;
        }

        /* renamed from: e */
        public void mo5039e() {
        }

        @NonNull
        public ClipDescription getDescription() {
            return this.f2734b;
        }
    }

    /* renamed from: androidx.core.view.inputmethod.InputContentInfoCompat$c */
    private interface C0571c {
        @NonNull
        /* renamed from: a */
        Uri mo5035a();

        /* renamed from: b */
        void mo5036b();

        @Nullable
        /* renamed from: c */
        Uri mo5037c();

        @Nullable
        /* renamed from: d */
        Object mo5038d();

        /* renamed from: e */
        void mo5039e();

        @NonNull
        ClipDescription getDescription();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f2731a = new C0569a(uri, clipDescription, uri2);
        } else {
            this.f2731a = new C0570b(uri, clipDescription, uri2);
        }
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new C0569a(obj));
        }
        return null;
    }

    @NonNull
    public Uri getContentUri() {
        return this.f2731a.mo5035a();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.f2731a.getDescription();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.f2731a.mo5037c();
    }

    public void releasePermission() {
        this.f2731a.mo5039e();
    }

    public void requestPermission() {
        this.f2731a.mo5036b();
    }

    @Nullable
    public Object unwrap() {
        return this.f2731a.mo5038d();
    }

    @RequiresApi(25)
    /* renamed from: androidx.core.view.inputmethod.InputContentInfoCompat$a */
    private static final class C0569a implements C0571c {
        @NonNull

        /* renamed from: a */
        final InputContentInfo f2732a;

        C0569a(@NonNull Object obj) {
            this.f2732a = (InputContentInfo) obj;
        }

        @NonNull
        /* renamed from: a */
        public Uri mo5035a() {
            return this.f2732a.getContentUri();
        }

        /* renamed from: b */
        public void mo5036b() {
            this.f2732a.requestPermission();
        }

        @Nullable
        /* renamed from: c */
        public Uri mo5037c() {
            return this.f2732a.getLinkUri();
        }

        @Nullable
        /* renamed from: d */
        public Object mo5038d() {
            return this.f2732a;
        }

        /* renamed from: e */
        public void mo5039e() {
            this.f2732a.releasePermission();
        }

        @NonNull
        public ClipDescription getDescription() {
            return this.f2732a.getDescription();
        }

        C0569a(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f2732a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(@NonNull C0571c cVar) {
        this.f2731a = cVar;
    }
}
