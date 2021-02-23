package com.dream_studio.animalsounds;

import android.os.AsyncTask;
import java.io.File;

/* renamed from: com.dream_studio.animalsounds.b */
/* compiled from: DownloadXMLFileFromURL */
class C1469b extends AsyncTask<String, String, String> {

    /* renamed from: d */
    public static String f6879d = "Ok";

    /* renamed from: e */
    public static String f6880e = "Error";

    /* renamed from: a */
    private String f6881a = "";

    /* renamed from: b */
    private ImagesActivity f6882b;

    /* renamed from: c */
    private long f6883c;

    public C1469b(ImagesActivity imagesActivity, long j) {
        this.f6882b = imagesActivity;
        this.f6883c = j;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087 A[SYNTHETIC, Splitter:B:38:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091 A[SYNTHETIC, Splitter:B:43:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a2 A[SYNTHETIC, Splitter:B:50:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0154 A[SYNTHETIC, Splitter:B:91:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015e A[SYNTHETIC, Splitter:B:96:0x015e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.String... r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Error: "
            java.lang.String r1 = f6879d
            r2 = 1
            r2 = r12[r2]
            r11.f6881a = r2
            r2 = -1
            r3 = 2
            r4 = 8192(0x2000, float:1.14794E-41)
            r5 = 0
            r6 = 0
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            r8 = r12[r6]     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            java.net.URLConnection r8 = r7.openConnection()     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            r8.connect()     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            java.io.InputStream r7 = r7.openStream()     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            r8.<init>(r7, r4)     // Catch:{ Exception -> 0x007a, all -> 0x0076 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r9.<init>()     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            java.lang.String r10 = r11.f6881a     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r9.append(r10)     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r10 = r12[r3]     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r9.append(r10)     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r7.<init>(r9)     // Catch:{ Exception -> 0x0072, all -> 0x006d }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
        L_0x0042:
            int r9 = r8.read(r5)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            if (r9 == r2) goto L_0x0055
            boolean r10 = r11.isCancelled()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            if (r10 == 0) goto L_0x0051
            java.lang.String r1 = f6880e     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            goto L_0x0055
        L_0x0051:
            r7.write(r5, r6, r9)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            goto L_0x0042
        L_0x0055:
            r7.flush()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r8.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0060:
            r7.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x009a
        L_0x0064:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x009a
        L_0x0069:
            r12 = move-exception
            goto L_0x006f
        L_0x006b:
            r1 = move-exception
            goto L_0x0074
        L_0x006d:
            r12 = move-exception
            r7 = r5
        L_0x006f:
            r5 = r8
            goto L_0x0152
        L_0x0072:
            r1 = move-exception
            r7 = r5
        L_0x0074:
            r5 = r8
            goto L_0x007c
        L_0x0076:
            r12 = move-exception
            r7 = r5
            goto L_0x0152
        L_0x007a:
            r1 = move-exception
            r7 = r5
        L_0x007c:
            java.lang.String r8 = f6880e     // Catch:{ all -> 0x0151 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0151 }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x0151 }
            if (r5 == 0) goto L_0x008f
            r5.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x008f:
            if (r7 == 0) goto L_0x0099
            r7.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0099:
            r1 = r8
        L_0x009a:
            java.lang.String r5 = f6879d
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0150
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0146 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0146 }
            r7.<init>()     // Catch:{ Exception -> 0x0146 }
            java.lang.String r8 = r11.f6881a     // Catch:{ Exception -> 0x0146 }
            r7.append(r8)     // Catch:{ Exception -> 0x0146 }
            r12 = r12[r3]     // Catch:{ Exception -> 0x0146 }
            r7.append(r12)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r12 = r7.toString()     // Catch:{ Exception -> 0x0146 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x0146 }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0146 }
            java.lang.String r3 = r11.f6881a     // Catch:{ Exception -> 0x0146 }
            r12.<init>(r3)     // Catch:{ Exception -> 0x0146 }
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x0146 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0146 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0146 }
            r8.<init>(r5)     // Catch:{ Exception -> 0x0146 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0146 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0146 }
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0141 }
        L_0x00d2:
            java.util.zip.ZipEntry r7 = r3.getNextEntry()     // Catch:{ all -> 0x0141 }
            if (r7 == 0) goto L_0x013a
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0141 }
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x0141 }
            r8.<init>(r12, r9)     // Catch:{ all -> 0x0141 }
            boolean r9 = r7.isDirectory()     // Catch:{ all -> 0x0141 }
            if (r9 == 0) goto L_0x00e9
            r9 = r8
            goto L_0x00ed
        L_0x00e9:
            java.io.File r9 = r8.getParentFile()     // Catch:{ all -> 0x0141 }
        L_0x00ed:
            boolean r10 = r9.isDirectory()     // Catch:{ all -> 0x0141 }
            if (r10 != 0) goto L_0x0115
            boolean r10 = r9.mkdirs()     // Catch:{ all -> 0x0141 }
            if (r10 == 0) goto L_0x00fa
            goto L_0x0115
        L_0x00fa:
            java.io.FileNotFoundException r12 = new java.io.FileNotFoundException     // Catch:{ all -> 0x0141 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0141 }
            r1.<init>()     // Catch:{ all -> 0x0141 }
            java.lang.String r2 = "Failed to ensure directory: "
            r1.append(r2)     // Catch:{ all -> 0x0141 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ all -> 0x0141 }
            r1.append(r2)     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0141 }
            r12.<init>(r1)     // Catch:{ all -> 0x0141 }
            throw r12     // Catch:{ all -> 0x0141 }
        L_0x0115:
            boolean r7 = r7.isDirectory()     // Catch:{ all -> 0x0141 }
            if (r7 == 0) goto L_0x011c
            goto L_0x00d2
        L_0x011c:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0141 }
            r7.<init>(r8)     // Catch:{ all -> 0x0141 }
        L_0x0121:
            int r8 = r3.read(r4)     // Catch:{ all -> 0x0135 }
            if (r8 == r2) goto L_0x012b
            r7.write(r4, r6, r8)     // Catch:{ all -> 0x0135 }
            goto L_0x0121
        L_0x012b:
            r7.close()     // Catch:{ all -> 0x0141 }
            boolean r7 = r11.isCancelled()     // Catch:{ all -> 0x0141 }
            if (r7 == 0) goto L_0x00d2
            goto L_0x013a
        L_0x0135:
            r12 = move-exception
            r7.close()     // Catch:{ all -> 0x0141 }
            throw r12     // Catch:{ all -> 0x0141 }
        L_0x013a:
            r3.close()     // Catch:{ Exception -> 0x0146 }
            r5.delete()     // Catch:{ Exception -> 0x0146 }
            goto L_0x0150
        L_0x0141:
            r12 = move-exception
            r3.close()     // Catch:{ Exception -> 0x0146 }
            throw r12     // Catch:{ Exception -> 0x0146 }
        L_0x0146:
            r12 = move-exception
            java.lang.String r1 = f6880e
            java.lang.String r12 = r12.getMessage()
            android.util.Log.e(r0, r12)
        L_0x0150:
            return r1
        L_0x0151:
            r12 = move-exception
        L_0x0152:
            if (r5 == 0) goto L_0x015c
            r5.close()     // Catch:{ IOException -> 0x0158 }
            goto L_0x015c
        L_0x0158:
            r0 = move-exception
            r0.printStackTrace()
        L_0x015c:
            if (r7 == 0) goto L_0x0166
            r7.close()     // Catch:{ IOException -> 0x0162 }
            goto L_0x0166
        L_0x0162:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0166:
            goto L_0x0168
        L_0x0167:
            throw r12
        L_0x0168:
            goto L_0x0167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.C1469b.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String str) {
        if (!isCancelled() && str.equals(f6879d)) {
            new File(this.f6881a + LoadBottomGalleryLinks.GALLERY_LINKS_FILE_NAME).delete();
            File file = new File(this.f6881a + LoadBottomGalleryLinks.GALLERY_LINKS_FILE_NAME_UNZIPPED);
            if (file.renameTo(new File(this.f6881a + LoadBottomGalleryLinks.GALLERY_LINKS_FILE_NAME))) {
                LoadBottomGalleryLinks.storelinksVersion(this.f6882b.getApplicationContext(), this.f6883c);
            }
            ImagesActivity imagesActivity = this.f6882b;
            if (imagesActivity != null && !imagesActivity.isFinishing()) {
                this.f6882b.updateBottomGallery(this.f6883c);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onProgressUpdate(String... strArr) {
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }
}
