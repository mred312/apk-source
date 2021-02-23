package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, LifecycleListener {

    /* renamed from: k */
    private static final RequestOptions f5493k = ((RequestOptions) RequestOptions.decodeTypeOf(Bitmap.class).lock());

    /* renamed from: l */
    private static final RequestOptions f5494l = ((RequestOptions) RequestOptions.decodeTypeOf(GifDrawable.class).lock());

    /* renamed from: m */
    private static final RequestOptions f5495m = ((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW)).skipMemoryCache(true));

    /* renamed from: a */
    final Lifecycle f5496a;
    @GuardedBy("this")

    /* renamed from: b */
    private final RequestTracker f5497b;
    @GuardedBy("this")

    /* renamed from: c */
    private final RequestManagerTreeNode f5498c;
    protected final Context context;
    @GuardedBy("this")

    /* renamed from: d */
    private final TargetTracker f5499d;

    /* renamed from: e */
    private final Runnable f5500e;

    /* renamed from: f */
    private final Handler f5501f;

    /* renamed from: g */
    private final ConnectivityMonitor f5502g;
    protected final Glide glide;

    /* renamed from: h */
    private final CopyOnWriteArrayList<RequestListener<Object>> f5503h;
    @GuardedBy("this")

    /* renamed from: i */
    private RequestOptions f5504i;

    /* renamed from: j */
    private boolean f5505j;

    /* renamed from: com.bumptech.glide.RequestManager$a */
    class C1159a implements Runnable {
        C1159a() {
        }

        public void run() {
            RequestManager requestManager = RequestManager.this;
            requestManager.f5496a.addListener(requestManager);
        }
    }

    /* renamed from: com.bumptech.glide.RequestManager$b */
    private static class C1160b extends CustomViewTarget<View, Object> {
        C1160b(@NonNull View view) {
            super(view);
        }

        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        /* access modifiers changed from: protected */
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    /* renamed from: com.bumptech.glide.RequestManager$c */
    private class C1161c implements ConnectivityMonitor.ConnectivityListener {
        @GuardedBy("RequestManager.this")

        /* renamed from: a */
        private final RequestTracker f5507a;

        C1161c(@NonNull RequestTracker requestTracker) {
            this.f5507a = requestTracker;
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.f5507a.restartRequests();
                }
            }
        }
    }

    public RequestManager(@NonNull Glide glide2, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context2) {
        this(glide2, lifecycle, requestManagerTreeNode, new RequestTracker(), glide2.mo9126c(), context2);
    }

    /* renamed from: f */
    private void m4103f(@NonNull Target<?> target) {
        boolean e = mo9262e(target);
        Request request = target.getRequest();
        if (!e && !this.glide.mo9136i(target) && request != null) {
            target.setRequest((Request) null);
            request.clear();
        }
    }

    /* renamed from: g */
    private synchronized void m4104g(@NonNull RequestOptions requestOptions) {
        this.f5504i = (RequestOptions) this.f5504i.apply(requestOptions);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<RequestListener<Object>> mo9247a() {
        return this.f5503h;
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.f5503h.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        m4104g(requestOptions);
        return this;
    }

    @CheckResult
    @NonNull
    /* renamed from: as */
    public <ResourceType> RequestBuilder<ResourceType> mo9250as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Bitmap> asBitmap() {
        return mo9250as(Bitmap.class).apply((BaseRequestOptions<?>) f5493k);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> asDrawable() {
        return mo9250as(Drawable.class);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<File> asFile() {
        return mo9250as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    @CheckResult
    @NonNull
    public RequestBuilder<GifDrawable> asGif() {
        return mo9250as(GifDrawable.class).apply((BaseRequestOptions<?>) f5494l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized RequestOptions mo9255b() {
        return this.f5504i;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public <T> TransitionOptions<?, T> mo9256c(Class<T> cls) {
        return this.glide.mo9129d().getDefaultTransitionOptions(cls);
    }

    public void clear(@NonNull View view) {
        clear((Target<?>) new C1160b(view));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo9259d(@NonNull Target<?> target, @NonNull Request request) {
        this.f5499d.track(target);
        this.f5497b.runRequest(request);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<File> downloadOnly() {
        return mo9250as(File.class).apply((BaseRequestOptions<?>) f5495m);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized boolean mo9262e(@NonNull Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f5497b.clearAndRemove(request)) {
            return false;
        }
        this.f5499d.untrack(target);
        target.setRequest((Request) null);
        return true;
    }

    public synchronized boolean isPaused() {
        return this.f5497b.isPaused();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.f5499d.onDestroy();
        for (Target<?> clear : this.f5499d.getAll()) {
            clear(clear);
        }
        this.f5499d.clear();
        this.f5497b.clearRequests();
        this.f5496a.removeListener(this);
        this.f5496a.removeListener(this.f5502g);
        this.f5501f.removeCallbacks(this.f5500e);
        this.glide.mo9137k(this);
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        resumeRequests();
        this.f5499d.onStart();
    }

    public synchronized void onStop() {
        pauseRequests();
        this.f5499d.onStop();
    }

    public void onTrimMemory(int i) {
        if (i == 60 && this.f5505j) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.f5497b.pauseAllRequests();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        for (RequestManager pauseAllRequests : this.f5498c.getDescendants()) {
            pauseAllRequests.pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.f5497b.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        for (RequestManager pauseRequests : this.f5498c.getDescendants()) {
            pauseRequests.pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.f5497b.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager resumeRequests : this.f5498c.getDescendants()) {
            resumeRequests.resumeRequests();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.f5505j = z;
    }

    /* access modifiers changed from: protected */
    public synchronized void setRequestOptions(@NonNull RequestOptions requestOptions) {
        this.f5504i = (RequestOptions) ((RequestOptions) requestOptions.clone()).autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f5497b + ", treeNode=" + this.f5498c + "}";
    }

    public void clear(@Nullable Target<?> target) {
        if (target != null) {
            m4103f(target);
        }
    }

    RequestManager(Glide glide2, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context2) {
        this.f5499d = new TargetTracker();
        C1159a aVar = new C1159a();
        this.f5500e = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f5501f = handler;
        this.glide = glide2;
        this.f5496a = lifecycle;
        this.f5498c = requestManagerTreeNode;
        this.f5497b = requestTracker;
        this.context = context2;
        ConnectivityMonitor build = connectivityMonitorFactory.build(context2.getApplicationContext(), new C1161c(requestTracker));
        this.f5502g = build;
        if (Util.isOnBackgroundThread()) {
            handler.post(aVar);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.f5503h = new CopyOnWriteArrayList<>(glide2.mo9129d().getDefaultRequestListeners());
        setRequestOptions(glide2.mo9129d().getDefaultRequestOptions());
        glide2.mo9135h(this);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable Drawable drawable) {
        return asDrawable().load(drawable);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable String str) {
        return asDrawable().load(str);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable Uri uri) {
        return asDrawable().load(uri);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable File file) {
        return asDrawable().load(file);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@RawRes @DrawableRes @Nullable Integer num) {
        return asDrawable().load(num);
    }

    @CheckResult
    @Deprecated
    public RequestBuilder<Drawable> load(@Nullable URL url) {
        return asDrawable().load(url);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable byte[] bArr) {
        return asDrawable().load(bArr);
    }

    @CheckResult
    @NonNull
    public RequestBuilder<Drawable> load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }
}
