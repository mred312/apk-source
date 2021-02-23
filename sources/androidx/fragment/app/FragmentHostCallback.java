package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
    @Nullable

    /* renamed from: a */
    private final Activity f3083a;
    @NonNull

    /* renamed from: b */
    private final Context f3084b;
    @NonNull

    /* renamed from: c */
    private final Handler f3085c;

    /* renamed from: d */
    private final int f3086d;

    /* renamed from: e */
    final FragmentManager f3087e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(@NonNull Context context, @NonNull Handler handler, int i) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Activity mo5696a() {
        return this.f3083a;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public Context mo5697b() {
        return this.f3084b;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public Handler mo5698c() {
        return this.f3085c;
    }

    public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    @Nullable
    public View onFindViewById(int i) {
        return null;
    }

    @Nullable
    public abstract E onGetHost();

    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.f3084b);
    }

    public int onGetWindowAnimations() {
        return this.f3086d;
    }

    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    @Deprecated
    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
    }

    public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        return false;
    }

    public void onStartActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        onStartActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Deprecated
    public void onStartIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        if (i == -1) {
            ActivityCompat.startIntentSenderForResult(this.f3083a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    FragmentHostCallback(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public void onStartActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        if (i == -1) {
            ContextCompat.startActivity(this.f3084b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    FragmentHostCallback(@Nullable Activity activity, @NonNull Context context, @NonNull Handler handler, int i) {
        this.f3087e = new C0690f();
        this.f3083a = activity;
        this.f3084b = (Context) Preconditions.checkNotNull(context, "context == null");
        this.f3085c = (Handler) Preconditions.checkNotNull(handler, "handler == null");
        this.f3086d = i;
    }
}
