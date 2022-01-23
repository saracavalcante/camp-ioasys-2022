package br.com.ioasys.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import br.com.ioasys.fragments2.fragments.FragmentExample

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            callFragmentExample()
        }
    }

    private fun callFragmentExample() {

        val bundle = bundleOf(
            "USER_ID" to 101,
            "USER_NAME" to "Sara Cavalcante",
            "USER_AGE" to 24
        )

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FragmentExample>(R.id.fragmentContainerView, args = bundle)
        }
    }
}