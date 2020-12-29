package com.example.mobile_course.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobile_course.R
import com.example.mobile_course.create.CreateFragmentDirections.actionCreateFragmentToListFragment
import com.example.mobile_course.database.Goal
import com.example.mobile_course.todolist.ListFragmentDirections
import kotlinx.android.synthetic.main.fragment_create.*


class CreateFragment : Fragment() {

    private lateinit var createViewModel: CreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createViewModel = ViewModelProvider(this).get(CreateViewModel::class.java)
        createViewModel.goalKey = CreateFragmentArgs.fromBundle(requireArguments()).goalKey

        btn_ok.setOnClickListener{
            onOkClicked()
        }

        createViewModel.navigateToList.observe(viewLifecycleOwner, Observer {
                this.findNavController().navigate(
                    CreateFragmentDirections
                        .actionCreateFragmentToListFragment())
                createViewModel.doneNavigating()
        })
    }

    fun onOkClicked(){
        val title = et_title.text.toString()
        val description = et_description.text.toString()

        if(title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(requireContext(), "Заполните все поля",Toast.LENGTH_SHORT).
            show()
            return
        }

        val goal: Goal = Goal()
        goal.title = title
        goal.description = description
        createViewModel.onSetGoal(goal = goal)

        createViewModel.doneNavigating()
    }
}