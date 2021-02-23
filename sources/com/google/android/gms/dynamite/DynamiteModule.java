package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class DynamiteModule {
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new C1706f();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new C1705e();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new C1707g();
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new C1704d();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new C1701a();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new C1703c();
    @GuardedBy("DynamiteModule.class")

    /* renamed from: b */
    private static Boolean f7761b = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: c */
    private static zzk f7762c = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: d */
    private static zzm f7763d = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: e */
    private static String f7764e = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: f */
    private static int f7765f = -1;

    /* renamed from: g */
    private static final ThreadLocal<C1699a> f7766g = new ThreadLocal<>();

    /* renamed from: h */
    private static final VersionPolicy.zzb f7767h = new C1702b();

    /* renamed from: a */
    private final Context f7768a;

    @DynamiteApi
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, C1702b bVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, C1702b bVar) {
            this(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public static class zza {
            public int zza = 0;
            public int zzb = 0;
            public int zzc = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public interface zzb {
            int zza(Context context, String str);

            int zza(Context context, String str, boolean z);
        }

        zza zza(Context context, String str, zzb zzb2);
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    private static class C1699a {

        /* renamed from: a */
        public Cursor f7769a;

        private C1699a() {
        }

        /* synthetic */ C1699a(C1702b bVar) {
            this();
        }
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    private static class C1700b implements VersionPolicy.zzb {

        /* renamed from: a */
        private final int f7770a;

        public C1700b(int i, int i2) {
            this.f7770a = i;
        }

        public final int zza(Context context, String str) {
            return this.f7770a;
        }

        public final int zza(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.f7768a = (Context) Preconditions.checkNotNull(context);
    }

    /* renamed from: a */
    private static DynamiteModule m5737a(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    /* renamed from: b */
    private static DynamiteModule m5738b(Context context, String str, int i) {
        Boolean bool;
        IObjectWrapper iObjectWrapper;
        try {
            synchronized (DynamiteModule.class) {
                bool = f7761b;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (C1702b) null);
            } else if (bool.booleanValue()) {
                return m5743g(context, str, i);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                Log.i("DynamiteModule", sb.toString());
                zzk c = m5739c(context);
                if (c != null) {
                    if (c.zzb() >= 2) {
                        iObjectWrapper = c.zzb(ObjectWrapper.wrap(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        iObjectWrapper = c.zza(ObjectWrapper.wrap(context), str, i);
                    }
                    if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                        return new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                    }
                    throw new LoadingException("Failed to load remote module.", (C1702b) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (C1702b) null);
            }
        } catch (RemoteException e) {
            throw new LoadingException("Failed to load remote module.", e, (C1702b) null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Throwable th) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
            throw new LoadingException("Failed to load remote module.", th, (C1702b) null);
        }
    }

    /* renamed from: c */
    private static zzk m5739c(Context context) {
        zzk zzk;
        synchronized (DynamiteModule.class) {
            zzk zzk2 = f7762c;
            if (zzk2 != null) {
                return zzk2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzk = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzk) {
                        zzk = (zzk) queryLocalInterface;
                    } else {
                        zzk = new zzj(iBinder);
                    }
                }
                if (zzk != null) {
                    f7762c = zzk;
                    return zzk;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    /* renamed from: d */
    private static Boolean m5740d() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f7765f >= 2);
        }
        return valueOf;
    }

    @GuardedBy("DynamiteModule.class")
    /* renamed from: e */
    private static void m5741e(ClassLoader classLoader) {
        zzm zzm;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzm = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzm) {
                    zzm = (zzm) queryLocalInterface;
                } else {
                    zzm = new zzl(iBinder);
                }
            }
            f7763d = zzm;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (C1702b) null);
        }
    }

    /* renamed from: f */
    private static int m5742f(Context context, String str, boolean z) {
        zzk c = m5739c(context);
        if (c == null) {
            return 0;
        }
        try {
            if (c.zzb() >= 2) {
                return c.zzb(ObjectWrapper.wrap(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return c.zza(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* renamed from: g */
    private static DynamiteModule m5743g(Context context, String str, int i) {
        zzm zzm;
        IObjectWrapper iObjectWrapper;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            zzm = f7763d;
        }
        if (zzm != null) {
            C1699a aVar = f7766g.get();
            if (aVar == null || aVar.f7769a == null) {
                throw new LoadingException("No result cursor", (C1702b) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = aVar.f7769a;
            ObjectWrapper.wrap(null);
            if (m5740d().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                iObjectWrapper = zzm.zzb(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                iObjectWrapper = zzm.zza(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor));
            }
            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (C1702b) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (C1702b) null);
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m5744h(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r10 == 0) goto L_0x000a
            java.lang.String r8 = "api_force_staging"
            goto L_0x000c
        L_0x000a:
            java.lang.String r8 = "api"
        L_0x000c:
            int r10 = r8.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r2 = r2.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.<init>(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r8 == 0) goto L_0x0083
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 == 0) goto L_0x0083
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 <= 0) goto L_0x007c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0079 }
            f7764e = r1     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0079 }
            if (r1 < 0) goto L_0x0067
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0079 }
            f7765f = r1     // Catch:{ all -> 0x0079 }
        L_0x0067:
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$a> r10 = f7766g     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$a r10 = (com.google.android.gms.dynamite.DynamiteModule.C1699a) r10     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r10 == 0) goto L_0x007c
            android.database.Cursor r1 = r10.f7769a     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r1 != 0) goto L_0x007c
            r10.f7769a = r8     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            goto L_0x007d
        L_0x0079:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x007c:
            r0 = r8
        L_0x007d:
            if (r0 == 0) goto L_0x0082
            r0.close()
        L_0x0082:
            return r9
        L_0x0083:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>((java.lang.String) r10, (com.google.android.gms.dynamite.C1702b) r0)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x0092:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00ae
        L_0x0096:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x009f
        L_0x009b:
            r8 = move-exception
            goto L_0x00ae
        L_0x009d:
            r8 = move-exception
            r9 = r0
        L_0x009f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x00a4
            throw r8     // Catch:{ all -> 0x00ac }
        L_0x00a4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00ac }
            throw r10     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r8 = move-exception
            r0 = r9
        L_0x00ae:
            if (r0 == 0) goto L_0x00b3
            r0.close()
        L_0x00b3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.m5744h(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) {
        VersionPolicy.zza zza;
        ThreadLocal<C1699a> threadLocal = f7766g;
        C1699a aVar = threadLocal.get();
        C1699a aVar2 = new C1699a((C1702b) null);
        threadLocal.set(aVar2);
        try {
            zza = versionPolicy.zza(context, str, f7767h);
            int i = zza.zza;
            int i2 = zza.zzb;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            int i3 = zza.zzc;
            if (i3 == 0 || ((i3 == -1 && zza.zza == 0) || (i3 == 1 && zza.zzb == 0))) {
                int i4 = zza.zza;
                int i5 = zza.zzb;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (C1702b) null);
            } else if (i3 == -1) {
                DynamiteModule a = m5737a(context, str);
                Cursor cursor = aVar2.f7769a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(aVar);
                return a;
            } else if (i3 == 1) {
                DynamiteModule b = m5738b(context, str, zza.zzb);
                Cursor cursor2 = aVar2.f7769a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                threadLocal.set(aVar);
                return b;
            } else {
                int i6 = zza.zzc;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new LoadingException(sb3.toString(), (C1702b) null);
            }
        } catch (LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
            int i7 = zza.zza;
            if (i7 == 0 || versionPolicy.zza(context, str, new C1700b(i7, 0)).zzc != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e, (C1702b) null);
            }
            DynamiteModule a2 = m5737a(context, str);
            Cursor cursor3 = aVar2.f7769a;
            if (cursor3 != null) {
                cursor3.close();
            }
            f7766g.set(aVar);
            return a2;
        } catch (Throwable th) {
            Cursor cursor4 = aVar2.f7769a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f7766g.set(aVar);
            throw th;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r2 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r2)     // Catch:{ all -> 0x00ff }
            java.lang.Boolean r3 = f7761b     // Catch:{ all -> 0x00fc }
            if (r3 != 0) goto L_0x00c9
            android.content.Context r3 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            java.lang.Class r3 = r3.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            java.lang.Class r4 = r3.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
            r5 = 0
            java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x009a }
            java.lang.ClassLoader r6 = (java.lang.ClassLoader) r6     // Catch:{ all -> 0x009a }
            if (r6 == 0) goto L_0x003d
            java.lang.ClassLoader r3 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009a }
            if (r6 != r3) goto L_0x0039
        L_0x0037:
            r0 = r1
            goto L_0x0097
        L_0x0039:
            m5741e(r6)     // Catch:{ LoadingException -> 0x0097 }
            goto L_0x0097
        L_0x003d:
            java.lang.String r6 = "com.google.android.gms"
            android.content.Context r7 = r10.getApplicationContext()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ all -> 0x009a }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x009a }
            if (r6 == 0) goto L_0x0055
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009a }
            r3.set(r5, r0)     // Catch:{ all -> 0x009a }
            goto L_0x0037
        L_0x0055:
            int r6 = m5744h(r10, r11, r12)     // Catch:{ LoadingException -> 0x008f }
            java.lang.String r7 = f7764e     // Catch:{ LoadingException -> 0x008f }
            if (r7 == 0) goto L_0x008c
            boolean r7 = r7.isEmpty()     // Catch:{ LoadingException -> 0x008f }
            if (r7 == 0) goto L_0x0064
            goto L_0x008c
        L_0x0064:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x008f }
            r8 = 29
            if (r7 < r8) goto L_0x0076
            dalvik.system.DelegateLastClassLoader r7 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x008f }
            java.lang.String r8 = f7764e     // Catch:{ LoadingException -> 0x008f }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x008f }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x008f }
            goto L_0x0081
        L_0x0076:
            com.google.android.gms.dynamite.h r7 = new com.google.android.gms.dynamite.h     // Catch:{ LoadingException -> 0x008f }
            java.lang.String r8 = f7764e     // Catch:{ LoadingException -> 0x008f }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x008f }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x008f }
        L_0x0081:
            m5741e(r7)     // Catch:{ LoadingException -> 0x008f }
            r3.set(r5, r7)     // Catch:{ LoadingException -> 0x008f }
            f7761b = r0     // Catch:{ LoadingException -> 0x008f }
            monitor-exit(r4)     // Catch:{ all -> 0x009a }
            monitor-exit(r2)     // Catch:{ all -> 0x00fc }
            return r6
        L_0x008c:
            monitor-exit(r4)     // Catch:{ all -> 0x009a }
            monitor-exit(r2)     // Catch:{ all -> 0x00fc }
            return r6
        L_0x008f:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x009a }
            r3.set(r5, r0)     // Catch:{ all -> 0x009a }
            goto L_0x0037
        L_0x0097:
            monitor-exit(r4)     // Catch:{ all -> 0x009a }
            r1 = r0
            goto L_0x00c6
        L_0x009a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x009a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x00a1, IllegalAccessException -> 0x009f, NoSuchFieldException -> 0x009d }
        L_0x009d:
            r0 = move-exception
            goto L_0x00a2
        L_0x009f:
            r0 = move-exception
            goto L_0x00a2
        L_0x00a1:
            r0 = move-exception
        L_0x00a2:
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00fc }
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00fc }
            int r4 = r4.length()     // Catch:{ all -> 0x00fc }
            int r4 = r4 + 30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r5.<init>(r4)     // Catch:{ all -> 0x00fc }
            java.lang.String r4 = "Failed to load module via V2: "
            r5.append(r4)     // Catch:{ all -> 0x00fc }
            r5.append(r0)     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00fc }
            android.util.Log.w(r3, r0)     // Catch:{ all -> 0x00fc }
        L_0x00c6:
            f7761b = r1     // Catch:{ all -> 0x00fc }
            r3 = r1
        L_0x00c9:
            monitor-exit(r2)     // Catch:{ all -> 0x00fc }
            boolean r0 = r3.booleanValue()     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x00f7
            int r10 = m5744h(r10, r11, r12)     // Catch:{ LoadingException -> 0x00d5 }
            return r10
        L_0x00d5:
            r11 = move-exception
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00ff }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x00ff }
            int r1 = r11.length()     // Catch:{ all -> 0x00ff }
            if (r1 == 0) goto L_0x00ed
            java.lang.String r11 = r0.concat(r11)     // Catch:{ all -> 0x00ff }
            goto L_0x00f2
        L_0x00ed:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00ff }
            r11.<init>(r0)     // Catch:{ all -> 0x00ff }
        L_0x00f2:
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x00ff }
            r10 = 0
            return r10
        L_0x00f7:
            int r10 = m5742f(r10, r11, r12)     // Catch:{ all -> 0x00ff }
            return r10
        L_0x00fc:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00fc }
            throw r11     // Catch:{ all -> 0x00ff }
        L_0x00ff:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            goto L_0x0105
        L_0x0104:
            throw r11
        L_0x0105:
            goto L_0x0104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    @KeepForSdk
    public final Context getModuleContext() {
        return this.f7768a;
    }

    @KeepForSdk
    public final IBinder instantiate(String str) {
        try {
            return (IBinder) this.f7768a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (C1702b) null);
        }
    }
}
