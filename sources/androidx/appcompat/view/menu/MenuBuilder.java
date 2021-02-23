package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuBuilder implements SupportMenu {

    /* renamed from: A */
    private static final int[] f910A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    private final Context f911a;

    /* renamed from: b */
    private final Resources f912b;

    /* renamed from: c */
    private boolean f913c;

    /* renamed from: d */
    private boolean f914d;

    /* renamed from: e */
    private Callback f915e;

    /* renamed from: f */
    private ArrayList<MenuItemImpl> f916f;

    /* renamed from: g */
    private ArrayList<MenuItemImpl> f917g;

    /* renamed from: h */
    private boolean f918h;

    /* renamed from: i */
    private ArrayList<MenuItemImpl> f919i;

    /* renamed from: j */
    private ArrayList<MenuItemImpl> f920j;

    /* renamed from: k */
    private boolean f921k;

    /* renamed from: l */
    private int f922l = 0;

    /* renamed from: m */
    private ContextMenu.ContextMenuInfo f923m;

    /* renamed from: n */
    CharSequence f924n;

    /* renamed from: o */
    Drawable f925o;

    /* renamed from: p */
    View f926p;

    /* renamed from: q */
    private boolean f927q = false;

    /* renamed from: r */
    private boolean f928r = false;

    /* renamed from: s */
    private boolean f929s = false;

    /* renamed from: t */
    private boolean f930t = false;

    /* renamed from: u */
    private boolean f931u = false;

    /* renamed from: v */
    private ArrayList<MenuItemImpl> f932v = new ArrayList<>();

    /* renamed from: w */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f933w = new CopyOnWriteArrayList<>();

    /* renamed from: x */
    private MenuItemImpl f934x;

    /* renamed from: y */
    private boolean f935y = false;

    /* renamed from: z */
    private boolean f936z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void onMenuModeChange(@NonNull MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f911a = context;
        this.f912b = context.getResources();
        this.f916f = new ArrayList<>();
        this.f917g = new ArrayList<>();
        this.f918h = true;
        this.f919i = new ArrayList<>();
        this.f920j = new ArrayList<>();
        this.f921k = true;
        m676r(true);
    }

    /* renamed from: a */
    private MenuItemImpl m667a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    /* renamed from: c */
    private void m668c(boolean z) {
        if (!this.f933w.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f933w.remove(next);
                } else {
                    menuPresenter.updateMenuView(z);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    /* renamed from: d */
    private void m669d(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f933w.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f933w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private void m670e(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.f933w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f933w.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    /* renamed from: f */
    private boolean m671f(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z = false;
        if (this.f933w.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z = menuPresenter.onSubMenuSelected(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.f933w.remove(next);
            } else if (!z) {
                z = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
        }
        return z;
    }

    /* renamed from: g */
    private static int m672g(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* renamed from: k */
    private static int m673k(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = f910A;
            if (i2 < iArr.length) {
                return (i & SupportMenu.USER_MASK) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* renamed from: o */
    private void m674o(int i, boolean z) {
        if (i >= 0 && i < this.f916f.size()) {
            this.f916f.remove(i);
            if (z) {
                onItemsChanged(true);
            }
        }
    }

    /* renamed from: q */
    private void m675q(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources l = mo1678l();
        if (view != null) {
            this.f926p = view;
            this.f924n = null;
            this.f925o = null;
        } else {
            if (i > 0) {
                this.f924n = l.getText(i);
            } else if (charSequence != null) {
                this.f924n = charSequence;
            }
            if (i2 > 0) {
                this.f925o = ContextCompat.getDrawable(getContext(), i2);
            } else if (drawable != null) {
                this.f925o = drawable;
            }
            this.f926p = null;
        }
        onItemsChanged(false);
    }

    /* renamed from: r */
    private void m676r(boolean z) {
        boolean z2 = true;
        if (!z || this.f912b.getConfiguration().keyboard == 1 || !ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.f911a), this.f911a)) {
            z2 = false;
        }
        this.f914d = z2;
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f911a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int k = m673k(i3);
        MenuItemImpl a = m667a(i, i2, i3, k, charSequence, this.f922l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f923m;
        if (contextMenuInfo != null) {
            a.mo1719g(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.f916f;
        arrayList.add(m672g(arrayList, k), a);
        onItemsChanged(true);
        return a;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.f911a);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo1645b(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        Callback callback = this.f915e;
        return callback != null && callback.onMenuItemSelected(menuBuilder, menuItem);
    }

    public void changeMenuMode() {
        Callback callback = this.f915e;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    public void clear() {
        MenuItemImpl menuItemImpl = this.f934x;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.f916f.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.f927q = true;
        clear();
        clearHeader();
        this.f933w.clear();
        this.f927q = false;
        this.f928r = false;
        this.f929s = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.f925o = null;
        this.f924n = null;
        this.f926p = null;
        onItemsChanged(false);
    }

    public final void close(boolean z) {
        if (!this.f931u) {
            this.f931u = true;
            Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f933w.remove(next);
                } else {
                    menuPresenter.onCloseMenu(this, z);
                }
            }
            this.f931u = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f933w.isEmpty() && this.f934x == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f933w.remove(next);
                } else {
                    z = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.f934x = null;
            }
        }
        return z;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (this.f933w.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter = (MenuPresenter) next.get();
            if (menuPresenter == null) {
                this.f933w.remove(next);
            } else {
                z = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.f934x = menuItemImpl;
        }
        return z;
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f916f.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f916f.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.f921k) {
            Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.f933w.remove(next);
                } else {
                    z |= menuPresenter.flagActionItems();
                }
            }
            if (z) {
                this.f919i.clear();
                this.f920j.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i);
                    if (menuItemImpl.isActionButton()) {
                        this.f919i.add(menuItemImpl);
                    } else {
                        this.f920j.add(menuItemImpl);
                    }
                }
            } else {
                this.f919i.clear();
                this.f920j.clear();
                this.f920j.addAll(getVisibleItems());
            }
            this.f921k = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.f919i;
    }

    /* access modifiers changed from: protected */
    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return this.f911a;
    }

    public MenuItemImpl getExpandedItem() {
        return this.f934x;
    }

    public Drawable getHeaderIcon() {
        return this.f925o;
    }

    public CharSequence getHeaderTitle() {
        return this.f924n;
    }

    public View getHeaderView() {
        return this.f926p;
    }

    public MenuItem getItem(int i) {
        return this.f916f.get(i);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.f920j;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.f918h) {
            return this.f917g;
        }
        this.f917g.clear();
        int size = this.f916f.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f916f.get(i);
            if (menuItemImpl.isVisible()) {
                this.f917g.add(menuItemImpl);
            }
        }
        this.f918h = false;
        this.f921k = true;
        return this.f917g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public MenuItemImpl mo1670h(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<MenuItemImpl> arrayList = this.f932v;
        arrayList.clear();
        mo1672i(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            if (isQwertyMode) {
                c = menuItemImpl.getAlphabeticShortcut();
            } else {
                c = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c == 8 && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean hasVisibleItems() {
        if (this.f936z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f916f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo1672i(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f916f.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f916f.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).mo1672i(list, i, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == ((isQwertyMode ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & SupportMenu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (isQwertyMode && alphabeticShortcut == 8 && i == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public boolean isGroupDividerEnabled() {
        return this.f935y;
    }

    /* access modifiers changed from: package-private */
    public boolean isQwertyMode() {
        return this.f913c;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return mo1670h(i, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.f914d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo1677j() {
        return this.f930t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Resources mo1678l() {
        return this.f912b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo1679m(MenuItemImpl menuItemImpl) {
        this.f921k = true;
        onItemsChanged(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo1680n(MenuItemImpl menuItemImpl) {
        this.f918h = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z) {
        if (!this.f927q) {
            if (z) {
                this.f918h = true;
                this.f921k = true;
            }
            m668c(z);
            return;
        }
        this.f928r = true;
        if (z) {
            this.f929s = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo1682p(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f916f.size();
        stopDispatchingItemsChanged();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f916f.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.mo1718f(menuItemImpl == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, (MenuPresenter) null, i);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl h = mo1670h(i, keyEvent);
        boolean performItemAction = h != null ? performItemAction(h, i2) : false;
        if ((i2 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            int size = this.f916f.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f916f.get(findGroupIndex).getGroupId() != i) {
                    onItemsChanged(true);
                } else {
                    m674o(findGroupIndex, false);
                    i2 = i3;
                }
            }
            onItemsChanged(true);
        }
    }

    public void removeItem(int i) {
        m674o(findItemIndex(i), true);
    }

    public void removeItemAt(int i) {
        m674o(i, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.f933w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f933w.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        m669d(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        m670e(bundle);
    }

    public void setCallback(Callback callback) {
        this.f915e = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f923m = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        this.f922l = i;
        return this;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f916f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f916f.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        this.f935y = z;
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f916f.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f916f.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f916f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f916f.get(i2);
            if (menuItemImpl.getGroupId() == i && menuItemImpl.mo1733h(z)) {
                z2 = true;
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(Drawable drawable) {
        m675q(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        m675q(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderViewInt(View view) {
        m675q(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z) {
        this.f930t = z;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.f936z = z;
    }

    public void setQwertyMode(boolean z) {
        this.f913c = z;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z) {
        if (this.f914d != z) {
            m676r(z);
            onItemsChanged(false);
        }
    }

    public int size() {
        return this.f916f.size();
    }

    public void startDispatchingItemsChanged() {
        this.f927q = false;
        if (this.f928r) {
            this.f928r = false;
            onItemsChanged(this.f929s);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.f927q) {
            this.f927q = true;
            this.f928r = false;
            this.f929s = false;
        }
    }

    public MenuItem add(int i) {
        return addInternal(0, 0, 0, this.f912b.getString(i));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.f933w.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.f921k = true;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f912b.getString(i));
    }

    public int findGroupIndex(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f916f.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        ActionProvider supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            invoke |= m671f(subMenuBuilder, menuPresenter);
            if (!invoke) {
                close(true);
            }
        } else if ((i & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderIconInt(int i) {
        m675q(0, (CharSequence) null, i, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder setHeaderTitleInt(int i) {
        m675q(i, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f911a, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.f912b.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, (CharSequence) this.f912b.getString(i4));
    }

    public void close() {
        close(true);
    }
}
