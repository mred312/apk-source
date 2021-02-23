package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {

    /* renamed from: g */
    private static final Executor f3848g = new C0874b();

    /* renamed from: a */
    private final ListUpdateCallback f3849a;

    /* renamed from: b */
    final AsyncDifferConfig<T> f3850b;

    /* renamed from: c */
    final Executor f3851c;
    @Nullable

    /* renamed from: d */
    private List<T> f3852d;
    @NonNull

    /* renamed from: e */
    private List<T> f3853e;

    /* renamed from: f */
    int f3854f;

    /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$a */
    class C0871a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f3855a;

        /* renamed from: b */
        final /* synthetic */ List f3856b;

        /* renamed from: c */
        final /* synthetic */ int f3857c;

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$a$a */
        class C0872a extends DiffUtil.Callback {
            C0872a() {
            }

            public boolean areContentsTheSame(int i, int i2) {
                Object obj = C0871a.this.f3855a.get(i);
                Object obj2 = C0871a.this.f3856b.get(i2);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.f3850b.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            public boolean areItemsTheSame(int i, int i2) {
                Object obj = C0871a.this.f3855a.get(i);
                Object obj2 = C0871a.this.f3856b.get(i2);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return AsyncListDiffer.this.f3850b.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            @Nullable
            public Object getChangePayload(int i, int i2) {
                Object obj = C0871a.this.f3855a.get(i);
                Object obj2 = C0871a.this.f3856b.get(i2);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.f3850b.getDiffCallback().getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }

            public int getNewListSize() {
                return C0871a.this.f3856b.size();
            }

            public int getOldListSize() {
                return C0871a.this.f3855a.size();
            }
        }

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$a$b */
        class C0873b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ DiffUtil.DiffResult f3860a;

            C0873b(DiffUtil.DiffResult diffResult) {
                this.f3860a = diffResult;
            }

            public void run() {
                C0871a aVar = C0871a.this;
                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                if (asyncListDiffer.f3854f == aVar.f3857c) {
                    asyncListDiffer.mo6629a(aVar.f3856b, this.f3860a);
                }
            }
        }

        C0871a(List list, List list2, int i) {
            this.f3855a = list;
            this.f3856b = list2;
            this.f3857c = i;
        }

        public void run() {
            AsyncListDiffer.this.f3851c.execute(new C0873b(DiffUtil.calculateDiff(new C0872a())));
        }
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$b */
    private static class C0874b implements Executor {

        /* renamed from: a */
        final Handler f3862a = new Handler(Looper.getMainLooper());

        C0874b() {
        }

        public void execute(@NonNull Runnable runnable) {
            this.f3862a.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this((ListUpdateCallback) new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6629a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.f3852d = list;
        this.f3853e = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f3849a);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.f3853e;
    }

    public void submitList(@Nullable List<T> list) {
        int i = this.f3854f + 1;
        this.f3854f = i;
        List<T> list2 = this.f3852d;
        if (list != list2) {
            if (list == null) {
                int size = list2.size();
                this.f3852d = null;
                this.f3853e = Collections.emptyList();
                this.f3849a.onRemoved(0, size);
            } else if (list2 == null) {
                this.f3852d = list;
                this.f3853e = Collections.unmodifiableList(list);
                this.f3849a.onInserted(0, list.size());
            } else {
                this.f3850b.getBackgroundThreadExecutor().execute(new C0871a(list2, list, i));
            }
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.f3853e = Collections.emptyList();
        this.f3849a = listUpdateCallback;
        this.f3850b = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.f3851c = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.f3851c = f3848g;
        }
    }
}
