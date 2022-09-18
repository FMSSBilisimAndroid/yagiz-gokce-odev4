package com.yagizgokce.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.yagizgokce.myapplication.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var DetailFragmentBinding : FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DetailFragmentBinding = FragmentDetailBinding.inflate(layoutInflater)
        val view = DetailFragmentBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingInit()

        DetailFragmentBinding.apply {
            buyButton.setOnClickListener {
                buyEstate()
            }
        }

    }

    private fun bindingInit() {

        DetailFragmentBinding.apply {
            textPrice.text ="${args.currentMarsData.price}${'$'}"
            textID.text ="${args.currentMarsData.id}"
            textType.text="${args.currentMarsData.type.uppercase()}"
            buyButton.text="${args.currentMarsData.type.uppercase()}"
        }
        Picasso.get().load(args.currentMarsData.img_src).into(DetailFragmentBinding.itemView)

    }

    private fun buyEstate(){

        Toast.makeText(context, "${args.currentMarsData.type.uppercase()} MARS ESTATE", Toast.LENGTH_SHORT).show()

    }
}