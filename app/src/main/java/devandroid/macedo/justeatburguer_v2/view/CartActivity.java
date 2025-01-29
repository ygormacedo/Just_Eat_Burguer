package devandroid.macedo.justeatburguer_v2.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.net.URLEncoder;
import java.util.ArrayList;

import devandroid.macedo.justeatburguer_v2.R;
import devandroid.macedo.justeatburguer_v2.model.User;
import devandroid.macedo.justeatburguer_v2.viewmodel.CartViewModel;

public class CartActivity extends AppCompatActivity {
    private CartViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);

        TextView textViewItems = findViewById(R.id.textViewItems);
        Spinner spinnerPayment = findViewById(R.id.spinnerPayment);
        Button buttonFinish = findViewById(R.id.buttonFinish);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.payment_methods, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPayment.setAdapter(adapter);

        ArrayList<String> selectedItems = getIntent().getStringArrayListExtra("SELECTED_ITEMS");
        String name = getIntent().getStringExtra("NAME");
        String phone = getIntent().getStringExtra("PHONE");

        viewModel.setUser(new User(name, phone));
        viewModel.setSelectedItems(selectedItems);

        StringBuilder itemsText = new StringBuilder();
        for (String item : selectedItems) {
            itemsText.append(item).append("\n");
        }
        textViewItems.setText(itemsText.toString());

        buttonFinish.setOnClickListener(v -> {
            String paymentMethod = spinnerPayment.getSelectedItem().toString();
            viewModel.setPaymentMethod(paymentMethod);

            String message = viewModel.generateOrderSummary();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=5511987226939&text=" + URLEncoder.encode(message);
            // URL DE TESTE YGOR String url = "https://api.whatsapp.com/send?phone=&text=5511947578682" + URLEncoder.encode(message);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });
    }
}