package com.google.protobuf;

/* renamed from: com.google.protobuf.q0 */
/* compiled from: TextFormatEscaper */
final class C3742q0 {

    /* renamed from: com.google.protobuf.q0$a */
    /* compiled from: TextFormatEscaper */
    static class C3743a implements C3744b {

        /* renamed from: a */
        final /* synthetic */ ByteString f20858a;

        C3743a(ByteString byteString) {
            this.f20858a = byteString;
        }

        /* renamed from: a */
        public byte mo23985a(int i) {
            return this.f20858a.byteAt(i);
        }

        public int size() {
            return this.f20858a.size();
        }
    }

    /* renamed from: com.google.protobuf.q0$b */
    /* compiled from: TextFormatEscaper */
    private interface C3744b {
        /* renamed from: a */
        byte mo23985a(int i);

        int size();
    }

    /* renamed from: a */
    static String m13627a(ByteString byteString) {
        return m13628b(new C3743a(byteString));
    }

    /* renamed from: b */
    static String m13628b(C3744b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i = 0; i < bVar.size(); i++) {
            byte a = bVar.mo23985a(i);
            if (a == 34) {
                sb.append("\\\"");
            } else if (a == 39) {
                sb.append("\\'");
            } else if (a != 92) {
                switch (a) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a >= 32 && a <= 126) {
                            sb.append((char) a);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a >>> 6) & 3) + 48));
                            sb.append((char) (((a >>> 3) & 7) + 48));
                            sb.append((char) ((a & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    static String m13629c(String str) {
        return m13627a(ByteString.copyFromUtf8(str));
    }
}
