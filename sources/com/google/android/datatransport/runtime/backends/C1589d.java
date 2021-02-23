package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import javax.inject.Inject;

/* renamed from: com.google.android.datatransport.runtime.backends.d */
/* compiled from: CreationContextFactory */
class C1589d {

    /* renamed from: a */
    private final Context f7216a;

    /* renamed from: b */
    private final Clock f7217b;

    /* renamed from: c */
    private final Clock f7218c;

    @Inject
    C1589d(Context context, @WallTime Clock clock, @Monotonic Clock clock2) {
        this.f7216a = context;
        this.f7217b = clock;
        this.f7218c = clock2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CreationContext mo11446a(String str) {
        return CreationContext.create(this.f7216a, this.f7217b, this.f7218c, str);
    }
}
