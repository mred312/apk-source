package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    private final ArrayList<C0656b> f3193a = new ArrayList<>();

    /* renamed from: b */
    private FrameLayout f3194b;

    /* renamed from: c */
    private Context f3195c;

    /* renamed from: d */
    private FragmentManager f3196d;

    /* renamed from: e */
    private int f3197e;

    /* renamed from: f */
    private TabHost.OnTabChangeListener f3198f;

    /* renamed from: g */
    private C0656b f3199g;

    /* renamed from: h */
    private boolean f3200h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0654a();

        /* renamed from: a */
        String f3201a;

        /* renamed from: androidx.fragment.app.FragmentTabHost$SavedState$a */
        class C0654a implements Parcelable.Creator<SavedState> {
            C0654a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3201a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3201a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3201a = parcel.readString();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTabHost$a */
    static class C0655a implements TabHost.TabContentFactory {

        /* renamed from: a */
        private final Context f3202a;

        public C0655a(Context context) {
            this.f3202a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f3202a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTabHost$b */
    static final class C0656b {
        @NonNull

        /* renamed from: a */
        final String f3203a;
        @NonNull

        /* renamed from: b */
        final Class<?> f3204b;
        @Nullable

        /* renamed from: c */
        final Bundle f3205c;

        /* renamed from: d */
        Fragment f3206d;

        C0656b(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
            this.f3203a = str;
            this.f3204b = cls;
            this.f3205c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, (AttributeSet) null);
        m2335e(context, (AttributeSet) null);
    }

    @Nullable
    /* renamed from: a */
    private FragmentTransaction m2331a(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        C0656b d = m2334d(str);
        if (this.f3199g != d) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f3196d.beginTransaction();
            }
            C0656b bVar = this.f3199g;
            if (!(bVar == null || (fragment = bVar.f3206d) == null)) {
                fragmentTransaction.detach(fragment);
            }
            if (d != null) {
                Fragment fragment2 = d.f3206d;
                if (fragment2 == null) {
                    Fragment instantiate = this.f3196d.getFragmentFactory().instantiate(this.f3195c.getClassLoader(), d.f3204b.getName());
                    d.f3206d = instantiate;
                    instantiate.setArguments(d.f3205c);
                    fragmentTransaction.add(this.f3197e, d.f3206d, d.f3203a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.f3199g = d;
        }
        return fragmentTransaction;
    }

    /* renamed from: b */
    private void m2332b() {
        if (this.f3194b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f3197e);
            this.f3194b = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f3197e);
            }
        }
    }

    /* renamed from: c */
    private void m2333c(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f3194b = frameLayout2;
            frameLayout2.setId(this.f3197e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    /* renamed from: d */
    private C0656b m2334d(String str) {
        int size = this.f3193a.size();
        for (int i = 0; i < size; i++) {
            C0656b bVar = this.f3193a.get(i);
            if (bVar.f3203a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: e */
    private void m2335e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f3197e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new C0655a(this.f3195c));
        String tag = tabSpec.getTag();
        C0656b bVar = new C0656b(tag, cls, bundle);
        if (this.f3200h) {
            Fragment findFragmentByTag = this.f3196d.findFragmentByTag(tag);
            bVar.f3206d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                FragmentTransaction beginTransaction = this.f3196d.beginTransaction();
                beginTransaction.detach(bVar.f3206d);
                beginTransaction.commit();
            }
        }
        this.f3193a.add(bVar);
        addTab(tabSpec);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f3193a.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            C0656b bVar = this.f3193a.get(i);
            Fragment findFragmentByTag = this.f3196d.findFragmentByTag(bVar.f3203a);
            bVar.f3206d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (bVar.f3203a.equals(currentTabTag)) {
                    this.f3199g = bVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f3196d.beginTransaction();
                    }
                    fragmentTransaction.detach(bVar.f3206d);
                }
            }
        }
        this.f3200h = true;
        FragmentTransaction a = m2331a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f3196d.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3200h = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f3201a);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3201a = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction a;
        if (this.f3200h && (a = m2331a(str, (FragmentTransaction) null)) != null) {
            a.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3198f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3198f = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        m2333c(context);
        super.setup();
        this.f3195c = context;
        this.f3196d = fragmentManager;
        m2332b();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2335e(context, attributeSet);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i) {
        m2333c(context);
        super.setup();
        this.f3195c = context;
        this.f3196d = fragmentManager;
        this.f3197e = i;
        m2332b();
        this.f3194b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}
