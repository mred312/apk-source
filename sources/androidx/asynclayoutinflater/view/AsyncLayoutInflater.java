package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {

    /* renamed from: a */
    LayoutInflater f1757a;

    /* renamed from: b */
    Handler f1758b;

    /* renamed from: c */
    C0358d f1759c;

    /* renamed from: d */
    private Handler.Callback f1760d = new C0355a();

    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view, @LayoutRes int i, @Nullable ViewGroup viewGroup);
    }

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$a */
    class C0355a implements Handler.Callback {
        C0355a() {
        }

        public boolean handleMessage(Message message) {
            C0357c cVar = (C0357c) message.obj;
            if (cVar.f1766d == null) {
                cVar.f1766d = AsyncLayoutInflater.this.f1757a.inflate(cVar.f1765c, cVar.f1764b, false);
            }
            cVar.f1767e.onInflateFinished(cVar.f1766d, cVar.f1765c, cVar.f1764b);
            AsyncLayoutInflater.this.f1759c.mo3141d(cVar);
            return true;
        }
    }

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$b */
    private static class C0356b extends LayoutInflater {

        /* renamed from: a */
        private static final String[] f1762a = {"android.widget.", "android.webkit.", "android.app."};

        C0356b(Context context) {
            super(context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new C0356b(context);
        }

        /* access modifiers changed from: protected */
        public View onCreateView(String str, AttributeSet attributeSet) {
            String[] strArr = f1762a;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    View createView = createView(str, strArr[i], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$c */
    private static class C0357c {

        /* renamed from: a */
        AsyncLayoutInflater f1763a;

        /* renamed from: b */
        ViewGroup f1764b;

        /* renamed from: c */
        int f1765c;

        /* renamed from: d */
        View f1766d;

        /* renamed from: e */
        OnInflateFinishedListener f1767e;

        C0357c() {
        }
    }

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$d */
    private static class C0358d extends Thread {

        /* renamed from: c */
        private static final C0358d f1768c;

        /* renamed from: a */
        private ArrayBlockingQueue<C0357c> f1769a = new ArrayBlockingQueue<>(10);

        /* renamed from: b */
        private Pools.SynchronizedPool<C0357c> f1770b = new Pools.SynchronizedPool<>(10);

        static {
            C0358d dVar = new C0358d();
            f1768c = dVar;
            dVar.start();
        }

        private C0358d() {
        }

        /* renamed from: b */
        public static C0358d m1188b() {
            return f1768c;
        }

        /* renamed from: a */
        public void mo3139a(C0357c cVar) {
            try {
                this.f1769a.put(cVar);
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        /* renamed from: c */
        public C0357c mo3140c() {
            C0357c acquire = this.f1770b.acquire();
            return acquire == null ? new C0357c() : acquire;
        }

        /* renamed from: d */
        public void mo3141d(C0357c cVar) {
            cVar.f1767e = null;
            cVar.f1763a = null;
            cVar.f1764b = null;
            cVar.f1765c = 0;
            cVar.f1766d = null;
            this.f1770b.release(cVar);
        }

        /* renamed from: e */
        public void mo3142e() {
            try {
                C0357c take = this.f1769a.take();
                try {
                    take.f1766d = take.f1763a.f1757a.inflate(take.f1765c, take.f1764b, false);
                } catch (RuntimeException e) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                Message.obtain(take.f1763a.f1758b, 0, take).sendToTarget();
            } catch (InterruptedException e2) {
                Log.w("AsyncLayoutInflater", e2);
            }
        }

        public void run() {
            while (true) {
                mo3142e();
            }
        }
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.f1757a = new C0356b(context);
        this.f1758b = new Handler(this.f1760d);
        this.f1759c = C0358d.m1188b();
    }

    @UiThread
    public void inflate(@LayoutRes int i, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            C0357c c = this.f1759c.mo3140c();
            c.f1763a = this;
            c.f1765c = i;
            c.f1764b = viewGroup;
            c.f1767e = onInflateFinishedListener;
            this.f1759c.mo3139a(c);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
