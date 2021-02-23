package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

/* renamed from: androidx.appcompat.app.b */
/* compiled from: NavItemSelectedListener */
class C0181b implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    private final ActionBar.OnNavigationListener f603a;

    public C0181b(ActionBar.OnNavigationListener onNavigationListener) {
        this.f603a = onNavigationListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ActionBar.OnNavigationListener onNavigationListener = this.f603a;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
