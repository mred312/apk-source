package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {

    /* renamed from: a */
    private final C1331a f6254a;

    /* renamed from: b */
    private final RequestManagerTreeNode f6255b;

    /* renamed from: c */
    private final Set<RequestManagerFragment> f6256c;
    @Nullable

    /* renamed from: d */
    private RequestManager f6257d;
    @Nullable

    /* renamed from: e */
    private RequestManagerFragment f6258e;
    @Nullable

    /* renamed from: f */
    private Fragment f6259f;

    /* renamed from: com.bumptech.glide.manager.RequestManagerFragment$a */
    private class C1328a implements RequestManagerTreeNode {
        C1328a() {
        }

        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> b = RequestManagerFragment.this.mo9961b();
            HashSet hashSet = new HashSet(b.size());
            for (RequestManagerFragment next : b) {
                if (next.getRequestManager() != null) {
                    hashSet.add(next.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new C1331a());
    }

    /* renamed from: a */
    private void m4619a(RequestManagerFragment requestManagerFragment) {
        this.f6256c.add(requestManagerFragment);
    }

    @TargetApi(17)
    @Nullable
    /* renamed from: d */
    private Fragment m4620d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f6259f;
    }

    @TargetApi(17)
    /* renamed from: e */
    private boolean m4621e(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* renamed from: f */
    private void m4622f(@NonNull Activity activity) {
        m4624i();
        RequestManagerFragment j = Glide.get(activity).getRequestManagerRetriever().mo9982j(activity);
        this.f6258e = j;
        if (!equals(j)) {
            this.f6258e.m4619a(this);
        }
    }

    /* renamed from: g */
    private void m4623g(RequestManagerFragment requestManagerFragment) {
        this.f6256c.remove(requestManagerFragment);
    }

    /* renamed from: i */
    private void m4624i() {
        RequestManagerFragment requestManagerFragment = this.f6258e;
        if (requestManagerFragment != null) {
            requestManagerFragment.m4623g(this);
            this.f6258e = null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    @NonNull
    /* renamed from: b */
    public Set<RequestManagerFragment> mo9961b() {
        if (equals(this.f6258e)) {
            return Collections.unmodifiableSet(this.f6256c);
        }
        if (this.f6258e == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.f6258e.mo9961b()) {
            if (m4621e(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public C1331a mo9962c() {
        return this.f6254a;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.f6257d;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.f6255b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo9965h(@Nullable Fragment fragment) {
        this.f6259f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            m4622f(fragment.getActivity());
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m4622f(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6254a.mo10005a();
        m4624i();
    }

    public void onDetach() {
        super.onDetach();
        m4624i();
    }

    public void onStart() {
        super.onStart();
        this.f6254a.mo10006b();
    }

    public void onStop() {
        super.onStop();
        this.f6254a.mo10007c();
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.f6257d = requestManager;
    }

    public String toString() {
        return super.toString() + "{parent=" + m4620d() + "}";
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(@NonNull C1331a aVar) {
        this.f6255b = new C1328a();
        this.f6256c = new HashSet();
        this.f6254a = aVar;
    }
}
