package tech.thdev.app.data

/**
 * Created by taehwankwon on 12/11/2017.
 */

data class PhotoInfo(
    val photo: PhotoDetail,
    val stat: String //ok
)

data class PhotoDetail(
    val id: String, //38347231961
    private val secret: String, //e4006a52b7
    private val server: String, //4525
    private val farm: Int, //5
    val dateuploaded: String, //1510453173
    val isfavorite: Int, //0
    val license: Int, //0
    val safety_level: Int, //0
    val rotation: Int, //0
    val originalsecret: String, //c3f44e5d9b
    val originalformat: String, //jpg
    val owner: Owner,
    val title: Title,
    val description: Description,
    val visibility: Visibility,
    val dates: Dates,
    val views: Int, //2
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
    fun getImageUrl() = "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
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
    fun getBuddyIcons() = "http://farm$iconfarm.staticflickr.com/$iconserver/buddyicons/$nsid.jpg"
}

data class Editability(
    val cancomment: Int, //1
    val canaddmeta: Int //0
)

data class Urls(
    val url: List<Url>
)

data class Url(
    val type: String, //photopage
    val _content: String //https://www.flickr.com/photos/138147998@N05/38347231961/
)

data class Visibility(
    val ispublic: Int, //1
    val isfriend: Int, //0
    val isfamily: Int //0
)

data class Notes(
    val note: List<Any>
)

data class People(
    val haspeople: Int //0
)

data class Tags(
    val tag: List<Tag>
)

data class Tag(
    val id: String, //138142658-38347231961-604
    val author: String, //138147998@N05
    val authorname: String, //illustrationvintage
    val raw: String, //tower
    val _content: String, //tower
    val machine_tag: Int //0
)

data class Description(
    val _content: String //Eiffel tower in spring
)

data class Dates(
    val posted: String, //1510453173
    val taken: String, //2012-04-07 00:00:37
    val takengranularity: Int, //0
    val takenunknown: Int, //1
    val lastupdate: String //1510453262
)

data class Publiceditability(
    val cancomment: Int, //1
    val canaddmeta: Int //0
)

data class Title(
    val _content: String //Eiffel tower in spring
)

data class Usage(
    val candownload: Int, //1
    val canblog: Int, //1
    val canprint: Int, //0
    val canshare: Int //1
)