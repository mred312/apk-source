package com.google.firebase.crashlytics.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence {

    /* renamed from: g */
    private static final Charset f19455g = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: h */
    private static final int f19456h = 15;

    /* renamed from: i */
    private static final CrashlyticsReportJsonTransform f19457i = new CrashlyticsReportJsonTransform();

    /* renamed from: j */
    private static final Comparator<? super File> f19458j = C3443e.m11648a();

    /* renamed from: k */
    private static final FilenameFilter f19459k = C3444f.m11649a();
    @NonNull

    /* renamed from: a */
    private final AtomicInteger f19460a = new AtomicInteger(0);
    @NonNull

    /* renamed from: b */
    private final File f19461b;
    @NonNull

    /* renamed from: c */
    private final File f19462c;
    @NonNull

    /* renamed from: d */
    private final File f19463d;
    @NonNull

    /* renamed from: e */
    private final File f19464e;
    @NonNull

    /* renamed from: f */
    private final SettingsDataProvider f19465f;

    public CrashlyticsReportPersistence(@NonNull File file, @NonNull SettingsDataProvider settingsDataProvider) {
        File file2 = new File(file, "report-persistence");
        this.f19461b = new File(file2, "sessions");
        this.f19462c = new File(file2, "priority-reports");
        this.f19463d = new File(file2, "reports");
        this.f19464e = new File(file2, "native-reports");
        this.f19465f = settingsDataProvider;
    }

    /* renamed from: A */
    private void m11613A(@NonNull File file, long j) {
        boolean z;
        List<File> l = m11628l(file, f19459k);
        if (l.isEmpty()) {
            Logger logger = Logger.getLogger();
            logger.mo20859d("Session " + file.getName() + " has no events.");
            return;
        }
        Collections.sort(l);
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = l.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File next = it.next();
                try {
                    arrayList.add(f19457i.eventFromJson(m11639w(next)));
                    if (z || m11630n(next.getName())) {
                        z = true;
                    }
                } catch (IOException e) {
                    Logger logger2 = Logger.getLogger();
                    logger2.mo20860d("Could not add event to report for " + next, e);
                }
            }
        }
        String str = null;
        File file2 = new File(file, "user");
        if (file2.isFile()) {
            try {
                str = m11639w(file2);
            } catch (IOException e2) {
                Logger logger3 = Logger.getLogger();
                logger3.mo20860d("Could not read user ID file in " + file.getName(), e2);
            }
        }
        m11614B(new File(file, "report"), z ? this.f19462c : this.f19463d, arrayList, j, z, str);
    }

    /* renamed from: B */
    private static void m11614B(@NonNull File file, @NonNull File file2, @NonNull List<CrashlyticsReport.Session.Event> list, long j, boolean z, @Nullable String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f19457i;
            CrashlyticsReport withEvents = crashlyticsReportJsonTransform.reportFromJson(m11639w(file)).withSessionEndFields(j, z, str).withEvents(ImmutableList.from(list));
            CrashlyticsReport.Session session = withEvents.getSession();
            if (session != null) {
                m11638v(file2);
                m11616D(new File(file2, session.getIdentifier()), crashlyticsReportJsonTransform.reportToJson(withEvents));
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.mo20860d("Could not synthesize final report file for " + file, e);
        }
    }

    /* renamed from: C */
    private static int m11615C(@NonNull File file, int i) {
        List<File> l = m11628l(file, C3441c.m11646a());
        Collections.sort(l, C3442d.m11647a());
        return m11620d(l, i);
    }

    /* renamed from: D */
    private static void m11616D(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f19455g);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable unused) {
        }
        throw th;
    }

    @NonNull
    /* renamed from: c */
    private List<File> m11619c(@Nullable String str) {
        List<File> k = m11627k(this.f19461b, C3440b.m11645a(str));
        Collections.sort(k, f19458j);
        if (k.size() <= 8) {
            return k;
        }
        for (File x : k.subList(8, k.size())) {
            m11640x(x);
        }
        return k.subList(0, 8);
    }

    /* renamed from: d */
    private static int m11620d(List<File> list, int i) {
        int size = list.size();
        for (File next : list) {
            if (size <= i) {
                return size;
            }
            m11640x(next);
            size--;
        }
        return size;
    }

    /* renamed from: e */
    private void m11621e() {
        int i = this.f19465f.getSettings().getSessionData().maxCompleteSessionsCount;
        List<File> i2 = m11625i();
        int size = i2.size();
        if (size > i) {
            for (File delete : i2.subList(i, size)) {
                delete.delete();
            }
        }
    }

    @NonNull
    /* renamed from: f */
    private static List<File> m11622f(@NonNull List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (List<File> size : listArr) {
            i += size.size();
        }
        arrayList.ensureCapacity(i);
        for (List<File> addAll : listArr) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: g */
    private static String m11623g(int i, boolean z) {
        String format = String.format(Locale.US, "%010d", new Object[]{Integer.valueOf(i)});
        String str = z ? "_" : "";
        return NotificationCompat.CATEGORY_EVENT + format + str;
    }

    @NonNull
    /* renamed from: h */
    private static List<File> m11624h(@NonNull File file) {
        return m11627k(file, (FileFilter) null);
    }

    @NonNull
    /* renamed from: i */
    private List<File> m11625i() {
        return m11641y(m11622f(m11624h(this.f19462c), m11624h(this.f19464e)), m11624h(this.f19463d));
    }

    @NonNull
    /* renamed from: j */
    private static String m11626j(@NonNull String str) {
        return str.substring(0, f19456h);
    }

    @NonNull
    /* renamed from: k */
    private static List<File> m11627k(@NonNull File file, @Nullable FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    @NonNull
    /* renamed from: l */
    private static List<File> m11628l(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    @NonNull
    /* renamed from: m */
    private File m11629m(@NonNull String str) {
        return new File(this.f19461b, str);
    }

    /* renamed from: n */
    private static boolean m11630n(@NonNull String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && str.endsWith("_");
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public static boolean m11631o(@NonNull File file, @NonNull String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_");
    }

    /* renamed from: p */
    static /* synthetic */ boolean m11632p(String str, File file) {
        return file.isDirectory() && !file.getName().equals(str);
    }

    /* renamed from: t */
    private static boolean m11636t(@NonNull File file) {
        return file.exists() || file.mkdirs();
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public static int m11637u(@NonNull File file, @NonNull File file2) {
        return m11626j(file.getName()).compareTo(m11626j(file2.getName()));
    }

    @NonNull
    /* renamed from: v */
    private static File m11638v(@NonNull File file) {
        if (m11636t(file)) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    @NonNull
    /* renamed from: w */
    private static String m11639w(@NonNull File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f19455g);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        throw th;
    }

    /* renamed from: x */
    private static void m11640x(@Nullable File file) {
        if (file != null) {
            if (file.isDirectory()) {
                for (File x : file.listFiles()) {
                    m11640x(x);
                }
            }
            file.delete();
        }
    }

    @NonNull
    /* renamed from: y */
    private static List<File> m11641y(@NonNull List<File>... listArr) {
        for (List<File> sort : listArr) {
            Collections.sort(sort, f19458j);
        }
        return m11622f(listArr);
    }

    /* renamed from: z */
    private static void m11642z(@NonNull File file, @NonNull File file2, @NonNull CrashlyticsReport.FilesPayload filesPayload, @NonNull String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f19457i;
            CrashlyticsReport withNdkPayload = crashlyticsReportJsonTransform.reportFromJson(m11639w(file)).withNdkPayload(filesPayload);
            m11638v(file2);
            m11616D(new File(file2, str), crashlyticsReportJsonTransform.reportToJson(withNdkPayload));
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.mo20860d("Could not synthesize final native report file for " + file, e);
        }
    }

    public void deleteAllReports() {
        for (File delete : m11625i()) {
            delete.delete();
        }
    }

    public void deleteFinalizedReport(String str) {
        FilenameFilter a = C3439a.m11644a(str);
        for (File delete : m11622f(m11628l(this.f19462c, a), m11628l(this.f19464e, a), m11628l(this.f19463d, a))) {
            delete.delete();
        }
    }

    public void finalizeReports(@Nullable String str, long j) {
        for (File next : m11619c(str)) {
            Logger logger = Logger.getLogger();
            logger.mo20859d("Finalizing report for session " + next.getName());
            m11613A(next, j);
            m11640x(next);
        }
        m11621e();
    }

    public void finalizeSessionWithNativeEvent(@NonNull String str, @NonNull CrashlyticsReport.FilesPayload filesPayload) {
        m11642z(new File(m11629m(str), "report"), this.f19464e, filesPayload, str);
    }

    @NonNull
    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> i = m11625i();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(i.size());
        for (File next : m11625i()) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.create(f19457i.reportFromJson(m11639w(next)), next.getName()));
            } catch (IOException e) {
                Logger logger = Logger.getLogger();
                logger.mo20860d("Could not load report file " + next + "; deleting", e);
                next.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str) {
        persistEvent(event, str, false);
    }

    public void persistReport(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().mo20859d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            File m = m11629m(identifier);
            m11638v(m);
            m11616D(new File(m, "report"), f19457i.reportToJson(crashlyticsReport));
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.mo20860d("Could not persist report for session " + identifier, e);
        }
    }

    public void persistUserIdForSession(@NonNull String str, @NonNull String str2) {
        try {
            m11616D(new File(m11629m(str2), "user"), str);
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.mo20860d("Could not persist user ID for session " + str2, e);
        }
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str, boolean z) {
        int i = this.f19465f.getSettings().getSessionData().maxCustomExceptionEvents;
        File m = m11629m(str);
        try {
            m11616D(new File(m, m11623g(this.f19460a.getAndIncrement(), z)), f19457i.eventToJson(event));
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.mo20860d("Could not persist event for session " + str, e);
        }
        m11615C(m, i);
    }
}
