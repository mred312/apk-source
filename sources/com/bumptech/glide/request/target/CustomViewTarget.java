package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.C1155R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    @IdRes

    /* renamed from: e */
    private static final int f6414e = C1155R.C1157id.glide_custom_view_target_tag;

    /* renamed from: a */
    private final C1343b f6415a;
    @Nullable

    /* renamed from: b */
    private View.OnAttachStateChangeListener f6416b;

    /* renamed from: c */
    private boolean f6417c;

    /* renamed from: d */
    private boolean f6418d;
    protected final T view;

    /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$a */
    class C1342a implements View.OnAttachStateChangeListener {
        C1342a() {
        }

        public void onViewAttachedToWindow(View view) {
            CustomViewTarget.this.mo10154e();
        }

        public void onViewDetachedFromWindow(View view) {
            CustomViewTarget.this.mo10153d();
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$b */
    static final class C1343b {
        @VisibleForTesting
        @Nullable

        /* renamed from: e */
        static Integer f6420e;

        /* renamed from: a */
        private final View f6421a;

        /* renamed from: b */
        private final List<SizeReadyCallback> f6422b = new ArrayList();

        /* renamed from: c */
        boolean f6423c;
        @Nullable

        /* renamed from: d */
        private C1344a f6424d;

        /* renamed from: com.bumptech.glide.request.target.CustomViewTarget$b$a */
        private static final class C1344a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<C1343b> f6425a;

            C1344a(@NonNull C1343b bVar) {
                this.f6425a = new WeakReference<>(bVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C1343b bVar = (C1343b) this.f6425a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.mo10162a();
                return true;
            }
        }

        C1343b(@NonNull View view) {
            this.f6421a = view;
        }

        /* renamed from: c */
        private static int m4717c(@NonNull Context context) {
            if (f6420e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6420e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6420e.intValue();
        }

        /* renamed from: e */
        private int m4718e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f6423c && this.f6421a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f6421a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m4717c(this.f6421a.getContext());
        }

        /* renamed from: f */
        private int m4719f() {
            int paddingTop = this.f6421a.getPaddingTop() + this.f6421a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f6421a.getLayoutParams();
            return m4718e(this.f6421a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: g */
        private int m4720g() {
            int paddingLeft = this.f6421a.getPaddingLeft() + this.f6421a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f6421a.getLayoutParams();
            return m4718e(this.f6421a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: h */
        private boolean m4721h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        /* renamed from: i */
        private boolean m4722i(int i, int i2) {
            return m4721h(i) && m4721h(i2);
        }

        /* renamed from: j */
        private void m4723j(int i, int i2) {
            Iterator it = new ArrayList(this.f6422b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).onSizeReady(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10162a() {
            if (!this.f6422b.isEmpty()) {
                int g = m4720g();
                int f = m4719f();
                if (m4722i(g, f)) {
                    m4723j(g, f);
                    mo10163b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo10163b() {
            ViewTreeObserver viewTreeObserver = this.f6421a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f6424d);
            }
            this.f6424d = null;
            this.f6422b.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo10164d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g = m4720g();
            int f = m4719f();
            if (m4722i(g, f)) {
                sizeReadyCallback.onSizeReady(g, f);
                return;
            }
            if (!this.f6422b.contains(sizeReadyCallback)) {
                this.f6422b.add(sizeReadyCallback);
            }
            if (this.f6424d == null) {
                ViewTreeObserver viewTreeObserver = this.f6421a.getViewTreeObserver();
                C1344a aVar = new C1344a(this);
                this.f6424d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo10165k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f6422b.remove(sizeReadyCallback);
        }
    }

    public CustomViewTarget(@NonNull T t) {
        this.view = (View) Preconditions.checkNotNull(t);
        this.f6415a = new C1343b(t);
    }

    @Nullable
    /* renamed from: a */
    private Object m4711a() {
        return this.view.getTag(f6414e);
    }

    /* renamed from: b */
    private void m4712b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6416b;
        if (onAttachStateChangeListener != null && !this.f6418d) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6418d = true;
        }
    }

    /* renamed from: c */
    private void m4713c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6416b;
        if (onAttachStateChangeListener != null && this.f6418d) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6418d = false;
        }
    }

    /* renamed from: f */
    private void m4714f(@Nullable Object obj) {
        this.view.setTag(f6414e, obj);
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.f6416b != null) {
            return this;
        }
        this.f6416b = new C1342a();
        m4712b();
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo10153d() {
        Request request = getRequest();
        if (request != null) {
            this.f6417c = true;
            request.clear();
            this.f6417c = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo10154e() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    @Nullable
    public final Request getRequest() {
        Object a = m4711a();
        if (a == null) {
            return null;
        }
        if (a instanceof Request) {
            return (Request) a;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f6415a.mo10164d(sizeReadyCallback);
    }

    @NonNull
    public final T getView() {
        return this.view;
    }

    public void onDestroy() {
    }

    public final void onLoadCleared(@Nullable Drawable drawable) {
        this.f6415a.mo10163b();
        onResourceCleared(drawable);
        if (!this.f6417c) {
            m4713c();
        }
    }

    public final void onLoadStarted(@Nullable Drawable drawable) {
        m4712b();
        onResourceLoading(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void onResourceCleared(@Nullable Drawable drawable);

    /* access modifiers changed from: protected */
    public void onResourceLoading(@Nullable Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f6415a.mo10165k(sizeReadyCallback);
    }

    public final void setRequest(@Nullable Request request) {
        m4714f(request);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(@IdRes int i) {
        return this;
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        this.f6415a.f6423c = true;
        return this;
    }
}
