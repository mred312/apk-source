package com.medio.audioplayer;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayerMP extends MediaPlayer {

    /* renamed from: a */
    private Context f20920a = null;

    public AudioPlayerMP(Context context) {
        this.f20920a = context;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[SYNTHETIC, Splitter:B:11:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[Catch:{ Exception -> 0x006e }, LOOP:0: B:15:0x004a->B:17:0x0050, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071 A[SYNTHETIC, Splitter:B:26:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0054 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean loadFile(int r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            android.content.Context r2 = r9.f20920a     // Catch:{ Exception -> 0x0022 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0022 }
            android.content.res.AssetFileDescriptor r2 = r2.openRawResourceFd(r10)     // Catch:{ Exception -> 0x0022 }
            java.io.FileDescriptor r4 = r2.getFileDescriptor()     // Catch:{ Exception -> 0x0020 }
            long r5 = r2.getStartOffset()     // Catch:{ Exception -> 0x0020 }
            long r7 = r2.getLength()     // Catch:{ Exception -> 0x0020 }
            r3 = r9
            r3.setDataSource(r4, r5, r7)     // Catch:{ Exception -> 0x0020 }
            r2.close()     // Catch:{ Exception -> 0x0020 }
            return r0
        L_0x0020:
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            r3 = 0
            if (r2 == 0) goto L_0x0029
            r2.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            android.content.Context r2 = r9.f20920a     // Catch:{ Exception -> 0x006e }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x006e }
            java.io.InputStream r10 = r2.openRawResource(r10)     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = "sound"
            java.lang.String r4 = "tmp"
            android.content.Context r5 = r9.f20920a     // Catch:{ Exception -> 0x006e }
            java.io.File r5 = r5.getCacheDir()     // Catch:{ Exception -> 0x006e }
            java.io.File r2 = java.io.File.createTempFile(r2, r4, r5)     // Catch:{ Exception -> 0x006e }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006e }
            r4.<init>(r2)     // Catch:{ Exception -> 0x006e }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r5]     // Catch:{ Exception -> 0x006e }
        L_0x004a:
            int r7 = r10.read(r6, r3, r5)     // Catch:{ Exception -> 0x006e }
            if (r7 < 0) goto L_0x0054
            r4.write(r6, r3, r7)     // Catch:{ Exception -> 0x006e }
            goto L_0x004a
        L_0x0054:
            r10.close()     // Catch:{ Exception -> 0x006e }
            r4.close()     // Catch:{ Exception -> 0x006e }
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006e }
            r10.<init>(r2)     // Catch:{ Exception -> 0x006e }
            java.io.FileDescriptor r1 = r10.getFD()     // Catch:{ Exception -> 0x006a }
            r9.setDataSource(r1)     // Catch:{ Exception -> 0x006a }
            r10.close()     // Catch:{ Exception -> 0x006a }
            return r0
        L_0x006a:
            r0 = move-exception
            r1 = r10
            r10 = r0
            goto L_0x006f
        L_0x006e:
            r10 = move-exception
        L_0x006f:
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ IOException -> 0x0074 }
        L_0x0074:
            com.medio.catchexception.CatchException.logException(r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medio.audioplayer.AudioPlayerMP.loadFile(int):boolean");
    }
}
