package Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.RestaurantAdapter;
import Object.Restaurant;
import hcmute.edu.vn.foodapp_16.R;

public class SearchFragment extends Fragment {

    private RecyclerView rcvFoods;

    private RestaurantAdapter restaurantAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        rcvFoods = view.findViewById(R.id.rcv_foods);
        rcvFoods.setLayoutManager(new LinearLayoutManager(this.getContext()));

        restaurantAdapter = new RestaurantAdapter(this.getContext(),getListFoods());

        rcvFoods.setAdapter(restaurantAdapter);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    private List<Restaurant> getListFoods() {
        List<Restaurant> list = new ArrayList<>();

        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre", "Bún đậu tá lả", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre", "Bún đậu tá lả", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre", "Bún đậu tá lả", "4.1 (100+)"));


        return list;
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}