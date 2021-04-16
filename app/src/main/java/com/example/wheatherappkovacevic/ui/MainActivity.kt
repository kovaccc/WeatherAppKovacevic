package com.example.wheatherappkovacevic.ui


import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.wheatherappkovacevic.R
import com.example.wheatherappkovacevic.databinding.ActivityMainBinding
import com.example.wheatherappkovacevic.dialogs.ProgressDialog
import com.example.wheatherappkovacevic.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


private val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var searchView: SearchView? = null

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var mainActivityBinding: ActivityMainBinding

    private var snackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityBinding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
        ).apply {
            viewModel = mainViewModel
            lifecycleOwner = this@MainActivity
        }

        mainViewModel.currentSnackbarLD.observe(this, {
            if(it != null) {
                createSnackBar(it)
                snackbar!!.show()
            }
            else {
                snackbar?.dismiss()
            }
        })

        mainViewModel.currentProgressbarLD.observe(this, {
            val progressDialog = ProgressDialog()
           if(it){
               progressDialog.show(supportFragmentManager, "progressDialog")
           }
            else {
                if(progressDialog.isResumed) progressDialog.dismiss()
            }
        })
    }


    private fun createSnackBar(errorMessage:String) {
        snackbar =  Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.dismiss)) {
                    snackbar?.dismiss()
                    mainViewModel.resetSnackBarState()
                }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.d(TAG, ".onCreateOptionsMenu: starts")
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        val searchableInfo = searchManager.getSearchableInfo(componentName)
        searchView?.setSearchableInfo(searchableInfo)

        searchView?.isIconified = false

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, ".onQueryTextSubmit: called")

                mainViewModel.resetSnackBarState()
                mainViewModel.searchCityWeather(query!!)
                searchView?.clearFocus()

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })


        Log.d(TAG, ".onCreateOptionsMenu: returning")
        return true
    }
}