package com.example.mercaya;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.CustomViewHolder> {

    private Context mContext;
    private List<Productos> productos;

    private OnClickInterface myListerner;

    public interface OnClickInterface {
        void getItemPosition(int positio);
    }

    public void setMyListerner(OnClickInterface myListerner) {
        this.myListerner = myListerner;
    }

    public ProductoAdapter(List<Productos> productos,Context mContext) {
        this.mContext = mContext;
        this.productos = productos;
    }


    public CustomViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View itemView = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.product,parent,false );

        return new CustomViewHolder( itemView );
    }


    public void onBindViewHolder(final ProductoAdapter.CustomViewHolder holder,int position) {
        final Productos producto = productos.get( position );
        holder.name.setText( producto.getName() );
        holder.detalle.setText( producto.getdetalle() );
        holder.image.setImageResource( producto.getImageResource() );

        holder.detalle.setOnClickListener( new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent= new Intent(mContext,ScrollingActivity.class );
                intent.putExtra( "name",producto.getImageResource() );
                intent.putExtra( "name",producto.getName() );
                mContext.startActivity(intent);

              showOptionsMenu( holder.detalle );


            }
        } );
    }

    /**
     * opciones en el menu de cada imagen
     */
    private void showOptionsMenu(View view) {
        PopupMenu popup = new PopupMenu( mContext,view );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate( R.menu.menu_producto,popup.getMenu() );

        popup.show();

    }


    public int getItemCount() {
        return productos.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name, detalle;
        public ImageView image;

        /**
         * Constructor to initialize the Views
         *
         * @param itemView
         */
        public CustomViewHolder(View itemView) {
            super( itemView );
            name = (TextView) itemView.findViewById( R.id.Name );
            detalle = (TextView) itemView.findViewById( R.id.detalle );
            image = (ImageView) itemView.findViewById( R.id.Image );


            image.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myListerner != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            myListerner.getItemPosition( position );
                        }
                    }
                }
            } );

        }
    }


}



