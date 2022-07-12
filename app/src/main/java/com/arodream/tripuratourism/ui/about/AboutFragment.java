package com.arodream.tripuratourism.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arodream.tripuratourism.R;
import com.arodream.tripuratourism.model.Student;

import java.util.ArrayList;

public class AboutFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Student> list = new ArrayList<>();
    AboutAdapter aboutAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about,container,false);
        recyclerView = root.findViewById(R.id.aboutRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

//        Student student = new Student(R.drawable.shubham,"Shubham Das","App Developer","8787636059");
//        Student student1 = new Student(R.drawable.rupesh,"Rupesh Das","User Interface Designer"," 8837269230");
//        Student student2 = new Student(R.drawable.gdp,"Parth Das","User Interface Designer","8542588558");
//
//        list.add(student);list.add(student1);list.add(student2);
//        aboutAdapter = new AboutAdapter(getContext(),list);
//
//        recyclerView.setAdapter(aboutAdapter);

        return root;
    }

}
