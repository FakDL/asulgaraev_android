package com.example.mobile_course.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_course.MainActivity
import com.example.mobile_course.recyclerview.PostSAdapter
import com.example.mobile_course.R
import com.example.mobile_course.SwipeToDelete
import com.example.mobile_course.data.PostSList
import com.example.mobile_course.models.PostS
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.item_sm_post.*

class EditFragment: Fragment() {

    private var adapter: PostSAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = PostSList.list.let { it1 ->
            PostSAdapter(it1,  {
            }) {
                PostSList.list.removeAt(it)
                adapter?.notifyDataSetChanged()
            }
        }
        rv_sm_post.adapter = adapter

        fab.setOnClickListener {
            var dialog = AddDialogFragment()
            dialog.setTargetFragment(this, 1)
            activity?.supportFragmentManager?.let {
                    it -> dialog.show(it, "addDialog")
            }
        }

        val divider = DividerItemDecoration(this.requireContext(), DividerItemDecoration.VERTICAL)
        rv_sm_post.addItemDecoration(divider)

        val item = object: SwipeToDelete(this.requireContext(), 0, ItemTouchHelper.LEFT) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int){
                adapter?.delete(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(item)
        itemTouchHelper.attachToRecyclerView(rv_sm_post)

        super.onViewCreated(view, savedInstanceState)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        adapter?.notifyDataSetChanged()
        super.onActivityResult(requestCode, resultCode, data)
    }

}