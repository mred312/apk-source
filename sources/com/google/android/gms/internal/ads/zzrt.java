package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzrt {

    /* renamed from: a */
    private final int f16961a;

    /* renamed from: b */
    private final int f16962b;

    /* renamed from: c */
    private final zzrq f16963c = new zzrx();

    public zzrt(int i) {
        this.f16962b = i;
        this.f16961a = 6;
    }

    @VisibleForTesting
    /* renamed from: a */
    private final String m9092a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        uh0 uh0 = new uh0();
        PriorityQueue priorityQueue = new PriorityQueue(this.f16962b, new th0(this));
        for (String zze : split) {
            String[] zze2 = zzru.zze(zze, false);
            if (zze2.length != 0) {
                zzrz.zza(zze2, this.f16962b, this.f16961a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                uh0.mo14883a(this.f16963c.zzbp(((zzry) it.next()).f16966b));
            } catch (IOException e) {
                zzaza.zzc("Error while writing hash to byteStream", e);
            }
        }
        return uh0.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            String str = arrayList.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append(10);
        }
        return m9092a(sb.toString());
    }
}
