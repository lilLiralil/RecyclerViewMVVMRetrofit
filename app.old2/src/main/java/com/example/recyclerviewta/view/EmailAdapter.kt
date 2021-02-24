package com.example.recyclerviewta.view

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewta.R
import com.example.recyclerviewta.model.Email
import kotlinx.android.synthetic.main.item.view.*

/* CLASSE RESPONSÁVEL POR GERENCIAR DINAMICAMENTE A LISTA

 */
class EmailAdapter (val emails: MutableList<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>()
{
//INFLANDO(MONTANDO COM OS ITENS ADQUIRIDOS)O LAYOUT
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context)
        return EmailViewHolder(view.inflate(R.layout.item, parent,false))
    }
//CONTA E GERA OS ITENS NO LAYOUT
    override fun getItemCount(): Int = emails.size

//GERENCIA A ROLAGEM DE ACORDO COM A POSIÇÃO GERANDO OS ITENS NO LAYOUT
    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.render(emails[position])
        /* toda vez que ouver uma rolagem do usuário na lista ele irá retornar a posição na lista a posição
    atual para manipulação de item por item.*/
    }

//CLASSE INTERNA CRIADA PARA DISPOR O VIEW HOLDER COM A CONFIGURAÇÃO DE CADA ITEM DO LAYOUT
    inner class EmailViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun render(email: Email) {

            with(email){
                val hash = user.hashCode() // trata a cor de fundo do icone
                itemView.txt_icon.text = user.first().toString()
                itemView.txt_icon.background = itemView.oval(Color.rgb(hash, hash/2,hash/0))
                itemView.txt_user.text = user
                itemView.txt_subject.text = subject
                itemView.txt_preview.text = preview
                itemView.txt_date.text = date

                // manipulando emails lidos ou não lidos(lido fica negrito BOLD,não lido NORMAL)
                itemView.txt_user.setTypeface(Typeface.DEFAULT,if (unread)BOLD else NORMAL)
                itemView.txt_subject.setTypeface(Typeface.DEFAULT,if (unread)BOLD else NORMAL)
                itemView.txt_date.setTypeface(Typeface.DEFAULT,if (unread)BOLD else NORMAL)

                //mudando as propriedades da imagem favoritando
                itemView.img_star.setImageResource(
                        if (stared)R.drawable.ic_baseline_stars_24
                        else
                            R.drawable.ic_baseline_star_border_24
                            )
            }
        }

    }
// Função que retorna um objeto com todos os atributos para  colorir e tratar tamanho do icon
    fun View.oval(@ColorInt color: Int): ShapeDrawable{
        val oval = ShapeDrawable(OvalShape())
        with(oval){
            intrinsicHeight = height
            intrinsicWidth = width
            paint.color = color
        }
    return oval
    }
}