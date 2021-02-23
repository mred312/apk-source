package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.C0359R;
import androidx.core.widget.TextViewCompat;
import java.util.List;

/* renamed from: androidx.browser.browseractions.c */
/* compiled from: BrowserActionsFallbackMenuUi */
class C0367c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private final Context f1791a;

    /* renamed from: b */
    private final Uri f1792b;

    /* renamed from: c */
    private final List<BrowserActionItem> f1793c;

    /* renamed from: d */
    C0370c f1794d;

    /* renamed from: e */
    private C0365b f1795e;

    /* renamed from: androidx.browser.browseractions.c$a */
    /* compiled from: BrowserActionsFallbackMenuUi */
    class C0368a implements DialogInterface.OnShowListener {

        /* renamed from: a */
        final /* synthetic */ View f1796a;

        C0368a(View view) {
            this.f1796a = view;
        }

        public void onShow(DialogInterface dialogInterface) {
            C0367c.this.f1794d.mo3167a(this.f1796a);
        }
    }

    /* renamed from: androidx.browser.browseractions.c$b */
    /* compiled from: BrowserActionsFallbackMenuUi */
    class C0369b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TextView f1798a;

        C0369b(C0367c cVar, TextView textView) {
            this.f1798a = textView;
        }

        public void onClick(View view) {
            if (TextViewCompat.getMaxLines(this.f1798a) == Integer.MAX_VALUE) {
                this.f1798a.setMaxLines(1);
                this.f1798a.setEllipsize(TextUtils.TruncateAt.END);
                return;
            }
            this.f1798a.setMaxLines(Integer.MAX_VALUE);
            this.f1798a.setEllipsize((TextUtils.TruncateAt) null);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    /* renamed from: androidx.browser.browseractions.c$c */
    /* compiled from: BrowserActionsFallbackMenuUi */
    interface C0370c {
        /* renamed from: a */
        void mo3167a(View view);
    }

    C0367c(Context context, Uri uri, List<BrowserActionItem> list) {
        this.f1791a = context;
        this.f1792b = uri;
        this.f1793c = list;
    }

    /* renamed from: b */
    private BrowserActionsFallbackMenuView m1201b(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(C0359R.C0361id.browser_actions_menu_view);
        TextView textView = (TextView) view.findViewById(C0359R.C0361id.browser_actions_header_text);
        textView.setText(this.f1792b.toString());
        textView.setOnClickListener(new C0369b(this, textView));
        ListView listView = (ListView) view.findViewById(C0359R.C0361id.browser_actions_menu_items);
        listView.setAdapter(new C0363a(this.f1793c, this.f1791a));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    /* renamed from: a */
    public void mo3163a() {
        View inflate = LayoutInflater.from(this.f1791a).inflate(C0359R.layout.browser_actions_context_menu_page, (ViewGroup) null);
        C0365b bVar = new C0365b(this.f1791a, m1201b(inflate));
        this.f1795e = bVar;
        bVar.setContentView(inflate);
        if (this.f1794d != null) {
            this.f1795e.setOnShowListener(new C0368a(inflate));
        }
        this.f1795e.show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            this.f1793c.get(i).getAction().send();
            this.f1795e.dismiss();
        } catch (PendingIntent.CanceledException e) {
            Log.e("BrowserActionskMenuUi", "Failed to send custom item action", e);
        }
    }
}
