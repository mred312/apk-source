package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.C0131R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.PointerIconCompat;

/* renamed from: androidx.appcompat.view.menu.b */
/* compiled from: MenuDialogHelper */
class C0227b implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* renamed from: a */
    private MenuBuilder f998a;

    /* renamed from: b */
    private AlertDialog f999b;

    /* renamed from: c */
    ListMenuPresenter f1000c;

    /* renamed from: d */
    private MenuPresenter.Callback f1001d;

    public C0227b(MenuBuilder menuBuilder) {
        this.f998a = menuBuilder;
    }

    /* renamed from: a */
    public void mo1894a() {
        AlertDialog alertDialog = this.f999b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: b */
    public void mo1895b(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f998a;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), C0131R.layout.abc_list_menu_item_layout);
        this.f1000c = listMenuPresenter;
        listMenuPresenter.setCallback(this);
        this.f998a.addMenuPresenter(this.f1000c);
        builder.setAdapter(this.f1000c.getAdapter(), this);
        View headerView = menuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(this);
        AlertDialog create = builder.create();
        this.f999b = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f999b.getWindow().getAttributes();
        attributes.type = PointerIconCompat.TYPE_HELP;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f999b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f998a.performItemAction((MenuItemImpl) this.f1000c.getAdapter().getItem(i), 0);
    }

    public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f998a) {
            mo1894a();
        }
        MenuPresenter.Callback callback = this.f1001d;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1000c.onCloseMenu(this.f998a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f999b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f999b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f998a.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f998a.performShortcut(i, keyEvent, 0);
    }

    public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.f1001d;
        if (callback != null) {
            return callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }
}
