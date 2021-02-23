package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.e */
/* compiled from: DataCacheWriter */
class C1229e<DataType> implements DiskCache.Writer {

    /* renamed from: a */
    private final Encoder<DataType> f5808a;

    /* renamed from: b */
    private final DataType f5809b;

    /* renamed from: c */
    private final Options f5810c;

    C1229e(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f5808a = encoder;
        this.f5809b = datatype;
        this.f5810c = options;
    }

    public boolean write(@NonNull File file) {
        return this.f5808a.encode(this.f5809b, file, this.f5810c);
    }
}
