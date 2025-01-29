package devandroid.macedo.justeatburguer_v2.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import devandroid.macedo.justeatburguer_v2.model.User;

// CartViewModel.java
public class CartViewModel extends ViewModel {
    private User user;
    private List<String> selectedItems;
    private String paymentMethod;

    public void setUser(User user) {
        this.user = user;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Nome: ").append(user.getName()).append("\n");
        summary.append("Telefone: ").append(user.getPhone()).append("\n");
        summary.append("Itens:\n");
        for (String item : selectedItems) {
            summary.append("- ").append(item).append("\n");
        }
        summary.append("Forma de Pagamento: ").append(paymentMethod);
        return summary.toString();
    }
}