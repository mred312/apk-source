package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbm implements zzdfi<zzdbn> {

    /* renamed from: a */
    private final zzdzc f15180a;

    /* renamed from: b */
    private final Context f15181b;

    public zzdbm(zzdzc zzdzc, Context context) {
        this.f15180a = zzdzc;
        this.f15181b = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdbn mo17076a() {
        AudioManager audioManager = (AudioManager) this.f15181b.getSystemService("audio");
        return new zzdbn(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzp.zzkv().zzqk(), zzp.zzkv().zzql());
    }

    public final zzdyz<zzdbn> zzasm() {
        return this.f15180a.zze(new C1780bt(this));
    }
}
