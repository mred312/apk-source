package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.core.location.b */
/* compiled from: GpsStatusWrapper */
class C0481b extends GnssStatusCompat {

    /* renamed from: a */
    private final GpsStatus f2409a;
    @GuardedBy("mWrapped")

    /* renamed from: b */
    private int f2410b = -1;
    @GuardedBy("mWrapped")

    /* renamed from: c */
    private Iterator<GpsSatellite> f2411c;
    @GuardedBy("mWrapped")

    /* renamed from: d */
    private int f2412d;
    @GuardedBy("mWrapped")

    /* renamed from: e */
    private GpsSatellite f2413e;

    C0481b(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.f2409a = gpsStatus2;
        this.f2411c = gpsStatus2.getSatellites().iterator();
        this.f2412d = -1;
        this.f2413e = null;
    }

    /* renamed from: a */
    private static int m1605a(int i) {
        if (i > 0 && i <= 32) {
            return 1;
        }
        if (i >= 33 && i <= 64) {
            return 2;
        }
        if (i > 64 && i <= 88) {
            return 3;
        }
        if (i <= 200 || i > 235) {
            return (i < 193 || i > 200) ? 0 : 4;
        }
        return 5;
    }

    /* renamed from: b */
    private GpsSatellite m1606b(int i) {
        GpsSatellite gpsSatellite;
        synchronized (this.f2409a) {
            if (i < this.f2412d) {
                this.f2411c = this.f2409a.getSatellites().iterator();
                this.f2412d = -1;
            }
            while (true) {
                int i2 = this.f2412d;
                if (i2 >= i) {
                    break;
                }
                this.f2412d = i2 + 1;
                if (!this.f2411c.hasNext()) {
                    this.f2413e = null;
                    break;
                }
                this.f2413e = this.f2411c.next();
            }
            gpsSatellite = this.f2413e;
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    /* renamed from: c */
    private static int m1607c(int i) {
        int a = m1605a(i);
        if (a == 2) {
            return i + 87;
        }
        if (a != 3) {
            return a != 5 ? i : i - 200;
        }
        return i - 64;
    }

    public float getAzimuthDegrees(int i) {
        return m1606b(i).getAzimuth();
    }

    public float getCarrierFrequencyHz(int i) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i) {
        return m1606b(i).getSnr();
    }

    public int getConstellationType(int i) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return m1605a(m1606b(i).getPrn());
    }

    public float getElevationDegrees(int i) {
        return m1606b(i).getElevation();
    }

    public int getSatelliteCount() {
        int i;
        synchronized (this.f2409a) {
            if (this.f2410b == -1) {
                for (GpsSatellite next : this.f2409a.getSatellites()) {
                    this.f2410b++;
                }
                this.f2410b++;
            }
            i = this.f2410b;
        }
        return i;
    }

    public int getSvid(int i) {
        if (Build.VERSION.SDK_INT < 24) {
            return m1606b(i).getPrn();
        }
        return m1607c(m1606b(i).getPrn());
    }

    public boolean hasAlmanacData(int i) {
        return m1606b(i).hasAlmanac();
    }

    public boolean hasCarrierFrequencyHz(int i) {
        return false;
    }

    public boolean hasEphemerisData(int i) {
        return m1606b(i).hasEphemeris();
    }

    public boolean usedInFix(int i) {
        return m1606b(i).usedInFix();
    }
}
