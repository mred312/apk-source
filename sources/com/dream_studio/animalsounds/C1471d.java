package com.dream_studio.animalsounds;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.dream_studio.animalsounds.d */
/* compiled from: MyGestureDetector */
class C1471d extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    private ImagesActivity f6885a = null;

    public C1471d(ImagesActivity imagesActivity) {
        this.f6885a = imagesActivity;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        try {
            if (Math.abs(motionEvent.getX() - motionEvent2.getX()) <= Math.abs(motionEvent.getY() - motionEvent2.getY()) || Math.abs(f) <= Math.abs(f2)) {
                if (motionEvent.getY() - motionEvent2.getY() > 80.0f && Math.abs(f2) > 70.0f) {
                    this.f6885a.openSlideUpPanel();
                    return false;
                } else if (motionEvent2.getY() - motionEvent.getY() <= 80.0f || Math.abs(f2) <= 70.0f) {
                    return false;
                } else {
                    this.f6885a.closeSlideUpPanel();
                    return false;
                }
            } else if (motionEvent.getX() - motionEvent2.getX() > 80.0f && Math.abs(f) > 70.0f) {
                this.f6885a.onSwitchNext((View) null);
                return false;
            } else if (motionEvent2.getX() - motionEvent.getX() <= 80.0f || Math.abs(f) <= 70.0f) {
                return false;
            } else {
                this.f6885a.onSwitchBack((View) null);
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ImagesActivity imagesActivity = this.f6885a;
        if (imagesActivity != null) {
            imagesActivity.playSound(false);
        }
        return super.onSingleTapConfirmed(motionEvent);
    }
}
