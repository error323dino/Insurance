package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            //Declare varaible to store basic, extra and total
            var basic: Int = 0
            var extra: Int = 0

            val age: Int = binding.spinnerAge.selectedItemPosition
            if (age == 0){
                basic = 60
            }
            else if (age ==1 ){
                basic = 70
            }
            else if (age ==2 ){
                basic = 90
            }
            else if (age ==3 ){
                basic = 120
            }
            else{
                basic = 150
            }

            val gender = binding.radioGroupGender.checkedRadioButtonId
            if(gender == binding.radioButtonMale.id){
                if (age == 0){
                    extra = 50
                }
                else if (age ==1 ){
                    extra = 100
                }
                else if (age ==2){
                    extra = 150
                }
                else if (age ==3){
                    extra = 200
                }
                else{
                    extra = 200
                }
            }

            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker) {
                if (age == 0){
                    extra = extra
                }
                else if (age == 1){
                    extra =  extra + 100
                }
                else if (age == 2){
                    extra =  extra + 150
                }
                else if (age == 3) {
                    extra =  extra + 200
                }
                else if (age == 4) {
                    extra =  extra + 250
                }

                else{
                    extra =  extra + 300
                }
            }

            val premium = Premium(basic, extra, basic + extra)
            binding.myPremium = premium


        }
        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0,false)
            binding.radioGroupGender.clearCheck()
            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker) {
                binding.checkBoxSmoker.toggle()
            }

            var basic: Int = 0
            var extra: Int = 0

            val premium = Premium(basic, extra, basic + extra)
            binding.myPremium = premium


        }
    }
}