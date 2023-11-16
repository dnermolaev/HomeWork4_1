import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        WallService.add(Post(text = "post", likes = Post.Like()))
        val result = WallService.postId
        assertTrue(result>0)
    }

    @Test
    fun updateTrue() {
        WallService.add(Post(text = "post1", likes = Post.Like()))
        WallService.add(Post(text = "post2", likes = Post.Like()))

        val update = Post(id = 1, text = "post1_updated", likes = Post.Like())
        val result = WallService.update(update)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        WallService.add(Post(text = "post1", likes = Post.Like()))
        WallService.add(Post(text = "post2", likes = Post.Like()))

        val update = Post(id = 0, text = "postupdated", likes = Post.Like())
        val result = WallService.update(update)
        assertFalse(result)
    }
}