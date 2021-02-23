package com.google.firebase.abt;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.remoteconfig.internal.LegacyConfigsHandler;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AbtExperimentInfo {

    /* renamed from: g */
    private static final String[] f18854g = {"experimentId", LegacyConfigsHandler.EXPERIMENT_START_TIME_KEY, LegacyConfigsHandler.EXPERIMENT_TIME_TO_LIVE_KEY, LegacyConfigsHandler.EXPERIMENT_TRIGGER_TIMEOUT_KEY, "variantId"};
    @VisibleForTesting

    /* renamed from: h */
    static final DateFormat f18855h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: a */
    private final String f18856a;

    /* renamed from: b */
    private final String f18857b;

    /* renamed from: c */
    private final String f18858c;

    /* renamed from: d */
    private final Date f18859d;

    /* renamed from: e */
    private final long f18860e;

    /* renamed from: f */
    private final long f18861f;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j, long j2) {
        this.f18856a = str;
        this.f18857b = str2;
        this.f18858c = str3;
        this.f18859d = date;
        this.f18860e = j;
        this.f18861f = j2;
    }

    /* renamed from: a */
    static AbtExperimentInfo m11128a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str = conditionalUserProperty.triggerEventName;
        if (str == null) {
            str = "";
        }
        return new AbtExperimentInfo(conditionalUserProperty.name, String.valueOf(conditionalUserProperty.value), str, new Date(conditionalUserProperty.creationTimestamp), conditionalUserProperty.triggerTimeout, conditionalUserProperty.timeToLive);
    }

    /* renamed from: b */
    static AbtExperimentInfo m11129b(Map<String, String> map) {
        m11131h(map);
        try {
            return new AbtExperimentInfo(map.get("experimentId"), map.get("variantId"), map.containsKey(LegacyConfigsHandler.EXPERIMENT_TRIGGER_EVENT_KEY) ? map.get(LegacyConfigsHandler.EXPERIMENT_TRIGGER_EVENT_KEY) : "", f18855h.parse(map.get(LegacyConfigsHandler.EXPERIMENT_START_TIME_KEY)), Long.parseLong(map.get(LegacyConfigsHandler.EXPERIMENT_TRIGGER_TIMEOUT_KEY)), Long.parseLong(map.get(LegacyConfigsHandler.EXPERIMENT_TIME_TO_LIVE_KEY)));
        } catch (ParseException e) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e);
        } catch (NumberFormatException e2) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e2);
        }
    }

    /* renamed from: g */
    static void m11130g(AbtExperimentInfo abtExperimentInfo) {
        m11131h(abtExperimentInfo.mo20745f());
    }

    /* renamed from: h */
    private static void m11131h(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : f18854g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo20742c() {
        return this.f18856a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo20743d() {
        return this.f18859d.getTime();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public AnalyticsConnector.ConditionalUserProperty mo20744e(String str) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = str;
        conditionalUserProperty.creationTimestamp = mo20743d();
        conditionalUserProperty.name = this.f18856a;
        conditionalUserProperty.value = this.f18857b;
        conditionalUserProperty.triggerEventName = TextUtils.isEmpty(this.f18858c) ? null : this.f18858c;
        conditionalUserProperty.triggerTimeout = this.f18860e;
        conditionalUserProperty.timeToLive = this.f18861f;
        return conditionalUserProperty;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: f */
    public Map<String, String> mo20745f() {
        HashMap hashMap = new HashMap();
        hashMap.put("experimentId", this.f18856a);
        hashMap.put("variantId", this.f18857b);
        hashMap.put(LegacyConfigsHandler.EXPERIMENT_TRIGGER_EVENT_KEY, this.f18858c);
        hashMap.put(LegacyConfigsHandler.EXPERIMENT_START_TIME_KEY, f18855h.format(this.f18859d));
        hashMap.put(LegacyConfigsHandler.EXPERIMENT_TRIGGER_TIMEOUT_KEY, Long.toString(this.f18860e));
        hashMap.put(LegacyConfigsHandler.EXPERIMENT_TIME_TO_LIVE_KEY, Long.toString(this.f18861f));
        return hashMap;
    }
}
