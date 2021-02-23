package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends C1049b {

    /* renamed from: j */
    static final PorterDuff.Mode f4790j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private C1046h f4791b;

    /* renamed from: c */
    private PorterDuffColorFilter f4792c;

    /* renamed from: d */
    private ColorFilter f4793d;

    /* renamed from: e */
    private boolean f4794e;

    /* renamed from: f */
    private boolean f4795f;

    /* renamed from: g */
    private final float[] f4796g;

    /* renamed from: h */
    private final Matrix f4797h;

    /* renamed from: i */
    private final Rect f4798i;

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$b */
    private static class C1040b extends C1044f {
        C1040b() {
        }

        /* renamed from: f */
        private void m3769f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4825b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4824a = PathParser.createNodesFromPathData(string2);
            }
            this.f4826c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        /* renamed from: c */
        public boolean mo8301c() {
            return true;
        }

        /* renamed from: e */
        public void mo8302e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C1048a.f4861d);
                m3769f(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        C1040b(C1040b bVar) {
            super(bVar);
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$e */
    private static abstract class C1043e {
        private C1043e() {
        }

        /* renamed from: a */
        public boolean mo8303a() {
            return false;
        }

        /* renamed from: b */
        public boolean mo8304b(int[] iArr) {
            return false;
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$h */
    private static class C1046h extends Drawable.ConstantState {

        /* renamed from: a */
        int f4845a;

        /* renamed from: b */
        C1045g f4846b;

        /* renamed from: c */
        ColorStateList f4847c;

        /* renamed from: d */
        PorterDuff.Mode f4848d;

        /* renamed from: e */
        boolean f4849e;

        /* renamed from: f */
        Bitmap f4850f;

        /* renamed from: g */
        ColorStateList f4851g;

        /* renamed from: h */
        PorterDuff.Mode f4852h;

        /* renamed from: i */
        int f4853i;

        /* renamed from: j */
        boolean f4854j;

        /* renamed from: k */
        boolean f4855k;

        /* renamed from: l */
        Paint f4856l;

        public C1046h(C1046h hVar) {
            this.f4847c = null;
            this.f4848d = VectorDrawableCompat.f4790j;
            if (hVar != null) {
                this.f4845a = hVar.f4845a;
                C1045g gVar = new C1045g(hVar.f4846b);
                this.f4846b = gVar;
                if (hVar.f4846b.f4833e != null) {
                    gVar.f4833e = new Paint(hVar.f4846b.f4833e);
                }
                if (hVar.f4846b.f4832d != null) {
                    this.f4846b.f4832d = new Paint(hVar.f4846b.f4832d);
                }
                this.f4847c = hVar.f4847c;
                this.f4848d = hVar.f4848d;
                this.f4849e = hVar.f4849e;
            }
        }

        /* renamed from: a */
        public boolean mo8350a(int i, int i2) {
            return i == this.f4850f.getWidth() && i2 == this.f4850f.getHeight();
        }

        /* renamed from: b */
        public boolean mo8351b() {
            return !this.f4855k && this.f4851g == this.f4847c && this.f4852h == this.f4848d && this.f4854j == this.f4849e && this.f4853i == this.f4846b.getRootAlpha();
        }

        /* renamed from: c */
        public void mo8352c(int i, int i2) {
            if (this.f4850f == null || !mo8350a(i, i2)) {
                this.f4850f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f4855k = true;
            }
        }

        /* renamed from: d */
        public void mo8353d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4850f, (Rect) null, rect, mo8354e(colorFilter));
        }

        /* renamed from: e */
        public Paint mo8354e(ColorFilter colorFilter) {
            if (!mo8355f() && colorFilter == null) {
                return null;
            }
            if (this.f4856l == null) {
                Paint paint = new Paint();
                this.f4856l = paint;
                paint.setFilterBitmap(true);
            }
            this.f4856l.setAlpha(this.f4846b.getRootAlpha());
            this.f4856l.setColorFilter(colorFilter);
            return this.f4856l;
        }

        /* renamed from: f */
        public boolean mo8355f() {
            return this.f4846b.getRootAlpha() < 255;
        }

        /* renamed from: g */
        public boolean mo8356g() {
            return this.f4846b.mo8344f();
        }

        public int getChangingConfigurations() {
            return this.f4845a;
        }

        /* renamed from: h */
        public boolean mo8358h(int[] iArr) {
            boolean g = this.f4846b.mo8345g(iArr);
            this.f4855k |= g;
            return g;
        }

        /* renamed from: i */
        public void mo8359i() {
            this.f4851g = this.f4847c;
            this.f4852h = this.f4848d;
            this.f4853i = this.f4846b.getRootAlpha();
            this.f4854j = this.f4849e;
            this.f4855k = false;
        }

        /* renamed from: j */
        public void mo8360j(int i, int i2) {
            this.f4850f.eraseColor(0);
            this.f4846b.mo8343b(new Canvas(this.f4850f), i, i2, (ColorFilter) null);
        }

        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public C1046h() {
            this.f4847c = null;
            this.f4848d = VectorDrawableCompat.f4790j;
            this.f4846b = new C1045g();
        }
    }

    VectorDrawableCompat() {
        this.f4795f = true;
        this.f4796g = new float[9];
        this.f4797h = new Matrix();
        this.f4798i = new Rect();
        this.f4791b = new C1046h();
    }

    /* renamed from: a */
    static int m3761a(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    /* renamed from: c */
    private void m3762c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C1046h hVar = this.f4791b;
        C1045g gVar = hVar.f4846b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f4836h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C1042d dVar = (C1042d) arrayDeque.peek();
                if ("path".equals(name)) {
                    C1041c cVar = new C1041c();
                    cVar.mo8305g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4812b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f4844p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.f4845a = cVar.f4827d | hVar.f4845a;
                } else if ("clip-path".equals(name)) {
                    C1040b bVar = new C1040b();
                    bVar.mo8302e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4812b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f4844p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f4845a = bVar.f4827d | hVar.f4845a;
                } else if ("group".equals(name)) {
                    C1042d dVar2 = new C1042d();
                    dVar2.mo8322c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4812b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f4844p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f4845a = dVar2.f4821k | hVar.f4845a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat create(@androidx.annotation.NonNull android.content.res.Resources r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0021
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r6, r7, r8)
            r0.f4870a = r6
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$i r6 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$i
            android.graphics.drawable.Drawable r7 = r0.f4870a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x0021:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0029:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            r4 = 2
            if (r3 == r4) goto L_0x0034
            r5 = 1
            if (r3 == r5) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            if (r3 != r4) goto L_0x003b
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = createFromXmlInner(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            return r6
        L_0x003b:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.create(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    /* renamed from: d */
    private boolean m3763d() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    private static PorterDuff.Mode m3764e(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: g */
    private void m3765g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        C1046h hVar = this.f4791b;
        C1045g gVar = hVar.f4846b;
        hVar.f4848d = m3764e(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            hVar.f4847c = namedColorStateList;
        }
        hVar.f4849e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f4849e);
        gVar.f4839k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f4839k);
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f4840l);
        gVar.f4840l = namedFloat;
        if (gVar.f4839k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (namedFloat > 0.0f) {
            gVar.f4837i = typedArray.getDimension(3, gVar.f4837i);
            float dimension = typedArray.getDimension(2, gVar.f4838j);
            gVar.f4838j = dimension;
            if (gVar.f4837i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f4842n = string;
                    gVar.f4844p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo8275b(String str) {
        return this.f4791b.f4846b.f4844p.get(str);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f4870a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f4798i);
        if (this.f4798i.width() > 0 && this.f4798i.height() > 0) {
            ColorFilter colorFilter = this.f4793d;
            if (colorFilter == null) {
                colorFilter = this.f4792c;
            }
            canvas.getMatrix(this.f4797h);
            this.f4797h.getValues(this.f4796g);
            float abs = Math.abs(this.f4796g[0]);
            float abs2 = Math.abs(this.f4796g[4]);
            float abs3 = Math.abs(this.f4796g[1]);
            float abs4 = Math.abs(this.f4796g[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f4798i.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f4798i.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f4798i;
                canvas.translate((float) rect.left, (float) rect.top);
                if (m3763d()) {
                    canvas.translate((float) this.f4798i.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f4798i.offsetTo(0, 0);
                this.f4791b.mo8352c(min, min2);
                if (!this.f4795f) {
                    this.f4791b.mo8360j(min, min2);
                } else if (!this.f4791b.mo8351b()) {
                    this.f4791b.mo8360j(min, min2);
                    this.f4791b.mo8359i();
                }
                this.f4791b.mo8353d(canvas, colorFilter, this.f4798i);
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo8278f(boolean z) {
        this.f4795f = z;
    }

    public int getAlpha() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.f4791b.f4846b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4791b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.f4793d;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f4870a != null && Build.VERSION.SDK_INT >= 24) {
            return new C1047i(this.f4870a.getConstantState());
        }
        this.f4791b.f4845a = getChangingConfigurations();
        return this.f4791b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f4791b.f4846b.f4838j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f4791b.f4846b.f4837i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        C1045g gVar;
        C1046h hVar = this.f4791b;
        if (hVar == null || (gVar = hVar.f4846b) == null) {
            return 1.0f;
        }
        float f = gVar.f4837i;
        if (f == 0.0f) {
            return 1.0f;
        }
        float f2 = gVar.f4838j;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        float f3 = gVar.f4840l;
        if (f3 == 0.0f) {
            return 1.0f;
        }
        float f4 = gVar.f4839k;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f4 / f, f3 / f2);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public PorterDuffColorFilter mo8287h(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.f4791b.f4849e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.f4791b.f4847c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.f4791b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f4870a
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$h r0 = r1.f4791b
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.mo8356g()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$h r0 = r1.f4791b
            android.content.res.ColorStateList r0 = r0.f4847c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.isStateful():boolean");
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f4794e && super.mutate() == this) {
            this.f4791b = new C1046h(this.f4791b);
            this.f4794e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C1046h hVar = this.f4791b;
        ColorStateList colorStateList = hVar.f4847c;
        if (!(colorStateList == null || (mode = hVar.f4848d) == null)) {
            this.f4792c = mo8287h(this.f4792c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.mo8356g() || !hVar.mo8358h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f4791b.f4846b.getRootAlpha() != i) {
            this.f4791b.f4846b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f4791b.f4849e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        C1046h hVar = this.f4791b;
        if (hVar.f4847c != colorStateList) {
            hVar.f4847c = colorStateList;
            this.f4792c = mo8287h(this.f4792c, colorStateList, hVar.f4848d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        C1046h hVar = this.f4791b;
        if (hVar.f4848d != mode) {
            hVar.f4848d = mode;
            this.f4792c = mo8287h(this.f4792c, hVar.f4847c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$i */
    private static class C1047i extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f4857a;

        public C1047i(Drawable.ConstantState constantState) {
            this.f4857a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f4857a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f4857a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f4870a = (VectorDrawable) this.f4857a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f4870a = (VectorDrawable) this.f4857a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f4870a = (VectorDrawable) this.f4857a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f4793d = colorFilter;
        invalidateSelf();
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$f */
    private static abstract class C1044f extends C1043e {

        /* renamed from: a */
        protected PathParser.PathDataNode[] f4824a = null;

        /* renamed from: b */
        String f4825b;

        /* renamed from: c */
        int f4826c = 0;

        /* renamed from: d */
        int f4827d;

        public C1044f() {
            super();
        }

        /* renamed from: c */
        public boolean mo8301c() {
            return false;
        }

        /* renamed from: d */
        public void mo8339d(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f4824a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f4824a;
        }

        public String getPathName() {
            return this.f4825b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.f4824a, pathDataNodeArr)) {
                this.f4824a = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.f4824a, pathDataNodeArr);
            }
        }

        public C1044f(C1044f fVar) {
            super();
            this.f4825b = fVar.f4825b;
            this.f4827d = fVar.f4827d;
            this.f4824a = PathParser.deepCopyNodes(fVar.f4824a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f4870a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C1046h hVar = this.f4791b;
        hVar.f4846b = new C1045g();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C1048a.f4858a);
        m3765g(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        hVar.f4845a = getChangingConfigurations();
        hVar.f4855k = true;
        m3762c(resources, xmlPullParser, attributeSet, theme);
        this.f4792c = mo8287h(this.f4792c, hVar.f4847c, hVar.f4848d);
    }

    VectorDrawableCompat(@NonNull C1046h hVar) {
        this.f4795f = true;
        this.f4796g = new float[9];
        this.f4797h = new Matrix();
        this.f4798i = new Rect();
        this.f4791b = hVar;
        this.f4792c = mo8287h(this.f4792c, hVar.f4847c, hVar.f4848d);
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$c */
    private static class C1041c extends C1044f {

        /* renamed from: e */
        private int[] f4799e;

        /* renamed from: f */
        ComplexColorCompat f4800f;

        /* renamed from: g */
        float f4801g = 0.0f;

        /* renamed from: h */
        ComplexColorCompat f4802h;

        /* renamed from: i */
        float f4803i = 1.0f;

        /* renamed from: j */
        float f4804j = 1.0f;

        /* renamed from: k */
        float f4805k = 0.0f;

        /* renamed from: l */
        float f4806l = 1.0f;

        /* renamed from: m */
        float f4807m = 0.0f;

        /* renamed from: n */
        Paint.Cap f4808n = Paint.Cap.BUTT;

        /* renamed from: o */
        Paint.Join f4809o = Paint.Join.MITER;

        /* renamed from: p */
        float f4810p = 4.0f;

        C1041c() {
        }

        /* renamed from: e */
        private Paint.Cap m3772e(int i, Paint.Cap cap) {
            if (i == 0) {
                return Paint.Cap.BUTT;
            }
            if (i != 1) {
                return i != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        /* renamed from: f */
        private Paint.Join m3773f(int i, Paint.Join join) {
            if (i == 0) {
                return Paint.Join.MITER;
            }
            if (i != 1) {
                return i != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        /* renamed from: h */
        private void m3774h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f4799e = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4825b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4824a = PathParser.createNodesFromPathData(string2);
                }
                Resources.Theme theme2 = theme;
                this.f4802h = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f4804j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.f4804j);
                this.f4808n = m3772e(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f4808n);
                this.f4809o = m3773f(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f4809o);
                this.f4810p = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f4810p);
                this.f4800f = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f4803i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4803i);
                this.f4801g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.f4801g);
                this.f4806l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4806l);
                this.f4807m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4807m);
                this.f4805k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.f4805k);
                this.f4826c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.f4826c);
            }
        }

        /* renamed from: a */
        public boolean mo8303a() {
            return this.f4802h.isStateful() || this.f4800f.isStateful();
        }

        /* renamed from: b */
        public boolean mo8304b(int[] iArr) {
            return this.f4800f.onStateChanged(iArr) | this.f4802h.onStateChanged(iArr);
        }

        /* renamed from: g */
        public void mo8305g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C1048a.f4860c);
            m3774h(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f4804j;
        }

        /* access modifiers changed from: package-private */
        @ColorInt
        public int getFillColor() {
            return this.f4802h.getColor();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f4803i;
        }

        /* access modifiers changed from: package-private */
        @ColorInt
        public int getStrokeColor() {
            return this.f4800f.getColor();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f4801g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f4806l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f4807m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f4805k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f) {
            this.f4804j = f;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i) {
            this.f4802h.setColor(i);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f) {
            this.f4803i = f;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i) {
            this.f4800f.setColor(i);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f) {
            this.f4801g = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f) {
            this.f4806l = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f) {
            this.f4807m = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f) {
            this.f4805k = f;
        }

        C1041c(C1041c cVar) {
            super(cVar);
            this.f4799e = cVar.f4799e;
            this.f4800f = cVar.f4800f;
            this.f4801g = cVar.f4801g;
            this.f4803i = cVar.f4803i;
            this.f4802h = cVar.f4802h;
            this.f4826c = cVar.f4826c;
            this.f4804j = cVar.f4804j;
            this.f4805k = cVar.f4805k;
            this.f4806l = cVar.f4806l;
            this.f4807m = cVar.f4807m;
            this.f4808n = cVar.f4808n;
            this.f4809o = cVar.f4809o;
            this.f4810p = cVar.f4810p;
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$g */
    private static class C1045g {

        /* renamed from: q */
        private static final Matrix f4828q = new Matrix();

        /* renamed from: a */
        private final Path f4829a;

        /* renamed from: b */
        private final Path f4830b;

        /* renamed from: c */
        private final Matrix f4831c;

        /* renamed from: d */
        Paint f4832d;

        /* renamed from: e */
        Paint f4833e;

        /* renamed from: f */
        private PathMeasure f4834f;

        /* renamed from: g */
        private int f4835g;

        /* renamed from: h */
        final C1042d f4836h;

        /* renamed from: i */
        float f4837i;

        /* renamed from: j */
        float f4838j;

        /* renamed from: k */
        float f4839k;

        /* renamed from: l */
        float f4840l;

        /* renamed from: m */
        int f4841m;

        /* renamed from: n */
        String f4842n;

        /* renamed from: o */
        Boolean f4843o;

        /* renamed from: p */
        final ArrayMap<String, Object> f4844p;

        public C1045g() {
            this.f4831c = new Matrix();
            this.f4837i = 0.0f;
            this.f4838j = 0.0f;
            this.f4839k = 0.0f;
            this.f4840l = 0.0f;
            this.f4841m = 255;
            this.f4842n = null;
            this.f4843o = null;
            this.f4844p = new ArrayMap<>();
            this.f4836h = new C1042d();
            this.f4829a = new Path();
            this.f4830b = new Path();
        }

        /* renamed from: a */
        private static float m3787a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* renamed from: c */
        private void m3788c(C1042d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.f4811a.set(matrix);
            dVar.f4811a.preConcat(dVar.f4820j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.f4812b.size(); i3++) {
                C1043e eVar = dVar.f4812b.get(i3);
                if (eVar instanceof C1042d) {
                    m3788c((C1042d) eVar, dVar.f4811a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof C1044f) {
                    m3789d(dVar, (C1044f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* renamed from: d */
        private void m3789d(C1042d dVar, C1044f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f4839k;
            float f2 = ((float) i2) / this.f4840l;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.f4811a;
            this.f4831c.set(matrix);
            this.f4831c.postScale(f, f2);
            float e = m3790e(matrix);
            if (e != 0.0f) {
                fVar.mo8339d(this.f4829a);
                Path path = this.f4829a;
                this.f4830b.reset();
                if (fVar.mo8301c()) {
                    this.f4830b.setFillType(fVar.f4826c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f4830b.addPath(path, this.f4831c);
                    canvas.clipPath(this.f4830b);
                    return;
                }
                C1041c cVar = (C1041c) fVar;
                float f3 = cVar.f4805k;
                if (!(f3 == 0.0f && cVar.f4806l == 1.0f)) {
                    float f4 = cVar.f4807m;
                    float f5 = (f3 + f4) % 1.0f;
                    float f6 = (cVar.f4806l + f4) % 1.0f;
                    if (this.f4834f == null) {
                        this.f4834f = new PathMeasure();
                    }
                    this.f4834f.setPath(this.f4829a, false);
                    float length = this.f4834f.getLength();
                    float f7 = f5 * length;
                    float f8 = f6 * length;
                    path.reset();
                    if (f7 > f8) {
                        this.f4834f.getSegment(f7, length, path, true);
                        this.f4834f.getSegment(0.0f, f8, path, true);
                    } else {
                        this.f4834f.getSegment(f7, f8, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f4830b.addPath(path, this.f4831c);
                if (cVar.f4802h.willDraw()) {
                    ComplexColorCompat complexColorCompat = cVar.f4802h;
                    if (this.f4833e == null) {
                        Paint paint = new Paint(1);
                        this.f4833e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f4833e;
                    if (complexColorCompat.isGradient()) {
                        Shader shader = complexColorCompat.getShader();
                        shader.setLocalMatrix(this.f4831c);
                        paint2.setShader(shader);
                        paint2.setAlpha(Math.round(cVar.f4804j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.m3761a(complexColorCompat.getColor(), cVar.f4804j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f4830b.setFillType(cVar.f4826c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f4830b, paint2);
                }
                if (cVar.f4800f.willDraw()) {
                    ComplexColorCompat complexColorCompat2 = cVar.f4800f;
                    if (this.f4832d == null) {
                        Paint paint3 = new Paint(1);
                        this.f4832d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f4832d;
                    Paint.Join join = cVar.f4809o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f4808n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f4810p);
                    if (complexColorCompat2.isGradient()) {
                        Shader shader2 = complexColorCompat2.getShader();
                        shader2.setLocalMatrix(this.f4831c);
                        paint4.setShader(shader2);
                        paint4.setAlpha(Math.round(cVar.f4803i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.m3761a(complexColorCompat2.getColor(), cVar.f4803i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f4801g * min * e);
                    canvas.drawPath(this.f4830b, paint4);
                }
            }
        }

        /* renamed from: e */
        private float m3790e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a = m3787a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }

        /* renamed from: b */
        public void mo8343b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m3788c(this.f4836h, f4828q, canvas, i, i2, colorFilter);
        }

        /* renamed from: f */
        public boolean mo8344f() {
            if (this.f4843o == null) {
                this.f4843o = Boolean.valueOf(this.f4836h.mo8303a());
            }
            return this.f4843o.booleanValue();
        }

        /* renamed from: g */
        public boolean mo8345g(int[] iArr) {
            return this.f4836h.mo8304b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f4841m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f4841m = i;
        }

        public C1045g(C1045g gVar) {
            this.f4831c = new Matrix();
            this.f4837i = 0.0f;
            this.f4838j = 0.0f;
            this.f4839k = 0.0f;
            this.f4840l = 0.0f;
            this.f4841m = 255;
            this.f4842n = null;
            this.f4843o = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.f4844p = arrayMap;
            this.f4836h = new C1042d(gVar.f4836h, arrayMap);
            this.f4829a = new Path(gVar.f4829a);
            this.f4830b = new Path(gVar.f4830b);
            this.f4837i = gVar.f4837i;
            this.f4838j = gVar.f4838j;
            this.f4839k = gVar.f4839k;
            this.f4840l = gVar.f4840l;
            this.f4835g = gVar.f4835g;
            this.f4841m = gVar.f4841m;
            this.f4842n = gVar.f4842n;
            String str = gVar.f4842n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f4843o = gVar.f4843o;
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$d */
    private static class C1042d extends C1043e {

        /* renamed from: a */
        final Matrix f4811a;

        /* renamed from: b */
        final ArrayList<C1043e> f4812b;

        /* renamed from: c */
        float f4813c;

        /* renamed from: d */
        private float f4814d;

        /* renamed from: e */
        private float f4815e;

        /* renamed from: f */
        private float f4816f;

        /* renamed from: g */
        private float f4817g;

        /* renamed from: h */
        private float f4818h;

        /* renamed from: i */
        private float f4819i;

        /* renamed from: j */
        final Matrix f4820j;

        /* renamed from: k */
        int f4821k;

        /* renamed from: l */
        private int[] f4822l;

        /* renamed from: m */
        private String f4823m;

        public C1042d(C1042d dVar, ArrayMap<String, Object> arrayMap) {
            super();
            C1044f fVar;
            this.f4811a = new Matrix();
            this.f4812b = new ArrayList<>();
            this.f4813c = 0.0f;
            this.f4814d = 0.0f;
            this.f4815e = 0.0f;
            this.f4816f = 1.0f;
            this.f4817g = 1.0f;
            this.f4818h = 0.0f;
            this.f4819i = 0.0f;
            Matrix matrix = new Matrix();
            this.f4820j = matrix;
            this.f4823m = null;
            this.f4813c = dVar.f4813c;
            this.f4814d = dVar.f4814d;
            this.f4815e = dVar.f4815e;
            this.f4816f = dVar.f4816f;
            this.f4817g = dVar.f4817g;
            this.f4818h = dVar.f4818h;
            this.f4819i = dVar.f4819i;
            this.f4822l = dVar.f4822l;
            String str = dVar.f4823m;
            this.f4823m = str;
            this.f4821k = dVar.f4821k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(dVar.f4820j);
            ArrayList<C1043e> arrayList = dVar.f4812b;
            for (int i = 0; i < arrayList.size(); i++) {
                C1043e eVar = arrayList.get(i);
                if (eVar instanceof C1042d) {
                    this.f4812b.add(new C1042d((C1042d) eVar, arrayMap));
                } else {
                    if (eVar instanceof C1041c) {
                        fVar = new C1041c((C1041c) eVar);
                    } else if (eVar instanceof C1040b) {
                        fVar = new C1040b((C1040b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f4812b.add(fVar);
                    String str2 = fVar.f4825b;
                    if (str2 != null) {
                        arrayMap.put(str2, fVar);
                    }
                }
            }
        }

        /* renamed from: d */
        private void m3778d() {
            this.f4820j.reset();
            this.f4820j.postTranslate(-this.f4814d, -this.f4815e);
            this.f4820j.postScale(this.f4816f, this.f4817g);
            this.f4820j.postRotate(this.f4813c, 0.0f, 0.0f);
            this.f4820j.postTranslate(this.f4818h + this.f4814d, this.f4819i + this.f4815e);
        }

        /* renamed from: e */
        private void m3779e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f4822l = null;
            this.f4813c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f4813c);
            this.f4814d = typedArray.getFloat(1, this.f4814d);
            this.f4815e = typedArray.getFloat(2, this.f4815e);
            this.f4816f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.f4816f);
            this.f4817g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.f4817g);
            this.f4818h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.f4818h);
            this.f4819i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.f4819i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4823m = string;
            }
            m3778d();
        }

        /* renamed from: a */
        public boolean mo8303a() {
            for (int i = 0; i < this.f4812b.size(); i++) {
                if (this.f4812b.get(i).mo8303a()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public boolean mo8304b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f4812b.size(); i++) {
                z |= this.f4812b.get(i).mo8304b(iArr);
            }
            return z;
        }

        /* renamed from: c */
        public void mo8322c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C1048a.f4859b);
            m3779e(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        public String getGroupName() {
            return this.f4823m;
        }

        public Matrix getLocalMatrix() {
            return this.f4820j;
        }

        public float getPivotX() {
            return this.f4814d;
        }

        public float getPivotY() {
            return this.f4815e;
        }

        public float getRotation() {
            return this.f4813c;
        }

        public float getScaleX() {
            return this.f4816f;
        }

        public float getScaleY() {
            return this.f4817g;
        }

        public float getTranslateX() {
            return this.f4818h;
        }

        public float getTranslateY() {
            return this.f4819i;
        }

        public void setPivotX(float f) {
            if (f != this.f4814d) {
                this.f4814d = f;
                m3778d();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f4815e) {
                this.f4815e = f;
                m3778d();
            }
        }

        public void setRotation(float f) {
            if (f != this.f4813c) {
                this.f4813c = f;
                m3778d();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f4816f) {
                this.f4816f = f;
                m3778d();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f4817g) {
                this.f4817g = f;
                m3778d();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f4818h) {
                this.f4818h = f;
                m3778d();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f4819i) {
                this.f4819i = f;
                m3778d();
            }
        }

        public C1042d() {
            super();
            this.f4811a = new Matrix();
            this.f4812b = new ArrayList<>();
            this.f4813c = 0.0f;
            this.f4814d = 0.0f;
            this.f4815e = 0.0f;
            this.f4816f = 1.0f;
            this.f4817g = 1.0f;
            this.f4818h = 0.0f;
            this.f4819i = 0.0f;
            this.f4820j = new Matrix();
            this.f4823m = null;
        }
    }
}
