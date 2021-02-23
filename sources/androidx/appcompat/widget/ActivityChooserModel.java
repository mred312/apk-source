package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.bumptech.glide.load.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class ActivityChooserModel extends DataSetObservable {

    /* renamed from: n */
    static final String f1133n = ActivityChooserModel.class.getSimpleName();

    /* renamed from: o */
    private static final Object f1134o = new Object();

    /* renamed from: p */
    private static final Map<String, ActivityChooserModel> f1135p = new HashMap();

    /* renamed from: a */
    private final Object f1136a = new Object();

    /* renamed from: b */
    private final List<ActivityResolveInfo> f1137b = new ArrayList();

    /* renamed from: c */
    private final List<HistoricalRecord> f1138c = new ArrayList();

    /* renamed from: d */
    final Context f1139d;

    /* renamed from: e */
    final String f1140e;

    /* renamed from: f */
    private Intent f1141f;

    /* renamed from: g */
    private ActivitySorter f1142g = new C0248a();

    /* renamed from: h */
    private int f1143h = 50;

    /* renamed from: i */
    boolean f1144i = true;

    /* renamed from: j */
    private boolean f1145j = false;

    /* renamed from: k */
    private boolean f1146k = true;

    /* renamed from: l */
    private boolean f1147l = false;

    /* renamed from: m */
    private OnChooseActivityListener f1148m;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal((double) this.weight) + "]";
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[" + "; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal((double) this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserModel$a */
    private static final class C0248a implements ActivitySorter {

        /* renamed from: a */
        private final Map<ComponentName, ActivityResolveInfo> f1149a = new HashMap();

        C0248a() {
        }

        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.f1149a;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserModel$b */
    private final class C0249b extends AsyncTask<Object, Void, Void> {
        C0249b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
            if (r15 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
            if (r15 == null) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b0, code lost:
            if (r15 == null) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d0, code lost:
            if (r15 == null) goto L_0x00d3;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.ActivityChooserModel r7 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x00de }
                android.content.Context r7 = r7.f1139d     // Catch:{ FileNotFoundException -> 0x00de }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00de }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r9 = 0
            L_0x002f:
                if (r9 >= r8) goto L_0x0061
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r10 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r10     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.activity     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r11 = "time"
                long r12 = r10.time     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r11 = "weight"
                float r10 = r10.weight     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                int r9 = r9 + 1
                goto L_0x002f
            L_0x0061:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x00b3, IllegalStateException -> 0x0093, IOException -> 0x0073 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f1144i = r5
                if (r15 == 0) goto L_0x00d3
            L_0x006d:
                r15.close()     // Catch:{ IOException -> 0x00d3 }
                goto L_0x00d3
            L_0x0071:
                r0 = move-exception
                goto L_0x00d4
            L_0x0073:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f1133n     // Catch:{ all -> 0x0071 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
                r3.<init>()     // Catch:{ all -> 0x0071 }
                r3.append(r2)     // Catch:{ all -> 0x0071 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0071 }
                java.lang.String r2 = r2.f1140e     // Catch:{ all -> 0x0071 }
                r3.append(r2)     // Catch:{ all -> 0x0071 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0071 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0071 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f1144i = r5
                if (r15 == 0) goto L_0x00d3
                goto L_0x006d
            L_0x0093:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f1133n     // Catch:{ all -> 0x0071 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
                r3.<init>()     // Catch:{ all -> 0x0071 }
                r3.append(r2)     // Catch:{ all -> 0x0071 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0071 }
                java.lang.String r2 = r2.f1140e     // Catch:{ all -> 0x0071 }
                r3.append(r2)     // Catch:{ all -> 0x0071 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0071 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0071 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f1144i = r5
                if (r15 == 0) goto L_0x00d3
                goto L_0x006d
            L_0x00b3:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f1133n     // Catch:{ all -> 0x0071 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
                r3.<init>()     // Catch:{ all -> 0x0071 }
                r3.append(r2)     // Catch:{ all -> 0x0071 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0071 }
                java.lang.String r2 = r2.f1140e     // Catch:{ all -> 0x0071 }
                r3.append(r2)     // Catch:{ all -> 0x0071 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0071 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0071 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f1144i = r5
                if (r15 == 0) goto L_0x00d3
                goto L_0x006d
            L_0x00d3:
                return r6
            L_0x00d4:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.f1144i = r5
                if (r15 == 0) goto L_0x00dd
                r15.close()     // Catch:{ IOException -> 0x00dd }
            L_0x00dd:
                throw r0
            L_0x00de:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f1133n
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.C0249b.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.f1139d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f1140e = str;
            return;
        }
        this.f1140e = str + ".xml";
    }

    /* renamed from: a */
    private boolean m768a(HistoricalRecord historicalRecord) {
        boolean add = this.f1138c.add(historicalRecord);
        if (add) {
            this.f1146k = true;
            m773l();
            m772k();
            m776r();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: c */
    private void m769c() {
        boolean j = m771j() | m774m();
        m773l();
        if (j) {
            m776r();
            notifyChanged();
        }
    }

    /* renamed from: d */
    public static ActivityChooserModel m770d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f1134o) {
            Map<String, ActivityChooserModel> map = f1135p;
            activityChooserModel = map.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                map.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    /* renamed from: j */
    private boolean m771j() {
        if (!this.f1147l || this.f1141f == null) {
            return false;
        }
        this.f1147l = false;
        this.f1137b.clear();
        List<ResolveInfo> queryIntentActivities = this.f1139d.getPackageManager().queryIntentActivities(this.f1141f, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1137b.add(new ActivityResolveInfo(queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: k */
    private void m772k() {
        if (!this.f1145j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1146k) {
            this.f1146k = false;
            if (!TextUtils.isEmpty(this.f1140e)) {
                new C0249b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f1138c), this.f1140e});
            }
        }
    }

    /* renamed from: l */
    private void m773l() {
        int size = this.f1138c.size() - this.f1143h;
        if (size > 0) {
            this.f1146k = true;
            for (int i = 0; i < size; i++) {
                HistoricalRecord remove = this.f1138c.remove(0);
            }
        }
    }

    /* renamed from: m */
    private boolean m774m() {
        if (!this.f1144i || !this.f1146k || TextUtils.isEmpty(this.f1140e)) {
            return false;
        }
        this.f1144i = false;
        this.f1145j = true;
        m775n();
        return true;
    }

    /* renamed from: n */
    private void m775n() {
        try {
            FileInputStream openFileInput = this.f1139d.openFileInput(this.f1140e);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, Key.STRING_CHARSET_NAME);
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<HistoricalRecord> list = this.f1138c;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e) {
                String str = f1133n;
                Log.e(str, "Error reading historical recrod file: " + this.f1140e, e);
                if (openFileInput == null) {
                }
            } catch (IOException e2) {
                String str2 = f1133n;
                Log.e(str2, "Error reading historical recrod file: " + this.f1140e, e2);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* renamed from: r */
    private boolean m776r() {
        if (this.f1142g == null || this.f1141f == null || this.f1137b.isEmpty() || this.f1138c.isEmpty()) {
            return false;
        }
        this.f1142g.sort(this.f1141f, this.f1137b, Collections.unmodifiableList(this.f1138c));
        return true;
    }

    /* renamed from: b */
    public Intent mo2090b(int i) {
        synchronized (this.f1136a) {
            if (this.f1141f == null) {
                return null;
            }
            m769c();
            ActivityInfo activityInfo = this.f1137b.get(i).resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent(this.f1141f);
            intent.setComponent(componentName);
            if (this.f1148m != null) {
                if (this.f1148m.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            m768a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: e */
    public ResolveInfo mo2091e(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1136a) {
            m769c();
            resolveInfo = this.f1137b.get(i).resolveInfo;
        }
        return resolveInfo;
    }

    /* renamed from: f */
    public int mo2092f() {
        int size;
        synchronized (this.f1136a) {
            m769c();
            size = this.f1137b.size();
        }
        return size;
    }

    /* renamed from: g */
    public int mo2093g(ResolveInfo resolveInfo) {
        synchronized (this.f1136a) {
            m769c();
            List<ActivityResolveInfo> list = this.f1137b;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: h */
    public ResolveInfo mo2094h() {
        synchronized (this.f1136a) {
            m769c();
            if (this.f1137b.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f1137b.get(0).resolveInfo;
            return resolveInfo;
        }
    }

    /* renamed from: i */
    public int mo2095i() {
        int size;
        synchronized (this.f1136a) {
            m769c();
            size = this.f1138c.size();
        }
        return size;
    }

    /* renamed from: o */
    public void mo2096o(int i) {
        synchronized (this.f1136a) {
            m769c();
            ActivityResolveInfo activityResolveInfo = this.f1137b.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.f1137b.get(0);
            float f = activityResolveInfo2 != null ? (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f : 1.0f;
            ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
            m768a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    /* renamed from: p */
    public void mo2097p(Intent intent) {
        synchronized (this.f1136a) {
            if (this.f1141f != intent) {
                this.f1141f = intent;
                this.f1147l = true;
                m769c();
            }
        }
    }

    /* renamed from: q */
    public void mo2098q(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.f1136a) {
            this.f1148m = onChooseActivityListener;
        }
    }
}
