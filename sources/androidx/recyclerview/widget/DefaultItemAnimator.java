package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: s */
    private static TimeInterpolator f3894s;

    /* renamed from: h */
    private ArrayList<RecyclerView.ViewHolder> f3895h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<RecyclerView.ViewHolder> f3896i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<C0886j> f3897j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<C0885i> f3898k = new ArrayList<>();

    /* renamed from: l */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f3899l = new ArrayList<>();

    /* renamed from: m */
    ArrayList<ArrayList<C0886j>> f3900m = new ArrayList<>();

    /* renamed from: n */
    ArrayList<ArrayList<C0885i>> f3901n = new ArrayList<>();

    /* renamed from: o */
    ArrayList<RecyclerView.ViewHolder> f3902o = new ArrayList<>();

    /* renamed from: p */
    ArrayList<RecyclerView.ViewHolder> f3903p = new ArrayList<>();

    /* renamed from: q */
    ArrayList<RecyclerView.ViewHolder> f3904q = new ArrayList<>();

    /* renamed from: r */
    ArrayList<RecyclerView.ViewHolder> f3905r = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$a */
    class C0877a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3906a;

        C0877a(ArrayList arrayList) {
            this.f3906a = arrayList;
        }

        public void run() {
            Iterator it = this.f3906a.iterator();
            while (it.hasNext()) {
                C0886j jVar = (C0886j) it.next();
                DefaultItemAnimator.this.mo6668e(jVar.f3940a, jVar.f3941b, jVar.f3942c, jVar.f3943d, jVar.f3944e);
            }
            this.f3906a.clear();
            DefaultItemAnimator.this.f3900m.remove(this.f3906a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$b */
    class C0878b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3908a;

        C0878b(ArrayList arrayList) {
            this.f3908a = arrayList;
        }

        public void run() {
            Iterator it = this.f3908a.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.mo6667d((C0885i) it.next());
            }
            this.f3908a.clear();
            DefaultItemAnimator.this.f3901n.remove(this.f3908a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$c */
    class C0879c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f3910a;

        C0879c(ArrayList arrayList) {
            this.f3910a = arrayList;
        }

        public void run() {
            Iterator it = this.f3910a.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.mo6665c((RecyclerView.ViewHolder) it.next());
            }
            this.f3910a.clear();
            DefaultItemAnimator.this.f3899l.remove(this.f3910a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$d */
    class C0880d extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.ViewHolder f3912a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f3913b;

        /* renamed from: c */
        final /* synthetic */ View f3914c;

        C0880d(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3912a = viewHolder;
            this.f3913b = viewPropertyAnimator;
            this.f3914c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3913b.setListener((Animator.AnimatorListener) null);
            this.f3914c.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.f3912a);
            DefaultItemAnimator.this.f3904q.remove(this.f3912a);
            DefaultItemAnimator.this.mo6672h();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.f3912a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$e */
    class C0881e extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.ViewHolder f3916a;

        /* renamed from: b */
        final /* synthetic */ View f3917b;

        /* renamed from: c */
        final /* synthetic */ ViewPropertyAnimator f3918c;

        C0881e(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3916a = viewHolder;
            this.f3917b = view;
            this.f3918c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3917b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f3918c.setListener((Animator.AnimatorListener) null);
            DefaultItemAnimator.this.dispatchAddFinished(this.f3916a);
            DefaultItemAnimator.this.f3902o.remove(this.f3916a);
            DefaultItemAnimator.this.mo6672h();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchAddStarting(this.f3916a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$f */
    class C0882f extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.ViewHolder f3920a;

        /* renamed from: b */
        final /* synthetic */ int f3921b;

        /* renamed from: c */
        final /* synthetic */ View f3922c;

        /* renamed from: d */
        final /* synthetic */ int f3923d;

        /* renamed from: e */
        final /* synthetic */ ViewPropertyAnimator f3924e;

        C0882f(RecyclerView.ViewHolder viewHolder, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3920a = viewHolder;
            this.f3921b = i;
            this.f3922c = view;
            this.f3923d = i2;
            this.f3924e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f3921b != 0) {
                this.f3922c.setTranslationX(0.0f);
            }
            if (this.f3923d != 0) {
                this.f3922c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f3924e.setListener((Animator.AnimatorListener) null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.f3920a);
            DefaultItemAnimator.this.f3903p.remove(this.f3920a);
            DefaultItemAnimator.this.mo6672h();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.f3920a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$g */
    class C0883g extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C0885i f3926a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f3927b;

        /* renamed from: c */
        final /* synthetic */ View f3928c;

        C0883g(C0885i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3926a = iVar;
            this.f3927b = viewPropertyAnimator;
            this.f3928c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3927b.setListener((Animator.AnimatorListener) null);
            this.f3928c.setAlpha(1.0f);
            this.f3928c.setTranslationX(0.0f);
            this.f3928c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f3926a.f3934a, true);
            DefaultItemAnimator.this.f3905r.remove(this.f3926a.f3934a);
            DefaultItemAnimator.this.mo6672h();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f3926a.f3934a, true);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$h */
    class C0884h extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C0885i f3930a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f3931b;

        /* renamed from: c */
        final /* synthetic */ View f3932c;

        C0884h(C0885i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3930a = iVar;
            this.f3931b = viewPropertyAnimator;
            this.f3932c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3931b.setListener((Animator.AnimatorListener) null);
            this.f3932c.setAlpha(1.0f);
            this.f3932c.setTranslationX(0.0f);
            this.f3932c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f3930a.f3935b, false);
            DefaultItemAnimator.this.f3905r.remove(this.f3930a.f3935b);
            DefaultItemAnimator.this.mo6672h();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f3930a.f3935b, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$j */
    private static class C0886j {

        /* renamed from: a */
        public RecyclerView.ViewHolder f3940a;

        /* renamed from: b */
        public int f3941b;

        /* renamed from: c */
        public int f3942c;

        /* renamed from: d */
        public int f3943d;

        /* renamed from: e */
        public int f3944e;

        C0886j(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.f3940a = viewHolder;
            this.f3941b = i;
            this.f3942c = i2;
            this.f3943d = i3;
            this.f3944e = i4;
        }
    }

    /* renamed from: f */
    private void m2859f(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3904q.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new C0880d(viewHolder, animate, view)).start();
    }

    /* renamed from: i */
    private void m2860i(List<C0885i> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0885i iVar = list.get(size);
            if (m2862k(iVar, viewHolder) && iVar.f3934a == null && iVar.f3935b == null) {
                list.remove(iVar);
            }
        }
    }

    /* renamed from: j */
    private void m2861j(C0885i iVar) {
        RecyclerView.ViewHolder viewHolder = iVar.f3934a;
        if (viewHolder != null) {
            m2862k(iVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.f3935b;
        if (viewHolder2 != null) {
            m2862k(iVar, viewHolder2);
        }
    }

    /* renamed from: k */
    private boolean m2862k(C0885i iVar, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (iVar.f3935b == viewHolder) {
            iVar.f3935b = null;
        } else if (iVar.f3934a != viewHolder) {
            return false;
        } else {
            iVar.f3934a = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    /* renamed from: l */
    private void m2863l(RecyclerView.ViewHolder viewHolder) {
        if (f3894s == null) {
            f3894s = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f3894s);
        endAnimation(viewHolder);
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        m2863l(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f3896i.add(viewHolder);
        return true;
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        m2863l(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            m2863l(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-i5));
            viewHolder2.itemView.setTranslationY((float) (-i6));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.f3898k.add(new C0885i(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) viewHolder.itemView.getTranslationY());
        m2863l(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.f3897j.add(new C0886j(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        m2863l(viewHolder);
        this.f3895h.add(viewHolder);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6665c(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3902o.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new C0881e(viewHolder, view, animate)).start();
    }

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6667d(C0885i iVar) {
        View view;
        RecyclerView.ViewHolder viewHolder = iVar.f3934a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.f3935b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f3905r.add(iVar.f3934a);
            duration.translationX((float) (iVar.f3938e - iVar.f3936c));
            duration.translationY((float) (iVar.f3939f - iVar.f3937d));
            duration.alpha(0.0f).setListener(new C0883g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f3905r.add(iVar.f3935b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new C0884h(iVar, animate, view2)).start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo6668e(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f3903p.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new C0882f(viewHolder, i5, view, i6, animate)).start();
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f3897j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f3897j.get(size).f3940a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.f3897j.remove(size);
            }
        }
        m2860i(this.f3898k, viewHolder);
        if (this.f3895h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f3896i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f3901n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f3901n.get(size2);
            m2860i(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f3901n.remove(size2);
            }
        }
        for (int size3 = this.f3900m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f3900m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((C0886j) arrayList2.get(size4)).f3940a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3900m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3899l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f3899l.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f3899l.remove(size5);
                }
            }
        }
        this.f3904q.remove(viewHolder);
        this.f3902o.remove(viewHolder);
        this.f3905r.remove(viewHolder);
        this.f3903p.remove(viewHolder);
        mo6672h();
    }

    public void endAnimations() {
        int size = this.f3897j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0886j jVar = this.f3897j.get(size);
            View view = jVar.f3940a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.f3940a);
            this.f3897j.remove(size);
        }
        for (int size2 = this.f3895h.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f3895h.get(size2));
            this.f3895h.remove(size2);
        }
        int size3 = this.f3896i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f3896i.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.f3896i.remove(size3);
        }
        for (int size4 = this.f3898k.size() - 1; size4 >= 0; size4--) {
            m2861j(this.f3898k.get(size4));
        }
        this.f3898k.clear();
        if (isRunning()) {
            for (int size5 = this.f3900m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f3900m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C0886j jVar2 = (C0886j) arrayList.get(size6);
                    View view2 = jVar2.f3940a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.f3940a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3900m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3899l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f3899l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3899l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3901n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f3901n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m2861j((C0885i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3901n.remove(arrayList3);
                    }
                }
            }
            mo6671g(this.f3904q);
            mo6671g(this.f3903p);
            mo6671g(this.f3902o);
            mo6671g(this.f3905r);
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6671g(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6672h() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return !this.f3896i.isEmpty() || !this.f3898k.isEmpty() || !this.f3897j.isEmpty() || !this.f3895h.isEmpty() || !this.f3903p.isEmpty() || !this.f3904q.isEmpty() || !this.f3902o.isEmpty() || !this.f3905r.isEmpty() || !this.f3900m.isEmpty() || !this.f3899l.isEmpty() || !this.f3901n.isEmpty();
    }

    public void runPendingAnimations() {
        boolean z = !this.f3895h.isEmpty();
        boolean z2 = !this.f3897j.isEmpty();
        boolean z3 = !this.f3898k.isEmpty();
        boolean z4 = !this.f3896i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.f3895h.iterator();
            while (it.hasNext()) {
                m2859f(it.next());
            }
            this.f3895h.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f3897j);
                this.f3900m.add(arrayList);
                this.f3897j.clear();
                C0877a aVar = new C0877a(arrayList);
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((C0886j) arrayList.get(0)).f3940a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f3898k);
                this.f3901n.add(arrayList2);
                this.f3898k.clear();
                C0878b bVar = new C0878b(arrayList2);
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((C0885i) arrayList2.get(0)).f3934a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f3896i);
                this.f3899l.add(arrayList3);
                this.f3896i.clear();
                C0879c cVar = new C0879c(arrayList3);
                if (z || z2 || z3) {
                    long j = 0;
                    long removeDuration = z ? getRemoveDuration() : 0;
                    long moveDuration = z2 ? getMoveDuration() : 0;
                    if (z3) {
                        j = getChangeDuration();
                    }
                    ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, cVar, removeDuration + Math.max(moveDuration, j));
                    return;
                }
                cVar.run();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.DefaultItemAnimator$i */
    private static class C0885i {

        /* renamed from: a */
        public RecyclerView.ViewHolder f3934a;

        /* renamed from: b */
        public RecyclerView.ViewHolder f3935b;

        /* renamed from: c */
        public int f3936c;

        /* renamed from: d */
        public int f3937d;

        /* renamed from: e */
        public int f3938e;

        /* renamed from: f */
        public int f3939f;

        private C0885i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f3934a = viewHolder;
            this.f3935b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3934a + ", newHolder=" + this.f3935b + ", fromX=" + this.f3936c + ", fromY=" + this.f3937d + ", toX=" + this.f3938e + ", toY=" + this.f3939f + '}';
        }

        C0885i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.f3936c = i;
            this.f3937d = i2;
            this.f3938e = i3;
            this.f3939f = i4;
        }
    }
}
