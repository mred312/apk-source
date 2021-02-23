package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0131R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* renamed from: i */
    private static final int[] f1220i = {16843505};

    /* renamed from: a */
    private final C0317b f1221a;

    /* renamed from: b */
    private final Context f1222b;

    /* renamed from: c */
    private ForwardingListener f1223c;

    /* renamed from: d */
    private SpinnerAdapter f1224d;

    /* renamed from: e */
    private final boolean f1225e;

    /* renamed from: f */
    private C0267f f1226f;

    /* renamed from: g */
    int f1227g;

    /* renamed from: h */
    final Rect f1228h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0258a();

        /* renamed from: a */
        boolean f1229a;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$a */
        class C0258a implements Parcelable.Creator<SavedState> {
            C0258a() {
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

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f1229a ? (byte) 1 : 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1229a = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$a */
    class C0259a extends ForwardingListener {

        /* renamed from: j */
        final /* synthetic */ C0263e f1230j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0259a(View view, C0263e eVar) {
            super(view);
            this.f1230j = eVar;
        }

        public ShowableListMenu getPopup() {
            return this.f1230j;
        }

        @SuppressLint({"SyntheticAccessor"})
        public boolean onForwardingStarted() {
            if (AppCompatSpinner.this.getInternalPopup().isShowing()) {
                return true;
            }
            AppCompatSpinner.this.mo2269b();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$b */
    class C0260b implements ViewTreeObserver.OnGlobalLayoutListener {
        C0260b() {
        }

        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.mo2269b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c */
    class C0261c implements C0267f, DialogInterface.OnClickListener {
        @VisibleForTesting

        /* renamed from: a */
        AlertDialog f1233a;

        /* renamed from: b */
        private ListAdapter f1234b;

        /* renamed from: c */
        private CharSequence f1235c;

        C0261c() {
        }

        /* renamed from: a */
        public CharSequence mo2300a() {
            return this.f1235c;
        }

        /* renamed from: b */
        public void mo2301b(CharSequence charSequence) {
            this.f1235c = charSequence;
        }

        /* renamed from: c */
        public void mo2302c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        /* renamed from: d */
        public void mo2303d(int i, int i2) {
            if (this.f1234b != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f1235c;
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                AlertDialog create = builder.setSingleChoiceItems(this.f1234b, AppCompatSpinner.this.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                this.f1233a = create;
                ListView listView = create.getListView();
                if (Build.VERSION.SDK_INT >= 17) {
                    listView.setTextDirection(i);
                    listView.setTextAlignment(i2);
                }
                this.f1233a.show();
            }
        }

        public void dismiss() {
            AlertDialog alertDialog = this.f1233a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f1233a = null;
            }
        }

        public Drawable getBackground() {
            return null;
        }

        public int getHorizontalOffset() {
            return 0;
        }

        public int getVerticalOffset() {
            return 0;
        }

        public boolean isShowing() {
            AlertDialog alertDialog = this.f1233a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i, this.f1234b.getItemId(i));
            }
            dismiss();
        }

        public void setAdapter(ListAdapter listAdapter) {
            this.f1234b = listAdapter;
        }

        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void setVerticalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d */
    private static class C0262d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f1237a;

        /* renamed from: b */
        private ListAdapter f1238b;

        public C0262d(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Resources.Theme theme) {
            this.f1237a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1238b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter2.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1238b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1238b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1237a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e */
    class C0263e extends ListPopupWindow implements C0267f {

        /* renamed from: J */
        private CharSequence f1239J;

        /* renamed from: K */
        ListAdapter f1240K;

        /* renamed from: L */
        private final Rect f1241L = new Rect();

        /* renamed from: M */
        private int f1242M;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e$a */
        class C0264a implements AdapterView.OnItemClickListener {
            C0264a(AppCompatSpinner appCompatSpinner) {
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    C0263e eVar = C0263e.this;
                    AppCompatSpinner.this.performItemClick(view, i, eVar.f1240K.getItemId(i));
                }
                C0263e.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e$b */
        class C0265b implements ViewTreeObserver.OnGlobalLayoutListener {
            C0265b() {
            }

            public void onGlobalLayout() {
                C0263e eVar = C0263e.this;
                if (!eVar.mo2329n(AppCompatSpinner.this)) {
                    C0263e.this.dismiss();
                    return;
                }
                C0263e.this.mo2327l();
                C0263e.super.show();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e$c */
        class C0266c implements PopupWindow.OnDismissListener {

            /* renamed from: a */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1246a;

            C0266c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1246a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1246a);
                }
            }
        }

        public C0263e(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            setAnchorView(AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new C0264a(AppCompatSpinner.this));
        }

        /* renamed from: a */
        public CharSequence mo2300a() {
            return this.f1239J;
        }

        /* renamed from: b */
        public void mo2301b(CharSequence charSequence) {
            this.f1239J = charSequence;
        }

        /* renamed from: c */
        public void mo2302c(int i) {
            this.f1242M = i;
        }

        /* renamed from: d */
        public void mo2303d(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            mo2327l();
            setInputMethodMode(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listView.setTextDirection(i);
                listView.setTextAlignment(i2);
            }
            setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                C0265b bVar = new C0265b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                setOnDismissListener(new C0266c(bVar));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public void mo2327l() {
            int i;
            int i2;
            Drawable background = getBackground();
            int i3 = 0;
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.f1228h);
                if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                    i2 = AppCompatSpinner.this.f1228h.right;
                } else {
                    i2 = -AppCompatSpinner.this.f1228h.left;
                }
                i3 = i2;
            } else {
                Rect rect = AppCompatSpinner.this.f1228h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i4 = appCompatSpinner.f1227g;
            if (i4 == -2) {
                int a = appCompatSpinner.mo2268a((SpinnerAdapter) this.f1240K, getBackground());
                int i5 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1228h;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (a > i6) {
                    a = i6;
                }
                setContentWidth(Math.max(a, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(i4);
            }
            if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                i = i3 + (((width - paddingRight) - getWidth()) - mo2328m());
            } else {
                i = i3 + paddingLeft + mo2328m();
            }
            setHorizontalOffset(i);
        }

        /* renamed from: m */
        public int mo2328m() {
            return this.f1242M;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo2329n(View view) {
            return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.f1241L);
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f1240K = listAdapter;
        }
    }

    @VisibleForTesting
    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$f */
    interface C0267f {
        /* renamed from: a */
        CharSequence mo2300a();

        /* renamed from: b */
        void mo2301b(CharSequence charSequence);

        /* renamed from: c */
        void mo2302c(int i);

        /* renamed from: d */
        void mo2303d(int i, int i2);

        void dismiss();

        Drawable getBackground();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setVerticalOffset(int i);
    }

    public AppCompatSpinner(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2268a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.f1228h);
        Rect rect = this.f1228h;
        return i2 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2269b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1226f.mo2303d(getTextDirection(), getTextAlignment());
        } else {
            this.f1226f.mo2303d(-1, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            bVar.mo2943b();
        }
    }

    public int getDropDownHorizontalOffset() {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            return fVar.getHorizontalOffset();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            return fVar.getVerticalOffset();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f1226f != null) {
            return this.f1227g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final C0267f getInternalPopup() {
        return this.f1226f;
    }

    public Drawable getPopupBackground() {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            return fVar.getBackground();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f1222b;
    }

    public CharSequence getPrompt() {
        C0267f fVar = this.f1226f;
        return fVar != null ? fVar.mo2300a() : super.getPrompt();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            return bVar.mo2944c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            return bVar.mo2945d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0267f fVar = this.f1226f;
        if (fVar != null && fVar.isShowing()) {
            this.f1226f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1226f != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo2268a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1229a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new C0260b());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0267f fVar = this.f1226f;
        savedState.f1229a = fVar != null && fVar.isShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.f1223c;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        C0267f fVar = this.f1226f;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.isShowing()) {
            return true;
        }
        mo2269b();
        return true;
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            bVar.mo2947f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            bVar.mo2948g(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            fVar.mo2302c(i);
            this.f1226f.setHorizontalOffset(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            fVar.setVerticalOffset(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f1226f != null) {
            this.f1227g = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            fVar.setBackgroundDrawable(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        C0267f fVar = this.f1226f;
        if (fVar != null) {
            fVar.mo2301b(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            bVar.mo2950i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0317b bVar = this.f1221a;
        if (bVar != null) {
            bVar.mo2951j(mode);
        }
    }

    public AppCompatSpinner(@NonNull Context context, int i) {
        this(context, (AttributeSet) null, C0131R.attr.spinnerStyle, i);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1225e) {
            this.f1224d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1226f != null) {
            Context context = this.f1222b;
            if (context == null) {
                context = getContext();
            }
            this.f1226f.setAdapter(new C0262d(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r11 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r11 != null) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1228h = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(r6, r0)
            int[] r0 = androidx.appcompat.C0131R.styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.b r2 = new androidx.appcompat.widget.b
            r2.<init>(r6)
            r6.f1221a = r2
            if (r11 == 0) goto L_0x0029
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
            r6.f1222b = r2
            goto L_0x003b
        L_0x0029:
            int r11 = androidx.appcompat.C0131R.styleable.Spinner_popupTheme
            int r11 = r0.getResourceId(r11, r1)
            if (r11 == 0) goto L_0x0039
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (int) r11)
            r6.f1222b = r2
            goto L_0x003b
        L_0x0039:
            r6.f1222b = r7
        L_0x003b:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x006d
            int[] r11 = f1220i     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0055 }
            if (r3 == 0) goto L_0x004f
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0055 }
        L_0x004f:
            if (r11 == 0) goto L_0x006d
        L_0x0051:
            r11.recycle()
            goto L_0x006d
        L_0x0055:
            r3 = move-exception
            goto L_0x005b
        L_0x0057:
            r7 = move-exception
            goto L_0x0067
        L_0x0059:
            r3 = move-exception
            r11 = r2
        L_0x005b:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0065 }
            if (r11 == 0) goto L_0x006d
            goto L_0x0051
        L_0x0065:
            r7 = move-exception
            r2 = r11
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.recycle()
        L_0x006c:
            throw r7
        L_0x006d:
            r11 = 1
            if (r10 == 0) goto L_0x00aa
            if (r10 == r11) goto L_0x0073
            goto L_0x00ba
        L_0x0073:
            androidx.appcompat.widget.AppCompatSpinner$e r10 = new androidx.appcompat.widget.AppCompatSpinner$e
            android.content.Context r3 = r6.f1222b
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f1222b
            int[] r4 = androidx.appcompat.C0131R.styleable.Spinner
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.C0131R.styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.getLayoutDimension((int) r3, (int) r4)
            r6.f1227g = r3
            int r3 = androidx.appcompat.C0131R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.getDrawable(r3)
            r10.setBackgroundDrawable(r3)
            int r3 = androidx.appcompat.C0131R.styleable.Spinner_android_prompt
            java.lang.String r3 = r0.getString(r3)
            r10.mo2301b(r3)
            r1.recycle()
            r6.f1226f = r10
            androidx.appcompat.widget.AppCompatSpinner$a r1 = new androidx.appcompat.widget.AppCompatSpinner$a
            r1.<init>(r6, r10)
            r6.f1223c = r1
            goto L_0x00ba
        L_0x00aa:
            androidx.appcompat.widget.AppCompatSpinner$c r10 = new androidx.appcompat.widget.AppCompatSpinner$c
            r10.<init>()
            r6.f1226f = r10
            int r1 = androidx.appcompat.C0131R.styleable.Spinner_android_prompt
            java.lang.String r1 = r0.getString(r1)
            r10.mo2301b(r1)
        L_0x00ba:
            int r10 = androidx.appcompat.C0131R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.getTextArray(r10)
            if (r10 == 0) goto L_0x00d2
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.C0131R.layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00d2:
            r0.recycle()
            r6.f1225e = r11
            android.widget.SpinnerAdapter r7 = r6.f1224d
            if (r7 == 0) goto L_0x00e0
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f1224d = r2
        L_0x00e0:
            androidx.appcompat.widget.b r7 = r6.f1221a
            r7.mo2946e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
