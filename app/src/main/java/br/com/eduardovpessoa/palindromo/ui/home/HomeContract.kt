package br.com.eduardovpessoa.palindromo.ui.home

import br.com.eduardovpessoa.palindromo.data.entity.Word

interface HomeContract {
    interface View {
        fun initViews()
        fun onClickVerify()
        fun setAdapter(list: MutableList<Word>)
        fun showMessage(name : String)
    }

    interface Presenter {
        fun insertWord(word: Word)
        fun loadWords()
        fun verifyWord(name: String)
        fun onDestroy()
    }
}