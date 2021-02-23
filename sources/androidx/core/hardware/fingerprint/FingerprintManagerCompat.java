package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.p003os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public class FingerprintManagerCompat {

    /* renamed from: a */
    private final Context f2372a;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {

        /* renamed from: a */
        private final CryptoObject f2373a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f2373a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f2373a;
        }
    }

    /* renamed from: androidx.core.hardware.fingerprint.FingerprintManagerCompat$a */
    class C0466a extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a */
        final /* synthetic */ AuthenticationCallback f2377a;

        C0466a(AuthenticationCallback authenticationCallback) {
            this.f2377a = authenticationCallback;
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
            this.f2377a.onAuthenticationError(i, charSequence);
        }

        public void onAuthenticationFailed() {
            this.f2377a.onAuthenticationFailed();
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.f2377a.onAuthenticationHelp(i, charSequence);
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f2377a.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.m1596b(authenticationResult.getCryptoObject())));
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f2372a = context;
    }

    @RequiresApi(23)
    @Nullable
    /* renamed from: a */
    private static FingerprintManager m1595a(@NonNull Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    @RequiresApi(23)
    /* renamed from: b */
    static CryptoObject m1596b(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    @RequiresApi(23)
    /* renamed from: c */
    private static FingerprintManager.AuthenticationCallback m1597c(AuthenticationCallback authenticationCallback) {
        return new C0466a(authenticationCallback);
    }

    @RequiresApi(23)
    /* renamed from: d */
    private static FingerprintManager.CryptoObject m1598d(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        FingerprintManager a;
        if (Build.VERSION.SDK_INT >= 23 && (a = m1595a(this.f2372a)) != null) {
            a.authenticate(m1598d(cryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i, m1597c(authenticationCallback), handler);
        }
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager a;
        if (Build.VERSION.SDK_INT < 23 || (a = m1595a(this.f2372a)) == null || !a.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager a;
        if (Build.VERSION.SDK_INT < 23 || (a = m1595a(this.f2372a)) == null || !a.isHardwareDetected()) {
            return false;
        }
        return true;
    }

    public static class CryptoObject {

        /* renamed from: a */
        private final Signature f2374a;

        /* renamed from: b */
        private final Cipher f2375b;

        /* renamed from: c */
        private final Mac f2376c;

        public CryptoObject(@NonNull Signature signature) {
            this.f2374a = signature;
            this.f2375b = null;
            this.f2376c = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.f2375b;
        }

        @Nullable
        public Mac getMac() {
            return this.f2376c;
        }

        @Nullable
        public Signature getSignature() {
            return this.f2374a;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.f2375b = cipher;
            this.f2374a = null;
            this.f2376c = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.f2376c = mac;
            this.f2375b = null;
            this.f2374a = null;
        }
    }
}
