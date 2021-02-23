package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.C0131R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: d */
    private int f1465d = 4;

    /* renamed from: e */
    private final C0307b f1466e = new C0307b();

    /* renamed from: f */
    final Context f1467f;

    /* renamed from: g */
    String f1468g = DEFAULT_SHARE_HISTORY_FILE_NAME;

    /* renamed from: h */
    OnShareTargetSelectedListener f1469h;

    /* renamed from: i */
    private ActivityChooserModel.OnChooseActivityListener f1470i;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    /* renamed from: androidx.appcompat.widget.ShareActionProvider$a */
    private class C0306a implements ActivityChooserModel.OnChooseActivityListener {
        C0306a() {
        }

        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.f1469h;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ShareActionProvider$b */
    private class C0307b implements MenuItem.OnMenuItemClickListener {
        C0307b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent b = ActivityChooserModel.m770d(shareActionProvider.f1467f, shareActionProvider.f1468g).mo2090b(menuItem.getItemId());
            if (b == null) {
                return true;
            }
            String action = b.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.mo2717b(b);
            }
            ShareActionProvider.this.f1467f.startActivity(b);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f1467f = context;
    }

    /* renamed from: a */
    private void m973a() {
        if (this.f1469h != null) {
            if (this.f1470i == null) {
                this.f1470i = new C0306a();
            }
            ActivityChooserModel.m770d(this.f1467f, this.f1468g).mo2098q(this.f1470i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2717b(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f1467f);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.m770d(this.f1467f, this.f1468g));
        }
        TypedValue typedValue = new TypedValue();
        this.f1467f.getTheme().resolveAttribute(C0131R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.f1467f, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(C0131R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(C0131R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel d = ActivityChooserModel.m770d(this.f1467f, this.f1468g);
        PackageManager packageManager = this.f1467f.getPackageManager();
        int f = d.mo2092f();
        int min = Math.min(f, this.f1465d);
        for (int i = 0; i < min; i++) {
            ResolveInfo e = d.mo2091e(i);
            subMenu.add(0, i, i, e.loadLabel(packageManager)).setIcon(e.loadIcon(packageManager)).setOnMenuItemClickListener(this.f1466e);
        }
        if (min < f) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f1467f.getString(C0131R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < f; i2++) {
                ResolveInfo e2 = d.mo2091e(i2);
                addSubMenu.add(0, i2, i2, e2.loadLabel(packageManager)).setIcon(e2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f1466e);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f1469h = onShareTargetSelectedListener;
        m973a();
    }

    public void setShareHistoryFileName(String str) {
        this.f1468g = str;
        m973a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                mo2717b(intent);
            }
        }
        ActivityChooserModel.m770d(this.f1467f, this.f1468g).mo2097p(intent);
    }
}
