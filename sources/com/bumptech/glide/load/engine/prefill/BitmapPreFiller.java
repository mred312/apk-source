package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

public final class BitmapPreFiller {

    /* renamed from: a */
    private final MemoryCache f5965a;

    /* renamed from: b */
    private final BitmapPool f5966b;

    /* renamed from: c */
    private final DecodeFormat f5967c;

    /* renamed from: d */
    private final Handler f5968d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private C1263a f5969e;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f5965a = memoryCache;
        this.f5966b = bitmapPool;
        this.f5967c = decodeFormat;
    }

    /* renamed from: b */
    private static int m4430b(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.mo9699d(), preFillType.mo9697b(), preFillType.mo9696a());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public C1266b mo9694a(PreFillType... preFillTypeArr) {
        long maxSize = (this.f5965a.getMaxSize() - this.f5965a.getCurrentSize()) + this.f5966b.getMaxSize();
        int i = 0;
        for (PreFillType c : preFillTypeArr) {
            i += c.mo9698c();
        }
        float f = ((float) maxSize) / ((float) i);
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType : preFillTypeArr) {
            hashMap.put(preFillType, Integer.valueOf(Math.round(((float) preFillType.mo9698c()) * f) / m4430b(preFillType)));
        }
        return new C1266b(hashMap);
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        C1263a aVar = this.f5969e;
        if (aVar != null) {
            aVar.mo9708b();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i = 0; i < builderArr.length; i++) {
            PreFillType.Builder builder = builderArr[i];
            if (builder.mo9704b() == null) {
                if (this.f5967c == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i] = builder.mo9703a();
        }
        C1263a aVar2 = new C1263a(this.f5966b, this.f5965a, mo9694a(preFillTypeArr));
        this.f5969e = aVar2;
        this.f5968d.post(aVar2);
    }
}
