package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ActivityResultRegistry {

    /* renamed from: a */
    private final AtomicInteger f307a = new AtomicInteger(65536);

    /* renamed from: b */
    private final Map<Integer, String> f308b = new HashMap();

    /* renamed from: c */
    private final Map<String, Integer> f309c = new HashMap();

    /* renamed from: d */
    private final transient Map<String, C0127c<?>> f310d = new HashMap();

    /* renamed from: e */
    private final Bundle f311e = new Bundle();

    /* renamed from: androidx.activity.result.ActivityResultRegistry$a */
    class C0125a extends ActivityResultLauncher<I> {

        /* renamed from: a */
        final /* synthetic */ int f317a;

        /* renamed from: b */
        final /* synthetic */ ActivityResultContract f318b;

        /* renamed from: c */
        final /* synthetic */ String f319c;

        C0125a(int i, ActivityResultContract activityResultContract, String str) {
            this.f317a = i;
            this.f318b = activityResultContract;
            this.f319c = str;
        }

        @NonNull
        public ActivityResultContract<I, ?> getContract() {
            return this.f318b;
        }

        public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            ActivityResultRegistry.this.onLaunch(this.f317a, this.f318b, i, activityOptionsCompat);
        }

        public void unregister() {
            ActivityResultRegistry.this.mo704d(this.f319c);
        }
    }

    /* renamed from: androidx.activity.result.ActivityResultRegistry$b */
    class C0126b extends ActivityResultLauncher<I> {

        /* renamed from: a */
        final /* synthetic */ int f321a;

        /* renamed from: b */
        final /* synthetic */ ActivityResultContract f322b;

        /* renamed from: c */
        final /* synthetic */ String f323c;

        C0126b(int i, ActivityResultContract activityResultContract, String str) {
            this.f321a = i;
            this.f322b = activityResultContract;
            this.f323c = str;
        }

        @NonNull
        public ActivityResultContract<I, ?> getContract() {
            return this.f322b;
        }

        public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            ActivityResultRegistry.this.onLaunch(this.f321a, this.f322b, i, activityOptionsCompat);
        }

        public void unregister() {
            ActivityResultRegistry.this.mo704d(this.f323c);
        }
    }

    /* renamed from: androidx.activity.result.ActivityResultRegistry$c */
    private static class C0127c<O> {

        /* renamed from: a */
        final ActivityResultCallback<O> f325a;

        /* renamed from: b */
        final ActivityResultContract<?, O> f326b;

        C0127c(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.f325a = activityResultCallback;
            this.f326b = activityResultContract;
        }
    }

    /* renamed from: a */
    private void m367a(int i, String str) {
        this.f308b.put(Integer.valueOf(i), str);
        this.f309c.put(str, Integer.valueOf(i));
    }

    /* renamed from: b */
    private <O> void m368b(String str, int i, @Nullable Intent intent, @Nullable C0127c<O> cVar) {
        ActivityResultCallback<O> activityResultCallback;
        if (cVar == null || (activityResultCallback = cVar.f325a) == null) {
            this.f311e.putParcelable(str, new ActivityResult(i, intent));
        } else {
            activityResultCallback.onActivityResult(cVar.f326b.parseResult(i, intent));
        }
    }

    /* renamed from: c */
    private int m369c(String str) {
        Integer num = this.f309c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int andIncrement = this.f307a.getAndIncrement();
        m367a(andIncrement, str);
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    @MainThread
    /* renamed from: d */
    public final void mo704d(@NonNull String str) {
        Integer remove = this.f309c.remove(str);
        if (remove != null) {
            this.f308b.remove(remove);
        }
        this.f310d.remove(str);
        if (this.f311e.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f311e.getParcelable(str));
            this.f311e.remove(str);
        }
    }

    @MainThread
    public final boolean dispatchResult(int i, int i2, @Nullable Intent intent) {
        String str = this.f308b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        m368b(str, i2, intent, this.f310d.get(str));
        return true;
    }

    @MainThread
    public abstract <I, O> void onLaunch(int i, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i2, @Nullable ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@Nullable Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                int size = stringArrayList.size();
                for (int i = 0; i < size; i++) {
                    m367a(integerArrayList.get(i).intValue(), stringArrayList.get(i));
                }
                this.f307a.set(size);
                this.f311e.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f308b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f308b.values()));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", this.f311e);
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultCallback<O> activityResultCallback) {
        int c = m369c(str);
        this.f310d.put(str, new C0127c(activityResultCallback, activityResultContract));
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        final ActivityResult activityResult = (ActivityResult) this.f311e.getParcelable(str);
        if (activityResult != null) {
            this.f311e.remove(str);
            if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
            } else {
                lifecycle.addObserver(new LifecycleEventObserver(this) {
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        if (Lifecycle.Event.ON_START.equals(event)) {
                            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
                        }
                    }
                });
            }
        }
        lifecycle.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                    ActivityResultRegistry.this.mo704d(str);
                }
            }
        });
        return new C0125a(c, activityResultContract, str);
    }

    @MainThread
    public final <O> boolean dispatchResult(int i, @SuppressLint({"UnknownNullness"}) O o) {
        C0127c cVar;
        ActivityResultCallback<O> activityResultCallback;
        String str = this.f308b.get(Integer.valueOf(i));
        if (str == null || (cVar = this.f310d.get(str)) == null || (activityResultCallback = cVar.f325a) == null) {
            return false;
        }
        activityResultCallback.onActivityResult(o);
        return true;
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> register(@NonNull String str, @NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        int c = m369c(str);
        this.f310d.put(str, new C0127c(activityResultCallback, activityResultContract));
        ActivityResult activityResult = (ActivityResult) this.f311e.getParcelable(str);
        if (activityResult != null) {
            this.f311e.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new C0126b(c, activityResultContract, str);
    }
}
