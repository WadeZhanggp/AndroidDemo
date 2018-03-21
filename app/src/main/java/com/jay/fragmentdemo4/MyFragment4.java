package com.jay.fragmentdemo4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jay.fragmentdemo4.util.FileHelper;

import java.io.IOException;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment implements View.OnClickListener {

    private EditText editname;
    private EditText editdetail;
    private Button btnsave;
    private Button btnclean;
    private Button btnread;
    private Context mContext;
    private View mView;

    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fg_content4, container, false);
        mContext = this.getActivity().getApplicationContext();
        bindViews();
        return mView;
    }

    private void bindViews() {
        editdetail = (EditText) mView.findViewById(R.id.editdetail);
        editname = (EditText) mView.findViewById(R.id.editname);
        btnclean = (Button) mView.findViewById(R.id.btnclean);
        btnsave = (Button) mView.findViewById(R.id.btnsave);
        btnread = (Button) mView.findViewById(R.id.btnread);

        btnclean.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnclean:
                editdetail.setText("");
                editname.setText("");
                break;
            case R.id.btnsave:
                FileHelper fHelper = new FileHelper(mContext);
                String filename = editname.getText().toString();
                String filedetail = editdetail.getText().toString();
                try {
                    fHelper.save(filename, filedetail);
                    Toast.makeText(mContext, "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(mContext, "数据写入失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnread:
                String detail = "";
                FileHelper fHelper2 = new FileHelper(mContext);
                try {
                    String fname = editname.getText().toString();
                    detail = fHelper2.read(fname);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(mContext, detail, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
