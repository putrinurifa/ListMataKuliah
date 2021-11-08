package org.aplas.listmatakuliah;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private ArrayList<String> fotoMatkul = new ArrayList<>();
    private ArrayList<String> NamaMatakuliah = new ArrayList<>();
    private ArrayList<String> infoMatkul = new ArrayList<>();
    private Context context;


    public RecycleViewAdapter(ArrayList<String> fotoMatkul, ArrayList<String> namaMatakuliah, ArrayList<String> infoMatkul, Context context) {
        this.fotoMatkul = fotoMatkul;
        this.NamaMatakuliah = namaMatakuliah;
        this.infoMatkul = infoMatkul;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).asBitmap().load(fotoMatkul.get(position)).into(holder.imageViewFotoMatkul);
        holder.NamaMatkul.setText(NamaMatakuliah.get(position));

        holder.contraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, NamaMatakuliah.get(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("foto_matkul", fotoMatkul.get(position));
                intent.putExtra("nama_matkul", NamaMatakuliah.get(position));
                intent.putExtra("info_matkul", infoMatkul.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NamaMatakuliah.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewFotoMatkul;
        TextView NamaMatkul;
        ConstraintLayout contraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFotoMatkul = itemView.findViewById(R.id.imageViewFotoMatkul);
            NamaMatkul = itemView.findViewById(R.id.NamaMatkul);
            contraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
