package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {

    /* renamed from: a */
    final RecyclerView.Adapter f4303a;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.f4303a = adapter;
    }

    public void onChanged(int i, int i2) {
        this.f4303a.notifyItemRangeChanged(i, i2);
    }

    public void onInserted(int i, int i2) {
        this.f4303a.notifyItemRangeInserted(i, i2);
    }

    public void onMoved(int i, int i2) {
        this.f4303a.notifyItemMoved(i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.f4303a.notifyItemRangeRemoved(i, i2);
    }

    public void onChanged(int i, int i2, Object obj) {
        this.f4303a.notifyItemRangeChanged(i, i2, obj);
    }
}
