package com.medio.audioplayer;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import com.medio.catchexception.CatchException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer implements AudioPlayerListener {

    /* renamed from: a */
    private Context f20900a = null;

    /* renamed from: b */
    private C3784a f20901b = null;

    /* renamed from: c */
    private AudioPlayerMP f20902c = null;

    /* renamed from: d */
    private MediaPlayer f20903d = null;

    /* renamed from: e */
    boolean f20904e = false;

    /* renamed from: f */
    int f20905f = 0;

    /* renamed from: g */
    private AudioPlayerListener f20906g = null;

    /* renamed from: h */
    private List<C3783j> f20907h = null;

    /* renamed from: com.medio.audioplayer.AudioPlayer$a */
    class C3774a implements MediaPlayer.OnPreparedListener {
        C3774a() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (!AudioPlayer.this.f20904e) {
                mediaPlayer.start();
            }
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$b */
    class C3775b implements MediaPlayer.OnErrorListener {
        C3775b() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AudioPlayer.this.m14018r();
            AudioPlayer.this.m14013m();
            return true;
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$c */
    class C3776c implements MediaPlayer.OnCompletionListener {
        C3776c() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayer.this.m14021u();
            AudioPlayer.this.m14012l();
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$d */
    class C3777d implements MediaPlayer.OnErrorListener {
        C3777d() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AudioPlayer.this.m14019s();
            AudioPlayer.this.m14015o();
            return true;
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$e */
    class C3778e implements MediaPlayer.OnCompletionListener {
        C3778e() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayer.this.m14021u();
            AudioPlayer.this.m14012l();
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$f */
    class C3779f implements MediaPlayer.OnPreparedListener {
        C3779f() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (!AudioPlayer.this.f20904e) {
                mediaPlayer.start();
            }
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$g */
    class C3780g implements MediaPlayer.OnErrorListener {
        C3780g() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AudioPlayer.this.m14018r();
            AudioPlayer.this.m14015o();
            return true;
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$h */
    class C3781h implements MediaPlayer.OnCompletionListener {
        C3781h() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayer.this.m14021u();
            AudioPlayer.this.m14012l();
        }
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$i */
    class C3782i implements C3788b {
        C3782i() {
        }

        /* renamed from: a */
        public void mo24095a() {
            AudioPlayer.this.m14021u();
            AudioPlayer.this.m14012l();
        }
    }

    public AudioPlayer(Context context) {
        this.f20900a = context;
        this.f20907h = new ArrayList();
    }

    /* renamed from: g */
    private String m14007g(String str, String str2) {
        return String.format("%s/%s_%s.ogg", new Object[]{this.f20900a.getFilesDir(), str2, str});
    }

    /* renamed from: h */
    private int m14008h(String str) {
        int identifier = this.f20900a.getResources().getIdentifier(str, "raw", this.f20900a.getPackageName());
        if (identifier == 0) {
            Resources resources = this.f20900a.getResources();
            identifier = resources.getIdentifier(this.f20900a.getPackageName() + ":raw/" + str, (String) null, (String) null);
        }
        if (identifier == 0) {
            CatchException.log(String.format("AudioPlayer getIndentifier() name=%s", new Object[]{str}));
        }
        return identifier;
    }

    /* renamed from: i */
    private String m14009i(int i) {
        return this.f20900a.getResources().getResourceName(i);
    }

    /* renamed from: j */
    private void m14010j() {
        release();
        this.f20904e = false;
        this.f20905f = 0;
    }

    /* renamed from: k */
    private void m14011k() {
        m14020t();
        try {
            List<C3783j> list = this.f20907h;
            if (list != null && this.f20905f < list.size()) {
                C3783j jVar = this.f20907h.get(this.f20905f);
                AudioPlayerMP audioPlayerMP = new AudioPlayerMP(this.f20900a);
                this.f20902c = audioPlayerMP;
                audioPlayerMP.setAudioStreamType(3);
                this.f20902c.setOnPreparedListener(new C3779f());
                this.f20902c.setOnErrorListener(new C3780g());
                this.f20902c.setOnCompletionListener(new C3781h());
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(jVar.f20919c));
                    try {
                        this.f20902c.setDataSource(fileInputStream2.getFD());
                        this.f20902c.prepareAsync();
                        fileInputStream2.close();
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                    }
                } catch (Exception unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    m14015o();
                }
            }
        } catch (Exception unused3) {
            m14015o();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m14012l() {
        this.f20905f++;
        m14014n();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m14013m() {
        m14020t();
        try {
            List<C3783j> list = this.f20907h;
            if (list != null && this.f20905f < list.size()) {
                MediaPlayer create = MediaPlayer.create(this.f20900a, this.f20907h.get(this.f20905f).f20917a);
                this.f20903d = create;
                create.setOnErrorListener(new C3777d());
                this.f20903d.setOnCompletionListener(new C3778e());
                this.f20903d.start();
            }
        } catch (Exception unused) {
            m14015o();
        }
    }

    /* renamed from: n */
    private void m14014n() {
        List<C3783j> list = this.f20907h;
        if (list != null && this.f20905f < list.size()) {
            if (this.f20907h.get(this.f20905f).f20918b) {
                m14011k();
            } else {
                m14016p();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m14015o() {
        List<C3783j> list;
        m14020t();
        if (!this.f20904e && (list = this.f20907h) != null && this.f20905f < list.size()) {
            try {
                C3784a aVar = new C3784a(this.f20900a);
                this.f20901b = aVar;
                aVar.mo24100v(new C3782i());
                C3783j jVar = this.f20907h.get(this.f20905f);
                int i = jVar.f20917a;
                if (i > 0) {
                    if (!this.f20901b.mo24097q(i)) {
                        m14012l();
                    }
                } else if (!this.f20901b.mo24098r(jVar.f20919c)) {
                    m14012l();
                }
            } catch (Exception e) {
                CatchException.logException(e);
                m14012l();
            }
        }
    }

    /* renamed from: p */
    private void m14016p() {
        m14020t();
        try {
            List<C3783j> list = this.f20907h;
            if (list != null && this.f20905f < list.size()) {
                AudioPlayerMP audioPlayerMP = new AudioPlayerMP(this.f20900a);
                this.f20902c = audioPlayerMP;
                audioPlayerMP.setAudioStreamType(3);
                this.f20902c.setOnPreparedListener(new C3774a());
                this.f20902c.setOnErrorListener(new C3775b());
                this.f20902c.setOnCompletionListener(new C3776c());
                if (this.f20902c.loadFile(this.f20907h.get(this.f20905f).f20917a)) {
                    this.f20902c.prepareAsync();
                } else {
                    m14013m();
                }
            }
        } catch (Exception unused) {
            m14013m();
        }
    }

    /* renamed from: q */
    private void m14017q() {
        C3784a aVar = this.f20901b;
        if (aVar != null) {
            aVar.mo24099t();
            this.f20901b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m14018r() {
        AudioPlayerMP audioPlayerMP = this.f20902c;
        if (audioPlayerMP != null) {
            audioPlayerMP.release();
            this.f20902c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m14019s() {
        MediaPlayer mediaPlayer = this.f20903d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f20903d = null;
        }
    }

    /* renamed from: t */
    private void m14020t() {
        m14018r();
        m14017q();
        m14019s();
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m14021u() {
        AudioPlayerListener audioPlayerListener = this.f20906g;
        if (audioPlayerListener != null) {
            audioPlayerListener.setOnEndListener();
        }
    }

    public void pause() {
        release();
    }

    public void playByID(int i, int i2) {
        m14010j();
        if (i != 0) {
            try {
                this.f20907h.add(new C3783j(this, i, m14009i(i)));
            } catch (Exception e) {
                CatchException.logException(e);
            }
        }
        if (i2 != 0) {
            this.f20907h.add(new C3783j(this, i2, m14009i(i2)));
        }
        m14014n();
    }

    public void playByName(String str, String str2) {
        m14010j();
        if (str != null) {
            try {
                this.f20907h.add(new C3783j(this, m14008h(str), str));
            } catch (Exception e) {
                CatchException.logException(e);
            }
        }
        if (str2 != null) {
            this.f20907h.add(new C3783j(this, m14008h(str2), str2));
        }
        m14014n();
    }

    public void playByPath(String str) {
        m14010j();
        if (str != null) {
            try {
                this.f20907h.add(new C3783j(this, str));
            } catch (Exception e) {
                CatchException.logException(e);
            }
        }
        m14014n();
    }

    public void release() {
        this.f20904e = true;
        m14018r();
        m14017q();
        m14019s();
        List<C3783j> list = this.f20907h;
        if (list != null) {
            list.clear();
        }
    }

    public void setListener(AudioPlayerListener audioPlayerListener) {
        this.f20906g = audioPlayerListener;
    }

    public void setOnEndListener() {
    }

    public void stop() {
        release();
    }

    /* renamed from: com.medio.audioplayer.AudioPlayer$j */
    private class C3783j {

        /* renamed from: a */
        public int f20917a;

        /* renamed from: b */
        public boolean f20918b = false;

        /* renamed from: c */
        public String f20919c;

        public C3783j(AudioPlayer audioPlayer, int i, String str) {
            this.f20917a = i;
        }

        public C3783j(AudioPlayer audioPlayer, String str) {
            this.f20919c = str;
        }
    }

    public void playByName(String str, String str2, boolean z, boolean z2, String str3) {
        m14010j();
        if (!z) {
            if (str != null) {
                try {
                    this.f20907h.add(new C3783j(this, m14008h(str), str));
                } catch (Exception e) {
                    CatchException.logException(e);
                }
            }
            if (str2 != null) {
                this.f20907h.add(new C3783j(this, m14008h(str2), str2));
            }
        }
        if (z2) {
            if (str != null) {
                if (!str.contains("l_")) {
                    this.f20907h.add(new C3783j(this, m14008h(str), str));
                } else {
                    this.f20907h.add(new C3783j(this, m14007g(str, str3)));
                }
            }
            if (str2 != null) {
                if (!str2.contains("l_")) {
                    this.f20907h.add(new C3783j(this, m14008h(str2), str2));
                } else {
                    this.f20907h.add(new C3783j(this, m14007g(str2, str3)));
                }
            }
        } else {
            if (str != null && !str.contains("l_")) {
                this.f20907h.add(new C3783j(this, m14008h(str), str));
            }
            if (str2 != null && !str2.contains("l_")) {
                this.f20907h.add(new C3783j(this, m14008h(str2), str2));
            }
        }
        m14014n();
    }
}
