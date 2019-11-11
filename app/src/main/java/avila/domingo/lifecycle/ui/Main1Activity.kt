package avila.domingo.lifecycle.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import avila.domingo.lifecycle.R
import avila.domingo.lifecycle.base.BaseActivity
import avila.domingo.lifecycle.di.qualifiers.Ac1
import avila.domingo.lifecycle.ui.data.ResourceState
import avila.domingo.lifecycle.util.TAG
import kotlinx.android.synthetic.main.activity_main1.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class Main1Activity : BaseActivity() {

    private val obtainLifecycle: Unit by inject(Ac1) { parametersOf(this.lifecycle) }
    private val mainActivityViewModel: MainActivity1ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        obtainLifecycle.run { }
        mainActivityViewModel.generateRandomDouble()
        mainActivityViewModel.generateRandomInt()

        mainActivityViewModel.randomDoubleLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        Log.d(TAG, "Random double: $this")
                    }
                }
            }
        })

        mainActivityViewModel.randomIntLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        Log.d(avila.domingo.lifecycle.util.TAG, "Random int: $this")
                    }
                }
            }
        })

        button_navigate_2.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }

        button_navigate_3.setOnClickListener {
            startActivity(Intent(this, Main3Activity::class.java))
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main1

    override fun checkAgain(): () -> Unit = {}

    override fun tryAgain(): () -> Unit = {}
}
