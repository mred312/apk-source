package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {

    /* renamed from: a */
    private static volatile boolean f6190a = true;

    private DrawableDecoderCompat() {
    }

    /* renamed from: a */
    private static Drawable m4573a(Context context, Context context2, @DrawableRes int i, @Nullable Resources.Theme theme) {
        try {
            if (f6190a) {
                return m4575c(context2, i, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f6190a = false;
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i);
            }
            throw e;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return m4574b(context2, i, theme);
    }

    /* renamed from: b */
    private static Drawable m4574b(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }

    /* renamed from: c */
    private static Drawable m4575c(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i);
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i) {
        return m4573a(context, context2, i, (Resources.Theme) null);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return m4573a(context, context, i, theme);
    }
}
