package com.medio.myutilities;

import java.util.ArrayList;
import java.util.Locale;

public class LanguagesBase {
    public ArrayList<language> langList = new ArrayList<>();
    public int selectedItem = 0;

    public int checkLanguagePosition(String str, String str2) {
        int i = -1;
        for (int size = this.langList.size() - 1; size >= 0; size--) {
            if (this.langList.get(size).langListLocale.getLanguage().contentEquals(str)) {
                if (this.langList.get(size).langListLocale.getCountry().contentEquals(str2)) {
                    return size;
                }
                i = size;
            }
        }
        return i;
    }

    public int getLanguagePictureResId(String str, String str2) {
        int i = 0;
        for (int size = this.langList.size() - 1; size >= 0; size--) {
            if (this.langList.get(size).langListLocale.getLanguage().contentEquals(str)) {
                i = this.langList.get(size).langListItemImage;
                if (this.langList.get(size).langListLocale.getCountry().contentEquals(str2)) {
                    return this.langList.get(size).langListItemImage;
                }
            }
        }
        return i;
    }

    public class language {
        public int langListItemImage;
        public Locale langListLocale;
        public boolean langSound;
        public boolean mustDownload;
        public int pronunVer;

        public language(LanguagesBase languagesBase) {
            this.langListItemImage = -1;
            this.langListLocale = null;
            this.langSound = false;
            this.mustDownload = false;
            this.pronunVer = 0;
        }

        public language(LanguagesBase languagesBase, int i, Locale locale) {
            this.langListItemImage = i;
            this.langListLocale = locale;
            this.langSound = false;
            this.mustDownload = false;
            this.pronunVer = 0;
        }

        public language(LanguagesBase languagesBase, int i, Locale locale, boolean z) {
            this.langListItemImage = i;
            this.langListLocale = locale;
            this.langSound = z;
            this.mustDownload = false;
            this.pronunVer = 0;
        }

        public language(LanguagesBase languagesBase, int i, Locale locale, boolean z, boolean z2) {
            this.langListItemImage = i;
            this.langListLocale = locale;
            this.langSound = z;
            this.mustDownload = z2;
            this.pronunVer = 0;
        }

        public language(LanguagesBase languagesBase, int i, Locale locale, boolean z, boolean z2, int i2) {
            this.langListItemImage = i;
            this.langListLocale = locale;
            this.langSound = z;
            this.mustDownload = z2;
            this.pronunVer = i2;
        }

        public language(LanguagesBase languagesBase, language language) {
            this.langListItemImage = language.langListItemImage;
            this.langListLocale = language.langListLocale;
            this.langSound = language.langSound;
            this.mustDownload = language.mustDownload;
            this.pronunVer = language.pronunVer;
        }
    }
}
