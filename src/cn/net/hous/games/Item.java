package cn.net.hous.games;

import java.util.List;

/**
 * Created by 帅 on 2015/6/18.
 */
public class Item {

    private int itemid;
    private String itemname;
    private int itemtype;

    public int getItemid() {
        return itemid;
    }
    public void setItemid(int itemid){
        this.itemid = itemid;
    }
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemtype() {
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }

    public void save()
    {
        ItemDAO.save(this);
    }


    public static List<Integer> getItemIds() {
        return ItemDAO.getitemIds();
    }

    public static List<Item> getItems(){
        return ItemDAO.getitems();
    }

    public static void itemDel(int itemid) {
        ItemDAO.delete(itemid);
    }

    public static Item getItemById(int anInt) {
        return ItemDAO.getItemById(anInt);
    }
}
