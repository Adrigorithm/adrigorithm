package com.adri.main.items;

import com.adri.main.Main;
import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(Main.setup.itemGroup));
        setRegistryName("firstitem");
    }
}
