package com.example.coffeeshop.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeeshop.Model.ItemsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    fun loadfiltered(id:Int):LiveData<MutableList<ItemsModel>> {
        val Listdata= MutableLiveData<MutableList<ItemsModel>>()
        val ref= firebaseDatabase.getReference("Items")
        val query:Query= ref.orderByChild("categoryId").equalTo(id.toString())

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<ItemsModel>()
                for (childSnapshot in snapshot.children) {
                    val item= childSnapshot.getValue(ItemsModel::class.java)
                    item?.let { lists.add(it) }
                }
                Listdata.value= lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return Listdata
    }
}