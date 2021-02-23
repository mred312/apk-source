package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: A */
    private View f937A;

    /* renamed from: B */
    private ActionProvider f938B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f939C;

    /* renamed from: D */
    private boolean f940D = false;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f941E;

    /* renamed from: a */
    private final int f942a;

    /* renamed from: b */
    private final int f943b;

    /* renamed from: c */
    private final int f944c;

    /* renamed from: d */
    private final int f945d;

    /* renamed from: e */
    private CharSequence f946e;

    /* renamed from: f */
    private CharSequence f947f;

    /* renamed from: g */
    private Intent f948g;

    /* renamed from: h */
    private char f949h;

    /* renamed from: i */
    private int f950i = 4096;

    /* renamed from: j */
    private char f951j;

    /* renamed from: k */
    private int f952k = 4096;

    /* renamed from: l */
    private Drawable f953l;

    /* renamed from: m */
    private int f954m = 0;

    /* renamed from: n */
    MenuBuilder f955n;

    /* renamed from: o */
    private SubMenuBuilder f956o;

    /* renamed from: p */
    private Runnable f957p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f958q;

    /* renamed from: r */
    private CharSequence f959r;

    /* renamed from: s */
    private CharSequence f960s;

    /* renamed from: t */
    private ColorStateList f961t = null;

    /* renamed from: u */
    private PorterDuff.Mode f962u = null;

    /* renamed from: v */
    private boolean f963v = false;

    /* renamed from: w */
    private boolean f964w = false;

    /* renamed from: x */
    private boolean f965x = false;

    /* renamed from: y */
    private int f966y = 16;

    /* renamed from: z */
    private int f967z = 0;

    /* renamed from: androidx.appcompat.view.menu.MenuItemImpl$a */
    class C0219a implements ActionProvider.VisibilityListener {
        C0219a() {
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            MenuItemImpl menuItemImpl = MenuItemImpl.this;
            menuItemImpl.f955n.mo1680n(menuItemImpl);
        }
    }

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f955n = menuBuilder;
        this.f942a = i2;
        this.f943b = i;
        this.f944c = i3;
        this.f945d = i4;
        this.f946e = charSequence;
        this.f967z = i5;
    }

    /* renamed from: a */
    private static void m685a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: b */
    private Drawable m686b(Drawable drawable) {
        if (drawable != null && this.f965x && (this.f963v || this.f964w)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (this.f963v) {
                DrawableCompat.setTintList(drawable, this.f961t);
            }
            if (this.f964w) {
                DrawableCompat.setTintMode(drawable, this.f962u);
            }
            this.f965x = false;
        }
        return drawable;
    }

    public void actionFormatChanged() {
        this.f955n.mo1679m(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public char mo1715c() {
        return this.f955n.isQwertyMode() ? this.f951j : this.f949h;
    }

    public boolean collapseActionView() {
        if ((this.f967z & 8) == 0) {
            return false;
        }
        if (this.f937A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f939C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f955n.collapseItemActionView(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo1716d() {
        char c = mo1715c();
        if (c == 0) {
            return "";
        }
        Resources resources = this.f955n.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f955n.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(C0131R.string.abc_prepend_shortcut_label));
        }
        int i = this.f955n.isQwertyMode() ? this.f952k : this.f950i;
        m685a(sb, i, 65536, resources.getString(C0131R.string.abc_menu_meta_shortcut_label));
        m685a(sb, i, 4096, resources.getString(C0131R.string.abc_menu_ctrl_shortcut_label));
        m685a(sb, i, 2, resources.getString(C0131R.string.abc_menu_alt_shortcut_label));
        m685a(sb, i, 1, resources.getString(C0131R.string.abc_menu_shift_shortcut_label));
        m685a(sb, i, 4, resources.getString(C0131R.string.abc_menu_sym_shortcut_label));
        m685a(sb, i, 8, resources.getString(C0131R.string.abc_menu_function_shortcut_label));
        if (c == 8) {
            sb.append(resources.getString(C0131R.string.abc_menu_delete_shortcut_label));
        } else if (c == 10) {
            sb.append(resources.getString(C0131R.string.abc_menu_enter_shortcut_label));
        } else if (c != ' ') {
            sb.append(c);
        } else {
            sb.append(resources.getString(C0131R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public CharSequence mo1717e(MenuView.ItemView itemView) {
        if (itemView == null || !itemView.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f939C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f955n.expandItemActionView(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo1718f(boolean z) {
        int i = this.f966y;
        int i2 = (z ? 2 : 0) | (i & -3);
        this.f966y = i2;
        if (i != i2) {
            this.f955n.onItemsChanged(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo1719g(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f941E = contextMenuInfo;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.f937A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.f938B;
        if (actionProvider == null) {
            return null;
        }
        View onCreateActionView = actionProvider.onCreateActionView(this);
        this.f937A = onCreateActionView;
        return onCreateActionView;
    }

    public int getAlphabeticModifiers() {
        return this.f952k;
    }

    public char getAlphabeticShortcut() {
        return this.f951j;
    }

    public CharSequence getContentDescription() {
        return this.f959r;
    }

    public int getGroupId() {
        return this.f943b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f953l;
        if (drawable != null) {
            return m686b(drawable);
        }
        if (this.f954m == 0) {
            return null;
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.f955n.getContext(), this.f954m);
        this.f954m = 0;
        this.f953l = drawable2;
        return m686b(drawable2);
    }

    public ColorStateList getIconTintList() {
        return this.f961t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f962u;
    }

    public Intent getIntent() {
        return this.f948g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f942a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f941E;
    }

    public int getNumericModifiers() {
        return this.f950i;
    }

    public char getNumericShortcut() {
        return this.f949h;
    }

    public int getOrder() {
        return this.f944c;
    }

    public int getOrdering() {
        return this.f945d;
    }

    public SubMenu getSubMenu() {
        return this.f956o;
    }

    public ActionProvider getSupportActionProvider() {
        return this.f938B;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f946e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f947f;
        if (charSequence == null) {
            charSequence = this.f946e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f960s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo1733h(boolean z) {
        int i = this.f966y;
        int i2 = (z ? 0 : 8) | (i & -9);
        this.f966y = i2;
        if (i != i2) {
            return true;
        }
        return false;
    }

    public boolean hasCollapsibleActionView() {
        ActionProvider actionProvider;
        if ((this.f967z & 8) == 0) {
            return false;
        }
        if (this.f937A == null && (actionProvider = this.f938B) != null) {
            this.f937A = actionProvider.onCreateActionView(this);
        }
        if (this.f937A != null) {
            return true;
        }
        return false;
    }

    public boolean hasSubMenu() {
        return this.f956o != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo1736i() {
        return this.f955n.isShortcutsVisible() && mo1715c() != 0;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f958q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f955n;
        if (menuBuilder.mo1645b(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.f957p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f948g != null) {
            try {
                this.f955n.getContext().startActivity(this.f948g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        ActionProvider actionProvider = this.f938B;
        if (actionProvider == null || !actionProvider.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isActionButton() {
        return (this.f966y & 32) == 32;
    }

    public boolean isActionViewExpanded() {
        return this.f940D;
    }

    public boolean isCheckable() {
        return (this.f966y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f966y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f966y & 16) != 0;
    }

    public boolean isExclusiveCheckable() {
        return (this.f966y & 4) != 0;
    }

    public boolean isVisible() {
        ActionProvider actionProvider = this.f938B;
        if (actionProvider == null || !actionProvider.overridesItemVisibility()) {
            if ((this.f966y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f966y & 8) != 0 || !this.f938B.isVisible()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean requestsActionButton() {
        return (this.f967z & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.f967z & 2) == 2;
    }

    public boolean requiresOverflow() {
        return !requiresActionButton() && !requestsActionButton();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z) {
        this.f940D = z;
        this.f955n.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f951j == c) {
            return this;
        }
        this.f951j = Character.toLowerCase(c);
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.f957p = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f966y;
        boolean z2 = z | (i & true);
        this.f966y = z2 ? 1 : 0;
        if (i != z2) {
            this.f955n.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f966y & 4) != 0) {
            this.f955n.mo1682p(this);
        } else {
            mo1718f(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f966y |= 16;
        } else {
            this.f966y &= -17;
        }
        this.f955n.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        this.f966y = (z ? 4 : 0) | (this.f966y & -5);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f954m = 0;
        this.f953l = drawable;
        this.f965x = true;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f961t = colorStateList;
        this.f963v = true;
        this.f965x = true;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f962u = mode;
        this.f964w = true;
        this.f965x = true;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f948g = intent;
        return this;
    }

    public void setIsActionButton(boolean z) {
        if (z) {
            this.f966y |= 32;
        } else {
            this.f966y &= -33;
        }
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f949h == c) {
            return this;
        }
        this.f949h = c;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f939C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f958q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f949h = c;
        this.f951j = Character.toLowerCase(c2);
        this.f955n.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            this.f967z = i;
            this.f955n.mo1679m(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.f956o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.f938B;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.f937A = null;
        this.f938B = actionProvider;
        this.f955n.onItemsChanged(true);
        ActionProvider actionProvider3 = this.f938B;
        if (actionProvider3 != null) {
            actionProvider3.setVisibilityListener(new C0219a());
        }
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f946e = charSequence;
        this.f955n.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.f956o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f947f = charSequence;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (mo1733h(z)) {
            this.f955n.mo1680n(this);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        return this.f955n.mo1677j();
    }

    public boolean showsTextAsAction() {
        return (this.f967z & 4) == 4;
    }

    public String toString() {
        CharSequence charSequence = this.f946e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f959r = charSequence;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f960s = charSequence;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public SupportMenuItem setActionView(View view) {
        int i;
        this.f937A = view;
        this.f938B = null;
        if (view != null && view.getId() == -1 && (i = this.f942a) > 0) {
            view.setId(i);
        }
        this.f955n.mo1679m(this);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f951j == c && this.f952k == i) {
            return this;
        }
        this.f951j = Character.toLowerCase(c);
        this.f952k = KeyEvent.normalizeMetaState(i);
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f949h == c && this.f950i == i) {
            return this;
        }
        this.f949h = c;
        this.f950i = KeyEvent.normalizeMetaState(i);
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f949h = c;
        this.f950i = KeyEvent.normalizeMetaState(i);
        this.f951j = Character.toLowerCase(c2);
        this.f952k = KeyEvent.normalizeMetaState(i2);
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f953l = null;
        this.f954m = i;
        this.f965x = true;
        this.f955n.onItemsChanged(false);
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f955n.getContext().getString(i));
    }

    public SupportMenuItem setActionView(int i) {
        Context context = this.f955n.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }
}
