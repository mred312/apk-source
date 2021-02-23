package com.dream_studio.animalsounds;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import com.dream_studio.animalsounds.util.Utilities;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.medio.catchexception.CatchException;
import com.medio.locale.LocaleManager;
import com.medio.myutilities.BitmapLoaderFromResource;
import com.medio.myutilities.LanguagesBase;
import com.medio.myutilities.Utilities;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends BaseActivity {
    public static final int DO_NOTHING = 0;
    public static final int IMAGES_ACTIVITY = 1;
    public static final long MIN_SPACE_VALUE = 3145728;
    public static final String PREFERENCES_NAME = "ASAPpreferences";
    public static final int PRONUNCIATION_DISCARDED = 255;
    public static final int PRONUNCIATION_NONE = -1;
    public static final int SHOW_TALK_OPTIONS_DLG = 1;
    public static final int SPEAK_NAME_FIRST = 1;
    public static final int SPEAK_NAME_LAST = 2;
    public static final int SPEAK_NAME_NONE = 0;
    public static final int SPEAK_NAME_ONLY = 3;
    public static final boolean START = true;
    public static final boolean STOP = false;
    public final Languages mLanguages = new Languages();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SharedPreferences f6702n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f6703o = false;

    /* renamed from: p */
    private boolean f6704p = false;

    /* renamed from: q */
    private String f6705q = "";
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f6706r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f6707s = 0;

    /* renamed from: t */
    private Animation f6708t = null;

    /* renamed from: u */
    private ArrayList<Integer> f6709u = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public String f6710v = "";

    /* renamed from: w */
    FirebaseRemoteConfig f6711w = null;

    /* renamed from: x */
    private boolean f6712x = false;

    /* renamed from: y */
    private View.OnClickListener f6713y = new C1430s();

    /* renamed from: com.dream_studio.animalsounds.MainActivity$a */
    class C1412a implements DialogInterface.OnDismissListener {
        C1412a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.setMuteButton();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$b */
    class C1413b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f6715a;

        /* renamed from: b */
        final /* synthetic */ Dialog f6716b;

        C1413b(int i, Dialog dialog) {
            this.f6715a = i;
            this.f6716b = dialog;
        }

        public void onClick(View view) {
            SharedPreferences.Editor edit = MainActivity.this.f6702n.edit();
            edit.putInt("runCnt", this.f6715a + 1);
            edit.apply();
            this.f6716b.dismiss();
            MainActivity.this.finish();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$c */
    class C1414c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Dialog f6718a;

        C1414c(MainActivity mainActivity, Dialog dialog) {
            this.f6718a = dialog;
        }

        public void onClick(View view) {
            this.f6718a.cancel();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$d */
    class C1415d implements View.OnClickListener {
        C1415d() {
        }

        public void onClick(View view) {
            boolean unused = MainActivity.this.f6703o = true;
            MainActivity.this.m4902V();
            MainActivity mainActivity = MainActivity.this;
            mainActivity.m4901U(mainActivity.getPackageName());
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$e */
    class C1416e implements View.OnClickListener {
        C1416e() {
        }

        public void onClick(View view) {
            boolean unused = MainActivity.this.f6703o = true;
            MainActivity.this.m4902V();
            MainActivity mainActivity = MainActivity.this;
            mainActivity.m4901U(mainActivity.getPackageName());
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$f */
    class C1417f implements View.OnClickListener {
        C1417f() {
        }

        public void onClick(View view) {
            MainActivity.this.showOtherAppDialog();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$g */
    class C1418g implements View.OnClickListener {
        C1418g() {
        }

        public void onClick(View view) {
            MainActivity.this.showOtherAppDialog();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$h */
    class C1419h implements DialogInterface.OnDismissListener {
        C1419h() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.setMuteButton();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$i */
    class C1420i implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ LanguagesBase.language f6724a;

        /* renamed from: b */
        final /* synthetic */ int f6725b;

        C1420i(LanguagesBase.language language, int i) {
            this.f6724a = language;
            this.f6725b = i;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            MainActivity.this.m4895N(this.f6724a, this.f6725b);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$j */
    class C1421j implements DialogInterface.OnClickListener {
        C1421j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.setPronunStatusSharedPreferences(255);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$k */
    class C1422k implements OnFailureListener {
        C1422k() {
        }

        public void onFailure(@NonNull Exception exc) {
            MainActivity.this.createAdsIfInitialized(true, true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$l */
    class C1423l implements DialogInterface.OnDismissListener {
        C1423l() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.setMuteButton();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$m */
    class C1424m implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f6730a;

        C1424m(int i) {
            this.f6730a = i;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            MainActivity mainActivity = MainActivity.this;
            Languages languages = mainActivity.mLanguages;
            mainActivity.m4895N(languages.langList.get(languages.selectedItem), this.f6730a);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$n */
    class C1425n implements DialogInterface.OnClickListener {
        C1425n(MainActivity mainActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$o */
    class C1426o implements DialogInterface.OnClickListener {
        C1426o(MainActivity mainActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$p */
    class C1427p implements DialogInterface.OnDismissListener {
        C1427p() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.setMuteButton();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$q */
    class C1428q extends AdListener {
        C1428q() {
        }

        public void onAdClosed() {
            super.onAdClosed();
            MainActivity.this.loadInterstitial();
            MainActivity.this.showQuitDialog();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$r */
    class C1429r implements OnCompleteListener<Boolean> {
        C1429r() {
        }

        public void onComplete(@NonNull Task<Boolean> task) {
            if (task.isSuccessful()) {
                task.getResult().booleanValue();
                MainActivity mainActivity = MainActivity.this;
                mainActivity.mShowTransitionInterstitial = mainActivity.f6711w.getBoolean("transition_interstitial_enable");
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.mShowQuitInterstitial = mainActivity2.f6711w.getBoolean("quit_interstitial_enable");
                MainActivity mainActivity3 = MainActivity.this;
                mainActivity3.mShowBannerAds = mainActivity3.f6711w.getBoolean("lower_banner_enable");
                MainActivity mainActivity4 = MainActivity.this;
                mainActivity4.mChangeSmartBannerToBanner = mainActivity4.f6711w.getBoolean("change_smart_banner_to_banner");
                MainActivity mainActivity5 = MainActivity.this;
                mainActivity5.mChangeSmartBannerToNativeBanner = mainActivity5.f6711w.getBoolean("change_smart_banner_to_native_banner");
                MainActivity mainActivity6 = MainActivity.this;
                mainActivity6.mShowAdaptiveBanner = mainActivity6.f6711w.getBoolean("show_adaptive_banner");
                MainActivity mainActivity7 = MainActivity.this;
                mainActivity7.mBannerIdChoice = mainActivity7.f6711w.getLong("lower_banner_id_choice");
                MainActivity.this.createAdsIfInitialized(true, true);
            }
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$s */
    class C1430s implements View.OnClickListener {
        C1430s() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id != C1441R.C1443id.mute) {
                if (id != C1441R.C1443id.text_language) {
                    switch (id) {
                        case C1441R.C1443id.button_category:
                            MainActivity.this.showCategoryChoiceDialog();
                            return;
                        case C1441R.C1443id.button_flag:
                            break;
                        case C1441R.C1443id.button_like:
                            if (MainActivity.this.m4896P()) {
                                MainActivity.this.m4900T(99);
                                return;
                            } else {
                                MainActivity.this.toastBottom((int) C1441R.string.like_list_empty);
                                return;
                            }
                        case C1441R.C1443id.button_menu:
                            MainActivity.this.m4898R();
                            return;
                        case C1441R.C1443id.button_random:
                            MainActivity mainActivity = MainActivity.this;
                            boolean unused = mainActivity.f6706r = !mainActivity.f6706r;
                            ((ToggleButton) MainActivity.this.findViewById(C1441R.C1443id.button_random)).setChecked(MainActivity.this.f6706r);
                            if (MainActivity.this.f6706r) {
                                MainActivity.this.toastBottom((int) C1441R.string.shuffle_info);
                                return;
                            } else {
                                MainActivity.this.toastBottom((int) C1441R.string.sort_info);
                                return;
                            }
                        case C1441R.C1443id.button_share:
                            MainActivity.this.shareApp();
                            return;
                        case C1441R.C1443id.button_zwierzeta:
                            MainActivity.this.m4900T(98);
                            return;
                        default:
                            return;
                    }
                }
                MainActivity mainActivity2 = MainActivity.this;
                Utilities.showLanguageDialog(mainActivity2.mContext, mainActivity2.mLanguages);
                return;
            }
            MainActivity.this.mVolumeControl.controlSysVolume(0, false, true);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$t */
    class C1431t implements Runnable {
        C1431t() {
        }

        public void run() {
            MobileAds.initialize(MainActivity.this.getApplicationContext());
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$u */
    class C1432u implements DialogInterface.OnClickListener {
        C1432u() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            MainActivity.this.m4900T(i);
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$v */
    class C1433v implements DialogInterface.OnDismissListener {
        C1433v() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.setMuteButton();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$w */
    class C1434w implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ ListMenu f6739a;

        C1434w(ListMenu listMenu) {
            this.f6739a = listMenu;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            switch (this.f6739a.menuListArray.get(i).listItemImage) {
                case C1441R.C1442drawable.menu_buttons_flag:
                    MainActivity mainActivity = MainActivity.this;
                    Utilities.showLanguageDialog(mainActivity.mContext, mainActivity.mLanguages);
                    break;
                case C1441R.C1442drawable.menu_buttons_hand:
                    boolean unused = MainActivity.this.f6703o = true;
                    MainActivity.this.m4902V();
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.m4901U(mainActivity2.getPackageName());
                    break;
                case C1441R.C1442drawable.menu_buttons_message:
                    String str = "";
                    try {
                        PackageInfo packageInfo = MainActivity.this.getPackageManager().getPackageInfo(MainActivity.this.getPackageName(), 0);
                        str = packageInfo.versionName;
                        i2 = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        i2 = 0;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String format = String.format(MainActivity.this.getString(C1441R.string.sendErrorTitle), new Object[]{MainActivity.this.getString(C1441R.string.app_name), str, Integer.valueOf(i2), MainActivity.this.f6710v, Build.VERSION.RELEASE, Build.MANUFACTURER, Build.MODEL});
                    intent.setData(Uri.parse("mailto:?subject=" + format + "&body=&to=" + MainActivity.this.getString(C1441R.string.sendErrorEmail)));
                    try {
                        MainActivity.this.startActivity(intent);
                        break;
                    } catch (ActivityNotFoundException unused2) {
                        MainActivity.this.toastBottom((int) C1441R.string.emailClientNotInstalledTxt);
                        break;
                    }
                case C1441R.C1442drawable.menu_buttons_more:
                    MainActivity.this.showOtherAppDialog();
                    break;
                case C1441R.C1442drawable.menu_buttons_pronunciation:
                    MainActivity.this.showTalkOptionDialog();
                    break;
                case C1441R.C1442drawable.menu_buttons_share:
                    MainActivity.this.shareApp();
                    break;
                case C1441R.C1442drawable.menu_buttons_termofuse:
                    Utilities.showTermsOfUseDialog((Activity) MainActivity.this.mContext);
                    break;
            }
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$x */
    class C1435x implements DialogInterface.OnDismissListener {
        C1435x() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            MainActivity.this.setMuteButton();
        }
    }

    /* renamed from: com.dream_studio.animalsounds.MainActivity$y */
    class C1436y implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TalkListAdapter f6742a;

        C1436y(TalkListAdapter talkListAdapter) {
            this.f6742a = talkListAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                int unused = MainActivity.this.f6707s = 0;
            } else if (i == 1) {
                int unused2 = MainActivity.this.f6707s = 1;
            } else if (i != 2) {
                int unused3 = MainActivity.this.f6707s = 0;
            } else {
                int unused4 = MainActivity.this.f6707s = 2;
            }
            this.f6742a.setSelected(i);
            this.f6742a.notifyDataSetChanged();
            SharedPreferences.Editor edit = MainActivity.this.f6702n.edit();
            edit.putInt("talkSet", MainActivity.this.f6707s);
            edit.apply();
            dialogInterface.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m4895N(LanguagesBase.language language, int i) {
        if (!com.medio.myutilities.Utilities.checkNetworkConnection(this.mContext)) {
            showErrorDialog(C1441R.string.noInternetConn, true, i);
        } else if (getFilesDir().getFreeSpace() < MIN_SPACE_VALUE) {
            showErrorDialog(C1441R.string.insuficientMemory, false, 0);
        } else {
            String file = getFilesDir().toString();
            String format = String.format(Locale.ENGLISH, getString(C1441R.string.downloadFileName), new Object[]{language.langListLocale.getLanguage(), Byte.valueOf((byte) language.pronunVer)});
            C1466a aVar = new C1466a(this.mContext, i, (byte) language.pronunVer);
            aVar.execute(new String[]{getString(C1441R.string.downloadServerUrl) + format, file, format});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public boolean m4896P() {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(C1441R.array.animals);
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < this.f6709u.size()) {
                int intValue = this.f6709u.get(i).intValue();
                if (intValue < obtainTypedArray.length() && !obtainTypedArray.getString(intValue).contentEquals("--")) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        obtainTypedArray.recycle();
        ImageButton imageButton = (ImageButton) findViewById(C1441R.C1443id.button_like);
        if (z) {
            imageButton.setBackgroundResource(C1441R.C1442drawable.button_main_like);
        } else {
            imageButton.setBackgroundResource(C1441R.C1442drawable.button_main_like_empty);
        }
        return z;
    }

    /* renamed from: Q */
    private void m4897Q() {
        InterstitialAd interstitialAd;
        if (this.mRemoveAds || !this.mShowQuitInterstitial || (interstitialAd = this.mInterstitial) == null || !interstitialAd.isLoaded()) {
            showQuitDialog();
            return;
        }
        this.mInterstitial.setAdListener(new C1428q());
        this.mInterstitial.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void m4898R() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        ListMenu listMenu = new ListMenu(this.mContext);
        MenuListAdapter menuListAdapter = new MenuListAdapter(this.mContext, C1441R.layout.menu_list_item, listMenu);
        Languages languages = this.mLanguages;
        if (!languages.langList.get(languages.selectedItem).langSound) {
            listMenu.removeItem(C1441R.C1442drawable.menu_buttons_pronunciation);
        }
        builder.setSingleChoiceItems(menuListAdapter, -1, new C1434w(listMenu));
        AlertDialog create = builder.create();
        create.setOnDismissListener(new C1435x());
        create.setOwnerActivity((Activity) this.mContext);
        create.show();
    }

    /* renamed from: S */
    private void m4899S(LanguagesBase.language language, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(getString(C1441R.string.downloadQuestion));
        builder.setPositiveButton(C1441R.string.yesBtnTxt, new C1420i(language, i));
        builder.setNegativeButton(C1441R.string.noBtnTxt, new C1421j());
        AlertDialog create = builder.create();
        create.setOnDismissListener(new C1423l());
        create.setOwnerActivity(this);
        create.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m4900T(int i) {
        Intent intent = new Intent(getApplicationContext(), ImagesActivity.class);
        intent.putExtra("type", (byte) i);
        intent.putExtra("random", this.f6706r);
        intent.putExtra("is_second_language", this.f6704p);
        intent.putExtra("second_language", this.f6705q);
        intent.putExtra("showTransInterstitial", this.mShowTransitionInterstitial);
        intent.putExtra("showQuitInterstitial", false);
        intent.putExtra("showBannerAds", this.mShowBannerAds);
        intent.putExtra("changeSmartBannerToBanner", this.mChangeSmartBannerToBanner);
        intent.putExtra("changeSmartBannerToNativeBanner", this.mChangeSmartBannerToNativeBanner);
        intent.putExtra("showAdaptiveBanner", this.mShowAdaptiveBanner);
        intent.putExtra("bannerIdChoice", this.mBannerIdChoice);
        intent.putExtra("talkSet", this.f6707s);
        Languages languages = this.mLanguages;
        intent.putExtra("isSpeaker", languages.langList.get(languages.selectedItem).langSound);
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m4901U(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(getString(C1441R.string.playAppStore) + str));
        try {
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(getString(C1441R.string.playAppUri) + str));
            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivity(intent2);
            } else {
                toastBottom(getString(C1441R.string.otherIntentException));
            }
        } catch (Exception e) {
            CatchException.logException(e);
            toastBottom(getString(C1441R.string.otherIntentException));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m4902V() {
        SharedPreferences.Editor edit = this.f6702n.edit();
        edit.putBoolean("rated", true);
        edit.apply();
    }

    private void initUI() {
        getWindowManager().getDefaultDisplay().getMetrics(this.metrics);
        ImageButton imageButton = (ImageButton) findViewById(C1441R.C1443id.button_flag);
        Languages languages = this.mLanguages;
        String language = languages.langList.get(languages.selectedItem).langListLocale.getLanguage();
        Languages languages2 = this.mLanguages;
        imageButton.setImageResource(languages.getLanguagePictureResId(language, languages2.langList.get(languages2.selectedItem).langListLocale.getCountry()));
        ((ToggleButton) findViewById(C1441R.C1443id.mute)).setOnClickListener(this.f6713y);
        ((ImageButton) findViewById(C1441R.C1443id.button_zwierzeta)).setOnClickListener(this.f6713y);
        imageButton.setOnClickListener(this.f6713y);
        ((TextView) findViewById(C1441R.C1443id.text_language)).setOnClickListener(this.f6713y);
        ((ImageButton) findViewById(C1441R.C1443id.button_menu)).setOnClickListener(this.f6713y);
        ((ImageButton) findViewById(C1441R.C1443id.button_category)).setOnClickListener(this.f6713y);
        ((ImageButton) findViewById(C1441R.C1443id.button_like)).setOnClickListener(this.f6713y);
        ToggleButton toggleButton = (ToggleButton) findViewById(C1441R.C1443id.button_random);
        toggleButton.setOnClickListener(this.f6713y);
        toggleButton.setChecked(this.f6706r);
        if (getResources().getDisplayMetrics().densityDpi == 120) {
            findViewById(C1441R.C1443id.textSwitcherShadowTop).setVisibility(8);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C1441R.anim.round_360_right);
        this.f6708t = loadAnimation;
        loadAnimation.setRepeatCount(-1);
        ((ImageButton) findViewById(C1441R.C1443id.button_share)).setOnClickListener(this.f6713y);
        m4896P();
        setMuteButton();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public void mo10455O() {
        try {
            this.f6711w = FirebaseRemoteConfig.getInstance();
            long j = 10800;
            if (com.medio.myutilities.Utilities.isDebugable(this.mContext)) {
                j = 0;
            }
            this.f6711w.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(j).build());
            this.f6711w.setDefaultsAsync((int) C1441R.xml.remote_config_defaults);
            this.mShowTransitionInterstitial = this.f6711w.getBoolean("transition_interstitial_enable");
            this.mShowQuitInterstitial = this.f6711w.getBoolean("quit_interstitial_enable");
            this.mShowBannerAds = this.f6711w.getBoolean("lower_banner_enable");
            this.mChangeSmartBannerToBanner = this.f6711w.getBoolean("change_smart_banner_to_banner");
            this.mChangeSmartBannerToNativeBanner = this.f6711w.getBoolean("change_smart_banner_to_native_banner");
            this.mShowAdaptiveBanner = this.f6711w.getBoolean("show_adaptive_banner");
            this.mBannerIdChoice = this.f6711w.getLong("lower_banner_id_choice");
            this.f6711w.fetchAndActivate().addOnCompleteListener((Activity) this, new C1429r()).addOnFailureListener((Activity) this, (OnFailureListener) new C1422k());
        } catch (Exception e) {
            CatchException.logException(e);
            createAdsIfInitialized(true, true);
        }
    }

    /* access modifiers changed from: protected */
    public void loadImages() {
        ((RecyclingImageView) findViewById(C1441R.C1443id.title)).setImageDrawable(getResources().getDrawable(C1441R.C1442drawable.title));
    }

    public void loadLikeListFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, 0);
        this.f6709u.clear();
        int i = sharedPreferences.getInt("Like_size", 0);
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList<Integer> arrayList = this.f6709u;
            arrayList.add(Integer.valueOf(sharedPreferences.getInt("Like_" + i2, 0)));
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 11223344) {
                switchAdsPersonalization();
                mo10455O();
            }
        } else if (i2 == -1) {
            Bundle extras = intent.getExtras();
            this.f6704p = extras.getBoolean("is_second_language", false);
            this.f6705q = extras.getString("second_language");
            this.f6706r = extras.getBoolean("random", false);
            ((ToggleButton) findViewById(C1441R.C1443id.button_random)).setChecked(this.f6706r);
        }
    }

    public void onBackPressed() {
        m4897Q();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        releaseImages();
        setContentView(C1441R.layout.activity_main);
        initUI();
        int identifier = getResources().getIdentifier("animal_sounds", "drawable", getPackageName());
        Resources resources = getResources();
        Context context = this.mContext;
        Resources resources2 = getResources();
        DisplayMetrics displayMetrics = this.metrics;
        ((CustomImageView) findViewById(C1441R.C1443id.bkg)).setImageDrawable(new RecyclingBitmapDrawable(resources, BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(context, resources2, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.ARGB_8888)));
        loadImages();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, 0);
        this.f6702n = sharedPreferences;
        this.f6703o = sharedPreferences.getBoolean("rated", false);
        this.f6707s = this.f6702n.getInt("talkSet", 1);
        Utilities.LocaleHolder checkAndPrepareLanguage = com.medio.myutilities.Utilities.checkAndPrepareLanguage(this.mContext, this.mLanguages, this.mLang, this.mCountry);
        this.mLang = checkAndPrepareLanguage.lang;
        this.mCountry = checkAndPrepareLanguage.country;
        setContentView(C1441R.layout.activity_main);
        getWindow().addFlags(128);
        this.f6710v = LocaleManager.getSystemCountry(this.mContext);
        initUI();
        if (TermsAndPolicyAcceptance.CheckTermsAccepted(this)) {
            mo10455O();
        }
        int checkLanguagePosition = this.mLanguages.checkLanguagePosition(this.mLang, this.mCountry);
        if (checkLanguagePosition != -1 && this.f6707s != 0 && this.mLanguages.langList.get(checkLanguagePosition).mustDownload) {
            int i = this.f6702n.getInt(this.mLang, -1);
            if (i == -1 || i < this.mLanguages.langList.get(checkLanguagePosition).pronunVer) {
                m4899S(this.mLanguages.langList.get(checkLanguagePosition), 0);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        m4898R();
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        setMuteButton();
        ((ToggleButton) findViewById(C1441R.C1443id.button_random)).setChecked(this.f6706r);
        loadLikeListFromSharedPreferences();
        m4896P();
        if (!this.f6712x && !this.mRemoveAds) {
            this.f6712x = true;
            new Handler().postDelayed(new C1431t(), 100);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("random", this.f6706r);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        int identifier = getResources().getIdentifier("animal_sounds", "drawable", getPackageName());
        Resources resources = getResources();
        Context context = this.mContext;
        Resources resources2 = getResources();
        DisplayMetrics displayMetrics = this.metrics;
        ((CustomImageView) findViewById(C1441R.C1443id.bkg)).setImageDrawable(new RecyclingBitmapDrawable(resources, BitmapLoaderFromResource.decodeSampledBitmapFromResourceMemOpt(context, resources2, identifier, displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.ARGB_8888)));
        loadImages();
        setVolumeControlStream(3);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        releaseImages();
    }

    /* access modifiers changed from: protected */
    public void releaseImages() {
        ((CustomImageView) findViewById(C1441R.C1443id.bkg)).setImageDrawable((Drawable) null);
        ((RecyclingImageView) findViewById(C1441R.C1443id.title)).setImageDrawable((Drawable) null);
    }

    public void setPronunStatusSharedPreferences(int i) {
        SharedPreferences.Editor edit = this.f6702n.edit();
        edit.putInt(this.mLang, i);
        edit.apply();
    }

    public void shareApp() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", getString(C1441R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", getString(C1441R.string.app_short_description) + ".\n\n" + getString(C1441R.string.playAppUri) + getPackageName());
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, getString(C1441R.string.shareUsing)));
    }

    public void showCategoryChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle(getResources().getString(C1441R.string.animalsGroupSelectionTitle));
        builder.setSingleChoiceItems(new AnimalsGroupListAdapter(this, C1441R.layout.animal_group_list_item, new AnimalsGroup(this)), -1, new C1432u());
        AlertDialog create = builder.create();
        create.setOnDismissListener(new C1433v());
        create.setOwnerActivity(this);
        create.show();
    }

    public void showErrorDialog(int i, boolean z, int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle(C1441R.string.errorMessageTitle);
        builder.setMessage(i);
        builder.setCancelable(false);
        if (z) {
            builder.setPositiveButton(C1441R.string.buttonTryAgain, new C1424m(i2));
            builder.setNegativeButton(C1441R.string.buttonCancel, new C1425n(this));
        } else {
            builder.setPositiveButton(C1441R.string.buttonOK, new C1426o(this));
        }
        AlertDialog create = builder.create();
        create.setOnDismissListener(new C1427p());
        create.setOwnerActivity((Activity) this.mContext);
        try {
            if (!isFinishing()) {
                create.show();
            }
        } catch (Exception e) {
            CatchException.logException(e);
        }
    }

    public void showOtherAppDialog() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(getString(C1441R.string.otherAppStore)));
        try {
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(getString(C1441R.string.otherAppUri)));
            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivity(intent2);
            } else {
                toastBottom(getString(C1441R.string.otherIntentException));
            }
        } catch (Exception e) {
            CatchException.logException(e);
            toastBottom(getString(C1441R.string.otherIntentException));
        }
    }

    public void showQuitDialog() {
        Dialog dialog = new Dialog(this.mContext, C1441R.style.quitDialogTheme);
        dialog.setContentView(((Activity) this.mContext).getLayoutInflater().inflate(C1441R.layout.quit_dlg, (ViewGroup) null));
        int i = this.f6702n.getInt("runCnt", 1);
        if (this.f6703o || i < 2) {
            dialog.findViewById(C1441R.C1443id.quit_dlg_text1).setVisibility(8);
            dialog.findViewById(C1441R.C1443id.quit_dlg_image).setVisibility(8);
            ((TextView) dialog.findViewById(C1441R.C1443id.quit_dlg_text2)).setPadding(20, 20, 20, 20);
        }
        ((Button) dialog.findViewById(C1441R.C1443id.quitDlgButtonYes)).setOnClickListener(new C1413b(i, dialog));
        ((Button) dialog.findViewById(C1441R.C1443id.quitDlgButtonNo)).setOnClickListener(new C1414c(this, dialog));
        Button button = (Button) dialog.findViewById(C1441R.C1443id.quitDlgButtonRate);
        if (this.f6703o || i < 2) {
            button.setText(C1441R.string.otherAppsTitle);
            button.setOnClickListener(new C1417f());
        } else {
            button.setOnClickListener(new C1415d());
            ((ImageView) dialog.findViewById(C1441R.C1443id.quit_dlg_image)).setOnClickListener(new C1416e());
        }
        ((ImageView) dialog.findViewById(C1441R.C1443id.icon)).setOnClickListener(new C1418g());
        dialog.setOnDismissListener(new C1419h());
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOwnerActivity((Activity) this.mContext);
        try {
            if (!((Activity) this.mContext).isFinishing()) {
                dialog.show();
            }
        } catch (Exception e) {
            CatchException.logException(e);
        }
    }

    public void showTalkOptionDialog() {
        Languages languages = this.mLanguages;
        LanguagesBase.language language = languages.langList.get(languages.selectedItem);
        int i = this.f6702n.getInt(this.mLang, -1);
        if (!language.mustDownload || !(i == -1 || i == 255 || i != language.pronunVer)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(C1441R.string.speakNameTitle);
            TalkListAdapter talkListAdapter = new TalkListAdapter(this, C1441R.layout.speak_list_item, new String[]{getString(C1441R.string.speakNameNone), getString(C1441R.string.speakNameFirst), getString(C1441R.string.speakNameLast)}, this.f6707s);
            if (this.f6707s >= 3) {
                this.f6707s = 1;
            }
            builder.setSingleChoiceItems(talkListAdapter, this.f6707s, new C1436y(talkListAdapter));
            AlertDialog create = builder.create();
            create.setOnDismissListener(new C1412a());
            create.setOwnerActivity(this);
            create.show();
            return;
        }
        m4899S(language, 1);
    }
}
