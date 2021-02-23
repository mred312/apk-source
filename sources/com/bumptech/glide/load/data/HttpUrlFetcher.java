package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting

    /* renamed from: g */
    static final C1174b f5628g = new C1173a();

    /* renamed from: a */
    private final GlideUrl f5629a;

    /* renamed from: b */
    private final int f5630b;

    /* renamed from: c */
    private final C1174b f5631c;

    /* renamed from: d */
    private HttpURLConnection f5632d;

    /* renamed from: e */
    private InputStream f5633e;

    /* renamed from: f */
    private volatile boolean f5634f;

    /* renamed from: com.bumptech.glide.load.data.HttpUrlFetcher$a */
    private static class C1173a implements C1174b {
        C1173a() {
        }

        /* renamed from: a */
        public HttpURLConnection mo9425a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* renamed from: com.bumptech.glide.load.data.HttpUrlFetcher$b */
    interface C1174b {
        /* renamed from: a */
        HttpURLConnection mo9425a(URL url);
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, f5628g);
    }

    /* renamed from: a */
    private InputStream m4192a(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f5633e = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f5633e = httpURLConnection.getInputStream();
        }
        return this.f5633e;
    }

    /* renamed from: b */
    private static boolean m4193b(int i) {
        return i / 100 == 2;
    }

    /* renamed from: c */
    private static boolean m4194c(int i) {
        return i / 100 == 3;
    }

    /* renamed from: d */
    private InputStream m4195d(URL url, int i, URL url2, Map<String, String> map) {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f5632d = this.f5631c.mo9425a(url);
            for (Map.Entry next : map.entrySet()) {
                this.f5632d.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f5632d.setConnectTimeout(this.f5630b);
            this.f5632d.setReadTimeout(this.f5630b);
            this.f5632d.setUseCaches(false);
            this.f5632d.setDoInput(true);
            this.f5632d.setInstanceFollowRedirects(false);
            this.f5632d.connect();
            this.f5633e = this.f5632d.getInputStream();
            if (this.f5634f) {
                return null;
            }
            int responseCode = this.f5632d.getResponseCode();
            if (m4193b(responseCode)) {
                return m4192a(this.f5632d);
            }
            if (m4194c(responseCode)) {
                String headerField = this.f5632d.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    cleanup();
                    return m4195d(url3, i + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f5632d.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    public void cancel() {
        this.f5634f = true;
    }

    public void cleanup() {
        InputStream inputStream = this.f5633e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f5632d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f5632d = null;
    }

    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long logTime = LogTime.getLogTime();
        try {
            dataCallback.onDataReady(m4195d(this.f5629a.toURL(), 0, (URL) null, this.f5629a.getHeaders()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.getElapsedMillis(logTime));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e);
            }
            dataCallback.onLoadFailed(e);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl, int i, C1174b bVar) {
        this.f5629a = glideUrl;
        this.f5630b = i;
        this.f5631c = bVar;
    }
}
