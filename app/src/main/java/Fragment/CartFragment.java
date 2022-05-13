package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Activity.PaymentActivity;
import Activity.SuccessfulActivity;
import Adapter.CartAdapter;
import Object.Cart;
import hcmute.edu.vn.foodapp_16.R;


public class CartFragment extends Fragment {

    private RecyclerView rcvCart;
    private CartAdapter cartAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        rcvCart = view.findViewById(R.id.rcv_cart);
        rcvCart.setLayoutManager(new LinearLayoutManager(this.getContext()));

        cartAdapter = new CartAdapter(getListCarts());

        rcvCart.setAdapter(cartAdapter);

        //Button Back Home
        ImageButton imgBtnOnBack = (ImageButton) view.findViewById(R.id.button_OnBack);
        imgBtnOnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment  = new HomeFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frame_layout, fragment, fragment.getTag())
                        .commit();
            }
        });

        LinearLayout layoutPayment = (LinearLayout) view.findViewById(R.id.layout_Payment);
        layoutPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), PaymentActivity.class);
                startActivity(in);
            }
        });

        Button btnPlaceOrder = (Button) view.findViewById(R.id.buttonPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), SuccessfulActivity.class);
                startActivity(in);
            }
        });

        return view;
    }



    private List<Cart> getListCarts() {
        List<Cart> list = new ArrayList<>();
        list.add(new Cart(R.drawable.list_food_1, "Bún đậu mẹt tre", "2", "Làm cho ngon vô", "12.000"));
        list.add(new Cart(R.drawable.list_food_1, "Bún đậu mẹt tre", "2", "Làm cho ngon vô", "12.000"));
        list.add(new Cart(R.drawable.list_food_1, "Bún đậu mẹt tre", "2", "Làm cho ngon vô", "12.000"));
        return list;
    }

}