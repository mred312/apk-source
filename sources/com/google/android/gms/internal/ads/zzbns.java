package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbns extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    private final Context f13554a;

    /* renamed from: b */
    private View f13555b;

    private zzbns(Context context) {
        super(context);
        this.f13554a = context;
    }

    /* renamed from: a */
    private final void m7825a(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.f13554a);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int b = m7826b(jSONObject.optDouble("padding", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        textView.setPadding(0, b, 0, b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, m7826b(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    /* renamed from: b */
    private final int m7826b(double d) {
        zzwq.zzqa();
        return zzayr.zzc(this.f13554a, (int) d);
    }

    public static zzbns zza(Context context, View view, zzdmu zzdmu) {
        zzbns zzbns = new zzbns(context);
        zzbns.f13555b = view;
        zzbns.addView(view);
        zzp.zzln();
        zzazy.zza((View) zzbns, (ViewTreeObserver.OnScrollChangedListener) zzbns);
        zzp.zzln();
        zzazy.zza((View) zzbns, (ViewTreeObserver.OnGlobalLayoutListener) zzbns);
        JSONObject jSONObject = zzdmu.zzhhp;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbns.f13554a);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                zzbns.m7825a(optJSONObject, relativeLayout, 10);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
            if (optJSONObject2 != null) {
                zzbns.m7825a(optJSONObject2, relativeLayout, 12);
            }
            zzbns.addView(relativeLayout);
        }
        return zzbns;
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.f13555b.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.f13555b.setY((float) (-iArr[1]));
    }
}
