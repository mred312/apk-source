package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.versionedparcelable.b */
/* compiled from: VersionedParcelStream */
class C1054b extends VersionedParcel {

    /* renamed from: j */
    private static final Charset f4880j = Charset.forName("UTF-16");

    /* renamed from: a */
    private final DataInputStream f4881a;

    /* renamed from: b */
    private final DataOutputStream f4882b;

    /* renamed from: c */
    private DataInputStream f4883c;

    /* renamed from: d */
    private DataOutputStream f4884d;

    /* renamed from: e */
    private C1056b f4885e;

    /* renamed from: f */
    private boolean f4886f;

    /* renamed from: g */
    int f4887g;

    /* renamed from: h */
    private int f4888h;

    /* renamed from: i */
    int f4889i;

    /* renamed from: androidx.versionedparcelable.b$b */
    /* compiled from: VersionedParcelStream */
    private static class C1056b {

        /* renamed from: a */
        final ByteArrayOutputStream f4891a;

        /* renamed from: b */
        final DataOutputStream f4892b;

        /* renamed from: c */
        private final int f4893c;

        /* renamed from: d */
        private final DataOutputStream f4894d;

        C1056b(int i, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f4891a = byteArrayOutputStream;
            this.f4892b = new DataOutputStream(byteArrayOutputStream);
            this.f4893c = i;
            this.f4894d = dataOutputStream;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8492a() {
            this.f4892b.flush();
            int size = this.f4891a.size();
            this.f4894d.writeInt((this.f4893c << 16) | (size >= 65535 ? SupportMenu.USER_MASK : size));
            if (size >= 65535) {
                this.f4894d.writeInt(size);
            }
            this.f4891a.writeTo(this.f4894d);
        }
    }

    public C1054b(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    /* renamed from: m */
    private void m3818m(int i, String str, Bundle bundle) {
        switch (i) {
            case 0:
                bundle.putParcelable(str, (Parcelable) null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) readArray(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, readIntArray());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, readLongArray());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                return;
            default:
                throw new RuntimeException("Unknown type " + i);
        }
    }

    /* renamed from: n */
    private void m3819n(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    public void closeField() {
        C1056b bVar = this.f4885e;
        if (bVar != null) {
            try {
                if (bVar.f4891a.size() != 0) {
                    this.f4885e.mo8492a();
                }
                this.f4885e = null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel createSubParcel() {
        return new C1054b(this.f4883c, this.f4884d, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    public boolean isStream() {
        return true;
    }

    public boolean readBoolean() {
        try {
            return this.f4883c.readBoolean();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i = 0; i < readInt; i++) {
            m3818m(readInt(), readString(), bundle);
        }
        return bundle;
    }

    public byte[] readByteArray() {
        try {
            int readInt = this.f4883c.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f4883c.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    /* access modifiers changed from: protected */
    public CharSequence readCharSequence() {
        return null;
    }

    public double readDouble() {
        try {
            return this.f4883c.readDouble();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public boolean readField(int i) {
        while (true) {
            try {
                int i2 = this.f4888h;
                if (i2 == i) {
                    return true;
                }
                if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                    return false;
                }
                int i3 = this.f4887g;
                int i4 = this.f4889i;
                if (i3 < i4) {
                    this.f4881a.skip((long) (i4 - i3));
                }
                this.f4889i = -1;
                int readInt = this.f4881a.readInt();
                this.f4887g = 0;
                int i5 = readInt & SupportMenu.USER_MASK;
                if (i5 == 65535) {
                    i5 = this.f4881a.readInt();
                }
                this.f4888h = (readInt >> 16) & SupportMenu.USER_MASK;
                this.f4889i = i5;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public float readFloat() {
        try {
            return this.f4883c.readFloat();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public int readInt() {
        try {
            return this.f4883c.readInt();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public long readLong() {
        try {
            return this.f4883c.readLong();
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    public String readString() {
        try {
            int readInt = this.f4883c.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f4883c.readFully(bArr);
            return new String(bArr, f4880j);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int i) {
        closeField();
        C1056b bVar = new C1056b(i, this.f4882b);
        this.f4885e = bVar;
        this.f4884d = bVar.f4892b;
    }

    public void setSerializationFlags(boolean z, boolean z2) {
        if (z) {
            this.f4886f = z2;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public void writeBoolean(boolean z) {
        try {
            this.f4884d.writeBoolean(z);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public void writeBundle(Bundle bundle) {
        if (bundle != null) {
            try {
                Set<String> keySet = bundle.keySet();
                this.f4884d.writeInt(keySet.size());
                for (String str : keySet) {
                    writeString(str);
                    m3819n(bundle.get(str));
                }
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        } else {
            this.f4884d.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] bArr) {
        if (bArr != null) {
            try {
                this.f4884d.writeInt(bArr.length);
                this.f4884d.write(bArr);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        } else {
            this.f4884d.writeInt(-1);
        }
    }

    /* access modifiers changed from: protected */
    public void writeCharSequence(CharSequence charSequence) {
        if (!this.f4886f) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    public void writeDouble(double d) {
        try {
            this.f4884d.writeDouble(d);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public void writeFloat(float f) {
        try {
            this.f4884d.writeFloat(f);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public void writeInt(int i) {
        try {
            this.f4884d.writeInt(i);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public void writeLong(long j) {
        try {
            this.f4884d.writeLong(j);
        } catch (IOException e) {
            throw new VersionedParcel.ParcelException(e);
        }
    }

    public void writeParcelable(Parcelable parcelable) {
        if (!this.f4886f) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void writeString(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(f4880j);
                this.f4884d.writeInt(bytes.length);
                this.f4884d.write(bytes);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        } else {
            this.f4884d.writeInt(-1);
        }
    }

    public void writeStrongBinder(IBinder iBinder) {
        if (!this.f4886f) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    public void writeStrongInterface(IInterface iInterface) {
        if (!this.f4886f) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    private C1054b(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f4887g = 0;
        this.f4888h = -1;
        this.f4889i = -1;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new C1055a(inputStream)) : null;
        this.f4881a = dataInputStream;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.f4882b = dataOutputStream;
        this.f4883c = dataInputStream;
        this.f4884d = dataOutputStream;
    }

    /* renamed from: androidx.versionedparcelable.b$a */
    /* compiled from: VersionedParcelStream */
    class C1055a extends FilterInputStream {
        C1055a(InputStream inputStream) {
            super(inputStream);
        }

        public int read() {
            C1054b bVar = C1054b.this;
            int i = bVar.f4889i;
            if (i == -1 || bVar.f4887g < i) {
                int read = super.read();
                C1054b.this.f4887g++;
                return read;
            }
            throw new IOException();
        }

        public long skip(long j) {
            C1054b bVar = C1054b.this;
            int i = bVar.f4889i;
            if (i == -1 || bVar.f4887g < i) {
                long skip = super.skip(j);
                if (skip > 0) {
                    C1054b.this.f4887g += (int) skip;
                }
                return skip;
            }
            throw new IOException();
        }

        public int read(byte[] bArr, int i, int i2) {
            C1054b bVar = C1054b.this;
            int i3 = bVar.f4889i;
            if (i3 == -1 || bVar.f4887g < i3) {
                int read = super.read(bArr, i, i2);
                if (read > 0) {
                    C1054b.this.f4887g += read;
                }
                return read;
            }
            throw new IOException();
        }
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            try {
                this.f4884d.writeInt(i2);
                this.f4884d.write(bArr, i, i2);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        } else {
            this.f4884d.writeInt(-1);
        }
    }
}
