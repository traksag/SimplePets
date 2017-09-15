package simplepets.brainsynder.menu.menuItems;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import simple.brainsynder.api.ItemMaker;
import simplepets.brainsynder.menu.MenuItemAbstract;
import simplepets.brainsynder.nms.entities.type.main.IColorable;
import simplepets.brainsynder.nms.entities.type.main.IEntityPet;
import simplepets.brainsynder.pet.PetType;
import simplepets.brainsynder.wrapper.DyeColorWrapper;

public class Color extends MenuItemAbstract {
    private ItemMaker item = new ItemMaker(Material.WOOL).setName("&6Change Color");

    public Color(PetType type, IEntityPet entityPet) {
        super(type, entityPet);
    }

    @Override
    public ItemMaker getItem() {

        ItemMaker item = null;
        if (getEntityPet() instanceof IColorable) {
            IColorable var = (IColorable) getEntityPet();
            DyeColorWrapper typeID = DyeColorWrapper.WHITE;
            if (var.getColor() != null)
                typeID = var.getColor();
            item = new ItemMaker(Material.WOOL, typeID.getWoolData());
            item.setName(" ");
            DyeColorWrapper prev = DyeColorWrapper.getPrevious(typeID);
            DyeColorWrapper next = DyeColorWrapper.getNext(typeID);
            item.addLoreLine("&6Previous: §" + prev.getChatChar() + WordUtils.capitalize(prev.toString().toLowerCase()));
            item.addLoreLine("&6Current: §" + typeID.getChatChar() + WordUtils.capitalize(typeID.toString().toLowerCase()));
            item.addLoreLine("&6Next: §" + next.getChatChar() + WordUtils.capitalize(next.toString().toLowerCase()));
        }
        return item;
    }

    @Override
    public void onLeftClick() {
        if (entityPet instanceof IColorable) {
            IColorable var = (IColorable) entityPet;
            DyeColorWrapper wrapper = DyeColorWrapper.WHITE;
            if (var.getColor() != null)
                wrapper = var.getColor();
            var.setColor(DyeColorWrapper.getNext(wrapper));
        }
    }

    @Override
    public void onRightClick() {
        if (entityPet instanceof IColorable) {
            IColorable var = (IColorable) entityPet;
            DyeColorWrapper wrapper = DyeColorWrapper.WHITE;
            if (var.getColor() != null)
                wrapper = var.getColor();
            var.setColor(DyeColorWrapper.getPrevious(wrapper));
        }
    }
}
