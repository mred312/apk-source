package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbac extends zzbap implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {

    /* renamed from: r */
    private static final Map<Integer, String> f12982r;

    /* renamed from: a */
    private final zzbbe f12983a;

    /* renamed from: b */
    private final zzbbh f12984b;

    /* renamed from: c */
    private final boolean f12985c;

    /* renamed from: d */
    private int f12986d = 0;

    /* renamed from: e */
    private int f12987e = 0;

    /* renamed from: f */
    private MediaPlayer f12988f;

    /* renamed from: g */
    private Uri f12989g;

    /* renamed from: h */
    private int f12990h;

    /* renamed from: i */
    private int f12991i;

    /* renamed from: j */
    private int f12992j;

    /* renamed from: k */
    private int f12993k;

    /* renamed from: l */
    private int f12994l;

    /* renamed from: m */
    private zzbbc f12995m;

    /* renamed from: n */
    private boolean f12996n;

    /* renamed from: o */
    private int f12997o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public zzbam f12998p;

    /* renamed from: q */
    private Integer f12999q = null;

    static {
        HashMap hashMap = new HashMap();
        f12982r = hashMap;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            hashMap.put(-1004, "MEDIA_ERROR_IO");
            hashMap.put(-1007, "MEDIA_ERROR_MALFORMED");
            hashMap.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            hashMap.put(-110, "MEDIA_ERROR_TIMED_OUT");
            hashMap.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        hashMap.put(100, "MEDIA_ERROR_SERVER_DIED");
        hashMap.put(1, "MEDIA_ERROR_UNKNOWN");
        hashMap.put(1, "MEDIA_INFO_UNKNOWN");
        hashMap.put(Integer.valueOf(HardwareConfigState.DEFAULT_MAXIMUM_FDS_FOR_HARDWARE_CONFIGS), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        hashMap.put(701, "MEDIA_INFO_BUFFERING_START");
        hashMap.put(702, "MEDIA_INFO_BUFFERING_END");
        hashMap.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        hashMap.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        hashMap.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (i >= 19) {
            hashMap.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            hashMap.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzbac(Context context, zzbbe zzbbe, boolean z, boolean z2, zzbbf zzbbf, zzbbh zzbbh) {
        super(context);
        setSurfaceTextureListener(this);
        this.f12983a = zzbbe;
        this.f12984b = zzbbh;
        this.f12996n = z;
        this.f12985c = z2;
        zzbbh.zzb(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m7642b(MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        int i = Build.VERSION.SDK_INT;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && this.f12983a != null && mediaPlayer != null && i >= 19 && (trackInfo = mediaPlayer.getTrackInfo()) != null) {
            HashMap hashMap = new HashMap();
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2 != null) {
                    int trackType = trackInfo2.getTrackType();
                    if (trackType == 1) {
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 != null) {
                            if (format2.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                }
                            }
                            if (format2.containsKey("bitrate")) {
                                Integer valueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                this.f12999q = valueOf;
                                hashMap.put("bitRate", String.valueOf(valueOf));
                            }
                            if (format2.containsKey("width") && format2.containsKey("height")) {
                                int integer = format2.getInteger("width");
                                int integer2 = format2.getInteger("height");
                                StringBuilder sb = new StringBuilder(23);
                                sb.append(integer);
                                sb.append("x");
                                sb.append(integer2);
                                hashMap.put("resolution", sb.toString());
                            }
                            if (format2.containsKey("mime")) {
                                hashMap.put("videoMime", format2.getString("mime"));
                            }
                            if (i >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format2.getString("codecs-string"));
                            }
                        }
                    } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                        if (format.containsKey("mime")) {
                            hashMap.put("audioMime", format.getString("mime"));
                        }
                        if (i >= 30 && format.containsKey("codecs-string")) {
                            hashMap.put("audioCodec", format.getString("codecs-string"));
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                this.f12983a.zza("onMetadataEvent", hashMap);
            }
        }
    }

    /* renamed from: d */
    private final void m7644d(boolean z) {
        zzd.zzee("AdMediaPlayerView release");
        zzbbc zzbbc = this.f12995m;
        if (zzbbc != null) {
            zzbbc.zzaad();
            this.f12995m = null;
        }
        MediaPlayer mediaPlayer = this.f12988f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f12988f.release();
            this.f12988f = null;
            m7646f(0);
            if (z) {
                this.f12987e = 0;
                this.f12987e = 0;
            }
        }
    }

    /* renamed from: e */
    private final void m7645e(float f) {
        MediaPlayer mediaPlayer = this.f12988f;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzaza.zzfa("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* renamed from: f */
    private final void m7646f(int i) {
        if (i == 3) {
            this.f12984b.zzaat();
            this.zzeii.zzaat();
        } else if (this.f12986d == 3) {
            this.f12984b.zzaau();
            this.zzeii.zzaau();
        }
        this.f12986d = i;
    }

    /* renamed from: h */
    private final void m7647h() {
        zzd.zzee("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f12989g != null && surfaceTexture != null) {
            m7644d(false);
            try {
                zzp.zzlg();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f12988f = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.f12988f.setOnCompletionListener(this);
                this.f12988f.setOnErrorListener(this);
                this.f12988f.setOnInfoListener(this);
                this.f12988f.setOnPreparedListener(this);
                this.f12988f.setOnVideoSizeChangedListener(this);
                this.f12992j = 0;
                if (this.f12996n) {
                    zzbbc zzbbc = new zzbbc(getContext());
                    this.f12995m = zzbbc;
                    zzbbc.zza(surfaceTexture, getWidth(), getHeight());
                    this.f12995m.start();
                    SurfaceTexture zzaae = this.f12995m.zzaae();
                    if (zzaae != null) {
                        surfaceTexture = zzaae;
                    } else {
                        this.f12995m.zzaad();
                        this.f12995m = null;
                    }
                }
                this.f12988f.setDataSource(getContext(), this.f12989g);
                zzp.zzlh();
                this.f12988f.setSurface(new Surface(surfaceTexture));
                this.f12988f.setAudioStreamType(3);
                this.f12988f.setScreenOnWhilePlaying(true);
                this.f12988f.prepareAsync();
                m7646f(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.f12989g);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzaza.zzd(sb.toString(), e);
                onError(this.f12988f, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m7648i() {
        /*
            r8 = this;
            boolean r0 = r8.f12985c
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.m7649j()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.f12988f
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.f12987e
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            r0 = 0
            r8.m7645e(r0)
            android.media.MediaPlayer r0 = r8.f12988f
            r0.start()
            android.media.MediaPlayer r0 = r8.f12988f
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.m7649j()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.f12988f
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.f12988f
            r0.pause()
            r8.zzzq()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.m7648i():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.f12986d;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m7649j() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.f12988f
            if (r0 == 0) goto L_0x000f
            int r0 = r2.f12986d
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.m7649j():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final /* synthetic */ void mo15927g(int i) {
        zzbam zzbam = this.f12998p;
        if (zzbam != null) {
            zzbam.onWindowVisibilityChanged(i);
        }
    }

    public final int getCurrentPosition() {
        if (m7649j()) {
            return this.f12988f.getCurrentPosition();
        }
        return 0;
    }

    public final int getDuration() {
        if (m7649j()) {
            return this.f12988f.getDuration();
        }
        return -1;
    }

    public final long getTotalBytes() {
        if (this.f12999q != null) {
            return ((long) getDuration()) * ((long) this.f12999q.intValue());
        }
        return -1;
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.f12988f;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.f12988f;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f12992j = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzd.zzee("AdMediaPlayerView completion");
        m7646f(5);
        this.f12987e = 5;
        zzm.zzedd.post(new C2276p6(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Map<Integer, String> map = f12982r;
        String str = map.get(Integer.valueOf(i));
        String str2 = map.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaza.zzfa(sb.toString());
        m7646f(-1);
        this.f12987e = -1;
        zzm.zzedd.post(new C2239o6(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        Map<Integer, String> map = f12982r;
        String str = map.get(Integer.valueOf(i));
        String str2 = map.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.zzee(sb.toString());
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r1 > r6) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f12990h
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.f12991i
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.f12990h
            if (r2 <= 0) goto L_0x0083
            int r2 = r5.f12991i
            if (r2 <= 0) goto L_0x0083
            com.google.android.gms.internal.ads.zzbbc r2 = r5.f12995m
            if (r2 != 0) goto L_0x0083
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0047
            if (r1 != r2) goto L_0x0047
            int r0 = r5.f12990h
            int r1 = r0 * r7
            int r2 = r5.f12991i
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003c
            int r0 = r0 * r7
            int r0 = r0 / r2
            goto L_0x006a
        L_0x003c:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L_0x0067
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L_0x0058
        L_0x0047:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x005a
            int r0 = r5.f12991i
            int r0 = r0 * r6
            int r2 = r5.f12990h
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0057
            if (r0 <= r7) goto L_0x0057
            goto L_0x0067
        L_0x0057:
            r1 = r0
        L_0x0058:
            r0 = r6
            goto L_0x0083
        L_0x005a:
            if (r1 != r2) goto L_0x006c
            int r1 = r5.f12990h
            int r1 = r1 * r7
            int r2 = r5.f12991i
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0069
            if (r1 <= r6) goto L_0x0069
        L_0x0067:
            r0 = r6
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            r1 = r7
            goto L_0x0083
        L_0x006c:
            int r2 = r5.f12990h
            int r4 = r5.f12991i
            if (r1 != r3) goto L_0x0078
            if (r4 <= r7) goto L_0x0078
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x007a
        L_0x0078:
            r1 = r2
            r7 = r4
        L_0x007a:
            if (r0 != r3) goto L_0x0069
            if (r1 <= r6) goto L_0x0069
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0058
        L_0x0083:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzbbc r6 = r5.f12995m
            if (r6 == 0) goto L_0x008d
            r6.zzm(r0, r1)
        L_0x008d:
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 16
            if (r6 != r7) goto L_0x00a6
            int r6 = r5.f12993k
            if (r6 <= 0) goto L_0x0099
            if (r6 != r0) goto L_0x009f
        L_0x0099:
            int r6 = r5.f12994l
            if (r6 <= 0) goto L_0x00a2
            if (r6 == r1) goto L_0x00a2
        L_0x009f:
            r5.m7648i()
        L_0x00a2:
            r5.f12993k = r0
            r5.f12994l = r1
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.onMeasure(int, int):void");
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzd.zzee("AdMediaPlayerView prepared");
        m7646f(2);
        this.f12984b.zzfb();
        zzm.zzedd.post(new C2164m6(this, mediaPlayer));
        this.f12990h = mediaPlayer.getVideoWidth();
        this.f12991i = mediaPlayer.getVideoHeight();
        int i = this.f12997o;
        if (i != 0) {
            seekTo(i);
        }
        m7648i();
        int i2 = this.f12990h;
        int i3 = this.f12991i;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzaza.zzez(sb.toString());
        if (this.f12987e == 3) {
            play();
        }
        zzzq();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.zzee("AdMediaPlayerView surface created");
        m7647h();
        zzm.zzedd.post(new C2350r6(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzd.zzee("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.f12988f;
        if (mediaPlayer != null && this.f12997o == 0) {
            this.f12997o = mediaPlayer.getCurrentPosition();
        }
        zzbbc zzbbc = this.f12995m;
        if (zzbbc != null) {
            zzbbc.zzaad();
        }
        zzm.zzedd.post(new C2428t6(this));
        m7644d(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.zzee("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.f12987e == 3;
        if (!(this.f12990h == i && this.f12991i == i2)) {
            z = false;
        }
        if (this.f12988f != null && z2 && z) {
            int i3 = this.f12997o;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbbc zzbbc = this.f12995m;
        if (zzbbc != null) {
            zzbbc.zzm(i, i2);
        }
        zzm.zzedd.post(new C2313q6(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f12984b.zzc(this);
        this.zzeih.zza(surfaceTexture, this.f12998p);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzd.zzee(sb.toString());
        this.f12990h = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f12991i = videoHeight;
        if (this.f12990h != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzd.zzee(sb.toString());
        zzm.zzedd.post(new C2201n6(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void pause() {
        zzd.zzee("AdMediaPlayerView pause");
        if (m7649j() && this.f12988f.isPlaying()) {
            this.f12988f.pause();
            m7646f(4);
            zzm.zzedd.post(new C2465u6(this));
        }
        this.f12987e = 4;
    }

    public final void play() {
        zzd.zzee("AdMediaPlayerView play");
        if (m7649j()) {
            this.f12988f.start();
            m7646f(3);
            this.zzeih.zzzs();
            zzm.zzedd.post(new C2387s6(this));
        }
        this.f12987e = 3;
    }

    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzd.zzee(sb.toString());
        if (m7649j()) {
            this.f12988f.seekTo(i);
            this.f12997o = 0;
            return;
        }
        this.f12997o = i;
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zztf zzd = zztf.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.f12989g = parse;
            this.f12997o = 0;
            m7647h();
            requestLayout();
            invalidate();
        }
    }

    public final void stop() {
        zzd.zzee("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.f12988f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f12988f.release();
            this.f12988f = null;
            m7646f(0);
            this.f12987e = 0;
        }
        this.f12984b.onStop();
    }

    public final String toString() {
        String name = zzbac.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    public final void zza(zzbam zzbam) {
        this.f12998p = zzbam;
    }

    public final long zzna() {
        return 0;
    }

    public final String zzzk() {
        String str = this.f12996n ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    public final long zzzo() {
        if (this.f12999q != null) {
            return (getTotalBytes() * ((long) this.f12992j)) / 100;
        }
        return -1;
    }

    public final int zzzp() {
        if (Build.VERSION.SDK_INT < 26 || !m7649j()) {
            return -1;
        }
        return this.f12988f.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final void zzzq() {
        m7645e(this.zzeii.getVolume());
    }

    public final void zza(float f, float f2) {
        zzbbc zzbbc = this.f12995m;
        if (zzbbc != null) {
            zzbbc.zzb(f, f2);
        }
    }
}
