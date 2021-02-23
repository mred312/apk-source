package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.datatransport.runtime.scheduling.persistence.C1626a;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.c */
/* compiled from: EventStoreConfig */
abstract class C1630c {

    /* renamed from: a */
    static final C1630c f7376a;

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.c$a */
    /* compiled from: EventStoreConfig */
    static abstract class C1631a {
        C1631a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C1630c mo11528a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C1631a mo11529b(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract C1631a mo11530c(long j);

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract C1631a mo11531d(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public abstract C1631a mo11532e(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public abstract C1631a mo11533f(long j);
    }

    static {
        C1631a a = m5175a();
        a.mo11533f(10485760);
        a.mo11531d(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        a.mo11529b(10000);
        a.mo11530c(604800000);
        a.mo11532e(81920);
        f7376a = a.mo11528a();
    }

    C1630c() {
    }

    /* renamed from: a */
    static C1631a m5175a() {
        return new C1626a.C1628b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract int mo11520b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract long mo11521c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract int mo11522d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract int mo11523e();

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract long mo11525f();
}
