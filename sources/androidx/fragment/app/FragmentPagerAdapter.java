package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: c */
    private final FragmentManager f3168c;

    /* renamed from: d */
    private final int f3169d;

    /* renamed from: e */
    private FragmentTransaction f3170e;

    /* renamed from: f */
    private Fragment f3171f;

    /* renamed from: g */
    private boolean f3172g;

    @Deprecated
    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    /* renamed from: b */
    private static String m2328b(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f3170e == null) {
            this.f3170e = this.f3168c.beginTransaction();
        }
        this.f3170e.detach(fragment);
        if (fragment.equals(this.f3171f)) {
            this.f3171f = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f3170e;
        if (fragmentTransaction != null) {
            if (!this.f3172g) {
                try {
                    this.f3172g = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                    this.f3172g = false;
                } catch (Throwable th) {
                    this.f3172g = false;
                    throw th;
                }
            }
            this.f3170e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        if (this.f3170e == null) {
            this.f3170e = this.f3168c.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = this.f3168c.findFragmentByTag(m2328b(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f3170e.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.f3170e.add(viewGroup.getId(), findFragmentByTag, m2328b(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f3171f) {
            findFragmentByTag.setMenuVisibility(false);
            if (this.f3169d == 1) {
                this.f3170e.setMaxLifecycle(findFragmentByTag, Lifecycle.State.STARTED);
            } else {
                findFragmentByTag.setUserVisibleHint(false);
            }
        }
        return findFragmentByTag;
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f3171f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f3169d == 1) {
                    if (this.f3170e == null) {
                        this.f3170e = this.f3168c.beginTransaction();
                    }
                    this.f3170e.setMaxLifecycle(this.f3171f, Lifecycle.State.STARTED);
                } else {
                    this.f3171f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f3169d == 1) {
                if (this.f3170e == null) {
                    this.f3170e = this.f3168c.beginTransaction();
                }
                this.f3170e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f3171f = fragment;
        }
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager, int i) {
        this.f3170e = null;
        this.f3171f = null;
        this.f3168c = fragmentManager;
        this.f3169d = i;
    }
}
