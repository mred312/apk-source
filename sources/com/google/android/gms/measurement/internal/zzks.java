package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzjk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzks extends C3071o7 {
    zzks(zzki zzki) {
        super(zzki);
    }

    /* renamed from: A */
    static boolean m10955A(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    /* renamed from: B */
    static Object m10956B(zzcd.zzc zzc, String str) {
        zzcd.zze f = m10958f(zzc, str);
        if (f == null) {
            return null;
        }
        if (f.zzc()) {
            return f.zzd();
        }
        if (f.zze()) {
            return Long.valueOf(f.zzf());
        }
        if (f.zzi()) {
            return Double.valueOf(f.zzj());
        }
        if (f.zzl() <= 0) {
            return null;
        }
        List<zzcd.zze> zzk = f.zzk();
        ArrayList arrayList = new ArrayList();
        for (zzcd.zze next : zzk) {
            if (next != null) {
                Bundle bundle = new Bundle();
                for (zzcd.zze next2 : next.zzk()) {
                    if (next2.zzc()) {
                        bundle.putString(next2.zzb(), next2.zzd());
                    } else if (next2.zze()) {
                        bundle.putLong(next2.zzb(), next2.zzf());
                    } else if (next2.zzi()) {
                        bundle.putDouble(next2.zzb(), next2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* renamed from: b */
    static int m10957b(zzcd.zzg.zza zza, String str) {
        if (zza == null) {
            return -1;
        }
        for (int i = 0; i < zza.zze(); i++) {
            if (str.equals(zza.zzd(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: f */
    static zzcd.zze m10958f(zzcd.zzc zzc, String str) {
        for (zzcd.zze next : zzc.zza()) {
            if (next.zzb().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: g */
    static <Builder extends zzjk> Builder m10959g(Builder builder, byte[] bArr) {
        zzhm zzb = zzhm.zzb();
        if (zzb != null) {
            return builder.zza(bArr, zzb);
        }
        return builder.zza(bArr);
    }

    /* renamed from: k */
    private static String m10960k(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* renamed from: l */
    static List<Long> m10961l(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* renamed from: n */
    private static List<zzcd.zze> m10962n(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzcd.zze.zza zzm = zzcd.zze.zzm();
                for (String str : bundle.keySet()) {
                    zzcd.zze.zza zza = zzcd.zze.zzm().zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zza.zza(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zza.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zza.zza(((Double) obj).doubleValue());
                    }
                    zzm.zza(zza);
                }
                if (zzm.zzd() > 0) {
                    arrayList.add((zzcd.zze) ((zzhz) zzm.zzz()));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    static void m10963o(zzcd.zzc.zza zza, String str, Object obj) {
        List<zzcd.zze> zza2 = zza.zza();
        int i = 0;
        while (true) {
            if (i >= zza2.size()) {
                i = -1;
                break;
            } else if (str.equals(zza2.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzcd.zze.zza zza3 = zzcd.zze.zzm().zza(str);
        if (obj instanceof Long) {
            zza3.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza3.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza3.zza(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zza3.zza((Iterable<? extends zzcd.zze>) m10962n((Bundle[]) obj));
        }
        if (i >= 0) {
            zza.zza(i, zza3);
        } else {
            zza.zza(zza3);
        }
    }

    /* renamed from: r */
    private static void m10964r(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    /* renamed from: s */
    private final void m10965s(StringBuilder sb, int i, zzbv.zzc zzc) {
        if (zzc != null) {
            m10964r(sb, i);
            sb.append("filter {\n");
            if (zzc.zze()) {
                m10968v(sb, i, "complement", Boolean.valueOf(zzc.zzf()));
            }
            if (zzc.zzg()) {
                m10968v(sb, i, "param_name", zzn().zzb(zzc.zzh()));
            }
            if (zzc.zza()) {
                int i2 = i + 1;
                zzbv.zzf zzb = zzc.zzb();
                if (zzb != null) {
                    m10964r(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (zzb.zza()) {
                        m10968v(sb, i2, "match_type", zzb.zzb().name());
                    }
                    if (zzb.zzc()) {
                        m10968v(sb, i2, "expression", zzb.zzd());
                    }
                    if (zzb.zze()) {
                        m10968v(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        m10964r(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String append : zzb.zzg()) {
                            m10964r(sb, i2 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    m10964r(sb, i2);
                    sb.append("}\n");
                }
            }
            if (zzc.zzc()) {
                m10966t(sb, i + 1, "number_filter", zzc.zzd());
            }
            m10964r(sb, i);
            sb.append("}\n");
        }
    }

    /* renamed from: t */
    private static void m10966t(StringBuilder sb, int i, String str, zzbv.zzd zzd) {
        if (zzd != null) {
            m10964r(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zza()) {
                m10968v(sb, i, "comparison_type", zzd.zzb().name());
            }
            if (zzd.zzc()) {
                m10968v(sb, i, "match_as_float", Boolean.valueOf(zzd.zzd()));
            }
            if (zzd.zze()) {
                m10968v(sb, i, "comparison_value", zzd.zzf());
            }
            if (zzd.zzg()) {
                m10968v(sb, i, "min_comparison_value", zzd.zzh());
            }
            if (zzd.zzi()) {
                m10968v(sb, i, "max_comparison_value", zzd.zzj());
            }
            m10964r(sb, i);
            sb.append("}\n");
        }
    }

    /* renamed from: u */
    private static void m10967u(StringBuilder sb, int i, String str, zzcd.zzi zzi, String str2) {
        if (zzi != null) {
            m10964r(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzi.zzd() != 0) {
                m10964r(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long next : zzi.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzi.zzb() != 0) {
                m10964r(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long next2 : zzi.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzi.zzf() != 0) {
                m10964r(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzcd.zzb next3 : zzi.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next3.zza() ? Integer.valueOf(next3.zzb()) : null);
                    sb.append(":");
                    sb.append(next3.zzc() ? Long.valueOf(next3.zzd()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzi.zzh() != 0) {
                m10964r(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzcd.zzj next4 : zzi.zzg()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next4.zza() ? Integer.valueOf(next4.zzb()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : next4.zzc()) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            m10964r(sb, 3);
            sb.append("}\n");
        }
    }

    /* renamed from: v */
    private static void m10968v(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            m10964r(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* renamed from: w */
    private final void m10969w(StringBuilder sb, int i, List<zzcd.zze> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzcd.zze next : list) {
                if (next != null) {
                    m10964r(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    m10968v(sb, i2, "name", next.zza() ? zzn().zzb(next.zzb()) : null);
                    m10968v(sb, i2, "string_value", next.zzc() ? next.zzd() : null);
                    m10968v(sb, i2, "int_value", next.zze() ? Long.valueOf(next.zzf()) : null);
                    if (next.zzi()) {
                        d = Double.valueOf(next.zzj());
                    }
                    m10968v(sb, i2, "double_value", d);
                    if (next.zzl() > 0) {
                        m10969w(sb, i2, next.zzk());
                    }
                    m10964r(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    @WorkerThread
    /* renamed from: y */
    static boolean m10970y(zzar zzar, zzn zzn) {
        Preconditions.checkNotNull(zzar);
        Preconditions.checkNotNull(zzn);
        return !TextUtils.isEmpty(zzn.zzb) || !TextUtils.isEmpty(zzn.zzr);
    }

    /* renamed from: z */
    static boolean m10971z(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public final byte[] mo20539C(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzq().zze().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public final byte[] mo20540D(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzq().zze().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: E */
    public final List<Integer> mo20541E() {
        Map<String, String> zza = zzat.zza(this.zza.zzm());
        if (zza == null || zza.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzat.zzao.zza(null).intValue();
        Iterator<Map.Entry<String, String>> it = zza.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((String) next.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzq().zzh().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzq().zzh().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: c */
    public final long mo20542c(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzo().zzc();
        MessageDigest X = zzkw.m10998X();
        if (X != null) {
            return zzkw.m11001e(X.digest(bArr));
        }
        zzq().zze().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzq().zze().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T mo20543d(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.zzer r5 = r4.zzq()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zze()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.mo20543d(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final zzcd.zzc mo20544e(zzak zzak) {
        zzcd.zzc.zza zzb = zzcd.zzc.zzj().zzb(zzak.f18502e);
        Iterator<String> it = zzak.f18503f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzcd.zze.zza zza = zzcd.zze.zzm().zza(next);
            mo20549p(zza, zzak.f18503f.mo20239b(next));
            zzb.zza(zza);
        }
        return (zzcd.zzc) ((zzhz) zzb.zzz());
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzks mo20059f_() {
        return super.mo20059f_();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final String mo20545h(zzbv.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzb.zza()) {
            m10968v(sb, 0, "filter_id", Integer.valueOf(zzb.zzb()));
        }
        m10968v(sb, 0, "event_name", zzn().zza(zzb.zzc()));
        String k = m10960k(zzb.zzh(), zzb.zzi(), zzb.zzk());
        if (!k.isEmpty()) {
            m10968v(sb, 0, "filter_type", k);
        }
        if (zzb.zzf()) {
            m10966t(sb, 1, "event_count_filter", zzb.zzg());
        }
        if (zzb.zze() > 0) {
            sb.append("  filters {\n");
            for (zzbv.zzc s : zzb.zzd()) {
                m10965s(sb, 2, s);
            }
        }
        m10964r(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final String mo20546i(zzbv.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zze.zza()) {
            m10968v(sb, 0, "filter_id", Integer.valueOf(zze.zzb()));
        }
        m10968v(sb, 0, "property_name", zzn().zzc(zze.zzc()));
        String k = m10960k(zze.zze(), zze.zzf(), zze.zzh());
        if (!k.isEmpty()) {
            m10968v(sb, 0, "filter_type", k);
        }
        m10965s(sb, 1, zze.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final String mo20547j(zzcd.zzf zzf) {
        if (zzf == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzcd.zzg next : zzf.zza()) {
            if (next != null) {
                m10964r(sb, 1);
                sb.append("bundle {\n");
                if (next.zza()) {
                    m10968v(sb, 1, "protocol_version", Integer.valueOf(next.zzb()));
                }
                m10968v(sb, 1, "platform", next.zzq());
                if (next.zzz()) {
                    m10968v(sb, 1, "gmp_version", Long.valueOf(next.mo19221h_()));
                }
                if (next.zzab()) {
                    m10968v(sb, 1, "uploading_gmp_version", Long.valueOf(next.zzac()));
                }
                if (next.zzbc()) {
                    m10968v(sb, 1, "dynamite_version", Long.valueOf(next.zzbd()));
                }
                if (next.zzau()) {
                    m10968v(sb, 1, "config_version", Long.valueOf(next.zzav()));
                }
                m10968v(sb, 1, "gmp_app_id", next.zzam());
                m10968v(sb, 1, "admob_app_id", next.zzbb());
                m10968v(sb, 1, "app_id", next.zzx());
                m10968v(sb, 1, "app_version", next.zzy());
                if (next.zzar()) {
                    m10968v(sb, 1, "app_version_major", Integer.valueOf(next.zzas()));
                }
                m10968v(sb, 1, "firebase_instance_id", next.zzaq());
                if (next.zzah()) {
                    m10968v(sb, 1, "dev_cert_hash", Long.valueOf(next.zzai()));
                }
                m10968v(sb, 1, "app_store", next.zzw());
                if (next.zzg()) {
                    m10968v(sb, 1, "upload_timestamp_millis", Long.valueOf(next.zzh()));
                }
                if (next.zzi()) {
                    m10968v(sb, 1, "start_timestamp_millis", Long.valueOf(next.zzj()));
                }
                if (next.zzk()) {
                    m10968v(sb, 1, "end_timestamp_millis", Long.valueOf(next.zzl()));
                }
                if (next.zzm()) {
                    m10968v(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(next.zzn()));
                }
                if (next.zzo()) {
                    m10968v(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(next.zzp()));
                }
                m10968v(sb, 1, "app_instance_id", next.zzag());
                m10968v(sb, 1, "resettable_device_id", next.zzad());
                m10968v(sb, 1, "device_id", next.zzat());
                m10968v(sb, 1, "ds_id", next.zzay());
                if (next.zzae()) {
                    m10968v(sb, 1, "limited_ad_tracking", Boolean.valueOf(next.zzaf()));
                }
                m10968v(sb, 1, "os_version", next.zzr());
                m10968v(sb, 1, "device_model", next.zzs());
                m10968v(sb, 1, "user_default_language", next.zzt());
                if (next.zzu()) {
                    m10968v(sb, 1, "time_zone_offset_minutes", Integer.valueOf(next.zzv()));
                }
                if (next.zzaj()) {
                    m10968v(sb, 1, "bundle_sequential_index", Integer.valueOf(next.zzak()));
                }
                if (next.zzan()) {
                    m10968v(sb, 1, "service_upload", Boolean.valueOf(next.zzao()));
                }
                m10968v(sb, 1, "health_monitor", next.zzal());
                if (!zzs().zza(zzat.zzbx) && next.zzaw() && next.zzax() != 0) {
                    m10968v(sb, 1, "android_id", Long.valueOf(next.zzax()));
                }
                if (next.zzaz()) {
                    m10968v(sb, 1, "retry_counter", Integer.valueOf(next.zzba()));
                }
                if (next.zzbf()) {
                    m10968v(sb, 1, "consent_signals", next.zzbg());
                }
                List<zzcd.zzk> zze = next.zze();
                if (zze != null) {
                    for (zzcd.zzk next2 : zze) {
                        if (next2 != null) {
                            m10964r(sb, 2);
                            sb.append("user_property {\n");
                            Double d = null;
                            m10968v(sb, 2, "set_timestamp_millis", next2.zza() ? Long.valueOf(next2.zzb()) : null);
                            m10968v(sb, 2, "name", zzn().zzc(next2.zzc()));
                            m10968v(sb, 2, "string_value", next2.zze());
                            m10968v(sb, 2, "int_value", next2.zzf() ? Long.valueOf(next2.zzg()) : null);
                            if (next2.zzh()) {
                                d = Double.valueOf(next2.zzi());
                            }
                            m10968v(sb, 2, "double_value", d);
                            m10964r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzcd.zza> zzap = next.zzap();
                String zzx = next.zzx();
                if (zzap != null) {
                    for (zzcd.zza next3 : zzap) {
                        if (next3 != null) {
                            m10964r(sb, 2);
                            sb.append("audience_membership {\n");
                            if (next3.zza()) {
                                m10968v(sb, 2, "audience_id", Integer.valueOf(next3.zzb()));
                            }
                            if (next3.zzf()) {
                                m10968v(sb, 2, "new_audience", Boolean.valueOf(next3.zzg()));
                            }
                            m10967u(sb, 2, "current_data", next3.zzc(), zzx);
                            if (next3.zzd()) {
                                m10967u(sb, 2, "previous_data", next3.zze(), zzx);
                            }
                            m10964r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzcd.zzc> zzc = next.zzc();
                if (zzc != null) {
                    for (zzcd.zzc next4 : zzc) {
                        if (next4 != null) {
                            m10964r(sb, 2);
                            sb.append("event {\n");
                            m10968v(sb, 2, "name", zzn().zza(next4.zzc()));
                            if (next4.zzd()) {
                                m10968v(sb, 2, "timestamp_millis", Long.valueOf(next4.zze()));
                            }
                            if (next4.zzf()) {
                                m10968v(sb, 2, "previous_timestamp_millis", Long.valueOf(next4.zzg()));
                            }
                            if (next4.zzh()) {
                                m10968v(sb, 2, "count", Integer.valueOf(next4.zzi()));
                            }
                            if (next4.zzb() != 0) {
                                m10969w(sb, 2, next4.zza());
                            }
                            m10964r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                m10964r(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final List<Long> mo20548m(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                zzq().zzh().zza("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzq().zzh().zza("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (next.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final void mo20549p(zzcd.zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc().zze();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zza.zza((Iterable<? extends zzcd.zze>) m10962n((Bundle[]) obj));
        } else {
            zzq().zze().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final void mo20550q(zzcd.zzk.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zzb(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzq().zze().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public final boolean mo20551x(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzl().currentTimeMillis() - j) > j2;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    public final /* bridge */ /* synthetic */ zzjo zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ C2939a8 zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ C2950c zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfp zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}
