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
    var likes: Like

) {
    class Like(
        val count: Int = 0,
        val user_likes: Boolean = false,
        val can_like: Boolean = true,
        val can_publish: Boolean = false
    ) {
    }

}

object WallService {
    private var posts = emptyArray<Post>()
    var postId: Int = 0


    fun clear() {
        posts = emptyArray()
        postId = 0
    }

    fun add(post: Post): Post {
        posts += post
        postId++
        post.id = postId
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id)
                posts[index] = newPost
            return true
        }
        return false
    }
}


