package am.example.task1

import am.example.task1.databinding.RecyclerRowBinding
import am.example.task1.model.Data
import am.example.task1.model.UserData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(
    val userData: MutableList<Data>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    inner class UserViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = userData[position]
            binding.run {
                with(item) {
                    fullName.text = calcName()
                    mail.text = email
                    userId.text = id.toString()
                    Glide.with(root)
                        .load(avatar)
                        .error(R.drawable.ic_baseline_error_24)
                        .into(this@run.avatar)
                }
            }
        }

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    fun update(updatedData: MutableList<Data>) {
        userData.clear()
        userData.addAll(updatedData)
        notifyDataSetChanged()
    }

}