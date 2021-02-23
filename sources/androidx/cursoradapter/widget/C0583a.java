package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: androidx.cursoradapter.widget.a */
/* compiled from: CursorFilter */
class C0583a extends Filter {

    /* renamed from: a */
    C0584a f2840a;

    /* renamed from: androidx.cursoradapter.widget.a$a */
    /* compiled from: CursorFilter */
    interface C0584a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    C0583a(C0584a aVar) {
        this.f2840a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f2840a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f2840a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f2840a.getCursor();
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            this.f2840a.changeCursor((Cursor) obj);
        }
    }
}
