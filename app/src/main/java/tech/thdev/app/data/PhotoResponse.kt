package tech.thdev.app.data

/**
 * Created by record-tae on 11/5/17.
 */

data class PhotoResponse(
        val photos: Photos,
        val stat: String, //ok
        val code: Int,
        val message: String?
)

data class Photos(
        val page: Int, //1
        val pages: Int, //10
        val perpage: Int, //100
        val total: String, //1000
        val photo: List<Photo>
)

data class Photo(
        val id: String, //24457892888
        val owner: String, //146542030@N02
        val secret: String, //bb01366e98
        val server: String, //4521
        val farm: Int, //5
        val title: String, //МБОУ "Шыгырданская СОШ имени профессора Э.З.Феизова", Село Шыгырдан
        val ispublic: Int, //1
        val isfriend: Int, //0
        val isfamily: Int //0
) {
    fun getImageUrl()
            = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}