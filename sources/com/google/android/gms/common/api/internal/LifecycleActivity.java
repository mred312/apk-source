package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class LifecycleActivity {

    /* renamed from: a */
    private final Object f7481a;

    public LifecycleActivity(Activity activity) {
        this.f7481a = Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    @NonNull
    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.f7481a;
    }

    @NonNull
    @KeepForSdk
    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.f7481a;
    }

    @NonNull
    @KeepForSdk
    public Object asObject() {
        return this.f7481a;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.f7481a instanceof FragmentActivity;
    }

    public final boolean zza() {
        return this.f7481a instanceof Activity;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
