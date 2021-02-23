package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a */
    private final Downsampler f6166a;

    /* renamed from: b */
    private final ArrayPool f6167b;

    /* renamed from: com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder$a */
    static class C1306a implements Downsampler.DecodeCallbacks {

        /* renamed from: a */
        private final RecyclableBufferedInputStream f6168a;

        /* renamed from: b */
        private final ExceptionCatchingInputStream f6169b;

        C1306a(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f6168a = recyclableBufferedInputStream;
            this.f6169b = exceptionCatchingInputStream;
        }

        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
            IOException exception = this.f6169b.getException();
            if (exception != null) {
                if (bitmap != null) {
                    bitmapPool.put(bitmap);
                }
                throw exception;
            }
        }

        public void onObtainBounds() {
            this.f6168a.fixMarkLimit();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f6166a = downsampler;
        this.f6167b = arrayPool;
    }

    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f6167b);
            z = true;
        }
        ExceptionCatchingInputStream obtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        try {
            return this.f6166a.decode(new MarkEnforcingInputStream(obtain), i, i2, options, new C1306a(recyclableBufferedInputStream, obtain));
        } finally {
            obtain.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.f6166a.handles(inputStream);
    }
}
