package br.com.corsan.gustavo.calculaflex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btCalculate.setOnClickListener(){
            val nextView = Intent(this,ResultActivity::class.java)
            nextView.putExtra( "GAS_PRICE",etGasPrice.text.toString())
            nextView.putExtra("ETHANOL_PRICE",etEthanolPrice.text.toString())
            nextView.putExtra("GAS_AVERAGE",etGasAverage.text.toString())
            nextView.putExtra("ETHANOL_AVERAGE",etEthanolAverage.text.toString())
            startActivity(nextView)
        }

    }

}
