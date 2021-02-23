package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {

    /* renamed from: a */
    private final GifDecoder f6215a;

    /* renamed from: b */
    private final Handler f6216b;

    /* renamed from: c */
    private final List<FrameCallback> f6217c;

    /* renamed from: d */
    final RequestManager f6218d;

    /* renamed from: e */
    private final BitmapPool f6219e;

    /* renamed from: f */
    private boolean f6220f;

    /* renamed from: g */
    private boolean f6221g;

    /* renamed from: h */
    private boolean f6222h;

    /* renamed from: i */
    private RequestBuilder<Bitmap> f6223i;

    /* renamed from: j */
    private C1324a f6224j;

    /* renamed from: k */
    private boolean f6225k;

    /* renamed from: l */
    private C1324a f6226l;

    /* renamed from: m */
    private Bitmap f6227m;

    /* renamed from: n */
    private Transformation<Bitmap> f6228n;

    /* renamed from: o */
    private C1324a f6229o;
    @Nullable

    /* renamed from: p */
    private C1326c f6230p;

    /* renamed from: q */
    private int f6231q;

    /* renamed from: r */
    private int f6232r;

    /* renamed from: s */
    private int f6233s;

    public interface FrameCallback {
        void onFrameReady();
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$a */
    static class C1324a extends CustomTarget<Bitmap> {

        /* renamed from: d */
        private final Handler f6234d;

        /* renamed from: e */
        final int f6235e;

        /* renamed from: f */
        private final long f6236f;

        /* renamed from: g */
        private Bitmap f6237g;

        C1324a(Handler handler, int i, long j) {
            this.f6234d = handler;
            this.f6235e = i;
            this.f6236f = j;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Bitmap mo9945a() {
            return this.f6237g;
        }

        public void onLoadCleared(@Nullable Drawable drawable) {
            this.f6237g = null;
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            this.f6237g = bitmap;
            this.f6234d.sendMessageAtTime(this.f6234d.obtainMessage(1, this), this.f6236f);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$b */
    private class C1325b implements Handler.Callback {
        C1325b() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.mo9940o((C1324a) message.obj);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                GifFrameLoader.this.f6218d.clear((Target<?>) (C1324a) message.obj);
                return false;
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.GifFrameLoader$c */
    interface C1326c {
        void onFrameReady();
    }

    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), gifDecoder, (Handler) null, m4594k(Glide.with(glide.getContext()), i, i2), transformation, bitmap);
    }

    /* renamed from: g */
    private static Key m4593g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    /* renamed from: k */
    private static RequestBuilder<Bitmap> m4594k(RequestManager requestManager, int i, int i2) {
        return requestManager.asBitmap().apply((BaseRequestOptions<?>) ((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(i, i2));
    }

    /* renamed from: n */
    private void m4595n() {
        if (this.f6220f && !this.f6221g) {
            if (this.f6222h) {
                Preconditions.checkArgument(this.f6229o == null, "Pending target must be null when starting from the first frame");
                this.f6215a.resetFrameIndex();
                this.f6222h = false;
            }
            C1324a aVar = this.f6229o;
            if (aVar != null) {
                this.f6229o = null;
                mo9940o(aVar);
                return;
            }
            this.f6221g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f6215a.getNextDelay());
            this.f6215a.advance();
            this.f6226l = new C1324a(this.f6216b, this.f6215a.getCurrentFrameIndex(), uptimeMillis);
            this.f6223i.apply((BaseRequestOptions<?>) RequestOptions.signatureOf(m4593g())).load((Object) this.f6215a).into(this.f6226l);
        }
    }

    /* renamed from: p */
    private void m4596p() {
        Bitmap bitmap = this.f6227m;
        if (bitmap != null) {
            this.f6219e.put(bitmap);
            this.f6227m = null;
        }
    }

    /* renamed from: s */
    private void m4597s() {
        if (!this.f6220f) {
            this.f6220f = true;
            this.f6225k = false;
            m4595n();
        }
    }

    /* renamed from: t */
    private void m4598t() {
        this.f6220f = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9929a() {
        this.f6217c.clear();
        m4596p();
        m4598t();
        C1324a aVar = this.f6224j;
        if (aVar != null) {
            this.f6218d.clear((Target<?>) aVar);
            this.f6224j = null;
        }
        C1324a aVar2 = this.f6226l;
        if (aVar2 != null) {
            this.f6218d.clear((Target<?>) aVar2);
            this.f6226l = null;
        }
        C1324a aVar3 = this.f6229o;
        if (aVar3 != null) {
            this.f6218d.clear((Target<?>) aVar3);
            this.f6229o = null;
        }
        this.f6215a.clear();
        this.f6225k = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ByteBuffer mo9930b() {
        return this.f6215a.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Bitmap mo9931c() {
        C1324a aVar = this.f6224j;
        return aVar != null ? aVar.mo9945a() : this.f6227m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo9932d() {
        C1324a aVar = this.f6224j;
        if (aVar != null) {
            return aVar.f6235e;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Bitmap mo9933e() {
        return this.f6227m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo9934f() {
        return this.f6215a.getFrameCount();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Transformation<Bitmap> mo9935h() {
        return this.f6228n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo9936i() {
        return this.f6233s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo9937j() {
        return this.f6215a.getTotalIterationCount();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo9938l() {
        return this.f6215a.getByteSize() + this.f6231q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo9939m() {
        return this.f6232r;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: o */
    public void mo9940o(C1324a aVar) {
        C1326c cVar = this.f6230p;
        if (cVar != null) {
            cVar.onFrameReady();
        }
        this.f6221g = false;
        if (this.f6225k) {
            this.f6216b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f6220f) {
            this.f6229o = aVar;
        } else {
            if (aVar.mo9945a() != null) {
                m4596p();
                C1324a aVar2 = this.f6224j;
                this.f6224j = aVar;
                for (int size = this.f6217c.size() - 1; size >= 0; size--) {
                    this.f6217c.get(size).onFrameReady();
                }
                if (aVar2 != null) {
                    this.f6216b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m4595n();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9941q(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.checkNotNull(r3)
            com.bumptech.glide.load.Transformation r0 = (com.bumptech.glide.load.Transformation) r0
            r2.f6228n = r0
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.checkNotNull(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.f6227m = r0
            com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> r0 = r2.f6223i
            com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
            r1.<init>()
            com.bumptech.glide.request.BaseRequestOptions r3 = r1.transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) r3)
            com.bumptech.glide.RequestBuilder r3 = r0.apply((com.bumptech.glide.request.BaseRequestOptions<?>) r3)
            r2.f6223i = r3
            int r3 = com.bumptech.glide.util.Util.getBitmapByteSize(r4)
            r2.f6231q = r3
            int r3 = r4.getWidth()
            r2.f6232r = r3
            int r3 = r4.getHeight()
            r2.f6233s = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifFrameLoader.mo9941q(com.bumptech.glide.load.Transformation, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo9942r() {
        Preconditions.checkArgument(!this.f6220f, "Can't restart a running animation");
        this.f6222h = true;
        C1324a aVar = this.f6229o;
        if (aVar != null) {
            this.f6218d.clear((Target<?>) aVar);
            this.f6229o = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo9943u(FrameCallback frameCallback) {
        if (this.f6225k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f6217c.contains(frameCallback)) {
            boolean isEmpty = this.f6217c.isEmpty();
            this.f6217c.add(frameCallback);
            if (isEmpty) {
                m4597s();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo9944v(FrameCallback frameCallback) {
        this.f6217c.remove(frameCallback);
        if (this.f6217c.isEmpty()) {
            m4598t();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f6217c = new ArrayList();
        this.f6218d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new C1325b()) : handler;
        this.f6219e = bitmapPool;
        this.f6216b = handler;
        this.f6223i = requestBuilder;
        this.f6215a = gifDecoder;
        mo9941q(transformation, bitmap);
    }
}
