package com.dream_studio.animalsounds;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.KeyEvent;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.dream_studio.animalsounds.a */
/* compiled from: DownloadFileFromURL */
class C1466a extends AsyncTask<String, String, String> {

    /* renamed from: a */
    private ProgressDialog f6872a = null;

    /* renamed from: b */
    private String f6873b = null;

    /* renamed from: c */
    private Context f6874c = null;

    /* renamed from: d */
    private int f6875d;

    /* renamed from: e */
    private byte f6876e = 0;

    /* renamed from: com.dream_studio.animalsounds.a$a */
    /* compiled from: DownloadFileFromURL */
    class C1467a implements DialogInterface.OnKeyListener {
        C1467a() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            C1466a.this.cancel(true);
            return false;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.a$b */
    /* compiled from: DownloadFileFromURL */
    class C1468b implements DialogInterface.OnClickListener {
        C1468b() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C1466a.this.cancel(true);
        }
    }

    public C1466a(Context context, int i, byte b) {
        this.f6874c = context;
        this.f6875d = i;
        this.f6876e = b;
    }

    /* renamed from: a */
    private void m4942a() {
        ProgressDialog progressDialog = this.f6872a;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String doInBackground(String... strArr) {
        this.f6873b = strArr[1];
        try {
            URL url = new URL(strArr[0]);
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            long contentLength = (long) openConnection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream(), 8192);
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1] + strArr[2]);
            byte[] bArr = new byte[1024];
            long j = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (isCancelled()) {
                    break;
                } else {
                    j += (long) read;
                    publishProgress(new String[]{"" + ((int) ((100 * j) / contentLength))});
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            return strArr[1] + strArr[2];
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            m4942a();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(String str) {
        m4942a();
        if (str != null) {
            new C1473f(this.f6874c, this.f6875d, this.f6876e).execute(new String[]{str, this.f6873b});
            return;
        }
        ((MainActivity) this.f6874c).showErrorDialog(C1441R.string.operationFailed, true, this.f6875d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void onProgressUpdate(String... strArr) {
        ProgressDialog progressDialog = this.f6872a;
        if (progressDialog != null) {
            progressDialog.setProgress(Integer.parseInt(strArr[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        m4942a();
        ((MainActivity) this.f6874c).showErrorDialog(C1441R.string.operationAborted, false, 0);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        ProgressDialog progressDialog = new ProgressDialog(this.f6874c);
        this.f6872a = progressDialog;
        progressDialog.setMessage(this.f6874c.getString(C1441R.string.fileDownloading));
        this.f6872a.setIndeterminate(false);
        this.f6872a.setMax(100);
        this.f6872a.setProgressStyle(1);
        this.f6872a.setProgressDrawable(this.f6874c.getResources().getDrawable(C1441R.C1442drawable.custom_progress_bar));
        this.f6872a.setCancelable(false);
        this.f6872a.setOnKeyListener(new C1467a());
        this.f6872a.setButton(-2, this.f6874c.getString(C1441R.string.buttonCancel), new C1468b());
        this.f6872a.setOwnerActivity((Activity) this.f6874c);
        this.f6872a.show();
    }
}
