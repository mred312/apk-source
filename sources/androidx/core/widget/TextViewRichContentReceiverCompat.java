package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;

public abstract class TextViewRichContentReceiverCompat extends RichContentReceiverCompat<TextView> {

    /* renamed from: a */
    private static final Set<String> f2830a = Collections.singleton("text/*");

    @NonNull
    public Set<String> getSupportedMimeTypes() {
        return f2830a;
    }

    public boolean onReceive(@NonNull TextView textView, @NonNull ClipData clipData, int i, int i2) {
        CharSequence charSequence;
        if (i == 1 && !supports(clipData.getDescription())) {
            return false;
        }
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
            if ((i2 & 1) != 0) {
                charSequence = clipData.getItemAt(i3).coerceToText(context);
                if (charSequence instanceof Spanned) {
                    charSequence = charSequence.toString();
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                charSequence = clipData.getItemAt(i3).coerceToStyledText(context);
            } else {
                charSequence = clipData.getItemAt(i3).coerceToText(context);
            }
            if (charSequence != null) {
                if (!z) {
                    int selectionStart = Selection.getSelectionStart(editable);
                    int selectionEnd = Selection.getSelectionEnd(editable);
                    int max = Math.max(0, Math.min(selectionStart, selectionEnd));
                    int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
                    Selection.setSelection(editable, max2);
                    editable.replace(max, max2, charSequence);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequence);
                }
            }
        }
        return z;
    }
}
