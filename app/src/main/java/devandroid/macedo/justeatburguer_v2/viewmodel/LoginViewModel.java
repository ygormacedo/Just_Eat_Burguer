package devandroid.macedo.justeatburguer_v2.viewmodel;
import androidx.lifecycle.ViewModel;
import devandroid.macedo.justeatburguer_v2.model.User;
import devandroid.macedo.justeatburguer_v2.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private UserRepository userRepository = new UserRepository();

    public void saveUser(String name, String phone) {
        User user = new User(name, phone);
        userRepository.saveUser(user);
    }
}