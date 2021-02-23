package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzr extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdru;
    private final zzz zzdrv;

    public zzr(Context context, zzq zzq, @Nullable zzz zzz) {
        super(context);
        this.zzdrv = zzz;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zzdru = imageButton;
        imageButton.setImageResource(17301527);
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzwq.zzqa();
        int zzc = zzayr.zzc(context, zzq.paddingLeft);
        zzwq.zzqa();
        int zzc2 = zzayr.zzc(context, 0);
        zzwq.zzqa();
        int zzc3 = zzayr.zzc(context, zzq.paddingRight);
        zzwq.zzqa();
        imageButton.setPadding(zzc, zzc2, zzc3, zzayr.zzc(context, zzq.paddingBottom));
        imageButton.setContentDescription("Interstitial close button");
        zzwq.zzqa();
        int zzc4 = zzayr.zzc(context, zzq.size + zzq.paddingLeft + zzq.paddingRight);
        zzwq.zzqa();
        addView(imageButton, new FrameLayout.LayoutParams(zzc4, zzayr.zzc(context, zzq.size + zzq.paddingBottom), 17));
    }

    public final void onClick(View view) {
        zzz zzz = this.zzdrv;
        if (zzz != null) {
            zzz.zzvd();
        }
    }

    public final void zzal(boolean z) {
        if (z) {
            this.zzdru.setVisibility(8);
        } else {
            this.zzdru.setVisibility(0);
        }
    }
}
