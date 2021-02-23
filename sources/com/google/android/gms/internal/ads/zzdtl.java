package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdtl {

    /* renamed from: a */
    private final Context f15952a;

    /* renamed from: b */
    private final zzdsi f15953b;

    public zzdtl(@NonNull Context context, zzdsi zzdsi) {
        this.f15952a = context;
        this.f15953b = zzdsi;
    }

    /* renamed from: a */
    private final String m8505a() {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String value = zzdwd.OS_ARCH.value();
        if (!TextUtils.isEmpty(value) && hashSet.contains(value)) {
            return value;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzdsi zzdsi = this.f15953b;
            if (zzdsi != null) {
                zzdsi.zza(2024, 0, e);
            }
        } catch (IllegalAccessException e2) {
            zzdsi zzdsi2 = this.f15953b;
            if (zzdsi2 != null) {
                zzdsi2.zza(2024, 0, e2);
            }
        }
        String str = Build.CPU_ABI;
        if (str != null) {
            return str;
        }
        return Build.CPU_ABI2;
    }

    /* renamed from: b */
    private final zzgn m8506b() {
        FileInputStream fileInputStream;
        File file = new File(new File(this.f15952a.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzdsi zzdsi = this.f15953b;
            if (zzdsi != null) {
                zzdsi.zzg(5017, "No lib/");
            }
            return zzgn.UNKNOWN;
        }
        File[] listFiles = file.listFiles(new zzdxl(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            zzdsi zzdsi2 = this.f15953b;
            if (zzdsi2 != null) {
                zzdsi2.zzg(5017, "No .so");
            }
            return zzgn.UNKNOWN;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            byte[] bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
                byte[] bArr2 = {0, 0};
                if (bArr[5] == 2) {
                    m8507c(bArr, (String) null);
                    zzgn zzgn = zzgn.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgn;
                }
                bArr2[0] = bArr[19];
                bArr2[1] = bArr[18];
                short s = ByteBuffer.wrap(bArr2).getShort();
                if (s == 3) {
                    zzgn zzgn2 = zzgn.X86;
                    fileInputStream.close();
                    return zzgn2;
                } else if (s == 40) {
                    zzgn zzgn3 = zzgn.ARM7;
                    fileInputStream.close();
                    return zzgn3;
                } else if (s == 62) {
                    zzgn zzgn4 = zzgn.X86_64;
                    fileInputStream.close();
                    return zzgn4;
                } else if (s != 183) {
                    m8507c(bArr, (String) null);
                    zzgn zzgn5 = zzgn.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgn5;
                } else {
                    zzgn zzgn6 = zzgn.ARM64;
                    fileInputStream.close();
                    return zzgn6;
                }
            } else {
                fileInputStream.close();
                return zzgn.UNSUPPORTED;
            }
        } catch (IOException e) {
            m8507c((byte[]) null, e.toString());
        } catch (Throwable th) {
            zzeid.zza(th, th);
        }
        throw th;
    }

    /* renamed from: c */
    private final void m8507c(byte[] bArr, String str) {
        if (this.f15953b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("os.arch:");
            sb.append(zzdwd.OS_ARCH.value());
            sb.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
                if (strArr != null) {
                    sb.append("supported_abis:");
                    sb.append(Arrays.toString(strArr));
                    sb.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            sb.append("CPU_ABI:");
            sb.append(Build.CPU_ABI);
            sb.append(";");
            sb.append("CPU_ABI2:");
            sb.append(Build.CPU_ABI2);
            sb.append(";");
            if (bArr != null) {
                sb.append("ELF:");
                sb.append(Arrays.toString(bArr));
                sb.append(";");
            }
            if (str != null) {
                sb.append("dbg:");
                sb.append(str);
                sb.append(";");
            }
            this.f15953b.zzg(4007, sb.toString());
        }
    }

    public static boolean zza(zzgn zzgn) {
        int i = d10.f8043a[zzgn.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public final zzgn zzaxp() {
        zzgn b = m8506b();
        if (b == zzgn.UNKNOWN) {
            String a = m8505a();
            if (TextUtils.isEmpty(a)) {
                m8507c((byte[]) null, "Empty dev arch");
                b = zzgn.UNSUPPORTED;
            } else if (a.equalsIgnoreCase("i686") || a.equalsIgnoreCase("x86")) {
                b = zzgn.X86;
            } else if (a.equalsIgnoreCase("x86_64")) {
                b = zzgn.X86_64;
            } else if (a.equalsIgnoreCase("arm64-v8a")) {
                b = zzgn.ARM64;
            } else if (a.equalsIgnoreCase("armeabi-v7a") || a.equalsIgnoreCase("armv71")) {
                b = zzgn.ARM7;
            } else {
                m8507c((byte[]) null, a);
                b = zzgn.UNSUPPORTED;
            }
        }
        zzdsi zzdsi = this.f15953b;
        if (zzdsi != null) {
            zzdsi.zzg(5018, b.name());
        }
        return b;
    }
}
