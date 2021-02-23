package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class DragStartHelper {

    /* renamed from: a */
    private final View f2590a;

    /* renamed from: b */
    private final OnDragStartListener f2591b;

    /* renamed from: c */
    private int f2592c;

    /* renamed from: d */
    private int f2593d;

    /* renamed from: e */
    private boolean f2594e;

    /* renamed from: f */
    private final View.OnLongClickListener f2595f = new C0524a();

    /* renamed from: g */
    private final View.OnTouchListener f2596g = new C0525b();

    public interface OnDragStartListener {
        boolean onDragStart(View view, DragStartHelper dragStartHelper);
    }

    /* renamed from: androidx.core.view.DragStartHelper$a */
    class C0524a implements View.OnLongClickListener {
        C0524a() {
        }

        public boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    }

    /* renamed from: androidx.core.view.DragStartHelper$b */
    class C0525b implements View.OnTouchListener {
        C0525b() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    }

    public DragStartHelper(View view, OnDragStartListener onDragStartListener) {
        this.f2590a = view;
        this.f2591b = onDragStartListener;
    }

    public void attach() {
        this.f2590a.setOnLongClickListener(this.f2595f);
        this.f2590a.setOnTouchListener(this.f2596g);
    }

    public void detach() {
        this.f2590a.setOnLongClickListener((View.OnLongClickListener) null);
        this.f2590a.setOnTouchListener((View.OnTouchListener) null);
    }

    public void getTouchPosition(Point point) {
        point.set(this.f2592c, this.f2593d);
    }

    public boolean onLongClick(View view) {
        return this.f2591b.onDragStart(view, this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r2 != 3) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            int r2 = r8.getAction()
            r3 = 0
            if (r2 == 0) goto L_0x0049
            r4 = 1
            if (r2 == r4) goto L_0x0046
            r5 = 2
            if (r2 == r5) goto L_0x001b
            r7 = 3
            if (r2 == r7) goto L_0x0046
            goto L_0x004d
        L_0x001b:
            r2 = 8194(0x2002, float:1.1482E-41)
            boolean r2 = androidx.core.view.MotionEventCompat.isFromSource(r8, r2)
            if (r2 == 0) goto L_0x004d
            int r8 = r8.getButtonState()
            r8 = r8 & r4
            if (r8 != 0) goto L_0x002b
            goto L_0x004d
        L_0x002b:
            boolean r8 = r6.f2594e
            if (r8 == 0) goto L_0x0030
            goto L_0x004d
        L_0x0030:
            int r8 = r6.f2592c
            if (r8 != r0) goto L_0x0039
            int r8 = r6.f2593d
            if (r8 != r1) goto L_0x0039
            goto L_0x004d
        L_0x0039:
            r6.f2592c = r0
            r6.f2593d = r1
            androidx.core.view.DragStartHelper$OnDragStartListener r8 = r6.f2591b
            boolean r7 = r8.onDragStart(r7, r6)
            r6.f2594e = r7
            return r7
        L_0x0046:
            r6.f2594e = r3
            goto L_0x004d
        L_0x0049:
            r6.f2592c = r0
            r6.f2593d = r1
        L_0x004d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.DragStartHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
