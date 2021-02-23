package com.dream_studio.animalsounds;

import android.content.Context;

public class AnimalsGroup {
    public animal[] animalsGroupList;

    public AnimalsGroup(Context context) {
        this.animalsGroupList = new animal[]{new animal(this, C1441R.C1442drawable.group_animals_birds, context.getString(C1441R.string.ptaki)), new animal(this, C1441R.C1442drawable.group_animals_farm, context.getString(C1441R.string.animalsGroupFarm)), new animal(this, C1441R.C1442drawable.group_animals_wild, context.getString(C1441R.string.animalsGroupWild)), new animal(this, C1441R.C1442drawable.group_animals_pets, context.getString(C1441R.string.animalsGroupPet)), new animal(this, C1441R.C1442drawable.group_animals_mammals, context.getString(C1441R.string.animalsGroupMammals)), new animal(this, C1441R.C1442drawable.group_animals_reptilesandamphibians, context.getString(C1441R.string.animalsGroupReptilesAndAmphibians)), new animal(this, C1441R.C1442drawable.group_animals_insects, context.getString(C1441R.string.animalsGroupInsects)), new animal(this, C1441R.C1442drawable.group_animals_land, context.getString(C1441R.string.animalsGroupLand)), new animal(this, C1441R.C1442drawable.group_animals_water, context.getString(C1441R.string.animalsGroupWater))};
    }

    public class animal {
        public int animalsGroupListItemImage;
        public String animalsGroupListItemName;

        public animal(AnimalsGroup animalsGroup) {
            this.animalsGroupListItemImage = -1;
            this.animalsGroupListItemName = null;
        }

        public animal(AnimalsGroup animalsGroup, int i, String str) {
            this.animalsGroupListItemImage = i;
            this.animalsGroupListItemName = str;
        }

        public animal(AnimalsGroup animalsGroup, animal animal) {
            this.animalsGroupListItemImage = animal.animalsGroupListItemImage;
            this.animalsGroupListItemName = animal.animalsGroupListItemName;
        }
    }
}
