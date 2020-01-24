package br.com.eduardovpessoa.palindromo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardovpessoa.palindromo.R
import br.com.eduardovpessoa.palindromo.data.entity.Word

class HomeAdapter(var wordList: MutableList<Word>?) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(wordList?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_home_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (wordList.isNullOrEmpty()) {
            0
        } else {
            wordList!!.size
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var desc: TextView = itemView.findViewById(R.id.txtWord)
        var img: ImageView = itemView.findViewById(R.id.imgWord)
        fun bindView(word: Word?) {
            desc.text = word?.toString()
            if (word?.isPalindromo!!) {
                img.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_done
                    )
                )
            } else {
                img.setImageDrawable(
                    ContextCompat.getDrawable(
                        itemView.context,
                        R.drawable.ic_close
                    )
                )
            }

        }
    }

}