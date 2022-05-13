package Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import Adapter.CartAdapter;
import hcmute.edu.vn.foodapp_16.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rcvCart;
    private CartAdapter cartAdapter;

    private TextView tvTest;

    private int imgFood = 0;
    private String nameFood;
    private String quantity;
    private String note;
    private String price;

    private Button btnGotoCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        ImageView imgViewFood = findViewById(R.id.imageView_Food);
        TextView tvNameFood = findViewById(R.id.textView_FoodName);
        TextView tvQuantity = findViewById(R.id.textView_Quantity);
        TextView tvNote = findViewById(R.id.textView_Note);
        TextView tvPrice = findViewById(R.id.textView_Price);

        imgFood = bundle.getInt("key_imgFood");
        nameFood = bundle.getString("key_nameFood");
        quantity = bundle.getString("key_quantity");
        note = bundle.getString("key_note");
        price = bundle.getString("key_price");

        imgViewFood.setImageResource(imgFood);
        tvNameFood.setText(nameFood);
        tvQuantity.setText(quantity);
        tvNote.setText(note);
        tvPrice.setText(price);

    }


}