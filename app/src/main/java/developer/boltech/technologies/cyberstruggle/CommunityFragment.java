package developer.boltech.technologies.cyberstruggle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CommunityFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_community, container, false);

        // Initialize buttons
//        final Button btnIntegrityCheck = (Button) view.findViewById(R.id.btnIntegrityCheck);
//        final Button btnSecurityCheck = (Button) view.findViewById(R.id.btnSecurityCheck);

        final EditText commentEditText = (EditText) view.findViewById(R.id.commentEditText);
        final EditText nameEditText = (EditText) view.findViewById(R.id.nameEditText);
        final EditText emailEditText = (EditText) view.findViewById(R.id.emailEditText);
        final EditText websiteEditText = (EditText) view.findViewById(R.id.websiteEditText);
        final Button inquireButton = (Button) view.findViewById(R.id.inquireButton);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference reference = databaseReference.child("user_data");
        
        inquireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = commentEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String website = websiteEditText.getText().toString();
                
                UserData userData = new UserData(comment, name, email, website);
                reference.push().setValue(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Inquiry sent successfully!!!", Toast.LENGTH_SHORT).show();
                        
                        commentEditText.getText().clear();
                        nameEditText.getText().clear();
                        emailEditText.getText().clear();
                        websiteEditText.getText().clear();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Error sending inquiry to cyberstruggle. Please check your internet connection!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        final Button applyRibbonButton = (Button) view.findViewById(R.id.applyRibbonButton);
        applyRibbonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RibbonActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Integrity Check Activity
//        btnIntegrityCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), IntegrityCheckActivity.class);
//                startActivity(intent);
//            }
//        });

        // Navigate to Security Check Activity
//        btnSecurityCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), SecurityChecksActivity.class);
//                startActivity(intent);
//            }
//        });

        return view;

//        This was the initial return statement I used before declaring View view
//        return inflater.inflate(R.layout.fragment_community, container, false);
    }
}
