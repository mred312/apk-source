package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;

@RequiresApi(api = 28)
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: a */
    final HardwareConfigState f6096a = HardwareConfigState.getInstance();

    /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$a */
    class C1292a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a */
        final /* synthetic */ int f6097a;

        /* renamed from: b */
        final /* synthetic */ int f6098b;

        /* renamed from: c */
        final /* synthetic */ boolean f6099c;

        /* renamed from: d */
        final /* synthetic */ DecodeFormat f6100d;

        /* renamed from: e */
        final /* synthetic */ DownsampleStrategy f6101e;

        /* renamed from: f */
        final /* synthetic */ PreferredColorSpace f6102f;

        /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$a$a */
        class C1293a implements ImageDecoder.OnPartialImageListener {
            C1293a(C1292a aVar) {
            }

            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        C1292a(int i, int i2, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.f6097a = i;
            this.f6098b = i2;
            this.f6099c = z;
            this.f6100d = decodeFormat;
            this.f6101e = downsampleStrategy;
            this.f6102f = preferredColorSpace;
        }

        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (ImageDecoderResourceDecoder.this.f6096a.isHardwareConfigAllowed(this.f6097a, this.f6098b, this.f6099c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f6100d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C1293a(this));
            Size size = imageInfo.getSize();
            int i = this.f6097a;
            if (i == Integer.MIN_VALUE) {
                i = size.getWidth();
            }
            int i2 = this.f6098b;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getHeight();
            }
            float scaleFactor = this.f6101e.getScaleFactor(size.getWidth(), size.getHeight(), i, i2);
            int round = Math.round(((float) size.getWidth()) * scaleFactor);
            int round2 = Math.round(((float) size.getHeight()) * scaleFactor);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
            }
            imageDecoder.setTargetSize(round, round2);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                if (this.f6102f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i3 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract Resource<T> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener);

    public final boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }

    @Nullable
    public final Resource<T> decode(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull Options options) {
        DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        Option option = Downsampler.ALLOW_HARDWARE_CONFIG;
        return decode(source, i, i2, (ImageDecoder.OnHeaderDecodedListener) new C1292a(i, i2, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE)));
    }
}
