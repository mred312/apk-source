package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    private final Uri f5641a;

    /* renamed from: b */
    private final C1179c f5642b;

    /* renamed from: c */
    private InputStream f5643c;

    /* renamed from: com.bumptech.glide.load.data.mediastore.ThumbFetcher$a */
    static class C1175a implements C1178b {

        /* renamed from: b */
        private static final String[] f5644b = {"_data"};

        /* renamed from: a */
        private final ContentResolver f5645a;

        C1175a(ContentResolver contentResolver) {
            this.f5645a = contentResolver;
        }

        /* renamed from: a */
        public Cursor mo9429a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f5645a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5644b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    /* renamed from: com.bumptech.glide.load.data.mediastore.ThumbFetcher$b */
    static class C1176b implements C1178b {

        /* renamed from: b */
        private static final String[] f5646b = {"_data"};

        /* renamed from: a */
        private final ContentResolver f5647a;

        C1176b(ContentResolver contentResolver) {
            this.f5647a = contentResolver;
        }

        /* renamed from: a */
        public Cursor mo9429a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f5647a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f5646b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    @VisibleForTesting
    ThumbFetcher(Uri uri, C1179c cVar) {
        this.f5641a = uri;
        this.f5642b = cVar;
    }

    /* renamed from: a */
    private static ThumbFetcher m4201a(Context context, Uri uri, C1178b bVar) {
        return new ThumbFetcher(uri, new C1179c(Glide.get(context).getRegistry().getImageHeaderParsers(), bVar, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    /* renamed from: b */
    private InputStream m4202b() {
        InputStream d = this.f5642b.mo9434d(this.f5641a);
        int a = d != null ? this.f5642b.mo9433a(this.f5641a) : -1;
        return a != -1 ? new ExifOrientationStream(d, a) : d;
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return m4201a(context, uri, new C1175a(context.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return m4201a(context, uri, new C1176b(context.getContentResolver()));
    }

    public void cancel() {
    }

    public void cleanup() {
        InputStream inputStream = this.f5643c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream b = m4202b();
            this.f5643c = b;
            dataCallback.onDataReady(b);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }
}
