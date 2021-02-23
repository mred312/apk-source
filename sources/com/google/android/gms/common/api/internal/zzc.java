package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzc extends Fragment implements LifecycleFragment {

    /* renamed from: e0 */
    private static WeakHashMap<FragmentActivity, WeakReference<zzc>> f7492e0 = new WeakHashMap<>();

    /* renamed from: b0 */
    private Map<String, LifecycleCallback> f7493b0 = Collections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */

    /* renamed from: c0 */
    public int f7494c0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: d0 */
    public Bundle f7495d0;

    public static zzc zza(FragmentActivity fragmentActivity) {
        zzc zzc;
        WeakReference weakReference = f7492e0.get(fragmentActivity);
        if (weakReference != null && (zzc = (zzc) weakReference.get()) != null) {
            return zzc;
        }
        try {
            zzc zzc2 = (zzc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzc2 == null || zzc2.isRemoving()) {
                zzc2 = new zzc();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzc2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f7492e0.put(fragmentActivity, new WeakReference(zzc2));
            return zzc2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final void addCallback(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.f7493b0.containsKey(str)) {
            this.f7493b0.put(str, lifecycleCallback);
            if (this.f7494c0 > 0) {
                new zzi(Looper.getMainLooper()).post(new C1662b(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.f7493b0.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f7493b0.get(str));
    }

    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.f7494c0 > 0;
    }

    public final boolean isStarted() {
        return this.f7494c0 >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.f7493b0.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7494c0 = 1;
        this.f7495d0 = bundle;
        for (Map.Entry next : this.f7493b0.entrySet()) {
            ((LifecycleCallback) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f7494c0 = 5;
        for (LifecycleCallback onDestroy : this.f7493b0.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f7494c0 = 3;
        for (LifecycleCallback onResume : this.f7493b0.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f7493b0.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f7494c0 = 2;
        for (LifecycleCallback onStart : this.f7493b0.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f7494c0 = 4;
        for (LifecycleCallback onStop : this.f7493b0.values()) {
            onStop.onStop();
        }
    }
}
