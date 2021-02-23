package androidx.core.widget;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import java.util.Set;

public abstract class RichContentReceiverCompat<T extends View> {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_CLIPBOARD = 0;
    public static final int SOURCE_INPUT_METHOD = 1;

    /* renamed from: androidx.core.widget.RichContentReceiverCompat$a */
    class C0578a implements InputConnectionCompat.OnCommitContentListener {

        /* renamed from: a */
        final /* synthetic */ View f2813a;

        C0578a(View view) {
            this.f2813a = view;
        }

        public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
            ClipDescription description = inputContentInfoCompat.getDescription();
            if ((i & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                } catch (Exception e) {
                    Log.w("RichContentReceiver", "Can't insert from IME; requestPermission() failed: " + e);
                    return false;
                }
            }
            return RichContentReceiverCompat.this.onReceive(this.f2813a, new ClipData(description, new ClipData.Item(inputContentInfoCompat.getContentUri())), 1, 0);
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final InputConnectionCompat.OnCommitContentListener buildOnCommitContentListener(@NonNull T t) {
        return new C0578a(t);
    }

    @NonNull
    public abstract Set<String> getSupportedMimeTypes();

    public abstract boolean onReceive(@NonNull T t, @NonNull ClipData clipData, int i, int i2);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void populateEditorInfoContentMimeTypes(@Nullable InputConnection inputConnection, @Nullable EditorInfo editorInfo) {
        if (inputConnection != null && editorInfo != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, (String[]) getSupportedMimeTypes().toArray(new String[0]));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean supports(@NonNull ClipDescription clipDescription) {
        for (String hasMimeType : getSupportedMimeTypes()) {
            if (clipDescription.hasMimeType(hasMimeType)) {
                return true;
            }
        }
        return false;
    }
}
