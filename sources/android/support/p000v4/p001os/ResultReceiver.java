package android.support.p000v4.p001os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.p000v4.p001os.IResultReceiver;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: android.support.v4.os.ResultReceiver */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new C0107a();

    /* renamed from: a */
    final boolean f260a;

    /* renamed from: b */
    final Handler f261b;

    /* renamed from: c */
    IResultReceiver f262c;

    /* renamed from: android.support.v4.os.ResultReceiver$a */
    class C0107a implements Parcelable.Creator<ResultReceiver> {
        C0107a() {
        }

        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: b */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$b */
    class C0108b extends IResultReceiver.Stub {
        C0108b() {
        }

        public void send(int i, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f261b;
            if (handler != null) {
                handler.post(new C0109c(i, bundle));
            } else {
                resultReceiver.onReceiveResult(i, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$c */
    class C0109c implements Runnable {

        /* renamed from: a */
        final int f264a;

        /* renamed from: b */
        final Bundle f265b;

        C0109c(int i, Bundle bundle) {
            this.f264a = i;
            this.f265b = bundle;
        }

        public void run() {
            ResultReceiver.this.onReceiveResult(this.f264a, this.f265b);
        }
    }

    public ResultReceiver(Handler handler) {
        this.f260a = true;
        this.f261b = handler;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
    }

    public void send(int i, Bundle bundle) {
        if (this.f260a) {
            Handler handler = this.f261b;
            if (handler != null) {
                handler.post(new C0109c(i, bundle));
            } else {
                onReceiveResult(i, bundle);
            }
        } else {
            IResultReceiver iResultReceiver = this.f262c;
            if (iResultReceiver != null) {
                try {
                    iResultReceiver.send(i, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f262c == null) {
                this.f262c = new C0108b();
            }
            parcel.writeStrongBinder(this.f262c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f260a = false;
        this.f261b = null;
        this.f262c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
}
