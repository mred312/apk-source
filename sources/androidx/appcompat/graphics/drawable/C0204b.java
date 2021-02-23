package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.C0200a;
import androidx.appcompat.resources.C0206R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.appcompat.graphics.drawable.b */
/* compiled from: StateListDrawable */
class C0204b extends C0200a {

    /* renamed from: m */
    private C0205a f723m;

    /* renamed from: n */
    private boolean f724n;

    /* renamed from: androidx.appcompat.graphics.drawable.b$a */
    /* compiled from: StateListDrawable */
    static class C0205a extends C0200a.C0203c {

        /* renamed from: J */
        int[][] f725J;

        C0205a(C0205a aVar, C0204b bVar, Resources resources) {
            super(aVar, bVar, resources);
            if (aVar != null) {
                this.f725J = aVar.f725J;
            } else {
                this.f725J = new int[mo1375f()][];
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: A */
        public int mo1395A(int[] iArr) {
            int[][] iArr2 = this.f725J;
            int h = mo1378h();
            for (int i = 0; i < h; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @NonNull
        public Drawable newDrawable() {
            return new C0204b(this, (Resources) null);
        }

        /* renamed from: o */
        public void mo1385o(int i, int i2) {
            super.mo1385o(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f725J, 0, iArr, 0, i);
            this.f725J = iArr;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public void mo1291r() {
            int[][] iArr = this.f725J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f725J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f725J = iArr2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z */
        public int mo1396z(int[] iArr, Drawable drawable) {
            int a = mo1370a(drawable);
            this.f725J[a] = iArr;
            return a;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new C0204b(this, resources);
        }
    }

    C0204b(C0205a aVar, Resources resources) {
        mo1256h(new C0205a(aVar, this, resources));
        onStateChange(getState());
    }

    /* renamed from: l */
    private void m612l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        C0205a aVar = this.f723m;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0206R.styleable.StateListDrawableItem);
                    Drawable drawable = null;
                    int resourceId = obtainAttributes.getResourceId(C0206R.styleable.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                    }
                    obtainAttributes.recycle();
                    int[] k = mo1394k(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        }
                    }
                    aVar.mo1396z(k, drawable);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: m */
    private void m613m(TypedArray typedArray) {
        C0205a aVar = this.f723m;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f700d |= typedArray.getChangingConfigurations();
        }
        aVar.f705i = typedArray.getBoolean(C0206R.styleable.StateListDrawable_android_variablePadding, aVar.f705i);
        aVar.f708l = typedArray.getBoolean(C0206R.styleable.StateListDrawable_android_constantSize, aVar.f708l);
        aVar.f688A = typedArray.getInt(C0206R.styleable.StateListDrawable_android_enterFadeDuration, aVar.f688A);
        aVar.f689B = typedArray.getInt(C0206R.styleable.StateListDrawable_android_exitFadeDuration, aVar.f689B);
        aVar.f720x = typedArray.getBoolean(C0206R.styleable.StateListDrawable_android_dither, aVar.f720x);
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.f723m.mo1396z(iArr, drawable);
            onStateChange(getState());
        }
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1256h(@NonNull C0200a.C0203c cVar) {
        super.mo1256h(cVar);
        if (cVar instanceof C0205a) {
            this.f723m = (C0205a) cVar;
        }
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0206R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(C0206R.styleable.StateListDrawable_android_visible, true), true);
        m613m(obtainAttributes);
        mo1361i(resources);
        obtainAttributes.recycle();
        m612l(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0205a mo1242b() {
        return new C0205a(this.f723m, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int[] mo1394k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @NonNull
    public Drawable mutate() {
        if (!this.f724n && super.mutate() == this) {
            this.f723m.mo1291r();
            this.f724n = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int A = this.f723m.mo1395A(iArr);
        if (A < 0) {
            A = this.f723m.mo1395A(StateSet.WILD_CARD);
        }
        return mo1359g(A) || onStateChange;
    }

    C0204b(@Nullable C0205a aVar) {
        if (aVar != null) {
            mo1256h(aVar);
        }
    }
}
