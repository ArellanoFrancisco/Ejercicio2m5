package com.example.ejercicio2m5;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.example.ejercicio2m5.databinding.FragmentoBinding;

public class Fragmento extends Fragment {
    private FragmentoBinding binding;
    public Fragmento() { } // Required empty public constructor

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentoBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = binding.radiogroup.indexOfChild(binding.radiogroup.findViewById(checkedId));
                switch (index) {

                    case 0:
                        binding.textView1.setText(R.string.Answer3);
                        break;

                    case 1:
                        binding.textView1.setText(R.string.Answer4);
                        break;

                    default:
                        break;
                }
            }
        });
      }
}