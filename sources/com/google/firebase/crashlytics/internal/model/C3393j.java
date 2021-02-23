package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.j */
/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application */
final class C3393j extends CrashlyticsReport.Session.Event.Application {

    /* renamed from: a */
    private final CrashlyticsReport.Session.Event.Application.Execution f19350a;

    /* renamed from: b */
    private final ImmutableList<CrashlyticsReport.CustomAttribute> f19351b;

    /* renamed from: c */
    private final Boolean f19352c;

    /* renamed from: d */
    private final int f19353d;

    /* renamed from: com.google.firebase.crashlytics.internal.model.j$b */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application */
    static final class C3395b extends CrashlyticsReport.Session.Event.Application.Builder {

        /* renamed from: a */
        private CrashlyticsReport.Session.Event.Application.Execution f19354a;

        /* renamed from: b */
        private ImmutableList<CrashlyticsReport.CustomAttribute> f19355b;

        /* renamed from: c */
        private Boolean f19356c;

        /* renamed from: d */
        private Integer f19357d;

        public CrashlyticsReport.Session.Event.Application build() {
            String str = "";
            if (this.f19354a == null) {
                str = str + " execution";
            }
            if (this.f19357d == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new C3393j(this.f19354a, this.f19355b, this.f19356c, this.f19357d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Application.Builder setBackground(@Nullable Boolean bool) {
            this.f19356c = bool;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.f19355b = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution execution) {
            if (execution != null) {
                this.f19354a = execution;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i) {
            this.f19357d = Integer.valueOf(i);
            return this;
        }

        C3395b() {
        }

        private C3395b(CrashlyticsReport.Session.Event.Application application) {
            this.f19354a = application.getExecution();
            this.f19355b = application.getCustomAttributes();
            this.f19356c = application.getBackground();
            this.f19357d = Integer.valueOf(application.getUiOrientation());
        }
    }

    public boolean equals(Object obj) {
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (!this.f19350a.equals(application.getExecution()) || ((immutableList = this.f19351b) != null ? !immutableList.equals(application.getCustomAttributes()) : application.getCustomAttributes() != null) || ((bool = this.f19352c) != null ? !bool.equals(application.getBackground()) : application.getBackground() != null) || this.f19353d != application.getUiOrientation()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Boolean getBackground() {
        return this.f19352c;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.f19351b;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.f19350a;
    }

    public int getUiOrientation() {
        return this.f19353d;
    }

    public int hashCode() {
        int hashCode = (this.f19350a.hashCode() ^ 1000003) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList = this.f19351b;
        int i = 0;
        int hashCode2 = (hashCode ^ (immutableList == null ? 0 : immutableList.hashCode())) * 1000003;
        Boolean bool = this.f19352c;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.f19353d;
    }

    public CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        return new C3395b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f19350a + ", customAttributes=" + this.f19351b + ", background=" + this.f19352c + ", uiOrientation=" + this.f19353d + "}";
    }

    private C3393j(CrashlyticsReport.Session.Event.Application.Execution execution, @Nullable ImmutableList<CrashlyticsReport.CustomAttribute> immutableList, @Nullable Boolean bool, int i) {
        this.f19350a = execution;
        this.f19351b = immutableList;
        this.f19352c = bool;
        this.f19353d = i;
    }
}
