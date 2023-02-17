package com.ok.redirect.sdk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ok.redirect.sdk.databinding.ActivityOkredirectBinding

internal class OkRedirectActivity : AppCompatActivity() {
    private var _binding: ActivityOkredirectBinding? = null
    private val binding: ActivityOkredirectBinding get() = _binding!!

    private val target: OkRedirectActivity get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView<ActivityOkredirectBinding?>(
            this, R.layout.activity_okredirect
        ).apply {
            lifecycleOwner = target
        }
        initNavGraph()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initNavGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_base)
        graph.setStartDestination(R.id.browserFragment)
        navHostFragment.findNavController().setGraph(graph, intent.extras)
    }
}