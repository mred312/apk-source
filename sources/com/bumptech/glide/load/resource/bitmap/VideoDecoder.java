package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new C1313b());
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new C1312a());

    /* renamed from: d */
    private static final C1315d f6181d = new C1315d();

    /* renamed from: a */
    private final C1316e<T> f6182a;

    /* renamed from: b */
    private final BitmapPool f6183b;

    /* renamed from: c */
    private final C1315d f6184c;

    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$a */
    class C1312a implements Option.CacheKeyUpdater<Long> {

        /* renamed from: a */
        private final ByteBuffer f6185a = ByteBuffer.allocate(8);

        C1312a() {
        }

        /* renamed from: a */
        public void update(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f6185a) {
                this.f6185a.position(0);
                messageDigest.update(this.f6185a.putLong(l.longValue()).array());
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$b */
    class C1313b implements Option.CacheKeyUpdater<Integer> {

        /* renamed from: a */
        private final ByteBuffer f6186a = ByteBuffer.allocate(4);

        C1313b() {
        }

        /* renamed from: a */
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f6186a) {
                    this.f6186a.position(0);
                    messageDigest.update(this.f6186a.putInt(num.intValue()).array());
                }
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$c */
    private static final class C1314c implements C1316e<AssetFileDescriptor> {
        private C1314c() {
        }

        /* renamed from: b */
        public void mo9882a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ C1314c(C1312a aVar) {
            this();
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$d */
    static class C1315d {
        C1315d() {
        }

        /* renamed from: a */
        public MediaMetadataRetriever mo9884a() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$e */
    interface C1316e<T> {
        /* renamed from: a */
        void mo9882a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.VideoDecoder$f */
    static final class C1317f implements C1316e<ParcelFileDescriptor> {
        C1317f() {
        }

        /* renamed from: b */
        public void mo9882a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(BitmapPool bitmapPool, C1316e<T> eVar) {
        this(bitmapPool, eVar, f6181d);
    }

    @Nullable
    /* renamed from: a */
    private static Bitmap m4560a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap c = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.NONE) ? null : m4562c(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return c == null ? m4561b(mediaMetadataRetriever, j, i) : c;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new C1314c((C1312a) null));
    }

    /* renamed from: b */
    private static Bitmap m4561b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @TargetApi(27)
    /* renamed from: c */
    private static Bitmap m4562c(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i4 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i4;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(((float) parseInt) * scaleFactor), Math.round(scaleFactor * ((float) parseInt2)));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new C1317f());
    }

    public Resource<Bitmap> decode(@NonNull T t, int i, int i2, @NonNull Options options) {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.get(FRAME_OPTION);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.DEFAULT;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a = this.f6184c.mo9884a();
            try {
                this.f6182a.mo9882a(a, t);
                Bitmap a2 = m4560a(a, longValue, num.intValue(), i, i2, downsampleStrategy2);
                a.release();
                return BitmapResource.obtain(a2, this.f6183b);
            } catch (RuntimeException e) {
                throw new IOException(e);
            } catch (Throwable th) {
                a.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean handles(@NonNull T t, @NonNull Options options) {
        return true;
    }

    @VisibleForTesting
    VideoDecoder(BitmapPool bitmapPool, C1316e<T> eVar, C1315d dVar) {
        this.f6183b = bitmapPool;
        this.f6182a = eVar;
        this.f6184c = dVar;
    }
}
