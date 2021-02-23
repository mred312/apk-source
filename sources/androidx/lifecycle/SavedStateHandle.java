package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class SavedStateHandle {

    /* renamed from: e */
    private static final Class[] f3516e;

    /* renamed from: a */
    final Map<String, Object> f3517a;

    /* renamed from: b */
    final Map<String, SavedStateRegistry.SavedStateProvider> f3518b;

    /* renamed from: c */
    private final Map<String, C0753b<?>> f3519c;

    /* renamed from: d */
    private final SavedStateRegistry.SavedStateProvider f3520d;

    /* renamed from: androidx.lifecycle.SavedStateHandle$a */
    class C0752a implements SavedStateRegistry.SavedStateProvider {
        C0752a() {
        }

        @NonNull
        public Bundle saveState() {
            for (Map.Entry entry : new HashMap(SavedStateHandle.this.f3518b).entrySet()) {
                SavedStateHandle.this.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
            Set<String> keySet = SavedStateHandle.this.f3517a.keySet();
            ArrayList arrayList = new ArrayList(keySet.size());
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (String next : keySet) {
                arrayList.add(next);
                arrayList2.add(SavedStateHandle.this.f3517a.get(next));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i = Build.VERSION.SDK_INT;
        clsArr[27] = i >= 21 ? Size.class : cls;
        if (i >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        f3516e = clsArr;
    }

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        this.f3518b = new HashMap();
        this.f3519c = new HashMap();
        this.f3520d = new C0752a();
        this.f3517a = new HashMap(map);
    }

    /* renamed from: a */
    static SavedStateHandle m2581a(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new SavedStateHandle();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new SavedStateHandle(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(hashMap);
    }

    @NonNull
    /* renamed from: b */
    private <T> MutableLiveData<T> m2582b(@NonNull String str, boolean z, @Nullable T t) {
        C0753b bVar;
        MutableLiveData<T> mutableLiveData = this.f3519c.get(str);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        if (this.f3517a.containsKey(str)) {
            bVar = new C0753b(this, str, this.f3517a.get(str));
        } else if (z) {
            bVar = new C0753b(this, str, t);
        } else {
            bVar = new C0753b(this, str);
        }
        this.f3519c.put(str, bVar);
        return bVar;
    }

    /* renamed from: d */
    private static void m2583d(Object obj) {
        if (obj != null) {
            Class[] clsArr = f3516e;
            int length = clsArr.length;
            int i = 0;
            while (i < length) {
                if (!clsArr[i].isInstance(obj)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public SavedStateRegistry.SavedStateProvider mo6252c() {
        return this.f3520d;
    }

    @MainThread
    public void clearSavedStateProvider(@NonNull String str) {
        this.f3518b.remove(str);
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        return this.f3517a.containsKey(str);
    }

    @MainThread
    @Nullable
    public <T> T get(@NonNull String str) {
        return this.f3517a.get(str);
    }

    @MainThread
    @NonNull
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        return m2582b(str, false, (Object) null);
    }

    @MainThread
    @NonNull
    public Set<String> keys() {
        return Collections.unmodifiableSet(this.f3517a.keySet());
    }

    @MainThread
    @Nullable
    public <T> T remove(@NonNull String str) {
        T remove = this.f3517a.remove(str);
        C0753b remove2 = this.f3519c.remove(str);
        if (remove2 != null) {
            remove2.mo6262f();
        }
        return remove;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t) {
        m2583d(t);
        MutableLiveData mutableLiveData = this.f3519c.get(str);
        if (mutableLiveData != null) {
            mutableLiveData.setValue(t);
        } else {
            this.f3517a.put(str, t);
        }
    }

    @MainThread
    public void setSavedStateProvider(@NonNull String str, @NonNull SavedStateRegistry.SavedStateProvider savedStateProvider) {
        this.f3518b.put(str, savedStateProvider);
    }

    @MainThread
    @NonNull
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t) {
        return m2582b(str, true, t);
    }

    /* renamed from: androidx.lifecycle.SavedStateHandle$b */
    static class C0753b<T> extends MutableLiveData<T> {

        /* renamed from: l */
        private String f3522l;

        /* renamed from: m */
        private SavedStateHandle f3523m;

        C0753b(SavedStateHandle savedStateHandle, String str, T t) {
            super(t);
            this.f3522l = str;
            this.f3523m = savedStateHandle;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo6262f() {
            this.f3523m = null;
        }

        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.f3523m;
            if (savedStateHandle != null) {
                savedStateHandle.f3517a.put(this.f3522l, t);
            }
            super.setValue(t);
        }

        C0753b(SavedStateHandle savedStateHandle, String str) {
            this.f3522l = str;
            this.f3523m = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.f3518b = new HashMap();
        this.f3519c = new HashMap();
        this.f3520d = new C0752a();
        this.f3517a = new HashMap();
    }
}
