package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;

public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;
    @ColorInt

    /* renamed from: a */
    int[] f5550a = null;

    /* renamed from: b */
    int f5551b = 0;

    /* renamed from: c */
    int f5552c = 0;

    /* renamed from: d */
    C1169a f5553d;

    /* renamed from: e */
    final List<C1169a> f5554e = new ArrayList();

    /* renamed from: f */
    int f5555f;

    /* renamed from: g */
    int f5556g;

    /* renamed from: h */
    boolean f5557h;

    /* renamed from: i */
    int f5558i;

    /* renamed from: j */
    int f5559j;

    /* renamed from: k */
    int f5560k;
    @ColorInt

    /* renamed from: l */
    int f5561l;

    /* renamed from: m */
    int f5562m = -1;

    public int getHeight() {
        return this.f5556g;
    }

    public int getNumFrames() {
        return this.f5552c;
    }

    public int getStatus() {
        return this.f5551b;
    }

    public int getWidth() {
        return this.f5555f;
    }
}
