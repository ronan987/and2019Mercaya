package com.example.mercaya;


import androidx.appcompat.app.ActionBar;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class ImagenesPapas extends AppCompatActivity implements View.OnClickListener {
    TextView txtnombre, txtdetalle;
    ImageView img;

    int position = -1;


    List<Productos> listaFrutas = new ArrayList<>();
    RecyclerView recyclerView;
    ProductoAdapter adapter = new ProductoAdapter( listaFrutas, this );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.product );




        txtnombre = findViewById( R.id.Name );
        txtdetalle = findViewById( R.id.detalle );

        img = findViewById( R.id.Image );

        llenarFrutas();
        recyclerView = findViewById( R.id.recycler_view );
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager( this, 2 );
        recyclerView.setLayoutManager( mLayoutManager );
        recyclerView.setItemAnimator( new DefaultItemAnimator() );
        recyclerView.setAdapter( adapter );


    }

    private void llenarFrutas() {
        Productos product = new Productos( "Papas", R.drawable.papas, "Ver mas" );
        listaFrutas.add( product );
        product = new Productos( "Granos y Cereales", R.drawable.granos, "Ver mas" );
        listaFrutas.add( product );
        product = new Productos( "Frutas", R.drawable.frutas_variadas, "Ver mas" );
        listaFrutas.add( product );


        product = new Productos( "Frutas", R.drawable.frutas_variadas, "Ver mas" );
        listaFrutas.add( product );
        product = new Productos( "Frutas", R.drawable.frutas_variadas, "Ver mas" );
        listaFrutas.add( product );
        product = new Productos( "Frutas", R.drawable.frutas_variadas, "Ver mas" );
        listaFrutas.add( product );


    }


    @Override
    public void onClick(View v) {

    }
}

