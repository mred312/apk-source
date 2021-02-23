package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdnp {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public zzvk f15792a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzvn f15793b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public zzxu f15794c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f15795d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzaak f15796e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f15797f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<String> f15798g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<String> f15799h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public zzadz f15800i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public zzvw f15801j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public PublisherAdViewOptions f15802k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l */
    public zzxo f15803l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f15804m = 1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public zzajl f15805n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public zzdnc f15806o = new zzdnc();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f15807p = false;

    public final zzvk zzaup() {
        return this.f15792a;
    }

    public final String zzauq() {
        return this.f15795d;
    }

    public final zzdnc zzaur() {
        return this.f15806o;
    }

    public final zzdnn zzaus() {
        Preconditions.checkNotNull(this.f15795d, "ad unit must not be null");
        Preconditions.checkNotNull(this.f15793b, "ad size must not be null");
        Preconditions.checkNotNull(this.f15792a, "ad request must not be null");
        return new zzdnn(this);
    }

    public final boolean zzaut() {
        return this.f15807p;
    }

    public final zzdnp zzb(zzadz zzadz) {
        this.f15800i = zzadz;
        return this;
    }

    public final zzdnp zzbn(boolean z) {
        this.f15807p = z;
        return this;
    }

    public final zzdnp zzbo(boolean z) {
        this.f15797f = z;
        return this;
    }

    public final zzdnp zzc(zzxu zzxu) {
        this.f15794c = zzxu;
        return this;
    }

    public final zzdnp zzd(ArrayList<String> arrayList) {
        this.f15799h = arrayList;
        return this;
    }

    public final zzdnp zzee(int i) {
        this.f15804m = i;
        return this;
    }

    public final zzdnp zzf(zzvn zzvn) {
        this.f15793b = zzvn;
        return this;
    }

    public final zzdnp zzgq(String str) {
        this.f15795d = str;
        return this;
    }

    public final zzdnp zzh(zzvk zzvk) {
        this.f15792a = zzvk;
        return this;
    }

    public final zzvn zzkf() {
        return this.f15793b;
    }

    public final zzdnp zzb(zzvw zzvw) {
        this.f15801j = zzvw;
        return this;
    }

    public final zzdnp zzc(zzaak zzaak) {
        this.f15796e = zzaak;
        return this;
    }

    public final zzdnp zzb(zzajl zzajl) {
        this.f15805n = zzajl;
        this.f15796e = new zzaak(false, true, false);
        return this;
    }

    public final zzdnp zzc(ArrayList<String> arrayList) {
        this.f15798g = arrayList;
        return this;
    }

    public final zzdnp zzc(zzdnn zzdnn) {
        this.f15806o.zza(zzdnn.zzhiv);
        this.f15792a = zzdnn.zzhio;
        this.f15793b = zzdnn.zzbpe;
        this.f15794c = zzdnn.zzhim;
        this.f15795d = zzdnn.zzhip;
        this.f15796e = zzdnn.zzhin;
        this.f15798g = zzdnn.zzhiq;
        this.f15799h = zzdnn.zzhir;
        this.f15800i = zzdnn.zzdnh;
        this.f15801j = zzdnn.zzhis;
        zzdnp zzb = zzb(zzdnn.zzhit);
        zzb.f15807p = zzdnn.zzgyj;
        return zzb;
    }

    public final zzdnp zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.f15802k = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.f15797f = publisherAdViewOptions.getManualImpressionsEnabled();
            this.f15803l = publisherAdViewOptions.zzju();
        }
        return this;
    }
}
