package devandroid.macedo.justeatburguer_v2.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import devandroid.macedo.justeatburguer_v2.R;
import devandroid.macedo.justeatburguer_v2.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        EditText editTextName = findViewById(R.id.txtName);
        EditText editTextPhone = findViewById(R.id.txtPhone);
        Button buttonContinue = findViewById(R.id.buttonContinue);

        buttonContinue.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String phone = editTextPhone.getText().toString();

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                viewModel.saveUser(name, phone);
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("PHONE", phone);
                startActivity(intent);
            }
        });
    }
}