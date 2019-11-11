package avila.domingo.lifecycle.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import avila.domingo.lifecycle.R
import avila.domingo.lifecycle.base.BaseActivity
import avila.domingo.lifecycle.util.TAG
import avila.domingo.lifecycle.di.qualifiers.Ac2
import avila.domingo.lifecycle.ui.data.ResourceState
import kotlinx.android.synthetic.main.activity_main2.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class Main2Activity : BaseActivity() {

    private val obtainLifecycle: Unit by inject(Ac2) { parametersOf(this.lifecycle) }
    private val mainActivityViewModel: MainActivity2ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        obtainLifecycle.run { }
        mainActivityViewModel.generateRandomInt()
        mainActivityViewModel.generateRandomString()

        mainActivityViewModel.randomIntLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        Log.d(TAG, "Random int: $this")
                    }
                }
            }
        })

        mainActivityViewModel.randomStringLiveData.observe(this, Observer { resource ->
            resource?.run {
                managementResourceState(status, message)
                if (status == ResourceState.SUCCESS) {
                    data?.run {
                        Log.d(TAG, "Random string: $this")
                    }
                }
            }
        })

        button_navigate_1.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }

        button_navigate_3.setOnClickListener {
            startActivity(Intent(this, Main3Activity::class.java))
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main2

    override fun checkAgain(): () -> Unit = {}

    override fun tryAgain(): () -> Unit = {}
}


