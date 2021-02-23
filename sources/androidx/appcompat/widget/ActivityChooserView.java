package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: a */
    final C0255f f1151a;

    /* renamed from: b */
    private final C0256g f1152b;

    /* renamed from: c */
    private final View f1153c;

    /* renamed from: d */
    private final Drawable f1154d;

    /* renamed from: e */
    final FrameLayout f1155e;

    /* renamed from: f */
    private final ImageView f1156f;

    /* renamed from: g */
    final FrameLayout f1157g;

    /* renamed from: h */
    private final ImageView f1158h;

    /* renamed from: i */
    private final int f1159i;

    /* renamed from: j */
    ActionProvider f1160j;

    /* renamed from: k */
    final DataSetObserver f1161k;

    /* renamed from: l */
    private final ViewTreeObserver.OnGlobalLayoutListener f1162l;

    /* renamed from: m */
    private ListPopupWindow f1163m;

    /* renamed from: n */
    PopupWindow.OnDismissListener f1164n;

    /* renamed from: o */
    boolean f1165o;

    /* renamed from: p */
    int f1166p;

    /* renamed from: q */
    private boolean f1167q;

    /* renamed from: r */
    private int f1168r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f1169a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f1169a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    class C0250a extends DataSetObserver {
        C0250a() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1151a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1151a.notifyDataSetInvalidated();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    class C0251b implements ViewTreeObserver.OnGlobalLayoutListener {
        C0251b() {
        }

        public void onGlobalLayout() {
            if (!ActivityChooserView.this.isShowingPopup()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().dismiss();
                return;
            }
            ActivityChooserView.this.getListPopupWindow().show();
            ActionProvider actionProvider = ActivityChooserView.this.f1160j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$c */
    class C0252c extends View.AccessibilityDelegate {
        C0252c(ActivityChooserView activityChooserView) {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$d */
    class C0253d extends ForwardingListener {
        C0253d(View view) {
            super(view);
        }

        public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStopped() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$e */
    class C0254e extends DataSetObserver {
        C0254e() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.mo2113b();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$f */
    private class C0255f extends BaseAdapter {

        /* renamed from: a */
        private ActivityChooserModel f1174a;

        /* renamed from: b */
        private int f1175b = 4;

        /* renamed from: c */
        private boolean f1176c;

        /* renamed from: d */
        private boolean f1177d;

        /* renamed from: e */
        private boolean f1178e;

        C0255f() {
        }

        /* renamed from: a */
        public int mo2134a() {
            return this.f1174a.mo2092f();
        }

        /* renamed from: b */
        public ActivityChooserModel mo2135b() {
            return this.f1174a;
        }

        /* renamed from: c */
        public ResolveInfo mo2136c() {
            return this.f1174a.mo2094h();
        }

        /* renamed from: d */
        public int mo2137d() {
            return this.f1174a.mo2095i();
        }

        /* renamed from: e */
        public boolean mo2138e() {
            return this.f1176c;
        }

        /* renamed from: f */
        public int mo2139f() {
            int i = this.f1175b;
            this.f1175b = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f1175b = i;
            return i2;
        }

        /* renamed from: g */
        public void mo2140g(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel b = ActivityChooserView.this.f1151a.mo2135b();
            if (b != null && ActivityChooserView.this.isShown()) {
                b.unregisterObserver(ActivityChooserView.this.f1161k);
            }
            this.f1174a = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.f1161k);
            }
            notifyDataSetChanged();
        }

        public int getCount() {
            int f = this.f1174a.mo2092f();
            if (!this.f1176c && this.f1174a.mo2094h() != null) {
                f--;
            }
            int min = Math.min(f, this.f1175b);
            return this.f1178e ? min + 1 : min;
        }

        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.f1176c && this.f1174a.mo2094h() != null) {
                    i++;
                }
                return this.f1174a.mo2091e(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (!this.f1178e || i != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != C0131R.C0133id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C0131R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(C0131R.C0133id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(C0131R.C0133id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f1176c || i != 0 || !this.f1177d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C0131R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(C0131R.C0133id.title)).setText(ActivityChooserView.this.getContext().getString(C0131R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        /* renamed from: h */
        public void mo2147h(int i) {
            if (this.f1175b != i) {
                this.f1175b = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: i */
        public void mo2148i(boolean z, boolean z2) {
            if (this.f1176c != z || this.f1177d != z2) {
                this.f1176c = z;
                this.f1177d = z2;
                notifyDataSetChanged();
            }
        }

        /* renamed from: j */
        public void mo2149j(boolean z) {
            if (this.f1178e != z) {
                this.f1178e = z;
                notifyDataSetChanged();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$g */
    private class C0256g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        C0256g() {
        }

        /* renamed from: a */
        private void m799a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1164n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1157g) {
                activityChooserView.dismissPopup();
                Intent b = ActivityChooserView.this.f1151a.mo2135b().mo2090b(ActivityChooserView.this.f1151a.mo2135b().mo2093g(ActivityChooserView.this.f1151a.mo2136c()));
                if (b != null) {
                    b.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b);
                }
            } else if (view == activityChooserView.f1155e) {
                activityChooserView.f1165o = false;
                activityChooserView.mo2112a(activityChooserView.f1166p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m799a();
            ActionProvider actionProvider = ActivityChooserView.this.f1160j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((C0255f) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                ActivityChooserView.this.dismissPopup();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.f1165o) {
                    if (!activityChooserView.f1151a.mo2138e()) {
                        i++;
                    }
                    Intent b = ActivityChooserView.this.f1151a.mo2135b().mo2090b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b);
                    }
                } else if (i > 0) {
                    activityChooserView.f1151a.mo2135b().mo2096o(i);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.mo2112a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1157g) {
                if (activityChooserView.f1151a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f1165o = true;
                    activityChooserView2.mo2112a(activityChooserView2.f1166p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2112a(int i) {
        if (this.f1151a.mo2135b() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f1162l);
            boolean z = this.f1157g.getVisibility() == 0;
            int a = this.f1151a.mo2134a();
            if (i == Integer.MAX_VALUE || a <= i + (z ? 1 : 0)) {
                this.f1151a.mo2149j(false);
                this.f1151a.mo2147h(i);
            } else {
                this.f1151a.mo2149j(true);
                this.f1151a.mo2147h(i - 1);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.isShowing()) {
                if (this.f1165o || !z) {
                    this.f1151a.mo2148i(true, z);
                } else {
                    this.f1151a.mo2148i(false, false);
                }
                listPopupWindow.setContentWidth(Math.min(this.f1151a.mo2139f(), this.f1159i));
                listPopupWindow.show();
                ActionProvider actionProvider = this.f1160j;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
                listPopupWindow.getListView().setContentDescription(getContext().getString(C0131R.string.abc_activitychooserview_choose_application));
                listPopupWindow.getListView().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2113b() {
        if (this.f1151a.getCount() > 0) {
            this.f1155e.setEnabled(true);
        } else {
            this.f1155e.setEnabled(false);
        }
        int a = this.f1151a.mo2134a();
        int d = this.f1151a.mo2137d();
        if (a == 1 || (a > 1 && d > 0)) {
            this.f1157g.setVisibility(0);
            ResolveInfo c = this.f1151a.mo2136c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1158h.setImageDrawable(c.loadIcon(packageManager));
            if (this.f1168r != 0) {
                CharSequence loadLabel = c.loadLabel(packageManager);
                this.f1157g.setContentDescription(getContext().getString(this.f1168r, new Object[]{loadLabel}));
            }
        } else {
            this.f1157g.setVisibility(8);
        }
        if (this.f1157g.getVisibility() == 0) {
            this.f1153c.setBackgroundDrawable(this.f1154d);
        } else {
            this.f1153c.setBackgroundDrawable((Drawable) null);
        }
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1162l);
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.f1151a.mo2135b();
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.f1163m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1163m = listPopupWindow;
            listPopupWindow.setAdapter(this.f1151a);
            this.f1163m.setAnchorView(this);
            this.f1163m.setModal(true);
            this.f1163m.setOnItemClickListener(this.f1152b);
            this.f1163m.setOnDismissListener(this.f1152b);
        }
        return this.f1163m;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel b = this.f1151a.mo2135b();
        if (b != null) {
            b.registerObserver(this.f1161k);
        }
        this.f1167q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel b = this.f1151a.mo2135b();
        if (b != null) {
            b.unregisterObserver(this.f1161k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1162l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.f1167q = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1153c.layout(0, 0, i3 - i, i4 - i2);
        if (!isShowingPopup()) {
            dismissPopup();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view = this.f1153c;
        if (this.f1157g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f1151a.mo2140g(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1168r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1156f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1156f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1166p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1164n = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.f1160j = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.f1167q) {
            return false;
        }
        this.f1165o = false;
        mo2112a(this.f1166p);
        return true;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1161k = new C0250a();
        this.f1162l = new C0251b();
        this.f1166p = 4;
        int[] iArr = C0131R.styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        this.f1166p = obtainStyledAttributes.getInt(C0131R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0131R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(C0131R.layout.abc_activity_chooser_view, this, true);
        C0256g gVar = new C0256g();
        this.f1152b = gVar;
        View findViewById = findViewById(C0131R.C0133id.activity_chooser_view_content);
        this.f1153c = findViewById;
        this.f1154d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(C0131R.C0133id.default_activity_button);
        this.f1157g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i2 = C0131R.C0133id.image;
        this.f1158h = (ImageView) frameLayout.findViewById(i2);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(C0131R.C0133id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new C0252c(this));
        frameLayout2.setOnTouchListener(new C0253d(frameLayout2));
        this.f1155e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i2);
        this.f1156f = imageView;
        imageView.setImageDrawable(drawable);
        C0255f fVar = new C0255f();
        this.f1151a = fVar;
        fVar.registerDataSetObserver(new C0254e());
        Resources resources = context.getResources();
        this.f1159i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0131R.dimen.abc_config_prefDialogWidth));
    }
}
