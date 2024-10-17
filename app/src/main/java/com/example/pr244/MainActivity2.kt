package com.example.pr244

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pr244.R.*
import com.example.pr244.R.id.*
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(fragmentContainerView) as NavHostFragment? ?: return
        val navController = host.navController
        val sideBar = findViewById<NavigationView>(navigation_view)
        sideBar.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
        toolBar.setupWithNavController(navController,appBarConfiguration)


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_right_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val navController = findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}