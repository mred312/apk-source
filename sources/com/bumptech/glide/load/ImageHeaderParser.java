package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        

        /* renamed from: a */
        private final boolean f5604a;

        private ImageType(boolean z) {
            this.f5604a = z;
        }

        public boolean hasAlpha() {
            return this.f5604a;
        }
    }

    int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool);

    int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool);

    @NonNull
    ImageType getType(@NonNull InputStream inputStream);

    @NonNull
    ImageType getType(@NonNull ByteBuffer byteBuffer);
}
