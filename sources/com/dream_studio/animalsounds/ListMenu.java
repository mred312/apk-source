package com.dream_studio.animalsounds;

import android.content.Context;
import java.util.ArrayList;

public class ListMenu {
    public ArrayList<menuItem> menuListArray;

    public ListMenu(Context context) {
        ArrayList<menuItem> arrayList = new ArrayList<>();
        this.menuListArray = arrayList;
        arrayList.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_more, context.getString(C1441R.string.otherAppsTitle)));
        this.menuListArray.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_flag, context.getString(C1441R.string.jezyk)));
        this.menuListArray.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_message, context.getString(C1441R.string.errorReport)));
        this.menuListArray.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_hand, context.getString(C1441R.string.rateBtnTxt)));
        this.menuListArray.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_share, context.getString(C1441R.string.shareApp)));
        this.menuListArray.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_pronunciation, context.getString(C1441R.string.speakNameTitle)));
        this.menuListArray.add(new menuItem(this, C1441R.C1442drawable.menu_buttons_termofuse, context.getString(C1441R.string.terms_of_use)));
    }

    public void removeItem(int i) {
        if (this.menuListArray != null) {
            for (int i2 = 0; i2 < this.menuListArray.size(); i2++) {
                if (this.menuListArray.get(i2).listItemImage == i) {
                    this.menuListArray.remove(i2);
                    return;
                }
            }
        }
    }

    public class menuItem {
        public int listItemImage;
        public String listItemName;

        public menuItem(ListMenu listMenu) {
            this.listItemImage = -1;
            this.listItemName = "";
        }

        public menuItem(ListMenu listMenu, int i, String str) {
            this.listItemImage = i;
            this.listItemName = str;
        }
    }
}
