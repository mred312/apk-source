package com.dream_studio.animalsounds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dream_studio.animalsounds.ListMenu;

public class MenuListAdapter extends ArrayAdapter<ListMenu.menuItem> {

    /* renamed from: a */
    Context f6744a;

    /* renamed from: b */
    int f6745b;

    /* renamed from: c */
    ListMenu f6746c = null;

    /* renamed from: com.dream_studio.animalsounds.MenuListAdapter$a */
    static class C1437a {

        /* renamed from: a */
        ImageView f6747a;

        /* renamed from: b */
        TextView f6748b;

        C1437a() {
        }
    }

    public MenuListAdapter(Context context, int i, ListMenu listMenu) {
        super(context, i);
        this.f6745b = i;
        this.f6744a = context;
        this.f6746c = listMenu;
    }

    public int getCount() {
        ListMenu listMenu = this.f6746c;
        if (listMenu != null) {
            return listMenu.menuListArray.size();
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1437a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f6744a.getSystemService("layout_inflater")).inflate(this.f6745b, (ViewGroup) null);
            aVar = new C1437a();
            aVar.f6747a = (ImageView) view.findViewById(C1441R.C1443id.menuListItemImage);
            aVar.f6748b = (TextView) view.findViewById(C1441R.C1443id.menuListItemName);
            view.setTag(aVar);
        } else {
            aVar = (C1437a) view.getTag();
        }
        if (i < this.f6746c.menuListArray.size()) {
            aVar.f6747a.setImageResource(this.f6746c.menuListArray.get(i).listItemImage);
            aVar.f6748b.setText(this.f6746c.menuListArray.get(i).listItemName);
        }
        return view;
    }

    public ListMenu.menuItem getItem(int i) {
        ListMenu listMenu = this.f6746c;
        if (listMenu == null || i >= listMenu.menuListArray.size()) {
            return null;
        }
        return this.f6746c.menuListArray.get(i);
    }
}
