package com.dream_studio.animalsounds;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MyImageSwitcher {
    public static final char BACK_TO_PREVIOUS_IMAGE = '\u0002';
    public static final char GO_TO_NEXT_IMAGE = '\u0001';
    public static final char NO_ANIMATION = 0;

    /* renamed from: a */
    Context f6749a = null;

    /* renamed from: b */
    Activity f6750b = null;

    /* renamed from: c */
    Animation f6751c = null;

    /* renamed from: d */
    Animation f6752d = null;

    /* renamed from: e */
    Animation f6753e = null;

    /* renamed from: f */
    Animation f6754f = null;

    /* renamed from: g */
    AnimatorSet f6755g = null;

    /* renamed from: h */
    CustomImageViewAnimals f6756h = null;

    /* renamed from: i */
    CustomImageViewAnimals f6757i = null;

    /* renamed from: com.dream_studio.animalsounds.MyImageSwitcher$a */
    class C1438a implements View.OnTouchListener {

        /* renamed from: a */
        final /* synthetic */ GestureDetector f6758a;

        C1438a(GestureDetector gestureDetector) {
            this.f6758a = gestureDetector;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            ((BaseActivity) MyImageSwitcher.this.f6749a).mVolumeControl.hideVolumeControl();
            return this.f6758a.onTouchEvent(motionEvent);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MyImageSwitcher$b */
    class C1439b implements Animation.AnimationListener {
        C1439b() {
        }

        public void onAnimationEnd(Animation animation) {
            MyImageSwitcher.this.m4906c(0);
            MyImageSwitcher.this.m4908e();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MyImageSwitcher$c */
    class C1440c implements Animation.AnimationListener {
        C1440c() {
        }

        public void onAnimationEnd(Animation animation) {
            MyImageSwitcher.this.m4906c(0);
            MyImageSwitcher.this.m4908e();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    MyImageSwitcher(Context context) {
        this.f6749a = context;
        Activity activity = (Activity) context;
        this.f6750b = activity;
        this.f6756h = (CustomImageViewAnimals) activity.findViewById(C1441R.C1443id.imageForeground);
        this.f6757i = (CustomImageViewAnimals) this.f6750b.findViewById(C1441R.C1443id.imageBackground);
        this.f6750b.findViewById(C1441R.C1443id.sliding_layout).setOnTouchListener(new C1438a(new GestureDetector(this.f6749a, new C1471d((ImagesActivity) this.f6749a))));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4906c(int i) {
        if (Build.VERSION.SDK_INT > 24) {
            this.f6756h.setLayerType(i, (Paint) null);
            this.f6757i.setLayerType(i, (Paint) null);
        }
    }

    /* renamed from: d */
    private void m4907d() {
        if (Build.VERSION.SDK_INT >= 11) {
            AnimatorSet animatorSet = this.f6755g;
            if (animatorSet != null) {
                animatorSet.end();
            }
            m4906c(0);
            this.f6756h.setScaleX(1.0f);
            this.f6756h.setScaleY(1.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4908e() {
        this.f6757i.clearAnimation();
        this.f6757i.setImageDrawable((Drawable) null);
        this.f6757i.setDrawingCacheEnabled(false);
        this.f6757i.setVisibility(8);
    }

    /* renamed from: f */
    private void m4909f() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f6749a, C1441R.anim.from_right);
        this.f6751c = loadAnimation;
        loadAnimation.setAnimationListener(new C1439b());
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f6749a, C1441R.anim.from_left);
        this.f6752d = loadAnimation2;
        loadAnimation2.setAnimationListener(new C1440c());
        this.f6753e = AnimationUtils.loadAnimation(this.f6749a, C1441R.anim.to_left);
        this.f6754f = AnimationUtils.loadAnimation(this.f6749a, C1441R.anim.to_right);
    }

    /* renamed from: g */
    private void m4910g() {
        if (Build.VERSION.SDK_INT >= 11) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this.f6749a, C1441R.animator.zoom_wave);
            this.f6755g = animatorSet;
            animatorSet.setTarget(this.f6756h);
        }
    }

    public void releaseImages() {
        this.f6756h.clearAnimation();
        this.f6756h.setImageDrawable((Drawable) null);
        this.f6756h.setDrawingCacheEnabled(false);
        m4908e();
    }

    public void releaseListener() {
        this.f6756h.setOnTouchListener((View.OnTouchListener) null);
    }

    public void setActualImage(Drawable drawable, char c) {
        m4907d();
        this.f6757i.setImageDrawable(this.f6756h.getDrawable());
        if (c == 1) {
            this.f6757i.setVisibility(0);
            m4906c(2);
            this.f6756h.startAnimation(this.f6751c);
            this.f6757i.startAnimation(this.f6753e);
        } else if (c != 2) {
            this.f6757i.clearAnimation();
        } else {
            this.f6757i.setVisibility(0);
            m4906c(2);
            this.f6756h.startAnimation(this.f6752d);
            this.f6757i.startAnimation(this.f6754f);
        }
        this.f6756h.setImageDrawable(drawable);
        this.f6756h.setDrawingCacheEnabled(false);
        if (c == 0) {
            m4908e();
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.f6756h.setScaleType(scaleType);
        this.f6757i.setScaleType(scaleType);
        m4910g();
        m4909f();
    }
}
