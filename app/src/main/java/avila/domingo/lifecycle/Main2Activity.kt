package avila.domingo.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import avila.domingo.lifecycle.di.qualifiers.Ac2
import avila.domingo.lifecycle.di.qualifiers.M2
import avila.domingo.lifecycle.modules.Module2LifecycleSubscriber
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class Main2Activity : AppCompatActivity() {

    private val obtainLifecycle: Unit by inject(Ac2) { parametersOf(this.lifecycle) }
    private val module2LifecycleSubscriber: Module2LifecycleSubscriber by inject(M2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        obtainLifecycle.run { }

        module2LifecycleSubscriber.doStuff()
    }
}


