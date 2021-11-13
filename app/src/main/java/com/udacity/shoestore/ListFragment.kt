package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R.id.detailFragment
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.view.ShoeCard
import com.udacity.shoestore.viewmodels.ShoeListViewModel


class ListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentListBinding
    var navController: NavController?= null

    private val observer: Observer<Shoe> =
        Observer<Shoe> { t ->
            val shoeCard: ShoeCard = ShoeCard(context!!)
            binding.linearLayout.addView(shoeCard)
            shoeCard.configure(t!!)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity!!.finish()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.fragment_login) {
                findNavController().navigate(com.udacity.shoestore.R.id.fragment_login)
            }
            return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            findNavController().navigate(detailFragment)
        }

        for (shoe: Shoe in viewModel.shoes) {
            val shoeCard: ShoeCard = ShoeCard(context!!)
            binding.linearLayout.addView(shoeCard)
            shoeCard.configure(shoe)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.shoeLiveData.removeObserver(observer)
    }
}

