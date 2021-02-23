package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {

    /* renamed from: a */
    private static final FilenameFilter f19060a = new C3272a();

    /* renamed from: b */
    private static final ExecutorService f19061b = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    /* renamed from: com.google.firebase.crashlytics.internal.common.Utils$a */
    class C3272a implements FilenameFilter {
        C3272a() {
        }

        public boolean accept(File file, String str) {
            return true;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.Utils$b */
    class C3273b implements Continuation<T, Void> {

        /* renamed from: a */
        final /* synthetic */ TaskCompletionSource f19062a;

        C3273b(TaskCompletionSource taskCompletionSource) {
            this.f19062a = taskCompletionSource;
        }

        /* renamed from: a */
        public Void then(@NonNull Task<T> task) {
            if (task.isSuccessful()) {
                this.f19062a.trySetResult(task.getResult());
                return null;
            }
            this.f19062a.trySetException(task.getException());
            return null;
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.common.Utils$c */
    class C3274c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callable f19063a;

        /* renamed from: b */
        final /* synthetic */ TaskCompletionSource f19064b;

        /* renamed from: com.google.firebase.crashlytics.internal.common.Utils$c$a */
        class C3275a implements Continuation<T, Void> {
            C3275a() {
            }

            /* renamed from: a */
            public Void then(@NonNull Task<T> task) {
                if (task.isSuccessful()) {
                    C3274c.this.f19064b.setResult(task.getResult());
                    return null;
                }
                C3274c.this.f19064b.setException(task.getException());
                return null;
            }
        }

        C3274c(Callable callable, TaskCompletionSource taskCompletionSource) {
            this.f19063a = callable;
            this.f19064b = taskCompletionSource;
        }

        public void run() {
            try {
                ((Task) this.f19063a.call()).continueWith(new C3275a());
            } catch (Exception e) {
                this.f19064b.setException(e);
            }
        }
    }

    private Utils() {
    }

    /* renamed from: a */
    static int m11279a(File file, int i, Comparator<File> comparator) {
        return m11280b(file, f19060a, i, comparator);
    }

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(f19061b, C3336t.m11481a(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new TimeoutException();
        }
    }

    /* renamed from: b */
    static int m11280b(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return m11281c(Arrays.asList(listFiles), i, comparator);
    }

    /* renamed from: c */
    static int m11281c(List<File> list, int i, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File next : list) {
            if (size <= i) {
                return size;
            }
            m11284f(next);
            size--;
        }
        return size;
    }

    public static <T> Task<T> callTask(Executor executor, Callable<Task<T>> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new C3274c(callable, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* renamed from: d */
    static int m11282d(File file, File file2, int i, Comparator<File> comparator) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        File[] listFiles2 = file2.listFiles(f19060a);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        arrayList.addAll(Arrays.asList(listFiles));
        arrayList.addAll(Arrays.asList(listFiles2));
        return m11281c(arrayList, i, comparator);
    }

    /* renamed from: f */
    private static void m11284f(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                m11284f(f);
            }
        }
        file.delete();
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3273b bVar = new C3273b(taskCompletionSource);
        task.continueWith(bVar);
        task2.continueWith(bVar);
        return taskCompletionSource.getTask();
    }
}
