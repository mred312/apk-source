package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FragmentController {

    /* renamed from: a */
    private final FragmentHostCallback<?> f3081a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f3081a = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3081a;
        fragmentHostCallback.f3087e.mo5772j(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.f3081a.f3087e.mo5805w();
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        this.f3081a.f3087e.mo5807y(configuration);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        return this.f3081a.f3087e.mo5809z(menuItem);
    }

    public void dispatchCreate() {
        this.f3081a.f3087e.mo5703A();
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.f3081a.f3087e.mo5705B(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.f3081a.f3087e.mo5707C();
    }

    public void dispatchDestroyView() {
        this.f3081a.f3087e.mo5709D();
    }

    public void dispatchLowMemory() {
        this.f3081a.f3087e.mo5711E();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.f3081a.f3087e.mo5712F(z);
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        return this.f3081a.f3087e.mo5716H(menuItem);
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        this.f3081a.f3087e.mo5718I(menu);
    }

    public void dispatchPause() {
        this.f3081a.f3087e.mo5721K();
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.f3081a.f3087e.mo5723L(z);
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        return this.f3081a.f3087e.mo5724M(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.f3081a.f3087e.mo5727O();
    }

    public void dispatchStart() {
        this.f3081a.f3087e.mo5729P();
    }

    public void dispatchStop() {
        this.f3081a.f3087e.mo5731R();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.f3081a.f3087e.mo5738X(true);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.f3081a.f3087e.mo5751d0(str);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.f3081a.f3087e.mo5769i0();
    }

    public int getActiveFragmentsCount() {
        return this.f3081a.f3087e.mo5767h0();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.f3081a.f3087e;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.f3081a.f3087e.mo5720J0();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f3081a.f3087e.mo5778o0().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        this.f3081a.f3087e.mo5734T0(parcelable, new FragmentManagerNonConfig(list, (Map<String, FragmentManagerNonConfig>) null, (Map<String, ViewModelStore>) null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3081a;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            fragmentHostCallback.f3087e.mo5735U0(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Deprecated
    @Nullable
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Deprecated
    @Nullable
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.f3081a.f3087e.mo5737V0();
    }

    @Deprecated
    @Nullable
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig V0 = this.f3081a.f3087e.mo5737V0();
        if (V0 == null || V0.mo5855b() == null) {
            return null;
        }
        return new ArrayList(V0.mo5855b());
    }

    @Nullable
    public Parcelable saveAllState() {
        return this.f3081a.f3087e.mo5739X0();
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f3081a.f3087e.mo5734T0(parcelable, fragmentManagerNonConfig);
    }
}
