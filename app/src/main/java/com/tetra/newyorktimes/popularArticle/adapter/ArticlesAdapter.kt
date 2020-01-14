package com.tetra.newyorktimes.popularArticle.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.tetra.newyorktimes.R
import com.tetra.newyorktimes.popularArticle.viewModel.helper.Result
import kotlinx.android.synthetic.main.article_item.view.*
import java.util.*

/*
 * Recycler view adapter to show article items
*/
class ArticlesAdapter(
    callback: Callback,
    context: Context,
    private val results: ArrayList<Result>
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {
    private var callback: Callback? = null
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    val mRandom = Random(System.currentTimeMillis())

    init {
        this.callback = callback
    }

    /*
    * Create n number of views using view type
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(layoutInflater.inflate(R.layout.article_item, parent, false))
    }

    /*
    * Returns Items size
    */
    override fun getItemCount(): Int {
        return results.size
    }

    /*
    * Handle the data to set the view
    */
    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.title.text = result.title
        holder.subTitle.text = result.abstract
        holder.description.text = result.byline
        holder.publishedDate.text = "  " + result.published_date

        val drawable = TextDrawable.builder()
            .beginConfig()
            .width(255)
            .height(255)
            .endConfig()
            .buildRound(result.title!!.substring(0, 2).toUpperCase(), generateRandomColor())
        holder.highlight.setImageDrawable(drawable)

        holder.rootContainer.setOnClickListener {
            result.url?.let {
                callback?.itemClicked(it)
            }
        }
    }

    /*
    * Callbacks to the view
    */
    interface Callback {
        fun itemClicked(url: String)
    }

    /*
    * View holder to get the instance of the UI element
    */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title
        val subTitle: TextView = itemView.subTitle
        val description: TextView = itemView.description
        val publishedDate: TextView = itemView.publishedDate
        val highlight: ImageView = itemView.highlight
        val rootContainer: RelativeLayout = itemView.rootContainer

    }

    /*
    *This is the base color which will be mixed with the generated one
    */
    private fun generateRandomColor(): Int {
        val baseColor: Int = Color.WHITE
        val baseRed: Int = Color.red(baseColor)
        val baseGreen: Int = Color.green(baseColor)
        val baseBlue: Int = Color.blue(baseColor)
        val red = (baseRed + mRandom.nextInt(155) + 100)
        val green = (baseGreen + mRandom.nextInt(155) + 8)
        val blue = (baseBlue + (mRandom.nextInt(155) + 1))

        return Color.rgb(red, green, blue)
    }
}
