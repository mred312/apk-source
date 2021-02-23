package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.C3325k;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.ndk.NativeFileUtils;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
import com.google.firebase.crashlytics.internal.report.ReportManager;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.DefaultCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.NativeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.firebase.crashlytics.internal.common.h */
/* compiled from: CrashlyticsController */
class C3287h {

    /* renamed from: A */
    static final FilenameFilter f19089A = C3286g.m11314a();

    /* renamed from: B */
    static final FilenameFilter f19090B = new C3309p();

    /* renamed from: C */
    static final Comparator<File> f19091C = new C3310q();

    /* renamed from: D */
    static final Comparator<File> f19092D = new C3311r();
    /* access modifiers changed from: private */

    /* renamed from: E */
    public static final Pattern f19093E = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: F */
    private static final Map<String, String> f19094F = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");

    /* renamed from: G */
    private static final String[] f19095G = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* renamed from: z */
    static final FilenameFilter f19096z = new C3304k("BeginSession");

    /* renamed from: a */
    private final AtomicInteger f19097a = new AtomicInteger(0);

    /* renamed from: b */
    private final Context f19098b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DataCollectionArbiter f19099c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C3324j f19100d;

    /* renamed from: e */
    private final UserMetadata f19101e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C3281f f19102f;

    /* renamed from: g */
    private final HttpRequestFactory f19103g;

    /* renamed from: h */
    private final IdManager f19104h;

    /* renamed from: i */
    private final FileStore f19105i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C3276a f19106j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final ReportUploader.Provider f19107k;

    /* renamed from: l */
    private final C3291b0 f19108l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final LogFileManager f19109m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final ReportManager f19110n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final ReportUploader.HandlingExceptionCheck f19111o;

    /* renamed from: p */
    private final CrashlyticsNativeComponent f19112p;

    /* renamed from: q */
    private final StackTraceTrimmingStrategy f19113q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final String f19114r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final AnalyticsEventLogger f19115s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final C3335s f19116t;

    /* renamed from: u */
    private C3325k f19117u;

    /* renamed from: v */
    TaskCompletionSource<Boolean> f19118v = new TaskCompletionSource<>();

    /* renamed from: w */
    TaskCompletionSource<Boolean> f19119w = new TaskCompletionSource<>();

    /* renamed from: x */
    TaskCompletionSource<Void> f19120x = new TaskCompletionSource<>();

    /* renamed from: y */
    AtomicBoolean f19121y = new AtomicBoolean(false);

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$a */
    /* compiled from: CrashlyticsController */
    class C3288a implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ long f19122a;

        /* renamed from: b */
        final /* synthetic */ String f19123b;

        C3288a(long j, String str) {
            this.f19122a = j;
            this.f19123b = str;
        }

        /* renamed from: a */
        public Void call() {
            if (C3287h.this.mo20984m0()) {
                return null;
            }
            C3287h.this.f19109m.writeToLog(this.f19122a, this.f19123b);
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$a0 */
    /* compiled from: CrashlyticsController */
    static class C3289a0 implements FilenameFilter {
        C3289a0() {
        }

        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$b */
    /* compiled from: CrashlyticsController */
    class C3290b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Date f19125a;

        /* renamed from: b */
        final /* synthetic */ Throwable f19126b;

        /* renamed from: c */
        final /* synthetic */ Thread f19127c;

        C3290b(Date date, Throwable th, Thread thread) {
            this.f19125a = date;
            this.f19126b = th;
            this.f19127c = thread;
        }

        public void run() {
            if (!C3287h.this.mo20984m0()) {
                long s = C3287h.m11363i0(this.f19125a);
                String t = C3287h.this.m11351a0();
                if (t == null) {
                    Logger.getLogger().mo20859d("Tried to write a non-fatal exception while no session was open.");
                    return;
                }
                long j = s;
                C3287h.this.f19116t.mo21044k(this.f19126b, this.f19127c, C3287h.m11389y0(t), j);
                C3287h.this.m11339S(this.f19127c, this.f19126b, t, j);
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$b0 */
    /* compiled from: CrashlyticsController */
    private static final class C3291b0 implements LogFileManager.DirectoryProvider {

        /* renamed from: a */
        private final FileStore f19129a;

        public C3291b0(FileStore fileStore) {
            this.f19129a = fileStore;
        }

        public File getLogFileDir() {
            File file = new File(this.f19129a.getFilesDir(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$c */
    /* compiled from: CrashlyticsController */
    class C3292c implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ UserMetadata f19130a;

        C3292c(UserMetadata userMetadata) {
            this.f19130a = userMetadata;
        }

        /* renamed from: a */
        public Void call() {
            String t = C3287h.this.m11351a0();
            if (t == null) {
                Logger.getLogger().mo20859d("Tried to cache user data while no session was open.");
                return null;
            }
            C3287h.this.f19116t.mo21045l(C3287h.m11389y0(t));
            new C3329n(C3287h.this.mo20980d0()).mo21038i(t, this.f19130a);
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$c0 */
    /* compiled from: CrashlyticsController */
    private final class C3293c0 implements ReportUploader.ReportFilesProvider {
        private C3293c0() {
        }

        public File[] getCompleteSessionFiles() {
            return C3287h.this.mo20986p0();
        }

        public File[] getNativeReportFiles() {
            return C3287h.this.mo20987s0();
        }

        /* synthetic */ C3293c0(C3287h hVar, C3304k kVar) {
            this();
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$d */
    /* compiled from: CrashlyticsController */
    class C3294d implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ Map f19133a;

        C3294d(Map map) {
            this.f19133a = map;
        }

        /* renamed from: a */
        public Void call() {
            new C3329n(C3287h.this.mo20980d0()).mo21037h(C3287h.this.m11351a0(), this.f19133a);
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$d0 */
    /* compiled from: CrashlyticsController */
    private final class C3295d0 implements ReportUploader.HandlingExceptionCheck {
        private C3295d0() {
        }

        public boolean isHandlingException() {
            return C3287h.this.mo20984m0();
        }

        /* synthetic */ C3295d0(C3287h hVar, C3304k kVar) {
            this();
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$e */
    /* compiled from: CrashlyticsController */
    class C3296e implements Callable<Void> {
        C3296e() {
        }

        /* renamed from: a */
        public Void call() {
            C3287h.this.m11333P();
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$e0 */
    /* compiled from: CrashlyticsController */
    private static final class C3297e0 implements Runnable {

        /* renamed from: a */
        private final Context f19137a;

        /* renamed from: b */
        private final Report f19138b;

        /* renamed from: c */
        private final ReportUploader f19139c;

        /* renamed from: d */
        private final boolean f19140d;

        public C3297e0(Context context, Report report, ReportUploader reportUploader, boolean z) {
            this.f19137a = context;
            this.f19138b = report;
            this.f19139c = reportUploader;
            this.f19140d = z;
        }

        public void run() {
            if (CommonUtils.canTryConnection(this.f19137a)) {
                Logger.getLogger().mo20859d("Attempting to send crash report at time of crash...");
                this.f19139c.uploadReport(this.f19138b, this.f19140d);
            }
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$f */
    /* compiled from: CrashlyticsController */
    class C3298f implements Runnable {
        C3298f() {
        }

        public void run() {
            C3287h hVar = C3287h.this;
            hVar.mo20973M(hVar.m11377r0(new C3289a0()));
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$f0 */
    /* compiled from: CrashlyticsController */
    static class C3299f0 implements FilenameFilter {

        /* renamed from: a */
        private final String f19142a;

        public C3299f0(String str) {
            this.f19142a = str;
        }

        public boolean accept(File file, String str) {
            if (!str.equals(this.f19142a + ClsFileOutputStream.SESSION_FILE_EXTENSION) && str.contains(this.f19142a) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$g */
    /* compiled from: CrashlyticsController */
    class C3300g implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ Set f19143a;

        C3300g(C3287h hVar, Set set) {
            this.f19143a = set;
        }

        public boolean accept(File file, String str) {
            if (str.length() < 35) {
                return false;
            }
            return this.f19143a.contains(str.substring(0, 35));
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$h */
    /* compiled from: CrashlyticsController */
    class C3301h implements C3321y {

        /* renamed from: a */
        final /* synthetic */ String f19144a;

        /* renamed from: b */
        final /* synthetic */ String f19145b;

        /* renamed from: c */
        final /* synthetic */ long f19146c;

        C3301h(C3287h hVar, String str, String str2, long j) {
            this.f19144a = str;
            this.f19145b = str2;
            this.f19146c = j;
        }

        /* renamed from: a */
        public void mo21008a(CodedOutputStream codedOutputStream) {
            SessionProtobufHelper.writeBeginSession(codedOutputStream, this.f19144a, this.f19145b, this.f19146c);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$i */
    /* compiled from: CrashlyticsController */
    class C3302i implements C3321y {

        /* renamed from: a */
        final /* synthetic */ String f19147a;

        /* renamed from: b */
        final /* synthetic */ String f19148b;

        /* renamed from: c */
        final /* synthetic */ String f19149c;

        /* renamed from: d */
        final /* synthetic */ String f19150d;

        /* renamed from: e */
        final /* synthetic */ int f19151e;

        C3302i(String str, String str2, String str3, String str4, int i) {
            this.f19147a = str;
            this.f19148b = str2;
            this.f19149c = str3;
            this.f19150d = str4;
            this.f19151e = i;
        }

        /* renamed from: a */
        public void mo21008a(CodedOutputStream codedOutputStream) {
            SessionProtobufHelper.writeSessionApp(codedOutputStream, this.f19147a, this.f19148b, this.f19149c, this.f19150d, this.f19151e, C3287h.this.f19114r);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$j */
    /* compiled from: CrashlyticsController */
    class C3303j implements C3321y {

        /* renamed from: a */
        final /* synthetic */ String f19153a;

        /* renamed from: b */
        final /* synthetic */ String f19154b;

        /* renamed from: c */
        final /* synthetic */ boolean f19155c;

        C3303j(C3287h hVar, String str, String str2, boolean z) {
            this.f19153a = str;
            this.f19154b = str2;
            this.f19155c = z;
        }

        /* renamed from: a */
        public void mo21008a(CodedOutputStream codedOutputStream) {
            SessionProtobufHelper.writeSessionOS(codedOutputStream, this.f19153a, this.f19154b, this.f19155c);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$k */
    /* compiled from: CrashlyticsController */
    class C3304k extends C3322z {
        C3304k(String str) {
            super(str);
        }

        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$l */
    /* compiled from: CrashlyticsController */
    class C3305l implements C3321y {

        /* renamed from: a */
        final /* synthetic */ int f19156a;

        /* renamed from: b */
        final /* synthetic */ String f19157b;

        /* renamed from: c */
        final /* synthetic */ int f19158c;

        /* renamed from: d */
        final /* synthetic */ long f19159d;

        /* renamed from: e */
        final /* synthetic */ long f19160e;

        /* renamed from: f */
        final /* synthetic */ boolean f19161f;

        /* renamed from: g */
        final /* synthetic */ int f19162g;

        /* renamed from: h */
        final /* synthetic */ String f19163h;

        /* renamed from: i */
        final /* synthetic */ String f19164i;

        C3305l(C3287h hVar, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
            this.f19156a = i;
            this.f19157b = str;
            this.f19158c = i2;
            this.f19159d = j;
            this.f19160e = j2;
            this.f19161f = z;
            this.f19162g = i3;
            this.f19163h = str2;
            this.f19164i = str3;
        }

        /* renamed from: a */
        public void mo21008a(CodedOutputStream codedOutputStream) {
            SessionProtobufHelper.writeSessionDevice(codedOutputStream, this.f19156a, this.f19157b, this.f19158c, this.f19159d, this.f19160e, this.f19161f, this.f19162g, this.f19163h, this.f19164i);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$m */
    /* compiled from: CrashlyticsController */
    class C3306m implements C3321y {

        /* renamed from: a */
        final /* synthetic */ UserMetadata f19165a;

        C3306m(C3287h hVar, UserMetadata userMetadata) {
            this.f19165a = userMetadata;
        }

        /* renamed from: a */
        public void mo21008a(CodedOutputStream codedOutputStream) {
            SessionProtobufHelper.writeSessionUser(codedOutputStream, this.f19165a.getUserId(), (String) null, (String) null);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$n */
    /* compiled from: CrashlyticsController */
    class C3307n implements C3321y {

        /* renamed from: a */
        final /* synthetic */ String f19166a;

        C3307n(String str) {
            this.f19166a = str;
        }

        /* renamed from: a */
        public void mo21008a(CodedOutputStream codedOutputStream) {
            SessionProtobufHelper.writeSessionAppClsId(codedOutputStream, this.f19166a);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$o */
    /* compiled from: CrashlyticsController */
    class C3308o implements Callable<Void> {

        /* renamed from: a */
        final /* synthetic */ long f19167a;

        C3308o(long j) {
            this.f19167a = j;
        }

        /* renamed from: a */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.f19167a);
            C3287h.this.f19115s.logEvent("_ae", bundle);
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$p */
    /* compiled from: CrashlyticsController */
    class C3309p implements FilenameFilter {
        C3309p() {
        }

        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$q */
    /* compiled from: CrashlyticsController */
    class C3310q implements Comparator<File> {
        C3310q() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$r */
    /* compiled from: CrashlyticsController */
    class C3311r implements Comparator<File> {
        C3311r() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$s */
    /* compiled from: CrashlyticsController */
    class C3312s implements C3325k.C3326a {
        C3312s() {
        }

        /* renamed from: a */
        public void mo21017a(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
            C3287h.this.mo20983l0(settingsDataProvider, thread, th);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$t */
    /* compiled from: CrashlyticsController */
    class C3313t implements Callable<Task<Void>> {

        /* renamed from: a */
        final /* synthetic */ Date f19170a;

        /* renamed from: b */
        final /* synthetic */ Throwable f19171b;

        /* renamed from: c */
        final /* synthetic */ Thread f19172c;

        /* renamed from: d */
        final /* synthetic */ SettingsDataProvider f19173d;

        /* renamed from: com.google.firebase.crashlytics.internal.common.h$t$a */
        /* compiled from: CrashlyticsController */
        class C3314a implements SuccessContinuation<AppSettingsData, Void> {

            /* renamed from: a */
            final /* synthetic */ Executor f19175a;

            C3314a(Executor executor) {
                this.f19175a = executor;
            }

            @NonNull
            /* renamed from: a */
            public Task<Void> then(@Nullable AppSettingsData appSettingsData) {
                if (appSettingsData == null) {
                    Logger.getLogger().mo20869w("Received null app settings, cannot send reports at crash time.");
                    return Tasks.forResult(null);
                }
                C3287h.this.m11318B0(appSettingsData, true);
                return Tasks.whenAll((Task<?>[]) new Task[]{C3287h.this.m11387x0(), C3287h.this.f19116t.mo21047n(this.f19175a, DataTransportState.m11271a(appSettingsData))});
            }
        }

        C3313t(Date date, Throwable th, Thread thread, SettingsDataProvider settingsDataProvider) {
            this.f19170a = date;
            this.f19171b = th;
            this.f19172c = thread;
            this.f19173d = settingsDataProvider;
        }

        /* renamed from: a */
        public Task<Void> call() {
            long s = C3287h.m11363i0(this.f19170a);
            String t = C3287h.this.m11351a0();
            if (t == null) {
                Logger.getLogger().mo20861e("Tried to write a fatal exception while no session was open.");
                return Tasks.forResult(null);
            }
            C3287h.this.f19100d.mo21028a();
            long j = s;
            C3287h.this.f19116t.mo21043j(this.f19171b, this.f19172c, C3287h.m11389y0(t), j);
            C3287h.this.m11337R(this.f19172c, this.f19171b, t, j);
            C3287h.this.m11335Q(this.f19170a.getTime());
            Settings settings = this.f19173d.getSettings();
            int i = settings.getSessionData().maxCustomExceptionEvents;
            int i2 = settings.getSessionData().maxCompleteSessionsCount;
            C3287h.this.mo20974N(i);
            C3287h.this.m11333P();
            C3287h.this.mo20970J0(i2);
            if (!C3287h.this.f19099c.isAutomaticDataCollectionEnabled()) {
                return Tasks.forResult(null);
            }
            Executor c = C3287h.this.f19102f.mo20955c();
            return this.f19173d.getAppSettings().onSuccessTask(c, new C3314a(c));
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$u */
    /* compiled from: CrashlyticsController */
    class C3315u implements SuccessContinuation<Void, Boolean> {
        C3315u(C3287h hVar) {
        }

        @NonNull
        /* renamed from: a */
        public Task<Boolean> then(@Nullable Void voidR) {
            return Tasks.forResult(Boolean.TRUE);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$v */
    /* compiled from: CrashlyticsController */
    class C3316v implements SuccessContinuation<Boolean, Void> {

        /* renamed from: a */
        final /* synthetic */ Task f19177a;

        /* renamed from: b */
        final /* synthetic */ float f19178b;

        /* renamed from: com.google.firebase.crashlytics.internal.common.h$v$a */
        /* compiled from: CrashlyticsController */
        class C3317a implements Callable<Task<Void>> {

            /* renamed from: a */
            final /* synthetic */ Boolean f19180a;

            /* renamed from: com.google.firebase.crashlytics.internal.common.h$v$a$a */
            /* compiled from: CrashlyticsController */
            class C3318a implements SuccessContinuation<AppSettingsData, Void> {

                /* renamed from: a */
                final /* synthetic */ List f19182a;

                /* renamed from: b */
                final /* synthetic */ boolean f19183b;

                /* renamed from: c */
                final /* synthetic */ Executor f19184c;

                C3318a(List list, boolean z, Executor executor) {
                    this.f19182a = list;
                    this.f19183b = z;
                    this.f19184c = executor;
                }

                @NonNull
                /* renamed from: a */
                public Task<Void> then(@Nullable AppSettingsData appSettingsData) {
                    if (appSettingsData == null) {
                        Logger.getLogger().mo20869w("Received null app settings, cannot send reports during app startup.");
                        return Tasks.forResult(null);
                    }
                    for (Report report : this.f19182a) {
                        if (report.getType() == Report.Type.JAVA) {
                            C3287h.m11390z(appSettingsData.organizationId, report.getFile());
                        }
                    }
                    Task unused = C3287h.this.m11387x0();
                    C3287h.this.f19107k.createReportUploader(appSettingsData).uploadReportsAsync(this.f19182a, this.f19183b, C3316v.this.f19178b);
                    C3287h.this.f19116t.mo21047n(this.f19184c, DataTransportState.m11271a(appSettingsData));
                    C3287h.this.f19120x.trySetResult(null);
                    return Tasks.forResult(null);
                }
            }

            C3317a(Boolean bool) {
                this.f19180a = bool;
            }

            /* renamed from: a */
            public Task<Void> call() {
                List<Report> findReports = C3287h.this.f19110n.findReports();
                if (!this.f19180a.booleanValue()) {
                    Logger.getLogger().mo20859d("Reports are being deleted.");
                    C3287h.m11327J(C3287h.this.mo20985o0());
                    C3287h.this.f19110n.deleteReports(findReports);
                    C3287h.this.f19116t.mo21046m();
                    C3287h.this.f19120x.trySetResult(null);
                    return Tasks.forResult(null);
                }
                Logger.getLogger().mo20859d("Reports are being sent.");
                boolean booleanValue = this.f19180a.booleanValue();
                C3287h.this.f19099c.grantDataCollectionPermission(booleanValue);
                Executor c = C3287h.this.f19102f.mo20955c();
                return C3316v.this.f19177a.onSuccessTask(c, new C3318a(findReports, booleanValue, c));
            }
        }

        C3316v(Task task, float f) {
            this.f19177a = task;
            this.f19178b = f;
        }

        @NonNull
        /* renamed from: a */
        public Task<Void> then(@Nullable Boolean bool) {
            return C3287h.this.f19102f.mo20958i(new C3317a(bool));
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$w */
    /* compiled from: CrashlyticsController */
    class C3319w implements ReportUploader.Provider {
        C3319w() {
        }

        public ReportUploader createReportUploader(@NonNull AppSettingsData appSettingsData) {
            String str = appSettingsData.reportsUrl;
            String str2 = appSettingsData.ndkReportsUrl;
            return new ReportUploader(appSettingsData.organizationId, C3287h.this.f19106j.f19066a, DataTransportState.m11271a(appSettingsData), C3287h.this.f19110n, C3287h.this.m11349Z(str, str2), C3287h.this.f19111o);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$x */
    /* compiled from: CrashlyticsController */
    private static class C3320x implements FilenameFilter {
        private C3320x() {
        }

        public boolean accept(File file, String str) {
            return !C3287h.f19090B.accept(file, str) && C3287h.f19093E.matcher(str).matches();
        }

        /* synthetic */ C3320x(C3304k kVar) {
            this();
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$y */
    /* compiled from: CrashlyticsController */
    private interface C3321y {
        /* renamed from: a */
        void mo21008a(CodedOutputStream codedOutputStream);
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.h$z */
    /* compiled from: CrashlyticsController */
    static class C3322z implements FilenameFilter {

        /* renamed from: a */
        private final String f19187a;

        public C3322z(String str) {
            this.f19187a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f19187a) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    C3287h(Context context, C3281f fVar, HttpRequestFactory httpRequestFactory, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, C3324j jVar, C3276a aVar, ReportManager reportManager, ReportUploader.Provider provider, CrashlyticsNativeComponent crashlyticsNativeComponent, UnityVersionProvider unityVersionProvider, AnalyticsEventLogger analyticsEventLogger, SettingsDataProvider settingsDataProvider) {
        FileStore fileStore2 = fileStore;
        ReportUploader.Provider provider2 = provider;
        this.f19098b = context;
        this.f19102f = fVar;
        this.f19103g = httpRequestFactory;
        this.f19104h = idManager;
        this.f19099c = dataCollectionArbiter;
        this.f19105i = fileStore2;
        this.f19100d = jVar;
        this.f19106j = aVar;
        if (provider2 != null) {
            this.f19107k = provider2;
        } else {
            this.f19107k = m11325I();
        }
        this.f19112p = crashlyticsNativeComponent;
        this.f19114r = unityVersionProvider.getUnityVersion();
        this.f19115s = analyticsEventLogger;
        UserMetadata userMetadata = new UserMetadata();
        this.f19101e = userMetadata;
        C3291b0 b0Var = new C3291b0(fileStore2);
        this.f19108l = b0Var;
        LogFileManager logFileManager = new LogFileManager(context, b0Var);
        this.f19109m = logFileManager;
        this.f19110n = reportManager == null ? new ReportManager(new C3293c0(this, (C3304k) null)) : reportManager;
        this.f19111o = new C3295d0(this, (C3304k) null);
        MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
        this.f19113q = middleOutFallbackStrategy;
        this.f19116t = C3335s.m11468b(context, idManager, fileStore, aVar, logFileManager, userMetadata, middleOutFallbackStrategy, settingsDataProvider);
    }

    /* renamed from: A */
    private static void m11315A(@NonNull File file, @NonNull C3321y yVar) {
        FileOutputStream fileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                codedOutputStream = CodedOutputStream.newInstance((OutputStream) fileOutputStream);
                yVar.mo21008a(codedOutputStream);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to append to " + file.getPath());
                CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to append to " + file.getPath());
                CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to append to " + file.getPath());
            CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + file.getPath());
            throw th;
        }
    }

    /* renamed from: A0 */
    private void m11316A0(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f19093E.matcher(name);
            if (!matcher.matches()) {
                Logger.getLogger().mo20859d("Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                Logger.getLogger().mo20859d("Trimming session file: " + name);
                file.delete();
            }
        }
    }

    /* renamed from: B */
    private void m11317B(Map<String, String> map) {
        this.f19102f.mo20957h(new C3294d(map));
    }

    /* access modifiers changed from: private */
    /* renamed from: B0 */
    public void m11318B0(@NonNull AppSettingsData appSettingsData, boolean z) {
        Context Y = m11348Y();
        ReportUploader createReportUploader = this.f19107k.createReportUploader(appSettingsData);
        for (File file : mo20986p0()) {
            m11390z(appSettingsData.organizationId, file);
            this.f19102f.mo20956g(new C3297e0(Y, new SessionReport(file, f19094F), createReportUploader, z));
        }
    }

    /* renamed from: C */
    private void m11319C(UserMetadata userMetadata) {
        this.f19102f.mo20957h(new C3292c(userMetadata));
    }

    /* renamed from: F */
    private void m11320F(File[] fileArr, int i, int i2) {
        Logger.getLogger().mo20859d("Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String h0 = m11361h0(file);
            Logger logger = Logger.getLogger();
            logger.mo20859d("Closing session: " + h0);
            m11343U0(file, h0, i2);
            i++;
        }
    }

    /* renamed from: G */
    private void m11321G(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (IOException e) {
                Logger.getLogger().mo20862e("Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    /* renamed from: G0 */
    private void m11322G0(File file, String str, File[] fileArr, File file2) {
        ClsFileOutputStream clsFileOutputStream;
        boolean z = file2 != null;
        File c0 = z ? mo20979c0() : mo20982g0();
        if (!c0.exists()) {
            c0.mkdirs();
        }
        try {
            clsFileOutputStream = new ClsFileOutputStream(c0, str);
            try {
                CodedOutputStream newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                Logger.getLogger().mo20859d("Collecting SessionStart data for session ID " + str);
                m11346W0(newInstance, file);
                newInstance.writeUInt64(4, m11353b0());
                newInstance.writeBool(5, z);
                newInstance.writeUInt32(11, 1);
                newInstance.writeEnum(12, 3);
                m11330M0(newInstance, str);
                m11331N0(newInstance, fileArr, str);
                if (z) {
                    m11346W0(newInstance, file2);
                }
                CommonUtils.flushOrLog(newInstance, "Error flushing session file stream");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
            } catch (Exception e) {
                e = e;
                try {
                    Logger.getLogger().mo20862e("Failed to write session file for session ID: " + str, e);
                    CommonUtils.flushOrLog((Flushable) null, "Error flushing session file stream");
                    m11321G(clsFileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.flushOrLog((Flushable) null, "Error flushing session file stream");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
            Logger.getLogger().mo20862e("Failed to write session file for session ID: " + str, e);
            CommonUtils.flushOrLog((Flushable) null, "Error flushing session file stream");
            m11321G(clsFileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog((Flushable) null, "Error flushing session file stream");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
            throw th;
        }
    }

    /* renamed from: H */
    private static void m11323H(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    /* renamed from: H0 */
    private void m11324H0(int i) {
        HashSet hashSet = new HashSet();
        File[] v0 = m11383v0();
        int min = Math.min(i, v0.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(m11361h0(v0[i2]));
        }
        this.f19109m.discardOldLogFiles(hashSet);
        m11316A0(m11377r0(new C3320x((C3304k) null)), hashSet);
    }

    /* renamed from: I */
    private ReportUploader.Provider m11325I() {
        return new C3319w();
    }

    /* renamed from: I0 */
    private void m11326I0(String str, int i) {
        File d0 = mo20980d0();
        Utils.m11280b(d0, new C3322z(str + "SessionEvent"), i, f19092D);
    }

    /* access modifiers changed from: private */
    /* renamed from: J */
    public static void m11327J(File[] fileArr) {
        if (fileArr != null) {
            for (File delete : fileArr) {
                delete.delete();
            }
        }
    }

    /* renamed from: K0 */
    private Task<Boolean> m11328K0() {
        Boolean bool = Boolean.TRUE;
        if (this.f19099c.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().mo20859d("Automatic data collection is enabled. Allowing upload.");
            this.f19118v.trySetResult(Boolean.FALSE);
            return Tasks.forResult(bool);
        }
        Logger.getLogger().mo20859d("Automatic data collection is disabled.");
        Logger.getLogger().mo20859d("Notifying that unsent reports are available.");
        this.f19118v.trySetResult(bool);
        Task<TContinuationResult> onSuccessTask = this.f19099c.waitForAutomaticDataCollectionEnabled().onSuccessTask(new C3315u(this));
        Logger.getLogger().mo20859d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(onSuccessTask, this.f19119w.getTask());
    }

    /* renamed from: L0 */
    private void m11329L0(String str, long j) {
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{CrashlyticsCore.getVersion()});
        m11341T0(str, "BeginSession", new C3301h(this, str, format, j));
        this.f19112p.writeBeginSession(str, format, j);
    }

    /* renamed from: M0 */
    private void m11330M0(CodedOutputStream codedOutputStream, String str) {
        for (String str2 : f19095G) {
            File[] r0 = m11377r0(new C3322z(str + str2 + ClsFileOutputStream.SESSION_FILE_EXTENSION));
            if (r0.length == 0) {
                Logger.getLogger().mo20859d("Can't find " + str2 + " data for session ID " + str);
            } else {
                Logger.getLogger().mo20859d("Collecting " + str2 + " data for session ID " + str);
                m11346W0(codedOutputStream, r0[0]);
            }
        }
    }

    /* renamed from: N0 */
    private static void m11331N0(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.FILE_MODIFIED_COMPARATOR);
        for (File file : fileArr) {
            try {
                Logger.getLogger().mo20859d(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, file.getName()}));
                m11346W0(codedOutputStream, file);
            } catch (Exception e) {
                Logger.getLogger().mo20862e("Error writting non-fatal to session.", e);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [int, boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: O */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11332O(int r6, boolean r7) {
        /*
            r5 = this;
            int r0 = r7 + 8
            r5.m11324H0(r0)
            java.io.File[] r0 = r5.m11383v0()
            int r1 = r0.length
            if (r1 > r7) goto L_0x0016
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r7 = "No open sessions to be closed."
            r6.mo20859d(r7)
            return
        L_0x0016:
            r1 = r0[r7]
            java.lang.String r1 = m11361h0(r1)
            r5.m11345V0(r1)
            com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r2 = r5.f19112p
            boolean r2 = r2.hasCrashDataForSession(r1)
            if (r2 == 0) goto L_0x004a
            r5.m11344V(r1)
            com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r2 = r5.f19112p
            boolean r2 = r2.finalizeSession(r1)
            if (r2 != 0) goto L_0x004a
            com.google.firebase.crashlytics.internal.Logger r2 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not finalize native session: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.mo20859d(r1)
        L_0x004a:
            r5.m11320F(r0, r7, r6)
            r6 = 0
            if (r7 == 0) goto L_0x005b
            r6 = 0
            r6 = r0[r6]
            java.lang.String r6 = m11361h0(r6)
            java.lang.String r6 = m11389y0(r6)
        L_0x005b:
            com.google.firebase.crashlytics.internal.common.s r7 = r5.f19116t
            long r0 = m11353b0()
            r7.mo21041d(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.C3287h.m11332O(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public void m11333P() {
        long b0 = m11353b0();
        String eVar = new C3280e(this.f19104h).toString();
        Logger logger = Logger.getLogger();
        logger.mo20859d("Opening a new session with ID " + eVar);
        this.f19112p.openSession(eVar);
        m11329L0(eVar, b0);
        m11334P0(eVar);
        m11340S0(eVar);
        m11336Q0(eVar);
        this.f19109m.setCurrentSession(eVar);
        this.f19116t.mo21042g(m11389y0(eVar), b0);
    }

    /* renamed from: P0 */
    private void m11334P0(String str) {
        String appIdentifier = this.f19104h.getAppIdentifier();
        C3276a aVar = this.f19106j;
        String str2 = aVar.f19070e;
        String str3 = aVar.f19071f;
        String str4 = appIdentifier;
        String str5 = str2;
        String str6 = str3;
        String crashlyticsInstallId = this.f19104h.getCrashlyticsInstallId();
        int id = DeliveryMechanism.determineFrom(this.f19106j.f19068c).getId();
        m11341T0(str, "SessionApp", new C3302i(str4, str5, str6, crashlyticsInstallId, id));
        this.f19112p.writeSessionApp(str, str4, str5, str6, crashlyticsInstallId, id, this.f19114r);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m11335Q(long j) {
        try {
            File d0 = mo20980d0();
            new File(d0, ".ae" + j).createNewFile();
        } catch (IOException unused) {
            Logger.getLogger().mo20859d("Could not write app exception marker.");
        }
    }

    /* renamed from: Q0 */
    private void m11336Q0(String str) {
        Context Y = m11348Y();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = CommonUtils.isEmulator(Y);
        int deviceState = CommonUtils.getDeviceState(Y);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.PRODUCT;
        m11341T0(str, "SessionDevice", new C3305l(this, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str3, str4));
        this.f19112p.writeSessionDevice(str, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceState, str3, str4);
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m11337R(@NonNull Thread thread, @NonNull Throwable th, @NonNull String str, long j) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(mo20980d0(), str + "SessionCrash");
            try {
                codedOutputStream = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                m11338R0(codedOutputStream, thread, th, j, "crash", true);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
            try {
                Logger.getLogger().mo20862e("An error occurred in the fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
        CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
    }

    /* renamed from: R0 */
    private void m11338R0(CodedOutputStream codedOutputStream, Thread thread, Throwable th, long j, String str, boolean z) {
        Thread[] threadArr;
        TreeMap treeMap;
        Map map;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.f19113q);
        Context Y = m11348Y();
        C3278c a = C3278c.m11288a(Y);
        Float b = a.mo20948b();
        int c = a.mo20949c();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(Y);
        int i = Y.getResources().getConfiguration().orientation;
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(Y);
        long calculateUsedDiskSpaceInBytes = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(Y.getPackageName(), Y);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.f19106j.f19067b;
        String appIdentifier = this.f19104h.getAppIdentifier();
        int i2 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry next : allStackTraces.entrySet()) {
                threadArr2[i2] = (Thread) next.getKey();
                linkedList.add(this.f19113q.getTrimmedStackTrace((StackTraceElement[]) next.getValue()));
                i2++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (!CommonUtils.getBooleanResourceValue(Y, "com.crashlytics.CollectCustomKeys", true)) {
            map = new TreeMap();
        } else {
            map = this.f19101e.getCustomKeys();
            if (map != null && map.size() > 1) {
                treeMap = new TreeMap(map);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.f19109m.getBytesForLog(), appProcessInfo, i, appIdentifier, str2, b, c, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
                this.f19109m.clearLog();
            }
        }
        treeMap = map;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.f19109m.getBytesForLog(), appProcessInfo, i, appIdentifier, str2, b, c, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
        this.f19109m.clearLog();
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void m11339S(@NonNull Thread thread, @NonNull Throwable th, @NonNull String str, long j) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream newInstance;
        String str2 = str;
        CodedOutputStream codedOutputStream = null;
        try {
            Logger.getLogger().mo20859d("Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            clsFileOutputStream = new ClsFileOutputStream(mo20980d0(), str2 + "SessionEvent" + CommonUtils.padWithZerosToMaxIntWidth(this.f19097a.getAndIncrement()));
            try {
                newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
            } catch (Exception e) {
                e = e;
                try {
                    Logger.getLogger().mo20862e("An error occurred in the non-fatal exception logger", e);
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    m11326I0(str2, 64);
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    throw th;
                }
            }
            try {
                m11338R0(newInstance, thread, th, j, "error", false);
                CommonUtils.flushOrLog(newInstance, "Failed to flush to non-fatal file.");
            } catch (Exception e2) {
                e = e2;
                codedOutputStream = newInstance;
                Logger.getLogger().mo20862e("An error occurred in the non-fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                m11326I0(str2, 64);
            } catch (Throwable th3) {
                th = th3;
                codedOutputStream = newInstance;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
            Logger.getLogger().mo20862e("An error occurred in the non-fatal exception logger", e);
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            m11326I0(str2, 64);
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw th;
        }
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
        try {
            m11326I0(str2, 64);
        } catch (Exception e4) {
            Logger.getLogger().mo20862e("An error occurred when trimming non-fatal files.", e4);
        }
    }

    /* renamed from: S0 */
    private void m11340S0(String str) {
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.VERSION.CODENAME;
        boolean isRooted = CommonUtils.isRooted(m11348Y());
        m11341T0(str, "SessionOS", new C3303j(this, str2, str3, isRooted));
        this.f19112p.writeSessionOs(str, str2, str3, isRooted);
    }

    /* renamed from: T0 */
    private void m11341T0(String str, String str2, C3321y yVar) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(mo20980d0(), str + str2);
            try {
                codedOutputStream = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                yVar.mo21008a(codedOutputStream);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            throw th;
        }
    }

    /* renamed from: U */
    private static File[] m11342U(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* renamed from: U0 */
    private void m11343U0(File file, String str, int i) {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Collecting session parts for ID " + str);
        File[] r0 = m11377r0(new C3322z(str + "SessionCrash"));
        boolean z = r0 != null && r0.length > 0;
        Logger logger2 = Logger.getLogger();
        Locale locale = Locale.US;
        logger2.mo20859d(String.format(locale, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z)}));
        File[] r02 = m11377r0(new C3322z(str + "SessionEvent"));
        boolean z2 = r02 != null && r02.length > 0;
        Logger.getLogger().mo20859d(String.format(locale, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z2)}));
        if (z || z2) {
            m11322G0(file, str, m11365j0(str, r02, i), z ? r0[0] : null);
        } else {
            Logger logger3 = Logger.getLogger();
            logger3.mo20859d("No events present for session ID " + str);
        }
        Logger logger4 = Logger.getLogger();
        logger4.mo20859d("Removing session part files for ID " + str);
        m11327J(m11381u0(str));
    }

    /* renamed from: V */
    private void m11344V(String str) {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.f19112p.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile == null || !minidumpFile.exists()) {
            Logger logger2 = Logger.getLogger();
            logger2.mo20869w("No minidump data found for session " + str);
            return;
        }
        long lastModified = minidumpFile.lastModified();
        LogFileManager logFileManager = new LogFileManager(this.f19098b, this.f19108l, str);
        File file = new File(mo20981f0(), str);
        if (!file.mkdirs()) {
            Logger.getLogger().mo20859d("Couldn't create native sessions directory");
            return;
        }
        m11335Q(lastModified);
        List<C3331o> e0 = m11357e0(sessionFileProvider, str, m11348Y(), mo20980d0(), logFileManager.getBytesForLog());
        C3332p.m11464b(file, e0);
        this.f19116t.mo21040c(m11389y0(str), e0);
        logFileManager.clearLog();
    }

    /* renamed from: V0 */
    private void m11345V0(String str) {
        m11341T0(str, "SessionUser", new C3306m(this, m11367k0(str)));
    }

    /* renamed from: W0 */
    private static void m11346W0(CodedOutputStream codedOutputStream, File file) {
        if (!file.exists()) {
            Logger logger = Logger.getLogger();
            logger.mo20861e("Tried to include a file that doesn't exist: " + file.getName());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                m11323H(fileInputStream2, codedOutputStream, (int) file.length());
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    /* renamed from: X */
    private static boolean m11347X() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: Y */
    private Context m11348Y() {
        return this.f19098b;
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public CreateReportSpiCall m11349Z(String str, String str2) {
        String stringsFileValue = CommonUtils.getStringsFileValue(m11348Y(), "com.crashlytics.ApiEndpoint");
        return new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(stringsFileValue, str, this.f19103g, CrashlyticsCore.getVersion()), new NativeCreateReportSpiCall(stringsFileValue, str2, this.f19103g, CrashlyticsCore.getVersion()));
    }

    /* access modifiers changed from: private */
    @Nullable
    /* renamed from: a0 */
    public String m11351a0() {
        File[] v0 = m11383v0();
        if (v0.length > 0) {
            return m11361h0(v0[0]);
        }
        return null;
    }

    /* renamed from: b0 */
    private static long m11353b0() {
        return m11363i0(new Date());
    }

    @NonNull
    /* renamed from: e0 */
    static List<C3331o> m11357e0(NativeSessionFileProvider nativeSessionFileProvider, String str, Context context, File file, byte[] bArr) {
        byte[] bArr2;
        C3329n nVar = new C3329n(file);
        File b = nVar.mo21035b(str);
        File a = nVar.mo21034a(str);
        try {
            bArr2 = NativeFileUtils.binaryImagesJsonFromMapsFile(nativeSessionFileProvider.getBinaryImagesFile(), context);
        } catch (Exception unused) {
            bArr2 = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C3279d("logs_file", "logs", bArr));
        arrayList.add(new C3279d("binary_images_file", "binaryImages", bArr2));
        arrayList.add(new C3327l("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new C3327l("session_meta_file", "session", nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new C3327l("app_meta_file", "app", nativeSessionFileProvider.getAppFile()));
        arrayList.add(new C3327l("device_meta_file", "device", nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new C3327l("os_meta_file", "os", nativeSessionFileProvider.getOsFile()));
        arrayList.add(new C3327l("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile()));
        arrayList.add(new C3327l("user_meta_file", "user", b));
        arrayList.add(new C3327l("keys_file", "keys", a));
        return arrayList;
    }

    /* renamed from: h0 */
    static String m11361h0(File file) {
        return file.getName().substring(0, 35);
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public static long m11363i0(Date date) {
        return date.getTime() / 1000;
    }

    /* renamed from: j0 */
    private File[] m11365j0(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        Logger.getLogger().mo20859d(String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        m11326I0(str, i);
        return m11377r0(new C3322z(str + "SessionEvent"));
    }

    /* renamed from: k0 */
    private UserMetadata m11367k0(String str) {
        if (mo20984m0()) {
            return this.f19101e;
        }
        return new C3329n(mo20980d0()).mo21036e(str);
    }

    /* renamed from: q0 */
    private static File[] m11375q0(File file, FilenameFilter filenameFilter) {
        return m11342U(file.listFiles(filenameFilter));
    }

    /* access modifiers changed from: private */
    /* renamed from: r0 */
    public File[] m11377r0(FilenameFilter filenameFilter) {
        return m11375q0(mo20980d0(), filenameFilter);
    }

    /* renamed from: u0 */
    private File[] m11381u0(String str) {
        return m11377r0(new C3299f0(str));
    }

    /* renamed from: v0 */
    private File[] m11383v0() {
        File[] t0 = mo20988t0();
        Arrays.sort(t0, f19091C);
        return t0;
    }

    /* renamed from: w0 */
    private Task<Void> m11385w0(long j) {
        if (!m11347X()) {
            return Tasks.call(new ScheduledThreadPoolExecutor(1), new C3308o(j));
        }
        Logger.getLogger().mo20859d("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
        return Tasks.forResult(null);
    }

    /* access modifiers changed from: private */
    /* renamed from: x0 */
    public Task<Void> m11387x0() {
        ArrayList arrayList = new ArrayList();
        for (File file : mo20985o0()) {
            try {
                arrayList.add(m11385w0(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger.getLogger().mo20859d("Could not parse timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll((Collection<? extends Task<?>>) arrayList);
    }

    /* access modifiers changed from: private */
    @NonNull
    /* renamed from: y0 */
    public static String m11389y0(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public static void m11390z(@Nullable String str, @NonNull File file) {
        if (str != null) {
            m11315A(file, new C3307n(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C0 */
    public Task<Void> mo20964C0() {
        this.f19119w.trySetResult(Boolean.TRUE);
        return this.f19120x.getTask();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: D */
    public Task<Boolean> mo20965D() {
        if (this.f19121y.compareAndSet(false, true)) {
            return this.f19118v.getTask();
        }
        Logger.getLogger().mo20859d("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D0 */
    public void mo20966D0(String str, String str2) {
        try {
            this.f19101e.setCustomKey(str, str2);
            m11317B(this.f19101e.getCustomKeys());
        } catch (IllegalArgumentException e) {
            Context context = this.f19098b;
            if (context == null || !CommonUtils.isAppDebuggable(context)) {
                Logger.getLogger().mo20861e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo20967E() {
        this.f19102f.mo20956g(new C3298f());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E0 */
    public void mo20968E0(String str) {
        this.f19101e.setUserId(str);
        m11319C(this.f19101e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F0 */
    public Task<Void> mo20969F0(float f, Task<AppSettingsData> task) {
        if (!this.f19110n.areReportsAvailable()) {
            Logger.getLogger().mo20859d("No reports are available.");
            this.f19118v.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        Logger.getLogger().mo20859d("Unsent reports are available.");
        return m11328K0().onSuccessTask(new C3316v(task, f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J0 */
    public void mo20970J0(int i) {
        File f0 = mo20981f0();
        File c0 = mo20979c0();
        Comparator<File> comparator = f19092D;
        int d = i - Utils.m11282d(f0, c0, i, comparator);
        Utils.m11280b(mo20980d0(), f19090B, d - Utils.m11279a(mo20982g0(), d, comparator), comparator);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public Task<Void> mo20971K() {
        this.f19119w.trySetResult(Boolean.FALSE);
        return this.f19120x.getTask();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public boolean mo20972L() {
        if (!this.f19100d.mo21029c()) {
            String a0 = m11351a0();
            if (a0 == null || !this.f19112p.hasCrashDataForSession(a0)) {
                return false;
            }
            return true;
        }
        Logger.getLogger().mo20859d("Found previous crash marker.");
        this.f19100d.mo21030d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: M */
    public void mo20973M(File[] fileArr) {
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            Logger.getLogger().mo20859d("Found invalid session part file: " + file);
            hashSet.add(m11361h0(file));
        }
        if (!hashSet.isEmpty()) {
            for (File file2 : m11377r0(new C3300g(this, hashSet))) {
                Logger.getLogger().mo20859d("Deleting invalid session file: " + file2);
                file2.delete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public void mo20974N(int i) {
        m11332O(i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O0 */
    public void mo20975O0(@NonNull Thread thread, @NonNull Throwable th) {
        this.f19102f.mo20956g(new C3290b(new Date(), th, thread));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: T */
    public void mo20976T(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        mo20989z0();
        C3325k kVar = new C3325k(new C3312s(), settingsDataProvider, uncaughtExceptionHandler);
        this.f19117u = kVar;
        Thread.setDefaultUncaughtExceptionHandler(kVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: W */
    public boolean mo20977W(int i) {
        this.f19102f.mo20954b();
        if (mo20984m0()) {
            Logger.getLogger().mo20859d("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.getLogger().mo20859d("Finalizing previously open sessions.");
        try {
            m11332O(i, true);
            Logger.getLogger().mo20859d("Closed all previously open sessions");
            return true;
        } catch (Exception e) {
            Logger.getLogger().mo20862e("Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: X0 */
    public void mo20978X0(long j, String str) {
        this.f19102f.mo20957h(new C3288a(j, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c0 */
    public File mo20979c0() {
        return new File(mo20980d0(), "fatal-sessions");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public File mo20980d0() {
        return this.f19105i.getFilesDir();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f0 */
    public File mo20981f0() {
        return new File(mo20980d0(), "native-sessions");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g0 */
    public File mo20982g0() {
        return new File(mo20980d0(), "nonfatal-sessions");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l0 */
    public synchronized void mo20983l0(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
        Logger logger = Logger.getLogger();
        logger.mo20859d("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        try {
            Utils.awaitEvenIfOnMainThread(this.f19102f.mo20958i(new C3313t(new Date(), th, thread, settingsDataProvider)));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m0 */
    public boolean mo20984m0() {
        C3325k kVar = this.f19117u;
        return kVar != null && kVar.mo21031a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o0 */
    public File[] mo20985o0() {
        return m11377r0(f19089A);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p0 */
    public File[] mo20986p0() {
        LinkedList linkedList = new LinkedList();
        File c0 = mo20979c0();
        FilenameFilter filenameFilter = f19090B;
        Collections.addAll(linkedList, m11375q0(c0, filenameFilter));
        Collections.addAll(linkedList, m11375q0(mo20982g0(), filenameFilter));
        Collections.addAll(linkedList, m11375q0(mo20980d0(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s0 */
    public File[] mo20987s0() {
        return m11342U(mo20981f0().listFiles());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t0 */
    public File[] mo20988t0() {
        return m11377r0(f19096z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z0 */
    public void mo20989z0() {
        this.f19102f.mo20957h(new C3296e());
    }
}
