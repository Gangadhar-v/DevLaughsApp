package com.example.devlaughs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout


class JokesFragment : Fragment() {
    private lateinit var recylcerView:RecyclerView
    private lateinit var jokeAdapter:JokesAdapter


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_jokes, container, false)
        recylcerView = view.findViewById(R.id.jokesRecyclerView)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val jokesArrayList = args?.getStringArrayList("j")
        val array = ArrayList(jokesArrayList!!)

        val linearLayoutManager = ZoomRecyclerLayout(this@JokesFragment.requireContext())
        jokeAdapter = JokesAdapter(array)

        recylcerView.adapter = jokeAdapter
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        recylcerView.layoutManager = linearLayoutManager
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true


        }
    }
