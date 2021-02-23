package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {

    /* renamed from: a */
    private final C0526a f2599a;

    /* renamed from: androidx.core.view.GestureDetectorCompat$a */
    interface C0526a {
        /* renamed from: a */
        void mo4558a(GestureDetector.OnDoubleTapListener onDoubleTapListener);

        /* renamed from: b */
        void mo4559b(boolean z);

        /* renamed from: c */
        boolean mo4560c();

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* renamed from: androidx.core.view.GestureDetectorCompat$b */
    static class C0527b implements C0526a {

        /* renamed from: v */
        private static final int f2600v = ViewConfiguration.getLongPressTimeout();

        /* renamed from: w */
        private static final int f2601w = ViewConfiguration.getTapTimeout();

        /* renamed from: x */
        private static final int f2602x = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a */
        private int f2603a;

        /* renamed from: b */
        private int f2604b;

        /* renamed from: c */
        private int f2605c;

        /* renamed from: d */
        private int f2606d;

        /* renamed from: e */
        private final Handler f2607e;

        /* renamed from: f */
        final GestureDetector.OnGestureListener f2608f;

        /* renamed from: g */
        GestureDetector.OnDoubleTapListener f2609g;

        /* renamed from: h */
        boolean f2610h;

        /* renamed from: i */
        boolean f2611i;

        /* renamed from: j */
        private boolean f2612j;

        /* renamed from: k */
        private boolean f2613k;

        /* renamed from: l */
        private boolean f2614l;

        /* renamed from: m */
        MotionEvent f2615m;

        /* renamed from: n */
        private MotionEvent f2616n;

        /* renamed from: o */
        private boolean f2617o;

        /* renamed from: p */
        private float f2618p;

        /* renamed from: q */
        private float f2619q;

        /* renamed from: r */
        private float f2620r;

        /* renamed from: s */
        private float f2621s;

        /* renamed from: t */
        private boolean f2622t;

        /* renamed from: u */
        private VelocityTracker f2623u;

        C0527b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f2607e = new C0528a(handler);
            } else {
                this.f2607e = new C0528a();
            }
            this.f2608f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                mo4558a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            m1717g(context);
        }

        /* renamed from: d */
        private void m1715d() {
            this.f2607e.removeMessages(1);
            this.f2607e.removeMessages(2);
            this.f2607e.removeMessages(3);
            this.f2623u.recycle();
            this.f2623u = null;
            this.f2617o = false;
            this.f2610h = false;
            this.f2613k = false;
            this.f2614l = false;
            this.f2611i = false;
            if (this.f2612j) {
                this.f2612j = false;
            }
        }

        /* renamed from: e */
        private void m1716e() {
            this.f2607e.removeMessages(1);
            this.f2607e.removeMessages(2);
            this.f2607e.removeMessages(3);
            this.f2617o = false;
            this.f2613k = false;
            this.f2614l = false;
            this.f2611i = false;
            if (this.f2612j) {
                this.f2612j = false;
            }
        }

        /* renamed from: g */
        private void m1717g(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f2608f != null) {
                this.f2622t = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f2605c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f2606d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f2603a = scaledTouchSlop * scaledTouchSlop;
                this.f2604b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        /* renamed from: h */
        private boolean m1718h(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f2614l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f2602x)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < this.f2604b) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public void mo4558a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2609g = onDoubleTapListener;
        }

        /* renamed from: b */
        public void mo4559b(boolean z) {
            this.f2622t = z;
        }

        /* renamed from: c */
        public boolean mo4560c() {
            return this.f2622t;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo4562f() {
            this.f2607e.removeMessages(3);
            this.f2611i = false;
            this.f2612j = true;
            this.f2608f.onLongPress(this.f2615m);
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r13) {
            /*
                r12 = this;
                int r0 = r13.getAction()
                android.view.VelocityTracker r1 = r12.f2623u
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r12.f2623u = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r12.f2623u
                r1.addMovement(r13)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = 1
                goto L_0x001d
            L_0x001c:
                r4 = 0
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r13.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r13.getPointerCount()
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x002d:
                if (r8 >= r6) goto L_0x003f
                if (r5 != r8) goto L_0x0032
                goto L_0x003c
            L_0x0032:
                float r11 = r13.getX(r8)
                float r9 = r9 + r11
                float r11 = r13.getY(r8)
                float r10 = r10 + r11
            L_0x003c:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x003f:
                if (r4 == 0) goto L_0x0044
                int r4 = r6 + -1
                goto L_0x0045
            L_0x0044:
                r4 = r6
            L_0x0045:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01bf
                r8 = 1000(0x3e8, float:1.401E-42)
                if (r0 == r2) goto L_0x0131
                if (r0 == r4) goto L_0x00ba
                if (r0 == r5) goto L_0x00b5
                r2 = 5
                if (r0 == r2) goto L_0x00a8
                if (r0 == r1) goto L_0x005b
                goto L_0x024e
            L_0x005b:
                r12.f2618p = r9
                r12.f2620r = r9
                r12.f2619q = r10
                r12.f2621s = r10
                android.view.VelocityTracker r0 = r12.f2623u
                int r1 = r12.f2606d
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r13.getActionIndex()
                int r1 = r13.getPointerId(r0)
                android.view.VelocityTracker r2 = r12.f2623u
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r12.f2623u
                float r1 = r4.getYVelocity(r1)
                r4 = 0
            L_0x0080:
                if (r4 >= r6) goto L_0x024e
                if (r4 != r0) goto L_0x0085
                goto L_0x00a5
            L_0x0085:
                int r5 = r13.getPointerId(r4)
                android.view.VelocityTracker r8 = r12.f2623u
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r12.f2623u
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r8 = r8 + r5
                int r5 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a5
                android.view.VelocityTracker r13 = r12.f2623u
                r13.clear()
                goto L_0x024e
            L_0x00a5:
                int r4 = r4 + 1
                goto L_0x0080
            L_0x00a8:
                r12.f2618p = r9
                r12.f2620r = r9
                r12.f2619q = r10
                r12.f2621s = r10
                r12.m1716e()
                goto L_0x024e
            L_0x00b5:
                r12.m1715d()
                goto L_0x024e
            L_0x00ba:
                boolean r0 = r12.f2612j
                if (r0 == 0) goto L_0x00c0
                goto L_0x024e
            L_0x00c0:
                float r0 = r12.f2618p
                float r0 = r0 - r9
                float r1 = r12.f2619q
                float r1 = r1 - r10
                boolean r6 = r12.f2617o
                if (r6 == 0) goto L_0x00d3
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f2609g
                boolean r13 = r0.onDoubleTapEvent(r13)
                r3 = r3 | r13
                goto L_0x024e
            L_0x00d3:
                boolean r6 = r12.f2613k
                if (r6 == 0) goto L_0x0111
                float r6 = r12.f2620r
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r12.f2621s
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r6 = r6 + r7
                int r7 = r12.f2603a
                if (r6 <= r7) goto L_0x0108
                android.view.GestureDetector$OnGestureListener r7 = r12.f2608f
                android.view.MotionEvent r8 = r12.f2615m
                boolean r13 = r7.onScroll(r8, r13, r0, r1)
                r12.f2618p = r9
                r12.f2619q = r10
                r12.f2613k = r3
                android.os.Handler r0 = r12.f2607e
                r0.removeMessages(r5)
                android.os.Handler r0 = r12.f2607e
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f2607e
                r0.removeMessages(r4)
                goto L_0x0109
            L_0x0108:
                r13 = 0
            L_0x0109:
                int r0 = r12.f2603a
                if (r6 <= r0) goto L_0x01bc
                r12.f2614l = r3
                goto L_0x01bc
            L_0x0111:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x0123
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x024e
            L_0x0123:
                android.view.GestureDetector$OnGestureListener r2 = r12.f2608f
                android.view.MotionEvent r3 = r12.f2615m
                boolean r3 = r2.onScroll(r3, r13, r0, r1)
                r12.f2618p = r9
                r12.f2619q = r10
                goto L_0x024e
            L_0x0131:
                r12.f2610h = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
                boolean r1 = r12.f2617o
                if (r1 == 0) goto L_0x0143
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f2609g
                boolean r13 = r1.onDoubleTapEvent(r13)
                r13 = r13 | r3
                goto L_0x019b
            L_0x0143:
                boolean r1 = r12.f2612j
                if (r1 == 0) goto L_0x014f
                android.os.Handler r13 = r12.f2607e
                r13.removeMessages(r5)
                r12.f2612j = r3
                goto L_0x0191
            L_0x014f:
                boolean r1 = r12.f2613k
                if (r1 == 0) goto L_0x0166
                android.view.GestureDetector$OnGestureListener r1 = r12.f2608f
                boolean r1 = r1.onSingleTapUp(r13)
                boolean r5 = r12.f2611i
                if (r5 == 0) goto L_0x0164
                android.view.GestureDetector$OnDoubleTapListener r5 = r12.f2609g
                if (r5 == 0) goto L_0x0164
                r5.onSingleTapConfirmed(r13)
            L_0x0164:
                r13 = r1
                goto L_0x019b
            L_0x0166:
                android.view.VelocityTracker r1 = r12.f2623u
                int r5 = r13.getPointerId(r3)
                int r6 = r12.f2606d
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r12.f2605c
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x0193
                float r5 = java.lang.Math.abs(r1)
                int r7 = r12.f2605c
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x0191
                goto L_0x0193
            L_0x0191:
                r13 = 0
                goto L_0x019b
            L_0x0193:
                android.view.GestureDetector$OnGestureListener r5 = r12.f2608f
                android.view.MotionEvent r7 = r12.f2615m
                boolean r13 = r5.onFling(r7, r13, r1, r6)
            L_0x019b:
                android.view.MotionEvent r1 = r12.f2616n
                if (r1 == 0) goto L_0x01a2
                r1.recycle()
            L_0x01a2:
                r12.f2616n = r0
                android.view.VelocityTracker r0 = r12.f2623u
                if (r0 == 0) goto L_0x01ae
                r0.recycle()
                r0 = 0
                r12.f2623u = r0
            L_0x01ae:
                r12.f2617o = r3
                r12.f2611i = r3
                android.os.Handler r0 = r12.f2607e
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f2607e
                r0.removeMessages(r4)
            L_0x01bc:
                r3 = r13
                goto L_0x024e
            L_0x01bf:
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f2609g
                if (r0 == 0) goto L_0x01fb
                android.os.Handler r0 = r12.f2607e
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x01d0
                android.os.Handler r1 = r12.f2607e
                r1.removeMessages(r5)
            L_0x01d0:
                android.view.MotionEvent r1 = r12.f2615m
                if (r1 == 0) goto L_0x01f3
                android.view.MotionEvent r6 = r12.f2616n
                if (r6 == 0) goto L_0x01f3
                if (r0 == 0) goto L_0x01f3
                boolean r0 = r12.m1718h(r1, r6, r13)
                if (r0 == 0) goto L_0x01f3
                r12.f2617o = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f2609g
                android.view.MotionEvent r1 = r12.f2615m
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f2609g
                boolean r1 = r1.onDoubleTapEvent(r13)
                r0 = r0 | r1
                goto L_0x01fc
            L_0x01f3:
                android.os.Handler r0 = r12.f2607e
                int r1 = f2602x
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x01fb:
                r0 = 0
            L_0x01fc:
                r12.f2618p = r9
                r12.f2620r = r9
                r12.f2619q = r10
                r12.f2621s = r10
                android.view.MotionEvent r1 = r12.f2615m
                if (r1 == 0) goto L_0x020b
                r1.recycle()
            L_0x020b:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
                r12.f2615m = r1
                r12.f2613k = r2
                r12.f2614l = r2
                r12.f2610h = r2
                r12.f2612j = r3
                r12.f2611i = r3
                boolean r1 = r12.f2622t
                if (r1 == 0) goto L_0x0237
                android.os.Handler r1 = r12.f2607e
                r1.removeMessages(r4)
                android.os.Handler r1 = r12.f2607e
                android.view.MotionEvent r3 = r12.f2615m
                long r5 = r3.getDownTime()
                int r3 = f2601w
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = f2600v
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x0237:
                android.os.Handler r1 = r12.f2607e
                android.view.MotionEvent r3 = r12.f2615m
                long r3 = r3.getDownTime()
                int r5 = f2601w
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r12.f2608f
                boolean r13 = r1.onDown(r13)
                r3 = r0 | r13
            L_0x024e:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.GestureDetectorCompat.C0527b.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* renamed from: androidx.core.view.GestureDetectorCompat$b$a */
        private class C0528a extends Handler {
            C0528a() {
            }

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    C0527b bVar = C0527b.this;
                    bVar.f2608f.onShowPress(bVar.f2615m);
                } else if (i == 2) {
                    C0527b.this.mo4562f();
                } else if (i == 3) {
                    C0527b bVar2 = C0527b.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f2609g;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!bVar2.f2610h) {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.f2615m);
                    } else {
                        bVar2.f2611i = true;
                    }
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }

            C0528a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    /* renamed from: androidx.core.view.GestureDetectorCompat$c */
    static class C0529c implements C0526a {

        /* renamed from: a */
        private final GestureDetector f2625a;

        C0529c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2625a = new GestureDetector(context, onGestureListener, handler);
        }

        /* renamed from: a */
        public void mo4558a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2625a.setOnDoubleTapListener(onDoubleTapListener);
        }

        /* renamed from: b */
        public void mo4559b(boolean z) {
            this.f2625a.setIsLongpressEnabled(z);
        }

        /* renamed from: c */
        public boolean mo4560c() {
            return this.f2625a.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f2625a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public boolean isLongpressEnabled() {
        return this.f2599a.mo4560c();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f2599a.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f2599a.mo4559b(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f2599a.mo4558a(onDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f2599a = new C0529c(context, onGestureListener, handler);
        } else {
            this.f2599a = new C0527b(context, onGestureListener, handler);
        }
    }
}
