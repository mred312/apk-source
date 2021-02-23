package com.dream_studio.animalsounds.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.dream_studio.animalsounds.C1441R;
import com.medio.catchexception.CatchException;
import java.util.ArrayList;

public class PositionSwitcher {

    /* renamed from: a */
    TypedArray f6892a = null;

    /* renamed from: b */
    private ArrayList<Integer> f6893b = new ArrayList<>();

    public PositionSwitcher(Context context) {
        if (context != null) {
            try {
                this.f6892a = context.getResources().obtainTypedArray(C1441R.array.switching_array);
                this.f6893b.clear();
                int i = 0;
                while (i < this.f6892a.length() && this.f6892a.getInteger(i, -1) != -1) {
                    this.f6893b.add(Integer.valueOf(this.f6892a.getInteger(i, 0)));
                    i++;
                }
                this.f6892a.recycle();
            } catch (Resources.NotFoundException e) {
                CatchException.logException(e);
            }
        }
    }

    public boolean contain(int i) {
        return this.f6893b.contains(Integer.valueOf(i));
    }

    public int getSwitchedPosition(int i) {
        return this.f6893b.get(i).intValue();
    }

    public int indexOf(int i) {
        return this.f6893b.indexOf(Integer.valueOf(i));
    }

    public int size() {
        return this.f6893b.size();
    }
}
