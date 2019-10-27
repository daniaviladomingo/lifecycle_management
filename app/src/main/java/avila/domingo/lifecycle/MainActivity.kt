package avila.domingo.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import avila.domingo.lifecycle.di.qualifiers.Ac1
import avila.domingo.lifecycle.di.qualifiers.M1
import avila.domingo.lifecycle.modules.Module1LifecycleSubscriber
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val obtainLifecycle: Unit by inject(Ac1) { parametersOf(this.lifecycle) }
    private val module1LifecycleSubscriber: Module1LifecycleSubscriber by inject(M1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        obtainLifecycle.run {  }

        module1LifecycleSubscriber.doStuff()

        button_navigate.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }
    }
}
