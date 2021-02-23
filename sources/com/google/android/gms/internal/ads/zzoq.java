package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzoq implements zzot {

    /* renamed from: o */
    private static final Pattern f16790o = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: p */
    private static final AtomicReference<byte[]> f16791p = new AtomicReference<>();

    /* renamed from: a */
    private final boolean f16792a;

    /* renamed from: b */
    private final int f16793b;

    /* renamed from: c */
    private final int f16794c;

    /* renamed from: d */
    private final String f16795d;

    /* renamed from: e */
    private final zzox f16796e = new zzox();

    /* renamed from: f */
    private final zzpd<? super zzoq> f16797f;

    /* renamed from: g */
    private zzoo f16798g;

    /* renamed from: h */
    private HttpURLConnection f16799h;

    /* renamed from: i */
    private InputStream f16800i;

    /* renamed from: j */
    private boolean f16801j;

    /* renamed from: k */
    private long f16802k;

    /* renamed from: l */
    private long f16803l;

    /* renamed from: m */
    private long f16804m;

    /* renamed from: n */
    private long f16805n;

    public zzoq(String str, zzpp<String> zzpp, zzpd<? super zzoq> zzpd, int i, int i2, boolean z, zzox zzox) {
        this.f16795d = zzpc.checkNotEmpty(str);
        this.f16797f = zzpd;
        this.f16793b = i;
        this.f16794c = i2;
        this.f16792a = true;
    }

    /* renamed from: a */
    private final HttpURLConnection m9036a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f16793b);
        httpURLConnection.setReadTimeout(this.f16794c);
        for (Map.Entry next : this.f16796e.zzit().entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.f16795d);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m9037b(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L_0x0036
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0015 }
            goto L_0x0038
        L_0x0015:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 28
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r4.append(r1)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r3, r1)
        L_0x0036:
            r4 = -1
        L_0x0038:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00cb
            java.util.regex.Pattern r1 = f16790o
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto L_0x00cb
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch:{ NumberFormatException -> 0x00aa }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00aa }
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch:{ NumberFormatException -> 0x00aa }
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x006e
            r4 = r6
            goto L_0x00cb
        L_0x006e:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00cb
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + 26
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00aa }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00aa }
            int r1 = r1 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00aa }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r1 = "Inconsistent headers ["
            r8.append(r1)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = "] ["
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r10)     // Catch:{ NumberFormatException -> 0x00aa }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x00aa }
            java.lang.String r0 = r8.toString()     // Catch:{ NumberFormatException -> 0x00aa }
            android.util.Log.w(r3, r0)     // Catch:{ NumberFormatException -> 0x00aa }
            long r0 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x00aa }
            r4 = r0
            goto L_0x00cb
        L_0x00aa:
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r0 = r0.length()
            int r0 = r0 + 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            android.util.Log.e(r3, r10)
        L_0x00cb:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.m9037b(java.net.HttpURLConnection):long");
    }

    /* renamed from: c */
    private final void m9038c() {
        HttpURLConnection httpURLConnection = this.f16799h;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f16799h = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|(1:6)(1:7)|8|9|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        if (r3 > android.support.p000v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x0034;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.f16800i     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0075
            java.net.HttpURLConnection r2 = r9.f16799h     // Catch:{ all -> 0x0088 }
            long r3 = r9.f16803l     // Catch:{ all -> 0x0088 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.f16805n     // Catch:{ all -> 0x0088 }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzpt.SDK_INT     // Catch:{ all -> 0x0088 }
            r8 = 19
            if (r7 == r8) goto L_0x001e
            r8 = 20
            if (r7 != r8) goto L_0x0065
        L_0x001e:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0065 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x002e
            int r3 = r2.read()     // Catch:{ Exception -> 0x0065 }
            r4 = -1
            if (r3 != r4) goto L_0x0034
            goto L_0x0065
        L_0x002e:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0065
        L_0x0034:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0065 }
            if (r4 != 0) goto L_0x004c
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x0065
        L_0x004c:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0065 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0065 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0065 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0065 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0065 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0065 }
        L_0x0065:
            java.io.InputStream r2 = r9.f16800i     // Catch:{ IOException -> 0x006b }
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0075
        L_0x006b:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzov r3 = new com.google.android.gms.internal.ads.zzov     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzoo r4 = r9.f16798g     // Catch:{ all -> 0x0088 }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzoo) r4, (int) r5)     // Catch:{ all -> 0x0088 }
            throw r3     // Catch:{ all -> 0x0088 }
        L_0x0075:
            r9.f16800i = r0
            r9.m9038c()
            boolean r0 = r9.f16801j
            if (r0 == 0) goto L_0x0087
            r9.f16801j = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.f16797f
            if (r0 == 0) goto L_0x0087
            r0.zze(r9)
        L_0x0087:
            return
        L_0x0088:
            r2 = move-exception
            r9.f16800i = r0
            r9.m9038c()
            boolean r0 = r9.f16801j
            if (r0 == 0) goto L_0x009b
            r9.f16801j = r1
            com.google.android.gms.internal.ads.zzpd<? super com.google.android.gms.internal.ads.zzoq> r0 = r9.f16797f
            if (r0 == 0) goto L_0x009b
            r0.zze(r9)
        L_0x009b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoq.close():void");
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f16799h;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.f16799h;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final int read(byte[] bArr, int i, int i2) {
        try {
            if (this.f16804m != this.f16802k) {
                byte[] andSet = f16791p.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.f16804m;
                    long j2 = this.f16802k;
                    if (j == j2) {
                        f16791p.set(andSet);
                        break;
                    }
                    int read = this.f16800i.read(andSet, 0, (int) Math.min(j2 - j, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.f16804m += (long) read;
                        zzpd<? super zzoq> zzpd = this.f16797f;
                        if (zzpd != null) {
                            zzpd.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.f16803l;
            if (j3 != -1) {
                long j4 = j3 - this.f16805n;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j4);
            }
            int read2 = this.f16800i.read(bArr, i, i2);
            if (read2 != -1) {
                this.f16805n += (long) read2;
                zzpd<? super zzoq> zzpd2 = this.f16797f;
                if (zzpd2 != null) {
                    zzpd2.zzc(this, read2);
                }
                return read2;
            } else if (this.f16803l == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzov(e, this.f16798g, 2);
        }
    }

    public final long zza(zzoo zzoo) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection a;
        zzoo zzoo2 = zzoo;
        this.f16798g = zzoo2;
        long j = 0;
        this.f16805n = 0;
        this.f16804m = 0;
        try {
            URL url = new URL(zzoo2.uri.toString());
            byte[] bArr = zzoo2.zzbia;
            long j2 = zzoo2.position;
            long j3 = zzoo2.zzcm;
            boolean isFlagSet = zzoo2.isFlagSet(1);
            if (!this.f16792a) {
                httpURLConnection = m9036a(url, bArr, j2, j3, isFlagSet, true);
            } else {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        URL url3 = url2;
                        int i3 = i2;
                        long j4 = j3;
                        long j5 = j2;
                        a = m9036a(url2, bArr2, j2, j3, isFlagSet, false);
                        int responseCode = a.getResponseCode();
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                            if (bArr2 == null) {
                                if (responseCode != 307) {
                                    if (responseCode != 308) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        bArr2 = null;
                        String headerField = a.getHeaderField("Location");
                        a.disconnect();
                        if (headerField != null) {
                            url2 = new URL(url3, headerField);
                            String protocol = url2.getProtocol();
                            if ("https".equals(protocol) || "http".equals(protocol)) {
                                i = i3;
                                j3 = j4;
                                j2 = j5;
                            } else {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                        } else {
                            throw new ProtocolException("Null location redirect");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
                httpURLConnection = a;
            }
            this.f16799h = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map headerFields = this.f16799h.getHeaderFields();
                    m9038c();
                    zzou zzou = new zzou(responseCode2, headerFields, zzoo2);
                    if (responseCode2 == 416) {
                        zzou.initCause(new zzop(0));
                    }
                    throw zzou;
                }
                this.f16799h.getContentType();
                if (responseCode2 == 200) {
                    long j6 = zzoo2.position;
                    if (j6 != 0) {
                        j = j6;
                    }
                }
                this.f16802k = j;
                if (!zzoo2.isFlagSet(1)) {
                    long j7 = zzoo2.zzcm;
                    long j8 = -1;
                    if (j7 != -1) {
                        this.f16803l = j7;
                    } else {
                        long b = m9037b(this.f16799h);
                        if (b != -1) {
                            j8 = b - this.f16802k;
                        }
                        this.f16803l = j8;
                    }
                } else {
                    this.f16803l = zzoo2.zzcm;
                }
                try {
                    this.f16800i = this.f16799h.getInputStream();
                    this.f16801j = true;
                    zzpd<? super zzoq> zzpd = this.f16797f;
                    if (zzpd != null) {
                        zzpd.zza(this, zzoo2);
                    }
                    return this.f16803l;
                } catch (IOException e) {
                    m9038c();
                    throw new zzov(e, zzoo2, 1);
                }
            } catch (IOException e2) {
                IOException iOException = e2;
                m9038c();
                String valueOf2 = String.valueOf(zzoo2.uri.toString());
                throw new zzov(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), iOException, zzoo2, 1);
            }
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(zzoo2.uri.toString());
            throw new zzov(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e3, zzoo2, 1);
        }
    }
}
