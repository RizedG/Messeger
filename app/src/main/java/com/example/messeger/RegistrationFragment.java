package com.example.messeger;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.messeger.databinding.FragmentRegistrationBinding;

import ViewModels.RegistrationViewModel;
import ru.tinkoff.decoro.Mask;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class RegistrationFragment extends Fragment {
    private FragmentRegistrationBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.next.setEnabled(false);

        Slot[] slots = new PhoneNumberUnderscoreSlotsParser().parseSlots("+8 (9__) ___-__-__");
        FormatWatcher formatWatcher = new MaskFormatWatcher(MaskImpl.createTerminated(slots));
        formatWatcher.installOn(binding.room);
        binding.room.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().length() == 18) binding.next.setEnabled(true);
                else binding.next.setEnabled(false);
            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Ура", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_basicWindow);
            }
        });
        return view;
    }
}