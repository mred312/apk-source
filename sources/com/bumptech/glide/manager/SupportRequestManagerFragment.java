package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: b0 */
    private final C1331a f6273b0;

    /* renamed from: c0 */
    private final RequestManagerTreeNode f6274c0;

    /* renamed from: d0 */
    private final Set<SupportRequestManagerFragment> f6275d0;
    @Nullable

    /* renamed from: e0 */
    private SupportRequestManagerFragment f6276e0;
    @Nullable

    /* renamed from: f0 */
    private RequestManager f6277f0;
    @Nullable

    /* renamed from: g0 */
    private Fragment f6278g0;

    /* renamed from: com.bumptech.glide.manager.SupportRequestManagerFragment$a */
    private class C1330a implements RequestManagerTreeNode {
        C1330a() {
        }

        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> j0 = SupportRequestManagerFragment.this.mo9996j0();
            HashSet hashSet = new HashSet(j0.size());
            for (SupportRequestManagerFragment next : j0) {
                if (next.getRequestManager() != null) {
                    hashSet.add(next.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new C1331a());
    }

    /* renamed from: i0 */
    private void m4643i0(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f6275d0.add(supportRequestManagerFragment);
    }

    @Nullable
    /* renamed from: l0 */
    private Fragment m4644l0() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f6278g0;
    }

    @Nullable
    /* renamed from: m0 */
    private static FragmentManager m4645m0(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    /* renamed from: n0 */
    private boolean m4646n0(@NonNull Fragment fragment) {
        Fragment l0 = m4644l0();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(l0)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* renamed from: o0 */
    private void m4647o0(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        m4649r0();
        SupportRequestManagerFragment l = Glide.get(context).getRequestManagerRetriever().mo9983l(context, fragmentManager);
        this.f6276e0 = l;
        if (!equals(l)) {
            this.f6276e0.m4643i0(this);
        }
    }

    /* renamed from: p0 */
    private void m4648p0(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f6275d0.remove(supportRequestManagerFragment);
    }

    /* renamed from: r0 */
    private void m4649r0() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f6276e0;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.m4648p0(this);
            this.f6276e0 = null;
        }
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.f6277f0;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.f6274c0;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: j0 */
    public Set<SupportRequestManagerFragment> mo9996j0() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f6276e0;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f6275d0);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.f6276e0.mo9996j0()) {
            if (m4646n0(next.m4644l0())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: k0 */
    public C1331a mo9997k0() {
        return this.f6273b0;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager m0 = m4645m0(this);
        if (m0 != null) {
            try {
                m4647o0(getContext(), m0);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6273b0.mo10005a();
        m4649r0();
    }

    public void onDetach() {
        super.onDetach();
        this.f6278g0 = null;
        m4649r0();
    }

    public void onStart() {
        super.onStart();
        this.f6273b0.mo10006b();
    }

    public void onStop() {
        super.onStop();
        this.f6273b0.mo10007c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q0 */
    public void mo9998q0(@Nullable Fragment fragment) {
        FragmentManager m0;
        this.f6278g0 = fragment;
        if (fragment != null && fragment.getContext() != null && (m0 = m4645m0(fragment)) != null) {
            m4647o0(fragment.getContext(), m0);
        }
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.f6277f0 = requestManager;
    }

    public String toString() {
        return super.toString() + "{parent=" + m4644l0() + "}";
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@NonNull C1331a aVar) {
        this.f6274c0 = new C1330a();
        this.f6275d0 = new HashSet();
        this.f6273b0 = aVar;
    }
}
