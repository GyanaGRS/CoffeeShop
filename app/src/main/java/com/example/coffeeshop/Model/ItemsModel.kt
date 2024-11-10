package com.example.coffeeshop.Model

import android.os.Parcel
import android.os.Parcelable

class ItemsModel(
    var title: String? = null,
    var description: String? = null,
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var extra: String? = null,
    var categoryId: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        title = parcel.readString(),
        description = parcel.readString(),
        picUrl = parcel.createStringArrayList() ?: ArrayList(),
        price = parcel.readDouble(),
        extra = parcel.readString(),
        categoryId = parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeStringList(picUrl)
        parcel.writeDouble(price)
        parcel.writeString(extra)
        parcel.writeString(categoryId)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(parcel: Parcel): ItemsModel = ItemsModel(parcel)
        override fun newArray(size: Int): Array<ItemsModel?> = arrayOfNulls(size)
    }
}
