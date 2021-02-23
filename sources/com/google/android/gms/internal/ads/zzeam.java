package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.ads.zzefr;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeam<P> {

    /* renamed from: d */
    private static final Charset f16102d = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: a */
    private ConcurrentMap<String, List<zzeal<P>>> f16103a = new ConcurrentHashMap();

    /* renamed from: b */
    private zzeal<P> f16104b;

    /* renamed from: c */
    private final Class<P> f16105c;

    private zzeam(Class<P> cls) {
        this.f16105c = cls;
    }

    public static <P> zzeam<P> zza(Class<P> cls) {
        return new zzeam<>(cls);
    }

    public final Class<P> zzazr() {
        return this.f16105c;
    }

    public final zzeal<P> zzbae() {
        return this.f16104b;
    }

    public final void zza(zzeal<P> zzeal) {
        if (zzeal == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzeal.zzbab() == zzefl.ENABLED) {
            List list = (List) this.f16103a.get(new String(zzeal.zzbad(), f16102d));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.f16104b = zzeal;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final zzeal<P> zza(P p, zzefr.zza zza) {
        byte[] bArr;
        if (zza.zzbab() == zzefl.ENABLED) {
            int i = f40.f8426a[zza.zzbac().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zza.zzbdy()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zza.zzbdy()).array();
            } else if (i == 4) {
                bArr = zzdzv.zzhyf;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzeal zzeal = new zzeal(p, bArr, zza.zzbab(), zza.zzbac(), zza.zzbdy());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzeal);
            String str = new String(zzeal.zzbad(), f16102d);
            List list = (List) this.f16103a.put(str, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzeal);
                this.f16103a.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzeal;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }
}
