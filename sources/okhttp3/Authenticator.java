package okhttp3;

import javax.annotation.Nullable;

public interface Authenticator {
    public static final Authenticator NONE = new C3523a();

    /* renamed from: okhttp3.Authenticator$a */
    class C3523a implements Authenticator {
        C3523a() {
        }

        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    }

    @Nullable
    Request authenticate(@Nullable Route route, Response response);
}
