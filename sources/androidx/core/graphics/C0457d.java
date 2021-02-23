package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.core.graphics.d */
/* compiled from: TypefaceCompatBaseImpl */
class C0457d {

    /* renamed from: a */
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> f2337a = new ConcurrentHashMap<>();

    /* renamed from: androidx.core.graphics.d$a */
    /* compiled from: TypefaceCompatBaseImpl */
    class C0458a implements C0460c<FontsContractCompat.FontInfo> {
        C0458a(C0457d dVar) {
        }

        /* renamed from: c */
        public int mo4183a(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.getWeight();
        }

        /* renamed from: d */
        public boolean mo4184b(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.isItalic();
        }
    }

    /* renamed from: androidx.core.graphics.d$b */
    /* compiled from: TypefaceCompatBaseImpl */
    class C0459b implements C0460c<FontResourcesParserCompat.FontFileResourceEntry> {
        C0459b(C0457d dVar) {
        }

        /* renamed from: c */
        public int mo4183a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.getWeight();
        }

        /* renamed from: d */
        public boolean mo4184b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.isItalic();
        }
    }

    /* renamed from: androidx.core.graphics.d$c */
    /* compiled from: TypefaceCompatBaseImpl */
    private interface C0460c<T> {
        /* renamed from: a */
        int mo4183a(T t);

        /* renamed from: b */
        boolean mo4184b(T t);
    }

    C0457d() {
    }

    /* renamed from: a */
    private void m1558a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long e = m1561e(typeface);
        if (e != 0) {
            this.f2337a.put(Long.valueOf(e), fontFamilyFilesResourceEntry);
        }
    }

    /* renamed from: b */
    private FontResourcesParserCompat.FontFileResourceEntry m1559b(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontResourcesParserCompat.FontFileResourceEntry) m1560c(fontFamilyFilesResourceEntry.getEntries(), i, new C0459b(this));
    }

    /* renamed from: c */
    private static <T> T m1560c(T[] tArr, int i, C0460c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : HardwareConfigState.DEFAULT_MAXIMUM_FDS_FOR_HARDWARE_CONFIGS;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.mo4183a(t2) - i2) * 2) + (cVar.mo4184b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* renamed from: e */
    private static long m1561e(@Nullable Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0;
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        }
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry b = m1559b(fontFamilyFilesResourceEntry, i);
        if (b == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, b.getResourceId(), b.getFileName(), i);
        m1558a(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
            try {
                Typeface createFromInputStream = createFromInputStream(context, inputStream);
                TypefaceCompatUtil.closeQuietly(inputStream);
                return createFromInputStream;
            } catch (IOException unused) {
                TypefaceCompatUtil.closeQuietly(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.closeQuietly(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            TypefaceCompatUtil.closeQuietly(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            TypefaceCompatUtil.closeQuietly(inputStream2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: d */
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry mo4182d(Typeface typeface) {
        long e = m1561e(typeface);
        if (e == 0) {
            return null;
        }
        return this.f2337a.get(Long.valueOf(e));
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (FontsContractCompat.FontInfo) m1560c(fontInfoArr, i, new C0458a(this));
    }
}
