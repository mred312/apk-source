package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {

    /* renamed from: G */
    private static Method f1297G = null;

    /* renamed from: H */
    private static Method f1298H = null;

    /* renamed from: I */
    private static Method f1299I = null;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: A */
    private Runnable f1300A;

    /* renamed from: B */
    final Handler f1301B;

    /* renamed from: C */
    private final Rect f1302C;

    /* renamed from: D */
    private Rect f1303D;

    /* renamed from: E */
    private boolean f1304E;

    /* renamed from: F */
    PopupWindow f1305F;

    /* renamed from: a */
    private Context f1306a;

    /* renamed from: b */
    private ListAdapter f1307b;

    /* renamed from: c */
    C0330k f1308c;

    /* renamed from: d */
    private int f1309d;

    /* renamed from: e */
    private int f1310e;

    /* renamed from: f */
    private int f1311f;

    /* renamed from: g */
    private int f1312g;

    /* renamed from: h */
    private int f1313h;

    /* renamed from: i */
    private boolean f1314i;

    /* renamed from: j */
    private boolean f1315j;

    /* renamed from: k */
    private boolean f1316k;

    /* renamed from: l */
    private int f1317l;

    /* renamed from: m */
    private boolean f1318m;

    /* renamed from: n */
    private boolean f1319n;

    /* renamed from: o */
    int f1320o;

    /* renamed from: p */
    private View f1321p;

    /* renamed from: q */
    private int f1322q;

    /* renamed from: r */
    private DataSetObserver f1323r;

    /* renamed from: s */
    private View f1324s;

    /* renamed from: t */
    private Drawable f1325t;

    /* renamed from: u */
    private AdapterView.OnItemClickListener f1326u;

    /* renamed from: v */
    private AdapterView.OnItemSelectedListener f1327v;

    /* renamed from: w */
    final C0277h f1328w;

    /* renamed from: x */
    private final C0276g f1329x;

    /* renamed from: y */
    private final C0275f f1330y;

    /* renamed from: z */
    private final C0273d f1331z;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$a */
    class C0270a extends ForwardingListener {
        C0270a(View view) {
            super(view);
        }

        /* renamed from: h */
        public ListPopupWindow getPopup() {
            return ListPopupWindow.this;
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$b */
    class C0271b implements Runnable {
        C0271b() {
        }

        public void run() {
            View anchorView = ListPopupWindow.this.getAnchorView();
            if (anchorView != null && anchorView.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$c */
    class C0272c implements AdapterView.OnItemSelectedListener {
        C0272c() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            C0330k kVar;
            if (i != -1 && (kVar = ListPopupWindow.this.f1308c) != null) {
                kVar.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$d */
    private class C0273d implements Runnable {
        C0273d() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$e */
    private class C0274e extends DataSetObserver {
        C0274e() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$f */
    private class C0275f implements AbsListView.OnScrollListener {
        C0275f() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.f1305F.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f1301B.removeCallbacks(listPopupWindow.f1328w);
                ListPopupWindow.this.f1328w.run();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$g */
    private class C0276g implements View.OnTouchListener {
        C0276g() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f1305F) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.f1305F.getWidth() && y >= 0 && y < ListPopupWindow.this.f1305F.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f1301B.postDelayed(listPopupWindow.f1328w, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.f1301B.removeCallbacks(listPopupWindow2.f1328w);
                return false;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$h */
    private class C0277h implements Runnable {
        C0277h() {
        }

        public void run() {
            C0330k kVar = ListPopupWindow.this.f1308c;
            if (kVar != null && ViewCompat.isAttachedToWindow(kVar) && ListPopupWindow.this.f1308c.getCount() > ListPopupWindow.this.f1308c.getChildCount()) {
                int childCount = ListPopupWindow.this.f1308c.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f1320o) {
                    listPopupWindow.f1305F.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        Class cls = Boolean.TYPE;
        int i = Build.VERSION.SDK_INT;
        if (i <= 28) {
            try {
                f1297G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{cls});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f1299I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (i <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f1298H = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, cls});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, (AttributeSet) null, C0131R.attr.listPopupWindowStyle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.k} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m878e() {
        /*
            r12 = this;
            androidx.appcompat.widget.k r0 = r12.f1308c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bf
            android.content.Context r0 = r12.f1306a
            androidx.appcompat.widget.ListPopupWindow$b r5 = new androidx.appcompat.widget.ListPopupWindow$b
            r5.<init>()
            r12.f1300A = r5
            boolean r5 = r12.f1304E
            r5 = r5 ^ r3
            androidx.appcompat.widget.k r5 = r12.mo2489f(r0, r5)
            r12.f1308c = r5
            android.graphics.drawable.Drawable r6 = r12.f1325t
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.k r5 = r12.f1308c
            android.widget.ListAdapter r6 = r12.f1307b
            r5.setAdapter(r6)
            androidx.appcompat.widget.k r5 = r12.f1308c
            android.widget.AdapterView$OnItemClickListener r6 = r12.f1326u
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.k r5 = r12.f1308c
            r5.setFocusable(r3)
            androidx.appcompat.widget.k r5 = r12.f1308c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.k r5 = r12.f1308c
            androidx.appcompat.widget.ListPopupWindow$c r6 = new androidx.appcompat.widget.ListPopupWindow$c
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.k r5 = r12.f1308c
            androidx.appcompat.widget.ListPopupWindow$f r6 = r12.f1330y
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f1327v
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.k r6 = r12.f1308c
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.k r5 = r12.f1308c
            android.view.View r6 = r12.f1321p
            if (r6 == 0) goto L_0x00b8
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1322q
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1322q
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.f1310e
            if (r0 < 0) goto L_0x009c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009e
        L_0x009c:
            r0 = 0
            r5 = 0
        L_0x009e:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            android.widget.PopupWindow r6 = r12.f1305F
            r6.setContentView(r5)
            goto L_0x00dd
        L_0x00bf:
            android.widget.PopupWindow r0 = r12.f1305F
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1321p
            if (r0 == 0) goto L_0x00dc
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            android.widget.PopupWindow r5 = r12.f1305F
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f9
            android.graphics.Rect r6 = r12.f1302C
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.f1302C
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f1314i
            if (r7 != 0) goto L_0x00ff
            int r6 = -r6
            r12.f1312g = r6
            goto L_0x00ff
        L_0x00f9:
            android.graphics.Rect r5 = r12.f1302C
            r5.setEmpty()
            r5 = 0
        L_0x00ff:
            android.widget.PopupWindow r6 = r12.f1305F
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r3 = 0
        L_0x010a:
            android.view.View r4 = r12.getAnchorView()
            int r6 = r12.f1312g
            int r3 = r12.m879g(r4, r6, r3)
            boolean r4 = r12.f1318m
            if (r4 != 0) goto L_0x017b
            int r4 = r12.f1309d
            if (r4 != r2) goto L_0x011d
            goto L_0x017b
        L_0x011d:
            int r4 = r12.f1310e
            r6 = -2
            if (r4 == r6) goto L_0x0144
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012b
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x015c
        L_0x012b:
            android.content.Context r2 = r12.f1306a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.f1302C
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x015c
        L_0x0144:
            android.content.Context r2 = r12.f1306a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.f1302C
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x015c:
            r7 = r1
            androidx.appcompat.widget.k r6 = r12.f1308c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.measureHeightOfChildrenCompat(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0179
            androidx.appcompat.widget.k r2 = r12.f1308c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.k r3 = r12.f1308c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0179:
            int r1 = r1 + r0
            return r1
        L_0x017b:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.m878e():int");
    }

    /* renamed from: g */
    private int m879g(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f1305F.getMaxAvailableHeight(view, i, z);
        }
        Method method = f1298H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f1305F, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1305F.getMaxAvailableHeight(view, i);
    }

    /* renamed from: h */
    private static boolean m880h(int i) {
        return i == 66 || i == 23;
    }

    /* renamed from: i */
    private void m881i() {
        View view = this.f1321p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1321p);
            }
        }
    }

    /* renamed from: j */
    private void m882j(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1297G;
            if (method != null) {
                try {
                    method.invoke(this.f1305F, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f1305F.setIsClippedToScreen(z);
        }
    }

    public void clearListSelection() {
        C0330k kVar = this.f1308c;
        if (kVar != null) {
            kVar.setListSelectionHidden(true);
            kVar.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new C0270a(view);
    }

    public void dismiss() {
        this.f1305F.dismiss();
        m881i();
        this.f1305F.setContentView((View) null);
        this.f1308c = null;
        this.f1301B.removeCallbacks(this.f1328w);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: f */
    public C0330k mo2489f(Context context, boolean z) {
        return new C0330k(context, z);
    }

    @Nullable
    public View getAnchorView() {
        return this.f1324s;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.f1305F.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.f1305F.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.f1303D != null) {
            return new Rect(this.f1303D);
        }
        return null;
    }

    public int getHeight() {
        return this.f1309d;
    }

    public int getHorizontalOffset() {
        return this.f1311f;
    }

    public int getInputMethodMode() {
        return this.f1305F.getInputMethodMode();
    }

    @Nullable
    public ListView getListView() {
        return this.f1308c;
    }

    public int getPromptPosition() {
        return this.f1322q;
    }

    @Nullable
    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.f1308c.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f1308c.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.f1308c.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.f1308c.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.f1305F.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.f1314i) {
            return 0;
        }
        return this.f1312g;
    }

    public int getWidth() {
        return this.f1310e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.f1318m;
    }

    public boolean isInputMethodNotNeeded() {
        return this.f1305F.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.f1304E;
    }

    public boolean isShowing() {
        return this.f1305F.isShowing();
    }

    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        int i2;
        int i3;
        if (isShowing() && i != 62 && (this.f1308c.getSelectedItemPosition() >= 0 || !m880h(i))) {
            int selectedItemPosition = this.f1308c.getSelectedItemPosition();
            boolean z = !this.f1305F.isAboveAnchor();
            ListAdapter listAdapter = this.f1307b;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i2 = 0;
                } else {
                    i2 = this.f1308c.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    i3 = listAdapter.getCount() - 1;
                } else {
                    i3 = this.f1308c.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
                i4 = i2;
                i5 = i3;
            }
            if ((!z || i != 19 || selectedItemPosition > i4) && (z || i != 20 || selectedItemPosition < i5)) {
                this.f1308c.setListSelectionHidden(false);
                if (this.f1308c.onKeyDown(i, keyEvent)) {
                    this.f1305F.setInputMethodMode(2);
                    this.f1308c.requestFocusFromTouch();
                    show();
                    if (i == 19 || i == 20 || i == 23 || i == 66) {
                        return true;
                    }
                } else if (!z || i != 20) {
                    if (!z && i == 19 && selectedItemPosition == i4) {
                        return true;
                    }
                    return false;
                } else if (selectedItemPosition == i5) {
                    return true;
                }
            } else {
                clearListSelection();
                this.f1305F.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i, @NonNull KeyEvent keyEvent) {
        if (i != 4 || !isShowing()) {
            return false;
        }
        View view = this.f1324s;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        } else if (keyEvent.getAction() != 1) {
            return false;
        } else {
            KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
            if (keyDispatcherState2 != null) {
                keyDispatcherState2.handleUpEvent(keyEvent);
            }
            if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                return false;
            }
            dismiss();
            return true;
        }
    }

    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        if (!isShowing() || this.f1308c.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f1308c.onKeyUp(i, keyEvent);
        if (onKeyUp && m880h(i)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.f1326u == null) {
            return true;
        }
        C0330k kVar = this.f1308c;
        int i2 = i;
        this.f1326u.onItemClick(kVar, kVar.getChildAt(i - kVar.getFirstVisiblePosition()), i2, kVar.getAdapter().getItemId(i));
        return true;
    }

    public void postShow() {
        this.f1301B.post(this.f1300A);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1323r;
        if (dataSetObserver == null) {
            this.f1323r = new C0274e();
        } else {
            ListAdapter listAdapter2 = this.f1307b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1307b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1323r);
        }
        C0330k kVar = this.f1308c;
        if (kVar != null) {
            kVar.setAdapter(this.f1307b);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.f1324s = view;
    }

    public void setAnimationStyle(@StyleRes int i) {
        this.f1305F.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.f1305F.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.f1305F.getBackground();
        if (background != null) {
            background.getPadding(this.f1302C);
            Rect rect = this.f1302C;
            this.f1310e = rect.left + rect.right + i;
            return;
        }
        setWidth(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z) {
        this.f1318m = z;
    }

    public void setDropDownGravity(int i) {
        this.f1317l = i;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        this.f1303D = rect != null ? new Rect(rect) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.f1319n = z;
    }

    public void setHeight(int i) {
        if (i >= 0 || -2 == i || -1 == i) {
            this.f1309d = i;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int i) {
        this.f1311f = i;
    }

    public void setInputMethodMode(int i) {
        this.f1305F.setInputMethodMode(i);
    }

    public void setListSelector(Drawable drawable) {
        this.f1325t = drawable;
    }

    public void setModal(boolean z) {
        this.f1304E = z;
        this.f1305F.setFocusable(z);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f1305F.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f1326u = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f1327v = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z) {
        this.f1316k = true;
        this.f1315j = z;
    }

    public void setPromptPosition(int i) {
        this.f1322q = i;
    }

    public void setPromptView(@Nullable View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            m881i();
        }
        this.f1321p = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        C0330k kVar = this.f1308c;
        if (isShowing() && kVar != null) {
            kVar.setListSelectionHidden(false);
            kVar.setSelection(i);
            if (kVar.getChoiceMode() != 0) {
                kVar.setItemChecked(i, true);
            }
        }
    }

    public void setSoftInputMode(int i) {
        this.f1305F.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.f1312g = i;
        this.f1314i = true;
    }

    public void setWidth(int i) {
        this.f1310e = i;
    }

    public void setWindowLayoutType(int i) {
        this.f1313h = i;
    }

    public void show() {
        int e = m878e();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.f1305F, this.f1313h);
        boolean z = true;
        if (!this.f1305F.isShowing()) {
            int i = this.f1310e;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = getAnchorView().getWidth();
            }
            int i2 = this.f1309d;
            if (i2 == -1) {
                e = -1;
            } else if (i2 != -2) {
                e = i2;
            }
            this.f1305F.setWidth(i);
            this.f1305F.setHeight(e);
            m882j(true);
            this.f1305F.setOutsideTouchable(!this.f1319n && !this.f1318m);
            this.f1305F.setTouchInterceptor(this.f1329x);
            if (this.f1316k) {
                PopupWindowCompat.setOverlapAnchor(this.f1305F, this.f1315j);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = f1299I;
                if (method != null) {
                    try {
                        method.invoke(this.f1305F, new Object[]{this.f1303D});
                    } catch (Exception e2) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                this.f1305F.setEpicenterBounds(this.f1303D);
            }
            PopupWindowCompat.showAsDropDown(this.f1305F, getAnchorView(), this.f1311f, this.f1312g, this.f1317l);
            this.f1308c.setSelection(-1);
            if (!this.f1304E || this.f1308c.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.f1304E) {
                this.f1301B.post(this.f1331z);
            }
        } else if (ViewCompat.isAttachedToWindow(getAnchorView())) {
            int i3 = this.f1310e;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = getAnchorView().getWidth();
            }
            int i4 = this.f1309d;
            if (i4 == -1) {
                if (!isInputMethodNotNeeded) {
                    e = -1;
                }
                if (isInputMethodNotNeeded) {
                    this.f1305F.setWidth(this.f1310e == -1 ? -1 : 0);
                    this.f1305F.setHeight(0);
                } else {
                    this.f1305F.setWidth(this.f1310e == -1 ? -1 : 0);
                    this.f1305F.setHeight(-1);
                }
            } else if (i4 != -2) {
                e = i4;
            }
            PopupWindow popupWindow = this.f1305F;
            if (this.f1319n || this.f1318m) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.f1305F.update(getAnchorView(), this.f1311f, this.f1312g, i3 < 0 ? -1 : i3, e < 0 ? -1 : e);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        this.f1309d = -2;
        this.f1310e = -2;
        this.f1313h = 1002;
        this.f1317l = 0;
        this.f1318m = false;
        this.f1319n = false;
        this.f1320o = Integer.MAX_VALUE;
        this.f1322q = 0;
        this.f1328w = new C0277h();
        this.f1329x = new C0276g();
        this.f1330y = new C0275f();
        this.f1331z = new C0273d();
        this.f1302C = new Rect();
        this.f1306a = context;
        this.f1301B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0131R.styleable.ListPopupWindow, i, i2);
        this.f1311f = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1312g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1314i = true;
        }
        obtainStyledAttributes.recycle();
        C0320e eVar = new C0320e(context, attributeSet, i, i2);
        this.f1305F = eVar;
        eVar.setInputMethodMode(1);
    }
}
