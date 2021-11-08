package org.aplas.listmatakuliah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView FotoMatkul;
    TextView textViewNamaMatkul, textViewInfoMatkul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FotoMatkul = findViewById(R.id.FotoMatkul);
        textViewNamaMatkul = findViewById(R.id.textViewNamaMatkul);
        textViewInfoMatkul = findViewById(R.id.textViewInfoMatkul);

        getIncomingExtra();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //memanggil inflater
        MenuInflater inflater = this.getMenuInflater();

        //meng inflate(menggambar menu di activity
        inflater.inflate(R.menu.menu_tentang, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId){
            case R.id.tentang_id:
                Intent i = new Intent(DetailActivity.this, AboutActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("foto_matkul") && getIntent().hasExtra("nama_matkul") && getIntent().hasExtra("info_matkul")){
            String fotoMatkul = getIntent().getStringExtra("foto_matkul");
            String namaMatkul = getIntent().getStringExtra("nama_matkul");
            String infoMatkul = getIntent().getStringExtra("info_matkul");

            setDataActivity(fotoMatkul, namaMatkul, infoMatkul);
        }
    }

    private void setDataActivity(String fotoMatkul, String namaMatkul, String infoMatkul){
        Glide.with(this).asBitmap().load(fotoMatkul).into(FotoMatkul);
        textViewNamaMatkul.setText(namaMatkul);
        textViewInfoMatkul.setText(infoMatkul);
    }
}