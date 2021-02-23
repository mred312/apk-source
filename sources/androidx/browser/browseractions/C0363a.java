package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.C0359R;
import androidx.core.content.res.ResourcesCompat;
import java.util.List;

/* renamed from: androidx.browser.browseractions.a */
/* compiled from: BrowserActionsFallbackMenuAdapter */
class C0363a extends BaseAdapter {

    /* renamed from: a */
    private final List<BrowserActionItem> f1784a;

    /* renamed from: b */
    private final Context f1785b;

    /* renamed from: androidx.browser.browseractions.a$a */
    /* compiled from: BrowserActionsFallbackMenuAdapter */
    static class C0364a {

        /* renamed from: a */
        ImageView f1786a;

        /* renamed from: b */
        TextView f1787b;

        C0364a() {
        }
    }

    C0363a(List<BrowserActionItem> list, Context context) {
        this.f1784a = list;
        this.f1785b = context;
    }

    public int getCount() {
        return this.f1784a.size();
    }

    public Object getItem(int i) {
        return this.f1784a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0364a aVar;
        BrowserActionItem browserActionItem = this.f1784a.get(i);
        if (view == null) {
            view = LayoutInflater.from(this.f1785b).inflate(C0359R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            aVar = new C0364a();
            aVar.f1786a = (ImageView) view.findViewById(C0359R.C0361id.browser_actions_menu_item_icon);
            aVar.f1787b = (TextView) view.findViewById(C0359R.C0361id.browser_actions_menu_item_text);
            view.setTag(aVar);
        } else {
            aVar = (C0364a) view.getTag();
        }
        aVar.f1787b.setText(browserActionItem.getTitle());
        if (browserActionItem.getIconId() != 0) {
            aVar.f1786a.setImageDrawable(ResourcesCompat.getDrawable(this.f1785b.getResources(), browserActionItem.getIconId(), (Resources.Theme) null));
        } else {
            aVar.f1786a.setImageDrawable((Drawable) null);
        }
        return view;
    }
}
