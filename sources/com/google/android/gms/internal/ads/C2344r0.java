package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zzbf;

/* renamed from: com.google.android.gms.internal.ads.r0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2344r0 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final zzahz f10745a;

    /* renamed from: b */
    private final Context f10746b;

    /* renamed from: c */
    private final String f10747c;

    /* renamed from: d */
    private final zzbf f10748d;

    /* renamed from: e */
    private final String f10749e;

    /* renamed from: f */
    private final Resources f10750f;

    C2344r0(zzahz zzahz, Context context, String str, zzbf zzbf, String str2, Resources resources) {
        this.f10745a = zzahz;
        this.f10746b = context;
        this.f10747c = str;
        this.f10748d = zzbf;
        this.f10749e = str2;
        this.f10750f = resources;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10745a.mo15346b(this.f10746b, this.f10747c, this.f10748d, this.f10749e, this.f10750f, dialogInterface, i);
    }
}
