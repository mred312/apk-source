package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;

public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f5070c.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: b */
        public /* bridge */ /* synthetic */ WorkRequest.Builder mo8753b() {
            mo8755d();
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: c */
        public OneTimeWorkRequest mo8752a() {
            if (!this.f5068a || Build.VERSION.SDK_INT < 23 || !this.f5070c.constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: d */
        public Builder mo8755d() {
            return this;
        }

        @NonNull
        public Builder setInputMerger(@NonNull Class<? extends InputMerger> cls) {
            this.f5070c.inputMergerClassName = cls.getName();
            return this;
        }
    }

    OneTimeWorkRequest(Builder builder) {
        super(builder.f5069b, builder.f5070c, builder.f5071d);
    }

    @NonNull
    public static OneTimeWorkRequest from(@NonNull Class<? extends ListenableWorker> cls) {
        return (OneTimeWorkRequest) new Builder(cls).build();
    }

    @NonNull
    public static List<OneTimeWorkRequest> from(@NonNull List<Class<? extends ListenableWorker>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<? extends ListenableWorker> builder : list) {
            arrayList.add(new Builder(builder).build());
        }
        return arrayList;
    }
}
