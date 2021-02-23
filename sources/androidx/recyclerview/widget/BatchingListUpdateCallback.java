package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a */
    final ListUpdateCallback f3889a;

    /* renamed from: b */
    int f3890b = 0;

    /* renamed from: c */
    int f3891c = -1;

    /* renamed from: d */
    int f3892d = -1;

    /* renamed from: e */
    Object f3893e = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.f3889a = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.f3890b;
        if (i != 0) {
            if (i == 1) {
                this.f3889a.onInserted(this.f3891c, this.f3892d);
            } else if (i == 2) {
                this.f3889a.onRemoved(this.f3891c, this.f3892d);
            } else if (i == 3) {
                this.f3889a.onChanged(this.f3891c, this.f3892d, this.f3893e);
            }
            this.f3893e = null;
            this.f3890b = 0;
        }
    }

    public void onChanged(int i, int i2, Object obj) {
        int i3;
        if (this.f3890b == 3) {
            int i4 = this.f3891c;
            int i5 = this.f3892d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.f3893e == obj) {
                this.f3891c = Math.min(i, i4);
                this.f3892d = Math.max(i5 + i4, i3) - this.f3891c;
                return;
            }
        }
        dispatchLastEvent();
        this.f3891c = i;
        this.f3892d = i2;
        this.f3893e = obj;
        this.f3890b = 3;
    }

    public void onInserted(int i, int i2) {
        int i3;
        if (this.f3890b == 1 && i >= (i3 = this.f3891c)) {
            int i4 = this.f3892d;
            if (i <= i3 + i4) {
                this.f3892d = i4 + i2;
                this.f3891c = Math.min(i, i3);
                return;
            }
        }
        dispatchLastEvent();
        this.f3891c = i;
        this.f3892d = i2;
        this.f3890b = 1;
    }

    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.f3889a.onMoved(i, i2);
    }

    public void onRemoved(int i, int i2) {
        int i3;
        if (this.f3890b != 2 || (i3 = this.f3891c) < i || i3 > i + i2) {
            dispatchLastEvent();
            this.f3891c = i;
            this.f3892d = i2;
            this.f3890b = 2;
            return;
        }
        this.f3892d += i2;
        this.f3891c = i;
    }
}
