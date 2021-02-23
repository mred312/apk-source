package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {

    /* renamed from: m */
    private static volatile Glide f5404m;

    /* renamed from: n */
    private static volatile boolean f5405n;

    /* renamed from: a */
    private final Engine f5406a;

    /* renamed from: b */
    private final BitmapPool f5407b;

    /* renamed from: c */
    private final MemoryCache f5408c;

    /* renamed from: d */
    private final GlideContext f5409d;

    /* renamed from: e */
    private final Registry f5410e;

    /* renamed from: f */
    private final ArrayPool f5411f;

    /* renamed from: g */
    private final RequestManagerRetriever f5412g;

    /* renamed from: h */
    private final ConnectivityMonitorFactory f5413h;

    /* renamed from: i */
    private final List<RequestManager> f5414i = new ArrayList();

    /* renamed from: j */
    private final RequestOptionsFactory f5415j;

    /* renamed from: k */
    private MemoryCategory f5416k = MemoryCategory.NORMAL;
    @GuardedBy("this")
    @Nullable

    /* renamed from: l */
    private BitmapPreFiller f5417l;

    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    Glide(@NonNull Context context, @NonNull Engine engine, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, boolean z, boolean z2, int i2, int i3) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Context context2 = context;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        Class<GifDecoder> cls = GifDecoder.class;
        Class<String> cls2 = String.class;
        Class<Integer> cls3 = Integer.class;
        Class<byte[]> cls4 = byte[].class;
        this.f5406a = engine;
        this.f5407b = bitmapPool2;
        this.f5411f = arrayPool2;
        this.f5408c = memoryCache;
        this.f5412g = requestManagerRetriever;
        this.f5413h = connectivityMonitorFactory;
        this.f5415j = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f5410e = registry;
        registry.register((ImageHeaderParser) new DefaultImageHeaderParser());
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 27) {
            registry.register((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> imageHeaderParsers = registry.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, imageHeaderParsers, bitmapPool2, arrayPool2);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel = VideoDecoder.parcel(bitmapPool);
        if (!z2 || i4 < 28) {
            Downsampler downsampler = new Downsampler(registry.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
            resourceDecoder = new ByteBufferBitmapDecoder(downsampler);
            resourceDecoder2 = new StreamBitmapDecoder(downsampler, arrayPool2);
        } else {
            resourceDecoder2 = new InputStreamBitmapImageDecoderResourceDecoder();
            resourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        Class<byte[]> cls5 = cls4;
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        Class<String> cls6 = cls2;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool2);
        ResourceLoader.UriFactory uriFactory2 = uriFactory;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        Class<Integer> cls7 = cls3;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory2 = fileDescriptorFactory;
        ResourceLoader.StreamFactory streamFactory2 = streamFactory;
        Registry register = registry.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(arrayPool2)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, resourceDecoder).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, resourceDecoder2).append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, parcel).append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bitmapPool)).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, bitmapEncoder).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, resourceDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, resourceDecoder2)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcel)).append(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool2, bitmapEncoder)).append(Registry.BUCKET_GIF, InputStream.class, GifDrawable.class, new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool2)).append(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).append(GifDrawable.class, new GifDrawableEncoder()).append(cls, cls, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, cls, Bitmap.class, new GifFrameResourceDecoder(bitmapPool2)).append(Uri.class, Drawable.class, resourceDrawableDecoder).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool2)).register((DataRewinder.Factory<?>) new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register((DataRewinder.Factory<?>) new InputStreamRewinder.Factory(arrayPool2));
        Class cls8 = Integer.TYPE;
        ResourceLoader.StreamFactory streamFactory3 = streamFactory2;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory3 = fileDescriptorFactory2;
        Class<Integer> cls9 = cls7;
        ResourceLoader.UriFactory uriFactory3 = uriFactory2;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory2 = assetFileDescriptorFactory;
        Class<String> cls10 = cls6;
        Context context3 = context;
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls11 = cls5;
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        register.append(cls8, InputStream.class, streamFactory3).append(cls8, ParcelFileDescriptor.class, fileDescriptorFactory3).append(cls9, InputStream.class, streamFactory3).append(cls9, ParcelFileDescriptor.class, fileDescriptorFactory3).append(cls9, Uri.class, uriFactory3).append(cls8, AssetFileDescriptor.class, assetFileDescriptorFactory2).append(cls9, AssetFileDescriptor.class, assetFileDescriptorFactory2).append(cls8, Uri.class, uriFactory3).append(cls10, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(cls10, InputStream.class, new StringLoader.StreamFactory()).append(cls10, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(cls10, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new HttpUriLoader.Factory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).append(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context3)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context3)).append(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver2)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver2)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver2)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(context3)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(cls11, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(cls11, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).register(Bitmap.class, cls11, bitmapBytesTranscoder2).register(Drawable.class, cls11, new DrawableBytesTranscoder(bitmapPool2, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).register(GifDrawable.class, cls11, gifDrawableBytesTranscoder2);
        this.f5409d = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, z, i);
    }

    @GuardedBy("Glide.class")
    /* renamed from: a */
    private static void m4073a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f5405n) {
            f5405n = true;
            m4076f(context, generatedAppGlideModule);
            f5405n = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @Nullable
    /* renamed from: b */
    private static GeneratedAppGlideModule m4074b(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (InstantiationException e) {
            m4078j(e);
            throw null;
        } catch (IllegalAccessException e2) {
            m4078j(e2);
            throw null;
        } catch (NoSuchMethodException e3) {
            m4078j(e3);
            throw null;
        } catch (InvocationTargetException e4) {
            m4078j(e4);
            throw null;
        }
    }

    @NonNull
    /* renamed from: e */
    private static RequestManagerRetriever m4075e(@Nullable Context context) {
        Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @GuardedBy("Glide.class")
    /* renamed from: f */
    private static void m4076f(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        m4077g(context, new GlideBuilder(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    /* renamed from: g */
    private static void m4077g(@NonNull Context context, @NonNull GlideBuilder glideBuilder, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            emptyList = new ManifestParser(applicationContext).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.mo9124a().isEmpty()) {
            Set<Class<?>> a = generatedAppGlideModule.mo9124a();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (a.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (GlideModule glideModule : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + glideModule.getClass());
            }
        }
        glideBuilder.mo9147b(generatedAppGlideModule != null ? generatedAppGlideModule.mo9125b() : null);
        for (GlideModule applyOptions : emptyList) {
            applyOptions.applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        Glide a2 = glideBuilder.mo9145a(applicationContext);
        for (GlideModule next2 : emptyList) {
            try {
                next2.registerComponents(applicationContext, a2, a2.f5410e);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, a2, a2.f5410e);
        }
        applicationContext.registerComponentCallbacks(a2);
        f5404m = a2;
    }

    @NonNull
    public static Glide get(@NonNull Context context) {
        if (f5404m == null) {
            GeneratedAppGlideModule b = m4074b(context.getApplicationContext());
            synchronized (Glide.class) {
                if (f5404m == null) {
                    m4073a(context, b);
                }
            }
        }
        return f5404m;
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR);
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide) {
        synchronized (Glide.class) {
            if (f5404m != null) {
                tearDown();
            }
            f5404m = glide;
        }
    }

    /* renamed from: j */
    private static void m4078j(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @VisibleForTesting
    public static synchronized void tearDown() {
        synchronized (Glide.class) {
            if (f5404m != null) {
                f5404m.getContext().getApplicationContext().unregisterComponentCallbacks(f5404m);
                f5404m.f5406a.shutdown();
            }
            f5404m = null;
        }
    }

    @NonNull
    public static RequestManager with(@NonNull Context context) {
        return m4075e(context).get(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ConnectivityMonitorFactory mo9126c() {
        return this.f5413h;
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.f5406a.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.f5408c.clearMemory();
        this.f5407b.clearMemory();
        this.f5411f.clearMemory();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: d */
    public GlideContext mo9129d() {
        return this.f5409d;
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.f5411f;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.f5407b;
    }

    @NonNull
    public Context getContext() {
        return this.f5409d.getBaseContext();
    }

    @NonNull
    public Registry getRegistry() {
        return this.f5410e;
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.f5412g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo9135h(RequestManager requestManager) {
        synchronized (this.f5414i) {
            if (!this.f5414i.contains(requestManager)) {
                this.f5414i.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo9136i(@NonNull Target<?> target) {
        synchronized (this.f5414i) {
            for (RequestManager e : this.f5414i) {
                if (e.mo9262e(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo9137k(RequestManager requestManager) {
        synchronized (this.f5414i) {
            if (this.f5414i.contains(requestManager)) {
                this.f5414i.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        clearMemory();
    }

    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    public synchronized void preFillBitmapPool(@NonNull PreFillType.Builder... builderArr) {
        if (this.f5417l == null) {
            this.f5417l = new BitmapPreFiller(this.f5408c, this.f5407b, (DecodeFormat) this.f5415j.build().getOptions().get(Downsampler.DECODE_FORMAT));
        }
        this.f5417l.preFill(builderArr);
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.f5408c.setSizeMultiplier(memoryCategory.getMultiplier());
        this.f5407b.setSizeMultiplier(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f5416k;
        this.f5416k = memoryCategory;
        return memoryCategory2;
    }

    public void trimMemory(int i) {
        Util.assertMainThread();
        for (RequestManager onTrimMemory : this.f5414i) {
            onTrimMemory.onTrimMemory(i);
        }
        this.f5408c.trimMemory(i);
        this.f5407b.trimMemory(i);
        this.f5411f.trimMemory(i);
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Glide", 6)) {
            Log.e("Glide", "default disk cache dir is null");
        }
        return null;
    }

    @NonNull
    public static RequestManager with(@NonNull Activity activity) {
        return m4075e(activity).get(activity);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity fragmentActivity) {
        return m4075e(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment fragment) {
        return m4075e(fragment.getContext()).get(fragment);
    }

    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        GeneratedAppGlideModule b = m4074b(context);
        synchronized (Glide.class) {
            if (f5404m != null) {
                tearDown();
            }
            m4077g(context, glideBuilder, b);
        }
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment fragment) {
        return m4075e(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static RequestManager with(@NonNull View view) {
        return m4075e(view.getContext()).get(view);
    }
}
