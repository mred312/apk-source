package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<Data> f5694a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f5695b;

    /* renamed from: c */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f5696c;

    /* renamed from: d */
    private final String f5697d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f5694a = cls;
        this.f5695b = pool;
        this.f5696c = (List) Preconditions.checkNotEmpty(list);
        this.f5697d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* renamed from: a */
    private Resource<Transcode> m4238a(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.C1180a<ResourceType> aVar, List<Throwable> list) {
        List<Throwable> list2 = list;
        int size = this.f5696c.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = ((DecodePath) this.f5696c.get(i3)).decode(dataRewinder, i, i2, options, aVar);
            } catch (GlideException e) {
                list2.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f5697d, (List<Throwable>) new ArrayList(list2));
    }

    public Class<Data> getDataClass() {
        return this.f5694a;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, @NonNull Options options, int i, int i2, DecodePath.C1180a<ResourceType> aVar) {
        List list = (List) Preconditions.checkNotNull(this.f5695b.acquire());
        try {
            return m4238a(dataRewinder, options, i, i2, aVar, list);
        } finally {
            this.f5695b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f5696c.toArray()) + '}';
    }
}
