package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {

    /* renamed from: a */
    private C0750a f3515a;

    /* renamed from: androidx.lifecycle.ReportFragment$a */
    interface C0750a {
        /* renamed from: a */
        void mo6236a();

        void onResume();

        void onStart();
    }

    @RequiresApi(29)
    /* renamed from: androidx.lifecycle.ReportFragment$b */
    static class C0751b implements Application.ActivityLifecycleCallbacks {
        C0751b() {
        }

        static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new C0751b());
        }

        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            ReportFragment.m2575a(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(@NonNull Activity activity) {
            ReportFragment.m2575a(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(@NonNull Activity activity) {
            ReportFragment.m2575a(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(@NonNull Activity activity) {
            ReportFragment.m2575a(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(@NonNull Activity activity) {
            ReportFragment.m2575a(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(@NonNull Activity activity) {
            ReportFragment.m2575a(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(@NonNull Activity activity) {
        }

        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        public void onActivityStarted(@NonNull Activity activity) {
        }

        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    /* renamed from: a */
    static void m2575a(@NonNull Activity activity, @NonNull Lifecycle.Event event) {
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof LifecycleRegistry) {
                ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
            }
        }
    }

    /* renamed from: b */
    private void m2576b(@NonNull Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            m2575a(getActivity(), event);
        }
    }

    /* renamed from: c */
    private void m2577c(C0750a aVar) {
        if (aVar != null) {
            aVar.mo6236a();
        }
    }

    /* renamed from: d */
    private void m2578d(C0750a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    /* renamed from: e */
    private void m2579e(C0750a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public static void injectIfNeededIn(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            C0751b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m2577c(this.f3515a);
        m2576b(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        m2576b(Lifecycle.Event.ON_DESTROY);
        this.f3515a = null;
    }

    public void onPause() {
        super.onPause();
        m2576b(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        m2578d(this.f3515a);
        m2576b(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        m2579e(this.f3515a);
        m2576b(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        m2576b(Lifecycle.Event.ON_STOP);
    }
}
