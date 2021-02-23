package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzein;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public abstract class zzeik<MessageType extends zzeik<MessageType, BuilderType>, BuilderType extends zzein<MessageType, BuilderType>> implements zzels {
    protected int zziij = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzekk.m8823a(iterable);
        if (iterable instanceof zzekz) {
            List<?> zzbiu = ((zzekz) iterable).zzbiu();
            zzekz zzekz = (zzekz) list;
            int size = list.size();
            for (Object next : zzbiu) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzekz.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzekz.size() - 1; size2 >= size; size2--) {
                        zzekz.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzeiu) {
                    zzekz.zzak((zzeiu) next);
                } else {
                    zzekz.add((String) next);
                }
            }
        } else if (iterable instanceof na0) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo17586a() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo17587b(int i) {
        throw new UnsupportedOperationException();
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbhz()];
            zzejo zzv = zzejo.zzv(bArr);
            zzb(zzv);
            zzv.zzbhb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final zzeiu zzbfg() {
        try {
            q80 e = zzeiu.m8789e(zzbhz());
            zzb(e.mo14642b());
            return e.mo14641a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }
}
