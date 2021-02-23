package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.SelfDestructiveThread;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String PARCEL_FONT_RESULTS = "font_results";

    /* renamed from: a */
    static final LruCache<String, Typeface> f2449a = new LruCache<>(16);

    /* renamed from: b */
    private static final SelfDestructiveThread f2450b = new SelfDestructiveThread("fonts", 10, 10000);

    /* renamed from: c */
    static final Object f2451c = new Object();
    @GuardedBy("sLock")

    /* renamed from: d */
    static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<C0505f>>> f2452d = new SimpleArrayMap<>();

    /* renamed from: e */
    private static final Comparator<byte[]> f2453e = new C0504e();

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;

        /* renamed from: a */
        private final int f2454a;

        /* renamed from: b */
        private final FontInfo[] f2455b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int i, @Nullable FontInfo[] fontInfoArr) {
            this.f2454a = i;
            this.f2455b = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            return this.f2455b;
        }

        public int getStatusCode() {
            return this.f2454a;
        }
    }

    public static class FontInfo {

        /* renamed from: a */
        private final Uri f2456a;

        /* renamed from: b */
        private final int f2457b;

        /* renamed from: c */
        private final int f2458c;

        /* renamed from: d */
        private final boolean f2459d;

        /* renamed from: e */
        private final int f2460e;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i, @IntRange(from = 1, mo779to = 1000) int i2, boolean z, int i3) {
            this.f2456a = (Uri) Preconditions.checkNotNull(uri);
            this.f2457b = i;
            this.f2458c = i2;
            this.f2459d = z;
            this.f2460e = i3;
        }

        public int getResultCode() {
            return this.f2460e;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.f2457b;
        }

        @NonNull
        public Uri getUri() {
            return this.f2456a;
        }

        @IntRange(from = 1, mo779to = 1000)
        public int getWeight() {
            return this.f2458c;
        }

        public boolean isItalic() {
            return this.f2459d;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int RESULT_OK = 0;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$a */
    class C0491a implements Callable<C0505f> {

        /* renamed from: a */
        final /* synthetic */ Context f2461a;

        /* renamed from: b */
        final /* synthetic */ FontRequest f2462b;

        /* renamed from: c */
        final /* synthetic */ int f2463c;

        /* renamed from: d */
        final /* synthetic */ String f2464d;

        C0491a(Context context, FontRequest fontRequest, int i, String str) {
            this.f2461a = context;
            this.f2462b = fontRequest;
            this.f2463c = i;
            this.f2464d = str;
        }

        /* renamed from: a */
        public C0505f call() {
            C0505f e = FontsContractCompat.m1636e(this.f2461a, this.f2462b, this.f2463c);
            Typeface typeface = e.f2483a;
            if (typeface != null) {
                FontsContractCompat.f2449a.put(this.f2464d, typeface);
            }
            return e;
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$b */
    class C0492b implements SelfDestructiveThread.ReplyCallback<C0505f> {

        /* renamed from: a */
        final /* synthetic */ ResourcesCompat.FontCallback f2465a;

        /* renamed from: b */
        final /* synthetic */ Handler f2466b;

        C0492b(ResourcesCompat.FontCallback fontCallback, Handler handler) {
            this.f2465a = fontCallback;
            this.f2466b = handler;
        }

        /* renamed from: a */
        public void onReply(C0505f fVar) {
            if (fVar == null) {
                this.f2465a.callbackFailAsync(1, this.f2466b);
                return;
            }
            int i = fVar.f2484b;
            if (i == 0) {
                this.f2465a.callbackSuccessAsync(fVar.f2483a, this.f2466b);
            } else {
                this.f2465a.callbackFailAsync(i, this.f2466b);
            }
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$c */
    class C0493c implements SelfDestructiveThread.ReplyCallback<C0505f> {

        /* renamed from: a */
        final /* synthetic */ String f2467a;

        C0493c(String str) {
            this.f2467a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            ((androidx.core.provider.SelfDestructiveThread.ReplyCallback) r2.get(r0)).onReply(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReply(androidx.core.provider.FontsContractCompat.C0505f r5) {
            /*
                r4 = this;
                java.lang.Object r0 = androidx.core.provider.FontsContractCompat.f2451c
                monitor-enter(r0)
                androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.provider.SelfDestructiveThread$ReplyCallback<androidx.core.provider.FontsContractCompat$f>>> r1 = androidx.core.provider.FontsContractCompat.f2452d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.f2467a     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.f2467a     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                androidx.core.provider.SelfDestructiveThread$ReplyCallback r1 = (androidx.core.provider.SelfDestructiveThread.ReplyCallback) r1
                r1.onReply(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                goto L_0x002f
            L_0x002e:
                throw r5
            L_0x002f:
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontsContractCompat.C0493c.onReply(androidx.core.provider.FontsContractCompat$f):void");
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$d */
    class C0494d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f2468a;

        /* renamed from: b */
        final /* synthetic */ FontRequest f2469b;

        /* renamed from: c */
        final /* synthetic */ Handler f2470c;

        /* renamed from: d */
        final /* synthetic */ FontRequestCallback f2471d;

        /* renamed from: androidx.core.provider.FontsContractCompat$d$a */
        class C0495a implements Runnable {
            C0495a() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(-1);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$b */
        class C0496b implements Runnable {
            C0496b() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(-2);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$c */
        class C0497c implements Runnable {
            C0497c() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$d */
        class C0498d implements Runnable {
            C0498d() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$e */
        class C0499e implements Runnable {
            C0499e() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(1);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$f */
        class C0500f implements Runnable {
            C0500f() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$g */
        class C0501g implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f2478a;

            C0501g(int i) {
                this.f2478a = i;
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(this.f2478a);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$h */
        class C0502h implements Runnable {
            C0502h() {
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$d$i */
        class C0503i implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Typeface f2481a;

            C0503i(Typeface typeface) {
                this.f2481a = typeface;
            }

            public void run() {
                C0494d.this.f2471d.onTypefaceRetrieved(this.f2481a);
            }
        }

        C0494d(Context context, FontRequest fontRequest, Handler handler, FontRequestCallback fontRequestCallback) {
            this.f2468a = context;
            this.f2469b = fontRequest;
            this.f2470c = handler;
            this.f2471d = fontRequestCallback;
        }

        public void run() {
            try {
                FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(this.f2468a, (CancellationSignal) null, this.f2469b);
                if (fetchFonts.getStatusCode() != 0) {
                    int statusCode = fetchFonts.getStatusCode();
                    if (statusCode == 1) {
                        this.f2470c.post(new C0496b());
                    } else if (statusCode != 2) {
                        this.f2470c.post(new C0498d());
                    } else {
                        this.f2470c.post(new C0497c());
                    }
                } else {
                    FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts == null || fonts.length == 0) {
                        this.f2470c.post(new C0499e());
                        return;
                    }
                    int length = fonts.length;
                    int i = 0;
                    while (i < length) {
                        FontInfo fontInfo = fonts[i];
                        if (fontInfo.getResultCode() != 0) {
                            int resultCode = fontInfo.getResultCode();
                            if (resultCode < 0) {
                                this.f2470c.post(new C0500f());
                                return;
                            } else {
                                this.f2470c.post(new C0501g(resultCode));
                                return;
                            }
                        } else {
                            i++;
                        }
                    }
                    Typeface buildTypeface = FontsContractCompat.buildTypeface(this.f2468a, (CancellationSignal) null, fonts);
                    if (buildTypeface == null) {
                        this.f2470c.post(new C0502h());
                    } else {
                        this.f2470c.post(new C0503i(buildTypeface));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.f2470c.post(new C0495a());
            }
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$e */
    class C0504e implements Comparator<byte[]> {
        C0504e() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(byte[] r5, byte[] r6) {
            /*
                r4 = this;
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x0008
                int r5 = r5.length
                int r6 = r6.length
            L_0x0006:
                int r5 = r5 - r6
                return r5
            L_0x0008:
                r0 = 0
                r1 = 0
            L_0x000a:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001b
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x0018
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x0006
            L_0x0018:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontsContractCompat.C0504e.compare(byte[], byte[]):int");
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$f */
    private static final class C0505f {

        /* renamed from: a */
        final Typeface f2483a;

        /* renamed from: b */
        final int f2484b;

        C0505f(@Nullable Typeface typeface, int i) {
            this.f2483a = typeface;
            this.f2484b = i;
        }
    }

    private FontsContractCompat() {
    }

    /* renamed from: a */
    private static List<byte[]> m1632a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    /* renamed from: b */
    private static boolean m1633b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    /* renamed from: c */
    private static List<List<byte[]>> m1634c(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014b  */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.NonNull
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.core.provider.FontsContractCompat.FontInfo[] m1635d(android.content.Context r23, androidx.core.provider.FontRequest r24, java.lang.String r25, android.os.CancellationSignal r26) {
        /*
            r0 = r25
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r2 = r2.build()
            android.net.Uri$Builder r4 = new android.net.Uri$Builder
            r4.<init>()
            android.net.Uri$Builder r3 = r4.scheme(r3)
            android.net.Uri$Builder r0 = r3.authority(r0)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r0 = r0.build()
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0147 }
            r5 = 16
            java.lang.String r9 = "font_variation_settings"
            r11 = 2
            r12 = 7
            java.lang.String r13 = "result_code"
            java.lang.String r14 = "font_italic"
            java.lang.String r15 = "font_weight"
            java.lang.String r3 = "font_ttc_index"
            java.lang.String r6 = "file_id"
            java.lang.String r7 = "_id"
            r8 = 1
            r10 = 0
            if (r4 <= r5) goto L_0x0083
            android.content.ContentResolver r4 = r23.getContentResolver()     // Catch:{ all -> 0x0147 }
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x0147 }
            r12[r10] = r7     // Catch:{ all -> 0x0147 }
            r12[r8] = r6     // Catch:{ all -> 0x0147 }
            r12[r11] = r3     // Catch:{ all -> 0x0147 }
            r5 = 3
            r12[r5] = r9     // Catch:{ all -> 0x0147 }
            r5 = 4
            r12[r5] = r15     // Catch:{ all -> 0x0147 }
            r5 = 5
            r12[r5] = r14     // Catch:{ all -> 0x0147 }
            r5 = 6
            r12[r5] = r13     // Catch:{ all -> 0x0147 }
            java.lang.String r9 = "query = ?"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ all -> 0x0147 }
            java.lang.String r5 = r24.getQuery()     // Catch:{ all -> 0x0147 }
            r11[r10] = r5     // Catch:{ all -> 0x0147 }
            r16 = 0
            r5 = r2
            r20 = r1
            r1 = r6
            r6 = r12
            r12 = r7
            r7 = r9
            r9 = 1
            r8 = r11
            r11 = 1
            r9 = r16
            r11 = 0
            r10 = r26
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0147 }
            r10 = r12
            r11 = 1
            goto L_0x00b5
        L_0x0083:
            r20 = r1
            r1 = r6
            r10 = r7
            r4 = 2
            r11 = 0
            android.content.ContentResolver r5 = r23.getContentResolver()     // Catch:{ all -> 0x0147 }
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ all -> 0x0147 }
            r6[r11] = r10     // Catch:{ all -> 0x0147 }
            r6[r8] = r1     // Catch:{ all -> 0x0147 }
            r6[r4] = r3     // Catch:{ all -> 0x0147 }
            r4 = 3
            r6[r4] = r9     // Catch:{ all -> 0x0147 }
            r4 = 4
            r6[r4] = r15     // Catch:{ all -> 0x0147 }
            r4 = 5
            r6[r4] = r14     // Catch:{ all -> 0x0147 }
            r4 = 6
            r6[r4] = r13     // Catch:{ all -> 0x0147 }
            java.lang.String r7 = "query = ?"
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0147 }
            java.lang.String r4 = r24.getQuery()     // Catch:{ all -> 0x0147 }
            r9[r11] = r4     // Catch:{ all -> 0x0147 }
            r12 = 0
            r4 = r5
            r5 = r2
            r11 = 1
            r8 = r9
            r9 = r12
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0147 }
        L_0x00b5:
            if (r4 == 0) goto L_0x0136
            int r5 = r4.getCount()     // Catch:{ all -> 0x0133 }
            if (r5 <= 0) goto L_0x0136
            int r5 = r4.getColumnIndex(r13)     // Catch:{ all -> 0x0133 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0133 }
            r6.<init>()     // Catch:{ all -> 0x0133 }
            int r7 = r4.getColumnIndex(r10)     // Catch:{ all -> 0x0133 }
            int r1 = r4.getColumnIndex(r1)     // Catch:{ all -> 0x0133 }
            int r3 = r4.getColumnIndex(r3)     // Catch:{ all -> 0x0133 }
            int r8 = r4.getColumnIndex(r15)     // Catch:{ all -> 0x0133 }
            int r9 = r4.getColumnIndex(r14)     // Catch:{ all -> 0x0133 }
        L_0x00da:
            boolean r10 = r4.moveToNext()     // Catch:{ all -> 0x0133 }
            if (r10 == 0) goto L_0x0131
            r10 = -1
            if (r5 == r10) goto L_0x00ea
            int r12 = r4.getInt(r5)     // Catch:{ all -> 0x0133 }
            r22 = r12
            goto L_0x00ec
        L_0x00ea:
            r22 = 0
        L_0x00ec:
            if (r3 == r10) goto L_0x00f5
            int r12 = r4.getInt(r3)     // Catch:{ all -> 0x0133 }
            r19 = r12
            goto L_0x00f7
        L_0x00f5:
            r19 = 0
        L_0x00f7:
            if (r1 != r10) goto L_0x0102
            long r12 = r4.getLong(r7)     // Catch:{ all -> 0x0133 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r2, r12)     // Catch:{ all -> 0x0133 }
            goto L_0x010a
        L_0x0102:
            long r12 = r4.getLong(r1)     // Catch:{ all -> 0x0133 }
            android.net.Uri r12 = android.content.ContentUris.withAppendedId(r0, r12)     // Catch:{ all -> 0x0133 }
        L_0x010a:
            r18 = r12
            if (r8 == r10) goto L_0x0115
            int r12 = r4.getInt(r8)     // Catch:{ all -> 0x0133 }
            r20 = r12
            goto L_0x0119
        L_0x0115:
            r12 = 400(0x190, float:5.6E-43)
            r20 = 400(0x190, float:5.6E-43)
        L_0x0119:
            if (r9 == r10) goto L_0x0124
            int r10 = r4.getInt(r9)     // Catch:{ all -> 0x0133 }
            if (r10 != r11) goto L_0x0124
            r21 = 1
            goto L_0x0126
        L_0x0124:
            r21 = 0
        L_0x0126:
            androidx.core.provider.FontsContractCompat$FontInfo r10 = new androidx.core.provider.FontsContractCompat$FontInfo     // Catch:{ all -> 0x0133 }
            r17 = r10
            r17.<init>(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0133 }
            r6.add(r10)     // Catch:{ all -> 0x0133 }
            goto L_0x00da
        L_0x0131:
            r1 = r6
            goto L_0x0138
        L_0x0133:
            r0 = move-exception
            r3 = r4
            goto L_0x0149
        L_0x0136:
            r1 = r20
        L_0x0138:
            if (r4 == 0) goto L_0x013d
            r4.close()
        L_0x013d:
            r0 = 0
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = new androidx.core.provider.FontsContractCompat.FontInfo[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = (androidx.core.provider.FontsContractCompat.FontInfo[]) r0
            return r0
        L_0x0147:
            r0 = move-exception
            r3 = 0
        L_0x0149:
            if (r3 == 0) goto L_0x014e
            r3.close()
        L_0x014e:
            goto L_0x0150
        L_0x014f:
            throw r0
        L_0x0150:
            goto L_0x014f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontsContractCompat.m1635d(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }

    @NonNull
    /* renamed from: e */
    static C0505f m1636e(Context context, FontRequest fontRequest, int i) {
        try {
            FontFamilyResult fetchFonts = fetchFonts(context, (CancellationSignal) null, fontRequest);
            int i2 = -3;
            if (fetchFonts.getStatusCode() == 0) {
                Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, (CancellationSignal) null, fetchFonts.getFonts(), i);
                if (createFromFontInfo != null) {
                    i2 = 0;
                }
                return new C0505f(createFromFontInfo, i2);
            }
            if (fetchFonts.getStatusCode() == 1) {
                i2 = -2;
            }
            return new C0505f((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0505f((Typeface) null, -1);
        }
    }

    /* renamed from: f */
    private static void m1637f(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        handler.post(new C0494d(context, fontRequest, new Handler(), fontRequestCallback));
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return new FontFamilyResult(1, (FontInfo[]) null);
        }
        return new FontFamilyResult(0, m1635d(context, fontRequest, provider.authority, cancellationSignal));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        f2450b.postAndReply(r1, new androidx.core.provider.FontsContractCompat.C0493c(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        return null;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface getFontSync(android.content.Context r2, androidx.core.provider.FontRequest r3, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r4, @androidx.annotation.Nullable android.os.Handler r5, boolean r6, int r7, int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.getIdentifier()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r1 = f2449a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.onFontRetrieved(r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0043
            r1 = -1
            if (r7 != r1) goto L_0x0043
            androidx.core.provider.FontsContractCompat$f r2 = m1636e(r2, r3, r8)
            if (r4 == 0) goto L_0x0040
            int r3 = r2.f2484b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f2483a
            r4.callbackSuccessAsync(r3, r5)
            goto L_0x0040
        L_0x003d:
            r4.callbackFailAsync(r3, r5)
        L_0x0040:
            android.graphics.Typeface r2 = r2.f2483a
            return r2
        L_0x0043:
            androidx.core.provider.FontsContractCompat$a r1 = new androidx.core.provider.FontsContractCompat$a
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0056
            androidx.core.provider.SelfDestructiveThread r3 = f2450b     // Catch:{ InterruptedException -> 0x0055 }
            java.lang.Object r3 = r3.postAndWait(r1, r7)     // Catch:{ InterruptedException -> 0x0055 }
            androidx.core.provider.FontsContractCompat$f r3 = (androidx.core.provider.FontsContractCompat.C0505f) r3     // Catch:{ InterruptedException -> 0x0055 }
            android.graphics.Typeface r2 = r3.f2483a     // Catch:{ InterruptedException -> 0x0055 }
        L_0x0055:
            return r2
        L_0x0056:
            if (r4 != 0) goto L_0x005a
            r3 = r2
            goto L_0x005f
        L_0x005a:
            androidx.core.provider.FontsContractCompat$b r3 = new androidx.core.provider.FontsContractCompat$b
            r3.<init>(r4, r5)
        L_0x005f:
            java.lang.Object r4 = f2451c
            monitor-enter(r4)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.provider.SelfDestructiveThread$ReplyCallback<androidx.core.provider.FontsContractCompat$f>>> r5 = f2452d     // Catch:{ all -> 0x008c }
            java.lang.Object r6 = r5.get(r0)     // Catch:{ all -> 0x008c }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x008c }
            if (r6 == 0) goto L_0x0073
            if (r3 == 0) goto L_0x0071
            r6.add(r3)     // Catch:{ all -> 0x008c }
        L_0x0071:
            monitor-exit(r4)     // Catch:{ all -> 0x008c }
            return r2
        L_0x0073:
            if (r3 == 0) goto L_0x0080
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r6.<init>()     // Catch:{ all -> 0x008c }
            r6.add(r3)     // Catch:{ all -> 0x008c }
            r5.put(r0, r6)     // Catch:{ all -> 0x008c }
        L_0x0080:
            monitor-exit(r4)     // Catch:{ all -> 0x008c }
            androidx.core.provider.SelfDestructiveThread r3 = f2450b
            androidx.core.provider.FontsContractCompat$c r4 = new androidx.core.provider.FontsContractCompat$c
            r4.<init>(r0)
            r3.postAndReply(r1, r4)
            return r2
        L_0x008c:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontsContractCompat.getFontSync(android.content.Context, androidx.core.provider.FontRequest, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    @VisibleForTesting
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            List<byte[]> a = m1632a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a, f2453e);
            List<List<byte[]>> c = m1634c(fontRequest, resources);
            for (int i = 0; i < c.size(); i++) {
                ArrayList arrayList = new ArrayList(c.get(i));
                Collections.sort(arrayList, f2453e);
                if (m1633b(a, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                Uri uri = fontInfo.getUri();
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static void requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        m1637f(context.getApplicationContext(), fontRequest, fontRequestCallback, handler);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void resetCache() {
        f2449a.evictAll();
    }
}
