package org.xiph.vorbis.decoder;

public interface DecodeFeed {
    public static final int CORRUPT_SECONDARY_HEADER = -25;
    public static final int ERROR_READING_FIRST_PAGE = -22;
    public static final int ERROR_READING_INITIAL_HEADER_PACKET = -23;
    public static final int INVALID_OGG_BITSTREAM = -21;
    public static final int NOT_VORBIS_HEADER = -24;
    public static final int PREMATURE_END_OF_FILE = -26;
    public static final int SUCCESS = 0;

    int readVorbisData(byte[] bArr, int i);

    void start(DecodeStreamInfo decodeStreamInfo);

    void startReadingHeader();

    void stop();

    void writePCMData(short[] sArr, int i);
}
