package com.fandipres.rekam

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listKamera: MutableList<DataCamera> = mutableListOf(
        DataCamera("Kamera Canon 60D", "DSLR", "RP 150.000 / Hari", R.drawable.cam_canon_60d),
        DataCamera("Kamera Canon 500D", "DSLR", "Rp 90.000 / Hari", R.drawable.cam_canon_500d),
        DataCamera("Kamera Canon 7D", "DSLR", "Rp 175.000 / Hari", R.drawable.cam_canon_7d),
        DataCamera("Kamera Canon 600D", "DSLR", "Rp 120.000 / Hari", R.drawable.cam_canon_600d),
        DataCamera("Kamera Canon 650D", "DSLR", "Rp 125.000 / Hari", R.drawable.cam_canon_650d),
        DataCamera(
            "Kamera Nikon D3200",
            "DSLR",
            "Rp 100.000 / Hari",
            R.drawable.cam_nikon_d3200
        ),
        DataCamera(
            "Kamera Nikon D5200",
            "DSLR",
            "Rp 120.000 / Hari",
            R.drawable.cam_nikon_d5200
        ),
        DataCamera("Kamera Nikon D90", "DSLR", "Rp 150.000 / Hari", R.drawable.cam_nikon_d90)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var objView = inflater.inflate(R.layout.fragment_home, container, false)
        var recyclerHome = objView.findViewById<RecyclerView>(R.id.recyclerViewCamera) as RecyclerView
        recyclerHome.layoutManager = LinearLayoutManager(activity)
        recyclerHome.adapter = AdapterRVCamera(listKamera)
        return objView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                AccountFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}