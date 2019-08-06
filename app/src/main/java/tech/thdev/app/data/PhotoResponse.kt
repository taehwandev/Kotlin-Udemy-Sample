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
		val pages: String, //2347
		val perpage: Int, //100
		val total: String, //234661
		val photo: List<Photo>
)

data class Photo(
		val id: String, //38294557366
		val owner: String, //139066376@N03
		private val secret: String, //a477b5bd73
		private val server: String, //4568
		private val farm: Int, //5
		val title: String, //Men's Clothes
		val ispublic: Int, //1
		val isfriend: Int, //0
		val isfamily: Int //0
) {
	fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}