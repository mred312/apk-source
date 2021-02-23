package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.nio.ByteBuffer;

@RequiresApi(api = 28)
public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a */
    private final BitmapImageDecoderResourceDecoder f6116a = new BitmapImageDecoderResourceDecoder();

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return true;
    }

    @Nullable
    public Resource<Bitmap> decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        return this.f6116a.decode(ImageDecoder.createSource(byteBuffer), i, i2, options);
    }
}
