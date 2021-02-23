package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a */
    private final Pools.Pool<ArrayList<T>> f1946a = new Pools.SimplePool(10);

    /* renamed from: b */
    private final SimpleArrayMap<T, ArrayList<T>> f1947b = new SimpleArrayMap<>();

    /* renamed from: c */
    private final ArrayList<T> f1948c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f1949d = new HashSet<>();

    /* renamed from: a */
    private void m1325a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f1947b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        m1325a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @NonNull
    /* renamed from: b */
    private ArrayList<T> m1326b() {
        ArrayList<T> acquire = this.f1946a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    /* renamed from: c */
    private void m1327c(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1946a.release(arrayList);
    }

    public void addEdge(@NonNull T t, @NonNull T t2) {
        if (!this.f1947b.containsKey(t) || !this.f1947b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f1947b.get(t);
        if (arrayList == null) {
            arrayList = m1326b();
            this.f1947b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void addNode(@NonNull T t) {
        if (!this.f1947b.containsKey(t)) {
            this.f1947b.put(t, null);
        }
    }

    public void clear() {
        int size = this.f1947b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f1947b.valueAt(i);
            if (valueAt != null) {
                m1327c(valueAt);
            }
        }
        this.f1947b.clear();
    }

    public boolean contains(@NonNull T t) {
        return this.f1947b.containsKey(t);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t) {
        return this.f1947b.get(t);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t) {
        int size = this.f1947b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f1947b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1947b.keyAt(i));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.f1948c.clear();
        this.f1949d.clear();
        int size = this.f1947b.size();
        for (int i = 0; i < size; i++) {
            m1325a(this.f1947b.keyAt(i), this.f1948c, this.f1949d);
        }
        return this.f1948c;
    }

    public boolean hasOutgoingEdges(@NonNull T t) {
        int size = this.f1947b.size();
        for (int i = 0; i < size; i++) {
            ArrayList valueAt = this.f1947b.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
