package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final File f5510a;

    /* renamed from: b */
    private final File f5511b;

    /* renamed from: c */
    private final File f5512c;

    /* renamed from: d */
    private final File f5513d;

    /* renamed from: e */
    private final int f5514e;

    /* renamed from: f */
    private long f5515f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f5516g;

    /* renamed from: h */
    private long f5517h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Writer f5518i;

    /* renamed from: j */
    private final LinkedHashMap<String, C1164c> f5519j = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f5520k;

    /* renamed from: l */
    private long f5521l = 0;

    /* renamed from: m */
    final ThreadPoolExecutor f5522m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1163b((C1162a) null));

    /* renamed from: n */
    private final Callable<Void> f5523n = new C1162a();

    public final class Editor {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C1164c f5524a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final boolean[] f5525b;

        /* renamed from: c */
        private boolean f5526c;

        /* synthetic */ Editor(DiskLruCache diskLruCache, C1164c cVar, C1162a aVar) {
            this(cVar);
        }

        /* renamed from: c */
        private InputStream m4139c(int i) {
            synchronized (DiskLruCache.this) {
                if (this.f5524a.f5539f != this) {
                    throw new IllegalStateException();
                } else if (!this.f5524a.f5538e) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.f5524a.mo9326j(i));
                        return fileInputStream;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        public void abort() {
            DiskLruCache.this.m4125m(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.f5526c) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }

        public void commit() {
            DiskLruCache.this.m4125m(this, true);
            this.f5526c = true;
        }

        public File getFile(int i) {
            File k;
            synchronized (DiskLruCache.this) {
                if (this.f5524a.f5539f == this) {
                    if (!this.f5524a.f5538e) {
                        this.f5525b[i] = true;
                    }
                    k = this.f5524a.mo9327k(i);
                    if (!DiskLruCache.this.f5510a.exists()) {
                        DiskLruCache.this.f5510a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k;
        }

        public String getString(int i) {
            InputStream c = m4139c(i);
            if (c != null) {
                return DiskLruCache.m4129q(c);
            }
            return null;
        }

        public void set(int i, String str) {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(getFile(i)), C1167b.f5549b);
                try {
                    outputStreamWriter2.write(str);
                    C1167b.m4159a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    C1167b.m4159a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C1167b.m4159a(outputStreamWriter);
                throw th;
            }
        }

        private Editor(C1164c cVar) {
            this.f5524a = cVar;
            this.f5525b = cVar.f5538e ? null : new boolean[DiskLruCache.this.f5516g];
        }
    }

    public final class Value {

        /* renamed from: a */
        private final String f5528a;

        /* renamed from: b */
        private final long f5529b;

        /* renamed from: c */
        private final long[] f5530c;

        /* renamed from: d */
        private final File[] f5531d;

        /* synthetic */ Value(DiskLruCache diskLruCache, String str, long j, File[] fileArr, long[] jArr, C1162a aVar) {
            this(str, j, fileArr, jArr);
        }

        public Editor edit() {
            return DiskLruCache.this.m4127o(this.f5528a, this.f5529b);
        }

        public File getFile(int i) {
            return this.f5531d[i];
        }

        public long getLength(int i) {
            return this.f5530c[i];
        }

        public String getString(int i) {
            return DiskLruCache.m4129q(new FileInputStream(this.f5531d[i]));
        }

        private Value(String str, long j, File[] fileArr, long[] jArr) {
            this.f5528a = str;
            this.f5529b = j;
            this.f5531d = fileArr;
            this.f5530c = jArr;
        }
    }

    /* renamed from: com.bumptech.glide.disklrucache.DiskLruCache$a */
    class C1162a implements Callable<Void> {
        C1162a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() {
            /*
                r4 = this;
                com.bumptech.glide.disklrucache.DiskLruCache r0 = com.bumptech.glide.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f5518i     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m4136x()     // Catch:{ all -> 0x0028 }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.m4130r()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m4134v()     // Catch:{ all -> 0x0028 }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f5520k = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.C1162a.call():java.lang.Void");
        }
    }

    /* renamed from: com.bumptech.glide.disklrucache.DiskLruCache$b */
    private static final class C1163b implements ThreadFactory {
        private C1163b() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ C1163b(C1162a aVar) {
            this();
        }
    }

    /* renamed from: com.bumptech.glide.disklrucache.DiskLruCache$c */
    private final class C1164c {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f5534a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long[] f5535b;

        /* renamed from: c */
        File[] f5536c;

        /* renamed from: d */
        File[] f5537d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f5538e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Editor f5539f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public long f5540g;

        /* synthetic */ C1164c(DiskLruCache diskLruCache, String str, C1162a aVar) {
            this(str);
        }

        /* renamed from: m */
        private IOException m4150m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public void m4151n(String[] strArr) {
            if (strArr.length == DiskLruCache.this.f5516g) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f5535b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        m4150m(strArr);
                        throw null;
                    }
                }
                return;
            }
            m4150m(strArr);
            throw null;
        }

        /* renamed from: j */
        public File mo9326j(int i) {
            return this.f5536c[i];
        }

        /* renamed from: k */
        public File mo9327k(int i) {
            return this.f5537d[i];
        }

        /* renamed from: l */
        public String mo9328l() {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f5535b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        private C1164c(String str) {
            this.f5534a = str;
            this.f5535b = new long[DiskLruCache.this.f5516g];
            this.f5536c = new File[DiskLruCache.this.f5516g];
            this.f5537d = new File[DiskLruCache.this.f5516g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.f5516g; i++) {
                sb.append(i);
                this.f5536c[i] = new File(DiskLruCache.this.f5510a, sb.toString());
                sb.append(".tmp");
                this.f5537d[i] = new File(DiskLruCache.this.f5510a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        this.f5510a = file2;
        this.f5514e = i;
        this.f5511b = new File(file2, "journal");
        this.f5512c = new File(file2, "journal.tmp");
        this.f5513d = new File(file2, "journal.bkp");
        this.f5516g = i2;
        this.f5515f = j;
    }

    /* renamed from: k */
    private void m4123k() {
        if (this.f5518i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    /* renamed from: l */
    private static void m4124l(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m4125m(com.bumptech.glide.disklrucache.DiskLruCache.Editor r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bumptech.glide.disklrucache.DiskLruCache$c r0 = r10.f5524a     // Catch:{ all -> 0x010e }
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r1 = r0.f5539f     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f5538e     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f5516g     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f5525b     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.mo9327k(r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.abort()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.abort()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.f5516g     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.mo9327k(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.mo9326j(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5535b     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5535b     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f5517h     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f5517h = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            m4126n(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f5520k     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.f5520k = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f5539f = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f5538e     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f5538e = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.f5534a     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.mo9328l()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.f5521l     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.f5521l = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f5540g = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$c> r10 = r9.f5519j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f5534a     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f5534a     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f5518i     // Catch:{ all -> 0x010e }
            m4128p(r10)     // Catch:{ all -> 0x010e }
            long r10 = r9.f5517h     // Catch:{ all -> 0x010e }
            long r0 = r9.f5515f     // Catch:{ all -> 0x010e }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ff
            boolean r10 = r9.m4130r()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f5522m     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f5523n     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0112
        L_0x0111:
            throw r10
        L_0x0112:
            goto L_0x0111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.m4125m(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    /* renamed from: n */
    private static void m4126n(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.disklrucache.DiskLruCache.Editor m4127o(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m4123k()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$c> r0 = r5.f5519j     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            com.bumptech.glide.disklrucache.DiskLruCache$c r0 = (com.bumptech.glide.disklrucache.DiskLruCache.C1164c) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.f5540g     // Catch:{ all -> 0x005d }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            com.bumptech.glide.disklrucache.DiskLruCache$c r0 = new com.bumptech.glide.disklrucache.DiskLruCache$c     // Catch:{ all -> 0x005d }
            r0.<init>(r5, r6, r3)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$c> r7 = r5.f5519j     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = r0.f5539f     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r3
        L_0x0034:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = new com.bumptech.glide.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x005d }
            r7.<init>(r5, r0, r3)     // Catch:{ all -> 0x005d }
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f5539f = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f5518i     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f5518i     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f5518i     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f5518i     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f5518i     // Catch:{ all -> 0x005d }
            m4128p(r6)     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.m4127o(java.lang.String, long):com.bumptech.glide.disklrucache.DiskLruCache$Editor");
    }

    public static DiskLruCache open(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m4135w(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.f5511b.exists()) {
                try {
                    diskLruCache.m4132t();
                    diskLruCache.m4131s();
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
            diskLruCache2.m4134v();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    @TargetApi(26)
    /* renamed from: p */
    private static void m4128p(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public static String m4129q(InputStream inputStream) {
        return C1167b.m4161c(new InputStreamReader(inputStream, C1167b.f5549b));
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public boolean m4130r() {
        int i = this.f5520k;
        return i >= 2000 && i >= this.f5519j.size();
    }

    /* renamed from: s */
    private void m4131s() {
        m4126n(this.f5512c);
        Iterator<C1164c> it = this.f5519j.values().iterator();
        while (it.hasNext()) {
            C1164c next = it.next();
            int i = 0;
            if (next.f5539f == null) {
                while (i < this.f5516g) {
                    this.f5517h += next.f5535b[i];
                    i++;
                }
            } else {
                Editor unused = next.f5539f = null;
                while (i < this.f5516g) {
                    m4126n(next.mo9326j(i));
                    m4126n(next.mo9327k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f5520k = r0 - r9.f5519j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.mo9329c() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        m4134v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f5518i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f5511b, true), com.bumptech.glide.disklrucache.C1167b.f5548a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4132t() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.bumptech.glide.disklrucache.a r1 = new com.bumptech.glide.disklrucache.a
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f5511b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bumptech.glide.disklrucache.C1167b.f5548a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.mo9331d()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.mo9331d()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.mo9331d()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.mo9331d()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.mo9331d()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f5514e     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f5516g     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.mo9331d()     // Catch:{ EOFException -> 0x005f }
            r9.m4133u(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$c> r2 = r9.f5519j     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f5520k = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.mo9329c()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.m4134v()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f5511b     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = com.bumptech.glide.disklrucache.C1167b.f5548a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f5518i = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            com.bumptech.glide.disklrucache.C1167b.m4159a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            com.bumptech.glide.disklrucache.C1167b.m4159a(r1)
            goto L_0x00c0
        L_0x00bf:
            throw r0
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.m4132t():void");
    }

    /* renamed from: u */
    private void m4133u(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f5519j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C1164c cVar = this.f5519j.get(str2);
            if (cVar == null) {
                cVar = new C1164c(this, str2, (C1162a) null);
                this.f5519j.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = cVar.f5538e = true;
                Editor unused2 = cVar.f5539f = null;
                cVar.m4151n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                Editor unused3 = cVar.f5539f = new Editor(this, cVar, (C1162a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: v */
    public synchronized void m4134v() {
        Writer writer = this.f5518i;
        if (writer != null) {
            m4124l(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5512c), C1167b.f5548a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5514e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f5516g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C1164c next : this.f5519j.values()) {
                if (next.f5539f != null) {
                    bufferedWriter.write("DIRTY " + next.f5534a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f5534a + next.mo9328l() + 10);
                }
            }
            m4124l(bufferedWriter);
            if (this.f5511b.exists()) {
                m4135w(this.f5511b, this.f5513d, true);
            }
            m4135w(this.f5512c, this.f5511b, false);
            this.f5513d.delete();
            this.f5518i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5511b, true), C1167b.f5548a));
        } catch (Throwable th) {
            m4124l(bufferedWriter);
            throw th;
        }
    }

    /* renamed from: w */
    private static void m4135w(File file, File file2, boolean z) {
        if (z) {
            m4126n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m4136x() {
        while (this.f5517h > this.f5515f) {
            remove((String) this.f5519j.entrySet().iterator().next().getKey());
        }
    }

    public synchronized void close() {
        if (this.f5518i != null) {
            Iterator it = new ArrayList(this.f5519j.values()).iterator();
            while (it.hasNext()) {
                C1164c cVar = (C1164c) it.next();
                if (cVar.f5539f != null) {
                    cVar.f5539f.abort();
                }
            }
            m4136x();
            m4124l(this.f5518i);
            this.f5518i = null;
        }
    }

    public void delete() {
        close();
        C1167b.m4160b(this.f5510a);
    }

    public Editor edit(String str) {
        return m4127o(str, -1);
    }

    public synchronized void flush() {
        m4123k();
        m4136x();
        m4128p(this.f5518i);
    }

    public synchronized Value get(String str) {
        m4123k();
        C1164c cVar = this.f5519j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f5538e) {
            return null;
        }
        for (File exists : cVar.f5536c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f5520k++;
        this.f5518i.append("READ");
        this.f5518i.append(' ');
        this.f5518i.append(str);
        this.f5518i.append(10);
        if (m4130r()) {
            this.f5522m.submit(this.f5523n);
        }
        return new Value(this, str, cVar.f5540g, cVar.f5536c, cVar.f5535b, (C1162a) null);
    }

    public File getDirectory() {
        return this.f5510a;
    }

    public synchronized long getMaxSize() {
        return this.f5515f;
    }

    public synchronized boolean isClosed() {
        return this.f5518i == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m4123k()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$c> r0 = r7.f5519j     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            com.bumptech.glide.disklrucache.DiskLruCache$c r0 = (com.bumptech.glide.disklrucache.DiskLruCache.C1164c) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r2 = r0.f5539f     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f5516g     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.mo9326j(r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.f5517h     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f5535b     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f5517h = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f5535b     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.f5520k     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.f5520k = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5518i     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5518i     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5518i     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f5518i     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$c> r0 = r7.f5519j     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.m4130r()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f5522m     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f5523n     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0093
        L_0x0092:
            throw r8
        L_0x0093:
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized void setMaxSize(long j) {
        this.f5515f = j;
        this.f5522m.submit(this.f5523n);
    }

    public synchronized long size() {
        return this.f5517h;
    }
}
