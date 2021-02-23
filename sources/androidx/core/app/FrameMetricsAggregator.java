package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;

    /* renamed from: a */
    private C0412b f1965a;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }

    @RequiresApi(24)
    /* renamed from: androidx.core.app.FrameMetricsAggregator$a */
    private static class C0410a extends C0412b {

        /* renamed from: e */
        private static HandlerThread f1966e;

        /* renamed from: f */
        private static Handler f1967f;

        /* renamed from: a */
        int f1968a;

        /* renamed from: b */
        SparseIntArray[] f1969b = new SparseIntArray[9];

        /* renamed from: c */
        private ArrayList<WeakReference<Activity>> f1970c = new ArrayList<>();

        /* renamed from: d */
        Window.OnFrameMetricsAvailableListener f1971d = new C0411a();

        /* renamed from: androidx.core.app.FrameMetricsAggregator$a$a */
        class C0411a implements Window.OnFrameMetricsAvailableListener {
            C0411a() {
            }

            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                C0410a aVar = C0410a.this;
                if ((aVar.f1968a & 1) != 0) {
                    aVar.mo3615f(aVar.f1969b[0], frameMetrics.getMetric(8));
                }
                C0410a aVar2 = C0410a.this;
                if ((aVar2.f1968a & 2) != 0) {
                    aVar2.mo3615f(aVar2.f1969b[1], frameMetrics.getMetric(1));
                }
                C0410a aVar3 = C0410a.this;
                if ((aVar3.f1968a & 4) != 0) {
                    aVar3.mo3615f(aVar3.f1969b[2], frameMetrics.getMetric(3));
                }
                C0410a aVar4 = C0410a.this;
                if ((aVar4.f1968a & 8) != 0) {
                    aVar4.mo3615f(aVar4.f1969b[3], frameMetrics.getMetric(4));
                }
                C0410a aVar5 = C0410a.this;
                if ((aVar5.f1968a & 16) != 0) {
                    aVar5.mo3615f(aVar5.f1969b[4], frameMetrics.getMetric(5));
                }
                C0410a aVar6 = C0410a.this;
                if ((aVar6.f1968a & 64) != 0) {
                    aVar6.mo3615f(aVar6.f1969b[6], frameMetrics.getMetric(7));
                }
                C0410a aVar7 = C0410a.this;
                if ((aVar7.f1968a & 32) != 0) {
                    aVar7.mo3615f(aVar7.f1969b[5], frameMetrics.getMetric(6));
                }
                C0410a aVar8 = C0410a.this;
                if ((aVar8.f1968a & 128) != 0) {
                    aVar8.mo3615f(aVar8.f1969b[7], frameMetrics.getMetric(0));
                }
                C0410a aVar9 = C0410a.this;
                if ((aVar9.f1968a & 256) != 0) {
                    aVar9.mo3615f(aVar9.f1969b[8], frameMetrics.getMetric(2));
                }
            }
        }

        C0410a(int i) {
            this.f1968a = i;
        }

        /* renamed from: a */
        public void mo3610a(Activity activity) {
            if (f1966e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f1966e = handlerThread;
                handlerThread.start();
                f1967f = new Handler(f1966e.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                SparseIntArray[] sparseIntArrayArr = this.f1969b;
                if (sparseIntArrayArr[i] == null && (this.f1968a & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f1971d, f1967f);
            this.f1970c.add(new WeakReference(activity));
        }

        /* renamed from: b */
        public SparseIntArray[] mo3611b() {
            return this.f1969b;
        }

        /* renamed from: c */
        public SparseIntArray[] mo3612c(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f1970c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference next = it.next();
                if (next.get() == activity) {
                    this.f1970c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1971d);
            return this.f1969b;
        }

        /* renamed from: d */
        public SparseIntArray[] mo3613d() {
            SparseIntArray[] sparseIntArrayArr = this.f1969b;
            this.f1969b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        /* renamed from: e */
        public SparseIntArray[] mo3614e() {
            for (int size = this.f1970c.size() - 1; size >= 0; size--) {
                WeakReference weakReference = this.f1970c.get(size);
                Activity activity = (Activity) weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1971d);
                    this.f1970c.remove(size);
                }
            }
            return this.f1969b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo3615f(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }
    }

    /* renamed from: androidx.core.app.FrameMetricsAggregator$b */
    private static class C0412b {
        C0412b() {
        }

        /* renamed from: a */
        public void mo3610a(Activity activity) {
        }

        /* renamed from: b */
        public SparseIntArray[] mo3611b() {
            return null;
        }

        /* renamed from: c */
        public SparseIntArray[] mo3612c(Activity activity) {
            return null;
        }

        /* renamed from: d */
        public SparseIntArray[] mo3613d() {
            return null;
        }

        /* renamed from: e */
        public SparseIntArray[] mo3614e() {
            return null;
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(@NonNull Activity activity) {
        this.f1965a.mo3610a(activity);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.f1965a.mo3611b();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity activity) {
        return this.f1965a.mo3612c(activity);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.f1965a.mo3613d();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.f1965a.mo3614e();
    }

    public FrameMetricsAggregator(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1965a = new C0410a(i);
        } else {
            this.f1965a = new C0412b();
        }
    }
}
