package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.firebase.crashlytics.internal.common.k */
/* compiled from: CrashlyticsUncaughtExceptionHandler */
class C3325k implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final C3326a f19191a;

    /* renamed from: b */
    private final SettingsDataProvider f19192b;

    /* renamed from: c */
    private final Thread.UncaughtExceptionHandler f19193c;

    /* renamed from: d */
    private final AtomicBoolean f19194d = new AtomicBoolean(false);

    /* renamed from: com.google.firebase.crashlytics.internal.common.k$a */
    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    interface C3326a {
        /* renamed from: a */
        void mo21017a(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th);
    }

    public C3325k(C3326a aVar, SettingsDataProvider settingsDataProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f19191a = aVar;
        this.f19192b = settingsDataProvider;
        this.f19193c = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo21031a() {
        return this.f19194d.get();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f19194d.set(true);
        if (thread == null) {
            try {
                Logger.getLogger().mo20861e("Could not handle uncaught exception; null thread");
            } catch (Exception e) {
                Logger.getLogger().mo20862e("An error occurred in the uncaught exception handler", e);
            } catch (Throwable th2) {
                Logger.getLogger().mo20859d("Crashlytics completed exception processing. Invoking default exception handler.");
                this.f19193c.uncaughtException(thread, th);
                this.f19194d.set(false);
                throw th2;
            }
        } else if (th == null) {
            Logger.getLogger().mo20861e("Could not handle uncaught exception; null throwable");
        } else {
            this.f19191a.mo21017a(this.f19192b, thread, th);
        }
        Logger.getLogger().mo20859d("Crashlytics completed exception processing. Invoking default exception handler.");
        this.f19193c.uncaughtException(thread, th);
        this.f19194d.set(false);
    }
}
