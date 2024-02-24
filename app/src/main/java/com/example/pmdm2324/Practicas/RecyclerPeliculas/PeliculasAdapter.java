package com.example.pmdm2324.Practicas.RecyclerPeliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.Practicas.consumoApi.Peliculas;
import com.example.pmdm2324.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ViewHolder>{
    private ArrayList<Peliculas> datosPeliculas;
    private OnItemClickListener listener;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView descripcion;
        private final TextView estrellas;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.NombrePelicula);
            descripcion = (TextView) view.findViewById(R.id.Descripcion);
            estrellas = (TextView) view.findViewById(R.id.Estrellas);
        }

        public TextView getNombrePeliculas() {
            return nombre;
        }

        public TextView getDescripcion() {
            return descripcion;
        }
        public TextView getEstrellas() {
            return estrellas;
        }

    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public PeliculasAdapter(List<Peliculas> dataSet) {
        datosPeliculas = new ArrayList<Peliculas>();
        add(dataSet);
    }
    public interface OnItemClickListener {
        void onItemClick(Peliculas pelicula);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PeliculasAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_peliculas, viewGroup, false);

        return new PeliculasAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PeliculasAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getNombrePeliculas().setText("Nombre: " + datosPeliculas.get(position).nombre.toString());
        viewHolder.getDescripcion().setText("Descripcion: " + datosPeliculas.get(position).descripcion.toString());
        viewHolder.getEstrellas().setText("Estrellas: " + datosPeliculas.get(position).estrellas.toString());

        Peliculas pelicula = datosPeliculas.get(position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(pelicula);
                }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datosPeliculas.size();
    }

    public void add(List<Peliculas> dataSet) {
        datosPeliculas.addAll(dataSet);
        notifyDataSetChanged();
    }
}
