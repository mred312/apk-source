package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbbj implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    private final AudioManager f13073a;

    /* renamed from: b */
    private final C1906f7 f13074b;

    /* renamed from: c */
    private boolean f13075c;

    /* renamed from: d */
    private boolean f13076d;

    /* renamed from: e */
    private boolean f13077e;

    /* renamed from: f */
    private float f13078f = 1.0f;

    public zzbbj(Context context, C1906f7 f7Var) {
        this.f13073a = (AudioManager) context.getSystemService("audio");
        this.f13074b = f7Var;
    }

    /* renamed from: a */
    private final void m7667a() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = this.f13076d && !this.f13077e && this.f13078f > 0.0f;
        if (z4 && !(z2 = this.f13075c)) {
            AudioManager audioManager = this.f13073a;
            if (audioManager != null && !z2) {
                if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                    z3 = true;
                }
                this.f13075c = z3;
            }
            this.f13074b.zzzq();
        } else if (!z4 && (z = this.f13075c)) {
            AudioManager audioManager2 = this.f13073a;
            if (audioManager2 != null && z) {
                if (audioManager2.abandonAudioFocus(this) == 0) {
                    z3 = true;
                }
                this.f13075c = z3;
            }
            this.f13074b.zzzq();
        }
    }

    public final float getVolume() {
        float f = this.f13077e ? 0.0f : this.f13078f;
        if (this.f13075c) {
            return f;
        }
        return 0.0f;
    }

    public final void onAudioFocusChange(int i) {
        this.f13075c = i > 0;
        this.f13074b.zzzq();
    }

    public final void setMuted(boolean z) {
        this.f13077e = z;
        m7667a();
    }

    public final void setVolume(float f) {
        this.f13078f = f;
        m7667a();
    }

    public final void zzaat() {
        this.f13076d = true;
        m7667a();
    }

    public final void zzaau() {
        this.f13076d = false;
        m7667a();
    }
}
