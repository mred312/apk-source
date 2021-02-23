package com.dream_studio.animalsounds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.medio.myutilities.LanguagesBase;

public class LangListAdapter extends ArrayAdapter<LanguagesBase.language> {

    /* renamed from: a */
    Context f6688a;

    /* renamed from: b */
    int f6689b;

    /* renamed from: c */
    Languages f6690c = null;

    /* renamed from: com.dream_studio.animalsounds.LangListAdapter$a */
    static class C1407a {

        /* renamed from: a */
        ImageView f6691a;

        /* renamed from: b */
        TextView f6692b;

        /* renamed from: c */
        RadioButton f6693c;

        C1407a() {
        }
    }

    public LangListAdapter(Context context, int i, Languages languages) {
        super(context, i);
        this.f6689b = i;
        this.f6688a = context;
        this.f6690c = languages;
    }

    public int getCount() {
        Languages languages = this.f6690c;
        if (languages != null) {
            return languages.langList.size();
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1407a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.f6688a.getSystemService("layout_inflater")).inflate(this.f6689b, (ViewGroup) null);
            aVar = new C1407a();
            aVar.f6691a = (ImageView) view.findViewById(C1441R.C1443id.langListItemImage);
            aVar.f6692b = (TextView) view.findViewById(C1441R.C1443id.langListItemName);
            aVar.f6693c = (RadioButton) view.findViewById(C1441R.C1443id.langListItemChecked);
            view.setTag(aVar);
        } else {
            aVar = (C1407a) view.getTag();
        }
        if (i < this.f6690c.langList.size()) {
            aVar.f6691a.setImageResource(this.f6690c.langList.get(i).langListItemImage);
            aVar.f6692b.setText(this.f6690c.langList.get(i).langListLocale.getDisplayLanguage());
            aVar.f6693c.setChecked(this.f6690c.selectedItem == i);
        }
        return view;
    }

    public LanguagesBase.language getItem(int i) {
        Languages languages = this.f6690c;
        if (languages == null || i >= languages.langList.size()) {
            return null;
        }
        return this.f6690c.langList.get(i);
    }
}
