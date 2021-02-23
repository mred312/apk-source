package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: c */
    private final FragmentManager f3186c;

    /* renamed from: d */
    private final int f3187d;

    /* renamed from: e */
    private FragmentTransaction f3188e;

    /* renamed from: f */
    private ArrayList<Fragment.SavedState> f3189f;

    /* renamed from: g */
    private ArrayList<Fragment> f3190g;

    /* renamed from: h */
    private Fragment f3191h;

    /* renamed from: i */
    private boolean f3192i;

    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f3188e == null) {
            this.f3188e = this.f3186c.beginTransaction();
        }
        while (this.f3189f.size() <= i) {
            this.f3189f.add((Object) null);
        }
        this.f3189f.set(i, fragment.isAdded() ? this.f3186c.saveFragmentInstanceState(fragment) : null);
        this.f3190g.set(i, (Object) null);
        this.f3188e.remove(fragment);
        if (fragment.equals(this.f3191h)) {
            this.f3191h = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f3188e;
        if (fragmentTransaction != null) {
            if (!this.f3192i) {
                try {
                    this.f3192i = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                    this.f3192i = false;
                } catch (Throwable th) {
                    this.f3192i = false;
                    throw th;
                }
            }
            this.f3188e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i);

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f3190g.size() > i && (fragment = this.f3190g.get(i)) != null) {
            return fragment;
        }
        if (this.f3188e == null) {
            this.f3188e = this.f3186c.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.f3189f.size() > i && (savedState = this.f3189f.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f3190g.size() <= i) {
            this.f3190g.add((Object) null);
        }
        item.setMenuVisibility(false);
        if (this.f3187d == 0) {
            item.setUserVisibleHint(false);
        }
        this.f3190g.set(i, item);
        this.f3188e.add(viewGroup.getId(), item);
        if (this.f3187d == 1) {
            this.f3188e.setMaxLifecycle(item, Lifecycle.State.STARTED);
        }
        return item;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f3189f.clear();
            this.f3190g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f3189f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f3186c.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f3190g.size() <= parseInt) {
                            this.f3190g.add((Object) null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f3190g.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Nullable
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f3189f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f3189f.size()];
            this.f3189f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f3190g.size(); i++) {
            Fragment fragment = this.f3190g.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f3186c.putFragment(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f3191h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f3187d == 1) {
                    if (this.f3188e == null) {
                        this.f3188e = this.f3186c.beginTransaction();
                    }
                    this.f3188e.setMaxLifecycle(this.f3191h, Lifecycle.State.STARTED);
                } else {
                    this.f3191h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f3187d == 1) {
                if (this.f3188e == null) {
                    this.f3188e = this.f3186c.beginTransaction();
                }
                this.f3188e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f3191h = fragment;
        }
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager, int i) {
        this.f3188e = null;
        this.f3189f = new ArrayList<>();
        this.f3190g = new ArrayList<>();
        this.f3191h = null;
        this.f3186c = fragmentManager;
        this.f3187d = i;
    }
}
