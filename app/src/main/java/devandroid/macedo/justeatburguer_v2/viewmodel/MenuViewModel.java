package devandroid.macedo.justeatburguer_v2.viewmodel;

import androidx.lifecycle.LiveData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import devandroid.macedo.justeatburguer_v2.model.MenuItem;
import devandroid.macedo.justeatburguer_v2.repository.MenuRepository;

public class MenuViewModel extends ViewModel {
    private MenuRepository menuRepository = new MenuRepository();
    private MutableLiveData<List<MenuItem>> menuItems = new MutableLiveData<>();

    public LiveData<List<MenuItem>> getMenuItems() {
        menuItems.setValue(menuRepository.getMenuItems());
        return menuItems;
    }
}


// TESTE NEW BRANCH