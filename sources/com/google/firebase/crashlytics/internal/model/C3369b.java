package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: com.google.firebase.crashlytics.internal.model.b */
/* compiled from: AutoValue_CrashlyticsReport_CustomAttribute */
final class C3369b extends CrashlyticsReport.CustomAttribute {

    /* renamed from: a */
    private final String f19276a;

    /* renamed from: b */
    private final String f19277b;

    /* renamed from: com.google.firebase.crashlytics.internal.model.b$b */
    /* compiled from: AutoValue_CrashlyticsReport_CustomAttribute */
    static final class C3371b extends CrashlyticsReport.CustomAttribute.Builder {

        /* renamed from: a */
        private String f19278a;

        /* renamed from: b */
        private String f19279b;

        C3371b() {
        }

        public CrashlyticsReport.CustomAttribute build() {
            String str = "";
            if (this.f19278a == null) {
                str = str + " key";
            }
            if (this.f19279b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new C3369b(this.f19278a, this.f19279b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.CustomAttribute.Builder setKey(String str) {
            if (str != null) {
                this.f19278a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        public CrashlyticsReport.CustomAttribute.Builder setValue(String str) {
            if (str != null) {
                this.f19279b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.CustomAttribute)) {
            return false;
        }
        CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
        if (!this.f19276a.equals(customAttribute.getKey()) || !this.f19277b.equals(customAttribute.getValue())) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getKey() {
        return this.f19276a;
    }

    @NonNull
    public String getValue() {
        return this.f19277b;
    }

    public int hashCode() {
        return ((this.f19276a.hashCode() ^ 1000003) * 1000003) ^ this.f19277b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f19276a + ", value=" + this.f19277b + "}";
    }

    private C3369b(String str, String str2) {
        this.f19276a = str;
        this.f19277b = str2;
    }
}
