package androidx.activity;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
    @Nullable

    /* renamed from: a */
    private final Runnable f295a;

    /* renamed from: b */
    final ArrayDeque<OnBackPressedCallback> f296b;

    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, C0121a {

        /* renamed from: a */
        private final Lifecycle f297a;

        /* renamed from: b */
        private final OnBackPressedCallback f298b;
        @Nullable

        /* renamed from: c */
        private C0121a f299c;

        LifecycleOnBackPressedCancellable(@NonNull Lifecycle lifecycle, @NonNull OnBackPressedCallback onBackPressedCallback) {
            this.f297a = lifecycle;
            this.f298b = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        public void cancel() {
            this.f297a.removeObserver(this);
            this.f298b.mo673b(this);
            C0121a aVar = this.f299c;
            if (aVar != null) {
                aVar.cancel();
                this.f299c = null;
            }
        }

        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f299c = OnBackPressedDispatcher.this.mo678a(this.f298b);
            } else if (event == Lifecycle.Event.ON_STOP) {
                C0121a aVar = this.f299c;
                if (aVar != null) {
                    aVar.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$a */
    private class C0117a implements C0121a {

        /* renamed from: a */
        private final OnBackPressedCallback f301a;

        C0117a(OnBackPressedCallback onBackPressedCallback) {
            this.f301a = onBackPressedCallback;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f296b.remove(this.f301a);
            this.f301a.mo673b(this);
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    /* access modifiers changed from: package-private */
    @MainThread
    @NonNull
    /* renamed from: a */
    public C0121a mo678a(@NonNull OnBackPressedCallback onBackPressedCallback) {
        this.f296b.add(onBackPressedCallback);
        C0117a aVar = new C0117a(onBackPressedCallback);
        onBackPressedCallback.mo672a(aVar);
        return aVar;
    }

    @MainThread
    public void addCallback(@NonNull OnBackPressedCallback onBackPressedCallback) {
        mo678a(onBackPressedCallback);
    }

    @MainThread
    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f296b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    public void onBackPressed() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f296b.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.f295a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this.f296b = new ArrayDeque<>();
        this.f295a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.mo672a(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
        }
    }
}
