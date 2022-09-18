package com.yagizgokce.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import com.yagizgokce.myapplication.databinding.FragmentMenuBinding


class MenuFragment : Fragment(),MenuRecyclerAdapter.Listener {
    private lateinit var MenuFragmentBinding: FragmentMenuBinding
    private var marsModels: ArrayList<MarsDataModel>? = null
    private var recyclerViewAdapter : MenuRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MenuFragmentBinding = FragmentMenuBinding.inflate(layoutInflater)
        val view = MenuFragmentBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context,2)
        MenuFragmentBinding.recyclerView.layoutManager = layoutManager

        getData()
    }

    fun getData(){

        MarsApi.retrofitService.getProperties().enqueue(object : Callback<List<MarsDataModel>>{
            override fun onResponse(call: Call<List<MarsDataModel>>, response: Response<List<MarsDataModel>>) {

                if(response.isSuccessful){
                    response.body()?.let { responseList ->
                        marsModels = ArrayList(responseList)

                        marsModels?.let {

                            recyclerViewAdapter = MenuRecyclerAdapter(it,this@MenuFragment)
                            MenuFragmentBinding.recyclerView.adapter = recyclerViewAdapter
                        }
                    }

                }

            }

            override fun onFailure(call: Call<List<MarsDataModel>>, t: Throwable) {
                Log.v("PATIKA",t.message.toString())
            }

        })
    }

    override fun onItemClick(marsDataModel: MarsDataModel) {
        val action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(marsDataModel)
        findNavController().navigate(directions = action)
    }


}