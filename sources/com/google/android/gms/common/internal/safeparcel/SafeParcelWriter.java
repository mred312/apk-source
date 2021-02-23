package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    /* renamed from: a */
    private static int m5310a(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: b */
    private static void m5311b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    public static int beginObjectHeader(Parcel parcel) {
        return m5310a(parcel, 20293);
    }

    /* renamed from: c */
    private static <T extends Parcelable> void m5312c(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: d */
    private static void m5313d(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void finishObjectHeader(Parcel parcel, int i) {
        m5313d(parcel, i);
    }

    public static void writeBigDecimal(Parcel parcel, int i, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal != null) {
            int a = m5310a(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr != null) {
            int a = m5310a(parcel, i);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i2].scale());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBigInteger(Parcel parcel, int i, BigInteger bigInteger, boolean z) {
        if (bigInteger != null) {
            int a = m5310a(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBoolean(Parcel parcel, int i, boolean z) {
        m5311b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int i, boolean[] zArr, boolean z) {
        if (zArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeBooleanArray(zArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i, List<Boolean> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).booleanValue() ? 1 : 0);
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            m5311b(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int a = m5310a(parcel, i);
            parcel.writeBundle(bundle);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i, byte b) {
        m5311b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeByteArray(bArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i, byte[][] bArr, boolean z) {
        if (bArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeByteArray(sparseArray.valueAt(i2));
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeChar(Parcel parcel, int i, char c) {
        m5311b(parcel, i, 4);
        parcel.writeInt(c);
    }

    public static void writeCharArray(Parcel parcel, int i, char[] cArr, boolean z) {
        if (cArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeCharArray(cArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i, double d) {
        m5311b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(Parcel parcel, int i, double[] dArr, boolean z) {
        if (dArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeDoubleArray(dArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i, List<Double> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeDouble(list.get(i2).doubleValue());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            m5311b(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeDouble(sparseArray.valueAt(i2).doubleValue());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i, float f) {
        m5311b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeFloatArray(fArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i, List<Float> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeFloat(list.get(i2).floatValue());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeFloatObject(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            m5311b(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeFloat(sparseArray.valueAt(i2).floatValue());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int a = m5310a(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i, List<IBinder> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            parcel.writeBinderList(list);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeStrongBinder(sparseArray.valueAt(i2));
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeInt(Parcel parcel, int i, int i2) {
        m5311b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeIntArray(iArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).intValue());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            m5311b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeList(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            parcel.writeList(list);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i, long j) {
        m5311b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(Parcel parcel, int i, long[] jArr, boolean z) {
        if (jArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeLongArray(jArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i, List<Long> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(list.get(i2).longValue());
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeLongObject(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m5311b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int a = m5310a(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i, Parcel[] parcelArr, boolean z) {
        if (parcelArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeParcelList(Parcel parcel, int i, List<Parcel> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcel parcel2 = list.get(i2);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                Parcel valueAt = sparseArray.valueAt(i2);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a = m5310a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i, short s) {
        m5311b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray != null) {
            int a = m5310a(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseIntArray.keyAt(i2));
                parcel.writeInt(sparseIntArray.valueAt(i2));
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseLongArray.keyAt(i2));
                parcel.writeLong(sparseLongArray.valueAt(i2));
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int a = m5310a(parcel, i);
            parcel.writeString(str);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeStringArray(strArr);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            parcel.writeStringList(list);
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeString(sparseArray.valueAt(i2));
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int a = m5310a(parcel, i);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m5312c(parcel, t, i2);
                }
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int a = m5310a(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m5312c(parcel, parcelable, 0);
                }
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a = m5310a(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m5312c(parcel, parcelable, 0);
                }
            }
            m5313d(parcel, a);
        } else if (z) {
            m5311b(parcel, i, 0);
        }
    }
}
