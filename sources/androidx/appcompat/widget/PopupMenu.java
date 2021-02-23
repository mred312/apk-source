package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {

    /* renamed from: a */
    private final Context f1346a;

    /* renamed from: b */
    private final MenuBuilder f1347b;

    /* renamed from: c */
    private final View f1348c;

    /* renamed from: d */
    final MenuPopupHelper f1349d;

    /* renamed from: e */
    OnMenuItemClickListener f1350e;

    /* renamed from: f */
    OnDismissListener f1351f;

    /* renamed from: g */
    private View.OnTouchListener f1352g;

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$a */
    class C0278a implements MenuBuilder.Callback {
        C0278a() {
        }

        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.f1350e;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }

        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$b */
    class C0279b implements PopupWindow.OnDismissListener {
        C0279b() {
        }

        public void onDismiss() {
            PopupMenu popupMenu = PopupMenu.this;
            OnDismissListener onDismissListener = popupMenu.f1351f;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(popupMenu);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$c */
    class C0280c extends ForwardingListener {
        C0280c(View view) {
            super(view);
        }

        public ShowableListMenu getPopup() {
            return PopupMenu.this.f1349d.getPopup();
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            PopupMenu.this.show();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStopped() {
            PopupMenu.this.dismiss();
            return true;
        }
    }

    public PopupMenu(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    public void dismiss() {
        this.f1349d.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.f1352g == null) {
            this.f1352g = new C0280c(this.f1348c);
        }
        return this.f1352g;
    }

    public int getGravity() {
        return this.f1349d.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.f1347b;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f1346a);
    }

    public void inflate(@MenuRes int i) {
        getMenuInflater().inflate(i, this.f1347b);
    }

    public void setGravity(int i) {
        this.f1349d.setGravity(i);
    }

    public void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.f1351f = onDismissListener;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener onMenuItemClickListener) {
        this.f1350e = onMenuItemClickListener;
    }

    public void show() {
        this.f1349d.show();
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i) {
        this(context, view, i, C0131R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i, @AttrRes int i2, @StyleRes int i3) {
        this.f1346a = context;
        this.f1348c = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.f1347b = menuBuilder;
        menuBuilder.setCallback(new C0278a());
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i2, i3);
        this.f1349d = menuPopupHelper;
        menuPopupHelper.setGravity(i);
        menuPopupHelper.setOnDismissListener(new C0279b());
    }
}
