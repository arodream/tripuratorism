package com.arodream.tripuratourism.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arodream.tripuratourism.R;
import com.arodream.tripuratourism.model.Student;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.AboutViewHolder> {
    Context context;
    List<Student> students;

    public AboutAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public AboutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_about_detail,parent,false);
        return new AboutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutViewHolder holder, int position) {

        Student student = students.get(position);
        holder.nameTxt.setText(student.getName());
        holder.detailTxt.setText(student.getDetail());
        holder.img.setImageResource(student.getImg());

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class AboutViewHolder extends RecyclerView.ViewHolder {
        TextView nameTxt, detailTxt;
        CircleImageView img;
        public AboutViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.std_name);
            detailTxt = itemView.findViewById(R.id.std_detail);
            img = itemView.findViewById(R.id.std_img);

        }
    }
}
