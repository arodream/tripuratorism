package com.arodream.tripuratourism.ui.qna;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.arodream.tripuratourism.R;
import com.google.android.material.textfield.TextInputEditText;

public class QnaFragment extends Fragment {
    TextInputEditText subjectTxt, detailTxt;
    Button submitBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_qna,container,false);
        subjectTxt = root.findViewById(R.id.qna_subject);
        detailTxt = root.findViewById(R.id.qna_detail);
        submitBtn = root.findViewById(R.id.qna_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();

            }
        });
        return root;
    }

    private void sendEmail(){
        String subject = subjectTxt.getText().toString();
        String detail = detailTxt.getText().toString();

        String[] to = {"mail2ajoyshil@gmail.com"};

        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.setType("text/plain");

        email.putExtra(Intent.EXTRA_EMAIL,to);
        email.putExtra(Intent.EXTRA_SUBJECT,subject);
        email.putExtra(Intent.EXTRA_TEXT,detail);

        try {
            startActivity(Intent.createChooser(email,"Send Email....."));
            //Toast.makeText(getContext(),"Email sent",Toast.LENGTH_SHORT).show();
            subjectTxt.setText("");
            detailTxt.setText("");
        }catch (Exception e){
            Toast.makeText(getContext(),"There is no Email client installed",Toast.LENGTH_SHORT).show();
        }
    }
}
