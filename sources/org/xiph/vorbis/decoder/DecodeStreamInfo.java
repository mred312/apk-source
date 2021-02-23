package org.xiph.vorbis.decoder;

public class DecodeStreamInfo {

    /* renamed from: a */
    private long f21395a;

    /* renamed from: b */
    private long f21396b;

    /* renamed from: c */
    private String f21397c;

    public DecodeStreamInfo(long j, long j2, String str) {
        this.f21395a = j;
        this.f21396b = j2;
        this.f21397c = str;
    }

    public long getChannels() {
        return this.f21396b;
    }

    public long getSampleRate() {
        return this.f21395a;
    }

    public String getVendor() {
        return this.f21397c;
    }

    public void setChannels(long j) {
        this.f21396b = j;
    }

    public void setSampleRate(long j) {
        this.f21395a = j;
    }

    public void setVendor(String str) {
        this.f21397c = str;
    }
}
