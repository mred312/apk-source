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
import androidx.annotation.CallSuper;
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

@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: f */
    private static boolean f6446f;

    /* renamed from: g */
    private static int f6447g = C1155R.C1157id.glide_custom_view_target_tag;

    /* renamed from: b */
    private final C1348b f6448b;
    @Nullable

    /* renamed from: c */
    private View.OnAttachStateChangeListener f6449c;

    /* renamed from: d */
    private boolean f6450d;

    /* renamed from: e */
    private boolean f6451e;
    protected final T view;

    /* renamed from: com.bumptech.glide.request.target.ViewTarget$a */
    class C1347a implements View.OnAttachStateChangeListener {
        C1347a() {
        }

        public void onViewAttachedToWindow(View view) {
            ViewTarget.this.mo10206e();
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTarget.this.mo10205d();
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.request.target.ViewTarget$b */
    static final class C1348b {
        @VisibleForTesting
        @Nullable

        /* renamed from: e */
        static Integer f6453e;

        /* renamed from: a */
        private final View f6454a;

        /* renamed from: b */
        private final List<SizeReadyCallback> f6455b = new ArrayList();

        /* renamed from: c */
        boolean f6456c;
        @Nullable

        /* renamed from: d */
        private C1349a f6457d;

        /* renamed from: com.bumptech.glide.request.target.ViewTarget$b$a */
        private static final class C1349a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<C1348b> f6458a;

            C1349a(@NonNull C1348b bVar) {
                this.f6458a = new WeakReference<>(bVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C1348b bVar = (C1348b) this.f6458a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.mo10212a();
                return true;
            }
        }

        C1348b(@NonNull View view) {
            this.f6454a = view;
        }

        /* renamed from: c */
        private static int m4740c(@NonNull Context context) {
            if (f6453e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6453e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6453e.intValue();
        }

        /* renamed from: e */
        private int m4741e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f6456c && this.f6454a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f6454a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return m4740c(this.f6454a.getContext());
        }

        /* renamed from: f */
        private int m4742f() {
            int paddingTop = this.f6454a.getPaddingTop() + this.f6454a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f6454a.getLayoutParams();
            return m4741e(this.f6454a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* renamed from: g */
        private int m4743g() {
            int paddingLeft = this.f6454a.getPaddingLeft() + this.f6454a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f6454a.getLayoutParams();
            return m4741e(this.f6454a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* renamed from: h */
        private boolean m4744h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        /* renamed from: i */
        private boolean m4745i(int i, int i2) {
            return m4744h(i) && m4744h(i2);
        }

        /* renamed from: j */
        private void m4746j(int i, int i2) {
            Iterator it = new ArrayList(this.f6455b).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).onSizeReady(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10212a() {
            if (!this.f6455b.isEmpty()) {
                int g = m4743g();
                int f = m4742f();
                if (m4745i(g, f)) {
                    m4746j(g, f);
                    mo10213b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo10213b() {
            ViewTreeObserver viewTreeObserver = this.f6454a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f6457d);
            }
            this.f6457d = null;
            this.f6455b.clear();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo10214d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g = m4743g();
            int f = m4742f();
            if (m4745i(g, f)) {
                sizeReadyCallback.onSizeReady(g, f);
                return;
            }
            if (!this.f6455b.contains(sizeReadyCallback)) {
                this.f6455b.add(sizeReadyCallback);
            }
            if (this.f6457d == null) {
                ViewTreeObserver viewTreeObserver = this.f6454a.getViewTreeObserver();
                C1349a aVar = new C1349a(this);
                this.f6457d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo10215k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f6455b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(@NonNull T t) {
        this.view = (View) Preconditions.checkNotNull(t);
        this.f6448b = new C1348b(t);
    }

    @Nullable
    /* renamed from: a */
    private Object m4734a() {
        return this.view.getTag(f6447g);
    }

    /* renamed from: b */
    private void m4735b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6449c;
        if (onAttachStateChangeListener != null && !this.f6451e) {
            this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6451e = true;
        }
    }

    /* renamed from: c */
    private void m4736c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6449c;
        if (onAttachStateChangeListener != null && this.f6451e) {
            this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6451e = false;
        }
    }

    /* renamed from: f */
    private void m4737f(@Nullable Object obj) {
        f6446f = true;
        this.view.setTag(f6447g, obj);
    }

    @Deprecated
    public static void setTagId(int i) {
        if (!f6446f) {
            f6447g = i;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @NonNull
    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.f6449c != null) {
            return this;
        }
        this.f6449c = new C1347a();
        m4735b();
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10205d() {
        Request request = getRequest();
        if (request != null) {
            this.f6450d = true;
            request.clear();
            this.f6450d = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10206e() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    @Nullable
    public Request getRequest() {
        Object a = m4734a();
        if (a == null) {
            return null;
        }
        if (a instanceof Request) {
            return (Request) a;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @CallSuper
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f6448b.mo10214d(sizeReadyCallback);
    }

    @NonNull
    public T getView() {
        return this.view;
    }

    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f6448b.mo10213b();
        if (!this.f6450d) {
            m4736c();
        }
    }

    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        m4735b();
    }

    @CallSuper
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f6448b.mo10215k(sizeReadyCallback);
    }

    public void setRequest(@Nullable Request request) {
        m4737f(request);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    @NonNull
    public final ViewTarget<T, Z> waitForLayout() {
        this.f6448b.f6456c = true;
        return this;
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }
}
