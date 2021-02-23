package okhttp3;

import java.util.Collections;
import java.util.List;

public interface CookieJar {
    public static final CookieJar NO_COOKIES = new C3923a();

    /* renamed from: okhttp3.CookieJar$a */
    class C3923a implements CookieJar {
        C3923a() {
        }

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
