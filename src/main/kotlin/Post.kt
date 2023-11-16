data class Post(
    var id: Int = 0,
    val ownerId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    var text: String,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    var likes: Like = Like()

) {
    data class Like(
        val count: Int = 0,
        val user_likes: Boolean = false,
        val can_like: Boolean = true,
        val can_publish: Boolean = false
    ) {
    }

}

object WallService {
     var posts = emptyArray<Post>()
    var postId: Int = 0


    fun clear() {
        posts = emptyArray()
        postId = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++postId, likes = post.likes.copy())
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
            println(posts[index])
            return true}
        }
        return false
    }
}


