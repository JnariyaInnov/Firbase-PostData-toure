package com.karthi.sathguru;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TempUpActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PRO_IMAGE_REQUEST = 5;

    private ImageButton mButtonChooseImage;
    private Button mButtonUpload;
    //    private TextView mTextViewShowUploads;

    private EditText mEditTextFile;
    TextView mTextName, mCount;
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    private Uri mImageUri;
    Uri profileimg = null;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String date, email,uid, usName,pImgUrl, tName, m_Text, uploadName;

    private RecyclerView mUploadList;

    private List<String> fileNameList;
    private List<String> fileDoneList;

    private UploadListAdapter uploadListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_up);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        date = simpleDateFormat.format(calendar.getTime());

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            usName = user.getDisplayName();

        }

        mButtonChooseImage = findViewById(R.id.button_choose_image);
        mButtonUpload = findViewById(R.id.button_upload);
//        mTextViewShowUploads = findViewById(R.id.text_view_show_uploads);
        mTextName = findViewById(R.id.text_name);

        mTextName.setText(usName);
        tName = mTextName.getText().toString();
        if(tName.equals("")){
            Log.e("name of text","name");
            if(usName.equals("")){
                Log.e("name of text","no user name");

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Username and Profile picture");
                builder.setMessage("Type an username and click ok to select the profile picture");

// Set up the input
                final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        Log.e("username",m_Text);
                        mTextName.setText(m_Text);
                        picFileChooser();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        }

        mEditTextFile = findViewById(R.id.edit_text_descp);
        mUploadList = (RecyclerView) findViewById(R.id.upload_list);


        mStorageRef = FirebaseStorage.getInstance().getReference();
       // mDatabaseRef = FirebaseDatabase.getInstance().getReference("temples");

        fileNameList = new ArrayList<>();
        fileDoneList = new ArrayList<>();

        uploadListAdapter = new UploadListAdapter(fileNameList, fileDoneList);

        //RecyclerView

        mUploadList.setLayoutManager(new LinearLayoutManager(this));
        mUploadList.setHasFixedSize(true);
        mUploadList.setAdapter(uploadListAdapter);

        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // Name, email address, and profile photo Url
                    uploadName = user.getDisplayName();
                }
                if(uploadName.equals("")){
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(m_Text)
                            .setPhotoUri(Uri.parse(pImgUrl))
                            .build();

                    assert user != null;
                    user.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(TempUpActivity.this, "Profile updated!", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
                openFileChooser();
            }
        });

        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mUploadTask != null && mUploadTask.isInProgress()) {
//                    Toast.makeText(TempUpActivity.this, "Upload in progress", Toast.LENGTH_SHORT).show();
//                } else {
//                    uploadFile();
//                }
                finish();
            }
        });
        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
        if (user1 != null) {
            email = user.getEmail();
            uid = user.getUid();
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    //set icon
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    //set title
                    .setTitle("Login required")
                    //set message
                    .setMessage("Are you an existing user?")
                    //set positive button
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what would happen when positive button is clicked
                            Intent intent = new Intent(TempUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    })
                    //set negative button
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what should happen when negative button is clicked
                            Intent intent = new Intent(TempUpActivity.this, SignupActivity.class);
                            startActivity(intent);                        }
                    })
                    .show();
        }
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_REQUEST);
    }
    private void picFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PRO_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {

            if (data.getClipData() != null) {

                int totalItemsSelected = data.getClipData().getItemCount();

                for (int i = 0; i < totalItemsSelected; i++) {

                    Toast.makeText(TempUpActivity.this, "Selected Multiple images", Toast.LENGTH_SHORT).show();

                    Uri fileUri = data.getClipData().getItemAt(i).getUri();

                    String fileName = getFileName(fileUri);

                    fileNameList.add(fileName);
                    fileDoneList.add("uploading");
                    uploadListAdapter.notifyDataSetChanged();

                    StorageReference fileToUpload = mStorageRef.child("temples").child(fileName);
                    mDatabaseRef = FirebaseDatabase.getInstance().getReference("temples");

                    final int finalI = i;
                    fileToUpload.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            fileDoneList.remove(finalI);
                            fileDoneList.add(finalI, "done");

                            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user != null) {
                                // Name, email address, and profile photo Url
                                uploadName = user.getDisplayName();
                                profileimg = user.getPhotoUrl();
                            }

                            Upload upload = new Upload(uploadName,email, mEditTextFile.getText().toString().trim(),
                                    date, taskSnapshot.getDownloadUrl().toString(),profileimg.toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);

                            uploadListAdapter.notifyDataSetChanged();

                            Toast.makeText(TempUpActivity.this, "Images uploaded", Toast.LENGTH_SHORT).show();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TempUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }}).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            // mProgressBar.setProgress((int) progress);
                            //
                        }

                    });
                }


            } else if (data.getData() != null) {

                Uri fileUri = data.getData();

                String fileName = getFileName(fileUri);

                fileNameList.add(fileName);
                fileDoneList.add("uploading");
                uploadListAdapter.notifyDataSetChanged();

                StorageReference fileToUpload = mStorageRef.child("temples").child(fileName);
                mDatabaseRef = FirebaseDatabase.getInstance().getReference("temples");

                fileToUpload.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        fileDoneList.remove(0);
                        fileDoneList.add(0, "done");

                        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if (user != null) {
                            // Name, email address, and profile photo Url
                            uploadName = user.getDisplayName();
                            profileimg = user.getPhotoUrl();
                        }
                        Upload upload = new Upload(uploadName,email, mEditTextFile.getText().toString().trim(),
                                date, taskSnapshot.getDownloadUrl().toString(),profileimg.toString());

                        String uploadId = mDatabaseRef.push().getKey();
                        mDatabaseRef.child(uploadId).setValue(upload);

                        uploadListAdapter.notifyDataSetChanged();

                        Toast.makeText(TempUpActivity.this, "Image uploaded", Toast.LENGTH_SHORT).show();

                    }
                });

                Toast.makeText(TempUpActivity.this, "Selected Single image", Toast.LENGTH_SHORT).show();

            }

        }
        if (requestCode == PRO_IMAGE_REQUEST && resultCode == RESULT_OK) {

            if (data.getData() != null) {

                Uri fileUri = data.getData();

                String fileName = getFileName(fileUri);

                StorageReference fileToUpload = mStorageRef.child("profile").child(fileName);
                fileToUpload.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                        pImgUrl = taskSnapshot.getDownloadUrl().toString();
                        Log.e("imgurl",pImgUrl);

                        Toast.makeText(TempUpActivity.this, "Profile image uploaded !", Toast.LENGTH_SHORT).show();

                    }
                });

                Toast.makeText(TempUpActivity.this, "Profile image selected!", Toast.LENGTH_SHORT).show();

            }

        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

//    private void uploadFile() {
//        if (mImageUri != null) {
//
//            String name=mTextName.getText().toString().trim();
//            if (TextUtils.isEmpty(name)) {
//                Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            ProgressDialog progressDialog = new ProgressDialog(TempUpActivity.this);
//            progressDialog.setTitle("Upload in process...");
//            progressDialog.show();
//
//            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
//                    + "." + getFileExtension(mImageUri));
//
//            mUploadTask = fileReference.putFile(mImageUri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    mProgressBar.setProgress(0);
//                                }
//                            }, 500);
//
//                            Toast.makeText(TempUpActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
//                            TempUp temple = new TempUp(mTextName.getText().toString().trim(),email, mEditTextFile.getText().toString().trim(),
//                                    date, taskSnapshot.getDownloadUrl().toString());
//                            String uploadId = mDatabaseRef.push().getKey();
//                            mDatabaseRef.child(uploadId).setValue(temple);
//
//                            finish();
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(TempUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                            mProgressBar.setProgress((int) progress);
//                        }
//                    });
//        } else {
//            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
