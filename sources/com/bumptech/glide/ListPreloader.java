package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private final int f5450a;

    /* renamed from: b */
    private final C1154b f5451b;

    /* renamed from: c */
    private final RequestManager f5452c;

    /* renamed from: d */
    private final PreloadModelProvider<T> f5453d;

    /* renamed from: e */
    private final PreloadSizeProvider<T> f5454e;

    /* renamed from: f */
    private int f5455f;

    /* renamed from: g */
    private int f5456g;

    /* renamed from: h */
    private int f5457h = -1;

    /* renamed from: i */
    private int f5458i;

    /* renamed from: j */
    private boolean f5459j = true;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t, int i, int i2);
    }

    /* renamed from: com.bumptech.glide.ListPreloader$a */
    private static final class C1153a implements Target<Object> {

        /* renamed from: a */
        int f5460a;

        /* renamed from: b */
        int f5461b;
        @Nullable

        /* renamed from: c */
        private Request f5462c;

        C1153a() {
        }

        @Nullable
        public Request getRequest() {
            return this.f5462c;
        }

        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.f5461b, this.f5460a);
        }

        public void onDestroy() {
        }

        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        public void setRequest(@Nullable Request request) {
            this.f5462c = request;
        }
    }

    /* renamed from: com.bumptech.glide.ListPreloader$b */
    private static final class C1154b {

        /* renamed from: a */
        final Queue<C1153a> f5463a;

        C1154b(int i) {
            this.f5463a = Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f5463a.offer(new C1153a());
            }
        }

        /* renamed from: a */
        public C1153a mo9191a(int i, int i2) {
            C1153a poll = this.f5463a.poll();
            this.f5463a.offer(poll);
            poll.f5461b = i;
            poll.f5460a = i2;
            return poll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.f5452c = requestManager;
        this.f5453d = preloadModelProvider;
        this.f5454e = preloadSizeProvider;
        this.f5450a = i;
        this.f5451b = new C1154b(i + 1);
    }

    /* renamed from: a */
    private void m4086a() {
        for (int i = 0; i < this.f5451b.f5463a.size(); i++) {
            this.f5452c.clear((Target<?>) this.f5451b.mo9191a(0, 0));
        }
    }

    /* renamed from: b */
    private void m4087b(int i, int i2) {
        int i3;
        int i4;
        if (i < i2) {
            i3 = Math.max(this.f5455f, i);
            i4 = i2;
        } else {
            i4 = Math.min(this.f5456g, i);
            i3 = i2;
        }
        int min = Math.min(this.f5458i, i4);
        int min2 = Math.min(this.f5458i, Math.max(0, i3));
        if (i < i2) {
            for (int i5 = min2; i5 < min; i5++) {
                m4089d(this.f5453d.getPreloadItems(i5), i5, true);
            }
        } else {
            for (int i6 = min - 1; i6 >= min2; i6--) {
                m4089d(this.f5453d.getPreloadItems(i6), i6, false);
            }
        }
        this.f5456g = min2;
        this.f5455f = min;
    }

    /* renamed from: c */
    private void m4088c(int i, boolean z) {
        if (this.f5459j != z) {
            this.f5459j = z;
            m4086a();
        }
        m4087b(i, (z ? this.f5450a : -this.f5450a) + i);
    }

    /* renamed from: d */
    private void m4089d(List<T> list, int i, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                m4090e(list.get(i2), i, i2);
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            m4090e(list.get(i3), i, i3);
        }
    }

    /* renamed from: e */
    private void m4090e(@Nullable T t, int i, int i2) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t != null && (preloadSize = this.f5454e.getPreloadSize(t, i, i2)) != null && (preloadRequestBuilder = this.f5453d.getPreloadRequestBuilder(t)) != null) {
            preloadRequestBuilder.into(this.f5451b.mo9191a(preloadSize[0], preloadSize[1]));
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f5458i = i3;
        int i4 = this.f5457h;
        if (i > i4) {
            m4088c(i2 + i, true);
        } else if (i < i4) {
            m4088c(i, false);
        }
        this.f5457h = i;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
