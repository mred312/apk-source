package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: c */
    private Context f735c;

    /* renamed from: d */
    private ActionBarContextView f736d;

    /* renamed from: e */
    private ActionMode.Callback f737e;

    /* renamed from: f */
    private WeakReference<View> f738f;

    /* renamed from: g */
    private boolean f739g;

    /* renamed from: h */
    private boolean f740h;

    /* renamed from: i */
    private MenuBuilder f741i;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f735c = context;
        this.f736d = actionBarContextView;
        this.f737e = callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f741i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f740h = z;
    }

    public void finish() {
        if (!this.f739g) {
            this.f739g = true;
            this.f736d.sendAccessibilityEvent(32);
            this.f737e.onDestroyActionMode(this);
        }
    }

    public View getCustomView() {
        WeakReference<View> weakReference = this.f738f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu getMenu() {
        return this.f741i;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f736d.getContext());
    }

    public CharSequence getSubtitle() {
        return this.f736d.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.f736d.getTitle();
    }

    public void invalidate() {
        this.f737e.onPrepareActionMode(this, this.f741i);
    }

    public boolean isTitleOptional() {
        return this.f736d.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return this.f740h;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return this.f737e.onActionItemClicked(this, menuItem);
    }

    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        invalidate();
        this.f736d.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f736d.getContext(), subMenuBuilder).show();
        return true;
    }

    public void setCustomView(View view) {
        this.f736d.setCustomView(view);
        this.f738f = view != null ? new WeakReference<>(view) : null;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f736d.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f736d.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.f736d.setTitleOptional(z);
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.f735c.getString(i));
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.f735c.getString(i));
    }
}
