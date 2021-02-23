package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

public class GlideContext extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: k */
    static final TransitionOptions<?, ?> f5439k = new GenericTransitionOptions();

    /* renamed from: a */
    private final ArrayPool f5440a;

    /* renamed from: b */
    private final Registry f5441b;

    /* renamed from: c */
    private final ImageViewTargetFactory f5442c;

    /* renamed from: d */
    private final Glide.RequestOptionsFactory f5443d;

    /* renamed from: e */
    private final List<RequestListener<Object>> f5444e;

    /* renamed from: f */
    private final Map<Class<?>, TransitionOptions<?, ?>> f5445f;

    /* renamed from: g */
    private final Engine f5446g;

    /* renamed from: h */
    private final boolean f5447h;

    /* renamed from: i */
    private final int f5448i;
    @GuardedBy("this")
    @Nullable

    /* renamed from: j */
    private RequestOptions f5449j;

    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull Glide.RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, @NonNull Engine engine, boolean z, int i) {
        super(context.getApplicationContext());
        this.f5440a = arrayPool;
        this.f5441b = registry;
        this.f5442c = imageViewTargetFactory;
        this.f5443d = requestOptionsFactory;
        this.f5444e = list;
        this.f5445f = map;
        this.f5446g = engine;
        this.f5447h = z;
        this.f5448i = i;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> buildImageViewTarget(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f5442c.buildTarget(imageView, cls);
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.f5440a;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.f5444e;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        if (this.f5449j == null) {
            this.f5449j = (RequestOptions) this.f5443d.build().lock();
        }
        return this.f5449j;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(@NonNull Class<T> cls) {
        TransitionOptions<?, T> transitionOptions = this.f5445f.get(cls);
        if (transitionOptions == null) {
            for (Map.Entry next : this.f5445f.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transitionOptions = (TransitionOptions) next.getValue();
                }
            }
        }
        return transitionOptions == null ? f5439k : transitionOptions;
    }

    @NonNull
    public Engine getEngine() {
        return this.f5446g;
    }

    public int getLogLevel() {
        return this.f5448i;
    }

    @NonNull
    public Registry getRegistry() {
        return this.f5441b;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.f5447h;
    }
}
