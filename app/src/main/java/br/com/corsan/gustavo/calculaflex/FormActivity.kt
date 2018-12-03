package br.com.corsan.gustavo.calculaflex

import br.com.corsan.gustavo.calculaflex.extensions.getDouble
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.corsan.gustavo.calculaflex.watches.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage))
        etEthanolAverage.addTextChangedListener(DecimalTextWatcher(etEthanolAverage, 1))

        btCalculate.setOnClickListener(){
            val nextView = Intent(this,ResultActivity::class.java)
            nextView.putExtra( "GAS_PRICE",etGasPrice.getDouble())
            nextView.putExtra("ETHANOL_PRICE",etEthanolPrice.getDouble())
            nextView.putExtra("GAS_AVERAGE",etGasAverage.getDouble())
            nextView.putExtra("ETHANOL_AVERAGE",etEthanolAverage.getDouble())
            startActivity(nextView)
        }

    }

}
