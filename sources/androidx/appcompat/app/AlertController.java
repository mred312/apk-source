package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.C0131R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {

    /* renamed from: A */
    NestedScrollView f361A;

    /* renamed from: B */
    private int f362B = 0;

    /* renamed from: C */
    private Drawable f363C;

    /* renamed from: D */
    private ImageView f364D;

    /* renamed from: E */
    private TextView f365E;

    /* renamed from: F */
    private TextView f366F;

    /* renamed from: G */
    private View f367G;

    /* renamed from: H */
    ListAdapter f368H;

    /* renamed from: I */
    int f369I = -1;

    /* renamed from: J */
    private int f370J;

    /* renamed from: K */
    private int f371K;

    /* renamed from: L */
    int f372L;

    /* renamed from: M */
    int f373M;

    /* renamed from: N */
    int f374N;

    /* renamed from: O */
    int f375O;

    /* renamed from: P */
    private boolean f376P;

    /* renamed from: Q */
    private int f377Q = 0;

    /* renamed from: R */
    Handler f378R;

    /* renamed from: S */
    private final View.OnClickListener f379S = new C0142a();

    /* renamed from: a */
    private final Context f380a;

    /* renamed from: b */
    final AppCompatDialog f381b;

    /* renamed from: c */
    private final Window f382c;

    /* renamed from: d */
    private final int f383d;

    /* renamed from: e */
    private CharSequence f384e;

    /* renamed from: f */
    private CharSequence f385f;

    /* renamed from: g */
    ListView f386g;

    /* renamed from: h */
    private View f387h;

    /* renamed from: i */
    private int f388i;

    /* renamed from: j */
    private int f389j;

    /* renamed from: k */
    private int f390k;

    /* renamed from: l */
    private int f391l;

    /* renamed from: m */
    private int f392m;

    /* renamed from: n */
    private boolean f393n = false;

    /* renamed from: o */
    Button f394o;

    /* renamed from: p */
    private CharSequence f395p;

    /* renamed from: q */
    Message f396q;

    /* renamed from: r */
    private Drawable f397r;

    /* renamed from: s */
    Button f398s;

    /* renamed from: t */
    private CharSequence f399t;

    /* renamed from: u */
    Message f400u;

    /* renamed from: v */
    private Drawable f401v;

    /* renamed from: w */
    Button f402w;

    /* renamed from: x */
    private CharSequence f403x;

    /* renamed from: y */
    Message f404y;

    /* renamed from: z */
    private Drawable f405z;

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId = 0;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified = false;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$a */
        class C0138a extends ArrayAdapter<CharSequence> {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f406a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0138a(Context context, int i, int i2, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                this.f406a = recycleListView;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null && zArr[i]) {
                    this.f406a.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$b */
        class C0139b extends CursorAdapter {

            /* renamed from: a */
            private final int f408a;

            /* renamed from: b */
            private final int f409b;

            /* renamed from: c */
            final /* synthetic */ RecycleListView f410c;

            /* renamed from: d */
            final /* synthetic */ AlertController f411d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0139b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f410c = recycleListView;
                this.f411d = alertController;
                Cursor cursor2 = getCursor();
                this.f408a = cursor2.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                this.f409b = cursor2.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f408a));
                RecycleListView recycleListView = this.f410c;
                int position = cursor.getPosition();
                boolean z = true;
                if (cursor.getInt(this.f409b) != 1) {
                    z = false;
                }
                recycleListView.setItemChecked(position, z);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return AlertParams.this.mInflater.inflate(this.f411d.f373M, viewGroup, false);
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$c */
        class C0140c implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ AlertController f413a;

            C0140c(AlertController alertController) {
                this.f413a = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlertParams.this.mOnClickListener.onClick(this.f413a.f381b, i);
                if (!AlertParams.this.mIsSingleChoice) {
                    this.f413a.f381b.dismiss();
                }
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$d */
        class C0141d implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ RecycleListView f415a;

            /* renamed from: b */
            final /* synthetic */ AlertController f416b;

            C0141d(RecycleListView recycleListView, AlertController alertController) {
                this.f415a = recycleListView;
                this.f416b = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null) {
                    zArr[i] = this.f415a.isItemChecked(i);
                }
                AlertParams.this.mOnCheckboxClickListener.onClick(this.f416b.f381b, i, this.f415a.isItemChecked(i));
            }
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$AlertParams$b] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$AlertParams$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m410a(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.mInflater
                int r1 = r11.f372L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.mIsMultiChoice
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.mCursor
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$AlertParams$a r9 = new androidx.appcompat.app.AlertController$AlertParams$a
                android.content.Context r3 = r10.mContext
                int r4 = r11.f373M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.mItems
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$AlertParams$b r9 = new androidx.appcompat.app.AlertController$AlertParams$b
                android.content.Context r3 = r10.mContext
                android.database.Cursor r4 = r10.mCursor
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.mIsSingleChoice
                if (r1 == 0) goto L_0x003c
                int r1 = r11.f374N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.f375O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.mCursor
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.mContext
                android.database.Cursor r5 = r10.mCursor
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.mLabelColumn
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.mAdapter
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$g r9 = new androidx.appcompat.app.AlertController$g
                android.content.Context r1 = r10.mContext
                java.lang.CharSequence[] r3 = r10.mItems
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$AlertParams$OnPrepareListViewListener r1 = r10.mOnPrepareListViewListener
                if (r1 == 0) goto L_0x0072
                r1.onPrepareListView(r0)
            L_0x0072:
                r11.f368H = r9
                int r1 = r10.mCheckedItem
                r11.f369I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.mOnClickListener
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$AlertParams$c r1 = new androidx.appcompat.app.AlertController$AlertParams$c
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0091
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.mOnCheckboxClickListener
                if (r1 == 0) goto L_0x0091
                androidx.appcompat.app.AlertController$AlertParams$d r1 = new androidx.appcompat.app.AlertController$AlertParams$d
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0091:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.mOnItemSelectedListener
                if (r1 == 0) goto L_0x0098
                r0.setOnItemSelectedListener(r1)
            L_0x0098:
                boolean r1 = r10.mIsSingleChoice
                if (r1 == 0) goto L_0x00a0
                r0.setChoiceMode(r8)
                goto L_0x00a8
            L_0x00a0:
                boolean r1 = r10.mIsMultiChoice
                if (r1 == 0) goto L_0x00a8
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a8:
                r11.f386g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AlertParams.m410a(androidx.appcompat.app.AlertController):void");
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.mo935m(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.mo939r(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.mo937o(drawable);
                }
                int i = this.mIconId;
                if (i != 0) {
                    alertController.mo936n(i);
                }
                int i2 = this.mIconAttrId;
                if (i2 != 0) {
                    alertController.mo936n(alertController.mo929d(i2));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.mo938p(charSequence2);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (!(charSequence3 == null && this.mPositiveButtonIcon == null)) {
                alertController.mo934l(-1, charSequence3, this.mPositiveButtonListener, (Message) null, this.mPositiveButtonIcon);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (!(charSequence4 == null && this.mNegativeButtonIcon == null)) {
                alertController.mo934l(-2, charSequence4, this.mNegativeButtonListener, (Message) null, this.mNegativeButtonIcon);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (!(charSequence5 == null && this.mNeutralButtonIcon == null)) {
                alertController.mo934l(-3, charSequence5, this.mNeutralButtonListener, (Message) null, this.mNeutralButtonIcon);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                m410a(alertController);
            }
            View view2 = this.mView;
            if (view2 == null) {
                int i3 = this.mViewLayoutResId;
                if (i3 != 0) {
                    alertController.mo940s(i3);
                }
            } else if (this.mViewSpacingSpecified) {
                alertController.mo942u(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            } else {
                alertController.mo941t(view2);
            }
        }
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f418a;

        /* renamed from: b */
        private final int f419b;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f418a, getPaddingRight(), z2 ? getPaddingBottom() : this.f419b);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0131R.styleable.RecycleListView);
            this.f419b = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f418a = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    class C0142a implements View.OnClickListener {
        C0142a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r3 = r0.f404y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.f394o
                if (r3 != r1) goto L_0x000f
                android.os.Message r1 = r0.f396q
                if (r1 == 0) goto L_0x000f
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x002a
            L_0x000f:
                android.widget.Button r1 = r0.f398s
                if (r3 != r1) goto L_0x001c
                android.os.Message r1 = r0.f400u
                if (r1 == 0) goto L_0x001c
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x002a
            L_0x001c:
                android.widget.Button r1 = r0.f402w
                if (r3 != r1) goto L_0x0029
                android.os.Message r3 = r0.f404y
                if (r3 == 0) goto L_0x0029
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x002a
            L_0x0029:
                r3 = 0
            L_0x002a:
                if (r3 == 0) goto L_0x002f
                r3.sendToTarget()
            L_0x002f:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r0 = r3.f378R
                r1 = 1
                androidx.appcompat.app.AppCompatDialog r3 = r3.f381b
                android.os.Message r3 = r0.obtainMessage(r1, r3)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.C0142a.onClick(android.view.View):void");
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$b */
    class C0143b implements NestedScrollView.OnScrollChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f421a;

        /* renamed from: b */
        final /* synthetic */ View f422b;

        C0143b(AlertController alertController, View view, View view2) {
            this.f421a = view;
            this.f422b = view2;
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            AlertController.m386g(nestedScrollView, this.f421a, this.f422b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    class C0144c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f423a;

        /* renamed from: b */
        final /* synthetic */ View f424b;

        C0144c(View view, View view2) {
            this.f423a = view;
            this.f424b = view2;
        }

        public void run() {
            AlertController.m386g(AlertController.this.f361A, this.f423a, this.f424b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$d */
    class C0145d implements AbsListView.OnScrollListener {

        /* renamed from: a */
        final /* synthetic */ View f426a;

        /* renamed from: b */
        final /* synthetic */ View f427b;

        C0145d(AlertController alertController, View view, View view2) {
            this.f426a = view;
            this.f427b = view2;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlertController.m386g(absListView, this.f426a, this.f427b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$e */
    class C0146e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f428a;

        /* renamed from: b */
        final /* synthetic */ View f429b;

        C0146e(View view, View view2) {
            this.f428a = view;
            this.f429b = view2;
        }

        public void run() {
            AlertController.m386g(AlertController.this.f386g, this.f428a, this.f429b);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$f */
    private static final class C0147f extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f431a;

        public C0147f(DialogInterface dialogInterface) {
            this.f431a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f431a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$g */
    private static class C0148g extends ArrayAdapter<CharSequence> {
        public C0148g(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f380a = context;
        this.f381b = appCompatDialog;
        this.f382c = window;
        this.f378R = new C0147f(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, C0131R.styleable.AlertDialog, C0131R.attr.alertDialogStyle, 0);
        this.f370J = obtainStyledAttributes.getResourceId(C0131R.styleable.AlertDialog_android_layout, 0);
        this.f371K = obtainStyledAttributes.getResourceId(C0131R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f372L = obtainStyledAttributes.getResourceId(C0131R.styleable.AlertDialog_listLayout, 0);
        this.f373M = obtainStyledAttributes.getResourceId(C0131R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f374N = obtainStyledAttributes.getResourceId(C0131R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f375O = obtainStyledAttributes.getResourceId(C0131R.styleable.AlertDialog_listItemLayout, 0);
        this.f376P = obtainStyledAttributes.getBoolean(C0131R.styleable.AlertDialog_showTitle, true);
        this.f383d = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    /* renamed from: A */
    private static boolean m383A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0131R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static boolean m384a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m384a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m385b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: g */
    static void m386g(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    @Nullable
    /* renamed from: j */
    private ViewGroup m387j(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: k */
    private int m388k() {
        int i = this.f371K;
        if (i == 0) {
            return this.f370J;
        }
        if (this.f377Q == 1) {
            return i;
        }
        return this.f370J;
    }

    /* renamed from: q */
    private void m389q(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.f382c.findViewById(C0131R.C0133id.scrollIndicatorUp);
        View findViewById2 = this.f382c.findViewById(C0131R.C0133id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f385f != null) {
                this.f361A.setOnScrollChangeListener(new C0143b(this, findViewById, findViewById2));
                this.f361A.post(new C0144c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f386g;
            if (listView != null) {
                listView.setOnScrollListener(new C0145d(this, findViewById, findViewById2));
                this.f386g.post(new C0146e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    /* renamed from: v */
    private void m390v(ViewGroup viewGroup) {
        boolean z;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f394o = button;
        button.setOnClickListener(this.f379S);
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.f395p) || this.f397r != null) {
            this.f394o.setText(this.f395p);
            Drawable drawable = this.f397r;
            if (drawable != null) {
                int i = this.f383d;
                drawable.setBounds(0, 0, i, i);
                this.f394o.setCompoundDrawables(this.f397r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f394o.setVisibility(0);
            z = true;
        } else {
            this.f394o.setVisibility(8);
            z = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f398s = button2;
        button2.setOnClickListener(this.f379S);
        if (!TextUtils.isEmpty(this.f399t) || this.f401v != null) {
            this.f398s.setText(this.f399t);
            Drawable drawable2 = this.f401v;
            if (drawable2 != null) {
                int i2 = this.f383d;
                drawable2.setBounds(0, 0, i2, i2);
                this.f398s.setCompoundDrawables(this.f401v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f398s.setVisibility(0);
            z |= true;
        } else {
            this.f398s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f402w = button3;
        button3.setOnClickListener(this.f379S);
        if (!TextUtils.isEmpty(this.f403x) || this.f405z != null) {
            this.f402w.setText(this.f403x);
            Drawable drawable3 = this.f405z;
            if (drawable3 != null) {
                int i3 = this.f383d;
                drawable3.setBounds(0, 0, i3, i3);
                this.f402w.setCompoundDrawables(this.f405z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f402w.setVisibility(0);
            z |= true;
        } else {
            this.f402w.setVisibility(8);
        }
        if (m383A(this.f380a)) {
            if (z) {
                m385b(this.f394o);
            } else if (z) {
                m385b(this.f398s);
            } else if (z) {
                m385b(this.f402w);
            }
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: w */
    private void m391w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f382c.findViewById(C0131R.C0133id.scrollView);
        this.f361A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f361A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.f366F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f385f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.f361A.removeView(this.f366F);
            if (this.f386g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f361A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f361A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f386g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: x */
    private void m392x(ViewGroup viewGroup) {
        View view = this.f387h;
        boolean z = false;
        if (view == null) {
            view = this.f388i != 0 ? LayoutInflater.from(this.f380a).inflate(this.f388i, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !m384a(view)) {
            this.f382c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f382c.findViewById(C0131R.C0133id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f393n) {
                frameLayout.setPadding(this.f389j, this.f390k, this.f391l, this.f392m);
            }
            if (this.f386g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: y */
    private void m393y(ViewGroup viewGroup) {
        if (this.f367G != null) {
            viewGroup.addView(this.f367G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f382c.findViewById(C0131R.C0133id.title_template).setVisibility(8);
            return;
        }
        this.f364D = (ImageView) this.f382c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f384e)) || !this.f376P) {
            this.f382c.findViewById(C0131R.C0133id.title_template).setVisibility(8);
            this.f364D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f382c.findViewById(C0131R.C0133id.alertTitle);
        this.f365E = textView;
        textView.setText(this.f384e);
        int i = this.f362B;
        if (i != 0) {
            this.f364D.setImageResource(i);
            return;
        }
        Drawable drawable = this.f363C;
        if (drawable != null) {
            this.f364D.setImageDrawable(drawable);
            return;
        }
        this.f365E.setPadding(this.f364D.getPaddingLeft(), this.f364D.getPaddingTop(), this.f364D.getPaddingRight(), this.f364D.getPaddingBottom());
        this.f364D.setVisibility(8);
    }

    /* renamed from: z */
    private void m394z() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f382c.findViewById(C0131R.C0133id.parentPanel);
        int i = C0131R.C0133id.topPanel;
        View findViewById4 = findViewById3.findViewById(i);
        int i2 = C0131R.C0133id.contentPanel;
        View findViewById5 = findViewById3.findViewById(i2);
        int i3 = C0131R.C0133id.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i3);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(C0131R.C0133id.customPanel);
        m392x(viewGroup);
        View findViewById7 = viewGroup.findViewById(i);
        View findViewById8 = viewGroup.findViewById(i2);
        View findViewById9 = viewGroup.findViewById(i3);
        ViewGroup j = m387j(findViewById7, findViewById4);
        ViewGroup j2 = m387j(findViewById8, findViewById5);
        ViewGroup j3 = m387j(findViewById9, findViewById6);
        m391w(j2);
        m390v(j3);
        m393y(j);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (j == null || j.getVisibility() == 8) ? false : true;
        boolean z3 = (j3 == null || j3.getVisibility() == 8) ? false : true;
        if (!(z3 || j2 == null || (findViewById2 = j2.findViewById(C0131R.C0133id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.f361A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f385f == null && this.f386g == null)) {
                view = j.findViewById(C0131R.C0133id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(j2 == null || (findViewById = j2.findViewById(C0131R.C0133id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f386g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view2 = this.f386g;
            if (view2 == null) {
                view2 = this.f361A;
            }
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                m389q(j2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f386g;
        if (listView2 != null && (listAdapter = this.f368H) != null) {
            listView2.setAdapter(listAdapter);
            int i4 = this.f369I;
            if (i4 > -1) {
                listView2.setItemChecked(i4, true);
                listView2.setSelection(i4);
            }
        }
    }

    /* renamed from: c */
    public Button mo928c(int i) {
        if (i == -3) {
            return this.f402w;
        }
        if (i == -2) {
            return this.f398s;
        }
        if (i != -1) {
            return null;
        }
        return this.f394o;
    }

    /* renamed from: d */
    public int mo929d(int i) {
        TypedValue typedValue = new TypedValue();
        this.f380a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: e */
    public ListView mo930e() {
        return this.f386g;
    }

    /* renamed from: f */
    public void mo931f() {
        this.f381b.setContentView(m388k());
        m394z();
    }

    /* renamed from: h */
    public boolean mo932h(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f361A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    /* renamed from: i */
    public boolean mo933i(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f361A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    /* renamed from: l */
    public void mo934l(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f378R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.f403x = charSequence;
            this.f404y = message;
            this.f405z = drawable;
        } else if (i == -2) {
            this.f399t = charSequence;
            this.f400u = message;
            this.f401v = drawable;
        } else if (i == -1) {
            this.f395p = charSequence;
            this.f396q = message;
            this.f397r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: m */
    public void mo935m(View view) {
        this.f367G = view;
    }

    /* renamed from: n */
    public void mo936n(int i) {
        this.f363C = null;
        this.f362B = i;
        ImageView imageView = this.f364D;
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            imageView.setVisibility(0);
            this.f364D.setImageResource(this.f362B);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: o */
    public void mo937o(Drawable drawable) {
        this.f363C = drawable;
        this.f362B = 0;
        ImageView imageView = this.f364D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.f364D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: p */
    public void mo938p(CharSequence charSequence) {
        this.f385f = charSequence;
        TextView textView = this.f366F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: r */
    public void mo939r(CharSequence charSequence) {
        this.f384e = charSequence;
        TextView textView = this.f365E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: s */
    public void mo940s(int i) {
        this.f387h = null;
        this.f388i = i;
        this.f393n = false;
    }

    /* renamed from: t */
    public void mo941t(View view) {
        this.f387h = view;
        this.f388i = 0;
        this.f393n = false;
    }

    /* renamed from: u */
    public void mo942u(View view, int i, int i2, int i3, int i4) {
        this.f387h = view;
        this.f388i = 0;
        this.f393n = true;
        this.f389j = i;
        this.f390k = i2;
        this.f391l = i3;
        this.f392m = i4;
    }
}
