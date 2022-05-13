package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import Object.Food;
import hcmute.edu.vn.foodapp_16.R;

public class DishDetailsActivity extends AppCompatActivity {

    private Button btnAddCart;

    private ImageView imgViewFood;
    private TextView tvFoodName;
    private ElegantNumberButton quantity;
    private EditText edtNote;
    private TextView tvPrice;
    private TextView tvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);

        //MAPPING
        tvFoodName = findViewById(R.id.textView_FoodName);
        tvDescription = findViewById(R.id.textView_Description);
        tvPrice = findViewById(R.id.textView_Price);
        imgViewFood = findViewById(R.id.imageView_Food);


        //Click Food -> Go to Dish Details Activity
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Food food = (Food) bundle.get("object_food") ;

        //Mapping...............

        //Set Data
        tvFoodName.setText(food.getName());
        tvDescription.setText(food.getDescription());
        tvPrice.setText(food.getPrice());
        imgViewFood.setImageResource(food.getImage());

        ////////////////////////////////////////////////////////////////////////////////////////////////


        //Click Button Add to Card -> Go to Fragment Cart and set Data
        //////////////////////////////////////////////////////////////////////////////////////////////////

        //Mapping
        quantity = findViewById(R.id.numberButton_Quantity);
        edtNote = findViewById(R.id.editText_Note);

        btnAddCart = findViewById(R.id.button_Add_To_Card);

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToActivityCart();
            }
        });

        /////////////////////////////////////////////////////////////////////////////////////////////////


    }


    private void sendDataToActivityCart() {

        Integer imgFood = (Integer) imgViewFood.getTag();

        String strNameFood = tvFoodName.getText().toString().trim();

        String strQuantity = quantity.getNumber();

        String strNote = edtNote.getText().toString().trim();

        String strPrice = tvPrice.getText().toString().trim();




        //Navigation
        Intent intent = new Intent(DishDetailsActivity.this, CartActivity.class);
        intent.putExtra("key_imgFood", imgFood);
        intent.putExtra("key_nameFood", strNameFood);
        intent.putExtra("key_quantity", strQuantity);
        intent.putExtra("key_note", strNote);
        intent.putExtra("key_price", strPrice);
        startActivity(intent);


    }

}