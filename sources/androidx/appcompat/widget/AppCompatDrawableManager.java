package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AppCompatDrawableManager {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final PorterDuff.Mode f1191b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    private static AppCompatDrawableManager f1192c;

    /* renamed from: a */
    private ResourceManagerInternal f1193a;

    /* renamed from: androidx.appcompat.widget.AppCompatDrawableManager$a */
    class C0257a implements ResourceManagerInternal.C0286f {

        /* renamed from: a */
        private final int[] f1194a = {C0131R.C0132drawable.abc_textfield_search_default_mtrl_alpha, C0131R.C0132drawable.abc_textfield_default_mtrl_alpha, C0131R.C0132drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b */
        private final int[] f1195b = {C0131R.C0132drawable.abc_ic_commit_search_api_mtrl_alpha, C0131R.C0132drawable.abc_seekbar_tick_mark_material, C0131R.C0132drawable.abc_ic_menu_share_mtrl_alpha, C0131R.C0132drawable.abc_ic_menu_copy_mtrl_am_alpha, C0131R.C0132drawable.abc_ic_menu_cut_mtrl_alpha, C0131R.C0132drawable.abc_ic_menu_selectall_mtrl_alpha, C0131R.C0132drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c */
        private final int[] f1196c = {C0131R.C0132drawable.abc_textfield_activated_mtrl_alpha, C0131R.C0132drawable.abc_textfield_search_activated_mtrl_alpha, C0131R.C0132drawable.abc_cab_background_top_mtrl_alpha, C0131R.C0132drawable.abc_text_cursor_material, C0131R.C0132drawable.abc_text_select_handle_left_mtrl, C0131R.C0132drawable.abc_text_select_handle_middle_mtrl, C0131R.C0132drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d */
        private final int[] f1197d = {C0131R.C0132drawable.abc_popup_background_mtrl_mult, C0131R.C0132drawable.abc_cab_background_internal_bg, C0131R.C0132drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e */
        private final int[] f1198e = {C0131R.C0132drawable.abc_tab_indicator_material, C0131R.C0132drawable.abc_textfield_search_material};

        /* renamed from: f */
        private final int[] f1199f = {C0131R.C0132drawable.abc_btn_check_material, C0131R.C0132drawable.abc_btn_radio_material, C0131R.C0132drawable.abc_btn_check_material_anim, C0131R.C0132drawable.abc_btn_radio_material_anim};

        C0257a() {
        }

        /* renamed from: f */
        private boolean m808f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: g */
        private ColorStateList m809g(@NonNull Context context) {
            return m810h(context, 0);
        }

        /* renamed from: h */
        private ColorStateList m810h(@NonNull Context context, @ColorInt int i) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0131R.attr.colorControlHighlight);
            int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, C0131R.attr.colorButtonNormal);
            return new ColorStateList(new int[][]{ThemeUtils.f1515b, ThemeUtils.f1517d, ThemeUtils.f1516c, ThemeUtils.f1519f}, new int[]{disabledThemeAttrColor, ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        /* renamed from: i */
        private ColorStateList m811i(@NonNull Context context) {
            return m810h(context, ThemeUtils.getThemeAttrColor(context, C0131R.attr.colorAccent));
        }

        /* renamed from: j */
        private ColorStateList m812j(@NonNull Context context) {
            return m810h(context, ThemeUtils.getThemeAttrColor(context, C0131R.attr.colorButtonNormal));
        }

        /* renamed from: k */
        private ColorStateList m813k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i = C0131R.attr.colorSwitchThumbNormal;
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, i);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = ThemeUtils.f1515b;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, i);
                iArr[1] = ThemeUtils.f1518e;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0131R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.f1519f;
                iArr2[2] = ThemeUtils.getThemeAttrColor(context, i);
            } else {
                iArr[0] = ThemeUtils.f1515b;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                iArr[1] = ThemeUtils.f1518e;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0131R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.f1519f;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        /* renamed from: l */
        private LayerDrawable m814l(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DimenRes int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawable = resourceManagerInternal.getDrawable(context, C0131R.C0132drawable.abc_star_black_48dp);
            Drawable drawable2 = resourceManagerInternal.getDrawable(context, C0131R.C0132drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) drawable;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        /* renamed from: m */
        private void m815m(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = AppCompatDrawableManager.f1191b;
            }
            drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo2207a(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.f1191b
                int[] r1 = r6.f1194a
                boolean r1 = r6.m808f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = androidx.appcompat.C0131R.attr.colorControlNormal
            L_0x0014:
                r8 = -1
            L_0x0015:
                r1 = 1
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f1196c
                boolean r1 = r6.m808f(r1, r8)
                if (r1 == 0) goto L_0x0022
                int r2 = androidx.appcompat.C0131R.attr.colorControlActivated
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f1197d
                boolean r1 = r6.m808f(r1, r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = androidx.appcompat.C0131R.C0132drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = androidx.appcompat.C0131R.C0132drawable.abc_dialog_material_background
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = -1
                r1 = 0
                r2 = 0
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.C0257a.mo2207a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        /* renamed from: b */
        public PorterDuff.Mode mo2208b(int i) {
            if (i == C0131R.C0132drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        /* renamed from: c */
        public Drawable mo2209c(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i) {
            if (i == C0131R.C0132drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, C0131R.C0132drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, C0131R.C0132drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == C0131R.C0132drawable.abc_ratingbar_material) {
                return m814l(resourceManagerInternal, context, C0131R.dimen.abc_star_big);
            } else {
                if (i == C0131R.C0132drawable.abc_ratingbar_indicator_material) {
                    return m814l(resourceManagerInternal, context, C0131R.dimen.abc_star_medium);
                }
                if (i == C0131R.C0132drawable.abc_ratingbar_small_material) {
                    return m814l(resourceManagerInternal, context, C0131R.dimen.abc_star_small);
                }
                return null;
            }
        }

        /* renamed from: d */
        public ColorStateList mo2210d(@NonNull Context context, int i) {
            if (i == C0131R.C0132drawable.abc_edit_text_material) {
                return AppCompatResources.getColorStateList(context, C0131R.color.abc_tint_edittext);
            }
            if (i == C0131R.C0132drawable.abc_switch_track_mtrl_alpha) {
                return AppCompatResources.getColorStateList(context, C0131R.color.abc_tint_switch_track);
            }
            if (i == C0131R.C0132drawable.abc_switch_thumb_material) {
                return m813k(context);
            }
            if (i == C0131R.C0132drawable.abc_btn_default_mtrl_shape) {
                return m812j(context);
            }
            if (i == C0131R.C0132drawable.abc_btn_borderless_material) {
                return m809g(context);
            }
            if (i == C0131R.C0132drawable.abc_btn_colored_material) {
                return m811i(context);
            }
            if (i == C0131R.C0132drawable.abc_spinner_mtrl_am_alpha || i == C0131R.C0132drawable.abc_spinner_textfield_background_material) {
                return AppCompatResources.getColorStateList(context, C0131R.color.abc_tint_spinner);
            }
            if (m808f(this.f1195b, i)) {
                return ThemeUtils.getThemeAttrColorStateList(context, C0131R.attr.colorControlNormal);
            }
            if (m808f(this.f1198e, i)) {
                return AppCompatResources.getColorStateList(context, C0131R.color.abc_tint_default);
            }
            if (m808f(this.f1199f, i)) {
                return AppCompatResources.getColorStateList(context, C0131R.color.abc_tint_btn_checkable);
            }
            if (i == C0131R.C0132drawable.abc_seekbar_thumb_material) {
                return AppCompatResources.getColorStateList(context, C0131R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        /* renamed from: e */
        public boolean mo2211e(@NonNull Context context, int i, @NonNull Drawable drawable) {
            if (i == C0131R.C0132drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i2 = C0131R.attr.colorControlNormal;
                m815m(findDrawableByLayerId, ThemeUtils.getThemeAttrColor(context, i2), AppCompatDrawableManager.f1191b);
                m815m(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, i2), AppCompatDrawableManager.f1191b);
                m815m(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0131R.attr.colorControlActivated), AppCompatDrawableManager.f1191b);
                return true;
            } else if (i != C0131R.C0132drawable.abc_ratingbar_material && i != C0131R.C0132drawable.abc_ratingbar_indicator_material && i != C0131R.C0132drawable.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m815m(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, C0131R.attr.colorControlNormal), AppCompatDrawableManager.f1191b);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i3 = C0131R.attr.colorControlActivated;
                m815m(findDrawableByLayerId2, ThemeUtils.getThemeAttrColor(context, i3), AppCompatDrawableManager.f1191b);
                m815m(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, i3), AppCompatDrawableManager.f1191b);
                return true;
            }
        }
    }

    /* renamed from: d */
    static void m805d(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.m899r(drawable, tintInfo, iArr);
    }

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (f1192c == null) {
                preload();
            }
            appCompatDrawableManager = f1192c;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (f1192c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                f1192c = appCompatDrawableManager;
                appCompatDrawableManager.f1193a = ResourceManagerInternal.get();
                f1192c.f1193a.setHooks(new C0257a());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized Drawable mo2203b(@NonNull Context context, @DrawableRes int i, boolean z) {
        return this.f1193a.mo2579i(context, i, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized ColorStateList mo2204c(@NonNull Context context, @DrawableRes int i) {
        return this.f1193a.mo2580j(context, i);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return this.f1193a.getDrawable(context, i);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.f1193a.onConfigurationChanged(context);
    }
}
