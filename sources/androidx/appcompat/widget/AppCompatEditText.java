package androidx.appcompat.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.RichContentReceiverCompat;
import androidx.core.widget.TextViewCompat;

public class AppCompatEditText extends EditText implements TintableBackgroundView {

    /* renamed from: a */
    private final C0317b f1200a;

    /* renamed from: b */
    private final C0324i f1201b;

    /* renamed from: c */
    private final C0323h f1202c;
    @Nullable

    /* renamed from: d */
    private RichContentReceiverCompat<TextView> f1203d;

    public AppCompatEditText(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            bVar.mo2943b();
        }
        C0324i iVar = this.f1201b;
        if (iVar != null) {
            iVar.mo2971b();
        }
    }

    @Nullable
    public RichContentReceiverCompat<TextView> getRichContentReceiverCompat() {
        return this.f1203d;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            return bVar.mo2944c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            return bVar.mo2945d();
        }
        return null;
    }

    @RequiresApi(api = 26)
    @NonNull
    public TextClassifier getTextClassifier() {
        C0323h hVar;
        if (Build.VERSION.SDK_INT >= 28 || (hVar = this.f1202c) == null) {
            return super.getTextClassifier();
        }
        return hVar.mo2969a();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        RichContentReceiverCompat<TextView> richContentReceiverCompat;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0319d.m1045a(onCreateInputConnection, editorInfo, this);
        if (onCreateInputConnection == null || (richContentReceiverCompat = this.f1203d) == null) {
            return onCreateInputConnection;
        }
        richContentReceiverCompat.populateEditorInfoContentMimeTypes(onCreateInputConnection, editorInfo);
        return InputConnectionCompat.createWrapper(onCreateInputConnection, editorInfo, this.f1203d.buildOnCommitContentListener(this));
    }

    public boolean onTextContextMenuItem(int i) {
        ClipData clipData;
        if (this.f1203d == null) {
            return super.onTextContextMenuItem(i);
        }
        if (i != 16908322 && i != 16908337) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            clipData = null;
        } else {
            clipData = clipboardManager.getPrimaryClip();
        }
        if (clipData != null) {
            this.f1203d.onReceive(this, clipData, 0, i == 16908322 ? 0 : 1);
        }
        return true;
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            bVar.mo2947f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            bVar.mo2948g(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setRichContentReceiverCompat(@Nullable RichContentReceiverCompat<TextView> richContentReceiverCompat) {
        this.f1203d = richContentReceiverCompat;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            bVar.mo2950i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0317b bVar = this.f1200a;
        if (bVar != null) {
            bVar.mo2951j(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0324i iVar = this.f1201b;
        if (iVar != null) {
            iVar.mo2985q(context, i);
        }
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        C0323h hVar;
        if (Build.VERSION.SDK_INT >= 28 || (hVar = this.f1202c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            hVar.mo2970b(textClassifier);
        }
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.editTextStyle);
    }

    @Nullable
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        C0317b bVar = new C0317b(this);
        this.f1200a = bVar;
        bVar.mo2946e(attributeSet, i);
        C0324i iVar = new C0324i(this);
        this.f1201b = iVar;
        iVar.mo2981m(attributeSet, i);
        iVar.mo2971b();
        this.f1202c = new C0323h(this);
    }
}
