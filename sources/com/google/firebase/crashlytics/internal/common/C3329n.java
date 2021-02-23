package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.firebase.crashlytics.internal.common.n */
/* compiled from: MetaDataStore */
class C3329n {

    /* renamed from: b */
    private static final Charset f19199b = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: a */
    private final File f19200a;

    /* renamed from: com.google.firebase.crashlytics.internal.common.n$a */
    /* compiled from: MetaDataStore */
    class C3330a extends JSONObject {

        /* renamed from: a */
        final /* synthetic */ UserMetadata f19201a;

        C3330a(UserMetadata userMetadata) {
            this.f19201a = userMetadata;
            put("userId", userMetadata.getUserId());
        }
    }

    public C3329n(File file) {
        this.f19200a = file;
    }

    /* renamed from: c */
    private static UserMetadata m11451c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        UserMetadata userMetadata = new UserMetadata();
        userMetadata.setUserId(m11454g(jSONObject, "userId"));
        return userMetadata;
    }

    /* renamed from: d */
    private static String m11452d(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    /* renamed from: f */
    private static String m11453f(UserMetadata userMetadata) {
        return new C3330a(userMetadata).toString();
    }

    /* renamed from: g */
    private static String m11454g(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, (String) null);
        }
        return null;
    }

    @NonNull
    /* renamed from: a */
    public File mo21034a(String str) {
        File file = this.f19200a;
        return new File(file, str + "keys" + ".meta");
    }

    @NonNull
    /* renamed from: b */
    public File mo21035b(String str) {
        File file = this.f19200a;
        return new File(file, str + "user" + ".meta");
    }

    /* renamed from: e */
    public UserMetadata mo21036e(String str) {
        File b = mo21035b(str);
        if (!b.exists()) {
            return new UserMetadata();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(b);
            try {
                UserMetadata c = m11451c(CommonUtils.streamToString(fileInputStream2));
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                return c;
            } catch (Exception e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    Logger.getLogger().mo20862e("Error deserializing user metadata.", e);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return new UserMetadata();
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Logger.getLogger().mo20862e("Error deserializing user metadata.", e);
            CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
            return new UserMetadata();
        }
    }

    /* renamed from: h */
    public void mo21037h(String str, Map<String, String> map) {
        File a = mo21034a(str);
        BufferedWriter bufferedWriter = null;
        try {
            String d = m11452d(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a), f19199b));
            try {
                bufferedWriter2.write(d);
                bufferedWriter2.flush();
                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close key/value metadata file.");
            } catch (Exception e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.getLogger().mo20862e("Error serializing key/value metadata.", e);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Logger.getLogger().mo20862e("Error serializing key/value metadata.", e);
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
        }
    }

    /* renamed from: i */
    public void mo21038i(String str, UserMetadata userMetadata) {
        File b = mo21035b(str);
        BufferedWriter bufferedWriter = null;
        try {
            String f = m11453f(userMetadata);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b), f19199b));
            try {
                bufferedWriter2.write(f);
                bufferedWriter2.flush();
                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
            } catch (Exception e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.getLogger().mo20862e("Error serializing user metadata.", e);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Logger.getLogger().mo20862e("Error serializing user metadata.", e);
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
        }
    }
}
