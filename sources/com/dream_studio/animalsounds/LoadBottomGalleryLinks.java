package com.dream_studio.animalsounds;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import com.google.ads.mediation.facebook.FacebookAdapter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;

public class LoadBottomGalleryLinks {
    public static String COMPLETED = "Ok";
    public static String ERROR = "Error";
    public static long GALLERY_LINKS_BASE_VERSION = 0;
    public static String GALLERY_LINKS_FILE_NAME = "/gallery_links.xml";
    public static String GALLERY_LINKS_FILE_NAME_UNZIPPED = "/gallery_links_new.xml";

    /* renamed from: c */
    private static String f6694c = "links_version";

    /* renamed from: a */
    private ImagesActivity f6695a;

    /* renamed from: b */
    private ConcurrentHashMap<Integer, C1409b> f6696b = new ConcurrentHashMap<>();

    /* renamed from: com.dream_studio.animalsounds.LoadBottomGalleryLinks$b */
    private static class C1409b {

        /* renamed from: a */
        public int f6697a;

        /* renamed from: b */
        public ArrayList<String> f6698b;

        private C1409b() {
            this.f6698b = new ArrayList<>();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.LoadBottomGalleryLinks$c */
    class C1410c extends AsyncTask<String, String, String> {

        /* renamed from: a */
        private ConcurrentHashMap<Integer, C1409b> f6699a;

        public C1410c(@NonNull LoadBottomGalleryLinks loadBottomGalleryLinks, ConcurrentHashMap<Integer, C1409b> concurrentHashMap) {
            this.f6699a = concurrentHashMap;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return LoadBottomGalleryLinks.m4876e(this.f6699a, strArr[0]);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.LoadBottomGalleryLinks$d */
    class C1411d extends AsyncTask<String, String, String> {

        /* renamed from: a */
        private Context f6700a;

        /* renamed from: b */
        private ConcurrentHashMap<Integer, C1409b> f6701b;

        public C1411d(LoadBottomGalleryLinks loadBottomGalleryLinks, @NonNull Context context, ConcurrentHashMap<Integer, C1409b> concurrentHashMap) {
            this.f6700a = context;
            this.f6701b = concurrentHashMap;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return LoadBottomGalleryLinks.m4875d(this.f6700a, this.f6701b, Integer.parseInt(strArr[0]));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    public LoadBottomGalleryLinks(ImagesActivity imagesActivity, long j) {
        this.f6695a = imagesActivity;
        long c = m4874c(imagesActivity.getApplicationContext());
        long j2 = GALLERY_LINKS_BASE_VERSION;
        if (j == j2 && c == j2) {
            new C1411d(this, this.f6695a, this.f6696b).execute(new String[]{String.valueOf(C1441R.raw.gallery_links)});
        } else if (j <= c) {
            String file = this.f6695a.getFilesDir().toString();
            String format = String.format(Locale.ENGLISH, GALLERY_LINKS_FILE_NAME, new Object[]{Long.valueOf(j)});
            C1410c cVar = new C1410c(this, this.f6696b);
            cVar.execute(new String[]{file + format});
        } else {
            String file2 = this.f6695a.getFilesDir().toString();
            String format2 = String.format(Locale.ENGLISH, this.f6695a.getString(C1441R.string.downloadXMLFileName), new Object[]{Long.valueOf(j)});
            C1469b bVar = new C1469b(this.f6695a, j);
            bVar.execute(new String[]{this.f6695a.getString(C1441R.string.downloadServerUrl) + format2, file2, format2});
        }
    }

    /* renamed from: c */
    private static long m4874c(Context context) {
        return context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getLong(f6694c, GALLERY_LINKS_BASE_VERSION);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A[SYNTHETIC, Splitter:B:22:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC, Splitter:B:28:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004f A[SYNTHETIC, Splitter:B:32:0x004f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0042=Splitter:B:25:0x0042, B:19:0x0036=Splitter:B:19:0x0036} */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4875d(android.content.Context r4, java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.dream_studio.animalsounds.LoadBottomGalleryLinks.C1409b> r5, int r6) {
        /*
            java.lang.String r0 = COMPLETED
            r1 = 0
            org.xmlpull.v1.XmlPullParserFactory r2 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            org.xmlpull.v1.XmlPullParser r2 = r2.newPullParser()     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            java.io.InputStream r4 = r4.openRawResource(r6)     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            java.lang.String r6 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r3 = 0
            r2.setFeature(r6, r3)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
            r2.setInput(r4, r1)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
            m4877f(r2, r5)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
            if (r4 == 0) goto L_0x004c
            r4.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x004c
        L_0x0025:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x004c
        L_0x002a:
            r5 = move-exception
            r1 = r4
            goto L_0x004d
        L_0x002d:
            r5 = move-exception
            r1 = r4
            goto L_0x0036
        L_0x0030:
            r5 = move-exception
            r1 = r4
            goto L_0x0042
        L_0x0033:
            r5 = move-exception
            goto L_0x004d
        L_0x0035:
            r5 = move-exception
        L_0x0036:
            com.medio.catchexception.CatchException.logException(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = ERROR     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x004c
        L_0x0041:
            r5 = move-exception
        L_0x0042:
            com.medio.catchexception.CatchException.logException(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = ERROR     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x004c:
            return r0
        L_0x004d:
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0057:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.LoadBottomGalleryLinks.m4875d(android.content.Context, java.util.concurrent.ConcurrentHashMap, int):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC, Splitter:B:21:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f A[SYNTHETIC, Splitter:B:31:0x004f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0042=Splitter:B:24:0x0042, B:18:0x0036=Splitter:B:18:0x0036} */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4876e(java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.dream_studio.animalsounds.LoadBottomGalleryLinks.C1409b> r5, java.lang.String r6) {
        /*
            java.lang.String r0 = COMPLETED
            r1 = 0
            org.xmlpull.v1.XmlPullParserFactory r2 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            org.xmlpull.v1.XmlPullParser r2 = r2.newPullParser()     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            java.io.File r3 = new java.io.File     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            r3.<init>(r6)     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            r6.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0041, IOException -> 0x0035 }
            java.lang.String r3 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r4 = 0
            r2.setFeature(r3, r4)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
            r2.setInput(r6, r1)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
            m4877f(r2, r5)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
            r6.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x004c
        L_0x0025:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x004c
        L_0x002a:
            r5 = move-exception
            r1 = r6
            goto L_0x004d
        L_0x002d:
            r5 = move-exception
            r1 = r6
            goto L_0x0036
        L_0x0030:
            r5 = move-exception
            r1 = r6
            goto L_0x0042
        L_0x0033:
            r5 = move-exception
            goto L_0x004d
        L_0x0035:
            r5 = move-exception
        L_0x0036:
            com.medio.catchexception.CatchException.logException(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = ERROR     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x004c
        L_0x0041:
            r5 = move-exception
        L_0x0042:
            com.medio.catchexception.CatchException.logException(r5)     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = ERROR     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x004c:
            return r0
        L_0x004d:
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0057:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.LoadBottomGalleryLinks.m4876e(java.util.concurrent.ConcurrentHashMap, java.lang.String):java.lang.String");
    }

    /* renamed from: f */
    private static void m4877f(XmlPullParser xmlPullParser, ConcurrentHashMap<Integer, C1409b> concurrentHashMap) {
        int eventType = xmlPullParser.getEventType();
        C1409b bVar = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animal".equals(name)) {
                    bVar = new C1409b();
                } else if (bVar != null) {
                    if (FacebookAdapter.KEY_ID.equals(name)) {
                        int intValue = Integer.valueOf(xmlPullParser.nextText()).intValue();
                        bVar.f6697a = intValue;
                        concurrentHashMap.put(Integer.valueOf(intValue), bVar);
                    } else if ("link".equals(name)) {
                        bVar.f6698b.add(xmlPullParser.nextText());
                    } else if ("pixajpg".equals(name)) {
                        bVar.f6698b.add("https://cdn.pixabay.com/" + xmlPullParser.nextText() + "_640.jpg");
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static void storelinksVersion(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).edit();
        edit.putLong(f6694c, j);
        edit.commit();
    }

    public ArrayList<String> getLinks(int i) {
        if (this.f6696b.get(Integer.valueOf(i)) != null) {
            return this.f6696b.get(Integer.valueOf(i)).f6698b;
        }
        return null;
    }
}
