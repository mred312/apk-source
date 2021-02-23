package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;

public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: a */
    private int f730a;

    /* renamed from: b */
    private Resources.Theme f731b;

    /* renamed from: c */
    private LayoutInflater f732c;

    /* renamed from: d */
    private Configuration f733d;

    /* renamed from: e */
    private Resources f734e;

    public ContextThemeWrapper() {
        super((Context) null);
    }

    /* renamed from: a */
    private Resources m622a() {
        if (this.f734e == null) {
            Configuration configuration = this.f733d;
            if (configuration == null) {
                this.f734e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f734e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f733d);
                this.f734e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f734e;
    }

    /* renamed from: b */
    private void m623b() {
        boolean z = this.f731b == null;
        if (z) {
            this.f731b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f731b.setTo(theme);
            }
        }
        onApplyThemeResource(this.f731b, this.f730a, z);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.f734e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f733d == null) {
            this.f733d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return m622a();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f732c == null) {
            this.f732c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f732c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f731b;
        if (theme != null) {
            return theme;
        }
        if (this.f730a == 0) {
            this.f730a = C0131R.style.Theme_AppCompat_Light;
        }
        m623b();
        return this.f731b;
    }

    public int getThemeResId() {
        return this.f730a;
    }

    /* access modifiers changed from: protected */
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public void setTheme(int i) {
        if (this.f730a != i) {
            this.f730a = i;
            m623b();
        }
    }

    public ContextThemeWrapper(Context context, @StyleRes int i) {
        super(context);
        this.f730a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f731b = theme;
    }
}
