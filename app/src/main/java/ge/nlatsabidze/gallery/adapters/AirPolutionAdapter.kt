package ge.nlatsabidze.gallery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.gallery.databinding.AirPolutionItemBinding
import ge.nlatsabidze.gallery.modelPolution.AirPolutionResponse

class AirPolutionAdapter:RecyclerView.Adapter<AirPolutionAdapter.AirPolutionViewHolder>() {

    var airPolutionData: List<AirPolutionResponse> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class AirPolutionViewHolder(private val binding: AirPolutionItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: AirPolutionResponse) {
            binding.tvCarbon.text = item.components?.co.toString()
            binding.tvNitrogen.text = item.components?.no.toString()
            binding.tvDioxid.text = item.components?.no2.toString()
            binding.tvOzone.text = item.components?.o3.toString()
            binding.tvSulphur.text = item.components?.so2.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirPolutionAdapter.AirPolutionViewHolder {
        return AirPolutionViewHolder(AirPolutionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AirPolutionAdapter.AirPolutionViewHolder, position: Int) {
        val currentItem = airPolutionData[position]
        holder.onBind(currentItem)
    }

    override fun getItemCount() = airPolutionData.size
}