package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzb extends Fragment implements LifecycleFragment {

    /* renamed from: d */
    private static WeakHashMap<Activity, WeakReference<zzb>> f7488d = new WeakHashMap<>();

    /* renamed from: a */
    private Map<String, LifecycleCallback> f7489a = Collections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f7490b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Bundle f7491c;

    public static zzb zza(Activity activity) {
        zzb zzb;
        WeakReference weakReference = f7488d.get(activity);
        if (weakReference != null && (zzb = (zzb) weakReference.get()) != null) {
            return zzb;
        }
        try {
            zzb zzb2 = (zzb) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzb2 == null || zzb2.isRemoving()) {
                zzb2 = new zzb();
                activity.getFragmentManager().beginTransaction().add(zzb2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f7488d.put(activity, new WeakReference(zzb2));
            return zzb2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public final void addCallback(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.f7489a.containsKey(str)) {
            this.f7489a.put(str, lifecycleCallback);
            if (this.f7490b > 0) {
                new zzi(Looper.getMainLooper()).post(new C1661a(this, lifecycleCallback, str));
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
        for (LifecycleCallback dump : this.f7489a.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f7489a.get(str));
    }

    public final Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.f7490b > 0;
    }

    public final boolean isStarted() {
        return this.f7490b >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.f7489a.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7490b = 1;
        this.f7491c = bundle;
        for (Map.Entry next : this.f7489a.entrySet()) {
            ((LifecycleCallback) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f7490b = 5;
        for (LifecycleCallback onDestroy : this.f7489a.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f7490b = 3;
        for (LifecycleCallback onResume : this.f7489a.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f7489a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f7490b = 2;
        for (LifecycleCallback onStart : this.f7489a.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f7490b = 4;
        for (LifecycleCallback onStop : this.f7489a.values()) {
            onStop.onStop();
        }
    }
}
