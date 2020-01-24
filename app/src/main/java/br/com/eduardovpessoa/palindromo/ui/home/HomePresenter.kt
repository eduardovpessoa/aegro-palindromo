package br.com.eduardovpessoa.palindromo.ui.home

import android.content.Context
import br.com.eduardovpessoa.palindromo.PalindromoApplication
import br.com.eduardovpessoa.palindromo.data.PalindromoDatabase
import br.com.eduardovpessoa.palindromo.data.dao.WordDao
import br.com.eduardovpessoa.palindromo.data.entity.Word
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.toList
import kotlin.coroutines.CoroutineContext

class HomePresenter(var view: HomeContract.View?) : HomeContract.Presenter, CoroutineScope {

    private val db: PalindromoDatabase
    private val wordDao: WordDao
    private var job: Job = Job()
    private val context: Context
    override val coroutineContext: CoroutineContext get() = Dispatchers.IO + job
    private lateinit var wordList: MutableList<Word>

    init {
        view?.initViews()
        context = PalindromoApplication.applicationContext()
        db = PalindromoDatabase.getDatabase(context)
        wordDao = db.wordDao()
    }

    override fun insertWord(word: Word) {
        launch {
            wordDao.insert(word)
        }
    }

    override fun loadWords() {
        launch {
            wordList = wordDao.queryAll()
            withContext(Dispatchers.Main) {
                view?.setAdapter(wordList)
            }
        }
    }

    override fun verifyWord(name: String) {
        when (name.reversed().equals(name, true)) {
            true -> {
                launch {
                    insertWord(Word(name = name, isPalindromo = true))
                    withContext(Dispatchers.Main) {
                        view?.showMessage("A palavra $name é um palíndromo!")
                    }
                }
            }
            else -> {
                launch {
                    insertWord(Word(name = name))
                    withContext(Dispatchers.Main) {
                        view?.showMessage("A palavra $name não é um palíndromo!")
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        view = null
    }

}