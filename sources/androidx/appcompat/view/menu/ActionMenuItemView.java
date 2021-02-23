package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {

    /* renamed from: f */
    MenuItemImpl f819f;

    /* renamed from: g */
    private CharSequence f820g;

    /* renamed from: h */
    private Drawable f821h;

    /* renamed from: i */
    MenuBuilder.ItemInvoker f822i;

    /* renamed from: j */
    private ForwardingListener f823j;

    /* renamed from: k */
    PopupCallback f824k;

    /* renamed from: l */
    private boolean f825l;

    /* renamed from: m */
    private boolean f826m;

    /* renamed from: n */
    private int f827n;

    /* renamed from: o */
    private int f828o;

    /* renamed from: p */
    private int f829p;

    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    private class C0212a extends ForwardingListener {
        public C0212a() {
            super(ActionMenuItemView.this);
        }

        public ShowableListMenu getPopup() {
            PopupCallback popupCallback = ActionMenuItemView.this.f824k;
            if (popupCallback != null) {
                return popupCallback.getPopup();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ShowableListMenu popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.f822i;
            if (itemInvoker == null || !itemInvoker.invokeItem(actionMenuItemView.f819f) || (popup = getPopup()) == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: b */
    private boolean m640b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* renamed from: c */
    private void m641c() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f820g);
        if (this.f821h != null && (!this.f819f.showsTextAsAction() || (!this.f825l && !this.f826m))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.f820g : null);
        CharSequence contentDescription = this.f819f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f819f.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f819f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f819f.getTitle();
            }
            TooltipCompat.setTooltipText(this, charSequence2);
            return;
        }
        TooltipCompat.setTooltipText(this, tooltipText);
    }

    public MenuItemImpl getItemData() {
        return this.f819f;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f819f = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.mo1717e(this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f823j == null) {
            this.f823j = new C0212a();
        }
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean needsDividerBefore() {
        return hasText() && this.f819f.getIcon() == null;
    }

    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.f822i;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.f819f);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f825l = m640b();
        m641c();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean hasText = hasText();
        if (hasText && (i4 = this.f828o) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, this.f827n);
        } else {
            i3 = this.f827n;
        }
        if (mode != 1073741824 && this.f827n > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        if (!hasText && this.f821h != null) {
            super.setPadding((getMeasuredWidth() - this.f821h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (!this.f819f.hasSubMenu() || (forwardingListener = this.f823j) == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f826m != z) {
            this.f826m = z;
            MenuItemImpl menuItemImpl = this.f819f;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f821h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f829p;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i) / ((float) intrinsicHeight)));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        m641c();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f822i = itemInvoker;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f828o = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f824k = popupCallback;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f820g = charSequence;
        m641c();
    }

    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f825l = m640b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0131R.styleable.ActionMenuItemView, i, 0);
        this.f827n = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f829p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f828o = -1;
        setSaveEnabled(false);
    }
}
