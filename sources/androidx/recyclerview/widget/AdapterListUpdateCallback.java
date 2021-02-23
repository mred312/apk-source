package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull

    /* renamed from: a */
    private final RecyclerView.Adapter f3839a;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.f3839a = adapter;
    }

    public void onChanged(int i, int i2, Object obj) {
        this.f3839a.notifyItemRangeChanged(i, i2, obj);
    }

    public void onInserted(int i, int i2) {
        this.f3839a.notifyItemRangeInserted(i, i2);
    }

    public void onMoved(int i, int i2) {
        this.f3839a.notifyItemMoved(i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.f3839a.notifyItemRangeRemoved(i, i2);
    }
}
