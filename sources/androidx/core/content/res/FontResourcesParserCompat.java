package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.C0401R;
import androidx.core.provider.FontRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat {
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        @NonNull

        /* renamed from: a */
        private final FontFileResourceEntry[] f2297a;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f2297a = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.f2297a;
        }
    }

    public static final class FontFileResourceEntry {
        @NonNull

        /* renamed from: a */
        private final String f2298a;

        /* renamed from: b */
        private int f2299b;

        /* renamed from: c */
        private boolean f2300c;

        /* renamed from: d */
        private String f2301d;

        /* renamed from: e */
        private int f2302e;

        /* renamed from: f */
        private int f2303f;

        public FontFileResourceEntry(@NonNull String str, int i, boolean z, @Nullable String str2, int i2, int i3) {
            this.f2298a = str;
            this.f2299b = i;
            this.f2300c = z;
            this.f2301d = str2;
            this.f2302e = i2;
            this.f2303f = i3;
        }

        @NonNull
        public String getFileName() {
            return this.f2298a;
        }

        public int getResourceId() {
            return this.f2303f;
        }

        public int getTtcIndex() {
            return this.f2302e;
        }

        @Nullable
        public String getVariationSettings() {
            return this.f2301d;
        }

        public int getWeight() {
            return this.f2299b;
        }

        public boolean isItalic() {
            return this.f2300c;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        @NonNull

        /* renamed from: a */
        private final FontRequest f2304a;

        /* renamed from: b */
        private final int f2305b;

        /* renamed from: c */
        private final int f2306c;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2) {
            this.f2304a = fontRequest;
            this.f2306c = i;
            this.f2305b = i2;
        }

        public int getFetchStrategy() {
            return this.f2306c;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.f2304a;
        }

        public int getTimeout() {
            return this.f2305b;
        }
    }

    private FontResourcesParserCompat() {
    }

    /* renamed from: a */
    private static int m1504a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    @Nullable
    /* renamed from: b */
    private static FamilyResourceEntry m1505b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m1506c(xmlPullParser, resources);
        }
        m1508e(xmlPullParser);
        return null;
    }

    @Nullable
    /* renamed from: c */
    private static FamilyResourceEntry m1506c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0401R.styleable.FontFamily);
        String string = obtainAttributes.getString(C0401R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0401R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0401R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0401R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0401R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0401R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(m1507d(xmlPullParser, resources));
                    } else {
                        m1508e(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            m1508e(xmlPullParser);
        }
        return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
    }

    /* renamed from: d */
    private static FontFileResourceEntry m1507d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0401R.styleable.FontFamilyFont);
        int i = C0401R.styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i)) {
            i = C0401R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        int i3 = C0401R.styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i3)) {
            i3 = C0401R.styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i3, 0);
        int i4 = C0401R.styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = C0401R.styleable.FontFamilyFont_android_ttcIndex;
        }
        int i5 = C0401R.styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = C0401R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i5);
        int i6 = obtainAttributes.getInt(i4, 0);
        int i7 = C0401R.styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = C0401R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i7, 0);
        String string2 = obtainAttributes.getString(i7);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m1508e(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i2, z, string, i6, resourceId);
    }

    /* renamed from: e */
    private static void m1508e(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    /* renamed from: f */
    private static List<byte[]> m1509f(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @androidx.annotation.Nullable
    public static androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry parse(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r3 = m1505b(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            goto L_0x001b
        L_0x001a:
            throw r3
        L_0x001b:
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.FontResourcesParserCompat.parse(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry");
    }

    public static List<List<byte[]>> readCerts(Resources resources, @ArrayRes int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m1504a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m1509f(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m1509f(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }
}
