package com.dream_studio.animalsounds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dream_studio.animalsounds.AnimalsGroup;

public class AnimalsGroupListAdapter extends ArrayAdapter<AnimalsGroup.animal> {

    /* renamed from: a */
    Context f6522a;

    /* renamed from: b */
    int f6523b;

    /* renamed from: c */
    AnimalsGroup f6524c = null;

    /* renamed from: com.dream_studio.animalsounds.AnimalsGroupListAdapter$a */
    static class C1366a {

        /* renamed from: a */
        ImageView f6525a;

        /* renamed from: b */
        TextView f6526b;

        C1366a() {
        }
    }

    public AnimalsGroupListAdapter(Context context, int i, AnimalsGroup animalsGroup) {
        super(context, i);
        this.f6523b = i;
        this.f6522a = context;
        this.f6524c = animalsGroup;
    }

    public int getCount() {
        AnimalsGroup animalsGroup = this.f6524c;
        if (animalsGroup != null) {
            return animalsGroup.animalsGroupList.length;
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1366a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f6522a.getSystemService("layout_inflater")).inflate(this.f6523b, (ViewGroup) null);
            aVar = new C1366a();
            aVar.f6525a = (ImageView) view.findViewById(C1441R.C1443id.animGroupListItemImage);
            aVar.f6526b = (TextView) view.findViewById(C1441R.C1443id.animGroupListItemName);
            view.setTag(aVar);
        } else {
            aVar = (C1366a) view.getTag();
        }
        AnimalsGroup.animal[] animalArr = this.f6524c.animalsGroupList;
        if (i < animalArr.length) {
            aVar.f6525a.setImageResource(animalArr[i].animalsGroupListItemImage);
            aVar.f6526b.setText(this.f6524c.animalsGroupList[i].animalsGroupListItemName);
        }
        return view;
    }

    public AnimalsGroup.animal getItem(int i) {
        AnimalsGroup animalsGroup = this.f6524c;
        if (animalsGroup == null) {
            return null;
        }
        AnimalsGroup.animal[] animalArr = animalsGroup.animalsGroupList;
        if (i < animalArr.length) {
            return animalArr[i];
        }
        return null;
    }
}
