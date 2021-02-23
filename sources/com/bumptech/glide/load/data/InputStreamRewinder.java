package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a */
    private final RecyclableBufferedInputStream f5635a;

    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a */
        private final ArrayPool f5636a;

        public Factory(ArrayPool arrayPool) {
            this.f5636a = arrayPool;
        }

        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @NonNull
        public DataRewinder<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f5636a);
        }
    }

    InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f5635a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    public void cleanup() {
        this.f5635a.release();
    }

    @NonNull
    public InputStream rewindAndGet() {
        this.f5635a.reset();
        return this.f5635a;
    }
}
