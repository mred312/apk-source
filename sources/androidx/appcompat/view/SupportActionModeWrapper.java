package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportActionModeWrapper extends ActionMode {

    /* renamed from: a */
    final Context f742a;

    /* renamed from: b */
    final ActionMode f743b;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a */
        final ActionMode.Callback f744a;

        /* renamed from: b */
        final Context f745b;

        /* renamed from: c */
        final ArrayList<SupportActionModeWrapper> f746c = new ArrayList<>();

        /* renamed from: d */
        final SimpleArrayMap<Menu, Menu> f747d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f745b = context;
            this.f744a = callback;
        }

        /* renamed from: a */
        private Menu m624a(Menu menu) {
            Menu menu2 = this.f747d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f745b, (SupportMenu) menu);
            this.f747d.put(menu, menuWrapperICS);
            return menuWrapperICS;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.f746c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f746c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f743b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f745b, actionMode);
            this.f746c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f744a.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.f745b, (SupportMenuItem) menuItem));
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f744a.onCreateActionMode(getActionModeWrapper(actionMode), m624a(menu));
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f744a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f744a.onPrepareActionMode(getActionModeWrapper(actionMode), m624a(menu));
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f742a = context;
        this.f743b = actionMode;
    }

    public void finish() {
        this.f743b.finish();
    }

    public View getCustomView() {
        return this.f743b.getCustomView();
    }

    public Menu getMenu() {
        return new MenuWrapperICS(this.f742a, (SupportMenu) this.f743b.getMenu());
    }

    public MenuInflater getMenuInflater() {
        return this.f743b.getMenuInflater();
    }

    public CharSequence getSubtitle() {
        return this.f743b.getSubtitle();
    }

    public Object getTag() {
        return this.f743b.getTag();
    }

    public CharSequence getTitle() {
        return this.f743b.getTitle();
    }

    public boolean getTitleOptionalHint() {
        return this.f743b.getTitleOptionalHint();
    }

    public void invalidate() {
        this.f743b.invalidate();
    }

    public boolean isTitleOptional() {
        return this.f743b.isTitleOptional();
    }

    public void setCustomView(View view) {
        this.f743b.setCustomView(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f743b.setSubtitle(charSequence);
    }

    public void setTag(Object obj) {
        this.f743b.setTag(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f743b.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f743b.setTitleOptionalHint(z);
    }

    public void setSubtitle(int i) {
        this.f743b.setSubtitle(i);
    }

    public void setTitle(int i) {
        this.f743b.setTitle(i);
    }
}
