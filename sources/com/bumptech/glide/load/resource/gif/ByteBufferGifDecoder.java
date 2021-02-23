package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f */
    private static final C1321a f6192f = new C1321a();

    /* renamed from: g */
    private static final C1322b f6193g = new C1322b();

    /* renamed from: a */
    private final Context f6194a;

    /* renamed from: b */
    private final List<ImageHeaderParser> f6195b;

    /* renamed from: c */
    private final C1322b f6196c;

    /* renamed from: d */
    private final C1321a f6197d;

    /* renamed from: e */
    private final GifBitmapProvider f6198e;

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$a */
    static class C1321a {
        C1321a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public GifDecoder mo9899a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$b */
    static class C1322b {

        /* renamed from: a */
        private final Queue<GifHeaderParser> f6199a = Util.createQueue(0);

        C1322b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized GifHeaderParser mo9900a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f6199a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.setData(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public synchronized void mo9901b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.f6199a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get(context).getRegistry().getImageHeaderParsers(), Glide.get(context).getBitmapPool(), Glide.get(context).getArrayPool());
    }

    @Nullable
    /* renamed from: a */
    private GifDrawableResource m4581a(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0) {
                if (parseHeader.getStatus() == 0) {
                    if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    GifDecoder a = this.f6197d.mo9899a(this.f6198e, parseHeader, byteBuffer, m4582b(parseHeader, i, i2));
                    a.setDefaultBitmapConfig(config);
                    a.advance();
                    Bitmap nextFrame = a.getNextFrame();
                    if (nextFrame == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f6194a, a, UnitTransformation.get(), i, i2, nextFrame));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
            }
        }
    }

    /* renamed from: b */
    private static int m4582b(GifHeader gifHeader, int i, int i2) {
        int i3;
        int min = Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
        if (min == 0) {
            i3 = 0;
        } else {
            i3 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i3);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + gifHeader.getWidth() + "x" + gifHeader.getHeight() + "]");
        }
        return max;
    }

    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser a = this.f6196c.mo9900a(byteBuffer);
        try {
            return m4581a(byteBuffer, i, i2, a, options);
        } finally {
            this.f6196c.mo9901b(a);
        }
    }

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.f6195b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f6193g, f6192f);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, C1322b bVar, C1321a aVar) {
        this.f6194a = context.getApplicationContext();
        this.f6195b = list;
        this.f6197d = aVar;
        this.f6198e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f6196c = bVar;
    }
}
