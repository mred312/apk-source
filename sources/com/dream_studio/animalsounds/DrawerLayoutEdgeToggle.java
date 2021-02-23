package com.dream_studio.animalsounds;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

@TargetApi(12)
public class DrawerLayoutEdgeToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private Activity f6593a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DrawerLayout f6594b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f6595c;

    /* renamed from: d */
    private float f6596d;

    /* renamed from: e */
    private Drawable f6597e;

    /* renamed from: f */
    private Drawable f6598f;

    /* renamed from: g */
    private boolean f6599g;

    /* renamed from: h */
    private int f6600h = 255;

    /* renamed from: i */
    private float f6601i = 1.2f;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View.OnClickListener f6602j;

    /* renamed from: k */
    private View.OnClickListener f6603k = new C1377a();

    /* renamed from: l */
    private View.OnTouchListener f6604l = new C1378b();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f6605m = true;

    /* renamed from: n */
    private int f6606n = 0;

    /* renamed from: o */
    private int f6607o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View.OnTouchListener f6608p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f6609q;

    /* renamed from: r */
    private FrameLayout f6610r;

    /* renamed from: s */
    private Drawable f6611s;

    /* renamed from: t */
    private int f6612t;

    /* renamed from: u */
    private float f6613u;

    /* renamed from: com.dream_studio.animalsounds.DrawerLayoutEdgeToggle$a */
    class C1377a implements View.OnClickListener {
        C1377a() {
        }

        public void onClick(View view) {
            if (DrawerLayoutEdgeToggle.this.f6605m) {
                if (!DrawerLayoutEdgeToggle.this.f6594b.isDrawerOpen(DrawerLayoutEdgeToggle.this.f6609q)) {
                    DrawerLayoutEdgeToggle.this.f6594b.openDrawer(DrawerLayoutEdgeToggle.this.f6609q);
                } else {
                    DrawerLayoutEdgeToggle.this.f6594b.closeDrawer(DrawerLayoutEdgeToggle.this.f6609q);
                }
            }
            if (DrawerLayoutEdgeToggle.this.f6602j != null) {
                DrawerLayoutEdgeToggle.this.f6602j.onClick(view);
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.DrawerLayoutEdgeToggle$b */
    class C1378b implements View.OnTouchListener {

        /* renamed from: a */
        private float f6615a = 0.0f;

        /* renamed from: b */
        private int f6616b = 0;

        C1378b() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f6616b = motionEvent.getPointerId(0);
                this.f6615a = motionEvent.getRawX();
                view.getParent().requestDisallowInterceptTouchEvent(true);
            } else if (motionEvent.getAction() == 1) {
                this.f6615a = 0.0f;
            }
            if (motionEvent.getPointerCount() <= 1 && motionEvent.findPointerIndex(this.f6616b) >= 0) {
                try {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setEdgeFlags(15);
                    obtain.setLocation(DrawerLayoutEdgeToggle.this.f6594b.isDrawerOpen((int) GravityCompat.START) ? motionEvent.getRawX() : motionEvent.getRawX() - this.f6615a, motionEvent.getRawY());
                    DrawerLayoutEdgeToggle.this.f6594b.onTouchEvent(obtain);
                    if (DrawerLayoutEdgeToggle.this.f6608p != null) {
                        return DrawerLayoutEdgeToggle.this.f6608p.onTouch(view, motionEvent);
                    }
                    return false;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.DrawerLayoutEdgeToggle$c */
    class C1379c implements ViewTreeObserver.OnGlobalLayoutListener {
        C1379c() {
        }

        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            DrawerLayoutEdgeToggle.this.f6594b.measure(1073741824, 1073741824);
            DrawerLayoutEdgeToggle.this.syncState();
            DrawerLayoutEdgeToggle drawerLayoutEdgeToggle = DrawerLayoutEdgeToggle.this;
            drawerLayoutEdgeToggle.m4819o(drawerLayoutEdgeToggle.f6595c, this);
        }
    }

    public DrawerLayoutEdgeToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, boolean z, int i3) {
        if (i3 == 8388613 || i3 == 8388611 || i3 == 3 || i3 == 5) {
            this.f6609q = i3;
            this.f6593a = activity;
            this.f6594b = drawerLayout;
            this.f6597e = activity.getResources().getDrawable(i);
            this.f6598f = activity.getResources().getDrawable(i2);
            this.f6610r = (FrameLayout) this.f6593a.findViewById(16908290);
            ImageView imageView = new ImageView(activity);
            this.f6595c = imageView;
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new C1379c());
            }
            this.f6595c.setOnClickListener(this.f6603k);
            this.f6595c.setOnTouchListener(this.f6604l);
            this.f6595c.setSaveEnabled(true);
            this.f6594b.setOnTouchListener(this.f6604l);
            this.f6610r.addView(this.f6595c, new FrameLayout.LayoutParams(-2, -2, i3));
            this.f6599g = z;
            this.f6611s = this.f6598f;
            return;
        }
        throw new IllegalArgumentException("Use: GravityCompat.END, GravityCompat.START, Gravity.LEFT or Gravity.RIGHT for drawerGravity parameter");
    }

    /* renamed from: h */
    private float m4812h(int i, float f) {
        return (i == 8388613 || i == 3) ? (((float) this.f6612t) - f) - ((float) this.f6595c.getDrawable().getIntrinsicWidth()) : f;
    }

    /* renamed from: i */
    private void m4813i() {
        if (this.f6596d == 0.0f) {
            for (int i = 0; i < this.f6594b.getChildCount(); i++) {
                float f = this.f6596d;
                if (f == 0.0f) {
                    f = (float) this.f6594b.getChildAt(i).getMeasuredWidth();
                }
                this.f6596d = f;
                this.f6596d = Math.min(f, (float) this.f6594b.getChildAt(i).getMeasuredWidth());
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    private int m4814j() {
        Point point = new Point();
        this.f6593a.getWindowManager().getDefaultDisplay().getSize(point);
        return point.y;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: k */
    private int m4815k() {
        Point point = new Point();
        this.f6593a.getWindowManager().getDefaultDisplay().getSize(point);
        return point.x;
    }

    /* renamed from: l */
    private boolean m4816l() {
        return this.f6594b.isDrawerOpen(this.f6609q);
    }

    /* renamed from: m */
    private void m4817m(float f) {
        this.f6595c.setAlpha(this.f6601i - f);
    }

    /* renamed from: n */
    private void m4818n() {
        this.f6598f.setAlpha(this.f6600h);
        this.f6597e.setAlpha(this.f6600h);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: o */
    public void m4819o(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT < 16) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        } else {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* renamed from: p */
    private void m4820p(float f) {
        if (!this.f6599g) {
            m4818n();
        } else {
            m4817m(f);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: q */
    private void m4821q() {
        int i;
        int i2;
        Resources resources;
        int i3 = this.f6607o;
        if (i3 != 0 && (i = this.f6606n) != 0 && i3 != 0 && i != 0) {
            if (m4816l()) {
                resources = this.f6593a.getResources();
                i2 = this.f6607o;
            } else {
                resources = this.f6593a.getResources();
                i2 = this.f6606n;
            }
            this.f6593a.getActionBar().setTitle(resources.getString(i2));
        }
    }

    /* renamed from: r */
    private void m4822r() {
        m4813i();
        this.f6612t = m4815k();
        this.f6595c.setImageDrawable(this.f6611s);
        if (m4816l()) {
            this.f6595c.setX((float) ((int) m4812h(this.f6609q, this.f6596d)));
            m4820p(1.0f);
        }
    }

    /* renamed from: s */
    private void m4823s() {
        float f = this.f6613u;
        if (f > 100.0f || f < 0.0f) {
            throw new IllegalArgumentException("Invalid percentage.");
        }
        float j = (float) m4814j();
        this.f6595c.setY((float) ((int) (j - ((f / 100.0f) * j))));
    }

    public View getDrawerLayoutHandle() {
        return this.f6595c;
    }

    public void onConfigurationChanged(Configuration configuration) {
        DrawerLayout drawerLayout = this.f6594b;
        if (drawerLayout != null) {
            drawerLayout.measure(1073741824, 1073741824);
            syncState();
        }
    }

    public void onDrawerClosed(View view) {
        this.f6595c.setImageDrawable(this.f6598f);
        m4821q();
        this.f6611s = this.f6598f;
    }

    public void onDrawerOpened(View view) {
        this.f6595c.setImageDrawable(this.f6597e);
        m4821q();
        this.f6611s = this.f6597e;
    }

    public void onDrawerSlide(View view, float f) {
        m4813i();
        float h = m4812h(this.f6609q, this.f6596d * f);
        this.f6595c.setTranslationX(h);
        this.f6595c.setX(h);
        m4820p(f);
    }

    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!m4816l()) {
            return false;
        }
        this.f6594b.closeDrawer(this.f6609q);
        return false;
    }

    public void setActionBarCloseTitle(int i) {
        this.f6606n = i;
    }

    public void setActionBarOpenTitle(int i) {
        this.f6607o = i;
    }

    public void setOnHandleClickListener(View.OnClickListener onClickListener) {
        this.f6602j = onClickListener;
    }

    public void setOnHandleTouchListener(View.OnTouchListener onTouchListener) {
        this.f6608p = onTouchListener;
    }

    public void setOverrideDefaultHandleAction(boolean z) {
        this.f6605m = z;
    }

    public void setVerticalTopOffset(int i) {
        this.f6613u = (float) i;
    }

    public void syncState() {
        this.f6611s = this.f6594b.isDrawerOpen(this.f6609q) ? this.f6597e : this.f6598f;
        this.f6612t = m4815k();
        this.f6595c.setImageDrawable(this.f6611s);
        m4821q();
        m4822r();
        m4823s();
    }
}
