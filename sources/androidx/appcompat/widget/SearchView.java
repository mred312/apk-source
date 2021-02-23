package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: q0 */
    static final C0304k f1389q0 = (Build.VERSION.SDK_INT < 29 ? new C0304k() : null);

    /* renamed from: A */
    private Rect f1390A;

    /* renamed from: B */
    private int[] f1391B;

    /* renamed from: C */
    private int[] f1392C;

    /* renamed from: D */
    private final ImageView f1393D;

    /* renamed from: E */
    private final Drawable f1394E;

    /* renamed from: F */
    private final int f1395F;

    /* renamed from: G */
    private final int f1396G;

    /* renamed from: H */
    private final Intent f1397H;

    /* renamed from: I */
    private final Intent f1398I;

    /* renamed from: J */
    private final CharSequence f1399J;

    /* renamed from: K */
    private OnQueryTextListener f1400K;

    /* renamed from: L */
    private OnCloseListener f1401L;

    /* renamed from: M */
    View.OnFocusChangeListener f1402M;

    /* renamed from: N */
    private OnSuggestionListener f1403N;

    /* renamed from: O */
    private View.OnClickListener f1404O;

    /* renamed from: P */
    private boolean f1405P;

    /* renamed from: Q */
    private boolean f1406Q;

    /* renamed from: R */
    CursorAdapter f1407R;

    /* renamed from: S */
    private boolean f1408S;

    /* renamed from: T */
    private CharSequence f1409T;

    /* renamed from: U */
    private boolean f1410U;

    /* renamed from: V */
    private boolean f1411V;

    /* renamed from: W */
    private int f1412W;

    /* renamed from: a0 */
    private boolean f1413a0;

    /* renamed from: b0 */
    private CharSequence f1414b0;

    /* renamed from: c0 */
    private CharSequence f1415c0;

    /* renamed from: d0 */
    private boolean f1416d0;

    /* renamed from: e0 */
    private int f1417e0;

    /* renamed from: f0 */
    SearchableInfo f1418f0;

    /* renamed from: g0 */
    private Bundle f1419g0;

    /* renamed from: h0 */
    private final Runnable f1420h0;

    /* renamed from: i0 */
    private Runnable f1421i0;

    /* renamed from: j0 */
    private final WeakHashMap<String, Drawable.ConstantState> f1422j0;

    /* renamed from: k0 */
    private final View.OnClickListener f1423k0;

    /* renamed from: l0 */
    View.OnKeyListener f1424l0;

    /* renamed from: m0 */
    private final TextView.OnEditorActionListener f1425m0;

    /* renamed from: n0 */
    private final AdapterView.OnItemClickListener f1426n0;

    /* renamed from: o0 */
    private final AdapterView.OnItemSelectedListener f1427o0;

    /* renamed from: p */
    final SearchAutoComplete f1428p;

    /* renamed from: p0 */
    private TextWatcher f1429p0;

    /* renamed from: q */
    private final View f1430q;

    /* renamed from: r */
    private final View f1431r;

    /* renamed from: s */
    private final View f1432s;

    /* renamed from: t */
    final ImageView f1433t;

    /* renamed from: u */
    final ImageView f1434u;

    /* renamed from: v */
    final ImageView f1435v;

    /* renamed from: w */
    final ImageView f1436w;

    /* renamed from: x */
    private final View f1437x;

    /* renamed from: y */
    private C0305l f1438y;

    /* renamed from: z */
    private Rect f1439z;

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0292a();

        /* renamed from: b */
        boolean f1440b;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$a */
        class C0292a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0292a() {
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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1440b + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1440b));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1440b = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: d */
        private int f1441d;

        /* renamed from: e */
        private SearchView f1442e;

        /* renamed from: f */
        private boolean f1443f;

        /* renamed from: g */
        final Runnable f1444g;

        /* renamed from: androidx.appcompat.widget.SearchView$SearchAutoComplete$a */
        class C0293a implements Runnable {
            C0293a() {
            }

            public void run() {
                SearchAutoComplete.this.mo2687c();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2685a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1389q0.mo2714c(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo2686b() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo2687c() {
            if (this.f1443f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1443f = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f1441d <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1443f) {
                removeCallbacks(this.f1444g);
                post(this.f1444g);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1442e.mo2632O();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1442e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1442e.hasFocus() && getVisibility() == 0) {
                this.f1443f = true;
                if (SearchView.m928B(getContext())) {
                    mo2685a();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f1443f = false;
                removeCallbacks(this.f1444g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1443f = false;
                removeCallbacks(this.f1444g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1443f = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1442e = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1441d = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0131R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1444g = new C0293a();
            this.f1441d = getThreshold();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    class C0294a implements TextWatcher {
        C0294a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.mo2631N(charSequence);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    class C0295b implements Runnable {
        C0295b() {
        }

        public void run() {
            SearchView.this.mo2634T();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    class C0296c implements Runnable {
        C0296c() {
        }

        public void run() {
            CursorAdapter cursorAdapter = SearchView.this.f1407R;
            if (cursorAdapter instanceof C0335n) {
                cursorAdapter.changeCursor((Cursor) null);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    class C0297d implements View.OnFocusChangeListener {
        C0297d() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f1402M;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    class C0298e implements View.OnLayoutChangeListener {
        C0298e() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.mo2652r();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    class C0299f implements View.OnClickListener {
        C0299f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1433t) {
                searchView.mo2628K();
            } else if (view == searchView.f1435v) {
                searchView.mo2624G();
            } else if (view == searchView.f1434u) {
                searchView.mo2629L();
            } else if (view == searchView.f1436w) {
                searchView.mo2633P();
            } else if (view == searchView.f1428p) {
                searchView.mo2671x();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$g */
    class C0300g implements View.OnKeyListener {
        C0300g() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1418f0 == null) {
                return false;
            }
            if (searchView.f1428p.isPopupShowing() && SearchView.this.f1428p.getListSelection() != -1) {
                return SearchView.this.mo2630M(view, i, keyEvent);
            }
            if (SearchView.this.f1428p.mo2686b() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.mo2623E(0, (String) null, searchView2.f1428p.getText().toString());
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$h */
    class C0301h implements TextView.OnEditorActionListener {
        C0301h() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.mo2629L();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$i */
    class C0302i implements AdapterView.OnItemClickListener {
        C0302i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.mo2625H(i, 0, (String) null);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$j */
    class C0303j implements AdapterView.OnItemSelectedListener {
        C0303j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.mo2626I(i);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$k */
    private static class C0304k {

        /* renamed from: a */
        private Method f1456a = null;

        /* renamed from: b */
        private Method f1457b = null;

        /* renamed from: c */
        private Method f1458c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        C0304k() {
            m968d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1456a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1457b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1458c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* renamed from: d */
        private static void m968d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2712a(AutoCompleteTextView autoCompleteTextView) {
            m968d();
            Method method = this.f1457b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo2713b(AutoCompleteTextView autoCompleteTextView) {
            m968d();
            Method method = this.f1456a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo2714c(AutoCompleteTextView autoCompleteTextView) {
            m968d();
            Method method = this.f1458c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$l */
    private static class C0305l extends TouchDelegate {

        /* renamed from: a */
        private final View f1459a;

        /* renamed from: b */
        private final Rect f1460b = new Rect();

        /* renamed from: c */
        private final Rect f1461c = new Rect();

        /* renamed from: d */
        private final Rect f1462d = new Rect();

        /* renamed from: e */
        private final int f1463e;

        /* renamed from: f */
        private boolean f1464f;

        public C0305l(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1463e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            mo2715a(rect, rect2);
            this.f1459a = view;
        }

        /* renamed from: a */
        public void mo2715a(Rect rect, Rect rect2) {
            this.f1460b.set(rect);
            this.f1462d.set(rect);
            Rect rect3 = this.f1462d;
            int i = this.f1463e;
            rect3.inset(-i, -i);
            this.f1461c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0032
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003d
            L_0x001b:
                boolean r2 = r7.f1464f
                r7.f1464f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r7.f1464f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r7.f1462d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = 0
                goto L_0x003f
            L_0x002f:
                r4 = r2
            L_0x0030:
                r2 = 1
                goto L_0x003f
            L_0x0032:
                android.graphics.Rect r2 = r7.f1460b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003d
                r7.f1464f = r4
                goto L_0x0030
            L_0x003d:
                r2 = 1
                r4 = 0
            L_0x003f:
                if (r4 == 0) goto L_0x0072
                if (r2 == 0) goto L_0x005f
                android.graphics.Rect r2 = r7.f1461c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005f
                android.view.View r0 = r7.f1459a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1459a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L_0x006c
            L_0x005f:
                android.graphics.Rect r2 = r7.f1461c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L_0x006c:
                android.view.View r0 = r7.f1459a
                boolean r5 = r0.dispatchTouchEvent(r8)
            L_0x0072:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.C0305l.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: A */
    private boolean m927A() {
        SearchableInfo searchableInfo = this.f1418f0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1418f0.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1397H;
        } else if (this.f1418f0.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1398I;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: B */
    static boolean m928B(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: C */
    private boolean m929C() {
        return (this.f1408S || this.f1413a0) && !isIconified();
    }

    /* renamed from: D */
    private void m930D(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    /* renamed from: F */
    private boolean m931F(int i, int i2, String str) {
        Cursor cursor = this.f1407R.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        m930D(m942t(cursor, i2, str));
        return true;
    }

    /* renamed from: Q */
    private void m932Q() {
        post(this.f1420h0);
    }

    /* renamed from: R */
    private void m933R(int i) {
        Editable text = this.f1428p.getText();
        Cursor cursor = this.f1407R.getCursor();
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = this.f1407R.convertToString(cursor);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    /* renamed from: S */
    private void m934S() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1428p.getText());
        int i = 0;
        if (!z2 && (!this.f1405P || this.f1416d0)) {
            z = false;
        }
        ImageView imageView = this.f1435v;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f1435v.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    /* renamed from: U */
    private void m935U() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1428p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m947z(queryHint));
    }

    /* renamed from: V */
    private void m936V() {
        this.f1428p.setThreshold(this.f1418f0.getSuggestThreshold());
        this.f1428p.setImeOptions(this.f1418f0.getImeOptions());
        int inputType = this.f1418f0.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1418f0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1428p.setInputType(inputType);
        CursorAdapter cursorAdapter = this.f1407R;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor((Cursor) null);
        }
        if (this.f1418f0.getSuggestAuthority() != null) {
            C0335n nVar = new C0335n(getContext(), this, this.f1418f0, this.f1422j0);
            this.f1407R = nVar;
            this.f1428p.setAdapter(nVar);
            C0335n nVar2 = (C0335n) this.f1407R;
            if (this.f1410U) {
                i = 2;
            }
            nVar2.mo3081o(i);
        }
    }

    /* renamed from: W */
    private void m937W() {
        this.f1432s.setVisibility((!m929C() || !(this.f1434u.getVisibility() == 0 || this.f1436w.getVisibility() == 0)) ? 8 : 0);
    }

    /* renamed from: X */
    private void m938X(boolean z) {
        this.f1434u.setVisibility((!this.f1408S || !m929C() || !hasFocus() || (!z && this.f1413a0)) ? 8 : 0);
    }

    /* renamed from: Y */
    private void m939Y(boolean z) {
        this.f1406Q = z;
        int i = 0;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f1428p.getText());
        this.f1433t.setVisibility(i2);
        m938X(z2);
        this.f1430q.setVisibility(z ? 8 : 0);
        if (this.f1393D.getDrawable() == null || this.f1405P) {
            i = 8;
        }
        this.f1393D.setVisibility(i);
        m934S();
        m940Z(!z2);
        m937W();
    }

    /* renamed from: Z */
    private void m940Z(boolean z) {
        int i = 8;
        if (this.f1413a0 && !isIconified() && z) {
            this.f1434u.setVisibility(8);
            i = 0;
        }
        this.f1436w.setVisibility(i);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0131R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0131R.dimen.abc_search_view_preferred_width);
    }

    /* renamed from: s */
    private Intent m941s(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1415c0);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1419g0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1418f0.getSearchActivity());
        return intent;
    }

    /* renamed from: t */
    private Intent m942t(Cursor cursor, int i, String str) {
        int i2;
        Uri uri;
        String f;
        try {
            String f2 = C0335n.m1148f(cursor, "suggest_intent_action");
            if (f2 == null) {
                f2 = this.f1418f0.getSuggestIntentAction();
            }
            if (f2 == null) {
                f2 = "android.intent.action.SEARCH";
            }
            String str2 = f2;
            String f3 = C0335n.m1148f(cursor, "suggest_intent_data");
            if (f3 == null) {
                f3 = this.f1418f0.getSuggestIntentData();
            }
            if (!(f3 == null || (f = C0335n.m1148f(cursor, "suggest_intent_data_id")) == null)) {
                f3 = f3 + "/" + Uri.encode(f);
            }
            if (f3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(f3);
            }
            return m941s(str2, uri, C0335n.m1148f(cursor, "suggest_intent_extra_data"), C0335n.m1148f(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            return null;
        }
    }

    /* renamed from: u */
    private Intent m943u(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1419g0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: v */
    private Intent m944v(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    /* renamed from: w */
    private void m945w() {
        this.f1428p.dismissDropDown();
    }

    /* renamed from: y */
    private void m946y(View view, Rect rect) {
        view.getLocationInWindow(this.f1391B);
        getLocationInWindow(this.f1392C);
        int[] iArr = this.f1391B;
        int i = iArr[1];
        int[] iArr2 = this.f1392C;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    /* renamed from: z */
    private CharSequence m947z(CharSequence charSequence) {
        if (!this.f1405P || this.f1394E == null) {
            return charSequence;
        }
        double textSize = (double) this.f1428p.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.f1394E.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1394E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo2623E(int i, String str, String str2) {
        getContext().startActivity(m941s("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public void mo2624G() {
        if (!TextUtils.isEmpty(this.f1428p.getText())) {
            this.f1428p.setText("");
            this.f1428p.requestFocus();
            this.f1428p.setImeVisibility(true);
        } else if (this.f1405P) {
            OnCloseListener onCloseListener = this.f1401L;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                m939Y(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public boolean mo2625H(int i, int i2, String str) {
        OnSuggestionListener onSuggestionListener = this.f1403N;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i)) {
            return false;
        }
        m931F(i, 0, (String) null);
        this.f1428p.setImeVisibility(false);
        m945w();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public boolean mo2626I(int i) {
        OnSuggestionListener onSuggestionListener = this.f1403N;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i)) {
            return false;
        }
        m933R(i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public void mo2627J(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public void mo2628K() {
        m939Y(false);
        this.f1428p.requestFocus();
        this.f1428p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1404O;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public void mo2629L() {
        Editable text = this.f1428p.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.f1400K;
            if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
                if (this.f1418f0 != null) {
                    mo2623E(0, (String) null, text.toString());
                }
                this.f1428p.setImeVisibility(false);
                m945w();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public boolean mo2630M(View view, int i, KeyEvent keyEvent) {
        int i2;
        if (this.f1418f0 != null && this.f1407R != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return mo2625H(this.f1428p.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                if (i == 21) {
                    i2 = 0;
                } else {
                    i2 = this.f1428p.length();
                }
                this.f1428p.setSelection(i2);
                this.f1428p.setListSelection(0);
                this.f1428p.clearListSelection();
                this.f1428p.mo2685a();
                return true;
            } else if (i != 19 || this.f1428p.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public void mo2631N(CharSequence charSequence) {
        Editable text = this.f1428p.getText();
        this.f1415c0 = text;
        boolean z = !TextUtils.isEmpty(text);
        m938X(z);
        m940Z(!z);
        m934S();
        m937W();
        if (this.f1400K != null && !TextUtils.equals(charSequence, this.f1414b0)) {
            this.f1400K.onQueryTextChange(charSequence.toString());
        }
        this.f1414b0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public void mo2632O() {
        m939Y(isIconified());
        m932Q();
        if (this.f1428p.hasFocus()) {
            mo2671x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public void mo2633P() {
        SearchableInfo searchableInfo = this.f1418f0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m944v(this.f1397H, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m943u(this.f1398I, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: T */
    public void mo2634T() {
        int[] iArr = this.f1428p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1431r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1432s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void clearFocus() {
        this.f1411V = true;
        super.clearFocus();
        this.f1428p.clearFocus();
        this.f1428p.setImeVisibility(false);
        this.f1411V = false;
    }

    public int getImeOptions() {
        return this.f1428p.getImeOptions();
    }

    public int getInputType() {
        return this.f1428p.getInputType();
    }

    public int getMaxWidth() {
        return this.f1412W;
    }

    public CharSequence getQuery() {
        return this.f1428p.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1409T;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1418f0;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.f1399J;
        }
        return getContext().getText(this.f1418f0.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.f1396G;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.f1395F;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f1407R;
    }

    public boolean isIconfiedByDefault() {
        return this.f1405P;
    }

    public boolean isIconified() {
        return this.f1406Q;
    }

    public boolean isQueryRefinementEnabled() {
        return this.f1410U;
    }

    public boolean isSubmitButtonEnabled() {
        return this.f1408S;
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        m939Y(true);
        this.f1428p.setImeOptions(this.f1417e0);
        this.f1416d0 = false;
    }

    public void onActionViewExpanded() {
        if (!this.f1416d0) {
            this.f1416d0 = true;
            int imeOptions = this.f1428p.getImeOptions();
            this.f1417e0 = imeOptions;
            this.f1428p.setImeOptions(imeOptions | 33554432);
            this.f1428p.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1420h0);
        post(this.f1421i0);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m946y(this.f1428p, this.f1439z);
            Rect rect = this.f1390A;
            Rect rect2 = this.f1439z;
            rect.set(rect2.left, 0, rect2.right, i4 - i2);
            C0305l lVar = this.f1438y;
            if (lVar == null) {
                C0305l lVar2 = new C0305l(this.f1390A, this.f1439z, this.f1428p);
                this.f1438y = lVar2;
                setTouchDelegate(lVar2);
                return;
            }
            lVar.mo2715a(this.f1390A, this.f1439z);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f1412W;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f1412W;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.f1412W) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m939Y(savedState.f1440b);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1440b = isIconified();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m932Q();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo2652r() {
        int i;
        if (this.f1437x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1431r.getPaddingLeft();
            Rect rect = new Rect();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int dimensionPixelSize = this.f1405P ? resources.getDimensionPixelSize(C0131R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(C0131R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1428p.getDropDownBackground().getPadding(rect);
            if (isLayoutRtl) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f1428p.setDropDownHorizontalOffset(i);
            this.f1428p.setDropDownWidth((((this.f1437x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1411V || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1428p.requestFocus(i, rect);
        if (requestFocus) {
            m939Y(false);
        }
        return requestFocus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.f1419g0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            mo2624G();
        } else {
            mo2628K();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1405P != z) {
            this.f1405P = z;
            m939Y(z);
            m935U();
        }
    }

    public void setImeOptions(int i) {
        this.f1428p.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1428p.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1412W = i;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f1401L = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1402M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.f1400K = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1404O = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.f1403N = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.f1428p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1428p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1415c0 = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            mo2629L();
        }
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.f1409T = charSequence;
        m935U();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1410U = z;
        CursorAdapter cursorAdapter = this.f1407R;
        if (cursorAdapter instanceof C0335n) {
            ((C0335n) cursorAdapter).mo3081o(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1418f0 = searchableInfo;
        if (searchableInfo != null) {
            m936V();
            m935U();
        }
        boolean A = m927A();
        this.f1413a0 = A;
        if (A) {
            this.f1428p.setPrivateImeOptions("nm");
        }
        m939Y(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1408S = z;
        m939Y(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f1407R = cursorAdapter;
        this.f1428p.setAdapter(cursorAdapter);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public void mo2671x() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1428p.refreshAutoCompleteResults();
            return;
        }
        C0304k kVar = f1389q0;
        kVar.mo2713b(this.f1428p);
        kVar.mo2712a(this.f1428p);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1439z = new Rect();
        this.f1390A = new Rect();
        this.f1391B = new int[2];
        this.f1392C = new int[2];
        this.f1420h0 = new C0295b();
        this.f1421i0 = new C0296c();
        this.f1422j0 = new WeakHashMap<>();
        C0299f fVar = new C0299f();
        this.f1423k0 = fVar;
        this.f1424l0 = new C0300g();
        C0301h hVar = new C0301h();
        this.f1425m0 = hVar;
        C0302i iVar = new C0302i();
        this.f1426n0 = iVar;
        C0303j jVar = new C0303j();
        this.f1427o0 = jVar;
        this.f1429p0 = new C0294a();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0131R.styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(C0131R.styleable.SearchView_layout, C0131R.layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(C0131R.C0133id.search_src_text);
        this.f1428p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1430q = findViewById(C0131R.C0133id.search_edit_frame);
        View findViewById = findViewById(C0131R.C0133id.search_plate);
        this.f1431r = findViewById;
        View findViewById2 = findViewById(C0131R.C0133id.submit_area);
        this.f1432s = findViewById2;
        ImageView imageView = (ImageView) findViewById(C0131R.C0133id.search_button);
        this.f1433t = imageView;
        ImageView imageView2 = (ImageView) findViewById(C0131R.C0133id.search_go_btn);
        this.f1434u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(C0131R.C0133id.search_close_btn);
        this.f1435v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(C0131R.C0133id.search_voice_btn);
        this.f1436w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(C0131R.C0133id.search_mag_icon);
        this.f1393D = imageView5;
        ViewCompat.setBackground(findViewById, obtainStyledAttributes.getDrawable(C0131R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(findViewById2, obtainStyledAttributes.getDrawable(C0131R.styleable.SearchView_submitBackground));
        int i2 = C0131R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(obtainStyledAttributes.getDrawable(i2));
        imageView2.setImageDrawable(obtainStyledAttributes.getDrawable(C0131R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(obtainStyledAttributes.getDrawable(C0131R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(obtainStyledAttributes.getDrawable(C0131R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(obtainStyledAttributes.getDrawable(i2));
        this.f1394E = obtainStyledAttributes.getDrawable(C0131R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(imageView, getResources().getString(C0131R.string.abc_searchview_description_search));
        this.f1395F = obtainStyledAttributes.getResourceId(C0131R.styleable.SearchView_suggestionRowLayout, C0131R.layout.abc_search_dropdown_item_icons_2line);
        this.f1396G = obtainStyledAttributes.getResourceId(C0131R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1429p0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f1424l0);
        searchAutoComplete.setOnFocusChangeListener(new C0297d());
        setIconifiedByDefault(obtainStyledAttributes.getBoolean(C0131R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f1399J = obtainStyledAttributes.getText(C0131R.styleable.SearchView_defaultQueryHint);
        this.f1409T = obtainStyledAttributes.getText(C0131R.styleable.SearchView_queryHint);
        int i3 = obtainStyledAttributes.getInt(C0131R.styleable.SearchView_android_imeOptions, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = obtainStyledAttributes.getInt(C0131R.styleable.SearchView_android_inputType, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(obtainStyledAttributes.getBoolean(C0131R.styleable.SearchView_android_focusable, true));
        obtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1397H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1398I = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1437x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new C0298e());
        }
        m939Y(this.f1405P);
        m935U();
    }

    private void setQuery(CharSequence charSequence) {
        this.f1428p.setText(charSequence);
        this.f1428p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
