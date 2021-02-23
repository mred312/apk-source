package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.core.location.a */
/* compiled from: GnssStatusWrapper */
class C0480a extends GnssStatusCompat {

    /* renamed from: a */
    private final GnssStatus f2408a;

    C0480a(GnssStatus gnssStatus) {
        this.f2408a = (GnssStatus) Preconditions.checkNotNull(gnssStatus);
    }

    public float getAzimuthDegrees(int i) {
        return this.f2408a.getAzimuthDegrees(i);
    }

    public float getCarrierFrequencyHz(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2408a.getCarrierFrequencyHz(i);
        }
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i) {
        return this.f2408a.getCn0DbHz(i);
    }

    public int getConstellationType(int i) {
        return this.f2408a.getConstellationType(i);
    }

    public float getElevationDegrees(int i) {
        return this.f2408a.getElevationDegrees(i);
    }

    public int getSatelliteCount() {
        return this.f2408a.getSatelliteCount();
    }

    public int getSvid(int i) {
        return this.f2408a.getSvid(i);
    }

    public boolean hasAlmanacData(int i) {
        return this.f2408a.hasAlmanacData(i);
    }

    public boolean hasCarrierFrequencyHz(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2408a.hasCarrierFrequencyHz(i);
        }
        return false;
    }

    public boolean hasEphemerisData(int i) {
        return this.f2408a.hasEphemerisData(i);
    }

    public boolean usedInFix(int i) {
        return this.f2408a.usedInFix(i);
    }
}
