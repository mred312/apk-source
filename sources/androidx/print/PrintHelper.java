package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

public final class PrintHelper {
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: g */
    static final boolean f3803g;

    /* renamed from: h */
    static final boolean f3804h;

    /* renamed from: a */
    final Context f3805a;

    /* renamed from: b */
    BitmapFactory.Options f3806b = null;

    /* renamed from: c */
    final Object f3807c = new Object();

    /* renamed from: d */
    int f3808d = 2;

    /* renamed from: e */
    int f3809e = 2;

    /* renamed from: f */
    int f3810f = 1;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* renamed from: androidx.print.PrintHelper$a */
    class C0862a extends AsyncTask<Void, Void, Throwable> {

        /* renamed from: a */
        final /* synthetic */ CancellationSignal f3811a;

        /* renamed from: b */
        final /* synthetic */ PrintAttributes f3812b;

        /* renamed from: c */
        final /* synthetic */ Bitmap f3813c;

        /* renamed from: d */
        final /* synthetic */ PrintAttributes f3814d;

        /* renamed from: e */
        final /* synthetic */ int f3815e;

        /* renamed from: f */
        final /* synthetic */ ParcelFileDescriptor f3816f;

        /* renamed from: g */
        final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f3817g;

        C0862a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.f3811a = cancellationSignal;
            this.f3812b = printAttributes;
            this.f3813c = bitmap;
            this.f3814d = printAttributes2;
            this.f3815e = i;
            this.f3816f = parcelFileDescriptor;
            this.f3817g = writeResultCallback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00d2 */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3 A[Catch:{ all -> 0x00c7, all -> 0x00da }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3 A[Catch:{ all -> 0x00c7, all -> 0x00da }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00d6 A[Catch:{ all -> 0x00c7, all -> 0x00da }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Throwable doInBackground(java.lang.Void... r9) {
            /*
                r8 = this;
                android.os.CancellationSignal r9 = r8.f3811a     // Catch:{ all -> 0x00da }
                boolean r9 = r9.isCanceled()     // Catch:{ all -> 0x00da }
                r0 = 0
                if (r9 == 0) goto L_0x000a
                return r0
            L_0x000a:
                android.print.pdf.PrintedPdfDocument r9 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00da }
                androidx.print.PrintHelper r1 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00da }
                android.content.Context r1 = r1.f3805a     // Catch:{ all -> 0x00da }
                android.print.PrintAttributes r2 = r8.f3812b     // Catch:{ all -> 0x00da }
                r9.<init>(r1, r2)     // Catch:{ all -> 0x00da }
                android.graphics.Bitmap r1 = r8.f3813c     // Catch:{ all -> 0x00da }
                android.print.PrintAttributes r2 = r8.f3812b     // Catch:{ all -> 0x00da }
                int r2 = r2.getColorMode()     // Catch:{ all -> 0x00da }
                android.graphics.Bitmap r1 = androidx.print.PrintHelper.m2834a(r1, r2)     // Catch:{ all -> 0x00da }
                android.os.CancellationSignal r2 = r8.f3811a     // Catch:{ all -> 0x00da }
                boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00da }
                if (r2 == 0) goto L_0x002a
                return r0
            L_0x002a:
                r2 = 1
                android.graphics.pdf.PdfDocument$Page r3 = r9.startPage(r2)     // Catch:{ all -> 0x00c7 }
                boolean r4 = androidx.print.PrintHelper.f3804h     // Catch:{ all -> 0x00c7 }
                if (r4 == 0) goto L_0x0041
                android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ all -> 0x00c7 }
                android.graphics.pdf.PdfDocument$PageInfo r5 = r3.getInfo()     // Catch:{ all -> 0x00c7 }
                android.graphics.Rect r5 = r5.getContentRect()     // Catch:{ all -> 0x00c7 }
                r2.<init>(r5)     // Catch:{ all -> 0x00c7 }
                goto L_0x0064
            L_0x0041:
                android.print.pdf.PrintedPdfDocument r5 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00c7 }
                androidx.print.PrintHelper r6 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00c7 }
                android.content.Context r6 = r6.f3805a     // Catch:{ all -> 0x00c7 }
                android.print.PrintAttributes r7 = r8.f3814d     // Catch:{ all -> 0x00c7 }
                r5.<init>(r6, r7)     // Catch:{ all -> 0x00c7 }
                android.graphics.pdf.PdfDocument$Page r2 = r5.startPage(r2)     // Catch:{ all -> 0x00c7 }
                android.graphics.RectF r6 = new android.graphics.RectF     // Catch:{ all -> 0x00c7 }
                android.graphics.pdf.PdfDocument$PageInfo r7 = r2.getInfo()     // Catch:{ all -> 0x00c7 }
                android.graphics.Rect r7 = r7.getContentRect()     // Catch:{ all -> 0x00c7 }
                r6.<init>(r7)     // Catch:{ all -> 0x00c7 }
                r5.finishPage(r2)     // Catch:{ all -> 0x00c7 }
                r5.close()     // Catch:{ all -> 0x00c7 }
                r2 = r6
            L_0x0064:
                int r5 = r1.getWidth()     // Catch:{ all -> 0x00c7 }
                int r6 = r1.getHeight()     // Catch:{ all -> 0x00c7 }
                int r7 = r8.f3815e     // Catch:{ all -> 0x00c7 }
                android.graphics.Matrix r5 = androidx.print.PrintHelper.m2836c(r5, r6, r2, r7)     // Catch:{ all -> 0x00c7 }
                if (r4 == 0) goto L_0x0075
                goto L_0x0083
            L_0x0075:
                float r4 = r2.left     // Catch:{ all -> 0x00c7 }
                float r6 = r2.top     // Catch:{ all -> 0x00c7 }
                r5.postTranslate(r4, r6)     // Catch:{ all -> 0x00c7 }
                android.graphics.Canvas r4 = r3.getCanvas()     // Catch:{ all -> 0x00c7 }
                r4.clipRect(r2)     // Catch:{ all -> 0x00c7 }
            L_0x0083:
                android.graphics.Canvas r2 = r3.getCanvas()     // Catch:{ all -> 0x00c7 }
                r2.drawBitmap(r1, r5, r0)     // Catch:{ all -> 0x00c7 }
                r9.finishPage(r3)     // Catch:{ all -> 0x00c7 }
                android.os.CancellationSignal r2 = r8.f3811a     // Catch:{ all -> 0x00c7 }
                boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00c7 }
                if (r2 == 0) goto L_0x00a7
                r9.close()     // Catch:{ all -> 0x00da }
                android.os.ParcelFileDescriptor r9 = r8.f3816f     // Catch:{ all -> 0x00da }
                if (r9 == 0) goto L_0x009f
                r9.close()     // Catch:{ IOException -> 0x009f }
            L_0x009f:
                android.graphics.Bitmap r9 = r8.f3813c     // Catch:{ all -> 0x00da }
                if (r1 == r9) goto L_0x00a6
                r1.recycle()     // Catch:{ all -> 0x00da }
            L_0x00a6:
                return r0
            L_0x00a7:
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00c7 }
                android.os.ParcelFileDescriptor r3 = r8.f3816f     // Catch:{ all -> 0x00c7 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x00c7 }
                r2.<init>(r3)     // Catch:{ all -> 0x00c7 }
                r9.writeTo(r2)     // Catch:{ all -> 0x00c7 }
                r9.close()     // Catch:{ all -> 0x00da }
                android.os.ParcelFileDescriptor r9 = r8.f3816f     // Catch:{ all -> 0x00da }
                if (r9 == 0) goto L_0x00bf
                r9.close()     // Catch:{ IOException -> 0x00bf }
            L_0x00bf:
                android.graphics.Bitmap r9 = r8.f3813c     // Catch:{ all -> 0x00da }
                if (r1 == r9) goto L_0x00c6
                r1.recycle()     // Catch:{ all -> 0x00da }
            L_0x00c6:
                return r0
            L_0x00c7:
                r0 = move-exception
                r9.close()     // Catch:{ all -> 0x00da }
                android.os.ParcelFileDescriptor r9 = r8.f3816f     // Catch:{ all -> 0x00da }
                if (r9 == 0) goto L_0x00d2
                r9.close()     // Catch:{ IOException -> 0x00d2 }
            L_0x00d2:
                android.graphics.Bitmap r9 = r8.f3813c     // Catch:{ all -> 0x00da }
                if (r1 == r9) goto L_0x00d9
                r1.recycle()     // Catch:{ all -> 0x00da }
            L_0x00d9:
                throw r0     // Catch:{ all -> 0x00da }
            L_0x00da:
                r9 = move-exception
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.C0862a.doInBackground(java.lang.Void[]):java.lang.Throwable");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Throwable th) {
            if (this.f3811a.isCanceled()) {
                this.f3817g.onWriteCancelled();
            } else if (th == null) {
                this.f3817g.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } else {
                Log.e("PrintHelper", "Error writing printed content", th);
                this.f3817g.onWriteFailed((CharSequence) null);
            }
        }
    }

    @RequiresApi(19)
    /* renamed from: androidx.print.PrintHelper$b */
    private class C0863b extends PrintDocumentAdapter {

        /* renamed from: a */
        private final String f3819a;

        /* renamed from: b */
        private final int f3820b;

        /* renamed from: c */
        private final Bitmap f3821c;

        /* renamed from: d */
        private final OnPrintFinishCallback f3822d;

        /* renamed from: e */
        private PrintAttributes f3823e;

        C0863b(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.f3819a = str;
            this.f3820b = i;
            this.f3821c = bitmap;
            this.f3822d = onPrintFinishCallback;
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.f3822d;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.f3823e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f3819a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.mo6588g(this.f3823e, this.f3820b, this.f3821c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @RequiresApi(19)
    /* renamed from: androidx.print.PrintHelper$c */
    private class C0864c extends PrintDocumentAdapter {

        /* renamed from: a */
        final String f3825a;

        /* renamed from: b */
        final Uri f3826b;

        /* renamed from: c */
        final OnPrintFinishCallback f3827c;

        /* renamed from: d */
        final int f3828d;

        /* renamed from: e */
        PrintAttributes f3829e;

        /* renamed from: f */
        AsyncTask<Uri, Boolean, Bitmap> f3830f;

        /* renamed from: g */
        Bitmap f3831g = null;

        /* renamed from: androidx.print.PrintHelper$c$a */
        class C0865a extends AsyncTask<Uri, Boolean, Bitmap> {

            /* renamed from: a */
            final /* synthetic */ CancellationSignal f3833a;

            /* renamed from: b */
            final /* synthetic */ PrintAttributes f3834b;

            /* renamed from: c */
            final /* synthetic */ PrintAttributes f3835c;

            /* renamed from: d */
            final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f3836d;

            /* renamed from: androidx.print.PrintHelper$c$a$a */
            class C0866a implements CancellationSignal.OnCancelListener {
                C0866a() {
                }

                public void onCancel() {
                    C0864c.this.mo6607a();
                    C0865a.this.cancel(false);
                }
            }

            C0865a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.f3833a = cancellationSignal;
                this.f3834b = printAttributes;
                this.f3835c = printAttributes2;
                this.f3836d = layoutResultCallback;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Bitmap doInBackground(Uri... uriArr) {
                try {
                    C0864c cVar = C0864c.this;
                    return PrintHelper.this.mo6587f(cVar.f3826b);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void onCancelled(Bitmap bitmap) {
                this.f3836d.onLayoutCancelled();
                C0864c.this.f3830f = null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public void onPostExecute(Bitmap bitmap) {
                PrintAttributes.MediaSize mediaSize;
                super.onPostExecute(bitmap);
                if (bitmap != null && (!PrintHelper.f3803g || PrintHelper.this.f3810f == 0)) {
                    synchronized (this) {
                        mediaSize = C0864c.this.f3829e.getMediaSize();
                    }
                    if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelper.m2837d(bitmap))) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    }
                }
                C0864c.this.f3831g = bitmap;
                if (bitmap != null) {
                    this.f3836d.onLayoutFinished(new PrintDocumentInfo.Builder(C0864c.this.f3825a).setContentType(1).setPageCount(1).build(), true ^ this.f3834b.equals(this.f3835c));
                } else {
                    this.f3836d.onLayoutFailed((CharSequence) null);
                }
                C0864c.this.f3830f = null;
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                this.f3833a.setOnCancelListener(new C0866a());
            }
        }

        C0864c(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.f3825a = str;
            this.f3826b = uri;
            this.f3827c = onPrintFinishCallback;
            this.f3828d = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6607a() {
            synchronized (PrintHelper.this.f3807c) {
                BitmapFactory.Options options = PrintHelper.this.f3806b;
                if (options != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    PrintHelper.this.f3806b = null;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            mo6607a();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f3830f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.f3827c;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.f3831g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f3831g = null;
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.f3829e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f3831g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f3825a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.f3830f = new C0865a(cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.mo6588g(this.f3829e, this.f3828d, this.f3831g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        f3803g = i < 20 || i > 23;
        if (i != 23) {
            z = true;
        }
        f3804h = z;
    }

    public PrintHelper(@NonNull Context context) {
        this.f3805a = context;
    }

    /* renamed from: a */
    static Bitmap m2834a(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    @RequiresApi(19)
    /* renamed from: b */
    private static PrintAttributes.Builder m2835b(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    /* renamed from: c */
    static Matrix m2836c(int i, int i2, RectF rectF, int i3) {
        float f;
        Matrix matrix = new Matrix();
        float f2 = (float) i;
        float width = rectF.width() / f2;
        if (i3 == 2) {
            f = Math.max(width, rectF.height() / ((float) i2));
        } else {
            f = Math.min(width, rectF.height() / ((float) i2));
        }
        matrix.postScale(f, f);
        matrix.postTranslate((rectF.width() - (f2 * f)) / 2.0f, (rectF.height() - (((float) i2) * f)) / 2.0f);
        return matrix;
    }

    /* renamed from: d */
    static boolean m2837d(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028 A[SYNTHETIC, Splitter:B:19:0x0028] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m2838e(android.net.Uri r5, android.graphics.BitmapFactory.Options r6) {
        /*
            r4 = this;
            java.lang.String r0 = "close fail "
            java.lang.String r1 = "PrintHelper"
            if (r5 == 0) goto L_0x0031
            android.content.Context r2 = r4.f3805a
            if (r2 == 0) goto L_0x0031
            r3 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0025 }
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch:{ all -> 0x0025 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ all -> 0x0022 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0021:
            return r6
        L_0x0022:
            r6 = move-exception
            r3 = r5
            goto L_0x0026
        L_0x0025:
            r6 = move-exception
        L_0x0026:
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0030:
            throw r6
        L_0x0031:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "bad argument to loadBitmap"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.m2838e(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Bitmap mo6587f(Uri uri) {
        BitmapFactory.Options options;
        if (uri == null || this.f3805a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        m2838e(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int max = Math.max(i, i2);
            int i3 = 1;
            while (max > 3500) {
                max >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                synchronized (this.f3807c) {
                    options = new BitmapFactory.Options();
                    this.f3806b = options;
                    options.inMutable = true;
                    options.inSampleSize = i3;
                }
                try {
                    Bitmap e = m2838e(uri, options);
                    synchronized (this.f3807c) {
                        this.f3806b = null;
                    }
                    return e;
                } catch (Throwable th) {
                    synchronized (this.f3807c) {
                        this.f3806b = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    /* renamed from: g */
    public void mo6588g(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintAttributes printAttributes2;
        if (f3804h) {
            printAttributes2 = printAttributes;
        } else {
            printAttributes2 = m2835b(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        new C0862a(cancellationSignal, printAttributes2, bitmap, printAttributes, i, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }

    public int getColorMode() {
        return this.f3809e;
    }

    public int getOrientation() {
        if (Build.VERSION.SDK_INT < 19 || this.f3810f != 0) {
            return this.f3810f;
        }
        return 1;
    }

    public int getScaleMode() {
        return this.f3808d;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void setColorMode(int i) {
        this.f3809e = i;
    }

    public void setOrientation(int i) {
        this.f3810f = i;
    }

    public void setScaleMode(int i) {
        this.f3808d = i;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (Build.VERSION.SDK_INT >= 19 && bitmap != null) {
            PrintManager printManager = (PrintManager) this.f3805a.getSystemService("print");
            if (m2837d(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new C0863b(str, this.f3808d, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.f3809e).build());
        }
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            C0864c cVar = new C0864c(str, uri, onPrintFinishCallback, this.f3808d);
            PrintManager printManager = (PrintManager) this.f3805a.getSystemService("print");
            PrintAttributes.Builder builder = new PrintAttributes.Builder();
            builder.setColorMode(this.f3809e);
            int i = this.f3810f;
            if (i == 1 || i == 0) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
            } else if (i == 2) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
            }
            printManager.print(str, cVar, builder.build());
        }
    }
}
