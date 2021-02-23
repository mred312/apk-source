package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CrashlyticsReportDataCapture {

    /* renamed from: e */
    private static final String f19027e = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{BuildConfig.VERSION_NAME});

    /* renamed from: f */
    private static final Map<String, Integer> f19028f;

    /* renamed from: a */
    private final Context f19029a;

    /* renamed from: b */
    private final IdManager f19030b;

    /* renamed from: c */
    private final C3276a f19031c;

    /* renamed from: d */
    private final StackTraceTrimmingStrategy f19032d;

    static {
        HashMap hashMap = new HashMap();
        f19028f = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, C3276a aVar, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f19029a = context;
        this.f19030b = idManager;
        this.f19031c = aVar;
        this.f19032d = stackTraceTrimmingStrategy;
    }

    /* renamed from: a */
    private CrashlyticsReport.Builder m11247a() {
        return CrashlyticsReport.builder().setSdkVersion(BuildConfig.VERSION_NAME).setGmpAppId(this.f19031c.f19066a).setInstallationUuid(this.f19030b.getCrashlyticsInstallId()).setBuildVersion(this.f19031c.f19070e).setDisplayVersion(this.f19031c.f19071f).setPlatform(4);
    }

    /* renamed from: b */
    private static int m11248b() {
        Integer num;
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str) && (num = f19028f.get(str.toLowerCase(Locale.US))) != null) {
            return num.intValue();
        }
        return 7;
    }

    /* renamed from: c */
    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage m11249c() {
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder().setBaseAddress(0).setSize(0).setName(this.f19031c.f19069d).setUuid(this.f19031c.f19067b).build();
    }

    /* renamed from: d */
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> m11250d() {
        return ImmutableList.from((E[]) new CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[]{m11249c()});
    }

    /* renamed from: e */
    private CrashlyticsReport.Session.Event.Application m11251e(int i, TrimmedThrowableData trimmedThrowableData, Thread thread, int i2, int i3, boolean z) {
        Boolean bool;
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(this.f19031c.f19069d, this.f19029a);
        if (appProcessInfo != null) {
            bool = Boolean.valueOf(appProcessInfo.importance != 100);
        } else {
            bool = null;
        }
        return CrashlyticsReport.Session.Event.Application.builder().setBackground(bool).setUiOrientation(i).setExecution(m11255i(trimmedThrowableData, thread, i2, i3, z)).build();
    }

    /* renamed from: f */
    private CrashlyticsReport.Session.Event.Device m11252f(int i) {
        C3278c a = C3278c.m11288a(this.f19029a);
        Float b = a.mo20948b();
        Double valueOf = b != null ? Double.valueOf(b.doubleValue()) : null;
        int c = a.mo20949c();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(this.f19029a);
        return CrashlyticsReport.Session.Event.Device.builder().setBatteryLevel(valueOf).setBatteryVelocity(c).setProximityOn(proximitySensorEnabled).setOrientation(i).setRamUsed(CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(this.f19029a)).setDiskUsed(CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath())).build();
    }

    /* renamed from: g */
    private CrashlyticsReport.Session.Event.Application.Execution.Exception m11253g(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        return m11254h(trimmedThrowableData, i, i2, 0);
    }

    /* renamed from: h */
    private CrashlyticsReport.Session.Event.Application.Execution.Exception m11254h(TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        String str = trimmedThrowableData.className;
        String str2 = trimmedThrowableData.localizedMessage;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (i3 >= i2) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.cause;
                i4++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder overflowCount = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder().setType(str).setReason(str2).setFrames(ImmutableList.from(m11257k(stackTraceElementArr, i))).setOverflowCount(i4);
        if (trimmedThrowableData2 != null && i4 == 0) {
            overflowCount.setCausedBy(m11254h(trimmedThrowableData2, i, i2, i3 + 1));
        }
        return overflowCount.build();
    }

    /* renamed from: i */
    private CrashlyticsReport.Session.Event.Application.Execution m11255i(TrimmedThrowableData trimmedThrowableData, Thread thread, int i, int i2, boolean z) {
        return CrashlyticsReport.Session.Event.Application.Execution.builder().setThreads(m11265s(trimmedThrowableData, thread, i, z)).setException(m11253g(trimmedThrowableData, i, i2)).setSignal(m11262p()).setBinaries(m11250d()).build();
    }

    /* renamed from: j */
    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame m11256j(StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        long j = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max((long) stackTraceElement.getLineNumber(), 0) : 0;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j = (long) stackTraceElement.getLineNumber();
        }
        return builder.setPc(max).setSymbol(str).setFile(fileName).setOffset(j).build();
    }

    /* renamed from: k */
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> m11257k(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement j : stackTraceElementArr) {
            arrayList.add(m11256j(j, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder().setImportance(i)));
        }
        return ImmutableList.from(arrayList);
    }

    /* renamed from: l */
    private CrashlyticsReport.Session.Application m11258l() {
        return CrashlyticsReport.Session.Application.builder().setIdentifier(this.f19030b.getAppIdentifier()).setVersion(this.f19031c.f19070e).setDisplayVersion(this.f19031c.f19071f).setInstallationUuid(this.f19030b.getCrashlyticsInstallId()).build();
    }

    /* renamed from: m */
    private CrashlyticsReport.Session m11259m(String str, long j) {
        return CrashlyticsReport.Session.builder().setStartedAt(j).setIdentifier(str).setGenerator(f19027e).setApp(m11258l()).setOs(m11261o()).setDevice(m11260n()).setGeneratorType(3).build();
    }

    /* renamed from: n */
    private CrashlyticsReport.Session.Device m11260n() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int b = m11248b();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean isEmulator = CommonUtils.isEmulator(this.f19029a);
        int deviceState = CommonUtils.getDeviceState(this.f19029a);
        String str = Build.MANUFACTURER;
        return CrashlyticsReport.Session.Device.builder().setArch(b).setModel(Build.MODEL).setCores(availableProcessors).setRam(totalRamInBytes).setDiskSpace(blockCount).setSimulator(isEmulator).setState(deviceState).setManufacturer(str).setModelClass(Build.PRODUCT).build();
    }

    /* renamed from: o */
    private CrashlyticsReport.Session.OperatingSystem m11261o() {
        return CrashlyticsReport.Session.OperatingSystem.builder().setPlatform(3).setVersion(Build.VERSION.RELEASE).setBuildVersion(Build.VERSION.CODENAME).setJailbroken(CommonUtils.isRooted(this.f19029a)).build();
    }

    /* renamed from: p */
    private CrashlyticsReport.Session.Event.Application.Execution.Signal m11262p() {
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.builder().setName("0").setCode("0").setAddress(0).build();
    }

    /* renamed from: q */
    private CrashlyticsReport.Session.Event.Application.Execution.Thread m11263q(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return m11264r(thread, stackTraceElementArr, 0);
    }

    /* renamed from: r */
    private CrashlyticsReport.Session.Event.Application.Execution.Thread m11264r(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.builder().setName(thread.getName()).setImportance(i).setFrames(ImmutableList.from(m11257k(stackTraceElementArr, i))).build();
    }

    /* renamed from: s */
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> m11265s(TrimmedThrowableData trimmedThrowableData, Thread thread, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m11264r(thread, trimmedThrowableData.stacktrace, i));
        if (z) {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(m11263q(thread2, this.f19032d.getTrimmedStackTrace((StackTraceElement[]) next.getValue())));
                }
            }
        }
        return ImmutableList.from(arrayList);
    }

    public CrashlyticsReport.Session.Event captureEventData(Throwable th, Thread thread, String str, long j, int i, int i2, boolean z) {
        int i3 = this.f19029a.getResources().getConfiguration().orientation;
        Throwable th2 = th;
        String str2 = str;
        long j2 = j;
        return CrashlyticsReport.Session.Event.builder().setType(str).setTimestamp(j).setApp(m11251e(i3, new TrimmedThrowableData(th, this.f19032d), thread, i, i2, z)).setDevice(m11252f(i3)).build();
    }

    public CrashlyticsReport captureReportData(String str, long j) {
        return m11247a().setSession(m11259m(str, j)).build();
    }

    public CrashlyticsReport captureReportData() {
        return m11247a().build();
    }
}
