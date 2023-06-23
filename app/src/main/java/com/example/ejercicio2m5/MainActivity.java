package com.example.ejercicio2m5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import com.example.ejercicio2m5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean FragmentShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // boton salir
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FragmentShow) {
                    Fragmentocerrado();
                } else{
                    Fragmentoabierto();
                }
            }
            private void Fragmentocerrado() {
                FragmentManager manager = getSupportFragmentManager();
                Fragmento fragmento = (Fragmento) manager.findFragmentById(binding.fragmentContainerView.getId());
                if( fragmento != null){

                    FragmentTransaction transaction= manager.beginTransaction();
                    transaction.remove(fragmento).commit();
                    binding.button.setText(R.string.open);
                    FragmentShow= false;
                }
            }
            private void Fragmentoabierto() {
                Fragmento fragmento = new Fragmento();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction().replace(binding.fragmentContainerView.getId(),
                        fragmento, Fragmento.class.getSimpleName());
                transaction.commit();
                binding.button.setText(R.string.close);
                FragmentShow= true;
            }
        });
    }
}