package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<DataType> f5654a;

    /* renamed from: b */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f5655b;

    /* renamed from: c */
    private final ResourceTranscoder<ResourceType, Transcode> f5656c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f5657d;

    /* renamed from: e */
    private final String f5658e;

    /* renamed from: com.bumptech.glide.load.engine.DecodePath$a */
    interface C1180a<ResourceType> {
        @NonNull
        /* renamed from: a */
        Resource<ResourceType> mo9442a(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.f5654a = cls;
        this.f5655b = list;
        this.f5656c = resourceTranscoder;
        this.f5657d = pool;
        this.f5658e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    /* renamed from: a */
    private Resource<ResourceType> m4214a(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options) {
        List list = (List) Preconditions.checkNotNull(this.f5657d.acquire());
        try {
            return m4215b(dataRewinder, i, i2, options, list);
        } finally {
            this.f5657d.release(list);
        }
    }

    @NonNull
    /* renamed from: b */
    private Resource<ResourceType> m4215b(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, List<Throwable> list) {
        int size = this.f5655b.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.f5655b.get(i3);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f5658e, (List<Throwable>) new ArrayList(list));
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i, int i2, @NonNull Options options, C1180a<ResourceType> aVar) {
        return this.f5656c.transcode(aVar.mo9442a(m4214a(dataRewinder, i, i2, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f5654a + ", decoders=" + this.f5655b + ", transcoder=" + this.f5656c + '}';
    }
}
