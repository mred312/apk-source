package com.dream_studio.animalsounds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class TalkListAdapter extends ArrayAdapter<String> {

    /* renamed from: a */
    Context f6830a;

    /* renamed from: b */
    int f6831b;

    /* renamed from: c */
    int f6832c;

    /* renamed from: d */
    String[] f6833d;

    /* renamed from: com.dream_studio.animalsounds.TalkListAdapter$a */
    static class C1448a {

        /* renamed from: a */
        TextView f6834a;

        /* renamed from: b */
        RadioButton f6835b;

        C1448a() {
        }
    }

    public TalkListAdapter(Context context, int i, String[] strArr, int i2) {
        super(context, i);
        this.f6831b = i;
        this.f6830a = context;
        this.f6833d = strArr;
        this.f6832c = i2;
    }

    public int getCount() {
        String[] strArr = this.f6833d;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1448a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f6830a.getSystemService("layout_inflater")).inflate(this.f6831b, (ViewGroup) null);
            aVar = new C1448a();
            aVar.f6834a = (TextView) view.findViewById(C1441R.C1443id.speakListItemName);
            aVar.f6835b = (RadioButton) view.findViewById(C1441R.C1443id.speakListItemChecked);
            view.setTag(aVar);
        } else {
            aVar = (C1448a) view.getTag();
        }
        String[] strArr = this.f6833d;
        if (i < strArr.length) {
            aVar.f6834a.setText(strArr[i]);
            aVar.f6835b.setChecked(i == this.f6832c);
        }
        return view;
    }

    public void setSelected(int i) {
        if (i < this.f6833d.length) {
            this.f6832c = i;
        }
    }

    public String getItem(int i) {
        String[] strArr = this.f6833d;
        if (strArr == null || i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }
}
