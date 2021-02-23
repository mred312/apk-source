package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcej {

    /* renamed from: a */
    private final Clock f14187a;

    /* renamed from: b */
    private final Executor f14188b;

    public zzcej(zzax zzax, Clock clock, Executor executor) {
        this.f14187a = clock;
        this.f14188b = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final Bitmap m7942b(byte[] bArr, double d, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwr)).booleanValue()) {
            options.inJustDecodeBounds = true;
            m7943c(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                int i2 = i - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i2 / ((Integer) zzwq.zzqe().zzd(zzabf.zzcws)).intValue())) / 2);
            }
        }
        return m7943c(bArr, options);
    }

    /* renamed from: c */
    private final Bitmap m7943c(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.f14187a.elapsedRealtime();
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.f14187a.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = elapsedRealtime2 - elapsedRealtime;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            }
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzd.zzee(sb.toString());
        }
        return decodeByteArray;
    }

    public final zzdyz<Bitmap> zza(String str, double d, boolean z) {
        return zzdyr.zzb(zzax.zzer(str), new C1880ei(this, d, z), this.f14188b);
    }
}
