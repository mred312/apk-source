package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {

    /* renamed from: c */
    static boolean f3564c = false;
    @NonNull

    /* renamed from: a */
    private final LifecycleOwner f3565a;
    @NonNull

    /* renamed from: b */
    private final C0779b f3566b;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: l */
        private final int f3567l;
        @Nullable

        /* renamed from: m */
        private final Bundle f3568m;
        @NonNull

        /* renamed from: n */
        private final Loader<D> f3569n;

        /* renamed from: o */
        private LifecycleOwner f3570o;

        /* renamed from: p */
        private C0778a<D> f3571p;

        /* renamed from: q */
        private Loader<D> f3572q;

        LoaderInfo(int i, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.f3567l = i;
            this.f3568m = bundle;
            this.f3569n = loader;
            this.f3572q = loader2;
            loader.registerListener(i, this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3567l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3568m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3569n);
            Loader<D> loader = this.f3569n;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f3571p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f3571p);
                C0778a<D> aVar = this.f3571p;
                aVar.mo6313a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(mo6307g().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        /* access modifiers changed from: package-private */
        @MainThread
        /* renamed from: f */
        public Loader<D> mo6306f(boolean z) {
            if (LoaderManagerImpl.f3564c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3569n.cancelLoad();
            this.f3569n.abandon();
            C0778a<D> aVar = this.f3571p;
            if (aVar != null) {
                removeObserver(aVar);
                if (z) {
                    aVar.mo6315c();
                }
            }
            this.f3569n.unregisterListener(this);
            if ((aVar == null || aVar.mo6314b()) && !z) {
                return this.f3569n;
            }
            this.f3569n.reset();
            return this.f3572q;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: g */
        public Loader<D> mo6307g() {
            return this.f3569n;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public boolean mo6308h() {
            C0778a<D> aVar;
            if (hasActiveObservers() && (aVar = this.f3571p) != null && !aVar.mo6314b()) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo6309i() {
            LifecycleOwner lifecycleOwner = this.f3570o;
            C0778a<D> aVar = this.f3571p;
            if (lifecycleOwner != null && aVar != null) {
                super.removeObserver(aVar);
                observe(lifecycleOwner, aVar);
            }
        }

        /* access modifiers changed from: package-private */
        @MainThread
        @NonNull
        /* renamed from: j */
        public Loader<D> mo6310j(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            C0778a<D> aVar = new C0778a<>(this.f3569n, loaderCallbacks);
            observe(lifecycleOwner, aVar);
            C0778a<D> aVar2 = this.f3571p;
            if (aVar2 != null) {
                removeObserver(aVar2);
            }
            this.f3570o = lifecycleOwner;
            this.f3571p = aVar;
            return this.f3569n;
        }

        /* access modifiers changed from: protected */
        public void onActive() {
            if (LoaderManagerImpl.f3564c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f3569n.startLoading();
        }

        /* access modifiers changed from: protected */
        public void onInactive() {
            if (LoaderManagerImpl.f3564c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3569n.stopLoading();
        }

        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
            if (LoaderManagerImpl.f3564c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            if (LoaderManagerImpl.f3564c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d);
        }

        public void removeObserver(@NonNull Observer<? super D> observer) {
            super.removeObserver(observer);
            this.f3570o = null;
            this.f3571p = null;
        }

        public void setValue(D d) {
            super.setValue(d);
            Loader<D> loader = this.f3572q;
            if (loader != null) {
                loader.reset();
                this.f3572q = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3567l);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.f3569n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.loader.app.LoaderManagerImpl$a */
    static class C0778a<D> implements Observer<D> {
        @NonNull

        /* renamed from: a */
        private final Loader<D> f3573a;
        @NonNull

        /* renamed from: b */
        private final LoaderManager.LoaderCallbacks<D> f3574b;

        /* renamed from: c */
        private boolean f3575c = false;

        C0778a(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f3573a = loader;
            this.f3574b = loaderCallbacks;
        }

        /* renamed from: a */
        public void mo6313a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3575c);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo6314b() {
            return this.f3575c;
        }

        /* access modifiers changed from: package-private */
        @MainThread
        /* renamed from: c */
        public void mo6315c() {
            if (this.f3575c) {
                if (LoaderManagerImpl.f3564c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f3573a);
                }
                this.f3574b.onLoaderReset(this.f3573a);
            }
        }

        public void onChanged(@Nullable D d) {
            if (LoaderManagerImpl.f3564c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f3573a + ": " + this.f3573a.dataToString(d));
            }
            this.f3574b.onLoadFinished(this.f3573a, d);
            this.f3575c = true;
        }

        public String toString() {
            return this.f3574b.toString();
        }
    }

    /* renamed from: androidx.loader.app.LoaderManagerImpl$b */
    static class C0779b extends ViewModel {

        /* renamed from: e */
        private static final ViewModelProvider.Factory f3576e = new C0780a();

        /* renamed from: c */
        private SparseArrayCompat<LoaderInfo> f3577c = new SparseArrayCompat<>();

        /* renamed from: d */
        private boolean f3578d = false;

        /* renamed from: androidx.loader.app.LoaderManagerImpl$b$a */
        static class C0780a implements ViewModelProvider.Factory {
            C0780a() {
            }

            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                return new C0779b();
            }
        }

        C0779b() {
        }

        @NonNull
        /* renamed from: g */
        static C0779b m2627g(ViewModelStore viewModelStore) {
            return (C0779b) new ViewModelProvider(viewModelStore, f3576e).get(C0779b.class);
        }

        /* renamed from: e */
        public void mo6317e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3577c.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f3577c.size(); i++) {
                    LoaderInfo valueAt = this.f3577c.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3577c.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo6318f() {
            this.f3578d = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public <D> LoaderInfo<D> mo6319h(int i) {
            return this.f3577c.get(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public boolean mo6320i() {
            int size = this.f3577c.size();
            for (int i = 0; i < size; i++) {
                if (this.f3577c.valueAt(i).mo6308h()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public boolean mo6321j() {
            return this.f3578d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo6322k() {
            int size = this.f3577c.size();
            for (int i = 0; i < size; i++) {
                this.f3577c.valueAt(i).mo6309i();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public void mo6323l(int i, @NonNull LoaderInfo loaderInfo) {
            this.f3577c.put(i, loaderInfo);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public void mo6324m(int i) {
            this.f3577c.remove(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public void mo6325n() {
            this.f3578d = true;
        }

        /* access modifiers changed from: protected */
        public void onCleared() {
            super.onCleared();
            int size = this.f3577c.size();
            for (int i = 0; i < size; i++) {
                this.f3577c.valueAt(i).mo6306f(true);
            }
            this.f3577c.clear();
        }
    }

    LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.f3565a = lifecycleOwner;
        this.f3566b = C0779b.m2627g(viewModelStore);
    }

    /* JADX INFO: finally extract failed */
    @MainThread
    @NonNull
    /* renamed from: a */
    private <D> Loader<D> m2618a(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.f3566b.mo6325n();
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader, loader);
                if (f3564c) {
                    Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                }
                this.f3566b.mo6323l(i, loaderInfo);
                this.f3566b.mo6318f();
                return loaderInfo.mo6310j(this.f3565a, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f3566b.mo6318f();
            throw th;
        }
    }

    @MainThread
    public void destroyLoader(int i) {
        if (this.f3566b.mo6321j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3564c) {
                Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
            }
            LoaderInfo h = this.f3566b.mo6319h(i);
            if (h != null) {
                h.mo6306f(true);
                this.f3566b.mo6324m(i);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3566b.mo6317e(str, fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public <D> Loader<D> getLoader(int i) {
        if (!this.f3566b.mo6321j()) {
            LoaderInfo h = this.f3566b.mo6319h(i);
            if (h != null) {
                return h.mo6307g();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public boolean hasRunningLoaders() {
        return this.f3566b.mo6320i();
    }

    @MainThread
    @NonNull
    public <D> Loader<D> initLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3566b.mo6321j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo h = this.f3566b.mo6319h(i);
            if (f3564c) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (h == null) {
                return m2618a(i, bundle, loaderCallbacks, (Loader) null);
            }
            if (f3564c) {
                Log.v("LoaderManager", "  Re-using existing loader " + h);
            }
            return h.mo6310j(this.f3565a, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void markForRedelivery() {
        this.f3566b.mo6322k();
    }

    @MainThread
    @NonNull
    public <D> Loader<D> restartLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f3566b.mo6321j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f3564c) {
                Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
            }
            LoaderInfo h = this.f3566b.mo6319h(i);
            Loader loader = null;
            if (h != null) {
                loader = h.mo6306f(false);
            }
            return m2618a(i, bundle, loaderCallbacks, loader);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.f3565a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
