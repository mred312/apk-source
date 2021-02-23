package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {

        /* renamed from: a */
        private final Context f1521a;

        /* renamed from: b */
        private final LayoutInflater f1522b;

        /* renamed from: c */
        private LayoutInflater f1523c;

        public Helper(@NonNull Context context) {
            this.f1521a = context;
            this.f1522b = LayoutInflater.from(context);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.f1523c;
            return layoutInflater != null ? layoutInflater : this.f1522b;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.f1523c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            if (theme == null) {
                this.f1523c = null;
            } else if (theme == this.f1521a.getTheme()) {
                this.f1523c = this.f1522b;
            } else {
                this.f1523c = LayoutInflater.from(new ContextThemeWrapper(this.f1521a, theme));
            }
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);
}
