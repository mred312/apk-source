package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {

    /* renamed from: l */
    final FragmentController f3070l = FragmentController.createController(new C0634c());

    /* renamed from: m */
    final LifecycleRegistry f3071m = new LifecycleRegistry(this);

    /* renamed from: n */
    boolean f3072n;

    /* renamed from: o */
    boolean f3073o;

    /* renamed from: p */
    boolean f3074p = true;

    /* renamed from: androidx.fragment.app.FragmentActivity$a */
    class C0632a implements SavedStateRegistry.SavedStateProvider {
        C0632a() {
        }

        @NonNull
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            FragmentActivity.this.mo5602e();
            FragmentActivity.this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            Parcelable saveAllState = FragmentActivity.this.f3070l.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable("android:support:fragments", saveAllState);
            }
            return bundle;
        }
    }

    /* renamed from: androidx.fragment.app.FragmentActivity$b */
    class C0633b implements OnContextAvailableListener {
        C0633b() {
        }

        public void onContextAvailable(@NonNull Context context) {
            FragmentActivity.this.f3070l.attachHost((Fragment) null);
            Bundle consumeRestoredStateForKey = FragmentActivity.this.getSavedStateRegistry().consumeRestoredStateForKey("android:support:fragments");
            if (consumeRestoredStateForKey != null) {
                FragmentActivity.this.f3070l.restoreSaveState(consumeRestoredStateForKey.getParcelable("android:support:fragments"));
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentActivity$c */
    class C0634c extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, FragmentOnAttachListener {
        public C0634c() {
            super(FragmentActivity.this);
        }

        /* renamed from: d */
        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        @NonNull
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @NonNull
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.f3071m;
        }

        @NonNull
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @NonNull
        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Nullable
        public View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @NonNull
        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    public FragmentActivity() {
        m2184d();
    }

    /* renamed from: d */
    private void m2184d() {
        getSavedStateRegistry().registerSavedStateProvider("android:support:fragments", new C0632a());
        addOnContextAvailableListener(new C0633b());
    }

    /* renamed from: f */
    private static boolean m2185f(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment next : fragmentManager.getFragments()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z |= m2185f(next.getChildFragmentManager(), state);
                }
                C0712l lVar = next.f3001T;
                if (lVar != null && lVar.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    next.f3001T.mo6138f(state);
                    z = true;
                }
                if (next.f3000S.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    next.f3000S.setCurrentState(state);
                    z = true;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public final View mo5600c(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f3070l.onCreateView(view, str, context, attributeSet);
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f3072n);
        printWriter.print(" mResumed=");
        printWriter.print(this.f3073o);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3074p);
        if (getApplication() != null) {
            LoaderManager.getInstance(this).dump(str2, fileDescriptor, printWriter, strArr);
        }
        this.f3070l.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5602e() {
        do {
        } while (m2185f(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.f3070l.getSupportFragmentManager();
    }

    @NonNull
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.f3070l.noteStateNotSaved();
        super.onActivityResult(i, i2, intent);
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3070l.noteStateNotSaved();
        this.f3070l.dispatchConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f3070l.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, @NonNull Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.f3070l.dispatchCreateOptionsMenu(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View c = mo5600c(view, str, context, attributeSet);
        return c == null ? super.onCreateView(view, str, context, attributeSet) : c;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f3070l.dispatchDestroy();
        this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f3070l.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, @NonNull MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.f3070l.dispatchOptionsItemSelected(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.f3070l.dispatchContextItemSelected(menuItem);
    }

    @CallSuper
    public void onMultiWindowModeChanged(boolean z) {
        this.f3070l.dispatchMultiWindowModeChanged(z);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f3070l.noteStateNotSaved();
    }

    public void onPanelClosed(int i, @NonNull Menu menu) {
        if (i == 0) {
            this.f3070l.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f3073o = false;
        this.f3070l.dispatchPause();
        this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @CallSuper
    public void onPictureInPictureModeChanged(boolean z) {
        this.f3070l.dispatchPictureInPictureModeChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onPrepareOptionsPanel(@Nullable View view, @NonNull Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, @Nullable View view, @NonNull Menu menu) {
        if (i == 0) {
            return onPrepareOptionsPanel(view, menu) | this.f3070l.dispatchPrepareOptionsMenu(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @CallSuper
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.f3070l.noteStateNotSaved();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f3073o = true;
        this.f3070l.noteStateNotSaved();
        this.f3070l.execPendingActions();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.f3070l.dispatchResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f3074p = false;
        if (!this.f3072n) {
            this.f3072n = true;
            this.f3070l.dispatchActivityCreated();
        }
        this.f3070l.noteStateNotSaved();
        this.f3070l.execPendingActions();
        this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.f3070l.dispatchStart();
    }

    public void onStateNotSaved() {
        this.f3070l.noteStateNotSaved();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f3074p = true;
        mo5602e();
        this.f3070l.dispatchStop();
        this.f3071m.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        if (i == -1) {
            ActivityCompat.startIntentSenderForResult(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public void startActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        if (i == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        View c = mo5600c((View) null, str, context, attributeSet);
        return c == null ? super.onCreateView(str, context, attributeSet) : c;
    }

    @ContentView
    public FragmentActivity(@LayoutRes int i) {
        super(i);
        m2184d();
    }
}
