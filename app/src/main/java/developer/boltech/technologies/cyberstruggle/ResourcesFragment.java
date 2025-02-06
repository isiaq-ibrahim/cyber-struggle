package developer.boltech.technologies.cyberstruggle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ResourcesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resources, container, false);

        final CardView changingMeaningCardView = view.findViewById(R.id.changingMeaningCardView);
        final CardView comHijackingCardView = view.findViewById(R.id.comHijackingCardView);
        final CardView microsoftAdvancedThreatCardView = view.findViewById(R.id.microsoftAdvancedThreatCardView);
        final CardView microsoftSMBv3ThreatCardView = view.findViewById(R.id.microsoftSMBv3ThreatCardView);
        final CardView intelligencePlanningCardView = view.findViewById(R.id.intelligencePlanningCardView);
        final CardView symantecEndpointCardView = view.findViewById(R.id.symantecEndpointCardView);

        changingMeaningCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),JournalOne.class);
                startActivity(intent);
            }
        });

        comHijackingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), JournalTwo.class);
                startActivity(intent);
            }
        });

        microsoftAdvancedThreatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), JournalFive.class);
                startActivity(intent);
            }
        });

        microsoftSMBv3ThreatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),JournalSix.class);
                startActivity(intent);
            }
        });

        intelligencePlanningCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), JournalSeven.class);
                startActivity(intent);
            }
        });

        symantecEndpointCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), JournalEight.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
