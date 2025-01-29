package devandroid.macedo.justeatburguer_v2.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import java.util.ArrayList;

import devandroid.macedo.justeatburguer_v2.R;
import devandroid.macedo.justeatburguer_v2.model.MenuItem;
import devandroid.macedo.justeatburguer_v2.viewmodel.MenuViewModel;

public class MenuActivity extends AppCompatActivity {
    private MenuViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        viewModel = new ViewModelProvider(this).get(MenuViewModel.class);

        ListView listViewMenu = findViewById(R.id.listViewMenu);
        Button buttonAddToCart = findViewById(R.id.buttonAddToCart);

        viewModel.getMenuItems().observe(this, menuItems -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_multiple_choice,
                    menuItems.stream().map(item -> item.getName() + " - R$" + item.getPrice()).toArray(String[]::new)
            );
            listViewMenu.setAdapter(adapter);
        });

        buttonAddToCart.setOnClickListener(v -> {
            ArrayList<String> selectedItems = new ArrayList<>();
            for (int i = 0; i < listViewMenu.getCount(); i++) {
                if (listViewMenu.isItemChecked(i)) {
                    selectedItems.add((String) listViewMenu.getItemAtPosition(i));
                }
            }

            Intent intent = new Intent(MenuActivity.this, CartActivity.class);
            intent.putStringArrayListExtra("SELECTED_ITEMS", selectedItems);
            intent.putExtra("NAME", getIntent().getStringExtra("NAME"));
            intent.putExtra("PHONE", getIntent().getStringExtra("PHONE"));
            startActivity(intent);
        });
    }
}