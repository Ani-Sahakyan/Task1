package am.example.task1

import am.example.task1.aa.repoModule
import am.example.task1.di.modules.retroCallModule
import am.example.task1.aa.viewModelModule
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(applicationContext)
            modules(repoModule, viewModelModule, retroCallModule)
        }

    }

}