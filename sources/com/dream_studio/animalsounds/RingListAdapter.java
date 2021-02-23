package com.dream_studio.animalsounds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dream_studio.animalsounds.SetAsTypes;

public class RingListAdapter extends ArrayAdapter<SetAsTypes.setAsType> {

    /* renamed from: a */
    Context f6811a;

    /* renamed from: b */
    int f6812b;

    /* renamed from: c */
    SetAsTypes f6813c = null;

    /* renamed from: com.dream_studio.animalsounds.RingListAdapter$a */
    static class C1445a {

        /* renamed from: a */
        ImageView f6814a;

        /* renamed from: b */
        TextView f6815b;

        C1445a() {
        }
    }

    public RingListAdapter(Context context, int i, SetAsTypes setAsTypes) {
        super(context, i);
        this.f6812b = i;
        this.f6811a = context;
        this.f6813c = setAsTypes;
    }

    public int getCount() {
        SetAsTypes setAsTypes = this.f6813c;
        if (setAsTypes != null) {
            return setAsTypes.setAsTypesArray.length;
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1445a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f6811a.getSystemService("layout_inflater")).inflate(this.f6812b, (ViewGroup) null);
            aVar = new C1445a();
            aVar.f6814a = (ImageView) view.findViewById(C1441R.C1443id.ringListItemImage);
            aVar.f6815b = (TextView) view.findViewById(C1441R.C1443id.ringListItemName);
            view.setTag(aVar);
        } else {
            aVar = (C1445a) view.getTag();
        }
        SetAsTypes.setAsType[] setastypeArr = this.f6813c.setAsTypesArray;
        if (i < setastypeArr.length) {
            aVar.f6814a.setImageResource(setastypeArr[i].listItemImage);
            aVar.f6815b.setText(this.f6813c.setAsTypesArray[i].listItemName);
        }
        return view;
    }

    public SetAsTypes.setAsType getItem(int i) {
        SetAsTypes setAsTypes = this.f6813c;
        if (setAsTypes == null) {
            return null;
        }
        SetAsTypes.setAsType[] setastypeArr = setAsTypes.setAsTypesArray;
        if (i < setastypeArr.length) {
            return setastypeArr[i];
        }
        return null;
    }
}
