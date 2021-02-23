package androidx.core.p003os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;

/* renamed from: androidx.core.os.MessageCompat */
public final class MessageCompat {

    /* renamed from: a */
    private static boolean f2422a = true;

    /* renamed from: b */
    private static boolean f2423b = true;

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            return message.isAsynchronous();
        }
        if (f2423b && i >= 16) {
            try {
                return message.isAsynchronous();
            } catch (NoSuchMethodError unused) {
                f2423b = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            message.setAsynchronous(z);
        } else if (f2422a && i >= 16) {
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError unused) {
                f2422a = false;
            }
        }
    }
}
