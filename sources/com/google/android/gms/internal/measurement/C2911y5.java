package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.y5 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2911y5 {
    /* renamed from: a */
    static String m10004a(zzgr zzgr) {
        C2726b6 b6Var = new C2726b6(zzgr);
        StringBuilder sb = new StringBuilder(b6Var.zza());
        for (int i = 0; i < b6Var.zza(); i++) {
            byte zza = b6Var.zza(i);
            if (zza == 34) {
                sb.append("\\\"");
            } else if (zza == 39) {
                sb.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
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
                        if (zza >= 32 && zza <= 126) {
                            sb.append((char) zza);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            sb.append((char) ((zza & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
