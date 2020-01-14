package com.tetra.newyorktimes.popularArticle.viewModel.helper

import android.os.Parcel
import android.os.Parcelable

data class PopularArticleJson(
    var status: String? = "",
    var copyright: String? = "",
    var num_results: Int? = 0,
    var results: ArrayList<Result>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createTypedArrayList(Result)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeString(copyright)
        parcel.writeValue(num_results)
        parcel.writeTypedList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PopularArticleJson> {
        override fun createFromParcel(parcel: Parcel): PopularArticleJson {
            return PopularArticleJson(parcel)
        }

        override fun newArray(size: Int): Array<PopularArticleJson?> {
            return arrayOfNulls(size)
        }
    }
}

data class Result(
    var url: String? = "",
    var adx_keywords: String? = "",
    var section: String? = "",
    var byline: String? = "",
    var type: String? = "",
    var title: String? = "",
    var abstract: String? = "",
    var published_date: String? = "",
    var source: String? = "",
    var id: Long? = 0,
    var asset_id: Long? = 0,
    var views: Int? = 0,
    /*var des_facet: ArrayList<String?>? = null,
    var org_facet: ArrayList<String?>? = null,
    var per_facet: ArrayList<String?>? = null,
    var geo_facet: ArrayList<String?>? = null,*/
    var media: List<Media?>? = listOf(),
    var uri: String? = "",
    var column: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        /*parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),*/
        parcel.createTypedArrayList(Media),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(adx_keywords)
        parcel.writeString(section)
        parcel.writeString(byline)
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeString(abstract)
        parcel.writeString(published_date)
        parcel.writeString(source)
        parcel.writeValue(id)
        parcel.writeValue(asset_id)
        parcel.writeValue(views)
        /*parcel.writeStringList(des_facet)
        parcel.writeStringList(org_facet)
        parcel.writeStringList(per_facet)
        parcel.writeStringList(geo_facet)*/
        parcel.writeTypedList(media)
        parcel.writeString(uri)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}

data class Media(
    var type: String? = "",
    var subtype: String? = "",
    var caption: String? = "",
    var copyright: String? = "",
    var approved_for_syndication: Int? = 0,
    var media_metadata: ArrayList<MediaMetadata>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createTypedArrayList(MediaMetadata)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(subtype)
        parcel.writeString(caption)
        parcel.writeString(copyright)
        parcel.writeValue(approved_for_syndication)
        parcel.writeTypedList(media_metadata)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}

data class MediaMetadata(
    var url: String? = "",
    var format: String? = "",
    var height: Int? = 0,
    var width: Int? = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(format)
        parcel.writeValue(height)
        parcel.writeValue(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MediaMetadata> {
        override fun createFromParcel(parcel: Parcel): MediaMetadata {
            return MediaMetadata(parcel)
        }

        override fun newArray(size: Int): Array<MediaMetadata?> {
            return arrayOfNulls(size)
        }
    }
}
