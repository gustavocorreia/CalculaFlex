package br.com.corsan.gustavo.calculaflex

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.corsan.gustavo.calculaflex.extensions.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        calculate()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        val gasPrice = intent.extras.getDouble("GAS_PRICE", 0.0)
        val ethanolPrice = intent.extras.getDouble("ETHANOL_PRICE", 0.0)
        val gasAverage = intent.extras.getDouble("GAS_AVERAGE",0.0)
        val ethanolAverage = intent.extras.getDouble("ETHANOL_AVERAGE",0.0)

        val perfomanceMyCar = ethanolAverage / gasAverage
        val priceIndex = ethanolPrice / gasPrice

        if(priceIndex <= perfomanceMyCar){
            tvSuggestion.text = getString(R.string.label_ethanol)
        } else{
            tvSuggestion.text = getString(R.string.label_gasoline)
        }

        tvGasAverageResult.text = (gasPrice / gasAverage).format(4)
        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(4)

        tvFuelRatio.text = getString(R.string.label_ratio_fuel, perfomanceMyCar.format(2))
    }


}
