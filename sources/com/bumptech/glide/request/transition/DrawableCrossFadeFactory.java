package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a */
    private final int f6462a;

    /* renamed from: b */
    private final boolean f6463b;

    /* renamed from: c */
    private DrawableCrossFadeTransition f6464c;

    public static class Builder {

        /* renamed from: a */
        private final int f6465a;

        /* renamed from: b */
        private boolean f6466b;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.f6465a, this.f6466b);
        }

        public Builder setCrossFadeEnabled(boolean z) {
            this.f6466b = z;
            return this;
        }

        public Builder(int i) {
            this.f6465a = i;
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.f6462a = i;
        this.f6463b = z;
    }

    /* renamed from: a */
    private Transition<Drawable> m4751a() {
        if (this.f6464c == null) {
            this.f6464c = new DrawableCrossFadeTransition(this.f6462a, this.f6463b);
        }
        return this.f6464c;
    }

    public Transition<Drawable> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.get();
        }
        return m4751a();
    }
}
