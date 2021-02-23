package com.dream_studio.animalsounds;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.dream_studio.animalsounds.f */
/* compiled from: UnzipFile */
class C1473f extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private Context f6886a = null;

    /* renamed from: b */
    private ProgressDialog f6887b = null;

    /* renamed from: c */
    private int f6888c;

    /* renamed from: d */
    private byte f6889d = 0;

    /* renamed from: com.dream_studio.animalsounds.f$a */
    /* compiled from: UnzipFile */
    class C1474a implements DialogInterface.OnKeyListener {
        C1474a() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            C1473f.this.cancel(true);
            return false;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.f$b */
    /* compiled from: UnzipFile */
    class C1475b implements DialogInterface.OnClickListener {
        C1475b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C1473f.this.cancel(true);
        }
    }

    public C1473f(Context context, int i, byte b) {
        this.f6886a = context;
        this.f6888c = i;
        this.f6889d = b;
    }

    /* renamed from: a */
    private void m4949a() {
        ProgressDialog progressDialog = this.f6887b;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String doInBackground(String... strArr) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(strArr[0]);
            File file2 = new File(strArr[1]);
            long length = file.length();
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                byte[] bArr = new byte[8192];
                long j = 0;
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        File file3 = new File(file2, nextEntry.getName());
                        File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                        if (!parentFile.isDirectory()) {
                            if (!parentFile.mkdirs()) {
                                throw new FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                            }
                        }
                        if (!nextEntry.isDirectory()) {
                            fileOutputStream = new FileOutputStream(file3);
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                j += (long) read;
                                fileOutputStream.write(bArr, 0, read);
                                publishProgress(new String[]{"" + ((int) ((100 * j) / length))});
                            }
                            fileOutputStream.close();
                            if (isCancelled()) {
                                break;
                            }
                        }
                    }
                }
                zipInputStream.close();
                file.delete();
                return "Ok";
            } catch (Throwable th) {
                zipInputStream.close();
                throw th;
            }
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            m4949a();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(String str) {
        m4949a();
        if (str != null) {
            ((MainActivity) this.f6886a).setPronunStatusSharedPreferences(this.f6889d);
            if (this.f6888c == 1) {
                ((MainActivity) this.f6886a).showTalkOptionDialog();
                return;
            }
            return;
        }
        ((MainActivity) this.f6886a).showErrorDialog(C1441R.string.operationFailed, true, this.f6888c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void onProgressUpdate(String... strArr) {
        ProgressDialog progressDialog = this.f6887b;
        if (progressDialog != null) {
            progressDialog.setProgress(Integer.parseInt(strArr[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        m4949a();
        ((MainActivity) this.f6886a).showErrorDialog(C1441R.string.operationAborted, false, 0);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        ProgressDialog progressDialog = new ProgressDialog(this.f6886a);
        this.f6887b = progressDialog;
        progressDialog.setMessage(this.f6886a.getString(C1441R.string.fileUnpacking));
        this.f6887b.setIndeterminate(false);
        this.f6887b.setMax(100);
        this.f6887b.setProgressStyle(1);
        this.f6887b.setProgressDrawable(this.f6886a.getResources().getDrawable(C1441R.C1442drawable.custom_progress_bar));
        this.f6887b.setCancelable(false);
        this.f6887b.setOnKeyListener(new C1474a());
        this.f6887b.setButton(-2, this.f6886a.getString(C1441R.string.buttonCancel), new C1475b());
        this.f6887b.setOwnerActivity((Activity) this.f6886a);
        this.f6887b.show();
    }
}
