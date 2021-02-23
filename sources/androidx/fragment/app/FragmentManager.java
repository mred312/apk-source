package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.collection.ArraySet;
import androidx.core.p003os.CancellationSignal;
import androidx.fragment.C0610R;
import androidx.fragment.app.C0679c;
import androidx.fragment.app.C0697j;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager implements FragmentResultOwner {

    /* renamed from: O */
    private static boolean f3088O = false;

    /* renamed from: P */
    static boolean f3089P = true;
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    /* renamed from: A */
    private ActivityResultLauncher<IntentSenderRequest> f3090A;

    /* renamed from: B */
    private ActivityResultLauncher<String[]> f3091B;

    /* renamed from: C */
    ArrayDeque<LaunchedFragmentInfo> f3092C = new ArrayDeque<>();

    /* renamed from: D */
    private boolean f3093D;

    /* renamed from: E */
    private boolean f3094E;

    /* renamed from: F */
    private boolean f3095F;

    /* renamed from: G */
    private boolean f3096G;

    /* renamed from: H */
    private boolean f3097H;

    /* renamed from: I */
    private ArrayList<C0663a> f3098I;

    /* renamed from: J */
    private ArrayList<Boolean> f3099J;

    /* renamed from: K */
    private ArrayList<Fragment> f3100K;

    /* renamed from: L */
    private ArrayList<C0651o> f3101L;

    /* renamed from: M */
    private C0691g f3102M;

    /* renamed from: N */
    private Runnable f3103N = new C0643g();

    /* renamed from: a */
    private final ArrayList<C0649m> f3104a = new ArrayList<>();

    /* renamed from: b */
    private boolean f3105b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0696i f3106c = new C0696i();

    /* renamed from: d */
    ArrayList<C0663a> f3107d;

    /* renamed from: e */
    private ArrayList<Fragment> f3108e;

    /* renamed from: f */
    private final C0687d f3109f = new C0687d(this);

    /* renamed from: g */
    private OnBackPressedDispatcher f3110g;

    /* renamed from: h */
    private final OnBackPressedCallback f3111h = new C0639c(false);

    /* renamed from: i */
    private final AtomicInteger f3112i = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Map<String, Bundle> f3113j = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Map<String, C0648l> f3114k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l */
    private ArrayList<OnBackStackChangedListener> f3115l;

    /* renamed from: m */
    private Map<Fragment, HashSet<CancellationSignal>> f3116m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n */
    private final C0697j.C0704g f3117n = new C0640d();

    /* renamed from: o */
    private final C0688e f3118o = new C0688e(this);

    /* renamed from: p */
    private final CopyOnWriteArrayList<FragmentOnAttachListener> f3119p = new CopyOnWriteArrayList<>();

    /* renamed from: q */
    int f3120q = -1;

    /* renamed from: r */
    private FragmentHostCallback<?> f3121r;

    /* renamed from: s */
    private FragmentContainer f3122s;

    /* renamed from: t */
    private Fragment f3123t;
    @Nullable

    /* renamed from: u */
    Fragment f3124u;

    /* renamed from: v */
    private FragmentFactory f3125v = null;

    /* renamed from: w */
    private FragmentFactory f3126w = new C0641e();

    /* renamed from: x */
    private C0724o f3127x = null;

    /* renamed from: y */
    private C0724o f3128y = new C0642f(this);

    /* renamed from: z */
    private ActivityResultLauncher<Intent> f3129z;

    public interface BackStackEntry {
        @Deprecated
        @Nullable
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        @Nullable
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        void onBackStackChanged();
    }

    /* renamed from: androidx.fragment.app.FragmentManager$a */
    class C0637a implements ActivityResultCallback<ActivityResult> {
        C0637a() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.f3092C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f3134a;
            int i = pollFirst.f3135b;
            Fragment i2 = FragmentManager.this.f3106c.mo6093i(str);
            if (i2 == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i2.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$b */
    class C0638b implements ActivityResultCallback<Map<String, Boolean>> {
        C0638b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a */
        public void onActivityResult(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.f3092C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.f3134a;
            int i2 = pollFirst.f3135b;
            Fragment i3 = FragmentManager.this.f3106c.mo6093i(str);
            if (i3 == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            i3.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$c */
    class C0639c extends OnBackPressedCallback {
        C0639c(boolean z) {
            super(z);
        }

        public void handleOnBackPressed() {
            FragmentManager.this.mo5801u0();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$d */
    class C0640d implements C0697j.C0704g {
        C0640d() {
        }

        /* renamed from: a */
        public void mo5840a(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            if (!cancellationSignal.isCanceled()) {
                FragmentManager.this.mo5728O0(fragment, cancellationSignal);
            }
        }

        /* renamed from: b */
        public void mo5841b(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            FragmentManager.this.mo5756f(fragment, cancellationSignal);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$e */
    class C0641e extends FragmentFactory {
        C0641e() {
        }

        @NonNull
        public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
            return FragmentManager.this.mo5777n0().instantiate(FragmentManager.this.mo5777n0().mo5697b(), str, (Bundle) null);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$f */
    class C0642f implements C0724o {
        C0642f(FragmentManager fragmentManager) {
        }

        @NonNull
        /* renamed from: a */
        public C0714n mo5842a(@NonNull ViewGroup viewGroup) {
            return new C0664b(viewGroup);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$g */
    class C0643g implements Runnable {
        C0643g() {
        }

        public void run() {
            FragmentManager.this.mo5738X(true);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$h */
    class C0644h extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3142a;

        /* renamed from: b */
        final /* synthetic */ View f3143b;

        /* renamed from: c */
        final /* synthetic */ Fragment f3144c;

        C0644h(FragmentManager fragmentManager, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f3142a = viewGroup;
            this.f3143b = view;
            this.f3144c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3142a.endViewTransition(this.f3143b);
            animator.removeListener(this);
            Fragment fragment = this.f3144c;
            View view = fragment.f2989H;
            if (view != null && fragment.f3033z) {
                view.setVisibility(8);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$i */
    class C0645i implements FragmentOnAttachListener {

        /* renamed from: a */
        final /* synthetic */ Fragment f3145a;

        C0645i(FragmentManager fragmentManager, Fragment fragment) {
            this.f3145a = fragment;
        }

        public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            this.f3145a.onAttachFragment(fragment);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$j */
    class C0646j implements ActivityResultCallback<ActivityResult> {
        C0646j() {
        }

        /* renamed from: a */
        public void onActivityResult(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.f3092C.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f3134a;
            int i = pollFirst.f3135b;
            Fragment i2 = FragmentManager.this.f3106c.mo6093i(str);
            if (i2 == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i2.onActivityResult(i, activityResult.getResultCode(), activityResult.getData());
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$k */
    static class C0647k extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        C0647k() {
        }

        @NonNull
        public Intent createIntent(@NonNull Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST);
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (!(fillInIntent == null || (bundleExtra = fillInIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundleExtra);
                fillInIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.getIntentSender()).setFillInIntent((Intent) null).setFlags(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).build();
                }
            }
            intent.putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            if (FragmentManager.m2230w0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @NonNull
        public ActivityResult parseResult(int i, @Nullable Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$l */
    private static class C0648l implements FragmentResultListener {

        /* renamed from: a */
        private final Lifecycle f3147a;

        /* renamed from: b */
        private final FragmentResultListener f3148b;

        /* renamed from: c */
        private final LifecycleEventObserver f3149c;

        C0648l(@NonNull Lifecycle lifecycle, @NonNull FragmentResultListener fragmentResultListener, @NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.f3147a = lifecycle;
            this.f3148b = fragmentResultListener;
            this.f3149c = lifecycleEventObserver;
        }

        /* renamed from: a */
        public boolean mo5847a(Lifecycle.State state) {
            return this.f3147a.getCurrentState().isAtLeast(state);
        }

        /* renamed from: b */
        public void mo5848b() {
            this.f3147a.removeObserver(this.f3149c);
        }

        public void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
            this.f3148b.onFragmentResult(str, bundle);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$m */
    interface C0649m {
        /* renamed from: a */
        boolean mo5850a(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    /* renamed from: androidx.fragment.app.FragmentManager$n */
    private class C0650n implements C0649m {

        /* renamed from: a */
        final String f3150a;

        /* renamed from: b */
        final int f3151b;

        /* renamed from: c */
        final int f3152c;

        C0650n(@Nullable String str, int i, int i2) {
            this.f3150a = str;
            this.f3151b = i;
            this.f3152c = i2;
        }

        /* renamed from: a */
        public boolean mo5850a(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f3124u;
            if (fragment != null && this.f3151b < 0 && this.f3150a == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
                return false;
            }
            return FragmentManager.this.mo5725M0(arrayList, arrayList2, this.f3150a, this.f3151b, this.f3152c);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$o */
    static class C0651o implements Fragment.C0631k {

        /* renamed from: a */
        final boolean f3154a;

        /* renamed from: b */
        final C0663a f3155b;

        /* renamed from: c */
        private int f3156c;

        C0651o(@NonNull C0663a aVar, boolean z) {
            this.f3154a = z;
            this.f3155b = aVar;
        }

        /* renamed from: a */
        public void mo5598a() {
            this.f3156c++;
        }

        /* renamed from: b */
        public void mo5599b() {
            int i = this.f3156c - 1;
            this.f3156c = i;
            if (i == 0) {
                this.f3155b.f3256t.mo5741Y0();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5851c() {
            C0663a aVar = this.f3155b;
            aVar.f3256t.mo5789r(aVar, this.f3154a, false, false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5852d() {
            boolean z = this.f3156c > 0;
            for (Fragment next : this.f3155b.f3256t.getFragments()) {
                next.mo5455f0((Fragment.C0631k) null);
                if (z && next.mo5575t()) {
                    next.startPostponedEnterTransition();
                }
            }
            C0663a aVar = this.f3155b;
            aVar.f3256t.mo5789r(aVar, this.f3154a, !z, true);
        }

        /* renamed from: e */
        public boolean mo5853e() {
            return this.f3156c == 0;
        }
    }

    /* renamed from: E0 */
    private void m2195E0(@NonNull ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment valueAt = arraySet.valueAt(i);
            if (!valueAt.f3019l) {
                View requireView = valueAt.requireView();
                valueAt.f2996O = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: J */
    private void m2196J(@Nullable Fragment fragment) {
        if (fragment != null && fragment.equals(mo5748c0(fragment.f3013f))) {
            fragment.mo5435O();
        }
    }

    /* renamed from: L0 */
    private boolean m2197L0(@Nullable String str, int i, int i2) {
        mo5738X(false);
        m2204W(true);
        Fragment fragment = this.f3124u;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean M0 = mo5725M0(this.f3098I, this.f3099J, str, i, i2);
        if (M0) {
            this.f3105b = true;
            try {
                m2200Q0(this.f3098I, this.f3099J);
            } finally {
                m2224o();
            }
        }
        m2219g1();
        m2202T();
        this.f3106c.mo6086b();
        return M0;
    }

    /* renamed from: N0 */
    private int m2198N0(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i, int i2, @NonNull ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C0663a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.mo5987p() && !aVar.mo5986n(arrayList, i4 + 1, i2)) {
                if (this.f3101L == null) {
                    this.f3101L = new ArrayList<>();
                }
                C0651o oVar = new C0651o(aVar, booleanValue);
                this.f3101L.add(oVar);
                aVar.mo5989r(oVar);
                if (booleanValue) {
                    aVar.mo5982j();
                } else {
                    aVar.mo5983k(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                m2213d(arraySet);
            }
        }
        return i3;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: Q */
    private void m2199Q(int i) {
        try {
            this.f3105b = true;
            this.f3106c.mo6088d(i);
            mo5715G0(i, false);
            if (f3089P) {
                for (C0714n h : m2225p()) {
                    h.mo6147h();
                }
            }
            this.f3105b = false;
            mo5738X(true);
        } catch (Throwable th) {
            this.f3105b = false;
            throw th;
        }
    }

    /* renamed from: Q0 */
    private void m2200Q0(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                m2210b0(arrayList, arrayList2);
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    if (!arrayList.get(i).f3224r) {
                        if (i2 != i) {
                            m2208a0(arrayList, arrayList2, i2, i);
                        }
                        i2 = i + 1;
                        if (arrayList2.get(i).booleanValue()) {
                            while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f3224r) {
                                i2++;
                            }
                        }
                        m2208a0(arrayList, arrayList2, i, i2);
                        i = i2 - 1;
                    }
                    i++;
                }
                if (i2 != size) {
                    m2208a0(arrayList, arrayList2, i2, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    /* renamed from: S0 */
    private void m2201S0() {
        if (this.f3115l != null) {
            for (int i = 0; i < this.f3115l.size(); i++) {
                this.f3115l.get(i).onBackStackChanged();
            }
        }
    }

    /* renamed from: T */
    private void m2202T() {
        if (this.f3097H) {
            this.f3097H = false;
            m2215e1();
        }
    }

    /* renamed from: U */
    private void m2203U() {
        if (f3089P) {
            for (C0714n h : m2225p()) {
                h.mo6147h();
            }
        } else if (!this.f3116m.isEmpty()) {
            for (Fragment next : this.f3116m.keySet()) {
                m2221l(next);
                mo5717H0(next);
            }
        }
    }

    /* renamed from: W */
    private void m2204W(boolean z) {
        if (this.f3105b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f3121r == null) {
            if (this.f3096G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f3121r.mo5698c().getLooper()) {
            if (!z) {
                m2223n();
            }
            if (this.f3098I == null) {
                this.f3098I = new ArrayList<>();
                this.f3099J = new ArrayList<>();
            }
            this.f3105b = true;
            try {
                m2210b0((ArrayList<C0663a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f3105b = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* renamed from: W0 */
    static int m2205W0(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i == 4099) {
            return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i != 8194) {
            return 0;
        }
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    }

    /* renamed from: Z */
    private static void m2206Z(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0663a aVar = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                aVar.mo5978f(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                aVar.mo5983k(z);
            } else {
                aVar.mo5978f(1);
                aVar.mo5982j();
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01bc  */
    /* renamed from: a0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2208a0(@androidx.annotation.NonNull java.util.ArrayList<androidx.fragment.app.C0663a> r18, @androidx.annotation.NonNull java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.a r0 = (androidx.fragment.app.C0663a) r0
            boolean r2 = r0.f3224r
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.f3100K
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.f3100K = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.f3100K
            androidx.fragment.app.i r1 = r6.f3106c
            java.util.List r1 = r1.mo6099o()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.getPrimaryNavigationFragment()
            r1 = 0
            r7 = r4
            r16 = 0
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.a r8 = (androidx.fragment.app.C0663a) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.f3100K
            androidx.fragment.app.Fragment r0 = r8.mo5984l(r9, r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.f3100K
            androidx.fragment.app.Fragment r0 = r8.mo5990s(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.f3215i
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = 0
            goto L_0x0062
        L_0x0060:
            r16 = 1
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.f3100K
            r0.clear()
            if (r2 != 0) goto L_0x00b9
            int r0 = r6.f3120q
            if (r0 < r14) goto L_0x00b9
            boolean r0 = f3089P
            if (r0 == 0) goto L_0x00a0
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00b9
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.a r1 = (androidx.fragment.app.C0663a) r1
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r1 = r1.f3209c
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x009d
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.FragmentTransaction$a r7 = (androidx.fragment.app.FragmentTransaction.C0657a) r7
            androidx.fragment.app.Fragment r7 = r7.f3227b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.h r7 = r6.mo5798t(r7)
            androidx.fragment.app.i r8 = r6.f3106c
            r8.mo6101q(r7)
            goto L_0x0083
        L_0x009d:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a0:
            androidx.fragment.app.FragmentHostCallback<?> r0 = r6.f3121r
            android.content.Context r7 = r0.mo5697b()
            androidx.fragment.app.FragmentContainer r8 = r6.f3122s
            r13 = 0
            androidx.fragment.app.j$g r0 = r6.f3117n
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = 1
            r14 = r0
            androidx.fragment.app.C0697j.m2469C(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00ba
        L_0x00b9:
            r1 = 1
        L_0x00ba:
            m2206Z(r18, r19, r20, r21)
            boolean r0 = f3089P
            if (r0 == 0) goto L_0x0141
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r2 == 0) goto L_0x011f
            r2 = r4
        L_0x00d0:
            if (r2 >= r3) goto L_0x011a
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.a r7 = (androidx.fragment.app.C0663a) r7
            if (r0 == 0) goto L_0x00f9
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r8 = r7.f3209c
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e1:
            if (r8 < 0) goto L_0x0117
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r9 = r7.f3209c
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.FragmentTransaction$a r9 = (androidx.fragment.app.FragmentTransaction.C0657a) r9
            androidx.fragment.app.Fragment r9 = r9.f3227b
            if (r9 == 0) goto L_0x00f6
            androidx.fragment.app.h r9 = r6.mo5798t(r9)
            r9.mo6073k()
        L_0x00f6:
            int r8 = r8 + -1
            goto L_0x00e1
        L_0x00f9:
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$a> r7 = r7.f3209c
            java.util.Iterator r7 = r7.iterator()
        L_0x00ff:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0117
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.FragmentTransaction$a r8 = (androidx.fragment.app.FragmentTransaction.C0657a) r8
            androidx.fragment.app.Fragment r8 = r8.f3227b
            if (r8 == 0) goto L_0x00ff
            androidx.fragment.app.h r8 = r6.mo5798t(r8)
            r8.mo6073k()
            goto L_0x00ff
        L_0x0117:
            int r2 = r2 + 1
            goto L_0x00d0
        L_0x011a:
            int r2 = r6.f3120q
            r6.mo5715G0(r2, r1)
        L_0x011f:
            java.util.Set r1 = r6.m2226q(r15, r4, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0127:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013d
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.n r2 = (androidx.fragment.app.C0714n) r2
            r2.mo6152o(r0)
            r2.mo6151n()
            r2.mo6146g()
            goto L_0x0127
        L_0x013d:
            r0 = r3
            r3 = r5
            goto L_0x0197
        L_0x0141:
            if (r2 == 0) goto L_0x0163
            androidx.collection.ArraySet r7 = new androidx.collection.ArraySet
            r7.<init>()
            r6.m2213d(r7)
            r0 = r17
            r14 = 1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.m2198N0(r1, r2, r3, r4, r5)
            r6.m2195E0(r7)
            goto L_0x0169
        L_0x0163:
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r14 = 1
            r0 = r13
        L_0x0169:
            if (r0 == r12) goto L_0x0195
            if (r8 == 0) goto L_0x0195
            int r1 = r6.f3120q
            if (r1 < r14) goto L_0x018c
            androidx.fragment.app.FragmentHostCallback<?> r1 = r6.f3121r
            android.content.Context r7 = r1.mo5697b()
            androidx.fragment.app.FragmentContainer r8 = r6.f3122s
            r1 = 1
            androidx.fragment.app.j$g r2 = r6.f3117n
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = 1
            r14 = r2
            androidx.fragment.app.C0697j.m2469C(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x018f
        L_0x018c:
            r3 = r11
            r0 = r13
            r1 = 1
        L_0x018f:
            int r2 = r6.f3120q
            r6.mo5715G0(r2, r1)
            goto L_0x0197
        L_0x0195:
            r3 = r11
            r0 = r13
        L_0x0197:
            r1 = r20
        L_0x0199:
            if (r1 >= r0) goto L_0x01ba
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.a r2 = (androidx.fragment.app.C0663a) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b4
            int r4 = r2.f3258v
            if (r4 < 0) goto L_0x01b4
            r4 = -1
            r2.f3258v = r4
        L_0x01b4:
            r2.mo5988q()
            int r1 = r1 + 1
            goto L_0x0199
        L_0x01ba:
            if (r16 == 0) goto L_0x01bf
            r17.m2201S0()
        L_0x01bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.m2208a0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    /* renamed from: b0 */
    private void m2210b0(@Nullable ArrayList<C0663a> arrayList, @Nullable ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<C0651o> arrayList3 = this.f3101L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            C0651o oVar = this.f3101L.get(i);
            if (arrayList != null && !oVar.f3154a && (indexOf2 = arrayList.indexOf(oVar.f3155b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.f3101L.remove(i);
                i--;
                size--;
                oVar.mo5851c();
            } else if (oVar.mo5853e() || (arrayList != null && oVar.f3155b.mo5986n(arrayList, 0, arrayList.size()))) {
                this.f3101L.remove(i);
                i--;
                size--;
                if (arrayList == null || oVar.f3154a || (indexOf = arrayList.indexOf(oVar.f3155b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    oVar.mo5852d();
                } else {
                    oVar.mo5851c();
                }
            }
            i++;
        }
    }

    /* renamed from: c1 */
    private void m2212c1(@NonNull Fragment fragment) {
        ViewGroup l0 = m2222l0(fragment);
        if (l0 != null) {
            int i = C0610R.C0612id.visible_removing_fragment_view_tag;
            if (l0.getTag(i) == null) {
                l0.setTag(i, fragment);
            }
            ((Fragment) l0.getTag(i)).mo5449d0(fragment.mo5505k());
        }
    }

    /* renamed from: d */
    private void m2213d(@NonNull ArraySet<Fragment> arraySet) {
        int i = this.f3120q;
        if (i >= 1) {
            int min = Math.min(i, 5);
            for (Fragment next : this.f3106c.mo6099o()) {
                if (next.f3008a < min) {
                    mo5719I0(next, min);
                    if (next.f2989H != null && !next.f3033z && next.f2994M) {
                        arraySet.add(next);
                    }
                }
            }
        }
    }

    @Nullable
    /* renamed from: e0 */
    private static Fragment m2214e0(@NonNull View view) {
        while (view != null) {
            Fragment s0 = m2228s0(view);
            if (s0 != null) {
                return s0;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    /* renamed from: e1 */
    private void m2215e1() {
        for (C0693h K0 : this.f3106c.mo6096l()) {
            mo5722K0(K0);
        }
    }

    @Deprecated
    public static void enableDebugLogging(boolean z) {
        f3088O = z;
    }

    @FragmentStateManagerControl
    public static void enableNewStateManager(boolean z) {
        f3089P = z;
    }

    /* renamed from: f0 */
    private void m2216f0() {
        if (f3089P) {
            for (C0714n i : m2225p()) {
                i.mo6148i();
            }
        } else if (this.f3101L != null) {
            while (!this.f3101L.isEmpty()) {
                this.f3101L.remove(0).mo5852d();
            }
        }
    }

    /* renamed from: f1 */
    private void m2217f1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0713m("FragmentManager"));
        FragmentHostCallback<?> fragmentHostCallback = this.f3121r;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    @NonNull
    public static <F extends Fragment> F findFragment(@NonNull View view) {
        F e0 = m2214e0(view);
        if (e0 != null) {
            return e0;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    /* renamed from: g0 */
    private boolean m2218g0(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.f3104a) {
            if (this.f3104a.isEmpty()) {
                return false;
            }
            int size = this.f3104a.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.f3104a.get(i).mo5850a(arrayList, arrayList2);
            }
            this.f3104a.clear();
            this.f3121r.mo5698c().removeCallbacks(this.f3103N);
            return z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (getBackStackEntryCount() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (mo5810z0(r3.f3123t) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f3111h;
     */
    /* renamed from: g1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2219g1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r0 = r3.f3104a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r1 = r3.f3104a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.OnBackPressedCallback r1 = r3.f3111h     // Catch:{ all -> 0x002a }
            r1.setEnabled(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.OnBackPressedCallback r0 = r3.f3111h
            int r1 = r3.getBackStackEntryCount()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f3123t
            boolean r1 = r3.mo5810z0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.setEnabled(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.m2219g1():void");
    }

    @NonNull
    /* renamed from: j0 */
    private C0691g m2220j0(@NonNull Fragment fragment) {
        return this.f3102M.mo6050h(fragment);
    }

    /* renamed from: l */
    private void m2221l(@NonNull Fragment fragment) {
        HashSet hashSet = this.f3116m.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
            hashSet.clear();
            m2229u(fragment);
            this.f3116m.remove(fragment);
        }
    }

    /* renamed from: l0 */
    private ViewGroup m2222l0(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.f2988G;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f3031x > 0 && this.f3122s.onHasView()) {
            View onFindViewById = this.f3122s.onFindViewById(fragment.f3031x);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    /* renamed from: n */
    private void m2223n() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* renamed from: o */
    private void m2224o() {
        this.f3105b = false;
        this.f3099J.clear();
        this.f3098I.clear();
    }

    /* renamed from: p */
    private Set<C0714n> m2225p() {
        HashSet hashSet = new HashSet();
        for (C0693h j : this.f3106c.mo6096l()) {
            ViewGroup viewGroup = j.mo6072j().f2988G;
            if (viewGroup != null) {
                hashSet.add(C0714n.m2509m(viewGroup, mo5790r0()));
            }
        }
        return hashSet;
    }

    /* renamed from: q */
    private Set<C0714n> m2226q(@NonNull ArrayList<C0663a> arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator<FragmentTransaction.C0657a> it = arrayList.get(i).f3209c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f3227b;
                if (!(fragment == null || (viewGroup = fragment.f2988G) == null)) {
                    hashSet.add(C0714n.m2508l(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    /* renamed from: s */
    private void m2227s(@NonNull Fragment fragment) {
        Animator animator;
        if (fragment.f2989H != null) {
            C0679c.C0684d b = C0679c.m2390b(this.f3121r.mo5697b(), fragment, !fragment.f3033z);
            if (b == null || (animator = b.f3308b) == null) {
                if (b != null) {
                    fragment.f2989H.startAnimation(b.f3307a);
                    b.f3307a.start();
                }
                fragment.f2989H.setVisibility((!fragment.f3033z || fragment.mo5540r()) ? 0 : 8);
                if (fragment.mo5540r()) {
                    fragment.mo5447c0(false);
                }
            } else {
                animator.setTarget(fragment.f2989H);
                if (!fragment.f3033z) {
                    fragment.f2989H.setVisibility(0);
                } else if (fragment.mo5540r()) {
                    fragment.mo5447c0(false);
                } else {
                    ViewGroup viewGroup = fragment.f2988G;
                    View view = fragment.f2989H;
                    viewGroup.startViewTransition(view);
                    b.f3308b.addListener(new C0644h(this, viewGroup, view, fragment));
                }
                b.f3308b.start();
            }
        }
        if (fragment.f3019l && m2231x0(fragment)) {
            this.f3093D = true;
        }
        fragment.f2995N = false;
        fragment.onHiddenChanged(fragment.f3033z);
    }

    @Nullable
    /* renamed from: s0 */
    static Fragment m2228s0(@NonNull View view) {
        Object tag = view.getTag(C0610R.C0612id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    /* renamed from: u */
    private void m2229u(@NonNull Fragment fragment) {
        fragment.mo5425E();
        this.f3118o.mo6043n(fragment, false);
        fragment.f2988G = null;
        fragment.f2989H = null;
        fragment.f3001T = null;
        fragment.f3002U.setValue(null);
        fragment.f3022o = false;
    }

    /* renamed from: w0 */
    static boolean m2230w0(int i) {
        return f3088O || Log.isLoggable("FragmentManager", i);
    }

    /* renamed from: x0 */
    private boolean m2231x0(@NonNull Fragment fragment) {
        return (fragment.f2985D && fragment.f2986E) || fragment.f3028u.mo5775m();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo5703A() {
        this.f3094E = false;
        this.f3095F = false;
        this.f3102M.mo6059p(false);
        m2199Q(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A0 */
    public boolean mo5704A0(int i) {
        return this.f3120q >= i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public boolean mo5705B(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.f3120q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null && mo5808y0(next) && next.mo5423B(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z = true;
            }
        }
        if (this.f3108e != null) {
            for (int i = 0; i < this.f3108e.size(); i++) {
                Fragment fragment = this.f3108e.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f3108e = arrayList;
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B0 */
    public void mo5706B0(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        if (this.f3091B != null) {
            this.f3092C.addLast(new LaunchedFragmentInfo(fragment.f3013f, i));
            this.f3091B.launch(strArr);
            return;
        }
        this.f3121r.onRequestPermissionsFromFragment(fragment, strArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public void mo5707C() {
        this.f3096G = true;
        mo5738X(true);
        m2203U();
        m2199Q(-1);
        this.f3121r = null;
        this.f3122s = null;
        this.f3123t = null;
        if (this.f3110g != null) {
            this.f3111h.remove();
            this.f3110g = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.f3129z;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            this.f3090A.unregister();
            this.f3091B.unregister();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C0 */
    public void mo5708C0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, @Nullable Bundle bundle) {
        if (this.f3129z != null) {
            this.f3092C.addLast(new LaunchedFragmentInfo(fragment.f3013f, i));
            if (!(intent == null || bundle == null)) {
                intent.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle);
            }
            this.f3129z.launch(intent);
            return;
        }
        this.f3121r.onStartActivityFromFragment(fragment, intent, i, bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public void mo5709D() {
        m2199Q(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D0 */
    public void mo5710D0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.f3090A != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (m2230w0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE, bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest build = new IntentSenderRequest.Builder(intentSender).setFillInIntent(intent2).setFlags(i3, i2).build();
            int i5 = i;
            this.f3092C.addLast(new LaunchedFragmentInfo(fragment2.f3013f, i));
            if (m2230w0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.f3090A.launch(build);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        this.f3121r.onStartIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo5711E() {
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null) {
                next.mo5428H();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public void mo5712F(boolean z) {
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null) {
                next.mo5429I(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F0 */
    public void mo5713F0(@NonNull Fragment fragment) {
        if (this.f3106c.mo6087c(fragment.f3013f)) {
            mo5717H0(fragment);
            View view = fragment.f2989H;
            if (!(view == null || !fragment.f2994M || fragment.f2988G == null)) {
                float f = fragment.f2996O;
                if (f > 0.0f) {
                    view.setAlpha(f);
                }
                fragment.f2996O = 0.0f;
                fragment.f2994M = false;
                C0679c.C0684d b = C0679c.m2390b(this.f3121r.mo5697b(), fragment, true);
                if (b != null) {
                    Animation animation = b.f3307a;
                    if (animation != null) {
                        fragment.f2989H.startAnimation(animation);
                    } else {
                        b.f3308b.setTarget(fragment.f2989H);
                        b.f3308b.start();
                    }
                }
            }
            if (fragment.f2995N) {
                m2227s(fragment);
            }
        } else if (m2230w0(3)) {
            Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f3120q + "since it is not added to " + this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void mo5714G(@NonNull Fragment fragment) {
        Iterator<FragmentOnAttachListener> it = this.f3119p.iterator();
        while (it.hasNext()) {
            it.next().onAttachFragment(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G0 */
    public void mo5715G0(int i, boolean z) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.f3121r == null && i != -1) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f3120q) {
            this.f3120q = i;
            if (f3089P) {
                this.f3106c.mo6103s();
            } else {
                for (Fragment F0 : this.f3106c.mo6099o()) {
                    mo5713F0(F0);
                }
                for (C0693h next : this.f3106c.mo6096l()) {
                    Fragment j = next.mo6072j();
                    if (!j.f2994M) {
                        mo5713F0(j);
                    }
                    if (j.f3020m && !j.mo5550s()) {
                        this.f3106c.mo6102r(next);
                    }
                }
            }
            m2215e1();
            if (this.f3093D && (fragmentHostCallback = this.f3121r) != null && this.f3120q == 7) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.f3093D = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public boolean mo5716H(@NonNull MenuItem menuItem) {
        if (this.f3120q < 1) {
            return false;
        }
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null && next.mo5430J(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H0 */
    public void mo5717H0(@NonNull Fragment fragment) {
        mo5719I0(fragment, this.f3120q);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public void mo5718I(@NonNull Menu menu) {
        if (this.f3120q >= 1) {
            for (Fragment next : this.f3106c.mo6099o()) {
                if (next != null) {
                    next.mo5431K(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != 5) goto L_0x0136;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0132  */
    /* renamed from: I0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5719I0(@androidx.annotation.NonNull androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.i r0 = r10.f3106c
            java.lang.String r1 = r11.f3013f
            androidx.fragment.app.h r0 = r0.mo6098n(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.h r0 = new androidx.fragment.app.h
            androidx.fragment.app.e r2 = r10.f3118o
            androidx.fragment.app.i r3 = r10.f3106c
            r0.<init>(r2, r3, r11)
            r0.mo6080s(r1)
        L_0x0017:
            boolean r2 = r11.f3021n
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r11.f3022o
            if (r2 == 0) goto L_0x0028
            int r2 = r11.f3008a
            if (r2 != r3) goto L_0x0028
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0028:
            int r2 = r0.mo6065c()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.f3008a
            java.lang.String r4 = "FragmentManager"
            r5 = 3
            r6 = -1
            r7 = 5
            r8 = 4
            if (r2 > r12) goto L_0x007c
            if (r2 >= r12) goto L_0x0047
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.f3116m
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0047
            r10.m2221l(r11)
        L_0x0047:
            int r2 = r11.f3008a
            if (r2 == r6) goto L_0x0057
            if (r2 == 0) goto L_0x005c
            if (r2 == r1) goto L_0x0061
            if (r2 == r3) goto L_0x006b
            if (r2 == r8) goto L_0x0070
            if (r2 == r7) goto L_0x0075
            goto L_0x0136
        L_0x0057:
            if (r12 <= r6) goto L_0x005c
            r0.mo6064b()
        L_0x005c:
            if (r12 <= 0) goto L_0x0061
            r0.mo6066d()
        L_0x0061:
            if (r12 <= r6) goto L_0x0066
            r0.mo6071i()
        L_0x0066:
            if (r12 <= r1) goto L_0x006b
            r0.mo6067e()
        L_0x006b:
            if (r12 <= r3) goto L_0x0070
            r0.mo6063a()
        L_0x0070:
            if (r12 <= r8) goto L_0x0075
            r0.mo6081t()
        L_0x0075:
            if (r12 <= r7) goto L_0x0136
            r0.mo6076n()
            goto L_0x0136
        L_0x007c:
            if (r2 <= r12) goto L_0x0136
            if (r2 == 0) goto L_0x012f
            if (r2 == r1) goto L_0x0121
            if (r2 == r3) goto L_0x00c6
            if (r2 == r8) goto L_0x0097
            if (r2 == r7) goto L_0x0092
            r9 = 7
            if (r2 == r9) goto L_0x008d
            goto L_0x0136
        L_0x008d:
            if (r12 >= r9) goto L_0x0092
            r0.mo6074l()
        L_0x0092:
            if (r12 >= r7) goto L_0x0097
            r0.mo6082u()
        L_0x0097:
            if (r12 >= r8) goto L_0x00c6
            boolean r2 = m2230w0(r5)
            if (r2 == 0) goto L_0x00b3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "movefrom ACTIVITY_CREATED: "
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r4, r2)
        L_0x00b3:
            android.view.View r2 = r11.f2989H
            if (r2 == 0) goto L_0x00c6
            androidx.fragment.app.FragmentHostCallback<?> r2 = r10.f3121r
            boolean r2 = r2.onShouldSaveFragmentState(r11)
            if (r2 == 0) goto L_0x00c6
            android.util.SparseArray<android.os.Parcelable> r2 = r11.f3010c
            if (r2 != 0) goto L_0x00c6
            r0.mo6079r()
        L_0x00c6:
            if (r12 >= r3) goto L_0x0121
            r2 = 0
            android.view.View r3 = r11.f2989H
            if (r3 == 0) goto L_0x0116
            android.view.ViewGroup r7 = r11.f2988G
            if (r7 == 0) goto L_0x0116
            r7.endViewTransition(r3)
            android.view.View r3 = r11.f2989H
            r3.clearAnimation()
            boolean r3 = r11.mo5577u()
            if (r3 != 0) goto L_0x0116
            int r3 = r10.f3120q
            r7 = 0
            if (r3 <= r6) goto L_0x0101
            boolean r3 = r10.f3096G
            if (r3 != 0) goto L_0x0101
            android.view.View r3 = r11.f2989H
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x0101
            float r3 = r11.f2996O
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0101
            androidx.fragment.app.FragmentHostCallback<?> r2 = r10.f3121r
            android.content.Context r2 = r2.mo5697b()
            r3 = 0
            androidx.fragment.app.c$d r2 = androidx.fragment.app.C0679c.m2390b(r2, r11, r3)
        L_0x0101:
            r11.f2996O = r7
            android.view.ViewGroup r3 = r11.f2988G
            android.view.View r6 = r11.f2989H
            if (r2 == 0) goto L_0x010e
            androidx.fragment.app.j$g r7 = r10.f3117n
            androidx.fragment.app.C0679c.m2389a(r11, r2, r7)
        L_0x010e:
            r3.removeView(r6)
            android.view.ViewGroup r2 = r11.f2988G
            if (r3 == r2) goto L_0x0116
            return
        L_0x0116:
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.f3116m
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x0121
            r0.mo6069g()
        L_0x0121:
            if (r12 >= r1) goto L_0x012f
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.f3116m
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x012c
            goto L_0x0130
        L_0x012c:
            r0.mo6068f()
        L_0x012f:
            r1 = r12
        L_0x0130:
            if (r1 >= 0) goto L_0x0135
            r0.mo6070h()
        L_0x0135:
            r12 = r1
        L_0x0136:
            int r0 = r11.f3008a
            if (r0 == r12) goto L_0x0168
            boolean r0 = m2230w0(r5)
            if (r0 == 0) goto L_0x0166
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.f3008a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r4, r0)
        L_0x0166:
            r11.f3008a = r12
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.mo5719I0(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J0 */
    public void mo5720J0() {
        if (this.f3121r != null) {
            this.f3094E = false;
            this.f3095F = false;
            this.f3102M.mo6059p(false);
            for (Fragment next : this.f3106c.mo6099o()) {
                if (next != null) {
                    next.mo5579v();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public void mo5721K() {
        m2199Q(5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K0 */
    public void mo5722K0(@NonNull C0693h hVar) {
        Fragment j = hVar.mo6072j();
        if (!j.f2990I) {
            return;
        }
        if (this.f3105b) {
            this.f3097H = true;
            return;
        }
        j.f2990I = false;
        if (f3089P) {
            hVar.mo6073k();
        } else {
            mo5717H0(j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public void mo5723L(boolean z) {
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null) {
                next.mo5433M(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public boolean mo5724M(@NonNull Menu menu) {
        boolean z = false;
        if (this.f3120q < 1) {
            return false;
        }
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null && next.mo5434N(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M0 */
    public boolean mo5725M0(@NonNull ArrayList<C0663a> arrayList, @NonNull ArrayList<Boolean> arrayList2, @Nullable String str, int i, int i2) {
        int i3;
        Boolean bool = Boolean.TRUE;
        ArrayList<C0663a> arrayList3 = this.f3107d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f3107d.remove(size));
            arrayList2.add(bool);
        } else {
            if (str != null || i >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    C0663a aVar = this.f3107d.get(size2);
                    if ((str != null && str.equals(aVar.getName())) || (i >= 0 && i == aVar.f3258v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C0663a aVar2 = this.f3107d.get(size2);
                        if ((str == null || !str.equals(aVar2.getName())) && (i < 0 || i != aVar2.f3258v)) {
                            break;
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.f3107d.size() - 1) {
                return false;
            }
            for (int size3 = this.f3107d.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f3107d.remove(size3));
                arrayList2.add(bool);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public void mo5726N() {
        m2219g1();
        m2196J(this.f3124u);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public void mo5727O() {
        this.f3094E = false;
        this.f3095F = false;
        this.f3102M.mo6059p(false);
        m2199Q(7);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O0 */
    public void mo5728O0(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        HashSet hashSet = this.f3116m.get(fragment);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.f3116m.remove(fragment);
            if (fragment.f3008a < 5) {
                m2229u(fragment);
                mo5717H0(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public void mo5729P() {
        this.f3094E = false;
        this.f3095F = false;
        this.f3102M.mo6059p(false);
        m2199Q(5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P0 */
    public void mo5730P0(@NonNull Fragment fragment) {
        if (m2230w0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f3025r);
        }
        boolean z = !fragment.mo5550s();
        if (!fragment.f2982A || z) {
            this.f3106c.mo6104t(fragment);
            if (m2231x0(fragment)) {
                this.f3093D = true;
            }
            fragment.f3020m = true;
            m2212c1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: R */
    public void mo5731R() {
        this.f3095F = true;
        this.f3102M.mo6059p(true);
        m2199Q(4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: R0 */
    public void mo5732R0(@NonNull Fragment fragment) {
        this.f3102M.mo6056n(fragment);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: S */
    public void mo5733S() {
        m2199Q(2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: T0 */
    public void mo5734T0(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (!(this.f3121r instanceof ViewModelStoreOwner)) {
            this.f3102M.mo6057o(fragmentManagerNonConfig);
            mo5735U0(parcelable);
            return;
        }
        m2217f1(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        throw null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: U0 */
    public void mo5735U0(@Nullable Parcelable parcelable) {
        C0693h hVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f3160a != null) {
                this.f3106c.mo6105u();
                Iterator<FragmentState> it = fragmentManagerState.f3160a.iterator();
                while (it.hasNext()) {
                    FragmentState next = it.next();
                    if (next != null) {
                        Fragment g = this.f3102M.mo6049g(next.f3174b);
                        if (g != null) {
                            if (m2230w0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + g);
                            }
                            hVar = new C0693h(this.f3118o, this.f3106c, g, next);
                        } else {
                            hVar = new C0693h(this.f3118o, this.f3106c, this.f3121r.mo5697b().getClassLoader(), getFragmentFactory(), next);
                        }
                        Fragment j = hVar.mo6072j();
                        j.f3026s = this;
                        if (m2230w0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + j.f3013f + "): " + j);
                        }
                        hVar.mo6075m(this.f3121r.mo5697b().getClassLoader());
                        this.f3106c.mo6101q(hVar);
                        hVar.mo6080s(this.f3120q);
                    }
                }
                for (Fragment next2 : this.f3102M.mo6052j()) {
                    if (!this.f3106c.mo6087c(next2.f3013f)) {
                        if (m2230w0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next2 + " that was not found in the set of active Fragments " + fragmentManagerState.f3160a);
                        }
                        this.f3102M.mo6056n(next2);
                        next2.f3026s = this;
                        C0693h hVar2 = new C0693h(this.f3118o, this.f3106c, next2);
                        hVar2.mo6080s(1);
                        hVar2.mo6073k();
                        next2.f3020m = true;
                        hVar2.mo6073k();
                    }
                }
                this.f3106c.mo6106v(fragmentManagerState.f3161b);
                if (fragmentManagerState.f3162c != null) {
                    this.f3107d = new ArrayList<>(fragmentManagerState.f3162c.length);
                    int i = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.f3162c;
                        if (i >= backStackStateArr.length) {
                            break;
                        }
                        C0663a a = backStackStateArr[i].mo5380a(this);
                        if (m2230w0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + a.f3258v + "): " + a);
                            PrintWriter printWriter = new PrintWriter(new C0713m("FragmentManager"));
                            a.mo5981i("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f3107d.add(a);
                        i++;
                    }
                } else {
                    this.f3107d = null;
                }
                this.f3112i.set(fragmentManagerState.f3163d);
                String str = fragmentManagerState.f3164e;
                if (str != null) {
                    Fragment c0 = mo5748c0(str);
                    this.f3124u = c0;
                    m2196J(c0);
                }
                ArrayList<String> arrayList = fragmentManagerState.f3165f;
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        this.f3113j.put(arrayList.get(i2), fragmentManagerState.f3166g.get(i2));
                    }
                }
                this.f3092C = new ArrayDeque<>(fragmentManagerState.f3167h);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V */
    public void mo5736V(@NonNull C0649m mVar, boolean z) {
        if (!z) {
            if (this.f3121r != null) {
                m2223n();
            } else if (this.f3096G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f3104a) {
            if (this.f3121r != null) {
                this.f3104a.add(mVar);
                mo5741Y0();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: V0 */
    public FragmentManagerNonConfig mo5737V0() {
        if (!(this.f3121r instanceof ViewModelStoreOwner)) {
            return this.f3102M.mo6053k();
        }
        m2217f1(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        throw null;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: X */
    public boolean mo5738X(boolean z) {
        m2204W(z);
        boolean z2 = false;
        while (m2218g0(this.f3098I, this.f3099J)) {
            this.f3105b = true;
            try {
                m2200Q0(this.f3098I, this.f3099J);
                m2224o();
                z2 = true;
            } catch (Throwable th) {
                m2224o();
                throw th;
            }
        }
        m2219g1();
        m2202T();
        this.f3106c.mo6086b();
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: X0 */
    public Parcelable mo5739X0() {
        int size;
        m2216f0();
        m2203U();
        mo5738X(true);
        this.f3094E = true;
        this.f3102M.mo6059p(true);
        ArrayList<FragmentState> w = this.f3106c.mo6107w();
        BackStackState[] backStackStateArr = null;
        if (w.isEmpty()) {
            if (m2230w0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> x = this.f3106c.mo6108x();
        ArrayList<C0663a> arrayList = this.f3107d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i = 0; i < size; i++) {
                backStackStateArr[i] = new BackStackState(this.f3107d.get(i));
                if (m2230w0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.f3107d.get(i));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f3160a = w;
        fragmentManagerState.f3161b = x;
        fragmentManagerState.f3162c = backStackStateArr;
        fragmentManagerState.f3163d = this.f3112i.get();
        Fragment fragment = this.f3124u;
        if (fragment != null) {
            fragmentManagerState.f3164e = fragment.f3013f;
        }
        fragmentManagerState.f3165f.addAll(this.f3113j.keySet());
        fragmentManagerState.f3166g.addAll(this.f3113j.values());
        fragmentManagerState.f3167h = new ArrayList<>(this.f3092C);
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y */
    public void mo5740Y(@NonNull C0649m mVar, boolean z) {
        if (!z || (this.f3121r != null && !this.f3096G)) {
            m2204W(z);
            if (mVar.mo5850a(this.f3098I, this.f3099J)) {
                this.f3105b = true;
                try {
                    m2200Q0(this.f3098I, this.f3099J);
                } finally {
                    m2224o();
                }
            }
            m2219g1();
            m2202T();
            this.f3106c.mo6086b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Y0 */
    public void mo5741Y0() {
        synchronized (this.f3104a) {
            ArrayList<C0651o> arrayList = this.f3101L;
            boolean z = false;
            boolean z2 = arrayList != null && !arrayList.isEmpty();
            if (this.f3104a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f3121r.mo5698c().removeCallbacks(this.f3103N);
                this.f3121r.mo5698c().post(this.f3103N);
                m2219g1();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Z0 */
    public void mo5742Z0(@NonNull Fragment fragment, boolean z) {
        ViewGroup l0 = m2222l0(fragment);
        if (l0 != null && (l0 instanceof FragmentContainerView)) {
            ((FragmentContainerView) l0).setDrawDisappearingViewsLast(!z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a1 */
    public void mo5743a1(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (!fragment.equals(mo5748c0(fragment.f3013f)) || !(fragment.f3027t == null || fragment.f3026s == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.f2999R = state;
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.f3119p.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f3115l == null) {
            this.f3115l = new ArrayList<>();
        }
        this.f3115l.add(onBackStackChangedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b1 */
    public void mo5746b1(@Nullable Fragment fragment) {
        if (fragment == null || (fragment.equals(mo5748c0(fragment.f3013f)) && (fragment.f3027t == null || fragment.f3026s == this))) {
            Fragment fragment2 = this.f3124u;
            this.f3124u = fragment;
            m2196J(fragment2);
            m2196J(this.f3124u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @NonNull
    public FragmentTransaction beginTransaction() {
        return new C0663a(this);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c0 */
    public Fragment mo5748c0(@NonNull String str) {
        return this.f3106c.mo6090f(str);
    }

    public final void clearFragmentResult(@NonNull String str) {
        this.f3113j.remove(str);
    }

    public final void clearFragmentResultListener(@NonNull String str) {
        C0648l remove = this.f3114k.remove(str);
        if (remove != null) {
            remove.mo5848b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public Fragment mo5751d0(@NonNull String str) {
        return this.f3106c.mo6093i(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d1 */
    public void mo5752d1(@NonNull Fragment fragment) {
        if (m2230w0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f3033z) {
            fragment.f3033z = false;
            fragment.f2995N = !fragment.f2995N;
        }
    }

    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3106c.mo6089e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f3108e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.f3108e.get(i).toString());
            }
        }
        ArrayList<C0663a> arrayList2 = this.f3107d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                C0663a aVar = this.f3107d.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.mo5980h(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3112i.get());
        synchronized (this.f3104a) {
            int size3 = this.f3104a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size3; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.f3104a.get(i3));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3121r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3122s);
        if (this.f3123t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3123t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3120q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3094E);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3095F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3096G);
        if (this.f3093D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3093D);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5754e(C0663a aVar) {
        if (this.f3107d == null) {
            this.f3107d = new ArrayList<>();
        }
        this.f3107d.add(aVar);
    }

    public boolean executePendingTransactions() {
        boolean X = mo5738X(true);
        m2216f0();
        return X;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5756f(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        if (this.f3116m.get(fragment) == null) {
            this.f3116m.put(fragment, new HashSet());
        }
        this.f3116m.get(fragment).add(cancellationSignal);
    }

    @Nullable
    public Fragment findFragmentById(@IdRes int i) {
        return this.f3106c.mo6091g(i);
    }

    @Nullable
    public Fragment findFragmentByTag(@Nullable String str) {
        return this.f3106c.mo6092h(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5759g(@NonNull Fragment fragment) {
        if (m2230w0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        this.f3106c.mo6101q(mo5798t(fragment));
        if (!fragment.f2982A) {
            this.f3106c.mo6085a(fragment);
            fragment.f3020m = false;
            if (fragment.f2989H == null) {
                fragment.f2995N = false;
            }
            if (m2231x0(fragment)) {
                this.f3093D = true;
            }
        }
    }

    @NonNull
    public BackStackEntry getBackStackEntryAt(int i) {
        return this.f3107d.get(i);
    }

    public int getBackStackEntryCount() {
        ArrayList<C0663a> arrayList = this.f3107d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Nullable
    public Fragment getFragment(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment c0 = mo5748c0(string);
        if (c0 != null) {
            return c0;
        }
        m2217f1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    @NonNull
    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.f3125v;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.f3123t;
        if (fragment != null) {
            return fragment.f3026s.getFragmentFactory();
        }
        return this.f3126w;
    }

    @NonNull
    public List<Fragment> getFragments() {
        return this.f3106c.mo6099o();
    }

    @Nullable
    public Fragment getPrimaryNavigationFragment() {
        return this.f3124u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5766h(@NonNull Fragment fragment) {
        this.f3102M.mo6046e(fragment);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h0 */
    public int mo5767h0() {
        return this.f3106c.mo6095k();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5768i() {
        return this.f3112i.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: i0 */
    public List<Fragment> mo5769i0() {
        return this.f3106c.mo6097m();
    }

    public boolean isDestroyed() {
        return this.f3096G;
    }

    public boolean isStateSaved() {
        return this.f3094E || this.f3095F;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5772j(@androidx.annotation.NonNull androidx.fragment.app.FragmentHostCallback<?> r3, @androidx.annotation.NonNull androidx.fragment.app.FragmentContainer r4, @androidx.annotation.Nullable androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r2.f3121r
            if (r0 != 0) goto L_0x0108
            r2.f3121r = r3
            r2.f3122s = r4
            r2.f3123t = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$i r4 = new androidx.fragment.app.FragmentManager$i
            r4.<init>(r2, r5)
            r2.addFragmentOnAttachListener(r4)
            goto L_0x001f
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.FragmentOnAttachListener
            if (r4 == 0) goto L_0x001f
            r4 = r3
            androidx.fragment.app.FragmentOnAttachListener r4 = (androidx.fragment.app.FragmentOnAttachListener) r4
            r2.addFragmentOnAttachListener(r4)
        L_0x001f:
            androidx.fragment.app.Fragment r4 = r2.f3123t
            if (r4 == 0) goto L_0x0026
            r2.m2219g1()
        L_0x0026:
            boolean r4 = r3 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r4 == 0) goto L_0x003b
            r4 = r3
            androidx.activity.OnBackPressedDispatcherOwner r4 = (androidx.activity.OnBackPressedDispatcherOwner) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f3110g = r0
            if (r5 == 0) goto L_0x0036
            r4 = r5
        L_0x0036:
            androidx.activity.OnBackPressedCallback r1 = r2.f3111h
            r0.addCallback(r4, r1)
        L_0x003b:
            if (r5 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r3 = r5.f3026s
            androidx.fragment.app.g r3 = r3.m2220j0(r5)
            r2.f3102M = r3
            goto L_0x005f
        L_0x0046:
            boolean r4 = r3 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r4 == 0) goto L_0x0057
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelStore r3 = r3.getViewModelStore()
            androidx.fragment.app.g r3 = androidx.fragment.app.C0691g.m2408i(r3)
            r2.f3102M = r3
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.g r3 = new androidx.fragment.app.g
            r4 = 0
            r3.<init>(r4)
            r2.f3102M = r3
        L_0x005f:
            androidx.fragment.app.g r3 = r2.f3102M
            boolean r4 = r2.isStateSaved()
            r3.mo6059p(r4)
            androidx.fragment.app.i r3 = r2.f3106c
            androidx.fragment.app.g r4 = r2.f3102M
            r3.mo6109y(r4)
            androidx.fragment.app.FragmentHostCallback<?> r3 = r2.f3121r
            boolean r4 = r3 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r4 == 0) goto L_0x0107
            androidx.activity.result.ActivityResultRegistryOwner r3 = (androidx.activity.result.ActivityResultRegistryOwner) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x0091
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.f3013f
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x0093
        L_0x0091:
            java.lang.String r4 = ""
        L_0x0093:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r0 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r0.<init>()
            androidx.fragment.app.FragmentManager$j r1 = new androidx.fragment.app.FragmentManager$j
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r3.register(r5, r0, r1)
            r2.f3129z = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.FragmentManager$k r0 = new androidx.fragment.app.FragmentManager$k
            r0.<init>()
            androidx.fragment.app.FragmentManager$a r1 = new androidx.fragment.app.FragmentManager$a
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r3.register(r5, r0, r1)
            r2.f3090A = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r5 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r5.<init>()
            androidx.fragment.app.FragmentManager$b r0 = new androidx.fragment.app.FragmentManager$b
            r0.<init>()
            androidx.activity.result.ActivityResultLauncher r3 = r3.register(r4, r5, r0)
            r2.f3091B = r3
        L_0x0107:
            return
        L_0x0108:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.mo5772j(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo5773k(@NonNull Fragment fragment) {
        if (m2230w0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f2982A) {
            fragment.f2982A = false;
            if (!fragment.f3019l) {
                this.f3106c.mo6085a(fragment);
                if (m2230w0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (m2231x0(fragment)) {
                    this.f3093D = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: k0 */
    public FragmentContainer mo5774k0() {
        return this.f3122s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo5775m() {
        boolean z = false;
        for (Fragment next : this.f3106c.mo6097m()) {
            if (next != null) {
                z = m2231x0(next);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: m0 */
    public C0696i mo5776m0() {
        return this.f3106c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: n0 */
    public FragmentHostCallback<?> mo5777n0() {
        return this.f3121r;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: o0 */
    public LayoutInflater.Factory2 mo5778o0() {
        return this.f3109f;
    }

    @NonNull
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: p0 */
    public C0688e mo5780p0() {
        return this.f3118o;
    }

    public void popBackStack() {
        mo5736V(new C0650n((String) null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return m2197L0((String) null, -1, 0);
    }

    public void putFragment(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.f3026s == this) {
            bundle.putString(str, fragment.f3013f);
            return;
        }
        m2217f1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: q0 */
    public Fragment mo5788q0() {
        return this.f3123t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo5789r(@NonNull C0663a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.mo5983k(z3);
        } else {
            aVar.mo5982j();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.f3120q >= 1) {
            C0697j.m2469C(this.f3121r.mo5697b(), this.f3122s, arrayList, arrayList2, 0, 1, true, this.f3117n);
        }
        if (z3) {
            mo5715G0(this.f3120q, true);
        }
        for (Fragment next : this.f3106c.mo6097m()) {
            if (next != null && next.f2989H != null && next.f2994M && aVar.mo5985m(next.f3031x)) {
                float f = next.f2996O;
                if (f > 0.0f) {
                    next.f2989H.setAlpha(f);
                }
                if (z3) {
                    next.f2996O = 0.0f;
                } else {
                    next.f2996O = -1.0f;
                    next.f2994M = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: r0 */
    public C0724o mo5790r0() {
        C0724o oVar = this.f3127x;
        if (oVar != null) {
            return oVar;
        }
        Fragment fragment = this.f3123t;
        if (fragment != null) {
            return fragment.f3026s.mo5790r0();
        }
        return this.f3128y;
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.f3118o.mo6044o(fragmentLifecycleCallbacks, z);
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener fragmentOnAttachListener) {
        this.f3119p.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.f3115l;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    @Nullable
    public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment fragment) {
        C0693h n = this.f3106c.mo6098n(fragment.f3013f);
        if (n != null && n.mo6072j().equals(fragment)) {
            return n.mo6077p();
        }
        m2217f1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public void setFragmentFactory(@NonNull FragmentFactory fragmentFactory) {
        this.f3125v = fragmentFactory;
    }

    public final void setFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        C0648l lVar = this.f3114k.get(str);
        if (lVar == null || !lVar.mo5847a(Lifecycle.State.STARTED)) {
            this.f3113j.put(str, bundle);
        } else {
            lVar.onFragmentResult(str, bundle);
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void setFragmentResultListener(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final FragmentResultListener fragmentResultListener) {
        final Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            C06356 r0 = new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    Bundle bundle;
                    if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f3113j.get(str)) != null) {
                        fragmentResultListener.onFragmentResult(str, bundle);
                        FragmentManager.this.clearFragmentResult(str);
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        FragmentManager.this.f3114k.remove(str);
                    }
                }
            };
            lifecycle.addObserver(r0);
            C0648l put = this.f3114k.put(str, new C0648l(lifecycle, fragmentResultListener, r0));
            if (put != null) {
                put.mo5848b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: t */
    public C0693h mo5798t(@NonNull Fragment fragment) {
        C0693h n = this.f3106c.mo6098n(fragment.f3013f);
        if (n != null) {
            return n;
        }
        C0693h hVar = new C0693h(this.f3118o, this.f3106c, fragment);
        hVar.mo6075m(this.f3121r.mo5697b().getClassLoader());
        hVar.mo6080s(this.f3120q);
        return hVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: t0 */
    public ViewModelStore mo5799t0(@NonNull Fragment fragment) {
        return this.f3102M.mo6054l(fragment);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3123t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3123t)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.f3121r;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3121r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u0 */
    public void mo5801u0() {
        mo5738X(true);
        if (this.f3111h.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.f3110g.onBackPressed();
        }
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f3118o.mo6045p(fragmentLifecycleCallbacks);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo5803v(@NonNull Fragment fragment) {
        if (m2230w0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.f2982A) {
            fragment.f2982A = true;
            if (fragment.f3019l) {
                if (m2230w0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f3106c.mo6104t(fragment);
                if (m2231x0(fragment)) {
                    this.f3093D = true;
                }
                m2212c1(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v0 */
    public void mo5804v0(@NonNull Fragment fragment) {
        if (m2230w0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.f3033z) {
            fragment.f3033z = true;
            fragment.f2995N = true ^ fragment.f2995N;
            m2212c1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo5805w() {
        this.f3094E = false;
        this.f3095F = false;
        this.f3102M.mo6059p(false);
        m2199Q(4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo5806x() {
        this.f3094E = false;
        this.f3095F = false;
        this.f3102M.mo6059p(false);
        m2199Q(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo5807y(@NonNull Configuration configuration) {
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null) {
                next.mo5582y(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y0 */
    public boolean mo5808y0(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public boolean mo5809z(@NonNull MenuItem menuItem) {
        if (this.f3120q < 1) {
            return false;
        }
        for (Fragment next : this.f3106c.mo6099o()) {
            if (next != null && next.mo5583z(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z0 */
    public boolean mo5810z0(@Nullable Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.f3026s;
        if (!fragment.equals(fragmentManager.getPrimaryNavigationFragment()) || !mo5810z0(fragmentManager.f3123t)) {
            return false;
        }
        return true;
    }

    public void popBackStack(@Nullable String str, int i) {
        mo5736V(new C0650n(str, -1, i), false);
    }

    public boolean popBackStackImmediate(@Nullable String str, int i) {
        return m2197L0(str, -1, i);
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new C0636a();

        /* renamed from: a */
        String f3134a;

        /* renamed from: b */
        int f3135b;

        /* renamed from: androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$a */
        class C0636a implements Parcelable.Creator<LaunchedFragmentInfo> {
            C0636a() {
            }

            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        }

        LaunchedFragmentInfo(@NonNull String str, int i) {
            this.f3134a = str;
            this.f3135b = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3134a);
            parcel.writeInt(this.f3135b);
        }

        LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.f3134a = parcel.readString();
            this.f3135b = parcel.readInt();
        }
    }

    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            mo5736V(new C0650n((String) null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        if (i >= 0) {
            return m2197L0((String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }
}
