package it.saimao.tmktaileconverter.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import it.saimao.tmktaileconverter.R;
import it.saimao.tmktaileconverter.language_tools.ShanRuleBasedSyllableSegmentation;
import it.saimao.tmktaileconverter.language_tools.TaiLeConverter;
import it.saimao.tmktaileconverter.language_tools.TaiLeSyllableSegmentation;
import it.saimao.tmktaileconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private String SHN;
    private String TDD;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SHN = getResources().getString(R.string.shan);
        TDD = getResources().getString(R.string.tai_le);
        binding.btConvert.setOnClickListener(this::convert);
        binding.btConvert.setOnLongClickListener(this::convertAndBreak);
        binding.btClear.setOnClickListener(this::clear);
        binding.btCopy.setOnClickListener(this::copy);
        binding.btCopy.setOnLongClickListener(this::copyBoth);
        binding.btBreak.setOnClickListener(this::sysBreak);
        binding.aboutUs.setOnClickListener(this::goToAboutUs);
        binding.rgroup.setOnCheckedChangeListener(this);
    }

    private void goToAboutUs(View view) {
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }

    private boolean convertAndBreak(View view) {
        if (binding.rbSHN2TDD.isChecked()) {
            String result = ShanRuleBasedSyllableSegmentation.segment(binding.edInput.getText().toString()).trim();
            binding.edOutput.setText(TaiLeConverter.shn2tdd(result).trim());
            return true;
        }
        return false;
    }

    private void sysBreak(View view) {
        if (binding.rbSHN2TDD.isChecked()) {
            // SHAN SYLLABLE BREAK
            binding.edOutput.setText(ShanRuleBasedSyllableSegmentation.segment(binding.edInput.getText().toString()).trim());
        } else {
            // TAI LE SYLLABLE BREAK
            binding.edOutput.setText(TaiLeSyllableSegmentation.segmentAsString(binding.edInput.getText().toString()).trim());
        }
    }

    public void copy(View view) {
        String text = binding.edOutput.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "No Output Text to be Copied!!", Toast.LENGTH_SHORT).show();
            return;
        }
        copyToClipboard(text);
        Toast.makeText(this, "Output Text Copied Successfully!", Toast.LENGTH_SHORT).show();
    }

    public boolean copyBoth(View view) {
        String outputText = binding.edOutput.getText().toString();
        String inputText = binding.edInput.getText().toString();
        if (outputText.isEmpty()) {
            Toast.makeText(this, "No Output Text to be Copied!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        String text;
        if (binding.rbSHN2TDD.isChecked()) {
            text = "#" + SHN + "#\n" + outputText + "\n#" + TDD + "#\n" + inputText;
        } else {
            text = "#" + TDD + "#\n" + inputText + "\n#" + SHN + "#\n" + outputText;
        }
        copyToClipboard(text);
        Toast.makeText(this, TDD + " & " + SHN + " Copied Successfully!", Toast.LENGTH_SHORT).show();

        return true;
    }

    private void copyToClipboard(String text) {

        ClipboardManager clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text", text);
        clipboard.setPrimaryClip(clip);
    }

    private void convert(View view) {

        if (binding.edInput.getText() == null || binding.edInput.getText().length() <= 0) return;

        if (binding.rbSHN2TDD.isChecked())
            binding.edOutput.setText(TaiLeConverter.shn2tdd(binding.edInput.getText().toString()).trim());
        else
            binding.edOutput.setText(TaiLeConverter.tdd2shn(binding.edInput.getText().toString()).trim());

        Log.d("Kham", binding.edOutput.getText().toString());
    }


    private void clear(View view) {
        binding.edInput.getText().clear();
        binding.edOutput.getText().clear();
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int rb) {
        if (rb == R.id.rbSHN2TDD) {
            binding.edInputLayout.setHint(SHN);
            binding.edOutputLayout.setHint(TDD);
        } else {
            binding.edInputLayout.setHint(TDD);
            binding.edOutputLayout.setHint(SHN);
        }


    }


}