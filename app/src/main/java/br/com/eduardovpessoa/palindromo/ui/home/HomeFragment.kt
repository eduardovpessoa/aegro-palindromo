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
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private var presenter: HomeContract.Presenter? = null
    private lateinit var layout: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        layout = view.findViewById(R.id.homeLayout)
    }

    override fun initViews() {
        presenter = HomePresenter(this)
        recyclerHome.layoutManager = LinearLayoutManager(context)
        recyclerHome.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun setAdapter(list: MutableList<Word>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDetach() {
        presenter?.onDestroy()
        presenter = null
        super.onDetach()
    }
}