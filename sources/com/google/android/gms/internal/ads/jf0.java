package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class jf0 {

    /* renamed from: A */
    private static final int f9481A = zzpt.zzbh("sosn");

    /* renamed from: B */
    private static final int f9482B = zzpt.zzbh("tvsh");

    /* renamed from: C */
    private static final int f9483C = zzpt.zzbh("----");

    /* renamed from: D */
    private static final String[] f9484D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    /* renamed from: a */
    private static final int f9485a = zzpt.zzbh("nam");

    /* renamed from: b */
    private static final int f9486b = zzpt.zzbh("trk");

    /* renamed from: c */
    private static final int f9487c = zzpt.zzbh("cmt");

    /* renamed from: d */
    private static final int f9488d = zzpt.zzbh("day");

    /* renamed from: e */
    private static final int f9489e = zzpt.zzbh("ART");

    /* renamed from: f */
    private static final int f9490f = zzpt.zzbh("too");

    /* renamed from: g */
    private static final int f9491g = zzpt.zzbh("alb");

    /* renamed from: h */
    private static final int f9492h = zzpt.zzbh("com");

    /* renamed from: i */
    private static final int f9493i = zzpt.zzbh("wrt");

    /* renamed from: j */
    private static final int f9494j = zzpt.zzbh("lyr");

    /* renamed from: k */
    private static final int f9495k = zzpt.zzbh("gen");

    /* renamed from: l */
    private static final int f9496l = zzpt.zzbh("covr");

    /* renamed from: m */
    private static final int f9497m = zzpt.zzbh("gnre");

    /* renamed from: n */
    private static final int f9498n = zzpt.zzbh("grp");

    /* renamed from: o */
    private static final int f9499o = zzpt.zzbh("disk");

    /* renamed from: p */
    private static final int f9500p = zzpt.zzbh("trkn");

    /* renamed from: q */
    private static final int f9501q = zzpt.zzbh("tmpo");

    /* renamed from: r */
    private static final int f9502r = zzpt.zzbh("cpil");

    /* renamed from: s */
    private static final int f9503s = zzpt.zzbh("aART");

    /* renamed from: t */
    private static final int f9504t = zzpt.zzbh("sonm");

    /* renamed from: u */
    private static final int f9505u = zzpt.zzbh("soal");

    /* renamed from: v */
    private static final int f9506v = zzpt.zzbh("soar");

    /* renamed from: w */
    private static final int f9507w = zzpt.zzbh("soaa");

    /* renamed from: x */
    private static final int f9508x = zzpt.zzbh("soco");

    /* renamed from: y */
    private static final int f9509y = zzpt.zzbh("rtng");

    /* renamed from: z */
    private static final int f9510z = zzpt.zzbh("pgap");

    /* renamed from: a */
    private static zzmk m6359a(int i, String str, zzpn zzpn, boolean z, boolean z2) {
        int e = m6363e(zzpn);
        if (z2) {
            e = Math.min(1, e);
        }
        if (e < 0) {
            String valueOf = String.valueOf(ue0.m7043c(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new zzmn(str, (String) null, Integer.toString(e));
        } else {
            return new zzmj("und", str, Integer.toString(e));
        }
    }

    /* renamed from: b */
    private static zzmn m6360b(int i, String str, zzpn zzpn) {
        int readInt = zzpn.readInt();
        if (zzpn.readInt() == ue0.f11337F0) {
            zzpn.zzbm(8);
            return new zzmn(str, (String) null, zzpn.zzbn(readInt - 16));
        }
        String valueOf = String.valueOf(ue0.m7043c(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    /* renamed from: c */
    private static zzmn m6361c(int i, String str, zzpn zzpn) {
        int readInt = zzpn.readInt();
        if (zzpn.readInt() == ue0.f11337F0 && readInt >= 22) {
            zzpn.zzbm(10);
            int readUnsignedShort = zzpn.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpn.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmn(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(ue0.m7043c(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a A[Catch:{ all -> 0x02bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041 A[Catch:{ all -> 0x02bf }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzmd.zza m6362d(com.google.android.gms.internal.ads.zzpn r14) {
        /*
            int r0 = r14.getPosition()
            int r1 = r14.readInt()
            int r0 = r0 + r1
            int r1 = r14.readInt()
            int r2 = r1 >>> 24
            r3 = 169(0xa9, float:2.37E-43)
            java.lang.String r4 = "und"
            java.lang.String r5 = "TCON"
            r6 = 16
            java.lang.String r7 = "MetadataUtil"
            r8 = 0
            if (r2 == r3) goto L_0x01d1
            r3 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r3) goto L_0x0023
            goto L_0x01d1
        L_0x0023:
            int r2 = f9497m     // Catch:{ all -> 0x02bf }
            r3 = 1
            if (r1 != r2) goto L_0x004a
            int r1 = m6363e(r14)     // Catch:{ all -> 0x02bf }
            if (r1 <= 0) goto L_0x0037
            java.lang.String[] r2 = f9484D     // Catch:{ all -> 0x02bf }
            int r4 = r2.length     // Catch:{ all -> 0x02bf }
            if (r1 > r4) goto L_0x0037
            int r1 = r1 - r3
            r1 = r2[r1]     // Catch:{ all -> 0x02bf }
            goto L_0x0038
        L_0x0037:
            r1 = r8
        L_0x0038:
            if (r1 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzmn r2 = new com.google.android.gms.internal.ads.zzmn     // Catch:{ all -> 0x02bf }
            r2.<init>(r5, r8, r1)     // Catch:{ all -> 0x02bf }
            r8 = r2
            goto L_0x0046
        L_0x0041:
            java.lang.String r1 = "Failed to parse standard genre code"
            android.util.Log.w(r7, r1)     // Catch:{ all -> 0x02bf }
        L_0x0046:
            r14.zzbl(r0)
            return r8
        L_0x004a:
            int r2 = f9499o     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0058
            java.lang.String r2 = "TPOS"
            com.google.android.gms.internal.ads.zzmn r1 = m6361c(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0058:
            int r2 = f9500p     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0066
            java.lang.String r2 = "TRCK"
            com.google.android.gms.internal.ads.zzmn r1 = m6361c(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0066:
            int r2 = f9501q     // Catch:{ all -> 0x02bf }
            r5 = 0
            if (r1 != r2) goto L_0x0075
            java.lang.String r2 = "TBPM"
            com.google.android.gms.internal.ads.zzmk r1 = m6359a(r1, r2, r14, r3, r5)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0075:
            int r2 = f9502r     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0083
            java.lang.String r2 = "TCMP"
            com.google.android.gms.internal.ads.zzmk r1 = m6359a(r1, r2, r14, r3, r3)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0083:
            int r2 = f9496l     // Catch:{ all -> 0x02bf }
            r9 = 4
            if (r1 != r2) goto L_0x00de
            int r1 = r14.readInt()     // Catch:{ all -> 0x02bf }
            int r2 = r14.readInt()     // Catch:{ all -> 0x02bf }
            int r3 = com.google.android.gms.internal.ads.ue0.f11337F0     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x00d5
            int r2 = r14.readInt()     // Catch:{ all -> 0x02bf }
            int r2 = com.google.android.gms.internal.ads.ue0.m7042b(r2)     // Catch:{ all -> 0x02bf }
            r3 = 13
            if (r2 != r3) goto L_0x00a3
            java.lang.String r3 = "image/jpeg"
            goto L_0x00ab
        L_0x00a3:
            r3 = 14
            if (r2 != r3) goto L_0x00aa
            java.lang.String r3 = "image/png"
            goto L_0x00ab
        L_0x00aa:
            r3 = r8
        L_0x00ab:
            if (r3 != 0) goto L_0x00c4
            r1 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02bf }
            r3.<init>(r1)     // Catch:{ all -> 0x02bf }
            java.lang.String r1 = "Unrecognized cover art flags: "
            r3.append(r1)     // Catch:{ all -> 0x02bf }
            r3.append(r2)     // Catch:{ all -> 0x02bf }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x02bf }
            android.util.Log.w(r7, r1)     // Catch:{ all -> 0x02bf }
            goto L_0x00da
        L_0x00c4:
            r14.zzbm(r9)     // Catch:{ all -> 0x02bf }
            int r1 = r1 - r6
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x02bf }
            r14.zze(r2, r5, r1)     // Catch:{ all -> 0x02bf }
            com.google.android.gms.internal.ads.zzmh r1 = new com.google.android.gms.internal.ads.zzmh     // Catch:{ all -> 0x02bf }
            r4 = 3
            r1.<init>(r3, r8, r4, r2)     // Catch:{ all -> 0x02bf }
            r8 = r1
            goto L_0x00da
        L_0x00d5:
            java.lang.String r1 = "Failed to parse cover art attribute"
            android.util.Log.w(r7, r1)     // Catch:{ all -> 0x02bf }
        L_0x00da:
            r14.zzbl(r0)
            return r8
        L_0x00de:
            int r2 = f9503s     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x00ec
            java.lang.String r2 = "TPE2"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x00ec:
            int r2 = f9504t     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x00fa
            java.lang.String r2 = "TSOT"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x00fa:
            int r2 = f9505u     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0108
            java.lang.String r2 = "TSO2"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0108:
            int r2 = f9506v     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0116
            java.lang.String r2 = "TSOA"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0116:
            int r2 = f9507w     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0124
            java.lang.String r2 = "TSOP"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0124:
            int r2 = f9508x     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0132
            java.lang.String r2 = "TSOC"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0132:
            int r2 = f9509y     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x0140
            java.lang.String r2 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzmk r1 = m6359a(r1, r2, r14, r5, r5)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0140:
            int r2 = f9510z     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x014e
            java.lang.String r2 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zzmk r1 = m6359a(r1, r2, r14, r5, r3)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x014e:
            int r2 = f9481A     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x015c
            java.lang.String r2 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x015c:
            int r2 = f9482B     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x016a
            java.lang.String r2 = "TVSHOW"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x016a:
            int r2 = f9483C     // Catch:{ all -> 0x02bf }
            if (r1 != r2) goto L_0x028a
            r1 = -1
            r2 = r8
            r3 = r2
            r5 = -1
            r7 = -1
        L_0x0173:
            int r10 = r14.getPosition()     // Catch:{ all -> 0x02bf }
            if (r10 >= r0) goto L_0x01aa
            int r10 = r14.getPosition()     // Catch:{ all -> 0x02bf }
            int r11 = r14.readInt()     // Catch:{ all -> 0x02bf }
            int r12 = r14.readInt()     // Catch:{ all -> 0x02bf }
            r14.zzbm(r9)     // Catch:{ all -> 0x02bf }
            int r13 = com.google.android.gms.internal.ads.ue0.f11333D0     // Catch:{ all -> 0x02bf }
            if (r12 != r13) goto L_0x0193
            int r11 = r11 + -12
            java.lang.String r2 = r14.zzbn(r11)     // Catch:{ all -> 0x02bf }
            goto L_0x0173
        L_0x0193:
            int r13 = com.google.android.gms.internal.ads.ue0.f11335E0     // Catch:{ all -> 0x02bf }
            if (r12 != r13) goto L_0x019e
            int r11 = r11 + -12
            java.lang.String r3 = r14.zzbn(r11)     // Catch:{ all -> 0x02bf }
            goto L_0x0173
        L_0x019e:
            int r13 = com.google.android.gms.internal.ads.ue0.f11337F0     // Catch:{ all -> 0x02bf }
            if (r12 != r13) goto L_0x01a4
            r5 = r10
            r7 = r11
        L_0x01a4:
            int r11 = r11 + -12
            r14.zzbm(r11)     // Catch:{ all -> 0x02bf }
            goto L_0x0173
        L_0x01aa:
            java.lang.String r9 = "com.apple.iTunes"
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x02bf }
            if (r2 == 0) goto L_0x01cd
            java.lang.String r2 = "iTunSMPB"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x02bf }
            if (r2 == 0) goto L_0x01cd
            if (r5 != r1) goto L_0x01bd
            goto L_0x01cd
        L_0x01bd:
            r14.zzbl(r5)     // Catch:{ all -> 0x02bf }
            r14.zzbm(r6)     // Catch:{ all -> 0x02bf }
            int r7 = r7 - r6
            java.lang.String r1 = r14.zzbn(r7)     // Catch:{ all -> 0x02bf }
            com.google.android.gms.internal.ads.zzmj r8 = new com.google.android.gms.internal.ads.zzmj     // Catch:{ all -> 0x02bf }
            r8.<init>(r4, r3, r1)     // Catch:{ all -> 0x02bf }
        L_0x01cd:
            r14.zzbl(r0)
            return r8
        L_0x01d1:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = f9487c     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0216
            int r2 = r14.readInt()     // Catch:{ all -> 0x02bf }
            int r3 = r14.readInt()     // Catch:{ all -> 0x02bf }
            int r5 = com.google.android.gms.internal.ads.ue0.f11337F0     // Catch:{ all -> 0x02bf }
            if (r3 != r5) goto L_0x01f5
            r1 = 8
            r14.zzbm(r1)     // Catch:{ all -> 0x02bf }
            int r2 = r2 - r6
            java.lang.String r1 = r14.zzbn(r2)     // Catch:{ all -> 0x02bf }
            com.google.android.gms.internal.ads.zzmj r8 = new com.google.android.gms.internal.ads.zzmj     // Catch:{ all -> 0x02bf }
            r8.<init>(r4, r1, r1)     // Catch:{ all -> 0x02bf }
            goto L_0x0212
        L_0x01f5:
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r1 = com.google.android.gms.internal.ads.ue0.m7043c(r1)     // Catch:{ all -> 0x02bf }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x02bf }
            int r3 = r1.length()     // Catch:{ all -> 0x02bf }
            if (r3 == 0) goto L_0x020a
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x02bf }
            goto L_0x020f
        L_0x020a:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x02bf }
            r1.<init>(r2)     // Catch:{ all -> 0x02bf }
        L_0x020f:
            android.util.Log.w(r7, r1)     // Catch:{ all -> 0x02bf }
        L_0x0212:
            r14.zzbl(r0)
            return r8
        L_0x0216:
            int r3 = f9485a     // Catch:{ all -> 0x02bf }
            if (r2 == r3) goto L_0x02b5
            int r3 = f9486b     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0220
            goto L_0x02b5
        L_0x0220:
            int r3 = f9492h     // Catch:{ all -> 0x02bf }
            if (r2 == r3) goto L_0x02ab
            int r3 = f9493i     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x022a
            goto L_0x02ab
        L_0x022a:
            int r3 = f9488d     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0238
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0238:
            int r3 = f9489e     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0246
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0246:
            int r3 = f9490f     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0254
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0254:
            int r3 = f9491g     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0262
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0262:
            int r3 = f9494j     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x0270
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x0270:
            int r3 = f9495k     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x027c
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r5, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x027c:
            int r3 = f9498n     // Catch:{ all -> 0x02bf }
            if (r2 != r3) goto L_0x028a
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x028a:
            java.lang.String r2 = "Skipped unknown metadata entry: "
            java.lang.String r1 = com.google.android.gms.internal.ads.ue0.m7043c(r1)     // Catch:{ all -> 0x02bf }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x02bf }
            int r3 = r1.length()     // Catch:{ all -> 0x02bf }
            if (r3 == 0) goto L_0x029f
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x02bf }
            goto L_0x02a4
        L_0x029f:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x02bf }
            r1.<init>(r2)     // Catch:{ all -> 0x02bf }
        L_0x02a4:
            android.util.Log.d(r7, r1)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r8
        L_0x02ab:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x02b5:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zzmn r1 = m6360b(r1, r2, r14)     // Catch:{ all -> 0x02bf }
            r14.zzbl(r0)
            return r1
        L_0x02bf:
            r1 = move-exception
            r14.zzbl(r0)
            goto L_0x02c5
        L_0x02c4:
            throw r1
        L_0x02c5:
            goto L_0x02c4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jf0.m6362d(com.google.android.gms.internal.ads.zzpn):com.google.android.gms.internal.ads.zzmd$zza");
    }

    /* renamed from: e */
    private static int m6363e(zzpn zzpn) {
        zzpn.zzbm(4);
        if (zzpn.readInt() == ue0.f11337F0) {
            zzpn.zzbm(8);
            return zzpn.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
