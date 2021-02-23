package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.p003os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class FragmentTransitionImpl {

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$a */
    class C0658a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f3234a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f3235b;

        /* renamed from: c */
        final /* synthetic */ ArrayList f3236c;

        /* renamed from: d */
        final /* synthetic */ ArrayList f3237d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f3238e;

        C0658a(FragmentTransitionImpl fragmentTransitionImpl, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f3234a = i;
            this.f3235b = arrayList;
            this.f3236c = arrayList2;
            this.f3237d = arrayList3;
            this.f3238e = arrayList4;
        }

        public void run() {
            for (int i = 0; i < this.f3234a; i++) {
                ViewCompat.setTransitionName((View) this.f3235b.get(i), (String) this.f3236c.get(i));
                ViewCompat.setTransitionName((View) this.f3237d.get(i), (String) this.f3238e.get(i));
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$b */
    class C0659b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3239a;

        /* renamed from: b */
        final /* synthetic */ Map f3240b;

        C0659b(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
            this.f3239a = arrayList;
            this.f3240b = map;
        }

        public void run() {
            int size = this.f3239a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f3239a.get(i);
                String transitionName = ViewCompat.getTransitionName(view);
                if (transitionName != null) {
                    ViewCompat.setTransitionName(view, FragmentTransitionImpl.m2343c(this.f3240b, transitionName));
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTransitionImpl$c */
    class C0660c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3241a;

        /* renamed from: b */
        final /* synthetic */ Map f3242b;

        C0660c(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
            this.f3241a = arrayList;
            this.f3242b = map;
        }

        public void run() {
            int size = this.f3241a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f3241a.get(i);
                ViewCompat.setTransitionName(view, (String) this.f3242b.get(ViewCompat.getTransitionName(view)));
            }
        }
    }

    /* renamed from: b */
    private static boolean m2342b(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    protected static void bfsAddViewChildren(List<View> list, View view) {
        int size = list.size();
        if (!m2342b(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m2342b(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    static String m2343c(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    protected static boolean isNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5938a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mo5938a(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public abstract void addTarget(Object obj, View view);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    public abstract Object cloneTransition(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5944d(Map<String, View> map, @NonNull View view) {
        if (view.getVisibility() == 0) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    mo5944d(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public ArrayList<String> mo5945e(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(ViewCompat.getTransitionName(view));
            ViewCompat.setTransitionName(view, (String) null);
        }
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5946f(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(viewGroup, new C0660c(this, arrayList, map));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5947g(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(view, new C0659b(this, arrayList, map));
    }

    /* access modifiers changed from: protected */
    public void getBoundsOnScreen(View view, Rect rect) {
        if (ViewCompat.isAttachedToWindow(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5949h(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String transitionName = ViewCompat.getTransitionName(view2);
            arrayList4.add(transitionName);
            if (transitionName != null) {
                ViewCompat.setTransitionName(view2, (String) null);
                String str = map.get(transitionName);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        ViewCompat.setTransitionName(arrayList2.get(i2), transitionName);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        OneShotPreDrawListener.add(view, new C0658a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    public abstract void removeTarget(Object obj, View view);

    public abstract void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList);

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(Object obj, Rect rect);

    public abstract void setEpicenter(Object obj, View view);

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull Runnable runnable) {
        runnable.run();
    }

    public abstract void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);
}
