package tech.thdev.app.data

/**
 * Created by taehwankwon on 12/11/2017.
 */

data class PhotoInfo(
		val photo: PhotoDetail,
		val stat: String //ok
)

data class PhotoDetail(
		val id: String, //37632503954
		val secret: String, //115683d03c
		val server: String, //4579
		val farm: Int, //5
		val dateuploaded: String, //1510449829
		val isfavorite: Int, //0
		val license: Int, //0
		val safety_level: Int, //0
		val rotation: Int, //0
		val originalsecret: String, //a2f42a48f2
		val originalformat: String, //jpg
		val owner: Owner,
		val title: Title,
		val description: Description,
		val visibility: Visibility,
		val dates: Dates,
		val views: Int, //0
		val editability: Editability,
		val publiceditability: Publiceditability,
		val usage: Usage,
		val comments: Comments,
		val notes: Notes,
		val people: People,
		val tags: Tags,
		val urls: Urls,
		val media: String //photo
) {
    fun getImageUrl()
            = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
}

data class Comments(
		val _content: Int //0
)

data class Owner(
		val nsid: String, //138147998@N05
		val username: String, //illustrationvintage
		val realname: String, //illustration vintage
		val location: String,
		val iconserver: String, //4551
		val iconfarm: Int, //5
		val path_alias: String
) {
    /**
     * Buddyicons API : <a href="https://www.flickr.com/services/api/misc.buddyicons.html">api</a>
     * http://farm{icon-farm}.staticflickr.com/{icon-server}/buddyicons/{nsid}.jpg
     */
    fun getBuddyIcons()
            = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}

data class Visibility(
		val ispublic: Int, //1
		val isfriend: Int, //0
		val isfamily: Int //0
)

data class Description(
		val _content: String //12781890 - the the interior of an apartment
)

data class Title(
		val _content: String //12781890_xxl
)

data class Notes(
		val note: List<Any>
)

data class People(
		val haspeople: Int //0
)

data class Usage(
		val candownload: Int, //1
		val canblog: Int, //0
		val canprint: Int, //0
		val canshare: Int //1
)

data class Dates(
		val posted: String, //1510449829
		val taken: String, //2017-11-11 17:23:49
		val takengranularity: Int, //0
		val takenunknown: Int, //1
		val lastupdate: String //1510450112
)

data class Editability(
		val cancomment: Int, //0
		val canaddmeta: Int //0
)

data class Publiceditability(
		val cancomment: Int, //1
		val canaddmeta: Int //0
)

data class Urls(
		val url: List<Url>
)

data class Url(
		val type: String, //photopage
		val _content: String //https://www.flickr.com/photos/138147998@N05/37632503954/
)

data class Tags(
		val tag: List<Tag>
)

data class Tag(
		val id: String, //138142658-37632503954-607
		val author: String, //138147998@N05
		val authorname: String, //illustrationvintage
		val raw: String, //art
		val _content: String, //art
		val machine_tag: String
)