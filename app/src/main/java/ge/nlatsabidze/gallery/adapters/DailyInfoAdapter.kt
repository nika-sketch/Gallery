package ge.nlatsabidze.gallery.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.gallery.daily.Daily
import ge.nlatsabidze.gallery.databinding.DailyItemBinding

class DailyInfoAdapter: RecyclerView.Adapter<DailyInfoAdapter.DailyInfoViewHolder>() {

    var temperature: List<Daily> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class DailyInfoViewHolder (private val binding: DailyItemBinding): RecyclerView.ViewHolder(binding.root) {
        private lateinit var currentData: Daily

        @SuppressLint("SetTextI18n")
        fun onBind() {
            currentData = temperature[absoluteAdapterPosition]
            binding.tvDay.text = currentData.temp?.day.toString() + "°" // 08
            binding.tvMax.text = currentData.temp?.max.toString() + "°" // 09
            binding.tvMin.text = currentData.temp?.min.toString() + "°" // 10
            binding.tvNight.text = currentData.temp?.night.toString() + "°" // 11
            binding.tvEve.text = currentData.temp?.eve.toString() + "°" // 12
            binding.tvMorn.text = currentData.temp?.morn.toString() + "°" // 13
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyInfoAdapter.DailyInfoViewHolder {
        return DailyInfoViewHolder(DailyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DailyInfoAdapter.DailyInfoViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = temperature.size

}