package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    private MenuItemImpl f875a;

    /* renamed from: b */
    private ImageView f876b;

    /* renamed from: c */
    private RadioButton f877c;

    /* renamed from: d */
    private TextView f878d;

    /* renamed from: e */
    private CheckBox f879e;

    /* renamed from: f */
    private TextView f880f;

    /* renamed from: g */
    private ImageView f881g;

    /* renamed from: h */
    private ImageView f882h;

    /* renamed from: i */
    private LinearLayout f883i;

    /* renamed from: j */
    private Drawable f884j;

    /* renamed from: k */
    private int f885k;

    /* renamed from: l */
    private Context f886l;

    /* renamed from: m */
    private boolean f887m;

    /* renamed from: n */
    private Drawable f888n;

    /* renamed from: o */
    private boolean f889o;

    /* renamed from: p */
    private LayoutInflater f890p;

    /* renamed from: q */
    private boolean f891q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.listMenuViewStyle);
    }

    /* renamed from: a */
    private void m659a(View view) {
        m660b(view, -1);
    }

    /* renamed from: b */
    private void m660b(View view, int i) {
        LinearLayout linearLayout = this.f883i;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    /* renamed from: c */
    private void m661c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(C0131R.layout.abc_list_menu_item_checkbox, this, false);
        this.f879e = checkBox;
        m659a(checkBox);
    }

    /* renamed from: d */
    private void m662d() {
        ImageView imageView = (ImageView) getInflater().inflate(C0131R.layout.abc_list_menu_item_icon, this, false);
        this.f876b = imageView;
        m660b(imageView, 0);
    }

    /* renamed from: e */
    private void m663e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(C0131R.layout.abc_list_menu_item_radio, this, false);
        this.f877c = radioButton;
        m659a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f890p == null) {
            this.f890p = LayoutInflater.from(getContext());
        }
        return this.f890p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f881g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f882h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f882h.getLayoutParams();
            rect.top += this.f882h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public MenuItemImpl getItemData() {
        return this.f875a;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f875a = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.mo1717e(this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.mo1736i(), menuItemImpl.mo1715c());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.f884j);
        TextView textView = (TextView) findViewById(C0131R.C0133id.title);
        this.f878d = textView;
        int i = this.f885k;
        if (i != -1) {
            textView.setTextAppearance(this.f886l, i);
        }
        this.f880f = (TextView) findViewById(C0131R.C0133id.shortcut);
        ImageView imageView = (ImageView) findViewById(C0131R.C0133id.submenuarrow);
        this.f881g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f888n);
        }
        this.f882h = (ImageView) findViewById(C0131R.C0133id.group_divider);
        this.f883i = (LinearLayout) findViewById(C0131R.C0133id.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f876b != null && this.f887m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f876b.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f877c != null || this.f879e != null) {
            if (this.f875a.isExclusiveCheckable()) {
                if (this.f877c == null) {
                    m663e();
                }
                compoundButton2 = this.f877c;
                compoundButton = this.f879e;
            } else {
                if (this.f879e == null) {
                    m661c();
                }
                compoundButton2 = this.f879e;
                compoundButton = this.f877c;
            }
            if (z) {
                compoundButton2.setChecked(this.f875a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f879e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f877c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f875a.isExclusiveCheckable()) {
            if (this.f877c == null) {
                m663e();
            }
            compoundButton = this.f877c;
        } else {
            if (this.f879e == null) {
                m661c();
            }
            compoundButton = this.f879e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f891q = z;
        this.f887m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f882h;
        if (imageView != null) {
            imageView.setVisibility((this.f889o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f875a.shouldShowIcon() || this.f891q;
        if (z || this.f887m) {
            ImageView imageView = this.f876b;
            if (imageView != null || drawable != null || this.f887m) {
                if (imageView == null) {
                    m662d();
                }
                if (drawable != null || this.f887m) {
                    ImageView imageView2 = this.f876b;
                    if (!z) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f876b.getVisibility() != 0) {
                        this.f876b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f876b.setVisibility(8);
            }
        }
    }

    public void setShortcut(boolean z, char c) {
        int i = (!z || !this.f875a.mo1736i()) ? 8 : 0;
        if (i == 0) {
            this.f880f.setText(this.f875a.mo1716d());
        }
        if (this.f880f.getVisibility() != i) {
            this.f880f.setVisibility(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f878d.setText(charSequence);
            if (this.f878d.getVisibility() != 0) {
                this.f878d.setVisibility(0);
            }
        } else if (this.f878d.getVisibility() != 8) {
            this.f878d.setVisibility(8);
        }
    }

    public boolean showsIcon() {
        return this.f891q;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, C0131R.styleable.MenuView, i, 0);
        this.f884j = obtainStyledAttributes.getDrawable(C0131R.styleable.MenuView_android_itemBackground);
        this.f885k = obtainStyledAttributes.getResourceId(C0131R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f887m = obtainStyledAttributes.getBoolean(C0131R.styleable.MenuView_preserveIconSpacing, false);
        this.f886l = context;
        this.f888n = obtainStyledAttributes.getDrawable(C0131R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, C0131R.attr.dropDownListViewStyle, 0);
        this.f889o = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }
}
