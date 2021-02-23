package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.versionedparcelable.a */
/* compiled from: VersionedParcelParcel */
class C1053a extends VersionedParcel {

    /* renamed from: a */
    private final SparseIntArray f4872a;

    /* renamed from: b */
    private final Parcel f4873b;

    /* renamed from: c */
    private final int f4874c;

    /* renamed from: d */
    private final int f4875d;

    /* renamed from: e */
    private final String f4876e;

    /* renamed from: f */
    private int f4877f;

    /* renamed from: g */
    private int f4878g;

    /* renamed from: h */
    private int f4879h;

    C1053a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public void closeField() {
        int i = this.f4877f;
        if (i >= 0) {
            int i2 = this.f4872a.get(i);
            int dataPosition = this.f4873b.dataPosition();
            this.f4873b.setDataPosition(i2);
            this.f4873b.writeInt(dataPosition - i2);
            this.f4873b.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel createSubParcel() {
        Parcel parcel = this.f4873b;
        int dataPosition = parcel.dataPosition();
        int i = this.f4878g;
        if (i == this.f4874c) {
            i = this.f4875d;
        }
        int i2 = i;
        return new C1053a(parcel, dataPosition, i2, this.f4876e + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean readBoolean() {
        return this.f4873b.readInt() != 0;
    }

    public Bundle readBundle() {
        return this.f4873b.readBundle(C1053a.class.getClassLoader());
    }

    public byte[] readByteArray() {
        int readInt = this.f4873b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4873b.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4873b);
    }

    public double readDouble() {
        return this.f4873b.readDouble();
    }

    public boolean readField(int i) {
        while (this.f4878g < this.f4875d) {
            int i2 = this.f4879h;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f4873b.setDataPosition(this.f4878g);
            int readInt = this.f4873b.readInt();
            this.f4879h = this.f4873b.readInt();
            this.f4878g += readInt;
        }
        if (this.f4879h == i) {
            return true;
        }
        return false;
    }

    public float readFloat() {
        return this.f4873b.readFloat();
    }

    public int readInt() {
        return this.f4873b.readInt();
    }

    public long readLong() {
        return this.f4873b.readLong();
    }

    public <T extends Parcelable> T readParcelable() {
        return this.f4873b.readParcelable(C1053a.class.getClassLoader());
    }

    public String readString() {
        return this.f4873b.readString();
    }

    public IBinder readStrongBinder() {
        return this.f4873b.readStrongBinder();
    }

    public void setOutputField(int i) {
        closeField();
        this.f4877f = i;
        this.f4872a.put(i, this.f4873b.dataPosition());
        writeInt(0);
        writeInt(i);
    }

    public void writeBoolean(boolean z) {
        this.f4873b.writeInt(z ? 1 : 0);
    }

    public void writeBundle(Bundle bundle) {
        this.f4873b.writeBundle(bundle);
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            this.f4873b.writeInt(bArr.length);
            this.f4873b.writeByteArray(bArr);
            return;
        }
        this.f4873b.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4873b, 0);
    }

    public void writeDouble(double d) {
        this.f4873b.writeDouble(d);
    }

    public void writeFloat(float f) {
        this.f4873b.writeFloat(f);
    }

    public void writeInt(int i) {
        this.f4873b.writeInt(i);
    }

    public void writeLong(long j) {
        this.f4873b.writeLong(j);
    }

    public void writeParcelable(Parcelable parcelable) {
        this.f4873b.writeParcelable(parcelable, 0);
    }

    public void writeString(String str) {
        this.f4873b.writeString(str);
    }

    public void writeStrongBinder(IBinder iBinder) {
        this.f4873b.writeStrongBinder(iBinder);
    }

    public void writeStrongInterface(IInterface iInterface) {
        this.f4873b.writeStrongInterface(iInterface);
    }

    private C1053a(Parcel parcel, int i, int i2, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f4872a = new SparseIntArray();
        this.f4877f = -1;
        this.f4878g = 0;
        this.f4879h = -1;
        this.f4873b = parcel;
        this.f4874c = i;
        this.f4875d = i2;
        this.f4878g = i;
        this.f4876e = str;
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.f4873b.writeInt(bArr.length);
            this.f4873b.writeByteArray(bArr, i, i2);
            return;
        }
        this.f4873b.writeInt(-1);
    }
}
