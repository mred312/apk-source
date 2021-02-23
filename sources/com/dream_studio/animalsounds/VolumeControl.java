package com.dream_studio.animalsounds;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Vibrator;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class VolumeControl implements C1472e {
    public static final int INT_VOLUME_MAX = 100;
    public static final int INT_VOLUME_MIN = 0;
    public static final int VOLUME_CONTROL_VISIBILITY_TIME = 2500;

    /* renamed from: a */
    Context f6843a = null;

    /* renamed from: b */
    BaseActivity f6844b = null;

    /* renamed from: c */
    private HideVolumeControlAfterTime f6845c = null;

    /* renamed from: d */
    AudioManager f6846d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6847e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6848f;

    /* renamed from: g */
    private int f6849g = 100;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f6850h = false;

    /* renamed from: com.dream_studio.animalsounds.VolumeControl$a */
    class C1452a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SeekBar f6851a;

        /* renamed from: b */
        final /* synthetic */ ToggleButton f6852b;

        /* renamed from: c */
        final /* synthetic */ ToggleButton f6853c;

        /* renamed from: d */
        final /* synthetic */ RelativeLayout f6854d;

        C1452a(SeekBar seekBar, ToggleButton toggleButton, ToggleButton toggleButton2, RelativeLayout relativeLayout) {
            this.f6851a = seekBar;
            this.f6852b = toggleButton;
            this.f6853c = toggleButton2;
            this.f6854d = relativeLayout;
        }

        public void onClick(View view) {
            int i;
            boolean unused = VolumeControl.this.f6850h = true;
            if (!VolumeControl.this.m4931i()) {
                i = -VolumeControl.this.f6846d.getStreamVolume(3);
                VolumeControl.this.f6846d.setStreamVolume(3, 0, 0);
                this.f6851a.setProgress(0);
            } else {
                i = Math.abs(VolumeControl.restoreSysVolume(VolumeControl.this.f6843a));
                VolumeControl.this.f6846d.setStreamVolume(3, i, 0);
                this.f6851a.setProgress(i);
            }
            VolumeControl volumeControl = VolumeControl.this;
            boolean unused2 = volumeControl.f6847e = volumeControl.m4931i();
            ToggleButton toggleButton = this.f6852b;
            if (toggleButton != null) {
                toggleButton.setChecked(VolumeControl.this.f6847e);
            }
            this.f6853c.setChecked(VolumeControl.this.f6847e);
            VolumeControl.storeSysVolume(VolumeControl.this.f6843a, i);
            VolumeControl.this.m4932j(this.f6854d);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.VolumeControl$b */
    class C1453b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a */
        final /* synthetic */ ToggleButton f6856a;

        /* renamed from: b */
        final /* synthetic */ ToggleButton f6857b;

        /* renamed from: c */
        final /* synthetic */ RelativeLayout f6858c;

        C1453b(ToggleButton toggleButton, ToggleButton toggleButton2, RelativeLayout relativeLayout) {
            this.f6856a = toggleButton;
            this.f6857b = toggleButton2;
            this.f6858c = relativeLayout;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            VolumeControl.this.f6846d.setStreamVolume(3, i, 0);
            boolean c = VolumeControl.this.m4931i();
            Vibrator vibrator = (Vibrator) VolumeControl.this.f6843a.getSystemService("vibrator");
            if (VolumeControl.this.f6847e && !c) {
                if (VolumeControl.this.f6848f) {
                    VolumeControl.this.f6844b.toastTop((int) C1441R.string.mute_off);
                } else {
                    VolumeControl.this.f6844b.toastBottom((int) C1441R.string.mute_off);
                }
                vibrator.vibrate(new long[]{0, 100, 200}, -1);
            }
            if (!VolumeControl.this.f6847e && c) {
                if (VolumeControl.this.f6848f) {
                    VolumeControl.this.f6844b.toastTop((int) C1441R.string.mute_on);
                } else {
                    VolumeControl.this.f6844b.toastBottom((int) C1441R.string.mute_on);
                }
                vibrator.vibrate(100);
            }
            boolean unused = VolumeControl.this.f6847e = c;
            ToggleButton toggleButton = this.f6856a;
            if (toggleButton != null) {
                toggleButton.setChecked(VolumeControl.this.f6847e);
            }
            this.f6857b.setChecked(VolumeControl.this.f6847e);
            if (!z && !VolumeControl.this.f6850h) {
                VolumeControl.storeSysVolume(VolumeControl.this.f6843a, i);
            }
            VolumeControl.this.m4932j(this.f6858c);
            boolean unused2 = VolumeControl.this.f6850h = false;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            VolumeControl.storeSysVolume(VolumeControl.this.f6843a, seekBar.getProgress());
        }
    }

    public VolumeControl(Context context, boolean z) {
        this.f6843a = context;
        this.f6848f = z;
        BaseActivity baseActivity = (BaseActivity) context;
        this.f6844b = baseActivity;
        this.f6846d = (AudioManager) baseActivity.getSystemService("audio");
        this.f6847e = m4931i();
    }

    /* renamed from: h */
    private void m4930h() {
        HideVolumeControlAfterTime hideVolumeControlAfterTime = this.f6845c;
        if (hideVolumeControlAfterTime != null) {
            hideVolumeControlAfterTime.cancel(false);
        }
        this.f6845c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m4931i() {
        return this.f6846d.getStreamVolume(3) == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m4932j(RelativeLayout relativeLayout) {
        HideVolumeControlAfterTime hideVolumeControlAfterTime = this.f6845c;
        if (hideVolumeControlAfterTime != null) {
            hideVolumeControlAfterTime.cancel(false);
        }
        HideVolumeControlAfterTime hideVolumeControlAfterTime2 = new HideVolumeControlAfterTime();
        this.f6845c = hideVolumeControlAfterTime2;
        hideVolumeControlAfterTime2.execute(new Object[]{relativeLayout, Integer.valueOf(VOLUME_CONTROL_VISIBILITY_TIME)});
    }

    public static int restorePlayerVolume(Context context) {
        return context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getInt("PlayerVolume", 100);
    }

    public static int restoreSysVolume(Context context) {
        return context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getInt("SysVolume", 75);
    }

    public static void storePlayerVolume(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).edit();
        edit.putInt("PlayerVolume", i);
        edit.apply();
    }

    public static void storeSysVolume(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).edit();
        edit.putInt("SysVolume", i);
        edit.apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009b A[Catch:{ Exception -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void controlSysVolume(int r12, boolean r13, boolean r14) {
        /*
            r11 = this;
            com.dream_studio.animalsounds.BaseActivity r0 = r11.f6844b     // Catch:{ Exception -> 0x00a4 }
            r1 = 2131296552(0x7f090128, float:1.8211024E38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x00a4 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x00a4 }
            com.dream_studio.animalsounds.BaseActivity r1 = r11.f6844b     // Catch:{ Exception -> 0x00a4 }
            r2 = 2131296507(0x7f0900fb, float:1.8210933E38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x00a4 }
            r7 = r1
            android.widget.SeekBar r7 = (android.widget.SeekBar) r7     // Catch:{ Exception -> 0x00a4 }
            android.content.Context r1 = r11.f6843a     // Catch:{ Exception -> 0x00a4 }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x00a4 }
            r2 = 2131296437(0x7f0900b5, float:1.821079E38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x00a4 }
            r8 = r1
            android.widget.ToggleButton r8 = (android.widget.ToggleButton) r8     // Catch:{ Exception -> 0x00a4 }
            android.content.Context r1 = r11.f6843a     // Catch:{ Exception -> 0x00a4 }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x00a4 }
            r2 = 2131296508(0x7f0900fc, float:1.8210935E38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x00a4 }
            r9 = r1
            android.widget.ToggleButton r9 = (android.widget.ToggleButton) r9     // Catch:{ Exception -> 0x00a4 }
            if (r0 != 0) goto L_0x0036
            return
        L_0x0036:
            r11.setControlPlayerVolume()     // Catch:{ Exception -> 0x00a4 }
            android.media.AudioManager r1 = r11.f6846d     // Catch:{ Exception -> 0x00a4 }
            r2 = 3
            int r1 = r1.getStreamMaxVolume(r2)     // Catch:{ Exception -> 0x00a4 }
            r7.setMax(r1)     // Catch:{ Exception -> 0x00a4 }
            r3 = 1
            r7.setEnabled(r3)     // Catch:{ Exception -> 0x00a4 }
            android.media.AudioManager r3 = r11.f6846d     // Catch:{ Exception -> 0x00a4 }
            int r3 = r3.getStreamVolume(r2)     // Catch:{ Exception -> 0x00a4 }
            r10 = 0
            if (r12 == 0) goto L_0x005b
            int r12 = r12 + r3
            if (r12 < 0) goto L_0x005b
            if (r12 > r1) goto L_0x005b
            android.media.AudioManager r1 = r11.f6846d     // Catch:{ Exception -> 0x00a4 }
            r1.setStreamVolume(r2, r12, r10)     // Catch:{ Exception -> 0x00a4 }
            r3 = r12
        L_0x005b:
            r11.f6850h = r14     // Catch:{ Exception -> 0x00a4 }
            r7.setProgress(r3)     // Catch:{ Exception -> 0x00a4 }
            com.dream_studio.animalsounds.VolumeControl$a r12 = new com.dream_studio.animalsounds.VolumeControl$a     // Catch:{ Exception -> 0x00a4 }
            r1 = r12
            r2 = r11
            r3 = r7
            r4 = r8
            r5 = r9
            r6 = r0
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x00a4 }
            r9.setOnClickListener(r12)     // Catch:{ Exception -> 0x00a4 }
            boolean r12 = r0.isShown()     // Catch:{ Exception -> 0x00a4 }
            if (r12 == 0) goto L_0x0082
            if (r13 == 0) goto L_0x0077
            goto L_0x0082
        L_0x0077:
            if (r13 != 0) goto L_0x0093
            r11.m4930h()     // Catch:{ Exception -> 0x00a4 }
            r12 = 8
            r0.setVisibility(r12)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x0093
        L_0x0082:
            r0.setVisibility(r10)     // Catch:{ Exception -> 0x00a4 }
            r11.m4932j(r0)     // Catch:{ Exception -> 0x00a4 }
            com.dream_studio.animalsounds.VolumeControl$b r12 = new com.dream_studio.animalsounds.VolumeControl$b     // Catch:{ Exception -> 0x00a4 }
            r12.<init>(r8, r9, r0)     // Catch:{ Exception -> 0x00a4 }
            r7.setOnSeekBarChangeListener(r12)     // Catch:{ Exception -> 0x00a4 }
            r0.invalidate()     // Catch:{ Exception -> 0x00a4 }
        L_0x0093:
            boolean r12 = r11.m4931i()     // Catch:{ Exception -> 0x00a4 }
            r11.f6847e = r12     // Catch:{ Exception -> 0x00a4 }
            if (r8 == 0) goto L_0x009e
            r8.setChecked(r12)     // Catch:{ Exception -> 0x00a4 }
        L_0x009e:
            boolean r12 = r11.f6847e     // Catch:{ Exception -> 0x00a4 }
            r9.setChecked(r12)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a8
        L_0x00a4:
            r12 = move-exception
            com.medio.catchexception.CatchException.logException(r12)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.VolumeControl.controlSysVolume(int, boolean, boolean):void");
    }

    public int getPlayerVolume() {
        return this.f6849g;
    }

    public void hideVolumeControl() {
        RelativeLayout relativeLayout;
        m4930h();
        BaseActivity baseActivity = this.f6844b;
        if (baseActivity != null && (relativeLayout = (RelativeLayout) baseActivity.findViewById(C1441R.C1443id.volume_control_box)) != null) {
            HideVolumeControlAfterTime hideVolumeControlAfterTime = new HideVolumeControlAfterTime();
            this.f6845c = hideVolumeControlAfterTime;
            hideVolumeControlAfterTime.execute(new Object[]{relativeLayout, 100});
        }
    }

    public void onPlayerVolumeChangeListener(int i) {
    }

    public boolean refreshMute() {
        boolean i = m4931i();
        this.f6847e = i;
        return i;
    }

    public void setControlPlayerVolume() {
    }

    public void setOnPlayerVolumeChangeListener(C1472e eVar) {
    }

    public void setPlayerVolume(int i) {
        this.f6849g = i;
        if (i < 0) {
            this.f6849g = 0;
        } else if (i > 100) {
            this.f6849g = 100;
        }
    }
}
