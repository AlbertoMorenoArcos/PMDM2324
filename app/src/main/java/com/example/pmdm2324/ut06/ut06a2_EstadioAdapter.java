package com.example.pmdm2324.ut06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.R;

import java.util.ArrayList;

public class ut06a2_EstadioAdapter extends RecyclerView.Adapter<ut06a2_EstadioAdapter.ViewHolder>  {
    private ArrayList<ut06a2_Estadio> datos;

    /*
     * Relacionado con el evento.
     */
    public interface ItemClickListener {
        void onClick(View view, int position, ut06a2_Estadio producto);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView nombre;
        private final TextView n_aficionados;

        private  final TextView nacion;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            nombre = (TextView) view.findViewById(R.id.ut06a2_ListaNombre);
            n_aficionados = (TextView) view.findViewById(R.id.ut06a2_ListaAficionados);
            nacion = (TextView) view.findViewById(R.id.ut06a2_ListaNacion);
            view.setOnClickListener(this);
        }

        public void setInfo(String nombre_estadio, int num_aficionados, String n_nacion) {
            nombre.setText(nombre_estadio);
            n_aficionados.setText(String.valueOf(num_aficionados));
            nacion.setText(n_nacion);
        }

        @Override
        public void onClick(View view) {
            // Si tengo un manejador de evento lo propago con el índice
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition(), datos.get(getAdapterPosition()));
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public ut06a2_EstadioAdapter(ArrayList<ut06a2_Estadio> dataSet) {
        datos = new ArrayList<ut06a2_Estadio>();
        add(dataSet);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_estadio, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        ut06a2_Estadio e = datos.get(position);
        viewHolder.setInfo(e.getNombre(),e.getN_Aficionados(), e.getNacion());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void add(ArrayList<ut06a2_Estadio> dataSet){
        datos.addAll(dataSet);
        notifyDataSetChanged();
    }
}
