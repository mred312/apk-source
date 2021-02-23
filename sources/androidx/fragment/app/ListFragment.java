package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListFragment extends Fragment {

    /* renamed from: b0 */
    private final Handler f3243b0 = new Handler();

    /* renamed from: c0 */
    private final Runnable f3244c0 = new C0661a();

    /* renamed from: d0 */
    private final AdapterView.OnItemClickListener f3245d0 = new C0662b();

    /* renamed from: e0 */
    ListAdapter f3246e0;

    /* renamed from: f0 */
    ListView f3247f0;

    /* renamed from: g0 */
    View f3248g0;

    /* renamed from: h0 */
    TextView f3249h0;

    /* renamed from: i0 */
    View f3250i0;

    /* renamed from: j0 */
    View f3251j0;

    /* renamed from: k0 */
    CharSequence f3252k0;

    /* renamed from: l0 */
    boolean f3253l0;

    /* renamed from: androidx.fragment.app.ListFragment$a */
    class C0661a implements Runnable {
        C0661a() {
        }

        public void run() {
            ListView listView = ListFragment.this.f3247f0;
            listView.focusableViewAvailable(listView);
        }
    }

    /* renamed from: androidx.fragment.app.ListFragment$b */
    class C0662b implements AdapterView.OnItemClickListener {
        C0662b() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    }

    /* renamed from: i0 */
    private void m2350i0() {
        if (this.f3247f0 == null) {
            View view = getView();
            if (view != null) {
                if (view instanceof ListView) {
                    this.f3247f0 = (ListView) view;
                } else {
                    TextView textView = (TextView) view.findViewById(16711681);
                    this.f3249h0 = textView;
                    if (textView == null) {
                        this.f3248g0 = view.findViewById(16908292);
                    } else {
                        textView.setVisibility(8);
                    }
                    this.f3250i0 = view.findViewById(16711682);
                    this.f3251j0 = view.findViewById(16711683);
                    View findViewById = view.findViewById(16908298);
                    if (findViewById instanceof ListView) {
                        ListView listView = (ListView) findViewById;
                        this.f3247f0 = listView;
                        View view2 = this.f3248g0;
                        if (view2 != null) {
                            listView.setEmptyView(view2);
                        } else {
                            CharSequence charSequence = this.f3252k0;
                            if (charSequence != null) {
                                this.f3249h0.setText(charSequence);
                                this.f3247f0.setEmptyView(this.f3249h0);
                            }
                        }
                    } else if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    } else {
                        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    }
                }
                this.f3253l0 = true;
                this.f3247f0.setOnItemClickListener(this.f3245d0);
                ListAdapter listAdapter = this.f3246e0;
                if (listAdapter != null) {
                    this.f3246e0 = null;
                    setListAdapter(listAdapter);
                } else if (this.f3250i0 != null) {
                    m2351j0(false, false);
                }
                this.f3243b0.post(this.f3244c0);
                return;
            }
            throw new IllegalStateException("Content view not yet created");
        }
    }

    /* renamed from: j0 */
    private void m2351j0(boolean z, boolean z2) {
        m2350i0();
        View view = this.f3250i0;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f3253l0 != z) {
            this.f3253l0 = z;
            if (z) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.f3251j0.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    view.clearAnimation();
                    this.f3251j0.clearAnimation();
                }
                this.f3250i0.setVisibility(8);
                this.f3251j0.setVisibility(0);
                return;
            }
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.f3251j0.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                view.clearAnimation();
                this.f3251j0.clearAnimation();
            }
            this.f3250i0.setVisibility(0);
            this.f3251j0.setVisibility(8);
        }
    }

    @Nullable
    public ListAdapter getListAdapter() {
        return this.f3246e0;
    }

    @NonNull
    public ListView getListView() {
        m2350i0();
        return this.f3247f0;
    }

    public long getSelectedItemId() {
        m2350i0();
        return this.f3247f0.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        m2350i0();
        return this.f3247f0.getSelectedItemPosition();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onDestroyView() {
        this.f3243b0.removeCallbacks(this.f3244c0);
        this.f3247f0 = null;
        this.f3253l0 = false;
        this.f3251j0 = null;
        this.f3250i0 = null;
        this.f3248g0 = null;
        this.f3249h0 = null;
        super.onDestroyView();
    }

    public void onListItemClick(@NonNull ListView listView, @NonNull View view, int i, long j) {
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m2350i0();
    }

    @NonNull
    public final ListAdapter requireListAdapter() {
        ListAdapter listAdapter = getListAdapter();
        if (listAdapter != null) {
            return listAdapter;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void setEmptyText(@Nullable CharSequence charSequence) {
        m2350i0();
        TextView textView = this.f3249h0;
        if (textView != null) {
            textView.setText(charSequence);
            if (this.f3252k0 == null) {
                this.f3247f0.setEmptyView(this.f3249h0);
            }
            this.f3252k0 = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(@Nullable ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f3246e0 != null;
        this.f3246e0 = listAdapter;
        ListView listView = this.f3247f0;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.f3253l0 && !z2) {
                if (requireView().getWindowToken() != null) {
                    z = true;
                }
                m2351j0(true, z);
            }
        }
    }

    public void setListShown(boolean z) {
        m2351j0(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        m2351j0(z, false);
    }

    public void setSelection(int i) {
        m2350i0();
        this.f3247f0.setSelection(i);
    }
}
