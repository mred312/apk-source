package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new C0128a();
    @NonNull

    /* renamed from: a */
    private final IntentSender f327a;
    @Nullable

    /* renamed from: b */
    private final Intent f328b;

    /* renamed from: c */
    private final int f329c;

    /* renamed from: d */
    private final int f330d;

    /* renamed from: androidx.activity.result.IntentSenderRequest$a */
    class C0128a implements Parcelable.Creator<IntentSenderRequest> {
        C0128a() {
        }

        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    }

    IntentSenderRequest(@NonNull IntentSender intentSender, @Nullable Intent intent, int i, int i2) {
        this.f327a = intentSender;
        this.f328b = intent;
        this.f329c = i;
        this.f330d = i2;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getFillInIntent() {
        return this.f328b;
    }

    public int getFlagsMask() {
        return this.f329c;
    }

    public int getFlagsValues() {
        return this.f330d;
    }

    @NonNull
    public IntentSender getIntentSender() {
        return this.f327a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.f327a, i);
        parcel.writeParcelable(this.f328b, i);
        parcel.writeInt(this.f329c);
        parcel.writeInt(this.f330d);
    }

    public static final class Builder {

        /* renamed from: a */
        private IntentSender f331a;

        /* renamed from: b */
        private Intent f332b;

        /* renamed from: c */
        private int f333c;

        /* renamed from: d */
        private int f334d;

        public Builder(@NonNull IntentSender intentSender) {
            this.f331a = intentSender;
        }

        @NonNull
        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.f331a, this.f332b, this.f333c, this.f334d);
        }

        @NonNull
        public Builder setFillInIntent(@Nullable Intent intent) {
            this.f332b = intent;
            return this;
        }

        @NonNull
        public Builder setFlags(int i, int i2) {
            this.f334d = i;
            this.f333c = i2;
            return this;
        }

        public Builder(@NonNull PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }
    }

    IntentSenderRequest(@NonNull Parcel parcel) {
        this.f327a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f328b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f329c = parcel.readInt();
        this.f330d = parcel.readInt();
    }
}
