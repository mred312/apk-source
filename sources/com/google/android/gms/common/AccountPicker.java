package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class AccountPicker {

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public static class AccountChooserOptions {
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a */
        public Account f7419a;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b */
        public ArrayList<Account> f7420b;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c */
        public ArrayList<String> f7421c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f7422d;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: e */
        public String f7423e;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: f */
        public Bundle f7424f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public boolean f7425g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f7426h;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: i */
        public String f7427i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public boolean f7428j;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: k */
        public zza f7429k;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: l */
        public String f7430l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public boolean f7431m;

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public static class Builder {
            @Nullable

            /* renamed from: a */
            private Account f7432a;
            @Nullable

            /* renamed from: b */
            private ArrayList<Account> f7433b;
            @Nullable

            /* renamed from: c */
            private ArrayList<String> f7434c;

            /* renamed from: d */
            private boolean f7435d = false;
            @Nullable

            /* renamed from: e */
            private String f7436e;
            @Nullable

            /* renamed from: f */
            private Bundle f7437f;

            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                ArrayList unused = accountChooserOptions.f7421c = this.f7434c;
                ArrayList unused2 = accountChooserOptions.f7420b = this.f7433b;
                boolean unused3 = accountChooserOptions.f7422d = this.f7435d;
                zza unused4 = accountChooserOptions.f7429k = null;
                String unused5 = accountChooserOptions.f7427i = null;
                Bundle unused6 = accountChooserOptions.f7424f = this.f7437f;
                Account unused7 = accountChooserOptions.f7419a = this.f7432a;
                boolean unused8 = accountChooserOptions.f7425g = false;
                String unused9 = accountChooserOptions.f7430l = null;
                int unused10 = accountChooserOptions.f7426h = 0;
                String unused11 = accountChooserOptions.f7423e = this.f7436e;
                boolean unused12 = accountChooserOptions.f7428j = false;
                boolean unused13 = accountChooserOptions.f7431m = false;
                return accountChooserOptions;
            }

            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                this.f7433b = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                this.f7434c = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.f7435d = z;
                return this;
            }

            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                this.f7437f = bundle;
                return this;
            }

            public Builder setSelectedAccount(@Nullable Account account) {
                this.f7432a = account;
                return this;
            }

            public Builder setTitleOverrideText(@Nullable String str) {
                this.f7436e = str;
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public static class zza {
        }
    }

    private AccountPicker() {
    }

    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        int i = 0;
        if (!accountChooserOptions.f7428j) {
            Preconditions.checkArgument(accountChooserOptions.f7427i == null, "We only support hostedDomain filter for account chip styled account picker");
            Preconditions.checkArgument(accountChooserOptions.f7429k == null, "Consent is only valid for account chip styled account picker");
        }
        intent.setAction(accountChooserOptions.f7428j ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.f7420b);
        if (accountChooserOptions.f7421c != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.f7421c.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.f7424f);
        intent.putExtra("selectedAccount", accountChooserOptions.f7419a);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.f7422d);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.f7423e);
        intent.putExtra("setGmsCoreAccount", accountChooserOptions.f7425g);
        intent.putExtra("realClientPackage", accountChooserOptions.f7430l);
        intent.putExtra("overrideTheme", accountChooserOptions.f7426h);
        if (accountChooserOptions.f7428j) {
            i = 2;
        }
        intent.putExtra("overrideCustomTheme", i);
        intent.putExtra("hostedDomainFilter", accountChooserOptions.f7427i);
        Bundle bundle = new Bundle();
        if (accountChooserOptions.f7428j && !TextUtils.isEmpty(accountChooserOptions.f7423e)) {
            bundle.putString("title", accountChooserOptions.f7423e);
        }
        if (accountChooserOptions.f7429k != null) {
            bundle.putBoolean("should_show_consent", true);
            bundle.putString("privacy_policy_url", (String) null);
            bundle.putString("terms_of_service_url", (String) null);
        }
        if (accountChooserOptions.f7431m) {
            bundle.putBoolean("exclude_add_account", true);
        }
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
