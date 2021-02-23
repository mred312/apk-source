package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* renamed from: androidx.appcompat.widget.h */
/* compiled from: AppCompatTextClassifierHelper */
final class C0323h {
    @NonNull

    /* renamed from: a */
    private TextView f1636a;
    @Nullable

    /* renamed from: b */
    private TextClassifier f1637b;

    C0323h(@NonNull TextView textView) {
        this.f1636a = (TextView) Preconditions.checkNotNull(textView);
    }

    @RequiresApi(api = 26)
    @NonNull
    /* renamed from: a */
    public TextClassifier mo2969a() {
        TextClassifier textClassifier = this.f1637b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1636a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }

    @RequiresApi(api = 26)
    /* renamed from: b */
    public void mo2970b(@Nullable TextClassifier textClassifier) {
        this.f1637b = textClassifier;
    }
}
