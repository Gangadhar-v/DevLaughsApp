package com.example.devlaughs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    lateinit var btn: Button
    lateinit var spinner: Spinner
    lateinit var progressBar: ProgressBar


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        btn = view.findViewById(R.id.getJokesBtn)
        spinner = view.findViewById(R.id.jokeAmountSpinner)
        progressBar = view.findViewById(R.id.progressBar)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val amount = spinner.selectedItem.toString().toInt()
            val retrofitService = RetrofitInstance.retrofitService


            retrofitService.getJokes(amount = amount).enqueue(object : Callback<JokeResponse> {
                override fun onResponse(
                    call: Call<JokeResponse>,
                    response: Response<JokeResponse>
                ) {

                    if (response.isSuccessful && response.body() != null) {
                        val jokesList = response.body()!!.jokes

                        if (!jokesList.isNullOrEmpty()) {
                            val jokesTexts: List<String> = jokesList.map { it.joke }
                            val arrayList = ArrayList(jokesTexts)

                            val bundle = Bundle().apply {
                                this.putStringArrayList("j", arrayList)
                            }
                            findNavController().navigate(
                                R.id.action_mainFragment_to_jokesFragment,
                                bundle
                            )
                            progressBar.visibility = View.GONE
                        } else {
                            Toast.makeText(requireContext(), "No jokes found", Toast.LENGTH_SHORT)
                                .show()
                        }


                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Failed  to retrieve jokes",
                            Toast.LENGTH_SHORT
                        )
                    }
                }

                override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), "Network request failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            )
        }
    }
}