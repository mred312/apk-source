package org.xiph.vorbis.decoder;

public class VorbisDecoder {
    static {
        System.loadLibrary("ogg");
        System.loadLibrary("vorbis");
        System.loadLibrary("vorbis-jni");
    }

    public static native int startDecoding(DecodeFeed decodeFeed);
}
