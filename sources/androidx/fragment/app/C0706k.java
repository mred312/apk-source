package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.p003os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* renamed from: androidx.fragment.app.k */
/* compiled from: FragmentTransitionCompat21 */
class C0706k extends FragmentTransitionImpl {

    /* renamed from: androidx.fragment.app.k$a */
    /* compiled from: FragmentTransitionCompat21 */
    class C0707a extends Transition.EpicenterCallback {

        /* renamed from: a */
        final /* synthetic */ Rect f3383a;

        C0707a(C0706k kVar, Rect rect) {
            this.f3383a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f3383a;
        }
    }

    /* renamed from: androidx.fragment.app.k$b */
    /* compiled from: FragmentTransitionCompat21 */
    class C0708b implements Transition.TransitionListener {

        /* renamed from: a */
        final /* synthetic */ View f3384a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f3385b;

        C0708b(C0706k kVar, View view, ArrayList arrayList) {
            this.f3384a = view;
            this.f3385b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f3384a.setVisibility(8);
            int size = this.f3385b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f3385b.get(i)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    /* renamed from: androidx.fragment.app.k$c */
    /* compiled from: FragmentTransitionCompat21 */
    class C0709c implements Transition.TransitionListener {

        /* renamed from: a */
        final /* synthetic */ Object f3386a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f3387b;

        /* renamed from: c */
        final /* synthetic */ Object f3388c;

        /* renamed from: d */
        final /* synthetic */ ArrayList f3389d;

        /* renamed from: e */
        final /* synthetic */ Object f3390e;

        /* renamed from: f */
        final /* synthetic */ ArrayList f3391f;

        C0709c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3386a = obj;
            this.f3387b = arrayList;
            this.f3388c = obj2;
            this.f3389d = arrayList2;
            this.f3390e = obj3;
            this.f3391f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f3386a;
            if (obj != null) {
                C0706k.this.replaceTargets(obj, this.f3387b, (ArrayList<View>) null);
            }
            Object obj2 = this.f3388c;
            if (obj2 != null) {
                C0706k.this.replaceTargets(obj2, this.f3389d, (ArrayList<View>) null);
            }
            Object obj3 = this.f3390e;
            if (obj3 != null) {
                C0706k.this.replaceTargets(obj3, this.f3391f, (ArrayList<View>) null);
            }
        }
    }

    /* renamed from: androidx.fragment.app.k$d */
    /* compiled from: FragmentTransitionCompat21 */
    class C0710d implements Transition.TransitionListener {

        /* renamed from: a */
        final /* synthetic */ Runnable f3393a;

        C0710d(C0706k kVar, Runnable runnable) {
            this.f3393a = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f3393a.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: androidx.fragment.app.k$e */
    /* compiled from: FragmentTransitionCompat21 */
    class C0711e extends Transition.EpicenterCallback {

        /* renamed from: a */
        final /* synthetic */ Rect f3394a;

        C0711e(C0706k kVar, Rect rect) {
            this.f3394a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f3394a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f3394a;
        }
    }

    C0706k() {
    }

    /* renamed from: i */
    private static boolean m2499i(Transition transition) {
        return !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes());
    }

    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    addTargets(transitionSet.getTransitionAt(i), arrayList);
                    i++;
                }
            } else if (!m2499i(transition) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
                int size = arrayList.size();
                while (i < size) {
                    transition.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        int i;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!m2499i(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            if (arrayList2 == null) {
                i = 0;
            } else {
                i = arrayList2.size();
            }
            while (i2 < i) {
                transition.addTarget(arrayList2.get(i2));
                i2++;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget(arrayList.get(size));
            }
        }
    }

    public void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new C0708b(this, view, arrayList));
    }

    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C0709c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new C0707a(this, rect));
        }
    }

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull Runnable runnable) {
        ((Transition) obj).addListener(new C0710d(this, runnable));
    }

    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C0711e(this, rect));
        }
    }
}
