package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a */
    private final int f799a;

    /* renamed from: b */
    private final int f800b;

    /* renamed from: c */
    private final int f801c;

    /* renamed from: d */
    private CharSequence f802d;

    /* renamed from: e */
    private CharSequence f803e;

    /* renamed from: f */
    private Intent f804f;

    /* renamed from: g */
    private char f805g;

    /* renamed from: h */
    private int f806h = 4096;

    /* renamed from: i */
    private char f807i;

    /* renamed from: j */
    private int f808j = 4096;

    /* renamed from: k */
    private Drawable f809k;

    /* renamed from: l */
    private Context f810l;

    /* renamed from: m */
    private MenuItem.OnMenuItemClickListener f811m;

    /* renamed from: n */
    private CharSequence f812n;

    /* renamed from: o */
    private CharSequence f813o;

    /* renamed from: p */
    private ColorStateList f814p = null;

    /* renamed from: q */
    private PorterDuff.Mode f815q = null;

    /* renamed from: r */
    private boolean f816r = false;

    /* renamed from: s */
    private boolean f817s = false;

    /* renamed from: t */
    private int f818t = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f810l = context;
        this.f799a = i2;
        this.f800b = i;
        this.f801c = i4;
        this.f802d = charSequence;
    }

    /* renamed from: a */
    private void m639a() {
        Drawable drawable = this.f809k;
        if (drawable == null) {
            return;
        }
        if (this.f816r || this.f817s) {
            Drawable wrap = DrawableCompat.wrap(drawable);
            this.f809k = wrap;
            Drawable mutate = wrap.mutate();
            this.f809k = mutate;
            if (this.f816r) {
                DrawableCompat.setTintList(mutate, this.f814p);
            }
            if (this.f817s) {
                DrawableCompat.setTintMode(this.f809k, this.f815q);
            }
        }
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f808j;
    }

    public char getAlphabeticShortcut() {
        return this.f807i;
    }

    public CharSequence getContentDescription() {
        return this.f812n;
    }

    public int getGroupId() {
        return this.f800b;
    }

    public Drawable getIcon() {
        return this.f809k;
    }

    public ColorStateList getIconTintList() {
        return this.f814p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f815q;
    }

    public Intent getIntent() {
        return this.f804f;
    }

    public int getItemId() {
        return this.f799a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f806h;
    }

    public char getNumericShortcut() {
        return this.f805g;
    }

    public int getOrder() {
        return this.f801c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f802d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f803e;
        return charSequence != null ? charSequence : this.f802d;
    }

    public CharSequence getTooltipText() {
        return this.f813o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f811m;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.f804f;
        if (intent == null) {
            return false;
        }
        this.f810l.startActivity(intent);
        return true;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f818t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f818t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f818t & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f818t & 8) == 0;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f807i = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f818t = z | (this.f818t & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f818t = (z ? 2 : 0) | (this.f818t & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f818t = (z ? 16 : 0) | (this.f818t & -17);
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z) {
        this.f818t = (z ? 4 : 0) | (this.f818t & -5);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f809k = drawable;
        m639a();
        return this;
    }

    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f814p = colorStateList;
        this.f816r = true;
        m639a();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f815q = mode;
        this.f817s = true;
        m639a();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f804f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f805g = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f811m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f805g = c;
        this.f807i = Character.toLowerCase(c2);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f802d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f803e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f818t & 8;
        if (z) {
            i = 0;
        }
        this.f818t = i2 | i;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f807i = Character.toLowerCase(c);
        this.f808j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f812n = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f805g = c;
        this.f806h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f802d = this.f810l.getResources().getString(i);
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f813o = charSequence;
        return this;
    }

    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setIcon(int i) {
        this.f809k = ContextCompat.getDrawable(this.f810l, i);
        m639a();
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f805g = c;
        this.f806h = KeyEvent.normalizeMetaState(i);
        this.f807i = Character.toLowerCase(c2);
        this.f808j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }
}
