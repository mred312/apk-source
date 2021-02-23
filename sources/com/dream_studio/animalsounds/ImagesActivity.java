package com.dream_studio.animalsounds;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ViewSwitcher;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.dream_studio.animalsounds.ShakeEventListener;
import com.dream_studio.animalsounds.util.PositionSwitcher;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.medio.audioplayer.AudioPlayer;
import com.medio.catchexception.CatchException;
import com.medio.myutilities.BitmapLoaderFromResource;
import com.medio.myutilities.Utilities;
import com.medio.timer.MyTimer;
import com.medio.wallpaper.LibraryWallpaperBitmaps;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Locale;

public class ImagesActivity extends WikiWebView {
    public static final int CONTACT_CHOOSER_ACTIVITY_CODE = 73729;
    public static final int EXPANDED_SLIDE_PANEL_MAX_ALPHA = 153;
    public static final int REQUEST_PERMISSION_CODE = 23;
    public static final int WRITE_SETTINGS_PERMISSION_CODE = 24;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ArrayList<String> f6621A;

    /* renamed from: B */
    String[] f6622B;

    /* renamed from: C */
    private ArrayList<String> f6623C;

    /* renamed from: D */
    private ArrayList<Integer> f6624D = new ArrayList<>();

    /* renamed from: E */
    private byte f6625E;

    /* renamed from: F */
    private PositionSwitcher f6626F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f6627G = 0;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f6628H = false;

    /* renamed from: I */
    private boolean f6629I = false;

    /* renamed from: J */
    private ArrayList<Integer> f6630J = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: K */
    public ArrayList<Integer> f6631K = new ArrayList<>();

    /* renamed from: L */
    private AudioPlayer f6632L = null;

    /* renamed from: M */
    private SensorManager f6633M = null;

    /* renamed from: N */
    private ShakeEventListener f6634N = null;

    /* renamed from: O */
    private SideGallery f6635O;

    /* renamed from: P */
    private MyImageSwitcher f6636P = null;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public Vibrator f6637Q = null;

    /* renamed from: R */
    private int f6638R = 0;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public MyTimer f6639S = null;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public DonutProgress f6640T = null;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public int f6641U = 0;

    /* renamed from: V */
    private boolean f6642V = false;

    /* renamed from: W */
    private boolean f6643W = false;

    /* renamed from: X */
    private boolean f6644X = false;

    /* renamed from: Y */
    private BottomGallery f6645Y = null;

    /* renamed from: Z */
    private boolean f6646Z = false;
    /* access modifiers changed from: private */

    /* renamed from: a0 */
    public SlidingUpPanelLayout f6647a0;

    /* renamed from: b0 */
    private LoadBottomGalleryLinks f6648b0;
    public final Languages mSecondLanguages = new Languages();

    /* renamed from: s */
    private Uri f6649s = null;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public TextSwitcher f6650t;

    /* renamed from: u */
    private TextSwitcher f6651u;

    /* renamed from: v */
    private boolean f6652v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f6653w = 0;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public DialogInterface f6654x = null;

    /* renamed from: y */
    private String f6655y = null;

    /* renamed from: z */
    private final Languages f6656z = new Languages();

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$a */
    class C1381a implements View.OnLongClickListener {
        C1381a() {
        }

        public boolean onLongClick(View view) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            if (imagesActivity.lock) {
                imagesActivity.toastTop((int) C1441R.string.locked_info);
                return false;
            }
            imagesActivity.m4868t0();
            return true;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$b */
    class C1382b implements View.OnClickListener {
        C1382b() {
        }

        public void onClick(View view) {
            ImagesActivity.this.m4869u0(false, true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$c */
    class C1383c implements View.OnClickListener {
        C1383c() {
        }

        public void onClick(View view) {
            ((ToggleButton) ImagesActivity.this.findViewById(C1441R.C1443id.lock)).setChecked(ImagesActivity.this.lock);
            ImagesActivity imagesActivity = ImagesActivity.this;
            imagesActivity.toastTop(imagesActivity.lock ? C1441R.string.locked_long_info : C1441R.string.unlocked_long_info);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$d */
    class C1384d implements View.OnClickListener {
        C1384d() {
        }

        public void onClick(View view) {
            ToggleButton toggleButton = (ToggleButton) ImagesActivity.this.findViewById(C1441R.C1443id.like);
            if (!toggleButton.isChecked()) {
                toggleButton.setChecked(false);
                while (ImagesActivity.this.f6631K.indexOf(Integer.valueOf(ImagesActivity.this.f6627G)) != -1) {
                    ImagesActivity.this.f6631K.remove(ImagesActivity.this.f6631K.indexOf(Integer.valueOf(ImagesActivity.this.f6627G)));
                }
            } else {
                toggleButton.setChecked(true);
                ImagesActivity.this.f6631K.add(Integer.valueOf(ImagesActivity.this.f6627G));
            }
            ImagesActivity.this.saveLikeListInSharedPreferences();
            ImagesActivity.this.f6637Q.vibrate(100);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$e */
    class C1385e implements View.OnClickListener {
        C1385e() {
        }

        public void onClick(View view) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            if (imagesActivity.lock) {
                imagesActivity.setMuteButton();
                ImagesActivity.this.toastTop((int) C1441R.string.locked_info);
                return;
            }
            imagesActivity.mVolumeControl.controlSysVolume(0, false, true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$f */
    class C1386f implements View.OnClickListener {
        C1386f() {
        }

        public void onClick(View view) {
            ImagesActivity.this.playSound(true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$g */
    class C1387g implements View.OnClickListener {
        C1387g(ImagesActivity imagesActivity) {
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$h */
    class C1388h implements SlidingUpPanelLayout.PanelSlideListener {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout f6663a;

        /* renamed from: b */
        final /* synthetic */ Button f6664b;

        /* renamed from: c */
        final /* synthetic */ Button f6665c;

        C1388h(RelativeLayout relativeLayout, Button button, Button button2) {
            this.f6663a = relativeLayout;
            this.f6664b = button;
            this.f6665c = button2;
        }

        public void onPanelSlide(View view, float f) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            imagesActivity.m4860l0(imagesActivity.mSwitchedPosition);
            this.f6663a.setBackgroundColor(((byte) ((int) (f * 153.0f))) << 24);
        }

        public void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
            if (panelState2 == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                this.f6663a.setBackgroundColor(0);
                this.f6664b.setVisibility(0);
                this.f6665c.setVisibility(8);
            }
            if (panelState2 == SlidingUpPanelLayout.PanelState.EXPANDED) {
                this.f6664b.setVisibility(8);
                this.f6665c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$i */
    class C1389i implements View.OnClickListener {
        C1389i() {
        }

        public void onClick(View view) {
            ImagesActivity.this.f6647a0.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$j */
    class C1390j implements View.OnClickListener {
        C1390j() {
        }

        public void onClick(View view) {
            ImagesActivity.this.f6647a0.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$k */
    class C1391k extends MyTimer {
        C1391k(Context context, int i, int i2) {
            super(context, i, i2);
        }

        public void onFinish() {
            ImagesActivity.this.f6640T.setProgress(70);
            ImagesActivity.this.onSwitchNext((View) null);
        }

        public void onTick(int i) {
            ImagesActivity.this.f6640T.setProgress(ImagesActivity.m4825C(ImagesActivity.this));
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$l */
    class C1392l implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Languages f6670a;

        /* renamed from: b */
        final /* synthetic */ LangListAdapter f6671b;

        C1392l(ImagesActivity imagesActivity, Languages languages, LangListAdapter langListAdapter) {
            this.f6670a = languages;
            this.f6671b = langListAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6670a.selectedItem = i;
            this.f6671b.notifyDataSetChanged();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$m */
    class C1393m implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Languages f6672a;

        C1393m(Languages languages) {
            this.f6672a = languages;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Languages languages = this.f6672a;
            ImagesActivity.this.setSecondLanguage(languages.langList.get(languages.selectedItem).langListLocale);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$n */
    class C1394n implements DialogInterface.OnClickListener {
        C1394n(ImagesActivity imagesActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$o */
    class C1395o implements DialogInterface.OnDismissListener {
        C1395o() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            imagesActivity.mModelessDialog = null;
            imagesActivity.setMuteButton();
            ImagesActivity.this.mo10309z();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$p */
    class C1396p implements ViewSwitcher.ViewFactory {

        /* renamed from: a */
        final /* synthetic */ float f6675a;

        C1396p(float f) {
            this.f6675a = f;
        }

        public View makeView() {
            TextView textView = new TextView(ImagesActivity.this);
            textView.setGravity(17);
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setTextSize(0, this.f6675a);
            textView.setTypeface(Typeface.createFromAsset(ImagesActivity.this.getAssets(), "fonts/OpenSans-Regular.ttf"));
            return textView;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$q */
    class C1397q implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SetAsTypes f6677a;

        C1397q(SetAsTypes setAsTypes) {
            this.f6677a = setAsTypes;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            int unused = ImagesActivity.this.f6653w = this.f6677a.setAsTypesArray[i].listItemType;
            DialogInterface unused2 = ImagesActivity.this.f6654x = dialogInterface;
            if (ImagesActivity.this.f6653w == 5) {
                ImagesActivity.this.setImageAsWallpaper();
            } else if (ImagesActivity.this.f6653w == 3) {
                if (!ImagesActivity.this.m4859k0() || !ImagesActivity.this.m4856h0() || !ImagesActivity.this.m4857i0()) {
                    ImagesActivity.this.m4865q0();
                } else {
                    ImagesActivity.this.setRingtone();
                }
            } else if (ImagesActivity.this.m4859k0()) {
                ImagesActivity.this.m4851c0();
            } else {
                ImagesActivity.this.m4864p0();
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$r */
    class C1398r implements DialogInterface.OnDismissListener {
        C1398r() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            imagesActivity.mModelessDialog = null;
            imagesActivity.setMuteButton();
            ImagesActivity.this.mo10309z();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$s */
    class C1399s implements ShakeEventListener.OnShakeListener {
        C1399s() {
        }

        public void onShake() {
            ImagesActivity.this.playSound(false);
            ImagesActivity.this.toastTop("Shake!");
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$t */
    class C1400t implements Runnable {
        C1400t() {
        }

        public void run() {
            ImagesActivity.this.f6650t.setText((CharSequence) ImagesActivity.this.f6621A.get(ImagesActivity.this.mSwitchedPosition));
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$u */
    class C1401u implements View.OnClickListener {
        C1401u() {
        }

        public void onClick(View view) {
            ImagesActivity.this.playSound(true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$v */
    class C1402v implements ViewSwitcher.ViewFactory {
        C1402v() {
        }

        public View makeView() {
            TextView textView = new TextView(ImagesActivity.this);
            textView.setGravity(17);
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            textView.setTextSize(0, ImagesActivity.this.getResources().getDimension(C1441R.dimen.animal_title_size_bottom));
            return textView;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$w */
    class C1403w extends DrawerLayoutEdgeToggle {
        C1403w(Activity activity, DrawerLayout drawerLayout, int i, int i2, boolean z, int i3) {
            super(activity, drawerLayout, i, i2, z, i3);
        }

        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
        }

        public void onDrawerOpened(View view) {
            super.onDrawerOpened(view);
        }

        public void onDrawerSlide(View view, float f) {
            super.onDrawerSlide(view, f);
            if (((double) f) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                ImagesActivity.this.mo10309z();
                ImagesActivity.this.adViewVisible = true;
                return;
            }
            ImagesActivity imagesActivity = ImagesActivity.this;
            if (imagesActivity.adViewVisible) {
                imagesActivity.mo10301s();
                ImagesActivity.this.adViewVisible = false;
            }
        }

        public void onDrawerStateChanged(int i) {
            super.onDrawerStateChanged(i);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$x */
    class C1404x implements View.OnClickListener {
        C1404x() {
        }

        public void onClick(View view) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            if (imagesActivity.lock) {
                imagesActivity.toastTop((int) C1441R.string.locked_info);
                ((ToggleButton) ImagesActivity.this.findViewById(C1441R.C1443id.slideshow)).setChecked(ImagesActivity.this.f6628H);
                return;
            }
            boolean unused = imagesActivity.f6628H = !imagesActivity.f6628H;
            ((ToggleButton) ImagesActivity.this.findViewById(C1441R.C1443id.slideshow)).setChecked(ImagesActivity.this.f6628H);
            ImagesActivity imagesActivity2 = ImagesActivity.this;
            imagesActivity2.toastTop(imagesActivity2.f6628H ? C1441R.string.slideshow_start : C1441R.string.slideshow_stop);
            ImagesActivity.this.f6637Q.vibrate(100);
            if (!ImagesActivity.this.f6628H) {
                ImagesActivity.this.f6639S.stop();
            } else {
                ImagesActivity.this.f6639S.start();
                ImagesActivity.this.f6640T.setMax(70);
            }
            ImagesActivity.this.f6640T.setVisibility(ImagesActivity.this.f6628H ? 0 : 4);
            DonutProgress D = ImagesActivity.this.f6640T;
            int unused2 = ImagesActivity.this.f6641U = 0;
            D.setProgress(0);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$y */
    class C1405y implements View.OnLongClickListener {
        C1405y() {
        }

        public boolean onLongClick(View view) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            imagesActivity.lock = !imagesActivity.lock;
            ((ToggleButton) imagesActivity.findViewById(C1441R.C1443id.lock)).setChecked(ImagesActivity.this.lock);
            ImagesActivity imagesActivity2 = ImagesActivity.this;
            imagesActivity2.toastTop(imagesActivity2.lock ? C1441R.string.lock : C1441R.string.unlock);
            ImagesActivity.this.f6637Q.vibrate(100);
            ImagesActivity imagesActivity3 = ImagesActivity.this;
            if (!imagesActivity3.lock) {
                imagesActivity3.m4870v0();
            } else {
                imagesActivity3.m4854f0();
            }
            return true;
        }
    }

    /* renamed from: com.dream_studio.animalsounds.ImagesActivity$z */
    class C1406z implements View.OnClickListener {
        C1406z() {
        }

        public void onClick(View view) {
            ImagesActivity imagesActivity = ImagesActivity.this;
            imagesActivity.toastTop(imagesActivity.lock ? C1441R.string.locked_info : C1441R.string.setRingtoneLongInfo);
        }
    }

    /* renamed from: C */
    static /* synthetic */ int m4825C(ImagesActivity imagesActivity) {
        int i = imagesActivity.f6641U + 1;
        imagesActivity.f6641U = i;
        return i;
    }

    /* renamed from: b0 */
    private static boolean m4850b0(File file) {
        File file2 = new File(file.getAbsolutePath());
        return (!file2.exists() ? file2.mkdir() : true) & file2.isDirectory() & file2.canWrite();
    }

    /* access modifiers changed from: private */
    /* renamed from: c0 */
    public void m4851c0() {
        if (m4858j0()) {
            setRingtone();
        } else if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            try {
                startActivityForResult(intent, 24);
            } catch (Exception e) {
                CatchException.logException(e);
                toastTop((int) C1441R.string.permissionIntentException);
            }
        }
    }

    /* renamed from: d0 */
    private String m4852d0() {
        return getPackageName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r11 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        if (r11 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        r11.close();
     */
    /* renamed from: e0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m4853e0(android.net.Uri r13, java.lang.String r14, android.content.ContentResolver r15) {
        /*
            r12 = this;
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]
            java.lang.String r1 = "_id"
            r8 = 0
            r7[r8] = r1
            r9 = -1
            r11 = 0
            java.lang.String r4 = "_data LIKE ?"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0031 }
            r5[r8] = r14     // Catch:{ Exception -> 0x0031 }
            r6 = 0
            r1 = r15
            r2 = r13
            r3 = r7
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0031 }
            if (r11 == 0) goto L_0x0029
            r11.moveToFirst()     // Catch:{ Exception -> 0x0031 }
            r13 = r7[r8]     // Catch:{ Exception -> 0x0031 }
            int r13 = r11.getColumnIndex(r13)     // Catch:{ Exception -> 0x0031 }
            long r13 = r11.getLong(r13)     // Catch:{ Exception -> 0x0031 }
            r9 = r13
        L_0x0029:
            if (r11 == 0) goto L_0x0038
        L_0x002b:
            r11.close()
            goto L_0x0038
        L_0x002f:
            r13 = move-exception
            goto L_0x0039
        L_0x0031:
            r13 = move-exception
            r13.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x0038
            goto L_0x002b
        L_0x0038:
            return r9
        L_0x0039:
            if (r11 == 0) goto L_0x003e
            r11.close()
        L_0x003e:
            goto L_0x0040
        L_0x003f:
            throw r13
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.ImagesActivity.m4853e0(android.net.Uri, java.lang.String, android.content.ContentResolver):long");
    }

    /* access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: f0 */
    public void m4854f0() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 19 && decorView != null) {
            decorView.setSystemUiVisibility(5894);
        }
    }

    /* renamed from: g0 */
    private boolean m4855g0(int i) {
        return (getPhotoId(i) == 0 || getSoundId(i) == 0 || this.f6624D.get(i).intValue() == 0 || this.f6621A.get(i).contentEquals("--")) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0381  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getBestAvailableFilesDir(android.content.Context r17, java.lang.String r18) {
        /*
            r1 = r18
            java.lang.String r2 = ""
            int r3 = android.os.Build.VERSION.SDK_INT
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = r0.getPath()
            java.lang.String r4 = "/"
            boolean r5 = r0.endsWith(r4)
            if (r5 != 0) goto L_0x0025
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
        L_0x0025:
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = r6.toString()
            r5.<init>(r0)
            boolean r0 = m4850b0(r5)
            if (r0 == 0) goto L_0x0040
            return r5
        L_0x0040:
            java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r18)
            boolean r5 = m4850b0(r0)
            if (r5 == 0) goto L_0x004b
            return r0
        L_0x004b:
            r5 = 0
            r6 = 19
            r7 = 0
            if (r3 < r6) goto L_0x008e
            r0 = r17
            java.io.File[] r0 = r0.getExternalFilesDirs(r5)
            if (r0 == 0) goto L_0x008e
            int r8 = r0.length
            r9 = 0
        L_0x005b:
            if (r9 >= r8) goto L_0x008e
            r10 = r0[r9]
            if (r10 == 0) goto L_0x008b
            java.lang.String r10 = r10.getPath()
            java.lang.String r11 = "/Android"
            java.lang.String[] r10 = r10.split(r11)
            r10 = r10[r7]
            java.io.File r11 = new java.io.File
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            r12.append(r4)
            r12.append(r1)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            boolean r10 = m4850b0(r11)
            if (r10 == 0) goto L_0x008b
            return r11
        L_0x008b:
            int r9 = r9 + 1
            goto L_0x005b
        L_0x008e:
            java.io.File r0 = new java.io.File
            java.lang.String r8 = "/storage/"
            r0.<init>(r8)
            java.io.File[] r0 = r0.listFiles()
            if (r0 == 0) goto L_0x00c8
            int r8 = r0.length
            r9 = 0
        L_0x009d:
            if (r9 >= r8) goto L_0x00c8
            r10 = r0[r9]
            if (r10 == 0) goto L_0x00c5
            java.io.File r11 = new java.io.File
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r10 = r10.getAbsolutePath()
            r12.append(r10)
            r12.append(r4)
            r12.append(r1)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            boolean r10 = m4850b0(r11)
            if (r10 == 0) goto L_0x00c5
            return r11
        L_0x00c5:
            int r9 = r9 + 1
            goto L_0x009d
        L_0x00c8:
            r8 = 1
            java.lang.ProcessBuilder r0 = new java.lang.ProcessBuilder     // Catch:{ Exception -> 0x0110 }
            java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ Exception -> 0x0110 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0110 }
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0110 }
            java.lang.String r10 = "mount"
            r9[r7] = r10     // Catch:{ Exception -> 0x0110 }
            java.lang.ProcessBuilder r0 = r0.command(r9)     // Catch:{ Exception -> 0x0110 }
            java.lang.ProcessBuilder r0 = r0.redirectErrorStream(r8)     // Catch:{ Exception -> 0x0110 }
            java.lang.Process r0 = r0.start()     // Catch:{ Exception -> 0x0110 }
            r0.waitFor()     // Catch:{ Exception -> 0x0110 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x0110 }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x0110 }
            r10 = r2
        L_0x00ee:
            int r11 = r0.read(r9)     // Catch:{ Exception -> 0x010e }
            r12 = -1
            if (r11 == r12) goto L_0x010a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e }
            r11.<init>()     // Catch:{ Exception -> 0x010e }
            r11.append(r10)     // Catch:{ Exception -> 0x010e }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x010e }
            r12.<init>(r9)     // Catch:{ Exception -> 0x010e }
            r11.append(r12)     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x010e }
            goto L_0x00ee
        L_0x010a:
            r0.close()     // Catch:{ Exception -> 0x010e }
            goto L_0x0115
        L_0x010e:
            r0 = move-exception
            goto L_0x0112
        L_0x0110:
            r0 = move-exception
            r10 = r2
        L_0x0112:
            r0.printStackTrace()
        L_0x0115:
            java.lang.String r0 = r10.trim()
            boolean r0 = r0.isEmpty()
            r9 = 23
            if (r0 != 0) goto L_0x0227
            java.lang.String r0 = "\n"
            java.lang.String[] r0 = r10.split(r0)
            int r10 = r0.length
            r11 = 0
        L_0x0129:
            java.lang.String r12 = "vold"
            java.lang.String r13 = " "
            if (r11 >= r10) goto L_0x01cb
            r14 = r0[r11]
            java.lang.String r15 = r14.toLowerCase()
            java.lang.String r5 = "/dev/block/vold"
            boolean r5 = r15.contains(r5)
            if (r5 == 0) goto L_0x01c2
            java.lang.String[] r5 = r14.split(r13)
            int r13 = r5.length
            r14 = 0
        L_0x0143:
            if (r14 >= r13) goto L_0x01c2
            r15 = r5[r14]
            boolean r16 = r15.startsWith(r4)
            if (r16 == 0) goto L_0x01bb
            java.util.Locale r6 = java.util.Locale.US
            java.lang.String r6 = r15.toLowerCase(r6)
            boolean r6 = r6.contains(r12)
            if (r6 != 0) goto L_0x01bb
            if (r3 < r9) goto L_0x0185
            java.lang.String r6 = r15.toLowerCase()
            java.lang.String r9 = ".*[0-9a-f]{4}[-][0-9a-f]{4}"
            boolean r6 = r6.matches(r9)
            if (r6 == 0) goto L_0x01bb
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r15)
            r9.append(r4)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r6.<init>(r9)
            boolean r9 = m4850b0(r6)
            if (r9 == 0) goto L_0x01bb
            return r6
        L_0x0185:
            java.lang.String r6 = r15.toLowerCase()
            java.lang.String r9 = "ext"
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L_0x019d
            java.lang.String r6 = r15.toLowerCase()
            java.lang.String r9 = "sdcard"
            boolean r6 = r6.contains(r9)
            if (r6 == 0) goto L_0x01bb
        L_0x019d:
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r15)
            r9.append(r4)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r6.<init>(r9)
            boolean r9 = m4850b0(r6)
            if (r9 == 0) goto L_0x01bb
            return r6
        L_0x01bb:
            int r14 = r14 + 1
            r6 = 19
            r9 = 23
            goto L_0x0143
        L_0x01c2:
            int r11 = r11 + 1
            r5 = 0
            r6 = 19
            r9 = 23
            goto L_0x0129
        L_0x01cb:
            int r3 = r0.length
            r5 = 0
        L_0x01cd:
            if (r5 >= r3) goto L_0x0227
            r6 = r0[r5]
            java.util.Locale r9 = java.util.Locale.US
            java.lang.String r9 = r6.toLowerCase(r9)
            java.lang.String r10 = "asec"
            boolean r9 = r9.contains(r10)
            if (r9 != 0) goto L_0x0224
            java.lang.String r9 = "(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*"
            boolean r9 = r6.matches(r9)
            if (r9 == 0) goto L_0x0224
            java.lang.String[] r6 = r6.split(r13)
            int r9 = r6.length
            r10 = 0
        L_0x01ed:
            if (r10 >= r9) goto L_0x0224
            r11 = r6[r10]
            boolean r14 = r11.startsWith(r4)
            if (r14 == 0) goto L_0x0221
            java.util.Locale r14 = java.util.Locale.US
            java.lang.String r14 = r11.toLowerCase(r14)
            boolean r14 = r14.contains(r12)
            if (r14 != 0) goto L_0x0221
            java.io.File r14 = new java.io.File
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r11)
            r15.append(r4)
            r15.append(r1)
            java.lang.String r11 = r15.toString()
            r14.<init>(r11)
            boolean r11 = m4850b0(r14)
            if (r11 == 0) goto L_0x0221
            return r14
        L_0x0221:
            int r10 = r10 + 1
            goto L_0x01ed
        L_0x0224:
            int r5 = r5 + 1
            goto L_0x01cd
        L_0x0227:
            java.lang.String r0 = "SECONDARY_STORAGE"
            java.lang.String r0 = java.lang.System.getenv(r0)
            if (r0 == 0) goto L_0x0235
            int r3 = r0.length()
            if (r3 != 0) goto L_0x023e
        L_0x0235:
            java.lang.String r0 = "EXTERNAL_SDCARD_STORAGE"
            java.lang.String r0 = java.lang.System.getenv(r0)
            if (r0 != 0) goto L_0x023e
            goto L_0x023f
        L_0x023e:
            r2 = r0
        L_0x023f:
            r0 = 53
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r3 = "/HWUserData"
            r0[r7] = r3
            java.lang.String r3 = "/LocalDisk"
            r0[r8] = r3
            r3 = 2
            java.lang.String r5 = "/FAT"
            r0[r3] = r5
            r3 = 3
            java.lang.String r5 = "/mnt/emmc"
            r0[r3] = r5
            r3 = 4
            java.lang.String r5 = "/mnt/ext_card"
            r0[r3] = r5
            r3 = 5
            java.lang.String r5 = "/mnt/extern_sd"
            r0[r3] = r5
            r3 = 6
            java.lang.String r5 = "/mnt/extsd"
            r0[r3] = r5
            r3 = 7
            java.lang.String r5 = "/mnt/ext_sd"
            r0[r3] = r5
            r3 = 8
            java.lang.String r5 = "/mnt/ext_sdcard"
            r0[r3] = r5
            r3 = 9
            java.lang.String r5 = "/mnt/external"
            r0[r3] = r5
            r3 = 10
            java.lang.String r5 = "/mnt/external1"
            r0[r3] = r5
            r3 = 11
            java.lang.String r5 = "/mnt/external_sd"
            r0[r3] = r5
            r3 = 12
            java.lang.String r5 = "/mnt/external_sdcard"
            r0[r3] = r5
            r3 = 13
            java.lang.String r5 = "/mnt/externalSdCard"
            r0[r3] = r5
            r3 = 14
            java.lang.String r5 = "/mnt/extsdcard"
            r0[r3] = r5
            r3 = 15
            java.lang.String r5 = "/mnt/extSdCard"
            r0[r3] = r5
            r3 = 16
            java.lang.String r5 = "/mnt/flash"
            r0[r3] = r5
            r3 = 17
            java.lang.String r5 = "/mnt/media"
            r0[r3] = r5
            r3 = 18
            java.lang.String r5 = "/mnt/media_rw/sdcard1"
            r0[r3] = r5
            java.lang.String r3 = "/mnt/nand"
            r5 = 19
            r0[r5] = r3
            r3 = 20
            java.lang.String r5 = "/mnt/sdcard"
            r0[r3] = r5
            r3 = 21
            java.lang.String r5 = "/mnt/sdcard/_ExternalSD"
            r0[r3] = r5
            r3 = 22
            java.lang.String r5 = "/mnt/sdcard/ext_sd"
            r0[r3] = r5
            java.lang.String r3 = "/mnt/sdcard/extStorages/SdCard"
            r5 = 23
            r0[r5] = r3
            r3 = 24
            java.lang.String r5 = "/mnt/sdcard/external_sd"
            r0[r3] = r5
            r3 = 25
            java.lang.String r5 = "/mnt/sdcard/external_sdcard"
            r0[r3] = r5
            r3 = 26
            java.lang.String r5 = "/mnt/sdcard/SD_CARD"
            r0[r3] = r5
            r3 = 27
            java.lang.String r5 = "/mnt/sdcard/sdcard1"
            r0[r3] = r5
            r3 = 28
            java.lang.String r5 = "/mnt/sdcard/sdcard2"
            r0[r3] = r5
            r3 = 29
            java.lang.String r5 = "/mnt/sdcard/tflash"
            r0[r3] = r5
            r3 = 30
            java.lang.String r5 = "/mnt/sdcard/removable_sdcard"
            r0[r3] = r5
            r3 = 31
            java.lang.String r5 = "/mnt/sdcard-ext"
            r0[r3] = r5
            r3 = 32
            java.lang.String r5 = "/mnt/sdcard2"
            r0[r3] = r5
            r3 = 33
            java.lang.String r5 = "/removable/microsd"
            r0[r3] = r5
            r3 = 34
            java.lang.String r5 = "/Removable/MicroSD"
            r0[r3] = r5
            r3 = 35
            java.lang.String r5 = "/Removable/SD"
            r0[r3] = r5
            r3 = 36
            java.lang.String r5 = "/sdcard/sd"
            r0[r3] = r5
            r3 = 37
            java.lang.String r5 = "/storage/sdcard0"
            r0[r3] = r5
            r3 = 38
            java.lang.String r5 = "/storage/sdcard0/external_sdcard"
            r0[r3] = r5
            r3 = 39
            java.lang.String r5 = "/storage/sdcard1"
            r0[r3] = r5
            r3 = 40
            java.lang.String r5 = "/storage/extsdcard"
            r0[r3] = r5
            r3 = 41
            java.lang.String r5 = "/storage/extSdCard"
            r0[r3] = r5
            r3 = 42
            java.lang.String r5 = "/storage/external_SD"
            r0[r3] = r5
            r3 = 43
            java.lang.String r5 = "/storage/ext_sd"
            r0[r3] = r5
            r3 = 44
            java.lang.String r5 = "/storage/removable/sdcard1"
            r0[r3] = r5
            r3 = 45
            java.lang.String r5 = "/storage/usbcard1"
            r0[r3] = r5
            r3 = 46
            java.lang.String r5 = "/data/sdext"
            r0[r3] = r5
            r3 = 47
            java.lang.String r5 = "/data/sdext2"
            r0[r3] = r5
            r3 = 48
            java.lang.String r5 = "/data/sdext3"
            r0[r3] = r5
            r3 = 49
            r0[r3] = r5
            r3 = 50
            java.lang.String r5 = "/media/external"
            r0[r3] = r5
            r3 = 51
            java.lang.String r5 = "/media/external/audio/media"
            r0[r3] = r5
            r3 = 52
            r0[r3] = r2
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x037b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x03a5
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            r5.append(r4)
            r5.append(r1)
            java.lang.String r2 = r5.toString()
            r3.<init>(r2)
            boolean r2 = m4850b0(r3)
            if (r2 == 0) goto L_0x037b
            return r3
        L_0x03a5:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.ImagesActivity.getBestAvailableFilesDir(android.content.Context, java.lang.String):java.io.File");
    }

    /* access modifiers changed from: private */
    /* renamed from: h0 */
    public boolean m4856h0() {
        return ContextCompat.checkSelfPermission(this.mContext, "android.permission.READ_CONTACTS") == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public boolean m4857i0() {
        return ContextCompat.checkSelfPermission(this.mContext, "android.permission.WRITE_CONTACTS") == 0;
    }

    /* renamed from: j0 */
    private boolean m4858j0() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.System.canWrite(this.mContext);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k0 */
    public boolean m4859k0() {
        return ContextCompat.checkSelfPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: l0 */
    public void m4860l0(int i) {
        BottomGallery bottomGallery;
        ArrayList<String> links;
        if (!this.f6646Z && (bottomGallery = this.f6645Y) != null) {
            this.f6646Z = true;
            bottomGallery.clear();
            LoadBottomGalleryLinks loadBottomGalleryLinks = this.f6648b0;
            if (loadBottomGalleryLinks != null && (links = loadBottomGalleryLinks.getLinks(i)) != null) {
                for (int size = links.size() - 1; size >= 0; size--) {
                    this.f6645Y.add(links.get(size));
                }
                this.f6645Y.notifyDataSetChanged();
                this.f6645Y.setSelected(0);
            }
        }
    }

    /* renamed from: m0 */
    private void m4861m0() {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(C1441R.array.animals_files);
        for (int i = 0; i < this.f6626F.size(); i++) {
            int switchedPosition = this.f6626F.getSwitchedPosition(i);
            if (m4855g0(switchedPosition)) {
                this.f6635O.add(getResources().getIdentifier(obtainTypedArray.getString(switchedPosition), "drawable", getPackageName()), this.f6621A.get(switchedPosition), switchedPosition);
            }
        }
        obtainTypedArray.recycle();
    }

    /* renamed from: n0 */
    private void m4862n0() {
        AudioPlayer audioPlayer = this.f6632L;
        if (audioPlayer != null) {
            audioPlayer.release();
            this.f6632L = null;
        }
    }

    /* renamed from: o0 */
    private void m4863o0(int i) {
        this.f6646Z = false;
        SlidingUpPanelLayout slidingUpPanelLayout = this.f6647a0;
        if (slidingUpPanelLayout != null && slidingUpPanelLayout.getPanelState() != SlidingUpPanelLayout.PanelState.COLLAPSED) {
            m4860l0(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p0 */
    public void m4864p0() {
        ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE");
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 23);
    }

    /* access modifiers changed from: private */
    /* renamed from: q0 */
    public void m4865q0() {
        ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE");
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"}, 23);
    }

    /* renamed from: r0 */
    private void m4866r0(float f) {
        TextSwitcher textSwitcher = this.f6650t;
        if (textSwitcher != null) {
            TextView textView = (TextView) textSwitcher.getCurrentView();
            String charSequence = textView != null ? textView.getText().toString() : null;
            this.f6650t.removeAllViews();
            this.f6650t.setFactory(new C1396p(f));
            this.f6650t.setText(charSequence);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1441R.C1443id.textSwitcherTopBar);
            relativeLayout.setLayoutParams((RelativeLayout.LayoutParams) relativeLayout.getLayoutParams());
        }
    }

    /* renamed from: s0 */
    private void m4867s0() {
        ((ToggleButton) findViewById(C1441R.C1443id.like)).setChecked(this.f6631K.contains(Integer.valueOf(this.f6627G)));
    }

    /* access modifiers changed from: private */
    /* renamed from: t0 */
    public void m4868t0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        SetAsTypes setAsTypes = new SetAsTypes(this.mContext);
        builder.setSingleChoiceItems(new RingListAdapter(this.mContext, C1441R.layout.ring_list_item, setAsTypes), -1, new C1397q(setAsTypes));
        mo10301s();
        AlertDialog create = builder.create();
        this.mModelessDialog = create;
        create.setOwnerActivity((Activity) this.mContext);
        this.mModelessDialog.setOnDismissListener(new C1398r());
        this.mModelessDialog.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: u0 */
    public void m4869u0(boolean z, boolean z2) {
    }

    /* access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: v0 */
    public void m4870v0() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 19 && decorView != null) {
            decorView.setSystemUiVisibility(4);
        }
    }

    /* renamed from: w0 */
    private void m4871w0() {
        AudioPlayer audioPlayer = this.f6632L;
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
    }

    public void closeSlideUpPanel() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.f6647a0;
        if (slidingUpPanelLayout != null) {
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
    }

    public int getPhotoId(int i) {
        return getResources().getIdentifier(this.f6623C.get(i), "drawable", getPackageName());
    }

    public String[] getSecondNames(Locale locale) {
        Resources resources = getApplicationContext().getResources();
        AssetManager assets = resources.getAssets();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.locale = locale;
        String[] stringArray = new Resources(assets, displayMetrics, configuration).getStringArray(C1441R.array.animals);
        new Resources(assets, displayMetrics, resources.getConfiguration());
        return stringArray;
    }

    public int getSoundId(int i) {
        return getResources().getIdentifier(this.f6623C.get(i), "raw", getPackageName());
    }

    public void initUI() {
        super.initUI();
        MyImageSwitcher myImageSwitcher = new MyImageSwitcher(this);
        this.f6636P = myImageSwitcher;
        myImageSwitcher.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f6650t = (TextSwitcher) findViewById(C1441R.C1443id.textSwitcher);
        m4866r0(getResources().getDimension(C1441R.dimen.images_animal_name_text_size));
        new Handler().post(new C1400t());
        int i = 0;
        if (!this.f6642V || (this.f6644X && !this.f6643W)) {
            this.f6650t.setEnabled(false);
            this.f6650t.setClickable(true);
        } else {
            this.f6650t.setEnabled(true);
            this.f6650t.setOnClickListener(new C1401u());
        }
        TextSwitcher textSwitcher = (TextSwitcher) findViewById(C1441R.C1443id.textSwitcherBottom);
        this.f6651u = textSwitcher;
        textSwitcher.removeAllViews();
        this.f6651u.setFactory(new C1402v());
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(C1441R.C1443id.drawer_layout);
        drawerLayout.setDrawerShadow((int) C1441R.C1442drawable.drawer_shadow_dark, (int) GravityCompat.START);
        C1403w wVar = new C1403w(this, drawerLayout, C1441R.C1442drawable.button_close_gallery, C1441R.C1442drawable.button_open_gallery, true, GravityCompat.START);
        this.mDrawerToggle = wVar;
        wVar.setVerticalTopOffset(55);
        drawerLayout.addDrawerListener(this.mDrawerToggle);
        findViewById(C1441R.C1443id.slideshow).setOnClickListener(new C1404x());
        findViewById(C1441R.C1443id.lock).setOnLongClickListener(new C1405y());
        ImageButton imageButton = (ImageButton) findViewById(C1441R.C1443id.ringtone);
        imageButton.setOnClickListener(new C1406z());
        imageButton.setOnLongClickListener(new C1381a());
        findViewById(C1441R.C1443id.settings).setOnClickListener(new C1382b());
        findViewById(C1441R.C1443id.lock).setOnClickListener(new C1383c());
        findViewById(C1441R.C1443id.like).setOnClickListener(new C1384d());
        findViewById(C1441R.C1443id.mute).setOnClickListener(new C1385e());
        ImageView imageView = (ImageView) findViewById(C1441R.C1443id.language);
        ImageButton imageButton2 = (ImageButton) findViewById(C1441R.C1443id.textSwitcherButtonTalk);
        imageButton2.setOnClickListener(new C1386f());
        if (!this.f6642V || (this.f6644X && !this.f6643W)) {
            imageButton2.setVisibility(8);
            Languages languages = this.f6656z;
            languages.selectedItem = languages.checkLanguagePosition(this.mLang, this.mCountry);
            imageView.setImageResource(this.f6656z.getLanguagePictureResId(this.mLang, this.mCountry));
        } else {
            imageView.setVisibility(8);
        }
        setMuteButton();
        ((ToggleButton) findViewById(C1441R.C1443id.slideshow)).setChecked(this.f6628H);
        ((ToggleButton) findViewById(C1441R.C1443id.lock)).setChecked(this.lock);
        this.f6635O = new SideGallery(this.mContext, this.f6624D);
        m4861m0();
        this.f6645Y = new BottomGallery(this.mContext, this.metrics);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C1441R.C1443id.buttonBar);
        Button button = (Button) findViewById(C1441R.C1443id.gallery_arrow_top);
        Button button2 = (Button) findViewById(C1441R.C1443id.gallery_arrow_down);
        relativeLayout.setOnClickListener(new C1387g(this));
        SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(C1441R.C1443id.sliding_layout);
        this.f6647a0 = slidingUpPanelLayout;
        slidingUpPanelLayout.addPanelSlideListener(new C1388h(relativeLayout, button, button2));
        button.setOnClickListener(new C1389i());
        button2.setOnClickListener(new C1390j());
        createAds();
        m4867s0();
        DonutProgress donutProgress = (DonutProgress) findViewById(C1441R.C1443id.donut_progress);
        this.f6640T = donutProgress;
        donutProgress.setMax(70);
        this.f6640T.setProgress(this.f6641U);
        DonutProgress donutProgress2 = this.f6640T;
        if (!this.f6628H) {
            i = 4;
        }
        donutProgress2.setVisibility(i);
    }

    public void loadLikeListFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFERENCES_NAME, 0);
        this.f6631K.clear();
        int i = sharedPreferences.getInt("Like_size", 0);
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList<Integer> arrayList = this.f6631K;
            arrayList.add(Integer.valueOf(sharedPreferences.getInt("Like_" + i2, 0)));
        }
    }

    public void makeShuffle() {
        this.f6630J.clear();
        for (int i = 0; i < this.f6626F.size(); i++) {
            if (m4855g0(this.f6626F.getSwitchedPosition(i))) {
                this.f6630J.add(Integer.valueOf(i));
            }
        }
        Collections.shuffle(this.f6630J);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 24) {
            if (i == 73729 && i2 == -1) {
                try {
                    if (this.f6649s != null) {
                        Cursor query = getContentResolver().query(intent.getData(), new String[]{"lookup"}, (String) null, (String[]) null, (String) null);
                        query.moveToFirst();
                        if (query.getCount() > 0) {
                            String string = query.getString(0);
                            query.close();
                            Uri lookupContact = ContactsContract.Contacts.lookupContact(getContentResolver(), Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, string));
                            if (lookupContact != null) {
                                ContentValues contentValues = new ContentValues(1);
                                contentValues.put("custom_ringtone", this.f6649s.toString());
                                getContentResolver().update(lookupContact, contentValues, (String) null, (String[]) null);
                                toastTop((int) C1441R.string.success);
                            } else {
                                toastTop(getString(C1441R.string.ringtoneSetErrorOccurred) + " 6");
                                CatchException.log("ImagesActivity::onActivityResult Error code: 6");
                            }
                        } else {
                            toastTop(getString(C1441R.string.ringtoneSetErrorOccurred) + " 7");
                            CatchException.log("ImagesActivity::onActivityResult Error code: 7");
                        }
                    } else {
                        toastTop(getString(C1441R.string.ringtoneSetErrorOccurred) + " 8");
                        CatchException.log("ImagesActivity::onActivityResult Error code: 8");
                    }
                } catch (Exception e) {
                    if (Utilities.isDebugable(this.mContext)) {
                        e.getMessage();
                    }
                    CatchException.logException(e);
                    toastTop(getString(C1441R.string.ringtoneSetErrorOccurred) + " 4");
                }
                DialogInterface dialogInterface = this.f6654x;
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    this.f6654x = null;
                }
            }
        } else if (m4858j0()) {
            setRingtone();
        } else {
            toastTop((int) C1441R.string.permissionNotGranted);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SideGallery sideGallery = this.f6635O;
        if (sideGallery != null) {
            sideGallery.destroy();
        }
        BottomGallery bottomGallery = this.f6645Y;
        if (bottomGallery != null) {
            bottomGallery.destroy();
        }
        this.f6636P.releaseImages();
        setContentView(C1441R.layout.activity_images);
        initUI();
        m4863o0(this.mSwitchedPosition);
        setActualImage(0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(C1441R.layout.activity_images);
        getWindow().addFlags(128);
        this.f6626F = new PositionSwitcher(this.mContext);
        this.f6637Q = (Vibrator) getSystemService("vibrator");
        this.f6629I = getIntent().getBooleanExtra("random", false);
        this.f6652v = getIntent().getBooleanExtra("is_second_language", false);
        this.f6655y = getIntent().getStringExtra("second_language");
        this.f6638R = getIntent().getIntExtra("talkSet", 0);
        this.f6642V = getIntent().getBooleanExtra("isSpeaker", false);
        long longExtra = getIntent().getLongExtra("gallery_links_ver", LoadBottomGalleryLinks.GALLERY_LINKS_BASE_VERSION);
        Resources resources = getResources();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6625E = extras.getByte("type");
        } else {
            finish();
        }
        TypedArray typedArray = null;
        if (bundle != null) {
            this.f6627G = bundle.getInt("mPosition");
            this.f6628H = bundle.getBoolean("slideshow_run");
            String string = bundle.getString("newRingtoneUri", (String) null);
            if (string != null) {
                this.f6649s = Uri.parse(string);
            }
        }
        int checkLanguagePosition = this.f6656z.checkLanguagePosition(this.mLang, this.mCountry);
        if (checkLanguagePosition != -1) {
            int i = getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).getInt(this.mLang, -1);
            this.f6644X = this.f6656z.langList.get(checkLanguagePosition).mustDownload;
            this.f6643W = i == this.f6656z.langList.get(checkLanguagePosition).pronunVer;
        }
        this.f6621A = new ArrayList<>(Arrays.asList(getResources().getStringArray(C1441R.array.animals)));
        this.f6623C = new ArrayList<>(Arrays.asList(getResources().getStringArray(C1441R.array.animals_files)));
        loadLikeListFromSharedPreferences();
        byte b = this.f6625E;
        if (b == 98) {
            typedArray = resources.obtainTypedArray(C1441R.array.all_animals);
        } else if (b != 99) {
            switch (b) {
                case 0:
                    typedArray = resources.obtainTypedArray(C1441R.array.birds);
                    break;
                case 1:
                    typedArray = resources.obtainTypedArray(C1441R.array.farm_animals);
                    break;
                case 2:
                    typedArray = resources.obtainTypedArray(C1441R.array.wild_animals);
                    break;
                case 3:
                    typedArray = resources.obtainTypedArray(C1441R.array.pet_animals);
                    break;
                case 4:
                    typedArray = resources.obtainTypedArray(C1441R.array.mammals);
                    break;
                case 5:
                    typedArray = resources.obtainTypedArray(C1441R.array.reptiles_and_amphibians);
                    break;
                case 6:
                    typedArray = resources.obtainTypedArray(C1441R.array.insects);
                    break;
                case 7:
                    typedArray = resources.obtainTypedArray(C1441R.array.land);
                    break;
                case 8:
                    typedArray = resources.obtainTypedArray(C1441R.array.water);
                    break;
                default:
                    typedArray = resources.obtainTypedArray(C1441R.array.all_animals);
                    break;
            }
        } else {
            this.f6624D.clear();
            for (int i2 = 0; i2 < this.f6621A.size(); i2++) {
                if (!this.f6626F.contain(i2)) {
                    this.f6624D.add(0);
                } else if (this.f6631K.contains(Integer.valueOf(this.f6626F.indexOf(i2)))) {
                    this.f6624D.add(1);
                } else {
                    this.f6624D.add(0);
                }
            }
        }
        if (typedArray != null && this.f6625E < 99) {
            this.f6624D.clear();
            for (int i3 = 0; i3 < typedArray.length(); i3++) {
                this.f6624D.add(Integer.valueOf(typedArray.getInt(i3, 0)));
            }
            typedArray.recycle();
        }
        this.mSwitchedPosition = this.f6626F.getSwitchedPosition(this.f6627G);
        while (this.f6624D.get(this.mSwitchedPosition).intValue() == 0) {
            int size = (this.f6627G + 1) % this.f6626F.size();
            this.f6627G = size;
            this.mSwitchedPosition = this.f6626F.getSwitchedPosition(size);
            while (true) {
                if (getPhotoId(this.mSwitchedPosition) == 0 || getSoundId(this.mSwitchedPosition) == 0) {
                    int size2 = (this.f6627G + 1) % this.f6626F.size();
                    this.f6627G = size2;
                    this.mSwitchedPosition = this.f6626F.getSwitchedPosition(size2);
                }
            }
        }
        this.f6632L = new AudioPlayer(this.mContext);
        this.f6639S = new C1391k(this, 7000, 100);
        this.f6633M = (SensorManager) getSystemService("sensor");
        ShakeEventListener shakeEventListener = new ShakeEventListener();
        this.f6634N = shakeEventListener;
        shakeEventListener.setOnShakeListener(new C1399s());
        if (this.f6629I) {
            makeShuffle();
            int shuffleAnimal = shuffleAnimal(true, this.f6627G);
            this.f6627G = shuffleAnimal;
            this.mSwitchedPosition = this.f6626F.getSwitchedPosition(shuffleAnimal);
        }
        initUI();
        playSound(false);
        this.f6648b0 = new LoadBottomGalleryLinks((ImagesActivity) this.mContext, longExtra);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f6636P.releaseListener();
        SideGallery sideGallery = this.f6635O;
        if (sideGallery != null) {
            sideGallery.destroy();
        }
        BottomGallery bottomGallery = this.f6645Y;
        if (bottomGallery != null) {
            bottomGallery.destroy();
        }
        m4862n0();
    }

    public void onHeaderBottomGalleryClick() {
    }

    public void onHeaderSideGalleryClick() {
        playSound(false);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(C1441R.C1443id.drawer_layout);
        if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            drawerLayout.closeDrawer((int) GravityCompat.START);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r8 != 27) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r8, android.view.KeyEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.lock
            r1 = 1
            r2 = 27
            r3 = 6
            r4 = 5
            r5 = 4
            r6 = 3
            if (r0 != 0) goto L_0x0085
            if (r8 == r6) goto L_0x007d
            if (r8 == r5) goto L_0x0016
            if (r8 == r4) goto L_0x007d
            if (r8 == r3) goto L_0x007d
            if (r8 == r2) goto L_0x007d
            goto L_0x0080
        L_0x0016:
            r8 = 2131296385(0x7f090081, float:1.8210685E38)
            android.view.View r8 = r7.findViewById(r8)
            androidx.drawerlayout.widget.DrawerLayout r8 = (androidx.drawerlayout.widget.DrawerLayout) r8
            r9 = 8388611(0x800003, float:1.1754948E-38)
            boolean r0 = r8.isDrawerOpen((int) r9)
            if (r0 == 0) goto L_0x002c
            r8.closeDrawer((int) r9)
            goto L_0x007c
        L_0x002c:
            boolean r8 = r7.showWikiWebView
            if (r8 == 0) goto L_0x0034
            r7.hideWikiWebView()
            goto L_0x007c
        L_0x0034:
            com.sothree.slidinguppanel.SlidingUpPanelLayout r8 = r7.f6647a0
            if (r8 == 0) goto L_0x0046
            com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r8 = r8.getPanelState()
            com.sothree.slidinguppanel.SlidingUpPanelLayout$PanelState r9 = com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState.COLLAPSED
            if (r8 == r9) goto L_0x0046
            com.sothree.slidinguppanel.SlidingUpPanelLayout r8 = r7.f6647a0
            r8.setPanelState(r9)
            goto L_0x007c
        L_0x0046:
            r7.m4871w0()
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            boolean r9 = r7.f6629I
            java.lang.String r0 = "random"
            r8.putBoolean(r0, r9)
            boolean r9 = r7.f6652v
            java.lang.String r0 = "is_second_language"
            r8.putBoolean(r0, r9)
            java.lang.String r9 = r7.f6655y
            java.lang.String r0 = "second_language"
            r8.putString(r0, r9)
            android.content.Intent r9 = new android.content.Intent
            r9.<init>()
            r9.putExtras(r8)
            r8 = -1
            r7.setResult(r8, r9)
            com.medio.timer.MyTimer r8 = r7.f6639S
            if (r8 == 0) goto L_0x0076
            r8.stop()
        L_0x0076:
            r7.stopWikiButtonAnimTimer()
            r7.showInterstitialAndCloseActivity()
        L_0x007c:
            return r1
        L_0x007d:
            r7.m4871w0()
        L_0x0080:
            boolean r8 = super.onKeyDown(r8, r9)
            return r8
        L_0x0085:
            if (r8 == r6) goto L_0x0098
            if (r8 == r5) goto L_0x0098
            if (r8 == r4) goto L_0x0098
            if (r8 == r3) goto L_0x0098
            if (r8 == r2) goto L_0x0098
            r0 = 187(0xbb, float:2.62E-43)
            if (r8 == r0) goto L_0x0098
            boolean r8 = super.onKeyDown(r8, r9)
            return r8
        L_0x0098:
            r8 = 2131689550(0x7f0f004e, float:1.9008119E38)
            r7.toastTop((int) r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.ImagesActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MyTimer myTimer = this.f6639S;
        if (myTimer != null) {
            myTimer.stop();
        }
        m4871w0();
        try {
            ShakeEventListener shakeEventListener = this.f6634N;
            if (shakeEventListener != null) {
                this.f6633M.unregisterListener(shakeEventListener);
            }
        } catch (Exception e) {
            CatchException.logException(e);
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 23) {
            int length = iArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                toastTop((int) C1441R.string.permissionNotGranted);
            } else if (this.f6653w == 3) {
                setRingtone();
            } else {
                m4851c0();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SensorManager sensorManager = this.f6633M;
        sensorManager.registerListener(this.f6634N, sensorManager.getDefaultSensor(1), 2);
        ((ToggleButton) findViewById(C1441R.C1443id.lock)).setChecked(this.lock);
        ((ToggleButton) findViewById(C1441R.C1443id.slideshow)).setChecked(this.f6628H);
        int i = 0;
        if (this.f6628H) {
            MyTimer myTimer = this.f6639S;
            if (myTimer != null) {
                myTimer.start();
            }
            DonutProgress donutProgress = this.f6640T;
            if (donutProgress != null) {
                this.f6641U = 0;
                donutProgress.setProgress(0);
            }
        }
        DonutProgress donutProgress2 = this.f6640T;
        if (donutProgress2 != null) {
            if (!this.f6628H) {
                i = 4;
            }
            donutProgress2.setVisibility(i);
        }
        if (this.lock) {
            m4854f0();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("mPosition", this.f6627G);
        bundle.putBoolean("slideshow_run", this.f6628H);
        Uri uri = this.f6649s;
        if (uri != null) {
            bundle.putString("newRingtoneUri", uri.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        setActualImage(0);
        setVolumeControlStream(3);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f6636P.releaseImages();
    }

    public void onSwitchBack(View view) {
        int i = this.f6627G;
        DonutProgress donutProgress = this.f6640T;
        this.f6641U = 0;
        donutProgress.setProgress(0);
        MyTimer myTimer = this.f6639S;
        if (myTimer != null && this.f6628H) {
            myTimer.resetCounter();
        }
        if (this.f6629I) {
            int shuffleAnimal = shuffleAnimal(false, i);
            this.f6627G = shuffleAnimal;
            this.mSwitchedPosition = this.f6626F.getSwitchedPosition(shuffleAnimal);
        } else {
            int i2 = this.f6627G;
            if (i2 == 0) {
                this.f6627G = this.f6626F.size() - 1;
            } else {
                this.f6627G = i2 - 1;
            }
            this.mSwitchedPosition = this.f6626F.getSwitchedPosition(this.f6627G);
            while (!m4855g0(this.mSwitchedPosition)) {
                int i3 = this.f6627G;
                if (i3 == 0) {
                    this.f6627G = this.f6626F.size() - 1;
                } else {
                    this.f6627G = i3 - 1;
                }
                this.mSwitchedPosition = this.f6626F.getSwitchedPosition(this.f6627G);
            }
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C1441R.anim.from_left);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, C1441R.anim.to_right);
        this.f6650t.setInAnimation(loadAnimation);
        this.f6650t.setOutAnimation(loadAnimation2);
        m4863o0(this.mSwitchedPosition);
        this.f6650t.setText(this.f6621A.get(this.mSwitchedPosition));
        if (this.f6652v) {
            this.f6651u.setText(this.f6622B[this.mSwitchedPosition]);
        }
        setActualImage(2);
        m4867s0();
        playSound(false);
        m4869u0(false, false);
    }

    public void onSwitchNext(View view) {
        int i = this.f6627G;
        DonutProgress donutProgress = this.f6640T;
        this.f6641U = 0;
        donutProgress.setProgress(0);
        MyTimer myTimer = this.f6639S;
        if (myTimer != null && this.f6628H) {
            myTimer.resetCounter();
        }
        if (this.f6629I) {
            int shuffleAnimal = shuffleAnimal(true, i);
            this.f6627G = shuffleAnimal;
            this.mSwitchedPosition = this.f6626F.getSwitchedPosition(shuffleAnimal);
        } else {
            int size = (this.f6627G + 1) % this.f6626F.size();
            this.f6627G = size;
            this.mSwitchedPosition = this.f6626F.getSwitchedPosition(size);
            while (!m4855g0(this.mSwitchedPosition)) {
                int size2 = (this.f6627G + 1) % this.f6626F.size();
                this.f6627G = size2;
                this.mSwitchedPosition = this.f6626F.getSwitchedPosition(size2);
            }
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C1441R.anim.from_right);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, C1441R.anim.to_left);
        this.f6650t.setInAnimation(loadAnimation);
        this.f6650t.setOutAnimation(loadAnimation2);
        m4863o0(this.mSwitchedPosition);
        this.f6650t.setText(this.f6621A.get(this.mSwitchedPosition));
        if (this.f6652v) {
            this.f6651u.setText(this.f6622B[this.mSwitchedPosition]);
        }
        setActualImage(1);
        m4867s0();
        playSound(false);
        m4869u0(false, false);
    }

    public void openSlideUpPanel() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.f6647a0;
        if (slidingUpPanelLayout != null) {
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void playSound(boolean r11) {
        /*
            r10 = this;
            r10.m4871w0()
            java.util.ArrayList<java.lang.String> r0 = r10.f6623C
            int r1 = r10.mSwitchedPosition
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r10.f6638R
            java.lang.String r2 = "l_"
            r3 = 1
            if (r1 == r3) goto L_0x0019
            r4 = 3
            if (r1 == r4) goto L_0x0019
            if (r11 == 0) goto L_0x002e
        L_0x0019:
            boolean r1 = r10.f6642V
            if (r1 == 0) goto L_0x002e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r5 = r1
            goto L_0x002f
        L_0x002e:
            r5 = r0
        L_0x002f:
            if (r11 != 0) goto L_0x004d
            boolean r11 = r10.f6642V
            if (r11 == 0) goto L_0x004d
            int r11 = r10.f6638R
            if (r11 != r3) goto L_0x003a
            goto L_0x004e
        L_0x003a:
            r1 = 2
            if (r11 != r1) goto L_0x004d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r2)
            r11.append(r0)
            java.lang.String r0 = r11.toString()
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            r6 = r0
            com.medio.audioplayer.AudioPlayer r4 = r10.f6632L
            if (r4 == 0) goto L_0x0062
            boolean r7 = r10.f6644X
            if (r7 == 0) goto L_0x005f
            boolean r8 = r10.f6643W
            java.lang.String r9 = r10.mLang
            r4.playByName(r5, r6, r7, r8, r9)
            goto L_0x0062
        L_0x005f:
            r4.playByName(r5, r6)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.ImagesActivity.playSound(boolean):void");
    }

    public boolean saveLikeListInSharedPreferences() {
        SharedPreferences.Editor edit = getSharedPreferences(MainActivity.PREFERENCES_NAME, 0).edit();
        edit.putInt("Like_size", this.f6631K.size());
        for (int i = 0; i < this.f6631K.size(); i++) {
            edit.remove("Like_" + i);
            edit.putInt("Like_" + i, this.f6631K.get(i).intValue());
        }
        return edit.commit();
    }

    public void setActualImage(char c) {
        Resources resources = getResources();
        Context context = this.mContext;
        Resources resources2 = getResources();
        int photoId = getPhotoId(this.mSwitchedPosition);
        DisplayMetrics displayMetrics = this.metrics;
        this.f6636P.setActualImage(new RecyclingBitmapDrawable(resources, BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(context, resources2, photoId, displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.ARGB_8888)), c);
    }

    public void setImageAsWallpaper() {
        int i;
        int i2;
        Bitmap bitmap;
        WallpaperManager instance = WallpaperManager.getInstance(this.mContext);
        int desiredMinimumWidth = instance.getDesiredMinimumWidth();
        int desiredMinimumHeight = instance.getDesiredMinimumHeight();
        if (desiredMinimumWidth != desiredMinimumHeight) {
            instance.setWallpaperOffsetSteps(1.0f, 1.0f);
            DisplayMetrics displayMetrics = this.metrics;
            instance.suggestDesiredDimensions(displayMetrics.widthPixels, displayMetrics.heightPixels);
            desiredMinimumWidth = instance.getDesiredMinimumWidth();
            desiredMinimumHeight = instance.getDesiredMinimumHeight();
        }
        if (desiredMinimumWidth <= 0 || desiredMinimumHeight <= 0) {
            DisplayMetrics displayMetrics2 = this.metrics;
            int i3 = displayMetrics2.widthPixels;
            i = displayMetrics2.heightPixels;
            i2 = i3;
        } else {
            i2 = desiredMinimumWidth;
            i = desiredMinimumHeight;
        }
        if (i2 <= 0 || i <= 0) {
            Context context = this.mContext;
            Resources resources = getResources();
            int photoId = getPhotoId(this.mSwitchedPosition);
            DisplayMetrics displayMetrics3 = this.metrics;
            bitmap = BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(context, resources, photoId, displayMetrics3.widthPixels, displayMetrics3.heightPixels, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(this.mContext, getResources(), getPhotoId(this.mSwitchedPosition), i2, i, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmap2 = bitmap;
        LibraryWallpaperBitmaps libraryWallpaperBitmaps = new LibraryWallpaperBitmaps();
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap2 = libraryWallpaperBitmaps.prepareBitmap(libraryWallpaperBitmaps.scaleBitmap(bitmap2, "autofit", instance, this.metrics, (double) i2, (double) i), instance, i2, i);
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                try {
                    instance.setBitmap(bitmap2);
                    toastTop((int) C1441R.string.success);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        DialogInterface dialogInterface = this.f6654x;
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.f6654x = null;
        }
    }

    public void setImageFromBottomGalleryClick(int i) {
        playSound(false);
    }

    public void setImageFromSideGalleryClick(int i) {
        if (m4855g0(i)) {
            this.f6627G = this.f6626F.indexOf(i);
            this.mSwitchedPosition = i;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, C1441R.anim.from_right);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, C1441R.anim.to_left);
            this.f6650t.setInAnimation(loadAnimation);
            this.f6650t.setOutAnimation(loadAnimation2);
            m4863o0(this.mSwitchedPosition);
            this.f6650t.setText(this.f6621A.get(this.mSwitchedPosition));
            if (this.f6652v) {
                this.f6651u.setText(this.f6622B[this.mSwitchedPosition]);
            }
            setActualImage(1);
            m4867s0();
            playSound(false);
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(C1441R.C1443id.drawer_layout);
            if (drawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                drawerLayout.closeDrawer((int) GravityCompat.START);
            }
            m4869u0(false, false);
        }
        if (this.f6628H) {
            MyTimer myTimer = this.f6639S;
            if (myTimer != null) {
                myTimer.resetCounter();
            }
            DonutProgress donutProgress = this.f6640T;
            if (donutProgress != null) {
                this.f6641U = 0;
                donutProgress.setProgress(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRingtone() {
        /*
            r17 = this;
            r1 = r17
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r3 = 2131689518(0x7f0f002e, float:1.9008054E38)
            java.lang.String r3 = r1.getString(r3)
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            java.util.ArrayList<java.lang.String> r3 = r1.f6621A
            int r4 = r1.mSwitchedPosition
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            int r0 = r1.f6653w
            r4 = 3
            r5 = 4
            r6 = 2
            r7 = 1
            if (r0 == r7) goto L_0x0044
            if (r0 == r6) goto L_0x0041
            if (r0 == r4) goto L_0x0044
            if (r0 == r5) goto L_0x003e
            java.lang.String r0 = android.os.Environment.DIRECTORY_RINGTONES
            goto L_0x0046
        L_0x003e:
            java.lang.String r0 = android.os.Environment.DIRECTORY_ALARMS
            goto L_0x0046
        L_0x0041:
            java.lang.String r0 = android.os.Environment.DIRECTORY_NOTIFICATIONS
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = android.os.Environment.DIRECTORY_RINGTONES
        L_0x0046:
            r8 = 0
            r1.f6649s = r8
            android.content.Context r9 = r1.mContext
            java.io.File r0 = getBestAvailableFilesDir(r9, r0)
            if (r0 == 0) goto L_0x0232
            java.lang.String r10 = "ogg"
            java.util.ArrayList<java.lang.String> r11 = r1.f6623C
            int r12 = r1.mSwitchedPosition
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r11 = r11.toString()
            java.io.File r12 = new java.io.File
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r11)
            java.lang.String r14 = "."
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            r12.<init>(r0, r13)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r13 = "android.resource://"
            r0.append(r13)
            java.lang.String r13 = r17.getPackageName()
            r0.append(r13)
            java.lang.String r13 = "/raw/"
            r0.append(r13)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.ContentResolver r11 = r17.getContentResolver()
            java.lang.String r13 = "r"
            android.content.res.AssetFileDescriptor r0 = r11.openAssetFileDescriptor(r0, r13)     // Catch:{ FileNotFoundException -> 0x00a6 }
            goto L_0x00b6
        L_0x00a6:
            r0 = move-exception
            android.content.Context r13 = r1.mContext
            boolean r13 = com.medio.myutilities.Utilities.isDebugable(r13)
            if (r13 == 0) goto L_0x00b2
            r0.getMessage()
        L_0x00b2:
            com.medio.catchexception.CatchException.logException(r0)
            r0 = r8
        L_0x00b6:
            boolean r13 = r12.exists()
            if (r13 != 0) goto L_0x00f5
            if (r0 == 0) goto L_0x00f5
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r13 = new byte[r13]     // Catch:{ IOException -> 0x00df }
            java.io.FileInputStream r0 = r0.createInputStream()     // Catch:{ IOException -> 0x00df }
            java.io.FileOutputStream r14 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00df }
            r14.<init>(r12)     // Catch:{ IOException -> 0x00df }
            int r15 = r0.read(r13)     // Catch:{ IOException -> 0x00df }
        L_0x00cf:
            r9 = -1
            if (r15 == r9) goto L_0x00db
            r9 = 0
            r14.write(r13, r9, r15)     // Catch:{ IOException -> 0x00df }
            int r15 = r0.read(r13)     // Catch:{ IOException -> 0x00df }
            goto L_0x00cf
        L_0x00db:
            r14.close()     // Catch:{ IOException -> 0x00df }
            goto L_0x00f5
        L_0x00df:
            r0 = move-exception
            android.content.Context r9 = r1.mContext
            boolean r9 = com.medio.myutilities.Utilities.isDebugable(r9)
            if (r9 == 0) goto L_0x00eb
            r0.getMessage()
        L_0x00eb:
            com.medio.catchexception.CatchException.logException(r0)
            r0 = 2131689582(0x7f0f006e, float:1.9008183E38)
            r1.toastTop((int) r0)
            r12 = r8
        L_0x00f5:
            if (r12 == 0) goto L_0x0216
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            int r9 = r1.f6653w
            java.lang.String r13 = "is_ringtone"
            if (r9 == r7) goto L_0x011e
            java.lang.String r14 = "is_notification"
            if (r9 == r6) goto L_0x011a
            if (r9 == r4) goto L_0x011e
            java.lang.String r15 = "is_alarm"
            if (r9 == r5) goto L_0x0116
            r0.put(r13, r2)
            r0.put(r14, r2)
            r0.put(r15, r2)
            goto L_0x0121
        L_0x0116:
            r0.put(r15, r2)
            goto L_0x0121
        L_0x011a:
            r0.put(r14, r2)
            goto L_0x0121
        L_0x011e:
            r0.put(r13, r2)
        L_0x0121:
            java.lang.String r2 = r12.getAbsolutePath()
            android.net.Uri r2 = android.provider.MediaStore.Audio.Media.getContentUriForPath(r2)
            if (r11 == 0) goto L_0x01fa
            java.lang.String r9 = r12.getAbsolutePath()
            long r13 = r1.m4853e0(r2, r9, r11)
            r15 = -1
            int r9 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r9 != 0) goto L_0x0186
            java.lang.String r9 = "_data"
            java.lang.String r13 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x0181 }
            r0.put(r9, r13)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r9 = "title"
            r0.put(r9, r3)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r3 = "_size"
            long r12 = r12.length()     // Catch:{ Exception -> 0x0181 }
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x0181 }
            r0.put(r3, r9)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r3 = "mime_type"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0181 }
            r9.<init>()     // Catch:{ Exception -> 0x0181 }
            java.lang.String r12 = "audio/"
            r9.append(r12)     // Catch:{ Exception -> 0x0181 }
            r9.append(r10)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0181 }
            r0.put(r3, r9)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r3 = "artist"
            java.lang.String r9 = r17.m4852d0()     // Catch:{ Exception -> 0x0181 }
            r0.put(r3, r9)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r3 = "is_music"
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0181 }
            r0.put(r3, r9)     // Catch:{ Exception -> 0x0181 }
            android.net.Uri r0 = r11.insert(r2, r0)     // Catch:{ Exception -> 0x0181 }
            r1.f6649s = r0     // Catch:{ Exception -> 0x0181 }
            goto L_0x01a5
        L_0x0181:
            r0 = move-exception
            com.medio.catchexception.CatchException.logException(r0)
            goto L_0x01a5
        L_0x0186:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a1 }
            r3.<init>()     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r9 = "_id="
            r3.append(r9)     // Catch:{ Exception -> 0x01a1 }
            r3.append(r13)     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01a1 }
            r11.update(r2, r0, r3, r8)     // Catch:{ Exception -> 0x01a1 }
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r2, r13)     // Catch:{ Exception -> 0x01a1 }
            r1.f6649s = r0     // Catch:{ Exception -> 0x01a1 }
            goto L_0x01a5
        L_0x01a1:
            r0 = move-exception
            com.medio.catchexception.CatchException.logException(r0)
        L_0x01a5:
            android.net.Uri r0 = r1.f6649s
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "2131689581 3"
            r1.toastTop((java.lang.String) r0)
            return
        L_0x01af:
            int r2 = r1.f6653w     // Catch:{ Exception -> 0x01ef }
            r3 = 2131689606(0x7f0f0086, float:1.9008232E38)
            if (r2 == r7) goto L_0x01e6
            if (r2 == r6) goto L_0x01dd
            if (r2 == r4) goto L_0x01c8
            if (r2 == r5) goto L_0x01be
            goto L_0x024d
        L_0x01be:
            android.content.Context r2 = r1.mContext     // Catch:{ Exception -> 0x01ef }
            android.media.RingtoneManager.setActualDefaultRingtoneUri(r2, r5, r0)     // Catch:{ Exception -> 0x01ef }
            r1.toastTop((int) r3)     // Catch:{ Exception -> 0x01ef }
            goto L_0x024d
        L_0x01c8:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x01ef }
            java.lang.String r2 = "android.intent.action.PICK"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01ef }
            android.net.Uri r2 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch:{ Exception -> 0x01ef }
            java.lang.String r3 = "vnd.android.cursor.dir/phone_v2"
            r0.setDataAndType(r2, r3)     // Catch:{ Exception -> 0x01ef }
            r2 = 73729(0x12001, float:1.03316E-40)
            r1.startActivityForResult(r0, r2)     // Catch:{ Exception -> 0x01ef }
            goto L_0x024d
        L_0x01dd:
            android.content.Context r2 = r1.mContext     // Catch:{ Exception -> 0x01ef }
            android.media.RingtoneManager.setActualDefaultRingtoneUri(r2, r6, r0)     // Catch:{ Exception -> 0x01ef }
            r1.toastTop((int) r3)     // Catch:{ Exception -> 0x01ef }
            goto L_0x024d
        L_0x01e6:
            android.content.Context r2 = r1.mContext     // Catch:{ Exception -> 0x01ef }
            android.media.RingtoneManager.setActualDefaultRingtoneUri(r2, r7, r0)     // Catch:{ Exception -> 0x01ef }
            r1.toastTop((int) r3)     // Catch:{ Exception -> 0x01ef }
            goto L_0x024d
        L_0x01ef:
            r0 = move-exception
            com.medio.catchexception.CatchException.logException(r0)
            r0 = 2131689570(0x7f0f0062, float:1.900816E38)
            r1.toastTop((int) r0)
            goto L_0x024d
        L_0x01fa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 2131689581(0x7f0f006d, float:1.9008181E38)
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            java.lang.String r2 = " 5"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.toastTop((java.lang.String) r0)
            goto L_0x024d
        L_0x0216:
            r2 = 2131689581(0x7f0f006d, float:1.9008181E38)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            java.lang.String r2 = " 2"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.toastTop((java.lang.String) r0)
            goto L_0x024d
        L_0x0232:
            r2 = 2131689581(0x7f0f006d, float:1.9008181E38)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            java.lang.String r2 = " 1"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.toastTop((java.lang.String) r0)
        L_0x024d:
            android.content.DialogInterface r0 = r1.f6654x
            if (r0 == 0) goto L_0x0256
            r0.dismiss()
            r1.f6654x = r8
        L_0x0256:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dream_studio.animalsounds.ImagesActivity.setRingtone():void");
    }

    public void setSecondLanguage(Locale locale) {
        ((RelativeLayout) findViewById(C1441R.C1443id.textSwitcherBottomBar)).setVisibility(0);
        this.f6622B = getSecondNames(locale);
        String language = locale.getLanguage();
        this.f6655y = language;
        Languages languages = this.mSecondLanguages;
        languages.selectedItem = languages.checkLanguagePosition(language, locale.getCountry());
        this.f6651u.setText(this.f6622B[this.mSwitchedPosition]);
        Languages languages2 = this.mSecondLanguages;
        ((ImageView) findViewById(C1441R.C1443id.flagButton)).setBackgroundResource(languages2.getLanguagePictureResId(languages2.langList.get(languages2.selectedItem).langListLocale.getLanguage(), locale.getCountry()));
        m4866r0(getResources().getDimension(C1441R.dimen.animal_title_size_small));
        this.f6652v = true;
    }

    public void showLanguageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(C1441R.string.changeLangTitle));
        Languages languages = new Languages();
        languages.selectedItem = this.mSecondLanguages.selectedItem;
        LangListAdapter langListAdapter = new LangListAdapter(this, C1441R.layout.lang_list_item, languages);
        builder.setSingleChoiceItems(langListAdapter, this.mSecondLanguages.selectedItem, new C1392l(this, languages, langListAdapter));
        builder.setPositiveButton(getResources().getString(C1441R.string.buttonOK), new C1393m(languages));
        builder.setNegativeButton(getResources().getString(C1441R.string.buttonCancel), new C1394n(this));
        AlertDialog create = builder.create();
        this.mModelessDialog = create;
        create.setOnDismissListener(new C1395o());
        this.mModelessDialog.setOwnerActivity(this);
        mo10301s();
        this.mModelessDialog.show();
    }

    public int shuffleAnimal(boolean z, int i) {
        ListIterator<Integer> listIterator = this.f6630J.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().intValue() == i) {
                if (!z) {
                    listIterator.previous();
                    if (listIterator.hasPrevious()) {
                        return listIterator.previous().intValue();
                    }
                    ArrayList<Integer> arrayList = this.f6630J;
                    return arrayList.get(arrayList.size() - 1).intValue();
                } else if (listIterator.hasNext()) {
                    return listIterator.next().intValue();
                } else {
                    return this.f6630J.get(0).intValue();
                }
            }
        }
        return 0;
    }

    public void updateBottomGallery(long j) {
        this.f6648b0 = new LoadBottomGalleryLinks((ImagesActivity) this.mContext, j);
    }
}
