package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {

        /* renamed from: b */
        private static EditorCompat f2262b;

        /* renamed from: a */
        private final C0442a f2263a = new C0442a();

        /* renamed from: androidx.core.content.SharedPreferencesCompat$EditorCompat$a */
        private static class C0442a {
            C0442a() {
            }

            /* renamed from: a */
            public void mo4087a(@NonNull SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (f2262b == null) {
                f2262b = new EditorCompat();
            }
            return f2262b;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.f2263a.mo4087a(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
