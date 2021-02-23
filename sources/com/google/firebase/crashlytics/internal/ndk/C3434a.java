package com.google.firebase.crashlytics.internal.ndk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.crashlytics.internal.ndk.a */
/* compiled from: BinaryImagesConverter */
class C3434a {

    /* renamed from: a */
    private final Context f19438a;

    /* renamed from: b */
    private final C3435a f19439b;

    /* renamed from: com.google.firebase.crashlytics.internal.ndk.a$a */
    /* compiled from: BinaryImagesConverter */
    interface C3435a {
        /* renamed from: a */
        String mo21394a(File file);
    }

    C3434a(Context context, C3435a aVar) {
        this.f19438a = context;
        this.f19439b = aVar;
    }

    @NonNull
    /* renamed from: b */
    private File m11598b(File file) {
        if (Build.VERSION.SDK_INT < 9 || !file.getAbsolutePath().startsWith("/data")) {
            return file;
        }
        try {
            return new File(this.f19438a.getPackageManager().getApplicationInfo(this.f19438a.getPackageName(), 0).nativeLibraryDir, file.getName());
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getLogger().mo20862e("Error getting ApplicationInfo", e);
            return file;
        }
    }

    @NonNull
    /* renamed from: c */
    private static JSONObject m11599c(String str, C3436b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", bVar.f19440a);
        jSONObject.put("size", bVar.f19441b);
        jSONObject.put("name", bVar.f19443d);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    @NonNull
    /* renamed from: d */
    private static byte[] m11600d(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
        } catch (JSONException e) {
            Logger.getLogger().mo20870w("Binary images string is null", e);
            return new byte[0];
        }
    }

    @NonNull
    /* renamed from: e */
    private File m11601e(String str) {
        File file = new File(str);
        return !file.exists() ? m11598b(file) : file;
    }

    /* renamed from: f */
    private static boolean m11602f(C3436b bVar) {
        return (bVar.f19442c.indexOf(120) == -1 || bVar.f19443d.indexOf(47) == -1) ? false : true;
    }

    @Nullable
    /* renamed from: g */
    private JSONObject m11603g(String str) {
        C3436b a = C3437c.m11607a(str);
        if (a != null && m11602f(a)) {
            try {
                try {
                    return m11599c(this.f19439b.mo21394a(m11601e(a.f19443d)), a);
                } catch (JSONException e) {
                    Logger.getLogger().mo20860d("Could not create a binary image json string", e);
                    return null;
                }
            } catch (IOException e2) {
                Logger logger = Logger.getLogger();
                logger.mo20860d("Could not generate ID for file " + a.f19443d, e2);
            }
        }
        return null;
    }

    @NonNull
    /* renamed from: h */
    private JSONArray m11604h(BufferedReader bufferedReader) {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return jSONArray;
            }
            JSONObject g = m11603g(readLine);
            if (g != null) {
                jSONArray.put(g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public byte[] mo21393a(BufferedReader bufferedReader) {
        return m11600d(m11604h(bufferedReader));
    }
}
