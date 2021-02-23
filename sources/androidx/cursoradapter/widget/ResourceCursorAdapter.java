package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: a */
    private int f2833a;

    /* renamed from: b */
    private int f2834b;

    /* renamed from: c */
    private LayoutInflater f2835c;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.f2834b = i;
        this.f2833a = i;
        this.f2835c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2835c.inflate(this.f2834b, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2835c.inflate(this.f2833a, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        this.f2834b = i;
    }

    public void setViewResource(int i) {
        this.f2833a = i;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2834b = i;
        this.f2833a = i;
        this.f2835c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f2834b = i;
        this.f2833a = i;
        this.f2835c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
