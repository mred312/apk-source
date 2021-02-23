package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {

    /* renamed from: a */
    private final byte[] f5563a = new byte[256];

    /* renamed from: b */
    private ByteBuffer f5564b;

    /* renamed from: c */
    private GifHeader f5565c;

    /* renamed from: d */
    private int f5566d = 0;

    /* renamed from: a */
    private boolean m4162a() {
        return this.f5565c.f5551b != 0;
    }

    /* renamed from: b */
    private int m4163b() {
        try {
            return this.f5564b.get() & 255;
        } catch (Exception unused) {
            this.f5565c.f5551b = 1;
            return 0;
        }
    }

    /* renamed from: c */
    private void m4164c() {
        this.f5565c.f5553d.f5589a = m4173l();
        this.f5565c.f5553d.f5590b = m4173l();
        this.f5565c.f5553d.f5591c = m4173l();
        this.f5565c.f5553d.f5592d = m4173l();
        int b = m4163b();
        boolean z = false;
        boolean z2 = (b & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((b & 7) + 1));
        C1169a aVar = this.f5565c.f5553d;
        if ((b & 64) != 0) {
            z = true;
        }
        aVar.f5593e = z;
        if (z2) {
            aVar.f5599k = m4166e(pow);
        } else {
            aVar.f5599k = null;
        }
        this.f5565c.f5553d.f5598j = this.f5564b.position();
        m4176o();
        if (!m4162a()) {
            GifHeader gifHeader = this.f5565c;
            gifHeader.f5552c++;
            gifHeader.f5554e.add(gifHeader.f5553d);
        }
    }

    /* renamed from: d */
    private void m4165d() {
        int b = m4163b();
        this.f5566d = b;
        if (b > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    int i3 = this.f5566d;
                    if (i < i3) {
                        i2 = i3 - i;
                        this.f5564b.get(this.f5563a, i, i2);
                        i += i2;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f5566d, e);
                    }
                    this.f5565c.f5551b = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    /* renamed from: e */
    private int[] m4166e(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.f5564b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | -16777216 | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f5565c.f5551b = 1;
        }
        return iArr;
    }

    /* renamed from: f */
    private void m4167f() {
        m4168g(Integer.MAX_VALUE);
    }

    /* renamed from: g */
    private void m4168g(int i) {
        boolean z = false;
        while (!z && !m4162a() && this.f5565c.f5552c <= i) {
            int b = m4163b();
            if (b == 33) {
                int b2 = m4163b();
                if (b2 == 1) {
                    m4175n();
                } else if (b2 == 249) {
                    this.f5565c.f5553d = new C1169a();
                    m4169h();
                } else if (b2 == 254) {
                    m4175n();
                } else if (b2 != 255) {
                    m4175n();
                } else {
                    m4165d();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f5563a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m4172k();
                    } else {
                        m4175n();
                    }
                }
            } else if (b == 44) {
                GifHeader gifHeader = this.f5565c;
                if (gifHeader.f5553d == null) {
                    gifHeader.f5553d = new C1169a();
                }
                m4164c();
            } else if (b != 59) {
                this.f5565c.f5551b = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: h */
    private void m4169h() {
        m4163b();
        int b = m4163b();
        C1169a aVar = this.f5565c.f5553d;
        int i = (b & 28) >> 2;
        aVar.f5595g = i;
        boolean z = true;
        if (i == 0) {
            aVar.f5595g = 1;
        }
        if ((b & 1) == 0) {
            z = false;
        }
        aVar.f5594f = z;
        int l = m4173l();
        if (l < 2) {
            l = 10;
        }
        C1169a aVar2 = this.f5565c.f5553d;
        aVar2.f5597i = l * 10;
        aVar2.f5596h = m4163b();
        m4163b();
    }

    /* renamed from: i */
    private void m4170i() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m4163b());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f5565c.f5551b = 1;
            return;
        }
        m4171j();
        if (this.f5565c.f5557h && !m4162a()) {
            GifHeader gifHeader = this.f5565c;
            gifHeader.f5550a = m4166e(gifHeader.f5558i);
            GifHeader gifHeader2 = this.f5565c;
            gifHeader2.f5561l = gifHeader2.f5550a[gifHeader2.f5559j];
        }
    }

    /* renamed from: j */
    private void m4171j() {
        this.f5565c.f5555f = m4173l();
        this.f5565c.f5556g = m4173l();
        int b = m4163b();
        GifHeader gifHeader = this.f5565c;
        gifHeader.f5557h = (b & 128) != 0;
        gifHeader.f5558i = (int) Math.pow(2.0d, (double) ((b & 7) + 1));
        this.f5565c.f5559j = m4163b();
        this.f5565c.f5560k = m4163b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4172k() {
        /*
            r3 = this;
        L_0x0000:
            r3.m4165d()
            byte[] r0 = r3.f5563a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.f5565c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f5562m = r0
        L_0x001b:
            int r0 = r3.f5566d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.m4162a()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.m4172k():void");
    }

    /* renamed from: l */
    private int m4173l() {
        return this.f5564b.getShort();
    }

    /* renamed from: m */
    private void m4174m() {
        this.f5564b = null;
        Arrays.fill(this.f5563a, (byte) 0);
        this.f5565c = new GifHeader();
        this.f5566d = 0;
    }

    /* renamed from: n */
    private void m4175n() {
        int b;
        do {
            b = m4163b();
            this.f5564b.position(Math.min(this.f5564b.position() + b, this.f5564b.limit()));
        } while (b > 0);
    }

    /* renamed from: o */
    private void m4176o() {
        m4163b();
        m4175n();
    }

    public void clear() {
        this.f5564b = null;
        this.f5565c = null;
    }

    public boolean isAnimated() {
        m4170i();
        if (!m4162a()) {
            m4168g(2);
        }
        return this.f5565c.f5552c > 1;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.f5564b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m4162a()) {
            return this.f5565c;
        } else {
            m4170i();
            if (!m4162a()) {
                m4167f();
                GifHeader gifHeader = this.f5565c;
                if (gifHeader.f5552c < 0) {
                    gifHeader.f5551b = 1;
                }
            }
            return this.f5565c;
        }
    }

    public GifHeaderParser setData(@NonNull ByteBuffer byteBuffer) {
        m4174m();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f5564b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f5564b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
        } else {
            this.f5564b = null;
            this.f5565c.f5551b = 2;
        }
        return this;
    }
}
