package devandroid.macedo.justeatburguer_v2.repository;


import java.util.ArrayList;
import java.util.List;
import devandroid.macedo.justeatburguer_v2.model.MenuItem;

public class MenuRepository {
    public List<MenuItem> getMenuItems() {

        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("THE ROYAL",  45));
        items.add(new MenuItem("CHEDDAR ONE",  35.0));
        items.add(new MenuItem("GARLIC BBQ", 32));
        items.add(new MenuItem("PARADISE", 27));
        items.add(new MenuItem("DUPLO", 24));
        return items;
    }
}