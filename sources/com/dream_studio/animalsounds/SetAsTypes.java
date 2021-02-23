package com.dream_studio.animalsounds;

import android.content.Context;

public class SetAsTypes {
    public static final int TYPE_CONTACT_RINGTONE = 3;
    public static final int TYPE_WALLPAPER = 5;
    public setAsType[] setAsTypesArray;

    public SetAsTypes(Context context) {
        this.setAsTypesArray = new setAsType[]{new setAsType(this, C1441R.C1442drawable.ringtone_global, context.getString(C1441R.string.typeRingtone), 1), new setAsType(this, C1441R.C1442drawable.ringtone_contact, context.getString(C1441R.string.typeContactRingtone), 3), new setAsType(this, C1441R.C1442drawable.ringtone_sms, context.getString(C1441R.string.typeNotification), 2), new setAsType(this, C1441R.C1442drawable.ringtone_alarm, context.getString(C1441R.string.typeAlarm), 4), new setAsType(this, C1441R.C1442drawable.wallpaper, context.getString(C1441R.string.typeWallpaper), 5)};
    }

    public class setAsType {
        public int listItemImage;
        public String listItemName;
        public int listItemType;

        public setAsType(SetAsTypes setAsTypes) {
            this.listItemImage = -1;
            this.listItemName = "";
            this.listItemType = -1;
        }

        public setAsType(SetAsTypes setAsTypes, int i, String str, int i2) {
            this.listItemImage = i;
            this.listItemName = str;
            this.listItemType = i2;
        }
    }
}
