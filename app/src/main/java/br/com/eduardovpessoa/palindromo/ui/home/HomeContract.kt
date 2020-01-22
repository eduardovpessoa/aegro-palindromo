package br.com.eduardovpessoa.palindromo.ui.home

import br.com.eduardovpessoa.palindromo.data.entity.Word

interface HomeContract {
    interface View {
        fun initViews()
        fun setAdapter(list: MutableList<Word>)
    }

    interface Presenter {
        fun insertWord(word: Word)
        fun loadWords()
        fun verifyWord(name: String)
        fun onDestroy()
    }
}