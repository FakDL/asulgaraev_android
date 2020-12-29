package com.example.mobile_course.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.mobile_course.R
import com.example.mobile_course.database.Goal
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.launch


class ListFragment : Fragment() {

    private lateinit var listViewModel: ListViewModel

    private lateinit var listAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        listViewModel.getAllGoals().observe(viewLifecycleOwner,{
            listAdapter.setGoals(it)
        })

        val clickLambda: (goal: Goal) -> Unit = {
            listViewModel.navigateToCreate.observe(viewLifecycleOwner, Observer { goal ->
                goal?.let {
                    this.findNavController().navigate(
                        ListFragmentDirections
                            .actionListFragmentToCreateFragment(goal.goalId))
                    listViewModel.doneNavigating()
                }
            })
        }

        val deleteLambda: (goal: Goal) -> Unit = {
            listViewModel.delete(it)
        }

        listAdapter = ListAdapter(clickLambda, deleteLambda,listViewModel.getAllGoals())
        rv_list.adapter = listAdapter
    }

}