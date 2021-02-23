package com.dream_studio.animalsounds;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.RelativeLayout;

public class HideVolumeControlAfterTime extends AsyncTask<Object, Integer, RelativeLayout> {

    /* renamed from: com.dream_studio.animalsounds.HideVolumeControlAfterTime$a */
    class C1380a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6620a;

        C1380a(HideVolumeControlAfterTime hideVolumeControlAfterTime, RelativeLayout relativeLayout) {
            this.f6620a = relativeLayout;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f6620a.findViewById(C1441R.C1443id.sys_volume_control).setEnabled(false);
            this.f6620a.findViewById(C1441R.C1443id.player_volume_control).setEnabled(false);
            this.f6620a.clearAnimation();
            this.f6620a.setVisibility(8);
            this.f6620a.setAlpha(1.0f);
        }
    }

    /* access modifiers changed from: protected */
    public RelativeLayout doInBackground(Object[] objArr) {
        try {
            int intValue = objArr[1].intValue() / 100;
            while (true) {
                int i = intValue - 1;
                if (intValue <= 0) {
                    break;
                }
                Thread.sleep(100);
                if (isCancelled()) {
                    break;
                }
                intValue = i;
            }
            if (!isCancelled()) {
                return objArr[0];
            }
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(12)
    public void onPostExecute(RelativeLayout relativeLayout) {
        super.onPostExecute(relativeLayout);
        if (isCancelled() || relativeLayout == null) {
            return;
        }
        if (Build.VERSION.SDK_INT > 13) {
            relativeLayout.animate().translationY(0.0f).alpha(0.0f).setListener(new C1380a(this, relativeLayout));
            return;
        }
        relativeLayout.findViewById(C1441R.C1443id.sys_volume_control).setEnabled(false);
        relativeLayout.findViewById(C1441R.C1443id.player_volume_control).setEnabled(false);
        relativeLayout.setVisibility(8);
    }
}
