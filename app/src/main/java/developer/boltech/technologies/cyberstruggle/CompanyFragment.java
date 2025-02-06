package developer.boltech.technologies.cyberstruggle;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CompanyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_company, container, false);

        final TextView twitterTextView = view.findViewById(R.id.twitterTextView);
        twitterTextView.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView linkedInTextView = view.findViewById(R.id.linkedInTextView);
        linkedInTextView.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView instagramTextView = view.findViewById(R.id.instagramTextView);
        instagramTextView.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}
