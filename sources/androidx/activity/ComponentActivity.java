package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller {

    /* renamed from: c */
    final ContextAwareHelper f267c;

    /* renamed from: d */
    private final LifecycleRegistry f268d;

    /* renamed from: e */
    final SavedStateRegistryController f269e;

    /* renamed from: f */
    private ViewModelStore f270f;

    /* renamed from: g */
    private ViewModelProvider.Factory f271g;

    /* renamed from: h */
    private final OnBackPressedDispatcher f272h;
    @LayoutRes

    /* renamed from: i */
    private int f273i;

    /* renamed from: j */
    private final AtomicInteger f274j;

    /* renamed from: k */
    private ActivityResultRegistry f275k;

    /* renamed from: androidx.activity.ComponentActivity$a */
    class C0112a implements Runnable {
        C0112a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$b */
    class C0113b extends ActivityResultRegistry {

        /* renamed from: androidx.activity.ComponentActivity$b$a */
        class C0114a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f280a;

            /* renamed from: b */
            final /* synthetic */ ActivityResultContract.SynchronousResult f281b;

            C0114a(int i, ActivityResultContract.SynchronousResult synchronousResult) {
                this.f280a = i;
                this.f281b = synchronousResult;
            }

            public void run() {
                C0113b.this.dispatchResult(this.f280a, this.f281b.getValue());
            }
        }

        /* renamed from: androidx.activity.ComponentActivity$b$b */
        class C0115b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f283a;

            /* renamed from: b */
            final /* synthetic */ IntentSender.SendIntentException f284b;

            C0115b(int i, IntentSender.SendIntentException sendIntentException) {
                this.f283a = i;
                this.f284b = sendIntentException;
            }

            public void run() {
                C0113b.this.dispatchResult(this.f283a, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, this.f284b));
            }
        }

        C0113b() {
        }

        public <I, O> void onLaunch(int i, @NonNull ActivityResultContract<I, O> activityResultContract, I i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            ComponentActivity componentActivity = ComponentActivity.this;
            ActivityResultContract.SynchronousResult<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i2);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new C0114a(i, synchronousResult));
                return;
            }
            Intent createIntent = activityResultContract.createIntent(componentActivity, i2);
            Bundle bundle = null;
            if (createIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
                bundle = createIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                createIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            } else if (activityOptionsCompat != null) {
                bundle = activityOptionsCompat.toBundle();
            }
            Bundle bundle2 = bundle;
            if (ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS.equals(createIntent.getAction())) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
                if (stringArrayExtra != null) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : stringArrayExtra) {
                        if (ComponentActivity.this.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                            arrayList.add(str);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ActivityCompat.requestPermissions(componentActivity, (String[]) arrayList.toArray(new String[0]), i);
                    }
                }
            } else if (ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST.equals(createIntent.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
                try {
                    ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle2);
                } catch (IntentSender.SendIntentException e) {
                    new Handler(Looper.getMainLooper()).post(new C0115b(i, e));
                }
            } else {
                ActivityCompat.startActivityForResult(componentActivity, createIntent, i, bundle2);
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$c */
    static final class C0116c {

        /* renamed from: a */
        Object f286a;

        /* renamed from: b */
        ViewModelStore f287b;

        C0116c() {
        }
    }

    public ComponentActivity() {
        this.f267c = new ContextAwareHelper();
        this.f268d = new LifecycleRegistry(this);
        this.f269e = SavedStateRegistryController.create(this);
        this.f272h = new OnBackPressedDispatcher(new C0112a());
        this.f274j = new AtomicInteger();
        this.f275k = new C0113b();
        if (getLifecycle() != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                getLifecycle().addObserver(new LifecycleEventObserver() {
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        if (event == Lifecycle.Event.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.f267c.clearAvailableContext();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().clear();
                        }
                    }
                }
            });
            if (19 <= i && i <= 23) {
                getLifecycle().addObserver(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    /* renamed from: b */
    private void m360b() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        m360b();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.f267c.addOnContextAvailableListener(onContextAvailableListener);
    }

    @NonNull
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.f275k;
    }

    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.f271g == null) {
                this.f271g = new SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.f271g;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    @Nullable
    public Object getLastCustomNonConfigurationInstance() {
        C0116c cVar = (C0116c) getLastNonConfigurationInstance();
        if (cVar != null) {
            return cVar.f286a;
        }
        return null;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.f268d;
    }

    @NonNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f272h;
    }

    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f269e.getSavedStateRegistry();
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            if (this.f270f == null) {
                C0116c cVar = (C0116c) getLastNonConfigurationInstance();
                if (cVar != null) {
                    this.f270f = cVar.f287b;
                }
                if (this.f270f == null) {
                    this.f270f = new ViewModelStore();
                }
            }
            return this.f270f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @Deprecated
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (!this.f275k.dispatchResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @MainThread
    public void onBackPressed() {
        this.f272h.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        this.f269e.performRestore(bundle);
        this.f267c.dispatchOnContextAvailable(this);
        super.onCreate(bundle);
        this.f275k.onRestoreInstanceState(bundle);
        ReportFragment.injectIfNeededIn(this);
        int i = this.f273i;
        if (i != 0) {
            setContentView(i);
        }
    }

    @CallSuper
    @Deprecated
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.f275k.dispatchResult(i, -1, new Intent().putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr).putExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS, iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Deprecated
    @Nullable
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        C0116c cVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.f270f;
        if (viewModelStore == null && (cVar = (C0116c) getLastNonConfigurationInstance()) != null) {
            viewModelStore = cVar.f287b;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C0116c cVar2 = new C0116c();
        cVar2.f286a = onRetainCustomNonConfigurationInstance;
        cVar2.f287b = viewModelStore;
        return cVar2;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f269e.performSave(bundle);
        this.f275k.onSaveInstanceState(bundle);
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.f267c.peekAvailableContext();
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.f274j.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.f267c.removeOnContextAvailableListener(onContextAvailableListener);
    }

    public void setContentView(@LayoutRes int i) {
        m360b();
        super.setContentView(i);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        m360b();
        super.setContentView(view);
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.f275k, activityResultCallback);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        m360b();
        super.setContentView(view, layoutParams);
    }

    @ContentView
    public ComponentActivity(@LayoutRes int i) {
        this();
        this.f273i = i;
    }
}
