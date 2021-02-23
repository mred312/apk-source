package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {

    /* renamed from: a */
    private boolean f293a;

    /* renamed from: b */
    private CopyOnWriteArrayList<C0121a> f294b = new CopyOnWriteArrayList<>();

    public OnBackPressedCallback(boolean z) {
        this.f293a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo672a(@NonNull C0121a aVar) {
        this.f294b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo673b(@NonNull C0121a aVar) {
        this.f294b.remove(aVar);
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.f293a;
    }

    @MainThread
    public final void remove() {
        Iterator<C0121a> it = this.f294b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.f293a = z;
    }
}
