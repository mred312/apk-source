package com.dream_studio.animalsounds;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.dream_studio.animalsounds.c */
/* compiled from: MyGalleryGestureDetector */
class C1470c extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    private ImagesActivity f6884a;

    public C1470c(ImagesActivity imagesActivity) {
        this.f6884a = imagesActivity;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        try {
            if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
                if (motionEvent.getX() - motionEvent2.getX() > 80.0f && Math.abs(f) > 70.0f) {
                    this.f6884a.onSwitchNext((View) null);
                    return false;
                } else if (motionEvent2.getX() - motionEvent.getX() <= 80.0f || Math.abs(f) <= 70.0f) {
                    return false;
                } else {
                    this.f6884a.onSwitchBack((View) null);
                    return false;
                }
            } else if (motionEvent.getY() - motionEvent2.getY() > 80.0f && Math.abs(f2) > 70.0f) {
                return false;
            } else {
                if (motionEvent2.getY() - motionEvent.getY() <= 80.0f) {
                    return false;
                }
                Math.abs(f2);
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }
}
