package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0131R;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.n */
/* compiled from: SuggestionsAdapter */
class C0335n extends ResourceCursorAdapter implements View.OnClickListener {

    /* renamed from: d */
    private final SearchView f1694d;

    /* renamed from: e */
    private final SearchableInfo f1695e;

    /* renamed from: f */
    private final Context f1696f;

    /* renamed from: g */
    private final WeakHashMap<String, Drawable.ConstantState> f1697g;

    /* renamed from: h */
    private final int f1698h;

    /* renamed from: i */
    private boolean f1699i = false;

    /* renamed from: j */
    private int f1700j = 1;

    /* renamed from: k */
    private ColorStateList f1701k;

    /* renamed from: l */
    private int f1702l = -1;

    /* renamed from: m */
    private int f1703m = -1;

    /* renamed from: n */
    private int f1704n = -1;

    /* renamed from: o */
    private int f1705o = -1;

    /* renamed from: p */
    private int f1706p = -1;

    /* renamed from: q */
    private int f1707q = -1;

    /* renamed from: androidx.appcompat.widget.n$a */
    /* compiled from: SuggestionsAdapter */
    private static final class C0336a {

        /* renamed from: a */
        public final TextView f1708a;

        /* renamed from: b */
        public final TextView f1709b;

        /* renamed from: c */
        public final ImageView f1710c;

        /* renamed from: d */
        public final ImageView f1711d;

        /* renamed from: e */
        public final ImageView f1712e;

        public C0336a(View view) {
            this.f1708a = (TextView) view.findViewById(16908308);
            this.f1709b = (TextView) view.findViewById(16908309);
            this.f1710c = (ImageView) view.findViewById(16908295);
            this.f1711d = (ImageView) view.findViewById(16908296);
            this.f1712e = (ImageView) view.findViewById(C0131R.C0133id.edit_query);
        }
    }

    public C0335n(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1694d = searchView;
        this.f1695e = searchableInfo;
        this.f1698h = searchView.getSuggestionCommitIconResId();
        this.f1696f = context;
        this.f1697g = weakHashMap;
    }

    /* renamed from: b */
    private Drawable m1144b(String str) {
        Drawable.ConstantState constantState = this.f1697g.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: c */
    private CharSequence m1145c(CharSequence charSequence) {
        if (this.f1701k == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0131R.attr.textColorSearchUrl, typedValue, true);
            this.f1701k = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1701k, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: d */
    private Drawable m1146d(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* renamed from: e */
    private Drawable m1147e(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1697g.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1697g.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1696f.getResources());
        }
        Drawable d = m1146d(componentName);
        if (d != null) {
            constantState = d.getConstantState();
        }
        this.f1697g.put(flattenToShortString, constantState);
        return d;
    }

    /* renamed from: f */
    public static String m1148f(Cursor cursor, String str) {
        return m1154n(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: g */
    private Drawable m1149g() {
        Drawable e = m1147e(this.f1695e.getSearchActivity());
        if (e != null) {
            return e;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m1150h(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.mo3076i(r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f1696f     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0085 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0335n.m1150h(android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: j */
    private Drawable m1151j(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1696f.getPackageName() + "/" + parseInt;
            Drawable b = m1144b(str2);
            if (b != null) {
                return b;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f1696f, parseInt);
            m1157r(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable b2 = m1144b(str);
            if (b2 != null) {
                return b2;
            }
            Drawable h = m1150h(Uri.parse(str));
            m1157r(str, h);
            return h;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    /* renamed from: k */
    private Drawable m1152k(Cursor cursor) {
        int i = this.f1705o;
        if (i == -1) {
            return null;
        }
        Drawable j = m1151j(cursor.getString(i));
        if (j != null) {
            return j;
        }
        return m1149g();
    }

    /* renamed from: l */
    private Drawable m1153l(Cursor cursor) {
        int i = this.f1706p;
        if (i == -1) {
            return null;
        }
        return m1151j(cursor.getString(i));
    }

    /* renamed from: n */
    private static String m1154n(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* renamed from: p */
    private void m1155p(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: q */
    private void m1156q(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: r */
    private void m1157r(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1697g.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: s */
    private void m1158s(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        C0336a aVar = (C0336a) view.getTag();
        int i = this.f1707q;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f1708a != null) {
            m1156q(aVar.f1708a, m1154n(cursor, this.f1702l));
        }
        if (aVar.f1709b != null) {
            String n = m1154n(cursor, this.f1704n);
            if (n != null) {
                charSequence = m1145c(n);
            } else {
                charSequence = m1154n(cursor, this.f1703m);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f1708a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1708a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1708a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1708a.setMaxLines(1);
                }
            }
            m1156q(aVar.f1709b, charSequence);
        }
        ImageView imageView = aVar.f1710c;
        if (imageView != null) {
            m1155p(imageView, m1152k(cursor), 4);
        }
        ImageView imageView2 = aVar.f1711d;
        if (imageView2 != null) {
            m1155p(imageView2, m1153l(cursor), 8);
        }
        int i3 = this.f1700j;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.f1712e.setVisibility(0);
            aVar.f1712e.setTag(aVar.f1708a.getText());
            aVar.f1712e.setOnClickListener(this);
            return;
        }
        aVar.f1712e.setVisibility(8);
    }

    public void changeCursor(Cursor cursor) {
        if (this.f1699i) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f1702l = cursor.getColumnIndex("suggest_text_1");
                this.f1703m = cursor.getColumnIndex("suggest_text_2");
                this.f1704n = cursor.getColumnIndex("suggest_text_2_url");
                this.f1705o = cursor.getColumnIndex("suggest_icon_1");
                this.f1706p = cursor.getColumnIndex("suggest_icon_2");
                this.f1707q = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        String f;
        String f2;
        if (cursor == null) {
            return null;
        }
        String f3 = m1148f(cursor, "suggest_intent_query");
        if (f3 != null) {
            return f3;
        }
        if (this.f1695e.shouldRewriteQueryFromData() && (f2 = m1148f(cursor, "suggest_intent_data")) != null) {
            return f2;
        }
        if (!this.f1695e.shouldRewriteQueryFromText() || (f = m1148f(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return f;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (newDropDownView != null) {
                ((C0336a) newDropDownView.getTag()).f1708a.setText(e.toString());
            }
            return newDropDownView;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            if (newView != null) {
                ((C0336a) newView.getTag()).f1708a.setText(e.toString());
            }
            return newView;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Drawable mo3076i(Uri uri) {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public Cursor mo3077m(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new C0336a(newView));
        ((ImageView) newView.findViewById(C0131R.C0133id.edit_query)).setImageResource(this.f1698h);
        return newView;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1158s(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1158s(getCursor());
    }

    /* renamed from: o */
    public void mo3081o(int i) {
        this.f1700j = i;
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1694d.mo2627J((CharSequence) tag);
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1694d.getVisibility() == 0 && this.f1694d.getWindowVisibility() == 0) {
            try {
                Cursor m = mo3077m(this.f1695e, charSequence2, 50);
                if (m != null) {
                    m.getCount();
                    return m;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }
}
