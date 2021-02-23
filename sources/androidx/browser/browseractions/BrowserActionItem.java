package androidx.browser.browseractions;

import android.app.PendingIntent;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class BrowserActionItem {

    /* renamed from: a */
    private final String f1771a;

    /* renamed from: b */
    private final PendingIntent f1772b;
    @DrawableRes

    /* renamed from: c */
    private final int f1773c;

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i) {
        this.f1771a = str;
        this.f1772b = pendingIntent;
        this.f1773c = i;
    }

    public PendingIntent getAction() {
        return this.f1772b;
    }

    public int getIconId() {
        return this.f1773c;
    }

    public String getTitle() {
        return this.f1771a;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
