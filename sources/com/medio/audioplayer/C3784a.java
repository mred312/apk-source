package com.medio.audioplayer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.medio.catchexception.CatchException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xiph.vorbis.decoder.DecodeFeed;
import org.xiph.vorbis.decoder.DecodeStreamInfo;
import org.xiph.vorbis.decoder.VorbisDecoder;

@TargetApi(16)
/* renamed from: com.medio.audioplayer.a */
/* compiled from: AudioPlayerAT */
class C3784a implements C3788b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f20921a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AudioTrack f20922b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f20923c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f20924d = 100.0f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f20925e = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile int f20926f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile int f20927g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<C3788b> f20928h = new ArrayList();

    /* renamed from: com.medio.audioplayer.a$a */
    /* compiled from: AudioPlayerAT */
    class C3785a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f20929a;

        /* renamed from: b */
        final /* synthetic */ String f20930b;

        /* renamed from: com.medio.audioplayer.a$a$a */
        /* compiled from: AudioPlayerAT */
        class C3786a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C3788b f20932a;

            C3786a(C3785a aVar, C3788b bVar) {
                this.f20932a = bVar;
            }

            public void run() {
                this.f20932a.mo24095a();
            }
        }

        C3785a(int i, String str) {
            this.f20929a = i;
            this.f20930b = str;
        }

        public void run() {
            C3787b bVar;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                int i = this.f20929a;
                if (i > 0) {
                    bVar = new C3787b(C3784a.this, i, (C3785a) null);
                } else {
                    bVar = new C3787b(C3784a.this, this.f20930b, (C3785a) null);
                }
                VorbisDecoder.startDecoding(bVar);
                bVar.stop();
            } catch (IllegalArgumentException e) {
                CatchException.logException(e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (C3784a.this.f20921a) {
                long j = currentTimeMillis2 - currentTimeMillis;
                if (((long) C3784a.this.f20926f) > j) {
                    try {
                        Thread.sleep(((long) C3784a.this.f20926f) - j);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (C3784a.this.f20922b != null) {
                AudioTrack f = C3784a.this.f20922b;
                AudioTrack unused = C3784a.this.f20922b = null;
                f.release();
            }
            if (C3784a.this.f20921a) {
                boolean unused2 = C3784a.this.f20921a = false;
                for (C3788b aVar : C3784a.this.f20928h) {
                    ((Activity) C3784a.this.f20923c).runOnUiThread(new C3786a(this, aVar));
                }
            }
        }
    }

    /* renamed from: com.medio.audioplayer.a$b */
    /* compiled from: AudioPlayerAT */
    private class C3787b implements DecodeFeed {

        /* renamed from: a */
        private int f20933a;

        /* renamed from: b */
        private InputStream f20934b;

        /* renamed from: c */
        private long f20935c;

        /* synthetic */ C3787b(C3784a aVar, int i, C3785a aVar2) {
            this(i);
        }

        /* renamed from: a */
        private AudioTrack m14047a(DecodeStreamInfo decodeStreamInfo, int i, int i2) {
            if (Build.VERSION.SDK_INT < 26) {
                return m14048b(decodeStreamInfo, i, i2);
            }
            try {
                return new AudioTrack.Builder().setAudioFormat(new AudioFormat.Builder().setChannelMask(i).setEncoding(2).setSampleRate((int) decodeStreamInfo.getSampleRate()).build()).setBufferSizeInBytes(i2).setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build()).setTransferMode(1).build();
            } catch (UnsupportedOperationException unused) {
                return m14048b(decodeStreamInfo, i, i2);
            }
        }

        /* renamed from: b */
        private AudioTrack m14048b(DecodeStreamInfo decodeStreamInfo, int i, int i2) {
            return new AudioTrack(3, (int) decodeStreamInfo.getSampleRate(), i, 2, i2, 1);
        }

        public int readVorbisData(byte[] bArr, int i) {
            if (!C3784a.this.f20921a) {
                return 0;
            }
            try {
                Log.d("AudioTracker", "Reading... " + i);
                InputStream inputStream = this.f20934b;
                int read = inputStream != null ? inputStream.read(bArr, 0, i) : -1;
                if (read == -1) {
                    return 0;
                }
                return read;
            } catch (IOException e) {
                Log.e("AudioTracker", "Failed to read vorbis data from file.  Aborting.", e);
                return 0;
            }
        }

        public void start(DecodeStreamInfo decodeStreamInfo) {
            if (decodeStreamInfo.getChannels() != 1 && decodeStreamInfo.getChannels() != 2) {
                throw new IllegalArgumentException("Channels can only be one or two");
            } else if (decodeStreamInfo.getSampleRate() <= 0) {
                throw new IllegalArgumentException("Invalid sample rate, must be above 0");
            } else if (C3784a.this.f20922b == null) {
                int i = decodeStreamInfo.getChannels() == 1 ? 4 : 12;
                int i2 = 2;
                int minBufferSize = AudioTrack.getMinBufferSize((int) decodeStreamInfo.getSampleRate(), i, 2);
                this.f20933a = minBufferSize;
                if (minBufferSize == -1 || minBufferSize == -2) {
                    this.f20933a = 16384;
                } else {
                    this.f20933a = minBufferSize * 2;
                }
                AudioTrack unused = C3784a.this.f20922b = m14047a(decodeStreamInfo, i, this.f20933a);
                C3784a aVar = C3784a.this;
                aVar.mo24101w(aVar.f20924d);
                C3784a aVar2 = C3784a.this;
                float sampleRate = 1.0f / ((float) decodeStreamInfo.getSampleRate());
                if (i == 4) {
                    i2 = 1;
                }
                float unused2 = aVar2.f20925e = (sampleRate / ((float) i2)) * 1000.0f;
                try {
                    C3784a.this.f20922b.play();
                } catch (IllegalStateException unused3) {
                    if (C3784a.this.f20922b != null) {
                        C3784a.this.f20922b.release();
                    }
                    AudioTrack unused4 = C3784a.this.f20922b = m14047a(decodeStreamInfo, i, this.f20933a);
                    C3784a aVar3 = C3784a.this;
                    aVar3.mo24101w(aVar3.f20924d);
                    try {
                        C3784a.this.f20922b.play();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void startReadingHeader() {
        }

        public void stop() {
            InputStream inputStream = this.f20934b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("AudioTracker", "Failed to close file input stream", e);
                }
                this.f20934b = null;
            }
        }

        public void writePCMData(short[] sArr, int i) {
            Log.d("AudioTracker", "Writing data to track: " + i);
            if (C3784a.this.f20921a && sArr != null && i > 0) {
                try {
                    if (C3784a.this.f20922b != null) {
                        C3784a.this.f20922b.write(sArr, 0, i);
                        this.f20935c += (long) i;
                        C3784a aVar = C3784a.this;
                        int unused = aVar.f20927g = (int) (aVar.f20925e * ((float) this.f20935c));
                    }
                } catch (Exception unused2) {
                    stop();
                }
            }
        }

        /* synthetic */ C3787b(C3784a aVar, String str, C3785a aVar2) {
            this(str);
        }

        private C3787b(int i) {
            this.f20933a = 32768;
            this.f20935c = 0;
            InputStream j = C3784a.this.m14037p(i);
            this.f20934b = j;
            if (j == null) {
                throw new IllegalArgumentException("Stream to decode must not be null.");
            }
        }

        private C3787b(String str) {
            String str2;
            this.f20933a = 32768;
            this.f20935c = 0;
            try {
                this.f20934b = new FileInputStream(str);
                str2 = "";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                str2 = e.getMessage();
            } catch (SecurityException e2) {
                e2.printStackTrace();
                str2 = e2.getMessage();
            } catch (Exception e3) {
                e3.printStackTrace();
                str2 = e3.getMessage();
            }
            if (this.f20934b == null) {
                CatchException.log(str);
                throw new IllegalArgumentException("Stream to decode must not be null (" + str2 + ").");
            }
        }
    }

    public C3784a(Context context) {
        this.f20923c = context;
    }

    /* renamed from: n */
    private int m14035n(int i) {
        Uri u = m14039u(this.f20923c, i);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.f20923c, u);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (extractMetadata != null) {
            return Integer.parseInt(extractMetadata);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[SYNTHETIC, Splitter:B:20:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m14036o(java.lang.String r6) {
        /*
            r5 = this;
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            r1 = 9
            r0.setDataSource(r6)     // Catch:{ Exception -> 0x000f }
            java.lang.String r6 = r0.extractMetadata(r1)     // Catch:{ Exception -> 0x000f }
            goto L_0x0042
        L_0x000f:
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0033 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0033 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0033 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0033 }
            java.io.FileDescriptor r3 = r6.getFD()     // Catch:{ Exception -> 0x002e }
            r0.setDataSource(r3)     // Catch:{ Exception -> 0x002e }
            java.lang.String r0 = r0.extractMetadata(r1)     // Catch:{ Exception -> 0x002e }
            r6.close()     // Catch:{ Exception -> 0x002a }
            r6 = r0
            goto L_0x0042
        L_0x002a:
            r1 = move-exception
            r2 = r6
            r6 = r0
            goto L_0x0035
        L_0x002e:
            r1 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0035
        L_0x0033:
            r1 = move-exception
            r6 = r2
        L_0x0035:
            r1.printStackTrace()
            if (r2 == 0) goto L_0x0042
            r2.close()     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0042:
            r0 = 0
            if (r6 == 0) goto L_0x0049
            int r0 = java.lang.Integer.parseInt(r6)
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medio.audioplayer.C3784a.m14036o(java.lang.String):int");
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public InputStream m14037p(int i) {
        return this.f20923c.getResources().openRawResource(i);
    }

    /* renamed from: s */
    private void m14038s(int i, String str) {
        new Thread(new C3785a(i, str)).start();
    }

    /* renamed from: u */
    public static Uri m14039u(Context context, int i) {
        return Uri.parse("android.resource://" + context.getResources().getResourcePackageName(i) + '/' + context.getResources().getResourceTypeName(i) + '/' + context.getResources().getResourceEntryName(i));
    }

    /* renamed from: a */
    public void mo24095a() {
    }

    /* renamed from: q */
    public synchronized boolean mo24097q(int i) {
        this.f20926f = m14035n(i);
        this.f20921a = true;
        m14038s(i, (String) null);
        return true;
    }

    /* renamed from: r */
    public synchronized boolean mo24098r(String str) {
        this.f20926f = m14036o(str);
        this.f20921a = true;
        m14038s(0, str);
        return true;
    }

    /* renamed from: t */
    public void mo24099t() {
        mo24102x();
    }

    /* renamed from: v */
    public void mo24100v(C3788b bVar) {
        this.f20928h.add(bVar);
    }

    /* renamed from: w */
    public synchronized void mo24101w(float f) {
        AudioTrack audioTrack = this.f20922b;
        if (audioTrack != null) {
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    audioTrack.setStereoVolume(f, f);
                } else {
                    audioTrack.setVolume(f);
                }
            } catch (Exception e) {
                CatchException.logException(e);
            }
        }
        this.f20924d = f;
    }

    /* renamed from: x */
    public synchronized void mo24102x() {
        this.f20921a = false;
    }
}
