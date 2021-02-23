package com.google.firebase.abt;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.internal.LegacyConfigsHandler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirebaseABTesting {

    /* renamed from: a */
    private final AnalyticsConnector f18862a;

    /* renamed from: b */
    private final String f18863b;
    @Nullable

    /* renamed from: c */
    private Integer f18864c = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OriginService {
        public static final String INAPP_MESSAGING = "fiam";
        public static final String REMOTE_CONFIG = "frc";
    }

    public FirebaseABTesting(Context context, AnalyticsConnector analyticsConnector, String str) {
        this.f18862a = analyticsConnector;
        this.f18863b = str;
    }

    /* renamed from: a */
    private void m11136a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        this.f18862a.setConditionalUserProperty(conditionalUserProperty);
    }

    /* renamed from: b */
    private void m11137b(List<AbtExperimentInfo> list) {
        ArrayDeque arrayDeque = new ArrayDeque(m11139d());
        int g = m11142g();
        for (AbtExperimentInfo next : list) {
            while (arrayDeque.size() >= g) {
                m11143h(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).name);
            }
            AnalyticsConnector.ConditionalUserProperty e = next.mo20744e(this.f18863b);
            m11136a(e);
            arrayDeque.offer(e);
        }
    }

    /* renamed from: c */
    private static List<AbtExperimentInfo> m11138c(List<Map<String, String>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> b : list) {
            arrayList.add(AbtExperimentInfo.m11129b(b));
        }
        return arrayList;
    }

    @WorkerThread
    /* renamed from: d */
    private List<AnalyticsConnector.ConditionalUserProperty> m11139d() {
        return this.f18862a.getConditionalUserProperties(this.f18863b, "");
    }

    /* renamed from: e */
    private ArrayList<AbtExperimentInfo> m11140e(List<AbtExperimentInfo> list, Set<String> set) {
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<>();
        for (AbtExperimentInfo next : list) {
            if (!set.contains(next.mo20742c())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private ArrayList<AnalyticsConnector.ConditionalUserProperty> m11141f(List<AnalyticsConnector.ConditionalUserProperty> list, Set<String> set) {
        ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList<>();
        for (AnalyticsConnector.ConditionalUserProperty next : list) {
            if (!set.contains(next.name)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @WorkerThread
    /* renamed from: g */
    private int m11142g() {
        if (this.f18864c == null) {
            this.f18864c = Integer.valueOf(this.f18862a.getMaxUserProperties(this.f18863b));
        }
        return this.f18864c.intValue();
    }

    /* renamed from: h */
    private void m11143h(String str) {
        this.f18862a.clearConditionalUserProperty(str, (String) null, (Bundle) null);
    }

    /* renamed from: i */
    private void m11144i(Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : collection) {
            m11143h(conditionalUserProperty.name);
        }
    }

    /* renamed from: j */
    private void m11145j(List<AbtExperimentInfo> list) {
        if (list.isEmpty()) {
            removeAllExperiments();
            return;
        }
        HashSet hashSet = new HashSet();
        for (AbtExperimentInfo c : list) {
            hashSet.add(c.mo20742c());
        }
        List<AnalyticsConnector.ConditionalUserProperty> d = m11139d();
        HashSet hashSet2 = new HashSet();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : d) {
            hashSet2.add(conditionalUserProperty.name);
        }
        m11144i(m11141f(d, hashSet));
        m11137b(m11140e(list, hashSet2));
    }

    /* renamed from: k */
    private void m11146k() {
        if (this.f18862a == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    @WorkerThread
    public List<AbtExperimentInfo> getAllExperiments() {
        m11146k();
        List<AnalyticsConnector.ConditionalUserProperty> d = m11139d();
        ArrayList arrayList = new ArrayList();
        for (AnalyticsConnector.ConditionalUserProperty a : d) {
            arrayList.add(AbtExperimentInfo.m11128a(a));
        }
        return arrayList;
    }

    @WorkerThread
    public void removeAllExperiments() {
        m11146k();
        m11144i(m11139d());
    }

    @WorkerThread
    public void replaceAllExperiments(List<Map<String, String>> list) {
        m11146k();
        if (list != null) {
            m11145j(m11138c(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }

    @WorkerThread
    public void reportActiveExperiment(AbtExperimentInfo abtExperimentInfo) {
        m11146k();
        AbtExperimentInfo.m11130g(abtExperimentInfo);
        ArrayList arrayList = new ArrayList();
        Map<String, String> f = abtExperimentInfo.mo20745f();
        f.remove(LegacyConfigsHandler.EXPERIMENT_TRIGGER_EVENT_KEY);
        arrayList.add(AbtExperimentInfo.m11129b(f));
        m11137b(arrayList);
    }

    @WorkerThread
    public void validateRunningExperiments(List<AbtExperimentInfo> list) {
        m11146k();
        HashSet hashSet = new HashSet();
        for (AbtExperimentInfo c : list) {
            hashSet.add(c.mo20742c());
        }
        m11144i(m11141f(m11139d(), hashSet));
    }
}
