package com.max.def.kotlinviews

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class SettingsActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        createRadioButtons();

    }

    private fun createRadioButtons()
    {
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group_buttons);
        val transformers = resources.getStringArray(R.array.transformers_list_array);

        for (transformer in transformers)
        {
            val radioButton = RadioButton(this)

            radioButton.text = transformer

            radioButton.setOnClickListener()
            {
                Toast.makeText(this,"You Clicked $transformer",Toast.LENGTH_SHORT).show();

                saveTransformer(transformer);
            }

            radioGroup.addView(radioButton)

            if (transformer == getTransformer(this))
            {
                radioButton.isChecked = true
            }
        }
    }

    companion object
    {
        fun getTransformer(context: Context): String?
        {
            val preference : SharedPreferences = context.getSharedPreferences("Transformers", Context.MODE_PRIVATE)

            return preference.getString("transformers","DefaultTransformer")
        }
    }

    private fun saveTransformer(transformer: String?)
    {
        val preference = this.getSharedPreferences("Transformers", Context.MODE_PRIVATE);
        val editor = preference.edit();

        editor.putString("transformers",transformer)
        editor.apply()
    }
}
