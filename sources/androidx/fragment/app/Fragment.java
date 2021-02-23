package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ActivityResultCaller {

    /* renamed from: a0 */
    static final Object f2981a0 = new Object();

    /* renamed from: A */
    boolean f2982A;

    /* renamed from: B */
    boolean f2983B;

    /* renamed from: C */
    boolean f2984C;

    /* renamed from: D */
    boolean f2985D;

    /* renamed from: E */
    boolean f2986E;

    /* renamed from: F */
    private boolean f2987F;

    /* renamed from: G */
    ViewGroup f2988G;

    /* renamed from: H */
    View f2989H;

    /* renamed from: I */
    boolean f2990I;

    /* renamed from: J */
    boolean f2991J;

    /* renamed from: K */
    C0629i f2992K;

    /* renamed from: L */
    Runnable f2993L;

    /* renamed from: M */
    boolean f2994M;

    /* renamed from: N */
    boolean f2995N;

    /* renamed from: O */
    float f2996O;

    /* renamed from: P */
    LayoutInflater f2997P;

    /* renamed from: Q */
    boolean f2998Q;

    /* renamed from: R */
    Lifecycle.State f2999R;

    /* renamed from: S */
    LifecycleRegistry f3000S;
    @Nullable

    /* renamed from: T */
    C0712l f3001T;

    /* renamed from: U */
    MutableLiveData<LifecycleOwner> f3002U;

    /* renamed from: V */
    private ViewModelProvider.Factory f3003V;

    /* renamed from: W */
    SavedStateRegistryController f3004W;
    @LayoutRes

    /* renamed from: X */
    private int f3005X;

    /* renamed from: Y */
    private final AtomicInteger f3006Y;

    /* renamed from: Z */
    private final ArrayList<C0630j> f3007Z;

    /* renamed from: a */
    int f3008a;

    /* renamed from: b */
    Bundle f3009b;

    /* renamed from: c */
    SparseArray<Parcelable> f3010c;

    /* renamed from: d */
    Bundle f3011d;
    @Nullable

    /* renamed from: e */
    Boolean f3012e;
    @NonNull

    /* renamed from: f */
    String f3013f;

    /* renamed from: g */
    Bundle f3014g;

    /* renamed from: h */
    Fragment f3015h;

    /* renamed from: i */
    String f3016i;

    /* renamed from: j */
    int f3017j;

    /* renamed from: k */
    private Boolean f3018k;

    /* renamed from: l */
    boolean f3019l;

    /* renamed from: m */
    boolean f3020m;

    /* renamed from: n */
    boolean f3021n;

    /* renamed from: o */
    boolean f3022o;

    /* renamed from: p */
    boolean f3023p;

    /* renamed from: q */
    boolean f3024q;

    /* renamed from: r */
    int f3025r;

    /* renamed from: s */
    FragmentManager f3026s;

    /* renamed from: t */
    FragmentHostCallback<?> f3027t;
    @NonNull

    /* renamed from: u */
    FragmentManager f3028u;

    /* renamed from: v */
    Fragment f3029v;

    /* renamed from: w */
    int f3030w;

    /* renamed from: x */
    int f3031x;

    /* renamed from: y */
    String f3032y;

    /* renamed from: z */
    boolean f3033z;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(@NonNull String str, @Nullable Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$a */
    class C0621a implements Runnable {
        C0621a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$b */
    class C0622b implements Runnable {
        C0622b() {
        }

        public void run() {
            Fragment.this.mo5444a(false);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$c */
    class C0623c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0714n f3038a;

        C0623c(Fragment fragment, C0714n nVar) {
            this.f3038a = nVar;
        }

        public void run() {
            this.f3038a.mo6146g();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$d */
    class C0624d extends FragmentContainer {
        C0624d() {
        }

        @Nullable
        public View onFindViewById(int i) {
            View view = Fragment.this.f2989H;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        public boolean onHasView() {
            return Fragment.this.f2989H != null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$e */
    class C0625e implements Function<Void, ActivityResultRegistry> {
        C0625e() {
        }

        /* renamed from: a */
        public ActivityResultRegistry apply(Void voidR) {
            Fragment fragment = Fragment.this;
            FragmentHostCallback<?> fragmentHostCallback = fragment.f3027t;
            if (fragmentHostCallback instanceof ActivityResultRegistryOwner) {
                return ((ActivityResultRegistryOwner) fragmentHostCallback).getActivityResultRegistry();
            }
            return fragment.requireActivity().getActivityResultRegistry();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$f */
    class C0626f implements Function<Void, ActivityResultRegistry> {

        /* renamed from: a */
        final /* synthetic */ ActivityResultRegistry f3041a;

        C0626f(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
            this.f3041a = activityResultRegistry;
        }

        /* renamed from: a */
        public ActivityResultRegistry apply(Void voidR) {
            return this.f3041a;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$g */
    class C0627g extends C0630j {

        /* renamed from: a */
        final /* synthetic */ Function f3042a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f3043b;

        /* renamed from: c */
        final /* synthetic */ ActivityResultContract f3044c;

        /* renamed from: d */
        final /* synthetic */ ActivityResultCallback f3045d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0627g(Function function, AtomicReference atomicReference, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
            super((C0621a) null);
            this.f3042a = function;
            this.f3043b = atomicReference;
            this.f3044c = activityResultContract;
            this.f3045d = activityResultCallback;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5597a() {
            this.f3043b.set(((ActivityResultRegistry) this.f3042a.apply(null)).register(Fragment.this.mo5451e(), Fragment.this, this.f3044c, this.f3045d));
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$h */
    class C0628h extends ActivityResultLauncher<I> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f3047a;

        /* renamed from: b */
        final /* synthetic */ ActivityResultContract f3048b;

        C0628h(Fragment fragment, AtomicReference atomicReference, ActivityResultContract activityResultContract) {
            this.f3047a = atomicReference;
            this.f3048b = activityResultContract;
        }

        @NonNull
        public ActivityResultContract<I, ?> getContract() {
            return this.f3048b;
        }

        public void launch(I i, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f3047a.get();
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(i, activityOptionsCompat);
                return;
            }
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }

        public void unregister() {
            ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) this.f3047a.getAndSet((Object) null);
            if (activityResultLauncher != null) {
                activityResultLauncher.unregister();
            }
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$i */
    static class C0629i {

        /* renamed from: a */
        View f3049a;

        /* renamed from: b */
        Animator f3050b;

        /* renamed from: c */
        int f3051c;

        /* renamed from: d */
        int f3052d;

        /* renamed from: e */
        ArrayList<String> f3053e;

        /* renamed from: f */
        ArrayList<String> f3054f;

        /* renamed from: g */
        Object f3055g = null;

        /* renamed from: h */
        Object f3056h;

        /* renamed from: i */
        Object f3057i;

        /* renamed from: j */
        Object f3058j;

        /* renamed from: k */
        Object f3059k;

        /* renamed from: l */
        Object f3060l;

        /* renamed from: m */
        Boolean f3061m;

        /* renamed from: n */
        Boolean f3062n;

        /* renamed from: o */
        SharedElementCallback f3063o;

        /* renamed from: p */
        SharedElementCallback f3064p;

        /* renamed from: q */
        int f3065q;

        /* renamed from: r */
        View f3066r;

        /* renamed from: s */
        boolean f3067s;

        /* renamed from: t */
        C0631k f3068t;

        /* renamed from: u */
        boolean f3069u;

        C0629i() {
            Object obj = Fragment.f2981a0;
            this.f3056h = obj;
            this.f3057i = null;
            this.f3058j = obj;
            this.f3059k = null;
            this.f3060l = obj;
            this.f3063o = null;
            this.f3064p = null;
            this.f3065q = 0;
            this.f3066r = null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$j */
    private static abstract class C0630j {
        private C0630j() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo5597a();

        /* synthetic */ C0630j(C0621a aVar) {
            this();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$k */
    interface C0631k {
        /* renamed from: a */
        void mo5598a();

        /* renamed from: b */
        void mo5599b();
    }

    public Fragment() {
        this.f3008a = -1;
        this.f3013f = UUID.randomUUID().toString();
        this.f3016i = null;
        this.f3018k = null;
        this.f3028u = new C0690f();
        this.f2986E = true;
        this.f2991J = true;
        this.f2993L = new C0621a();
        this.f2999R = Lifecycle.State.RESUMED;
        this.f3002U = new MutableLiveData<>();
        this.f3006Y = new AtomicInteger();
        this.f3007Z = new ArrayList<>();
        m2119p();
    }

    @NonNull
    /* renamed from: U */
    private <I, O> ActivityResultLauncher<I> m2115U(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull Function<Void, ActivityResultRegistry> function, @NonNull ActivityResultCallback<O> activityResultCallback) {
        if (this.f3008a <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            m2116V(new C0627g(function, atomicReference, activityResultContract, activityResultCallback));
            return new C0628h(this, atomicReference, activityResultContract);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    /* renamed from: V */
    private void m2116V(@NonNull C0630j jVar) {
        if (this.f3008a >= 0) {
            jVar.mo5597a();
        } else {
            this.f3007Z.add(jVar);
        }
    }

    /* renamed from: X */
    private void m2117X() {
        if (FragmentManager.m2230w0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f2989H != null) {
            mo5442Y(this.f3009b);
        }
        this.f3009b = null;
    }

    /* renamed from: c */
    private C0629i m2118c() {
        if (this.f2992K == null) {
            this.f2992K = new C0629i();
        }
        return this.f2992K;
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str) {
        return instantiate(context, str, (Bundle) null);
    }

    /* renamed from: p */
    private void m2119p() {
        this.f3000S = new LifecycleRegistry(this);
        this.f3004W = SavedStateRegistryController.create(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo5422A(Bundle bundle) {
        this.f3028u.mo5720J0();
        this.f3008a = 1;
        this.f2987F = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3000S.addObserver(new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP && (view = Fragment.this.f2989H) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
        }
        this.f3004W.performRestore(bundle);
        onCreate(bundle);
        this.f2998Q = true;
        if (this.f2987F) {
            this.f3000S.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new C0725p("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public boolean mo5423B(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        boolean z = false;
        if (this.f3033z) {
            return false;
        }
        if (this.f2985D && this.f2986E) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.f3028u.mo5705B(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public void mo5387C(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f3028u.mo5720J0();
        this.f3024q = true;
        this.f3001T = new C0712l();
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.f2989H = onCreateView;
        if (onCreateView != null) {
            this.f3001T.mo6134b();
            ViewTreeLifecycleOwner.set(this.f2989H, this.f3001T);
            ViewTreeViewModelStoreOwner.set(this.f2989H, this);
            ViewTreeSavedStateRegistryOwner.set(this.f2989H, this.f3001T);
            this.f3002U.setValue(this.f3001T);
        } else if (!this.f3001T.mo6135c()) {
            this.f3001T = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public void mo5424D() {
        this.f3028u.mo5707C();
        this.f3000S.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f3008a = 0;
        this.f2987F = false;
        this.f2998Q = false;
        onDestroy();
        if (!this.f2987F) {
            throw new C0725p("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo5425E() {
        this.f3028u.mo5709D();
        if (this.f2989H != null) {
            this.f3001T.mo6133a(Lifecycle.Event.ON_DESTROY);
        }
        this.f3008a = 1;
        this.f2987F = false;
        onDestroyView();
        if (this.f2987F) {
            LoaderManager.getInstance(this).markForRedelivery();
            this.f3024q = false;
            return;
        }
        throw new C0725p("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void mo5426F() {
        this.f3008a = -1;
        this.f2987F = false;
        onDetach();
        this.f2997P = null;
        if (!this.f2987F) {
            throw new C0725p("Fragment " + this + " did not call through to super.onDetach()");
        } else if (!this.f3028u.isDestroyed()) {
            this.f3028u.mo5707C();
            this.f3028u = new C0690f();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: G */
    public LayoutInflater mo5427G(@Nullable Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.f2997P = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public void mo5428H() {
        onLowMemory();
        this.f3028u.mo5711E();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo5429I(boolean z) {
        onMultiWindowModeChanged(z);
        this.f3028u.mo5712F(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public boolean mo5430J(@NonNull MenuItem menuItem) {
        if (this.f3033z) {
            return false;
        }
        if (!this.f2985D || !this.f2986E || !onOptionsItemSelected(menuItem)) {
            return this.f3028u.mo5716H(menuItem);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public void mo5431K(@NonNull Menu menu) {
        if (!this.f3033z) {
            if (this.f2985D && this.f2986E) {
                onOptionsMenuClosed(menu);
            }
            this.f3028u.mo5718I(menu);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public void mo5432L() {
        this.f3028u.mo5721K();
        if (this.f2989H != null) {
            this.f3001T.mo6133a(Lifecycle.Event.ON_PAUSE);
        }
        this.f3000S.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.f3008a = 6;
        this.f2987F = false;
        onPause();
        if (!this.f2987F) {
            throw new C0725p("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public void mo5433M(boolean z) {
        onPictureInPictureModeChanged(z);
        this.f3028u.mo5723L(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public boolean mo5434N(@NonNull Menu menu) {
        boolean z = false;
        if (this.f3033z) {
            return false;
        }
        if (this.f2985D && this.f2986E) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.f3028u.mo5724M(menu);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public void mo5435O() {
        boolean z0 = this.f3026s.mo5810z0(this);
        Boolean bool = this.f3018k;
        if (bool == null || bool.booleanValue() != z0) {
            this.f3018k = Boolean.valueOf(z0);
            onPrimaryNavigationFragmentChanged(z0);
            this.f3028u.mo5726N();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public void mo5436P() {
        this.f3028u.mo5720J0();
        this.f3028u.mo5738X(true);
        this.f3008a = 7;
        this.f2987F = false;
        onResume();
        if (this.f2987F) {
            LifecycleRegistry lifecycleRegistry = this.f3000S;
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            lifecycleRegistry.handleLifecycleEvent(event);
            if (this.f2989H != null) {
                this.f3001T.mo6133a(event);
            }
            this.f3028u.mo5727O();
            return;
        }
        throw new C0725p("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Q */
    public void mo5437Q(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.f3004W.performSave(bundle);
        Parcelable X0 = this.f3028u.mo5739X0();
        if (X0 != null) {
            bundle.putParcelable("android:support:fragments", X0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: R */
    public void mo5438R() {
        this.f3028u.mo5720J0();
        this.f3028u.mo5738X(true);
        this.f3008a = 5;
        this.f2987F = false;
        onStart();
        if (this.f2987F) {
            LifecycleRegistry lifecycleRegistry = this.f3000S;
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            lifecycleRegistry.handleLifecycleEvent(event);
            if (this.f2989H != null) {
                this.f3001T.mo6133a(event);
            }
            this.f3028u.mo5729P();
            return;
        }
        throw new C0725p("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: S */
    public void mo5439S() {
        this.f3028u.mo5731R();
        if (this.f2989H != null) {
            this.f3001T.mo6133a(Lifecycle.Event.ON_STOP);
        }
        this.f3000S.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.f3008a = 4;
        this.f2987F = false;
        onStop();
        if (!this.f2987F) {
            throw new C0725p("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: T */
    public void mo5440T() {
        onViewCreated(this.f2989H, this.f3009b);
        this.f3028u.mo5733S();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: W */
    public void mo5441W(@Nullable Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.f3028u.mo5735U0(parcelable);
            this.f3028u.mo5703A();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y */
    public final void mo5442Y(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f3010c;
        if (sparseArray != null) {
            this.f2989H.restoreHierarchyState(sparseArray);
            this.f3010c = null;
        }
        if (this.f2989H != null) {
            this.f3001T.mo6136d(this.f3011d);
            this.f3011d = null;
        }
        this.f2987F = false;
        onViewStateRestored(bundle);
        if (!this.f2987F) {
            throw new C0725p("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.f2989H != null) {
            this.f3001T.mo6133a(Lifecycle.Event.ON_CREATE);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Z */
    public void mo5443Z(View view) {
        m2118c().f3049a = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5444a(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        C0629i iVar = this.f2992K;
        C0631k kVar = null;
        if (iVar != null) {
            iVar.f3067s = false;
            C0631k kVar2 = iVar.f3068t;
            iVar.f3068t = null;
            kVar = kVar2;
        }
        if (kVar != null) {
            kVar.mo5599b();
        } else if (FragmentManager.f3089P && this.f2989H != null && (viewGroup = this.f2988G) != null && (fragmentManager = this.f3026s) != null) {
            C0714n l = C0714n.m2508l(viewGroup, fragmentManager);
            l.mo6151n();
            if (z) {
                this.f3027t.mo5698c().post(new C0623c(this, l));
            } else {
                l.mo6146g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a0 */
    public void mo5445a0(Animator animator) {
        m2118c().f3050b = animator;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public FragmentContainer mo5388b() {
        return new C0624d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b0 */
    public void mo5446b0(View view) {
        m2118c().f3066r = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c0 */
    public void mo5447c0(boolean z) {
        m2118c().f3069u = z;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: d */
    public Fragment mo5448d(@NonNull String str) {
        if (str.equals(this.f3013f)) {
            return this;
        }
        return this.f3028u.mo5751d0(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public void mo5449d0(int i) {
        if (this.f2992K != null || i != 0) {
            m2118c().f3051c = i;
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f3030w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f3031x));
        printWriter.print(" mTag=");
        printWriter.println(this.f3032y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f3008a);
        printWriter.print(" mWho=");
        printWriter.print(this.f3013f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f3025r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f3019l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f3020m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f3021n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f3022o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f3033z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f2982A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f2986E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f2985D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f2983B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f2991J);
        if (this.f3026s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f3026s);
        }
        if (this.f3027t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f3027t);
        }
        if (this.f3029v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f3029v);
        }
        if (this.f3014g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f3014g);
        }
        if (this.f3009b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f3009b);
        }
        if (this.f3010c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f3010c);
        }
        if (this.f3011d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f3011d);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f3017j);
        }
        if (mo5505k() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(mo5505k());
        }
        if (this.f2988G != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f2988G);
        }
        if (this.f2989H != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f2989H);
        }
        if (mo5454f() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(mo5454f());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f3028u + ":");
        FragmentManager fragmentManager = this.f3028u;
        fragmentManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: e */
    public String mo5451e() {
        return "fragment_" + this.f3013f + "_rq#" + this.f3006Y.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e0 */
    public void mo5452e0(int i) {
        if (this.f2992K != null || i != 0) {
            m2118c();
            this.f2992K.f3052d = i;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public View mo5454f() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3049a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f0 */
    public void mo5455f0(C0631k kVar) {
        m2118c();
        C0629i iVar = this.f2992K;
        C0631k kVar2 = iVar.f3068t;
        if (kVar != kVar2) {
            if (kVar == null || kVar2 == null) {
                if (iVar.f3067s) {
                    iVar.f3068t = kVar;
                }
                if (kVar != null) {
                    kVar.mo5598a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Animator mo5456g() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3050b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g0 */
    public void mo5457g0(int i) {
        m2118c().f3065q = i;
    }

    @Nullable
    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.mo5696a();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        C0629i iVar = this.f2992K;
        if (iVar == null || (bool = iVar.f3062n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        C0629i iVar = this.f2992K;
        if (iVar == null || (bool = iVar.f3061m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Nullable
    public final Bundle getArguments() {
        return this.f3014g;
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.f3027t != null) {
            return this.f3028u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Nullable
    public Context getContext() {
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.mo5697b();
    }

    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.f3026s != null) {
            if (this.f3003V == null) {
                Application application = null;
                Context context = requireContext().getApplicationContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else if (context instanceof Application) {
                        application = (Application) context;
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (application == null && FragmentManager.m2230w0(3)) {
                    Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                }
                this.f3003V = new SavedStateViewModelFactory(application, this, getArguments());
            }
            return this.f3003V;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @Nullable
    public Object getEnterTransition() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3055g;
    }

    @Nullable
    public Object getExitTransition() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3057i;
    }

    @Deprecated
    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.f3026s;
    }

    @Nullable
    public final Object getHost() {
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    public final int getId() {
        return this.f3030w;
    }

    @NonNull
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.f2997P;
        return layoutInflater == null ? mo5427G((Bundle) null) : layoutInflater;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.f3000S;
    }

    @NonNull
    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.f3029v;
    }

    @NonNull
    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.f3026s;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Nullable
    public Object getReenterTransition() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f3058j;
        return obj == f2981a0 ? getExitTransition() : obj;
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.f2983B;
    }

    @Nullable
    public Object getReturnTransition() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f3056h;
        return obj == f2981a0 ? getEnterTransition() : obj;
    }

    @NonNull
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f3004W.getSavedStateRegistry();
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3059k;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f3060l;
        return obj == f2981a0 ? getSharedElementEnterTransition() : obj;
    }

    @NonNull
    public final String getString(@StringRes int i) {
        return getResources().getString(i);
    }

    @Nullable
    public final String getTag() {
        return this.f3032y;
    }

    @Deprecated
    @Nullable
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.f3015h;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.f3026s;
        if (fragmentManager == null || (str = this.f3016i) == null) {
            return null;
        }
        return fragmentManager.mo5748c0(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.f3017j;
    }

    @NonNull
    public final CharSequence getText(@StringRes int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.f2991J;
    }

    @Nullable
    public View getView() {
        return this.f2989H;
    }

    @MainThread
    @NonNull
    public LifecycleOwner getViewLifecycleOwner() {
        C0712l lVar = this.f3001T;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.f3002U;
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        FragmentManager fragmentManager = this.f3026s;
        if (fragmentManager != null) {
            return fragmentManager.mo5799t0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public SharedElementCallback mo5490h() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3063o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h0 */
    public void mo5491h0(@Nullable ArrayList<String> arrayList, @Nullable ArrayList<String> arrayList2) {
        m2118c();
        C0629i iVar = this.f2992K;
        iVar.f3053e = arrayList;
        iVar.f3054f = arrayList2;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final boolean hasOptionsMenu() {
        return this.f2985D;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public SharedElementCallback mo5494i() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3064p;
    }

    public final boolean isAdded() {
        return this.f3027t != null && this.f3019l;
    }

    public final boolean isDetached() {
        return this.f2982A;
    }

    public final boolean isHidden() {
        return this.f3033z;
    }

    public final boolean isInLayout() {
        return this.f3022o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.f3026s;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMenuVisible() {
        /*
            r2 = this;
            boolean r0 = r2.f2986E
            if (r0 == 0) goto L_0x0012
            androidx.fragment.app.FragmentManager r0 = r2.f3026s
            if (r0 == 0) goto L_0x0010
            androidx.fragment.app.Fragment r1 = r2.f3029v
            boolean r0 = r0.mo5808y0(r1)
            if (r0 == 0) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.isMenuVisible():boolean");
    }

    public final boolean isRemoving() {
        return this.f3020m;
    }

    public final boolean isResumed() {
        return this.f3008a >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.f3026s;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r1.f2989H;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isVisible() {
        /*
            r1 = this;
            boolean r0 = r1.isAdded()
            if (r0 == 0) goto L_0x0020
            boolean r0 = r1.isHidden()
            if (r0 != 0) goto L_0x0020
            android.view.View r0 = r1.f2989H
            if (r0 == 0) goto L_0x0020
            android.os.IBinder r0 = r0.getWindowToken()
            if (r0 == 0) goto L_0x0020
            android.view.View r0 = r1.f2989H
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Fragment.isVisible():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public View mo5504j() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return null;
        }
        return iVar.f3066r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo5505k() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f3051c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo5506l() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f3052d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo5507m() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return 0;
        }
        return iVar.f3065q;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: n */
    public ArrayList<String> mo5508n() {
        ArrayList<String> arrayList;
        C0629i iVar = this.f2992K;
        if (iVar == null || (arrayList = iVar.f3053e) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: o */
    public ArrayList<String> mo5509o() {
        ArrayList<String> arrayList;
        C0629i iVar = this.f2992K;
        if (iVar == null || (arrayList = iVar.f3054f) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle bundle) {
        this.f2987F = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (FragmentManager.m2230w0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    @CallSuper
    @MainThread
    public void onAttach(@NonNull Context context) {
        this.f2987F = true;
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        Activity a = fragmentHostCallback == null ? null : fragmentHostCallback.mo5696a();
        if (a != null) {
            this.f2987F = false;
            onAttach(a);
        }
    }

    @MainThread
    @Deprecated
    public void onAttachFragment(@NonNull Fragment fragment) {
    }

    @CallSuper
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.f2987F = true;
    }

    @MainThread
    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @CallSuper
    @MainThread
    public void onCreate(@Nullable Bundle bundle) {
        this.f2987F = true;
        mo5441W(bundle);
        if (!this.f3028u.mo5704A0(1)) {
            this.f3028u.mo5703A();
        }
    }

    @MainThread
    @Nullable
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    @MainThread
    @Nullable
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @MainThread
    public void onCreateContextMenu(@NonNull ContextMenu contextMenu, @NonNull View view, @Nullable ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @MainThread
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
    }

    @MainThread
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i = this.f3005X;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.f2987F = true;
    }

    @MainThread
    public void onDestroyOptionsMenu() {
    }

    @CallSuper
    @MainThread
    public void onDestroyView() {
        this.f2987F = true;
    }

    @CallSuper
    @MainThread
    public void onDetach() {
        this.f2987F = true;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @MainThread
    public void onHiddenChanged(boolean z) {
    }

    @CallSuper
    @UiThread
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.f2987F = true;
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        Activity a = fragmentHostCallback == null ? null : fragmentHostCallback.mo5696a();
        if (a != null) {
            this.f2987F = false;
            onInflate(a, attributeSet, bundle);
        }
    }

    @CallSuper
    @MainThread
    public void onLowMemory() {
        this.f2987F = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @MainThread
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @MainThread
    public void onOptionsMenuClosed(@NonNull Menu menu) {
    }

    @CallSuper
    @MainThread
    public void onPause() {
        this.f2987F = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @MainThread
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
    }

    @MainThread
    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    @CallSuper
    @MainThread
    public void onResume() {
        this.f2987F = true;
    }

    @MainThread
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onStart() {
        this.f2987F = true;
    }

    @CallSuper
    @MainThread
    public void onStop() {
        this.f2987F = true;
    }

    @MainThread
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
    }

    @CallSuper
    @MainThread
    public void onViewStateRestored(@Nullable Bundle bundle) {
        this.f2987F = true;
    }

    public void postponeEnterTransition() {
        m2118c().f3067s = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo5539q() {
        m2119p();
        this.f3013f = UUID.randomUUID().toString();
        this.f3019l = false;
        this.f3020m = false;
        this.f3021n = false;
        this.f3022o = false;
        this.f3023p = false;
        this.f3025r = 0;
        this.f3026s = null;
        this.f3028u = new C0690f();
        this.f3027t = null;
        this.f3030w = 0;
        this.f3031x = 0;
        this.f3032y = null;
        this.f3033z = false;
        this.f2982A = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public boolean mo5540r() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return false;
        }
        return iVar.f3069u;
    }

    @MainThread
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return m2115U(activityResultContract, new C0625e(), activityResultCallback);
    }

    public void registerForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@NonNull String[] strArr, int i) {
        if (this.f3027t != null) {
            getParentFragmentManager().mo5706B0(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @NonNull
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @NonNull
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @NonNull
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @NonNull
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @NonNull
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public final boolean mo5550s() {
        return this.f3025r > 0;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        m2118c().f3062n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        m2118c().f3061m = Boolean.valueOf(z);
    }

    public void setArguments(@Nullable Bundle bundle) {
        if (this.f3026s == null || !isStateSaved()) {
            this.f3014g = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        m2118c().f3063o = sharedElementCallback;
    }

    public void setEnterTransition(@Nullable Object obj) {
        m2118c().f3055g = obj;
    }

    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        m2118c().f3064p = sharedElementCallback;
    }

    public void setExitTransition(@Nullable Object obj) {
        m2118c().f3057i = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.f2985D != z) {
            this.f2985D = z;
            if (isAdded() && !isHidden()) {
                this.f3027t.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setInitialSavedState(@Nullable SavedState savedState) {
        Bundle bundle;
        if (this.f3026s == null) {
            if (savedState == null || (bundle = savedState.f3035a) == null) {
                bundle = null;
            }
            this.f3009b = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.f2986E != z) {
            this.f2986E = z;
            if (this.f2985D && isAdded() && !isHidden()) {
                this.f3027t.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(@Nullable Object obj) {
        m2118c().f3058j = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        this.f2983B = z;
        FragmentManager fragmentManager = this.f3026s;
        if (fragmentManager == null) {
            this.f2984C = true;
        } else if (z) {
            fragmentManager.mo5766h(this);
        } else {
            fragmentManager.mo5732R0(this);
        }
    }

    public void setReturnTransition(@Nullable Object obj) {
        m2118c().f3056h = obj;
    }

    public void setSharedElementEnterTransition(@Nullable Object obj) {
        m2118c().f3059k = obj;
    }

    public void setSharedElementReturnTransition(@Nullable Object obj) {
        m2118c().f3060l = obj;
    }

    @Deprecated
    public void setTargetFragment(@Nullable Fragment fragment, int i) {
        FragmentManager fragmentManager = this.f3026s;
        FragmentManager fragmentManager2 = fragment != null ? fragment.f3026s : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            Fragment fragment2 = fragment;
            while (fragment2 != null) {
                if (!fragment2.equals(this)) {
                    fragment2 = fragment2.getTargetFragment();
                } else {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.f3016i = null;
                this.f3015h = null;
            } else if (this.f3026s == null || fragment.f3026s == null) {
                this.f3016i = null;
                this.f3015h = fragment;
            } else {
                this.f3016i = fragment.f3013f;
                this.f3015h = null;
            }
            this.f3017j = i;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.f2991J && z && this.f3008a < 5 && this.f3026s != null && isAdded() && this.f2998Q) {
            FragmentManager fragmentManager = this.f3026s;
            fragmentManager.mo5722K0(fragmentManager.mo5798t(this));
        }
        this.f2991J = z;
        this.f2990I = this.f3008a < 5 && !z;
        if (this.f3009b != null) {
            this.f3012e = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, (Bundle) null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        if (this.f3027t != null) {
            if (FragmentManager.m2230w0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(this);
                sb.append(" received the following in startIntentSenderForResult() requestCode: ");
                int i5 = i;
                sb.append(i);
                sb.append(" IntentSender: ");
                IntentSender intentSender2 = intentSender;
                sb.append(intentSender);
                sb.append(" fillInIntent: ");
                Intent intent2 = intent;
                sb.append(intent);
                sb.append(" options: ");
                sb.append(bundle);
                Log.v("FragmentManager", sb.toString());
            } else {
                IntentSender intentSender3 = intentSender;
                int i6 = i;
                Intent intent3 = intent;
                Bundle bundle2 = bundle;
            }
            getParentFragmentManager().mo5710D0(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void startPostponedEnterTransition() {
        if (this.f2992K != null && m2118c().f3067s) {
            if (this.f3027t == null) {
                m2118c().f3067s = false;
            } else if (Looper.myLooper() != this.f3027t.mo5698c().getLooper()) {
                this.f3027t.mo5698c().postAtFrontOfQueue(new C0622b());
            } else {
                mo5444a(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public boolean mo5575t() {
        C0629i iVar = this.f2992K;
        if (iVar == null) {
            return false;
        }
        return iVar.f3067s;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f3013f);
        sb.append(")");
        if (this.f3030w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3030w));
        }
        if (this.f3032y != null) {
            sb.append(" ");
            sb.append(this.f3032y);
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public final boolean mo5577u() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.mo5577u());
    }

    public void unregisterForContextMenu(@NonNull View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo5579v() {
        this.f3028u.mo5720J0();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo5580w(Bundle bundle) {
        this.f3028u.mo5720J0();
        this.f3008a = 3;
        this.f2987F = false;
        onActivityCreated(bundle);
        if (this.f2987F) {
            m2117X();
            this.f3028u.mo5805w();
            return;
        }
        throw new C0725p("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo5581x() {
        Iterator<C0630j> it = this.f3007Z.iterator();
        while (it.hasNext()) {
            it.next().mo5597a();
        }
        this.f3007Z.clear();
        this.f3028u.mo5772j(this.f3027t, mo5388b(), this);
        this.f3008a = 0;
        this.f2987F = false;
        onAttach(this.f3027t.mo5697b());
        if (this.f2987F) {
            this.f3026s.mo5714G(this);
            this.f3028u.mo5806x();
            return;
        }
        throw new C0725p("Fragment " + this + " did not call through to super.onAttach()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo5582y(@NonNull Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f3028u.mo5807y(configuration);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public boolean mo5583z(@NonNull MenuItem menuItem) {
        if (this.f3033z) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.f3028u.mo5809z(menuItem);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new C0620a();

        /* renamed from: a */
        final Bundle f3035a;

        /* renamed from: androidx.fragment.app.Fragment$SavedState$a */
        class C0620a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0620a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Bundle bundle) {
            this.f3035a = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeBundle(this.f3035a);
        }

        SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f3035a = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }
    }

    @NonNull
    @Deprecated
    public static Fragment instantiate(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    @NonNull
    public final String getString(@StringRes int i, @Nullable Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, @NonNull TimeUnit timeUnit) {
        Handler handler;
        m2118c().f3067s = true;
        FragmentManager fragmentManager = this.f3026s;
        if (fragmentManager != null) {
            handler = fragmentManager.mo5777n0().mo5698c();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.f2993L);
        handler.postDelayed(this.f2993L, timeUnit.toMillis(j));
    }

    @MainThread
    @NonNull
    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback) {
        return m2115U(activityResultContract, new C0626f(this, activityResultRegistry), activityResultCallback);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, @Nullable Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        if (this.f3027t != null) {
            getParentFragmentManager().mo5708C0(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.f3027t;
        if (fragmentHostCallback != null) {
            LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
            LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.f3028u.mo5778o0());
            return onGetLayoutInflater;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @CallSuper
    @MainThread
    @Deprecated
    public void onAttach(@NonNull Activity activity) {
        this.f2987F = true;
    }

    @CallSuper
    @UiThread
    @Deprecated
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        this.f2987F = true;
    }

    @ContentView
    public Fragment(@LayoutRes int i) {
        this();
        this.f3005X = i;
    }
}
