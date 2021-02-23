package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: c */
    private final AsyncListDiffer<T> f4080c;

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.f4080c = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    /* access modifiers changed from: protected */
    public T getItem(int i) {
        return this.f4080c.getCurrentList().get(i);
    }

    public int getItemCount() {
        return this.f4080c.getCurrentList().size();
    }

    public void submitList(@Nullable List<T> list) {
        this.f4080c.submitList(list);
    }

    protected ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.f4080c = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), asyncDifferConfig);
    }
}
