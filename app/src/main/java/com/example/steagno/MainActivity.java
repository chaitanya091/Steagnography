package com.example.steagno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_secretImage, iv_coverImage;
    Button btn_selectCoverImage,btn_selectSecretImage,btn_encrypt;
    int SELECT_COVER_PICTURE = 200;
    int SELECT_SECRET_PICTURE = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setCoverImageBtn();
        setSecretImageBtn();
        
    }

    public void init(){
        iv_coverImage = findViewById(R.id.iv_coverImage);
        iv_secretImage = findViewById(R.id.iv_secretImage);
        btn_selectCoverImage = findViewById(R.id.btn_selectCoverImage);
        btn_selectSecretImage = findViewById(R.id.btn_selectSecretImage);
        btn_encrypt = findViewById(R.id.btn_encrypt);
    }

    private void setSecretImageBtn() {
        btn_selectSecretImage.setOnClickListener(v -> secretImageChooser());
    }

    private void setCoverImageBtn() {
        btn_selectCoverImage.setOnClickListener(v -> coverImageChooser());
    }

    private void coverImageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Cover Picture"), SELECT_COVER_PICTURE);
    }

    private void secretImageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Secret Picture"), SELECT_SECRET_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == SELECT_COVER_PICTURE) {
                if (resultCode == RESULT_OK) {
                    Uri selectedCoverImageUri = data.getData();
                    if (null != selectedCoverImageUri) {
                        iv_coverImage.setImageURI(selectedCoverImageUri);
                    }
                }
            }
            if (requestCode == SELECT_SECRET_PICTURE) {
                if (resultCode == RESULT_OK) {
                    Uri selectedSecretImageUri = data.getData();
                    if (null != selectedSecretImageUri) {
                        iv_secretImage.setImageURI(selectedSecretImageUri);
                    }
                }
            }
    }
}