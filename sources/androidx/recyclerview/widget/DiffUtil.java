package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {

    /* renamed from: a */
    private static final Comparator<C0890d> f3945a = new C0887a();

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        public static final int NO_POSITION = -1;

        /* renamed from: a */
        private final List<C0890d> f3946a;

        /* renamed from: b */
        private final int[] f3947b;

        /* renamed from: c */
        private final int[] f3948c;

        /* renamed from: d */
        private final Callback f3949d;

        /* renamed from: e */
        private final int f3950e;

        /* renamed from: f */
        private final int f3951f;

        /* renamed from: g */
        private final boolean f3952g;

        DiffResult(Callback callback, List<C0890d> list, int[] iArr, int[] iArr2, boolean z) {
            this.f3946a = list;
            this.f3947b = iArr;
            this.f3948c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f3949d = callback;
            this.f3950e = callback.getOldListSize();
            this.f3951f = callback.getNewListSize();
            this.f3952g = z;
            m2870a();
            m2875f();
        }

        /* renamed from: a */
        private void m2870a() {
            C0890d dVar = this.f3946a.isEmpty() ? null : this.f3946a.get(0);
            if (dVar == null || dVar.f3960a != 0 || dVar.f3961b != 0) {
                C0890d dVar2 = new C0890d();
                dVar2.f3960a = 0;
                dVar2.f3961b = 0;
                dVar2.f3963d = false;
                dVar2.f3962c = 0;
                dVar2.f3964e = false;
                this.f3946a.add(0, dVar2);
            }
        }

        /* renamed from: b */
        private void m2871b(List<C0888b> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f3952g) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int[] iArr = this.f3948c;
                int i5 = i3 + i4;
                int i6 = iArr[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.onInserted(i, 1);
                    for (C0888b bVar : list) {
                        bVar.f3954b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = iArr[i5] >> 5;
                    listUpdateCallback.onMoved(m2877h(list, i7, true).f3954b, i);
                    if (i6 == 4) {
                        listUpdateCallback.onChanged(i, 1, this.f3949d.getChangePayload(i7, i5));
                    }
                } else if (i6 == 16) {
                    list.add(new C0888b(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString((long) i6));
                }
            }
        }

        /* renamed from: c */
        private void m2872c(List<C0888b> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.f3952g) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int[] iArr = this.f3947b;
                int i5 = i3 + i4;
                int i6 = iArr[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.onRemoved(i + i4, 1);
                    for (C0888b bVar : list) {
                        bVar.f3954b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = iArr[i5] >> 5;
                    C0888b h = m2877h(list, i7, false);
                    listUpdateCallback.onMoved(i + i4, h.f3954b - 1);
                    if (i6 == 4) {
                        listUpdateCallback.onChanged(h.f3954b - 1, 1, this.f3949d.getChangePayload(i5, i7));
                    }
                } else if (i6 == 16) {
                    list.add(new C0888b(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString((long) i6));
                }
            }
        }

        /* renamed from: d */
        private void m2873d(int i, int i2, int i3) {
            if (this.f3947b[i - 1] == 0) {
                m2874e(i, i2, i3, false);
            }
        }

        /* renamed from: e */
        private boolean m2874e(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i5 = i - 1;
                i4 = i5;
            }
            while (i3 >= 0) {
                C0890d dVar = this.f3946a.get(i3);
                int i6 = dVar.f3960a;
                int i7 = dVar.f3962c;
                int i8 = i6 + i7;
                int i9 = dVar.f3961b + i7;
                int i10 = 8;
                if (z) {
                    for (int i11 = i4 - 1; i11 >= i8; i11--) {
                        if (this.f3949d.areItemsTheSame(i11, i5)) {
                            if (!this.f3949d.areContentsTheSame(i11, i5)) {
                                i10 = 4;
                            }
                            this.f3948c[i5] = (i11 << 5) | 16;
                            this.f3947b[i11] = (i5 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.f3949d.areItemsTheSame(i5, i12)) {
                            if (!this.f3949d.areContentsTheSame(i5, i12)) {
                                i10 = 4;
                            }
                            int i13 = i - 1;
                            this.f3947b[i13] = (i12 << 5) | 16;
                            this.f3948c[i12] = (i13 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = dVar.f3960a;
                i2 = dVar.f3961b;
                i3--;
            }
            return false;
        }

        /* renamed from: f */
        private void m2875f() {
            int i = this.f3950e;
            int i2 = this.f3951f;
            for (int size = this.f3946a.size() - 1; size >= 0; size--) {
                C0890d dVar = this.f3946a.get(size);
                int i3 = dVar.f3960a;
                int i4 = dVar.f3962c;
                int i5 = i3 + i4;
                int i6 = dVar.f3961b + i4;
                if (this.f3952g) {
                    while (i > i5) {
                        m2873d(i, i2, size);
                        i--;
                    }
                    while (i2 > i6) {
                        m2876g(i, i2, size);
                        i2--;
                    }
                }
                for (int i7 = 0; i7 < dVar.f3962c; i7++) {
                    int i8 = dVar.f3960a + i7;
                    int i9 = dVar.f3961b + i7;
                    int i10 = this.f3949d.areContentsTheSame(i8, i9) ? 1 : 2;
                    this.f3947b[i8] = (i9 << 5) | i10;
                    this.f3948c[i9] = (i8 << 5) | i10;
                }
                i = dVar.f3960a;
                i2 = dVar.f3961b;
            }
        }

        /* renamed from: g */
        private void m2876g(int i, int i2, int i3) {
            if (this.f3948c[i2 - 1] == 0) {
                m2874e(i, i2, i3, true);
            }
        }

        /* renamed from: h */
        private static C0888b m2877h(List<C0888b> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                C0888b bVar = list.get(size);
                if (bVar.f3953a == i && bVar.f3955c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f3954b += z ? 1 : -1;
                        size++;
                    }
                    return bVar;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i) {
            if (i >= 0) {
                int[] iArr = this.f3948c;
                if (i < iArr.length) {
                    int i2 = iArr[i];
                    if ((i2 & 31) == 0) {
                        return -1;
                    }
                    return i2 >> 5;
                }
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.f3948c.length);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i) {
            if (i >= 0) {
                int[] iArr = this.f3947b;
                if (i < iArr.length) {
                    int i2 = iArr[i];
                    if ((i2 & 31) == 0) {
                        return -1;
                    }
                    return i2 >> 5;
                }
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.f3947b.length);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo((ListUpdateCallback) new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f3950e;
            int i2 = this.f3951f;
            for (int size = this.f3946a.size() - 1; size >= 0; size--) {
                C0890d dVar = this.f3946a.get(size);
                int i3 = dVar.f3962c;
                int i4 = dVar.f3960a + i3;
                int i5 = dVar.f3961b + i3;
                if (i4 < i) {
                    m2872c(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    m2871b(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    int[] iArr = this.f3947b;
                    int i7 = dVar.f3960a;
                    if ((iArr[i7 + i6] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i7 + i6, 1, this.f3949d.getChangePayload(i7 + i6, dVar.f3961b + i6));
                    }
                }
                i = dVar.f3960a;
                i2 = dVar.f3961b;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    /* renamed from: androidx.recyclerview.widget.DiffUtil$a */
    static class C0887a implements Comparator<C0890d> {
        C0887a() {
        }

        /* renamed from: a */
        public int compare(C0890d dVar, C0890d dVar2) {
            int i = dVar.f3960a - dVar2.f3960a;
            return i == 0 ? dVar.f3961b - dVar2.f3961b : i;
        }
    }

    /* renamed from: androidx.recyclerview.widget.DiffUtil$b */
    private static class C0888b {

        /* renamed from: a */
        int f3953a;

        /* renamed from: b */
        int f3954b;

        /* renamed from: c */
        boolean f3955c;

        public C0888b(int i, int i2, boolean z) {
            this.f3953a = i;
            this.f3954b = i2;
            this.f3955c = z;
        }
    }

    /* renamed from: androidx.recyclerview.widget.DiffUtil$c */
    static class C0889c {

        /* renamed from: a */
        int f3956a;

        /* renamed from: b */
        int f3957b;

        /* renamed from: c */
        int f3958c;

        /* renamed from: d */
        int f3959d;

        public C0889c() {
        }

        public C0889c(int i, int i2, int i3, int i4) {
            this.f3956a = i;
            this.f3957b = i2;
            this.f3958c = i3;
            this.f3959d = i4;
        }
    }

    /* renamed from: androidx.recyclerview.widget.DiffUtil$d */
    static class C0890d {

        /* renamed from: a */
        int f3960a;

        /* renamed from: b */
        int f3961b;

        /* renamed from: c */
        int f3962c;

        /* renamed from: d */
        boolean f3963d;

        /* renamed from: e */
        boolean f3964e;

        C0890d() {
        }
    }

    private DiffUtil() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r1[r13 - 1] < r1[r13 + r5]) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        if (r2[r12 - 1] < r2[r12 + 1]) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a A[LOOP:1: B:10:0x0033->B:33:0x009a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0081 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.recyclerview.widget.DiffUtil.C0890d m2869a(androidx.recyclerview.widget.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            r0 = r19
            r1 = r24
            r2 = r25
            int r3 = r21 - r20
            int r4 = r23 - r22
            r5 = 1
            if (r3 < r5) goto L_0x012f
            if (r4 >= r5) goto L_0x0011
            goto L_0x012f
        L_0x0011:
            int r6 = r3 - r4
            int r7 = r3 + r4
            int r7 = r7 + r5
            int r7 = r7 / 2
            int r8 = r26 - r7
            int r8 = r8 - r5
            int r9 = r26 + r7
            int r9 = r9 + r5
            r10 = 0
            java.util.Arrays.fill(r1, r8, r9, r10)
            int r8 = r8 + r6
            int r9 = r9 + r6
            java.util.Arrays.fill(r2, r8, r9, r3)
            int r8 = r6 % 2
            if (r8 == 0) goto L_0x002d
            r8 = 1
            goto L_0x002e
        L_0x002d:
            r8 = 0
        L_0x002e:
            r9 = 0
        L_0x002f:
            if (r9 > r7) goto L_0x0127
            int r11 = -r9
            r12 = r11
        L_0x0033:
            if (r12 > r9) goto L_0x00a0
            if (r12 == r11) goto L_0x004d
            if (r12 == r9) goto L_0x0045
            int r13 = r26 + r12
            int r14 = r13 + -1
            r14 = r1[r14]
            int r13 = r13 + r5
            r13 = r1[r13]
            if (r14 >= r13) goto L_0x0045
            goto L_0x004d
        L_0x0045:
            int r13 = r26 + r12
            int r13 = r13 - r5
            r13 = r1[r13]
            int r13 = r13 + r5
            r14 = 1
            goto L_0x0053
        L_0x004d:
            int r13 = r26 + r12
            int r13 = r13 + r5
            r13 = r1[r13]
            r14 = 0
        L_0x0053:
            int r15 = r13 - r12
        L_0x0055:
            if (r13 >= r3) goto L_0x006a
            if (r15 >= r4) goto L_0x006a
            int r10 = r20 + r13
            int r5 = r22 + r15
            boolean r5 = r0.areItemsTheSame(r10, r5)
            if (r5 == 0) goto L_0x006a
            int r13 = r13 + 1
            int r15 = r15 + 1
            r5 = 1
            r10 = 0
            goto L_0x0055
        L_0x006a:
            int r5 = r26 + r12
            r1[r5] = r13
            if (r8 == 0) goto L_0x009a
            int r10 = r6 - r9
            r13 = 1
            int r10 = r10 + r13
            if (r12 < r10) goto L_0x009a
            int r10 = r6 + r9
            int r10 = r10 - r13
            if (r12 > r10) goto L_0x009a
            r10 = r1[r5]
            r13 = r2[r5]
            if (r10 < r13) goto L_0x009a
            androidx.recyclerview.widget.DiffUtil$d r0 = new androidx.recyclerview.widget.DiffUtil$d
            r0.<init>()
            r3 = r2[r5]
            r0.f3960a = r3
            int r3 = r3 - r12
            r0.f3961b = r3
            r1 = r1[r5]
            r2 = r2[r5]
            int r1 = r1 - r2
            r0.f3962c = r1
            r0.f3963d = r14
            r13 = 0
            r0.f3964e = r13
            return r0
        L_0x009a:
            r13 = 0
            int r12 = r12 + 2
            r5 = 1
            r10 = 0
            goto L_0x0033
        L_0x00a0:
            r13 = 0
            r5 = r11
        L_0x00a2:
            if (r5 > r9) goto L_0x011c
            int r10 = r5 + r6
            int r12 = r9 + r6
            if (r10 == r12) goto L_0x00c4
            int r12 = r11 + r6
            if (r10 == r12) goto L_0x00bb
            int r12 = r26 + r10
            int r14 = r12 + -1
            r14 = r2[r14]
            r15 = 1
            int r12 = r12 + r15
            r12 = r2[r12]
            if (r14 >= r12) goto L_0x00bc
            goto L_0x00c5
        L_0x00bb:
            r15 = 1
        L_0x00bc:
            int r12 = r26 + r10
            int r12 = r12 + r15
            r12 = r2[r12]
            int r12 = r12 - r15
            r14 = 1
            goto L_0x00cb
        L_0x00c4:
            r15 = 1
        L_0x00c5:
            int r12 = r26 + r10
            int r12 = r12 - r15
            r12 = r2[r12]
            r14 = 0
        L_0x00cb:
            int r16 = r12 - r10
        L_0x00cd:
            if (r12 <= 0) goto L_0x00ea
            if (r16 <= 0) goto L_0x00ea
            int r17 = r20 + r12
            int r13 = r17 + -1
            int r17 = r22 + r16
            r18 = r3
            int r3 = r17 + -1
            boolean r3 = r0.areItemsTheSame(r13, r3)
            if (r3 == 0) goto L_0x00ec
            int r12 = r12 + -1
            int r16 = r16 + -1
            r3 = r18
            r13 = 0
            r15 = 1
            goto L_0x00cd
        L_0x00ea:
            r18 = r3
        L_0x00ec:
            int r3 = r26 + r10
            r2[r3] = r12
            if (r8 != 0) goto L_0x0115
            if (r10 < r11) goto L_0x0115
            if (r10 > r9) goto L_0x0115
            r12 = r1[r3]
            r13 = r2[r3]
            if (r12 < r13) goto L_0x0115
            androidx.recyclerview.widget.DiffUtil$d r0 = new androidx.recyclerview.widget.DiffUtil$d
            r0.<init>()
            r4 = r2[r3]
            r0.f3960a = r4
            int r4 = r4 - r10
            r0.f3961b = r4
            r1 = r1[r3]
            r2 = r2[r3]
            int r1 = r1 - r2
            r0.f3962c = r1
            r0.f3963d = r14
            r3 = 1
            r0.f3964e = r3
            return r0
        L_0x0115:
            r3 = 1
            int r5 = r5 + 2
            r3 = r18
            r13 = 0
            goto L_0x00a2
        L_0x011c:
            r18 = r3
            r3 = 1
            int r9 = r9 + 1
            r3 = r18
            r5 = 1
            r10 = 0
            goto L_0x002f
        L_0x0127:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation."
            r0.<init>(r1)
            throw r0
        L_0x012f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.m2869a(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$d");
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        C0889c cVar;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0889c(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0889c cVar2 = (C0889c) arrayList2.remove(arrayList2.size() - 1);
            C0890d a = m2869a(callback, cVar2.f3956a, cVar2.f3957b, cVar2.f3958c, cVar2.f3959d, iArr, iArr2, abs);
            if (a != null) {
                if (a.f3962c > 0) {
                    arrayList.add(a);
                }
                a.f3960a += cVar2.f3956a;
                a.f3961b += cVar2.f3958c;
                if (arrayList3.isEmpty()) {
                    cVar = new C0889c();
                } else {
                    cVar = (C0889c) arrayList3.remove(arrayList3.size() - 1);
                }
                cVar.f3956a = cVar2.f3956a;
                cVar.f3958c = cVar2.f3958c;
                if (a.f3964e) {
                    cVar.f3957b = a.f3960a;
                    cVar.f3959d = a.f3961b;
                } else if (a.f3963d) {
                    cVar.f3957b = a.f3960a - 1;
                    cVar.f3959d = a.f3961b;
                } else {
                    cVar.f3957b = a.f3960a;
                    cVar.f3959d = a.f3961b - 1;
                }
                arrayList2.add(cVar);
                if (!a.f3964e) {
                    int i2 = a.f3960a;
                    int i3 = a.f3962c;
                    cVar2.f3956a = i2 + i3;
                    cVar2.f3958c = a.f3961b + i3;
                } else if (a.f3963d) {
                    int i4 = a.f3960a;
                    int i5 = a.f3962c;
                    cVar2.f3956a = i4 + i5 + 1;
                    cVar2.f3958c = a.f3961b + i5;
                } else {
                    int i6 = a.f3960a;
                    int i7 = a.f3962c;
                    cVar2.f3956a = i6 + i7;
                    cVar2.f3958c = a.f3961b + i7 + 1;
                }
                arrayList2.add(cVar2);
            } else {
                arrayList3.add(cVar2);
            }
        }
        Collections.sort(arrayList, f3945a);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }
}
