package br.com.eduardovpessoa.palindromo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.eduardovpessoa.palindromo.R
import br.com.eduardovpessoa.palindromo.data.entity.Word
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private var presenter: HomeContract.Presenter? = null
    private lateinit var layout: View
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout = view.findViewById(R.id.homeLayout)
        initViews()
    }

    override fun initViews() {
        presenter = HomePresenter(this)
        imgCheck.setOnClickListener { onClickVerify() }
        recyclerHome.layoutManager = LinearLayoutManager(context)
        recyclerHome.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onClickVerify() {
        presenter?.verifyWord(edtWord.text.toString().trim())
    }

    override fun setAdapter(list: MutableList<Word>) {
        adapter = HomeAdapter(list)
        recyclerHome.adapter = adapter
    }

    override fun showMessage(name: String) {
        Snackbar.make(layout, name, Snackbar.LENGTH_LONG)
    }

    override fun onDetach() {
        presenter?.onDestroy()
        presenter = null
        super.onDetach()
    }
}