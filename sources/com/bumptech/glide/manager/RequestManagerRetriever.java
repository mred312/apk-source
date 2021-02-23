package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: i */
    private static final RequestManagerFactory f6261i = new C1329a();

    /* renamed from: a */
    private volatile RequestManager f6262a;
    @VisibleForTesting

    /* renamed from: b */
    final Map<FragmentManager, RequestManagerFragment> f6263b = new HashMap();
    @VisibleForTesting

    /* renamed from: c */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f6264c = new HashMap();

    /* renamed from: d */
    private final Handler f6265d;

    /* renamed from: e */
    private final RequestManagerFactory f6266e;

    /* renamed from: f */
    private final ArrayMap<View, Fragment> f6267f = new ArrayMap<>();

    /* renamed from: g */
    private final ArrayMap<View, android.app.Fragment> f6268g = new ArrayMap<>();

    /* renamed from: h */
    private final Bundle f6269h = new Bundle();

    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    /* renamed from: com.bumptech.glide.manager.RequestManagerRetriever$a */
    class C1329a implements RequestManagerFactory {
        C1329a() {
        }

        @NonNull
        public RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory) {
        this.f6266e = requestManagerFactory == null ? f6261i : requestManagerFactory;
        this.f6265d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    /* renamed from: a */
    private static void m4628a(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    /* renamed from: b */
    private static Activity m4629b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m4629b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    /* renamed from: c */
    private void m4630c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment next : fragmentManager.getFragments()) {
                if (next.getView() != null) {
                    arrayMap.put(next.getView(), next);
                    m4630c(next.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        m4631d(fragmentManager, arrayMap);
    }

    @Deprecated
    /* renamed from: d */
    private void m4631d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.f6269h.putInt("key", i);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f6269h, "key");
            } catch (Exception unused) {
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    if (Build.VERSION.SDK_INT >= 17) {
                        m4630c(fragment.getChildFragmentManager(), arrayMap);
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: e */
    private static void m4632e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.getView() == null)) {
                    map.put(next.getView(), next);
                    m4632e(next.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    @Deprecated
    @Nullable
    /* renamed from: f */
    private android.app.Fragment m4633f(@NonNull View view, @NonNull Activity activity) {
        this.f6268g.clear();
        m4630c(activity.getFragmentManager(), this.f6268g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f6268g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f6268g.clear();
        return fragment;
    }

    @Nullable
    /* renamed from: g */
    private Fragment m4634g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f6267f.clear();
        m4632e(fragmentActivity.getSupportFragmentManager().getFragments(), this.f6267f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f6267f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f6267f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    /* renamed from: h */
    private RequestManager m4635h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment k = m4637k(fragmentManager, fragment, z);
        RequestManager requestManager = k.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager build = this.f6266e.build(Glide.get(context), k.mo9962c(), k.getRequestManagerTreeNode(), context);
        k.setRequestManager(build);
        return build;
    }

    @NonNull
    /* renamed from: i */
    private RequestManager m4636i(@NonNull Context context) {
        if (this.f6262a == null) {
            synchronized (this) {
                if (this.f6262a == null) {
                    this.f6262a = this.f6266e.build(Glide.get(context.getApplicationContext()), new C1332b(), new C1335d(), context.getApplicationContext());
                }
            }
        }
        return this.f6262a;
    }

    @NonNull
    /* renamed from: k */
    private RequestManagerFragment m4637k(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f6263b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.mo9965h(fragment);
            if (z) {
                requestManagerFragment.mo9962c().mo10006b();
            }
            this.f6263b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f6265d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    /* renamed from: m */
    private SupportRequestManagerFragment m4638m(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f6264c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.mo9998q0(fragment);
            if (z) {
                supportRequestManagerFragment.mo9997k0().mo10006b();
            }
            this.f6264c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f6265d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    /* renamed from: n */
    private static boolean m4639n(Context context) {
        Activity b = m4629b(context);
        return b == null || !b.isFinishing();
    }

    @NonNull
    /* renamed from: o */
    private RequestManager m4640o(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment m = m4638m(fragmentManager, fragment, z);
        RequestManager requestManager = m.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager build = this.f6266e.build(Glide.get(context), m.mo9997k0(), m.getRequestManagerTreeNode(), context);
        m.setRequestManager(build);
        return build;
    }

    @NonNull
    public RequestManager get(@NonNull Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return get(contextWrapper.getBaseContext());
                    }
                }
            }
            return m4636i(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i = message.what;
        Object obj4 = null;
        boolean z = true;
        if (i == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.f6263b.remove(obj3);
        } else if (i != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.f6264c.remove(obj3);
        }
        Object obj5 = obj3;
        obj4 = obj2;
        obj = obj5;
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        return z;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    /* renamed from: j */
    public RequestManagerFragment mo9982j(Activity activity) {
        return m4637k(activity.getFragmentManager(), (android.app.Fragment) null, m4639n(activity));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: l */
    public SupportRequestManagerFragment mo9983l(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return m4638m(fragmentManager, (Fragment) null, m4639n(context));
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        m4628a(fragmentActivity);
        return m4640o(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, m4639n(fragmentActivity));
    }

    @NonNull
    public RequestManager get(@NonNull Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        return m4640o(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public RequestManager get(@NonNull Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        m4628a(activity);
        return m4635h(activity, activity.getFragmentManager(), (android.app.Fragment) null, m4639n(activity));
    }

    @NonNull
    public RequestManager get(@NonNull View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity b = m4629b(view.getContext());
        if (b == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (b instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) b;
            Fragment g = m4634g(view, fragmentActivity);
            return g != null ? get(g) : get(fragmentActivity);
        }
        android.app.Fragment f = m4633f(view, b);
        if (f == null) {
            return get(b);
        }
        return get(f);
    }

    @TargetApi(17)
    @NonNull
    @Deprecated
    public RequestManager get(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (Util.isOnBackgroundThread() || Build.VERSION.SDK_INT < 17) {
            return get(fragment.getActivity().getApplicationContext());
        } else {
            return m4635h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }
}
