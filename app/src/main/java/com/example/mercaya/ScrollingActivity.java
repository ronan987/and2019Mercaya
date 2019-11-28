package com.example.mercaya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

       List<Productos> productos = new ArrayList<>();
        private RecyclerView recyclerView;
        private ProductoAdapter pAdapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_scrolling);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            pAdapter = new ProductoAdapter(productos,this);

            // Create grids with 2 items in a row
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(pAdapter);

            pAdapter.setMyListerner(new ProductoAdapter.OnClickInterface() {
                @Override
                public void getItemPosition(int position) {
                    Intent i = new Intent(getBaseContext(),ImagenesPapas.class);
                    startActivity(i);
                    Toast.makeText(ScrollingActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                }
            });

            DetealleProductos();
            pAdapter.notifyDataSetChanged();

        }

        private void DetealleProductos() {
            Productos product = new Productos("Papas",R.drawable.papas,"Ver mas");
            productos.add(product);
            product = new Productos("Granos y Cereales",R.drawable.granos,"Ver mas");
            productos.add(product);
            product = new Productos("Frutas",R.drawable.frutas_variadas,"Ver mas");
            productos.add(product);
            product = new Productos("Verduras",R.drawable.verduras,"Ver mas");
            productos.add(product);
            product = new Productos("Carnes",R.drawable.carne,"Ver mas");
            productos.add(product);
            product = new Productos("Leches y Lacteos",R.drawable.productos_lacteos,"Ver mas");
            productos.add(product);
            product = new Productos("Harinas",R.drawable.harinas,"Ver mas");
            productos.add(product);
            product = new Productos("Condimentos",R.drawable.condimentos,"Ver mas");
            productos.add(product);
        }
    }