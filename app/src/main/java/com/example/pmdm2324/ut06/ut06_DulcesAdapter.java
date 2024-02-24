package com.example.pmdm2324.ut06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ut06_DulcesAdapter extends RecyclerView.Adapter<ut06_DulcesAdapter.ViewHolder>{

    private ArrayList<ut06_DulcesNavideños> datos;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombre;
        private final TextView calorias;
        private final TextView fruto_seco;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.NombrePelicula);
            calorias = (TextView) view.findViewById(R.id.Descripcion);
            fruto_seco = (TextView) view.findViewById(R.id.Estrellas);
        }

        public TextView getTextNombre() {
            return nombre;
        }

        public TextView getTextCalorias() {
            return calorias;
        }
        public TextView getTextFrutoSeco() {
            return fruto_seco;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public ut06_DulcesAdapter(ut06_DulcesNavideños[] dataSet) {
        datos = new ArrayList<ut06_DulcesNavideños>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ut06_DulcesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_dulces, viewGroup, false);

        return new ut06_DulcesAdapter.ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ut06_DulcesAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextNombre().setText(datos.get(position).nombre);
        viewHolder.getTextCalorias().setText(datos.get(position).calorias);
        viewHolder.getTextFrutoSeco().setText(datos.get(position).fruto_seco);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(ut06_DulcesNavideños[] dataSet) {
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
